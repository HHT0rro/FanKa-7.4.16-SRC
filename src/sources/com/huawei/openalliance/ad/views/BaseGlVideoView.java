package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.AttributeSet;
import android.view.Surface;
import com.huawei.hms.ads.fm;
import com.huawei.hms.ads.fn;
import com.huawei.hms.ads.fo;
import com.huawei.hms.ads.fp;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.ly;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.views.BaseVideoView;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class BaseGlVideoView extends BaseVideoView implements ly {
    public int B;
    public int C;
    public final fo Code;
    public Integer D;
    public Integer F;
    public fp I;
    public volatile Float L;
    public d S;
    public fm V;

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f32631a;

    /* renamed from: q, reason: collision with root package name */
    private final fn f32632q;

    /* renamed from: r, reason: collision with root package name */
    private float[] f32633r;

    /* renamed from: s, reason: collision with root package name */
    private volatile boolean f32634s;

    public BaseGlVideoView(Context context) {
        super(context);
        fn fnVar = new fn();
        this.f32632q = fnVar;
        this.Code = new fo(fnVar);
        this.f32631a = false;
        this.f32633r = new float[16];
        this.f32634s = false;
    }

    public BaseGlVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        fn fnVar = new fn();
        this.f32632q = fnVar;
        this.Code = new fo(fnVar);
        this.f32631a = false;
        this.f32633r = new float[16];
        this.f32634s = false;
    }

    public BaseGlVideoView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        fn fnVar = new fn();
        this.f32632q = fnVar;
        this.Code = new fo(fnVar);
        this.f32631a = false;
        this.f32633r = new float[16];
        this.f32634s = false;
    }

    private void B(int i10, int i11) {
        this.B = i10;
        this.C = i11;
        Code(i10, i11);
        if (this.L != null) {
            float floatValue = this.L.floatValue();
            int i12 = this.B;
            int i13 = this.C;
            Code(floatValue, i12 / i13, i12, i13);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(Surface surface) {
        gl.V(getLogTag(), "onSurfaceAvailable");
        this.f32640d = true;
        if (this.S != null && surface != null && surface.isValid()) {
            try {
                this.S.V();
                fm fmVar = new fm(this.S.S(), surface);
                this.V = fmVar;
                fmVar.I();
                this.S.Code();
                this.f32643g = this.S.I();
                this.I = this.S.C();
                this.Code.Code(this.S.Z());
                this.f32644h = this.S.B();
                this.f32641e.Code(this.f32643g);
                B(this.V.Code(), this.V.V());
                if (this.f32648l == null) {
                    BaseVideoView.h hVar = new BaseVideoView.h(this.f32651o);
                    this.f32648l = hVar;
                    this.f32641e.Code(hVar);
                }
                if (this.f32639c) {
                    Code(this.f32645i);
                }
            } catch (Throwable th) {
                gl.I(getLogTag(), "exception: %s", th.getClass().getSimpleName());
            }
        }
        I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(int i10, int i11) {
        gl.V(getLogTag(), "onSurfaceChanged");
        B(i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.I == null || this.V == null) {
            gl.I(getLogTag(), "render failed, textureProgram:%s, windowSurface:%s", au.V(this.I), au.V(this.V));
            return;
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        if (this.f32634s) {
            this.Code.Code(this.I, this.f32633r);
            this.V.Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        gl.V(getLogTag(), "onSurfaceDestroyed");
        this.f32640d = false;
        Code();
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView
    public void B() {
        Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseGlVideoView.3
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(16384);
            }
        });
    }

    public void C() {
        Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseGlVideoView.4
            @Override // java.lang.Runnable
            public void run() {
                BaseGlVideoView.this.i();
            }
        });
    }

    public void Code() {
        Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseGlVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                fm fmVar = BaseGlVideoView.this.V;
                if (fmVar != null) {
                    fmVar.B();
                    BaseGlVideoView.this.V = null;
                }
            }
        });
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView
    public void Code(float f10, float f11, int i10, int i11) {
        int i12 = this.f32646j;
        if (i12 == 1) {
            Code(this.B, this.C);
            return;
        }
        if (i12 != 2) {
            return;
        }
        if (f11 < f10) {
            this.D = Integer.valueOf(i11);
            this.F = Integer.valueOf((int) (i11 * f10));
        } else {
            this.F = Integer.valueOf(i10);
            this.D = Integer.valueOf((int) (i10 / f10));
        }
        this.Code.Code(this.F.intValue(), this.D.intValue());
    }

    public void Code(int i10, int i11) {
        GLES20.glViewport(0, 0, i10, i11);
        float f10 = i10;
        float f11 = i11;
        Matrix.orthoM(this.f32633r, 0, 0.0f, f10, 0.0f, f11, -1.0f, 1.0f);
        float f12 = f10 / 2.0f;
        float f13 = f11 / 2.0f;
        Integer num = this.F;
        if (num != null) {
            i10 = num.intValue();
        }
        Integer num2 = this.D;
        if (num2 != null) {
            i11 = num2.intValue();
        }
        this.Code.Code(i10, i11);
        this.Code.V(f12, f13);
    }

    public void Code(final Surface surface) {
        Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseGlVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                BaseGlVideoView.this.V(surface);
            }
        });
    }

    public void Code(Runnable runnable) {
        d dVar = this.S;
        if (dVar != null) {
            dVar.Code(runnable);
        }
    }

    public void I() {
        if (this.f32631a) {
            gl.I(getLogTag(), "renderVideo, destroyed");
        } else {
            Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseGlVideoView.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (BaseGlVideoView.this.f32631a) {
                            gl.I(BaseGlVideoView.this.getLogTag(), "renderVideo, destroyed");
                            return;
                        }
                        SurfaceTexture surfaceTexture = BaseGlVideoView.this.f32644h;
                        if (surfaceTexture != null) {
                            surfaceTexture.updateTexImage();
                        }
                        BaseGlVideoView baseGlVideoView = BaseGlVideoView.this;
                        if (baseGlVideoView.V != null) {
                            GLES20.glViewport(0, 0, baseGlVideoView.B, baseGlVideoView.C);
                            BaseGlVideoView.this.V.I();
                            BaseGlVideoView.this.h();
                        }
                    } catch (Throwable th) {
                        gl.Code(3, BaseGlVideoView.this.getLogTag(), "render exception", th);
                    }
                }
            });
        }
    }

    public void V(final int i10, final int i11) {
        Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseGlVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                BaseGlVideoView.this.Z(i10, i11);
                ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseGlVideoView.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BaseGlVideoView baseGlVideoView = BaseGlVideoView.this;
                        baseGlVideoView.f32651o.Code(baseGlVideoView.f32649m, baseGlVideoView.f32650n);
                    }
                });
            }
        });
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView, com.huawei.hms.ads.lz
    public void destroyView() {
        super.destroyView();
        this.f32631a = true;
        this.f32634s = false;
        Code();
    }

    public abstract String getLogTag();

    public void setVideoRatio(Float f10) {
        gl.Code(getLogTag(), "setVideoRatio %s", f10);
        this.L = f10;
    }
}
