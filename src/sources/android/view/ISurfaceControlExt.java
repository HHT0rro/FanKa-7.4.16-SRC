package android.view;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface ISurfaceControlExt {
    default void onSetMatrix(SurfaceControl sc2, float[] float9) {
    }

    default int getAnimationType(SurfaceControl sc2) {
        return 0;
    }

    default boolean isFingerprintType(String scName) {
        return false;
    }
}
