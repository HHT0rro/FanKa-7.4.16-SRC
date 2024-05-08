package com.tanx.exposer.framework.connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rc.b;
import rc.e;

/* compiled from: NetworkStateObserver.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class tanxc_do {

    /* renamed from: c, reason: collision with root package name */
    public ConnectivityManager f38983c;

    /* renamed from: g, reason: collision with root package name */
    public ConnectivityManager.NetworkCallback f38987g;

    /* renamed from: d, reason: collision with root package name */
    public int f38984d = -1;

    /* renamed from: e, reason: collision with root package name */
    public int f38985e = -1;

    /* renamed from: f, reason: collision with root package name */
    public final BroadcastReceiver f38986f = new BroadcastReceiver() { // from class: com.tanx.exposer.framework.connectivity.NetworkStateObserver$tanxc_do
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (b.f53376a) {
                b.a("NetworkStateObserver", "onReceive: action = " + action);
            }
            if (TextUtils.equals(action, "android.net.conn.CONNECTIVITY_CHANGE")) {
                tanxc_do.this.c();
                tanxc_do tanxc_doVar = tanxc_do.this;
                if (tanxc_doVar.f38984d != tanxc_doVar.f38985e) {
                    tanxc_do.b(tanxc_doVar);
                    tanxc_do tanxc_doVar2 = tanxc_do.this;
                    tanxc_doVar2.f38984d = tanxc_doVar2.f38985e;
                }
            }
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public Context f38981a = e.a.f53381a.g();

    /* renamed from: b, reason: collision with root package name */
    public List<a> f38982b = new LinkedList();

    /* compiled from: NetworkStateObserver.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void a(int i10);
    }

    /* compiled from: NetworkStateObserver.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class b extends ConnectivityManager.NetworkCallback {
        public b() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
            if (networkCapabilities.hasCapability(16)) {
                if (networkCapabilities.hasTransport(1)) {
                    tanxc_do.this.f38985e = 1;
                } else if (networkCapabilities.hasTransport(0)) {
                    tanxc_do.this.c();
                } else if (networkCapabilities.hasTransport(3)) {
                    tanxc_do.this.f38985e = 9;
                }
            }
            if (rc.b.f53376a) {
                rc.b.a("NetworkStateObserver", "onCapabilitiesChanged: cap = " + ((Object) networkCapabilities) + ", network = " + ((Object) network) + ", currentType = " + tanxc_do.this.f38985e + ", prevType = " + tanxc_do.this.f38984d);
            }
            tanxc_do tanxc_doVar = tanxc_do.this;
            if (tanxc_doVar.f38984d != tanxc_doVar.f38985e) {
                tanxc_do.b(tanxc_doVar);
                tanxc_do tanxc_doVar2 = tanxc_do.this;
                tanxc_doVar2.f38984d = tanxc_doVar2.f38985e;
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
            if (rc.b.f53376a) {
                rc.b.a("NetworkStateObserver", "onLost: currentType = " + tanxc_do.this.f38985e + ", prev = " + tanxc_do.this.f38984d + ", network = " + ((Object) network));
            }
            tanxc_do.this.c();
            tanxc_do tanxc_doVar = tanxc_do.this;
            if (tanxc_doVar.f38984d != tanxc_doVar.f38985e) {
                tanxc_do.b(tanxc_doVar);
                tanxc_do tanxc_doVar2 = tanxc_do.this;
                tanxc_doVar2.f38984d = tanxc_doVar2.f38985e;
            }
        }
    }

    /* compiled from: NetworkStateObserver.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public static final tanxc_do f38989a = new tanxc_do();
    }

    public tanxc_do() {
        try {
            this.f38983c = (ConnectivityManager) this.f38981a.getSystemService("connectivity");
        } catch (Exception e2) {
            rc.b.b("NetworkStateObserver", "get ConnectivityManager exception", e2);
        }
        a();
        c();
    }

    public static void b(tanxc_do tanxc_doVar) {
        synchronized (tanxc_doVar) {
            if (rc.b.f53376a) {
                rc.b.a("NetworkStateObserver", "notifyNetworkStateChanged: mPrevNetworkType = " + tanxc_doVar.f38984d + ", mCurrentNetworkType = " + tanxc_doVar.f38985e);
            }
            Iterator<a> iterator2 = tanxc_doVar.f38982b.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().a(tanxc_doVar.f38985e);
            }
        }
    }

    public final void a() {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                NetworkRequest build = new NetworkRequest.Builder().build();
                if (this.f38987g == null) {
                    this.f38987g = new b();
                }
                this.f38983c.registerNetworkCallback(build, this.f38987g);
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.f38981a.registerReceiver(this.f38986f, intentFilter);
        } catch (Throwable th) {
            rc.b.b("NetworkStateObserver", "registerNetworkState exception.", th);
        }
    }

    public final void c() {
        NetworkInfo networkInfo;
        try {
            networkInfo = this.f38983c.getActiveNetworkInfo();
        } catch (Exception e2) {
            rc.b.b("NetworkStateObserver", "getActiveNetworkType exception.", e2);
            networkInfo = null;
        }
        if (networkInfo == null) {
            this.f38985e = -1;
            if (rc.b.f53376a) {
                rc.b.a("NetworkStateObserver", "getActiveNetworkType with null network info.");
                return;
            }
            return;
        }
        if (networkInfo.getType() == 1 && networkInfo.isConnected()) {
            this.f38985e = 1;
        } else if (networkInfo.getType() == 0 && networkInfo.isConnected()) {
            this.f38985e = 0;
        } else if (networkInfo.getType() == 9 && networkInfo.isConnected()) {
            this.f38985e = 9;
        } else {
            this.f38985e = -1;
        }
        if (rc.b.f53376a) {
            rc.b.a("NetworkStateObserver", "getActiveNetworkType: mPrevNetworkType = " + this.f38984d + ", mCurrentNetworkType = " + this.f38985e + ", networkInfo = " + ((Object) networkInfo));
        }
    }
}
