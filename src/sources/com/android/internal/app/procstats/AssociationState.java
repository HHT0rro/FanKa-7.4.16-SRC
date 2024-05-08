package com.android.internal.app.procstats;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.UserHandle;
import android.util.ArrayMap;
import android.util.Pair;
import android.util.Slog;
import android.util.TimeUtils;
import android.util.proto.ProtoOutputStream;
import android.view.inputmethod.InputMethodManagerProto;
import com.alipay.sdk.util.i;
import com.android.internal.accessibility.common.ShortcutConstants;
import com.android.internal.app.procstats.ProcessStats;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class AssociationState {
    private static final boolean DEBUG = false;
    private static final String TAG = "ProcessStats";
    private static final boolean VALIDATE_TIMES = false;
    private final String mName;
    private final ProcessStats.PackageState mPackageState;
    private ProcessState mProc;
    private final String mProcessName;
    private final ProcessStats mProcessStats;
    final ArrayMap<SourceKey, SourceState> mSources = new ArrayMap<>();
    private int mTotalActiveCount;
    private long mTotalActiveDuration;
    private int mTotalActiveNesting;
    private long mTotalActiveStartUptime;
    private int mTotalCount;
    private long mTotalDuration;
    private int mTotalNesting;
    private long mTotalStartUptime;
    private static final SourceKey sTmpSourceKey = new SourceKey(0, (String) null, (String) null);
    static final Comparator<Pair<SourceKey, SourceDumpContainer>> ASSOCIATION_COMPARATOR = new Comparator() { // from class: com.android.internal.app.procstats.AssociationState$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return AssociationState.lambda$static$0((Pair) obj, (Pair) obj2);
        }
    };

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class SourceState implements Parcelable {
        int mActiveCount;
        long mActiveDuration;
        DurationsTable mActiveDurations;
        int mActiveNesting;
        long mActiveStartUptime;
        private final AssociationState mAssociationState;
        private SourceState mCommonSourceState;
        int mCount;
        long mDuration;
        boolean mInTrackingList;
        final SourceKey mKey;
        int mNesting;
        private final ProcessStats mProcessStats;
        long mStartUptime;
        private final ProcessState mTargetProcess;
        long mTrackingUptime;
        int mProcStateSeq = -1;
        int mProcState = -1;
        int mActiveProcState = -1;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SourceState(ProcessStats processStats, AssociationState associationState, ProcessState targetProcess, SourceKey key) {
            this.mProcessStats = processStats;
            this.mAssociationState = associationState;
            this.mTargetProcess = targetProcess;
            this.mKey = key;
        }

        public AssociationState getAssociationState() {
            return this.mAssociationState;
        }

        public String getProcessName() {
            return this.mKey.mProcess;
        }

        public int getUid() {
            return this.mKey.mUid;
        }

        private SourceState getCommonSourceState(boolean createIfNeeded) {
            if (this.mCommonSourceState == null && createIfNeeded) {
                this.mCommonSourceState = this.mTargetProcess.getOrCreateSourceState(this.mKey);
            }
            return this.mCommonSourceState;
        }

        public void trackProcState(int procState, int seq, long now) {
            SourceState commonSource;
            int procState2 = ProcessState.PROCESS_STATE_TO_STATE[procState];
            if (seq != this.mProcStateSeq) {
                this.mProcStateSeq = seq;
                this.mProcState = procState2;
            } else if (procState2 < this.mProcState) {
                this.mProcState = procState2;
            }
            if (procState2 < 12 && !this.mInTrackingList) {
                this.mInTrackingList = true;
                this.mTrackingUptime = now;
                if (this.mAssociationState != null) {
                    this.mProcessStats.mTrackingAssociations.add(this);
                }
            }
            if (this.mAssociationState != null && (commonSource = getCommonSourceState(true)) != null) {
                commonSource.trackProcState(procState, seq, now);
            }
        }

        long start() {
            SourceState commonSource;
            long now = start(-1L);
            if (this.mAssociationState != null && (commonSource = getCommonSourceState(true)) != null) {
                commonSource.start(now);
            }
            return now;
        }

        long start(long now) {
            int i10 = this.mNesting + 1;
            this.mNesting = i10;
            if (i10 == 1) {
                if (now < 0) {
                    now = SystemClock.uptimeMillis();
                }
                this.mCount++;
                this.mStartUptime = now;
            }
            return now;
        }

        public void stop() {
            SourceState commonSource;
            long now = stop(-1L);
            if (this.mAssociationState != null && (commonSource = getCommonSourceState(false)) != null) {
                commonSource.stop(now);
            }
        }

        long stop(long now) {
            int i10 = this.mNesting - 1;
            this.mNesting = i10;
            if (i10 == 0) {
                if (now < 0) {
                    now = SystemClock.uptimeMillis();
                }
                this.mDuration += now - this.mStartUptime;
                stopTracking(now);
            }
            return now;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void startActive(long now) {
            SourceState commonSource;
            boolean startActive = false;
            if (this.mInTrackingList) {
                if (this.mActiveStartUptime == 0) {
                    this.mActiveStartUptime = now;
                    this.mActiveNesting++;
                    this.mActiveCount++;
                    startActive = true;
                    AssociationState associationState = this.mAssociationState;
                    if (associationState != null) {
                        associationState.mTotalActiveNesting++;
                        if (this.mAssociationState.mTotalActiveNesting == 1) {
                            this.mAssociationState.mTotalActiveCount++;
                            this.mAssociationState.mTotalActiveStartUptime = now;
                        }
                    }
                } else if (this.mAssociationState == null) {
                    this.mActiveNesting++;
                }
                int i10 = this.mActiveProcState;
                if (i10 != this.mProcState) {
                    if (i10 != -1) {
                        long addedDuration = (this.mActiveDuration + now) - this.mActiveStartUptime;
                        this.mActiveStartUptime = now;
                        if (this.mAssociationState != null) {
                            startActive = true;
                        }
                        if (addedDuration != 0) {
                            if (this.mActiveDurations == null) {
                                makeDurations();
                            }
                            this.mActiveDurations.addDuration(this.mActiveProcState, addedDuration);
                            this.mActiveDuration = 0L;
                        }
                    }
                    this.mActiveProcState = this.mProcState;
                }
            } else if (this.mAssociationState != null) {
                Slog.wtf("ProcessStats", "startActive while not tracking: " + ((Object) this));
            }
            if (this.mAssociationState != null && (commonSource = getCommonSourceState(true)) != null && startActive) {
                commonSource.startActive(now);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void stopActive(long now) {
            SourceState commonSource;
            boolean stopActive = false;
            if (this.mActiveStartUptime != 0) {
                if (!this.mInTrackingList && this.mAssociationState != null) {
                    Slog.wtf("ProcessStats", "stopActive while not tracking: " + ((Object) this));
                }
                int i10 = this.mActiveNesting - 1;
                this.mActiveNesting = i10;
                long addedDuration = now - this.mActiveStartUptime;
                long j10 = (this.mAssociationState != null || i10 == 0) ? 0L : now;
                this.mActiveStartUptime = j10;
                stopActive = j10 == 0;
                DurationsTable durationsTable = this.mActiveDurations;
                if (durationsTable != null) {
                    durationsTable.addDuration(this.mActiveProcState, addedDuration);
                } else {
                    this.mActiveDuration += addedDuration;
                }
                AssociationState associationState = this.mAssociationState;
                if (associationState != null) {
                    associationState.mTotalActiveNesting--;
                    if (this.mAssociationState.mTotalActiveNesting == 0) {
                        this.mAssociationState.mTotalActiveDuration += now - this.mAssociationState.mTotalActiveStartUptime;
                        this.mAssociationState.mTotalActiveStartUptime = 0L;
                    }
                }
            }
            if (this.mAssociationState != null && (commonSource = getCommonSourceState(false)) != null && stopActive) {
                commonSource.stopActive(now);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean stopActiveIfNecessary(int curSeq, long now) {
            if (this.mProcStateSeq != curSeq || this.mProcState >= 12) {
                stopActive(now);
                stopTrackingProcState();
                return true;
            }
            return false;
        }

        private void stopTrackingProcState() {
            SourceState commonSource;
            this.mInTrackingList = false;
            this.mProcState = -1;
            if (this.mAssociationState != null && (commonSource = getCommonSourceState(false)) != null) {
                commonSource.stopTrackingProcState();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isInUse() {
            return this.mNesting > 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void resetSafely(long now) {
            SourceState commonSource;
            if (isInUse()) {
                this.mCount = 1;
                this.mStartUptime = now;
                this.mDuration = 0L;
                if (this.mActiveStartUptime > 0) {
                    this.mActiveCount = 1;
                    this.mActiveStartUptime = now;
                } else {
                    this.mActiveCount = 0;
                }
                this.mActiveDuration = 0L;
                this.mActiveDurations = null;
            }
            if (this.mAssociationState != null && (commonSource = getCommonSourceState(false)) != null) {
                commonSource.resetSafely(now);
                this.mCommonSourceState = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void commitStateTime(long nowUptime) {
            if (this.mNesting > 0) {
                this.mDuration += nowUptime - this.mStartUptime;
                this.mStartUptime = nowUptime;
            }
            long j10 = this.mActiveStartUptime;
            if (j10 > 0) {
                long addedDuration = nowUptime - j10;
                this.mActiveStartUptime = nowUptime;
                DurationsTable durationsTable = this.mActiveDurations;
                if (durationsTable != null) {
                    durationsTable.addDuration(this.mActiveProcState, addedDuration);
                } else {
                    this.mActiveDuration += addedDuration;
                }
            }
        }

        void makeDurations() {
            this.mActiveDurations = new DurationsTable(this.mProcessStats.mTableData);
        }

        private void stopTracking(long now) {
            if (this.mAssociationState != null) {
                r0.mTotalNesting--;
                if (this.mAssociationState.mTotalNesting == 0) {
                    this.mAssociationState.mTotalDuration += now - this.mAssociationState.mTotalStartUptime;
                }
            }
            stopActive(now);
            if (this.mInTrackingList) {
                this.mInTrackingList = false;
                this.mProcState = -1;
                if (this.mAssociationState != null) {
                    ArrayList<SourceState> list = this.mProcessStats.mTrackingAssociations;
                    for (int i10 = list.size() - 1; i10 >= 0; i10--) {
                        if (list.get(i10) == this) {
                            list.remove(i10);
                            return;
                        }
                    }
                    Slog.wtf("ProcessStats", "Stop tracking didn't find in tracking list: " + ((Object) this));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void add(SourceState otherSrc) {
            this.mCount += otherSrc.mCount;
            this.mDuration += otherSrc.mDuration;
            this.mActiveCount += otherSrc.mActiveCount;
            long j10 = otherSrc.mActiveDuration;
            if (j10 != 0 || otherSrc.mActiveDurations != null) {
                DurationsTable durationsTable = this.mActiveDurations;
                if (durationsTable != null) {
                    DurationsTable durationsTable2 = otherSrc.mActiveDurations;
                    if (durationsTable2 != null) {
                        durationsTable.addDurations(durationsTable2);
                        return;
                    } else {
                        durationsTable.addDuration(otherSrc.mActiveProcState, j10);
                        return;
                    }
                }
                if (otherSrc.mActiveDurations != null) {
                    makeDurations();
                    this.mActiveDurations.addDurations(otherSrc.mActiveDurations);
                    long j11 = this.mActiveDuration;
                    if (j11 != 0) {
                        this.mActiveDurations.addDuration(this.mActiveProcState, j11);
                        this.mActiveDuration = 0L;
                        this.mActiveProcState = -1;
                        return;
                    }
                    return;
                }
                long j12 = this.mActiveDuration;
                if (j12 != 0) {
                    if (this.mActiveProcState == otherSrc.mActiveProcState) {
                        this.mActiveDuration = j12 + j10;
                        return;
                    }
                    makeDurations();
                    this.mActiveDurations.addDuration(this.mActiveProcState, this.mActiveDuration);
                    this.mActiveDurations.addDuration(otherSrc.mActiveProcState, otherSrc.mActiveDuration);
                    this.mActiveDuration = 0L;
                    this.mActiveProcState = -1;
                    return;
                }
                this.mActiveProcState = otherSrc.mActiveProcState;
                this.mActiveDuration = j10;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            out.writeInt(this.mCount);
            out.writeLong(this.mDuration);
            out.writeInt(this.mActiveCount);
            if (this.mActiveDurations != null) {
                out.writeInt(1);
                this.mActiveDurations.writeToParcel(out);
            } else {
                out.writeInt(0);
                out.writeInt(this.mActiveProcState);
                out.writeLong(this.mActiveDuration);
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String readFromParcel(Parcel in) {
            this.mCount = in.readInt();
            this.mDuration = in.readLong();
            this.mActiveCount = in.readInt();
            if (in.readInt() != 0) {
                makeDurations();
                if (!this.mActiveDurations.readFromParcel(in)) {
                    return "Duration table corrupt: " + ((Object) this.mKey) + " <- " + toString();
                }
                return null;
            }
            this.mActiveProcState = in.readInt();
            this.mActiveDuration = in.readLong();
            return null;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append("SourceState{").append(Integer.toHexString(System.identityHashCode(this))).append(" ").append(this.mKey.mProcess).append("/").append(this.mKey.mUid);
            if (this.mProcState != -1) {
                sb2.append(" ").append(DumpUtils.STATE_NAMES[this.mProcState]).append(" #").append(this.mProcStateSeq);
            }
            sb2.append(i.f4738d);
            return sb2.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class SourceDumpContainer {
        public long mActiveTime;
        public final SourceState mState;
        public long mTotalTime;

        public SourceDumpContainer(SourceState state) {
            this.mState = state;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class SourceKey {
        String mPackage;
        String mProcess;
        int mUid;

        SourceKey(int uid, String process, String pkg) {
            this.mUid = uid;
            this.mProcess = process;
            this.mPackage = pkg;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public SourceKey(ProcessStats stats, Parcel in, int parcelVersion) {
            this.mUid = in.readInt();
            this.mProcess = stats.readCommonString(in, parcelVersion);
            this.mPackage = stats.readCommonString(in, parcelVersion);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void writeToParcel(ProcessStats stats, Parcel out) {
            out.writeInt(this.mUid);
            stats.writeCommonString(out, this.mProcess);
            stats.writeCommonString(out, this.mPackage);
        }

        public boolean equals(Object o10) {
            if (!(o10 instanceof SourceKey)) {
                return false;
            }
            SourceKey s2 = (SourceKey) o10;
            return s2.mUid == this.mUid && Objects.equals(s2.mProcess, this.mProcess) && Objects.equals(s2.mPackage, this.mPackage);
        }

        public int hashCode() {
            int hashCode = Integer.hashCode(this.mUid);
            String str = this.mProcess;
            int hashCode2 = hashCode ^ (str == null ? 0 : str.hashCode());
            String str2 = this.mPackage;
            return hashCode2 ^ (str2 != null ? str2.hashCode() * 33 : 0);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append("SourceKey{");
            UserHandle.formatUid(sb2, this.mUid);
            sb2.append(' ');
            sb2.append(this.mProcess);
            sb2.append(' ');
            sb2.append(this.mPackage);
            sb2.append('}');
            return sb2.toString();
        }
    }

    public AssociationState(ProcessStats processStats, ProcessStats.PackageState packageState, String name, String processName, ProcessState proc) {
        this.mProcessStats = processStats;
        this.mPackageState = packageState;
        this.mName = name;
        this.mProcessName = processName;
        this.mProc = proc;
    }

    public int getUid() {
        return this.mPackageState.mUid;
    }

    public String getPackage() {
        return this.mPackageState.mPackageName;
    }

    public String getProcessName() {
        return this.mProcessName;
    }

    public String getName() {
        return this.mName;
    }

    public ProcessState getProcess() {
        return this.mProc;
    }

    public void setProcess(ProcessState proc) {
        this.mProc = proc;
    }

    public long getTotalDuration(long now) {
        return this.mTotalDuration + (this.mTotalNesting > 0 ? now - this.mTotalStartUptime : 0L);
    }

    public long getActiveDuration(long now) {
        return this.mTotalActiveDuration + (this.mTotalActiveNesting > 0 ? now - this.mTotalActiveStartUptime : 0L);
    }

    public SourceState startSource(int uid, String processName, String packageName) {
        SourceState src;
        SourceKey sourceKey = sTmpSourceKey;
        synchronized (sourceKey) {
            sourceKey.mUid = uid;
            sourceKey.mProcess = processName;
            sourceKey.mPackage = packageName;
            src = this.mSources.get(sourceKey);
        }
        if (src == null) {
            SourceKey key = new SourceKey(uid, processName, packageName);
            src = new SourceState(this.mProcessStats, this, this.mProc, key);
            this.mSources.put(key, src);
        }
        long now = src.start();
        if (now > 0) {
            int i10 = this.mTotalNesting + 1;
            this.mTotalNesting = i10;
            if (i10 == 1) {
                this.mTotalCount++;
                this.mTotalStartUptime = now;
            }
        }
        return src;
    }

    public void add(AssociationState other) {
        this.mTotalCount += other.mTotalCount;
        long j10 = this.mTotalDuration;
        this.mTotalDuration += other.mTotalDuration;
        this.mTotalActiveCount += other.mTotalActiveCount;
        this.mTotalActiveDuration += other.mTotalActiveDuration;
        for (int isrc = other.mSources.size() - 1; isrc >= 0; isrc--) {
            SourceKey key = other.mSources.keyAt(isrc);
            SourceState otherSrc = other.mSources.valueAt(isrc);
            SourceState mySrc = this.mSources.get(key);
            if (mySrc == null) {
                mySrc = new SourceState(this.mProcessStats, this, this.mProc, key);
                this.mSources.put(key, mySrc);
            }
            mySrc.add(otherSrc);
        }
    }

    public boolean isInUse() {
        return this.mTotalNesting > 0;
    }

    public void resetSafely(long now) {
        if (!isInUse()) {
            this.mSources.clear();
            this.mTotalActiveCount = 0;
            this.mTotalCount = 0;
        } else {
            for (int isrc = this.mSources.size() - 1; isrc >= 0; isrc--) {
                SourceState src = this.mSources.valueAt(isrc);
                if (src.isInUse()) {
                    src.resetSafely(now);
                } else {
                    this.mSources.removeAt(isrc);
                }
            }
            this.mTotalCount = 1;
            this.mTotalStartUptime = now;
            if (this.mTotalActiveNesting > 0) {
                this.mTotalActiveCount = 1;
                this.mTotalActiveStartUptime = now;
            } else {
                this.mTotalActiveCount = 0;
            }
        }
        this.mTotalActiveDuration = 0L;
        this.mTotalDuration = 0L;
    }

    public void writeToParcel(ProcessStats stats, Parcel out, long nowUptime) {
        out.writeInt(this.mTotalCount);
        out.writeLong(this.mTotalDuration);
        out.writeInt(this.mTotalActiveCount);
        out.writeLong(this.mTotalActiveDuration);
        int NSRC = this.mSources.size();
        out.writeInt(NSRC);
        for (int isrc = 0; isrc < NSRC; isrc++) {
            SourceKey key = this.mSources.keyAt(isrc);
            SourceState src = this.mSources.valueAt(isrc);
            key.writeToParcel(stats, out);
            src.writeToParcel(out, 0);
        }
    }

    public String readFromParcel(ProcessStats stats, Parcel in, int parcelVersion) {
        this.mTotalCount = in.readInt();
        this.mTotalDuration = in.readLong();
        this.mTotalActiveCount = in.readInt();
        this.mTotalActiveDuration = in.readLong();
        int NSRC = in.readInt();
        if (NSRC < 0 || NSRC > 100000) {
            return "Association with bad src count: " + NSRC;
        }
        for (int isrc = 0; isrc < NSRC; isrc++) {
            SourceKey key = new SourceKey(stats, in, parcelVersion);
            SourceState src = new SourceState(this.mProcessStats, this, this.mProc, key);
            String errMsg = src.readFromParcel(in);
            if (errMsg != null) {
                return errMsg;
            }
            this.mSources.put(key, src);
        }
        return null;
    }

    public void commitStateTime(long nowUptime) {
        if (isInUse()) {
            for (int isrc = this.mSources.size() - 1; isrc >= 0; isrc--) {
                SourceState src = this.mSources.valueAt(isrc);
                src.commitStateTime(nowUptime);
            }
            int isrc2 = this.mTotalNesting;
            if (isrc2 > 0) {
                this.mTotalDuration += nowUptime - this.mTotalStartUptime;
                this.mTotalStartUptime = nowUptime;
            }
            if (this.mTotalActiveNesting > 0) {
                this.mTotalActiveDuration += nowUptime - this.mTotalActiveStartUptime;
                this.mTotalActiveStartUptime = nowUptime;
            }
        }
    }

    public boolean hasProcessOrPackage(String procName) {
        if (this.mProcessName.equals(procName)) {
            return true;
        }
        int NSRC = this.mSources.size();
        for (int isrc = 0; isrc < NSRC; isrc++) {
            SourceKey key = this.mSources.keyAt(isrc);
            if (procName.equals(key.mProcess) || procName.equals(key.mPackage)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int lambda$static$0(Pair o12, Pair o22) {
        int diff;
        if (((SourceDumpContainer) o12.second).mActiveTime != ((SourceDumpContainer) o22.second).mActiveTime) {
            return ((SourceDumpContainer) o12.second).mActiveTime > ((SourceDumpContainer) o22.second).mActiveTime ? -1 : 1;
        }
        if (((SourceDumpContainer) o12.second).mTotalTime != ((SourceDumpContainer) o22.second).mTotalTime) {
            return ((SourceDumpContainer) o12.second).mTotalTime > ((SourceDumpContainer) o22.second).mTotalTime ? -1 : 1;
        }
        if (((SourceKey) o12.first).mUid != ((SourceKey) o22.first).mUid) {
            return ((SourceKey) o12.first).mUid < ((SourceKey) o22.first).mUid ? -1 : 1;
        }
        if (((SourceKey) o12.first).mProcess != ((SourceKey) o22.first).mProcess && (diff = ((SourceKey) o12.first).mProcess.compareTo(((SourceKey) o22.first).mProcess)) != 0) {
            return diff;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArrayList<Pair<SourceKey, SourceDumpContainer>> createSortedAssociations(long now, long totalTime, ArrayMap<SourceKey, SourceState> inSources) {
        long duration;
        int numOfSources = inSources.size();
        ArrayList<Pair<SourceKey, SourceDumpContainer>> sources = new ArrayList<>(numOfSources);
        for (int isrc = 0; isrc < numOfSources; isrc++) {
            SourceState src = inSources.valueAt(isrc);
            SourceDumpContainer cont = new SourceDumpContainer(src);
            long duration2 = src.mDuration;
            if (src.mNesting <= 0) {
                duration = duration2;
            } else {
                duration = duration2 + (now - src.mStartUptime);
            }
            cont.mTotalTime = duration;
            cont.mActiveTime = dumpTime(null, null, src, totalTime, now, false, false);
            if (cont.mActiveTime < 0) {
                cont.mActiveTime = -cont.mActiveTime;
            }
            sources.add(new Pair<>(inSources.keyAt(isrc), cont));
        }
        Collections.sort(sources, ASSOCIATION_COMPARATOR);
        return sources;
    }

    public void dumpStats(PrintWriter pw, String prefix, String prefixInner, String headerPrefix, ArrayList<Pair<SourceKey, SourceDumpContainer>> sources, long now, long totalTime, String reqPackage, boolean dumpDetails, boolean dumpAll) {
        long totalDuration;
        String prefixInnerInner = prefixInner + "     ";
        long totalDuration2 = this.mTotalActiveDuration;
        if (this.mTotalActiveNesting > 0) {
            totalDuration2 += now - this.mTotalActiveStartUptime;
        }
        if (totalDuration2 > 0 || this.mTotalActiveCount != 0) {
            pw.print(prefix);
            pw.print("Active count ");
            pw.print(this.mTotalActiveCount);
            if (dumpAll) {
                pw.print(": ");
                TimeUtils.formatDuration(totalDuration2, pw);
                pw.print(" / ");
            } else {
                pw.print(": time ");
            }
            DumpUtils.printPercent(pw, totalDuration2 / totalTime);
            pw.println();
        }
        if (dumpAll && this.mTotalActiveNesting != 0) {
            pw.print(prefix);
            pw.print("mTotalActiveNesting=");
            pw.print(this.mTotalActiveNesting);
            pw.print(" mTotalActiveStartUptime=");
            TimeUtils.formatDuration(this.mTotalActiveStartUptime, now, pw);
            pw.println();
        }
        long totalDuration3 = this.mTotalDuration;
        if (this.mTotalNesting <= 0) {
            totalDuration = totalDuration3;
        } else {
            totalDuration = totalDuration3 + (now - this.mTotalStartUptime);
        }
        if (totalDuration > 0 || this.mTotalCount != 0) {
            pw.print(prefix);
            pw.print("Total count ");
            pw.print(this.mTotalCount);
            if (dumpAll) {
                pw.print(": ");
                TimeUtils.formatDuration(totalDuration, pw);
                pw.print(" / ");
            } else {
                pw.print(": time ");
            }
            DumpUtils.printPercent(pw, totalDuration / totalTime);
            pw.println();
        }
        if (dumpAll && this.mTotalNesting != 0) {
            pw.print(prefix);
            pw.print("mTotalNesting=");
            pw.print(this.mTotalNesting);
            pw.print(" mTotalStartUptime=");
            TimeUtils.formatDuration(this.mTotalStartUptime, now, pw);
            pw.println();
        }
        dumpSources(pw, prefix, prefixInner, prefixInnerInner, sources, now, totalTime, reqPackage, dumpDetails, dumpAll);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01d9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0161  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void dumpSources(java.io.PrintWriter r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.util.ArrayList<android.util.Pair<com.android.internal.app.procstats.AssociationState.SourceKey, com.android.internal.app.procstats.AssociationState.SourceDumpContainer>> r25, long r26, long r28, java.lang.String r30, boolean r31, boolean r32) {
        /*
            Method dump skipped, instructions count: 485
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.app.procstats.AssociationState.dumpSources(java.io.PrintWriter, java.lang.String, java.lang.String, java.lang.String, java.util.ArrayList, long, long, java.lang.String, boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void dumpActiveDurationSummary(PrintWriter pw, SourceState src, long totalTime, long now, boolean dumpAll) {
        long duration = dumpTime(null, null, src, totalTime, now, false, false);
        boolean isRunning = duration < 0;
        if (isRunning) {
            duration = -duration;
        }
        if (dumpAll) {
            TimeUtils.formatDuration(duration, pw);
            pw.print(" / ");
        } else {
            pw.print("time ");
        }
        DumpUtils.printPercent(pw, duration / totalTime);
        if (src.mActiveStartUptime > 0) {
            pw.print(" (running)");
        }
        pw.println();
    }

    static long dumpTime(PrintWriter pw, String prefix, SourceState src, long overallTime, long now, boolean dumpDetails, boolean dumpAll) {
        long time;
        String running;
        long totalTime = 0;
        boolean isRunning = false;
        int iprocstate = 0;
        while (iprocstate < 16) {
            if (src.mActiveDurations != null) {
                time = src.mActiveDurations.getValueForId((byte) iprocstate);
            } else {
                time = src.mActiveProcState == iprocstate ? src.mActiveDuration : 0L;
            }
            if (src.mActiveStartUptime != 0 && src.mActiveProcState == iprocstate) {
                running = " (running)";
                isRunning = true;
                time += now - src.mActiveStartUptime;
            } else {
                running = null;
            }
            if (time != 0) {
                if (pw != null) {
                    pw.print(prefix);
                    pw.print(DumpUtils.STATE_LABELS[iprocstate]);
                    pw.print(": ");
                    if (dumpAll) {
                        TimeUtils.formatDuration(time, pw);
                        pw.print(" / ");
                    } else {
                        pw.print("time ");
                    }
                    DumpUtils.printPercent(pw, time / overallTime);
                    if (running != null) {
                        pw.print(running);
                    }
                    pw.println();
                }
                totalTime += time;
            }
            iprocstate++;
        }
        return isRunning ? -totalTime : totalTime;
    }

    public void dumpTimesCheckin(PrintWriter pw, String pkgName, int uid, long vers, String associationName, long now) {
        int NSRC;
        AssociationState associationState = this;
        int NSRC2 = associationState.mSources.size();
        int isrc = 0;
        while (isrc < NSRC2) {
            SourceKey key = associationState.mSources.keyAt(isrc);
            SourceState src = associationState.mSources.valueAt(isrc);
            pw.print("pkgasc");
            pw.print(",");
            pw.print(pkgName);
            pw.print(",");
            pw.print(uid);
            pw.print(",");
            pw.print(vers);
            pw.print(",");
            pw.print(associationName);
            pw.print(",");
            pw.print(key.mProcess);
            pw.print(",");
            pw.print(key.mUid);
            pw.print(",");
            pw.print(src.mCount);
            long duration = src.mDuration;
            if (src.mNesting > 0) {
                duration += now - src.mStartUptime;
            }
            pw.print(",");
            pw.print(duration);
            pw.print(",");
            pw.print(src.mActiveCount);
            long timeNow = src.mActiveStartUptime != 0 ? now - src.mActiveStartUptime : 0L;
            if (src.mActiveDurations != null) {
                int N = src.mActiveDurations.getKeyCount();
                int i10 = 0;
                while (i10 < N) {
                    int NSRC3 = NSRC2;
                    int dkey = src.mActiveDurations.getKeyAt(i10);
                    SourceKey key2 = key;
                    long duration2 = src.mActiveDurations.getValue(dkey);
                    if (dkey == src.mActiveProcState) {
                        duration2 += timeNow;
                    }
                    int procState = SparseMappingTable.getIdFromKey(dkey);
                    pw.print(",");
                    DumpUtils.printArrayEntry(pw, DumpUtils.STATE_TAGS, procState, 1);
                    pw.print(ShortcutConstants.SERVICES_SEPARATOR);
                    pw.print(duration2);
                    i10++;
                    NSRC2 = NSRC3;
                    key = key2;
                }
                NSRC = NSRC2;
            } else {
                NSRC = NSRC2;
                long duration3 = src.mActiveDuration + timeNow;
                if (duration3 != 0) {
                    pw.print(",");
                    DumpUtils.printArrayEntry(pw, DumpUtils.STATE_TAGS, src.mActiveProcState, 1);
                    pw.print(ShortcutConstants.SERVICES_SEPARATOR);
                    pw.print(duration3);
                }
            }
            pw.println();
            isrc++;
            associationState = this;
            NSRC2 = NSRC;
        }
    }

    public void dumpDebug(ProtoOutputStream proto, long fieldId, long now) {
        int isrc;
        int NSRC;
        long sourceToken;
        int NSRC2;
        long j10;
        long sourceToken2;
        long j11 = now;
        long token = proto.start(fieldId);
        proto.write(1138166333441L, this.mName);
        proto.write(1120986464259L, this.mTotalCount);
        proto.write(1112396529668L, getTotalDuration(j11));
        int i10 = this.mTotalActiveCount;
        if (i10 != 0) {
            proto.write(1120986464261L, i10);
            proto.write(1112396529670L, getActiveDuration(j11));
        }
        int NSRC3 = this.mSources.size();
        int isrc2 = 0;
        while (isrc2 < NSRC3) {
            SourceKey key = this.mSources.keyAt(isrc2);
            SourceState src = this.mSources.valueAt(isrc2);
            long sourceToken3 = proto.start(2246267895810L);
            proto.write(1138166333442L, key.mProcess);
            proto.write(InputMethodManagerProto.NEXT_SERVED_VIEW, key.mPackage);
            proto.write(1120986464257L, key.mUid);
            proto.write(1120986464259L, src.mCount);
            long duration = src.mDuration;
            if (src.mNesting <= 0) {
                isrc = isrc2;
            } else {
                isrc = isrc2;
                duration += j11 - src.mStartUptime;
            }
            proto.write(1112396529668L, duration);
            if (src.mActiveCount == 0) {
                NSRC = NSRC3;
            } else {
                NSRC = NSRC3;
                proto.write(1120986464261L, src.mActiveCount);
            }
            long timeNow = src.mActiveStartUptime != 0 ? j11 - src.mActiveStartUptime : 0L;
            if (src.mActiveDurations != null) {
                int N = src.mActiveDurations.getKeyCount();
                long sourceToken4 = sourceToken3;
                int i11 = 0;
                while (i11 < N) {
                    int dkey = src.mActiveDurations.getKeyAt(i11);
                    long duration2 = src.mActiveDurations.getValue(dkey);
                    if (dkey == src.mActiveProcState) {
                        duration2 += timeNow;
                    }
                    int procState = SparseMappingTable.getIdFromKey(dkey);
                    long stateToken = proto.start(2246267895814L);
                    DumpUtils.printProto(proto, 1159641169921L, DumpUtils.STATE_PROTO_ENUMS, procState, 1);
                    proto.write(1112396529666L, duration2);
                    proto.end(stateToken);
                    i11++;
                    N = N;
                    src = src;
                    sourceToken4 = sourceToken4;
                }
                NSRC2 = NSRC;
                sourceToken = sourceToken4;
                j10 = 1112396529668L;
                sourceToken2 = 1120986464261L;
            } else {
                sourceToken = sourceToken3;
                NSRC2 = NSRC;
                j10 = 1112396529668L;
                sourceToken2 = 1120986464261L;
                long duration3 = src.mActiveDuration + timeNow;
                if (duration3 != 0) {
                    long stateToken2 = proto.start(2246267895814L);
                    DumpUtils.printProto(proto, 1159641169921L, DumpUtils.STATE_PROTO_ENUMS, src.mActiveProcState, 1);
                    proto.write(1112396529666L, duration3);
                    proto.end(stateToken2);
                }
            }
            long stateToken3 = sourceToken;
            proto.end(stateToken3);
            isrc2 = isrc + 1;
            j11 = now;
            NSRC3 = NSRC2;
        }
        proto.end(token);
    }

    public String toString() {
        return "AssociationState{" + Integer.toHexString(System.identityHashCode(this)) + " " + this.mName + " pkg=" + this.mPackageState.mPackageName + " proc=" + Integer.toHexString(System.identityHashCode(this.mProc)) + i.f4738d;
    }
}
