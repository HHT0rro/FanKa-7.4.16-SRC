package ga;

import android.content.Context;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public URLConnection f49423a;

    public final void a(Closeable closeable) {
        StringBuilder sb2;
        String exc;
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                sb2 = new StringBuilder();
                sb2.append("close IO IOException:");
                exc = e2.toString();
                sb2.append(exc);
                fa.a.c("IoUtils", sb2.toString());
            } catch (Exception e10) {
                sb2 = new StringBuilder();
                sb2.append("close IO execption:");
                exc = e10.toString();
                sb2.append(exc);
                fa.a.c("IoUtils", sb2.toString());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a A[Catch: all -> 0x0066, IOException -> 0x0068, TryCatch #0 {IOException -> 0x0068, blocks: (B:3:0x0005, B:5:0x0025, B:8:0x002e, B:9:0x003e, B:10:0x0043, B:12:0x004a, B:15:0x0055, B:33:0x0034), top: B:2:0x0005, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(java.net.URLConnection r6, java.io.InputStream r7, da.a r8) {
        /*
            r5 = this;
            java.lang.String r0 = "close error"
            java.lang.String r1 = "HTTPUtil"
            r2 = 0
            java.lang.String r6 = r6.getContentEncoding()     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L68
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L68
            r3.<init>()     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L68
            java.lang.String r4 = "parseHttpResponse contentType ="
            r3.append(r4)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L68
            r3.append(r6)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L68
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L68
            fa.a.a(r1, r3)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L68
            java.lang.String r3 = "gzip"
            boolean r3 = r3.equals(r6)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L68
            if (r3 != 0) goto L34
            java.lang.String r3 = "z"
            boolean r6 = r3.equals(r6)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L68
            if (r6 == 0) goto L2e
            goto L34
        L2e:
            java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L68
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L68
            goto L3e
        L34:
            java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L68
            java.util.zip.GZIPInputStream r3 = new java.util.zip.GZIPInputStream     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L68
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L68
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L68
        L3e:
            r2 = r6
            r6 = 65536(0x10000, float:9.18355E-41)
            byte[] r6 = new byte[r6]     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L68
        L43:
            int r7 = r2.read(r6)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L68
            r3 = -1
            if (r7 == r3) goto L70
            r8.c(r6, r7)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L68
            int r7 = r8.e()     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L68
            r3 = 4194304(0x400000, float:5.877472E-39)
            if (r7 <= r3) goto L43
            r8.b()     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L68
            java.lang.String r6 = "File being unzipped is too big."
            fa.a.c(r1, r6)     // Catch: java.lang.Throwable -> L66 java.io.IOException -> L68
            r2.close()     // Catch: java.io.IOException -> L61
            goto L65
        L61:
            r6 = move-exception
            fa.a.b(r1, r0, r6)
        L65:
            return
        L66:
            r6 = move-exception
            goto L79
        L68:
            r6 = move-exception
            java.lang.String r7 = "parseHttpResponse error!"
            fa.a.b(r1, r7, r6)     // Catch: java.lang.Throwable -> L66
            if (r2 == 0) goto L78
        L70:
            r2.close()     // Catch: java.io.IOException -> L74
            goto L78
        L74:
            r6 = move-exception
            fa.a.b(r1, r0, r6)
        L78:
            return
        L79:
            if (r2 == 0) goto L83
            r2.close()     // Catch: java.io.IOException -> L7f
            goto L83
        L7f:
            r7 = move-exception
            fa.a.b(r1, r0, r7)
        L83:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ga.b.b(java.net.URLConnection, java.io.InputStream, da.a):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [ga.b] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.Closeable] */
    public byte[] c(Context context, String str, String str2, String str3) {
        OutputStream outputStream;
        da.a aVar = new da.a();
        InputStream inputStream = null;
        try {
            try {
                URLConnection openConnection = new URL(str).openConnection();
                this.f49423a = openConnection;
                if (openConnection instanceof HttpURLConnection) {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setRequestMethod("POST");
                }
                URLConnection uRLConnection = this.f49423a;
                if (uRLConnection instanceof HttpsURLConnection) {
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnection;
                    httpsURLConnection.setSSLSocketFactory(xa.b.b(context));
                    httpsURLConnection.setHostnameVerifier(xa.b.f54584j);
                }
                this.f49423a.setConnectTimeout(5000);
                this.f49423a.setDoInput(true);
                this.f49423a.setDoOutput(true);
                this.f49423a.setReadTimeout(10000);
                this.f49423a.setDefaultUseCaches(false);
                this.f49423a.setUseCaches(false);
                this.f49423a.setRequestProperty("Content-Type", "application/x-gzip");
                this.f49423a.setRequestProperty("Content-Encoding", "gzip");
                this.f49423a.setRequestProperty("User-Agent", d.b(context));
                outputStream = this.f49423a.getOutputStream();
            } catch (IOException e2) {
                throw e2;
            } catch (Exception e10) {
                throw e10;
            } catch (Throwable th) {
                th = th;
                str = 0;
            }
            try {
                outputStream.write(a.a(str2.getBytes(str3)));
                outputStream.flush();
                if (this.f49423a instanceof HttpURLConnection) {
                    fa.a.d("HTTPUtil", "ResponseCode:" + ((HttpURLConnection) this.f49423a).getResponseCode());
                }
                inputStream = this.f49423a.getInputStream();
                b(this.f49423a, inputStream, aVar);
                if (inputStream != null) {
                    a(inputStream);
                }
                a(outputStream);
                URLConnection uRLConnection2 = this.f49423a;
                if (uRLConnection2 instanceof HttpURLConnection) {
                    ((HttpURLConnection) uRLConnection2).disconnect();
                }
                return aVar.d();
            } catch (IOException e11) {
                throw e11;
            } catch (Exception e12) {
                throw e12;
            } catch (Throwable th2) {
                str = outputStream;
                th = th2;
                if (inputStream != null) {
                    a(inputStream);
                }
                if (str != 0) {
                    a(str);
                }
                URLConnection uRLConnection3 = this.f49423a;
                if (uRLConnection3 instanceof HttpURLConnection) {
                    ((HttpURLConnection) uRLConnection3).disconnect();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
