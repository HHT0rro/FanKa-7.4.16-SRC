package com.jd.ad.sdk.jad_te;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class jad_bo {
    public static Drawable jad_an(Context context, Context context2, @DrawableRes int i10, @Nullable Resources.Theme theme) {
        if (theme == null) {
            theme = context2.getTheme();
        }
        return ResourcesCompat.getDrawable(context2.getResources(), i10, theme);
    }
}
