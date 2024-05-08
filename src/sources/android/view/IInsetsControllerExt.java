package android.view;

import android.util.SparseArray;
import android.view.animation.Interpolator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IInsetsControllerExt {

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface IStaticExt {
        default Interpolator replaceIMEInterpolator(Interpolator ip) {
            return ip;
        }

        default long replaceIMEDurationMs(boolean show, int time) {
            return time;
        }

        default boolean setInsetAnimationTid(int type) {
            return false;
        }

        default void imeAnimatorStart(int requestedTypes, int types, long duration) {
        }

        default void imeAnimatorUpdate(int requestedTypes, int types) {
        }

        default long imeAnimatorFinished(int requestedTypes, long preJankCount) {
            return 0L;
        }

        default void imeAnimatorCancelled(int requestedTypes) {
        }
    }

    default boolean isIgnoreTaskBarAnim(int types, SparseArray<InsetsSourceConsumer> sourceConsumers) {
        return false;
    }
}
