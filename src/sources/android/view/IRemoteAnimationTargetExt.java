package android.view;

import android.os.Parcel;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IRemoteAnimationTargetExt {
    default Object getOplusLaunchViewInfo() {
        return null;
    }

    default void setOplusLaunchViewInfo(Object viewInfo) {
    }

    default SurfaceControl getTaskLeash() {
        return null;
    }

    default void setTaskLeash(SurfaceControl taskLeash) {
    }

    default void writeToParcel(Parcel dest, int flags) {
    }

    default void readFromParcel(Parcel in) {
    }
}
