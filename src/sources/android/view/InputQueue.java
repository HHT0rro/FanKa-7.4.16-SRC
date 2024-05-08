package android.view;

import android.os.Looper;
import android.os.MessageQueue;
import android.util.LongSparseArray;
import android.util.Pools;
import dalvik.system.CloseGuard;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class InputQueue {
    private final LongSparseArray<ActiveInputEvent> mActiveEventArray = new LongSparseArray<>(20);
    private final Pools.Pool<ActiveInputEvent> mActiveInputEventPool = new Pools.SimplePool(20);
    private final CloseGuard mCloseGuard;
    private long mPtr;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface Callback {
        void onInputQueueCreated(InputQueue inputQueue);

        void onInputQueueDestroyed(InputQueue inputQueue);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface FinishedInputEventCallback {
        void onFinishedInputEvent(Object obj, boolean z10);
    }

    private static native void nativeDispose(long j10);

    private static native long nativeInit(WeakReference<InputQueue> weakReference, MessageQueue messageQueue);

    private static native long nativeSendKeyEvent(long j10, KeyEvent keyEvent, boolean z10);

    private static native long nativeSendMotionEvent(long j10, MotionEvent motionEvent);

    public InputQueue() {
        CloseGuard closeGuard = CloseGuard.get();
        this.mCloseGuard = closeGuard;
        this.mPtr = nativeInit(new WeakReference(this), Looper.myQueue());
        closeGuard.open("InputQueue.dispose");
    }

    protected void finalize() throws Throwable {
        try {
            dispose(true);
        } finally {
            super.finalize();
        }
    }

    public void dispose() {
        dispose(false);
    }

    public void dispose(boolean finalized) {
        CloseGuard closeGuard = this.mCloseGuard;
        if (closeGuard != null) {
            if (finalized) {
                closeGuard.warnIfOpen();
            }
            this.mCloseGuard.close();
        }
        long j10 = this.mPtr;
        if (j10 != 0) {
            nativeDispose(j10);
            this.mPtr = 0L;
        }
    }

    public long getNativePtr() {
        return this.mPtr;
    }

    public void sendInputEvent(InputEvent e2, Object token, boolean predispatch, FinishedInputEventCallback callback) {
        long id2;
        ActiveInputEvent event = obtainActiveInputEvent(token, callback);
        if (e2 instanceof KeyEvent) {
            id2 = nativeSendKeyEvent(this.mPtr, (KeyEvent) e2, predispatch);
        } else {
            long id3 = this.mPtr;
            id2 = nativeSendMotionEvent(id3, (MotionEvent) e2);
        }
        this.mActiveEventArray.put(id2, event);
    }

    private void finishInputEvent(long id2, boolean handled) {
        int index = this.mActiveEventArray.indexOfKey(id2);
        if (index >= 0) {
            ActiveInputEvent e2 = this.mActiveEventArray.valueAt(index);
            this.mActiveEventArray.removeAt(index);
            e2.mCallback.onFinishedInputEvent(e2.mToken, handled);
            recycleActiveInputEvent(e2);
        }
    }

    private ActiveInputEvent obtainActiveInputEvent(Object token, FinishedInputEventCallback callback) {
        ActiveInputEvent e2 = (ActiveInputEvent) this.mActiveInputEventPool.acquire();
        if (e2 == null) {
            e2 = new ActiveInputEvent();
        }
        e2.mToken = token;
        e2.mCallback = callback;
        return e2;
    }

    private void recycleActiveInputEvent(ActiveInputEvent e2) {
        e2.recycle();
        this.mActiveInputEventPool.release(e2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class ActiveInputEvent {
        public FinishedInputEventCallback mCallback;
        public Object mToken;

        private ActiveInputEvent() {
        }

        public void recycle() {
            this.mToken = null;
            this.mCallback = null;
        }
    }
}
