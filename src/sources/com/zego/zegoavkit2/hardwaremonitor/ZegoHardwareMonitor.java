package com.zego.zegoavkit2.hardwaremonitor;

import android.content.Context;
import android.os.Process;
import com.google.android.material.shadow.ShadowDrawableWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ZegoHardwareMonitor {
    private static double[] cpuUsage = {ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45};
    private static boolean isFirst = true;
    private static ZegoCPUUtils zegoCPUUtils = null;

    public static void getCpuUsage() {
        if (isFirst) {
            isFirst = false;
            ZegoCPUUtils zegoCPUUtils2 = new ZegoCPUUtils();
            zegoCPUUtils = zegoCPUUtils2;
            zegoCPUUtils2.getCpuUsage();
            return;
        }
        cpuUsage = zegoCPUUtils.getCpuUsage();
    }

    public static double getMEMTotal(Context context) {
        return ZegoMEMUtils.getTotalMemory(context);
    }

    public static double getMEMUsage(Context context) {
        return ZegoMEMUtils.getAppUsedMemory(context, Process.myPid());
    }

    public static double getProcessCPUUsage() {
        return cpuUsage[0];
    }

    public static double getSystemCPUUsage() {
        return cpuUsage[1];
    }

    public static double getSystemMEMUsage(Context context) {
        return ZegoMEMUtils.getUsedMemory(context);
    }

    public static void updateCpuUsage() {
        getCpuUsage();
    }
}
