package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.security.realidentity.common.BuildConfig;
import com.amap.api.col.p0003l.fu;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONObject;

/* compiled from: Utils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class fv {

    /* renamed from: a, reason: collision with root package name */
    public static String f5969a;

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f5970b = {"arm64-v8a", "x86_64"};

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f5971c = {"arm", "x86"};

    static {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < 80; i10++) {
            sb2.append("=");
        }
        f5969a = sb2.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r7) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 1
            java.lang.String r2 = "ut"
            r3 = 28
            if (r0 >= r3) goto L2d
            android.content.pm.ApplicationInfo r0 = r7.getApplicationInfo()     // Catch: java.lang.Throwable -> L27
            java.lang.Class<android.content.pm.ApplicationInfo> r4 = android.content.pm.ApplicationInfo.class
            java.lang.String r4 = r4.getName()     // Catch: java.lang.Throwable -> L27
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.Throwable -> L27
            java.lang.String r5 = "primaryCpuAbi"
            java.lang.reflect.Field r4 = r4.getDeclaredField(r5)     // Catch: java.lang.Throwable -> L27
            r4.setAccessible(r1)     // Catch: java.lang.Throwable -> L27
            java.lang.Object r0 = r4.get(r0)     // Catch: java.lang.Throwable -> L27
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L27
            goto L2f
        L27:
            r0 = move-exception
            java.lang.String r4 = "gct"
            com.amap.api.col.p0003l.gv.a(r0, r2, r4)
        L2d:
            java.lang.String r0 = ""
        L2f:
            int r4 = android.os.Build.VERSION.SDK_INT
            if (r4 < r3) goto L9c
            java.lang.Class<android.os.Build> r3 = android.os.Build.class
            java.lang.String r4 = "SUPPORTED_ABIS"
            java.lang.reflect.Field r3 = r3.getDeclaredField(r4)     // Catch: java.lang.Throwable -> L96
            r4 = 0
            java.lang.Object r3 = r3.get(r4)     // Catch: java.lang.Throwable -> L96
            java.lang.String[] r3 = (java.lang.String[]) r3     // Catch: java.lang.Throwable -> L96
            r5 = 0
            if (r3 == 0) goto L4a
            int r6 = r3.length     // Catch: java.lang.Throwable -> L96
            if (r6 <= 0) goto L4a
            r0 = r3[r5]     // Catch: java.lang.Throwable -> L96
        L4a:
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L96
            if (r3 != 0) goto L9c
            java.lang.String[] r3 = com.amap.api.col.p0003l.fv.f5970b     // Catch: java.lang.Throwable -> L96
            java.util.List r3 = java.util.Arrays.asList(r3)     // Catch: java.lang.Throwable -> L96
            boolean r3 = r3.contains(r0)     // Catch: java.lang.Throwable -> L96
            if (r3 == 0) goto L9c
            android.content.pm.ApplicationInfo r7 = r7.getApplicationInfo()     // Catch: java.lang.Throwable -> L96
            java.lang.String r7 = r7.nativeLibraryDir     // Catch: java.lang.Throwable -> L96
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Throwable -> L96
            if (r3 != 0) goto L9c
            java.lang.String r3 = java.io.File.separator     // Catch: java.lang.Throwable -> L96
            int r3 = r7.lastIndexOf(r3)     // Catch: java.lang.Throwable -> L96
            int r3 = r3 + r1
            java.lang.String r7 = r7.substring(r3)     // Catch: java.lang.Throwable -> L96
            java.lang.String[] r1 = com.amap.api.col.p0003l.fv.f5971c     // Catch: java.lang.Throwable -> L96
            java.util.List r1 = java.util.Arrays.asList(r1)     // Catch: java.lang.Throwable -> L96
            boolean r7 = r1.contains(r7)     // Catch: java.lang.Throwable -> L96
            if (r7 == 0) goto L9c
            java.lang.Class<android.os.Build> r7 = android.os.Build.class
            java.lang.String r1 = "SUPPORTED_32_BIT_ABIS"
            java.lang.reflect.Field r7 = r7.getDeclaredField(r1)     // Catch: java.lang.Throwable -> L96
            java.lang.Object r7 = r7.get(r4)     // Catch: java.lang.Throwable -> L96
            java.lang.String[] r7 = (java.lang.String[]) r7     // Catch: java.lang.Throwable -> L96
            if (r7 == 0) goto L9c
            int r1 = r7.length     // Catch: java.lang.Throwable -> L96
            if (r1 <= 0) goto L9c
            r7 = r7[r5]     // Catch: java.lang.Throwable -> L96
            r0 = r7
            goto L9c
        L96:
            r7 = move-exception
            java.lang.String r1 = "gct_p"
            com.amap.api.col.p0003l.gv.a(r7, r2, r1)
        L9c:
            boolean r7 = android.text.TextUtils.isEmpty(r0)
            if (r7 == 0) goto La4
            java.lang.String r0 = android.os.Build.CPU_ABI
        La4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.fv.a(android.content.Context):java.lang.String");
    }

    public static fu b() throws fi {
        return new fu.a("co", BuildConfig.VERSION_NAME, "AMap_co_1.0.0").a(new String[]{"com.amap.co", "com.amap.opensdk.co", "com.amap.location"}).a();
    }

    public static String c(String str) {
        return str.length() < 2 ? "" : fn.a(str.substring(1));
    }

    public static PublicKey d() throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException {
        ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(fn.b("MIICnjCCAgegAwIBAgIJAJ0Pdzos7ZfYMA0GCSqGSIb3DQEBBQUAMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjAeFw0xMzA4MTUwNzU2NTVaFw0yMzA4MTMwNzU2NTVaMGgxCzAJBgNVBAYTAkNOMRMwEQYDVQQIDApTb21lLVN0YXRlMRAwDgYDVQQHDAdCZWlqaW5nMREwDwYDVQQKDAhBdXRvbmF2aTEfMB0GA1UEAwwWY29tLmF1dG9uYXZpLmFwaXNlcnZlcjCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEA8eWAyHbFPoFPfdx5AD+D4nYFq4dbJ1p7SIKt19Oz1oivF/6H43v5Fo7s50pD1UF8+Qu4JoUQxlAgOt8OCyQ8DYdkaeB74XKb1wxkIYg/foUwN1CMHPZ9O9ehgna6K4EJXZxR7Y7XVZnbjHZIVn3VpPU/Rdr2v37LjTw+qrABJxMCAwEAAaNQME4wHQYDVR0OBBYEFOM/MLGP8xpVFuVd+3qZkw7uBvOTMB8GA1UdIwQYMBaAFOM/MLGP8xpVFuVd+3qZkw7uBvOTMAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEFBQADgYEA4LY3g8aAD8JkxAOqUXDDyLuCCGOc2pTIhn0TwMNaVdH4hZlpTeC/wuRD5LJ0z3j+IQ0vLvuQA5uDjVyEOlBrvVIGwSem/1XGUo13DfzgAJ5k1161S5l+sFUo5TxpHOXr8Z5nqJMjieXmhnE/I99GFyHpQmw4cC6rhYUhdhtg+Zk="));
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance(c("IWC41MDk"));
                KeyFactory keyFactory = KeyFactory.getInstance(c("EUlNB"));
                Certificate generateCertificate = certificateFactory.generateCertificate(byteArrayInputStream);
                if (generateCertificate != null && keyFactory != null) {
                    PublicKey generatePublic = keyFactory.generatePublic(new X509EncodedKeySpec(generateCertificate.getPublicKey().getEncoded()));
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    return generatePublic;
                }
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                return null;
            } catch (Throwable unused) {
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                }
                return null;
            }
        } catch (Throwable unused2) {
            byteArrayInputStream = null;
        }
    }

    public static String e(byte[] bArr) {
        try {
            return g(bArr);
        } catch (Throwable th) {
            gv.a(th, "ut", "h2s");
            return null;
        }
    }

    private static String f(String str) {
        try {
        } catch (Throwable th) {
            gv.a(th, "ut", "sPa");
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : split) {
            stringBuffer.append(str2);
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2.length() > 1) {
            return (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1);
        }
        return str;
    }

    public static String g(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        if (bArr == null) {
            return null;
        }
        for (byte b4 : bArr) {
            String hexString = Integer.toHexString(b4 & 255);
            if (hexString.length() == 1) {
                hexString = "0".concat(hexString);
            }
            sb2.append(hexString);
        }
        return sb2.toString();
    }

    private static byte[] h(byte[] bArr) throws IOException, Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        if (bArr == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th3) {
            th = th3;
            gZIPOutputStream2 = gZIPOutputStream;
            try {
                throw th;
            } catch (Throwable th4) {
                if (gZIPOutputStream2 != null) {
                    gZIPOutputStream2.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th4;
            }
        }
    }

    public static byte[] c() {
        try {
            String[] split = new StringBuffer("16,16,18,77,15,911,121,77,121,911,38,77,911,99,86,67,611,96,48,77,84,911,38,67,021,301,86,67,611,98,48,77,511,77,48,97,511,58,48,97,511,84,501,87,511,96,48,77,221,911,38,77,121,37,86,67,25,301,86,67,021,96,86,67,021,701,86,67,35,56,86,67,611,37,221,87").reverse().toString().split(",");
            byte[] bArr = new byte[split.length];
            for (int i10 = 0; i10 < split.length; i10++) {
                bArr[i10] = Byte.parseByte(split[i10]);
            }
            String[] split2 = new StringBuffer(new String(fn.b(new String(bArr)))).reverse().toString().split(",");
            byte[] bArr2 = new byte[split2.length];
            for (int i11 = 0; i11 < split2.length; i11++) {
                bArr2[i11] = Byte.parseByte(split2[i11]);
            }
            return bArr2;
        } catch (Throwable th) {
            gv.a(th, "ut", "gIV");
            return new byte[16];
        }
    }

    public static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return fn.a(str).contains(Build.MODEL + Build.VERSION.SDK_INT);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        String c4 = fn.c(a(str));
        try {
            return ((char) ((c4.length() % 26) + 65)) + c4;
        } catch (Throwable th) {
            gv.a(th, "ut", "tsfb64");
            return "";
        }
    }

    public static byte[] b(byte[] bArr) {
        try {
            return h(bArr);
        } catch (Throwable th) {
            gv.a(th, "ut", "gZp");
            return new byte[0];
        }
    }

    private static void g(String str) {
        int i10;
        while (true) {
            if (str.length() < 78) {
                break;
            }
            String substring = str.substring(0, 78);
            StringBuilder sb2 = new StringBuilder("|");
            sb2.append(substring);
            sb2.append("|");
            str = str.substring(78);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("|");
        sb3.append(str);
        for (i10 = 0; i10 < 78 - str.length(); i10++) {
            sb3.append(" ");
        }
        sb3.append("|");
    }

    public static boolean b(Context context) {
        return gs.a(context);
    }

    public static String b(Map<String, String> map) {
        String str;
        if (map != null) {
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (sb2.length() > 0) {
                    sb2.append("&");
                }
                sb2.append(entry.getKey());
                sb2.append("=");
                sb2.append(entry.getValue());
            }
            str = sb2.toString();
        } else {
            str = null;
        }
        return f(str);
    }

    public static String f(byte[] bArr) {
        try {
            return g(bArr);
        } catch (Throwable th) {
            gv.a(th, "ut", "csb2h");
            return null;
        }
    }

    public static byte[] d(byte[] bArr) {
        try {
            return h(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    public static byte[] d(String str) {
        if (str.length() % 2 != 0) {
            str = "0".concat(str);
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = (byte) Integer.parseInt(str.substring(i11, i11 + 2), 16);
        }
        return bArr;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x003c -> B:16:0x005c). Please report as a decompilation issue!!! */
    public static byte[] c(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ZipOutputStream zipOutputStream;
        byte[] bArr2 = null;
        if (bArr != null) {
            try {
            } catch (Throwable th) {
                gv.a(th, "ut", "zp2");
            }
            if (bArr.length != 0) {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        zipOutputStream = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                    zipOutputStream = null;
                }
                try {
                    zipOutputStream.putNextEntry(new ZipEntry(com.mobile.auth.BuildConfig.FLAVOR_type));
                    zipOutputStream.write(bArr);
                    zipOutputStream.closeEntry();
                    zipOutputStream.finish();
                    bArr2 = byteArrayOutputStream.toByteArray();
                    try {
                        zipOutputStream.close();
                    } catch (Throwable th4) {
                        gv.a(th4, "ut", "zp1");
                    }
                    byteArrayOutputStream.close();
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        gv.a(th, "ut", "zp");
                        if (zipOutputStream != null) {
                            try {
                                zipOutputStream.close();
                            } catch (Throwable th6) {
                                gv.a(th6, "ut", "zp1");
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return bArr2;
                    } finally {
                    }
                }
                return bArr2;
            }
        }
        return null;
    }

    public static boolean a(Context context, String str) {
        if (context == null || context.checkCallingOrSelfPermission(str) != 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23 && context.getApplicationInfo().targetSdkVersion >= 23) {
            try {
                if (((Integer) context.getClass().getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() != 0) {
                    return false;
                }
            } catch (Throwable th) {
                gv.a(th, "ut", "cpm");
            }
        }
        return true;
    }

    public static fu a() throws fi {
        return new fu.a("collection", "1.0", "AMap_collection_1.0").a(new String[]{"com.amap.api.collection"}).a();
    }

    public static void a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        if (TextUtils.isEmpty(str)) {
            try {
                byteArrayOutputStream.write(new byte[]{0});
                return;
            } catch (IOException e2) {
                gv.a(e2, "ut", "wsf");
                return;
            }
        }
        int length = str.length();
        if (length > 255) {
            length = 255;
        }
        a(byteArrayOutputStream, (byte) length, a(str));
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    public static byte[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }

    public static void a(ByteArrayOutputStream byteArrayOutputStream, byte b4, byte[] bArr) {
        try {
            byteArrayOutputStream.write(new byte[]{b4});
            int i10 = b4 & 255;
            if (i10 < 255 && i10 > 0) {
                byteArrayOutputStream.write(bArr);
            } else if (i10 == 255) {
                byteArrayOutputStream.write(bArr, 0, 255);
            }
        } catch (IOException e2) {
            gv.a(e2, "ut", "wFie");
        }
    }

    public static boolean a(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.has(str);
    }

    public static String a(Throwable th) {
        StringWriter stringWriter;
        PrintWriter printWriter;
        try {
            stringWriter = new StringWriter();
            try {
                printWriter = new PrintWriter(stringWriter);
            } catch (Throwable th2) {
                th = th2;
                printWriter = null;
            }
        } catch (Throwable th3) {
            th = th3;
            stringWriter = null;
            printWriter = null;
        }
        try {
            th.printStackTrace(printWriter);
            for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            String obj = stringWriter.toString();
            try {
                stringWriter.close();
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
            try {
                printWriter.close();
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            return obj;
        } catch (Throwable th6) {
            th = th6;
            try {
                th.printStackTrace();
                if (stringWriter != null) {
                    try {
                        stringWriter.close();
                    } catch (Throwable th7) {
                        th7.printStackTrace();
                    }
                }
                if (printWriter != null) {
                    try {
                        printWriter.close();
                    } catch (Throwable th8) {
                        th8.printStackTrace();
                    }
                }
                return null;
            } finally {
            }
        }
    }

    public static String a(Map<String, String> map) {
        if (map.size() == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        boolean z10 = true;
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (z10) {
                    z10 = false;
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append("=");
                    stringBuffer.append(entry.getValue());
                } else {
                    stringBuffer.append("&");
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append("=");
                    stringBuffer.append(entry.getValue());
                }
            }
        } catch (Throwable th) {
            gv.a(th, "ut", "abP");
        }
        return stringBuffer.toString();
    }

    public static byte[] a(int i10) {
        return new byte[]{(byte) (i10 / 256), (byte) (i10 % 256)};
    }

    public static String a(long j10) {
        return a(j10, "yyyyMMdd HH:mm:ss:SSS");
    }

    public static String a(long j10, String str) {
        try {
            return new SimpleDateFormat(str, Locale.CHINA).format(new Date(j10));
        } catch (Throwable th) {
            gv.a(th, "ut", "ctt");
            return null;
        }
    }

    public static void a(Context context, String str, String str2, JSONObject jSONObject) {
        String str3;
        String string;
        String e2 = fj.e(context);
        String b4 = fq.b(e2);
        String a10 = fj.a(context);
        try {
            if (jSONObject.has("info")) {
                str3 = jSONObject.getString("info");
                StringBuilder sb2 = new StringBuilder("请在高德开放平台官网中搜索\"");
                sb2.append(str3);
                sb2.append("\"相关内容进行解决");
            } else {
                str3 = "";
            }
            if ("INVALID_USER_SCODE".equals(str3)) {
                String string2 = jSONObject.has("sec_code") ? jSONObject.getString("sec_code") : "";
                string = jSONObject.has("sec_code_debug") ? jSONObject.getString("sec_code_debug") : "";
                if (b4.equals(string2) || b4.equals(string)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(c("C6K+35Zyo6auY5b635byA5pS+5bmz5Y+w5a6Y572R5Lit5pCc57Si"));
                    sb3.append("\"请求内容过长导致业务调用失败\"相关内容进行解决");
                }
            } else if ("INVALID_USER_KEY".equals(str3)) {
                string = jSONObject.has("key") ? jSONObject.getString("key") : "";
                if (string.length() > 0 && !a10.equals(string)) {
                    c("C6K+35Zyo6auY5b635byA5pS+5bmz5Y+w5a6Y572R5LiK5Y+R6LW35oqA5pyv5ZKo6K+i5bel5Y2V4oCUPui0puWPt+S4jktleemXrumimO+8jOWSqOivoklOVkFMSURfVVNFUl9LRVnlpoLkvZXop6PlhrM=");
                }
            }
        } catch (Throwable unused) {
        }
        g("SHA1Package:".concat(String.valueOf(e2)));
        g("key:".concat(String.valueOf(a10)));
        g("csid:".concat(String.valueOf(str)));
        g("gsid:".concat(String.valueOf(str2)));
        g("json:" + jSONObject.toString());
    }

    public static Calendar a(String str, String str2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.CHINA);
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(simpleDateFormat.parse(str));
            calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), calendar2.get(11), calendar2.get(12), calendar2.get(13));
            return calendar;
        } catch (ParseException e2) {
            gv.a(e2, "ut", "ctt");
            return null;
        }
    }
}
