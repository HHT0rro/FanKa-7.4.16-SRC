package com.amap.api.col.p0003l;

/* compiled from: AmapCellGsm.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class kn extends kl {

    /* renamed from: j, reason: collision with root package name */
    public int f6658j;

    /* renamed from: k, reason: collision with root package name */
    public int f6659k;

    /* renamed from: l, reason: collision with root package name */
    public int f6660l;

    /* renamed from: m, reason: collision with root package name */
    public int f6661m;

    /* renamed from: n, reason: collision with root package name */
    public int f6662n;

    /* renamed from: o, reason: collision with root package name */
    public int f6663o;

    public kn() {
        this.f6658j = 0;
        this.f6659k = 0;
        this.f6660l = Integer.MAX_VALUE;
        this.f6661m = Integer.MAX_VALUE;
        this.f6662n = Integer.MAX_VALUE;
        this.f6663o = Integer.MAX_VALUE;
    }

    @Override // com.amap.api.col.p0003l.kl
    /* renamed from: a */
    public final kl clone() {
        kn knVar = new kn(this.f6651h, this.f6652i);
        knVar.a(this);
        knVar.f6658j = this.f6658j;
        knVar.f6659k = this.f6659k;
        knVar.f6660l = this.f6660l;
        knVar.f6661m = this.f6661m;
        knVar.f6662n = this.f6662n;
        knVar.f6663o = this.f6663o;
        return knVar;
    }

    @Override // com.amap.api.col.p0003l.kl
    public final String toString() {
        return "AmapCellGsm{lac=" + this.f6658j + ", cid=" + this.f6659k + ", psc=" + this.f6660l + ", arfcn=" + this.f6661m + ", bsic=" + this.f6662n + ", timingAdvance=" + this.f6663o + ", mcc='" + this.f6644a + "', mnc='" + this.f6645b + "', signalStrength=" + this.f6646c + ", asuLevel=" + this.f6647d + ", lastUpdateSystemMills=" + this.f6648e + ", lastUpdateUtcMills=" + this.f6649f + ", age=" + this.f6650g + ", main=" + this.f6651h + ", newApi=" + this.f6652i + '}';
    }

    public kn(boolean z10, boolean z11) {
        super(z10, z11);
        this.f6658j = 0;
        this.f6659k = 0;
        this.f6660l = Integer.MAX_VALUE;
        this.f6661m = Integer.MAX_VALUE;
        this.f6662n = Integer.MAX_VALUE;
        this.f6663o = Integer.MAX_VALUE;
    }
}
