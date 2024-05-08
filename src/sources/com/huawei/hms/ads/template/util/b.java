package com.huawei.hms.ads.template.util;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.utils.an;
import com.huawei.quickcard.base.Attributes;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class b {
    public static Drawable Code(Context context, String str) {
        Class I;
        Object Code;
        Object Code2;
        if (str.startsWith("@color/")) {
            Class I2 = I(context, "color");
            if (I2 != null && (Code2 = an.Code(I2, str.substring(7))) != null && (Code2 instanceof Integer)) {
                return new ColorDrawable(context.getResources().getColor(((Integer) Code2).intValue()));
            }
        } else if (str.startsWith("@drawable/") && (I = I(context, "drawable")) != null && (Code = an.Code(I, str.substring(10))) != null && (Code instanceof Integer)) {
            return context.getResources().getDrawable(((Integer) Code).intValue());
        }
        return null;
    }

    private static Class I(Context context, String str) {
        String str2 = "com.huawei.hms.ads.template.R$" + str;
        try {
            return Class.forName(str2);
        } catch (ClassNotFoundException unused) {
            gl.I("ResourceUtil", "findHostAppRClass class not found: " + str2);
            return null;
        }
    }

    public static String V(Context context, String str) {
        Class I;
        Object Code;
        if (!str.startsWith("@strings/") || (I = I(context, Attributes.TextOverflow.STRING)) == null || (Code = an.Code(I, str.substring(9))) == null || !(Code instanceof Integer)) {
            return null;
        }
        return context.getResources().getString(((Integer) Code).intValue());
    }
}
