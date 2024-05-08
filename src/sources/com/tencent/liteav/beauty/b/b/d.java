package com.tencent.liteav.beauty.b.b;

import android.opengl.GLES20;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.beauty.NativeLoad;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d extends com.tencent.liteav.videobase.a.b {

    /* renamed from: a, reason: collision with root package name */
    private int f42987a;

    /* renamed from: b, reason: collision with root package name */
    private int f42988b;

    public d() {
        super(null, null);
        this.f42987a = -1;
        this.f42988b = -1;
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final int buildProgram() {
        return NativeLoad.nativeLoadGLProgram(13);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        this.f42987a = GLES20.glGetUniformLocation(getProgramId(), "texelWidthOffset");
        this.f42988b = GLES20.glGetUniformLocation(getProgramId(), "texelHeightOffset");
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onOutputSizeChanged(int i10, int i11) {
        super.onOutputSizeChanged(i10, i11);
        float f10 = 2.0f;
        if (i10 <= i11 ? i10 >= 540 : i11 >= 540) {
            f10 = 4.0f;
        }
        LiteavLog.i("SmoothHorizontal", "m_textureRation ".concat(String.valueOf(f10)));
        setFloatOnDraw(this.f42987a, f10 / i10);
        setFloatOnDraw(this.f42988b, f10 / i11);
    }
}
