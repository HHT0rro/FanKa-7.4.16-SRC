package com.huawei.quickcard.exposure;

import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.annotation.DoNotShrink;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IExposureSupport {
    void onAttachedToWindow();

    void onDetachedFromWindow();

    void onScreenStateChanged(int i10);

    void onVisibilityChanged(@NonNull View view, int i10);

    void setExposureManager(ExposureManager exposureManager);
}
