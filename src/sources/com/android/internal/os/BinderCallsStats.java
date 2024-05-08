package com.android.internal.os;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.format.DateFormat;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IntArray;
import android.util.KeyValueListParser;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import com.alimm.tanx.core.web.cache.utils.TimeUtils;
import com.android.internal.logging.nano.MetricsProto;
import com.android.internal.os.BinderCallsStats;
import com.android.internal.os.BinderInternal;
import com.android.internal.os.BinderLatencyObserver;
import com.android.internal.os.CachedDeviceState;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;
import java.util.function.ToDoubleFunction;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class BinderCallsStats implements BinderInternal.Observer {
    private static final int CALL_SESSIONS_POOL_SIZE = 100;
    private static final int CALL_STATS_OBSERVER_DEBOUNCE_MILLIS = 5000;
    private static final String DEBUG_ENTRY_PREFIX = "__DEBUG_";
    public static final boolean DEFAULT_COLLECT_LATENCY_DATA = true;
    public static final boolean DEFAULT_IGNORE_BATTERY_STATUS = false;
    public static final boolean DEFAULT_TRACK_DIRECT_CALLING_UID = true;
    public static final boolean DEFAULT_TRACK_SCREEN_INTERACTIVE = false;
    public static final boolean DETAILED_TRACKING_DEFAULT = true;
    public static final boolean ENABLED_DEFAULT = true;
    private static final String EXCEPTION_COUNT_OVERFLOW_NAME = "overflow";
    public static final int MAX_BINDER_CALL_STATS_COUNT_DEFAULT = 1500;
    private static final int MAX_EXCEPTION_COUNT_SIZE = 50;
    private static final Class<? extends Binder> OVERFLOW_BINDER = OverflowBinder.class;
    private static final int OVERFLOW_DIRECT_CALLING_UID = -1;
    private static final boolean OVERFLOW_SCREEN_INTERACTIVE = false;
    private static final int OVERFLOW_TRANSACTION_CODE = -1;
    public static final int PERIODIC_SAMPLING_INTERVAL_DEFAULT = 1000;
    public static final int SHARDING_MODULO_DEFAULT = 1;
    private static final String TAG = "BinderCallsStats";
    private boolean mAddDebugEntries;
    private CachedDeviceState.TimeInStateStopwatch mBatteryStopwatch;
    private final Queue<BinderInternal.CallSession> mCallSessionsPool;
    private long mCallStatsCount;
    private BinderInternal.CallStatsObserver mCallStatsObserver;
    private final Handler mCallStatsObserverHandler;
    private Runnable mCallStatsObserverRunnable;
    private boolean mCollectLatencyData;
    private boolean mDetailedTracking;
    private CachedDeviceState.Readonly mDeviceState;
    private final ArrayMap<String, Integer> mExceptionCounts;
    private boolean mIgnoreBatteryStatus;
    private BinderLatencyObserver mLatencyObserver;
    private final Object mLock;
    private int mMaxBinderCallStatsCount;
    private volatile IntArray mNativeTids;
    private final Object mNativeTidsLock;
    private int mPeriodicSamplingInterval;
    private final Random mRandom;
    private boolean mRecordingAllTransactionsForUid;
    private ArraySet<Integer> mSendUidsToObserver;
    private int mShardingModulo;
    private int mShardingOffset;
    private long mStartCurrentTime;
    private long mStartElapsedTime;
    private boolean mTrackDirectCallingUid;
    private boolean mTrackScreenInteractive;
    private final SparseArray<UidEntry> mUidEntries;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class ExportedCallStat {
        Class<? extends Binder> binderClass;
        public long callCount;
        public int callingUid;
        public String className;
        public long cpuTimeMicros;
        public long exceptionCount;
        public long latencyMicros;
        public long maxCpuTimeMicros;
        public long maxLatencyMicros;
        public long maxReplySizeBytes;
        public long maxRequestSizeBytes;
        public String methodName;
        public long recordedCallCount;
        public boolean screenInteractive;
        int transactionCode;
        public int workSourceUid;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private static class OverflowBinder extends Binder {
        private OverflowBinder() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Injector {
        public Random getRandomGenerator() {
            return new Random();
        }

        public Handler getHandler() {
            return new Handler(Looper.getMainLooper());
        }

        public BinderLatencyObserver getLatencyObserver(int processSource) {
            return new BinderLatencyObserver(new BinderLatencyObserver.Injector(), processSource);
        }
    }

    public BinderCallsStats(Injector injector) {
        this(injector, 1);
    }

    public BinderCallsStats(Injector injector, int processSource) {
        this.mDetailedTracking = true;
        this.mPeriodicSamplingInterval = 1000;
        this.mMaxBinderCallStatsCount = 1500;
        this.mUidEntries = new SparseArray<>();
        this.mExceptionCounts = new ArrayMap<>();
        this.mCallSessionsPool = new ConcurrentLinkedQueue();
        this.mLock = new Object();
        this.mStartCurrentTime = System.currentTimeMillis();
        this.mStartElapsedTime = SystemClock.elapsedRealtime();
        this.mCallStatsCount = 0L;
        this.mAddDebugEntries = false;
        this.mTrackDirectCallingUid = true;
        this.mTrackScreenInteractive = false;
        this.mIgnoreBatteryStatus = false;
        this.mCollectLatencyData = true;
        this.mShardingModulo = 1;
        this.mSendUidsToObserver = new ArraySet<>(32);
        this.mCallStatsObserverRunnable = new Runnable() { // from class: com.android.internal.os.BinderCallsStats.1
            @Override // java.lang.Runnable
            public void run() {
                if (BinderCallsStats.this.mCallStatsObserver == null) {
                    return;
                }
                BinderCallsStats.this.noteCallsStatsDelayed();
                synchronized (BinderCallsStats.this.mLock) {
                    int size = BinderCallsStats.this.mSendUidsToObserver.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        UidEntry uidEntry = (UidEntry) BinderCallsStats.this.mUidEntries.get(((Integer) BinderCallsStats.this.mSendUidsToObserver.valueAt(i10)).intValue());
                        if (uidEntry != null) {
                            ArrayMap<CallStatKey, CallStat> callStats = uidEntry.mCallStats;
                            int csize = callStats.size();
                            ArrayList<CallStat> tmpCallStats = new ArrayList<>(csize);
                            for (int j10 = 0; j10 < csize; j10++) {
                                tmpCallStats.add(callStats.valueAt(j10).m2375clone());
                            }
                            BinderCallsStats.this.mCallStatsObserver.noteCallStats(uidEntry.workSourceUid, uidEntry.incrementalCallCount, tmpCallStats);
                            uidEntry.incrementalCallCount = 0L;
                            for (int j11 = callStats.size() - 1; j11 >= 0; j11--) {
                                callStats.valueAt(j11).incrementalCallCount = 0L;
                            }
                        }
                    }
                    BinderCallsStats.this.mSendUidsToObserver.clear();
                }
            }
        };
        this.mNativeTidsLock = new Object();
        this.mNativeTids = new IntArray(0);
        Random randomGenerator = injector.getRandomGenerator();
        this.mRandom = randomGenerator;
        this.mCallStatsObserverHandler = injector.getHandler();
        this.mLatencyObserver = injector.getLatencyObserver(processSource);
        this.mShardingOffset = randomGenerator.nextInt(this.mShardingModulo);
    }

    public void setDeviceState(CachedDeviceState.Readonly deviceState) {
        CachedDeviceState.TimeInStateStopwatch timeInStateStopwatch = this.mBatteryStopwatch;
        if (timeInStateStopwatch != null) {
            timeInStateStopwatch.close();
        }
        this.mDeviceState = deviceState;
        this.mBatteryStopwatch = deviceState.createTimeOnBatteryStopwatch();
    }

    public void setCallStatsObserver(BinderInternal.CallStatsObserver callStatsObserver) {
        this.mCallStatsObserver = callStatsObserver;
        noteBinderThreadNativeIds();
        noteCallsStatsDelayed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void noteCallsStatsDelayed() {
        this.mCallStatsObserverHandler.removeCallbacks(this.mCallStatsObserverRunnable);
        if (this.mCallStatsObserver != null) {
            this.mCallStatsObserverHandler.postDelayed(this.mCallStatsObserverRunnable, 5000L);
        }
    }

    @Override // com.android.internal.os.BinderInternal.Observer
    public BinderInternal.CallSession callStarted(Binder binder, int code, int workSourceUid) {
        noteNativeThreadId();
        boolean collectCpu = canCollect();
        if (!this.mCollectLatencyData && !collectCpu) {
            return null;
        }
        BinderInternal.CallSession s2 = obtainCallSession();
        s2.binderClass = binder.getClass();
        s2.transactionCode = code;
        s2.exceptionThrown = false;
        s2.cpuTimeStarted = -1L;
        s2.timeStarted = -1L;
        s2.recordedCall = shouldRecordDetailedData();
        if (collectCpu && (this.mRecordingAllTransactionsForUid || s2.recordedCall)) {
            s2.cpuTimeStarted = getThreadTimeMicro();
            s2.timeStarted = getElapsedRealtimeMicro();
        } else if (this.mCollectLatencyData) {
            s2.timeStarted = getElapsedRealtimeMicro();
        }
        return s2;
    }

    private BinderInternal.CallSession obtainCallSession() {
        BinderInternal.CallSession s2 = this.mCallSessionsPool.poll();
        return s2 == null ? new BinderInternal.CallSession() : s2;
    }

    @Override // com.android.internal.os.BinderInternal.Observer
    public void callEnded(BinderInternal.CallSession s2, int parcelRequestSize, int parcelReplySize, int workSourceUid) {
        if (s2 == null) {
            return;
        }
        processCallEnded(s2, parcelRequestSize, parcelReplySize, workSourceUid);
        if (this.mCallSessionsPool.size() < 100) {
            this.mCallSessionsPool.add(s2);
        }
    }

    private void processCallEnded(BinderInternal.CallSession s2, int parcelRequestSize, int parcelReplySize, int workSourceUid) {
        boolean recordCall;
        UidEntry uidEntry;
        long duration;
        long latencyDuration;
        Object obj;
        if (this.mCollectLatencyData) {
            this.mLatencyObserver.callEnded(s2);
        }
        if (canCollect()) {
            if (s2.recordedCall) {
                recordCall = true;
                uidEntry = null;
            } else {
                boolean recordCall2 = this.mRecordingAllTransactionsForUid;
                if (recordCall2) {
                    UidEntry uidEntry2 = getUidEntry(workSourceUid);
                    recordCall = uidEntry2.recordAllTransactions;
                    uidEntry = uidEntry2;
                } else {
                    recordCall = false;
                    uidEntry = null;
                }
            }
            if (recordCall) {
                duration = getThreadTimeMicro() - s2.cpuTimeStarted;
                latencyDuration = getElapsedRealtimeMicro() - s2.timeStarted;
            } else {
                duration = 0;
                latencyDuration = 0;
            }
            boolean screenInteractive = this.mTrackScreenInteractive ? this.mDeviceState.isScreenInteractive() : false;
            int callingUid = this.mTrackDirectCallingUid ? getCallingUid() : -1;
            Object obj2 = this.mLock;
            synchronized (obj2) {
                try {
                    try {
                        try {
                            if (canCollect()) {
                                if (uidEntry == null) {
                                    uidEntry = getUidEntry(workSourceUid);
                                }
                                long j10 = 1;
                                uidEntry.callCount++;
                                uidEntry.incrementalCallCount++;
                                if (recordCall) {
                                    try {
                                        uidEntry.cpuTimeMicros += duration;
                                        uidEntry.recordedCallCount++;
                                        obj = obj2;
                                        try {
                                            CallStat callStat = uidEntry.getOrCreate(callingUid, s2.binderClass, s2.transactionCode, screenInteractive, this.mCallStatsCount >= ((long) this.mMaxBinderCallStatsCount));
                                            boolean isNewCallStat = callStat.callCount == 0;
                                            if (isNewCallStat) {
                                                try {
                                                    this.mCallStatsCount++;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    throw th;
                                                }
                                            }
                                            callStat.callCount++;
                                            callStat.incrementalCallCount++;
                                            callStat.recordedCallCount++;
                                            callStat.cpuTimeMicros += duration;
                                            callStat.maxCpuTimeMicros = Math.max(callStat.maxCpuTimeMicros, duration);
                                            callStat.latencyMicros += latencyDuration;
                                            callStat.maxLatencyMicros = Math.max(callStat.maxLatencyMicros, latencyDuration);
                                            if (this.mDetailedTracking) {
                                                long j11 = callStat.exceptionCount;
                                                if (!s2.exceptionThrown) {
                                                    j10 = 0;
                                                }
                                                callStat.exceptionCount = j11 + j10;
                                                try {
                                                    callStat.maxRequestSizeBytes = Math.max(callStat.maxRequestSizeBytes, parcelRequestSize);
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    throw th;
                                                }
                                                try {
                                                    callStat.maxReplySizeBytes = Math.max(callStat.maxReplySizeBytes, parcelReplySize);
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    throw th;
                                                }
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        obj = obj2;
                                    }
                                } else {
                                    obj = obj2;
                                    try {
                                        CallStat callStat2 = uidEntry.get(callingUid, s2.binderClass, s2.transactionCode, screenInteractive);
                                        if (callStat2 != null) {
                                            callStat2.callCount++;
                                            callStat2.incrementalCallCount++;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        throw th;
                                    }
                                }
                                if (this.mCallStatsObserver != null && !UserHandle.isCore(workSourceUid)) {
                                    this.mSendUidsToObserver.add(Integer.valueOf(workSourceUid));
                                }
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            obj = obj2;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        obj = obj2;
                    }
                } catch (Throwable th9) {
                    th = th9;
                }
            }
        }
    }

    private boolean shouldExport(ExportedCallStat e2, boolean applySharding) {
        if (!applySharding) {
            return true;
        }
        int hash = e2.binderClass.hashCode();
        int hash2 = ((((hash * 31) + e2.transactionCode) * 31) + e2.callingUid) * 31;
        int i10 = e2.screenInteractive ? MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP : MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT;
        int hash3 = this.mShardingOffset;
        return (hash3 + (hash2 + i10)) % this.mShardingModulo == 0;
    }

    private UidEntry getUidEntry(int uid) {
        UidEntry uidEntry = this.mUidEntries.get(uid);
        if (uidEntry == null) {
            UidEntry uidEntry2 = new UidEntry(uid);
            this.mUidEntries.put(uid, uidEntry2);
            return uidEntry2;
        }
        return uidEntry;
    }

    @Override // com.android.internal.os.BinderInternal.Observer
    public void callThrewException(BinderInternal.CallSession s2, Exception exception) {
        if (s2 == null) {
            return;
        }
        int i10 = 1;
        s2.exceptionThrown = true;
        try {
            String className = exception.getClass().getName();
            synchronized (this.mLock) {
                if (this.mExceptionCounts.size() >= 50) {
                    className = EXCEPTION_COUNT_OVERFLOW_NAME;
                }
                Integer count = this.mExceptionCounts.get(className);
                ArrayMap<String, Integer> arrayMap = this.mExceptionCounts;
                if (count != null) {
                    i10 = 1 + count.intValue();
                }
                arrayMap.put(className, Integer.valueOf(i10));
            }
        } catch (RuntimeException e2) {
            Slog.wtf(TAG, "Unexpected exception while updating mExceptionCounts");
        }
    }

    private void noteNativeThreadId() {
        int tid = getNativeTid();
        if (this.mNativeTids.binarySearch(tid) >= 0) {
            return;
        }
        synchronized (this.mNativeTidsLock) {
            IntArray nativeTids = this.mNativeTids;
            int index = nativeTids.binarySearch(tid);
            if (index < 0) {
                IntArray copyOnWriteArray = new IntArray(nativeTids.size() + 1);
                copyOnWriteArray.addAll(nativeTids);
                copyOnWriteArray.add((-index) - 1, tid);
                this.mNativeTids = copyOnWriteArray;
            }
        }
        noteBinderThreadNativeIds();
    }

    private void noteBinderThreadNativeIds() {
        BinderInternal.CallStatsObserver callStatsObserver = this.mCallStatsObserver;
        if (callStatsObserver == null) {
            return;
        }
        callStatsObserver.noteBinderThreadNativeIds(getNativeTids());
    }

    private boolean canCollect() {
        if (this.mRecordingAllTransactionsForUid || this.mIgnoreBatteryStatus) {
            return true;
        }
        CachedDeviceState.Readonly readonly = this.mDeviceState;
        return (readonly == null || readonly.isCharging()) ? false : true;
    }

    public ArrayList<ExportedCallStat> getExportedCallStats() {
        return getExportedCallStats(false);
    }

    public ArrayList<ExportedCallStat> getExportedCallStats(boolean applySharding) {
        if (!this.mDetailedTracking) {
            return new ArrayList<>();
        }
        ArrayList<ExportedCallStat> resultCallStats = new ArrayList<>();
        synchronized (this.mLock) {
            int uidEntriesSize = this.mUidEntries.size();
            for (int entryIdx = 0; entryIdx < uidEntriesSize; entryIdx++) {
                UidEntry entry = this.mUidEntries.valueAt(entryIdx);
                for (CallStat stat : entry.getCallStatsList()) {
                    ExportedCallStat e2 = getExportedCallStat(entry.workSourceUid, stat);
                    if (shouldExport(e2, applySharding)) {
                        resultCallStats.add(e2);
                    }
                }
            }
        }
        resolveBinderMethodNames(resultCallStats);
        if (this.mAddDebugEntries && this.mBatteryStopwatch != null) {
            resultCallStats.add(createDebugEntry("start_time_millis", this.mStartElapsedTime));
            resultCallStats.add(createDebugEntry("end_time_millis", SystemClock.elapsedRealtime()));
            resultCallStats.add(createDebugEntry("battery_time_millis", this.mBatteryStopwatch.getMillis()));
            resultCallStats.add(createDebugEntry(SettingsObserver.SETTINGS_SAMPLING_INTERVAL_KEY, this.mPeriodicSamplingInterval));
            resultCallStats.add(createDebugEntry(SettingsObserver.SETTINGS_SHARDING_MODULO_KEY, this.mShardingModulo));
        }
        return resultCallStats;
    }

    public ArrayList<ExportedCallStat> getExportedCallStats(int workSourceUid) {
        return getExportedCallStats(workSourceUid, false);
    }

    public ArrayList<ExportedCallStat> getExportedCallStats(int workSourceUid, boolean applySharding) {
        ArrayList<ExportedCallStat> resultCallStats = new ArrayList<>();
        synchronized (this.mLock) {
            UidEntry entry = getUidEntry(workSourceUid);
            for (CallStat stat : entry.getCallStatsList()) {
                ExportedCallStat e2 = getExportedCallStat(workSourceUid, stat);
                if (shouldExport(e2, applySharding)) {
                    resultCallStats.add(e2);
                }
            }
        }
        resolveBinderMethodNames(resultCallStats);
        return resultCallStats;
    }

    private ExportedCallStat getExportedCallStat(int workSourceUid, CallStat stat) {
        ExportedCallStat exported = new ExportedCallStat();
        exported.workSourceUid = workSourceUid;
        exported.callingUid = stat.callingUid;
        exported.className = stat.binderClass.getName();
        exported.binderClass = stat.binderClass;
        exported.transactionCode = stat.transactionCode;
        exported.screenInteractive = stat.screenInteractive;
        exported.cpuTimeMicros = stat.cpuTimeMicros;
        exported.maxCpuTimeMicros = stat.maxCpuTimeMicros;
        exported.latencyMicros = stat.latencyMicros;
        exported.maxLatencyMicros = stat.maxLatencyMicros;
        exported.recordedCallCount = stat.recordedCallCount;
        exported.callCount = stat.callCount;
        exported.maxRequestSizeBytes = stat.maxRequestSizeBytes;
        exported.maxReplySizeBytes = stat.maxReplySizeBytes;
        exported.exceptionCount = stat.exceptionCount;
        return exported;
    }

    private void resolveBinderMethodNames(ArrayList<ExportedCallStat> resultCallStats) {
        String methodName;
        ExportedCallStat previous = null;
        String previousMethodName = null;
        resultCallStats.sort(new Comparator() { // from class: com.android.internal.os.BinderCallsStats$$ExternalSyntheticLambda5
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int compareByBinderClassAndCode;
                compareByBinderClassAndCode = BinderCallsStats.compareByBinderClassAndCode((BinderCallsStats.ExportedCallStat) obj, (BinderCallsStats.ExportedCallStat) obj2);
                return compareByBinderClassAndCode;
            }
        });
        BinderTransactionNameResolver resolver = new BinderTransactionNameResolver();
        Iterator<ExportedCallStat> iterator2 = resultCallStats.iterator2();
        while (iterator2.hasNext()) {
            ExportedCallStat exported = iterator2.next();
            boolean isClassDifferent = previous == null || !previous.className.equals(exported.className);
            boolean isCodeDifferent = previous == null || previous.transactionCode != exported.transactionCode;
            if (isClassDifferent || isCodeDifferent) {
                methodName = resolver.getMethodName(exported.binderClass, exported.transactionCode);
            } else {
                methodName = previousMethodName;
            }
            previousMethodName = methodName;
            exported.methodName = methodName;
            previous = exported;
        }
    }

    private ExportedCallStat createDebugEntry(String variableName, long value) {
        int uid = Process.myUid();
        ExportedCallStat callStat = new ExportedCallStat();
        callStat.className = "";
        callStat.workSourceUid = uid;
        callStat.callingUid = uid;
        callStat.recordedCallCount = 1L;
        callStat.callCount = 1L;
        callStat.methodName = "__DEBUG_" + variableName;
        callStat.latencyMicros = value;
        return callStat;
    }

    public ArrayMap<String, Integer> getExportedExceptionStats() {
        ArrayMap<String, Integer> arrayMap;
        synchronized (this.mLock) {
            arrayMap = new ArrayMap<>(this.mExceptionCounts);
        }
        return arrayMap;
    }

    public void dump(PrintWriter pw, AppIdToPackageMap packageMap, int workSourceUid, boolean verbose) {
        synchronized (this.mLock) {
            dumpLocked(pw, packageMap, workSourceUid, verbose);
        }
    }

    private void dumpLocked(PrintWriter pw, AppIdToPackageMap packageMap, int workSourceUid, boolean verbose) {
        boolean verbose2;
        List<ExportedCallStat> exportedCallStats;
        List<ExportedCallStat> exportedCallStats2;
        long totalRecordedCallsCount;
        long totalCpuTime;
        if (workSourceUid == -1) {
            verbose2 = verbose;
        } else {
            verbose2 = true;
        }
        pw.print("Start time: ");
        pw.println(DateFormat.format(TimeUtils.STARD_FROMAT, this.mStartCurrentTime));
        pw.print("On battery time (ms): ");
        CachedDeviceState.TimeInStateStopwatch timeInStateStopwatch = this.mBatteryStopwatch;
        pw.println(timeInStateStopwatch != null ? timeInStateStopwatch.getMillis() : 0L);
        pw.println("Sampling interval period: " + this.mPeriodicSamplingInterval);
        pw.println("Sharding modulo: " + this.mShardingModulo);
        String str = "";
        String datasetSizeDesc = verbose2 ? "" : "(top 90% by cpu time) ";
        StringBuilder sb2 = new StringBuilder();
        pw.println("Per-UID raw data " + datasetSizeDesc + "(package/uid, worksource, call_desc, screen_interactive, cpu_time_micros, max_cpu_time_micros, latency_time_micros, max_latency_time_micros, exception_count, max_request_size_bytes, max_reply_size_bytes, recorded_call_count, call_count):");
        if (workSourceUid != -1) {
            exportedCallStats = getExportedCallStats(workSourceUid, true);
        } else {
            exportedCallStats = getExportedCallStats(true);
        }
        exportedCallStats.sort(new Comparator() { // from class: com.android.internal.os.BinderCallsStats$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int compareByCpuDesc;
                compareByCpuDesc = BinderCallsStats.compareByCpuDesc((BinderCallsStats.ExportedCallStat) obj, (BinderCallsStats.ExportedCallStat) obj2);
                return compareByCpuDesc;
            }
        });
        Iterator<ExportedCallStat> iterator2 = exportedCallStats.iterator2();
        while (iterator2.hasNext()) {
            ExportedCallStat e2 = iterator2.next();
            if (e2.methodName == null || !e2.methodName.startsWith("__DEBUG_")) {
                sb2.setLength(0);
                List<ExportedCallStat> exportedCallStats3 = exportedCallStats;
                boolean verbose3 = verbose2;
                Iterator<ExportedCallStat> it = iterator2;
                sb2.append("    ").append(packageMap.mapUid(e2.callingUid)).append(',').append(packageMap.mapUid(e2.workSourceUid)).append(',').append(e2.className).append('#').append(e2.methodName).append(',').append(e2.screenInteractive).append(',').append(e2.cpuTimeMicros).append(',').append(e2.maxCpuTimeMicros).append(',').append(e2.latencyMicros).append(',').append(e2.maxLatencyMicros).append(',').append(this.mDetailedTracking ? e2.exceptionCount : 95L).append(',').append(this.mDetailedTracking ? e2.maxRequestSizeBytes : 95L).append(',').append(this.mDetailedTracking ? e2.maxReplySizeBytes : 95L).append(',').append(e2.recordedCallCount).append(',').append(e2.callCount);
                pw.println(sb2);
                iterator2 = it;
                verbose2 = verbose3;
                exportedCallStats = exportedCallStats3;
            }
        }
        boolean verbose4 = verbose2;
        List<ExportedCallStat> exportedCallStats4 = exportedCallStats;
        pw.println();
        List<UidEntry> entries = new ArrayList<>();
        long totalCallsCount = 0;
        long totalRecordedCallsCount2 = 0;
        long totalCpuTime2 = 0;
        if (workSourceUid == -1) {
            int uidEntriesSize = this.mUidEntries.size();
            for (int i10 = 0; i10 < uidEntriesSize; i10++) {
                UidEntry e10 = this.mUidEntries.valueAt(i10);
                entries.add(e10);
                totalCpuTime2 += e10.cpuTimeMicros;
                totalRecordedCallsCount2 += e10.recordedCallCount;
                totalCallsCount += e10.callCount;
            }
            entries.sort(Comparator.comparingDouble(new ToDoubleFunction() { // from class: com.android.internal.os.BinderCallsStats$$ExternalSyntheticLambda1
                /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 double, still in use, count: 1, list:
                      (r0v0 double) from 0x0006: RETURN (r0v0 double)
                    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
                    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
                    	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:80)
                    	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:56)
                    	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:452)
                    	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
                    */
                @Override // java.util.function.ToDoubleFunction
                public final double applyAsDouble(java.lang.Object r3) {
                    /*
                        r2 = this;
                        com.android.internal.os.BinderCallsStats$UidEntry r3 = (com.android.internal.os.BinderCallsStats.UidEntry) r3
                        double r0 = com.android.internal.os.BinderCallsStats.lambda$dumpLocked$0(r3)
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.android.internal.os.BinderCallsStats$$ExternalSyntheticLambda1.applyAsDouble(java.lang.Object):double");
                }
            }).reversed());
            exportedCallStats2 = exportedCallStats4;
            totalRecordedCallsCount = totalRecordedCallsCount2;
            totalCpuTime = totalCpuTime2;
        } else {
            UidEntry e11 = getUidEntry(workSourceUid);
            entries.add(e11);
            long totalCpuTime3 = 0 + e11.cpuTimeMicros;
            long totalRecordedCallsCount3 = 0 + e11.recordedCallCount;
            totalCallsCount = 0 + e11.callCount;
            exportedCallStats2 = exportedCallStats4;
            totalRecordedCallsCount = totalRecordedCallsCount3;
            totalCpuTime = totalCpuTime3;
        }
        pw.println("Per-UID Summary " + datasetSizeDesc + "(cpu_time, % of total cpu_time, recorded_call_count, call_count, package/uid):");
        List<UidEntry> summaryEntries = verbose4 ? entries : getHighestValues(entries, new ToDoubleFunction() { // from class: com.android.internal.os.BinderCallsStats$$ExternalSyntheticLambda2
            /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 double, still in use, count: 1, list:
                  (r0v0 double) from 0x0006: RETURN (r0v0 double)
                	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
                	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
                	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:80)
                	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:56)
                	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:452)
                	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
                */
            @Override // java.util.function.ToDoubleFunction
            public final double applyAsDouble(java.lang.Object r3) {
                /*
                    r2 = this;
                    com.android.internal.os.BinderCallsStats$UidEntry r3 = (com.android.internal.os.BinderCallsStats.UidEntry) r3
                    double r0 = com.android.internal.os.BinderCallsStats.lambda$dumpLocked$1(r3)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.android.internal.os.BinderCallsStats$$ExternalSyntheticLambda2.applyAsDouble(java.lang.Object):double");
            }
        }, 0.9d);
        Iterator<UidEntry> iterator22 = summaryEntries.iterator2();
        while (iterator22.hasNext()) {
            UidEntry entry = iterator22.next();
            List<UidEntry> entries2 = entries;
            String uidStr = packageMap.mapUid(entry.workSourceUid);
            pw.println(String.format("  %10d %3.0f%% %8d %8d %s", Long.valueOf(entry.cpuTimeMicros), Double.valueOf((entry.cpuTimeMicros * 100.0d) / totalCpuTime), Long.valueOf(entry.recordedCallCount), Long.valueOf(entry.callCount), uidStr));
            entries = entries2;
            str = str;
            summaryEntries = summaryEntries;
            iterator22 = iterator22;
            totalRecordedCallsCount = totalRecordedCallsCount;
        }
        String str2 = str;
        long totalRecordedCallsCount4 = totalRecordedCallsCount;
        pw.println();
        if (workSourceUid == -1) {
            pw.println(String.format("  Summary: total_cpu_time=%d, calls_count=%d, avg_call_cpu_time=%.0f", Long.valueOf(totalCpuTime), Long.valueOf(totalCallsCount), Double.valueOf(totalCpuTime / totalRecordedCallsCount4)));
            pw.println();
        }
        pw.println("Exceptions thrown (exception_count, class_name):");
        final List<Pair<String, Integer>> exceptionEntries = new ArrayList<>();
        this.mExceptionCounts.entrySet().iterator2().forEachRemaining(new Consumer() { // from class: com.android.internal.os.BinderCallsStats$$ExternalSyntheticLambda3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                List.this.add(Pair.create((String) r2.getKey(), (Integer) ((Map.Entry) obj).getValue()));
            }
        });
        exceptionEntries.sort(new Comparator() { // from class: com.android.internal.os.BinderCallsStats$$ExternalSyntheticLambda4
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int compare;
                compare = Integer.compare(((Integer) ((Pair) obj2).second).intValue(), ((Integer) ((Pair) obj).second).intValue());
                return compare;
            }
        });
        for (Pair<String, Integer> entry2 : exceptionEntries) {
            pw.println(String.format("  %6d %s", entry2.second, entry2.first));
        }
        if (this.mPeriodicSamplingInterval != 1) {
            pw.println(str2);
            pw.println("/!\\ Displayed data is sampled. See sampling interval at the top.");
        }
    }

    protected long getThreadTimeMicro() {
        return SystemClock.currentThreadTimeMicro();
    }

    protected int getCallingUid() {
        return Binder.getCallingUid();
    }

    protected int getNativeTid() {
        return Process.myTid();
    }

    public int[] getNativeTids() {
        return this.mNativeTids.toArray();
    }

    protected long getElapsedRealtimeMicro() {
        return SystemClock.elapsedRealtimeNanos() / 1000;
    }

    protected boolean shouldRecordDetailedData() {
        return this.mRandom.nextInt(this.mPeriodicSamplingInterval) == 0;
    }

    public void setDetailedTracking(boolean enabled) {
        synchronized (this.mLock) {
            if (enabled != this.mDetailedTracking) {
                this.mDetailedTracking = enabled;
                reset();
            }
        }
    }

    public void setTrackScreenInteractive(boolean enabled) {
        synchronized (this.mLock) {
            if (enabled != this.mTrackScreenInteractive) {
                this.mTrackScreenInteractive = enabled;
                reset();
            }
        }
    }

    public void setTrackDirectCallerUid(boolean enabled) {
        synchronized (this.mLock) {
            if (enabled != this.mTrackDirectCallingUid) {
                this.mTrackDirectCallingUid = enabled;
                reset();
            }
        }
    }

    public void setIgnoreBatteryStatus(boolean ignored) {
        synchronized (this.mLock) {
            if (ignored != this.mIgnoreBatteryStatus) {
                this.mIgnoreBatteryStatus = ignored;
                reset();
            }
        }
    }

    public void recordAllCallsForWorkSourceUid(int workSourceUid) {
        setDetailedTracking(true);
        Slog.i(TAG, "Recording all Binder calls for UID: " + workSourceUid);
        UidEntry uidEntry = getUidEntry(workSourceUid);
        uidEntry.recordAllTransactions = true;
        this.mRecordingAllTransactionsForUid = true;
    }

    public void setAddDebugEntries(boolean addDebugEntries) {
        this.mAddDebugEntries = addDebugEntries;
    }

    public void setMaxBinderCallStats(int maxKeys) {
        if (maxKeys <= 0) {
            Slog.w(TAG, "Ignored invalid max value (value must be positive): " + maxKeys);
            return;
        }
        synchronized (this.mLock) {
            if (maxKeys != this.mMaxBinderCallStatsCount) {
                this.mMaxBinderCallStatsCount = maxKeys;
                reset();
            }
        }
    }

    public void setSamplingInterval(int samplingInterval) {
        if (samplingInterval <= 0) {
            Slog.w(TAG, "Ignored invalid sampling interval (value must be positive): " + samplingInterval);
            return;
        }
        synchronized (this.mLock) {
            if (samplingInterval != this.mPeriodicSamplingInterval) {
                this.mPeriodicSamplingInterval = samplingInterval;
                reset();
            }
        }
    }

    public void setShardingModulo(int shardingModulo) {
        if (shardingModulo <= 0) {
            Slog.w(TAG, "Ignored invalid sharding modulo (value must be positive): " + shardingModulo);
            return;
        }
        synchronized (this.mLock) {
            if (shardingModulo != this.mShardingModulo) {
                this.mShardingModulo = shardingModulo;
                this.mShardingOffset = this.mRandom.nextInt(shardingModulo);
                reset();
            }
        }
    }

    public void setCollectLatencyData(boolean collectLatencyData) {
        this.mCollectLatencyData = collectLatencyData;
    }

    public boolean getCollectLatencyData() {
        return this.mCollectLatencyData;
    }

    public void reset() {
        synchronized (this.mLock) {
            this.mCallStatsCount = 0L;
            this.mUidEntries.clear();
            this.mExceptionCounts.clear();
            this.mStartCurrentTime = System.currentTimeMillis();
            this.mStartElapsedTime = SystemClock.elapsedRealtime();
            CachedDeviceState.TimeInStateStopwatch timeInStateStopwatch = this.mBatteryStopwatch;
            if (timeInStateStopwatch != null) {
                timeInStateStopwatch.reset();
            }
            this.mRecordingAllTransactionsForUid = false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class CallStat {
        public final Class<? extends Binder> binderClass;
        public long callCount;
        public final int callingUid;
        public long cpuTimeMicros;
        public long exceptionCount;
        public long incrementalCallCount;
        public long latencyMicros;
        public long maxCpuTimeMicros;
        public long maxLatencyMicros;
        public long maxReplySizeBytes;
        public long maxRequestSizeBytes;
        public long recordedCallCount;
        public final boolean screenInteractive;
        public final int transactionCode;

        public CallStat(int callingUid, Class<? extends Binder> binderClass, int transactionCode, boolean screenInteractive) {
            this.callingUid = callingUid;
            this.binderClass = binderClass;
            this.transactionCode = transactionCode;
            this.screenInteractive = screenInteractive;
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public CallStat m2375clone() {
            CallStat clone = new CallStat(this.callingUid, this.binderClass, this.transactionCode, this.screenInteractive);
            clone.recordedCallCount = this.recordedCallCount;
            clone.callCount = this.callCount;
            clone.cpuTimeMicros = this.cpuTimeMicros;
            clone.maxCpuTimeMicros = this.maxCpuTimeMicros;
            clone.latencyMicros = this.latencyMicros;
            clone.maxLatencyMicros = this.maxLatencyMicros;
            clone.maxRequestSizeBytes = this.maxRequestSizeBytes;
            clone.maxReplySizeBytes = this.maxReplySizeBytes;
            clone.exceptionCount = this.exceptionCount;
            clone.incrementalCallCount = this.incrementalCallCount;
            return clone;
        }

        public String toString() {
            String methodName = new BinderTransactionNameResolver().getMethodName(this.binderClass, this.transactionCode);
            return "CallStat{callingUid=" + this.callingUid + ", transaction=" + this.binderClass.getSimpleName() + '.' + methodName + ", callCount=" + this.callCount + ", incrementalCallCount=" + this.incrementalCallCount + ", recordedCallCount=" + this.recordedCallCount + ", cpuTimeMicros=" + this.cpuTimeMicros + ", latencyMicros=" + this.latencyMicros + '}';
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class CallStatKey {
        public Class<? extends Binder> binderClass;
        public int callingUid;
        private boolean screenInteractive;
        public int transactionCode;

        public boolean equals(Object o10) {
            if (this == o10) {
                return true;
            }
            CallStatKey key = (CallStatKey) o10;
            return this.callingUid == key.callingUid && this.transactionCode == key.transactionCode && this.screenInteractive == key.screenInteractive && this.binderClass.equals(key.binderClass);
        }

        public int hashCode() {
            int result = this.binderClass.hashCode();
            return (((((result * 31) + this.transactionCode) * 31) + this.callingUid) * 31) + (this.screenInteractive ? MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP : MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class UidEntry {
        public long callCount;
        public long cpuTimeMicros;
        public long incrementalCallCount;
        private ArrayMap<CallStatKey, CallStat> mCallStats = new ArrayMap<>();
        private CallStatKey mTempKey = new CallStatKey();
        public boolean recordAllTransactions;
        public long recordedCallCount;
        public int workSourceUid;

        UidEntry(int uid) {
            this.workSourceUid = uid;
        }

        CallStat get(int callingUid, Class<? extends Binder> binderClass, int transactionCode, boolean screenInteractive) {
            this.mTempKey.callingUid = callingUid;
            this.mTempKey.binderClass = binderClass;
            this.mTempKey.transactionCode = transactionCode;
            this.mTempKey.screenInteractive = screenInteractive;
            return this.mCallStats.get(this.mTempKey);
        }

        CallStat getOrCreate(int callingUid, Class<? extends Binder> binderClass, int transactionCode, boolean screenInteractive, boolean maxCallStatsReached) {
            CallStat mapCallStat = get(callingUid, binderClass, transactionCode, screenInteractive);
            if (mapCallStat == null) {
                if (maxCallStatsReached) {
                    CallStat mapCallStat2 = get(-1, BinderCallsStats.OVERFLOW_BINDER, -1, false);
                    if (mapCallStat2 != null) {
                        return mapCallStat2;
                    }
                    callingUid = -1;
                    binderClass = BinderCallsStats.OVERFLOW_BINDER;
                    transactionCode = -1;
                    screenInteractive = false;
                }
                CallStat mapCallStat3 = new CallStat(callingUid, binderClass, transactionCode, screenInteractive);
                CallStatKey key = new CallStatKey();
                key.callingUid = callingUid;
                key.binderClass = binderClass;
                key.transactionCode = transactionCode;
                key.screenInteractive = screenInteractive;
                this.mCallStats.put(key, mapCallStat3);
                return mapCallStat3;
            }
            return mapCallStat;
        }

        public Collection<CallStat> getCallStatsList() {
            return this.mCallStats.values();
        }

        public String toString() {
            return "UidEntry{cpuTimeMicros=" + this.cpuTimeMicros + ", callCount=" + this.callCount + ", mCallStats=" + ((Object) this.mCallStats) + '}';
        }

        public boolean equals(Object o10) {
            if (this == o10) {
                return true;
            }
            UidEntry uidEntry = (UidEntry) o10;
            return this.workSourceUid == uidEntry.workSourceUid;
        }

        public int hashCode() {
            return this.workSourceUid;
        }
    }

    public SparseArray<UidEntry> getUidEntries() {
        return this.mUidEntries;
    }

    public ArrayMap<String, Integer> getExceptionCounts() {
        return this.mExceptionCounts;
    }

    public BinderLatencyObserver getLatencyObserver() {
        return this.mLatencyObserver;
    }

    public static <T> List<T> getHighestValues(List<T> list, ToDoubleFunction<T> toDoubleFunction, double percentile) {
        List<T> sortedList = new ArrayList<>(list);
        sortedList.sort(Comparator.comparingDouble(toDoubleFunction).reversed());
        double total = ShadowDrawableWrapper.COS_45;
        Iterator<T> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            total += toDoubleFunction.applyAsDouble(iterator2.next());
        }
        List<T> result = new ArrayList<>();
        double runningSum = ShadowDrawableWrapper.COS_45;
        for (T item : sortedList) {
            if (runningSum > percentile * total) {
                break;
            }
            result.add(item);
            runningSum += toDoubleFunction.applyAsDouble(item);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int compareByCpuDesc(ExportedCallStat a10, ExportedCallStat b4) {
        return Long.compare(b4.cpuTimeMicros, a10.cpuTimeMicros);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int compareByBinderClassAndCode(ExportedCallStat a10, ExportedCallStat b4) {
        int result = a10.className.compareTo(b4.className);
        if (result != 0) {
            return result;
        }
        return Integer.compare(a10.transactionCode, b4.transactionCode);
    }

    public static void startForBluetooth(Context context) {
        new SettingsObserver(context, new BinderCallsStats(new Injector(), 3));
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class SettingsObserver extends ContentObserver {
        public static final String SETTINGS_COLLECT_LATENCY_DATA_KEY = "collect_latency_data";
        public static final String SETTINGS_DETAILED_TRACKING_KEY = "detailed_tracking";
        public static final String SETTINGS_ENABLED_KEY = "enabled";
        public static final String SETTINGS_IGNORE_BATTERY_STATUS_KEY = "ignore_battery_status";
        public static final String SETTINGS_LATENCY_HISTOGRAM_BUCKET_COUNT_KEY = "latency_histogram_bucket_count";
        public static final String SETTINGS_LATENCY_HISTOGRAM_BUCKET_SCALE_FACTOR_KEY = "latency_histogram_bucket_scale_factor";
        public static final String SETTINGS_LATENCY_HISTOGRAM_FIRST_BUCKET_SIZE_KEY = "latency_histogram_first_bucket_size";
        public static final String SETTINGS_LATENCY_OBSERVER_PUSH_INTERVAL_MINUTES_KEY = "latency_observer_push_interval_minutes";
        public static final String SETTINGS_LATENCY_OBSERVER_SAMPLING_INTERVAL_KEY = "latency_observer_sampling_interval";
        public static final String SETTINGS_LATENCY_OBSERVER_SHARDING_MODULO_KEY = "latency_observer_sharding_modulo";
        public static final String SETTINGS_MAX_CALL_STATS_KEY = "max_call_stats_count";
        public static final String SETTINGS_SAMPLING_INTERVAL_KEY = "sampling_interval";
        public static final String SETTINGS_SHARDING_MODULO_KEY = "sharding_modulo";
        public static final String SETTINGS_TRACK_DIRECT_CALLING_UID_KEY = "track_calling_uid";
        public static final String SETTINGS_TRACK_SCREEN_INTERACTIVE_KEY = "track_screen_state";
        public static final String SETTINGS_UPLOAD_DATA_KEY = "upload_data";
        private final BinderCallsStats mBinderCallsStats;
        private final Context mContext;
        private boolean mEnabled;
        private final KeyValueListParser mParser;
        private final Uri mUri;

        public SettingsObserver(Context context, BinderCallsStats binderCallsStats) {
            super(BackgroundThread.getHandler());
            Uri uriFor = Settings.Global.getUriFor("binder_calls_stats");
            this.mUri = uriFor;
            this.mParser = new KeyValueListParser(',');
            this.mContext = context;
            context.getContentResolver().registerContentObserver(uriFor, false, this);
            this.mBinderCallsStats = binderCallsStats;
            onChange();
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri, int userId) {
            if (this.mUri.equals(uri)) {
                onChange();
            }
        }

        void onChange() {
            try {
                this.mParser.setString(Settings.Global.getString(this.mContext.getContentResolver(), "binder_calls_stats"));
            } catch (IllegalArgumentException e2) {
                Slog.e(BinderCallsStats.TAG, "Bad binder call stats settings", e2);
            }
            this.mBinderCallsStats.setDetailedTracking(false);
            this.mBinderCallsStats.setTrackScreenInteractive(false);
            this.mBinderCallsStats.setTrackDirectCallerUid(false);
            this.mBinderCallsStats.setIgnoreBatteryStatus(this.mParser.getBoolean(SETTINGS_IGNORE_BATTERY_STATUS_KEY, false));
            this.mBinderCallsStats.setCollectLatencyData(this.mParser.getBoolean(SETTINGS_COLLECT_LATENCY_DATA_KEY, true));
            configureLatencyObserver(this.mParser, this.mBinderCallsStats.getLatencyObserver());
            boolean enabled = this.mParser.getBoolean("enabled", true);
            if (this.mEnabled != enabled) {
                if (enabled) {
                    Binder.setObserver(this.mBinderCallsStats);
                } else {
                    Binder.setObserver(null);
                }
                this.mEnabled = enabled;
                this.mBinderCallsStats.reset();
                this.mBinderCallsStats.setAddDebugEntries(enabled);
                this.mBinderCallsStats.getLatencyObserver().reset();
            }
        }

        public static void configureLatencyObserver(KeyValueListParser mParser, BinderLatencyObserver binderLatencyObserver) {
            binderLatencyObserver.setSamplingInterval(mParser.getInt(SETTINGS_LATENCY_OBSERVER_SAMPLING_INTERVAL_KEY, 10));
            binderLatencyObserver.setShardingModulo(mParser.getInt(SETTINGS_LATENCY_OBSERVER_SHARDING_MODULO_KEY, 1));
            binderLatencyObserver.setHistogramBucketsParams(mParser.getInt(SETTINGS_LATENCY_HISTOGRAM_BUCKET_COUNT_KEY, 100), mParser.getInt(SETTINGS_LATENCY_HISTOGRAM_FIRST_BUCKET_SIZE_KEY, 5), mParser.getFloat(SETTINGS_LATENCY_HISTOGRAM_BUCKET_SCALE_FACTOR_KEY, 1.125f));
            binderLatencyObserver.setPushInterval(mParser.getInt(SETTINGS_LATENCY_OBSERVER_PUSH_INTERVAL_MINUTES_KEY, 360));
        }
    }
}
