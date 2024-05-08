package com.android.internal.policy;

import android.content.Context;
import android.content.res.Resources;
import android.view.RoundedCorners;
import com.android.internal.R;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ScreenDecorationsUtils {
    public static float getWindowCornerRadius(Context context) {
        Resources resources = context.getResources();
        if (!supportsRoundedCornersOnWindows(resources)) {
            return 0.0f;
        }
        String displayUniqueId = context.getDisplayNoVerify().getUniqueId();
        float defaultRadius = RoundedCorners.getRoundedCornerRadius(resources, displayUniqueId) - RoundedCorners.getRoundedCornerRadiusAdjustment(resources, displayUniqueId);
        float topRadius = RoundedCorners.getRoundedCornerTopRadius(resources, displayUniqueId) - RoundedCorners.getRoundedCornerRadiusTopAdjustment(resources, displayUniqueId);
        if (topRadius == 0.0f) {
            topRadius = defaultRadius;
        }
        float bottomRadius = RoundedCorners.getRoundedCornerBottomRadius(resources, displayUniqueId) - RoundedCorners.getRoundedCornerRadiusBottomAdjustment(resources, displayUniqueId);
        if (bottomRadius == 0.0f) {
            bottomRadius = defaultRadius;
        }
        return Math.min(topRadius, bottomRadius);
    }

    public static boolean supportsRoundedCornersOnWindows(Resources resources) {
        return resources.getBoolean(R.bool.config_supportsRoundedCornersOnWindows);
    }
}
