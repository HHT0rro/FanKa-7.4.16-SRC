package ac;

import android.content.Context;
import android.content.SharedPreferences;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f735a = Boolean.TRUE;

    public static String a() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        return nextElement.getHostAddress();
                    }
                }
            }
            return null;
        } catch (SocketException unused) {
            return null;
        }
    }

    public static String b(Context context, String str, String str2) {
        try {
            String e2 = e(context, str, str2);
            if (m.a(e2).booleanValue()) {
                return k.a(context, e2);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void c(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("cuAuthCacheName", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        for (String str : sharedPreferences.getAll().h()) {
            if (str.startsWith("accessCode")) {
                edit.remove(str);
            }
        }
        edit.commit();
    }

    public static boolean d(Context context, String str, String str2, String str3) {
        if (!m.a(str3).booleanValue()) {
            return false;
        }
        String e2 = e(context, str, str2);
        if (m.a(e2).booleanValue()) {
            return k.c(context, e2, str3);
        }
        return false;
    }

    public static String e(Context context, String str, String str2) {
        String c4 = j.c(context);
        String a10 = a();
        if (!m.a(a10).booleanValue()) {
            return null;
        }
        return "accessCode" + c4 + a10 + str + str2;
    }
}
