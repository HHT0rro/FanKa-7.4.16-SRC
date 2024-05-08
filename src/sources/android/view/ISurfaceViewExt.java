package android.view;

import android.window.SurfaceSyncGroup;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface ISurfaceViewExt {
    default void setShowSurfaceCornerRadius(boolean show) {
    }

    default boolean isShowSurfaceCornerRadius() {
        return true;
    }

    default void onDrawFinishedWithSync(SurfaceSyncGroup syncGroup) {
    }

    default boolean shouldDelaySync() {
        return false;
    }
}
