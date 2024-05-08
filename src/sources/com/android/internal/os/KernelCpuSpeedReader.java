package com.android.internal.os;

import android.os.StrictMode;
import android.system.Os;
import android.system.OsConstants;
import android.text.TextUtils;
import android.util.Slog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class KernelCpuSpeedReader {
    private static final String TAG = "KernelCpuSpeedReader";
    private final long[] mDeltaSpeedTimesMs;
    private final long mJiffyMillis;
    private final long[] mLastSpeedTimesMs;
    private final int mNumSpeedSteps;
    private final String mProcFile;

    public KernelCpuSpeedReader(int cpuNumber, int numSpeedSteps) {
        this.mProcFile = String.format("/sys/devices/system/cpu/cpu%d/cpufreq/stats/time_in_state", Integer.valueOf(cpuNumber));
        this.mNumSpeedSteps = numSpeedSteps;
        this.mLastSpeedTimesMs = new long[numSpeedSteps];
        this.mDeltaSpeedTimesMs = new long[numSpeedSteps];
        long jiffyHz = Os.sysconf(OsConstants._SC_CLK_TCK);
        this.mJiffyMillis = 1000 / jiffyHz;
    }

    public long[] readDelta() {
        BufferedReader reader;
        StrictMode.ThreadPolicy policy = StrictMode.allowThreadDiskReads();
        try {
            try {
                reader = new BufferedReader(new FileReader(this.mProcFile));
            } catch (IOException e2) {
                Slog.e(TAG, "Failed to read cpu-freq: " + e2.getMessage());
                Arrays.fill(this.mDeltaSpeedTimesMs, 0L);
            }
            try {
                TextUtils.SimpleStringSplitter splitter = new TextUtils.SimpleStringSplitter(' ');
                int speedIndex = 0;
                while (speedIndex < this.mLastSpeedTimesMs.length) {
                    String line = reader.readLine();
                    if (line == null) {
                        break;
                    }
                    try {
                        splitter.setString(line);
                        splitter.next();
                        long time = Long.parseLong(splitter.next()) * this.mJiffyMillis;
                        long[] jArr = this.mLastSpeedTimesMs;
                        long j10 = jArr[speedIndex];
                        if (time < j10) {
                            this.mDeltaSpeedTimesMs[speedIndex] = time;
                        } else {
                            this.mDeltaSpeedTimesMs[speedIndex] = time - j10;
                        }
                        jArr[speedIndex] = time;
                    } catch (NumberFormatException ex) {
                        Slog.e(TAG, "speedIndex = " + speedIndex + ", Failed to read cpu-freq: " + ex.getMessage());
                        this.mDeltaSpeedTimesMs[speedIndex] = 0;
                        this.mLastSpeedTimesMs[speedIndex] = 0;
                        speedIndex++;
                    }
                    speedIndex++;
                }
                reader.close();
                StrictMode.setThreadPolicy(policy);
                return this.mDeltaSpeedTimesMs;
            } catch (Throwable th) {
                try {
                    reader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (Throwable th3) {
            StrictMode.setThreadPolicy(policy);
            throw th3;
        }
    }

    public long[] readAbsolute() {
        BufferedReader reader;
        String line;
        StrictMode.ThreadPolicy policy = StrictMode.allowThreadDiskReads();
        long[] speedTimeMs = new long[this.mNumSpeedSteps];
        try {
            try {
                reader = new BufferedReader(new FileReader(this.mProcFile));
            } catch (IOException e2) {
                Slog.e(TAG, "Failed to read cpu-freq: " + e2.getMessage());
                Arrays.fill(speedTimeMs, 0L);
            }
            try {
                TextUtils.SimpleStringSplitter splitter = new TextUtils.SimpleStringSplitter(' ');
                for (int speedIndex = 0; speedIndex < this.mNumSpeedSteps && (line = reader.readLine()) != null; speedIndex++) {
                    splitter.setString(line);
                    splitter.next();
                    long time = Long.parseLong(splitter.next()) * this.mJiffyMillis;
                    speedTimeMs[speedIndex] = time;
                }
                reader.close();
                return speedTimeMs;
            } catch (Throwable th) {
                try {
                    reader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } finally {
            StrictMode.setThreadPolicy(policy);
        }
    }
}
