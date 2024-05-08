package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ai {
    public static boolean LZ() {
        return isOrientationPortrait();
    }

    public static void b(Context context, boolean z10) {
        try {
            Activity dn = com.kwad.sdk.n.l.dn(context);
            if (dn == null) {
                return;
            }
            if (z10) {
                dn.getWindow().getDecorView().setSystemUiVisibility(1792);
            } else {
                dn.getWindow().getDecorView().setSystemUiVisibility(3846);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean cl(Context context) {
        Activity dn = com.kwad.sdk.n.l.dn(context);
        if (dn != null) {
            Window window = dn.getWindow();
            r0 = (window.getAttributes().flags & 1024) == 1024;
            window.setFlags(1024, 1024);
        }
        return r0;
    }

    public static void cm(Context context) {
        Activity dn = com.kwad.sdk.n.l.dn(context);
        if (dn != null) {
            dn.getWindow().clearFlags(1024);
        }
    }

    public static void cn(Context context) {
        Activity dn = com.kwad.sdk.n.l.dn(context);
        if (dn != null) {
            dn.setRequestedOrientation(0);
        }
    }

    public static void co(Context context) {
        Activity dn = com.kwad.sdk.n.l.dn(context);
        if (dn != null) {
            dn.setRequestedOrientation(1);
        }
    }

    public static boolean isOrientationPortrait() {
        return ServiceProvider.KO().getApplicationContext().getResources().getConfiguration().orientation == 1;
    }
}
