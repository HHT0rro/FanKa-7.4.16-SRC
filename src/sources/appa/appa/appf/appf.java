package appa.appa.appf;

import android.os.Build;
import android.text.TextUtils;
import com.hailiang.advlib.core.ADEvent;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: PhoneBrandCheckerUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appf {

    /* renamed from: appa, reason: collision with root package name */
    private static final String f1017appa = "appf";

    public static boolean appa() {
        if (!appa("huawei") && !appa("honor")) {
            return false;
        }
        appd.appe(f1017appa, "Found brand \"HUAWEI\"");
        return true;
    }

    public static boolean appb() {
        if (!appa("oppo")) {
            return false;
        }
        appd.appe(f1017appa, "Found brand \"OPPO\"");
        return true;
    }

    public static boolean appc() {
        if (!appa(ADEvent.VIVO)) {
            return false;
        }
        appd.appe(f1017appa, "Found brand \"VIVO\"");
        return true;
    }

    public static boolean appa(String str) {
        String str2 = Build.MANUFACTURER;
        String str3 = Build.FINGERPRINT;
        String str4 = Build.BRAND;
        if (!TextUtils.isEmpty(str4) && str4.toLowerCase().contains(str)) {
            return true;
        }
        if (TextUtils.isEmpty(str2) || !str2.toLowerCase().contains(str)) {
            return !TextUtils.isEmpty(str3) && str3.toLowerCase().contains(str);
        }
        return true;
    }
}
