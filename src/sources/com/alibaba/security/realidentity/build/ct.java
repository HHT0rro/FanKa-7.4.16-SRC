package com.alibaba.security.realidentity.build;

import com.google.android.material.badge.BadgeDrawable;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import java.net.URLEncoder;
import java.util.Map;

/* compiled from: HttpUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ct {
    public static String a(String str, String str2) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, str2).replace(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, "%20").replace(StringUtils.NO_PRINT_CODE, "%2A").replace("%7E", "~").replace("%2F", "/");
        } catch (Exception e2) {
            throw new IllegalArgumentException("failed to encode url!", e2);
        }
    }

    public static String a(Map<String, String> map, String str) {
        if (map.isEmpty()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = true;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!z10) {
                sb2.append("&");
            }
            sb2.append(a(key, str));
            if (value != null) {
                sb2.append("=");
                sb2.append(a(value, str));
            }
            z10 = false;
        }
        return sb2.toString();
    }
}
