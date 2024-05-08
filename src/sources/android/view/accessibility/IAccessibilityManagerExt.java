package android.view.accessibility;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IAccessibilityManagerExt {
    default boolean getDirectEnabledState() {
        return false;
    }

    default void setDirectEnabledState(int stateFlags) {
    }

    default boolean directEnable(boolean managerEnable) {
        return false;
    }
}
