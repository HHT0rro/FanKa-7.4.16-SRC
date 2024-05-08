package com.tencent.liteav.videobase.b;

import android.opengl.GLES20;
import com.tencent.liteav.base.util.Rotation;
import com.tencent.liteav.videobase.a.j;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class f extends j {

    /* renamed from: a, reason: collision with root package name */
    private final FloatBuffer f43288a;

    /* renamed from: b, reason: collision with root package name */
    private int f43289b;

    public f(String str) {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n}", str);
    }

    @Override // com.tencent.liteav.videobase.a.j, com.tencent.liteav.videobase.a.b
    public void afterDrawArrays() {
        super.afterDrawArrays();
        int i10 = this.f43289b;
        if (i10 != -1) {
            GLES20.glDisableVertexAttribArray(i10);
        }
    }

    @Override // com.tencent.liteav.videobase.a.j, com.tencent.liteav.videobase.a.b
    public void beforeDrawArrays(int i10) {
        super.beforeDrawArrays(i10);
        int i11 = this.f43289b;
        if (i11 != -1) {
            GLES20.glVertexAttribPointer(i11, 2, 5126, false, 0, (Buffer) this.f43288a);
            GLES20.glEnableVertexAttribArray(this.f43289b);
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        this.f43289b = GLES20.glGetAttribLocation(getProgramId(), "inputTextureCoordinate2");
    }

    public f(String str, String str2) {
        super(str, str2);
        this.f43289b = -1;
        this.f43288a = OpenGlUtils.createTextureCoordsBuffer(Rotation.NORMAL, false, false);
    }
}
