package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.an;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static volatile e f10241a;

    private e() {
    }

    public static e a() {
        if (f10241a == null) {
            synchronized (e.class) {
                if (f10241a == null) {
                    f10241a = new e();
                }
            }
        }
        return f10241a;
    }

    public void a(double d10, an.b bVar) {
        cp a10 = cp.a();
        String c4 = a10.c(x.f10410a);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(com.kuaishou.weapon.p0.t.f36218c, "" + d10);
        hashMap.put("os", "android");
        hashMap.put("tp", a(bk.a((Context) null).d()));
        hashMap.put("bdr", a(bk.a((Context) null).b()));
        an anVar = new an(a10.a(c4, hashMap));
        anVar.a(bVar);
        anVar.b();
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException | NullPointerException unused) {
            return str;
        }
    }

    public DexClassLoader a(String str, String str2, String str3, ClassLoader classLoader) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            file.setReadOnly();
            return new DexClassLoader(str, str2, str3, classLoader);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
