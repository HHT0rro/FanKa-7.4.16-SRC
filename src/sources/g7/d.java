package g7;

import android.content.SharedPreferences;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d extends a<Integer> {
    public static Integer a(SharedPreferences sharedPreferences, String str, Integer num) {
        try {
            return (Integer) j7.c.a(new e(sharedPreferences, str, num));
        } catch (Exception e2) {
            String valueOf = String.valueOf(e2.getMessage());
            if (valueOf.length() != 0) {
                "Flag value not available, returning default: ".concat(valueOf);
            }
            return num;
        }
    }
}
