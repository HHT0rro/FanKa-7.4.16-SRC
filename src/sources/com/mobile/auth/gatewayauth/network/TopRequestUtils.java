package com.mobile.auth.gatewayauth.network;

import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.annotations.SafeProtector;
import com.mobile.auth.gatewayauth.utils.j;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import p.a;

@SafeProtector
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TopRequestUtils {
    private static final String APP_KEY = "25331768";
    private static final String CHARSET_UTF8 = "utf-8";
    private static final String CONTENT_ENCODING_GZIP = "gzip";
    private static final String SERVER_URL_HOST;
    private static final String SIGN_METHOD_HMAC = "hmac";
    private static final String SIGN_METHOD_MD5 = "md5";
    private static final HostnameVerifier mHostVerifier;

    static {
        a.a("pns-2.13.2.1-LogOnlineStandardCuumRelease_alijtca_plus");
        SERVER_URL_HOST = j.a("https://dypnsapi.aliyuncs.com/?");
        mHostVerifier = new HostnameVerifier() { // from class: com.mobile.auth.gatewayauth.network.TopRequestUtils.1
            @Override // javax.net.ssl.HostnameVerifier
            public boolean verify(String str, SSLSession sSLSession) {
                try {
                    return HttpsURLConnection.getDefaultHostnameVerifier().verify(TopRequestUtils.SERVER_URL_HOST, sSLSession);
                } catch (Throwable th) {
                    try {
                        ExceptionProcessor.processException(th);
                        return false;
                    } catch (Throwable th2) {
                        ExceptionProcessor.processException(th2);
                        return false;
                    }
                }
            }
        };
    }

    private static native Map<String, String> assembleTopParameter(String str) throws IOException;

    private static native String buildQuery(Map<String, String> map, String str) throws IOException;

    private static native String byte2hex(byte[] bArr);

    private static native String callApi(URL url, Map<String, String> map) throws IOException;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0120  */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r2v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v18, types: [java.io.Reader, java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.net.URL] */
    /* JADX WARN: Type inference failed for: r6v18, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String callHttpsApi(java.net.URL r6, java.util.Map<java.lang.String, java.lang.String> r7) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.auth.gatewayauth.network.TopRequestUtils.callHttpsApi(java.net.URL, java.util.Map):java.lang.String");
    }

    private static native byte[] encryptHMAC(String str, String str2) throws IOException;

    private static native byte[] encryptMD5(String str) throws IOException;

    private static native byte[] encryptMD5(byte[] bArr) throws IOException;

    public static native String getLifeBodyVerifyCertifyID(String str) throws IOException;

    private static native String getResponseAsString(HttpURLConnection httpURLConnection) throws IOException;

    private static native String getResponseCharset(String str);

    public static native String getSDKConfig(String str) throws IOException;

    private static native String getSecret1();

    private static native String getSecret2();

    private static native String getSecret3();

    private static native String getSecret4();

    private static native String getStreamAsString(InputStream inputStream, String str) throws IOException;

    public static native String getVendorList(String str, String str2) throws IOException;

    private static native boolean isNotEmpty(String str);

    private static native String signTopRequest(Map<String, String> map, String str, String str2) throws IOException;

    public static native String uploadUserTrackInfo(String str) throws IOException;
}
