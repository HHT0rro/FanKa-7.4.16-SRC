package com.kwad.sdk.core.network;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.y;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class p {
    private static String awq = "";
    private static String awr = "";

    public static String DO() {
        try {
            if (!TextUtils.isEmpty(awq)) {
                return awq;
            }
            String property = System.getProperty("http.agent");
            awq = property;
            if (TextUtils.isEmpty(property)) {
                return awq;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int length = awq.length();
            for (int i10 = 0; i10 < length; i10++) {
                char charAt = awq.charAt(i10);
                if (charAt > 31 && charAt < 127) {
                    stringBuffer.append(charAt);
                }
                stringBuffer.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            }
            String stringBuffer2 = stringBuffer.toString();
            awq = stringBuffer2;
            return stringBuffer2;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String DP() {
        String cg;
        if (!TextUtils.isEmpty(awr)) {
            return awr;
        }
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return "";
        }
        try {
            cg = y.cg(context);
            awr = cg;
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(cg)) {
            return awr;
        }
        String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
        awr = defaultUserAgent;
        String encode = URLEncoder.encode(defaultUserAgent, "UTF-8");
        awr = encode;
        y.ai(context, encode);
        return awr;
    }

    public static void b(HttpURLConnection httpURLConnection) {
        httpURLConnection.setRequestProperty("User-Agent", getUserAgent());
        httpURLConnection.setRequestProperty("BrowserUa", DP());
        httpURLConnection.setRequestProperty("SystemUa", DO());
    }

    public static String getDefaultUserAgent() {
        return DO() + "-ksad-android-3.3.59.1";
    }

    public static String getUserAgent() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getUserAgent();
    }
}
