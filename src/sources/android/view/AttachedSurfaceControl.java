package android.view;

import android.graphics.Rect;
import android.graphics.Region;
import android.view.SurfaceControl;
import android.window.SurfaceSyncGroup;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface AttachedSurfaceControl {

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface OnBufferTransformHintChangedListener {
        void onBufferTransformHintChanged(int i10);
    }

    boolean applyTransactionOnDraw(SurfaceControl.Transaction transaction);

    SurfaceControl.Transaction buildReparentTransaction(SurfaceControl surfaceControl);

    default int getBufferTransformHint() {
        return 0;
    }

    default void addOnBufferTransformHintChangedListener(OnBufferTransformHintChangedListener listener) {
    }

    default void removeOnBufferTransformHintChangedListener(OnBufferTransformHintChangedListener listener) {
    }

    default void setTouchableRegion(Region r10) {
    }

    default SurfaceSyncGroup getOrCreateSurfaceSyncGroup() {
        return null;
    }

    default void setChildBoundingInsets(Rect insets) {
    }
}
