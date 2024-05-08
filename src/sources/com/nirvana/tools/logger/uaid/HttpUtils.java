package com.nirvana.tools.logger.uaid;

import android.net.Network;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class HttpUtils {
    public static String get(String str, int i10) {
        return get(str, i10, null);
    }

    public static String get(String str, int i10, Network network) {
        String str2 = null;
        try {
            URL url = new URL(str);
            HttpURLConnection httpURLConnection = network != null ? (HttpURLConnection) network.openConnection(url) : (HttpsURLConnection) url.openConnection();
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(i10);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("GET");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            str2 = bufferedReader.readLine();
            bufferedReader.close();
            httpURLConnection.disconnect();
            return str2;
        } catch (SocketException | UnknownHostException | Exception unused) {
            return str2;
        }
    }

    public static String post(String str, String str2, int i10) {
        return post(str, str2, i10, null);
    }

    public static String post(String str, String str2, int i10, Network network) {
        String str3 = null;
        try {
            URL url = new URL(str);
            HttpURLConnection httpURLConnection = network != null ? (HttpURLConnection) network.openConnection(url) : (HttpsURLConnection) url.openConnection();
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setConnectTimeout(i10);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Type", FastJsonJsonView.DEFAULT_CONTENT_TYPE);
            httpURLConnection.setRequestMethod("POST");
            if (str2 != null && str2.length() > 0) {
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.writeBytes(str2);
                dataOutputStream.flush();
                dataOutputStream.close();
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            str3 = bufferedReader.readLine();
            bufferedReader.close();
            httpURLConnection.disconnect();
            return str3;
        } catch (SocketException | UnknownHostException | Exception unused) {
            return str3;
        }
    }
}
