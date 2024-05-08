package com.android.internal.os;

import android.os.BatteryStats;
import android.os.Process;
import android.os.StrictMode;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import android.view.ViewRootImplProto;
import android.view.WindowLayoutParamsProto;
import com.android.internal.logging.nano.MetricsProto;
import com.android.internal.util.FastPrintWriter;
import com.huawei.flexiblelayout.parser.cardmanager.d;
import com.huawei.openalliance.ad.constant.u;
import java.io.File;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import system.ext.loader.core.ExtLoader;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ProcessCpuTracker {
    private static final boolean DEBUG = false;
    static final int PROCESS_FULL_STAT_MAJOR_FAULTS = 2;
    static final int PROCESS_FULL_STAT_MINOR_FAULTS = 1;
    static final int PROCESS_FULL_STAT_STIME = 4;
    static final int PROCESS_FULL_STAT_UTIME = 3;
    static final int PROCESS_FULL_STAT_VSIZE = 5;
    static final int PROCESS_SCHEDSTAT_CPU_DELAY_TIME = 1;
    static final int PROCESS_SCHEDSTAT_CPU_TIME = 0;
    static final int PROCESS_STAT_MAJOR_FAULTS = 1;
    static final int PROCESS_STAT_MINOR_FAULTS = 0;
    static final int PROCESS_STAT_STIME = 3;
    static final int PROCESS_STAT_UTIME = 2;
    private static final String TAG = "ProcessCpuTracker";
    private static final boolean localLOGV = false;
    private long mBaseIdleTime;
    private long mBaseIoWaitTime;
    private long mBaseIrqTime;
    private long mBaseSoftIrqTime;
    private long mBaseSystemTime;
    private long mBaseUserTime;
    private int[] mCurPids;
    private int[] mCurThreadPids;
    private long mCurrentSampleRealTime;
    private long mCurrentSampleTime;
    private long mCurrentSampleWallTime;
    private boolean mFirst;
    private final boolean mIncludeThreads;
    private final long mJiffyMillis;
    private long mLastSampleRealTime;
    private long mLastSampleTime;
    private long mLastSampleWallTime;
    private final ArrayList<Stats> mProcStats;
    private int mRelIdleTime;
    private int mRelIoWaitTime;
    private int mRelIrqTime;
    private int mRelSoftIrqTime;
    private boolean mRelStatsAreGood;
    private int mRelSystemTime;
    private int mRelUserTime;
    private final ArrayList<Stats> mWorkingProcs;
    private boolean mWorkingProcsSorted;
    private static final int[] PROCESS_STATS_FORMAT = {32, MetricsProto.MetricsEvent.DIALOG_WIFI_SKIP, 32, 32, 32, 32, 32, 32, 32, 8224, 32, 8224, 32, 8224, 8224};
    private static final int[] PROCESS_FULL_STATS_FORMAT = {32, 4640, 32, 32, 32, 32, 32, 32, 32, 8224, 32, 8224, 32, 8224, 8224, 32, 32, 32, 32, 32, 32, 32, 8224};
    private static final int[] PROCESS_SCHEDSTATS_FORMAT = {8224, 8224};
    private static final int[] SYSTEM_CPU_FORMAT = {288, 8224, 8224, 8224, 8224, 8224, 8224, 8224};
    private static final int[] LOAD_AVERAGE_FORMAT = {16416, 16416, 16416};
    private static final Comparator<Stats> sLoadComparator = new Comparator<Stats>() { // from class: com.android.internal.os.ProcessCpuTracker.1
        @Override // java.util.Comparator
        public final int compare(Stats sta, Stats stb) {
            int ta2 = sta.rel_utime + sta.rel_stime;
            int tb2 = stb.rel_utime + stb.rel_stime;
            if (ta2 != tb2) {
                return ta2 > tb2 ? -1 : 1;
            }
            if (sta.added != stb.added) {
                return sta.added ? -1 : 1;
            }
            if (sta.removed != stb.removed) {
                return sta.added ? -1 : 1;
            }
            return 0;
        }
    };
    private final long[] mProcessStatsData = new long[4];
    private final String[] mProcessFullStatsStringData = new String[6];
    private final long[] mProcessFullStatsData = new long[6];
    private final long[] mSystemCpuData = new long[7];
    private final float[] mLoadAverageData = new float[3];
    public IProcessCpuTrackerExt mProcessCpuTrackerExt = (IProcessCpuTrackerExt) ExtLoader.type(IProcessCpuTrackerExt.class).base(this).create();
    private float mLoad1 = 0.0f;
    private float mLoad5 = 0.0f;
    private float mLoad15 = 0.0f;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface FilterStats {
        boolean needed(Stats stats);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class Stats {
        public boolean active;
        public boolean added;
        public String baseName;
        public long base_majfaults;
        public long base_minfaults;
        public long base_stime;
        public long base_uptime;
        public long base_utime;
        public BatteryStats.Uid.Proc batteryStats;
        final String cmdlineFile;
        public int cpuThousandths;
        public boolean interesting;
        public String name;
        public int nameWidth;
        public final int pid;
        public int rel_majfaults;
        public int rel_minfaults;
        public int rel_stime;
        public long rel_uptime;
        public int rel_utime;
        public boolean removed;
        final String statFile;
        final ArrayList<Stats> threadStats;
        final String threadsDir;
        public final int uid;
        public long vsize;
        public boolean working;
        final ArrayList<Stats> workingThreads;

        Stats(int _pid, int parentPid, boolean includeThreads) {
            this.pid = _pid;
            if (parentPid < 0) {
                File procDir = new File("/proc", Integer.toString(_pid));
                this.uid = getUid(procDir.toString());
                this.statFile = new File(procDir, "stat").toString();
                this.cmdlineFile = new File(procDir, "cmdline").toString();
                this.threadsDir = new File(procDir, d.a.f28343b).toString();
                if (includeThreads) {
                    this.threadStats = new ArrayList<>();
                    this.workingThreads = new ArrayList<>();
                    return;
                } else {
                    this.threadStats = null;
                    this.workingThreads = null;
                    return;
                }
            }
            File taskDir = new File(new File(new File("/proc", Integer.toString(parentPid)), d.a.f28343b), Integer.toString(_pid));
            this.uid = getUid(taskDir.toString());
            this.statFile = new File(taskDir, "stat").toString();
            this.cmdlineFile = null;
            this.threadsDir = null;
            this.threadStats = null;
            this.workingThreads = null;
        }

        private static int getUid(String path) {
            try {
                return Os.stat(path).st_uid;
            } catch (ErrnoException e2) {
                Slog.w(ProcessCpuTracker.TAG, "Failed to stat(" + path + "): " + ((Object) e2));
                return -1;
            }
        }
    }

    public ProcessCpuTracker(boolean includeThreads) {
        ArrayList<Stats> arrayList = new ArrayList<>();
        this.mProcStats = arrayList;
        this.mWorkingProcs = new ArrayList<>();
        this.mFirst = true;
        this.mIncludeThreads = includeThreads;
        long jiffyHz = Os.sysconf(OsConstants._SC_CLK_TCK);
        this.mJiffyMillis = 1000 / jiffyHz;
        IProcessCpuTrackerExt iProcessCpuTrackerExt = this.mProcessCpuTrackerExt;
        if (iProcessCpuTrackerExt != null) {
            iProcessCpuTrackerExt.init(arrayList);
        }
    }

    public void onLoadChanged(float load1, float load5, float load15) {
    }

    public int onMeasureProcessName(String name) {
        return 0;
    }

    public void init() {
        this.mFirst = true;
        update();
    }

    public void update() {
        long nowUptime;
        long nowRealtime;
        long nowWallTime;
        char c4;
        long nowUptime2 = SystemClock.uptimeMillis();
        long nowRealtime2 = SystemClock.elapsedRealtime();
        long nowWallTime2 = System.currentTimeMillis();
        long[] sysCpu = this.mSystemCpuData;
        if (!Process.readProcFile("/proc/stat", SYSTEM_CPU_FORMAT, null, sysCpu, null)) {
            nowUptime = nowUptime2;
            nowRealtime = nowRealtime2;
            nowWallTime = nowWallTime2;
            c4 = 1;
        } else {
            long j10 = sysCpu[0] + sysCpu[1];
            long j11 = this.mJiffyMillis;
            long usertime = j10 * j11;
            long systemtime = sysCpu[2] * j11;
            nowWallTime = nowWallTime2;
            long nowWallTime3 = sysCpu[3] * j11;
            nowRealtime = nowRealtime2;
            long nowRealtime3 = sysCpu[4] * j11;
            nowUptime = nowUptime2;
            long nowUptime3 = sysCpu[5] * j11;
            long softirqtime = j11 * sysCpu[6];
            this.mRelUserTime = (int) (usertime - this.mBaseUserTime);
            this.mRelSystemTime = (int) (systemtime - this.mBaseSystemTime);
            this.mRelIoWaitTime = (int) (nowRealtime3 - this.mBaseIoWaitTime);
            this.mRelIrqTime = (int) (nowUptime3 - this.mBaseIrqTime);
            this.mRelSoftIrqTime = (int) (softirqtime - this.mBaseSoftIrqTime);
            this.mRelIdleTime = (int) (nowWallTime3 - this.mBaseIdleTime);
            c4 = 1;
            this.mRelStatsAreGood = true;
            this.mBaseUserTime = usertime;
            this.mBaseSystemTime = systemtime;
            this.mBaseIoWaitTime = nowRealtime3;
            this.mBaseIrqTime = nowUptime3;
            this.mBaseSoftIrqTime = softirqtime;
            this.mBaseIdleTime = nowWallTime3;
        }
        this.mLastSampleTime = this.mCurrentSampleTime;
        this.mCurrentSampleTime = nowUptime;
        this.mLastSampleRealTime = this.mCurrentSampleRealTime;
        this.mCurrentSampleRealTime = nowRealtime;
        long j12 = this.mCurrentSampleWallTime;
        this.mLastSampleWallTime = j12;
        this.mCurrentSampleWallTime = nowWallTime;
        IProcessCpuTrackerExt iProcessCpuTrackerExt = this.mProcessCpuTrackerExt;
        if (iProcessCpuTrackerExt != null) {
            iProcessCpuTrackerExt.updateLastSampleWallTime(j12);
            this.mProcessCpuTrackerExt.updateCurrentSampleWallTime(this.mCurrentSampleWallTime);
        }
        StrictMode.ThreadPolicy savedPolicy = StrictMode.allowThreadDiskReads();
        try {
            this.mCurPids = collectStats("/proc", -1, this.mFirst, this.mCurPids, this.mProcStats);
            IProcessCpuTrackerExt iProcessCpuTrackerExt2 = this.mProcessCpuTrackerExt;
            if (iProcessCpuTrackerExt2 != null) {
                iProcessCpuTrackerExt2.updateProcStats(this.mProcStats);
            }
            StrictMode.setThreadPolicy(savedPolicy);
            float[] loadAverages = this.mLoadAverageData;
            if (Process.readProcFile("/proc/loadavg", LOAD_AVERAGE_FORMAT, null, null, loadAverages)) {
                float load1 = loadAverages[0];
                float load5 = loadAverages[c4];
                float load15 = loadAverages[2];
                if (load1 != this.mLoad1 || load5 != this.mLoad5 || load15 != this.mLoad15) {
                    this.mLoad1 = load1;
                    this.mLoad5 = load5;
                    this.mLoad15 = load15;
                    IProcessCpuTrackerExt iProcessCpuTrackerExt3 = this.mProcessCpuTrackerExt;
                    if (iProcessCpuTrackerExt3 != null) {
                        iProcessCpuTrackerExt3.updateLoad(load1, load5, load15);
                    }
                    onLoadChanged(load1, load5, load15);
                }
            }
            this.mWorkingProcsSorted = false;
            this.mFirst = false;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(savedPolicy);
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [java.lang.String[], float[]] */
    /* JADX WARN: Type inference failed for: r15v5 */
    private int[] collectStats(String statsFile, int parentPid, boolean first, int[] curPids, ArrayList<Stats> allProcs) {
        int[] pids;
        int[] pids2;
        int NP;
        int pid;
        int i10;
        int i11;
        int i12;
        int i13;
        int NS;
        boolean z10;
        long stime;
        long majfaults;
        long uptime;
        Stats st;
        int i14 = parentPid;
        ArrayList<Stats> arrayList = allProcs;
        int[] pids3 = Process.getPids(statsFile, curPids);
        boolean z11 = false;
        int NP2 = pids3 == null ? 0 : pids3.length;
        IProcessCpuTrackerExt iProcessCpuTrackerExt = this.mProcessCpuTrackerExt;
        if (iProcessCpuTrackerExt != null) {
            iProcessCpuTrackerExt.initMaxCpuInfo();
        }
        ?? r15 = 0;
        try {
            int NS2 = allProcs.size();
            int curStatsIndex = 0;
            int NS3 = NS2;
            int i15 = 0;
            while (true) {
                if (i15 >= NP2) {
                    pids = pids3;
                    break;
                }
                int pid2 = pids3[i15];
                if (pid2 < 0) {
                    pids = pids3;
                    break;
                }
                Stats st2 = curStatsIndex < NS3 ? arrayList.get(curStatsIndex) : r15;
                if (st2 == null || st2.pid != pid2) {
                    Stats st3 = st2;
                    int i16 = i15;
                    int NS4 = NS3;
                    pids2 = pids3;
                    NP = NP2;
                    if (st3 != null) {
                        pid = pid2;
                        if (st3.pid > pid) {
                            arrayList = allProcs;
                        } else {
                            st3.rel_utime = 0;
                            st3.rel_stime = 0;
                            st3.rel_minfaults = 0;
                            st3.rel_majfaults = 0;
                            st3.removed = true;
                            st3.working = true;
                            arrayList = allProcs;
                            arrayList.remove(curStatsIndex);
                            NS3 = NS4 - 1;
                            i12 = i16 - 1;
                            i10 = parentPid;
                            i11 = 1;
                        }
                    } else {
                        arrayList = allProcs;
                        pid = pid2;
                    }
                    i10 = parentPid;
                    Stats st4 = new Stats(pid, i10, this.mIncludeThreads);
                    arrayList.add(curStatsIndex, st4);
                    int curStatsIndex2 = curStatsIndex + 1;
                    int NS5 = NS4 + 1;
                    String[] procStatsString = this.mProcessFullStatsStringData;
                    long[] procStats = this.mProcessFullStatsData;
                    st4.base_uptime = SystemClock.uptimeMillis();
                    String path = st4.statFile.toString();
                    if (Process.readProcFile(path, PROCESS_FULL_STATS_FORMAT, procStatsString, procStats, null)) {
                        st4.vsize = procStats[5];
                        st4.interesting = true;
                        st4.baseName = procStatsString[0];
                        st4.base_minfaults = procStats[1];
                        st4.base_majfaults = procStats[2];
                        st4.base_utime = procStats[3] * this.mJiffyMillis;
                        st4.base_stime = procStats[4] * this.mJiffyMillis;
                        int denom = this.mRelUserTime + this.mRelSystemTime + this.mRelIrqTime + this.mRelIdleTime;
                        IProcessCpuTrackerExt iProcessCpuTrackerExt2 = this.mProcessCpuTrackerExt;
                        if (iProcessCpuTrackerExt2 != null) {
                            iProcessCpuTrackerExt2.updateMaxCpuInfo(st4, denom);
                        }
                    } else {
                        Slog.w(TAG, "Skipping unknown process pid " + pid);
                        st4.baseName = "<unknown>";
                        st4.base_stime = 0L;
                        st4.base_utime = 0L;
                        st4.base_majfaults = 0L;
                        st4.base_minfaults = 0L;
                    }
                    if (i10 < 0) {
                        getName(st4, st4.cmdlineFile);
                        if (st4.threadStats != null) {
                            this.mCurThreadPids = collectStats(st4.threadsDir, pid, true, this.mCurThreadPids, st4.threadStats);
                        }
                    } else if (st4.interesting) {
                        st4.name = st4.baseName;
                        st4.nameWidth = onMeasureProcessName(st4.name);
                    }
                    st4.rel_utime = 0;
                    st4.rel_stime = 0;
                    st4.rel_minfaults = 0;
                    st4.rel_majfaults = 0;
                    i11 = 1;
                    st4.added = true;
                    if (!first && st4.interesting) {
                        st4.working = true;
                    }
                    curStatsIndex = curStatsIndex2;
                    NS3 = NS5;
                    i12 = i16;
                } else {
                    st2.added = z11;
                    st2.working = z11;
                    int curStatsIndex3 = curStatsIndex + 1;
                    if (st2.interesting) {
                        i13 = i15;
                        long uptime2 = SystemClock.uptimeMillis();
                        long[] procStats2 = this.mProcessStatsData;
                        if (!Process.readProcFile(st2.statFile.toString(), PROCESS_STATS_FORMAT, r15, procStats2, r15)) {
                            NS = NS3;
                            pids2 = pids3;
                            NP = NP2;
                        } else {
                            long uptime3 = procStats2[0];
                            long minfaults = procStats2[1];
                            long j10 = procStats2[2];
                            long j11 = this.mJiffyMillis;
                            long utime = j10 * j11;
                            long stime2 = procStats2[3] * j11;
                            if (utime == st2.base_utime && stime2 == st2.base_stime) {
                                st2.rel_utime = 0;
                                st2.rel_stime = 0;
                                st2.rel_minfaults = 0;
                                st2.rel_majfaults = 0;
                                if (!st2.active) {
                                    NS = NS3;
                                    pids2 = pids3;
                                    NP = NP2;
                                } else {
                                    st2.active = false;
                                    NS = NS3;
                                    pids2 = pids3;
                                    NP = NP2;
                                }
                            } else {
                                if (st2.active) {
                                    z10 = true;
                                } else {
                                    z10 = true;
                                    st2.active = true;
                                }
                                if (i14 < 0) {
                                    getName(st2, st2.cmdlineFile);
                                    if (st2.threadStats != null) {
                                        pids2 = pids3;
                                        NP = NP2;
                                        uptime = uptime2;
                                        stime = stime2;
                                        majfaults = minfaults;
                                        st = st2;
                                        NS = NS3;
                                        this.mCurThreadPids = collectStats(st2.threadsDir, pid2, false, this.mCurThreadPids, st2.threadStats);
                                    } else {
                                        stime = stime2;
                                        NS = NS3;
                                        NP = NP2;
                                        majfaults = minfaults;
                                        pids2 = pids3;
                                        uptime = uptime2;
                                        st = st2;
                                    }
                                } else {
                                    stime = stime2;
                                    NS = NS3;
                                    NP = NP2;
                                    majfaults = minfaults;
                                    pids2 = pids3;
                                    uptime = uptime2;
                                    st = st2;
                                }
                                st.rel_uptime = uptime - st.base_uptime;
                                st.base_uptime = uptime;
                                st.rel_utime = (int) (utime - st.base_utime);
                                st.rel_stime = (int) (stime - st.base_stime);
                                st.base_utime = utime;
                                st.base_stime = stime;
                                st.rel_minfaults = (int) (uptime3 - st.base_minfaults);
                                long majfaults2 = majfaults;
                                st.rel_majfaults = (int) (majfaults2 - st.base_majfaults);
                                st.base_minfaults = uptime3;
                                st.base_majfaults = majfaults2;
                                st.working = true;
                                int denom2 = this.mRelUserTime + this.mRelSystemTime + this.mRelIrqTime + this.mRelIdleTime;
                                IProcessCpuTrackerExt iProcessCpuTrackerExt3 = this.mProcessCpuTrackerExt;
                                if (iProcessCpuTrackerExt3 != null) {
                                    iProcessCpuTrackerExt3.updateMaxCpuInfo(st, denom2);
                                }
                            }
                        }
                    } else {
                        i13 = i15;
                        NS = NS3;
                        pids2 = pids3;
                        NP = NP2;
                    }
                    i10 = parentPid;
                    arrayList = allProcs;
                    NS3 = NS;
                    curStatsIndex = curStatsIndex3;
                    i12 = i13;
                    i11 = 1;
                }
                i15 = i12 + i11;
                i14 = i10;
                pids3 = pids2;
                NP2 = NP;
                z11 = false;
                r15 = 0;
            }
            while (curStatsIndex < NS3) {
                Stats st5 = arrayList.get(curStatsIndex);
                st5.rel_utime = 0;
                st5.rel_stime = 0;
                st5.rel_minfaults = 0;
                st5.rel_majfaults = 0;
                st5.removed = true;
                st5.working = true;
                arrayList.remove(curStatsIndex);
                NS3--;
            }
            return pids;
        } catch (NullPointerException e2) {
            Slog.i(TAG, "collectStats(): allProcs is null!");
            return null;
        }
    }

    public long getCpuTimeForPid(int pid) {
        String statFile = "/proc/" + pid + "/stat";
        long[] statsData = new long[4];
        if (Process.readProcFile(statFile, PROCESS_STATS_FORMAT, null, statsData, null)) {
            long time = statsData[2] + statsData[3];
            return this.mJiffyMillis * time;
        }
        return 0L;
    }

    public long getCpuDelayTimeForPid(int pid) {
        String statFile = "/proc/" + pid + "/schedstat";
        long[] statsData = new long[4];
        if (Process.readProcFile(statFile, PROCESS_SCHEDSTATS_FORMAT, null, statsData, null)) {
            return statsData[1] / 1000000;
        }
        return 0L;
    }

    public final int getLastUserTime() {
        return this.mRelUserTime;
    }

    public final int getLastSystemTime() {
        return this.mRelSystemTime;
    }

    public final int getLastIoWaitTime() {
        return this.mRelIoWaitTime;
    }

    public final int getLastIrqTime() {
        return this.mRelIrqTime;
    }

    public final int getLastSoftIrqTime() {
        return this.mRelSoftIrqTime;
    }

    public final int getLastIdleTime() {
        return this.mRelIdleTime;
    }

    public final boolean hasGoodLastStats() {
        return this.mRelStatsAreGood;
    }

    public final float getTotalCpuPercent() {
        int i10 = this.mRelUserTime;
        int i11 = this.mRelSystemTime;
        int denom = i10 + i11 + this.mRelIrqTime + this.mRelIdleTime;
        if (denom <= 0) {
            return 0.0f;
        }
        return (((i10 + i11) + r3) * 100.0f) / denom;
    }

    final void buildWorkingProcs() {
        if (!this.mWorkingProcsSorted) {
            this.mWorkingProcs.clear();
            int N = this.mProcStats.size();
            for (int i10 = 0; i10 < N; i10++) {
                Stats stats = this.mProcStats.get(i10);
                if (stats.working) {
                    this.mWorkingProcs.add(stats);
                    if (stats.threadStats != null && stats.threadStats.size() > 1) {
                        stats.workingThreads.clear();
                        int M = stats.threadStats.size();
                        for (int j10 = 0; j10 < M; j10++) {
                            Stats tstats = stats.threadStats.get(j10);
                            if (tstats.working) {
                                stats.workingThreads.add(tstats);
                            }
                        }
                        Collections.sort(stats.workingThreads, sLoadComparator);
                    }
                }
            }
            Collections.sort(this.mWorkingProcs, sLoadComparator);
            this.mWorkingProcsSorted = true;
        }
    }

    public final int countStats() {
        return this.mProcStats.size();
    }

    public final Stats getStats(int index) {
        return this.mProcStats.get(index);
    }

    public final List<Stats> getStats(FilterStats filter) {
        ArrayList<Stats> statses = new ArrayList<>(this.mProcStats.size());
        int N = this.mProcStats.size();
        for (int p10 = 0; p10 < N; p10++) {
            Stats stats = this.mProcStats.get(p10);
            if (filter.needed(stats)) {
                statses.add(stats);
            }
        }
        return statses;
    }

    public final int countWorkingStats() {
        buildWorkingProcs();
        return this.mWorkingProcs.size();
    }

    public final Stats getWorkingStats(int index) {
        return this.mWorkingProcs.get(index);
    }

    public final void dumpProto(FileDescriptor fd2) {
        long now = SystemClock.uptimeMillis();
        ProtoOutputStream proto = new ProtoOutputStream(fd2);
        long currentLoadToken = proto.start(1146756268033L);
        proto.write(1108101562369L, this.mLoad1);
        proto.write(1108101562370L, this.mLoad5);
        proto.write(1108101562371L, this.mLoad15);
        proto.end(currentLoadToken);
        buildWorkingProcs();
        proto.write(1112396529666L, now);
        proto.write(1112396529667L, this.mLastSampleTime);
        proto.write(1112396529668L, this.mCurrentSampleTime);
        proto.write(1112396529669L, this.mLastSampleRealTime);
        proto.write(1112396529670L, this.mCurrentSampleRealTime);
        proto.write(1112396529671L, this.mLastSampleWallTime);
        proto.write(1112396529672L, this.mCurrentSampleWallTime);
        proto.write(WindowLayoutParamsProto.SOFT_INPUT_MODE, this.mRelUserTime);
        proto.write(1120986464266L, this.mRelSystemTime);
        proto.write(WindowLayoutParamsProto.WINDOW_ANIMATIONS, this.mRelIoWaitTime);
        proto.write(1120986464268L, this.mRelIrqTime);
        proto.write(1120986464269L, this.mRelSoftIrqTime);
        proto.write(ViewRootImplProto.SCROLL_Y, this.mRelIdleTime);
        int totalTime = this.mRelUserTime + this.mRelSystemTime + this.mRelIoWaitTime + this.mRelIrqTime + this.mRelSoftIrqTime + this.mRelIdleTime;
        proto.write(ViewRootImplProto.CUR_SCROLL_Y, totalTime);
        Iterator<Stats> iterator2 = this.mWorkingProcs.iterator2();
        while (iterator2.hasNext()) {
            Stats st = iterator2.next();
            dumpProcessCpuProto(proto, st, null);
            if (!st.removed && st.workingThreads != null) {
                Iterator<Stats> iterator22 = st.workingThreads.iterator2();
                while (iterator22.hasNext()) {
                    Stats tst = iterator22.next();
                    dumpProcessCpuProto(proto, tst, st);
                }
            }
        }
        proto.flush();
    }

    private static void dumpProcessCpuProto(ProtoOutputStream proto, Stats st, Stats proc) {
        long statToken = proto.start(2246267895824L);
        proto.write(1120986464257L, st.uid);
        proto.write(1120986464258L, st.pid);
        proto.write(1138166333443L, st.name);
        proto.write(1133871366148L, st.added);
        proto.write(1133871366149L, st.removed);
        proto.write(1120986464262L, st.rel_uptime);
        proto.write(1120986464263L, st.rel_utime);
        proto.write(WindowLayoutParamsProto.GRAVITY, st.rel_stime);
        proto.write(WindowLayoutParamsProto.SOFT_INPUT_MODE, st.rel_minfaults);
        proto.write(1120986464266L, st.rel_majfaults);
        if (proc != null) {
            proto.write(WindowLayoutParamsProto.WINDOW_ANIMATIONS, proc.pid);
        }
        proto.end(statToken);
    }

    public final String printCurrentLoad() {
        StringWriter sw = new StringWriter();
        FastPrintWriter fastPrintWriter = new FastPrintWriter(sw, false, 128);
        fastPrintWriter.print("Load: ");
        fastPrintWriter.print(this.mLoad1);
        fastPrintWriter.print(" / ");
        fastPrintWriter.print(this.mLoad5);
        fastPrintWriter.print(" / ");
        fastPrintWriter.println(this.mLoad15);
        fastPrintWriter.flush();
        return sw.toString();
    }

    public final String printCurrentState(long now) {
        return printCurrentState(now, Integer.MAX_VALUE);
    }

    public final String printCurrentState(long now, int maxProcessesToDump) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        buildWorkingProcs();
        StringWriter sw = new StringWriter();
        PrintWriter pw = new FastPrintWriter(sw, false, 1024);
        pw.print("CPU usage from ");
        long j10 = this.mLastSampleTime;
        if (now > j10) {
            pw.print(now - j10);
            pw.print("ms to ");
            pw.print(now - this.mCurrentSampleTime);
            pw.print("ms ago");
        } else {
            pw.print(j10 - now);
            pw.print("ms to ");
            pw.print(this.mCurrentSampleTime - now);
            pw.print("ms later");
        }
        pw.print(" (");
        pw.print(sdf.format(new Date(this.mLastSampleWallTime)));
        pw.print(" to ");
        pw.print(sdf.format(new Date(this.mCurrentSampleWallTime)));
        pw.print(")");
        long sampleTime = this.mCurrentSampleTime - this.mLastSampleTime;
        long sampleRealTime = this.mCurrentSampleRealTime - this.mLastSampleRealTime;
        long percAwake = sampleRealTime > 0 ? (sampleTime * 100) / sampleRealTime : 0L;
        if (percAwake != 100) {
            pw.print(" with ");
            pw.print(percAwake);
            pw.print("% awake");
        }
        pw.println(u.bD);
        int totalTime = this.mRelUserTime + this.mRelSystemTime + this.mRelIoWaitTime + this.mRelIrqTime + this.mRelSoftIrqTime + this.mRelIdleTime;
        int dumpedProcessCount = Math.min(maxProcessesToDump, this.mWorkingProcs.size());
        int i10 = 0;
        while (i10 < dumpedProcessCount) {
            Stats st = this.mWorkingProcs.get(i10);
            long percAwake2 = percAwake;
            int i11 = i10;
            int dumpedProcessCount2 = dumpedProcessCount;
            PrintWriter pw2 = pw;
            printProcessCPU(pw, st.added ? " +" : st.removed ? " -" : "  ", st.pid, st.name, (int) st.rel_uptime, st.rel_utime, st.rel_stime, 0, 0, 0, st.rel_minfaults, st.rel_majfaults);
            Stats st2 = st;
            if (!st2.removed && st2.workingThreads != null) {
                int M = st2.workingThreads.size();
                int j11 = 0;
                while (j11 < M) {
                    Stats tst = st2.workingThreads.get(j11);
                    printProcessCPU(pw2, tst.added ? "   +" : tst.removed ? "   -" : "    ", tst.pid, tst.name, (int) st2.rel_uptime, tst.rel_utime, tst.rel_stime, 0, 0, 0, 0, 0);
                    j11++;
                    M = M;
                    st2 = st2;
                }
            }
            i10 = i11 + 1;
            percAwake = percAwake2;
            pw = pw2;
            dumpedProcessCount = dumpedProcessCount2;
        }
        PrintWriter pw3 = pw;
        printProcessCPU(pw3, "", -1, "TOTAL", totalTime, this.mRelUserTime, this.mRelSystemTime, this.mRelIoWaitTime, this.mRelIrqTime, this.mRelSoftIrqTime, 0, 0);
        pw3.flush();
        return sw.toString();
    }

    private void printRatio(PrintWriter pw, long numerator, long denominator) {
        long thousands = (1000 * numerator) / denominator;
        long hundreds = thousands / 10;
        pw.print(hundreds);
        if (hundreds < 10) {
            long remainder = thousands - (10 * hundreds);
            if (remainder != 0) {
                pw.print('.');
                pw.print(remainder);
            }
        }
    }

    private void printProcessCPU(PrintWriter pw, String prefix, int pid, String label, int totalTime, int user, int system, int iowait, int irq, int softIrq, int minFaults, int majFaults) {
        String str;
        pw.print(prefix);
        int totalTime2 = totalTime == 0 ? 1 : totalTime;
        printRatio(pw, user + system + iowait + irq + softIrq, totalTime2);
        pw.print("% ");
        if (pid >= 0) {
            pw.print(pid);
            pw.print("/");
        }
        pw.print(label);
        pw.print(": ");
        printRatio(pw, user, totalTime2);
        pw.print("% user + ");
        printRatio(pw, system, totalTime2);
        pw.print("% kernel");
        if (iowait <= 0) {
            str = " + ";
        } else {
            pw.print(" + ");
            str = " + ";
            printRatio(pw, iowait, totalTime2);
            pw.print("% iowait");
        }
        if (irq > 0) {
            pw.print(str);
            printRatio(pw, irq, totalTime2);
            pw.print("% irq");
        }
        if (softIrq > 0) {
            pw.print(str);
            printRatio(pw, softIrq, totalTime2);
            pw.print("% softirq");
        }
        if (minFaults > 0 || majFaults > 0) {
            pw.print(" / faults:");
            if (minFaults > 0) {
                pw.print(" ");
                pw.print(minFaults);
                pw.print(" minor");
            }
            if (majFaults > 0) {
                pw.print(" ");
                pw.print(majFaults);
                pw.print(" major");
            }
        }
        pw.println();
    }

    private void getName(Stats st, String cmdlineFile) {
        int i10;
        String newName = st.name;
        if (st.name == null || st.name.equals("app_process") || st.name.equals("<pre-initialized>") || st.name.equals("usap32") || st.name.equals("usap64")) {
            String cmdName = ProcStatsUtil.readTerminatedProcFile(cmdlineFile, (byte) 0);
            if (cmdName != null && cmdName.length() > 1 && (i10 = (newName = cmdName).lastIndexOf("/")) > 0 && i10 < newName.length() - 1) {
                newName = newName.substring(i10 + 1);
            }
            if (newName == null) {
                newName = st.baseName;
            }
        }
        if (st.name == null || !newName.equals(st.name)) {
            st.name = newName;
            st.nameWidth = onMeasureProcessName(st.name);
        }
    }
}
