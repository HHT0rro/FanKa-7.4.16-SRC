package android.view;

import android.util.SparseArray;
import android.util.proto.ProtoOutputStream;
import android.view.inputmethod.ImeTracker;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface InsetsAnimationControlRunner {
    void cancel();

    void dumpDebug(ProtoOutputStream protoOutputStream, long j10);

    WindowInsetsAnimation getAnimation();

    int getAnimationType();

    int getControllingTypes();

    ImeTracker.Token getStatsToken();

    int getTypes();

    void notifyControlRevoked(int i10);

    void updateSurfacePosition(SparseArray<InsetsSourceControl> sparseArray);

    default boolean controlsType(int type) {
        return (getTypes() & type) != 0;
    }
}
