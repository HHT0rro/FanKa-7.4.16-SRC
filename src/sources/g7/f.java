package g7;

import android.content.SharedPreferences;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class f extends a<Long> {
    public static Long a(SharedPreferences sharedPreferences, String str, Long l10) {
        try {
            return (Long) j7.c.a(new g(sharedPreferences, str, l10));
        } catch (Exception e2) {
            String valueOf = String.valueOf(e2.getMessage());
            if (valueOf.length() != 0) {
                "Flag value not available, returning default: ".concat(valueOf);
            }
            return l10;
        }
    }
}
