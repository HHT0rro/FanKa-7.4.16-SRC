package com.ss.android.downloadlib.hc;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.ss.android.download.api.config.q;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ve {
    private static Object[] dk = new Object[0];
    private static Object[] ej = new Object[73];

    /* renamed from: m, reason: collision with root package name */
    public static final char[] f38782m = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: l, reason: collision with root package name */
    private static String f38781l = null;

    public static boolean dk(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static Signature[] e(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null) {
                return packageInfo.signatures;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String ej(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            return packageInfo != null ? packageInfo.versionName : "";
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static Intent hc(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    public static Drawable l(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                return packageManager.getApplicationInfo(str, 0).loadIcon(packageManager);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }

    public static boolean m(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean n(Context context, String str) {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) == null) {
                return false;
            }
            String str2 = packageArchiveInfo.packageName;
            int i10 = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return i10 <= packageInfo.versionCode;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean np(Context context, String str) {
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.c.getContext();
        }
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static File oa(Context context, String str) {
        File parentFile = context.getExternalFilesDir(null).getParentFile();
        File file = new File((parentFile != null ? parentFile.getParent() : null) + File.separator + str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getExtDir: file.toString()-->");
        sb2.append(file.toString());
        Logger.d("ToolUtils", sb2.toString());
        return file;
    }

    public static Signature[] w(Context context, String str) {
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 64);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.signatures;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static int dk(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return -1;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public static long m(JSONObject jSONObject, String str) {
        return com.ss.android.download.api.ej.dk.m(jSONObject, str);
    }

    @WorkerThread
    public static boolean ej(String str) {
        File file;
        Context context = com.ss.android.downloadlib.addownload.c.getContext();
        if (TextUtils.isEmpty(str) || !np(context, str)) {
            return false;
        }
        int i10 = context.getApplicationInfo().targetSdkVersion;
        if (com.ss.android.downloadlib.addownload.c.w().optInt("get_ext_dir_mode") == 0 && Build.VERSION.SDK_INT >= 29 && ((i10 == 29 && !Environment.isExternalStorageLegacy()) || i10 > 29)) {
            return true;
        }
        try {
            if (Build.VERSION.SDK_INT >= 29 && context.getApplicationInfo().targetSdkVersion >= 29 && com.ss.android.downloadlib.addownload.c.w().optInt("get_ext_dir_mode") == 1) {
                file = oa(context, str);
            } else {
                file = new File(Environment.getExternalStorageDirectory().getPath(), "android/data/" + str);
            }
            if (!file.exists()) {
                return false;
            }
            long m10 = hc.m(file);
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                if (packageInfo.lastUpdateTime < m10) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public static JSONObject m(JSONObject jSONObject, JSONObject jSONObject2) {
        return com.ss.android.download.api.ej.dk.m(jSONObject, jSONObject2);
    }

    @NonNull
    public static JSONObject m(JSONObject jSONObject) {
        return com.ss.android.download.api.ej.dk.m(jSONObject);
    }

    @NonNull
    public static JSONObject m(JSONObject... jSONObjectArr) {
        return com.ss.android.download.api.ej.dk.m(jSONObjectArr);
    }

    public static boolean dk(com.ss.android.downloadad.api.m.dk dkVar) {
        if (dkVar == null) {
            return false;
        }
        return m(dkVar.np(), dkVar.b(), dkVar.lf()).m();
    }

    public static boolean m(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (queryIntentActivities != null) {
                return !queryIntentActivities.isEmpty();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean dk(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.c.getContext();
        }
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    public static String m(long j10) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (j10 >= 1073741824) {
            return (j10 / 1073741824) + "G";
        }
        if (j10 >= 1048576) {
            return (j10 / 1048576) + "M";
        }
        return decimalFormat.format(((float) j10) / 1048576.0f) + "M";
    }

    public static long dk(long j10) {
        try {
            return m(Environment.getExternalStorageDirectory(), j10);
        } catch (Exception e2) {
            e2.printStackTrace();
            return j10;
        }
    }

    public static boolean dk() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static PackageInfo m(com.ss.android.downloadad.api.m.dk dkVar) {
        DownloadInfo downloadInfo;
        if (dkVar == null || (downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.c.getContext()).getDownloadInfo(dkVar.x())) == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.appdownloader.ej.m(com.ss.android.downloadlib.addownload.c.getContext(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        } catch (Throwable unused) {
            return null;
        }
    }

    @NonNull
    public static HashMap<String, String> dk(JSONObject jSONObject) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.optString(next));
                }
                return hashMap;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return hashMap;
    }

    public static Drawable m(Context context, String str) {
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        if (context != null && !TextUtils.isEmpty(str) && (packageArchiveInfo = (packageManager = context.getPackageManager()).getPackageArchiveInfo(str, 0)) != null) {
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            try {
                return applicationInfo.loadIcon(packageManager);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static void ej() {
        try {
            if (com.ss.android.downloadlib.addownload.c.np().m(com.ss.android.downloadlib.addownload.c.getContext(), "android.permission.REORDER_TASKS")) {
                ActivityManager activityManager = (ActivityManager) com.ss.android.downloadlib.addownload.c.getContext().getSystemService("activity");
                for (ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(20)) {
                    if (com.ss.android.downloadlib.addownload.c.getContext().getPackageName().equals(runningTaskInfo.topActivity.getPackageName())) {
                        activityManager.moveTaskToFront(runningTaskInfo.id, 1);
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static com.ss.android.downloadlib.addownload.dk.ej m(String str, int i10, String str2) {
        com.ss.android.downloadlib.addownload.dk.ej ejVar = new com.ss.android.downloadlib.addownload.dk.ej();
        if (TextUtils.isEmpty(str)) {
            return ejVar;
        }
        try {
            PackageInfo packageInfo = com.ss.android.downloadlib.addownload.c.getContext().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                ejVar.dk(packageInfo.versionCode);
                ejVar.m(com.ss.android.downloadlib.addownload.dk.ej.dk);
                q hc2 = com.ss.android.downloadlib.addownload.c.hc();
                if (hc2 != null && hc2.m() && !m(packageInfo.versionCode, i10, packageInfo.versionName, str2)) {
                    ejVar.m(com.ss.android.downloadlib.addownload.dk.ej.ej);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return ejVar;
    }

    private static boolean m(int i10, int i11, String str, String str2) {
        if (i11 == 0 && TextUtils.isEmpty(str2)) {
            return true;
        }
        return (i11 > 0 && i10 >= i11) || m(str, str2) >= 0;
    }

    public static boolean m(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return false;
        }
        return m(downloadModel.getPackageName(), downloadModel.getVersionCode(), downloadModel.getVersionName()).m();
    }

    public static boolean m(Context context, String str, String str2) {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) == null || !packageArchiveInfo.packageName.equals(str2)) {
                return false;
            }
            int i10 = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return i10 == packageInfo.versionCode;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean m(Signature[] signatureArr, Signature[] signatureArr2) {
        if (signatureArr == signatureArr2) {
            return true;
        }
        if (signatureArr == null || signatureArr2 == null || signatureArr.length != signatureArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < signatureArr.length; i10++) {
            if ((signatureArr[i10] == null && signatureArr2[i10] != null) || (signatureArr[i10] != null && !signatureArr[i10].equals(signatureArr2[i10]))) {
                return false;
            }
        }
        return true;
    }

    public static int m(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String m(String str, int i10) {
        return i10 == 0 ? "" : (TextUtils.isEmpty(str) || str.length() <= i10) ? str : str.substring(0, i10);
    }

    public static int m(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (str.equals(str2)) {
                    return 0;
                }
                String[] split = str.split("\\.");
                String[] split2 = str2.split("\\.");
                int min = Math.min(split.length, split2.length);
                int i10 = 0;
                int i11 = 0;
                while (i10 < min) {
                    i11 = Integer.parseInt(split[i10]) - Integer.parseInt(split2[i10]);
                    if (i11 != 0) {
                        break;
                    }
                    i10++;
                }
                if (i11 != 0) {
                    return i11 > 0 ? 1 : -1;
                }
                for (int i12 = i10; i12 < split.length; i12++) {
                    if (Integer.parseInt(split[i12]) > 0) {
                        return 1;
                    }
                }
                while (i10 < split2.length) {
                    if (Integer.parseInt(split2[i10]) > 0) {
                        return -1;
                    }
                    i10++;
                }
                return 0;
            }
        } catch (Exception unused) {
        }
        return -2;
    }

    public static String m(String... strArr) {
        return com.ss.android.download.api.ej.dk.m(strArr);
    }

    @NonNull
    public static <T> T m(T... tArr) {
        if (tArr != null) {
            for (T t2 : tArr) {
                if (t2 != null) {
                    return t2;
                }
            }
            throw new IllegalArgumentException("args is null");
        }
        throw new IllegalArgumentException("args is null");
    }

    public static boolean m() {
        try {
            if (com.ss.android.downloadlib.addownload.c.getContext().getPackageManager().getPackageInfo(com.ss.android.downloadlib.addownload.c.getContext().getPackageName(), 0).applicationInfo.targetSdkVersion == 33) {
                return Build.VERSION.SDK_INT == 33;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static long m(File file, long j10) {
        if (file == null) {
            return j10;
        }
        try {
            return DownloadUtils.getAvailableSpaceBytes(file.getAbsolutePath());
        } catch (Exception e2) {
            e2.printStackTrace();
            return j10;
        }
    }

    public static long m(File file) {
        if (file == null) {
            return -1L;
        }
        try {
            return new StatFs(file.getAbsolutePath()).getTotalBytes();
        } catch (Throwable th) {
            th.printStackTrace();
            return -1L;
        }
    }

    public static void m(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.putOpt(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
