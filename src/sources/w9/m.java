package w9;

import android.util.Log;
import com.huawei.openalliance.ad.constant.u;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class m {
    public static int a(String str, String str2) {
        return -1;
    }

    public static int b(String str, String str2, Throwable th) {
        return Log.e("CoreServiceSDK", str + u.bD + str2, th);
    }

    public static int c(String str, String str2) {
        return Log.e("CoreServiceSDK", str + u.bD + str2);
    }

    public static int d(String str, String str2) {
        return Log.i("CoreServiceSDK", str + u.bD + str2);
    }

    public static int e(String str, String str2) {
        return Log.w("CoreServiceSDK", str + u.bD + str2);
    }
}
