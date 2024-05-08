package com.ss.android.socialbase.appdownloader.n;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Process;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class n {

    /* renamed from: m, reason: collision with root package name */
    private static Boolean f38944m;

    public static boolean dk() {
        if (l() == 0) {
            return true;
        }
        return np();
    }

    public static boolean ej(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return registerReceiver != null && registerReceiver.getIntExtra("plugged", -1) == 2;
    }

    private static int l() {
        String str = null;
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, m("726f2e736563757265"));
            if (invoke != null) {
                str = (String) invoke;
            }
        } catch (Exception unused) {
        }
        return (str != null && "0".equals(str)) ? 0 : 1;
    }

    public static boolean m() {
        Boolean bool = f38944m;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    private static boolean n() {
        try {
            HashSet<String> hashSet = new HashSet();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/maps"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.endsWith(".so") || readLine.endsWith(".jar")) {
                    hashSet.add(readLine.substring(readLine.lastIndexOf(" ") + 1));
                }
            }
            bufferedReader.close();
            for (String str : hashSet) {
                if (str.contains(m("636f6d2e73617572696b2e737562737472617465")) || str.contains(m("58706f7365644272696467652e6a6172")) || str.contains(m("6c696273616e64686f6f6b2e656478702e736f"))) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean np() {
        String[] strArr = {m("2f7362696e2f7375"), m("2f73797374656d2f62696e2f7375"), m("2f73797374656d2f7862696e2f7375"), m("2f646174612f6c6f63616c2f7862696e2f7375"), m("2f646174612f6c6f63616c2f62696e2f7375"), m("2f73797374656d2f73642f7862696e2f7375"), m("2f73797374656d2f62696e2f6661696c736166652f7375"), m("2f646174612f6c6f63616c2f7375")};
        for (int i10 = 0; i10 < 8; i10++) {
            if (new File(strArr[i10]).exists()) {
                return true;
            }
        }
        return false;
    }

    @WorkerThread
    public static synchronized void m(@NonNull Context context) {
        synchronized (n.class) {
            if (f38944m == null) {
                f38944m = Boolean.valueOf((dk() || dk(context) || ej(context) || !l(context) || ej() || np(context)) ? false : true);
            }
        }
    }

    public static boolean dk(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    @WorkerThread
    public static boolean ej() {
        try {
            InetAddress.getByName(m("3132372e302e302e31"));
            new Socket(m("3132372e302e302e31"), Integer.parseInt(m("3237303432")));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean l(Context context) {
        try {
            int simState = ((TelephonyManager) context.getSystemService("phone")).getSimState();
            return (simState == 1 || simState == 0) ? false : true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String m(@NonNull String str) {
        return DownloadUtils.hexToString(str);
    }

    @WorkerThread
    public static boolean np(Context context) {
        return n() || n(context);
    }

    private static boolean n(Context context) {
        List asList = Arrays.asList(m("64652e726f62762e616e64726f69642e78706f736564"), m("636f6d2e746f706a6f686e77752e6d616769736b"), m("696f2e76612e6578706f736564"), m("636f6d2e77696e642e636f74746572"), m("6f72672e6d656f776361742e656478706f7365642e6d616e61676572"), m("6d652e7765697368752e657870"), m("636f6d2e73617572696b2e737562737472617465"));
        PackageManager packageManager = context.getPackageManager();
        Iterator iterator2 = asList.iterator2();
        while (iterator2.hasNext()) {
            try {
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
            if (packageManager.getPackageInfo((String) iterator2.next(), 0) != null) {
                return true;
            }
        }
        return false;
    }
}
