package com.runen.wnhz.runen.common.http;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.runen.wnhz.runen.BuildConfig;
import com.runen.wnhz.runen.common.utils.Constants;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * 全部接口公共参数  post  token      登录用户信息
   get   versions   版本号(100001)
   get   requestfor 请求类型(1安卓 2苹果 3其它)
 */

public class CommonParamsInterceptor implements Interceptor {

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    
    private Gson mGson;
    private Context mContext;

    public CommonParamsInterceptor(Context context,Gson gson){

        this.mContext = context;
        this.mGson = gson;

    }
    
    @Override
    public Response intercept(Chain chain) throws IOException {


        Request request = chain.request();


      try {
            
          String method = request.method();
          HashMap<String,Object> commomParamsMap = new HashMap<>();

            //保存在sp 中，不可能为没有的话就为null
            commomParamsMap.put(Constants.TOKEN, "");
            commomParamsMap.put(Constants.VERSIONS, BuildConfig.VERSION_NAME);
            commomParamsMap.put(Constants.REQUESTFOR,1);


            if(method.equals("GET")){



               HttpUrl httpUrl =  request.url();

               String oldParamJson =  httpUrl.queryParameter(Constants.PARAM);


                HashMap<String,Object> rootMap = mGson.fromJson(oldParamJson,HashMap.class); // 原始参数



                rootMap.put("publicParams",commomParamsMap); // 重新组装


                String newJsonParams = mGson.toJson(rootMap); // {"page":0,"publicParams":{"imei":'xxxxx',"sdk":14,.....}}



                String url = httpUrl.toString();

                url = url.substring(0,url.indexOf("?"))+"?"+Constants.PARAM+"="+newJsonParams; //  http://112.124.22.238:8081/course_api/cniaoplay/featured?p= {"page":0,"publicParams":{"imei":'xxxxx',"sdk":14,.....}}



                request = request.newBuilder().url(url).build();





            }
            else  if(method.equals("POST")){


                RequestBody body = request.body();


                HashMap<String,Object> rootMap = new HashMap<>();
                if(body instanceof FormBody){ // form 表单

                    for (int i=0;i<((FormBody) body).size();i++){

                        rootMap.put(((FormBody) body).encodedName(i),((FormBody) body).encodedValue(i));
                    }

                }
                else{

                    Buffer buffer = new Buffer();

                    body.writeTo(buffer);

                   String oldJsonParams =  buffer.readUtf8();

                   rootMap = mGson.fromJson(oldJsonParams,HashMap.class); // 原始参数
                    rootMap.put("publicParams",commomParamsMap); // 重新组装
                    String newJsonParams = mGson.toJson(rootMap); // {"page":0,"publicParams":{"imei":'xxxxx',"sdk":14,.....}}


                    request = request.newBuilder().post(RequestBody.create(JSON, newJsonParams)).build();


                }

            }
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return chain.proceed(request);
    }
}
