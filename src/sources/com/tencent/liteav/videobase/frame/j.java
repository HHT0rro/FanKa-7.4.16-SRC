package com.tencent.liteav.videobase.frame;

import android.opengl.GLES20;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class j {

    /* renamed from: c, reason: collision with root package name */
    private static final float[] f43456c = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};

    /* renamed from: d, reason: collision with root package name */
    private static final float[] f43457d = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: e, reason: collision with root package name */
    private static final float[] f43458e = {1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};

    /* renamed from: f, reason: collision with root package name */
    private static final float[] f43459f = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    public int f43460a;

    /* renamed from: b, reason: collision with root package name */
    public int f43461b;

    /* renamed from: g, reason: collision with root package name */
    private final FloatBuffer f43462g;

    /* renamed from: h, reason: collision with root package name */
    private final FloatBuffer f43463h;

    /* renamed from: j, reason: collision with root package name */
    private GLConstants.GLScaleType f43465j;

    /* renamed from: n, reason: collision with root package name */
    private c f43469n;

    /* renamed from: i, reason: collision with root package name */
    private final com.tencent.liteav.videobase.a.b[] f43464i = new com.tencent.liteav.videobase.a.b[GLConstants.PixelFormatType.values().length];

    /* renamed from: k, reason: collision with root package name */
    private PixelFrame f43466k = null;

    /* renamed from: l, reason: collision with root package name */
    private com.tencent.liteav.videobase.b.a f43467l = null;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.liteav.videobase.a.b f43468m = null;

    /* renamed from: com.tencent.liteav.videobase.frame.j$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f43470a;

        static {
            int[] iArr = new int[Rotation.values().length];
            f43470a = iArr;
            try {
                iArr[Rotation.ROTATION_90.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43470a[Rotation.ROTATION_180.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f43470a[Rotation.ROTATION_270.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f43470a[Rotation.NORMAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public j(int i10, int i11) {
        this.f43460a = i10;
        this.f43461b = i11;
        float[] fArr = GLConstants.f43293d;
        this.f43462g = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr);
        this.f43463h = OpenGlUtils.createTextureCoordsBuffer(Rotation.NORMAL, false, false);
    }

    private static float a(float f10) {
        return f10 == 0.0f ? 1.0f : 0.0f;
    }

    private static float a(float f10, float f11) {
        return f10 == 0.0f ? f11 : 1.0f - f11;
    }

    private void b() {
        PixelFrame pixelFrame = this.f43466k;
        if (pixelFrame == null) {
            return;
        }
        boolean z10 = pixelFrame.getRotation() == Rotation.ROTATION_90 || this.f43466k.getRotation() == Rotation.ROTATION_270;
        float max = Math.max((this.f43460a * 1.0f) / this.f43466k.getWidth(), (this.f43461b * 1.0f) / this.f43466k.getHeight());
        float round = (Math.round(r2 * max) * 1.0f) / this.f43460a;
        float round2 = (Math.round(r5 * max) * 1.0f) / this.f43461b;
        float[] fArr = GLConstants.f43293d;
        float[] fArr2 = new float[8];
        if (this.f43466k.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_OES) {
            a(fArr2, this.f43466k.getRotation(), this.f43466k.isMirrorHorizontal(), this.f43466k.isMirrorVertical());
        } else {
            OpenGlUtils.initTextureCoordsBuffer(fArr2, this.f43466k.getRotation(), this.f43466k.isMirrorHorizontal(), this.f43466k.isMirrorVertical());
        }
        GLConstants.GLScaleType gLScaleType = this.f43465j;
        if (gLScaleType == GLConstants.GLScaleType.CENTER_CROP) {
            float f10 = (1.0f - (z10 ? 1.0f / round2 : 1.0f / round)) / 2.0f;
            float f11 = (1.0f - (z10 ? 1.0f / round : 1.0f / round2)) / 2.0f;
            fArr2[0] = a(fArr2[0], f10);
            fArr2[1] = a(fArr2[1], f11);
            fArr2[2] = a(fArr2[2], f10);
            fArr2[3] = a(fArr2[3], f11);
            fArr2[4] = a(fArr2[4], f10);
            fArr2[5] = a(fArr2[5], f11);
            fArr2[6] = a(fArr2[6], f10);
            fArr2[7] = a(fArr2[7], f11);
        } else if (gLScaleType == GLConstants.GLScaleType.FIT_CENTER) {
            fArr = new float[]{fArr[0] / round2, fArr[1] / round, fArr[2] / round2, fArr[3] / round, fArr[4] / round2, fArr[5] / round, fArr[6] / round2, fArr[7] / round};
        }
        this.f43462g.clear();
        this.f43462g.put(fArr).position(0);
        this.f43463h.clear();
        this.f43463h.put(fArr2).position(0);
    }

    private void c() {
        if (this.f43468m != null) {
            return;
        }
        com.tencent.liteav.videobase.a.b bVar = new com.tencent.liteav.videobase.a.b();
        this.f43468m = bVar;
        bVar.initialize(null);
    }

    private void d() {
        com.tencent.liteav.videobase.b.a aVar = this.f43467l;
        if (aVar != null) {
            aVar.uninitialize();
            this.f43467l = null;
        }
        com.tencent.liteav.videobase.a.b bVar = this.f43468m;
        if (bVar != null) {
            bVar.uninitialize();
            this.f43468m = null;
        }
        c cVar = this.f43469n;
        if (cVar != null) {
            cVar.d();
            this.f43469n = null;
        }
        int i10 = 0;
        while (true) {
            com.tencent.liteav.videobase.a.b[] bVarArr = this.f43464i;
            if (i10 < bVarArr.length) {
                if (bVarArr[i10] != null) {
                    bVarArr[i10].uninitialize();
                    this.f43464i[i10] = null;
                }
                i10++;
            } else {
                LiteavLog.i("PixelFrameRenderer", "uninitialize GL components");
                return;
            }
        }
    }

    public final void a(PixelFrame pixelFrame, GLConstants.GLScaleType gLScaleType, d dVar) {
        if (pixelFrame != null && pixelFrame.isFrameDataValid()) {
            if (this.f43466k == null || a(pixelFrame, gLScaleType)) {
                this.f43465j = gLScaleType;
                this.f43466k = new PixelFrame(pixelFrame);
                d();
                b();
            }
            if (gLScaleType == GLConstants.GLScaleType.FIT_CENTER) {
                a(dVar);
            }
            if (this.f43466k.getPixelBufferType() == GLConstants.PixelBufferType.BYTE_BUFFER) {
                if (this.f43466k.getPixelFormatType() != GLConstants.PixelFormatType.RGBA) {
                    a(this.f43466k.getPixelFormatType(), dVar, pixelFrame.getBuffer(), pixelFrame.getColorRange(), pixelFrame.getColorSpace());
                    return;
                } else {
                    a(dVar, pixelFrame.getBuffer());
                    return;
                }
            }
            if (this.f43466k.getPixelBufferType() == GLConstants.PixelBufferType.BYTE_ARRAY) {
                if (this.f43466k.getPixelFormatType() != GLConstants.PixelFormatType.RGBA) {
                    a(this.f43466k.getPixelFormatType(), dVar, ByteBuffer.wrap(pixelFrame.getData()), pixelFrame.getColorRange(), pixelFrame.getColorSpace());
                    return;
                } else {
                    a(dVar, ByteBuffer.wrap(pixelFrame.getData()));
                    return;
                }
            }
            if (this.f43466k.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_OES) {
                a(dVar, pixelFrame.getTextureId(), pixelFrame.getMatrix());
                return;
            } else {
                if (this.f43466k.getPixelBufferType() == GLConstants.PixelBufferType.TEXTURE_2D) {
                    a(dVar, pixelFrame.getTextureId());
                    return;
                }
                return;
            }
        }
        LiteavLog.w("PixelFrameRenderer", "renderFrame: pixelFrame is not valid");
    }

    public final void a(int i10, int i11) {
        if (this.f43460a == i10 && this.f43461b == i11) {
            return;
        }
        this.f43460a = i10;
        this.f43461b = i11;
        b();
    }

    public final void a() {
        this.f43466k = null;
        d();
    }

    private boolean a(PixelFrame pixelFrame, GLConstants.GLScaleType gLScaleType) {
        return (gLScaleType == this.f43465j && pixelFrame.getWidth() == this.f43466k.getWidth() && pixelFrame.getHeight() == this.f43466k.getHeight() && pixelFrame.getPixelBufferType() == this.f43466k.getPixelBufferType() && pixelFrame.getPixelFormatType() == this.f43466k.getPixelFormatType() && pixelFrame.isMirrorHorizontal() == this.f43466k.isMirrorHorizontal() && pixelFrame.isMirrorVertical() == this.f43466k.isMirrorVertical() && pixelFrame.getRotation() == this.f43466k.getRotation()) ? false : true;
    }

    private void a(d dVar, Buffer buffer) {
        int ordinal = GLConstants.PixelFormatType.RGBA.ordinal();
        com.tencent.liteav.videobase.a.b[] bVarArr = this.f43464i;
        if (bVarArr[ordinal] == null) {
            bVarArr[ordinal] = new com.tencent.liteav.videobase.b.d();
            this.f43464i[ordinal].initialize(null);
        }
        com.tencent.liteav.videobase.b.d dVar2 = (com.tencent.liteav.videobase.b.d) this.f43464i[ordinal];
        dVar2.onOutputSizeChanged(this.f43460a, this.f43461b);
        OpenGlUtils.glViewport(0, 0, this.f43460a, this.f43461b);
        if (this.f43466k.getRotation() != Rotation.ROTATION_90 && this.f43466k.getRotation() != Rotation.ROTATION_270) {
            dVar2.a(buffer, this.f43466k.getWidth(), this.f43466k.getHeight());
        } else {
            dVar2.a(buffer, this.f43466k.getHeight(), this.f43466k.getWidth());
        }
        dVar2.onDraw(-1, dVar, this.f43462g, this.f43463h);
    }

    private void a(GLConstants.PixelFormatType pixelFormatType, d dVar, ByteBuffer byteBuffer, GLConstants.ColorRange colorRange, GLConstants.ColorSpace colorSpace) {
        int ordinal = pixelFormatType.ordinal();
        com.tencent.liteav.videobase.a.b[] bVarArr = this.f43464i;
        if (bVarArr[ordinal] == null) {
            if (pixelFormatType == GLConstants.PixelFormatType.I420) {
                bVarArr[ordinal] = new com.tencent.liteav.videobase.c.a(colorRange, colorSpace);
            } else if (pixelFormatType == GLConstants.PixelFormatType.NV21) {
                bVarArr[ordinal] = new com.tencent.liteav.videobase.c.d();
            } else {
                bVarArr[ordinal] = new com.tencent.liteav.videobase.c.c();
            }
            this.f43464i[ordinal].initialize(null);
        }
        com.tencent.liteav.videobase.c.i iVar = (com.tencent.liteav.videobase.c.i) this.f43464i[ordinal];
        iVar.onOutputSizeChanged(this.f43460a, this.f43461b);
        OpenGlUtils.glViewport(0, 0, this.f43460a, this.f43461b);
        if (this.f43466k.getRotation() != Rotation.ROTATION_90 && this.f43466k.getRotation() != Rotation.ROTATION_270) {
            iVar.a(byteBuffer, this.f43466k.getWidth(), this.f43466k.getHeight());
        } else {
            iVar.a(byteBuffer, this.f43466k.getHeight(), this.f43466k.getWidth());
        }
        iVar.onDraw(-1, dVar, this.f43462g, this.f43463h);
    }

    private void a(d dVar, int i10, float[] fArr) {
        if (this.f43467l == null) {
            com.tencent.liteav.videobase.b.a aVar = new com.tencent.liteav.videobase.b.a();
            this.f43467l = aVar;
            aVar.initialize(null);
        }
        OpenGlUtils.glViewport(0, 0, this.f43460a, this.f43461b);
        this.f43467l.setTextureTransform(fArr);
        this.f43467l.onOutputSizeChanged(this.f43460a, this.f43461b);
        this.f43467l.onDraw(i10, dVar, this.f43462g, this.f43463h);
    }

    private void a(d dVar, int i10) {
        c();
        OpenGlUtils.glViewport(0, 0, this.f43460a, this.f43461b);
        this.f43468m.onOutputSizeChanged(this.f43460a, this.f43461b);
        this.f43468m.onDraw(i10, dVar, this.f43462g, this.f43463h);
    }

    private void a(d dVar) {
        if (this.f43469n == null) {
            c cVar = new c();
            this.f43469n = cVar;
            cVar.a();
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        if (dVar == null) {
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glClear(16640);
            return;
        }
        this.f43469n.a(dVar.a());
        this.f43469n.b();
        GLES20.glClear(16640);
        OpenGlUtils.bindFramebuffer(36160, 0);
        this.f43469n.c();
    }

    private static void a(float[] fArr, Rotation rotation, boolean z10, boolean z11) {
        float[] fArr2 = f43456c;
        if (rotation != null) {
            int i10 = AnonymousClass1.f43470a[rotation.ordinal()];
            if (i10 == 1) {
                fArr2 = f43457d;
            } else if (i10 == 2) {
                fArr2 = f43459f;
            } else if (i10 == 3) {
                fArr2 = f43458e;
            }
        }
        System.arraycopy((Object) fArr2, 0, (Object) fArr, 0, fArr2.length);
        if (z10) {
            fArr[0] = a(fArr[0]);
            fArr[2] = a(fArr[2]);
            fArr[4] = a(fArr[4]);
            fArr[6] = a(fArr[6]);
        }
        if (z11) {
            fArr[1] = a(fArr[1]);
            fArr[3] = a(fArr[3]);
            fArr[5] = a(fArr[5]);
            fArr[7] = a(fArr[7]);
        }
    }
}
