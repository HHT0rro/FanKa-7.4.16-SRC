package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.push.service.XMPushService;
import fc.c;
import kc.r;
import kc.u;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class PkgDataClearedReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.PACKAGE_DATA_CLEARED".equals(intent.getAction()) || intent.getData() == null) {
            return;
        }
        String encodedSchemeSpecificPart = intent.getData().getEncodedSchemeSpecificPart();
        if (TextUtils.isEmpty(encodedSchemeSpecificPart)) {
            return;
        }
        try {
            Intent intent2 = new Intent(context, (Class<?>) XMPushService.class);
            intent2.setAction(r.f50851b);
            intent2.putExtra("data_cleared_pkg_name", encodedSchemeSpecificPart);
            u.e(context).h(intent2);
        } catch (Exception e2) {
            c.n("data cleared broadcast error: " + ((Object) e2));
        }
    }
}
