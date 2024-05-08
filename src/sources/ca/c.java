package ca;

import android.text.TextUtils;
import com.huawei.appgallery.agd.common.constant.SystemPropertyValues;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static int f1591a = -1;

    public static String a() {
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        String variant = locale.getVariant();
        String script = locale.getScript();
        if (TextUtils.isEmpty(script) && TextUtils.isEmpty(variant)) {
            return language + "_" + country;
        }
        return language + "_" + script + "_" + country + "_" + variant;
    }

    public static boolean b() {
        if (f1591a == -1) {
            f1591a = ("zh".equals(e.b("ro.product.locale.language")) && "CN".equals(e.b(SystemPropertyValues.PROP_REGION_KEY))) ? 0 : 1;
        }
        return f1591a == 1;
    }
}
