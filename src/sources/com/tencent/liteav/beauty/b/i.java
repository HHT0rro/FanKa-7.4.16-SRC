package com.tencent.liteav.beauty.b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.nio.FloatBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class i extends com.tencent.liteav.videobase.a.b {

    /* renamed from: a, reason: collision with root package name */
    public Bitmap f43040a;

    /* renamed from: b, reason: collision with root package name */
    public int f43041b;

    /* renamed from: c, reason: collision with root package name */
    public Bitmap f43042c;

    /* renamed from: d, reason: collision with root package name */
    public int f43043d;

    /* renamed from: e, reason: collision with root package name */
    public final FloatBuffer f43044e;

    /* renamed from: f, reason: collision with root package name */
    public final FloatBuffer f43045f;

    /* renamed from: g, reason: collision with root package name */
    private int f43046g;

    /* renamed from: h, reason: collision with root package name */
    private int f43047h;

    /* renamed from: i, reason: collision with root package name */
    private int f43048i;

    /* renamed from: j, reason: collision with root package name */
    private int f43049j;

    public i() {
        super(com.tencent.liteav.videobase.a.b.NO_FILTER_VERTEX_SHADER, "varying highp vec2 textureCoordinate;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2; // lookup texture 1\nuniform sampler2D inputImageTexture3; // lookup texture 2\n\n\nuniform lowp vec3 v3_params;\nuniform lowp vec2 v2_texs;\n\n\nvoid main()\n{\n    lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n\n    mediump float blueColor = textureColor.b * 63.0;\n\n    mediump vec2 quad1;\n    quad1.y = floor(floor(blueColor) / 8.0);\n    quad1.x = floor(blueColor) - (quad1.y * 8.0);\n\n    mediump vec2 quad2;\n    quad2.y = floor(ceil(blueColor) / 8.0);\n    quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n\n    highp vec2 texPos1;\n    texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n    texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n\n    highp vec2 texPos2;\n    texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n    texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n\n    lowp vec4 newColor1;\n    lowp vec4 newColor2;\n    if(textureCoordinate.x <= v3_params.x) { \n      if(v2_texs.x == 1.0) { \n        newColor1 = texture2D(inputImageTexture2, texPos1);\n        newColor2 = texture2D(inputImageTexture2, texPos2);\n        lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n        gl_FragColor = mix(textureColor, vec4(newColor.rgb, textureColor.w), v3_params.y);\n      } else { \n        gl_FragColor = textureColor;\n      } \n    } else {\n      if(v2_texs.y == 1.0) { \n        newColor1 = texture2D(inputImageTexture3, texPos1);\n        newColor2 = texture2D(inputImageTexture3, texPos2);\n        lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n        gl_FragColor = mix(textureColor, vec4(newColor.rgb, textureColor.w), v3_params.z);\n      } else { \n        gl_FragColor = textureColor;\n      } \n    }\n }");
        this.f43040a = null;
        this.f43041b = -1;
        this.f43042c = null;
        this.f43043d = -1;
        this.f43044e = FloatBuffer.allocate(3);
        this.f43045f = FloatBuffer.allocate(2);
    }

    public final void a(float f10, Bitmap bitmap, float f11, Bitmap bitmap2, float f12) {
        runOnDraw(j.a(this, f10, f11, f12, bitmap, bitmap2));
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void afterDrawArrays() {
        super.afterDrawArrays();
        if (this.f43041b != -1) {
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(3553, 0);
        }
        if (this.f43043d != -1) {
            GLES20.glActiveTexture(33988);
            GLES20.glBindTexture(3553, 0);
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void beforeDrawArrays(int i10) {
        super.beforeDrawArrays(i10);
        if (this.f43041b != -1) {
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(3553, this.f43041b);
            GLES20.glUniform1i(this.f43046g, 3);
        }
        if (this.f43043d != -1) {
            GLES20.glActiveTexture(33988);
            GLES20.glBindTexture(3553, this.f43043d);
            GLES20.glUniform1i(this.f43047h, 4);
        }
        GLES20.glUniform2fv(this.f43049j, 1, this.f43045f);
        GLES20.glUniform3fv(this.f43048i, 1, this.f43044e);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        this.f43046g = GLES20.glGetUniformLocation(getProgramId(), "inputImageTexture2");
        this.f43047h = GLES20.glGetUniformLocation(getProgramId(), "inputImageTexture3");
        this.f43048i = GLES20.glGetUniformLocation(getProgramId(), "v3_params");
        this.f43049j = GLES20.glGetUniformLocation(getProgramId(), "v2_texs");
        if (this.f43040a == null && this.f43042c == null) {
            return;
        }
        a(this.f43044e.get(0), this.f43040a, this.f43044e.get(1), this.f43042c, this.f43044e.get(2));
        this.f43040a = null;
        this.f43042c = null;
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onUninit() {
        super.onUninit();
        OpenGlUtils.deleteTexture(this.f43041b);
        OpenGlUtils.deleteTexture(this.f43043d);
        this.f43041b = -1;
        this.f43043d = -1;
    }
}
