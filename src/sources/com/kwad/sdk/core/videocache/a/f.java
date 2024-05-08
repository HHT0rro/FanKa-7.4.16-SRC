package com.kwad.sdk.core.videocache.a;

import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.utils.ad;
import java.util.HashMap;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f implements c {
    /* JADX WARN: Multi-variable type inference failed */
    private static String eI(String str) {
        Uri parse = Uri.parse(str);
        if (parse.getHost() == null || !parse.getHost().contains("yximgs.com")) {
            return str;
        }
        Uri.Builder buildUpon = parse.buildUpon();
        HashMap hashMap = new HashMap();
        if (parse.isHierarchical()) {
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            for (String str2 : queryParameterNames) {
                hashMap.put(str2, parse.getQueryParameter(str2));
            }
            buildUpon.clearQuery();
            for (String str3 : queryParameterNames) {
                if (!"tag".equals(str3) && !"di".equals(str3) && str3 != null) {
                    buildUpon.appendQueryParameter(str3, (String) hashMap.get(str3));
                }
            }
        }
        return buildUpon.toString();
    }

    private static String getExtension(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || (lastIndexOf + 2) + 4 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
    }

    @Override // com.kwad.sdk.core.videocache.a.c
    public final String generate(String str) {
        String eI = eI(str);
        String extension = getExtension(eI);
        String bu = ad.bu(eI);
        if (TextUtils.isEmpty(extension)) {
            return bu;
        }
        return bu + "." + extension;
    }
}
