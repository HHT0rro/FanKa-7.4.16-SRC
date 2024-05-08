package com.kwad.components.core.s;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.s;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d {
    public static void a(@NonNull Activity activity, int i10, boolean z10) {
        a(activity, 0, true, true);
    }

    private static void b(@NonNull Activity activity, int i10, boolean z10) {
        Window window = activity.getWindow();
        int i11 = Build.VERSION.SDK_INT;
        int i12 = 1280;
        if (z10 && i11 >= 23) {
            i12 = 9472;
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            if (at.Me()) {
                a(activity, true);
            } else if (at.Mf()) {
                k.b(activity, true);
            }
        }
        window.getDecorView().setSystemUiVisibility(i12);
        window.setStatusBarColor(i10);
        window.setNavigationBarColor(window.getNavigationBarColor());
    }

    public static boolean rc() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static void a(@NonNull Activity activity, int i10, boolean z10, boolean z11) {
        if (rc()) {
            b(activity, i10, z10);
            if (z11) {
                return;
            }
            activity.findViewById(16908290).setPadding(0, com.kwad.sdk.d.a.a.getStatusBarHeight(activity), 0, 0);
        }
    }

    private static boolean a(@NonNull Activity activity, boolean z10) {
        try {
            int intValue = ((Integer) s.aq("android.view.MiuiWindowManager$LayoutParams", "EXTRA_FLAG_STATUS_BAR_DARK_MODE")).intValue();
            s.callMethod(activity.getWindow(), "setExtraFlags", Integer.valueOf(intValue), Integer.valueOf(intValue));
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
