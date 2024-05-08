package com.zego.zegoavkit2.hardwaremonitor;

import android.os.Process;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoCPUUtils {
    private RandomAccessFile appProcStatFile;
    private RandomAccessFile sysProcStatFile;
    private final long tickInHz = ZegoTimeUtilJNI.getTimeTick();
    private final int cpuCount = Runtime.getRuntime().availableProcessors();
    private float appCpuUseTimeLast = 0.0f;
    private float appCpuUsage = 0.0f;
    private long sysCpuTotalTimeLast = 0;
    private long sysCpuIdelTimeLast = 0;
    private float sysCpuUsage = 0.0f;

    public ZegoCPUUtils() {
        try {
            this.appProcStatFile = new RandomAccessFile(String.format("/proc/%d/stat", Integer.valueOf(Process.myPid())), t.f36226k);
        } catch (IOException unused) {
        }
        try {
            this.sysProcStatFile = new RandomAccessFile("proc/stat", t.f36226k);
        } catch (IOException unused2) {
        }
    }

    private static String[] getStrsFromFile(RandomAccessFile randomAccessFile) {
        String str;
        if (randomAccessFile == null) {
            return null;
        }
        try {
            randomAccessFile.seek(0L);
            str = randomAccessFile.readLine();
        } catch (IOException unused) {
            str = null;
        }
        if (str.isEmpty()) {
            return null;
        }
        return str.split("\\s+");
    }

    private void updateCpuUsage() {
        long currentTimeMillis;
        long j10;
        String[] strsFromFile = getStrsFromFile(this.appProcStatFile);
        if (strsFromFile == null || strsFromFile.length < 52) {
            return;
        }
        long parseLong = (((float) (((Long.parseLong(strsFromFile[13]) + Long.parseLong(strsFromFile[14])) + Long.parseLong(strsFromFile[15])) + Long.parseLong(strsFromFile[16]))) * 1000.0f) / ((float) this.tickInHz);
        String[] strsFromFile2 = getStrsFromFile(this.sysProcStatFile);
        if (strsFromFile2 != null && strsFromFile2.length >= 8) {
            long parseLong2 = Long.parseLong(strsFromFile2[1]) + Long.parseLong(strsFromFile2[2]) + Long.parseLong(strsFromFile2[3]) + Long.parseLong(strsFromFile2[4]) + Long.parseLong(strsFromFile2[5]) + Long.parseLong(strsFromFile2[6]) + Long.parseLong(strsFromFile2[7]);
            long parseLong3 = Long.parseLong(strsFromFile2[4]) + Long.parseLong(strsFromFile2[5]);
            float f10 = ((float) parseLong2) * 1000.0f;
            long j11 = this.tickInHz;
            currentTimeMillis = f10 / ((float) j11);
            j10 = (((float) parseLong3) * 1000.0f) / ((float) j11);
        } else {
            currentTimeMillis = System.currentTimeMillis() * this.cpuCount;
            j10 = currentTimeMillis;
        }
        long j12 = this.sysCpuIdelTimeLast;
        if (j10 < j12) {
            return;
        }
        float f11 = (float) parseLong;
        float f12 = (float) (currentTimeMillis - this.sysCpuTotalTimeLast);
        this.appCpuUsage = ((f11 - this.appCpuUseTimeLast) * 100.0f) / f12;
        this.sysCpuUsage = ((f12 - ((float) (j10 - j12))) * 100.0f) / f12;
        this.appCpuUseTimeLast = f11;
        this.sysCpuIdelTimeLast = j10;
        this.sysCpuTotalTimeLast = currentTimeMillis;
    }

    public double[] getCpuUsage() {
        double[] dArr;
        synchronized (this) {
            updateCpuUsage();
            dArr = new double[2];
            float f10 = this.appCpuUsage;
            double d10 = f10;
            double d11 = ShadowDrawableWrapper.COS_45;
            dArr[0] = d10 > ShadowDrawableWrapper.COS_45 ? f10 : 0.0d;
            float f11 = this.sysCpuUsage;
            if (f11 > ShadowDrawableWrapper.COS_45) {
                d11 = f11;
            }
            dArr[1] = d11;
        }
        return dArr;
    }
}
