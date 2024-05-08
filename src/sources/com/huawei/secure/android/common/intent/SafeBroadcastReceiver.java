package com.huawei.secure.android.common.intent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import wa.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class SafeBroadcastReceiver extends BroadcastReceiver {
    public abstract void a(Context context, Intent intent);

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (a.a(intent)) {
            return;
        }
        a(context, new SafeIntent(intent));
    }
}
