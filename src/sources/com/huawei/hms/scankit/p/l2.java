package com.huawei.hms.scankit.p;

import sun.util.locale.LanguageTag;

/* compiled from: Dimension.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l2 {

    /* renamed from: a, reason: collision with root package name */
    private final int f31232a;

    /* renamed from: b, reason: collision with root package name */
    private final int f31233b;

    public int a() {
        return this.f31233b;
    }

    public int b() {
        return this.f31232a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof l2)) {
            return false;
        }
        l2 l2Var = (l2) obj;
        return this.f31232a == l2Var.f31232a && this.f31233b == l2Var.f31233b;
    }

    public int hashCode() {
        return (this.f31232a * 32713) + this.f31233b;
    }

    public String toString() {
        return this.f31232a + LanguageTag.PRIVATEUSE + this.f31233b;
    }
}
