package com.alimm.tanx.core.utils;

import android.content.Context;
import android.content.res.Resources;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DimenUtil implements NotConfused {
    public static int dp2px(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float dpToPixel(float f10) {
        return f10 * Resources.getSystem().getDisplayMetrics().density;
    }

    public static float px2dp(Context context, int i10) {
        return (i10 / context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static int sp2px(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
