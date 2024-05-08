package android.widget;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class EditorTouchState {
    private float mInitialDragDirectionXYRatio;
    private boolean mIsOnHandle;
    private long mLastDownMillis;
    private float mLastDownX;
    private float mLastDownY;
    private long mLastUpMillis;
    private float mLastUpX;
    private float mLastUpY;
    private boolean mMovedEnoughForDrag;
    private boolean mMultiTapInSameArea;
    private int mMultiTapStatus = 0;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface MultiTapStatus {
        public static final int DOUBLE_TAP = 2;
        public static final int FIRST_TAP = 1;
        public static final int NONE = 0;
        public static final int TRIPLE_CLICK = 3;
    }

    public float getLastDownX() {
        return this.mLastDownX;
    }

    public float getLastDownY() {
        return this.mLastDownY;
    }

    public float getLastUpX() {
        return this.mLastUpX;
    }

    public float getLastUpY() {
        return this.mLastUpY;
    }

    public boolean isDoubleTap() {
        return this.mMultiTapStatus == 2;
    }

    public boolean isTripleClick() {
        return this.mMultiTapStatus == 3;
    }

    public boolean isMultiTap() {
        int i10 = this.mMultiTapStatus;
        return i10 == 2 || i10 == 3;
    }

    public boolean isMultiTapInSameArea() {
        return isMultiTap() && this.mMultiTapInSameArea;
    }

    public boolean isMovedEnoughForDrag() {
        return this.mMovedEnoughForDrag;
    }

    public float getInitialDragDirectionXYRatio() {
        return this.mInitialDragDirectionXYRatio;
    }

    public void setIsOnHandle(boolean onHandle) {
        this.mIsOnHandle = onHandle;
    }

    public boolean isOnHandle() {
        return this.mIsOnHandle;
    }

    public void update(MotionEvent event, ViewConfiguration config) {
        int i10;
        int action = event.getActionMasked();
        if (action == 0) {
            boolean isMouse = event.isFromSource(8194);
            long eventTime = event.getEventTime();
            long j10 = this.mLastUpMillis;
            long millisSinceLastUp = eventTime - j10;
            long millisBetweenLastDownAndLastUp = j10 - this.mLastDownMillis;
            if (millisSinceLastUp <= ViewConfiguration.getDoubleTapTimeout() && millisBetweenLastDownAndLastUp <= ViewConfiguration.getDoubleTapTimeout() && ((i10 = this.mMultiTapStatus) == 1 || (i10 == 2 && isMouse))) {
                if (i10 == 1) {
                    this.mMultiTapStatus = 2;
                } else {
                    this.mMultiTapStatus = 3;
                }
                this.mMultiTapInSameArea = isDistanceWithin(this.mLastDownX, this.mLastDownY, event.getX(), event.getY(), config.getScaledDoubleTapSlop());
            } else {
                this.mMultiTapStatus = 1;
                this.mMultiTapInSameArea = false;
            }
            this.mLastDownX = event.getX();
            this.mLastDownY = event.getY();
            this.mLastDownMillis = event.getEventTime();
            this.mMovedEnoughForDrag = false;
            this.mInitialDragDirectionXYRatio = 0.0f;
            return;
        }
        if (action == 1) {
            this.mLastUpX = event.getX();
            this.mLastUpY = event.getY();
            this.mLastUpMillis = event.getEventTime();
            this.mMovedEnoughForDrag = false;
            this.mInitialDragDirectionXYRatio = 0.0f;
            return;
        }
        if (action == 2) {
            if (!this.mMovedEnoughForDrag) {
                float deltaX = event.getX() - this.mLastDownX;
                float deltaY = event.getY() - this.mLastDownY;
                float deltaXSquared = deltaX * deltaX;
                float distanceSquared = (deltaY * deltaY) + deltaXSquared;
                int touchSlop = config.getScaledTouchSlop();
                boolean z10 = distanceSquared > ((float) (touchSlop * touchSlop));
                this.mMovedEnoughForDrag = z10;
                if (z10) {
                    this.mInitialDragDirectionXYRatio = deltaY == 0.0f ? Float.MAX_VALUE : Math.abs(deltaX / deltaY);
                    return;
                }
                return;
            }
            return;
        }
        if (action == 3) {
            this.mLastDownMillis = 0L;
            this.mLastUpMillis = 0L;
            this.mMultiTapStatus = 0;
            this.mMultiTapInSameArea = false;
            this.mMovedEnoughForDrag = false;
            this.mInitialDragDirectionXYRatio = 0.0f;
        }
    }

    public static boolean isDistanceWithin(float x12, float y1, float x22, float y22, int maxDistance) {
        float deltaX = x22 - x12;
        float deltaY = y22 - y1;
        float distanceSquared = (deltaX * deltaX) + (deltaY * deltaY);
        return distanceSquared <= ((float) (maxDistance * maxDistance));
    }

    public static float getXYRatio(int angleFromVerticalInDegrees) {
        if (angleFromVerticalInDegrees <= 0) {
            return 0.0f;
        }
        if (angleFromVerticalInDegrees >= 90) {
            return Float.MAX_VALUE;
        }
        return (float) Math.tan(Math.toRadians(angleFromVerticalInDegrees));
    }
}
