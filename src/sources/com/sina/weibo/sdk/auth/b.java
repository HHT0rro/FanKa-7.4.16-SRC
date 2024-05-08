package com.sina.weibo.sdk.auth;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    private Map<String, WbAuthListener> f38339e;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: f, reason: collision with root package name */
        private static final b f38340f = new b(0);
    }

    public /* synthetic */ b(byte b4) {
        this();
    }

    public static synchronized b d() {
        b bVar;
        synchronized (b.class) {
            bVar = a.f38340f;
        }
        return bVar;
    }

    public final synchronized void a(String str, WbAuthListener wbAuthListener) {
        if (!TextUtils.isEmpty(str) && wbAuthListener != null) {
            this.f38339e.put(str, wbAuthListener);
        }
    }

    public final synchronized WbAuthListener b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f38339e.get(str);
    }

    public final synchronized void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f38339e.remove(str);
    }

    private b() {
        this.f38339e = new HashMap();
    }
}
