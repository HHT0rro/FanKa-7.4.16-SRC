package com.wangmai.okhttp.model;

import android.app.ActivityManager;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.wangmai.okhttp.OkHttp;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.apache.commons.lang3.time.TimeZones;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class HttpHeaders implements Serializable {
    public static final String FORMAT_HTTP_DATA = "EEE, dd MMM y HH:mm:ss 'GMT'";
    public static final TimeZone GMT_TIME_ZONE = TimeZone.getTimeZone(TimeZones.GMT_ID);
    public static final String HEAD_KEY_ACCEPT = "Accept";
    public static final String HEAD_KEY_ACCEPT_ENCODING = "Accept-Encoding";
    public static final String HEAD_KEY_ACCEPT_LANGUAGE = "Accept-Language";
    public static final String HEAD_KEY_CACHE_CONTROL = "Cache-Control";
    public static final String HEAD_KEY_CONNECTION = "Connection";
    public static final String HEAD_KEY_CONTENT_DISPOSITION = "Content-Disposition";
    public static final String HEAD_KEY_CONTENT_ENCODING = "Content-Encoding";
    public static final String HEAD_KEY_CONTENT_LENGTH = "Content-Length";
    public static final String HEAD_KEY_CONTENT_RANGE = "Content-Range";
    public static final String HEAD_KEY_CONTENT_TYPE = "Content-Type";
    public static final String HEAD_KEY_COOKIE = "Cookie";
    public static final String HEAD_KEY_COOKIE2 = "Cookie2";
    public static final String HEAD_KEY_DATE = "Date";
    public static final String HEAD_KEY_EXPIRES = "Expires";
    public static final String HEAD_KEY_E_TAG = "ETag";
    public static final String HEAD_KEY_IF_MODIFIED_SINCE = "If-Modified-Since";
    public static final String HEAD_KEY_IF_NONE_MATCH = "If-None-Match";
    public static final String HEAD_KEY_LAST_MODIFIED = "Last-Modified";
    public static final String HEAD_KEY_LOCATION = "Location";
    public static final String HEAD_KEY_PRAGMA = "Pragma";
    public static final String HEAD_KEY_RANGE = "Range";
    public static final String HEAD_KEY_RESPONSE_CODE = "ResponseCode";
    public static final String HEAD_KEY_RESPONSE_MESSAGE = "ResponseMessage";
    public static final String HEAD_KEY_SET_COOKIE = "Set-Cookie";
    public static final String HEAD_KEY_SET_COOKIE2 = "Set-Cookie2";
    public static final String HEAD_KEY_USER_AGENT = "User-Agent";
    public static final String HEAD_VALUE_ACCEPT_ENCODING = "gzip, deflate";
    public static final String HEAD_VALUE_CONNECTION_CLOSE = "close";
    public static final String HEAD_VALUE_CONNECTION_KEEP_ALIVE = "keep-alive";
    public static final String TAG = "WM_HttpHeaders";
    public static String acceptLanguage = null;
    public static final long serialVersionUID = 8458647755751403873L;
    public static String userAgent;
    public LinkedHashMap<String, String> headersMap;

    public HttpHeaders() {
        init();
    }

    public static String formatMillisToGMT(long j10) {
        Date date = new Date(j10);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_HTTP_DATA, Locale.US);
        simpleDateFormat.setTimeZone(GMT_TIME_ZONE);
        return simpleDateFormat.format(date);
    }

    public static String getAcceptLanguage() {
        if (TextUtils.isEmpty(acceptLanguage)) {
            Locale locale = Locale.getDefault();
            String language = locale.getLanguage();
            String country = locale.getCountry();
            StringBuilder sb2 = new StringBuilder(language);
            if (!TextUtils.isEmpty(country)) {
                sb2.append('-');
                sb2.append(country);
                sb2.append(',');
                sb2.append(language);
                sb2.append(";q=0.8");
            }
            String sb3 = sb2.toString();
            acceptLanguage = sb3;
            return sb3;
        }
        return acceptLanguage;
    }

    public static String getCacheControl(String str, String str2) {
        if (str != null) {
            return str;
        }
        if (str2 != null) {
            return str2;
        }
        return null;
    }

    public static long getDate(String str) {
        try {
            return parseGMTToMillis(str);
        } catch (ParseException unused) {
            return 0L;
        }
    }

    public static long getExpiration(String str) {
        try {
            return parseGMTToMillis(str);
        } catch (ParseException unused) {
            return -1L;
        }
    }

    public static long getLastModified(String str) {
        try {
            return parseGMTToMillis(str);
        } catch (ParseException unused) {
            return 0L;
        }
    }

    public static String getPackageName() {
        try {
            return OkHttp.getInstance().getContext().getApplicationContext().getPackageName();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String getProcessName() {
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) OkHttp.getInstance().getContext().getApplicationContext().getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == Process.myPid()) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getUserAgent() {
        if (TextUtils.isEmpty(userAgent)) {
            String str = null;
            try {
                str = WebSettings.getDefaultUserAgent(OkHttp.getInstance().getContext());
            } catch (Throwable th) {
                th.toString();
            }
            if (TextUtils.isEmpty(str)) {
                str = "okhttp-okhttp/wm";
            }
            userAgent = str;
            return str;
        }
        return userAgent;
    }

    private void init() {
        this.headersMap = new LinkedHashMap<>();
    }

    public static long parseGMTToMillis(String str) throws ParseException {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_HTTP_DATA, Locale.US);
        simpleDateFormat.setTimeZone(GMT_TIME_ZONE);
        return simpleDateFormat.parse(str).getTime();
    }

    public static void setAcceptLanguage(String str) {
        acceptLanguage = str;
    }

    public static void setUserAgent(String str) {
        userAgent = str;
    }

    public void clear() {
        this.headersMap.clear();
    }

    public String get(String str) {
        return this.headersMap.get(str);
    }

    public Set<String> getNames() {
        return this.headersMap.h();
    }

    public void put(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.headersMap.put(str, str2);
    }

    public String remove(String str) {
        return this.headersMap.remove(str);
    }

    public final String toJSONString() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : this.headersMap.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "HttpHeaders{headersMap=" + ((Object) this.headersMap) + '}';
    }

    public static String getDate(long j10) {
        return formatMillisToGMT(j10);
    }

    public void put(HttpHeaders httpHeaders) {
        LinkedHashMap<String, String> linkedHashMap;
        if (httpHeaders == null || (linkedHashMap = httpHeaders.headersMap) == null || linkedHashMap.isEmpty()) {
            return;
        }
        this.headersMap.putAll(httpHeaders.headersMap);
    }

    public HttpHeaders(String str, String str2) {
        init();
        put(str, str2);
    }
}
