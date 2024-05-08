package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.xiaomi.push.service.XMPushService;
import fc.c;
import kc.r;
import kc.u;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class PkgUninstallReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.PACKAGE_REMOVED".equals(intent.getAction())) {
            return;
        }
        boolean z10 = intent.getExtras().getBoolean("android.intent.extra.REPLACING");
        Uri data = intent.getData();
        if (data == null || z10) {
            return;
        }
        try {
            Intent intent2 = new Intent(context, (Class<?>) XMPushService.class);
            intent2.setAction(r.f50850a);
            intent2.putExtra("uninstall_pkg_name", data.getEncodedSchemeSpecificPart());
            u.e(context).h(intent2);
        } catch (Exception e2) {
            c.k(e2);
        }
    }
}
