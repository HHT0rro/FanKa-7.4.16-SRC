package com.mobile.auth.n;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private static r f37531a;

    /* renamed from: b, reason: collision with root package name */
    private ConnectivityManager f37532b;

    /* renamed from: c, reason: collision with root package name */
    private Network f37533c;

    /* renamed from: d, reason: collision with root package name */
    private ConnectivityManager.NetworkCallback f37534d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f37535e;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void a(Network network);
    }

    private r(Context context) {
        try {
            this.f37532b = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static r a(Context context) {
        if (f37531a == null) {
            synchronized (r.class) {
                if (f37531a == null) {
                    f37531a = new r(context);
                }
            }
        }
        return f37531a;
    }

    public synchronized void a(final a aVar) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = this.f37532b;
        if (connectivityManager == null) {
            c.a("WifiNetworkUtils", "mConnectivityManager 为空");
            aVar.a(null);
            return;
        }
        Network network = this.f37533c;
        if (network != null && !this.f37535e && (networkInfo = connectivityManager.getNetworkInfo(network)) != null && networkInfo.isAvailable()) {
            aVar.a(this.f37533c);
            return;
        }
        ConnectivityManager.NetworkCallback networkCallback = this.f37534d;
        if (networkCallback != null) {
            try {
                this.f37532b.unregisterNetworkCallback(networkCallback);
            } catch (Exception e2) {
                e2.printStackTrace();
                this.f37534d = null;
            }
        }
        NetworkRequest build = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
        ConnectivityManager.NetworkCallback networkCallback2 = new ConnectivityManager.NetworkCallback() { // from class: com.mobile.auth.n.r.1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network2) {
                try {
                    if (r.this.f37532b.getNetworkCapabilities(network2).hasTransport(0)) {
                        r.this.f37533c = network2;
                        aVar.a(network2);
                        r.this.f37535e = false;
                    } else {
                        c.a("WifiNetworkUtils", "切换失败，未开启数据网络");
                        r.this.f37533c = null;
                        aVar.a(null);
                        r.this.f37532b.unregisterNetworkCallback(r.this.f37534d);
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                    r.this.f37533c = null;
                    aVar.a(null);
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network2) {
                r.this.f37535e = true;
            }
        };
        this.f37534d = networkCallback2;
        try {
            this.f37532b.requestNetwork(build, networkCallback2);
        } catch (Exception e10) {
            e10.printStackTrace();
            aVar.a(null);
        }
    }

    public boolean a() {
        return this.f37533c != null;
    }

    public void b() {
        ConnectivityManager connectivityManager = this.f37532b;
        if (connectivityManager == null) {
            return;
        }
        try {
            ConnectivityManager.NetworkCallback networkCallback = this.f37534d;
            if (networkCallback == null) {
                return;
            }
            connectivityManager.unregisterNetworkCallback(networkCallback);
            this.f37534d = null;
            this.f37533c = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
