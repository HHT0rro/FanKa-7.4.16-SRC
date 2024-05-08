package android.view;

import android.content.Context;
import android.os.Handler;
import android.view.ViewRootImpl;
import android.view.WindowManager;
import android.window.SurfaceSyncGroup;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IViewRootImplWrapper {
    default void collectRootScrollCaptureTargets(ScrollCaptureSearchResults results) {
    }

    default Object getSocExtImpl() {
        return null;
    }

    default IViewRootImplExt getExtImpl() {
        return new IViewRootImplExt() { // from class: android.view.IViewRootImplWrapper.1
        };
    }

    default Handler getHandler() {
        return new Handler();
    }

    default SurfaceControl getSurfaceControl() {
        return null;
    }

    default Choreographer getChoreographer() {
        return Choreographer.getMainThreadInstance();
    }

    default WindowManager.LayoutParams getWindowAttributes() {
        return new WindowManager.LayoutParams();
    }

    default String getBasePackageName() {
        return null;
    }

    default ViewRootImpl.TraversalRunnable getTraversalRunnable() {
        return null;
    }

    default ViewRootImpl.WindowInputEventReceiver getInputEventReceiver() {
        return null;
    }

    default int getTraversalBarrier() {
        return 0;
    }

    default void setTraversalBarrier(int traversalBarrier) {
    }

    default boolean getTraversalScheduled() {
        return false;
    }

    default void scheduleTraversals() {
    }

    default Display getDisplay() {
        return null;
    }

    default void setTraversalScheduled(boolean traversalScheduled) {
    }

    default boolean getUnbufferedInputDispatch() {
        return false;
    }

    default void notifyRendererOfFramePending() {
    }

    default void pokeDrawLockIfNeeded() {
    }

    default void scheduleConsumeBatchedInput() {
    }

    default boolean isRemoved() {
        return false;
    }

    default SurfaceControl getSurfaceViewBoundsLayer() {
        return null;
    }

    default ArrayList<ViewRootImpl.SurfaceChangedCallback> getSurfaceChangedCallbacks() {
        return null;
    }

    default Context getContext() {
        return null;
    }

    default void addToWmsSync(SurfaceSyncGroup syncGroup) {
    }
}
