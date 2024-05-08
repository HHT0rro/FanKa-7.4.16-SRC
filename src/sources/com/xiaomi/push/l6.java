package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class l6 {

    /* renamed from: c, reason: collision with root package name */
    public static volatile l6 f47960c;

    /* renamed from: a, reason: collision with root package name */
    public final Context f47961a;

    /* renamed from: b, reason: collision with root package name */
    public Map<String, m6> f47962b = new HashMap();

    public l6(Context context) {
        this.f47961a = context;
    }

    public static l6 a(Context context) {
        if (context == null) {
            fc.c.n("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
            return null;
        }
        if (f47960c == null) {
            synchronized (l6.class) {
                if (f47960c == null) {
                    f47960c = new l6(context);
                }
            }
        }
        return f47960c;
    }

    public m6 b() {
        m6 m6Var = this.f47962b.get("UPLOADER_PUSH_CHANNEL");
        if (m6Var != null) {
            return m6Var;
        }
        m6 m6Var2 = this.f47962b.get("UPLOADER_HTTP");
        if (m6Var2 != null) {
            return m6Var2;
        }
        return null;
    }

    public Map<String, m6> c() {
        return this.f47962b;
    }

    public void d(m6 m6Var, String str) {
        if (m6Var == null) {
            fc.c.n("[TinyDataManager]: please do not add null mUploader to TinyDataManager.");
        } else if (TextUtils.isEmpty(str)) {
            fc.c.n("[TinyDataManager]: can not add a provider from unkown resource.");
        } else {
            c().put(str, m6Var);
        }
    }

    public boolean e(hu huVar, String str) {
        if (TextUtils.isEmpty(str)) {
            fc.c.i("pkgName is null or empty, upload ClientUploadDataItem failed.");
            return false;
        }
        if (kc.z.d(huVar, false)) {
            return false;
        }
        if (TextUtils.isEmpty(huVar.d())) {
            huVar.f(kc.z.a());
        }
        huVar.g(str);
        kc.a0.a(this.f47961a, huVar);
        return true;
    }

    public boolean f(String str, String str2, long j10, String str3) {
        return g(this.f47961a.getPackageName(), this.f47961a.getPackageName(), str, str2, j10, str3);
    }

    public final boolean g(String str, String str2, String str3, String str4, long j10, String str5) {
        hu huVar = new hu();
        huVar.d(str3);
        huVar.c(str4);
        huVar.a(j10);
        huVar.b(str5);
        huVar.a(true);
        huVar.a("push_sdk_channel");
        huVar.e(str2);
        return e(huVar, str);
    }
}
