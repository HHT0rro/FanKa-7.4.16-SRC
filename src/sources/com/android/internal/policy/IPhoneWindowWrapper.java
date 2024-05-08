package com.android.internal.policy;

import android.view.IWindowWrapper;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IPhoneWindowWrapper extends IWindowWrapper {
    default void setForcedNavigationBarColor(boolean isForced) {
    }

    default boolean isForcedNavigationBarColor() {
        return false;
    }

    default void setForcedStatusBarColor(boolean isForced) {
    }

    default CharSequence getTitle() {
        return "";
    }

    default DecorView getDecorView() {
        return null;
    }

    @Override // android.view.IWindowWrapper
    default IPhoneWindowExt getExtImpl() {
        return null;
    }
}
