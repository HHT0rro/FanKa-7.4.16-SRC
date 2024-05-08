package com.android.internal.compat;

import android.text.TextUtils;
import android.util.Log;
import android.util.Slog;
import com.android.internal.util.FrameworkStatsLog;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class ChangeReporter {
    public static final int SOURCE_APP_PROCESS = 1;
    public static final int SOURCE_SYSTEM_SERVER = 2;
    public static final int SOURCE_UNKNOWN_SOURCE = 0;
    public static final int STATE_DISABLED = 2;
    public static final int STATE_ENABLED = 1;
    public static final int STATE_LOGGED = 3;
    public static final int STATE_UNKNOWN_STATE = 0;
    private static final String TAG = "CompatibilityChangeReporter";
    private int mSource;
    private final Map<Integer, Set<ChangeReport>> mReportedChanges = new HashMap();
    private boolean mDebugLogAll = false;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface Source {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface State {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class ChangeReport {
        long mChangeId;
        int mState;

        ChangeReport(long changeId, int state) {
            this.mChangeId = changeId;
            this.mState = state;
        }

        public boolean equals(Object o10) {
            if (this == o10) {
                return true;
            }
            if (o10 == null || getClass() != o10.getClass()) {
                return false;
            }
            ChangeReport that = (ChangeReport) o10;
            if (this.mChangeId == that.mChangeId && this.mState == that.mState) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Long.valueOf(this.mChangeId), Integer.valueOf(this.mState));
        }
    }

    public ChangeReporter(int source) {
        this.mSource = source;
    }

    public void reportChange(int uid, long changeId, int state) {
        if (shouldWriteToStatsLog(uid, changeId, state)) {
            FrameworkStatsLog.write(228, uid, changeId, state, this.mSource);
        }
        if (shouldWriteToDebug(uid, changeId, state)) {
            debugLog(uid, changeId, state);
        }
        markAsReported(uid, new ChangeReport(changeId, state));
    }

    public void startDebugLogAll() {
        this.mDebugLogAll = true;
    }

    public void stopDebugLogAll() {
        this.mDebugLogAll = false;
    }

    public boolean shouldWriteToStatsLog(int uid, long changeId, int state) {
        return !isAlreadyReported(uid, new ChangeReport(changeId, state));
    }

    public boolean shouldWriteToDebug(int uid, long changeId, int state) {
        return this.mDebugLogAll || !isAlreadyReported(uid, new ChangeReport(changeId, state));
    }

    private boolean isAlreadyReported(int uid, ChangeReport report) {
        synchronized (this.mReportedChanges) {
            Set<ChangeReport> reportedChangesForUid = this.mReportedChanges.get(Integer.valueOf(uid));
            if (reportedChangesForUid == null) {
                return false;
            }
            return reportedChangesForUid.contains(report);
        }
    }

    private void markAsReported(int uid, ChangeReport report) {
        synchronized (this.mReportedChanges) {
            Set<ChangeReport> reportedChangesForUid = this.mReportedChanges.get(Integer.valueOf(uid));
            if (reportedChangesForUid == null) {
                this.mReportedChanges.put(Integer.valueOf(uid), new HashSet());
                reportedChangesForUid = this.mReportedChanges.get(Integer.valueOf(uid));
            }
            reportedChangesForUid.add(report);
        }
    }

    public void resetReportedChanges(int uid) {
        synchronized (this.mReportedChanges) {
            this.mReportedChanges.remove(Integer.valueOf(uid));
        }
    }

    private void debugLog(int uid, long changeId, int state) {
        String message = TextUtils.formatSimple("Compat change id reported: %d; UID %d; state: %s", new Object[]{Long.valueOf(changeId), Integer.valueOf(uid), stateToString(state)});
        if (this.mSource == 2) {
            Slog.d(TAG, message);
        } else {
            Log.d(TAG, message);
        }
    }

    private static String stateToString(int state) {
        switch (state) {
            case 1:
                return "ENABLED";
            case 2:
                return "DISABLED";
            case 3:
                return "LOGGED";
            default:
                return GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
    }
}
