package com.huawei.qcardsupport.qcard.cardmanager.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.huawei.flexiblelayout.log.Log;

/* compiled from: NetworkConnectedListener.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class f {

    /* renamed from: d, reason: collision with root package name */
    private static final String f33225d = "NetworkConnectedListener";

    /* renamed from: a, reason: collision with root package name */
    private final Context f33226a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f33227b = true;

    /* renamed from: c, reason: collision with root package name */
    private BroadcastReceiver f33228c;

    /* compiled from: NetworkConnectedListener.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            f.this.a(context, intent);
        }
    }

    public f(Context context) {
        this.f33226a = context;
    }

    public abstract void a();

    public void b() {
        if (this.f33228c != null) {
            return;
        }
        this.f33228c = new a();
        this.f33227b = true;
        this.f33226a.registerReceiver(this.f33228c, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void c() {
        BroadcastReceiver broadcastReceiver = this.f33228c;
        if (broadcastReceiver != null) {
            try {
                this.f33226a.unregisterReceiver(broadcastReceiver);
            } catch (Exception e2) {
                Log.w(f33225d, "unregisterReceiver error: " + e2.getMessage());
            }
            this.f33228c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent != null ? intent.getAction() : null)) {
            if (this.f33227b) {
                this.f33227b = false;
                return;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return;
            }
            a();
        }
    }
}
