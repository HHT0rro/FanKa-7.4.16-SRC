package com.tencent.liteav.videobase.b;

import android.opengl.GLES20;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e extends f {

    /* renamed from: a, reason: collision with root package name */
    private final FloatBuffer f43286a;

    /* renamed from: b, reason: collision with root package name */
    private int f43287b;

    public e(String str) {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\nattribute vec4 inputTextureCoordinate3;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvarying vec2 textureCoordinate3;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n    textureCoordinate3 = inputTextureCoordinate3.xy;\n}", str);
    }

    @Override // com.tencent.liteav.videobase.b.f, com.tencent.liteav.videobase.a.j, com.tencent.liteav.videobase.a.b
    public void afterDrawArrays() {
        super.afterDrawArrays();
        int i10 = this.f43287b;
        if (i10 != -1) {
            GLES20.glDisableVertexAttribArray(i10);
        }
    }

    @Override // com.tencent.liteav.videobase.b.f, com.tencent.liteav.videobase.a.j, com.tencent.liteav.videobase.a.b
    public void beforeDrawArrays(int i10) {
        super.beforeDrawArrays(i10);
        int i11 = this.f43287b;
        if (i11 != -1) {
            GLES20.glVertexAttribPointer(i11, 2, 5126, false, 0, (Buffer) this.f43286a);
            GLES20.glEnableVertexAttribArray(this.f43287b);
        }
    }

    @Override // com.tencent.liteav.videobase.b.f, com.tencent.liteav.videobase.a.b
    public void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(null);
        this.f43287b = GLES20.glGetAttribLocation(getProgramId(), "inputTextureCoordinate3");
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onOutputSizeChanged(int i10, int i11) {
        super.onOutputSizeChanged(i10, i11);
    }

    public e(String str, String str2) {
        super(str, str2);
        this.f43286a = OpenGlUtils.createTextureCoordsBuffer(Rotation.NORMAL, false, false);
    }
}
