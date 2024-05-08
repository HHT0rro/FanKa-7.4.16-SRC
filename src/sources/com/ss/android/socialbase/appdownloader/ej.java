package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.openalliance.ad.constant.as;
import com.ss.android.socialbase.appdownloader.ej.oa;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.SystemUtils;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ej {
    private static NotificationChannel dk;

    /* renamed from: m, reason: collision with root package name */
    private static int f38861m;

    /* JADX INFO: Access modifiers changed from: private */
    public static int l(Context context, int i10, boolean z10) {
        if (DownloadSetting.obtain(i10).optInt("notification_opt_2") == 1) {
            DownloadNotificationManager.getInstance().cancelNotification(i10);
        }
        m((Activity) e.m().dk());
        if (DownloadSetting.obtain(i10).optInt("install_queue_enable", 0) == 1) {
            return e.m().m(context, i10, z10);
        }
        return dk(context, i10, z10);
    }

    public static String dk(long j10) {
        long[] jArr = {1099511627776L, 1073741824, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j10 < 1) {
            return "0 " + strArr[4];
        }
        for (int i10 = 0; i10 < 5; i10++) {
            long j11 = jArr[i10];
            if (j10 >= j11) {
                return m(j10, j11, strArr[i10]);
            }
        }
        return null;
    }

    public static boolean ej(Context context, DownloadInfo downloadInfo) {
        if (context == null || downloadInfo == null || TextUtils.isEmpty(downloadInfo.getSavePath()) || TextUtils.isEmpty(downloadInfo.getName())) {
            return false;
        }
        return dk(context, downloadInfo, m(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName()));
    }

    private static String m(long j10, long j11, String str, boolean z10) {
        double d10 = j10;
        if (j11 > 1) {
            d10 /= j11;
        }
        if (!z10 && !"GB".equals(str) && !"TB".equals(str)) {
            return new DecimalFormat("#").format(d10) + " " + str;
        }
        return new DecimalFormat("#.##").format(d10) + " " + str;
    }

    public static boolean ej(String str) {
        return !TextUtils.isEmpty(str) && str.equals("application/vnd.android.package-archive");
    }

    public static String m(long j10) {
        return m(j10, true);
    }

    public static List<String> ej() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add("application/vnd.android.package-archive");
        arrayList.add("application/ttpatch");
        return arrayList;
    }

    public static String m(long j10, boolean z10) {
        long[] jArr = {1099511627776L, 1073741824, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j10 < 1) {
            return "0 " + strArr[4];
        }
        for (int i10 = 0; i10 < 5; i10++) {
            long j11 = jArr[i10];
            if (j10 >= j11) {
                return m(j10, j11, strArr[i10], z10);
            }
        }
        return null;
    }

    public static int dk(final Context context, final int i10, final boolean z10) {
        final DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i10);
        if (downloadInfo != null && "application/vnd.android.package-archive".equals(downloadInfo.getMimeType()) && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            final File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            if (file.exists()) {
                DownloadComponentManager.submitIOTask(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.ej.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int m10 = ej.m(context, i10, z10, downloadInfo, file);
                        if (m10 == 1 && l.oa().q() != null) {
                            l.oa().q().onOpenInstaller(downloadInfo, null);
                        }
                        ej.dk(downloadInfo, z10, m10);
                    }
                });
                return 1;
            }
        }
        dk(downloadInfo, z10, 2);
        return 2;
    }

    private static JSONObject l(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String m(long j10, long j11, String str) {
        double d10 = j10;
        if (j11 > 1) {
            d10 /= j11;
        }
        if ("MB".equals(str)) {
            return new DecimalFormat("#").format(d10) + str;
        }
        return new DecimalFormat("#.##").format(d10) + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dk(DownloadInfo downloadInfo, boolean z10, int i10) {
        if (downloadInfo == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("by_user", z10 ? 1 : 2);
            jSONObject.put("view_result", i10);
            jSONObject.put("real_package_name", downloadInfo.getFilePackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onEvent(downloadInfo.getId(), MonitorConstants.EventLabel.INSTALL_VIEW_RESULT, jSONObject);
    }

    public static int m(final Context context, final int i10, final boolean z10) {
        oa hc2 = l.oa().hc();
        if (hc2 == null) {
            return l(context, i10, z10);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i10);
        f38861m = 1;
        hc2.m(downloadInfo, new com.ss.android.socialbase.appdownloader.ej.w() { // from class: com.ss.android.socialbase.appdownloader.ej.1
            @Override // com.ss.android.socialbase.appdownloader.ej.w
            public void m() {
                int unused = ej.f38861m = ej.l(context, i10, z10);
            }
        });
        return f38861m;
    }

    public static boolean dk(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        return m(context, downloadInfo, packageInfo, false);
    }

    public static int dk(Context context, DownloadInfo downloadInfo) {
        if (context != null && downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            int appVersionCode = downloadInfo.getAppVersionCode();
            if (appVersionCode > 0) {
                return appVersionCode;
            }
            try {
                PackageInfo m10 = m(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
                if (m10 != null) {
                    int i10 = m10.versionCode;
                    downloadInfo.setAppVersionCode(i10);
                    return i10;
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static int m(Context context, int i10, boolean z10, DownloadInfo downloadInfo, File file) {
        PackageInfo packageInfo;
        Intent m10;
        Process process;
        if (file.getPath().startsWith(Environment.getDataDirectory().getAbsolutePath())) {
            try {
                process = Runtime.getRuntime().exec("chmod 555 " + file.getAbsolutePath());
            } catch (Throwable th) {
                th = th;
                process = null;
            }
            try {
                process.waitFor();
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                } finally {
                    if (process != null) {
                        process.destroy();
                    }
                }
            }
        }
        try {
            packageInfo = m(downloadInfo, file);
            if (packageInfo != null) {
                try {
                    downloadInfo.setFilePackageName(packageInfo.packageName);
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            th = null;
        } catch (Throwable th4) {
            th = th4;
            packageInfo = null;
        }
        if (l.oa().ej() != null) {
            if (packageInfo == null) {
                BaseException baseException = new BaseException(2001, th);
                l.oa().ej().m(downloadInfo, baseException, baseException.getErrorCode());
            } else {
                l.oa().ej().m(downloadInfo, null, 11);
            }
        }
        if (m(context, downloadInfo, packageInfo)) {
            return 2;
        }
        if (packageInfo != null && DownloadSetting.obtain(downloadInfo.getId()).optBugFix("install_callback_error")) {
            downloadInfo.getTempCacheData().put("extra_apk_package_name", packageInfo.packageName);
            downloadInfo.getTempCacheData().put("extra_apk_version_code", Integer.valueOf(packageInfo.versionCode));
        }
        int[] iArr = new int[1];
        if (dk(context, downloadInfo, packageInfo)) {
            m10 = context.getPackageManager().getLaunchIntentForPackage(packageInfo.packageName);
        } else {
            if (!z10 && m(context, i10, file)) {
                downloadInfo.getTempCacheData().put("extra_silent_install_succeed", Boolean.TRUE);
                return 1;
            }
            m10 = m(context, downloadInfo, file, z10, iArr);
        }
        if (m10 == null) {
            return iArr[0] == 1 ? 2 : 0;
        }
        m10.addFlags(268435456);
        if (downloadInfo.getLinkMode() > 0 && DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.KEY_APP_INSTALL_RETURN_RESULT, 0) == 1) {
            m10.putExtra("android.intent.extra.RETURN_RESULT", true);
        }
        if (iArr[0] == 0 && dk.m(context, downloadInfo, m10, z10)) {
            return 1;
        }
        return m(context, m10);
    }

    public static String dk() {
        return DownloadUtils.getDownloadPath();
    }

    public static boolean dk(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (!jSONObject.optBoolean("bind_app", false)) {
            if (jSONObject.optBoolean("auto_install_with_notification", true)) {
                return false;
            }
        }
        return true;
    }

    public static String dk(@NonNull Context context) {
        try {
            if (dk == null) {
                NotificationChannel notificationChannel = new NotificationChannel("111111", "channel_appdownloader", 3);
                dk = notificationChannel;
                notificationChannel.setSound(null, null);
                dk.setShowBadge(false);
                ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(dk);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "111111";
    }

    public static int m(Context context, Intent intent) {
        try {
            if (l.oa().r() != null) {
                if (l.oa().r().installApp(intent)) {
                    return 1;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            context.startActivity(intent);
            return 1;
        } catch (Throwable unused2) {
            return 0;
        }
    }

    public static boolean m(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.packageName.equals(downloadInfo.getPackageName())) {
            return false;
        }
        com.ss.android.socialbase.appdownloader.ej.l dk2 = l.oa().dk();
        if (dk2 != null) {
            dk2.m(downloadInfo.getId(), 8, downloadInfo.getPackageName(), packageInfo.packageName, "");
            if (dk2.m()) {
                return true;
            }
        }
        IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (downloadNotificationEventListener == null) {
            return false;
        }
        downloadNotificationEventListener.onNotificationEvent(8, downloadInfo, packageInfo.packageName, "");
        com.ss.android.socialbase.appdownloader.ej.ej m10 = l.oa().m();
        return (m10 instanceof com.ss.android.socialbase.appdownloader.ej.m) && ((com.ss.android.socialbase.appdownloader.ej.m) m10).ej();
    }

    public static boolean m(Context context, int i10, File file) {
        if (DownloadSetting.obtain(i10).optInt("back_miui_silent_install", 1) == 1) {
            return false;
        }
        if ((com.ss.android.socialbase.appdownloader.n.np.sy() || com.ss.android.socialbase.appdownloader.n.np.r()) && SystemUtils.checkServiceExists(context, "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService")) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"));
            Bundle bundle = new Bundle();
            bundle.putInt(as.f32242q, 0);
            bundle.putInt("flag", 256);
            bundle.putString("apkPath", file.getPath());
            bundle.putString("installerPkg", "com.miui.securitycore");
            intent.putExtras(bundle);
            try {
                context.startService(intent);
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static int m() {
        return l.oa().n() ? 16384 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0021 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.net.Uri m(int r1, com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider r2, android.content.Context r3, java.lang.String r4, java.io.File r5) {
        /*
            if (r2 == 0) goto Lb
            java.lang.String r1 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L1e
            android.net.Uri r1 = r2.getUriForFile(r4, r1)     // Catch: java.lang.Throwable -> L1e
            goto L1f
        Lb:
            com.ss.android.socialbase.appdownloader.l r2 = com.ss.android.socialbase.appdownloader.l.oa()
            com.ss.android.socialbase.appdownloader.ej.n r2 = r2.np()
            if (r2 == 0) goto L1e
            java.lang.String r0 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L1e
            android.net.Uri r1 = r2.m(r1, r4, r0)     // Catch: java.lang.Throwable -> L1e
            goto L1f
        L1e:
            r1 = 0
        L1f:
            if (r1 != 0) goto L3b
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L37
            r0 = 24
            if (r2 < r0) goto L32
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L37
            if (r2 != 0) goto L32
            android.net.Uri r1 = androidx.core.content.FileProvider.getUriForFile(r3, r4, r5)     // Catch: java.lang.Throwable -> L37
            goto L3b
        L32:
            android.net.Uri r1 = android.net.Uri.fromFile(r5)     // Catch: java.lang.Throwable -> L37
            goto L3b
        L37:
            r2 = move-exception
            r2.printStackTrace()
        L3b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.ej.m(int, com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider, android.content.Context, java.lang.String, java.io.File):android.net.Uri");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Intent m(Context context, DownloadInfo downloadInfo, @NonNull File file, boolean z10, int[] iArr) {
        Uri m10 = m(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, l.oa().l(), file);
        if (m10 == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(m10, "application/vnd.android.package-archive");
        com.ss.android.socialbase.appdownloader.ej.l dk2 = l.oa().dk();
        int m11 = dk2 != null ? dk2.m(downloadInfo.getId(), z10) : 0;
        IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        int i10 = m11;
        if (downloadNotificationEventListener != null) {
            i10 = downloadNotificationEventListener.interceptAfterNotificationSuccess(z10);
        }
        iArr[0] = i10;
        if (i10 != 0) {
            return null;
        }
        return intent;
    }

    public static boolean m(DownloadInfo downloadInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(downloadInfo.getPackageName()) || !str.equals(downloadInfo.getPackageName())) {
            return !TextUtils.isEmpty(downloadInfo.getName()) && m(DownloadComponentManager.getAppContext(), downloadInfo, str);
        }
        return true;
    }

    public static boolean m(Context context, DownloadInfo downloadInfo, String str) {
        if (context == null) {
            return false;
        }
        try {
            File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            PackageInfo packageInfo = null;
            if (file.exists()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("isPackageNameEqualsWithApk fileName:");
                sb2.append(downloadInfo.getName());
                sb2.append(" apkFileSize：");
                sb2.append(file.length());
                sb2.append(" fileUrl：");
                sb2.append(downloadInfo.getUrl());
                PackageInfo m10 = m(downloadInfo, file);
                if (m10 == null || !m10.packageName.equals(str)) {
                    return false;
                }
                int i10 = m10.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, m());
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (packageInfo == null || i10 != packageInfo.versionCode) {
                    return false;
                }
            } else {
                if (!DownloadSetting.obtain(downloadInfo.getId()).optBugFix("install_callback_error")) {
                    return false;
                }
                String string = DownloadUtils.getString(downloadInfo.getTempCacheData().get("extra_apk_package_name"), null);
                int i11 = DownloadUtils.getInt(downloadInfo.getTempCacheData().get("extra_apk_version_code"), 0);
                if (string == null || TextUtils.isEmpty(string) || !string.equals(str)) {
                    return false;
                }
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, m());
                } catch (PackageManager.NameNotFoundException unused2) {
                }
                if (packageInfo == null || i11 != packageInfo.versionCode) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean m(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo, boolean z10) {
        PackageInfo packageInfo2;
        if (packageInfo == null) {
            return false;
        }
        String str = packageInfo.packageName;
        int i10 = packageInfo.versionCode;
        if (downloadInfo != null) {
            downloadInfo.setAppVersionCode(i10);
        }
        try {
            packageInfo2 = context.getPackageManager().getPackageInfo(str, m());
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo2 = null;
        }
        if (packageInfo2 == null) {
            return false;
        }
        int i11 = packageInfo2.versionCode;
        return z10 ? i10 < i11 : (downloadInfo == null || DownloadSetting.obtain(downloadInfo.getId()).optInt("install_with_same_version_code", 0) != 1) ? i10 <= i11 : i10 < i11;
    }

    public static boolean m(Context context, DownloadInfo downloadInfo) {
        return m(context, downloadInfo, true);
    }

    public static boolean m(Context context, DownloadInfo downloadInfo, boolean z10) {
        if (downloadInfo == null) {
            return false;
        }
        String packageName = downloadInfo.getPackageName();
        int appVersionCode = downloadInfo.getAppVersionCode();
        if (appVersionCode <= 0 && z10) {
            return ej(context, downloadInfo);
        }
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packageName, m());
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (packageInfo == null) {
            return false;
        }
        return DownloadSetting.obtain(downloadInfo.getId()).optInt("install_with_same_version_code", 0) == 1 ? appVersionCode < packageInfo.versionCode : appVersionCode <= packageInfo.versionCode;
    }

    public static PackageInfo m(Context context, DownloadInfo downloadInfo, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str, str2);
        if (!file.exists()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isApkInstalled apkFileSize：fileName:");
        sb2.append(file.getPath());
        sb2.append(" apkFileSize");
        sb2.append(file.length());
        return m(downloadInfo, file);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (android.text.TextUtils.isEmpty(r4) == false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m(java.lang.String r3, java.lang.String r4, java.lang.String r5, boolean r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r1 = ""
            if (r0 == 0) goto L9
            return r1
        L9:
            android.net.Uri r3 = android.net.Uri.parse(r3)
            java.lang.String r0 = "default.apk"
            java.lang.String r2 = ".."
            if (r6 == 0) goto L34
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 == 0) goto L5a
            java.lang.String r4 = r3.getLastPathSegment()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L32
            java.lang.String r4 = r3.getLastPathSegment()
            boolean r4 = r4.contains(r2)
            if (r4 != 0) goto L32
            java.lang.String r4 = r3.getLastPathSegment()
            goto L5a
        L32:
            r4 = r0
            goto L5a
        L34:
            java.lang.String r6 = r3.getLastPathSegment()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L4c
            java.lang.String r6 = r3.getLastPathSegment()
            boolean r6 = r6.contains(r2)
            if (r6 != 0) goto L4c
            java.lang.String r1 = r3.getLastPathSegment()
        L4c:
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 == 0) goto L59
            boolean r3 = android.text.TextUtils.isEmpty(r4)
            if (r3 != 0) goto L32
            goto L5a
        L59:
            r4 = r1
        L5a:
            boolean r3 = ej(r5)
            if (r3 == 0) goto L77
            java.lang.String r3 = ".apk"
            boolean r5 = r4.endsWith(r3)
            if (r5 != 0) goto L77
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            r5.append(r3)
            java.lang.String r4 = r5.toString()
        L77:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.ej.m(java.lang.String, java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    public static String m(String str, DownloadSetting downloadSetting) {
        JSONObject optJSONObject;
        String format;
        if (downloadSetting == null || (optJSONObject = downloadSetting.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR)) == null) {
            return "";
        }
        String optString = optJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME);
        if (!TextUtils.isEmpty(optString) && optString.startsWith("/")) {
            optString = optString.substring(1);
        }
        if (TextUtils.isEmpty(optString)) {
            return optString;
        }
        if (!optString.contains("%s")) {
            format = optString + str;
        } else {
            try {
                format = String.format(optString, str);
            } catch (Throwable unused) {
            }
        }
        optString = format;
        return optString.length() > 255 ? optString.substring(optString.length() - 255) : optString;
    }

    public static boolean m(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return new JSONObject(str).optBoolean("bind_app", false);
    }

    public static int m(int i10) {
        if (i10 == 0) {
            return 0;
        }
        if (i10 == -2) {
            return 2;
        }
        if (i10 == 1) {
            return 4;
        }
        if (DownloadStatus.isDownloading(i10) || i10 == 11) {
            return 1;
        }
        return DownloadStatus.isDownloadOver(i10) ? 3 : 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0037, code lost:
    
        if (r1 != null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m(android.content.Context r6) {
        /*
            r0 = 0
            if (r6 != 0) goto L4
            return r0
        L4:
            r1 = 0
            int r2 = com.ss.android.socialbase.appdownloader.np.dk()     // Catch: java.lang.Throwable -> L37
            android.content.res.Resources r3 = r6.getResources()     // Catch: java.lang.Throwable -> L37
            int r2 = r3.getColor(r2)     // Catch: java.lang.Throwable -> L37
            int r3 = com.ss.android.socialbase.appdownloader.np.ej()     // Catch: java.lang.Throwable -> L37
            int r4 = com.ss.android.socialbase.appdownloader.np.l()     // Catch: java.lang.Throwable -> L37
            r5 = 2
            int[] r5 = new int[r5]     // Catch: java.lang.Throwable -> L37
            r5[r0] = r3     // Catch: java.lang.Throwable -> L37
            r3 = 1
            r5[r3] = r4     // Catch: java.lang.Throwable -> L37
            int r4 = com.ss.android.socialbase.appdownloader.np.np()     // Catch: java.lang.Throwable -> L37
            android.content.res.TypedArray r1 = r6.obtainStyledAttributes(r4, r5)     // Catch: java.lang.Throwable -> L37
            int r6 = r1.getColor(r0, r0)     // Catch: java.lang.Throwable -> L37
            if (r2 != r6) goto L33
            r1.recycle()     // Catch: java.lang.Throwable -> L32
        L32:
            return r3
        L33:
            r1.recycle()     // Catch: java.lang.Throwable -> L3a
            goto L3a
        L37:
            if (r1 == 0) goto L3a
            goto L33
        L3a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.ej.m(android.content.Context):boolean");
    }

    public static void m(DownloadInfo downloadInfo, boolean z10, boolean z11) {
        l.oa().m(new n(DownloadComponentManager.getAppContext(), downloadInfo.getUrl()).m(downloadInfo.getTitle()).dk(downloadInfo.getName()).ej(downloadInfo.getSavePath()).m(downloadInfo.isShowNotification()).dk(downloadInfo.isAutoInstallWithoutNotification()).ej(downloadInfo.isOnlyWifi() || z11).np(downloadInfo.getExtra()).n(downloadInfo.getMimeType()).m(downloadInfo.getExtraHeaders()).np(true).dk(downloadInfo.getRetryCount()).ej(downloadInfo.getBackUpUrlRetryCount()).dk(downloadInfo.getBackUpUrls()).l(downloadInfo.getMinProgressTimeMsInterval()).np(downloadInfo.getMaxProgressCount()).n(z10).l(downloadInfo.isNeedHttpsToHttpRetry()).hc(downloadInfo.getPackageName()).e(downloadInfo.getMd5()).m(downloadInfo.getExpectFileLength()).w(downloadInfo.isNeedDefaultHttpServiceBackUp()).oa(downloadInfo.isNeedReuseFirstConnection()).ve(downloadInfo.isNeedIndependentProcess()).m(downloadInfo.getEnqueueType()).r(downloadInfo.isForce()).sy(downloadInfo.isHeadConnectionAvailable()).hc(downloadInfo.isNeedRetryDelay()).w(downloadInfo.getRetryDelayTimeArray()).m(l(downloadInfo.getDownloadSettingString())).c(downloadInfo.getIconUrl()).n(downloadInfo.getExecutorGroup()).k(downloadInfo.isAutoInstall()));
    }

    public static void m(Activity activity) {
        if (activity != null) {
            try {
                if (activity.isFinishing()) {
                    return;
                }
                activity.finish();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static PackageInfo m(DownloadInfo downloadInfo, File file) {
        if (downloadInfo == null) {
            return com.ss.android.socialbase.appdownloader.n.m.np.m(DownloadComponentManager.getAppContext(), file, m());
        }
        PackageInfo packageInfo = downloadInfo.getPackageInfo();
        if (packageInfo != null) {
            return packageInfo;
        }
        PackageInfo m10 = com.ss.android.socialbase.appdownloader.n.m.np.m(DownloadComponentManager.getAppContext(), file, m());
        downloadInfo.setPackageInfo(m10);
        return m10;
    }

    public static int m(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
