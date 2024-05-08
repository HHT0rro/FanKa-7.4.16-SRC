package com.xiaomi.push;

import android.content.Context;
import android.content.IntentFilter;
import com.xiaomi.push.mpcd.receivers.BroadcastActionsReceiver;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class n2 {
    public static IntentFilter a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_CHANGED");
        intentFilter.addAction("android.intent.action.PACKAGE_DATA_CLEARED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addAction("android.intent.action.PACKAGE_RESTARTED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        return intentFilter;
    }

    public static s2 b() {
        return new o2();
    }

    public static void c(Context context) {
        u2.b(context).c();
        try {
            context.registerReceiver(new BroadcastActionsReceiver(b()), a());
        } catch (Throwable th) {
            fc.c.k(th);
        }
    }
}
