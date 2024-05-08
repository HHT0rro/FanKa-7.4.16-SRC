package com.android.internal.os;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.ArrayMap;
import android.util.Slog;
import com.android.internal.os.ProcessCpuTracker;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IProcessCpuTrackerExt {
    public static final String TAG = "IProcessCpuTrackerExt";

    default void init(ArrayList<ProcessCpuTracker.Stats> procStats) {
    }

    default void initHandler(Handler handler) {
        Slog.d(TAG, "default initHandler");
    }

    default void handleMessage(Message msg) {
        Slog.d(TAG, "default handleMessage");
    }

    default void collectAnbormalStats() {
        Slog.d(TAG, "default collectAnbormalStats");
    }

    default void printCpuTrack(PrintWriter pw) {
        Slog.d(TAG, "default printCpuTrack");
    }

    default void setContext(Context context) {
        Slog.d(TAG, "default setContext");
    }

    default void updateLastSampleWallTime(long lastSampleWallTime) {
        Slog.d(TAG, "default updateLastSampleWallTime");
    }

    default void updateCurrentSampleWallTime(long currentSampleWallTime) {
        Slog.d(TAG, "default updateCurrentSampleWallTime");
    }

    default void updateProcStats(ArrayList<ProcessCpuTracker.Stats> stats) {
    }

    default void updateLoad(float load1, float load5, float load15) {
    }

    default int getLoad1() {
        return -1;
    }

    default int getLoad5() {
        return -1;
    }

    default int getLoad15() {
        return -1;
    }

    default void buildWorkingProcs() {
    }

    default ArrayMap<String, String> getSimpleTopProcessesSnapShot() {
        return null;
    }

    default void collectSimpleTopThreeProcessesInfo(ArrayList<ProcessCpuTracker.Stats> workingProcs) {
    }

    default String getRatioString(long numerator, long denominator) {
        return null;
    }

    default void updateMaxCpuInfo(ProcessCpuTracker.Stats st, int denom) {
    }

    default int getMaxCpuThousandths() {
        return -1;
    }

    default String getMaxCpuProName() {
        return null;
    }

    default void initMaxCpuInfo() {
    }
}
