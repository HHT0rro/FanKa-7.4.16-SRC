package com.huawei.appgallery.marketinstallerservice.impl.download;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.appgallery.marketinstallerservice.api.FailResultParam;
import com.huawei.appgallery.marketinstallerservice.api.InstallCallback;
import com.huawei.appgallery.marketinstallerservice.api.MarketInfo;
import com.huawei.secure.android.common.intent.SafeBroadcastReceiver;
import y9.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class MarketInstallReceiver extends SafeBroadcastReceiver {
    @Override // com.huawei.secure.android.common.intent.SafeBroadcastReceiver
    public void a(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("callback_key");
        InstallCallback a10 = a.a(stringExtra);
        MarketInfo d10 = a.d(stringExtra);
        if (a10 == null) {
            fa.a.d("MarketInstallReceiver", "market install callback is null!");
            return;
        }
        int i10 = extras.getInt("android.content.pm.extra.STATUS");
        if (i10 == 0) {
            a10.onSuccess(d10);
        } else {
            FailResultParam failResultParam = new FailResultParam();
            failResultParam.setResult(-2);
            failResultParam.setReason(i10);
            failResultParam.setMarketInfo(d10);
            a10.onFailed(failResultParam);
        }
        a.f(stringExtra);
        a.e(stringExtra);
    }
}
