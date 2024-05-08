package com.hailiang.advlib.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/* compiled from: XUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f27139a = true;

    /* renamed from: b, reason: collision with root package name */
    public static String f27140b;

    /* renamed from: c, reason: collision with root package name */
    public static int f27141c;

    public static String a(InputStream inputStream, int i10, int i11) {
        int read;
        if (inputStream == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[1024];
            try {
                if (i11 == -1) {
                    while (true) {
                        int read2 = inputStream.read(bArr);
                        if (read2 <= -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, read2);
                    }
                } else {
                    while (i11 > 0) {
                        if (i11 < 1024) {
                            read = inputStream.read(bArr, 0, i11);
                        } else {
                            read = inputStream.read(bArr);
                        }
                        messageDigest.update(bArr, 0, read);
                        i11 -= read;
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            byte[] digest = messageDigest.digest();
            StringBuilder sb2 = new StringBuilder();
            for (byte b4 : digest) {
                sb2.append(Integer.toHexString((b4 & 255) | 256).substring(1, 3));
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static long b(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j10 = 0;
        int i10 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j10;
            }
            while (i10 < 512) {
                bArr[i10] = (byte) (bArr[i10] - 1);
                i10++;
            }
            outputStream.write(bArr, 0, read);
            j10 += read;
        }
    }

    public static String c(Context context) {
        try {
            return (String) c.g("android.app.ActivityThread").b("currentProcessName").c();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String d(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b(Context context) {
        if (!TextUtils.isEmpty(f27140b)) {
            return f27140b;
        }
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager == null ? null : packageManager.getPackageInfo(context.getPackageName(), 0);
                if (packageInfo != null) {
                    String str = packageInfo.versionName;
                    if (str == null) {
                        str = "";
                    }
                    f27140b = str;
                    return str;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return "";
    }

    public static String a(String str, String str2) throws IOException {
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                if (str2 != null) {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setRequestProperty("Content-Type", "application/json");
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(str2.getBytes());
                    outputStream.close();
                } else {
                    httpURLConnection.setRequestMethod("GET");
                }
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    try {
                        StringBuilder sb2 = new StringBuilder();
                        while (true) {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb2.append(readLine);
                        }
                        String sb3 = sb2.toString();
                        try {
                            bufferedReader2.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        httpURLConnection.disconnect();
                        return sb3;
                    } catch (Throwable th) {
                        bufferedReader = bufferedReader2;
                        th = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            throw th;
                        }
                        throw th;
                    }
                }
                throw new IOException("Unexpected response code: " + responseCode);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
        }
    }

    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j10 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j10;
            }
            outputStream.write(bArr, 0, read);
            j10 += read;
        }
    }

    public static String a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        boolean z10 = false;
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!z10) {
                sb2.append('?');
                z10 = true;
            } else if (z10) {
                sb2.append(SymbolValues.CHAR_AND_SYMBOL);
            }
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null && value != null) {
                sb2.append(key);
                sb2.append('=');
                try {
                    sb2.append(URLEncoder.encode(value, "UTF-8"));
                } catch (UnsupportedEncodingException e2) {
                    sb2.append("none");
                    e2.printStackTrace();
                }
            }
        }
        return sb2.toString();
    }

    public static int a(Context context) {
        int i10 = f27141c;
        if (i10 > 0) {
            return i10;
        }
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager == null ? null : packageManager.getPackageInfo(context.getPackageName(), 0);
                if (packageInfo != null) {
                    int i11 = packageInfo.versionCode;
                    f27141c = i11;
                    return i11;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return 0;
    }

    public static boolean a() {
        try {
            int i10 = AppCompatActivity.f847c;
            return f27139a;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void a(boolean z10) {
        f27139a = z10;
    }
}
