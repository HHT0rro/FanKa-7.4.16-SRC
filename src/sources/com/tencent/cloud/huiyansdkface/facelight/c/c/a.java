package com.tencent.cloud.huiyansdkface.facelight.c.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tencent.bugly.idasc.crashreport.BuglyLog;
import com.tencent.bugly.idasc.crashreport.CrashReport;
import com.tencent.cloud.huiyansdkface.facelight.net.model.Param;
import com.tencent.cloud.huiyansdkface.facelivesdk.BuildConfig;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a implements b {
    @Override // com.tencent.cloud.huiyansdkface.facelight.c.c.b
    public void a() {
        CrashReport.closeNativeReport();
        CrashReport.closeBugly();
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.c.c.b
    public void a(Context context) {
        final Context applicationContext = context.getApplicationContext();
        CrashReport.setDeviceModel(applicationContext, Param.getDeviceModel());
        CrashReport.setSdkExtraData(applicationContext, "900057692", BuildConfig.VERSION_NAME);
        CrashReport.UserStrategy userStrategy = new CrashReport.UserStrategy(applicationContext);
        userStrategy.setCrashHandleCallback(new CrashReport.CrashHandleCallback() { // from class: com.tencent.cloud.huiyansdkface.facelight.c.c.a.1
            @Override // com.tencent.bugly.idasc.BuglyStrategy.a
            public synchronized Map<String, String> onCrashHandleStart(int i10, String str, String str2, String str3) {
                HashMap hashMap;
                WLogger.d("BuglyHelper", "crashType=" + i10 + ";errorType=" + str + ";errorMsg=" + str2 + ";errorStack=" + str3);
                hashMap = new HashMap();
                try {
                    Bundle bundle = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128).metaData;
                    for (String str4 : bundle.keySet()) {
                        if (str4 != null && str4.startsWith("wb_version_")) {
                            hashMap.put(str4, bundle.getString(str4));
                        }
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    e2.printStackTrace();
                }
                return hashMap;
            }
        });
        userStrategy.setAppChannel("normalPro");
        userStrategy.setAppPackageName(context.getApplicationContext().getPackageName());
        userStrategy.setAppVersion(BuildConfig.VERSION_NAME);
        CrashReport.putUserData(applicationContext, "wb", "normalPro");
        CrashReport.initCrashReport(applicationContext, "900057692", false, userStrategy);
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.c.c.b
    public void a(String str) {
        CrashReport.setUserId(str);
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.c.c.b
    public void a(String str, String str2) {
        BuglyLog.d(str, str2);
    }

    @Override // com.tencent.cloud.huiyansdkface.facelight.c.c.b
    public void b(String str, String str2) {
        BuglyLog.i(str, str2);
    }
}
