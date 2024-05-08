package com.kwad.sdk.api.core;

import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class RequestParamsUtils {
    public static final String USER_AGENT_KEY = "User-Agent";
    private static String sUserAgent;

    public static String getUserAgent() {
        if (TextUtils.isEmpty(sUserAgent)) {
            sUserAgent = getUserAgentParams() + "ksad-android-3.3.59.1";
        }
        return sUserAgent;
    }

    private static String getUserAgentParams() {
        try {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            StringBuilder sb2 = new StringBuilder();
            int length = property.length();
            for (int i10 = 0; i10 < length; i10++) {
                char charAt = property.charAt(i10);
                if (charAt > 31 && charAt < 127) {
                    sb2.append(charAt);
                }
                sb2.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            }
            sb2.append("-");
            return sb2.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
