package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.push.j4;
import com.xiaomi.push.service.XMPushService;
import fc.c;
import kc.n;
import kc.u;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class PingReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        c.m(intent.getPackage() + " is the package name");
        if (!n.f50831m.equals(intent.getAction())) {
            c.i("cancel the old ping timer");
            j4.a();
        } else if (TextUtils.equals(context.getPackageName(), intent.getPackage())) {
            c.m("Ping XMChannelService on timer");
            try {
                Intent intent2 = new Intent(context, (Class<?>) XMPushService.class);
                intent2.putExtra("time_stamp", System.currentTimeMillis());
                intent2.setAction("com.xiaomi.push.timer");
                u.e(context).h(intent2);
            } catch (Exception e2) {
                c.k(e2);
            }
        }
    }
}
