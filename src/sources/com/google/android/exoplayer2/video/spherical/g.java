package com.google.android.exoplayer2.video.spherical;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.e0;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: SceneRenderer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g implements q6.h, a {

    /* renamed from: j, reason: collision with root package name */
    public int f23145j;

    /* renamed from: k, reason: collision with root package name */
    public SurfaceTexture f23146k;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public byte[] f23149n;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f23137b = new AtomicBoolean();

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f23138c = new AtomicBoolean(true);

    /* renamed from: d, reason: collision with root package name */
    public final ProjectionRenderer f23139d = new ProjectionRenderer();

    /* renamed from: e, reason: collision with root package name */
    public final c f23140e = new c();

    /* renamed from: f, reason: collision with root package name */
    public final e0<Long> f23141f = new e0<>();

    /* renamed from: g, reason: collision with root package name */
    public final e0<Projection> f23142g = new e0<>();

    /* renamed from: h, reason: collision with root package name */
    public final float[] f23143h = new float[16];

    /* renamed from: i, reason: collision with root package name */
    public final float[] f23144i = new float[16];

    /* renamed from: l, reason: collision with root package name */
    public volatile int f23147l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f23148m = -1;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(SurfaceTexture surfaceTexture) {
        this.f23137b.set(true);
    }

    @Override // q6.h
    public void a(long j10, long j11, Format format, @Nullable MediaFormat mediaFormat) {
        this.f23141f.a(j11, Long.valueOf(j10));
        i(format.f19554w, format.f19555x, j11);
    }

    @Override // com.google.android.exoplayer2.video.spherical.a
    public void c(long j10, float[] fArr) {
        this.f23140e.e(j10, fArr);
    }

    @Override // com.google.android.exoplayer2.video.spherical.a
    public void d() {
        this.f23141f.c();
        this.f23140e.d();
        this.f23138c.set(true);
    }

    public void e(float[] fArr, boolean z10) {
        GLES20.glClear(16384);
        com.google.android.exoplayer2.util.i.b();
        if (this.f23137b.compareAndSet(true, false)) {
            ((SurfaceTexture) com.google.android.exoplayer2.util.a.e(this.f23146k)).updateTexImage();
            com.google.android.exoplayer2.util.i.b();
            if (this.f23138c.compareAndSet(true, false)) {
                Matrix.setIdentityM(this.f23143h, 0);
            }
            long timestamp = this.f23146k.getTimestamp();
            Long g3 = this.f23141f.g(timestamp);
            if (g3 != null) {
                this.f23140e.c(this.f23143h, g3.longValue());
            }
            Projection j10 = this.f23142g.j(timestamp);
            if (j10 != null) {
                this.f23139d.d(j10);
            }
        }
        Matrix.multiplyMM(this.f23144i, 0, fArr, 0, this.f23143h, 0);
        this.f23139d.a(this.f23145j, this.f23144i, z10);
    }

    public SurfaceTexture f() {
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        com.google.android.exoplayer2.util.i.b();
        this.f23139d.b();
        com.google.android.exoplayer2.util.i.b();
        this.f23145j = com.google.android.exoplayer2.util.i.g();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f23145j);
        this.f23146k = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: com.google.android.exoplayer2.video.spherical.f
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                g.this.g(surfaceTexture2);
            }
        });
        return this.f23146k;
    }

    public void h(int i10) {
        this.f23147l = i10;
    }

    public final void i(@Nullable byte[] bArr, int i10, long j10) {
        byte[] bArr2 = this.f23149n;
        int i11 = this.f23148m;
        this.f23149n = bArr;
        if (i10 == -1) {
            i10 = this.f23147l;
        }
        this.f23148m = i10;
        if (i11 == i10 && Arrays.equals(bArr2, this.f23149n)) {
            return;
        }
        byte[] bArr3 = this.f23149n;
        Projection a10 = bArr3 != null ? e.a(bArr3, this.f23148m) : null;
        if (a10 == null || !ProjectionRenderer.c(a10)) {
            a10 = Projection.b(this.f23148m);
        }
        this.f23142g.a(j10, a10);
    }
}
