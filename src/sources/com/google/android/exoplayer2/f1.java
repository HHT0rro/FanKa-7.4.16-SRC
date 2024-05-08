package com.google.android.exoplayer2;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.android.internal.logging.nano.MetricsProto;

/* compiled from: PlaybackParameters.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f1 {

    /* renamed from: d, reason: collision with root package name */
    public static final f1 f20696d = new f1(1.0f);

    /* renamed from: e, reason: collision with root package name */
    public static final g<f1> f20697e = a5.a.f700a;

    /* renamed from: a, reason: collision with root package name */
    public final float f20698a;

    /* renamed from: b, reason: collision with root package name */
    public final float f20699b;

    /* renamed from: c, reason: collision with root package name */
    public final int f20700c;

    public f1(float f10) {
        this(f10, 1.0f);
    }

    public long a(long j10) {
        return j10 * this.f20700c;
    }

    @CheckResult
    public f1 b(float f10) {
        return new f1(f10, this.f20699b);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f1.class != obj.getClass()) {
            return false;
        }
        f1 f1Var = (f1) obj;
        return this.f20698a == f1Var.f20698a && this.f20699b == f1Var.f20699b;
    }

    public int hashCode() {
        return ((MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE + Float.floatToRawIntBits(this.f20698a)) * 31) + Float.floatToRawIntBits(this.f20699b);
    }

    public String toString() {
        return com.google.android.exoplayer2.util.j0.D("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.f20698a), Float.valueOf(this.f20699b));
    }

    public f1(float f10, float f11) {
        com.google.android.exoplayer2.util.a.a(f10 > 0.0f);
        com.google.android.exoplayer2.util.a.a(f11 > 0.0f);
        this.f20698a = f10;
        this.f20699b = f11;
        this.f20700c = Math.round(f10 * 1000.0f);
    }
}
