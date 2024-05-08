package android.view;

import android.graphics.Rect;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IRemoteTaskWindowInsetHelperExt {
    default void updateDisplayId(int id2) {
    }

    default InsetsSource updateInsetSourceIfNeeded(InsetsSource source, int type, Rect frame) {
        return null;
    }

    default boolean isDisplayChanged() {
        return false;
    }
}
