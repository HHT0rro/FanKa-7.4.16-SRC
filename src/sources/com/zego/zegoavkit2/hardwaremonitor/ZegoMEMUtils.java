package com.zego.zegoavkit2.hardwaremonitor;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import com.google.android.material.shadow.ShadowDrawableWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoMEMUtils {
    public static double getAppUsedMemory(Context context, int i10) {
        if (Build.VERSION.SDK_INT < 28) {
            return getPSSFromActivityManager(context, i10);
        }
        return getPSSFromDebug();
    }

    private static double getPSSFromActivityManager(Context context, int i10) {
        if (i10 < 0) {
            return ShadowDrawableWrapper.COS_45;
        }
        try {
            return ((ActivityManager) context.getSystemService("activity")).getProcessMemoryInfo(new int[]{i10})[0].getTotalPss() / 1024.0d;
        } catch (Exception e2) {
            e2.printStackTrace();
            return ShadowDrawableWrapper.COS_45;
        }
    }

    private static double getPSSFromDebug() {
        Debug.getMemoryInfo(new Debug.MemoryInfo());
        return r0.getTotalPss() / 1024.0d;
    }

    public static double getTotalMemory(Context context) {
        try {
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(new ActivityManager.MemoryInfo());
            return (r0.totalMem / 1024.0d) / 1024.0d;
        } catch (Exception e2) {
            e2.printStackTrace();
            return ShadowDrawableWrapper.COS_45;
        }
    }

    public static double getUsedMemory(Context context) {
        try {
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(new ActivityManager.MemoryInfo());
            return ((r0.totalMem - r0.availMem) / 1024.0d) / 1024.0d;
        } catch (Exception e2) {
            e2.printStackTrace();
            return ShadowDrawableWrapper.COS_45;
        }
    }
}
