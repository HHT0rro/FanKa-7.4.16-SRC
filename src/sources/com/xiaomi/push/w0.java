package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class w0 {

    /* renamed from: b, reason: collision with root package name */
    public static volatile w0 f48449b;

    /* renamed from: a, reason: collision with root package name */
    public Context f48450a;

    public w0(Context context) {
        this.f48450a = context;
    }

    public static w0 b(Context context) {
        if (f48449b == null) {
            synchronized (w0.class) {
                if (f48449b == null) {
                    f48449b = new w0(context);
                }
            }
        }
        return f48449b;
    }

    public synchronized long a(String str, String str2, long j10) {
        try {
        } catch (Throwable unused) {
            return j10;
        }
        return this.f48450a.getSharedPreferences(str, 4).getLong(str2, j10);
    }

    public synchronized String c(String str, String str2, String str3) {
        try {
        } catch (Throwable unused) {
            return str3;
        }
        return this.f48450a.getSharedPreferences(str, 4).getString(str2, str3);
    }

    public synchronized void d(String str, String str2, long j10) {
        SharedPreferences.Editor edit = this.f48450a.getSharedPreferences(str, 4).edit();
        edit.putLong(str2, j10);
        edit.commit();
    }

    public synchronized void e(String str, String str2, String str3) {
        SharedPreferences.Editor edit = this.f48450a.getSharedPreferences(str, 4).edit();
        edit.putString(str2, str3);
        edit.commit();
    }
}
