package bc;

import android.content.Context;
import android.os.Build;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {
    public static String a() {
        return Build.MANUFACTURER.toUpperCase();
    }

    public static void b(Context context, String str, String str2, String str3) {
        if (str3 == null) {
            str3 = "";
        }
        try {
            c.c(context);
            c.a().d(str + "-" + str2, str3);
        } catch (Exception unused) {
        }
    }
}
