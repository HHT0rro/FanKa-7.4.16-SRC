package android.view;

import android.content.res.Configuration;
import android.util.DisplayMetrics;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IDisplayInfoExt {
    default boolean supportDisplayCompat() {
        return false;
    }

    default void overrideDisplayMetricsIfNeed(DisplayMetrics outMetrics) {
    }

    default void overrideDisplayMetricsIfNeed(DisplayMetrics inoutMetrics, Configuration configuration, int logicalDensityDpi, float physicalXDpi, float physicalYDpi) {
    }
}
