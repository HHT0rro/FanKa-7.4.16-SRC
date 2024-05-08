package com.tencent.liteav.videobase.b;

import android.opengl.GLES20;
import com.tencent.liteav.videobase.base.GLConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b extends com.tencent.liteav.videobase.a.b {

    /* renamed from: a, reason: collision with root package name */
    public float[] f43278a;

    /* renamed from: b, reason: collision with root package name */
    private int f43279b;

    public b() {
        super(com.tencent.liteav.videobase.a.b.NO_FILTER_VERTEX_SHADER, "precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform mat3 matrix;\n\nvoid main()\n{\n  float cv_y = 1.0 - textureCoordinate.y;\n  float denominator = matrix[0][2] * textureCoordinate.x + matrix[1][2] * cv_y + matrix[2][2];\n  vec2 dst_coords;\n  dst_coords.x = matrix[0][0] * textureCoordinate.x + matrix[1][0] * cv_y + matrix[2][0];\n  dst_coords.y = matrix[0][1] * textureCoordinate.x + matrix[1][1] * cv_y + matrix[2][1];\n  dst_coords.x = dst_coords.x / denominator;\n  dst_coords.y = 1.0 - (dst_coords.y / denominator);\n  gl_FragColor = texture2D(inputImageTexture, dst_coords);\n}\n");
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void beforeDrawArrays(int i10) {
        super.beforeDrawArrays(i10);
        float[] fArr = this.f43278a;
        if (fArr == null) {
            fArr = GLConstants.f43290a;
        }
        GLES20.glUniformMatrix3fv(this.f43279b, 1, false, fArr, 0);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        this.f43279b = GLES20.glGetUniformLocation(getProgramId(), "matrix");
    }
}
