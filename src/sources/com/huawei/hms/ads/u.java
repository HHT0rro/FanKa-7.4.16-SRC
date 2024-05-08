package com.huawei.hms.ads;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class u implements s {
    private VideoConfiguration C;
    private boolean Code;
    private AdSize D;
    private int I;
    private boolean S;
    private int V;
    private boolean Z;
    private int B = 1;
    private Integer F = 0;
    private int L = -1;

    private int B(int i10) {
        if (i10 == 0) {
            return 1;
        }
        if (i10 != 1) {
            return i10 != 2 ? 0 : 2;
        }
        return 3;
    }

    @Override // com.huawei.hms.ads.s
    public int B() {
        return this.B;
    }

    @Override // com.huawei.hms.ads.s
    public VideoConfiguration C() {
        return this.C;
    }

    @Override // com.huawei.hms.ads.s
    public void Code(int i10) {
        this.V = i10;
        this.F = Integer.valueOf(B(i10));
    }

    @Override // com.huawei.hms.ads.s
    public void Code(AdSize adSize) {
        this.D = adSize;
    }

    @Override // com.huawei.hms.ads.s
    public void Code(VideoConfiguration videoConfiguration) {
        this.C = videoConfiguration;
    }

    @Override // com.huawei.hms.ads.s
    public void Code(boolean z10) {
        this.Code = z10;
    }

    @Override // com.huawei.hms.ads.s
    public boolean Code() {
        return this.Code;
    }

    @Override // com.huawei.hms.ads.s
    public AdSize D() {
        return this.D;
    }

    @Override // com.huawei.hms.ads.s
    public Integer F() {
        return this.F;
    }

    @Override // com.huawei.hms.ads.s
    public int I() {
        return this.I;
    }

    @Override // com.huawei.hms.ads.s
    public void I(int i10) {
        this.B = i10;
    }

    @Override // com.huawei.hms.ads.s
    public void I(boolean z10) {
        this.S = z10;
    }

    @Override // com.huawei.hms.ads.s
    public int L() {
        return this.L;
    }

    @Override // com.huawei.hms.ads.s
    public boolean S() {
        return this.S;
    }

    @Override // com.huawei.hms.ads.s
    public int V() {
        return this.V;
    }

    @Override // com.huawei.hms.ads.s
    public void V(int i10) {
        this.I = i10;
        this.F = Integer.valueOf(i10);
    }

    @Override // com.huawei.hms.ads.s
    public void V(boolean z10) {
        this.Z = z10;
    }

    @Override // com.huawei.hms.ads.s
    public void Z(int i10) {
        this.L = i10;
    }

    @Override // com.huawei.hms.ads.s
    public boolean Z() {
        return this.Z;
    }
}
