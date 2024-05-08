package com.android.internal.os;

import android.util.ArrayMap;
import android.util.Slog;
import com.android.internal.os.KernelCpuThreadReader;
import com.android.internal.util.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class KernelCpuThreadReaderDiff {
    private static final int OTHER_THREADS_ID = -1;
    private static final String OTHER_THREADS_NAME = "__OTHER_THREADS";
    private static final String TAG = "KernelCpuThreadReaderDiff";
    private int mMinimumTotalCpuUsageMillis;
    private Map<ThreadKey, int[]> mPreviousCpuUsage = null;
    private final KernelCpuThreadReader mReader;

    public KernelCpuThreadReaderDiff(KernelCpuThreadReader reader, int minimumTotalCpuUsageMillis) {
        this.mReader = (KernelCpuThreadReader) Preconditions.checkNotNull(reader);
        this.mMinimumTotalCpuUsageMillis = minimumTotalCpuUsageMillis;
    }

    public ArrayList<KernelCpuThreadReader.ProcessCpuUsage> getProcessCpuUsageDiffed() {
        Map<ThreadKey, int[]> newCpuUsage = null;
        try {
            ArrayList<KernelCpuThreadReader.ProcessCpuUsage> processCpuUsages = this.mReader.getProcessCpuUsage();
            newCpuUsage = createCpuUsageMap(processCpuUsages);
            if (this.mPreviousCpuUsage != null) {
                for (int i10 = 0; i10 < processCpuUsages.size(); i10++) {
                    KernelCpuThreadReader.ProcessCpuUsage processCpuUsage = processCpuUsages.get(i10);
                    changeToDiffs(this.mPreviousCpuUsage, processCpuUsage);
                    applyThresholding(processCpuUsage);
                }
                return processCpuUsages;
            }
            this.mPreviousCpuUsage = newCpuUsage;
            return null;
        } finally {
            this.mPreviousCpuUsage = newCpuUsage;
        }
    }

    public int[] getCpuFrequenciesKhz() {
        return this.mReader.getCpuFrequenciesKhz();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMinimumTotalCpuUsageMillis(int minimumTotalCpuUsageMillis) {
        if (minimumTotalCpuUsageMillis < 0) {
            Slog.w(TAG, "Negative minimumTotalCpuUsageMillis: " + minimumTotalCpuUsageMillis);
        } else {
            this.mMinimumTotalCpuUsageMillis = minimumTotalCpuUsageMillis;
        }
    }

    private static Map<ThreadKey, int[]> createCpuUsageMap(List<KernelCpuThreadReader.ProcessCpuUsage> processCpuUsages) {
        Map<ThreadKey, int[]> cpuUsageMap = new ArrayMap<>();
        for (int i10 = 0; i10 < processCpuUsages.size(); i10++) {
            KernelCpuThreadReader.ProcessCpuUsage processCpuUsage = processCpuUsages.get(i10);
            for (int j10 = 0; j10 < processCpuUsage.threadCpuUsages.size(); j10++) {
                KernelCpuThreadReader.ThreadCpuUsage threadCpuUsage = processCpuUsage.threadCpuUsages.get(j10);
                cpuUsageMap.put(new ThreadKey(processCpuUsage.processId, threadCpuUsage.threadId, processCpuUsage.processName, threadCpuUsage.threadName), threadCpuUsage.usageTimesMillis);
            }
        }
        return cpuUsageMap;
    }

    private static void changeToDiffs(Map<ThreadKey, int[]> previousCpuUsage, KernelCpuThreadReader.ProcessCpuUsage processCpuUsage) {
        for (int i10 = 0; i10 < processCpuUsage.threadCpuUsages.size(); i10++) {
            KernelCpuThreadReader.ThreadCpuUsage threadCpuUsage = processCpuUsage.threadCpuUsages.get(i10);
            ThreadKey key = new ThreadKey(processCpuUsage.processId, threadCpuUsage.threadId, processCpuUsage.processName, threadCpuUsage.threadName);
            int[] previous = previousCpuUsage.get(key);
            if (previous == null) {
                previous = new int[threadCpuUsage.usageTimesMillis.length];
            }
            threadCpuUsage.usageTimesMillis = cpuTimeDiff(threadCpuUsage.usageTimesMillis, previous);
        }
    }

    private void applyThresholding(KernelCpuThreadReader.ProcessCpuUsage processCpuUsage) {
        int[] filteredThreadsCpuUsage = null;
        ArrayList<KernelCpuThreadReader.ThreadCpuUsage> thresholded = new ArrayList<>();
        for (int i10 = 0; i10 < processCpuUsage.threadCpuUsages.size(); i10++) {
            KernelCpuThreadReader.ThreadCpuUsage threadCpuUsage = processCpuUsage.threadCpuUsages.get(i10);
            if (this.mMinimumTotalCpuUsageMillis > totalCpuUsage(threadCpuUsage.usageTimesMillis)) {
                if (filteredThreadsCpuUsage == null) {
                    filteredThreadsCpuUsage = new int[threadCpuUsage.usageTimesMillis.length];
                }
                addToCpuUsage(filteredThreadsCpuUsage, threadCpuUsage.usageTimesMillis);
            } else {
                thresholded.add(threadCpuUsage);
            }
        }
        if (filteredThreadsCpuUsage != null) {
            thresholded.add(new KernelCpuThreadReader.ThreadCpuUsage(-1, OTHER_THREADS_NAME, filteredThreadsCpuUsage));
        }
        processCpuUsage.threadCpuUsages = thresholded;
    }

    private static int totalCpuUsage(int[] cpuUsage) {
        int total = 0;
        for (int i10 : cpuUsage) {
            total += i10;
        }
        return total;
    }

    private static void addToCpuUsage(int[] a10, int[] b4) {
        for (int i10 = 0; i10 < a10.length; i10++) {
            a10[i10] = a10[i10] + b4[i10];
        }
    }

    private static int[] cpuTimeDiff(int[] a10, int[] b4) {
        int[] difference = new int[a10.length];
        for (int i10 = 0; i10 < a10.length; i10++) {
            difference[i10] = a10[i10] - b4[i10];
        }
        return difference;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class ThreadKey {
        private final int mProcessId;
        private final int mProcessNameHash;
        private final int mThreadId;
        private final int mThreadNameHash;

        ThreadKey(int processId, int threadId, String processName, String threadName) {
            this.mProcessId = processId;
            this.mThreadId = threadId;
            this.mProcessNameHash = Objects.hash(processName);
            this.mThreadNameHash = Objects.hash(threadName);
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.mProcessId), Integer.valueOf(this.mThreadId), Integer.valueOf(this.mProcessNameHash), Integer.valueOf(this.mThreadNameHash));
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ThreadKey)) {
                return false;
            }
            ThreadKey other = (ThreadKey) obj;
            return this.mProcessId == other.mProcessId && this.mThreadId == other.mThreadId && this.mProcessNameHash == other.mProcessNameHash && this.mThreadNameHash == other.mThreadNameHash;
        }
    }
}
