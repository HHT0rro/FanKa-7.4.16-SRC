package com.huawei.quickcard.exposure.extend;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class QuickCardAreaCalculator implements IQuickCardAreaCalculator {
    @Override // com.huawei.quickcard.exposure.extend.IQuickCardAreaCalculator
    public int getVisiblePercents(@NonNull View view) {
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return 0;
        }
        if ((rect.right <= 0 && rect.bottom <= 0) || !getVisibleRect(view, rect)) {
            return 0;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (width == 0 || height == 0) {
            return 0;
        }
        return ((rect.height() * rect.width()) * 100) / (height * width);
    }

    @Override // com.huawei.quickcard.exposure.extend.IQuickCardAreaCalculator
    public boolean getVisibleRect(@NonNull View view, @NonNull Rect rect) {
        return true;
    }
}
