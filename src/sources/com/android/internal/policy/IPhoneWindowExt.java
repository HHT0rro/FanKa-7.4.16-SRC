package com.android.internal.policy;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.IWindowExt;
import android.view.ViewGroup;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IPhoneWindowExt extends IWindowExt {
    default void init(Context context) {
    }

    default void setSystemBarColor(int color) {
    }

    default ViewGroup getContentParent() {
        return null;
    }

    default CharSequence getWindowTitle() {
        return "";
    }

    default boolean isUseDefaultNavigationBarColor() {
        return true;
    }

    default void hookGenerateLayout(PhoneWindow phoneWindow, TypedArray typedArray, Context context) {
    }

    default void hookForInputLogV(String msg) {
    }
}
