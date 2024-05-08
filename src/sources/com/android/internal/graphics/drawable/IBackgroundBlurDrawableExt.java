package com.android.internal.graphics.drawable;

import com.android.internal.graphics.drawable.BackgroundBlurDrawable;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IBackgroundBlurDrawableExt {
    default BackgroundBlurDrawable.BlurRegion[] sortBlurRegionsIfNeeded(BackgroundBlurDrawable.BlurRegion[] tmpBlurRegions) {
        return tmpBlurRegions;
    }

    default void setPackageName(String packageName) {
    }
}
