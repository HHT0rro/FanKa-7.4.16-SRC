package com.kwad.sdk.api.loader;

import android.view.autofill.AutofillManager;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import com.wangmai.okhttp.model.HttpHeaders;
import java.io.Closeable;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class i {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(java.lang.String r6, java.io.File r7) {
        /*
            r0 = 0
            boolean r1 = r7.exists()     // Catch: java.lang.Throwable -> L46
            if (r1 == 0) goto La
            com.kwad.sdk.api.loader.h.j(r7)     // Catch: java.lang.Throwable -> L46
        La:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L46
            r2 = 0
            r1.<init>(r7, r2)     // Catch: java.lang.Throwable -> L46
            java.net.HttpURLConnection r6 = cc(r6)     // Catch: java.lang.Throwable -> L42
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L3b
            java.io.InputStream r3 = r6.getInputStream()     // Catch: java.lang.Throwable -> L3b
            r7.<init>(r3)     // Catch: java.lang.Throwable -> L3b
            r0 = 10240(0x2800, float:1.4349E-41)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L36
        L21:
            int r3 = r7.read(r0)     // Catch: java.lang.Throwable -> L36
            r4 = -1
            if (r3 == r4) goto L2c
            r1.write(r0, r2, r3)     // Catch: java.lang.Throwable -> L36
            goto L21
        L2c:
            closeQuietly(r1)
            closeQuietly(r7)
            r6.disconnect()
            return
        L36:
            r0 = move-exception
            r5 = r1
            r1 = r6
            r6 = r0
            goto L40
        L3b:
            r7 = move-exception
            r5 = r1
            r1 = r6
            r6 = r7
            r7 = r0
        L40:
            r0 = r5
            goto L49
        L42:
            r6 = move-exception
            r7 = r0
            r0 = r1
            goto L48
        L46:
            r6 = move-exception
            r7 = r0
        L48:
            r1 = r7
        L49:
            closeQuietly(r0)
            closeQuietly(r7)
            if (r1 == 0) goto L54
            r1.disconnect()
        L54:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.api.loader.i.c(java.lang.String, java.io.File):void");
    }

    private static HttpURLConnection cc(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        TLSConnectionUtils.wrapHttpURLConnection(httpURLConnection);
        httpURLConnection.setRequestProperty(HttpHeaders.HEAD_KEY_ACCEPT_LANGUAGE, "zh-CN");
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(AutofillManager.MAX_TEMP_AUGMENTED_SERVICE_DURATION_MS);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty(HttpHeaders.HEAD_KEY_CONNECTION, HttpHeaders.HEAD_VALUE_CONNECTION_KEEP_ALIVE);
        httpURLConnection.setRequestProperty("Charset", "UTF-8");
        return httpURLConnection;
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
