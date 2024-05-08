package android.view;

import android.os.Handler;
import android.util.BoostFramework;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ChoreographerSocExtImpl implements IChoreographerSocExt {
    private static final int MOTION_EVENT_ACTION_CANCEL = 3;
    private static final int MOTION_EVENT_ACTION_DOWN = 0;
    private static final int MOTION_EVENT_ACTION_MOVE = 2;
    private static final int MOTION_EVENT_ACTION_UP = 1;
    private static final boolean OPTS_INPUT = false;
    private Choreographer mChoreographer;
    private int mTouchMoveNum = -1;
    private int mMotionEventType = -1;
    private boolean mConsumedMove = false;
    private boolean mConsumedDown = false;
    private boolean mIsVsyncScheduled = false;
    private long mLastTouchOptTimeNanos = 0;
    private boolean mIsDoFrameProcessing = false;

    public ChoreographerSocExtImpl(Object obj) {
        this.mChoreographer = null;
        this.mChoreographer = (Choreographer) obj;
    }

    @Override // android.view.IChoreographerSocExt
    public void setFrameInterval(long frameIntervalNanos) {
        BoostFramework.ScrollOptimizer.setFrameInterval(frameIntervalNanos);
    }

    @Override // android.view.IChoreographerSocExt
    public boolean hookScheduleFrameLocked(boolean USE_VSYNC, Handler handler, long mFrameIntervalNanos) {
        return BoostFramework.ScrollOptimizer.shouldUseVsync(USE_VSYNC);
    }

    @Override // android.view.IChoreographerSocExt
    public long getFrameDelay(long frameDelay, long lastFrameTimeNanos) {
        return BoostFramework.ScrollOptimizer.getFrameDelay(frameDelay, lastFrameTimeNanos);
    }

    @Override // android.view.IChoreographerSocExt
    public void setMotionEventInfo(int motionEventType, int touchMoveNum) {
        synchronized (this.mChoreographer) {
            this.mTouchMoveNum = touchMoveNum;
            this.mMotionEventType = motionEventType;
            BoostFramework.ScrollOptimizer.setMotionType(motionEventType);
        }
    }

    @Override // android.view.IChoreographerSocExt
    public void setIsDoFrameProcessing(boolean isDoFrameProcessing) {
        this.mIsDoFrameProcessing = isDoFrameProcessing;
    }

    @Override // android.view.IChoreographerSocExt
    public void setUITaskStatus(boolean isUITask) {
        BoostFramework.ScrollOptimizer.setUITaskStatus(isUITask);
    }

    @Override // android.view.IChoreographerSocExt
    public void setVsyncTime(long timestampNanos) {
        BoostFramework.ScrollOptimizer.setVsyncTime(timestampNanos);
    }

    @Override // android.view.IChoreographerSocExt
    public void setIsVsyncScheduled(boolean isVsyncScheduled) {
        this.mIsVsyncScheduled = isVsyncScheduled;
    }

    @Override // android.view.IChoreographerSocExt
    public void setScheduleVsync(boolean isscheduleVsync) {
        this.mIsVsyncScheduled = isscheduleVsync;
    }

    @Override // android.view.IChoreographerSocExt
    public void hookDoFramePerfHint(long vsyncId, boolean begin) {
    }

    @Override // android.view.IChoreographerSocExt
    public void hookDoCallbackPerfHint(int callbackType, boolean begin) {
    }

    @Override // android.view.IChoreographerSocExt
    public void checkAndSetFrameInterval(long frameIntervalNanos) {
        long currentFrameIntervalNanos = this.mChoreographer.getWrapper().getFrameIntervalNanos();
        if (frameIntervalNanos > 0 && Math.abs(frameIntervalNanos - currentFrameIntervalNanos) > 1000000) {
            this.mChoreographer.getWrapper().setFrameIntervalNanos(frameIntervalNanos);
            BoostFramework.ScrollOptimizer.setFrameInterval(frameIntervalNanos);
        }
    }

    @Override // android.view.IChoreographerSocExt
    public void hookRequestVsyncHint() {
    }
}
