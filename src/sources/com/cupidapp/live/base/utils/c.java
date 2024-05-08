package com.cupidapp.live.base.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ApplicationUtil.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class c {
    @Nullable
    public static final String a(@NotNull Context context) {
        kotlin.jvm.internal.s.i(context, "<this>");
        String c4 = c();
        if (!TextUtils.isEmpty(c4)) {
            return c4;
        }
        String a10 = b.a();
        return !TextUtils.isEmpty(a10) ? a10 : b(context);
    }

    @Nullable
    public static final String b(@NotNull Context context) {
        kotlin.jvm.internal.s.i(context, "<this>");
        try {
            int myPid = Process.myPid();
            Object systemService = context.getSystemService("activity");
            kotlin.jvm.internal.s.g(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) systemService).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Nullable
    public static final String c() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        return null;
    }
}
