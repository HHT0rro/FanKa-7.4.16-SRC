package com.android.internal.graphics.palette;

import com.google.android.material.shadow.ShadowDrawableWrapper;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class Contrast {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static float lighterY(float y10, float contrast) {
        float answer = ((5.0f + y10) * contrast) - 5.0f;
        if (answer > 100.0d) {
            return -1.0f;
        }
        return answer;
    }

    public static float darkerY(float y10, float contrast) {
        float answer = ((5.0f - (contrast * 5.0f)) + y10) / contrast;
        if (answer < ShadowDrawableWrapper.COS_45) {
            return -1.0f;
        }
        return answer;
    }

    public static float lstarToY(float lstar) {
        if (lstar > 8.0f) {
            return (float) (Math.pow((lstar + 16.0d) / 116.0d, 3.0d) * 100.0d);
        }
        return (float) ((lstar / 903.0f) * 100.0d);
    }

    public static float yToLstar(float y10) {
        float y11 = y10 / 100.0f;
        if (y11 <= 0.008856452f) {
            float y_intermediate = 903.2963f * y11;
            return y_intermediate;
        }
        float y_intermediate2 = (float) Math.cbrt(y11);
        return (116.0f * y_intermediate2) - 16.0f;
    }

    public static float contrastYs(float y1, float y22) {
        float lighter = Math.max(y1, y22);
        float darker = lighter == y1 ? y22 : y1;
        return (lighter + 5.0f) / (5.0f + darker);
    }
}
