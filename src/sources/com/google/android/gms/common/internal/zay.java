package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.gms.base.R$color;
import com.google.android.gms.base.R$drawable;
import com.google.android.gms.base.R$string;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class zay extends Button {
    public zay(Context context) {
        this(context, null);
    }

    public static int a(int i10, int i11, int i12, int i13) {
        if (i10 == 0) {
            return i11;
        }
        if (i10 == 1) {
            return i12;
        }
        if (i10 == 2) {
            return i13;
        }
        StringBuilder sb2 = new StringBuilder(33);
        sb2.append("Unknown color scheme: ");
        sb2.append(i10);
        throw new IllegalStateException(sb2.toString());
    }

    public final void b(Resources resources, int i10, int i11) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        int i12 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
        setMinHeight(i12);
        setMinWidth(i12);
        int i13 = R$drawable.common_google_signin_btn_icon_dark;
        int i14 = R$drawable.common_google_signin_btn_icon_light;
        int a10 = a(i11, i13, i14, i14);
        int i15 = R$drawable.common_google_signin_btn_text_dark;
        int i16 = R$drawable.common_google_signin_btn_text_light;
        int a11 = a(i11, i15, i16, i16);
        if (i10 == 0 || i10 == 1) {
            a10 = a11;
        } else if (i10 != 2) {
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append("Unknown button size: ");
            sb2.append(i10);
            throw new IllegalStateException(sb2.toString());
        }
        Drawable wrap = DrawableCompat.wrap(resources.getDrawable(a10));
        DrawableCompat.setTintList(wrap, resources.getColorStateList(R$color.common_google_signin_btn_tint));
        DrawableCompat.setTintMode(wrap, PorterDuff.Mode.SRC_ATOP);
        setBackgroundDrawable(wrap);
        int i17 = R$color.common_google_signin_btn_text_dark;
        int i18 = R$color.common_google_signin_btn_text_light;
        setTextColor((ColorStateList) h.h(resources.getColorStateList(a(i11, i17, i18, i18))));
        if (i10 == 0) {
            setText(resources.getString(R$string.common_signin_button_text));
        } else if (i10 == 1) {
            setText(resources.getString(R$string.common_signin_button_text_long));
        } else if (i10 == 2) {
            setText((CharSequence) null);
        } else {
            StringBuilder sb3 = new StringBuilder(32);
            sb3.append("Unknown button size: ");
            sb3.append(i10);
            throw new IllegalStateException(sb3.toString());
        }
        setTransformationMethod(null);
        if (b7.g.c(getContext())) {
            setGravity(19);
        }
    }

    public zay(Context context, @Nullable AttributeSet attributeSet) {
        super(context, null, 16842824);
    }
}
