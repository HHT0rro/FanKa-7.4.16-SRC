package android.window;

import android.view.SurfaceControl;
import android.window.IWindowContainerTransactionCallback;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class WindowContainerTransactionCallback {
    final IWindowContainerTransactionCallback mInterface = new IWindowContainerTransactionCallback.Stub() { // from class: android.window.WindowContainerTransactionCallback.1
        @Override // android.window.IWindowContainerTransactionCallback
        public void onTransactionReady(int id2, SurfaceControl.Transaction t2) {
            WindowContainerTransactionCallback.this.onTransactionReady(id2, t2);
        }
    };

    public abstract void onTransactionReady(int i10, SurfaceControl.Transaction transaction);
}
