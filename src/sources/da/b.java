package da;

import com.alipay.sdk.util.i;
import com.google.android.material.badge.BadgeDrawable;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class b {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLEncoder.encode(str, "UTF-8").replace(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, "%20").replace(StringUtils.NO_PRINT_CODE, "%2A").replace("~", "%7E");
        } catch (UnsupportedEncodingException unused) {
            fa.a.c("StringUtils", "encode2utf8 error");
            return null;
        }
    }

    public static boolean b(String str) {
        return str != null && str.trim().startsWith("{") && str.trim().endsWith(i.f4738d);
    }
}
