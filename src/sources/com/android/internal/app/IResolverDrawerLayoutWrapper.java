package com.android.internal.app;

import com.android.internal.widget.IResolverDrawerLayoutExt;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IResolverDrawerLayoutWrapper {
    default IResolverDrawerLayoutExt getResolverDrawerLayoutExt() {
        return null;
    }

    default void performDrag(float dy) {
    }

    default boolean isNestedListChildScrolled() {
        return false;
    }

    default void setDismissOnScrollerFinished(boolean isFinished) {
    }

    default void smoothScrollTo(int yOffset, float velocity) {
    }

    default void dismiss() {
    }

    default boolean isDismissable() {
        return false;
    }
}
