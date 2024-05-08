package android.view;

import android.graphics.FrameInfo;
import android.hardware.display.DisplayManagerGlobal;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.util.Log;
import android.util.TimeUtils;
import android.view.DisplayEventReceiver;
import java.io.PrintWriter;
import system.ext.loader.core.ExtLoader;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class Choreographer {
    public static final int CALLBACK_ANIMATION = 1;
    public static final int CALLBACK_COMMIT = 4;
    public static final int CALLBACK_INPUT = 0;
    public static final int CALLBACK_INSETS_ANIMATION = 2;
    private static final int CALLBACK_LAST = 4;
    public static final int CALLBACK_TRAVERSAL = 3;
    private static final boolean DEBUG_FRAMES = false;
    private static final boolean DEBUG_JANK = false;
    private static final long DEFAULT_FRAME_DELAY = 10;
    public static final int MSG_DO_ANIM_CALLBACK = 103;
    private static final int MSG_DO_FRAME = 0;
    public static final int MSG_DO_FRAME_INSERT = 104;
    private static final int MSG_DO_SCHEDULE_CALLBACK = 2;
    private static final int MSG_DO_SCHEDULE_VSYNC = 1;
    private static final String TAG = "Choreographer";
    private static volatile Choreographer mMainInstance;
    private CallbackRecord mCallbackPool;
    private final CallbackQueue[] mCallbackQueues;
    private boolean mCallbacksRunning;
    public IChoreographerExt mChoreographerExt;
    public IChoreographerSocExt mChoreographerSocExt;
    private IChoreographerWrapper mChoreographerWrapper;
    private boolean mDebugPrintNextFrameTimeDelta;
    private final FrameDisplayEventReceiver mDisplayEventReceiver;
    private int mFPSDivisor;
    private final FrameData mFrameData;
    FrameInfo mFrameInfo;

    @Deprecated
    private long mFrameIntervalNanos;
    private boolean mFrameScheduled;
    private final FrameHandler mHandler;
    private long mLastFrameIntervalNanos;
    private long mLastFrameTimeNanos;
    private final DisplayEventReceiver.VsyncEventData mLastVsyncEventData;
    private final Object mLock;
    private final Looper mLooper;
    private static volatile long sFrameDelay = 10;
    private static final ThreadLocal<Choreographer> sThreadInstance = new ThreadLocal<Choreographer>() { // from class: android.view.Choreographer.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Choreographer initialValue() {
            Looper looper = Looper.myLooper();
            if (looper == null) {
                throw new IllegalStateException("The current thread must have a looper!");
            }
            Choreographer choreographer = new Choreographer(looper, 0);
            if (looper == Looper.getMainLooper()) {
                Choreographer.mMainInstance = choreographer;
            }
            return choreographer;
        }
    };
    private static final ThreadLocal<Choreographer> sSfThreadInstance = new ThreadLocal<Choreographer>() { // from class: android.view.Choreographer.2
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Choreographer initialValue() {
            Looper looper = Looper.myLooper();
            if (looper == null) {
                throw new IllegalStateException("The current thread must have a looper!");
            }
            return new Choreographer(looper, 1);
        }
    };
    private static final boolean USE_VSYNC = SystemProperties.getBoolean("debug.choreographer.vsync", true);
    private static final boolean USE_FRAME_TIME = SystemProperties.getBoolean("debug.choreographer.frametime", true);
    private static final int SKIPPED_FRAME_WARNING_LIMIT = SystemProperties.getInt("debug.choreographer.skipwarning", 30);
    private static final Object FRAME_CALLBACK_TOKEN = new Object() { // from class: android.view.Choreographer.3
        public String toString() {
            return "FRAME_CALLBACK_TOKEN";
        }
    };
    private static final Object VSYNC_CALLBACK_TOKEN = new Object() { // from class: android.view.Choreographer.4
        public String toString() {
            return "VSYNC_CALLBACK_TOKEN";
        }
    };
    private static final String[] CALLBACK_TRACE_TITLES = {"input", "animation", "insets_animation", "traversal", "commit"};

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface FrameCallback {
        void doFrame(long j10);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface VsyncCallback {
        void onVsync(FrameData frameData);
    }

    private Choreographer(Looper looper, int vsyncSource) {
        this(looper, vsyncSource, 0L);
    }

    private Choreographer(Looper looper, int i10, long j10) {
        FrameDisplayEventReceiver frameDisplayEventReceiver;
        this.mLock = new Object();
        this.mFPSDivisor = 1;
        this.mLastVsyncEventData = new DisplayEventReceiver.VsyncEventData();
        this.mFrameData = new FrameData();
        this.mFrameInfo = new FrameInfo();
        byte b4 = 0;
        this.mChoreographerWrapper = new ChoreographerWrapper();
        this.mChoreographerExt = (IChoreographerExt) ExtLoader.type(IChoreographerExt.class).base(this).create();
        this.mLooper = looper;
        this.mHandler = new FrameHandler(looper);
        if (USE_VSYNC) {
            frameDisplayEventReceiver = new FrameDisplayEventReceiver(looper, i10, j10);
        } else {
            frameDisplayEventReceiver = null;
        }
        this.mDisplayEventReceiver = frameDisplayEventReceiver;
        this.mLastFrameTimeNanos = Long.MIN_VALUE;
        this.mFrameIntervalNanos = 1.0E9f / getRefreshRate();
        IChoreographerSocExt iChoreographerSocExt = (IChoreographerSocExt) ExtLoader.type(IChoreographerSocExt.class).base(this).create();
        this.mChoreographerSocExt = iChoreographerSocExt;
        iChoreographerSocExt.setFrameInterval(this.mFrameIntervalNanos);
        this.mCallbackQueues = new CallbackQueue[5];
        for (int i11 = 0; i11 <= 4; i11++) {
            this.mCallbackQueues[i11] = new CallbackQueue();
        }
        setFPSDivisor(SystemProperties.getInt(ThreadedRenderer.DEBUG_FPS_DIVISOR, 1));
        this.mChoreographerExt.onChoreographerInit();
    }

    private static float getRefreshRate() {
        DisplayInfo di = DisplayManagerGlobal.getInstance().getDisplayInfo(0);
        return di.getRefreshRate();
    }

    public static Choreographer getInstance() {
        return sThreadInstance.get();
    }

    public static Choreographer getSfInstance() {
        return sSfThreadInstance.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Choreographer getInstanceForSurfaceControl(long layerHandle, Looper looper) {
        if (looper == null) {
            throw new IllegalStateException("The current thread must have a looper!");
        }
        return new Choreographer(looper, 0, layerHandle);
    }

    public static Choreographer getMainThreadInstance() {
        return mMainInstance;
    }

    public static void releaseInstance() {
        ThreadLocal<Choreographer> threadLocal = sThreadInstance;
        Choreographer old = threadLocal.get();
        threadLocal.remove();
        old.dispose();
    }

    private void dispose() {
        this.mDisplayEventReceiver.dispose();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invalidate() {
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isTheLooperSame(Looper looper) {
        return this.mLooper == looper;
    }

    public static long getFrameDelay() {
        return sFrameDelay;
    }

    public static void setFrameDelay(long frameDelay) {
        sFrameDelay = frameDelay;
    }

    public static long subtractFrameDelay(long delayMillis) {
        long frameDelay = sFrameDelay;
        if (delayMillis <= frameDelay) {
            return 0L;
        }
        return delayMillis - frameDelay;
    }

    public long getFrameIntervalNanos() {
        long j10;
        synchronized (this.mLock) {
            j10 = this.mLastFrameIntervalNanos;
        }
        return j10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dump(String prefix, PrintWriter writer) {
        String innerPrefix = prefix + "  ";
        writer.print(prefix);
        writer.println("Choreographer:");
        writer.print(innerPrefix);
        writer.print("mFrameScheduled=");
        writer.println(this.mFrameScheduled);
        writer.print(innerPrefix);
        writer.print("mLastFrameTime=");
        writer.println(TimeUtils.formatUptime(this.mLastFrameTimeNanos / 1000000));
    }

    public void postCallback(int callbackType, Runnable action, Object token) {
        postCallbackDelayed(callbackType, action, token, 0L);
    }

    public void postCallbackDelayed(int callbackType, Runnable action, Object token, long delayMillis) {
        if (action == null) {
            throw new IllegalArgumentException("action must not be null");
        }
        if (callbackType < 0 || callbackType > 4) {
            throw new IllegalArgumentException("callbackType is invalid");
        }
        postCallbackDelayedInternal(callbackType, action, token, delayMillis);
    }

    private void postCallbackDelayedInternal(int callbackType, Object action, Object token, long delayMillis) {
        synchronized (this.mLock) {
            long now = SystemClock.uptimeMillis();
            long dueTime = now + delayMillis;
            this.mCallbackQueues[callbackType].addCallbackLocked(dueTime, action, token);
            if (dueTime <= now) {
                scheduleFrameLocked(now);
            } else {
                Message msg = this.mHandler.obtainMessage(2, action);
                msg.arg1 = callbackType;
                msg.setAsynchronous(true);
                this.mHandler.sendMessageAtTime(msg, dueTime);
            }
        }
    }

    public void postVsyncCallback(VsyncCallback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        postCallbackDelayedInternal(1, callback, VSYNC_CALLBACK_TOKEN, 0L);
    }

    public void removeCallbacks(int callbackType, Runnable action, Object token) {
        if (callbackType < 0 || callbackType > 4) {
            throw new IllegalArgumentException("callbackType is invalid");
        }
        removeCallbacksInternal(callbackType, action, token);
    }

    private void removeCallbacksInternal(int callbackType, Object action, Object token) {
        synchronized (this.mLock) {
            this.mCallbackQueues[callbackType].removeCallbacksLocked(action, token);
            if (action != null && token == null) {
                this.mHandler.removeMessages(2, action);
            }
        }
    }

    public void postFrameCallback(FrameCallback callback) {
        postFrameCallbackDelayed(callback, 0L);
    }

    public void postFrameCallbackDelayed(FrameCallback callback, long delayMillis) {
        if (callback == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        postCallbackDelayedInternal(1, callback, FRAME_CALLBACK_TOKEN, delayMillis);
    }

    public void removeFrameCallback(FrameCallback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        removeCallbacksInternal(1, callback, FRAME_CALLBACK_TOKEN);
    }

    public void removeVsyncCallback(VsyncCallback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        removeCallbacksInternal(1, callback, VSYNC_CALLBACK_TOKEN);
    }

    public long getFrameTime() {
        return getFrameTimeNanos() / 1000000;
    }

    public long getFrameTimeNanos() {
        long nanoTime;
        synchronized (this.mLock) {
            if (!this.mCallbacksRunning) {
                throw new IllegalStateException("This method must only be called as part of a callback while a frame is in progress.");
            }
            nanoTime = USE_FRAME_TIME ? this.mLastFrameTimeNanos : System.nanoTime();
        }
        return nanoTime;
    }

    public long getLastFrameTimeNanos() {
        long nanoTime;
        synchronized (this.mLock) {
            nanoTime = USE_FRAME_TIME ? this.mLastFrameTimeNanos : System.nanoTime();
        }
        return nanoTime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scheduleFrameLocked(long now) {
        if (!this.mFrameScheduled) {
            this.mFrameScheduled = true;
            if (this.mChoreographerSocExt.hookScheduleFrameLocked(USE_VSYNC, this.mHandler, this.mFrameIntervalNanos)) {
                if (!isRunningOnLooperThreadLocked()) {
                    Message msg = this.mHandler.obtainMessage(1);
                    msg.setAsynchronous(true);
                    this.mHandler.sendMessageAtFrontOfQueue(msg);
                    return;
                }
                scheduleVsyncLocked();
                return;
            }
            sFrameDelay = this.mChoreographerSocExt.getFrameDelay(sFrameDelay, this.mLastFrameTimeNanos);
            long nextFrameTime = Math.max((this.mLastFrameTimeNanos / 1000000) + sFrameDelay, now);
            Message msg2 = this.mHandler.obtainMessage(0);
            msg2.setAsynchronous(true);
            this.mHandler.sendMessageAtTime(msg2, nextFrameTime);
        }
    }

    public long getVsyncId() {
        return this.mLastVsyncEventData.preferredFrameTimeline().vsyncId;
    }

    public long getFrameDeadline() {
        return this.mLastVsyncEventData.preferredFrameTimeline().deadline;
    }

    void setFPSDivisor(int divisor) {
        if (divisor <= 0) {
            divisor = 1;
        }
        this.mFPSDivisor = divisor;
        ThreadedRenderer.setFPSDivisor(divisor);
    }

    private void traceMessage(String msg) {
        Trace.traceBegin(8L, msg);
        Trace.traceEnd(8L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:122:0x044b  */
    /* JADX WARN: Type inference failed for: r15v25 */
    /* JADX WARN: Type inference failed for: r18v2, types: [long] */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v5, types: [android.view.Choreographer$FrameData] */
    /* JADX WARN: Type inference failed for: r3v1, types: [long] */
    /* JADX WARN: Type inference failed for: r3v20, types: [android.view.DisplayEventReceiver, android.view.Choreographer$FrameDisplayEventReceiver] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void doFrame(long r45, int r47, android.view.DisplayEventReceiver.VsyncEventData r48) {
        /*
            Method dump skipped, instructions count: 1117
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.Choreographer.doFrame(long, int, android.view.DisplayEventReceiver$VsyncEventData):void");
    }

    void doCallbacks(int callbackType, long frameIntervalNanos) {
        long frameTimeNanos = this.mFrameData.mFrameTimeNanos;
        synchronized (this.mLock) {
            long now = System.nanoTime();
            CallbackRecord callbacks = this.mCallbackQueues[callbackType].extractDueCallbacksLocked(now / 1000000);
            if (callbacks == null) {
                return;
            }
            this.mCallbacksRunning = true;
            if (callbackType == 4) {
                long jitterNanos = now - frameTimeNanos;
                Trace.traceCounter(8L, "jitterNanos", (int) jitterNanos);
                if (jitterNanos >= 2 * frameIntervalNanos) {
                    long lastFrameOffset = (jitterNanos % frameIntervalNanos) + frameIntervalNanos;
                    long frameTimeNanos2 = now - lastFrameOffset;
                    this.mLastFrameTimeNanos = frameTimeNanos2;
                    this.mFrameData.update(frameTimeNanos2, this.mDisplayEventReceiver, jitterNanos);
                }
            }
            try {
                Trace.traceBegin(8L, CALLBACK_TRACE_TITLES[callbackType]);
                this.mChoreographerSocExt.hookDoCallbackPerfHint(callbackType, true);
                for (CallbackRecord c4 = callbacks; c4 != null; c4 = c4.next) {
                    c4.run(this.mFrameData);
                }
                synchronized (this.mLock) {
                    this.mCallbacksRunning = false;
                    do {
                        CallbackRecord next = callbacks.next;
                        recycleCallbackLocked(callbacks);
                        callbacks = next;
                    } while (callbacks != null);
                }
                this.mChoreographerSocExt.hookDoCallbackPerfHint(callbackType, false);
                Trace.traceEnd(8L);
            } catch (Throwable th) {
                synchronized (this.mLock) {
                    this.mCallbacksRunning = false;
                    do {
                        CallbackRecord next2 = callbacks.next;
                        recycleCallbackLocked(callbacks);
                        callbacks = next2;
                    } while (callbacks != null);
                    this.mChoreographerSocExt.hookDoCallbackPerfHint(callbackType, false);
                    Trace.traceEnd(8L);
                    throw th;
                }
            }
        }
    }

    void doScheduleVsync() {
        synchronized (this.mLock) {
            if (this.mFrameScheduled) {
                scheduleVsyncLocked();
            }
        }
    }

    void doScheduleCallback(int callbackType) {
        synchronized (this.mLock) {
            if (!this.mFrameScheduled) {
                long now = SystemClock.uptimeMillis();
                if (this.mCallbackQueues[callbackType].hasDueCallbacksLocked(now)) {
                    scheduleFrameLocked(now);
                }
            }
        }
    }

    private void scheduleVsyncLocked() {
        try {
            Trace.traceBegin(8L, "Choreographer#scheduleVsyncLocked");
            this.mDisplayEventReceiver.scheduleVsync();
            this.mChoreographerSocExt.setScheduleVsync(true);
            this.mChoreographerExt.setScheduleVsync();
        } finally {
            Trace.traceEnd(8L);
            this.mChoreographerSocExt.hookRequestVsyncHint();
        }
    }

    private boolean isRunningOnLooperThreadLocked() {
        return Looper.myLooper() == this.mLooper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CallbackRecord obtainCallbackLocked(long dueTime, Object action, Object token) {
        CallbackRecord callback = this.mCallbackPool;
        if (callback == null) {
            callback = new CallbackRecord();
        } else {
            this.mCallbackPool = callback.next;
            callback.next = null;
        }
        callback.dueTime = dueTime;
        callback.action = action;
        callback.token = token;
        return callback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recycleCallbackLocked(CallbackRecord callback) {
        callback.action = null;
        callback.token = null;
        callback.next = this.mCallbackPool;
        this.mCallbackPool = callback;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class FrameTimeline {
        private long mVsyncId = -1;
        private long mExpectedPresentationTimeNanos = -1;
        private long mDeadlineNanos = -1;
        private boolean mInCallback = false;

        FrameTimeline() {
        }

        void setInCallback(boolean inCallback) {
            this.mInCallback = inCallback;
        }

        private void checkInCallback() {
            if (!this.mInCallback) {
                throw new IllegalStateException("FrameTimeline is not valid outside of the vsync callback");
            }
        }

        void update(long vsyncId, long expectedPresentationTimeNanos, long deadlineNanos) {
            this.mVsyncId = vsyncId;
            this.mExpectedPresentationTimeNanos = expectedPresentationTimeNanos;
            this.mDeadlineNanos = deadlineNanos;
        }

        public long getVsyncId() {
            checkInCallback();
            return this.mVsyncId;
        }

        public long getExpectedPresentationTimeNanos() {
            checkInCallback();
            return this.mExpectedPresentationTimeNanos;
        }

        public long getDeadlineNanos() {
            checkInCallback();
            return this.mDeadlineNanos;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class FrameData {
        private long mFrameTimeNanos;
        private FrameTimeline[] mFrameTimelines;
        private boolean mInCallback = false;
        private int mPreferredFrameTimelineIndex;

        FrameData() {
            allocateFrameTimelines(7);
        }

        public long getFrameTimeNanos() {
            checkInCallback();
            return this.mFrameTimeNanos;
        }

        public FrameTimeline[] getFrameTimelines() {
            checkInCallback();
            return this.mFrameTimelines;
        }

        public FrameTimeline getPreferredFrameTimeline() {
            checkInCallback();
            return this.mFrameTimelines[this.mPreferredFrameTimelineIndex];
        }

        void setInCallback(boolean inCallback) {
            this.mInCallback = inCallback;
            int i10 = 0;
            while (true) {
                FrameTimeline[] frameTimelineArr = this.mFrameTimelines;
                if (i10 < frameTimelineArr.length) {
                    frameTimelineArr[i10].setInCallback(inCallback);
                    i10++;
                } else {
                    return;
                }
            }
        }

        private void checkInCallback() {
            if (!this.mInCallback) {
                throw new IllegalStateException("FrameData is not valid outside of the vsync callback");
            }
        }

        private void allocateFrameTimelines(int length) {
            this.mFrameTimelines = new FrameTimeline[length];
            int i10 = 0;
            while (true) {
                FrameTimeline[] frameTimelineArr = this.mFrameTimelines;
                if (i10 < frameTimelineArr.length) {
                    frameTimelineArr[i10] = new FrameTimeline();
                    i10++;
                } else {
                    return;
                }
            }
        }

        FrameTimeline update(long frameTimeNanos, DisplayEventReceiver.VsyncEventData vsyncEventData) {
            if (this.mFrameTimelines.length != vsyncEventData.frameTimelinesLength) {
                allocateFrameTimelines(vsyncEventData.frameTimelinesLength);
            }
            this.mFrameTimeNanos = frameTimeNanos;
            this.mPreferredFrameTimelineIndex = vsyncEventData.preferredFrameTimelineIndex;
            int i10 = 0;
            while (true) {
                FrameTimeline[] frameTimelineArr = this.mFrameTimelines;
                if (i10 < frameTimelineArr.length) {
                    DisplayEventReceiver.VsyncEventData.FrameTimeline frameTimeline = vsyncEventData.frameTimelines[i10];
                    this.mFrameTimelines[i10].update(frameTimeline.vsyncId, frameTimeline.expectedPresentationTime, frameTimeline.deadline);
                    i10++;
                } else {
                    int i11 = this.mPreferredFrameTimelineIndex;
                    return frameTimelineArr[i11];
                }
            }
        }

        FrameTimeline update(long frameTimeNanos, DisplayEventReceiver displayEventReceiver, long jitterNanos) {
            int newPreferredIndex = 0;
            long minimumDeadline = this.mFrameTimelines[this.mPreferredFrameTimelineIndex].mDeadlineNanos + jitterNanos;
            while (true) {
                FrameTimeline[] frameTimelineArr = this.mFrameTimelines;
                if (newPreferredIndex >= frameTimelineArr.length - 1 || frameTimelineArr[newPreferredIndex].mDeadlineNanos >= minimumDeadline) {
                    break;
                }
                newPreferredIndex++;
            }
            long newPreferredDeadline = this.mFrameTimelines[newPreferredIndex].mDeadlineNanos;
            if (newPreferredDeadline < minimumDeadline) {
                DisplayEventReceiver.VsyncEventData latestVsyncEventData = displayEventReceiver.getLatestVsyncEventData();
                update(frameTimeNanos, latestVsyncEventData);
            } else {
                update(frameTimeNanos, newPreferredIndex);
            }
            return this.mFrameTimelines[this.mPreferredFrameTimelineIndex];
        }

        void update(long frameTimeNanos, int newPreferredFrameTimelineIndex) {
            this.mFrameTimeNanos = frameTimeNanos;
            this.mPreferredFrameTimelineIndex = newPreferredFrameTimelineIndex;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class FrameHandler extends Handler {
        public FrameHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    Choreographer.this.doFrame(System.nanoTime(), 0, new DisplayEventReceiver.VsyncEventData());
                    return;
                case 1:
                    Choreographer.this.doScheduleVsync();
                    return;
                case 2:
                    Choreographer.this.doScheduleCallback(msg.arg1);
                    return;
                case 103:
                    Choreographer.this.mChoreographerExt.doAnimAheadCallback((FrameData) msg.obj);
                    return;
                case 104:
                    Choreographer.this.mChoreographerSocExt.hookDoFramePerfHint(-1L, true);
                    Choreographer.this.mChoreographerExt.doFrameInsert(System.nanoTime(), msg.arg1);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class FrameDisplayEventReceiver extends DisplayEventReceiver implements Runnable {
        private int mFrame;
        private boolean mHavePendingVsync;
        private final DisplayEventReceiver.VsyncEventData mLastVsyncEventData;
        private long mTimestampNanos;

        FrameDisplayEventReceiver(Looper looper, int vsyncSource, long layerHandle) {
            super(looper, vsyncSource, 0, layerHandle);
            this.mLastVsyncEventData = new DisplayEventReceiver.VsyncEventData();
        }

        @Override // android.view.DisplayEventReceiver
        public void onVsync(long timestampNanos, long physicalDisplayId, int frame, DisplayEventReceiver.VsyncEventData vsyncEventData) {
            long timestampNanos2;
            try {
                if (Trace.isTagEnabled(8L)) {
                    try {
                        Trace.traceBegin(8L, "Choreographer#onVsync " + vsyncEventData.preferredFrameTimeline().vsyncId + Choreographer.this.mChoreographerExt.markOnDoframe(vsyncEventData, timestampNanos, Choreographer.this.mLastFrameTimeNanos));
                    } catch (Throwable th) {
                        th = th;
                        Trace.traceEnd(8L);
                        throw th;
                    }
                }
                long now = System.nanoTime();
                if (timestampNanos <= now) {
                    timestampNanos2 = timestampNanos;
                } else {
                    Log.w(Choreographer.TAG, "Frame time is " + (((float) (timestampNanos - now)) * 1.0E-6f) + " ms in the future!  Check that graphics HAL is generating vsync timestamps using the correct timebase.");
                    timestampNanos2 = now;
                }
                try {
                    Choreographer.this.mChoreographerExt.dispatchVsyncData(timestampNanos2, vsyncEventData);
                    if (this.mHavePendingVsync) {
                        Log.w(Choreographer.TAG, "Already have a pending vsync event.  There should only be one at a time.");
                    } else {
                        this.mHavePendingVsync = true;
                    }
                    this.mTimestampNanos = timestampNanos2;
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    this.mFrame = frame;
                    this.mLastVsyncEventData.copyFrom(vsyncEventData);
                    Choreographer.this.mChoreographerSocExt.setVsyncTime(this.mTimestampNanos);
                    this.mLastVsyncEventData.copyFrom(vsyncEventData);
                    Message msg = Message.obtain(Choreographer.this.mHandler, this);
                    msg.setAsynchronous(true);
                    Choreographer.this.mHandler.sendMessageAtTime(msg, timestampNanos2 / 1000000);
                    Choreographer.this.mChoreographerSocExt.hookDoFramePerfHint(vsyncEventData.preferredFrameTimeline().vsyncId, true);
                    Trace.traceEnd(8L);
                } catch (Throwable th3) {
                    th = th3;
                    Trace.traceEnd(8L);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mHavePendingVsync = false;
            Choreographer.this.doFrame(this.mTimestampNanos, this.mFrame, this.mLastVsyncEventData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class CallbackRecord {
        public Object action;
        public long dueTime;
        public CallbackRecord next;
        public Object token;

        private CallbackRecord() {
        }

        public void run(long frameTimeNanos) {
            if (this.token == Choreographer.FRAME_CALLBACK_TOKEN) {
                ((FrameCallback) this.action).doFrame(frameTimeNanos);
            } else {
                ((Runnable) this.action).run();
            }
        }

        void run(FrameData frameData) {
            frameData.setInCallback(true);
            if (this.token == Choreographer.VSYNC_CALLBACK_TOKEN) {
                ((VsyncCallback) this.action).onVsync(frameData);
            } else {
                run(frameData.getFrameTimeNanos());
            }
            frameData.setInCallback(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class CallbackQueue {
        private CallbackRecord mHead;

        private CallbackQueue() {
        }

        public boolean hasDueCallbacksLocked(long now) {
            CallbackRecord callbackRecord = this.mHead;
            return callbackRecord != null && callbackRecord.dueTime <= now;
        }

        public CallbackRecord extractDueCallbacksLocked(long now) {
            CallbackRecord callbacks = this.mHead;
            if (callbacks == null || callbacks.dueTime > now) {
                return null;
            }
            CallbackRecord last = callbacks;
            CallbackRecord next = last.next;
            while (true) {
                if (next == null) {
                    break;
                }
                if (next.dueTime > now) {
                    last.next = null;
                    break;
                }
                last = next;
                next = next.next;
            }
            this.mHead = next;
            return callbacks;
        }

        public void addCallbackLocked(long dueTime, Object action, Object token) {
            CallbackRecord callback = Choreographer.this.obtainCallbackLocked(dueTime, action, token);
            CallbackRecord entry = this.mHead;
            if (entry == null) {
                this.mHead = callback;
                return;
            }
            if (dueTime < entry.dueTime) {
                callback.next = entry;
                this.mHead = callback;
                return;
            }
            while (true) {
                if (entry.next == null) {
                    break;
                }
                if (dueTime < entry.next.dueTime) {
                    callback.next = entry.next;
                    break;
                }
                entry = entry.next;
            }
            entry.next = callback;
        }

        public void removeCallbacksLocked(Object action, Object token) {
            CallbackRecord predecessor = null;
            CallbackRecord callback = this.mHead;
            while (callback != null) {
                CallbackRecord next = callback.next;
                if ((action == null || callback.action == action) && (token == null || callback.token == token)) {
                    if (predecessor != null) {
                        predecessor.next = next;
                    } else {
                        this.mHead = next;
                    }
                    Choreographer.this.recycleCallbackLocked(callback);
                } else {
                    predecessor = callback;
                }
                callback = next;
            }
        }
    }

    public void doEstimationFrame(long frameTimeNano) {
    }

    public void doPreAnimation(long frameTimeNanos, long frameIntervalNanos) {
    }

    public void forceFrameScheduled() {
    }

    public boolean isEmptyCallback() {
        return true;
    }

    public void forceScheduleNexFrame() {
        scheduleFrameLocked(SystemClock.uptimeMillis());
    }

    public IChoreographerWrapper getWrapper() {
        return this.mChoreographerWrapper;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private class ChoreographerWrapper implements IChoreographerWrapper {
        private ChoreographerWrapper() {
        }

        @Override // android.view.IChoreographerWrapper
        public void scheduleFrameLocked(long now) {
            Choreographer.this.scheduleFrameLocked(now);
        }

        @Override // android.view.IChoreographerWrapper
        public void setFrameScheduled(boolean frameScheduled) {
            Choreographer.this.mFrameScheduled = frameScheduled;
        }

        @Override // android.view.IChoreographerWrapper
        public boolean getFrameScheduled() {
            return Choreographer.this.mFrameScheduled;
        }

        @Override // android.view.IChoreographerWrapper
        public Handler getHandler() {
            return Choreographer.this.mHandler;
        }

        @Override // android.view.IChoreographerWrapper
        public Object getLock() {
            return Choreographer.this.mLock;
        }

        @Override // android.view.IChoreographerWrapper
        public Object getCallbackQueues() {
            return Choreographer.this.mCallbackQueues;
        }

        @Override // android.view.IChoreographerWrapper
        public int getCallbackLastConst() {
            return 4;
        }

        @Override // android.view.IChoreographerWrapper
        public int getMsgDoFrameConst() {
            return 0;
        }

        @Override // android.view.IChoreographerWrapper
        public void addCallbackLockedForCallbackQueue(Object callback, long dueTime, Object action, Object token) {
            if (callback instanceof CallbackQueue) {
                ((CallbackQueue) callback).addCallbackLocked(dueTime, action, token);
            }
        }

        @Override // android.view.IChoreographerWrapper
        public void setFrameTimeNanosForFrameData(FrameData frameData, long frameTimeNanos) {
            frameData.mFrameTimeNanos = frameTimeNanos;
        }

        @Override // android.view.IChoreographerWrapper
        public long getFrameIntervalNanos() {
            return Choreographer.this.mFrameIntervalNanos;
        }

        @Override // android.view.IChoreographerWrapper
        public void setFrameIntervalNanos(long frameIntervalNanos) {
            Choreographer.this.mFrameIntervalNanos = frameIntervalNanos;
        }

        @Override // android.view.IChoreographerWrapper
        public IChoreographerExt getExtImpl() {
            return Choreographer.this.mChoreographerExt;
        }
    }
}
