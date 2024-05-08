package cn.shuzilm.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
class u extends BroadcastReceiver {
    private u() {
    }

    public /* synthetic */ u(k kVar) {
        this();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            if (intent.getAction() == null) {
                return;
            }
            DUHelper.a(context, intent);
        } catch (Exception unused) {
        }
    }
}
