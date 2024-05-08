package android.view;

import android.view.SurfaceControl;
import java.util.function.Supplier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IInsetsSourceConsumerExt {
    default void updateLeashPositionIfNeeded(InsetsSourceControl control, InsetsSourceControl lastControl, boolean needAnimation, boolean isAnimationPending, Supplier<SurfaceControl.Transaction> transactionSupplier) {
    }

    default boolean isVisible(InsetsSourceControl control, InsetsController insetsController, InsetsState state, int id2) {
        return false;
    }
}
