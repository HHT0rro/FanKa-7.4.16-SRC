package com.huawei.appgallery.agd.common.support.global;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.common.CommonLog;
import com.huawei.appgallery.agd.common.constant.SystemPropertyValues;
import com.huawei.appgallery.agd.common.utils.PropertyUtil;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import com.huawei.secure.android.common.util.SafeString;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class HomeCountryUtils {

    /* renamed from: a, reason: collision with root package name */
    public static String f27367a = null;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f27368b = false;

    /* renamed from: c, reason: collision with root package name */
    public static String f27369c = "";

    /* renamed from: d, reason: collision with root package name */
    public static String f27370d = "";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface HomeCountry {
        public static final String CHINA = "CN";
        public static final String CHINA_TAIWAN = "TW";
    }

    @NonNull
    public static String a() {
        String country;
        Locale locale = Locale.getDefault();
        return (locale == null || (country = locale.getCountry()) == null) ? "" : country;
    }

    public static String b() {
        String str = f27370d;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String homeCountryFromRom = getHomeCountryFromRom();
        if (TextUtils.isEmpty(homeCountryFromRom)) {
            return a();
        }
        f27370d = homeCountryFromRom;
        return homeCountryFromRom;
    }

    public static boolean c() {
        return HomeCountry.CHINA_TAIWAN.equalsIgnoreCase(PropertyUtil.getProp("hbc.country"));
    }

    public static String getHomeCountry() {
        String homeCountryOfMedia = getHomeCountryOfMedia();
        if (TextUtils.isEmpty(homeCountryOfMedia)) {
            homeCountryOfMedia = b();
        }
        if (!StringUtils.equals(homeCountryOfMedia, f27369c)) {
            f27369c = homeCountryOfMedia;
            CommonLog.LOG.d("HomeCountryUtils", "getHomeCountry(): " + homeCountryOfMedia);
        }
        return homeCountryOfMedia;
    }

    public static String getHomeCountryFromRom() {
        int i10;
        if (c()) {
            CommonLog.LOG.d("HomeCountryUtils", "getHomeCountryFromRom, hbc.country is TW");
            return HomeCountry.CHINA_TAIWAN;
        }
        String prop = PropertyUtil.getProp(SystemPropertyValues.PROP_REGION_KEY);
        if (!StringUtils.isBlank(prop)) {
            CommonLog.LOG.d("HomeCountryUtils", "ro.product.locale.region=" + prop);
            return prop.toUpperCase(Locale.US);
        }
        String prop2 = PropertyUtil.getProp(SystemPropertyValues.PROP_LOCALE_KEY);
        if (!StringUtils.isBlank(prop2)) {
            CommonLog.LOG.d("HomeCountryUtils", "ro.product.locale=" + prop2);
            if (prop2.contains("CN")) {
                return "CN";
            }
        }
        int lastIndexOf = prop2.lastIndexOf("-");
        if (lastIndexOf >= 0 && (i10 = lastIndexOf + 1) < prop2.length()) {
            prop2 = SafeString.substring(prop2, i10);
        }
        return !StringUtils.isBlank(prop2) ? prop2.toUpperCase(Locale.US) : prop2;
    }

    public static String getHomeCountryOfMedia() {
        return f27367a;
    }

    public static boolean getIsHaveCorrectedCountry() {
        return f27368b;
    }

    public static boolean isNeedStoreServiceZone() {
        return TextUtils.isEmpty(getHomeCountryOfMedia()) && !getIsHaveCorrectedCountry();
    }

    public static void setHomeCountryOfMedia(String str) {
        f27367a = str;
    }

    public static void setIsHaveCalibrationCountry(boolean z10) {
        f27368b = z10;
    }
}
