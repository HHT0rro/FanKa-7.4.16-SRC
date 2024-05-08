package com.android.internal.os;

import android.os.StrictMode;
import android.util.IntArray;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.os.KernelCpuProcStringReader;
import com.android.internal.os.KernelCpuUidBpfMapReader;
import com.android.internal.util.Preconditions;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class KernelCpuUidTimeReader<T> {
    protected static final boolean DEBUG = false;
    private static final long DEFAULT_MIN_TIME_BETWEEN_READ = 1000;
    final KernelCpuUidBpfMapReader mBpfReader;
    protected boolean mBpfTimesAvailable;
    private final Clock mClock;
    private long mLastReadTimeMs;
    final SparseArray<T> mLastTimes;
    private long mMinTimeBetweenRead;
    final KernelCpuProcStringReader mReader;
    final String mTag;
    final boolean mThrottle;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface Callback<T> {
        void onUidCpuTime(int i10, T t2);
    }

    abstract void readAbsoluteImpl(Callback<T> callback);

    abstract void readDeltaImpl(Callback<T> callback, boolean z10);

    KernelCpuUidTimeReader(KernelCpuProcStringReader reader, KernelCpuUidBpfMapReader bpfReader, boolean throttle, Clock clock) {
        this.mTag = getClass().getSimpleName();
        this.mLastTimes = new SparseArray<>();
        this.mMinTimeBetweenRead = 1000L;
        this.mLastReadTimeMs = 0L;
        this.mReader = reader;
        this.mThrottle = throttle;
        this.mBpfReader = bpfReader;
        this.mClock = clock;
        this.mBpfTimesAvailable = bpfReader != null;
    }

    KernelCpuUidTimeReader(KernelCpuProcStringReader reader, boolean throttle, Clock clock) {
        this(reader, null, throttle, clock);
    }

    public void readDelta(Callback<T> cb2) {
        readDelta(false, cb2);
    }

    public void readDelta(boolean force, Callback<T> cb2) {
        if (!this.mThrottle) {
            readDeltaImpl(cb2, force);
            return;
        }
        long currTimeMs = this.mClock.elapsedRealtime();
        if (!force && currTimeMs < this.mLastReadTimeMs + this.mMinTimeBetweenRead) {
            return;
        }
        readDeltaImpl(cb2, force);
        this.mLastReadTimeMs = currTimeMs;
    }

    public void readAbsolute(Callback<T> cb2) {
        if (!this.mThrottle) {
            readAbsoluteImpl(cb2);
            return;
        }
        long currTimeMs = this.mClock.elapsedRealtime();
        if (currTimeMs < this.mLastReadTimeMs + this.mMinTimeBetweenRead) {
            return;
        }
        readAbsoluteImpl(cb2);
        this.mLastReadTimeMs = currTimeMs;
    }

    public void removeUid(int uid) {
        this.mLastTimes.delete(uid);
        if (this.mBpfTimesAvailable) {
            this.mBpfReader.removeUidsInRange(uid, uid);
        }
    }

    public void removeUidsInRange(int startUid, int endUid) {
        if (endUid < startUid) {
            Slog.e(this.mTag, "start UID " + startUid + " > end UID " + endUid);
            return;
        }
        this.mLastTimes.put(startUid, null);
        this.mLastTimes.put(endUid, null);
        int firstIndex = this.mLastTimes.indexOfKey(startUid);
        int lastIndex = this.mLastTimes.indexOfKey(endUid);
        this.mLastTimes.removeAtRange(firstIndex, (lastIndex - firstIndex) + 1);
        if (this.mBpfTimesAvailable) {
            this.mBpfReader.removeUidsInRange(startUid, endUid);
        }
    }

    public void setThrottle(long minTimeBetweenRead) {
        if (this.mThrottle && minTimeBetweenRead >= 0) {
            this.mMinTimeBetweenRead = minTimeBetweenRead;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class KernelCpuUidUserSysTimeReader extends KernelCpuUidTimeReader<long[]> {
        private static final String REMOVE_UID_PROC_FILE = "/proc/uid_cputime/remove_uid_range";
        private final long[] mBuffer;
        private final long[] mUsrSysTime;

        public KernelCpuUidUserSysTimeReader(boolean throttle) {
            this(throttle, Clock.SYSTEM_CLOCK);
        }

        public KernelCpuUidUserSysTimeReader(boolean throttle, Clock clock) {
            super(KernelCpuProcStringReader.getUserSysTimeReaderInstance(), throttle, clock);
            this.mBuffer = new long[4];
            this.mUsrSysTime = new long[2];
        }

        public KernelCpuUidUserSysTimeReader(KernelCpuProcStringReader reader, boolean throttle, Clock clock) {
            super(reader, throttle, clock);
            this.mBuffer = new long[4];
            this.mUsrSysTime = new long[2];
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x0092, code lost:
        
            r2.onUidCpuTime(r4, r13);
         */
        @Override // com.android.internal.os.KernelCpuUidTimeReader
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void readDeltaImpl(com.android.internal.os.KernelCpuUidTimeReader.Callback<long[]> r22, boolean r23) {
            /*
                Method dump skipped, instructions count: 257
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.internal.os.KernelCpuUidTimeReader.KernelCpuUidUserSysTimeReader.readDeltaImpl(com.android.internal.os.KernelCpuUidTimeReader$Callback, boolean):void");
        }

        @Override // com.android.internal.os.KernelCpuUidTimeReader
        void readAbsoluteImpl(Callback<long[]> cb2) {
            KernelCpuProcStringReader.ProcFileIterator iter = this.mReader.open(!this.mThrottle);
            if (iter == null) {
                if (iter != null) {
                    iter.close();
                    return;
                }
                return;
            }
            while (true) {
                try {
                    CharBuffer buf = iter.nextLine();
                    if (buf == null) {
                        break;
                    }
                    if (KernelCpuProcStringReader.asLongs(buf, this.mBuffer) < 3) {
                        Slog.wtf(this.mTag, "Invalid line: " + buf.toString());
                    } else {
                        long[] jArr = this.mUsrSysTime;
                        long[] jArr2 = this.mBuffer;
                        jArr[0] = jArr2[1];
                        jArr[1] = jArr2[2];
                        cb2.onUidCpuTime((int) jArr2[0], jArr);
                    }
                } catch (Throwable th) {
                    if (iter != null) {
                        try {
                            iter.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            if (iter != null) {
                iter.close();
            }
        }

        @Override // com.android.internal.os.KernelCpuUidTimeReader
        public void removeUid(int uid) {
            super.removeUid(uid);
            removeUidsFromKernelModule(uid, uid);
        }

        @Override // com.android.internal.os.KernelCpuUidTimeReader
        public void removeUidsInRange(int startUid, int endUid) {
            super.removeUidsInRange(startUid, endUid);
            removeUidsFromKernelModule(startUid, endUid);
        }

        private void removeUidsFromKernelModule(int startUid, int endUid) {
            Slog.d(this.mTag, "Removing uids " + startUid + "-" + endUid);
            int oldMask = StrictMode.allowThreadDiskWritesMask();
            try {
                try {
                    FileWriter writer = new FileWriter(REMOVE_UID_PROC_FILE);
                    try {
                        writer.write(startUid + "-" + endUid);
                        writer.flush();
                        writer.close();
                    } catch (Throwable th) {
                        try {
                            writer.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (IOException e2) {
                    Slog.e(this.mTag, "failed to remove uids " + startUid + " - " + endUid + " from uid_cputime module", e2);
                }
            } finally {
                StrictMode.setThreadPolicyMask(oldMask);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class KernelCpuUidFreqTimeReader extends KernelCpuUidTimeReader<long[]> {
        private static final int MAX_ERROR_COUNT = 5;
        private static final String UID_TIMES_PROC_FILE = "/proc/uid_time_in_state";
        private boolean mAllUidTimesAvailable;
        private long[] mBuffer;
        private long[] mCpuFreqs;
        private long[] mCurTimes;
        private long[] mDeltaTimes;
        private int mErrors;
        private int mFreqCount;
        private boolean mPerClusterTimesAvailable;
        private final Path mProcFilePath;

        public KernelCpuUidFreqTimeReader(boolean throttle) {
            this(throttle, Clock.SYSTEM_CLOCK);
        }

        public KernelCpuUidFreqTimeReader(boolean throttle, Clock clock) {
            this(UID_TIMES_PROC_FILE, KernelCpuProcStringReader.getFreqTimeReaderInstance(), KernelCpuUidBpfMapReader.getFreqTimeReaderInstance(), throttle, clock);
        }

        public KernelCpuUidFreqTimeReader(String procFile, KernelCpuProcStringReader reader, KernelCpuUidBpfMapReader bpfReader, boolean throttle) {
            this(procFile, reader, bpfReader, throttle, Clock.SYSTEM_CLOCK);
        }

        private KernelCpuUidFreqTimeReader(String procFile, KernelCpuProcStringReader reader, KernelCpuUidBpfMapReader bpfReader, boolean throttle, Clock clock) {
            super(reader, bpfReader, throttle, clock);
            this.mFreqCount = 0;
            this.mErrors = 0;
            this.mAllUidTimesAvailable = true;
            this.mProcFilePath = Paths.get(procFile, new String[0]);
        }

        public boolean perClusterTimesAvailable() {
            return this.mPerClusterTimesAvailable;
        }

        public boolean allUidTimesAvailable() {
            return this.mAllUidTimesAvailable;
        }

        public SparseArray<long[]> getAllUidCpuFreqTimeMs() {
            return this.mLastTimes;
        }

        public long[] readFreqs(PowerProfile powerProfile) {
            Preconditions.checkNotNull(powerProfile);
            long[] jArr = this.mCpuFreqs;
            if (jArr != null) {
                return jArr;
            }
            if (!this.mAllUidTimesAvailable) {
                return null;
            }
            if (this.mBpfTimesAvailable) {
                readFreqsThroughBpf();
            }
            if (this.mCpuFreqs == null) {
                int oldMask = StrictMode.allowThreadDiskReadsMask();
                try {
                    BufferedReader reader = Files.newBufferedReader(this.mProcFilePath);
                    try {
                        if (readFreqs(reader.readLine()) == null) {
                            if (reader != null) {
                                reader.close();
                            }
                            return null;
                        }
                        if (reader != null) {
                            reader.close();
                        }
                    } catch (Throwable th) {
                        if (reader != null) {
                            try {
                                reader.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e2) {
                    int i10 = this.mErrors + 1;
                    this.mErrors = i10;
                    if (i10 >= 5) {
                        this.mAllUidTimesAvailable = false;
                    }
                    Slog.e(this.mTag, "Failed to read /proc/uid_time_in_state: " + ((Object) e2));
                    return null;
                } finally {
                    StrictMode.setThreadPolicyMask(oldMask);
                }
            }
            IntArray numClusterFreqs = extractClusterInfoFromProcFileFreqs();
            int numClusters = powerProfile.getNumCpuClusters();
            if (numClusterFreqs.size() == numClusters) {
                this.mPerClusterTimesAvailable = true;
                int i11 = 0;
                while (true) {
                    if (i11 >= numClusters) {
                        break;
                    }
                    if (numClusterFreqs.get(i11) != powerProfile.getNumSpeedStepsInCpuCluster(i11)) {
                        this.mPerClusterTimesAvailable = false;
                        break;
                    }
                    i11++;
                }
            } else {
                this.mPerClusterTimesAvailable = false;
            }
            Slog.i(this.mTag, "mPerClusterTimesAvailable=" + this.mPerClusterTimesAvailable);
            return this.mCpuFreqs;
        }

        private long[] readFreqsThroughBpf() {
            if (!this.mBpfTimesAvailable || this.mBpfReader == null) {
                return null;
            }
            long[] dataDimensions = this.mBpfReader.getDataDimensions();
            this.mCpuFreqs = dataDimensions;
            if (dataDimensions == null) {
                return null;
            }
            int length = dataDimensions.length;
            this.mFreqCount = length;
            this.mCurTimes = new long[length];
            this.mDeltaTimes = new long[length];
            this.mBuffer = new long[length + 1];
            return dataDimensions;
        }

        private long[] readFreqs(String line) {
            if (line == null || line.trim().isEmpty()) {
                return null;
            }
            String[] lineArray = line.split(" ");
            if (lineArray.length <= 1) {
                Slog.wtf(this.mTag, "Malformed freq line: " + line);
                return null;
            }
            int length = lineArray.length - 1;
            this.mFreqCount = length;
            this.mCpuFreqs = new long[length];
            this.mCurTimes = new long[length];
            this.mDeltaTimes = new long[length];
            this.mBuffer = new long[length + 1];
            for (int i10 = 0; i10 < this.mFreqCount; i10++) {
                this.mCpuFreqs[i10] = Long.parseLong(lineArray[i10 + 1], 10);
            }
            return this.mCpuFreqs;
        }

        private void processUidDelta(Callback<long[]> callback) {
            int i10 = (int) this.mBuffer[0];
            long[] jArr = (long[]) this.mLastTimes.get(i10);
            if (jArr == null) {
                jArr = new long[this.mFreqCount];
                this.mLastTimes.put(i10, jArr);
            }
            copyToCurTimes();
            boolean z10 = false;
            int i11 = 0;
            while (true) {
                int i12 = this.mFreqCount;
                if (i11 < i12) {
                    long[] jArr2 = this.mDeltaTimes;
                    long j10 = this.mCurTimes[i11] - jArr[i11];
                    jArr2[i11] = j10;
                    if (j10 >= 0) {
                        z10 |= j10 > 0;
                        i11++;
                    } else {
                        Slog.e(this.mTag, "Negative delta from freq time for uid: " + i10 + ", delta: " + this.mDeltaTimes[i11]);
                        return;
                    }
                } else {
                    if (z10) {
                        System.arraycopy((Object) this.mCurTimes, 0, (Object) jArr, 0, i12);
                        if (callback != null) {
                            callback.onUidCpuTime(i10, this.mDeltaTimes);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }

        @Override // com.android.internal.os.KernelCpuUidTimeReader
        void readDeltaImpl(Callback<long[]> cb2, boolean forceRead) {
            if (this.mBpfTimesAvailable) {
                KernelCpuUidBpfMapReader.BpfMapIterator iter = this.mBpfReader.open(!this.mThrottle);
                try {
                    if (checkPrecondition(iter)) {
                        while (iter.getNextUid(this.mBuffer)) {
                            processUidDelta(cb2);
                        }
                        if (iter != null) {
                            iter.close();
                            return;
                        }
                        return;
                    }
                    if (iter != null) {
                        iter.close();
                    }
                } catch (Throwable th) {
                    if (iter != null) {
                        try {
                            iter.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            KernelCpuProcStringReader.ProcFileIterator iter2 = this.mReader.open(!this.mThrottle);
            try {
                if (!checkPrecondition(iter2)) {
                    if (iter2 != null) {
                        iter2.close();
                        return;
                    }
                    return;
                }
                while (true) {
                    CharBuffer buf = iter2.nextLine();
                    if (buf == null) {
                        break;
                    } else if (KernelCpuProcStringReader.asLongs(buf, this.mBuffer) != this.mBuffer.length) {
                        Slog.wtf(this.mTag, "Invalid line: " + buf.toString());
                    } else {
                        processUidDelta(cb2);
                    }
                }
                if (iter2 != null) {
                    iter2.close();
                }
            } catch (Throwable th3) {
                if (iter2 != null) {
                    try {
                        iter2.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        }

        @Override // com.android.internal.os.KernelCpuUidTimeReader
        void readAbsoluteImpl(Callback<long[]> cb2) {
            if (this.mBpfTimesAvailable) {
                KernelCpuUidBpfMapReader.BpfMapIterator iter = this.mBpfReader.open(!this.mThrottle);
                try {
                    if (checkPrecondition(iter)) {
                        while (iter.getNextUid(this.mBuffer)) {
                            copyToCurTimes();
                            cb2.onUidCpuTime((int) this.mBuffer[0], this.mCurTimes);
                        }
                        if (iter != null) {
                            iter.close();
                            return;
                        }
                        return;
                    }
                    if (iter != null) {
                        iter.close();
                    }
                } catch (Throwable th) {
                    if (iter != null) {
                        try {
                            iter.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            KernelCpuProcStringReader.ProcFileIterator iter2 = this.mReader.open(!this.mThrottle);
            try {
                if (!checkPrecondition(iter2)) {
                    if (iter2 != null) {
                        iter2.close();
                        return;
                    }
                    return;
                }
                while (true) {
                    CharBuffer buf = iter2.nextLine();
                    if (buf == null) {
                        break;
                    }
                    if (KernelCpuProcStringReader.asLongs(buf, this.mBuffer) != this.mBuffer.length) {
                        Slog.wtf(this.mTag, "Invalid line: " + buf.toString());
                    } else {
                        copyToCurTimes();
                        cb2.onUidCpuTime((int) this.mBuffer[0], this.mCurTimes);
                    }
                }
                if (iter2 != null) {
                    iter2.close();
                }
            } catch (Throwable th3) {
                if (iter2 != null) {
                    try {
                        iter2.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        }

        private void copyToCurTimes() {
            long factor = this.mBpfTimesAvailable ? 1L : 10L;
            for (int i10 = 0; i10 < this.mFreqCount; i10++) {
                this.mCurTimes[i10] = this.mBuffer[i10 + 1] * factor;
            }
        }

        private boolean checkPrecondition(KernelCpuUidBpfMapReader.BpfMapIterator iter) {
            if (iter == null) {
                this.mBpfTimesAvailable = false;
                return false;
            }
            if (this.mCpuFreqs != null) {
                return true;
            }
            this.mBpfTimesAvailable = readFreqsThroughBpf() != null;
            return this.mBpfTimesAvailable;
        }

        private boolean checkPrecondition(KernelCpuProcStringReader.ProcFileIterator iter) {
            if (iter == null || !iter.hasNextLine()) {
                return false;
            }
            CharBuffer line = iter.nextLine();
            return (this.mCpuFreqs == null && readFreqs(line.toString()) == null) ? false : true;
        }

        private IntArray extractClusterInfoFromProcFileFreqs() {
            int i10;
            IntArray numClusterFreqs = new IntArray();
            int freqsFound = 0;
            while (true) {
                int i11 = this.mFreqCount;
                if (i10 < i11) {
                    freqsFound++;
                    if (i10 + 1 != i11) {
                        long[] jArr = this.mCpuFreqs;
                        i10 = jArr[i10 + 1] > jArr[i10] ? i10 + 1 : 0;
                    }
                    numClusterFreqs.add(freqsFound);
                    freqsFound = 0;
                } else {
                    return numClusterFreqs;
                }
            }
        }

        public boolean isFastCpuTimesReader() {
            return this.mBpfTimesAvailable;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class KernelCpuUidActiveTimeReader extends KernelCpuUidTimeReader<Long> {
        private long[] mBuffer;
        private int mCores;

        public KernelCpuUidActiveTimeReader(boolean throttle) {
            this(throttle, Clock.SYSTEM_CLOCK);
        }

        public KernelCpuUidActiveTimeReader(boolean throttle, Clock clock) {
            super(KernelCpuProcStringReader.getActiveTimeReaderInstance(), KernelCpuUidBpfMapReader.getActiveTimeReaderInstance(), throttle, clock);
            this.mCores = 0;
        }

        public KernelCpuUidActiveTimeReader(KernelCpuProcStringReader reader, KernelCpuUidBpfMapReader bpfReader, boolean throttle) {
            super(reader, bpfReader, throttle, Clock.SYSTEM_CLOCK);
            this.mCores = 0;
        }

        private void processUidDelta(Callback<Long> callback) {
            long[] jArr = this.mBuffer;
            int i10 = (int) jArr[0];
            long sumActiveTime = sumActiveTime(jArr, this.mBpfTimesAvailable ? 1.0d : 10.0d);
            if (sumActiveTime > 0) {
                long longValue = sumActiveTime - ((Long) this.mLastTimes.get(i10, 0L)).longValue();
                if (longValue <= 0) {
                    if (longValue < 0) {
                        Slog.e(this.mTag, "Negative delta from active time for uid: " + i10 + ", delta: " + longValue);
                    }
                } else {
                    this.mLastTimes.put(i10, Long.valueOf(sumActiveTime));
                    if (callback != null) {
                        callback.onUidCpuTime(i10, Long.valueOf(longValue));
                    }
                }
            }
        }

        @Override // com.android.internal.os.KernelCpuUidTimeReader
        void readDeltaImpl(Callback<Long> cb2, boolean forceRead) {
            if (this.mBpfTimesAvailable) {
                KernelCpuUidBpfMapReader.BpfMapIterator iter = this.mBpfReader.open(!this.mThrottle);
                try {
                    if (checkPrecondition(iter)) {
                        while (iter.getNextUid(this.mBuffer)) {
                            processUidDelta(cb2);
                        }
                        if (iter != null) {
                            iter.close();
                            return;
                        }
                        return;
                    }
                    if (iter != null) {
                        iter.close();
                    }
                } catch (Throwable th) {
                    if (iter != null) {
                        try {
                            iter.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            KernelCpuProcStringReader.ProcFileIterator iter2 = this.mReader.open(!this.mThrottle);
            try {
                if (!checkPrecondition(iter2)) {
                    if (iter2 != null) {
                        iter2.close();
                        return;
                    }
                    return;
                }
                while (true) {
                    CharBuffer buf = iter2.nextLine();
                    if (buf == null) {
                        break;
                    } else if (KernelCpuProcStringReader.asLongs(buf, this.mBuffer) != this.mBuffer.length) {
                        Slog.wtf(this.mTag, "Invalid line: " + buf.toString());
                    } else {
                        processUidDelta(cb2);
                    }
                }
                if (iter2 != null) {
                    iter2.close();
                }
            } catch (Throwable th3) {
                if (iter2 != null) {
                    try {
                        iter2.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        }

        private void processUidAbsolute(Callback<Long> cb2) {
            long cpuActiveTime = sumActiveTime(this.mBuffer, this.mBpfTimesAvailable ? 1.0d : 10.0d);
            if (cpuActiveTime > 0) {
                cb2.onUidCpuTime((int) this.mBuffer[0], Long.valueOf(cpuActiveTime));
            }
        }

        @Override // com.android.internal.os.KernelCpuUidTimeReader
        void readAbsoluteImpl(Callback<Long> cb2) {
            if (this.mBpfTimesAvailable) {
                KernelCpuUidBpfMapReader.BpfMapIterator iter = this.mBpfReader.open(!this.mThrottle);
                try {
                    if (checkPrecondition(iter)) {
                        while (iter.getNextUid(this.mBuffer)) {
                            processUidAbsolute(cb2);
                        }
                        if (iter != null) {
                            iter.close();
                            return;
                        }
                        return;
                    }
                    if (iter != null) {
                        iter.close();
                    }
                } catch (Throwable th) {
                    if (iter != null) {
                        try {
                            iter.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            KernelCpuProcStringReader.ProcFileIterator iter2 = this.mReader.open(!this.mThrottle);
            try {
                if (!checkPrecondition(iter2)) {
                    if (iter2 != null) {
                        iter2.close();
                        return;
                    }
                    return;
                }
                while (true) {
                    CharBuffer buf = iter2.nextLine();
                    if (buf == null) {
                        break;
                    } else if (KernelCpuProcStringReader.asLongs(buf, this.mBuffer) != this.mBuffer.length) {
                        Slog.wtf(this.mTag, "Invalid line: " + buf.toString());
                    } else {
                        processUidAbsolute(cb2);
                    }
                }
                if (iter2 != null) {
                    iter2.close();
                }
            } catch (Throwable th3) {
                if (iter2 != null) {
                    try {
                        iter2.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        }

        private static long sumActiveTime(long[] times, double factor) {
            double sum = ShadowDrawableWrapper.COS_45;
            for (int i10 = 1; i10 < times.length; i10++) {
                sum += (times[i10] * factor) / i10;
            }
            return (long) sum;
        }

        private boolean checkPrecondition(KernelCpuUidBpfMapReader.BpfMapIterator iter) {
            if (iter == null) {
                this.mBpfTimesAvailable = false;
                return false;
            }
            if (this.mCores > 0) {
                return true;
            }
            long[] cores = this.mBpfReader.getDataDimensions();
            if (cores == null || cores.length < 1) {
                this.mBpfTimesAvailable = false;
                return false;
            }
            int i10 = (int) cores[0];
            this.mCores = i10;
            this.mBuffer = new long[i10 + 1];
            return true;
        }

        private boolean checkPrecondition(KernelCpuProcStringReader.ProcFileIterator iter) {
            if (iter == null || !iter.hasNextLine()) {
                return false;
            }
            CharBuffer line = iter.nextLine();
            if (this.mCores > 0) {
                return true;
            }
            String str = line.toString().trim();
            if (str.isEmpty()) {
                Slog.w(this.mTag, "Empty uid_concurrent_active_time");
                return false;
            }
            if (!str.startsWith("cpus:")) {
                Slog.wtf(this.mTag, "Malformed uid_concurrent_active_time line: " + str);
                return false;
            }
            int cores = Integer.parseInt(str.substring(5).trim(), 10);
            if (cores <= 0) {
                Slog.wtf(this.mTag, "Malformed uid_concurrent_active_time line: " + str);
                return false;
            }
            this.mCores = cores;
            this.mBuffer = new long[cores + 1];
            return true;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class KernelCpuUidClusterTimeReader extends KernelCpuUidTimeReader<long[]> {
        private long[] mBuffer;
        private int[] mCoresOnClusters;
        private long[] mCurTime;
        private long[] mDeltaTime;
        private int mNumClusters;
        private int mNumCores;

        public KernelCpuUidClusterTimeReader(boolean throttle) {
            this(throttle, Clock.SYSTEM_CLOCK);
        }

        public KernelCpuUidClusterTimeReader(boolean throttle, Clock clock) {
            super(KernelCpuProcStringReader.getClusterTimeReaderInstance(), KernelCpuUidBpfMapReader.getClusterTimeReaderInstance(), throttle, clock);
        }

        public KernelCpuUidClusterTimeReader(KernelCpuProcStringReader reader, KernelCpuUidBpfMapReader bpfReader, boolean throttle) {
            super(reader, bpfReader, throttle, Clock.SYSTEM_CLOCK);
        }

        void processUidDelta(Callback<long[]> callback) {
            int i10 = (int) this.mBuffer[0];
            long[] jArr = (long[]) this.mLastTimes.get(i10);
            if (jArr == null) {
                jArr = new long[this.mNumClusters];
                this.mLastTimes.put(i10, jArr);
            }
            sumClusterTime();
            boolean z10 = false;
            int i11 = 0;
            while (true) {
                int i12 = this.mNumClusters;
                if (i11 < i12) {
                    long[] jArr2 = this.mDeltaTime;
                    long j10 = this.mCurTime[i11] - jArr[i11];
                    jArr2[i11] = j10;
                    if (j10 >= 0) {
                        z10 |= j10 > 0;
                        i11++;
                    } else {
                        Slog.e(this.mTag, "Negative delta from cluster time for uid: " + i10 + ", delta: " + this.mDeltaTime[i11]);
                        return;
                    }
                } else {
                    if (z10) {
                        System.arraycopy((Object) this.mCurTime, 0, (Object) jArr, 0, i12);
                        if (callback != null) {
                            callback.onUidCpuTime(i10, this.mDeltaTime);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }

        @Override // com.android.internal.os.KernelCpuUidTimeReader
        void readDeltaImpl(Callback<long[]> cb2, boolean forceRead) {
            if (this.mBpfTimesAvailable) {
                KernelCpuUidBpfMapReader.BpfMapIterator iter = this.mBpfReader.open(!this.mThrottle);
                try {
                    if (checkPrecondition(iter)) {
                        while (iter.getNextUid(this.mBuffer)) {
                            processUidDelta(cb2);
                        }
                        if (iter != null) {
                            iter.close();
                            return;
                        }
                        return;
                    }
                    if (iter != null) {
                        iter.close();
                    }
                } catch (Throwable th) {
                    if (iter != null) {
                        try {
                            iter.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            KernelCpuProcStringReader.ProcFileIterator iter2 = this.mReader.open(!this.mThrottle);
            try {
                if (!checkPrecondition(iter2)) {
                    if (iter2 != null) {
                        iter2.close();
                        return;
                    }
                    return;
                }
                while (true) {
                    CharBuffer buf = iter2.nextLine();
                    if (buf == null) {
                        break;
                    } else if (KernelCpuProcStringReader.asLongs(buf, this.mBuffer) != this.mBuffer.length) {
                        Slog.wtf(this.mTag, "Invalid line: " + buf.toString());
                    } else {
                        processUidDelta(cb2);
                    }
                }
                if (iter2 != null) {
                    iter2.close();
                }
            } catch (Throwable th3) {
                if (iter2 != null) {
                    try {
                        iter2.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        }

        @Override // com.android.internal.os.KernelCpuUidTimeReader
        void readAbsoluteImpl(Callback<long[]> cb2) {
            if (this.mBpfTimesAvailable) {
                KernelCpuUidBpfMapReader.BpfMapIterator iter = this.mBpfReader.open(!this.mThrottle);
                try {
                    if (checkPrecondition(iter)) {
                        while (iter.getNextUid(this.mBuffer)) {
                            sumClusterTime();
                            cb2.onUidCpuTime((int) this.mBuffer[0], this.mCurTime);
                        }
                        if (iter != null) {
                            iter.close();
                            return;
                        }
                        return;
                    }
                    if (iter != null) {
                        iter.close();
                    }
                } catch (Throwable th) {
                    if (iter != null) {
                        try {
                            iter.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            KernelCpuProcStringReader.ProcFileIterator iter2 = this.mReader.open(!this.mThrottle);
            try {
                if (!checkPrecondition(iter2)) {
                    if (iter2 != null) {
                        iter2.close();
                        return;
                    }
                    return;
                }
                while (true) {
                    CharBuffer buf = iter2.nextLine();
                    if (buf == null) {
                        break;
                    }
                    if (KernelCpuProcStringReader.asLongs(buf, this.mBuffer) != this.mBuffer.length) {
                        Slog.wtf(this.mTag, "Invalid line: " + buf.toString());
                    } else {
                        sumClusterTime();
                        cb2.onUidCpuTime((int) this.mBuffer[0], this.mCurTime);
                    }
                }
                if (iter2 != null) {
                    iter2.close();
                }
            } catch (Throwable th3) {
                if (iter2 != null) {
                    try {
                        iter2.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        }

        private void sumClusterTime() {
            double factor = this.mBpfTimesAvailable ? 1.0d : 10.0d;
            int core = 1;
            for (int i10 = 0; i10 < this.mNumClusters; i10++) {
                double sum = ShadowDrawableWrapper.COS_45;
                int j10 = 1;
                while (j10 <= this.mCoresOnClusters[i10]) {
                    sum += (this.mBuffer[core] * factor) / j10;
                    j10++;
                    core++;
                }
                this.mCurTime[i10] = (long) sum;
            }
        }

        private boolean checkPrecondition(KernelCpuUidBpfMapReader.BpfMapIterator iter) {
            if (iter == null) {
                this.mBpfTimesAvailable = false;
                return false;
            }
            if (this.mNumClusters > 0) {
                return true;
            }
            long[] coresOnClusters = this.mBpfReader.getDataDimensions();
            if (coresOnClusters == null || coresOnClusters.length < 1) {
                this.mBpfTimesAvailable = false;
                return false;
            }
            int length = coresOnClusters.length;
            this.mNumClusters = length;
            this.mCoresOnClusters = new int[length];
            int cores = 0;
            int i10 = 0;
            while (true) {
                int i11 = this.mNumClusters;
                if (i10 < i11) {
                    int[] iArr = this.mCoresOnClusters;
                    int i12 = (int) coresOnClusters[i10];
                    iArr[i10] = i12;
                    cores += i12;
                    i10++;
                } else {
                    this.mNumCores = cores;
                    this.mBuffer = new long[cores + 1];
                    this.mCurTime = new long[i11];
                    this.mDeltaTime = new long[i11];
                    return true;
                }
            }
        }

        private boolean checkPrecondition(KernelCpuProcStringReader.ProcFileIterator iter) {
            if (iter == null || !iter.hasNextLine()) {
                return false;
            }
            CharBuffer line = iter.nextLine();
            if (this.mNumClusters > 0) {
                return true;
            }
            String lineStr = line.toString().trim();
            if (lineStr.isEmpty()) {
                Slog.w(this.mTag, "Empty uid_concurrent_policy_time");
                return false;
            }
            String[] lineArray = lineStr.split(" ");
            if (lineArray.length % 2 != 0) {
                Slog.wtf(this.mTag, "Malformed uid_concurrent_policy_time line: " + lineStr);
                return false;
            }
            int[] clusters = new int[lineArray.length / 2];
            int cores = 0;
            for (int i10 = 0; i10 < clusters.length; i10++) {
                if (!lineArray[i10 * 2].startsWith("policy")) {
                    Slog.wtf(this.mTag, "Malformed uid_concurrent_policy_time line: " + lineStr);
                    return false;
                }
                clusters[i10] = Integer.parseInt(lineArray[(i10 * 2) + 1], 10);
                cores += clusters[i10];
            }
            int length = clusters.length;
            this.mNumClusters = length;
            this.mNumCores = cores;
            this.mCoresOnClusters = clusters;
            this.mBuffer = new long[cores + 1];
            this.mCurTime = new long[length];
            this.mDeltaTime = new long[length];
            return true;
        }
    }
}
