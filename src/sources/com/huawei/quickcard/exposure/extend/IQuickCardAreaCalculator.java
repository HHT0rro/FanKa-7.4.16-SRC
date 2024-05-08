package com.huawei.quickcard.exposure.extend;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IQuickCardAreaCalculator {
    int getVisiblePercents(@NonNull View view);

    boolean getVisibleRect(@NonNull View view, @NonNull Rect rect);
}
