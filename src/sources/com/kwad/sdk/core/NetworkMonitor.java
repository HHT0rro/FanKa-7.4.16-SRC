package com.kwad.sdk.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.kuaishou.weapon.p0.g;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class NetworkMonitor {
    private static volatile boolean aoV;
    private final List<a> aoW;
    private boolean aoX;
    private final BroadcastReceiver aoY;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum Holder {
        INSTANCE;

        private final NetworkMonitor mInstance = new NetworkMonitor(0);

        Holder() {
        }

        public final NetworkMonitor getInstance() {
            return this.mInstance;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum NetworkState {
        NETWORK_NONE,
        NETWORK_MOBILE,
        NETWORK_WIFI
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void a(NetworkState networkState);
    }

    public /* synthetic */ NetworkMonitor(byte b4) {
        this();
    }

    private synchronized void aP(Context context) {
        if (aoV || context == null) {
            return;
        }
        try {
            context.getApplicationContext().registerReceiver(this.aoY, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            aoV = true;
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(NetworkState networkState) {
        Iterator<a> iterator2 = this.aoW.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().a(networkState);
        }
    }

    public static NetworkMonitor getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    private NetworkMonitor() {
        this.aoW = new CopyOnWriteArrayList();
        this.aoX = false;
        this.aoY = new BroadcastReceiver() { // from class: com.kwad.sdk.core.NetworkMonitor.1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(@NonNull Context context, Intent intent) {
                ConnectivityManager connectivityManager;
                try {
                    if ((ContextCompat.checkSelfPermission(context, g.f36116b) == 0) && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                            NetworkMonitor.this.b(NetworkState.NETWORK_NONE);
                            return;
                        }
                        if (1 == activeNetworkInfo.getType()) {
                            NetworkMonitor.this.b(NetworkState.NETWORK_WIFI);
                        } else if (activeNetworkInfo.getType() == 0) {
                            NetworkMonitor.this.b(NetworkState.NETWORK_MOBILE);
                        } else {
                            NetworkMonitor.this.b(NetworkState.NETWORK_NONE);
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
    }

    public final void a(Context context, @NonNull a aVar) {
        aP(context);
        if (this.aoW.contains(aVar)) {
            return;
        }
        this.aoW.add(aVar);
    }

    public final void a(a aVar) {
        this.aoW.remove(aVar);
    }
}
