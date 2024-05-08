package com.wangmai.ad.dex.allmodules.receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import appa.appa.appf.appd;
import com.wangmai.common.utils.SharedPreferencesHelper;
import com.wangmai.okhttp.OkHttp;
import com.wangmai.okhttp.callback.StringCallback;
import com.wangmai.okhttp.model.Response;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class ApkWMReceiver extends BroadcastReceiver {

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    class appa extends StringCallback {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ SharedPreferencesHelper f46819appa;

        appa(ApkWMReceiver apkWMReceiver, SharedPreferencesHelper sharedPreferencesHelper) {
            this.f46819appa = sharedPreferencesHelper;
        }

        @Override // com.wangmai.okhttp.callback.Callback
        public void onSuccess(Response<String> response) {
            this.f46819appa.savePreferencesString("brand_name", "");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        appd.appa("AppWMReceiver", intent.getAction());
        try {
            if (TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_ADDED")) {
                String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                SharedPreferencesHelper sharedPreferencesHelper = SharedPreferencesHelper.getInstance(context);
                String preferencesString = sharedPreferencesHelper.getPreferencesString("brand_name");
                if (TextUtils.isEmpty(preferencesString)) {
                    return;
                }
                String preferencesString2 = sharedPreferencesHelper.getPreferencesString("clickid");
                int preferencesInteger = sharedPreferencesHelper.getPreferencesInteger("installed_track_urls_size", 0);
                ArrayList arrayList = new ArrayList();
                for (int i10 = 0; i10 < preferencesInteger; i10++) {
                    String preferencesString3 = sharedPreferencesHelper.getPreferencesString("installed_track_urls" + i10);
                    if (preferencesString3 != null) {
                        preferencesString3 = preferencesString3.replaceAll("(?i)__CLICKID__", preferencesString2);
                    }
                    arrayList.add(preferencesString3);
                }
                if (preferencesString == null || arrayList.size() <= 0 || !preferencesString.equals(schemeSpecificPart)) {
                    return;
                }
                for (int i11 = 0; i11 < arrayList.size(); i11++) {
                    OkHttp.get((String) arrayList.get(i11)).execute(new appa(this, sharedPreferencesHelper));
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
