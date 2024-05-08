package com.alibaba.minilibc.android;

import android.os.Build;
import com.alibaba.security.realidentity.http.BaseHttpManager;
import com.alibaba.wireless.security.framework.utils.UserTrackMethodJniBridge;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class HttpClientUtils {
    private static final boolean DEBUG = false;
    private static final int ERROR_HANDLER_METHOD_ID_DOWNLOAD_FILE_FAILED = 100168;
    private static final String TAG = "HttpClientUtils";
    public static final int TIMEOUT_DEFAULT = 22000;
    public static final int TIMEOUT_MIN = 0;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
    public static class ResCode {
        public static final int CUSTOM_SSL_HANDSHAKE_ERROR = 1004;
        public static final int CUSTOM_UNKONW_HOST = 1003;
        public static final int EXCEPTION = 1002;
        public static final int HTTP_RESPONSE_NULL = 1000;
        public static final int REQ_PARAM_INVALID = 400;
        public static final int STATUS_OK = 200;
        public static final int UNKNOWN = -1;
    }

    private static void disconnect(URLConnection uRLConnection) {
        if (uRLConnection != null) {
            try {
                if (uRLConnection instanceof HttpsURLConnection) {
                    ((HttpsURLConnection) uRLConnection).disconnect();
                } else if (uRLConnection instanceof HttpURLConnection) {
                    ((HttpURLConnection) uRLConnection).disconnect();
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x012a, code lost:
    
        if (r11 != null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x012c, code lost:
    
        r0 = r11.length;
        r10 = r10;
        r12 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x012d, code lost:
    
        r10.m2917(r0);
        r10.m2921(r12);
        r10.m2924(r7);
        r10.m2918(r13 - r2);
        r10.m2922(r2);
        com.taobao.wireless.security.adapter.datareport.C0606.m2912(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0187, code lost:
    
        if (r11 != null) goto L68;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x018c: MOVE (r1 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:133:0x018c */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x016f A[Catch: Exception -> 0x016b, TRY_LEAVE, TryCatch #3 {Exception -> 0x016b, blocks: (B:89:0x0167, B:81:0x016f), top: B:88:0x0167 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0167 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0197 A[Catch: Exception -> 0x0193, TRY_LEAVE, TryCatch #7 {Exception -> 0x0193, blocks: (B:110:0x018f, B:98:0x0197), top: B:109:0x018f }] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v4, types: [com.taobao.wireless.security.adapter.datareport.а$в] */
    /* JADX WARN: Type inference failed for: r12v1, types: [int] */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.alibaba.minilibc.android.HttpClientResult doHttpPost(java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10, byte[] r11, java.lang.String r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 462
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.minilibc.android.HttpClientUtils.doHttpPost(java.lang.String, java.util.Map, byte[], java.lang.String, int, int):com.alibaba.minilibc.android.HttpClientResult");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0204 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x019c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0195 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0261 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x025a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x029c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0216  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean downloadFile(java.lang.String r30, java.lang.String r31) {
        /*
            Method dump skipped, instructions count: 722
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.minilibc.android.HttpClientUtils.downloadFile(java.lang.String, java.lang.String):boolean");
    }

    private static URLConnection getDefaultURLConnection(String str, int i10, int i11, String str2) {
        URLConnection uRLConnection = null;
        try {
        } catch (Throwable th) {
            UserTrackMethodJniBridge.addUtRecord("100168", 1, 0, "", 0L, th.getMessage(), str, "", "", "");
        }
        if (!str.startsWith("http")) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        uRLConnection = new URL(str).openConnection();
        if (i10 <= 0) {
            i10 = TIMEOUT_DEFAULT;
        }
        if (i11 <= 0) {
            i11 = TIMEOUT_DEFAULT;
        }
        if (str.startsWith("https")) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnection;
            httpsURLConnection.setConnectTimeout(i10);
            httpsURLConnection.setReadTimeout(i11);
            httpsURLConnection.setRequestMethod(str2);
        } else {
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
            httpURLConnection.setConnectTimeout(i10);
            httpURLConnection.setReadTimeout(i11);
            httpURLConnection.setRequestMethod(str2);
        }
        uRLConnection.setUseCaches(false);
        if ("POST".equals(str2)) {
            uRLConnection.setRequestProperty("Content-Type", "text/plain;charset=UTF-8");
            uRLConnection.setDoOutput(true);
        }
        uRLConnection.setRequestProperty(BaseHttpManager.HTTP_REQ_PROPERTY_CHARSET, "UTF-8");
        return uRLConnection;
    }

    private static int getResponseCode(URLConnection uRLConnection) throws IOException {
        return uRLConnection instanceof HttpsURLConnection ? ((HttpsURLConnection) uRLConnection).getResponseCode() : ((HttpURLConnection) uRLConnection).getResponseCode();
    }
}
