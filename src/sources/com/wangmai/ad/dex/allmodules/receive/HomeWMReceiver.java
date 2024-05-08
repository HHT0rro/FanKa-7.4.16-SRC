package com.wangmai.ad.dex.allmodules.receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import appa.appa.appf.appd;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class HomeWMReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        appd.appa("HomeWMReceiver", intent.getAction());
    }
}
