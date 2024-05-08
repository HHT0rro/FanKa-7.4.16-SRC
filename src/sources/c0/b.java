package c0;

import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class b {
    public static String a(String str) {
        String str2;
        try {
            str2 = f.a(str);
        } catch (Throwable unused) {
            str2 = "";
        }
        if (!z.a.d(str2)) {
            return str2;
        }
        return c.a(".SystemConfig" + File.separator + str);
    }
}
