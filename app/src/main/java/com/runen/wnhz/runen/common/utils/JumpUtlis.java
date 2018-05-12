package com.runen.wnhz.runen.common.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Administrator on 2018-04-25.
 * activity 跳转工具类
 */

public class JumpUtlis {

    //懒汉模式
    private static JumpUtlis instance;
    private JumpUtlis(){}

    public static JumpUtlis getInstance(){
        if (instance == null) {
            synchronized (JumpUtlis.class){
                instance = new JumpUtlis();
            }
        }
        return instance;
    }
    /* 无参正常跳转*/
    public void jumpActivity(Context context,Class mClass){
        context.startActivity(new Intent(context,mClass));
    }

    /* 带一个参跳转*/
    public void jumpActivity(Context context,Class mClass,Object Objects){
        Intent intent = new Intent(context,mClass);
        if (Objects instanceof String){
            intent.putExtra("Objects",(String) Objects);
        } else if (Objects instanceof Integer){
            intent.putExtra("Objects",(Integer) Objects);
        } else if (Objects instanceof Double){
            intent.putExtra("Objects",(Double) Objects);
        } else if (Objects instanceof Long){
            intent.putExtra("Objects",(Long) Objects);
        }
        
        context.startActivity(intent);
    }
    
    /* 带bund 传值*/
    public void jumpActivity(Context context, Class mClass, Bundle bundle){
        Intent intent = new Intent(context,mClass);
        intent.putExtra("Bundle",bundle);
        context.startActivity(intent);
    }
    

}
