package com.huawei.quickcard.utils;

import android.content.Context;
import com.huawei.quickcard.utils.NetworkConnectivityMonitor;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class NetworkInfoImpl {
    public static void addNetworkListener(NetworkConnectivityMonitor.ConnectivityListener connectivityListener) {
        NetworkConnectivityMonitor.getInstance().addConnectivityListener(connectivityListener);
    }

    public static boolean registerNetworkListener(Context context) {
        return NetworkConnectivityMonitor.getInstance().register(context);
    }

    public static void removeAllConnectivityListeners() {
        NetworkConnectivityMonitor.getInstance().removeAllConnectivityListeners();
    }

    public static void removeConnectivityListener(NetworkConnectivityMonitor.ConnectivityListener connectivityListener) {
        NetworkConnectivityMonitor.getInstance().removeConnectivityListener(connectivityListener);
    }

    public static void unregisterNetworkListener() {
        NetworkConnectivityMonitor.getInstance().unregister();
    }

    public static void removeConnectivityListener(Set<NetworkConnectivityMonitor.ConnectivityListener> set) {
        NetworkConnectivityMonitor.getInstance().removeConnectivityListener(set);
    }
}
