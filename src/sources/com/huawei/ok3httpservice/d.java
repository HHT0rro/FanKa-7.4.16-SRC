package com.huawei.ok3httpservice;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* compiled from: NetworkUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static ConnectivityManager f32108a;

    private static ConnectivityManager a(Context context) {
        if (f32108a == null) {
            f32108a = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        }
        return f32108a;
    }

    public static boolean b(Context context) {
        ConnectivityManager a10;
        NetworkInfo activeNetworkInfo;
        return (context == null || (a10 = a(context)) == null || (activeNetworkInfo = a10.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) ? false : true;
    }
}
