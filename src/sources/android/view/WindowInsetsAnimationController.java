package android.view;

import android.graphics.Insets;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface WindowInsetsAnimationController {
    void finish(boolean z10);

    float getCurrentAlpha();

    float getCurrentFraction();

    Insets getCurrentInsets();

    Insets getHiddenStateInsets();

    Insets getShownStateInsets();

    int getTypes();

    boolean hasZeroInsetsIme();

    boolean isCancelled();

    boolean isFinished();

    void setInsetsAndAlpha(Insets insets, float f10, float f11);

    default boolean isReady() {
        return (isFinished() || isCancelled()) ? false : true;
    }
}
