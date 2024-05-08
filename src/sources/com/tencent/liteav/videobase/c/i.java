package com.tencent.liteav.videobase.c;

import android.opengl.GLES20;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class i extends com.tencent.liteav.videobase.a.b {

    /* renamed from: a, reason: collision with root package name */
    public final GLConstants.ColorSpace f43354a;

    /* renamed from: b, reason: collision with root package name */
    public final GLConstants.ColorRange f43355b;

    /* renamed from: c, reason: collision with root package name */
    private int f43356c;

    /* renamed from: d, reason: collision with root package name */
    private final int[] f43357d;

    /* renamed from: e, reason: collision with root package name */
    private int f43358e;

    /* renamed from: f, reason: collision with root package name */
    private int f43359f;

    public i(String str, String str2, GLConstants.ColorRange colorRange, GLConstants.ColorSpace colorSpace) {
        super(str, str2);
        int[] iArr = new int[2];
        this.f43357d = iArr;
        this.f43358e = 0;
        this.f43359f = 0;
        Arrays.fill(iArr, -1);
        this.f43354a = colorSpace == GLConstants.ColorSpace.UNKNOWN ? GLConstants.ColorSpace.BT601 : colorSpace;
        this.f43355b = colorRange == GLConstants.ColorRange.UNKNOWN ? GLConstants.ColorRange.VIDEO_RANGE : colorRange;
    }

    private void b() {
        int i10 = 0;
        while (true) {
            int[] iArr = this.f43357d;
            if (i10 >= iArr.length) {
                return;
            }
            OpenGlUtils.deleteTexture(iArr[i10]);
            this.f43357d[i10] = -1;
            i10++;
        }
    }

    public abstract int a();

    public final void a(ByteBuffer byteBuffer, int i10, int i11) {
        if (this.f43358e != i10 || this.f43359f != i11) {
            b();
            this.f43358e = i10;
            this.f43359f = i11;
        }
        OpenGlUtils.loadYuv420DataToTextures(byteBuffer, a(), i10, i11, this.f43357d);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void beforeDrawArrays(int i10) {
        super.beforeDrawArrays(i10);
        GLES20.glActiveTexture(33985);
        OpenGlUtils.bindTexture(getTarget(), this.f43357d[1]);
        GLES20.glUniform1i(this.f43356c, 1);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onDraw(int i10, com.tencent.liteav.videobase.frame.d dVar, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        super.onDraw(this.f43357d[0], dVar, floatBuffer, floatBuffer2);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        this.f43356c = GLES20.glGetUniformLocation(getProgramId(), "uvTexture");
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onUninit() {
        b();
        super.onUninit();
    }

    public i(String str, String str2) {
        this(str, str2, GLConstants.ColorRange.VIDEO_RANGE, GLConstants.ColorSpace.BT601);
    }
}
