package android.widget;

import android.content.Context;
import com.google.android.material.shadow.ShadowDrawableWrapper;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface ISplineOverScrollerSocExt {
    default void setFlingFriction(float flingFriction) {
    }

    default void perfHintStart(float currentVelocity) {
    }

    default void perfHintFinish() {
    }

    default void perfHintUpdate(long currentTime) {
    }

    default boolean isSmoothFlingEnabled() {
        return false;
    }

    default double getSplineFlingDistance() {
        return ShadowDrawableWrapper.COS_45;
    }

    default int getSplineDuration() {
        return 0;
    }

    default boolean isVariableRefreshRateEnabled() {
        return false;
    }

    default double getCurrentDistance() {
        return ShadowDrawableWrapper.COS_45;
    }

    default float getCurrentVelocity() {
        return 0.0f;
    }

    default void setVariableRefreshRateEnable(boolean isVariableRefreshRateEnabled) {
    }

    default void initScrollScenario(Context context) {
    }
}
