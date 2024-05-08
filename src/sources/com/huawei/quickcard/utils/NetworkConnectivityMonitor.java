package com.huawei.quickcard.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.log.CardLogUtils;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class NetworkConnectivityMonitor {

    /* renamed from: g, reason: collision with root package name */
    private static final String f34279g = "NetworkConnectivityMonitor";

    /* renamed from: h, reason: collision with root package name */
    private static final Object f34280h = new Object();

    /* renamed from: i, reason: collision with root package name */
    private static final Object f34281i = new Object();

    /* renamed from: j, reason: collision with root package name */
    private static final Object f34282j = new Object();

    /* renamed from: k, reason: collision with root package name */
    private static volatile NetworkConnectivityMonitor f34283k;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f34285b;

    /* renamed from: d, reason: collision with root package name */
    private Context f34287d;

    /* renamed from: e, reason: collision with root package name */
    private NetworkCallbackImpl f34288e;

    /* renamed from: f, reason: collision with root package name */
    private volatile String f34289f;

    /* renamed from: a, reason: collision with root package name */
    private final Set<ConnectivityListener> f34284a = new CopyOnWriteArraySet();

    /* renamed from: c, reason: collision with root package name */
    private boolean f34286c = false;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface ConnectivityListener {
        void onConnectivityChanged(boolean z10);

        void onNetworkTypeChanged(NetworkInfo networkInfo);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class NetworkCallbackImpl extends ConnectivityManager.NetworkCallback {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<NetworkConnectivityMonitor> f34291a;

        public NetworkCallbackImpl(NetworkConnectivityMonitor networkConnectivityMonitor) {
            this.f34291a = new WeakReference<>(networkConnectivityMonitor);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(@NonNull Network network) {
            super.onAvailable(network);
            NetworkConnectivityMonitor networkConnectivityMonitor = this.f34291a.get();
            if (networkConnectivityMonitor == null) {
                return;
            }
            networkConnectivityMonitor.a(true);
            networkConnectivityMonitor.a();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(@NonNull Network network, @NonNull NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
            NetworkConnectivityMonitor networkConnectivityMonitor = this.f34291a.get();
            if (networkConnectivityMonitor == null) {
                return;
            }
            networkConnectivityMonitor.a();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(@NonNull Network network) {
            super.onLost(network);
            NetworkConnectivityMonitor networkConnectivityMonitor = this.f34291a.get();
            if (networkConnectivityMonitor == null) {
                return;
            }
            networkConnectivityMonitor.a(false);
            networkConnectivityMonitor.a();
        }
    }

    private NetworkConnectivityMonitor() {
    }

    public static NetworkConnectivityMonitor getInstance() {
        if (f34283k == null) {
            synchronized (f34280h) {
                if (f34283k == null) {
                    f34283k = new NetworkConnectivityMonitor();
                }
            }
        }
        return f34283k;
    }

    public void addConnectivityListener(ConnectivityListener connectivityListener) {
        synchronized (f34281i) {
            this.f34284a.add(connectivityListener);
        }
    }

    public String getNetworkType() {
        return this.f34289f;
    }

    public boolean register(Context context) {
        this.f34285b = true;
        synchronized (f34282j) {
            if (this.f34287d == null && context != null) {
                Context applicationContext = context.getApplicationContext();
                this.f34287d = applicationContext;
                ConnectivityManager connectivityManager = NetworkUtils.getConnectivityManager(applicationContext);
                if (connectivityManager != null) {
                    this.f34288e = new NetworkCallbackImpl(this);
                    connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), this.f34288e);
                    a(connectivityManager);
                }
                return true;
            }
            return false;
        }
    }

    public void registerGlobalListener(Context context) {
        if (this.f34285b || context == null) {
            return;
        }
        register(context);
        addConnectivityListener(new ConnectivityListener() { // from class: com.huawei.quickcard.utils.NetworkConnectivityMonitor.1
            @Override // com.huawei.quickcard.utils.NetworkConnectivityMonitor.ConnectivityListener
            public void onConnectivityChanged(boolean z10) {
            }

            @Override // com.huawei.quickcard.utils.NetworkConnectivityMonitor.ConnectivityListener
            public void onNetworkTypeChanged(NetworkInfo networkInfo) {
                NetworkConnectivityMonitor.this.setNetworkType(NetworkUtils.getNetworkType(networkInfo));
            }
        });
    }

    public void removeAllConnectivityListeners() {
        if (this.f34284a.isEmpty()) {
            return;
        }
        this.f34284a.clear();
    }

    public void removeConnectivityListener(ConnectivityListener connectivityListener) {
        synchronized (f34281i) {
            this.f34284a.remove(connectivityListener);
        }
    }

    public void setNetworkType(String str) {
        this.f34289f = str;
    }

    public void unregister() {
        synchronized (f34282j) {
            if (this.f34288e == null) {
                return;
            }
            ConnectivityManager connectivityManager = NetworkUtils.getConnectivityManager(this.f34287d);
            if (connectivityManager == null) {
                return;
            }
            connectivityManager.unregisterNetworkCallback(this.f34288e);
            this.f34288e = null;
            this.f34287d = null;
        }
    }

    private void a(ConnectivityManager connectivityManager) {
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                this.f34286c = activeNetworkInfo.isConnected();
            }
        } catch (SecurityException unused) {
            CardLogUtils.w(f34279g, "SecurityException : init preConnect failed");
        }
    }

    public void removeConnectivityListener(Set<ConnectivityListener> set) {
        synchronized (f34281i) {
            if (set == null) {
                return;
            }
            for (ConnectivityListener connectivityListener : set) {
                if (connectivityListener != null) {
                    this.f34284a.remove(connectivityListener);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z10) {
        if (this.f34286c == z10) {
            return;
        }
        this.f34286c = z10;
        for (ConnectivityListener connectivityListener : this.f34284a) {
            if (connectivityListener != null) {
                connectivityListener.onConnectivityChanged(z10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        NetworkInfo networkInfo = NetworkUtils.getNetworkInfo(getInstance().f34287d);
        for (ConnectivityListener connectivityListener : this.f34284a) {
            if (connectivityListener != null) {
                connectivityListener.onNetworkTypeChanged(networkInfo);
            }
        }
    }
}
