package com.huawei.openalliance.ad.inter.data;

import android.text.TextUtils;
import com.huawei.openalliance.ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.ad.constant.bq;
import java.io.Serializable;

@com.huawei.openalliance.ad.annotations.b
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class v implements Serializable {
    private static final long Code = 30414300;
    private String B;
    private int C;
    private String D;
    private int F;
    private int I;
    private int L;
    private String S;
    private String V;
    private int Z;

    /* renamed from: a, reason: collision with root package name */
    private String f32487a;

    /* renamed from: b, reason: collision with root package name */
    private int f32488b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f32489c;

    /* renamed from: d, reason: collision with root package name */
    private int f32490d;

    /* renamed from: e, reason: collision with root package name */
    private int f32491e;

    /* renamed from: f, reason: collision with root package name */
    private int f32492f;

    /* renamed from: g, reason: collision with root package name */
    private Float f32493g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f32494h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f32495i;

    /* renamed from: j, reason: collision with root package name */
    private float f32496j;

    @com.huawei.openalliance.ad.annotations.b
    public v() {
        this.B = "y";
        this.S = "n";
        this.F = 200;
        this.L = 0;
        this.f32487a = "n";
        this.f32488b = 1;
        this.f32490d = 100;
        this.f32491e = 90;
        this.f32492f = 0;
        this.f32494h = true;
        this.f32495i = false;
    }

    public v(VideoInfo videoInfo) {
        this.B = "y";
        this.S = "n";
        this.F = 200;
        this.L = 0;
        this.f32487a = "n";
        this.f32488b = 1;
        this.f32490d = 100;
        this.f32491e = 90;
        this.f32492f = 0;
        this.f32494h = true;
        this.f32495i = false;
        if (videoInfo != null) {
            this.V = videoInfo.Code();
            this.I = videoInfo.I();
            this.Z = videoInfo.Z();
            if (TextUtils.equals(videoInfo.B(), "y") || TextUtils.equals(videoInfo.B(), "a")) {
                this.B = "y";
            } else {
                this.B = "n";
            }
            this.S = videoInfo.C();
            this.F = videoInfo.S();
            this.D = videoInfo.F();
            this.f32488b = videoInfo.D();
            this.f32487a = this.S;
            this.f32489c = videoInfo.L() == 0;
            if (videoInfo.a() != null) {
                this.f32490d = videoInfo.a().intValue();
            }
            if (videoInfo.b() != null) {
                this.f32491e = videoInfo.b().intValue();
            }
            I(videoInfo.c());
            if (TextUtils.equals(videoInfo.B(), "a")) {
                this.C = 1;
            } else {
                this.C = 0;
            }
            this.f32494h = "y".equalsIgnoreCase(videoInfo.e());
            Code(videoInfo.d());
            Code(videoInfo.f());
        }
    }

    private void Code(Float f10) {
        if (f10 == null) {
            f10 = null;
        } else if (f10.floatValue() <= 0.0f) {
            f10 = Float.valueOf(1.7777778f);
        }
        this.f32493g = f10;
    }

    private void I(int i10) {
        if (i10 == 1) {
            this.f32492f = 1;
        } else {
            this.f32492f = 0;
        }
    }

    @com.huawei.openalliance.ad.annotations.b
    public String B() {
        return this.B;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String C() {
        return this.S;
    }

    public void Code(float f10) {
        if (f10 <= 0.0f) {
            f10 = 3.5f;
        }
        this.f32496j = f10;
    }

    public void Code(int i10) {
        this.L = i10;
    }

    public void Code(String str) {
        this.f32487a = str;
    }

    public void Code(boolean z10) {
        this.f32495i = z10;
    }

    public boolean Code() {
        if (2 == this.f32488b || this.f32495i) {
            return true;
        }
        String str = this.V;
        return str != null && str.startsWith(bq.CONTENT.toString());
    }

    @com.huawei.openalliance.ad.annotations.b
    public int D() {
        return this.f32488b;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String F() {
        return this.D;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int I() {
        return this.I;
    }

    public int L() {
        return this.L;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int S() {
        return this.F;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String V() {
        return this.V;
    }

    public void V(int i10) {
        this.I = i10;
    }

    public void V(String str) {
        this.V = str;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int Z() {
        return this.Z;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String a() {
        return this.f32487a;
    }

    @com.huawei.openalliance.ad.annotations.b
    public boolean b() {
        return this.f32489c;
    }

    public int c() {
        return this.f32490d;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int d() {
        return this.f32491e;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int e() {
        return this.f32492f;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int f() {
        return this.C;
    }

    @com.huawei.openalliance.ad.annotations.b
    public Float g() {
        return this.f32493g;
    }

    public boolean h() {
        return this.f32495i;
    }

    public boolean i() {
        return this.f32494h;
    }

    public float j() {
        return this.f32496j;
    }
}
