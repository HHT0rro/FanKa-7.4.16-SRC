package com.google.android.exoplayer2.ui;

import android.graphics.Color;
import androidx.annotation.ColorInt;

/* compiled from: HtmlUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class g {
    public static String a(String str) {
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 5 + String.valueOf(str).length());
        sb2.append(".");
        sb2.append(str);
        sb2.append(",.");
        sb2.append(str);
        sb2.append(" *");
        return sb2.toString();
    }

    public static String b(@ColorInt int i10) {
        return com.google.android.exoplayer2.util.j0.D("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i10)), Integer.valueOf(Color.green(i10)), Integer.valueOf(Color.blue(i10)), Double.valueOf(Color.alpha(i10) / 255.0d));
    }
}
