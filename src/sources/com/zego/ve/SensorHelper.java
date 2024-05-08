package com.zego.ve;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class SensorHelper implements SensorEventListener {
    private static final float ACCELERATION_TOLERANCE = 4.0f;
    private static final int ACCELEROMETER_DATA_X = 0;
    private static final int ACCELEROMETER_DATA_Y = 1;
    private static final int ACCELEROMETER_DATA_Z = 2;
    private static final int ADJACENT_ORIENTATION_ANGLE_GAP = 45;
    private static final float FILTER_TIME_CONSTANT_MS = 200.0f;
    private static final float MAX_ACCELERATION_MAGNITUDE = 13.80665f;
    private static final long MAX_FILTER_DELTA_TIME_NANOS = 1000000000;
    private static final int MAX_TILT = 80;
    private static final float MIN_ACCELERATION_MAGNITUDE = 5.80665f;
    public static final long NANOS_PER_MS = 1000000;
    private static final float NEAR_ZERO_MAGNITUDE = 1.0f;
    private static final long PROPOSAL_MIN_TIME_SINCE_ACCELERATION_ENDED_NANOS = 500000000;
    private static final long PROPOSAL_MIN_TIME_SINCE_FLAT_ENDED_NANOS = 500000000;
    private static final long PROPOSAL_MIN_TIME_SINCE_SWING_ENDED_NANOS = 300000000;
    private static final long PROPOSAL_SETTLE_TIME_NANOS = 40000000;
    private static final float RADIANS_TO_DEGREES = 57.29578f;
    private static final String TAG = "SensorHelper";
    private static final int TILT_HISTORY_SIZE = 200;
    private static final int TILT_OVERHEAD_ENTER = -40;
    private static final int TILT_OVERHEAD_EXIT = -15;
    private boolean mAccelerating;
    private long mAccelerationTimestampNanos;
    private boolean mFlat;
    private long mFlatTimestampNanos;
    private long mLastFilteredTimestampNanos;
    private float mLastFilteredX;
    private float mLastFilteredY;
    private float mLastFilteredZ;
    private boolean mOverhead;
    private int mPredictedRotation;
    private long mPredictedRotationTimestampNanos;
    private Sensor mSensor;
    private SensorManager mSensorManager;
    private long mSwingTimestampNanos;
    private boolean mSwinging;
    private int mTiltHistoryIndex;
    private long pthis = 0;
    private Object mLock = new Object();
    private Boolean mIsStarted = Boolean.FALSE;
    private int mProposedRotation = -1;
    private int mCurrentRotation = -1;
    private float[] mTiltHistory = new float[200];
    private long[] mTiltHistoryTimestampNanos = new long[200];
    private final int[][] mTiltToleranceConfig = {new int[]{-25, 70}, new int[]{-25, 65}, new int[]{-25, 60}, new int[]{-25, 65}};

    private void addTiltHistoryEntryLocked(long j10, float f10) {
        float[] fArr = this.mTiltHistory;
        int i10 = this.mTiltHistoryIndex;
        fArr[i10] = f10;
        long[] jArr = this.mTiltHistoryTimestampNanos;
        jArr[i10] = j10;
        int i11 = (i10 + 1) % 200;
        this.mTiltHistoryIndex = i11;
        jArr[i11] = Long.MIN_VALUE;
    }

    private void clearPredictedRotationLocked() {
        this.mPredictedRotation = -1;
        this.mPredictedRotationTimestampNanos = Long.MIN_VALUE;
    }

    private void clearTiltHistoryLocked() {
        this.mTiltHistoryTimestampNanos[0] = Long.MIN_VALUE;
        this.mTiltHistoryIndex = 1;
    }

    private float getLastTiltLocked() {
        int nextTiltHistoryIndexLocked = nextTiltHistoryIndexLocked(this.mTiltHistoryIndex);
        if (nextTiltHistoryIndexLocked >= 0) {
            return this.mTiltHistory[nextTiltHistoryIndexLocked];
        }
        return Float.NaN;
    }

    private boolean isFlatLocked(long j10) {
        int i10 = this.mTiltHistoryIndex;
        do {
            i10 = nextTiltHistoryIndexLocked(i10);
            if (i10 < 0 || this.mTiltHistory[i10] < 80.0f) {
                return false;
            }
        } while (this.mTiltHistoryTimestampNanos[i10] + MAX_FILTER_DELTA_TIME_NANOS > j10);
        return true;
    }

    private boolean isOrientationAngleAcceptableLocked(int i10, int i11) {
        int i12 = this.mCurrentRotation;
        if (i12 < 0) {
            return true;
        }
        if (i10 == i12 || i10 == (i12 + 1) % 4) {
            int i13 = ((i10 * 90) - 45) + 22;
            if (i10 == 0) {
                if (i11 >= 315 && i11 < i13 + 360) {
                    return false;
                }
            } else if (i11 < i13) {
                return false;
            }
        }
        if (i10 != i12 && i10 != (i12 + 3) % 4) {
            return true;
        }
        int i14 = ((i10 * 90) + 45) - 22;
        return i10 == 0 ? i11 > 45 || i11 <= i14 : i11 <= i14;
    }

    private boolean isPredictedRotationAcceptableLocked(long j10) {
        return j10 >= this.mPredictedRotationTimestampNanos + PROPOSAL_SETTLE_TIME_NANOS && j10 >= this.mFlatTimestampNanos + 500000000 && j10 >= this.mSwingTimestampNanos + PROPOSAL_MIN_TIME_SINCE_SWING_ENDED_NANOS && j10 >= this.mAccelerationTimestampNanos + 500000000;
    }

    private boolean isSwingingLocked(long j10, float f10) {
        int i10 = this.mTiltHistoryIndex;
        do {
            i10 = nextTiltHistoryIndexLocked(i10);
            if (i10 < 0 || this.mTiltHistoryTimestampNanos[i10] + PROPOSAL_MIN_TIME_SINCE_SWING_ENDED_NANOS < j10) {
                return false;
            }
        } while (this.mTiltHistory[i10] + 20.0f > f10);
        return true;
    }

    private boolean isTiltAngleAcceptableLocked(int i10, int i11) {
        int[][] iArr = this.mTiltToleranceConfig;
        return i11 >= iArr[i10][0] && i11 <= iArr[i10][1];
    }

    private int nextTiltHistoryIndexLocked(int i10) {
        if (i10 == 0) {
            i10 = 200;
        }
        int i11 = i10 - 1;
        if (this.mTiltHistoryTimestampNanos[i11] != Long.MIN_VALUE) {
            return i11;
        }
        return -1;
    }

    private static native int on_rotation(long j10, int i10);

    private float remainingMS(long j10, long j11) {
        if (j10 >= j11) {
            return 0.0f;
        }
        return ((float) (j11 - j10)) * 1.0E-6f;
    }

    private void updatePredictedRotationLocked(long j10, int i10) {
        if (this.mPredictedRotation != i10) {
            this.mPredictedRotation = i10;
            this.mPredictedRotationTimestampNanos = j10;
        }
    }

    public void create(long j10, Context context) {
        this.pthis = j10;
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.mSensorManager = sensorManager;
        this.mSensor = sensorManager.getDefaultSensor(1);
    }

    public void destroy() {
        synchronized (this.mLock) {
            this.pthis = 0L;
        }
        stop();
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005e A[Catch: all -> 0x014f, TryCatch #0 {, blocks: (B:4:0x0006, B:6:0x0021, B:15:0x0037, B:16:0x0054, B:18:0x005e, B:20:0x0072, B:27:0x008b, B:29:0x00a7, B:30:0x00ac, B:32:0x00b2, B:35:0x00bb, B:36:0x00c4, B:38:0x00c8, B:40:0x0110, B:42:0x011c, B:44:0x0126, B:45:0x0128, B:57:0x0122, B:58:0x00cc, B:60:0x00d4, B:61:0x00d8, B:63:0x00ee, B:64:0x00f0, B:67:0x00f9, B:69:0x00ff, B:71:0x0105, B:72:0x0109, B:76:0x00c2, B:79:0x0088, B:81:0x0050), top: B:3:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a7 A[Catch: all -> 0x014f, TryCatch #0 {, blocks: (B:4:0x0006, B:6:0x0021, B:15:0x0037, B:16:0x0054, B:18:0x005e, B:20:0x0072, B:27:0x008b, B:29:0x00a7, B:30:0x00ac, B:32:0x00b2, B:35:0x00bb, B:36:0x00c4, B:38:0x00c8, B:40:0x0110, B:42:0x011c, B:44:0x0126, B:45:0x0128, B:57:0x0122, B:58:0x00cc, B:60:0x00d4, B:61:0x00d8, B:63:0x00ee, B:64:0x00f0, B:67:0x00f9, B:69:0x00ff, B:71:0x0105, B:72:0x0109, B:76:0x00c2, B:79:0x0088, B:81:0x0050), top: B:3:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b2 A[Catch: all -> 0x014f, TryCatch #0 {, blocks: (B:4:0x0006, B:6:0x0021, B:15:0x0037, B:16:0x0054, B:18:0x005e, B:20:0x0072, B:27:0x008b, B:29:0x00a7, B:30:0x00ac, B:32:0x00b2, B:35:0x00bb, B:36:0x00c4, B:38:0x00c8, B:40:0x0110, B:42:0x011c, B:44:0x0126, B:45:0x0128, B:57:0x0122, B:58:0x00cc, B:60:0x00d4, B:61:0x00d8, B:63:0x00ee, B:64:0x00f0, B:67:0x00f9, B:69:0x00ff, B:71:0x0105, B:72:0x0109, B:76:0x00c2, B:79:0x0088, B:81:0x0050), top: B:3:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bb A[Catch: all -> 0x014f, TryCatch #0 {, blocks: (B:4:0x0006, B:6:0x0021, B:15:0x0037, B:16:0x0054, B:18:0x005e, B:20:0x0072, B:27:0x008b, B:29:0x00a7, B:30:0x00ac, B:32:0x00b2, B:35:0x00bb, B:36:0x00c4, B:38:0x00c8, B:40:0x0110, B:42:0x011c, B:44:0x0126, B:45:0x0128, B:57:0x0122, B:58:0x00cc, B:60:0x00d4, B:61:0x00d8, B:63:0x00ee, B:64:0x00f0, B:67:0x00f9, B:69:0x00ff, B:71:0x0105, B:72:0x0109, B:76:0x00c2, B:79:0x0088, B:81:0x0050), top: B:3:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c8 A[Catch: all -> 0x014f, TryCatch #0 {, blocks: (B:4:0x0006, B:6:0x0021, B:15:0x0037, B:16:0x0054, B:18:0x005e, B:20:0x0072, B:27:0x008b, B:29:0x00a7, B:30:0x00ac, B:32:0x00b2, B:35:0x00bb, B:36:0x00c4, B:38:0x00c8, B:40:0x0110, B:42:0x011c, B:44:0x0126, B:45:0x0128, B:57:0x0122, B:58:0x00cc, B:60:0x00d4, B:61:0x00d8, B:63:0x00ee, B:64:0x00f0, B:67:0x00f9, B:69:0x00ff, B:71:0x0105, B:72:0x0109, B:76:0x00c2, B:79:0x0088, B:81:0x0050), top: B:3:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011c A[Catch: all -> 0x014f, TryCatch #0 {, blocks: (B:4:0x0006, B:6:0x0021, B:15:0x0037, B:16:0x0054, B:18:0x005e, B:20:0x0072, B:27:0x008b, B:29:0x00a7, B:30:0x00ac, B:32:0x00b2, B:35:0x00bb, B:36:0x00c4, B:38:0x00c8, B:40:0x0110, B:42:0x011c, B:44:0x0126, B:45:0x0128, B:57:0x0122, B:58:0x00cc, B:60:0x00d4, B:61:0x00d8, B:63:0x00ee, B:64:0x00f0, B:67:0x00f9, B:69:0x00ff, B:71:0x0105, B:72:0x0109, B:76:0x00c2, B:79:0x0088, B:81:0x0050), top: B:3:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00cc A[Catch: all -> 0x014f, TryCatch #0 {, blocks: (B:4:0x0006, B:6:0x0021, B:15:0x0037, B:16:0x0054, B:18:0x005e, B:20:0x0072, B:27:0x008b, B:29:0x00a7, B:30:0x00ac, B:32:0x00b2, B:35:0x00bb, B:36:0x00c4, B:38:0x00c8, B:40:0x0110, B:42:0x011c, B:44:0x0126, B:45:0x0128, B:57:0x0122, B:58:0x00cc, B:60:0x00d4, B:61:0x00d8, B:63:0x00ee, B:64:0x00f0, B:67:0x00f9, B:69:0x00ff, B:71:0x0105, B:72:0x0109, B:76:0x00c2, B:79:0x0088, B:81:0x0050), top: B:3:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ab  */
    @Override // android.hardware.SensorEventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onSensorChanged(android.hardware.SensorEvent r16) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zego.ve.SensorHelper.onSensorChanged(android.hardware.SensorEvent):void");
    }

    public void resetLocked(boolean z10) {
        this.mLastFilteredTimestampNanos = Long.MIN_VALUE;
        if (z10) {
            this.mProposedRotation = -1;
        }
        this.mFlatTimestampNanos = Long.MIN_VALUE;
        this.mFlat = false;
        this.mSwingTimestampNanos = Long.MIN_VALUE;
        this.mSwinging = false;
        this.mAccelerationTimestampNanos = Long.MIN_VALUE;
        this.mAccelerating = false;
        this.mOverhead = false;
        clearPredictedRotationLocked();
        clearTiltHistoryLocked();
    }

    public void start() {
        synchronized (this.mLock) {
            if (!this.mIsStarted.booleanValue()) {
                this.mSensorManager.registerListener(this, this.mSensor, 3);
                this.mIsStarted = Boolean.TRUE;
            }
        }
    }

    public void stop() {
        synchronized (this.mLock) {
            if (this.mIsStarted.booleanValue()) {
                this.mSensorManager.unregisterListener(this, this.mSensor);
                this.mIsStarted = Boolean.FALSE;
            }
        }
    }
}
