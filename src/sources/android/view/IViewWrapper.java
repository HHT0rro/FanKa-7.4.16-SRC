package android.view;

import android.graphics.Paint;
import android.graphics.RenderNode;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IViewWrapper {
    default int computeVerticalScrollRange() {
        return 0;
    }

    default int computeVerticalScrollOffset() {
        return 0;
    }

    default int computeVerticalScrollExtent() {
        return 0;
    }

    default int computeHorizontalScrollRange() {
        return 0;
    }

    default int computeHorizontalScrollOffset() {
        return 0;
    }

    default int computeHorizontalScrollExtent() {
        return 0;
    }

    default IViewExt getViewExt() {
        return null;
    }

    default int getScrollX() {
        return 0;
    }

    default void setScrollX(int scrollX) {
    }

    default int getScrollY() {
        return 0;
    }

    default void setScrollY(int scrollY) {
    }

    default RenderNode getRenderNode() {
        return null;
    }

    default ViewParent getParent() {
        return null;
    }

    default Paint getLayerPaint() {
        return null;
    }
}
