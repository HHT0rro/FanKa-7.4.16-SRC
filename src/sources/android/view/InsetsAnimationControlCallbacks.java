package android.view;

import android.view.SyncRtSurfaceTransactionApplier;
import android.view.WindowInsetsAnimation;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface InsetsAnimationControlCallbacks {
    void applySurfaceParams(SyncRtSurfaceTransactionApplier.SurfaceParams... surfaceParamsArr);

    void notifyFinished(InsetsAnimationControlRunner insetsAnimationControlRunner, boolean z10);

    void releaseSurfaceControlFromRt(SurfaceControl surfaceControl);

    void reportPerceptible(int i10, boolean z10);

    void scheduleApplyChangeInsets(InsetsAnimationControlRunner insetsAnimationControlRunner);

    <T extends InsetsAnimationControlRunner & InternalInsetsAnimationController> void startAnimation(T t2, WindowInsetsAnimationControlListener windowInsetsAnimationControlListener, int i10, WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds);
}
