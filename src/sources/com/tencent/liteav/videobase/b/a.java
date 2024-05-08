package com.tencent.liteav.videobase.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a extends com.tencent.liteav.videobase.a.b {
    public a() {
        super(com.tencent.liteav.videobase.a.b.NO_FILTER_VERTEX_SHADER, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying highp vec2 textureCoordinate;\nuniform samplerExternalOES inputImageTexture;\nvoid main()\n{\n   gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final int getTarget() {
        return 36197;
    }
}
