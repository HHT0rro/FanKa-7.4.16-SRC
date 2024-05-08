package com.alipay.android.phone.mrpc.core;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f4282a;

    public static final boolean a(Context context) {
        Boolean bool = f4282a;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Boolean valueOf = Boolean.valueOf((context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 2) != 0);
            f4282a = valueOf;
            return valueOf.booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }
}
