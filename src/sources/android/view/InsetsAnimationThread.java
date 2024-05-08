package android.view;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class InsetsAnimationThread extends HandlerThread {
    private static Handler sHandler;
    private static InsetsAnimationThread sInstance;

    private InsetsAnimationThread() {
        super("InsetsAnimations");
    }

    private static void ensureThreadLocked() {
        if (sInstance == null) {
            InsetsAnimationThread insetsAnimationThread = new InsetsAnimationThread();
            sInstance = insetsAnimationThread;
            insetsAnimationThread.start();
            sInstance.getLooper().setTraceTag(8L);
            sHandler = new Handler(sInstance.getLooper());
        }
    }

    public static void release() {
        synchronized (InsetsAnimationThread.class) {
            InsetsAnimationThread insetsAnimationThread = sInstance;
            if (insetsAnimationThread == null) {
                return;
            }
            insetsAnimationThread.getLooper().quitSafely();
            sInstance = null;
            sHandler = null;
        }
    }

    public static InsetsAnimationThread get() {
        InsetsAnimationThread insetsAnimationThread;
        synchronized (InsetsAnimationThread.class) {
            ensureThreadLocked();
            insetsAnimationThread = sInstance;
        }
        return insetsAnimationThread;
    }

    public static Handler getHandler() {
        Handler handler;
        synchronized (InsetsAnimationThread.class) {
            ensureThreadLocked();
            handler = sHandler;
        }
        return handler;
    }
}