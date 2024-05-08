package android.view.displayhash;

import android.os.RemoteException;
import android.util.ArraySet;
import android.util.Log;
import android.view.WindowManagerGlobal;
import java.util.Collections;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class DisplayHashManager {
    private static final String TAG = "DisplayHashManager";
    private static Set<String> sSupportedHashAlgorithms;
    private final Object mSupportedHashingAlgorithmLock = new Object();

    public Set<String> getSupportedHashAlgorithms() {
        synchronized (this.mSupportedHashingAlgorithmLock) {
            Set<String> set = sSupportedHashAlgorithms;
            if (set != null) {
                return set;
            }
            try {
                String[] supportedAlgorithms = WindowManagerGlobal.getWindowManagerService().getSupportedDisplayHashAlgorithms();
                if (supportedAlgorithms == null) {
                    return Collections.emptySet();
                }
                ArraySet arraySet = new ArraySet(supportedAlgorithms);
                sSupportedHashAlgorithms = arraySet;
                return arraySet;
            } catch (RemoteException e2) {
                Log.e(TAG, "Failed to send request getSupportedHashingAlgorithms", e2);
                throw e2.rethrowFromSystemServer();
            }
        }
    }

    public VerifiedDisplayHash verifyDisplayHash(DisplayHash displayHash) {
        try {
            return WindowManagerGlobal.getWindowManagerService().verifyDisplayHash(displayHash);
        } catch (RemoteException e2) {
            Log.e(TAG, "Failed to send request verifyImpressionToken", e2);
            throw e2.rethrowFromSystemServer();
        }
    }

    public void setDisplayHashThrottlingEnabled(boolean enable) {
        try {
            WindowManagerGlobal.getWindowManagerService().setDisplayHashThrottlingEnabled(enable);
        } catch (RemoteException e2) {
        }
    }
}
