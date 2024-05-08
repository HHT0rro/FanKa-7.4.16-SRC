package android.view;

import android.os.IBinder;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Trace;
import android.util.Log;
import android.util.SparseIntArray;
import dalvik.system.CloseGuard;
import java.io.PrintWriter;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import system.ext.loader.core.ExtLoader;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class InputEventReceiver {
    private static final String TAG = "InputEventReceiver";
    Choreographer mChoreographer;
    private final CloseGuard mCloseGuard;
    private InputChannel mInputChannel;
    public IInputEventReceiverExt mInputEventReceiverExt;
    private MessageQueue mMessageQueue;
    private long mReceiverPtr;
    private final SparseIntArray mSeqMap;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface Factory {
        InputEventReceiver createInputEventReceiver(InputChannel inputChannel, Looper looper);
    }

    private static native boolean nativeConsumeBatchedInputEvents(long j10, long j11);

    private static native void nativeDispose(long j10);

    private static native String nativeDump(long j10, String str);

    private static native void nativeFinishInputEvent(long j10, int i10, boolean z10);

    private static native long nativeInit(WeakReference<InputEventReceiver> weakReference, InputChannel inputChannel, MessageQueue messageQueue);

    private static native void nativeReportTimeline(long j10, int i10, long j11, long j12);

    private static native void nativeSetOplusResampleTouch(long j10, boolean z10);

    public InputEventReceiver(InputChannel inputChannel, Looper looper) {
        CloseGuard closeGuard = CloseGuard.get();
        this.mCloseGuard = closeGuard;
        this.mSeqMap = new SparseIntArray();
        this.mInputEventReceiverExt = (IInputEventReceiverExt) ExtLoader.type(IInputEventReceiverExt.class).base(this).create();
        if (inputChannel == null) {
            throw new IllegalArgumentException("inputChannel must not be null");
        }
        if (looper == null) {
            throw new IllegalArgumentException("looper must not be null");
        }
        this.mInputChannel = inputChannel;
        this.mMessageQueue = looper.getQueue();
        this.mReceiverPtr = nativeInit(new WeakReference(this), this.mInputChannel, this.mMessageQueue);
        closeGuard.open("InputEventReceiver.dispose");
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

    private void dispose(boolean finalized) {
        CloseGuard closeGuard = this.mCloseGuard;
        if (closeGuard != null) {
            if (finalized) {
                closeGuard.warnIfOpen();
            }
            this.mCloseGuard.close();
        }
        long j10 = this.mReceiverPtr;
        if (j10 != 0) {
            nativeDispose(j10);
            this.mReceiverPtr = 0L;
        }
        InputChannel inputChannel = this.mInputChannel;
        if (inputChannel != null) {
            inputChannel.dispose();
            this.mInputChannel = null;
        }
        this.mMessageQueue = null;
        Reference.reachabilityFence(this);
    }

    public void onInputEvent(InputEvent event) {
        finishInputEvent(event, false);
    }

    public void onFocusEvent(boolean hasFocus) {
    }

    public void onPointerCaptureEvent(boolean pointerCaptureEnabled) {
    }

    public void onDragEvent(boolean isExiting, float x10, float y10) {
    }

    public void onTouchModeChanged(boolean inTouchMode) {
    }

    public void onBatchedInputEventPending(int source) {
        consumeBatchedInputEvents(-1L);
    }

    public final void finishInputEvent(InputEvent event, boolean handled) {
        if (event == null) {
            throw new IllegalArgumentException("event must not be null");
        }
        if (this.mReceiverPtr == 0) {
            Log.w(TAG, "Attempted to finish an input event but the input event receiver has already been disposed.");
        } else {
            int index = this.mSeqMap.indexOfKey(event.getSequenceNumber());
            if (index < 0) {
                Log.w(TAG, "Attempted to finish an input event that is not in progress.");
            } else {
                int seq = this.mSeqMap.valueAt(index);
                this.mSeqMap.removeAt(index);
                nativeFinishInputEvent(this.mReceiverPtr, seq, handled);
            }
        }
        event.recycleIfNeededAfterDispatch();
    }

    public final void reportTimeline(int inputEventId, long gpuCompletedTime, long presentTime) {
        Trace.traceBegin(4L, "reportTimeline");
        nativeReportTimeline(this.mReceiverPtr, inputEventId, gpuCompletedTime, presentTime);
        Trace.traceEnd(4L);
    }

    public final boolean consumeBatchedInputEvents(long frameTimeNanos) {
        long j10 = this.mReceiverPtr;
        if (j10 == 0) {
            Log.w(TAG, "Attempted to consume batched input events but the input event receiver has already been disposed.");
            return false;
        }
        return nativeConsumeBatchedInputEvents(j10, frameTimeNanos);
    }

    public IBinder getToken() {
        InputChannel inputChannel = this.mInputChannel;
        if (inputChannel == null) {
            return null;
        }
        return inputChannel.getToken();
    }

    private void dispatchInputEvent(int seq, InputEvent event) {
        this.mSeqMap.put(event.getSequenceNumber(), seq);
        onInputEvent(event);
        this.mInputEventReceiverExt.markOnInputEvent(event);
    }

    private void dispatchMotionEventInfo(int motionEventType, int touchMoveNum) {
        try {
            if (this.mChoreographer == null) {
                this.mChoreographer = Choreographer.getInstance();
            }
            Choreographer choreographer = this.mChoreographer;
            if (choreographer != null && choreographer.mChoreographerSocExt != null) {
                this.mChoreographer.mChoreographerSocExt.setMotionEventInfo(motionEventType, touchMoveNum);
            }
        } catch (Exception e2) {
            Log.e(TAG, "cannot invoke setMotionEventInfo.");
        }
    }

    public void dump(String prefix, PrintWriter writer) {
        writer.println(prefix + getClass().getName());
        writer.println(prefix + " mInputChannel: " + ((Object) this.mInputChannel));
        writer.println(prefix + " mSeqMap: " + ((Object) this.mSeqMap));
        writer.println(prefix + " mReceiverPtr:\n" + nativeDump(this.mReceiverPtr, prefix + "  "));
    }

    public final void setOplusResampleTouch(boolean enabled) {
        long j10 = this.mReceiverPtr;
        if (j10 == 0) {
            Log.w(TAG, "setOplusResampleTouch failed, receiver has already been disposed.");
        } else {
            nativeSetOplusResampleTouch(j10, enabled);
        }
    }
}
