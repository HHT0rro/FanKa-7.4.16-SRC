package com.huawei.flexiblelayout.css.adapter.value.integrate.tint;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class DrawableTintWrap implements ITintWrapper {
    @Override // com.huawei.flexiblelayout.css.adapter.value.integrate.tint.ITintWrapper
    public void setTint(Drawable drawable, Object obj) {
        if (drawable == null || obj == null) {
            return;
        }
        if (obj instanceof Integer) {
            DrawableCompat.setTint(drawable, ((Integer) obj).intValue());
        } else {
            DrawableCompat.setTintList(drawable, (ColorStateList) obj);
        }
    }
}
