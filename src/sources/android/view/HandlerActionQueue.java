package android.view;

import android.os.Handler;
import com.android.internal.util.GrowingArrayUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class HandlerActionQueue {
    private HandlerAction[] mActions;
    private int mCount;

    public void post(Runnable action) {
        postDelayed(action, 0L);
    }

    public void postDelayed(Runnable action, long delayMillis) {
        HandlerAction handlerAction = new HandlerAction(action, delayMillis);
        synchronized (this) {
            if (this.mActions == null) {
                this.mActions = new HandlerAction[4];
            }
            this.mActions = (HandlerAction[]) GrowingArrayUtils.append(this.mActions, this.mCount, handlerAction);
            this.mCount++;
        }
    }

    public void removeCallbacks(Runnable action) {
        synchronized (this) {
            int count = this.mCount;
            int j10 = 0;
            HandlerAction[] actions = this.mActions;
            for (int i10 = 0; i10 < count; i10++) {
                if (!actions[i10].matches(action)) {
                    if (j10 != i10) {
                        actions[j10] = actions[i10];
                    }
                    j10++;
                }
            }
            this.mCount = j10;
            while (j10 < count) {
                actions[j10] = null;
                j10++;
            }
        }
    }

    public void executeActions(Handler handler) {
        synchronized (this) {
            HandlerAction[] actions = this.mActions;
            int count = this.mCount;
            for (int i10 = 0; i10 < count; i10++) {
                HandlerAction handlerAction = actions[i10];
                handler.postDelayed(handlerAction.action, handlerAction.delay);
            }
            this.mActions = null;
            this.mCount = 0;
        }
    }

    public int size() {
        return this.mCount;
    }

    public Runnable getRunnable(int index) {
        if (index >= this.mCount) {
            throw new IndexOutOfBoundsException();
        }
        return this.mActions[index].action;
    }

    public long getDelay(int index) {
        if (index >= this.mCount) {
            throw new IndexOutOfBoundsException();
        }
        return this.mActions[index].delay;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class HandlerAction {
        final Runnable action;
        final long delay;

        public HandlerAction(Runnable action, long delay) {
            this.action = action;
            this.delay = delay;
        }

        public boolean matches(Runnable otherAction) {
            Runnable runnable;
            return (otherAction == null && this.action == null) || ((runnable = this.action) != null && runnable.equals(otherAction));
        }
    }
}
