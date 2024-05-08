package android.widget;

import android.content.Context;
import com.google.android.material.shadow.ShadowDrawableWrapper;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface ISplineOverScrollerWrapper {
    default int getSplineFlingDuration(int velocity) {
        return 0;
    }

    default double getSplineFlingDistance(int velocity) {
        return ShadowDrawableWrapper.COS_45;
    }

    default Context getContext() {
        return null;
    }

    default float[] getSplinePosition() {
        return null;
    }

    default float getFlingFriction() {
        return 0.0f;
    }

    default float getPhysicalCoeff() {
        return 0.0f;
    }
}
