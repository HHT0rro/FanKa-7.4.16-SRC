package com.android.internal.os;

import android.util.SparseArray;
import com.android.internal.os.LongArrayMultiStateCounter;
import dalvik.annotation.optimization.CriticalNative;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.Paths;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class KernelSingleUidTimeReader {
    private static final boolean DBG = false;
    private static final String PROC_FILE_DIR = "/proc/uid/";
    private static final String PROC_FILE_NAME = "/time_in_state";
    private static final String TAG = KernelSingleUidTimeReader.class.getName();
    public static final int TOTAL_READ_ERROR_COUNT = 5;
    private static final String UID_TIMES_PROC_FILE = "/proc/uid_time_in_state";
    private boolean mBpfTimesAvailable;
    private final int mCpuFreqsCount;
    private boolean mCpuFreqsCountVerified;
    private final Injector mInjector;
    private SparseArray<long[]> mLastUidCpuTimeMs;
    private int mReadErrorCounter;
    private boolean mSingleUidCpuTimesAvailable;

    private static final native boolean canReadBpfTimes();

    public KernelSingleUidTimeReader(int cpuFreqsCount) {
        this(cpuFreqsCount, new Injector());
    }

    public KernelSingleUidTimeReader(int cpuFreqsCount, Injector injector) {
        this.mLastUidCpuTimeMs = new SparseArray<>();
        this.mSingleUidCpuTimesAvailable = true;
        this.mBpfTimesAvailable = true;
        this.mInjector = injector;
        this.mCpuFreqsCount = cpuFreqsCount;
        if (cpuFreqsCount == 0) {
            this.mSingleUidCpuTimesAvailable = false;
        }
    }

    public boolean singleUidCpuTimesAvailable() {
        return this.mSingleUidCpuTimesAvailable;
    }

    public long[] readDeltaMs(int uid) {
        synchronized (this) {
            if (!this.mSingleUidCpuTimesAvailable) {
                return null;
            }
            if (this.mBpfTimesAvailable) {
                long[] cpuTimesMs = this.mInjector.readBpfData(uid);
                if (cpuTimesMs.length == 0) {
                    this.mBpfTimesAvailable = false;
                } else {
                    if (!this.mCpuFreqsCountVerified && cpuTimesMs.length != this.mCpuFreqsCount) {
                        this.mSingleUidCpuTimesAvailable = false;
                        return null;
                    }
                    this.mCpuFreqsCountVerified = true;
                    return computeDelta(uid, cpuTimesMs);
                }
            }
            String procFile = PROC_FILE_DIR + uid + PROC_FILE_NAME;
            try {
                byte[] data = this.mInjector.readData(procFile);
                if (!this.mCpuFreqsCountVerified) {
                    verifyCpuFreqsCount(data.length, procFile);
                }
                ByteBuffer buffer = ByteBuffer.wrap(data);
                buffer.order(ByteOrder.nativeOrder());
                return computeDelta(uid, readCpuTimesFromByteBuffer(buffer));
            } catch (Exception e2) {
                int i10 = this.mReadErrorCounter + 1;
                this.mReadErrorCounter = i10;
                if (i10 >= 5) {
                    this.mSingleUidCpuTimesAvailable = false;
                }
                return null;
            }
        }
    }

    private void verifyCpuFreqsCount(int numBytes, String procFile) {
        int actualCount = numBytes / 8;
        if (this.mCpuFreqsCount != actualCount) {
            this.mSingleUidCpuTimesAvailable = false;
            throw new IllegalStateException("Freq count didn't match,count from /proc/uid_time_in_state=" + this.mCpuFreqsCount + ", butcount from " + procFile + "=" + actualCount);
        }
        this.mCpuFreqsCountVerified = true;
    }

    private long[] readCpuTimesFromByteBuffer(ByteBuffer buffer) {
        long[] cpuTimesMs = new long[this.mCpuFreqsCount];
        for (int i10 = 0; i10 < this.mCpuFreqsCount; i10++) {
            cpuTimesMs[i10] = buffer.getLong() * 10;
        }
        return cpuTimesMs;
    }

    public long[] computeDelta(int uid, long[] latestCpuTimesMs) {
        synchronized (this) {
            if (!this.mSingleUidCpuTimesAvailable) {
                return null;
            }
            long[] lastCpuTimesMs = this.mLastUidCpuTimeMs.get(uid);
            long[] deltaTimesMs = getDeltaLocked(lastCpuTimesMs, latestCpuTimesMs);
            if (deltaTimesMs == null) {
                return null;
            }
            boolean hasNonZero = false;
            int i10 = deltaTimesMs.length - 1;
            while (true) {
                if (i10 < 0) {
                    break;
                }
                if (deltaTimesMs[i10] <= 0) {
                    i10--;
                } else {
                    hasNonZero = true;
                    break;
                }
            }
            if (!hasNonZero) {
                return null;
            }
            this.mLastUidCpuTimeMs.put(uid, latestCpuTimesMs);
            return deltaTimesMs;
        }
    }

    public long[] getDeltaLocked(long[] lastCpuTimesMs, long[] latestCpuTimesMs) {
        int i10 = latestCpuTimesMs.length;
        do {
            i10--;
            if (i10 < 0) {
                if (lastCpuTimesMs == null) {
                    return latestCpuTimesMs;
                }
                long[] deltaTimesMs = new long[latestCpuTimesMs.length];
                for (int i11 = latestCpuTimesMs.length - 1; i11 >= 0; i11--) {
                    deltaTimesMs[i11] = latestCpuTimesMs[i11] - lastCpuTimesMs[i11];
                    if (deltaTimesMs[i11] < 0) {
                        return null;
                    }
                }
                return deltaTimesMs;
            }
        } while (latestCpuTimesMs[i10] >= 0);
        return null;
    }

    public void setAllUidsCpuTimesMs(SparseArray<long[]> allUidsCpuTimesMs) {
        synchronized (this) {
            this.mLastUidCpuTimeMs.clear();
            for (int i10 = allUidsCpuTimesMs.size() - 1; i10 >= 0; i10--) {
                long[] cpuTimesMs = allUidsCpuTimesMs.valueAt(i10);
                if (cpuTimesMs != null) {
                    this.mLastUidCpuTimeMs.put(allUidsCpuTimesMs.keyAt(i10), (long[]) cpuTimesMs.clone());
                }
            }
        }
    }

    public void removeUid(int uid) {
        synchronized (this) {
            this.mLastUidCpuTimeMs.delete(uid);
        }
    }

    public void removeUidsInRange(int startUid, int endUid) {
        if (endUid < startUid) {
            return;
        }
        synchronized (this) {
            this.mLastUidCpuTimeMs.put(startUid, null);
            this.mLastUidCpuTimeMs.put(endUid, null);
            int startIdx = this.mLastUidCpuTimeMs.indexOfKey(startUid);
            int endIdx = this.mLastUidCpuTimeMs.indexOfKey(endUid);
            this.mLastUidCpuTimeMs.removeAtRange(startIdx, (endIdx - startIdx) + 1);
        }
    }

    public void addDelta(int uid, LongArrayMultiStateCounter counter, long timestampMs) {
        this.mInjector.addDelta(uid, counter, timestampMs, null);
    }

    public void addDelta(int uid, LongArrayMultiStateCounter counter, long timestampMs, LongArrayMultiStateCounter.LongArrayContainer deltaContainer) {
        this.mInjector.addDelta(uid, counter, timestampMs, deltaContainer);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Injector {
        private static native boolean addDeltaForTest(int i10, long j10, long j11, long[][] jArr, long j12);

        @CriticalNative
        private static native boolean addDeltaFromBpf(int i10, long j10, long j11, long j12);

        public native long[] readBpfData(int i10);

        public byte[] readData(String procFile) throws IOException {
            return Files.readAllBytes(Paths.get(procFile, new String[0]));
        }

        public boolean addDelta(int uid, LongArrayMultiStateCounter counter, long timestampMs, LongArrayMultiStateCounter.LongArrayContainer deltaOut) {
            return addDeltaFromBpf(uid, counter.mNativeObject, timestampMs, deltaOut != null ? deltaOut.mNativeObject : 0L);
        }

        public boolean addDeltaForTest(int uid, LongArrayMultiStateCounter counter, long timestampMs, long[][] timeInFreqDataNanos, LongArrayMultiStateCounter.LongArrayContainer deltaOut) {
            return addDeltaForTest(uid, counter.mNativeObject, timestampMs, timeInFreqDataNanos, deltaOut != null ? deltaOut.mNativeObject : 0L);
        }
    }

    public SparseArray<long[]> getLastUidCpuTimeMs() {
        return this.mLastUidCpuTimeMs;
    }

    public void setSingleUidCpuTimesAvailable(boolean singleUidCpuTimesAvailable) {
        this.mSingleUidCpuTimesAvailable = singleUidCpuTimesAvailable;
    }
}
