package com.kwad.sdk.utils;

import android.content.Context;
import android.content.res.Resources;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class as {
    public static int at(Context context, String str) {
        Resources cu = cu(context);
        if (cu == null) {
            cu = context.getResources();
        }
        return cu.getIdentifier(str, "drawable", context.getPackageName());
    }

    public static Resources cu(Context context) {
        if (context == null) {
            return null;
        }
        return ServiceProvider.KO().getResources();
    }

    public static int getAppIconId(Context context) {
        int i10;
        try {
            i10 = context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 64).applicationInfo.icon;
        } catch (Throwable unused) {
            i10 = 0;
        }
        return i10 <= 0 ? at(context, "ksad_notification_small_icon") : i10;
    }

    public static int getId(Context context, String str) {
        return getIdentifier(context, str, "id");
    }

    private static int getIdentifier(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, getPackageName(context));
    }

    private static String getPackageName(Context context) {
        return ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).yp() ? "com.kwad.sdk" : context.getPackageName();
    }
}
