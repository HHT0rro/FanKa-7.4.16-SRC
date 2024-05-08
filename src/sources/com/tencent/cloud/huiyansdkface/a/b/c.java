package com.tencent.cloud.huiyansdkface.a.b;

import android.os.Build;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c extends Throwable {

    /* renamed from: c, reason: collision with root package name */
    private static String f40319c = a();

    /* renamed from: a, reason: collision with root package name */
    private int f40320a;

    /* renamed from: b, reason: collision with root package name */
    private String f40321b;

    public c(int i10, String str, Throwable th, String str2) {
        super(str, th);
        this.f40320a = i10;
        this.f40321b = str2;
    }

    public static c a(int i10, String str) {
        return new c(i10, str, null, "type_status");
    }

    public static c a(int i10, String str, Throwable th) {
        return new c(i10, str, th, "type_device");
    }

    public static String a() {
        return "BRAND:" + Build.BRAND + "\nMODEL:" + Build.MODEL + "\nSDK_INT:" + Build.VERSION.SDK_INT + "\nVERSION:release_1.0.41.14\nVERSION_CODE:58\n";
    }

    public static c b(int i10, String str, Throwable th) {
        return new c(i10, str, th, "type_fatal");
    }

    public int b() {
        return this.f40320a;
    }

    public String c() {
        return this.f40321b;
    }

    public String d() {
        return super.getMessage();
    }
}
