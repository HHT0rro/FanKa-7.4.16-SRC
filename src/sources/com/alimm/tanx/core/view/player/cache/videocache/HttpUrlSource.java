package com.alimm.tanx.core.view.player.cache.videocache;

import android.text.TextUtils;
import com.alimm.tanx.core.view.player.cache.videocache.headers.EmptyHeadersInjector;
import com.alimm.tanx.core.view.player.cache.videocache.headers.HeaderInjector;
import com.alimm.tanx.core.view.player.cache.videocache.log.Logger;
import com.alimm.tanx.core.view.player.cache.videocache.log.LoggerFactory;
import com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorage;
import com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorageFactory;
import com.alipay.sdk.util.i;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class HttpUrlSource implements Source {
    public static final Logger LOG = LoggerFactory.getLogger("HttpUrlSource");
    public static final int MAX_REDIRECTS = 5;
    public HttpURLConnection connection;
    public final HeaderInjector headerInjector;
    public InputStream inputStream;
    public SourceInfo sourceInfo;
    public final SourceInfoStorage sourceInfoStorage;

    public HttpUrlSource(String str) {
        this(str, SourceInfoStorageFactory.newEmptySourceInfoStorage());
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void fetchContentInfo() throws com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheException {
        /*
            r10 = this;
            com.alimm.tanx.core.view.player.cache.videocache.log.Logger r0 = com.alimm.tanx.core.view.player.cache.videocache.HttpUrlSource.LOG
            r1 = 1
            java.lang.String[] r2 = new java.lang.String[r1]
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Read content info from "
            r3.append(r4)
            com.alimm.tanx.core.view.player.cache.videocache.SourceInfo r4 = r10.sourceInfo
            java.lang.String r4 = r4.url
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r4 = 0
            r2[r4] = r3
            r0.debug(r2)
            r2 = 0
            r5 = 10000(0x2710, float:1.4013E-41)
            r6 = 0
            java.net.HttpURLConnection r2 = r10.openConnection(r2, r5)     // Catch: java.lang.Throwable -> L6d java.io.IOException -> L70
            long r7 = r10.getContentLength(r2)     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L69
            java.lang.String r3 = r2.getContentType()     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L69
            java.io.InputStream r6 = r2.getInputStream()     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L69
            com.alimm.tanx.core.view.player.cache.videocache.SourceInfo r5 = new com.alimm.tanx.core.view.player.cache.videocache.SourceInfo     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L69
            com.alimm.tanx.core.view.player.cache.videocache.SourceInfo r9 = r10.sourceInfo     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L69
            java.lang.String r9 = r9.url     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L69
            r5.<init>(r9, r7, r3)     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L69
            r10.sourceInfo = r5     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L69
            com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorage r3 = r10.sourceInfoStorage     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L69
            java.lang.String r7 = r5.url     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L69
            r3.put(r7, r5)     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L69
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L69
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L69
            r3.<init>()     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L69
            java.lang.String r5 = "Source info fetched: "
            r3.append(r5)     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L69
            com.alimm.tanx.core.view.player.cache.videocache.SourceInfo r5 = r10.sourceInfo     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L69
            r3.append(r5)     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L69
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L69
            r1[r4] = r3     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L69
            r0.debug(r1)     // Catch: java.lang.Throwable -> L65 java.io.IOException -> L69
            com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheUtils.close(r6)
            goto L92
        L65:
            r0 = move-exception
            r1 = r6
            r6 = r2
            goto L97
        L69:
            r0 = move-exception
            r1 = r6
            r6 = r2
            goto L72
        L6d:
            r0 = move-exception
            r1 = r6
            goto L97
        L70:
            r0 = move-exception
            r1 = r6
        L72:
            com.alimm.tanx.core.view.player.cache.videocache.log.Logger r2 = com.alimm.tanx.core.view.player.cache.videocache.HttpUrlSource.LOG     // Catch: java.lang.Throwable -> L96
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L96
            r3.<init>()     // Catch: java.lang.Throwable -> L96
            java.lang.String r4 = "Error fetching info from "
            r3.append(r4)     // Catch: java.lang.Throwable -> L96
            com.alimm.tanx.core.view.player.cache.videocache.SourceInfo r4 = r10.sourceInfo     // Catch: java.lang.Throwable -> L96
            java.lang.String r4 = r4.url     // Catch: java.lang.Throwable -> L96
            r3.append(r4)     // Catch: java.lang.Throwable -> L96
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L96
            r2.error(r3, r0)     // Catch: java.lang.Throwable -> L96
            com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheUtils.close(r1)
            if (r6 == 0) goto L95
            r2 = r6
        L92:
            r2.disconnect()
        L95:
            return
        L96:
            r0 = move-exception
        L97:
            com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheUtils.close(r1)
            if (r6 == 0) goto L9f
            r6.disconnect()
        L9f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.view.player.cache.videocache.HttpUrlSource.fetchContentInfo():void");
    }

    private long getContentLength(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    private void injectCustomHeaders(HttpURLConnection httpURLConnection, String str) {
        for (Map.Entry<String, String> entry : this.headerInjector.addHeaders(str).entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    private HttpURLConnection openConnection(long j10, int i10) throws IOException, ProxyCacheException {
        boolean z10;
        String str;
        HttpURLConnection httpURLConnection;
        String str2 = this.sourceInfo.url;
        int i11 = 0;
        do {
            Logger logger = LOG;
            z10 = true;
            String[] strArr = new String[1];
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Open connection ");
            if (j10 > 0) {
                str = " with offset " + j10;
            } else {
                str = "";
            }
            sb2.append(str);
            sb2.append(" to ");
            sb2.append(str2);
            strArr[0] = sb2.toString();
            logger.debug(strArr);
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            injectCustomHeaders(httpURLConnection, str2);
            if (j10 > 0) {
                httpURLConnection.setRequestProperty("Range", "bytes=" + j10 + "-");
            }
            if (i10 > 0) {
                httpURLConnection.setConnectTimeout(i10);
                httpURLConnection.setReadTimeout(i10);
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 301 && responseCode != 302 && responseCode != 303) {
                z10 = false;
            }
            if (z10) {
                str2 = httpURLConnection.getHeaderField("Location");
                i11++;
                httpURLConnection.disconnect();
            }
            if (i11 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i11);
            }
        } while (z10);
        return httpURLConnection;
    }

    private long readSourceAvailableBytes(HttpURLConnection httpURLConnection, long j10, int i10) throws IOException {
        long contentLength = getContentLength(httpURLConnection);
        return i10 == 200 ? contentLength : i10 == 206 ? contentLength + j10 : this.sourceInfo.length;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Source
    public void close() throws ProxyCacheException {
        HttpURLConnection httpURLConnection = this.connection;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (ArrayIndexOutOfBoundsException e2) {
                LOG.error("Error closing connection correctly. Should happen only on Android L. If anybody know how to fix it, please visit https://github.com/danikula/AndroidVideoCache/issues/88. Until good solution is not know, just ignore this issue :(", e2);
            } catch (IllegalArgumentException e10) {
                e = e10;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            } catch (NullPointerException e11) {
                e = e11;
                throw new RuntimeException("Wait... but why? WTF!? Really shouldn't happen any more after fixing https://github.com/danikula/AndroidVideoCache/issues/43. If you read it on your device log, please, notify me danikula@gmail.com or create issue here https://github.com/danikula/AndroidVideoCache/issues.", e);
            }
        }
    }

    public synchronized String getMime() throws ProxyCacheException {
        if (TextUtils.isEmpty(this.sourceInfo.mime)) {
            fetchContentInfo();
        }
        return this.sourceInfo.mime;
    }

    public String getUrl() {
        return this.sourceInfo.url;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Source
    public synchronized long length() throws ProxyCacheException {
        if (this.sourceInfo.length == -2147483648L) {
            fetchContentInfo();
        }
        return this.sourceInfo.length;
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Source
    public void open(long j10) throws ProxyCacheException {
        try {
            HttpURLConnection openConnection = openConnection(j10, -1);
            this.connection = openConnection;
            String contentType = openConnection.getContentType();
            this.inputStream = new BufferedInputStream(this.connection.getInputStream(), 8192);
            HttpURLConnection httpURLConnection = this.connection;
            SourceInfo sourceInfo = new SourceInfo(this.sourceInfo.url, readSourceAvailableBytes(httpURLConnection, j10, httpURLConnection.getResponseCode()), contentType);
            this.sourceInfo = sourceInfo;
            this.sourceInfoStorage.put(sourceInfo.url, sourceInfo);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error opening connection for " + this.sourceInfo.url + " with offset " + j10, e2);
        }
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.Source
    public int read(byte[] bArr) throws ProxyCacheException {
        InputStream inputStream = this.inputStream;
        if (inputStream != null) {
            try {
                return inputStream.read(bArr, 0, bArr.length);
            } catch (InterruptedIOException e2) {
                throw new InterruptedProxyCacheException("Reading source " + this.sourceInfo.url + " is interrupted", e2);
            } catch (IOException e10) {
                throw new ProxyCacheException("Error reading data from " + this.sourceInfo.url, e10);
            }
        }
        throw new ProxyCacheException("Error reading data from " + this.sourceInfo.url + ": connection is absent!");
    }

    public String toString() {
        return "HttpUrlSource{sourceInfo='" + ((Object) this.sourceInfo) + i.f4738d;
    }

    public HttpUrlSource(String str, SourceInfoStorage sourceInfoStorage) {
        this(str, sourceInfoStorage, new EmptyHeadersInjector());
    }

    public HttpUrlSource(String str, SourceInfoStorage sourceInfoStorage, HeaderInjector headerInjector) {
        this.sourceInfoStorage = (SourceInfoStorage) Preconditions.checkNotNull(sourceInfoStorage);
        this.headerInjector = (HeaderInjector) Preconditions.checkNotNull(headerInjector);
        SourceInfo sourceInfo = sourceInfoStorage.get(str);
        this.sourceInfo = sourceInfo == null ? new SourceInfo(str, -2147483648L, ProxyCacheUtils.getSupposablyMime(str)) : sourceInfo;
    }

    public HttpUrlSource(HttpUrlSource httpUrlSource) {
        this.sourceInfo = httpUrlSource.sourceInfo;
        this.sourceInfoStorage = httpUrlSource.sourceInfoStorage;
        this.headerInjector = httpUrlSource.headerInjector;
    }
}
