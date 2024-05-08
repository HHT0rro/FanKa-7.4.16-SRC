package com.autonavi.aps.amapapi.restruct;

/* compiled from: Cgi.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class d {

    /* renamed from: l, reason: collision with root package name */
    public int f9440l;

    /* renamed from: n, reason: collision with root package name */
    public boolean f9442n;

    /* renamed from: a, reason: collision with root package name */
    public int f9429a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f9430b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f9431c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f9432d = 0;

    /* renamed from: e, reason: collision with root package name */
    public long f9433e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f9434f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f9435g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f9436h = 0;

    /* renamed from: i, reason: collision with root package name */
    public int f9437i = 0;

    /* renamed from: j, reason: collision with root package name */
    public int f9438j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f9439k = -113;

    /* renamed from: m, reason: collision with root package name */
    public short f9441m = 0;

    /* renamed from: o, reason: collision with root package name */
    public int f9443o = 32767;

    /* renamed from: p, reason: collision with root package name */
    public int f9444p = Integer.MAX_VALUE;

    /* renamed from: q, reason: collision with root package name */
    public int f9445q = Integer.MAX_VALUE;

    /* renamed from: r, reason: collision with root package name */
    public boolean f9446r = true;

    /* renamed from: s, reason: collision with root package name */
    public int f9447s = 99;

    /* renamed from: t, reason: collision with root package name */
    public long f9448t = 0;

    public d(int i10, boolean z10) {
        this.f9440l = i10;
        this.f9442n = z10;
    }

    private String e() {
        int i10 = this.f9440l;
        return this.f9440l + "#" + this.f9429a + "#" + this.f9430b + "#0#" + a();
    }

    private String f() {
        return this.f9440l + "#" + this.f9436h + "#" + this.f9437i + "#" + this.f9438j;
    }

    public final long a() {
        if (this.f9440l == 5) {
            return this.f9433e;
        }
        return this.f9432d;
    }

    public final String b() {
        int i10 = this.f9440l;
        if (i10 != 1) {
            if (i10 == 2) {
                return f();
            }
            if (i10 != 3 && i10 != 4 && i10 != 5) {
                return null;
            }
        }
        return e();
    }

    public final String c() {
        String b4 = b();
        if (b4 == null || b4.length() <= 0) {
            return "";
        }
        return (this.f9446r ? 1 : 0) + "#" + b4;
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final d clone() {
        d dVar = new d(this.f9440l, this.f9442n);
        dVar.f9429a = this.f9429a;
        dVar.f9430b = this.f9430b;
        dVar.f9431c = this.f9431c;
        dVar.f9432d = this.f9432d;
        dVar.f9433e = this.f9433e;
        dVar.f9434f = this.f9434f;
        dVar.f9435g = this.f9435g;
        dVar.f9436h = this.f9436h;
        dVar.f9437i = this.f9437i;
        dVar.f9438j = this.f9438j;
        dVar.f9439k = this.f9439k;
        dVar.f9441m = this.f9441m;
        dVar.f9443o = this.f9443o;
        dVar.f9444p = this.f9444p;
        dVar.f9445q = this.f9445q;
        dVar.f9446r = this.f9446r;
        dVar.f9447s = this.f9447s;
        dVar.f9448t = this.f9448t;
        return dVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof d)) {
            d dVar = (d) obj;
            int i10 = dVar.f9440l;
            if (i10 != 1) {
                return i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 == 5 && this.f9440l == 5 && dVar.f9431c == this.f9431c && dVar.f9433e == this.f9433e && dVar.f9445q == this.f9445q : this.f9440l == 4 && dVar.f9431c == this.f9431c && dVar.f9432d == this.f9432d && dVar.f9430b == this.f9430b : this.f9440l == 3 && dVar.f9431c == this.f9431c && dVar.f9432d == this.f9432d && dVar.f9430b == this.f9430b : this.f9440l == 2 && dVar.f9438j == this.f9438j && dVar.f9437i == this.f9437i && dVar.f9436h == this.f9436h;
            }
            if (this.f9440l == 1 && dVar.f9431c == this.f9431c && dVar.f9432d == this.f9432d && dVar.f9430b == this.f9430b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = String.valueOf(this.f9440l).hashCode();
        if (this.f9440l == 2) {
            hashCode = String.valueOf(this.f9438j).hashCode() + String.valueOf(this.f9437i).hashCode();
            hashCode2 = String.valueOf(this.f9436h).hashCode();
        } else {
            hashCode = String.valueOf(this.f9431c).hashCode() + String.valueOf(this.f9432d).hashCode();
            hashCode2 = String.valueOf(this.f9430b).hashCode();
        }
        return hashCode3 + hashCode + hashCode2;
    }
}
