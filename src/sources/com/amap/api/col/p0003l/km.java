package com.amap.api.col.p0003l;

/* compiled from: AmapCellCdma.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class km extends kl {

    /* renamed from: j, reason: collision with root package name */
    public int f6653j;

    /* renamed from: k, reason: collision with root package name */
    public int f6654k;

    /* renamed from: l, reason: collision with root package name */
    public int f6655l;

    /* renamed from: m, reason: collision with root package name */
    public int f6656m;

    /* renamed from: n, reason: collision with root package name */
    public int f6657n;

    public km() {
        this.f6653j = 0;
        this.f6654k = 0;
        this.f6655l = 0;
    }

    @Override // com.amap.api.col.p0003l.kl
    /* renamed from: a */
    public final kl clone() {
        km kmVar = new km(this.f6651h, this.f6652i);
        kmVar.a(this);
        kmVar.f6653j = this.f6653j;
        kmVar.f6654k = this.f6654k;
        kmVar.f6655l = this.f6655l;
        kmVar.f6656m = this.f6656m;
        kmVar.f6657n = this.f6657n;
        return kmVar;
    }

    @Override // com.amap.api.col.p0003l.kl
    public final String toString() {
        return "AmapCellCdma{sid=" + this.f6653j + ", nid=" + this.f6654k + ", bid=" + this.f6655l + ", latitude=" + this.f6656m + ", longitude=" + this.f6657n + ", mcc='" + this.f6644a + "', mnc='" + this.f6645b + "', signalStrength=" + this.f6646c + ", asuLevel=" + this.f6647d + ", lastUpdateSystemMills=" + this.f6648e + ", lastUpdateUtcMills=" + this.f6649f + ", age=" + this.f6650g + ", main=" + this.f6651h + ", newApi=" + this.f6652i + '}';
    }

    public km(boolean z10, boolean z11) {
        super(z10, z11);
        this.f6653j = 0;
        this.f6654k = 0;
        this.f6655l = 0;
    }
}
