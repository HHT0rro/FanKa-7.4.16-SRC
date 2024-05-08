package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bq {
    public static boolean a(View view, int i10, boolean z10) {
        return view != null && b(view, i10, z10) && cs(view.getContext());
    }

    private static boolean b(View view, int i10, boolean z10) {
        if (view == null || view.getParent() == null) {
            return false;
        }
        Activity dn = com.kwad.sdk.n.l.dn(view.getContext());
        if ((dn != null && dn.isFinishing()) || !view.isShown() || view.getVisibility() != 0 || (z10 && !view.hasWindowFocus())) {
            return false;
        }
        if (view.getGlobalVisibleRect(new Rect())) {
            long height = r9.height() * r9.width();
            long height2 = view.getHeight() * view.getWidth();
            if (height2 > 0 && height * 100 >= i10 * height2) {
                return true;
            }
        }
        return false;
    }

    private static boolean cs(Context context) {
        return ao.Ma().cs(context);
    }

    public static boolean o(View view, int i10) {
        return view != null && b(view, i10, true) && view.hasWindowFocus() && cs(view.getContext());
    }
}
