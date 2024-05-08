package com.alibaba.security.biometrics.build;

import android.graphics.Color;
import android.text.TextUtils;

/* compiled from: ColorUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ae {
    public static int a(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            return i10;
        }
        try {
            return Color.parseColor(str);
        } catch (Exception unused) {
            return i10;
        }
    }
}
