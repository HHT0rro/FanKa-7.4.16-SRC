package ga;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static ConnectivityManager f49424a;

    public static int a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isConnected()) {
            int type = networkInfo.getType();
            if (1 == type || 13 == type) {
                return 1;
            }
            if (type == 0) {
                switch (networkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return 3;
                    case 13:
                        return 4;
                }
            }
        }
        return 0;
    }

    public static NetworkInfo b(Context context) {
        ConnectivityManager c4 = c(context);
        if (c4 != null) {
            return c4.getActiveNetworkInfo();
        }
        return null;
    }

    public static ConnectivityManager c(Context context) {
        if (f49424a == null) {
            f49424a = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        }
        return f49424a;
    }

    public static int d(Context context) {
        return a(b(context));
    }

    public static boolean e(Context context) {
        ConnectivityManager c4;
        NetworkInfo activeNetworkInfo;
        return (context == null || (c4 = c(context)) == null || (activeNetworkInfo = c4.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) ? false : true;
    }
}
