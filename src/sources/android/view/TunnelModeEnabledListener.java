package android.view;

import java.util.concurrent.Executor;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class TunnelModeEnabledListener {
    private final Executor mExecutor;
    private long mNativeListener = nativeCreate(this);

    private static native long nativeCreate(TunnelModeEnabledListener tunnelModeEnabledListener);

    private static native void nativeDestroy(long j10);

    private static native void nativeRegister(long j10);

    private static native void nativeUnregister(long j10);

    public abstract void onTunnelModeEnabledChanged(boolean z10);

    public TunnelModeEnabledListener(Executor executor) {
        this.mExecutor = executor;
    }

    public void destroy() {
        if (this.mNativeListener == 0) {
            return;
        }
        unregister(this);
        nativeDestroy(this.mNativeListener);
        this.mNativeListener = 0L;
    }

    protected void finalize() throws Throwable {
        try {
            destroy();
        } finally {
            super.finalize();
        }
    }

    public static void register(TunnelModeEnabledListener listener) {
        long j10 = listener.mNativeListener;
        if (j10 == 0) {
            return;
        }
        nativeRegister(j10);
    }

    public static void unregister(TunnelModeEnabledListener listener) {
        long j10 = listener.mNativeListener;
        if (j10 == 0) {
            return;
        }
        nativeUnregister(j10);
    }

    public static void dispatchOnTunnelModeEnabledChanged(final TunnelModeEnabledListener listener, final boolean tunnelModeEnabled) {
        listener.mExecutor.execute(new Runnable() { // from class: android.view.TunnelModeEnabledListener$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                TunnelModeEnabledListener.this.onTunnelModeEnabledChanged(tunnelModeEnabled);
            }
        });
    }
}
