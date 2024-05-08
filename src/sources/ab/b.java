package ab;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import com.huawei.secure.android.common.util.LogsUtil;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b {
    public static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return !URLUtil.isNetworkUrl(str) ? str : b(str);
        }
        LogsUtil.f("UriUtil", "whiteListUrl is null");
        return null;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            LogsUtil.f("UriUtil", "url is null");
            return str;
        }
        try {
            if (!URLUtil.isNetworkUrl(str)) {
                LogsUtil.d("UriUtil", "url don't starts with http or https");
                return "";
            }
            return new URL(str.replaceAll("[\\\\#]", "/")).getHost();
        } catch (MalformedURLException e2) {
            LogsUtil.d("UriUtil", "getHostByURI error  MalformedURLException : " + e2.getMessage());
            return "";
        }
    }

    public static boolean c(String str, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str2 : strArr) {
                if (d(str, str2)) {
                    return true;
                }
            }
            return false;
        }
        LogsUtil.d("UriUtil", "whitelist is null");
        return false;
    }

    public static boolean d(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.contains("..") || str.contains("@")) {
            return false;
        }
        if (!str2.equals(str)) {
            if (!str.startsWith(str2 + SymbolValues.QUESTION_EN_SYMBOL)) {
                if (!str.startsWith(str2 + "#")) {
                    if (!str2.endsWith("/")) {
                        return false;
                    }
                    if (Uri.parse(str).getPathSegments().size() - Uri.parse(str2).getPathSegments().size() != 1) {
                        return false;
                    }
                    return str.startsWith(str2);
                }
            }
        }
        return true;
    }

    public static boolean e(String str, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str2 : strArr) {
                if (f(str, str2)) {
                    return true;
                }
            }
            return false;
        }
        LogsUtil.d("UriUtil", "whitelist is null");
        return false;
    }

    public static boolean f(String str, String str2) {
        String b4 = b(str);
        if (!TextUtils.isEmpty(b4) && !TextUtils.isEmpty(str2)) {
            String a10 = a(str2);
            if (TextUtils.isEmpty(a10)) {
                return false;
            }
            if (a10.equals(b4)) {
                return true;
            }
            if (b4.endsWith(a10)) {
                try {
                    String substring = b4.substring(0, b4.length() - a10.length());
                    if (substring.endsWith(".")) {
                        return substring.matches("^[A-Za-z0-9.-]+$");
                    }
                    return false;
                } catch (IndexOutOfBoundsException e2) {
                    LogsUtil.d("UriUtil", "IndexOutOfBoundsException" + e2.getMessage());
                } catch (Exception e10) {
                    LogsUtil.d("UriUtil", "Exception : " + e10.getMessage());
                    return false;
                }
            }
            return false;
        }
        LogsUtil.d("UriUtil", "url or whitelist is null");
        return false;
    }

    public static boolean g(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return TextUtils.equals(b(str), a(str2));
    }

    public static boolean h(String str, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str2 : strArr) {
                if (g(str, str2)) {
                    return true;
                }
            }
            return false;
        }
        LogsUtil.d("UriUtil", "whitelist is null");
        return false;
    }
}
