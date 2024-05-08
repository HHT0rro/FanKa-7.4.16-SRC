package com.amap.api.col.p0003l;

/* compiled from: AmapCellLte.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ko extends kl {

    /* renamed from: j, reason: collision with root package name */
    public int f6664j;

    /* renamed from: k, reason: collision with root package name */
    public int f6665k;

    /* renamed from: l, reason: collision with root package name */
    public int f6666l;

    /* renamed from: m, reason: collision with root package name */
    public int f6667m;

    /* renamed from: n, reason: collision with root package name */
    public int f6668n;

    public ko() {
        this.f6664j = 0;
        this.f6665k = 0;
        this.f6666l = Integer.MAX_VALUE;
        this.f6667m = Integer.MAX_VALUE;
        this.f6668n = Integer.MAX_VALUE;
    }

    @Override // com.amap.api.col.p0003l.kl
    /* renamed from: a */
    public final kl clone() {
        ko koVar = new ko(this.f6651h);
        koVar.a(this);
        koVar.f6664j = this.f6664j;
        koVar.f6665k = this.f6665k;
        koVar.f6666l = this.f6666l;
        koVar.f6667m = this.f6667m;
        koVar.f6668n = this.f6668n;
        return koVar;
    }

    @Override // com.amap.api.col.p0003l.kl
    public final String toString() {
        return "AmapCellLte{tac=" + this.f6664j + ", ci=" + this.f6665k + ", pci=" + this.f6666l + ", earfcn=" + this.f6667m + ", timingAdvance=" + this.f6668n + ", mcc='" + this.f6644a + "', mnc='" + this.f6645b + "', signalStrength=" + this.f6646c + ", asuLevel=" + this.f6647d + ", lastUpdateSystemMills=" + this.f6648e + ", lastUpdateUtcMills=" + this.f6649f + ", age=" + this.f6650g + ", main=" + this.f6651h + ", newApi=" + this.f6652i + '}';
    }

    public ko(boolean z10) {
        super(z10, true);
        this.f6664j = 0;
        this.f6665k = 0;
        this.f6666l = Integer.MAX_VALUE;
        this.f6667m = Integer.MAX_VALUE;
        this.f6668n = Integer.MAX_VALUE;
    }
}
