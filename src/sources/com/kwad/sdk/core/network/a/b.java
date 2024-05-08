package com.kwad.sdk.core.network.a;

import android.text.TextUtils;
import android.view.autofill.AutofillManager;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.network.r;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.export.proxy.AdHttpResponseHelper;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.utils.bn;
import com.wangmai.okhttp.model.HttpHeaders;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {
    public static com.kwad.sdk.core.network.c a(String str, Map<String, String> map, boolean z10) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        HttpURLConnection httpURLConnection2 = null;
        r1 = null;
        r1 = null;
        InputStream inputStream2 = null;
        httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Exception e2) {
            e = e2;
            inputStream = null;
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            r.wrapHttpURLConnection(httpURLConnection);
            a(httpURLConnection, map);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty(HttpHeaders.HEAD_KEY_ACCEPT, "application/json");
            p.b(httpURLConnection);
            int responseCode = httpURLConnection.getResponseCode();
            cVar.code = responseCode;
            cVar.avq = responseCode;
            StringBuilder sb2 = new StringBuilder();
            if (z10) {
                inputStream2 = httpURLConnection.getInputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    sb2.append(new String(bArr, 0, read));
                }
            }
            cVar.avs = sb2.toString();
            com.kwad.sdk.crash.utils.b.a(httpURLConnection);
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
        } catch (Exception e10) {
            e = e10;
            InputStream inputStream3 = inputStream2;
            httpURLConnection2 = httpURLConnection;
            inputStream = inputStream3;
            try {
                a(cVar, e);
                com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                return cVar;
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            InputStream inputStream4 = inputStream2;
            httpURLConnection2 = httpURLConnection;
            inputStream = inputStream4;
            com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
            throw th;
        }
        return cVar;
    }

    private static long c(HttpURLConnection httpURLConnection) {
        for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
            String key = entry.getKey();
            if (key != null && "content-length".equals(key.toLowerCase())) {
                try {
                    return Long.parseLong(entry.getValue().get(0));
                } catch (Throwable unused) {
                }
            }
        }
        return -1L;
    }

    public static com.kwad.sdk.core.network.c doGet(String str, Map<String, String> map) {
        return a(str, map, true);
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, Map<String, String> map2) {
        String str2;
        if (map2 != null) {
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                String encode = encode(entry.getValue());
                sb2.append(entry.getKey());
                sb2.append("=");
                sb2.append(encode);
                sb2.append("&");
            }
            str2 = sb2.substring(0, sb2.length() - 1);
        } else {
            str2 = null;
        }
        return a(str, map, str2, false);
    }

    public static boolean downloadUrlToStream(String str, OutputStream outputStream, long j10, AdHttpResponseListener adHttpResponseListener) {
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream;
        long c4;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                r.wrapHttpURLConnection(httpURLConnection);
                AdHttpResponseHelper.notifyResponseStart(adHttpResponseListener);
                httpURLConnection.setRequestProperty(HttpHeaders.HEAD_KEY_ACCEPT_LANGUAGE, "zh-CN");
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(AutofillManager.MAX_TEMP_AUGMENTED_SERVICE_DURATION_MS);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestProperty(HttpHeaders.HEAD_KEY_CONNECTION, HttpHeaders.HEAD_VALUE_CONNECTION_KEEP_ALIVE);
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                p.b(httpURLConnection);
                c4 = c(httpURLConnection);
                bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
            bufferedInputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            long j11 = 0;
            if (j10 <= 0) {
                if (j10 < 0) {
                    r2 = outputStream != null ? new BufferedOutputStream(outputStream) : null;
                    do {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        if (r2 != null) {
                            r2.write(bArr, 0, read);
                        }
                        j11 += read;
                    } while (!AdHttpResponseHelper.notifyResponseProgress(adHttpResponseListener, j11, c4));
                    if (r2 != null) {
                        r2.flush();
                    }
                }
                AdHttpResponseHelper.notifyResponseEnd(adHttpResponseListener);
                com.kwad.sdk.crash.utils.b.closeQuietly(r2);
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                httpURLConnection.disconnect();
                return true;
            }
            do {
                int read2 = bufferedInputStream.read(bArr);
                if (read2 == -1) {
                    break;
                }
                j11 += read2;
                AdHttpResponseHelper.notifyResponseProgress(adHttpResponseListener, j11, c4);
            } while (j11 <= j10);
            AdHttpResponseHelper.notifyResponseEnd(adHttpResponseListener);
            com.kwad.sdk.crash.utils.b.closeQuietly(r2);
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
            httpURLConnection.disconnect();
            return true;
        } catch (Throwable th3) {
            th = th3;
            com.kwad.sdk.crash.utils.b.closeQuietly(r2);
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    private static String encode(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
            return "";
        }
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        return a(str, map, jSONObject != null ? jSONObject.toString() : null, true);
    }

    private static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private static com.kwad.sdk.core.network.c a(String str, Map<String, String> map, String str2, boolean z10) {
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        HttpURLConnection httpURLConnection2 = null;
        r1 = null;
        r1 = null;
        OutputStream outputStream2 = null;
        httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        } catch (Exception e2) {
            e = e2;
            outputStream = null;
        } catch (Throwable th) {
            th = th;
            outputStream = null;
        }
        try {
            r.wrapHttpURLConnection(httpURLConnection);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            if (z10) {
                httpURLConnection.setRequestProperty("Content-Type", "application/json");
            } else {
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            }
            p.b(httpURLConnection);
            a(httpURLConnection, map);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.connect();
            if (!TextUtils.isEmpty(str2)) {
                outputStream2 = httpURLConnection.getOutputStream();
                outputStream2.write(str2.getBytes());
                outputStream2.flush();
            }
            int responseCode = httpURLConnection.getResponseCode();
            cVar.code = responseCode;
            cVar.avq = responseCode;
            if (responseCode == 200) {
                cVar.avs = a(httpURLConnection.getInputStream());
            }
            com.kwad.sdk.crash.utils.b.a(httpURLConnection);
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream2);
        } catch (Exception e10) {
            e = e10;
            OutputStream outputStream3 = outputStream2;
            httpURLConnection2 = httpURLConnection;
            outputStream = outputStream3;
            try {
                a(cVar, e);
                com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                return cVar;
            } catch (Throwable th2) {
                th = th2;
                com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            OutputStream outputStream4 = outputStream2;
            httpURLConnection2 = httpURLConnection;
            outputStream = outputStream4;
            com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
            throw th;
        }
        return cVar;
    }

    private static void a(@NonNull com.kwad.sdk.core.network.c cVar, Exception exc) {
        int i10 = cVar.code;
        if (i10 == 0) {
            i10 = -1;
        }
        cVar.avq = i10;
        cVar.avr = exc;
        if (exc instanceof SocketTimeoutException) {
            e eVar = e.avt;
            cVar.code = eVar.errorCode;
            cVar.avs = eVar.msg;
        } else {
            cVar.code = e.avu.errorCode;
            cVar.avs = e.avu.msg + "/" + bn.t(exc);
        }
        if (com.kwad.framework.a.a.f36635md.booleanValue()) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(exc);
        }
    }

    private static String a(InputStream inputStream) {
        try {
            try {
                return h.c(inputStream);
            } catch (IOException e2) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e2);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                return null;
            }
        } finally {
            com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
        }
    }
}
