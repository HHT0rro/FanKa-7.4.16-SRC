package com.android.internal.os;

import android.os.StrictMode;
import android.util.Slog;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class KernelCpuProcStringReader {
    private static final int ERROR_THRESHOLD = 5;
    private static final long FRESHNESS = 500;
    private static final int MAX_BUFFER_SIZE = 1048576;
    private char[] mBuf;
    private final Clock mClock;
    private int mErrors;
    private final Path mFile;
    private long mLastReadTime;
    private final ReentrantReadWriteLock mLock;
    private final ReentrantReadWriteLock.ReadLock mReadLock;
    private int mSize;
    private final ReentrantReadWriteLock.WriteLock mWriteLock;
    private static final String TAG = KernelCpuProcStringReader.class.getSimpleName();
    private static final String PROC_UID_FREQ_TIME = "/proc/uid_time_in_state";
    private static final KernelCpuProcStringReader FREQ_TIME_READER = new KernelCpuProcStringReader(PROC_UID_FREQ_TIME);
    private static final String PROC_UID_ACTIVE_TIME = "/proc/uid_concurrent_active_time";
    private static final KernelCpuProcStringReader ACTIVE_TIME_READER = new KernelCpuProcStringReader(PROC_UID_ACTIVE_TIME);
    private static final String PROC_UID_CLUSTER_TIME = "/proc/uid_concurrent_policy_time";
    private static final KernelCpuProcStringReader CLUSTER_TIME_READER = new KernelCpuProcStringReader(PROC_UID_CLUSTER_TIME);
    private static final String PROC_UID_USER_SYS_TIME = "/proc/uid_cputime/show_uid_stat";
    private static final KernelCpuProcStringReader USER_SYS_TIME_READER = new KernelCpuProcStringReader(PROC_UID_USER_SYS_TIME);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static KernelCpuProcStringReader getFreqTimeReaderInstance() {
        return FREQ_TIME_READER;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static KernelCpuProcStringReader getActiveTimeReaderInstance() {
        return ACTIVE_TIME_READER;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static KernelCpuProcStringReader getClusterTimeReaderInstance() {
        return CLUSTER_TIME_READER;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static KernelCpuProcStringReader getUserSysTimeReaderInstance() {
        return USER_SYS_TIME_READER;
    }

    public KernelCpuProcStringReader(String file) {
        this(file, Clock.SYSTEM_CLOCK);
    }

    public KernelCpuProcStringReader(String file, Clock clock) {
        this.mErrors = 0;
        this.mLastReadTime = 0L;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mLock = reentrantReadWriteLock;
        this.mReadLock = reentrantReadWriteLock.readLock();
        this.mWriteLock = reentrantReadWriteLock.writeLock();
        this.mFile = Paths.get(file, new String[0]);
        this.mClock = clock;
    }

    public ProcFileIterator open() {
        return open(false);
    }

    public ProcFileIterator open(boolean ignoreCache) {
        if (this.mErrors >= 5) {
            return null;
        }
        if (ignoreCache) {
            this.mWriteLock.lock();
        } else {
            this.mReadLock.lock();
            if (dataValid()) {
                return new ProcFileIterator(this.mSize);
            }
            this.mReadLock.unlock();
            this.mWriteLock.lock();
            if (dataValid()) {
                this.mReadLock.lock();
                this.mWriteLock.unlock();
                return new ProcFileIterator(this.mSize);
            }
        }
        int total = 0;
        this.mSize = 0;
        int oldMask = StrictMode.allowThreadDiskReadsMask();
        try {
            try {
                try {
                    BufferedReader r10 = Files.newBufferedReader(this.mFile);
                    try {
                        if (this.mBuf == null) {
                            this.mBuf = new char[1024];
                        }
                        while (true) {
                            char[] cArr = this.mBuf;
                            int curr = r10.read(cArr, total, cArr.length - total);
                            if (curr < 0) {
                                this.mSize = total;
                                this.mLastReadTime = this.mClock.elapsedRealtime();
                                this.mReadLock.lock();
                                ProcFileIterator procFileIterator = new ProcFileIterator(total);
                                if (r10 != null) {
                                    r10.close();
                                }
                                return procFileIterator;
                            }
                            total += curr;
                            char[] cArr2 = this.mBuf;
                            if (total == cArr2.length) {
                                if (cArr2.length == 1048576) {
                                    this.mErrors++;
                                    Slog.e(TAG, "Proc file too large: " + ((Object) this.mFile));
                                    if (r10 != null) {
                                        r10.close();
                                    }
                                    return null;
                                }
                                this.mBuf = Arrays.copyOf(cArr2, Math.min(cArr2.length << 1, 1048576));
                            }
                        }
                    } catch (Throwable th) {
                        if (r10 != null) {
                            try {
                                r10.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException | NoSuchFileException e2) {
                    this.mErrors++;
                    Slog.w(TAG, "File not found. It's normal if not implemented: " + ((Object) this.mFile));
                    return null;
                }
            } catch (IOException e10) {
                this.mErrors++;
                Slog.e(TAG, "Error reading " + ((Object) this.mFile), e10);
                return null;
            }
        } finally {
            StrictMode.setThreadPolicyMask(oldMask);
            this.mWriteLock.unlock();
        }
    }

    private boolean dataValid() {
        return this.mSize > 0 && this.mClock.elapsedRealtime() - this.mLastReadTime < 500;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class ProcFileIterator implements AutoCloseable {
        private int mPos;
        private final int mSize;

        public ProcFileIterator(int size) {
            this.mSize = size;
        }

        public boolean hasNextLine() {
            return this.mPos < this.mSize;
        }

        public CharBuffer nextLine() {
            if (this.mPos >= this.mSize) {
                return null;
            }
            int i10 = this.mPos;
            while (i10 < this.mSize && KernelCpuProcStringReader.this.mBuf[i10] != '\n') {
                i10++;
            }
            int start = this.mPos;
            this.mPos = i10 + 1;
            return CharBuffer.wrap(KernelCpuProcStringReader.this.mBuf, start, i10 - start);
        }

        public int size() {
            return this.mSize;
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            KernelCpuProcStringReader.this.mReadLock.unlock();
        }
    }

    public static int asLongs(CharBuffer buf, long[] array) {
        if (buf == null) {
            return -1;
        }
        int initialPos = buf.position();
        int count = 0;
        long num = -1;
        while (buf.remaining() > 0 && count < array.length) {
            char c4 = buf.get();
            if (!isNumber(c4) && c4 != ' ' && c4 != ':') {
                buf.position(initialPos);
                return -2;
            }
            if (num < 0) {
                if (isNumber(c4)) {
                    num = c4 - '0';
                }
            } else if (isNumber(c4)) {
                num = ((10 * num) + c4) - 48;
                if (num < 0) {
                    buf.position(initialPos);
                    return -3;
                }
            } else {
                array[count] = num;
                num = -1;
                count++;
            }
        }
        if (num >= 0) {
            array[count] = num;
            count++;
        }
        buf.position(initialPos);
        return count;
    }

    private static boolean isNumber(char c4) {
        return c4 >= '0' && c4 <= '9';
    }
}