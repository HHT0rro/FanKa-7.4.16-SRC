package ac;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class l {
    public static String a(Context context, String str) {
        try {
            return context.getSharedPreferences("cu_auth", 0).getString(str, "");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static void b(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("cu_auth", 0).edit();
            edit.putString(str, str2);
            edit.commit();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
