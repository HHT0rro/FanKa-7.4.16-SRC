package com.kwad.sdk.core.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import java.util.Arrays;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f {
    private static String P(String str, String str2) {
        Uri parse = Uri.parse(str);
        return parse.getPath() + "&" + dK(parse.getQuery()) + "&" + str2;
    }

    public static void a(String str, Map<String, String> map, String str2) {
        map.put("Ks-Sig1", dL(P(str, str2)));
    }

    private static String dK(String str) {
        if (TextUtils.isEmpty(str)) {
            return emptyIfNull(str);
        }
        String[] split = str.split("&");
        Arrays.sort(split);
        return TextUtils.join("&", split);
    }

    private static String dL(String str) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                String doSign = KWEGIDDFP.doSign(context, str);
                return doSign == null ? "" : doSign;
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
        return "";
    }

    private static String emptyIfNull(String str) {
        return str == null ? "" : str;
    }
}
