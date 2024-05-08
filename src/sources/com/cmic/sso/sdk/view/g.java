package com.cmic.sso.sdk.view;

import android.content.Context;
import android.content.res.Resources;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class g {
    public static int a(Context context, String str) {
        int a10 = a(context, str, "id");
        if (a10 != 0) {
            return a10;
        }
        throw new Resources.NotFoundException(str);
    }

    public static int a(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, context.getPackageName());
    }

    public static int b(Context context, String str) {
        int a10 = a(context, str, "drawable");
        if (a10 != 0) {
            return a10;
        }
        throw new Resources.NotFoundException(str);
    }

    public static int c(Context context, String str) {
        int a10 = a(context, str, "anim");
        if (a10 != 0) {
            return a10;
        }
        throw new Resources.NotFoundException(str);
    }
}
