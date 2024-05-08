package com.huawei.openalliance.ad.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.download.app.c;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PPSLauncherActivity extends Activity {
    public static final String Code = "69";
    private static final String V = "PPSLauncherActivity";

    private void Code() {
        c.Code(this, Code, (AdContentData) null, (RemoteCallResultCallback) null, (Class) null);
    }

    public boolean Code(Context context) {
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) context.getSystemService("activity")).getRunningTasks(10)) {
            if (runningTaskInfo.topActivity.getClassName().equalsIgnoreCase(PPSLauncherActivity.class.getName()) && runningTaskInfo.numActivities < 2) {
                return false;
            }
            if (runningTaskInfo.topActivity.getPackageName().equals(context.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        StringBuilder sb2;
        Intent launchIntentForPackage;
        try {
            super.onCreate(bundle);
            if (Code(this)) {
                gl.V(V, "app is active.");
                launchIntentForPackage = new Intent();
                launchIntentForPackage.setComponent(new ComponentName(getPackageName(), PPSBridgeActivity.class.getName()));
                launchIntentForPackage.setFlags(268435456);
                launchIntentForPackage.setClipData(u.cG);
            } else {
                gl.V(V, " app is not active. start launch app");
                launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
                launchIntentForPackage.setClipData(u.cG);
            }
            startActivity(launchIntentForPackage);
            Code();
            try {
                finish();
            } catch (Throwable th) {
                th = th;
                sb2 = new StringBuilder();
                sb2.append("finish activity error:");
                sb2.append(th.getClass().getName());
                gl.V(V, sb2.toString());
            }
        } catch (Throwable th2) {
            try {
                gl.V(V, "intent is not supported:" + th2.getClass().getName());
                try {
                    finish();
                } catch (Throwable th3) {
                    th = th3;
                    sb2 = new StringBuilder();
                    sb2.append("finish activity error:");
                    sb2.append(th.getClass().getName());
                    gl.V(V, sb2.toString());
                }
            } catch (Throwable th4) {
                try {
                    finish();
                } catch (Throwable th5) {
                    gl.V(V, "finish activity error:" + th5.getClass().getName());
                }
                throw th4;
            }
        }
    }
}
