package cn.shuzilm.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class j extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f1770a;

    public j(Context context) {
        this.f1770a = context;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        super.onAvailable(network);
        try {
            DUHelper.oxlbmV0d(this.f1770a, network, 1);
        } catch (Throwable unused) {
        }
    }
}
