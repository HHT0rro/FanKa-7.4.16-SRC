package com.vivo.push.f;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotifyOpenClientClickTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f46197a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f46198b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f46199c;

    public f(e eVar, Context context, Map map) {
        this.f46199c = eVar;
        this.f46197a = context;
        this.f46198b = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String packageName = this.f46197a.getPackageName();
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) this.f46197a.getSystemService("activity")).getRunningTasks(100);
            if (runningTasks != null) {
                Iterator<ActivityManager.RunningTaskInfo> iterator2 = runningTasks.iterator2();
                while (iterator2.hasNext()) {
                    ComponentName componentName = iterator2.next().topActivity;
                    if (componentName.getPackageName().equals(packageName)) {
                        com.vivo.push.util.u.d("NotifyOpenClientTask", "topClassName=" + componentName.getClassName());
                        Intent intent = new Intent();
                        intent.setComponent(componentName);
                        intent.setFlags(335544320);
                        e.b(intent, this.f46198b);
                        this.f46197a.startActivity(intent);
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            com.vivo.push.util.u.a("NotifyOpenClientTask", "start recentIntent is error", e2);
        }
        Intent launchIntentForPackage = this.f46197a.getPackageManager().getLaunchIntentForPackage(this.f46197a.getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.setFlags(268435456);
            e.b(launchIntentForPackage, this.f46198b);
            this.f46197a.startActivity(launchIntentForPackage);
            return;
        }
        com.vivo.push.util.u.a("NotifyOpenClientTask", "LaunchIntent is null");
    }
}
