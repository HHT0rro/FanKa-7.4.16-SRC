package com.huawei.appgallery.agd.serverreq.utils.device;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class TelphoneInformationManager {
    public static final String DEFAULT_COUNTRY = "US";
    public static final String DEFAULT_LANG = "en";
    public static final String DEFAULT_SCRIPT = "";

    public static String assembleLang(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return str;
        }
        if (TextUtils.isEmpty(str2)) {
            return str + "_" + str3;
        }
        return str + "_" + str2 + "_" + str3;
    }

    public static String getTelephoneLanguage() {
        String str;
        String str2;
        String str3;
        Locale locale = Locale.getDefault();
        if (locale != null) {
            str3 = locale.getLanguage();
            str2 = locale.getScript();
            str = locale.getCountry();
        } else {
            str = "US";
            str2 = "";
            str3 = "en";
        }
        return assembleLang(TextUtils.isEmpty(str3) ? "en" : str3, TextUtils.isEmpty(str2) ? "" : str2, TextUtils.isEmpty(str) ? "US" : str);
    }

    public static String getTelphoneFirmVersionFromSys() {
        return Build.VERSION.RELEASE.trim();
    }
}
