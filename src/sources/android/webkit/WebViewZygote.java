package android.webkit;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.ChildZygoteProcess;
import android.os.Process;
import android.os.ZygoteProcess;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.os.Zygote;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class WebViewZygote {
    private static final String LOGTAG = "WebViewZygote";
    private static final Object sLock = new Object();
    private static boolean sMultiprocessEnabled = false;
    private static PackageInfo sPackage;
    private static ChildZygoteProcess sZygote;

    public static ZygoteProcess getProcess() {
        synchronized (sLock) {
            ChildZygoteProcess childZygoteProcess = sZygote;
            if (childZygoteProcess != null) {
                return childZygoteProcess;
            }
            connectToZygoteIfNeededLocked();
            return sZygote;
        }
    }

    public static String getPackageName() {
        String str;
        synchronized (sLock) {
            str = sPackage.packageName;
        }
        return str;
    }

    public static boolean isMultiprocessEnabled() {
        boolean z10;
        synchronized (sLock) {
            z10 = sMultiprocessEnabled && sPackage != null;
        }
        return z10;
    }

    public static void setMultiprocessEnabled(boolean enabled) {
        synchronized (sLock) {
            sMultiprocessEnabled = enabled;
            if (!enabled) {
                stopZygoteLocked();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void onWebViewProviderChanged(PackageInfo packageInfo) {
        synchronized (sLock) {
            sPackage = packageInfo;
            if (sMultiprocessEnabled) {
                stopZygoteLocked();
            }
        }
    }

    private static void stopZygoteLocked() {
        ChildZygoteProcess childZygoteProcess = sZygote;
        if (childZygoteProcess != null) {
            childZygoteProcess.close();
            Process.killProcess(sZygote.getPid());
            sZygote = null;
        }
    }

    private static void connectToZygoteIfNeededLocked() {
        if (sZygote != null) {
            return;
        }
        PackageInfo packageInfo = sPackage;
        if (packageInfo == null) {
            Log.e(LOGTAG, "Cannot connect to zygote, no package specified");
            return;
        }
        try {
            String abi = packageInfo.applicationInfo.primaryCpuAbi;
            int runtimeFlags = Zygote.getMemorySafetyRuntimeFlagsForSecondaryZygote(sPackage.applicationInfo, null);
            ChildZygoteProcess startChildZygote = Process.ZYGOTE_PROCESS.startChildZygote("com.android.internal.os.WebViewZygoteInit", "webview_zygote", 1053, 1053, (int[]) null, runtimeFlags, "webview_zygote", abi, TextUtils.join(",", Build.SUPPORTED_ABIS), (String) null, 99000, Integer.MAX_VALUE);
            sZygote = startChildZygote;
            ZygoteProcess.waitForConnectionToZygote(startChildZygote.getPrimarySocketAddress());
            sZygote.preloadApp(sPackage.applicationInfo, abi);
        } catch (Exception e2) {
            Log.e(LOGTAG, "Error connecting to webview zygote", e2);
            stopZygoteLocked();
        }
    }
}
