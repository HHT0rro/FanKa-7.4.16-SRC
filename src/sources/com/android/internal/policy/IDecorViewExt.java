package com.android.internal.policy;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.view.IWindow;
import android.view.MotionEvent;
import android.view.WindowInsets;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IDecorViewExt {
    default boolean hookDecorView(Context context, boolean defaultForceWindowDrawsBarBackgrounds) {
        return defaultForceWindowDrawsBarBackgrounds;
    }

    default void hookSetHandledPrimaryActionMode(ObjectAnimator fadeAnim) {
    }

    default void hookOnDestroyActionMode(ObjectAnimator fadeAnim) {
    }

    default boolean isDebugSystemBar() {
        return false;
    }

    default void onConfigurationChanged(Configuration newConfig) {
    }

    default void updatePhoneWindow(PhoneWindow window) {
    }

    default void inputLog(String level, String tag, String msg, MotionEvent event) {
    }

    default int getLegacyNavBarBackgroundColor() {
        return -16777216;
    }

    default void draw(Canvas canvas, int width, int height) {
    }

    default void setWindow(IWindow window) {
    }

    default void onConfigurationChanged(Configuration newConfig, Context context) {
    }

    default void initDarkModeBackgroundColor() {
    }

    default void requestLayoutForDarkModeBackgroundView() {
    }

    default void requestUpdateColorViewsForPocketStudio(Context context, DecorView decor, Configuration newConfig) {
    }

    default boolean isClosedSuperFirewall() {
        return false;
    }

    default void markOnDecorMeasure(DecorView decorView, int widthMeasuredSpec, int heightMeasuredSpec) {
    }

    default void markOnDecorLayout(DecorView decorView, int left, int top, int right, int bottom) {
    }

    default void markOnDecorSetFrame(DecorView decorView, int l10, int t2, int r10, int b4) {
    }

    default int forceMarginByTaskBar(WindowInsets insets, DecorView decorView, int lastBottom) {
        return lastBottom;
    }
}
