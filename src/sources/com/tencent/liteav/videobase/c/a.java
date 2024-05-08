package com.tencent.liteav.videobase.c;

import android.opengl.GLES20;
import com.huawei.quickcard.base.Attributes;
import com.tencent.liteav.videobase.base.GLConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a extends i {

    /* renamed from: c, reason: collision with root package name */
    private static final float[] f43344c = {1.1644f, 1.1644f, 1.1644f, 0.0f, -0.3918f, 2.0172f, 1.596f, -0.813f, 0.0f};

    /* renamed from: d, reason: collision with root package name */
    private static final float[] f43345d = {1.0f, 1.0f, 1.0f, 0.0f, -0.3441f, 1.772f, 1.402f, -0.7141f, 0.0f};

    /* renamed from: e, reason: collision with root package name */
    private static final float[] f43346e = {1.1644f, 1.1644f, 1.1644f, 0.0f, -0.2132f, 2.1124f, 1.7927f, -0.5329f, 0.0f};

    /* renamed from: f, reason: collision with root package name */
    private static final float[] f43347f = {1.0f, 1.0f, 1.0f, 0.0f, -0.1873f, 1.8556f, 1.5748f, -0.4681f, 0.0f};

    /* renamed from: g, reason: collision with root package name */
    private static final float[] f43348g = {-0.0627451f, -0.5019608f, -0.5019608f};

    /* renamed from: h, reason: collision with root package name */
    private static final float[] f43349h = {0.0f, -0.5019608f, -0.5019608f};

    /* renamed from: i, reason: collision with root package name */
    private int f43350i;

    /* renamed from: j, reason: collision with root package name */
    private int f43351j;

    /* renamed from: com.tencent.liteav.videobase.c.a$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f43352a;

        static {
            int[] iArr = new int[GLConstants.ColorRange.values().length];
            f43352a = iArr;
            try {
                iArr[GLConstants.ColorRange.FULL_RANGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43352a[GLConstants.ColorRange.UNKNOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f43352a[GLConstants.ColorRange.VIDEO_RANGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public a(GLConstants.ColorRange colorRange, GLConstants.ColorSpace colorSpace) {
        super(com.tencent.liteav.videobase.a.b.NO_FILTER_VERTEX_SHADER, "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D uvTexture;\nuniform mat3 convertMatrix;\nuniform vec3 offset;\n\nvoid main()\n{\n    highp vec3 yuvColor;\n    highp vec3 rgbColor;\n\n    // Get the YUV values\n    yuvColor.x = texture2D(inputImageTexture, textureCoordinate).r;\n    yuvColor.y = texture2D(uvTexture, vec2(textureCoordinate.x, textureCoordinate.y * 0.5)).r;\n    yuvColor.z = texture2D(uvTexture, vec2(textureCoordinate.x, textureCoordinate.y * 0.5 + 0.5)).r;\n\n    // Do the color transform\n    yuvColor += offset;\n    rgbColor = convertMatrix * yuvColor;\n\n    gl_FragColor = vec4(rgbColor, 1.0);\n}", colorRange, colorSpace);
    }

    public static /* synthetic */ void a(a aVar) {
        float[] fArr;
        float[] fArr2;
        GLES20.glUseProgram(aVar.getProgramId());
        int i10 = aVar.f43351j;
        if (AnonymousClass1.f43352a[aVar.f43355b.ordinal()] != 1) {
            fArr = f43348g;
        } else {
            fArr = f43349h;
        }
        GLES20.glUniform3fv(i10, 1, fArr, 0);
        int i11 = aVar.f43350i;
        GLConstants.ColorSpace colorSpace = aVar.f43354a;
        if (colorSpace == null || colorSpace == GLConstants.ColorSpace.UNKNOWN) {
            colorSpace = GLConstants.ColorSpace.BT601;
        }
        GLConstants.ColorRange colorRange = aVar.f43355b;
        if (colorRange == null || colorRange == GLConstants.ColorRange.UNKNOWN) {
            colorRange = GLConstants.ColorRange.VIDEO_RANGE;
        }
        if (colorSpace == GLConstants.ColorSpace.BT601) {
            if (colorRange != GLConstants.ColorRange.VIDEO_RANGE && colorRange == GLConstants.ColorRange.FULL_RANGE) {
                fArr2 = f43345d;
            }
            fArr2 = f43344c;
        } else {
            if (colorSpace == GLConstants.ColorSpace.BT709) {
                if (colorRange == GLConstants.ColorRange.VIDEO_RANGE) {
                    fArr2 = f43346e;
                } else if (colorRange == GLConstants.ColorRange.FULL_RANGE) {
                    fArr2 = f43347f;
                }
            }
            fArr2 = f43344c;
        }
        GLES20.glUniformMatrix3fv(i11, 1, false, fArr2, 0);
    }

    @Override // com.tencent.liteav.videobase.c.i
    public final int a() {
        return 6409;
    }

    @Override // com.tencent.liteav.videobase.c.i, com.tencent.liteav.videobase.a.b
    public final void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        this.f43350i = GLES20.glGetUniformLocation(getProgramId(), "convertMatrix");
        this.f43351j = GLES20.glGetUniformLocation(getProgramId(), Attributes.Style.OFFSET);
        runOnDraw(b.a(this));
    }
}
