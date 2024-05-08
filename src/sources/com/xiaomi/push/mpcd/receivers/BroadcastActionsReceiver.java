package com.xiaomi.push.mpcd.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.push.s2;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class BroadcastActionsReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public s2 f47976a;

    public BroadcastActionsReceiver(s2 s2Var) {
        this.f47976a = s2Var;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        s2 s2Var = this.f47976a;
        if (s2Var != null) {
            s2Var.a(context, intent);
        }
    }
}
