package com.tencent.turingface.sdk.mfa;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Bi3eT {

    /* renamed from: a, reason: collision with root package name */
    public int f45528a;

    /* renamed from: b, reason: collision with root package name */
    public int f45529b;

    /* renamed from: c, reason: collision with root package name */
    public long f45530c;

    /* renamed from: d, reason: collision with root package name */
    public String f45531d;

    /* renamed from: e, reason: collision with root package name */
    public int f45532e;

    /* renamed from: f, reason: collision with root package name */
    public int f45533f;

    public Bi3eT(int i10, int i11, long j10, String str, int i12, int i13) {
        this.f45528a = i10;
        this.f45529b = i11;
        this.f45530c = j10;
        this.f45531d = str;
        this.f45532e = i12;
        this.f45533f = i13;
    }

    public static Bi3eT a(int i10) {
        return new Bi3eT(i10, 100, -1L, "", -1, -2);
    }

    public final String toString() {
        return this.f45528a + "_" + this.f45529b + "_" + this.f45530c + "_" + this.f45532e + "_" + this.f45531d + "_" + this.f45533f;
    }

    public static Bi3eT a(int i10, int i11) {
        return new Bi3eT(i10, 200, -1L, "", -1, i11);
    }
}
