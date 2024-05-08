package com.danlan.android.cognition.network;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.danlan.android.cognition.Logger;
import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.debuglog.DebugLogCollector;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class HttpUtil {
    private static void enableTlsOnOlderOsVersions() {
    }

    @Nullable
    public static String sendPost(Context context, String str, String str2, JSONObject jSONObject, String str3, Map<String, String> map) {
        return sendPost(context, str, str2, jSONObject, str3, map, null);
    }

    @Nullable
    public static String sendPost(Context context, String str, String str2, JSONObject jSONObject, String str3, Map<String, String> map, DebugLogCollector debugLogCollector) {
        HttpURLConnection httpURLConnection;
        Throwable th;
        try {
            Logger.d(StringFog.decrypt("UkZKR3FMV1UBR0tOQEpKGw==") + str);
            Logger.d(StringFog.decrypt("UkZKR3FMV1UBQlRKGw==") + str2);
            enableTlsOnOlderOsVersions();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                String str4 = str + str2;
                Logger.d(StringFog.decrypt("UkZKR3FMV1UBVlZPGw==") + str4);
                httpURLConnection = (HttpURLConnection) new URL(str4).openConnection();
                try {
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(10000);
                    httpURLConnection.setRequestMethod(StringFog.decrypt("cWx3dw=="));
                    httpURLConnection.setRequestProperty(StringFog.decrypt("YkxKV0RNUAx1WlRG"), StringFog.decrypt("QFNUT0hARVVITEoMS1BLTxoDR0tAUVdEVR5xd2cOHA=="));
                    httpURLConnection.setRequestProperty(StringFog.decrypt("YEBHRlFX"), StringFog.decrypt("QFNUT0hARVVITEoMS1BLTw=="));
                    if (!TextUtils.isEmpty(str3)) {
                        httpURLConnection.setRequestProperty(StringFog.decrypt("dFBBUQxiQ0RPVw=="), str3);
                    }
                    if (map != null && !map.isEmpty()) {
                        for (String str5 : map.h()) {
                            httpURLConnection.setRequestProperty(str5, map.get(str5));
                        }
                    }
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    String jSONObject2 = jSONObject.toString();
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(jSONObject2.getBytes(StandardCharsets.UTF_8));
                    outputStream.close();
                    if (debugLogCollector != null && DebugLogCollector.isIsDebugLogEnable()) {
                        debugLogCollector.setHttp_code(String.valueOf(httpURLConnection.getResponseCode()));
                        debugLogCollector.setHttp_response(String.valueOf(httpURLConnection.getResponseMessage()));
                    }
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getResponseCode() == 200 ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream(), StandardCharsets.UTF_8));
                    StringBuilder sb2 = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            String sb3 = sb2.toString();
                            httpURLConnection.disconnect();
                            return sb3;
                        }
                        sb2.append(readLine.trim());
                    }
                } catch (Exception e2) {
                    e = e2;
                    Logger.e(e.getMessage());
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (debugLogCollector != null && DebugLogCollector.isIsDebugLogEnable()) {
                        debugLogCollector.setFail_msg(debugLogCollector.getFail_msg() + StringFog.decrypt("DA==") + e.getMessage());
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            }
            return null;
        } catch (Exception e10) {
            e = e10;
            httpURLConnection = null;
        } catch (Throwable th3) {
            httpURLConnection = null;
            th = th3;
        }
    }
}
