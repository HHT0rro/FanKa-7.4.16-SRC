package com.tencent.liteav.beauty.b.b;

import android.opengl.GLES20;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.liteav.videobase.b.f;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e extends f {

    /* renamed from: a, reason: collision with root package name */
    public int f42989a;

    /* renamed from: b, reason: collision with root package name */
    public float f42990b;

    /* renamed from: c, reason: collision with root package name */
    private int f42991c;

    /* renamed from: d, reason: collision with root package name */
    private int f42992d;

    public e() {
        super(null, null);
        this.f42991c = -1;
        this.f42992d = -1;
        this.f42989a = -1;
        this.f42990b = 0.0f;
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final int buildProgram() {
        if (LiteavSystemInfo.getBrand().equals("samsung") && LiteavSystemInfo.getModel().equals("GT-I9500") && LiteavSystemInfo.getSystemOSVersion().equals("4.3")) {
            LiteavLog.d("SmoothVertical", "SAMSUNG_S4 GT-I9500 + Android 4.3; use diffrent shader!");
            return NativeLoad.nativeLoadGLProgram(15);
        }
        return NativeLoad.nativeLoadGLProgram(5);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final boolean canBeSkipped() {
        return isLessOrEqualZero(this.f42990b);
    }

    @Override // com.tencent.liteav.videobase.b.f, com.tencent.liteav.videobase.a.b
    public final void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        this.f42991c = GLES20.glGetUniformLocation(getProgramId(), "texelWidthOffset");
        this.f42992d = GLES20.glGetUniformLocation(getProgramId(), "texelHeightOffset");
        this.f42989a = GLES20.glGetUniformLocation(getProgramId(), "smoothDegree");
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onOutputSizeChanged(int i10, int i11) {
        super.onOutputSizeChanged(i10, i11);
        float f10 = 2.0f;
        if (i10 <= i11 ? i10 >= 540 : i11 >= 540) {
            f10 = 4.0f;
        }
        LiteavLog.i("SmoothVertical", "mTextureRation ".concat(String.valueOf(f10)));
        setFloatOnDraw(this.f42991c, f10 / i10);
        setFloatOnDraw(this.f42992d, f10 / i11);
    }
}
