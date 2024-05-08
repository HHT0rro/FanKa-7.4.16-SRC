package com.huawei.openalliance.ad.inter.data;

import com.huawei.openalliance.ad.constant.ad;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b {
    private int C;
    private int D;
    private int F;
    private int S;
    public static final b Code = new b(1080, 170);
    public static final b V = new b(1080, ad.f32206s);
    public static final b B = new b(960, 150);

    public b(int i10, int i11) {
        this.C = i10;
        this.S = i11;
        this.F = i10;
        this.D = i11;
    }

    public b(int i10, int i11, int i12, int i13) {
        this.C = i10;
        this.S = i11;
        this.F = i12;
        this.D = i13;
    }

    public int Code() {
        return this.C;
    }

    public int I() {
        return this.F;
    }

    public int V() {
        return this.S;
    }

    public int Z() {
        return this.D;
    }
}
