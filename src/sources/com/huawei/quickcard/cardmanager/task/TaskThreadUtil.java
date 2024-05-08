package com.huawei.quickcard.cardmanager.task;

import com.huawei.quickcard.cardmanager.log.ManagerLogUtil;
import java.util.concurrent.Executor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class TaskThreadUtil {

    /* renamed from: a, reason: collision with root package name */
    private static Executor f33562a;

    public static void execute(Runnable runnable) {
        Executor executor = f33562a;
        if (executor == null) {
            ManagerLogUtil.w("TaskThreadUtil does not set worker");
        } else {
            executor.execute(runnable);
        }
    }

    public static void setWorker(Executor executor) {
        f33562a = executor;
    }
}
