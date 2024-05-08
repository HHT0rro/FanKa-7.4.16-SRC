package com.alibaba.security.realidentity.build;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: OSSSharedPreferences.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class cw {

    /* renamed from: a, reason: collision with root package name */
    private static cw f3381a;

    /* renamed from: b, reason: collision with root package name */
    private SharedPreferences f3382b;

    private cw(Context context) {
        this.f3382b = context.getSharedPreferences("oss_android_sdk_sp", 0);
    }

    public static cw a(Context context) {
        if (f3381a == null) {
            synchronized (cw.class) {
                if (f3381a == null) {
                    f3381a = new cw(context);
                }
            }
        }
        return f3381a;
    }

    public final void b(String str) {
        SharedPreferences.Editor edit = this.f3382b.edit();
        edit.remove(str);
        edit.commit();
    }

    public final boolean c(String str) {
        return this.f3382b.contains(str);
    }

    public final void a(String str, String str2) {
        SharedPreferences.Editor edit = this.f3382b.edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public final String a(String str) {
        return this.f3382b.getString(str, "");
    }
}
