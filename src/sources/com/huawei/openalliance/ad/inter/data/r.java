package com.huawei.openalliance.ad.inter.data;

import com.huawei.openalliance.ad.beans.metadata.MediaFile;
import com.huawei.openalliance.ad.constant.bb;
import com.huawei.openalliance.ad.constant.bq;
import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class r implements Serializable {
    private int B;
    private int C;
    private int D;
    private String F;
    private String I;
    private int L;
    private String S;
    private String V;
    private long Z;

    /* renamed from: a, reason: collision with root package name */
    private int f32480a;

    /* renamed from: b, reason: collision with root package name */
    private long f32481b;

    /* renamed from: c, reason: collision with root package name */
    private String f32482c;

    public r() {
        this.B = 0;
        this.C = 0;
        this.F = "y";
        this.L = 0;
    }

    public r(MediaFile mediaFile, long j10) {
        this.B = 0;
        this.C = 0;
        this.F = "y";
        this.L = 0;
        this.V = mediaFile.Code();
        this.I = mediaFile.B();
        this.Z = mediaFile.Z();
        this.D = mediaFile.S();
        this.L = mediaFile.F();
        this.B = mediaFile.V();
        this.C = mediaFile.I();
        this.S = mediaFile.C();
        this.f32480a = mediaFile.D();
        this.f32481b = j10;
    }

    public String C() {
        return this.S;
    }

    public void Code(String str) {
        this.F = str;
    }

    public boolean I() {
        String str = this.I;
        if (str != null && str.startsWith(bq.CONTENT.toString())) {
            return true;
        }
        String str2 = this.f32482c;
        return str2 != null && str2.startsWith(bq.CONTENT.toString());
    }

    public int L() {
        return this.D;
    }

    public String S() {
        return this.F;
    }

    public void V(String str) {
        this.f32482c = str;
    }

    public boolean V() {
        return bb.Code.equals(this.V);
    }

    public String Z() {
        return this.I;
    }

    public String b() {
        return this.V;
    }

    public int c() {
        return this.f32480a;
    }

    public long d() {
        return this.f32481b;
    }

    public String e() {
        String str = this.I;
        return (str == null || !str.startsWith(bq.CONTENT.toString())) ? this.f32482c : this.I;
    }

    public Float f() {
        int i10;
        int i11 = this.B;
        if (i11 <= 0 || (i10 = this.C) <= 0) {
            return null;
        }
        return Float.valueOf(i11 / i10);
    }
}
