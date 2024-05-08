package com.danlan.android.cognition.collector.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.collector.util.NetUtil;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class NetBroadcastReceiver extends BroadcastReceiver {
    public NetEvent event;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface NetEvent {
        void onNetChange(int i10);
    }

    public NetBroadcastReceiver(NetEvent netEvent) {
        this.event = netEvent;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(StringFog.decrypt("QE1AUU5KQA9PRlANQkxKTw9ga21vZmd1aHVtd3h8Z2lgbWNm"))) {
            this.event.onNetChange(NetUtil.getNetWorkState(context));
        }
    }
}
