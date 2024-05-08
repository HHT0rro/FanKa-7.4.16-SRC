package android.view;

import android.hardware.input.InputManagerGlobal;
import android.util.ArrayMap;
import android.util.Pools;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class VelocityTracker {
    private static final int ACTIVE_POINTER_ID = -1;
    private static final Map<String, Integer> STRATEGIES;
    public static final int VELOCITY_TRACKER_STRATEGY_DEFAULT = -1;
    public static final int VELOCITY_TRACKER_STRATEGY_IMPULSE = 0;
    public static final int VELOCITY_TRACKER_STRATEGY_INT1 = 7;
    public static final int VELOCITY_TRACKER_STRATEGY_INT2 = 8;
    public static final int VELOCITY_TRACKER_STRATEGY_LEGACY = 9;
    public static final int VELOCITY_TRACKER_STRATEGY_LSQ1 = 1;
    public static final int VELOCITY_TRACKER_STRATEGY_LSQ2 = 2;
    public static final int VELOCITY_TRACKER_STRATEGY_LSQ3 = 3;
    public static final int VELOCITY_TRACKER_STRATEGY_WLSQ2_CENTRAL = 5;
    public static final int VELOCITY_TRACKER_STRATEGY_WLSQ2_DELTA = 4;
    public static final int VELOCITY_TRACKER_STRATEGY_WLSQ2_RECENT = 6;
    private static final Pools.SynchronizedPool<VelocityTracker> sPool = new Pools.SynchronizedPool<>(2);
    private long mPtr;
    private final int mStrategy;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface VelocityTrackableMotionEventAxis {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface VelocityTrackerStrategy {
    }

    private static native void nativeAddMovement(long j10, MotionEvent motionEvent);

    private static native void nativeClear(long j10);

    private static native void nativeComputeCurrentVelocity(long j10, int i10, float f10);

    private static native void nativeDispose(long j10);

    private static native float nativeGetVelocity(long j10, int i10, int i11);

    private static native long nativeInitialize(int i10);

    private static native boolean nativeIsAxisSupported(int i10);

    static {
        ArrayMap arrayMap = new ArrayMap();
        STRATEGIES = arrayMap;
        arrayMap.put("impulse", 0);
        arrayMap.put("lsq1", 1);
        arrayMap.put("lsq2", 2);
        arrayMap.put("lsq3", 3);
        arrayMap.put("wlsq2-delta", 4);
        arrayMap.put("wlsq2-central", 5);
        arrayMap.put("wlsq2-recent", 6);
        arrayMap.put(IconCompat.EXTRA_INT1, 7);
        arrayMap.put(IconCompat.EXTRA_INT2, 8);
        arrayMap.put("legacy", 9);
    }

    private static int toStrategyId(String strStrategy) {
        Map<String, Integer> map = STRATEGIES;
        if (map.containsKey(strStrategy)) {
            return map.get(strStrategy).intValue();
        }
        return -1;
    }

    public static VelocityTracker obtain() {
        VelocityTracker instance = (VelocityTracker) sPool.acquire();
        return instance != null ? instance : new VelocityTracker(-1);
    }

    @Deprecated
    public static VelocityTracker obtain(String strategy) {
        if (strategy == null) {
            return obtain();
        }
        return new VelocityTracker(toStrategyId(strategy));
    }

    public static VelocityTracker obtain(int strategy) {
        return new VelocityTracker(strategy);
    }

    public void recycle() {
        if (this.mStrategy == -1) {
            clear();
            sPool.release(this);
        }
    }

    public int getStrategyId() {
        return this.mStrategy;
    }

    private VelocityTracker(int strategy) {
        if (strategy == -1) {
            String strategyProperty = InputManagerGlobal.getInstance().getVelocityTrackerStrategy();
            if (strategyProperty == null || strategyProperty.isEmpty()) {
                this.mStrategy = strategy;
            } else {
                this.mStrategy = toStrategyId(strategyProperty);
            }
        } else {
            this.mStrategy = strategy;
        }
        this.mPtr = nativeInitialize(this.mStrategy);
    }

    protected void finalize() throws Throwable {
        try {
            long j10 = this.mPtr;
            if (j10 != 0) {
                nativeDispose(j10);
                this.mPtr = 0L;
            }
        } finally {
            super.finalize();
        }
    }

    public boolean isAxisSupported(int axis) {
        return nativeIsAxisSupported(axis);
    }

    public void clear() {
        nativeClear(this.mPtr);
    }

    public void addMovement(MotionEvent event) {
        if (event == null) {
            throw new IllegalArgumentException("event must not be null");
        }
        nativeAddMovement(this.mPtr, event);
    }

    public void computeCurrentVelocity(int units) {
        nativeComputeCurrentVelocity(this.mPtr, units, Float.MAX_VALUE);
    }

    public void computeCurrentVelocity(int units, float maxVelocity) {
        nativeComputeCurrentVelocity(this.mPtr, units, maxVelocity);
    }

    public float getXVelocity() {
        return getXVelocity(-1);
    }

    public float getYVelocity() {
        return getYVelocity(-1);
    }

    public float getXVelocity(int id2) {
        return nativeGetVelocity(this.mPtr, 0, id2);
    }

    public float getYVelocity(int id2) {
        return nativeGetVelocity(this.mPtr, 1, id2);
    }

    public float getAxisVelocity(int axis, int id2) {
        return nativeGetVelocity(this.mPtr, axis, id2);
    }

    public float getAxisVelocity(int axis) {
        return nativeGetVelocity(this.mPtr, axis, -1);
    }
}
