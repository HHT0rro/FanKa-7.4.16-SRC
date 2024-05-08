package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import com.kwad.sdk.utils.ap;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class j extends p {
    private final com.kwad.sdk.core.videocache.d.c aBJ;
    private final com.kwad.sdk.core.videocache.b.b aBK;
    private n aCh;
    private InputStream aCj;
    private OkHttpClient aCo = new OkHttpClient();

    public j(String str, com.kwad.sdk.core.videocache.d.c cVar, com.kwad.sdk.core.videocache.b.b bVar) {
        this.aBJ = (com.kwad.sdk.core.videocache.d.c) ap.checkNotNull(cVar);
        this.aBK = (com.kwad.sdk.core.videocache.b.b) ap.checkNotNull(bVar);
        n eJ = cVar.eJ(str);
        this.aCh = eJ == null ? new n(str, -2147483648L, l.eH(str)) : eJ;
    }

    private void Gx() {
        Response response = null;
        try {
            try {
                response = du(10000);
            } catch (IOException unused) {
                com.kwad.sdk.core.e.c.e("HttpUrlSource", "Error fetching info from " + this.aCh.url);
                if (0 == 0 || response.body() == null) {
                    return;
                }
            }
            if (response != null && response.isSuccessful()) {
                n nVar = new n(this.aCh.url, c(response), response.header("Content-Type"));
                this.aCh = nVar;
                this.aBJ.a(nVar.url, nVar);
                com.kwad.sdk.core.e.c.d("HttpUrlSource", "Source info fetched: " + ((Object) this.aCh));
                if (response.body() == null) {
                    return;
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(response.body());
                return;
            }
            throw new ProxyCacheException("Fail to fetchContentInfo: " + getUrl());
        } catch (Throwable th) {
            if (0 != 0 && response.body() != null) {
                com.kwad.sdk.crash.utils.b.closeQuietly(response.body());
            }
            throw th;
        }
    }

    private void Gz() {
        n eJ;
        com.kwad.sdk.core.videocache.d.c cVar = this.aBJ;
        if (cVar == null || !(cVar instanceof com.kwad.sdk.core.videocache.d.b) || (eJ = cVar.eJ(getUrl())) == null || TextUtils.isEmpty(eJ.aCy) || eJ.aCx == -2147483648L) {
            return;
        }
        this.aCh = eJ;
    }

    private long a(Response response, long j10) {
        int code = response.code();
        long contentLength = response.body().contentLength();
        return code == 200 ? contentLength : code == 206 ? contentLength + j10 : this.aCh.aCx;
    }

    private static long c(Response response) {
        String header = response.header("Content-Length");
        if (header == null) {
            return -1L;
        }
        return Long.parseLong(header);
    }

    private Response d(long j10, int i10) {
        Response execute;
        OkHttpClient.Builder newBuilder = this.aCo.newBuilder();
        int i11 = 0;
        newBuilder.connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
        try {
            newBuilder.dns(new com.kwad.sdk.core.network.a.d());
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
        this.aCo = newBuilder.build();
        String url = getUrl();
        boolean z10 = false;
        do {
            Request.Builder builder = new Request.Builder();
            builder.get();
            builder.url(url);
            if (j10 > 0) {
                builder.addHeader("Range", "bytes=" + j10 + "-");
            }
            execute = this.aCo.newCall(builder.build()).execute();
            if (execute.isRedirect()) {
                url = execute.header("Location");
                z10 = execute.isRedirect();
                i11++;
            }
            if (i11 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i11);
            }
        } while (z10);
        return execute;
    }

    private Response du(int i10) {
        Response execute;
        OkHttpClient.Builder newBuilder = new OkHttpClient().newBuilder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        newBuilder.connectTimeout(10000L, timeUnit);
        newBuilder.readTimeout(10000L, timeUnit);
        newBuilder.writeTimeout(10000L, timeUnit);
        int i11 = 0;
        newBuilder.connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
        try {
            newBuilder.dns(new com.kwad.sdk.core.network.a.d());
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTrace(th);
        }
        this.aCo = newBuilder.build();
        String url = getUrl();
        boolean z10 = false;
        do {
            Request.Builder builder = new Request.Builder();
            builder.head();
            builder.url(url);
            execute = this.aCo.newCall(builder.build()).execute();
            if (execute.isRedirect()) {
                url = execute.header("Location");
                z10 = execute.isRedirect();
                i11++;
            }
            if (i11 > 5) {
                throw new ProxyCacheException("Too many redirects: " + i11);
            }
        } while (z10);
        return execute;
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final synchronized String Gy() {
        if (TextUtils.isEmpty(this.aCh.aCy)) {
            Gz();
        }
        if (TextUtils.isEmpty(this.aCh.aCy)) {
            Gx();
        }
        return this.aCh.aCy;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void at(long j10) {
        try {
            Response d10 = d(j10, -1);
            String mediaType = d10.body().contentType().toString();
            long a10 = a(d10, j10);
            this.aCj = new BufferedInputStream(d10.body().byteStream(), 1024);
            n nVar = new n(this.aCh.url, a10, mediaType);
            this.aCh = nVar;
            this.aBJ.a(nVar.url, nVar);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error opening connection for " + getUrl() + " with offset " + j10, e2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final void close() {
        com.kwad.sdk.crash.utils.b.closeQuietly(this.aCj);
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final String getUrl() {
        return this.aCh.url;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final synchronized long length() {
        if (this.aCh.aCx == -2147483648L) {
            Gz();
        }
        if (this.aCh.aCx == -2147483648L) {
            Gx();
        }
        return this.aCh.aCx;
    }

    @Override // com.kwad.sdk.core.videocache.m
    public final int read(byte[] bArr) {
        InputStream inputStream = this.aCj;
        if (inputStream != null) {
            try {
                return inputStream.read(bArr, 0, 1024);
            } catch (InterruptedIOException e2) {
                throw new InterruptedProxyCacheException("Reading source " + this.aCh.url + " is interrupted", e2);
            } catch (IOException e10) {
                throw new ProxyCacheException("Error reading data from " + this.aCh.url, e10);
            }
        }
        throw new ProxyCacheException("Error reading data from " + this.aCh.url + ": connection is absent!");
    }

    @Override // com.kwad.sdk.core.videocache.p
    public final String toString() {
        return "HttpUrlSource{sourceInfo='" + ((Object) this.aCh) + com.alipay.sdk.util.i.f4738d;
    }

    public j(j jVar) {
        this.aCh = jVar.aCh;
        this.aBJ = jVar.aBJ;
        this.aBK = jVar.aBK;
    }
}
