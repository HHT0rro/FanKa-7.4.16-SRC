package com.amap.api.col.s;

import android.text.TextUtils;
import com.mobile.auth.BuildConfig;

/* compiled from: SDKInfo.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ch {

    /* renamed from: a, reason: collision with root package name */
    private String f7505a;

    /* renamed from: b, reason: collision with root package name */
    private String f7506b;

    /* renamed from: c, reason: collision with root package name */
    private int f7507c;

    /* renamed from: d, reason: collision with root package name */
    private String f7508d;

    /* renamed from: e, reason: collision with root package name */
    private String f7509e;

    /* renamed from: f, reason: collision with root package name */
    private String f7510f;

    /* renamed from: g, reason: collision with root package name */
    private String f7511g;

    /* renamed from: h, reason: collision with root package name */
    private String f7512h;

    /* renamed from: i, reason: collision with root package name */
    private String f7513i;

    /* renamed from: j, reason: collision with root package name */
    private String f7514j;

    /* renamed from: k, reason: collision with root package name */
    private String f7515k;

    /* renamed from: l, reason: collision with root package name */
    private String[] f7516l;

    /* compiled from: SDKInfo.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f7517a;

        /* renamed from: b, reason: collision with root package name */
        private String f7518b;

        /* renamed from: c, reason: collision with root package name */
        private String f7519c;

        /* renamed from: d, reason: collision with root package name */
        private String f7520d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f7521e = true;

        /* renamed from: f, reason: collision with root package name */
        private String f7522f = BuildConfig.FLAVOR_feat;

        /* renamed from: g, reason: collision with root package name */
        private String[] f7523g = null;

        public a(String str, String str2, String str3) {
            this.f7517a = str2;
            this.f7518b = str2;
            this.f7520d = str3;
            this.f7519c = str;
        }

        public final a a(boolean z10) {
            this.f7521e = z10;
            return this;
        }

        public final a a(String[] strArr) {
            if (strArr != null) {
                this.f7523g = (String[]) strArr.clone();
            }
            return this;
        }

        public final a a(String str) {
            this.f7518b = str;
            return this;
        }

        public final ch a() throws bv {
            if (this.f7523g != null) {
                return new ch(this, (byte) 0);
            }
            throw new bv("sdk packages is null");
        }
    }

    public /* synthetic */ ch(a aVar, byte b4) {
        this(aVar);
    }

    public final void a() {
        this.f7507c = 1;
    }

    public final String b() {
        if (TextUtils.isEmpty(this.f7514j) && !TextUtils.isEmpty(this.f7505a)) {
            this.f7514j = ci.c(this.f7505a);
        }
        return this.f7514j;
    }

    public final String c() {
        return this.f7511g;
    }

    public final String d() {
        if (TextUtils.isEmpty(this.f7512h) && !TextUtils.isEmpty(this.f7506b)) {
            this.f7512h = ci.c(this.f7506b);
        }
        return this.f7512h;
    }

    public final String e() {
        if (TextUtils.isEmpty(this.f7515k) && !TextUtils.isEmpty(this.f7510f)) {
            this.f7515k = ci.c(this.f7510f);
        }
        if (TextUtils.isEmpty(this.f7515k)) {
            this.f7515k = BuildConfig.FLAVOR_feat;
        }
        return this.f7515k;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (ch.class != obj.getClass()) {
            return false;
        }
        try {
            if (this.f7514j.equals(((ch) obj).f7514j) && this.f7511g.equals(((ch) obj).f7511g)) {
                if (this.f7512h.equals(((ch) obj).f7512h)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public final boolean f() {
        return this.f7507c == 1;
    }

    public final String[] g() {
        String[] strArr = this.f7516l;
        if ((strArr == null || strArr.length == 0) && !TextUtils.isEmpty(this.f7509e)) {
            this.f7516l = a(ci.c(this.f7509e));
        }
        return (String[]) this.f7516l.clone();
    }

    private ch() {
        this.f7507c = 1;
        this.f7516l = null;
    }

    private static String[] a(String str) {
        try {
            return str.split(";");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String a(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            for (String str : strArr) {
                sb2.append(str);
                sb2.append(";");
            }
            return sb2.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private ch(a aVar) {
        this.f7507c = 1;
        this.f7516l = null;
        this.f7511g = aVar.f7517a;
        this.f7512h = aVar.f7518b;
        this.f7514j = aVar.f7519c;
        this.f7513i = aVar.f7520d;
        this.f7507c = aVar.f7521e ? 1 : 0;
        this.f7515k = aVar.f7522f;
        this.f7516l = aVar.f7523g;
        this.f7506b = ci.b(this.f7512h);
        this.f7505a = ci.b(this.f7514j);
        this.f7508d = ci.b(this.f7513i);
        this.f7509e = ci.b(a(this.f7516l));
        this.f7510f = ci.b(this.f7515k);
    }
}
