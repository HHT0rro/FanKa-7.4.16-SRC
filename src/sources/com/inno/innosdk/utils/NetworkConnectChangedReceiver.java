package com.inno.innosdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class NetworkConnectChangedReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static NetworkConnectChangedReceiver f35555a;

    /* renamed from: b, reason: collision with root package name */
    public static Context f35556b;

    public static void a(Context context) {
        try {
            a();
            f35556b = context;
            f35555a = new NetworkConnectChangedReceiver();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.registerReceiver(f35555a, intentFilter);
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        NetworkInfo networkInfo;
        try {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && (networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo")) != null && NetworkInfo.State.CONNECTED == networkInfo.getState() && networkInfo.isAvailable()) {
                if (networkInfo.getType() == 1 || networkInfo.getType() == 0) {
                    a.a();
                }
            }
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }

    public static void a() {
        NetworkConnectChangedReceiver networkConnectChangedReceiver;
        try {
            Context context = f35556b;
            if (context == null || (networkConnectChangedReceiver = f35555a) == null) {
                return;
            }
            context.unregisterReceiver(networkConnectChangedReceiver);
            f35555a = null;
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }
}
