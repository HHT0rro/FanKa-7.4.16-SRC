package com.amap.api.col.p0003l;

/* compiled from: AmapCellWcdma.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class kp extends kl {

    /* renamed from: j, reason: collision with root package name */
    public int f6669j;

    /* renamed from: k, reason: collision with root package name */
    public int f6670k;

    /* renamed from: l, reason: collision with root package name */
    public int f6671l;

    /* renamed from: m, reason: collision with root package name */
    public int f6672m;

    public kp() {
        this.f6669j = 0;
        this.f6670k = 0;
        this.f6671l = Integer.MAX_VALUE;
        this.f6672m = Integer.MAX_VALUE;
    }

    @Override // com.amap.api.col.p0003l.kl
    /* renamed from: a */
    public final kl clone() {
        kp kpVar = new kp(this.f6651h, this.f6652i);
        kpVar.a(this);
        kpVar.f6669j = this.f6669j;
        kpVar.f6670k = this.f6670k;
        kpVar.f6671l = this.f6671l;
        kpVar.f6672m = this.f6672m;
        return kpVar;
    }

    @Override // com.amap.api.col.p0003l.kl
    public final String toString() {
        return "AmapCellWcdma{lac=" + this.f6669j + ", cid=" + this.f6670k + ", psc=" + this.f6671l + ", uarfcn=" + this.f6672m + ", mcc='" + this.f6644a + "', mnc='" + this.f6645b + "', signalStrength=" + this.f6646c + ", asuLevel=" + this.f6647d + ", lastUpdateSystemMills=" + this.f6648e + ", lastUpdateUtcMills=" + this.f6649f + ", age=" + this.f6650g + ", main=" + this.f6651h + ", newApi=" + this.f6652i + '}';
    }

    public kp(boolean z10, boolean z11) {
        super(z10, z11);
        this.f6669j = 0;
        this.f6670k = 0;
        this.f6671l = Integer.MAX_VALUE;
        this.f6672m = Integer.MAX_VALUE;
    }
}
