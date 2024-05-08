package com.google.android.exoplayer2.video.spherical;

import android.opengl.Matrix;
import com.google.android.exoplayer2.util.e0;

/* compiled from: FrameRotationQueue.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f23125a = new float[16];

    /* renamed from: b, reason: collision with root package name */
    public final float[] f23126b = new float[16];

    /* renamed from: c, reason: collision with root package name */
    public final e0<float[]> f23127c = new e0<>();

    /* renamed from: d, reason: collision with root package name */
    public boolean f23128d;

    public static void a(float[] fArr, float[] fArr2) {
        Matrix.setIdentityM(fArr, 0);
        float sqrt = (float) Math.sqrt((fArr2[10] * fArr2[10]) + (fArr2[8] * fArr2[8]));
        fArr[0] = fArr2[10] / sqrt;
        fArr[2] = fArr2[8] / sqrt;
        fArr[8] = (-fArr2[8]) / sqrt;
        fArr[10] = fArr2[10] / sqrt;
    }

    public static void b(float[] fArr, float[] fArr2) {
        float f10 = fArr2[0];
        float f11 = -fArr2[1];
        float f12 = -fArr2[2];
        float length = Matrix.length(f10, f11, f12);
        if (length != 0.0f) {
            Matrix.setRotateM(fArr, 0, (float) Math.toDegrees(length), f10 / length, f11 / length, f12 / length);
        } else {
            Matrix.setIdentityM(fArr, 0);
        }
    }

    public boolean c(float[] fArr, long j10) {
        float[] j11 = this.f23127c.j(j10);
        if (j11 == null) {
            return false;
        }
        b(this.f23126b, j11);
        if (!this.f23128d) {
            a(this.f23125a, this.f23126b);
            this.f23128d = true;
        }
        Matrix.multiplyMM(fArr, 0, this.f23125a, 0, this.f23126b, 0);
        return true;
    }

    public void d() {
        this.f23127c.c();
        this.f23128d = false;
    }

    public void e(long j10, float[] fArr) {
        this.f23127c.a(j10, fArr);
    }
}
