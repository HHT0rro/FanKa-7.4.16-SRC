package com.huawei.uikit.hwcommon.utils;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.appgallery.agd.agdpro.R$style;
import com.huawei.appgallery.agd.agdpro.R$styleable;
import com.huawei.uikit.hwcommon.drawable.HwAnimatedGradientDrawable;
import com.huawei.uikit.hwcommon.widget.HwClickEffectEntry;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HwWidgetUtils {
    public static HwClickEffectEntry getClickEffectEntry(@NonNull Context context, int i10) {
        return getClickEffectEntry(context, null, i10);
    }

    @Nullable
    public static HwAnimatedGradientDrawable getHwAnimatedGradientDrawable(Context context, HwClickEffectEntry hwClickEffectEntry) {
        if (context == null || hwClickEffectEntry == null) {
            return null;
        }
        HwAnimatedGradientDrawable hwAnimatedGradientDrawable = new HwAnimatedGradientDrawable(context);
        hwAnimatedGradientDrawable.setColor(hwClickEffectEntry.getClickEffectColor());
        hwAnimatedGradientDrawable.setMaxRectAlpha(hwClickEffectEntry.getClickEffectAlpha());
        hwAnimatedGradientDrawable.setMinRectScale(hwClickEffectEntry.getClickEffectMinRecScale());
        hwAnimatedGradientDrawable.setMaxRectScale(hwClickEffectEntry.getClickEffectMaxRecScale());
        hwAnimatedGradientDrawable.setForceDoScaleAnim(hwClickEffectEntry.isClickEffectForceDoScaleAnim());
        hwAnimatedGradientDrawable.setCornerRadius(hwClickEffectEntry.getClickEffectCornerRadius());
        return hwAnimatedGradientDrawable;
    }

    public static HwClickEffectEntry getClickEffectEntry(@NonNull Context context, AttributeSet attributeSet, int i10) {
        HwClickEffectEntry hwClickEffectEntry = new HwClickEffectEntry();
        Resources.Theme theme = context.getTheme();
        if (theme != null) {
            TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R$styleable.HwClickEffect, i10, R$style.Widget_Emui_HwClickEffectStyle_Light);
            hwClickEffectEntry.setClickEffectColor(obtainStyledAttributes.getColor(R$styleable.HwClickEffect_hwClickEffectColor, hwClickEffectEntry.getClickEffectColor()));
            hwClickEffectEntry.setClickEffectAlpha(obtainStyledAttributes.getFloat(R$styleable.HwClickEffect_hwClickEffectAlpha, hwClickEffectEntry.getClickEffectAlpha()));
            hwClickEffectEntry.setClickEffectMinRecScale(obtainStyledAttributes.getFloat(R$styleable.HwClickEffect_hwClickEffectMinRecScale, hwClickEffectEntry.getClickEffectMinRecScale()));
            hwClickEffectEntry.setClickEffectMaxRecScale(obtainStyledAttributes.getFloat(R$styleable.HwClickEffect_hwClickEffectMaxRecScale, hwClickEffectEntry.getClickEffectMaxRecScale()));
            hwClickEffectEntry.setClickEffectCornerRadius(obtainStyledAttributes.getDimension(R$styleable.HwClickEffect_hwClickEffectCornerRadius, hwClickEffectEntry.getClickEffectCornerRadius()));
            hwClickEffectEntry.setIsClickEffectForceDoScaleAnim(obtainStyledAttributes.getBoolean(R$styleable.HwClickEffect_hwClickEffectForceDoScaleAnim, hwClickEffectEntry.isClickEffectForceDoScaleAnim()));
            obtainStyledAttributes.recycle();
        }
        return hwClickEffectEntry;
    }

    public static HwAnimatedGradientDrawable getHwAnimatedGradientDrawable(@NonNull Context context, int i10) {
        return getHwAnimatedGradientDrawable(context, getClickEffectEntry(context, i10));
    }
}
