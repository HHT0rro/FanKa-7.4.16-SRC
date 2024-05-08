package android.widget;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IScrollViewWrapper {
    default IOplusScrollViewExt getExtImpl() {
        return new IOplusScrollViewExt() { // from class: android.widget.IScrollViewWrapper.1
        };
    }

    default OverScroller getOverScroller() {
        return null;
    }
}
