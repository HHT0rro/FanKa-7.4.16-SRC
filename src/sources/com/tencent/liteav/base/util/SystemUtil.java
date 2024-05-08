package com.tencent.liteav.base.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;
import android.view.Display;
import androidx.annotation.NonNull;
import com.android.internal.logging.nano.MetricsProto;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SystemUtil {
    private static final String TAG = "SystemUtil";
    private static boolean mFirstTimeRun;
    private static final a<CpuUsageMeasurer> sCpuUsageMeasurer = new a<>(u.b());

    public static Display getDisplay() {
        return j.a().d();
    }

    @CalledByNative
    public static int getDisplayRotationDegree() {
        return j.a().c().mValue;
    }

    @NonNull
    @CalledByNative
    public static Size getDisplaySize() {
        try {
            Display display = getDisplay();
            if (display != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                display.getRealMetrics(displayMetrics);
                return new Size(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
        } catch (Exception e2) {
            LiteavLog.e(TAG, "get display size failed.", e2);
        }
        return new Size(MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_RECEIVE_WAP_PUSH, 1280);
    }

    public static int[] getProcessCPURate() {
        if (mFirstTimeRun) {
            mFirstTimeRun = false;
            sCpuUsageMeasurer.a();
            CpuUsageMeasurer.a();
            return new int[]{0, 0};
        }
        sCpuUsageMeasurer.a();
        return CpuUsageMeasurer.a();
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnectedOrConnecting()) ? false : true;
    }
}
