package android.widget;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IOverScrollerWrapper {
    default IOplusOverScrollerExt getExtImpl() {
        return new IOplusOverScrollerExt() { // from class: android.widget.IOverScrollerWrapper.1
        };
    }

    default int getMode() {
        return 0;
    }
}
