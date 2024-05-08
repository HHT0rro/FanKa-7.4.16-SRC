package com.huawei.hms.scankit.p;

/* compiled from: Patch.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c6 implements Comparable<c6> {

    /* renamed from: a, reason: collision with root package name */
    public i2 f30804a;

    /* renamed from: b, reason: collision with root package name */
    public int f30805b;

    public c6(i2 i2Var, int i10) {
        this.f30804a = i2Var;
        this.f30805b = i10;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(c6 c6Var) {
        return Float.compare((-c6Var.f30804a.g()) + c6Var.f30804a.h(), (-this.f30804a.g()) + this.f30804a.h());
    }
}
