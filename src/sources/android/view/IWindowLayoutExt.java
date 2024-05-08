package android.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.WindowManager;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IWindowLayoutExt {
    default boolean isCutoutModeShow(int cutoutMode) {
        return false;
    }

    default void adjustWindowFrame(WindowManager.LayoutParams attrs, Rect windowBounds, int windowingMode, Rect outDisplayFrame, Rect outParentFrame) {
    }

    default void setInsetsHeightForCropping(int screenHeight, int imeHeight, int navBarHeight, int statusBarHeight, int windowMode) {
    }

    default void setOtherParametersForCropping(float density, float scale, int rotation, Rect zoomRect, Context context) {
    }

    default boolean inZoomWindowMode(int windowMode) {
        return false;
    }

    default void adjustDisplayCutoutSafeExceptMaybeBars(WindowManager.LayoutParams attrs, Rect displayFrame, Rect displayCutoutSafeExceptMaybeBars) {
    }

    default int adjustDisplayCutoutMode(WindowManager.LayoutParams attrs, InsetsState state) {
        return attrs.layoutInDisplayCutoutMode;
    }
}
