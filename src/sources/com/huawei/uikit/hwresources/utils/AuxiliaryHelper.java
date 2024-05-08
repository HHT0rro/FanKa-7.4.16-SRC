package com.huawei.uikit.hwresources.utils;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.widget.TextView;
import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AuxiliaryHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final float f35229a = 8.0f;

    public static float getFontSize(@NonNull Context context) {
        return context.getResources().getConfiguration().fontScale;
    }

    public static float getSingleLineHeight(@NonNull TextView textView) {
        if (textView == null) {
            return 0.0f;
        }
        Paint.FontMetrics fontMetrics = textView.getPaint().getFontMetrics();
        return fontMetrics.bottom - fontMetrics.top;
    }

    public static boolean isAuxiliaryDevice(@NonNull Context context) {
        return HwWidgetInstantiator.getCurrentType(context) == 1;
    }

    public static boolean pointInView(Rect rect, float f10, float f11) {
        return rect != null && Float.compare(f10, -8.0f) >= 0 && Float.compare(f11, -8.0f) >= 0 && Float.compare(f10, ((float) (rect.right - rect.left)) + 8.0f) == -1 && Float.compare(f11, ((float) (rect.bottom - rect.top)) + 8.0f) == -1;
    }
}
