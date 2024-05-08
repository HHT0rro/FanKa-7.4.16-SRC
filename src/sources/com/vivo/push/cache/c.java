package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.ad;
import com.vivo.push.util.af;
import com.vivo.push.util.k;
import com.vivo.push.util.u;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ICacheSettings.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class c<T> {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f46141a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public List<T> f46142b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public Context f46143c;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f46144d;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f46145e;

    public c(Context context) {
        this.f46143c = ContextDelegate.getContext(context);
        ad b4 = ad.b();
        b4.a(this.f46143c);
        this.f46144d = b4.c();
        this.f46145e = b4.d();
        c();
    }

    private String b() {
        return af.b(this.f46143c).a(a(), null);
    }

    private void d(String str) {
        af.b(this.f46143c).b(a(), str);
    }

    public abstract String a();

    public abstract List<T> a(String str);

    public abstract String b(String str) throws Exception;

    public final void c() {
        synchronized (f46141a) {
            k.a(a());
            this.f46142b.clear();
            c(b());
        }
    }

    public final byte[] e() {
        byte[] bArr = this.f46144d;
        return (bArr == null || bArr.length <= 0) ? ad.b().c() : bArr;
    }

    public final byte[] f() {
        byte[] bArr = this.f46145e;
        return (bArr == null || bArr.length <= 0) ? ad.b().d() : bArr;
    }

    public final void d() {
        synchronized (f46141a) {
            this.f46142b.clear();
            d("");
            u.d("CacheSettings", "clear " + a() + " strApps");
        }
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            u.d("CacheSettings", "ClientManager init " + a() + " strApps empty.");
            return;
        }
        if (str.length() > 10000) {
            u.d("CacheSettings", "sync " + a() + " strApps lenght too large");
            d();
            return;
        }
        try {
            u.d("CacheSettings", "ClientManager init " + a() + " strApps : " + str);
            List<T> a10 = a(b(str));
            if (a10 != null) {
                this.f46142b.addAll(a10);
            }
        } catch (Exception e2) {
            d();
            u.d("CacheSettings", u.a(e2));
        }
    }
}
