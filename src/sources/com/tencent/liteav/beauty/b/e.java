package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.nio.FloatBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e extends com.tencent.liteav.videobase.a.b {

    /* renamed from: i, reason: collision with root package name */
    private int f43017i;

    /* renamed from: j, reason: collision with root package name */
    private int f43018j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f43019k;

    /* renamed from: h, reason: collision with root package name */
    private float f43016h = 4.0f;

    /* renamed from: a, reason: collision with root package name */
    private final FloatBuffer f43009a = OpenGlUtils.createNormalCubeVerticesBuffer();

    /* renamed from: b, reason: collision with root package name */
    private final FloatBuffer f43010b = OpenGlUtils.createTextureCoordsBuffer(Rotation.NORMAL, false, false);

    /* renamed from: c, reason: collision with root package name */
    private final com.tencent.liteav.beauty.b.c f43011c = new com.tencent.liteav.beauty.b.c();

    /* renamed from: e, reason: collision with root package name */
    private final c f43013e = new c();

    /* renamed from: f, reason: collision with root package name */
    private final a f43014f = new a("precision highp float;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvoid main()\n{\n    gl_FragColor = texture2D(inputImageTexture2, textureCoordinate2) - texture2D(inputImageTexture, textureCoordinate) * texture2D(inputImageTexture2, textureCoordinate2);\n}\n");

    /* renamed from: g, reason: collision with root package name */
    private final b f43015g = new b("precision highp float;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvarying vec2 textureCoordinate3;\nvoid main()\n{\n    gl_FragColor = texture2D(inputImageTexture, textureCoordinate) * texture2D(inputImageTexture3, textureCoordinate3) + texture2D(inputImageTexture2, textureCoordinate2);\n}\n");

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.liteav.videobase.a.b f43012d = new com.tencent.liteav.videobase.a.b();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a extends com.tencent.liteav.videobase.b.f {
        public a(String str) {
            super(str);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b extends com.tencent.liteav.videobase.b.e {
        public b(String str) {
            super(str);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class c extends com.tencent.liteav.videobase.b.f {

        /* renamed from: a, reason: collision with root package name */
        private int f43020a;

        /* renamed from: b, reason: collision with root package name */
        private int f43021b;

        public c() {
            super(null, null);
        }

        @Override // com.tencent.liteav.videobase.a.b
        public final int buildProgram() {
            return NativeLoad.nativeLoadGLProgram(2);
        }

        @Override // com.tencent.liteav.videobase.b.f, com.tencent.liteav.videobase.a.b
        public final void onInit(com.tencent.liteav.videobase.frame.e eVar) {
            super.onInit(eVar);
            this.f43020a = GLES20.glGetUniformLocation(getProgramId(), "texelWidthOffset");
            this.f43021b = GLES20.glGetUniformLocation(getProgramId(), "texelHeightOffset");
        }

        @Override // com.tencent.liteav.videobase.a.b
        public final void onOutputSizeChanged(int i10, int i11) {
            super.onOutputSizeChanged(i10, i11);
            setFloatOnDraw(this.f43020a, 1.5f / this.mOutputSize.width);
            setFloatOnDraw(this.f43021b, 1.5f / this.mOutputSize.height);
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onDraw(int i10, com.tencent.liteav.videobase.frame.d dVar, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        int a10;
        if (isInitialized()) {
            runPendingOnDrawTasks();
            com.tencent.liteav.videobase.frame.d dVar2 = null;
            int i11 = this.f43017i;
            Size size = this.mOutputSize;
            if (i11 == size.width && this.f43018j == size.height) {
                a10 = i10;
            } else {
                dVar2 = this.mTexturePool.a(i11, this.f43018j);
                GLES20.glViewport(0, 0, this.f43017i, this.f43018j);
                this.f43012d.onDraw(i10, dVar2, floatBuffer, floatBuffer2);
                a10 = dVar2.a();
            }
            com.tencent.liteav.videobase.frame.d a11 = this.mTexturePool.a(this.f43017i, this.f43018j);
            com.tencent.liteav.videobase.frame.d a12 = this.mTexturePool.a(this.f43017i, this.f43018j);
            this.f43011c.onDraw(a10, a11, this.f43009a, this.f43010b);
            this.f43013e.a("inputImageTexture2", a11.a());
            this.f43013e.onDraw(a10, a12, this.f43009a, this.f43010b);
            if (dVar2 != null) {
                dVar2.release();
            }
            com.tencent.liteav.videobase.frame.d a13 = this.mTexturePool.a(this.f43017i, this.f43018j);
            this.f43014f.a("inputImageTexture2", a11.a());
            this.f43014f.onDraw(a12.a(), a13, this.f43009a, this.f43010b);
            a11.release();
            com.tencent.liteav.videobase.frame.d a14 = this.mTexturePool.a(this.f43017i, this.f43018j);
            this.f43011c.onDraw(a12.a(), a14, this.f43009a, this.f43010b);
            a12.release();
            com.tencent.liteav.videobase.frame.d a15 = this.mTexturePool.a(this.f43017i, this.f43018j);
            this.f43011c.onDraw(a13.a(), a15, this.f43009a, this.f43010b);
            a13.release();
            if (this.f43016h != 1.0f) {
                com.tencent.liteav.videobase.frame.e eVar = this.mTexturePool;
                Size size2 = this.mOutputSize;
                com.tencent.liteav.videobase.frame.d a16 = eVar.a(size2.width, size2.height);
                com.tencent.liteav.videobase.frame.e eVar2 = this.mTexturePool;
                Size size3 = this.mOutputSize;
                com.tencent.liteav.videobase.frame.d a17 = eVar2.a(size3.width, size3.height);
                Size size4 = this.mOutputSize;
                GLES20.glViewport(0, 0, size4.width, size4.height);
                this.f43012d.onDraw(a14.a(), a16, this.f43009a, this.f43010b);
                this.f43012d.onDraw(a15.a(), a17, this.f43009a, this.f43010b);
                this.f43015g.a("inputImageTexture2", a17.a());
                this.f43015g.a("inputImageTexture3", i10);
                this.f43015g.onDraw(a16.a(), dVar, this.f43009a, this.f43010b);
                a16.release();
                a17.release();
            } else {
                this.f43015g.a("inputImageTexture2", a15.a());
                this.f43015g.a("inputImageTexture3", i10);
                this.f43015g.onDraw(a14.a(), dVar, this.f43009a, this.f43010b);
            }
            a15.release();
            a14.release();
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        this.f43011c.initialize(eVar);
        this.f43013e.initialize(eVar);
        this.f43014f.initialize(eVar);
        this.f43015g.initialize(eVar);
        this.f43012d.initialize(eVar);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onOutputSizeChanged(int i10, int i11) {
        super.onOutputSizeChanged(i10, i11);
        if (!this.f43019k) {
            if (i10 < i11) {
                if (i10 < 540) {
                    this.f43016h = 1.0f;
                } else {
                    this.f43016h = 4.0f;
                }
            } else if (i11 < 540) {
                this.f43016h = 1.0f;
            } else {
                this.f43016h = 4.0f;
            }
        }
        if (Float.compare(this.f43016h, 1.0f) == 0) {
            this.f43017i = i10;
            this.f43018j = i11;
        } else {
            float f10 = this.f43016h;
            this.f43017i = (int) (i10 / f10);
            this.f43018j = (int) (i11 / f10);
        }
        this.f43012d.onOutputSizeChanged(this.f43017i, this.f43018j);
        this.f43013e.onOutputSizeChanged(this.f43017i, this.f43018j);
        this.f43014f.onOutputSizeChanged(this.f43017i, this.f43018j);
        this.f43015g.onOutputSizeChanged(i10, i11);
        this.f43011c.onOutputSizeChanged(this.f43017i, this.f43018j);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onUninit() {
        super.onUninit();
        this.f43011c.uninitialize();
        this.f43013e.uninitialize();
        this.f43014f.uninitialize();
        this.f43015g.uninitialize();
        this.f43012d.uninitialize();
    }
}
