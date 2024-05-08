package com.alibaba.security.biometrics.build;

import sun.util.locale.LanguageTag;

/* compiled from: Size.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class f implements Comparable<f> {

    /* renamed from: a, reason: collision with root package name */
    public final int f2297a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2298b;

    public f(int i10, int i11) {
        this.f2297a = i10;
        this.f2298b = i11;
    }

    private int a() {
        return this.f2297a;
    }

    private int b() {
        return this.f2298b;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(f fVar) {
        f fVar2 = fVar;
        return (fVar2.f2297a * fVar2.f2298b) - (this.f2297a * this.f2298b);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.f2297a == fVar.f2297a && this.f2298b == fVar.f2298b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10 = this.f2298b;
        int i11 = this.f2297a;
        return i10 ^ ((i11 >>> 16) | (i11 << 16));
    }

    public final String toString() {
        return this.f2297a + LanguageTag.PRIVATEUSE + this.f2298b;
    }

    private int a(f fVar) {
        return (fVar.f2297a * fVar.f2298b) - (this.f2297a * this.f2298b);
    }
}
