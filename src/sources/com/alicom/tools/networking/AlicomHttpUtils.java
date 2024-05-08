package com.alicom.tools.networking;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.security.realidentity.build.cs;
import com.wangmai.okhttp.model.HttpHeaders;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AlicomHttpUtils {
    private static ConcurrentHashMap<String, HostnameVerifier> mHostnameVerifiers = new ConcurrentHashMap<>();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.net.URL] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.alicom.tools.networking.Request] */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v24, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r8v0, types: [int] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v20, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [int] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19, types: [java.io.Reader, java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public static String callApi(Request request, int i10, int i11, int i12) throws IOException {
        HttpURLConnection httpURLConnection;
        Throwable th;
        BufferedReader bufferedReader;
        IOException e2;
        SocketTimeoutException e10;
        ?? url = new URL(request.getBaseUrl());
        String buildTopRequestParamas = i12 != 0 ? request.buildTopRequestParamas() : request.buildPopRequestParamas();
        byte[] bArr = new byte[0];
        if (buildTopRequestParamas != null) {
            bArr = buildTopRequestParamas.getBytes("utf-8");
        }
        try {
            try {
                httpURLConnection = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestMethod(request.getRequestMethod());
                    httpURLConnection.setConnectTimeout(i10);
                    httpURLConnection.setReadTimeout(i11);
                    httpURLConnection.setRequestProperty(cs.U, url.getHost());
                    httpURLConnection.setRequestProperty(HttpHeaders.HEAD_KEY_ACCEPT, "text/xml,text/javascript");
                    httpURLConnection.setRequestProperty("User-Agent", "top-sdk-java");
                    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
                    httpURLConnection.connect();
                    request = httpURLConnection.getOutputStream();
                    try {
                        request.write(bArr);
                        i10 = httpURLConnection.getInputStream();
                        try {
                            i11 = new InputStreamReader((InputStream) i10, "utf-8");
                        } catch (SocketTimeoutException e11) {
                            bufferedReader = null;
                            e10 = e11;
                            i11 = 0;
                        } catch (IOException e12) {
                            bufferedReader = null;
                            e2 = e12;
                            i11 = 0;
                        } catch (Throwable th2) {
                            url = 0;
                            th = th2;
                            i11 = 0;
                        }
                    } catch (SocketTimeoutException e13) {
                        i11 = 0;
                        bufferedReader = null;
                        e10 = e13;
                        i10 = 0;
                    } catch (IOException e14) {
                        i11 = 0;
                        bufferedReader = null;
                        e2 = e14;
                        i10 = 0;
                    } catch (Throwable th3) {
                        i11 = 0;
                        url = 0;
                        th = th3;
                        i10 = 0;
                    }
                } catch (SocketTimeoutException e15) {
                    i10 = 0;
                    i11 = 0;
                    bufferedReader = null;
                    e10 = e15;
                    request = 0;
                } catch (IOException e16) {
                    i10 = 0;
                    i11 = 0;
                    bufferedReader = null;
                    e2 = e16;
                    request = 0;
                } catch (Throwable th4) {
                    i10 = 0;
                    i11 = 0;
                    url = 0;
                    th = th4;
                    request = 0;
                }
            } catch (SocketTimeoutException e17) {
                i10 = 0;
                i11 = 0;
                bufferedReader = null;
                httpURLConnection = null;
                e10 = e17;
                request = 0;
            } catch (IOException e18) {
                i10 = 0;
                i11 = 0;
                bufferedReader = null;
                httpURLConnection = null;
                e2 = e18;
                request = 0;
            } catch (Throwable th5) {
                i10 = 0;
                i11 = 0;
                url = 0;
                httpURLConnection = null;
                th = th5;
                request = 0;
            }
            try {
                bufferedReader = new BufferedReader(i11);
            } catch (SocketTimeoutException e19) {
                bufferedReader = null;
                e10 = e19;
            } catch (IOException e20) {
                bufferedReader = null;
                e2 = e20;
            } catch (Throwable th6) {
                url = 0;
                th = th6;
                if (i10 != 0) {
                    try {
                        i10.close();
                    } catch (Throwable th7) {
                        th7.printStackTrace();
                        throw th;
                    }
                }
                if (i11 != 0) {
                    i11.close();
                }
                if (url != 0) {
                    url.close();
                }
                if (request != 0) {
                    request.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
            try {
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    stringBuffer.append(readLine);
                }
                String str = new String(stringBuffer);
                if (i10 != 0) {
                    try {
                        i10.close();
                    } catch (Throwable th8) {
                        th8.printStackTrace();
                    }
                }
                i11.close();
                bufferedReader.close();
                request.close();
                httpURLConnection.disconnect();
                return str;
            } catch (SocketTimeoutException e21) {
                e10 = e21;
                String stackTraceString = Log.getStackTraceString(e10);
                if (i10 != 0) {
                    try {
                        i10.close();
                    } catch (Throwable th9) {
                        th9.printStackTrace();
                        return stackTraceString;
                    }
                }
                if (i11 != 0) {
                    i11.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (request != 0) {
                    request.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return stackTraceString;
            } catch (IOException e22) {
                e2 = e22;
                String stackTraceString2 = Log.getStackTraceString(e2);
                if (i10 != 0) {
                    try {
                        i10.close();
                    } catch (Throwable th10) {
                        th10.printStackTrace();
                        return stackTraceString2;
                    }
                }
                if (i11 != 0) {
                    i11.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (request != 0) {
                    request.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return stackTraceString2;
            }
        } catch (Throwable th11) {
            th = th11;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0181 A[Catch: all -> 0x017d, TryCatch #18 {all -> 0x017d, blocks: (B:58:0x0179, B:45:0x0181, B:47:0x0186, B:49:0x018b, B:51:0x0190), top: B:57:0x0179 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0186 A[Catch: all -> 0x017d, TryCatch #18 {all -> 0x017d, blocks: (B:58:0x0179, B:45:0x0181, B:47:0x0186, B:49:0x018b, B:51:0x0190), top: B:57:0x0179 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x018b A[Catch: all -> 0x017d, TryCatch #18 {all -> 0x017d, blocks: (B:58:0x0179, B:45:0x0181, B:47:0x0186, B:49:0x018b, B:51:0x0190), top: B:57:0x0179 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0190 A[Catch: all -> 0x017d, TRY_LEAVE, TryCatch #18 {all -> 0x017d, blocks: (B:58:0x0179, B:45:0x0181, B:47:0x0186, B:49:0x018b, B:51:0x0190), top: B:57:0x0179 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0179 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0154 A[Catch: all -> 0x0150, TryCatch #8 {all -> 0x0150, blocks: (B:77:0x014c, B:64:0x0154, B:66:0x0159, B:68:0x015e, B:70:0x0163), top: B:76:0x014c }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0159 A[Catch: all -> 0x0150, TryCatch #8 {all -> 0x0150, blocks: (B:77:0x014c, B:64:0x0154, B:66:0x0159, B:68:0x015e, B:70:0x0163), top: B:76:0x014c }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x015e A[Catch: all -> 0x0150, TryCatch #8 {all -> 0x0150, blocks: (B:77:0x014c, B:64:0x0154, B:66:0x0159, B:68:0x015e, B:70:0x0163), top: B:76:0x014c }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0163 A[Catch: all -> 0x0150, TRY_LEAVE, TryCatch #8 {all -> 0x0150, blocks: (B:77:0x014c, B:64:0x0154, B:66:0x0159, B:68:0x015e, B:70:0x0163), top: B:76:0x014c }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x014c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01a3 A[Catch: all -> 0x019f, TryCatch #21 {all -> 0x019f, blocks: (B:95:0x019b, B:82:0x01a3, B:84:0x01a8, B:86:0x01ad, B:88:0x01b2), top: B:94:0x019b }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01a8 A[Catch: all -> 0x019f, TryCatch #21 {all -> 0x019f, blocks: (B:95:0x019b, B:82:0x01a3, B:84:0x01a8, B:86:0x01ad, B:88:0x01b2), top: B:94:0x019b }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01ad A[Catch: all -> 0x019f, TryCatch #21 {all -> 0x019f, blocks: (B:95:0x019b, B:82:0x01a3, B:84:0x01a8, B:86:0x01ad, B:88:0x01b2), top: B:94:0x019b }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01b2 A[Catch: all -> 0x019f, TRY_LEAVE, TryCatch #21 {all -> 0x019f, blocks: (B:95:0x019b, B:82:0x01a3, B:84:0x01a8, B:86:0x01ad, B:88:0x01b2), top: B:94:0x019b }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x019b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.alicom.tools.networking.Request] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v23, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v35 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v0, types: [int] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25, types: [java.io.Reader, java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v28 */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v30 */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String callHttpsApi(com.alicom.tools.networking.Request r7, int r8, int r9, int r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 442
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alicom.tools.networking.AlicomHttpUtils.callHttpsApi(com.alicom.tools.networking.Request, int, int, int):java.lang.String");
    }

    public static String getHostnameFromUrl(String str) {
        try {
            return new URL(str).getHost();
        } catch (MalformedURLException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static HostnameVerifier getHostnameVerifierByUrl(String str) {
        String hostnameFromUrl = getHostnameFromUrl(str);
        if (mHostnameVerifiers != null && !TextUtils.isEmpty(hostnameFromUrl) && mHostnameVerifiers.containsKey(hostnameFromUrl)) {
            return mHostnameVerifiers.get(hostnameFromUrl);
        }
        HostnameVerifier hostnameVerifier = new HostnameVerifier() { // from class: com.alicom.tools.networking.AlicomHttpUtils.1
            @Override // javax.net.ssl.HostnameVerifier
            public boolean verify(String str2, SSLSession sSLSession) {
                return HttpsURLConnection.getDefaultHostnameVerifier().verify(str2, sSLSession);
            }
        };
        if (mHostnameVerifiers == null) {
            mHostnameVerifiers = new ConcurrentHashMap<>();
        }
        mHostnameVerifiers.put(hostnameFromUrl, hostnameVerifier);
        return hostnameVerifier;
    }

    private static String getResponseAsString(HttpURLConnection httpURLConnection) throws IOException {
        String responseCharset = getResponseCharset(httpURLConnection.getContentType());
        if (httpURLConnection.getResponseCode() < 400) {
            return "gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding()) ? getStreamAsString(new GZIPInputStream(httpURLConnection.getInputStream()), responseCharset) : getStreamAsString(httpURLConnection.getInputStream(), responseCharset);
        }
        throw new IOException(httpURLConnection.getResponseCode() + " " + httpURLConnection.getResponseMessage());
    }

    private static String getResponseCharset(String str) {
        if (isNotEmpty(str)) {
            String[] split = str.split(";");
            int length = split.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                String trim = split[i10].trim();
                if (trim.startsWith("charset")) {
                    String[] split2 = trim.split("=", 2);
                    if (split2.length == 2 && isNotEmpty(split2[1])) {
                        return split2[1].trim();
                    }
                } else {
                    i10++;
                }
            }
        }
        return "utf-8";
    }

    private static String getStreamAsString(InputStream inputStream, String str) throws IOException {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, str);
            StringBuilder sb2 = new StringBuilder();
            char[] cArr = new char[1024];
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read <= 0) {
                    break;
                }
                sb2.append(cArr, 0, read);
            }
            return sb2.toString();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    private static boolean isNotEmpty(String str) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            for (int i10 = 0; i10 < length; i10++) {
                if (!Character.isWhitespace(str.charAt(i10))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0144 A[Catch: all -> 0x0140, TryCatch #0 {all -> 0x0140, blocks: (B:56:0x013c, B:43:0x0144, B:45:0x0149, B:47:0x014e, B:49:0x0153), top: B:55:0x013c }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0149 A[Catch: all -> 0x0140, TryCatch #0 {all -> 0x0140, blocks: (B:56:0x013c, B:43:0x0144, B:45:0x0149, B:47:0x014e, B:49:0x0153), top: B:55:0x013c }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x014e A[Catch: all -> 0x0140, TryCatch #0 {all -> 0x0140, blocks: (B:56:0x013c, B:43:0x0144, B:45:0x0149, B:47:0x014e, B:49:0x0153), top: B:55:0x013c }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0153 A[Catch: all -> 0x0140, TRY_LEAVE, TryCatch #0 {all -> 0x0140, blocks: (B:56:0x013c, B:43:0x0144, B:45:0x0149, B:47:0x014e, B:49:0x0153), top: B:55:0x013c }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0117 A[Catch: all -> 0x0113, TryCatch #12 {all -> 0x0113, blocks: (B:75:0x010f, B:62:0x0117, B:64:0x011c, B:66:0x0121, B:68:0x0126), top: B:74:0x010f }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011c A[Catch: all -> 0x0113, TryCatch #12 {all -> 0x0113, blocks: (B:75:0x010f, B:62:0x0117, B:64:0x011c, B:66:0x0121, B:68:0x0126), top: B:74:0x010f }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0121 A[Catch: all -> 0x0113, TryCatch #12 {all -> 0x0113, blocks: (B:75:0x010f, B:62:0x0117, B:64:0x011c, B:66:0x0121, B:68:0x0126), top: B:74:0x010f }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0126 A[Catch: all -> 0x0113, TRY_LEAVE, TryCatch #12 {all -> 0x0113, blocks: (B:75:0x010f, B:62:0x0117, B:64:0x011c, B:66:0x0121, B:68:0x0126), top: B:74:0x010f }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x010f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0166 A[Catch: all -> 0x0162, TryCatch #2 {all -> 0x0162, blocks: (B:93:0x015e, B:80:0x0166, B:82:0x016b, B:84:0x0170, B:86:0x0175), top: B:92:0x015e }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x016b A[Catch: all -> 0x0162, TryCatch #2 {all -> 0x0162, blocks: (B:93:0x015e, B:80:0x0166, B:82:0x016b, B:84:0x0170, B:86:0x0175), top: B:92:0x015e }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0170 A[Catch: all -> 0x0162, TryCatch #2 {all -> 0x0162, blocks: (B:93:0x015e, B:80:0x0166, B:82:0x016b, B:84:0x0170, B:86:0x0175), top: B:92:0x015e }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0175 A[Catch: all -> 0x0162, TRY_LEAVE, TryCatch #2 {all -> 0x0162, blocks: (B:93:0x015e, B:80:0x0166, B:82:0x016b, B:84:0x0170, B:86:0x0175), top: B:92:0x015e }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x015e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.alicom.tools.networking.Request] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v20, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v0, types: [int] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v23, types: [java.io.Reader, java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v26 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v28 */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String postHttps(com.alicom.tools.networking.Request r7, int r8, int r9, int r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 381
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alicom.tools.networking.AlicomHttpUtils.postHttps(com.alicom.tools.networking.Request, int, int, int):java.lang.String");
    }
}
