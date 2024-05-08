package com.huawei.appgallery.agd.common.utils;

import android.net.Uri;
import com.huawei.appgallery.agd.common.CommonLog;
import com.huawei.secure.android.common.util.SafeString;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import wa.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class UriUtil {

    @Deprecated
    public static final String KEYPART3_DEPRECATED = "#dM^%9";

    public static String getParameterValue(Uri uri, String str) {
        if (getQueryParameterNames(uri.getEncodedQuery()).contains(str)) {
            try {
                return c.a(uri, str);
            } catch (Exception e2) {
                CommonLog.LOG.e("UriUtil", "getParameterValue error," + e2.getMessage());
            }
        }
        return null;
    }

    public static String getParameterValue(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        return getParameterValue(Uri.parse(str), str2);
    }

    public static Set<String> getQueryParameterNames(String str) {
        if (str == null) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i10 = 0;
        do {
            try {
                int indexOf = str.indexOf(38, i10);
                if (indexOf == -1) {
                    indexOf = str.length();
                }
                int indexOf2 = str.indexOf(61, i10);
                if (indexOf2 > indexOf || indexOf2 == -1) {
                    indexOf2 = indexOf;
                }
                linkedHashSet.add(Uri.decode(SafeString.substring(str, i10, indexOf2)));
                i10 = indexOf + 1;
            } catch (Exception unused) {
                CommonLog.LOG.w("UriUtil", "getQueryParameterNames error");
            }
        } while (i10 < str.length());
        return Collections.unmodifiableSet(linkedHashSet);
    }
}
