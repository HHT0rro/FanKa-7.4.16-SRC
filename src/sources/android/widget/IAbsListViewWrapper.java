package android.widget;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IAbsListViewWrapper {
    default IAbsListviewExt getExtImpl() {
        return new IAbsListviewExt() { // from class: android.widget.IAbsListViewWrapper.1
        };
    }

    default Runnable getFlingRunnable() {
        return null;
    }

    default void setFlingRunnable() {
    }

    default void startSpringback() {
    }

    default OverScroller getOverScroller() {
        return null;
    }
}
