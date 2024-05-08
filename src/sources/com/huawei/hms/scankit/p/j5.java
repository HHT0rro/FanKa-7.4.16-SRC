package com.huawei.hms.scankit.p;

import android.view.animation.Interpolator;
import androidx.annotation.NonNull;

/* compiled from: OpacityAnimator.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class j5 implements f4 {

    /* renamed from: a, reason: collision with root package name */
    private final int f31169a;

    /* renamed from: b, reason: collision with root package name */
    private final int f31170b;

    /* renamed from: c, reason: collision with root package name */
    private final long f31171c;

    /* renamed from: d, reason: collision with root package name */
    private final long f31172d;

    /* renamed from: e, reason: collision with root package name */
    private final float f31173e;

    /* renamed from: f, reason: collision with root package name */
    private final Interpolator f31174f;

    public j5(int i10, int i11, long j10, long j11, @NonNull Interpolator interpolator) {
        this.f31169a = i10;
        this.f31170b = i11;
        this.f31171c = j10;
        this.f31172d = j11;
        this.f31173e = (float) (j11 - j10);
        this.f31174f = interpolator;
    }

    private int a(@NonNull w5 w5Var) {
        int i10 = this.f31170b;
        return i10 == -1 ? w5Var.e() : i10;
    }

    private int b(@NonNull w5 w5Var) {
        int i10 = this.f31169a;
        return i10 == -1 ? w5Var.a() : i10;
    }

    private int c(@NonNull w5 w5Var) {
        return a(w5Var) - b(w5Var);
    }

    @Override // com.huawei.hms.scankit.p.f4
    public void a(@NonNull w5 w5Var, long j10) {
        if (j10 < this.f31171c || j10 > this.f31172d || Float.compare(this.f31173e, 0.0f) == 0) {
            return;
        }
        w5Var.a((int) (b(w5Var) + (c(w5Var) * this.f31174f.getInterpolation(((float) (j10 - this.f31171c)) / this.f31173e))));
    }
}
