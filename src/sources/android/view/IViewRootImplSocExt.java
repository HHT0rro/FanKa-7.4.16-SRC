package android.view;

import android.content.Context;
import android.graphics.BLASTBufferQueue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IViewRootImplSocExt {
    default void setHaveMoveEvent(MotionEvent event) {
    }

    default void setBLASTBufferQueue(BLASTBufferQueue bLASTBufferQueue) {
    }

    default void hookScrollPerfHint(Context context) {
    }

    default void hookMotionEventPerfHint(MotionEvent event, Context context) {
    }

    default void scaleMotionEvent(InputEvent inputEvent) {
    }

    default void setSurfaceCreated(boolean created) {
    }

    default void hookFinishDrawingPerfHint() {
    }

    default void hookOnFrameDrawPerfHint() {
    }

    default void hookInputBegin(MotionEvent event, Context context) {
    }

    default void hookRealDrawPerfHint() {
    }
}
