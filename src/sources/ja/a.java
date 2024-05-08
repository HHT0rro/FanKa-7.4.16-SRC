package ja;

import com.huawei.secure.android.common.util.SafeString;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {
    public static String a(CharSequence charSequence, boolean z10) {
        return b(charSequence, z10, "is", MonitorConstants.CONNECT_TYPE_GET);
    }

    public static String b(CharSequence charSequence, boolean z10, String str, String str2) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String charSequence2 = charSequence.toString();
        if (!z10 || !charSequence2.startsWith("is") || charSequence.length() <= 2 || Character.isLowerCase(charSequence.charAt(2))) {
            if (!z10) {
                str = str2;
            }
            return c(str, charSequence2);
        }
        return str + SafeString.substring(charSequence2, 2);
    }

    public static String c(String str, String str2) {
        if (str2.length() == 0) {
            return str;
        }
        if (str.length() == 0) {
            return str2;
        }
        char charAt = str2.charAt(0);
        if (Character.isLowerCase(charAt)) {
            if (str2.length() > 1 && Character.isUpperCase(str2.charAt(1))) {
                return String.format(Locale.ENGLISH, "%s%s", str, str2);
            }
            boolean z10 = str2.length() > 2 && (Character.isTitleCase(str2.charAt(1)) || Character.isUpperCase(str2.charAt(1)));
            Locale locale = Locale.ENGLISH;
            Object[] objArr = new Object[2];
            objArr[0] = Character.valueOf(z10 ? Character.toUpperCase(charAt) : Character.toTitleCase(charAt));
            objArr[1] = str2.subSequence(1, str2.length());
            str2 = String.format(locale, "%s%s", objArr);
        }
        return String.format(Locale.ENGLISH, "%s%s", str, str2);
    }
}
