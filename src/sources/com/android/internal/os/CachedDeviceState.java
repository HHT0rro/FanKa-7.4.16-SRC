package com.android.internal.os;

import android.os.SystemClock;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class CachedDeviceState {
    private volatile boolean mCharging;
    private final ArrayList<TimeInStateStopwatch> mOnBatteryStopwatches;
    private volatile boolean mScreenInteractive;
    private final Object mStopwatchesLock;

    public CachedDeviceState() {
        this.mStopwatchesLock = new Object();
        this.mOnBatteryStopwatches = new ArrayList<>();
        this.mCharging = true;
        this.mScreenInteractive = false;
    }

    public CachedDeviceState(boolean isCharging, boolean isScreenInteractive) {
        this.mStopwatchesLock = new Object();
        this.mOnBatteryStopwatches = new ArrayList<>();
        this.mCharging = isCharging;
        this.mScreenInteractive = isScreenInteractive;
    }

    public void setScreenInteractive(boolean screenInteractive) {
        this.mScreenInteractive = screenInteractive;
    }

    public void setCharging(boolean charging) {
        if (this.mCharging != charging) {
            this.mCharging = charging;
            updateStopwatches(!charging);
        }
    }

    private void updateStopwatches(boolean shouldStart) {
        synchronized (this.mStopwatchesLock) {
            int size = this.mOnBatteryStopwatches.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (shouldStart) {
                    this.mOnBatteryStopwatches.get(i10).start();
                } else {
                    this.mOnBatteryStopwatches.get(i10).stop();
                }
            }
        }
    }

    public Readonly getReadonlyClient() {
        return new Readonly();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class Readonly {
        public Readonly() {
        }

        public boolean isCharging() {
            return CachedDeviceState.this.mCharging;
        }

        public boolean isScreenInteractive() {
            return CachedDeviceState.this.mScreenInteractive;
        }

        public TimeInStateStopwatch createTimeOnBatteryStopwatch() {
            TimeInStateStopwatch stopwatch;
            synchronized (CachedDeviceState.this.mStopwatchesLock) {
                stopwatch = new TimeInStateStopwatch();
                CachedDeviceState.this.mOnBatteryStopwatches.add(stopwatch);
                if (!CachedDeviceState.this.mCharging) {
                    stopwatch.start();
                }
            }
            return stopwatch;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class TimeInStateStopwatch implements AutoCloseable {
        private final Object mLock = new Object();
        private long mStartTimeMillis;
        private long mTotalTimeMillis;

        public TimeInStateStopwatch() {
        }

        public long getMillis() {
            long elapsedTime;
            synchronized (this.mLock) {
                elapsedTime = this.mTotalTimeMillis + elapsedTime();
            }
            return elapsedTime;
        }

        public void reset() {
            synchronized (this.mLock) {
                this.mTotalTimeMillis = 0L;
                this.mStartTimeMillis = isRunning() ? SystemClock.elapsedRealtime() : 0L;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void start() {
            synchronized (this.mLock) {
                if (!isRunning()) {
                    this.mStartTimeMillis = SystemClock.elapsedRealtime();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void stop() {
            synchronized (this.mLock) {
                if (isRunning()) {
                    this.mTotalTimeMillis += elapsedTime();
                    this.mStartTimeMillis = 0L;
                }
            }
        }

        private long elapsedTime() {
            if (isRunning()) {
                return SystemClock.elapsedRealtime() - this.mStartTimeMillis;
            }
            return 0L;
        }

        public boolean isRunning() {
            return this.mStartTimeMillis > 0;
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            synchronized (CachedDeviceState.this.mStopwatchesLock) {
                CachedDeviceState.this.mOnBatteryStopwatches.remove(this);
            }
        }
    }
}
