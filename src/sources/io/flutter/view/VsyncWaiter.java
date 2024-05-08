package io.flutter.view;

import android.hardware.display.DisplayManager;
import android.view.Choreographer;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class VsyncWaiter {
    private static VsyncWaiter instance;
    private static DisplayListener listener;
    private FlutterJNI flutterJNI;
    private long refreshPeriodNanos = -1;
    private FrameCallback frameCallback = new FrameCallback(0);
    private final FlutterJNI.AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate = new FlutterJNI.AsyncWaitForVsyncDelegate() { // from class: io.flutter.view.VsyncWaiter.1
        private Choreographer.FrameCallback obtainFrameCallback(long j10) {
            if (VsyncWaiter.this.frameCallback != null) {
                VsyncWaiter.this.frameCallback.cookie = j10;
                FrameCallback frameCallback = VsyncWaiter.this.frameCallback;
                VsyncWaiter.this.frameCallback = null;
                return frameCallback;
            }
            return new FrameCallback(j10);
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.AsyncWaitForVsyncDelegate
        public void asyncWaitForVsync(long j10) {
            Choreographer.getInstance().postFrameCallback(obtainFrameCallback(j10));
        }
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class DisplayListener implements DisplayManager.DisplayListener {
        private DisplayManager displayManager;

        public DisplayListener(DisplayManager displayManager) {
            this.displayManager = displayManager;
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i10) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i10) {
            if (i10 == 0) {
                float refreshRate = this.displayManager.getDisplay(0).getRefreshRate();
                VsyncWaiter.this.refreshPeriodNanos = (long) (1.0E9d / refreshRate);
                VsyncWaiter.this.flutterJNI.setRefreshRateFPS(refreshRate);
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i10) {
        }

        public void register() {
            this.displayManager.registerDisplayListener(this, null);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class FrameCallback implements Choreographer.FrameCallback {
        private long cookie;

        public FrameCallback(long j10) {
            this.cookie = j10;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j10) {
            long nanoTime = System.nanoTime() - j10;
            VsyncWaiter.this.flutterJNI.onVsync(nanoTime < 0 ? 0L : nanoTime, VsyncWaiter.this.refreshPeriodNanos, this.cookie);
            VsyncWaiter.this.frameCallback = this;
        }
    }

    private VsyncWaiter(@NonNull FlutterJNI flutterJNI) {
        this.flutterJNI = flutterJNI;
    }

    @NonNull
    public static VsyncWaiter getInstance(float f10, @NonNull FlutterJNI flutterJNI) {
        if (instance == null) {
            instance = new VsyncWaiter(flutterJNI);
        }
        flutterJNI.setRefreshRateFPS(f10);
        VsyncWaiter vsyncWaiter = instance;
        vsyncWaiter.refreshPeriodNanos = (long) (1.0E9d / f10);
        return vsyncWaiter;
    }

    @VisibleForTesting
    public static void reset() {
        instance = null;
        listener = null;
    }

    public void init() {
        this.flutterJNI.setAsyncWaitForVsyncDelegate(this.asyncWaitForVsyncDelegate);
    }

    @NonNull
    public static VsyncWaiter getInstance(@NonNull DisplayManager displayManager, @NonNull FlutterJNI flutterJNI) {
        if (instance == null) {
            instance = new VsyncWaiter(flutterJNI);
        }
        if (listener == null) {
            VsyncWaiter vsyncWaiter = instance;
            Objects.requireNonNull(vsyncWaiter);
            DisplayListener displayListener = new DisplayListener(displayManager);
            listener = displayListener;
            displayListener.register();
        }
        if (instance.refreshPeriodNanos == -1) {
            float refreshRate = displayManager.getDisplay(0).getRefreshRate();
            instance.refreshPeriodNanos = (long) (1.0E9d / refreshRate);
            flutterJNI.setRefreshRateFPS(refreshRate);
        }
        return instance;
    }
}
