package com.runen.wnhz.runen.wxapi;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class WXPayEntryActivity extends AppCompatActivity implements IWXAPIEventHandler {
	private IWXAPI api;
	private int id;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		api = WXAPIFactory.createWXAPI(this, null);
		api.handleIntent(getIntent(), this);

	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		setIntent(intent);
		api.handleIntent(intent, this);
	}

	@Override
	public void onReq(BaseReq baseReq) {

	}

	@Override
	public void onResp(BaseResp baseResp) {
		switch (baseResp.errCode) {
			case 0:
			/*	service.getOrderDetailsInfo(id)
						.observeOn(AndroidSchedulers.mainThread())
						.subscribe(new Action1<BaseEntity<OrderDetailsCellInfo>>() {
					@Override
					public void call(BaseEntity<OrderDetailsCellInfo> orderDetailsCellInfoBaseEntity) {
						switch (orderDetailsCellInfoBaseEntity.getCode()){
							case 200:
								Toast.makeText(WXPayEntryActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
								finish();
								break;
							case 400:
								Toast.makeText(WXPayEntryActivity.this, "支付失败", Toast.LENGTH_SHORT).show();
								finish();
								break;
							case 500:
								Toast.makeText(WXPayEntryActivity.this, "未知错误", Toast.LENGTH_SHORT).show();
								finish();
								break;
						}

					}
				});*/

				break;
			case -2:
				Toast.makeText(WXPayEntryActivity.this, "支付取消", Toast.LENGTH_SHORT).show();
				finish();
				break;
			default:
				Toast.makeText(WXPayEntryActivity.this, "支付错误", Toast.LENGTH_SHORT).show();
				finish();
				break;
		}
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}
}

