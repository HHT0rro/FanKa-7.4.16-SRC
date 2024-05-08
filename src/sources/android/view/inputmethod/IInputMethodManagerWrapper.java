package android.view.inputmethod;

import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IInputMethodManagerWrapper {
    default IInputMethodManagerExt getExtImpl() {
        return new IInputMethodManagerExt() { // from class: android.view.inputmethod.IInputMethodManagerWrapper.1
        };
    }

    default View getNextServedView() {
        return null;
    }

    default String getCurId() {
        return "";
    }
}
