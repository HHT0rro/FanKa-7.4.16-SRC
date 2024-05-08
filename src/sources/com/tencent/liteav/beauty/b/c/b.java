package com.tencent.liteav.beauty.b.c;

import android.opengl.GLES20;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.liteav.videobase.frame.e;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b extends com.tencent.liteav.videobase.a.b {

    /* renamed from: a, reason: collision with root package name */
    private int f43001a;

    /* renamed from: b, reason: collision with root package name */
    private int f43002b;

    /* renamed from: c, reason: collision with root package name */
    private final float[] f43003c;

    public b() {
        super(null, null);
        this.f43001a = -1;
        this.f43002b = -1;
        this.f43003c = new float[]{0.5f, 0.0f, 0.0f, 0.0f};
    }

    public final void a(float f10) {
        float[] fArr = this.f43003c;
        fArr[0] = f10;
        a(fArr);
    }

    public final void b(float f10) {
        float[] fArr = this.f43003c;
        fArr[1] = f10;
        a(fArr);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final int buildProgram() {
        return NativeLoad.nativeLoadGLProgram(14);
    }

    public final void c(float f10) {
        float[] fArr = this.f43003c;
        fArr[2] = f10;
        a(fArr);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final boolean canBeSkipped() {
        return isLessOrEqualZero(this.f43003c[0]) && isLessOrEqualZero(this.f43003c[1]) && isLessOrEqualZero(this.f43003c[2]);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onInit(e eVar) {
        super.onInit(eVar);
        this.f43001a = GLES20.glGetUniformLocation(getProgramId(), "singleStepOffset");
        this.f43002b = GLES20.glGetUniformLocation(getProgramId(), "beautyParams");
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onOutputSizeChanged(int i10, int i11) {
        super.onOutputSizeChanged(i10, i11);
        setFloatVec2OnDraw(this.f43001a, new float[]{2.0f / i10, 2.0f / i11});
    }

    private void a(float[] fArr) {
        setFloatVec4OnDraw(this.f43002b, fArr);
    }
}
