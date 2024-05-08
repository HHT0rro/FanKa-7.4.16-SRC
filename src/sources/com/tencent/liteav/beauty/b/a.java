package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import androidx.annotation.NonNull;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.nio.FloatBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a extends com.tencent.liteav.videobase.a.b implements b {

    /* renamed from: f, reason: collision with root package name */
    private float f42939f = 0.0f;

    /* renamed from: g, reason: collision with root package name */
    private float f42940g = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    private float f42941h = 0.0f;

    /* renamed from: i, reason: collision with root package name */
    private float f42942i = 0.0f;

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FloatBuffer f42934a = OpenGlUtils.createNormalCubeVerticesBuffer();

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    private final FloatBuffer f42935b = OpenGlUtils.createTextureCoordsBuffer(Rotation.NORMAL, false, false);

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    private final e f42936c = new e();

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final C0639a f42937d = new C0639a();

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    private final m f42938e = new m();

    /* renamed from: com.tencent.liteav.beauty.b.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0639a extends com.tencent.liteav.videobase.b.e {

        /* renamed from: a, reason: collision with root package name */
        public int f42953a;

        /* renamed from: b, reason: collision with root package name */
        public int f42954b;

        /* renamed from: c, reason: collision with root package name */
        public int f42955c;

        public C0639a() {
            super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\nattribute vec4 inputTextureCoordinate3;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvarying vec2 textureCoordinate3;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n    textureCoordinate3 = inputTextureCoordinate3.xy;\n}", com.tencent.liteav.videobase.a.b.NO_FILTER_FRAGMENT_SHADER);
            this.f42953a = -1;
            this.f42954b = -1;
            this.f42955c = -1;
        }

        @Override // com.tencent.liteav.videobase.a.b
        public final int buildProgram() {
            return NativeLoad.nativeLoadGLProgram(1);
        }

        @Override // com.tencent.liteav.videobase.b.e, com.tencent.liteav.videobase.b.f, com.tencent.liteav.videobase.a.b
        public final void onInit(com.tencent.liteav.videobase.frame.e eVar) {
            super.onInit(eVar);
            this.f42953a = GLES20.glGetUniformLocation(getProgramId(), "smoothDegree");
            this.f42954b = GLES20.glGetUniformLocation(getProgramId(), "brightDegree");
            this.f42955c = GLES20.glGetUniformLocation(getProgramId(), "ruddyDegree");
        }
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void a(float f10) {
        float f11;
        float f12;
        float f13;
        float f14;
        this.f42939f = f10;
        C0639a c0639a = this.f42937d;
        int i10 = c0639a.f42953a;
        float f15 = 1.0f;
        if (f10 > 1.0f) {
            double d10 = f10;
            if (d10 < 2.5d) {
                f12 = (f10 - 1.0f) / 1.5f;
                f13 = 3.1f;
            } else if (f10 < 4.0f) {
                f15 = 4.1f;
                f14 = ((f10 - 2.5f) / 1.5f) * 1.5f;
                f10 = f14 + f15;
                f11 = f10 / 10.0f;
            } else if (d10 < 5.5d) {
                f12 = (f10 - 4.0f) / 1.5f;
                f15 = 5.6f;
                f13 = 1.2000003f;
            } else {
                if (d10 <= 7.0d) {
                    f12 = (f10 - 5.5f) / 1.5f;
                    f15 = 6.8f;
                    f13 = 0.19999981f;
                }
                f11 = f10 / 10.0f;
            }
            f14 = f12 * f13;
            f10 = f14 + f15;
            f11 = f10 / 10.0f;
        } else {
            f11 = 0.1f;
        }
        c0639a.setFloatOnDraw(i10, f11);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void b(float f10) {
        this.f42940g = f10;
        C0639a c0639a = this.f42937d;
        c0639a.setFloatOnDraw(c0639a.f42954b, f10 / 3.0f);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void c(float f10) {
        this.f42941h = f10;
        C0639a c0639a = this.f42937d;
        c0639a.setFloatOnDraw(c0639a.f42955c, (f10 / 10.0f) / 2.0f);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final boolean canBeSkipped() {
        return isLessOrEqualZero(this.f42939f) && isLessOrEqualZero(this.f42940g) && isLessOrEqualZero(this.f42941h) && isLessOrEqualZero(this.f42942i);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void d(float f10) {
        float f11 = f10 / 1.5f;
        this.f42942i = f11;
        this.f42938e.a(f11);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onDraw(int i10, com.tencent.liteav.videobase.frame.d dVar, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        FloatBuffer floatBuffer3;
        FloatBuffer floatBuffer4;
        int i11;
        int a10;
        FloatBuffer floatBuffer5;
        FloatBuffer floatBuffer6;
        if (isInitialized()) {
            runPendingOnDrawTasks();
            float f10 = this.f42939f;
            com.tencent.liteav.videobase.frame.d dVar2 = null;
            if (f10 > 0.0f || this.f42940g > 0.0f || this.f42941h > 0.0f) {
                if (f10 != 0.0f) {
                    com.tencent.liteav.videobase.frame.e eVar = this.mTexturePool;
                    Size size = this.mOutputSize;
                    dVar2 = eVar.a(size.width, size.height);
                    this.f42936c.onDraw(i10, dVar2, floatBuffer, floatBuffer2);
                    i11 = dVar2.a();
                    floatBuffer4 = this.f42934a;
                    floatBuffer3 = this.f42935b;
                } else {
                    floatBuffer3 = floatBuffer2;
                    floatBuffer4 = floatBuffer;
                    i11 = i10;
                }
                com.tencent.liteav.videobase.frame.e eVar2 = this.mTexturePool;
                Size size2 = this.mOutputSize;
                com.tencent.liteav.videobase.frame.d a11 = eVar2.a(size2.width, size2.height);
                this.f42937d.a("inputImageTexture2", i10);
                if (this.f42942i > 0.0f) {
                    this.f42937d.onDraw(i11, a11, floatBuffer4, floatBuffer3);
                } else {
                    this.f42937d.onDraw(i11, dVar, floatBuffer4, floatBuffer3);
                }
                a10 = a11.a();
                floatBuffer5 = this.f42934a;
                floatBuffer6 = this.f42935b;
                if (dVar2 != null) {
                    dVar2.release();
                }
                dVar2 = a11;
            } else {
                floatBuffer6 = floatBuffer2;
                floatBuffer5 = floatBuffer;
                a10 = i10;
            }
            if (this.f42942i > 0.0f || a10 == i10) {
                this.f42938e.onDraw(a10, dVar, floatBuffer5, floatBuffer6);
            }
            if (dVar2 != null) {
                dVar2.release();
            }
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        this.f42936c.initialize(eVar);
        this.f42937d.initialize(eVar);
        this.f42938e.initialize(eVar);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onOutputSizeChanged(int i10, int i11) {
        super.onOutputSizeChanged(i10, i11);
        this.f42937d.onOutputSizeChanged(i10, i11);
        this.f42936c.onOutputSizeChanged(i10, i11);
        this.f42938e.onOutputSizeChanged(i10, i11);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onUninit() {
        super.onUninit();
        this.f42937d.uninitialize();
        this.f42936c.uninitialize();
        this.f42938e.uninitialize();
    }
}
