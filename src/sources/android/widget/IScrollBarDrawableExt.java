package android.widget;

import android.graphics.Rect;
import android.view.IViewExt;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IScrollBarDrawableExt {
    default void setScrollBarEffect(IViewExt effect) {
    }

    default void getDrawRect(Rect r10) {
    }

    default int getThumbLength(int size, int thickness, int extent, int range) {
        return -1;
    }
}
