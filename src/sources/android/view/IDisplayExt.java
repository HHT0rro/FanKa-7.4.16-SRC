package android.view;

import android.content.res.CompatibilityInfo;
import android.content.res.Resources;
import android.graphics.Point;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IDisplayExt {
    default boolean supportDisplayCompat() {
        return false;
    }

    default void updateCompatRealSize(DisplayInfo displayInfo, CompatibilityInfo compat, Point outSize) {
    }

    default int getCompactWindowRotation(Resources resources) {
        return -1;
    }

    default DisplayAdjustments getCompactWindowDisplayAdjustment(Resources resources) {
        return null;
    }

    default DisplayAdjustments getDisplayAdjustmentForCompactWindow(Resources resources, DisplayAdjustments originAdjustments) {
        return originAdjustments;
    }
}
