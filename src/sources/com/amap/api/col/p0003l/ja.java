package com.amap.api.col.p0003l;

/* compiled from: UpdateStrategy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class ja {

    /* renamed from: c, reason: collision with root package name */
    public ja f6526c;

    public ja() {
    }

    public int a() {
        ja jaVar = this.f6526c;
        return Math.min(Integer.MAX_VALUE, jaVar != null ? jaVar.a() : Integer.MAX_VALUE);
    }

    public void a_(boolean z10) {
        ja jaVar = this.f6526c;
        if (jaVar != null) {
            jaVar.a_(z10);
        }
    }

    public abstract boolean c();

    public final boolean d() {
        ja jaVar = this.f6526c;
        if (jaVar != null ? jaVar.d() : true) {
            return c();
        }
        return false;
    }

    public ja(ja jaVar) {
        this.f6526c = jaVar;
    }

    public void a_(int i10) {
        ja jaVar = this.f6526c;
        if (jaVar != null) {
            jaVar.a_(i10);
        }
    }
}
