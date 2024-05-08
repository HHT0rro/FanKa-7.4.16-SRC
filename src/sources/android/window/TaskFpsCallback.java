package android.window;

import android.annotation.SystemApi;
import android.os.RemoteException;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
@SystemApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class TaskFpsCallback {
    public abstract void onFpsReported(float f10);

    private static void dispatchOnFpsReported(ITaskFpsCallback listener, float fps) {
        try {
            listener.onFpsReported(fps);
        } catch (RemoteException e2) {
        }
    }
}
