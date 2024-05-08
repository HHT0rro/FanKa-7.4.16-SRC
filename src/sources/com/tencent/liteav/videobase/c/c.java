package com.tencent.liteav.videobase.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c extends i {
    public c() {
        super(com.tencent.liteav.videobase.a.b.NO_FILTER_VERTEX_SHADER, "varying highp vec2 textureCoordinate;\n\nuniform sampler2D yTexture;\nuniform sampler2D uvTexture;\nmediump mat3 colorConversionMatrix = mat3(       1.164,  1.164, 1.164,\n       1.596, -0.813,   0.0,\n         0.0, -0.392, 2.017\n);\nvoid main()\n{\n    mediump vec3 yuv;\n    lowp vec3 rgb;\n\n    yuv.x = texture2D(yTexture, textureCoordinate).r - (16.0/255.0);\n    yuv.y = texture2D(uvTexture, textureCoordinate).a - 0.5;\n    yuv.z = texture2D(uvTexture, textureCoordinate).r - 0.5;\n    rgb = colorConversionMatrix * yuv;\n\n    gl_FragColor = vec4(rgb, 1.0);\n}");
    }

    @Override // com.tencent.liteav.videobase.c.i
    public final int a() {
        return 6410;
    }
}
