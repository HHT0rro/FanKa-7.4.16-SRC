package android.view;

import android.window.SurfaceSyncGroup;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface ISurfaceViewWrapper {
    default SurfaceControl getBlastSurfaceControl() {
        return null;
    }

    default ISurfaceViewExt getExtImpl() {
        return new ISurfaceViewExt() { // from class: android.view.ISurfaceViewWrapper.1
        };
    }

    default void performDrawFinishedSync(SurfaceSyncGroup syncGroup) {
    }

    default void onDrawFinished(SurfaceSyncGroup syncGroup) {
    }
}
