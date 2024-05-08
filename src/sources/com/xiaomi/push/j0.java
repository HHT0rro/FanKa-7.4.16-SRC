package com.xiaomi.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.wangmai.okhttp.model.HttpHeaders;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class j0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f47809a = Pattern.compile("([^\\s;]+)(.*)");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f47810b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f47811c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a extends FilterInputStream {

        /* renamed from: b, reason: collision with root package name */
        public boolean f47812b;

        public a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) {
            int read;
            if (!this.f47812b && (read = super.read(bArr, i10, i11)) != -1) {
                return read;
            }
            this.f47812b = true;
            return -1;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class b {
    }

    public static int a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return -1;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return -1;
            }
            return activeNetworkInfo.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    public static NetworkInfo b(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static h0 c(Context context, String str, String str2, Map<String, String> map, String str3) {
        BufferedReader bufferedReader;
        h0 h0Var = new h0();
        try {
            try {
                try {
                    HttpURLConnection m10 = m(context, n(str));
                    m10.setConnectTimeout(10000);
                    m10.setReadTimeout(15000);
                    String str4 = str2;
                    if (str2 == 0) {
                        str4 = "GET";
                    }
                    m10.setRequestMethod(str4);
                    if (map != null) {
                        for (String str5 : map.h()) {
                            m10.setRequestProperty(str5, map.get(str5));
                        }
                    }
                    int i10 = 0;
                    if (!TextUtils.isEmpty(str3)) {
                        m10.setDoOutput(true);
                        byte[] bytes = str3.getBytes();
                        OutputStream outputStream = m10.getOutputStream();
                        try {
                            outputStream.write(bytes, 0, bytes.length);
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e2) {
                            e = e2;
                            throw new IOException("err while request " + str + com.huawei.openalliance.ad.constant.u.bD + e.getClass().getSimpleName());
                        } catch (Throwable th) {
                            th = th;
                            throw new IOException(th.getMessage());
                        }
                    }
                    h0Var.f47350a = m10.getResponseCode();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Http POST Response Code: ");
                    sb2.append(h0Var.f47350a);
                    while (true) {
                        String headerFieldKey = m10.getHeaderFieldKey(i10);
                        String headerField = m10.getHeaderField(i10);
                        if (headerFieldKey == null && headerField == null) {
                            try {
                                break;
                            } catch (IOException unused) {
                                bufferedReader = new BufferedReader(new InputStreamReader(new a(m10.getErrorStream())));
                            }
                        } else {
                            h0Var.f47351b.put(headerFieldKey, headerField);
                            i10 = i10 + 1 + 1;
                        }
                    }
                    bufferedReader = new BufferedReader(new InputStreamReader(new a(m10.getInputStream())));
                    try {
                        StringBuffer stringBuffer = new StringBuffer();
                        String property = System.getProperty("line.separator");
                        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                            stringBuffer.append(readLine);
                            stringBuffer.append(property);
                        }
                        h0Var.f47352c = stringBuffer.toString();
                        bufferedReader.close();
                        s7.b(null);
                        s7.b(null);
                        return h0Var;
                    } catch (IOException e10) {
                        e = e10;
                        throw new IOException("err while request " + str + com.huawei.openalliance.ad.constant.u.bD + e.getClass().getSimpleName());
                    } catch (Throwable th2) {
                        th = th2;
                        throw new IOException(th.getMessage());
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e11) {
                e = e11;
            }
        } catch (Throwable th4) {
            s7.b(null);
            s7.b(str2);
            throw th4;
        }
    }

    public static h0 d(Context context, String str, Map<String, String> map) {
        return c(context, str, "POST", null, l(map));
    }

    public static InputStream e(Context context, URL url, boolean z10, String str, String str2) {
        return f(context, url, z10, str, str2, null, null);
    }

    public static InputStream f(Context context, URL url, boolean z10, String str, String str2, Map<String, String> map, b bVar) {
        if (context == null) {
            throw new IllegalArgumentException("context");
        }
        if (url == null) {
            throw new IllegalArgumentException("url");
        }
        if (!z10) {
            url = new URL(j(url.toString()));
        }
        try {
            HttpURLConnection.setFollowRedirects(true);
            HttpURLConnection m10 = m(context, url);
            m10.setConnectTimeout(10000);
            m10.setReadTimeout(15000);
            if (!TextUtils.isEmpty(str)) {
                m10.setRequestProperty("User-Agent", str);
            }
            if (str2 != null) {
                m10.setRequestProperty(HttpHeaders.HEAD_KEY_COOKIE, str2);
            }
            if (map != null) {
                for (String str3 : map.h()) {
                    m10.setRequestProperty(str3, map.get(str3));
                }
            }
            return new a(m10.getInputStream());
        } catch (IOException e2) {
            throw new IOException("IOException:" + e2.getClass().getSimpleName());
        } catch (Throwable th) {
            throw new IOException(th.getMessage());
        }
    }

    public static String g(Context context) {
        if (r(context)) {
            return "wifi";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return "";
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "";
            }
            return (activeNetworkInfo.getTypeName() + "-" + activeNetworkInfo.getSubtypeName() + "-" + activeNetworkInfo.getExtraInfo()).toLowerCase();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String h(Context context, URL url) {
        return i(context, url, false, null, "UTF-8", null);
    }

    public static String i(Context context, URL url, boolean z10, String str, String str2, String str3) {
        InputStream inputStream;
        try {
            inputStream = e(context, url, z10, str, str3);
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            StringBuilder sb2 = new StringBuilder(1024);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str2));
            char[] cArr = new char[4096];
            while (true) {
                int read = bufferedReader.read(cArr);
                if (-1 == read) {
                    s7.b(inputStream);
                    return sb2.toString();
                }
                sb2.append(cArr, 0, read);
            }
        } catch (Throwable th2) {
            th = th2;
            s7.b(inputStream);
            throw th;
        }
    }

    public static String j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new String();
        return String.format("%s&key=%s", str, o0.b(String.format("%sbe988a6134bc8254465424e5a70ef037", str)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String k(String str, Map<String, String> map, File file, String str2) {
        if (!file.exists()) {
            return null;
        }
        String name = file.getName();
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty(HttpHeaders.HEAD_KEY_CONNECTION, "Keep-Alive");
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=*****");
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection.setFixedLengthStreamingMode(name.length() + 77 + ((int) file.length()) + str2.length());
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.writeBytes("--*****\r\n");
                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str2 + "\";filename=\"" + file.getName() + "\"" + IOUtils.LINE_SEPARATOR_WINDOWS);
                dataOutputStream.writeBytes(IOUtils.LINE_SEPARATOR_WINDOWS);
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        dataOutputStream.write(bArr, 0, read);
                        dataOutputStream.flush();
                    }
                    dataOutputStream.writeBytes(IOUtils.LINE_SEPARATOR_WINDOWS);
                    dataOutputStream.writeBytes("--");
                    dataOutputStream.writeBytes("*****");
                    dataOutputStream.writeBytes("--");
                    dataOutputStream.writeBytes(IOUtils.LINE_SEPARATOR_WINDOWS);
                    dataOutputStream.flush();
                    StringBuffer stringBuffer = new StringBuffer();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new a(httpURLConnection.getInputStream())));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                String stringBuffer2 = stringBuffer.toString();
                                s7.b(fileInputStream);
                                s7.b(bufferedReader);
                                return stringBuffer2;
                            }
                            stringBuffer.append(readLine);
                        } catch (IOException e2) {
                            e = e2;
                            throw new IOException("IOException:" + e.getClass().getSimpleName());
                        } catch (Throwable th) {
                            th = th;
                            throw new IOException(th.getMessage());
                        }
                    }
                } catch (IOException e10) {
                    e = e10;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e11) {
                e = e11;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            s7.b(null);
            s7.b(file);
            throw th4;
        }
    }

    public static String l(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                try {
                    stringBuffer.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                    stringBuffer.append("=");
                    stringBuffer.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                    stringBuffer.append("&");
                } catch (UnsupportedEncodingException e2) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to convert from params map to string: ");
                    sb2.append(e2.toString());
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("map: ");
                    sb3.append(map.toString());
                    return null;
                }
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    public static HttpURLConnection m(Context context, URL url) {
        return (HttpURLConnection) (("http".equals(url.getProtocol()) && o(context)) ? url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80))) : url.openConnection());
    }

    public static URL n(String str) {
        return new URL(str);
    }

    public static boolean o(Context context) {
        ConnectivityManager connectivityManager;
        if (!"CN".equalsIgnoreCase(((TelephonyManager) context.getSystemService("phone")).getSimCountryIso())) {
            return false;
        }
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception unused) {
        }
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        String extraInfo = activeNetworkInfo.getExtraInfo();
        return !TextUtils.isEmpty(extraInfo) && extraInfo.length() >= 3 && extraInfo.contains("ctwap");
    }

    public static boolean p(Context context) {
        return a(context) >= 0;
    }

    public static boolean q(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            networkInfo = null;
        }
        return networkInfo != null && networkInfo.isConnected();
    }

    public static boolean r(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && 1 == activeNetworkInfo.getType();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean s(Context context) {
        return t(context) || u(context) || v(context);
    }

    public static boolean t(Context context) {
        NetworkInfo b4 = b(context);
        return b4 != null && b4.getType() == 0 && 13 == b4.getSubtype();
    }

    public static boolean u(Context context) {
        NetworkInfo b4 = b(context);
        if (b4 == null || b4.getType() != 0) {
            return false;
        }
        String subtypeName = b4.getSubtypeName();
        if (!"TD-SCDMA".equalsIgnoreCase(subtypeName) && !"CDMA2000".equalsIgnoreCase(subtypeName) && !"WCDMA".equalsIgnoreCase(subtypeName)) {
            switch (b4.getSubtype()) {
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    break;
                case 4:
                case 7:
                case 11:
                case 13:
                default:
                    return false;
            }
        }
        return true;
    }

    public static boolean v(Context context) {
        NetworkInfo b4 = b(context);
        if (b4 == null || b4.getType() != 0) {
            return false;
        }
        int subtype = b4.getSubtype();
        return subtype == 1 || subtype == 2 || subtype == 4 || subtype == 7 || subtype == 11;
    }
}
