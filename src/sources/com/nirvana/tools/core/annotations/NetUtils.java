package com.nirvana.tools.core.annotations;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.annotation.RequiresPermission;
import com.kuaishou.weapon.p0.g;
import com.nirvana.tools.core.SupportJarUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class NetUtils {
    @RequiresPermission(g.f36116b)
    public static boolean hasConnectivity(Context context) {
        NetworkInfo networkInfo;
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (SupportJarUtils.checkSelfPermission(context, g.f36116b) == 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                Network activeNetwork = connectivityManager.getActiveNetwork();
                return (activeNetwork == null || (networkInfo = connectivityManager.getNetworkInfo(activeNetwork)) == null || !networkInfo.isConnected()) ? false : true;
            }
            NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
            if (allNetworkInfo == null) {
                return false;
            }
            for (NetworkInfo networkInfo2 : allNetworkInfo) {
                if (networkInfo2 != null && networkInfo2.isAvailable() && networkInfo2.isConnected()) {
                    return true;
                }
            }
        }
        return false;
    }
}
