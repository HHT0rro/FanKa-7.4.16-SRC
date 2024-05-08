package com.android.internal.policy;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Insets;
import android.util.RotationUtils;
import android.view.DisplayCutout;
import com.android.internal.R;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class SystemBarUtils {
    public static int getStatusBarHeight(Context context) {
        return getStatusBarHeight(context.getResources(), context.getDisplay().getCutout());
    }

    public static int getStatusBarHeight(Resources res, DisplayCutout cutout) {
        int defaultSize = res.getDimensionPixelSize(R.dimen.status_bar_height_default);
        int safeInsetTop = cutout == null ? 0 : cutout.getSafeInsetTop();
        int waterfallInsetTop = cutout != null ? cutout.getWaterfallInsets().top : 0;
        return Math.max(safeInsetTop, defaultSize + waterfallInsetTop);
    }

    public static int getStatusBarHeightForRotation(Context context, int targetRot) {
        int rotation = context.getDisplay().getRotation();
        DisplayCutout cutout = context.getDisplay().getCutout();
        Insets insets = cutout == null ? Insets.NONE : Insets.of(cutout.getSafeInsets());
        Insets waterfallInsets = cutout == null ? Insets.NONE : cutout.getWaterfallInsets();
        if (rotation != targetRot) {
            if (!insets.equals(Insets.NONE)) {
                insets = RotationUtils.rotateInsets(insets, RotationUtils.deltaRotation(rotation, targetRot));
            }
            if (!waterfallInsets.equals(Insets.NONE)) {
                waterfallInsets = RotationUtils.rotateInsets(waterfallInsets, RotationUtils.deltaRotation(rotation, targetRot));
            }
        }
        int defaultSize = context.getResources().getDimensionPixelSize(R.dimen.status_bar_height_default);
        return Math.max(insets.top, waterfallInsets.top + defaultSize);
    }

    public static int getQuickQsOffsetHeight(Context context) {
        int defaultSize = context.getResources().getDimensionPixelSize(17105514);
        int statusBarHeight = getStatusBarHeight(context);
        return Math.max(defaultSize, statusBarHeight);
    }
}
