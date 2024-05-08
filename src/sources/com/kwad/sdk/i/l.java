package com.kwad.sdk.i;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class l {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static int aJu;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface a {
        void onSuccess();
    }

    @WorkerThread
    public static void a(List<k> list, a aVar) {
        if (aJu > 10) {
            j.logE("LogReportUtil", "request error");
            return;
        }
        g Jg = h.Jc().Jg();
        Map<String, String> requestHeader = Jg.getRequestHeader();
        JSONObject Jb = Jg.Jb();
        c.putValue(Jb, "actionList", list);
        c.putValue(Jb, "timestamp", System.currentTimeMillis());
        a(Jg.Ja(), requestHeader, a(requestHeader, Jb), aVar);
    }

    private static String c(Map<String, String> map, String str) {
        g Jg = h.Jc().Jg();
        JSONObject jSONObject = new JSONObject();
        c.putValue(jSONObject, "version", Jg.getSdkVersion());
        c.putValue(jSONObject, "appId", Jg.getAppId());
        c.putValue(jSONObject, "message", com.kwad.sdk.i.a.al(str));
        com.kwad.sdk.i.a.a(Jg.Ja(), map, jSONObject.toString());
        return jSONObject.toString();
    }

    private static String c(InputStream inputStream) {
        InputStreamReader inputStreamReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            inputStreamReader = new InputStreamReader(inputStream);
            try {
                bufferedReader = new BufferedReader(inputStreamReader, 1024);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            inputStreamReader = null;
            th = th3;
            bufferedReader = null;
        }
        try {
            String a10 = a(bufferedReader);
            j.closeQuietly(bufferedReader);
            j.closeQuietly(inputStreamReader);
            return a10;
        } catch (Throwable th4) {
            th = th4;
            j.closeQuietly(bufferedReader);
            j.closeQuietly(inputStreamReader);
            throw th;
        }
    }

    private static String a(Map<String, String> map, JSONObject jSONObject) {
        if (h.Jc().Jg().IZ()) {
            return jSONObject.toString();
        }
        return c(map, jSONObject.toString());
    }

    private static void a(String str, Map<String, String> map, String str2, a aVar) {
        Closeable closeable;
        HttpURLConnection httpURLConnection = null;
        OutputStream outputStream = null;
        httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setRequestProperty("Content-Type", "application/json");
                httpURLConnection2.setConnectTimeout(10000);
                httpURLConnection2.setReadTimeout(30000);
                httpURLConnection2.setUseCaches(false);
                a(httpURLConnection2, map);
                httpURLConnection2.connect();
                if (!TextUtils.isEmpty(str2)) {
                    outputStream = httpURLConnection2.getOutputStream();
                    outputStream.write(str2.getBytes());
                    outputStream.flush();
                }
                if (httpURLConnection2.getResponseCode() == 200) {
                    String a10 = a(httpURLConnection2.getInputStream());
                    j.Jn();
                    if (!TextUtils.isEmpty(a10)) {
                        if (new JSONObject(a10).optInt("result") == 1) {
                            aJu = 0;
                            aVar.onSuccess();
                        } else {
                            aJu++;
                            j.Jn();
                        }
                    } else {
                        aJu++;
                        j.Jn();
                    }
                } else {
                    aJu++;
                    j.Jn();
                }
                j.a(httpURLConnection2);
                j.closeQuietly(outputStream);
            } catch (Exception unused) {
                httpURLConnection = httpURLConnection2;
                closeable = null;
                try {
                    aJu++;
                    j.Jm();
                    j.a(httpURLConnection);
                    j.closeQuietly(closeable);
                } catch (Throwable th) {
                    th = th;
                    j.a(httpURLConnection);
                    j.closeQuietly(closeable);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = httpURLConnection2;
                closeable = null;
                j.a(httpURLConnection);
                j.closeQuietly(closeable);
                throw th;
            }
        } catch (Exception unused2) {
            closeable = null;
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
        }
    }

    private static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private static String a(Reader reader) {
        StringWriter stringWriter;
        Throwable th;
        StringWriter stringWriter2 = new StringWriter();
        try {
            stringWriter = new StringWriter();
        } catch (Throwable th2) {
            stringWriter = stringWriter2;
            th = th2;
        }
        try {
            char[] cArr = new char[1024];
            while (true) {
                int read = reader.read(cArr);
                if (read != -1) {
                    stringWriter.write(cArr, 0, read);
                } else {
                    String stringWriter3 = stringWriter.toString();
                    j.closeQuietly(reader);
                    j.closeQuietly(stringWriter);
                    return stringWriter3;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            j.closeQuietly(reader);
            j.closeQuietly(stringWriter);
            throw th;
        }
    }

    private static String a(InputStream inputStream) {
        try {
            try {
                return c(inputStream);
            } catch (IOException unused) {
                j.Jm();
                j.closeQuietly(inputStream);
                return null;
            }
        } finally {
            j.closeQuietly(inputStream);
        }
    }
}
