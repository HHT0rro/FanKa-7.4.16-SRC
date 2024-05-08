package com.kwad.sdk.core.network.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.export.proxy.AdHttpBodyBuilder;
import com.kwad.sdk.export.proxy.AdHttpFormDataBuilder;
import com.kwad.sdk.export.proxy.AdHttpResponseHelper;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.utils.bn;
import com.wangmai.okhttp.model.HttpHeaders;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import okhttp3.ConnectionSpec;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c {
    private static final Pattern awu = Pattern.compile("Unexpected response code for CONNECT: ([0-9]+)", 2);
    public static String awv = "UTF-8";
    private static OkHttpClient aww = null;
    public static OkHttpClient awx = DT();

    public static OkHttpClient DS() {
        if (com.kwad.framework.a.a.f36635md.booleanValue()) {
            if (aww == null) {
                aww = awx.newBuilder().build();
            }
            return aww;
        }
        return awx;
    }

    private static OkHttpClient DT() {
        if (awx == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            OkHttpClient.Builder connectionSpecs = builder.connectTimeout(com.huawei.openalliance.ad.ipc.c.Code, timeUnit).readTimeout(6000L, timeUnit).connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
            try {
                connectionSpecs.dns(new d());
            } catch (Throwable th) {
                com.kwad.sdk.core.e.c.printStackTrace(th);
            }
            awx = connectionSpecs.build();
        }
        return awx;
    }

    public static com.kwad.sdk.core.network.c a(String str, @Nullable Map<String, String> map, boolean z10) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder url = new Request.Builder().url(str);
            a(url);
            a(url, map);
            Response execute = DS().newCall(url.build()).execute();
            int code = execute.code();
            cVar.code = code;
            cVar.avq = code;
            cVar.avs = z10 ? a(execute) : "";
        } catch (Exception e2) {
            a(cVar, e2);
        }
        return cVar;
    }

    private static void b(Request.Builder builder, Map<String, String> map) {
        FormBody formBody;
        if (map == null || map.isEmpty()) {
            formBody = null;
        } else {
            FormBody.Builder builder2 = new FormBody.Builder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null) {
                    try {
                        builder2.addEncoded(entry.getKey(), encode(entry.getValue()));
                    } catch (Exception unused) {
                    }
                }
            }
            formBody = builder2.build();
        }
        if (builder == null || formBody == null) {
            return;
        }
        builder.post(formBody);
    }

    public static com.kwad.sdk.core.network.c doGet(String str, @Nullable Map<String, String> map) {
        return a(str, map, true);
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder url = new Request.Builder().url(str);
            a(url);
            a(url, map);
            a(url, jSONObject);
            Response execute = DS().newCall(url.build()).execute();
            int code = execute.code();
            cVar.code = code;
            cVar.avq = code;
            cVar.avs = a(execute);
        } catch (Exception e2) {
            a(cVar, e2);
        }
        return cVar;
    }

    public static boolean downloadUrlToStream(String str, OutputStream outputStream, long j10, @Nullable AdHttpResponseListener adHttpResponseListener) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        Request.Builder url = new Request.Builder().url(str);
        HashMap hashMap = new HashMap();
        hashMap.put(HttpHeaders.HEAD_KEY_ACCEPT_LANGUAGE, "zh-CN");
        hashMap.put(HttpHeaders.HEAD_KEY_CONNECTION, HttpHeaders.HEAD_VALUE_CONNECTION_KEEP_ALIVE);
        hashMap.put("Charset", "UTF-8");
        a(url);
        a(url, hashMap);
        Response execute = DS().newCall(url.build()).execute();
        int code = execute.code();
        cVar.code = code;
        cVar.avq = code;
        if (execute.code() == 200) {
            a(execute, outputStream, j10, adHttpResponseListener);
            return true;
        }
        throw new FileNotFoundException(str);
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

    private static long b(Response response) {
        try {
            return Long.parseLong(response.header("content-length"));
        } catch (Throwable unused) {
            return -1L;
        }
    }

    private static void a(Request.Builder builder) {
        builder.addHeader("User-Agent", p.getUserAgent());
        builder.addHeader("BrowserUa", p.DP());
        builder.addHeader("SystemUa", p.DO());
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, Map<String, String> map2) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder url = new Request.Builder().url(str);
            a(url);
            a(url, map);
            b(url, map2);
            Response execute = DS().newCall(url.build()).execute();
            int code = execute.code();
            cVar.code = code;
            cVar.avq = code;
            cVar.avs = a(execute);
        } catch (Exception e2) {
            a(cVar, e2);
        }
        return cVar;
    }

    private static void a(@NonNull com.kwad.sdk.core.network.c cVar, Exception exc) {
        String message;
        cVar.avr = exc;
        if (cVar.avq == -1 && (exc instanceof IOException) && (message = exc.getMessage()) != null) {
            Matcher matcher = awu.matcher(message);
            if (matcher.find()) {
                try {
                    cVar.avq = Integer.parseInt(matcher.group(1));
                } catch (Exception unused) {
                }
            }
        }
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

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, AdHttpBodyBuilder adHttpBodyBuilder) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            final MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
            if (adHttpBodyBuilder != null) {
                adHttpBodyBuilder.buildFormData(new AdHttpFormDataBuilder() { // from class: com.kwad.sdk.core.network.a.c.1
                    @Override // com.kwad.sdk.export.proxy.AdHttpFormDataBuilder
                    public final void addFormDataPart(String str2, String str3) {
                        MultipartBody.Builder.this.addFormDataPart(str2, str3);
                    }

                    @Override // com.kwad.sdk.export.proxy.AdHttpFormDataBuilder
                    public final void addFormDataPart(String str2, String str3, String str4, byte[] bArr) {
                        MultipartBody.Builder.this.addFormDataPart(str2, str3, RequestBody.create(MediaType.parse(str4), bArr));
                    }
                });
            }
            Request.Builder post = new Request.Builder().url(str).post(type.build());
            a(post, map);
            Response execute = DS().newCall(post.build()).execute();
            int code = execute.code();
            cVar.code = code;
            cVar.avq = code;
            cVar.avs = a(execute);
        } catch (Exception e2) {
            a(cVar, e2);
        }
        return cVar;
    }

    private static void a(Request.Builder builder, @Nullable Map<String, String> map) {
        if (builder == null || map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                try {
                    builder.removeHeader(entry.getKey());
                    builder.addHeader(entry.getKey(), entry.getValue());
                } catch (Exception unused) {
                }
            }
        }
    }

    private static void a(Request.Builder builder, JSONObject jSONObject) {
        builder.post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jSONObject.toString()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Closeable, java.io.Reader, java.io.InputStreamReader] */
    private static String a(Response response) {
        InputStream inputStream;
        InputStream inputStream2;
        ?? r42;
        InputStream inputStream3;
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            inputStream = response.body().byteStream();
            try {
                List<String> headers = response.headers("Content-Encoding");
                boolean z10 = false;
                if (headers != null) {
                    Iterator<String> iterator2 = headers.iterator2();
                    while (true) {
                        if (!iterator2.hasNext()) {
                            break;
                        }
                        if ("gzip".equalsIgnoreCase(iterator2.next())) {
                            z10 = true;
                            break;
                        }
                    }
                }
                if (z10) {
                    inputStream3 = new GZIPInputStream(inputStream);
                    inputStream2 = inputStream3;
                } else {
                    inputStream2 = null;
                    inputStream3 = inputStream;
                }
                try {
                    r42 = new InputStreamReader(inputStream3, awv);
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(r42, 8);
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine != null) {
                                    sb2.append(readLine);
                                } else {
                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                                    com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r42);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                                    return sb2.toString();
                                }
                            } catch (Throwable th) {
                                bufferedReader = bufferedReader2;
                                th = th;
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r42);
                                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    r42 = 0;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream2 = null;
                r42 = inputStream2;
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r42);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            inputStream2 = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.io.BufferedInputStream, java.io.Closeable] */
    private static boolean a(Response response, OutputStream outputStream, long j10, AdHttpResponseListener adHttpResponseListener) {
        Throwable th;
        Closeable closeable;
        InputStream inputStream;
        InputStream inputStream2;
        long b4;
        boolean z10;
        InputStream inputStream3;
        ?? bufferedInputStream;
        try {
            AdHttpResponseHelper.notifyResponseStart(adHttpResponseListener);
            inputStream = response.body().byteStream();
            try {
                List<String> headers = response.headers("Content-Encoding");
                b4 = b(response);
                if (headers != null) {
                    Iterator<String> iterator2 = headers.iterator2();
                    while (iterator2.hasNext()) {
                        if ("gzip".equalsIgnoreCase(iterator2.next())) {
                            z10 = true;
                            break;
                        }
                    }
                }
                z10 = false;
                if (z10) {
                    inputStream3 = new GZIPInputStream(inputStream);
                    inputStream2 = inputStream3;
                } else {
                    inputStream2 = null;
                    inputStream3 = inputStream;
                }
                try {
                    bufferedInputStream = new BufferedInputStream(inputStream3);
                } catch (Throwable th2) {
                    th = th2;
                    closeable = null;
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = null;
                inputStream2 = null;
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
                        } while (!AdHttpResponseHelper.notifyResponseProgress(adHttpResponseListener, j11, b4));
                        if (r2 != null) {
                            r2.flush();
                        }
                    }
                    com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) bufferedInputStream);
                    com.kwad.sdk.crash.utils.b.closeQuietly(r2);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                    return true;
                }
                do {
                    int read2 = bufferedInputStream.read(bArr);
                    if (read2 == -1) {
                        break;
                    }
                    j11 += read2;
                    AdHttpResponseHelper.notifyResponseProgress(adHttpResponseListener, j11, b4);
                } while (j11 <= j10);
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) bufferedInputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(r2);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                return true;
            } catch (Throwable th4) {
                th = th4;
                closeable = null;
                r2 = bufferedInputStream;
                com.kwad.sdk.crash.utils.b.closeQuietly(r2);
                com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            closeable = null;
            inputStream = null;
            inputStream2 = null;
        }
    }
}
