package android.view;

import android.graphics.Rect;
import android.os.Parcel;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IInsetsStateExt {
    public static final int EXTRA_DISPLAY_CUTOUT_MODE_INVALID = -1;

    default void removeSourceByType(int types) {
    }

    default InsetsSource peekDefaultSource(int type) {
        return null;
    }

    default InsetsSource peekNavigationBarSource(int type, int flags) {
        return null;
    }

    default void setExtraDisplayCutoutMode(int extraCutoutMode) {
    }

    default int getExtraDisplayCutoutMode() {
        return -1;
    }

    default void readFromParcel(Parcel in) {
    }

    default void writeToParcel(Parcel dest) {
    }

    default void setRTWindowInsetHelper(IRemoteTaskWindowInsetHelperExt helper) {
    }

    default void updateInsetSource(InsetsSource source, int type, Rect frame) {
    }
}
