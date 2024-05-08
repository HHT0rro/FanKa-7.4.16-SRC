package g7;

import android.content.SharedPreferences;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h extends a<String> {
    public static String a(SharedPreferences sharedPreferences, String str, String str2) {
        try {
            return (String) j7.c.a(new i(sharedPreferences, str, str2));
        } catch (Exception e2) {
            String valueOf = String.valueOf(e2.getMessage());
            if (valueOf.length() != 0) {
                "Flag value not available, returning default: ".concat(valueOf);
            }
            return str2;
        }
    }
}
