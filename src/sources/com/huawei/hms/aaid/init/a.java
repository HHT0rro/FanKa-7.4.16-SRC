package com.huawei.hms.aaid.init;

import android.content.Context;

/* compiled from: AutoInitRunnable.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private Context f28922a;

    public a(Context context) {
        this.f28922a = context;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:22:0x008c
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    @Override // java.lang.Runnable
    public void run() {
        /*
            r8 = this;
            java.lang.String r0 = "push kit sdk not exists"
            java.lang.String r1 = "AutoInit"
            com.huawei.hms.aaid.constant.ErrorEnum r2 = com.huawei.hms.aaid.constant.ErrorEnum.SUCCESS     // Catch: java.lang.Exception -> L90
            int r2 = r2.getInternalCode()     // Catch: java.lang.Exception -> L90
            r3 = 0
            android.content.Context r4 = r8.f28922a     // Catch: com.huawei.hms.common.ApiException -> L27 java.lang.Exception -> L90
            com.huawei.hms.aaid.HmsInstanceId r4 = com.huawei.hms.aaid.HmsInstanceId.getInstance(r4)     // Catch: com.huawei.hms.common.ApiException -> L27 java.lang.Exception -> L90
            android.content.Context r5 = r8.f28922a     // Catch: com.huawei.hms.common.ApiException -> L27 java.lang.Exception -> L90
            java.lang.String r5 = com.huawei.hms.utils.Util.getAppId(r5)     // Catch: com.huawei.hms.common.ApiException -> L27 java.lang.Exception -> L90
            java.lang.String r3 = r4.getToken(r5, r3)     // Catch: com.huawei.hms.common.ApiException -> L27 java.lang.Exception -> L90
            java.lang.String r4 = "Push init succeed"
            com.huawei.hms.support.log.HMSLog.i(r1, r4)     // Catch: com.huawei.hms.common.ApiException -> L27 java.lang.Exception -> L90
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: com.huawei.hms.common.ApiException -> L27 java.lang.Exception -> L90
            if (r4 == 0) goto L31
            return
        L27:
            r2 = move-exception
            int r2 = r2.getStatusCode()     // Catch: java.lang.Exception -> L90
            java.lang.String r4 = "new Push init failed"
            com.huawei.hms.support.log.HMSLog.e(r1, r4)     // Catch: java.lang.Exception -> L90
        L31:
            android.content.Context r4 = r8.f28922a     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L8c java.lang.Exception -> L90
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L8c java.lang.Exception -> L90
            android.content.Context r5 = r8.f28922a     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L8c java.lang.Exception -> L90
            java.lang.String r5 = r5.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L8c java.lang.Exception -> L90
            r6 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r4 = r4.getApplicationInfo(r5, r6)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L8c java.lang.Exception -> L90
            android.os.Bundle r4 = r4.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L8c java.lang.Exception -> L90
            if (r4 == 0) goto L88
            java.lang.String r5 = "com.huawei.hms.client.service.name:push"
            java.lang.String r4 = r4.getString(r5)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L8c java.lang.Exception -> L90
            if (r4 == 0) goto L88
            android.content.Intent r4 = new android.content.Intent     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L8c java.lang.Exception -> L90
            java.lang.String r5 = "com.huawei.push.action.MESSAGING_EVENT"
            r4.<init>(r5)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L8c java.lang.Exception -> L90
            android.content.Context r5 = r8.f28922a     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L8c java.lang.Exception -> L90
            java.lang.String r5 = r5.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L8c java.lang.Exception -> L90
            r4.setPackage(r5)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L8c java.lang.Exception -> L90
            android.os.Bundle r5 = new android.os.Bundle     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L8c java.lang.Exception -> L90
            r5.<init>()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L8c java.lang.Exception -> L90
            java.lang.String r6 = "message_type"
            java.lang.String r7 = "new_token"
            r5.putString(r6, r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L8c java.lang.Exception -> L90
            java.lang.String r6 = "device_token"
            r5.putString(r6, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L8c java.lang.Exception -> L90
            java.lang.String r3 = "error"
            r5.putInt(r3, r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L8c java.lang.Exception -> L90
            com.huawei.hms.opendevice.k r2 = new com.huawei.hms.opendevice.k     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L8c java.lang.Exception -> L90
            r2.<init>()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L8c java.lang.Exception -> L90
            android.content.Context r3 = r8.f28922a     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L8c java.lang.Exception -> L90
            boolean r2 = r2.a(r3, r5, r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L8c java.lang.Exception -> L90
            if (r2 != 0) goto L96
            java.lang.String r2 = "start service failed"
            com.huawei.hms.support.log.HMSLog.e(r1, r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L8c java.lang.Exception -> L90
            goto L96
        L88:
            com.huawei.hms.support.log.HMSLog.i(r1, r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L8c java.lang.Exception -> L90
            goto L96
        L8c:
            com.huawei.hms.support.log.HMSLog.i(r1, r0)     // Catch: java.lang.Exception -> L90
            goto L96
        L90:
            r0 = move-exception
            java.lang.String r2 = "Push init failed"
            com.huawei.hms.support.log.HMSLog.e(r1, r2, r0)
        L96:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.aaid.init.a.run():void");
    }
}
