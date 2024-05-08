package android.widget;

import android.content.Context;
import android.util.Pair;
import com.google.android.material.shadow.ShadowDrawableWrapper;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface ISplineOverScrollerExt {
    default void hookSaveCurrVeloAccuCount() {
    }

    default void hookSetAbortTime(long time) {
    }

    default void hookResetVeloAccuCount() {
    }

    default void hookStartFling(long now, float currVelo, int velo, boolean finished) {
    }

    default Pair<Integer, Double> hookEndFling(Context context, int velocity, float flingFriction) {
        return new Pair<>(0, Double.valueOf(ShadowDrawableWrapper.COS_45));
    }

    default void onFlingStart(int duration, int velocity, int position) {
    }

    default void onFlingFinish() {
    }

    default void onFlingPositionUpdate(int velocity, int position) {
    }

    default void onFlingStateUpdate(int state) {
    }

    default void markOnStartScroll() {
    }

    default void markOnFling() {
    }

    default long markOnUpdateStart(long startTime, long currentTime) {
        return currentTime;
    }

    default void markOnUpdateSpline(int splineDuration, float t2, long currentTime, int offset) {
    }

    default void markOnUpdateEnd() {
    }
}
