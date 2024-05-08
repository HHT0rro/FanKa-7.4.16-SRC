package android.view;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IWindowWrapper {
    default IWindowExt getExtImpl() {
        return new IWindowExt() { // from class: android.view.IWindowWrapper.1
        };
    }

    default boolean isSetCloseOnTouchOutside() {
        return false;
    }

    default void setCloseOnTouchOutside(boolean closeOnTouchOutside) {
    }
}
