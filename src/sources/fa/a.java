package fa;

import android.util.Log;
import com.huawei.openalliance.ad.constant.u;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {
    public static int a(String str, String str2) {
        if (!b.a()) {
            return -1;
        }
        return Log.d("MarketInstallService", str + u.bD + str2);
    }

    public static int b(String str, String str2, Throwable th) {
        if (!b.c()) {
            return -1;
        }
        return Log.e("MarketInstallService", str + u.bD + str2, th);
    }

    public static int c(String str, String str2) {
        if (!b.c()) {
            return -1;
        }
        return Log.e("MarketInstallService", str + u.bD + str2);
    }

    public static int d(String str, String str2) {
        if (!b.b()) {
            return -1;
        }
        return Log.i("MarketInstallService", str + u.bD + str2);
    }

    public static int e(String str, String str2) {
        if (!b.c()) {
            return -1;
        }
        return Log.w("MarketInstallService", str + u.bD + str2);
    }
}
