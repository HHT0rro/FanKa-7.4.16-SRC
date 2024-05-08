package g7;

import android.content.SharedPreferences;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b extends a<Boolean> {
    public static Boolean a(SharedPreferences sharedPreferences, String str, Boolean bool) {
        try {
            return (Boolean) j7.c.a(new c(sharedPreferences, str, bool));
        } catch (Exception e2) {
            String valueOf = String.valueOf(e2.getMessage());
            if (valueOf.length() != 0) {
                "Flag value not available, returning default: ".concat(valueOf);
            }
            return bool;
        }
    }
}
