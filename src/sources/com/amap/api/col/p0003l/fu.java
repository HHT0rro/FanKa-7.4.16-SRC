package com.amap.api.col.p0003l;

import android.text.TextUtils;
import com.mobile.auth.BuildConfig;

/* compiled from: SDKInfo.java */
@hi(a = "a")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class fu {

    /* renamed from: a, reason: collision with root package name */
    @hj(a = "a1", b = 6)
    private String f5950a;

    /* renamed from: b, reason: collision with root package name */
    @hj(a = "a2", b = 6)
    private String f5951b;

    /* renamed from: c, reason: collision with root package name */
    @hj(a = "a6", b = 2)
    private int f5952c;

    /* renamed from: d, reason: collision with root package name */
    @hj(a = "a3", b = 6)
    private String f5953d;

    /* renamed from: e, reason: collision with root package name */
    @hj(a = "a4", b = 6)
    private String f5954e;

    /* renamed from: f, reason: collision with root package name */
    @hj(a = "a5", b = 6)
    private String f5955f;

    /* renamed from: g, reason: collision with root package name */
    private String f5956g;

    /* renamed from: h, reason: collision with root package name */
    private String f5957h;

    /* renamed from: i, reason: collision with root package name */
    private String f5958i;

    /* renamed from: j, reason: collision with root package name */
    private String f5959j;

    /* renamed from: k, reason: collision with root package name */
    private String f5960k;

    /* renamed from: l, reason: collision with root package name */
    private String[] f5961l;

    /* compiled from: SDKInfo.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f5962a;

        /* renamed from: b, reason: collision with root package name */
        private String f5963b;

        /* renamed from: c, reason: collision with root package name */
        private String f5964c;

        /* renamed from: d, reason: collision with root package name */
        private String f5965d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f5966e = true;

        /* renamed from: f, reason: collision with root package name */
        private String f5967f = BuildConfig.FLAVOR_feat;

        /* renamed from: g, reason: collision with root package name */
        private String[] f5968g = null;

        public a(String str, String str2, String str3) {
            this.f5962a = str2;
            this.f5963b = str2;
            this.f5965d = str3;
            this.f5964c = str;
        }

        public final a a(String[] strArr) {
            if (strArr != null) {
                this.f5968g = (String[]) strArr.clone();
            }
            return this;
        }

        public final a a(String str) {
            this.f5963b = str;
            return this;
        }

        public final fu a() throws fi {
            if (this.f5968g != null) {
                return new fu(this, (byte) 0);
            }
            throw new fi("sdk packages is null");
        }
    }

    public /* synthetic */ fu(a aVar, byte b4) {
        this(aVar);
    }

    public final void a(boolean z10) {
        this.f5952c = z10 ? 1 : 0;
    }

    public final String b() {
        return this.f5956g;
    }

    public final String c() {
        if (TextUtils.isEmpty(this.f5957h) && !TextUtils.isEmpty(this.f5951b)) {
            this.f5957h = fv.c(this.f5951b);
        }
        return this.f5957h;
    }

    public final String d() {
        if (TextUtils.isEmpty(this.f5960k) && !TextUtils.isEmpty(this.f5955f)) {
            this.f5960k = fv.c(this.f5955f);
        }
        if (TextUtils.isEmpty(this.f5960k)) {
            this.f5960k = BuildConfig.FLAVOR_feat;
        }
        return this.f5960k;
    }

    public final boolean e() {
        return this.f5952c == 1;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (fu.class != obj.getClass()) {
            return false;
        }
        try {
            if (this.f5959j.equals(((fu) obj).f5959j) && this.f5956g.equals(((fu) obj).f5956g)) {
                if (this.f5957h.equals(((fu) obj).f5957h)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public final String[] f() {
        String[] strArr = this.f5961l;
        if ((strArr == null || strArr.length == 0) && !TextUtils.isEmpty(this.f5954e)) {
            this.f5961l = a(fv.c(this.f5954e));
        }
        return (String[]) this.f5961l.clone();
    }

    private fu() {
        this.f5952c = 1;
        this.f5961l = null;
    }

    public final String a() {
        if (TextUtils.isEmpty(this.f5959j) && !TextUtils.isEmpty(this.f5950a)) {
            this.f5959j = fv.c(this.f5950a);
        }
        return this.f5959j;
    }

    private fu(a aVar) {
        this.f5952c = 1;
        this.f5961l = null;
        this.f5956g = aVar.f5962a;
        this.f5957h = aVar.f5963b;
        this.f5959j = aVar.f5964c;
        this.f5958i = aVar.f5965d;
        this.f5952c = aVar.f5966e ? 1 : 0;
        this.f5960k = aVar.f5967f;
        this.f5961l = aVar.f5968g;
        this.f5951b = fv.b(this.f5957h);
        this.f5950a = fv.b(this.f5959j);
        this.f5953d = fv.b(this.f5958i);
        this.f5954e = fv.b(a(this.f5961l));
        this.f5955f = fv.b(this.f5960k);
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
}
