package android.widget;

import android.content.Context;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IOplusScrollViewExt {
    default OverScroller createSpringOverScrollerInstance(Context context) {
        return null;
    }

    default void onOverScrolled(OverScroller scroller, int scrollRange, int x10, int y10) {
    }

    default boolean canFling(boolean canFling) {
        return false;
    }

    default boolean shouldDisplayEdgeEffects(boolean shouldDisplay) {
        return false;
    }

    default void hookInitScrollView(Context context) {
    }

    default void markOnTouchEventMove(int y10, int deltaY, int lastMotionY) {
    }

    default void markOnOverScrolled(int deltaY) {
    }
}
