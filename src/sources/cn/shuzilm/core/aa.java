package cn.shuzilm.core;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class aa {
    public static byte[] b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr, 0, 1024);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable unused) {
                }
                return byteArray;
            } catch (Throwable unused2) {
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable unused3) {
                    }
                }
                return null;
            }
        } catch (Throwable unused4) {
            byteArrayOutputStream = null;
        }
    }

    public static boolean i(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                if (type == 1) {
                    return true;
                }
                if (type == 0) {
                    return false;
                }
            }
            if (Build.VERSION.SDK_INT >= 23) {
                if (connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork()).hasTransport(1)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static int p(Context context) {
        try {
            DhcpInfo dhcpInfo = ((WifiManager) context.getSystemService("wifi")).getDhcpInfo();
            if (dhcpInfo != null) {
                return dhcpInfo.ipAddress;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public static boolean p(Context context, String str) {
        return (context == null || str == null || context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) ? false : true;
    }
}
