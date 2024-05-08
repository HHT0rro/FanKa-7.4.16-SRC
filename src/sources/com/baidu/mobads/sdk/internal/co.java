package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class co {

    /* renamed from: a, reason: collision with root package name */
    private static volatile co f10075a;

    private co() {
    }

    public static co a() {
        if (f10075a == null) {
            synchronized (co.class) {
                if (f10075a == null) {
                    f10075a = new co();
                }
            }
        }
        return f10075a;
    }

    private NetworkCapabilities c(Context context) {
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.f36116b) != 0) {
                return null;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
            return connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        } catch (Throwable unused) {
            return null;
        }
    }

    public NetworkInfo b(Context context) {
        try {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.f36116b) == 0) {
                return ((ConnectivityManager) applicationContext.getSystemService("connectivity")).getActiveNetworkInfo();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Boolean a(Context context) {
        try {
            boolean z10 = false;
            if (bk.a(context).a() < 29) {
                NetworkInfo b4 = b(context);
                if (b4 != null && b4.isConnected() && b4.getType() == 1) {
                    z10 = true;
                }
                return Boolean.valueOf(z10);
            }
            NetworkCapabilities c4 = c(context);
            if (c4 != null && c4.hasCapability(12) && c4.hasCapability(16) && c4.hasTransport(1)) {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        } catch (Throwable unused) {
            return Boolean.FALSE;
        }
    }
}
