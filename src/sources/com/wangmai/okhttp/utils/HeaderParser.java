package com.wangmai.okhttp.utils;

import android.text.TextUtils;
import com.wangmai.okhttp.cache.CacheEntity;
import com.wangmai.okhttp.cache.CacheMode;
import com.wangmai.okhttp.model.HttpHeaders;
import com.wangmai.okhttp.request.base.Request;
import java.util.Locale;
import java.util.StringTokenizer;
import okhttp3.Headers;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class HeaderParser {
    public static <T> void addCacheHeaders(Request request, CacheEntity<T> cacheEntity, CacheMode cacheMode) {
        HttpHeaders responseHeaders;
        if (cacheEntity == null || cacheMode != CacheMode.DEFAULT || (responseHeaders = cacheEntity.getResponseHeaders()) == null) {
            return;
        }
        String str = responseHeaders.get("ETag");
        if (str != null) {
            request.headers("If-None-Match", str);
        }
        long lastModified = HttpHeaders.getLastModified(responseHeaders.get("Last-Modified"));
        if (lastModified > 0) {
            request.headers("If-Modified-Since", HttpHeaders.formatMillisToGMT(lastModified));
        }
    }

    public static <T> CacheEntity<T> createCacheEntity(Headers headers, T t2, CacheMode cacheMode, String str) {
        long j10;
        long j11 = 0;
        if (cacheMode == CacheMode.DEFAULT) {
            long date = HttpHeaders.getDate(headers.get("Date"));
            long expiration = HttpHeaders.getExpiration(headers.get("Expires"));
            String cacheControl = HttpHeaders.getCacheControl(headers.get("Cache-Control"), headers.get(HttpHeaders.HEAD_KEY_PRAGMA));
            if (TextUtils.isEmpty(cacheControl) && expiration <= 0) {
                return null;
            }
            if (TextUtils.isEmpty(cacheControl)) {
                j10 = 0;
            } else {
                StringTokenizer stringTokenizer = new StringTokenizer(cacheControl, ",");
                j10 = 0;
                while (stringTokenizer.hasMoreTokens()) {
                    String lowerCase = stringTokenizer.nextToken().trim().toLowerCase(Locale.getDefault());
                    if (lowerCase.equals("no-cache") || lowerCase.equals("no-store")) {
                        return null;
                    }
                    if (lowerCase.startsWith("max-age=")) {
                        try {
                            j10 = Long.parseLong(lowerCase.substring(8));
                            if (j10 <= 0) {
                                return null;
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (date <= 0) {
                date = currentTimeMillis;
            }
            if (j10 > 0) {
                j11 = date + (j10 * 1000);
            } else if (expiration >= 0) {
                j11 = expiration;
            }
        } else {
            j11 = System.currentTimeMillis();
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        for (String str2 : headers.names()) {
            httpHeaders.put(str2, headers.get(str2));
        }
        CacheEntity<T> cacheEntity = new CacheEntity<>();
        cacheEntity.setKey(str);
        cacheEntity.setData(t2);
        cacheEntity.setLocalExpire(j11);
        cacheEntity.setResponseHeaders(httpHeaders);
        return cacheEntity;
    }
}
