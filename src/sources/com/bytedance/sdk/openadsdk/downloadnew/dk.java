package com.bytedance.sdk.openadsdk.downloadnew;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import sun.security.util.SecurityConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class dk {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class m {
        public Map<String, String> dk;
        public int ej;

        /* renamed from: l, reason: collision with root package name */
        public HttpURLConnection f11143l;

        /* renamed from: m, reason: collision with root package name */
        public InputStream f11144m;

        public m(InputStream inputStream, Map<String, String> map, int i10, HttpURLConnection httpURLConnection) {
            this.f11144m = inputStream;
            this.dk = map;
            this.ej = i10;
            this.f11143l = httpURLConnection;
        }
    }

    public static HttpURLConnection m(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setInstanceFollowRedirects(false);
                httpURLConnection2.setRequestProperty(SecurityConstants.SOCKET_ACCEPT_ACTION, "*/*");
                httpURLConnection2.setRequestProperty("connection", "Keep-Alive");
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection2.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection2.connect();
                int responseCode = httpURLConnection2.getResponseCode();
                return ((responseCode < 200 || responseCode >= 300) && responseCode >= 300 && responseCode < 400) ? m(httpURLConnection2.getHeaderField("Location"), map) : httpURLConnection2;
            } catch (Exception unused) {
                httpURLConnection = httpURLConnection2;
                return httpURLConnection;
            }
        } catch (Exception unused2) {
        }
    }

    public static Map<String, String> m(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        int size = httpURLConnection.getHeaderFields().size();
        for (int i10 = 0; i10 < size; i10++) {
            hashMap.put(httpURLConnection.getHeaderFieldKey(i10), httpURLConnection.getHeaderField(i10));
        }
        return hashMap;
    }

    public static m m(String str, List<HttpHeader> list) throws IOException {
        int responseCode;
        HashMap hashMap = new HashMap();
        if (list != null && !list.isEmpty()) {
            for (HttpHeader httpHeader : list) {
                hashMap.put(httpHeader.getName(), httpHeader.getValue());
            }
        }
        HttpURLConnection m10 = m(str, hashMap);
        if (m10 == null || (responseCode = m10.getResponseCode()) < 200 || responseCode >= 300) {
            return null;
        }
        Map<String, String> m11 = m(m10);
        InputStream inputStream = m10.getInputStream();
        String contentEncoding = m10.getContentEncoding();
        if (!TextUtils.isEmpty(contentEncoding) && contentEncoding.contains("gzip")) {
            inputStream = new GZIPInputStream(inputStream);
        }
        return new m(inputStream, m11, responseCode, m10);
    }
}
