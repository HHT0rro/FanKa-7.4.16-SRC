package com.huawei.hms.adapter;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.AndroidException;
import com.huawei.hms.adapter.ui.UpdateAdapter;
import com.huawei.hms.common.HmsCheckedState;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.AgHmsUpdateState;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class AvailableUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f28955a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f28956b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f28957c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f28958a;

        public a(Context context) {
            this.f28958a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            HMSLog.i("AvailableUtil", "enter asyncCheckHmsV3UpdateInfo");
            if (!AvailableUtil.isInstallerLibExist(this.f28958a)) {
                AgHmsUpdateState.getInstance().setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
                HMSLog.e("AvailableUtil", "asyncCheckHmsV3UpdateInfo installer is not exist");
            } else {
                UpdateAdapter.invokeMethod("com.huawei.hms.adapter.ui.InstallerAdapter", "checkHmsUpdateInfo", new Object[]{this.f28958a});
                HMSLog.i("AvailableUtil", "quit asyncCheckHmsV3UpdateInfo");
            }
        }
    }

    public static void asyncCheckHmsUpdateInfo(Context context) {
        if (HmsCheckedState.UNCHECKED != AgHmsUpdateState.getInstance().getCheckedState()) {
            HMSLog.i("AvailableUtil", "asyncCheckHmsUpdateInfo, not need to check");
        } else {
            new Thread(new a(context), "Thread-asyncCheckHmsV3UpdateInfo").start();
        }
    }

    public static boolean isInstallerLibExist(Context context) {
        Bundle bundle;
        Object obj;
        if (f28956b) {
            HMSLog.i("AvailableUtil", "installerInit exist: " + f28957c);
            return f28957c;
        }
        synchronized (f28955a) {
            if (!f28956b) {
                boolean z10 = false;
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    HMSLog.e("AvailableUtil", "In isAvailableLibExist, Failed to get 'PackageManager' instance.");
                    try {
                        Class.forName("com.huawei.hms.update.manager.UpdateManager");
                        z10 = true;
                    } catch (ClassNotFoundException unused) {
                        HMSLog.e("AvailableUtil", "In isInstallerLibExist, Failed to find class UpdateManager.");
                    }
                    f28957c = z10;
                    f28956b = true;
                } else {
                    try {
                        try {
                            ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && (obj = bundle.get("availableHMSCoreInstaller")) != null && String.valueOf(obj).equalsIgnoreCase("yes")) {
                                HMSLog.i("AvailableUtil", "available exist: true");
                                z10 = true;
                            }
                        } catch (AndroidException unused2) {
                            HMSLog.e("AvailableUtil", "In isInstallerLibExist, Failed to read meta data for the availableHMSCoreInstaller.");
                        }
                    } catch (RuntimeException e2) {
                        HMSLog.e("AvailableUtil", "In isInstallerLibExist, Failed to read meta data for the availableHMSCoreInstaller.", e2);
                    }
                    f28957c = z10;
                    f28956b = true;
                }
            }
        }
        HMSLog.i("AvailableUtil", "available exist: " + f28957c);
        return f28957c;
    }
}
