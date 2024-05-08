package com.huawei.appgallery.agd.agdpro;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import com.huawei.secure.android.common.intent.SafeBroadcastReceiver;
import e9.e;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class o {

    /* renamed from: g, reason: collision with root package name */
    public static final Object f27279g = new Object();

    /* renamed from: h, reason: collision with root package name */
    public static o f27280h;

    /* renamed from: a, reason: collision with root package name */
    public final Map<Handler, Integer> f27281a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public Context f27282b = null;

    /* renamed from: c, reason: collision with root package name */
    public Object f27283c = new byte[0];

    /* renamed from: d, reason: collision with root package name */
    public boolean f27284d;

    /* renamed from: e, reason: collision with root package name */
    public b f27285e;

    /* renamed from: f, reason: collision with root package name */
    public ConnectivityManager.NetworkCallback f27286f;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b extends SafeBroadcastReceiver {
        public /* synthetic */ b(a aVar) {
        }

        @Override // com.huawei.secure.android.common.intent.SafeBroadcastReceiver
        public void a(Context context, Intent intent) {
            if (intent == null || context == null || !"android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                return;
            }
            o.this.a();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class c extends ConnectivityManager.NetworkCallback {
        public /* synthetic */ c(a aVar) {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            o.this.a();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
            o.this.a();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
            o.this.a();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum d {
        UNKNOWN(0),
        CONNECTED(1),
        NOT_CONNECTED(2);


        /* renamed from: a, reason: collision with root package name */
        public int f27293a;

        d(int i10) {
            this.f27293a = i10;
        }
    }

    public o() {
        a aVar = null;
        if (Build.VERSION.SDK_INT >= 24) {
            this.f27286f = new c(aVar);
        } else {
            this.f27285e = new b(aVar);
        }
    }

    public static o g() {
        o oVar;
        synchronized (f27279g) {
            if (f27280h == null) {
                f27280h = new o();
            }
            oVar = f27280h;
        }
        return oVar;
    }

    public final synchronized void a() {
        d dVar;
        Context context = this.f27282b;
        if (context == null) {
            return;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            dVar = d.CONNECTED;
        } else {
            dVar = d.NOT_CONNECTED;
        }
        e eVar = e.f48945d;
        StringBuilder sb2 = new StringBuilder(16);
        sb2.append("onReceive(): ");
        sb2.append((Object) activeNetworkInfo);
        sb2.append(", mState=");
        sb2.append((Object) dVar);
        eVar.d("NetworkConnectivity", sb2.toString());
        synchronized (this.f27283c) {
            for (Map.Entry<Handler, Integer> entry : this.f27281a.entrySet()) {
                Handler key = entry.getKey();
                Integer value = entry.getValue();
                if (key != null && value != null) {
                    Message obtain = Message.obtain(key, value.intValue());
                    obtain.obj = activeNetworkInfo;
                    obtain.arg1 = dVar.f27293a;
                    key.sendMessage(obtain);
                }
            }
        }
    }

    public synchronized void b(Context context) {
        if (!this.f27284d) {
            this.f27282b = context;
            if (Build.VERSION.SDK_INT >= 24) {
                NetworkRequest.Builder builder = new NetworkRequest.Builder();
                builder.addCapability(12);
                ((ConnectivityManager) this.f27282b.getApplicationContext().getSystemService(ConnectivityManager.class)).registerNetworkCallback(builder.build(), this.f27286f);
            } else {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                context.registerReceiver(this.f27285e, intentFilter);
            }
            this.f27284d = true;
        }
    }

    public void c(Handler handler) {
        synchronized (this.f27283c) {
            this.f27281a.remove(handler);
        }
    }

    public void d(Handler handler, int i10) {
        synchronized (this.f27283c) {
            this.f27281a.put(handler, Integer.valueOf(i10));
        }
    }

    public synchronized void f() {
        if (this.f27284d) {
            if (Build.VERSION.SDK_INT >= 24) {
                ((ConnectivityManager) this.f27282b.getApplicationContext().getSystemService(ConnectivityManager.class)).unregisterNetworkCallback(this.f27286f);
            } else {
                this.f27282b.unregisterReceiver(this.f27285e);
            }
            this.f27282b = null;
            this.f27284d = false;
        }
    }
}
