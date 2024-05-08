package com.android.internal.os;

import android.util.ArrayMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class RpmStats {
    public Map<String, PowerStatePlatformSleepState> mPlatformLowPowerStats = new ArrayMap();
    public Map<String, PowerStateSubsystem> mSubsystemLowPowerStats = new ArrayMap();

    public PowerStatePlatformSleepState getAndUpdatePlatformState(String name, long timeMs, int count) {
        PowerStatePlatformSleepState e2 = this.mPlatformLowPowerStats.get(name);
        if (e2 == null) {
            e2 = new PowerStatePlatformSleepState();
            this.mPlatformLowPowerStats.put(name, e2);
        }
        e2.mTimeMs = timeMs;
        e2.mCount = count;
        return e2;
    }

    public PowerStateSubsystem getSubsystem(String name) {
        PowerStateSubsystem e2 = this.mSubsystemLowPowerStats.get(name);
        if (e2 == null) {
            PowerStateSubsystem e10 = new PowerStateSubsystem();
            this.mSubsystemLowPowerStats.put(name, e10);
            return e10;
        }
        return e2;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class PowerStateElement {
        public int mCount;
        public long mTimeMs;

        private PowerStateElement(long timeMs, int count) {
            this.mTimeMs = timeMs;
            this.mCount = count;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class PowerStatePlatformSleepState {
        public int mCount;
        public long mTimeMs;
        public Map<String, PowerStateElement> mVoters = new ArrayMap();

        public void putVoter(String name, long timeMs, int count) {
            PowerStateElement e2 = this.mVoters.get(name);
            if (e2 == null) {
                this.mVoters.put(name, new PowerStateElement(timeMs, count));
            } else {
                e2.mTimeMs = timeMs;
                e2.mCount = count;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class PowerStateSubsystem {
        public Map<String, PowerStateElement> mStates = new ArrayMap();

        public void putState(String name, long timeMs, int count) {
            PowerStateElement e2 = this.mStates.get(name);
            if (e2 == null) {
                this.mStates.put(name, new PowerStateElement(timeMs, count));
            } else {
                e2.mTimeMs = timeMs;
                e2.mCount = count;
            }
        }
    }
}
