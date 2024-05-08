package com.huawei.flexiblelayout.services.exposure;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class VisibleAreaCalculator {
    private static int a(View view) {
        if (view == null || view.getVisibility() != 0) {
            return 0;
        }
        return view.getHeight();
    }

    private static int b(View view) {
        if (view == null || view.getVisibility() != 0) {
            return 0;
        }
        return view.getWidth();
    }

    public int calculateVisiblePercents(@NonNull View view) {
        int a10 = a(view) * b(view);
        if (a10 <= 0) {
            return 0;
        }
        Rect rect = new Rect();
        if (getGlobalVisibleRect(view, rect) && !a(rect)) {
            return (int) (((rect.height() * rect.width()) * 100) / a10);
        }
        return 0;
    }

    public boolean getGlobalVisibleRect(@NonNull View view, @NonNull Rect rect) {
        return view.getGlobalVisibleRect(rect);
    }

    private static boolean a(Rect rect) {
        if (rect.width() == 0 || rect.height() == 0) {
            return true;
        }
        if (rect.bottom > 0 || rect.top > 0) {
            return rect.left <= 0 && rect.right <= 0;
        }
        return true;
    }
}
