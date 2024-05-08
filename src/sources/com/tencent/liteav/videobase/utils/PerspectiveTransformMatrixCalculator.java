package com.tencent.liteav.videobase.utils;

import android.graphics.PointF;
import com.tencent.liteav.base.annotations.JNINamespace;
import java.util.List;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class PerspectiveTransformMatrixCalculator {
    public static float[] getPerspectiveTransformMatrix(List<PointF> list, List<PointF> list2) {
        return nativeGetPerspectiveTransformMatrix(e.a(list), e.a(list2));
    }

    public static native float[] nativeGetPerspectiveTransformMatrix(float[] fArr, float[] fArr2);
}
