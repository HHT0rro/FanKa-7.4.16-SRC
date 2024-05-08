package android.view;

import android.graphics.Canvas;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IViewGroupExt {
    default void d(String tag, String msg) {
    }

    default void v(String tag, String msg) {
    }

    default boolean isLevelDebug() {
        return false;
    }

    default boolean isLevelVerbose() {
        return false;
    }

    default void hookdispatchTouchEvent(MotionEvent ev, IViewExt viewExt) {
    }

    default void markDispatchDraw(ViewGroup viewGroup, Canvas canvas) {
    }

    default void markDrawChild(ViewGroup viewGroup, View view, Canvas canvas) {
    }

    default boolean hookdrawChild(Canvas canvas, View child, long drawingTime) {
        return true;
    }

    default boolean markOnDispatchTouchEvent(MotionEvent event, View view) {
        return false;
    }

    default void markOnAddView(View child) {
    }

    default void markOnRemoveView(View child) {
    }
}
