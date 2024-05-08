package com.mobile.auth.d;

import android.content.Context;
import android.text.TextUtils;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final String f36758a = "d";

    /* JADX WARN: Removed duplicated region for block: B:53:0x00f5 A[Catch: Exception -> 0x00f1, all -> 0x0117, TryCatch #5 {all -> 0x0117, blocks: (B:3:0x0010, B:6:0x001a, B:46:0x00cb, B:36:0x00d3, B:38:0x00d8, B:42:0x00dc, B:60:0x00ed, B:53:0x00f5, B:55:0x00fa, B:77:0x0102, B:66:0x010a, B:68:0x010f, B:73:0x0116, B:72:0x0113, B:50:0x00e4), top: B:2:0x0010, inners: #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00fa A[Catch: Exception -> 0x00f1, all -> 0x0117, TRY_LEAVE, TryCatch #5 {all -> 0x0117, blocks: (B:3:0x0010, B:6:0x001a, B:46:0x00cb, B:36:0x00d3, B:38:0x00d8, B:42:0x00dc, B:60:0x00ed, B:53:0x00f5, B:55:0x00fa, B:77:0x0102, B:66:0x010a, B:68:0x010f, B:73:0x0116, B:72:0x0113, B:50:0x00e4), top: B:2:0x0010, inners: #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r16, java.lang.String r17, android.net.Network r18) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.auth.d.d.a(android.content.Context, java.lang.String, android.net.Network):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0123, code lost:
    
        if (r1 != null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0125, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0290, code lost:
    
        if (r1 == null) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x024a, code lost:
    
        if (r1 == null) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0204, code lost:
    
        if (r1 == null) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01be, code lost:
    
        if (r1 == null) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0179, code lost:
    
        if (r1 == null) goto L114;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x028d A[Catch: all -> 0x0294, TRY_ENTER, TRY_LEAVE, TryCatch #14 {all -> 0x0294, blocks: (B:43:0x0120, B:45:0x0125, B:73:0x0176, B:68:0x01bb, B:63:0x0201, B:58:0x0247, B:53:0x028d), top: B:11:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0247 A[Catch: all -> 0x0294, TRY_ENTER, TRY_LEAVE, TryCatch #14 {all -> 0x0294, blocks: (B:43:0x0120, B:45:0x0125, B:73:0x0176, B:68:0x01bb, B:63:0x0201, B:58:0x0247, B:53:0x028d), top: B:11:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0201 A[Catch: all -> 0x0294, TRY_ENTER, TRY_LEAVE, TryCatch #14 {all -> 0x0294, blocks: (B:43:0x0120, B:45:0x0125, B:73:0x0176, B:68:0x01bb, B:63:0x0201, B:58:0x0247, B:53:0x028d), top: B:11:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01bb A[Catch: all -> 0x0294, TRY_ENTER, TRY_LEAVE, TryCatch #14 {all -> 0x0294, blocks: (B:43:0x0120, B:45:0x0125, B:73:0x0176, B:68:0x01bb, B:63:0x0201, B:58:0x0247, B:53:0x028d), top: B:11:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0176 A[Catch: all -> 0x0294, TRY_ENTER, TRY_LEAVE, TryCatch #14 {all -> 0x0294, blocks: (B:43:0x0120, B:45:0x0125, B:73:0x0176, B:68:0x01bb, B:63:0x0201, B:58:0x0247, B:53:0x028d), top: B:11:0x001b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r15, java.lang.String r16, java.lang.String r17, android.net.Network r18, java.lang.String r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 684
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.auth.d.d.a(android.content.Context, java.lang.String, java.lang.String, android.net.Network, java.lang.String, java.lang.String):java.lang.String");
    }

    public static String a(Context context, HttpsURLConnection httpsURLConnection) {
        try {
            Map<String, List<String>> headerFields = httpsURLConnection.getHeaderFields();
            List<String> list = headerFields.get("Log-Level");
            if (list != null && !list.isEmpty()) {
                for (int i10 = 0; i10 < list.size(); i10++) {
                    String str = list.get(0);
                    if (!TextUtils.isEmpty(str)) {
                        com.mobile.auth.c.e.b(context, str);
                    }
                }
            }
            List<String> list2 = headerFields.get("p-ikgx");
            if (list2 != null && !list2.isEmpty()) {
                String str2 = list2.get(0);
                if (!TextUtils.isEmpty(str2)) {
                    return str2;
                }
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
            } catch (Throwable th2) {
                try {
                    ExceptionProcessor.processException(th2);
                    return null;
                } catch (Throwable th3) {
                    ExceptionProcessor.processException(th3);
                    return null;
                }
            }
        }
        return null;
    }

    public static final HostnameVerifier a() {
        try {
            return new HostnameVerifier() { // from class: com.mobile.auth.d.d.1
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    try {
                        return HttpsURLConnection.getDefaultHostnameVerifier().verify("id6.me", sSLSession);
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
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }
}
