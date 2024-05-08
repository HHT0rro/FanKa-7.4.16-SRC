package ra;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f53327a = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i10 = 1;
        if (1 == length) {
            return String.valueOf('*');
        }
        StringBuilder sb2 = new StringBuilder(length);
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            if (f53327a.matcher(String.valueOf(charAt)).matches()) {
                if (i10 % 2 == 0) {
                    charAt = '*';
                }
                i10++;
            }
            sb2.append(charAt);
        }
        return sb2.toString();
    }

    public static String b(String str, boolean z10) {
        StringBuilder sb2 = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            if (z10) {
                sb2.append(a(str));
            } else {
                sb2.append(str);
            }
        }
        return sb2.toString();
    }

    public static void c(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        f(str);
        b(str2, false);
    }

    public static void d(String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        f(str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(" , throwable message : ");
        sb2.append(th.getMessage());
    }

    public static void e(String str, String str2, boolean z10) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        f(str);
        b(str2, z10);
    }

    public static String f(String str) {
        return "SecurityComp10200303: " + str;
    }

    public static void g(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        f(str);
        b(str2, false);
    }
}
