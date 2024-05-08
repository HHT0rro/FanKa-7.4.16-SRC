package com.ss.android.socialbase.appdownloader.n.m;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class np {
    private static PackageInfo dk(@NonNull Context context, @NonNull File file, int i10) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            m("unzip_getpackagearchiveinfo", "packageManager == null");
            return null;
        }
        try {
            return packageManager.getPackageArchiveInfo(file.getPath(), i10);
        } catch (Throwable th) {
            m("unzip_getpackagearchiveinfo", "pm.getPackageArchiveInfo failed: " + th.getMessage());
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:150:0x006a, code lost:
    
        r13 = r1.getInputStream(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x006e, code lost:
    
        r4 = r1;
        r5 = r2;
        r1 = null;
        r13 = r13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v16, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.zip.ZipInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.pm.PackageInfo m(@androidx.annotation.NonNull java.io.File r13) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.n.m.np.m(java.io.File):android.content.pm.PackageInfo");
    }

    private static String m(int i10) {
        return (i10 >>> 24) == 1 ? "android:" : "";
    }

    public static PackageInfo m(@NonNull Context context, @NonNull File file, int i10) {
        if (DownloadExpSwitchCode.isSwitchEnable(268435456) && Build.VERSION.SDK_INT < 26) {
            try {
                return m(file);
            } catch (Throwable th) {
                m("getPackageInfo::unzip_getpackagearchiveinfo", th.getMessage());
                return dk(context, file, i10);
            }
        }
        return dk(context, file, i10);
    }

    private static void m(@NonNull String str, @NonNull String str2) {
        IDownloadMonitorListener downloadMonitorListener = DownloadComponentManager.getDownloadMonitorListener();
        if (downloadMonitorListener == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("message", str2);
        } catch (JSONException unused) {
        }
        downloadMonitorListener.monitorEvent(str, jSONObject, null, null);
    }

    private static String m(m mVar, int i10) {
        int dk = mVar.dk(i10);
        int ej = mVar.ej(i10);
        if (dk == 3) {
            return mVar.l(i10);
        }
        return dk == 2 ? String.format("?%s%08X", m(ej), Integer.valueOf(ej)) : (dk < 16 || dk > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(ej), Integer.valueOf(dk)) : String.valueOf(ej);
    }

    public static String m(Context context, PackageInfo packageInfo, String str) {
        ApplicationInfo applicationInfo;
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
            return null;
        }
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        try {
            return applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (OutOfMemoryError e2) {
            m("getPackageInfo::fail_load_label", e2.getMessage());
            return null;
        }
    }
}
