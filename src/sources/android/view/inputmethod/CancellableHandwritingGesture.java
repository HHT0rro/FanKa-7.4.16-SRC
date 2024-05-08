package android.view.inputmethod;

import android.os.CancellationSignal;
import android.os.CancellationSignalBeamer;
import android.os.IBinder;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class CancellableHandwritingGesture extends HandwritingGesture {
    CancellationSignal mCancellationSignal;
    IBinder mCancellationSignalToken;

    public void setCancellationSignal(CancellationSignal cancellationSignal) {
        this.mCancellationSignal = cancellationSignal;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CancellationSignal getCancellationSignal() {
        return this.mCancellationSignal;
    }

    public void unbeamCancellationSignal(CancellationSignalBeamer.Receiver receiver) {
        IBinder iBinder = this.mCancellationSignalToken;
        if (iBinder != null) {
            this.mCancellationSignal = receiver.unbeam(iBinder);
            this.mCancellationSignalToken = null;
        }
    }
}
