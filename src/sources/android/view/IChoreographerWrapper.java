package android.view;

import android.os.Handler;
import android.view.Choreographer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IChoreographerWrapper {
    default void scheduleFrameLocked(long now) {
    }

    default void setFrameScheduled(boolean frameScheduled) {
    }

    default boolean getFrameScheduled() {
        return false;
    }

    default Handler getHandler() {
        return null;
    }

    default Object getLock() {
        return null;
    }

    default Object getCallbackQueues() {
        return null;
    }

    default int getCallbackLastConst() {
        return 0;
    }

    default int getMsgDoFrameConst() {
        return 0;
    }

    default void addCallbackLockedForCallbackQueue(Object callback, long dueTime, Object action, Object token) {
    }

    default void setFrameTimeNanosForFrameData(Choreographer.FrameData frameData, long frameTimeNanos) {
    }

    default long getFrameIntervalNanos() {
        return 0L;
    }

    default void setFrameIntervalNanos(long frameIntervalNanos) {
    }

    default IChoreographerExt getExtImpl() {
        return null;
    }
}
