package android.view;

import android.graphics.HardwareRendererObserver;
import android.os.Handler;
import android.view.Window;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class FrameMetricsObserver implements HardwareRendererObserver.OnFrameMetricsAvailableListener {
    private final FrameMetrics mFrameMetrics;
    final Window.OnFrameMetricsAvailableListener mListener;
    private final HardwareRendererObserver mObserver;
    private final WeakReference<Window> mWindow;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FrameMetricsObserver(Window window, Handler handler, Window.OnFrameMetricsAvailableListener listener) {
        this.mWindow = new WeakReference<>(window);
        this.mListener = listener;
        FrameMetrics frameMetrics = new FrameMetrics();
        this.mFrameMetrics = frameMetrics;
        this.mObserver = new HardwareRendererObserver(this, frameMetrics.mTimingData, handler, false);
    }

    public void onFrameMetricsAvailable(int dropCountSinceLastInvocation) {
        if (this.mWindow.get() != null) {
            this.mListener.onFrameMetricsAvailable(this.mWindow.get(), this.mFrameMetrics, dropCountSinceLastInvocation);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HardwareRendererObserver getRendererObserver() {
        return this.mObserver;
    }
}
