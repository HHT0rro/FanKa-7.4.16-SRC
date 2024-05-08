package android.view;

import android.util.SparseArray;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IInsetsStateWrapper {
    default IInsetsStateExt getExtImpl() {
        return new IInsetsStateExt() { // from class: android.view.IInsetsStateWrapper.1
        };
    }

    default SparseArray<InsetsSource> getSources() {
        return new SparseArray<>();
    }
}
