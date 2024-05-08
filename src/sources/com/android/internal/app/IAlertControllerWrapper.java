package com.android.internal.app;

import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IAlertControllerWrapper {
    default CharSequence getTitle() {
        return "";
    }

    default CharSequence getMessage() {
        return "";
    }

    default CharSequence getPositionButtonText() {
        return "";
    }

    default CharSequence getNegativeButtonText() {
        return "";
    }

    default CharSequence getNeutralButtonText() {
        return "";
    }

    default TextView getMessageView() {
        return null;
    }

    default Button getPositiveButton() {
        return null;
    }

    default Button getNegativeButton() {
        return null;
    }

    default Button getNeutralButton() {
        return null;
    }

    default ScrollView getScrollView() {
        return null;
    }

    default void setUpView() {
    }

    default void selectContentView() {
    }
}
