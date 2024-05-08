package com.huawei.uikit.hwresources.utils;

import android.content.Context;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HwWidgetCompat {
    public static final float AUXILIARY_FONT_SIZE_LARGE = 3.2f;
    public static final float AUXILIARY_FONT_SIZE_MEDIUM = 2.0f;
    public static final float AUXILIARY_FONT_SIZE_SMALL = 1.75f;

    public static Context wrapContext(@NonNull Context context, @AttrRes int i10, @StyleRes int i11) {
        return context.getTheme().resolveAttribute(i10, new TypedValue(), false) ? context : new ContextThemeWrapper(context, i11);
    }
}
