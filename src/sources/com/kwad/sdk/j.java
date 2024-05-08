package com.kwad.sdk;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.kwad.framework.filedownloader.f.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.q;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class j implements com.kwad.framework.filedownloader.a.b {
    private final OkHttpClient akO;
    private final Request.Builder akP;
    private Request akQ;
    private Response akR;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a implements c.b {
        private volatile OkHttpClient akO;
        private OkHttpClient.Builder akS;

        public a() {
        }

        public a(boolean z10) {
            if (z10) {
                this.akS = j.zb();
            } else {
                this.akS = j.zc();
            }
        }

        @Override // com.kwad.framework.filedownloader.f.c.b
        public final com.kwad.framework.filedownloader.a.b be(String str) {
            if (this.akO == null) {
                synchronized (a.class) {
                    if (this.akO == null) {
                        OkHttpClient.Builder builder = this.akS;
                        this.akO = builder != null ? builder.build() : new OkHttpClient();
                        this.akS = null;
                    }
                }
            }
            return new j(str, this.akO, (byte) 0);
        }
    }

    public /* synthetic */ j(String str, OkHttpClient okHttpClient, byte b4) {
        this(str, okHttpClient);
    }

    private String bX(String str) {
        String bd2 = bd("Content-Type");
        String extension = q.getExtension(str);
        String str2 = ".apk";
        if (!TextUtils.isEmpty(bd2) && TextUtils.isEmpty(extension)) {
            String extensionFromMimeType = MimeTypeMap.getSingleton().getExtensionFromMimeType(bd2);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(System.currentTimeMillis());
            if (!TextUtils.isEmpty(extensionFromMimeType)) {
                str2 = "." + extensionFromMimeType;
            }
            sb2.append(str2);
            return sb2.toString();
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        return System.currentTimeMillis() + ".apk";
    }

    private static OkHttpClient.Builder yZ() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return builder.connectTimeout(10000L, timeUnit).addInterceptor(new com.kwad.sdk.k.a()).readTimeout(0L, timeUnit).connectionPool(new ConnectionPool(6, 60000L, timeUnit)).retryOnConnectionFailure(true);
    }

    private static OkHttpClient.Builder za() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return builder.connectTimeout(10000L, timeUnit).addInterceptor(new com.kwad.sdk.k.a()).protocols(Util.immutableList(new Protocol[]{Protocol.HTTP_1_1})).readTimeout(0L, timeUnit).connectionPool(new ConnectionPool(6, 60000L, timeUnit)).retryOnConnectionFailure(true);
    }

    public static /* synthetic */ OkHttpClient.Builder zb() {
        return za();
    }

    public static /* synthetic */ OkHttpClient.Builder zc() {
        return yZ();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void addHeader(String str, String str2) {
        this.akP.addHeader(str, str2);
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final String bd(String str) {
        String str2;
        if ("Content-Disposition".equals(str)) {
            try {
            } catch (Exception unused) {
                str2 = "";
            }
            if (TextUtils.isEmpty(com.kwad.framework.filedownloader.f.f.bv(this.akR.header(str)))) {
                str2 = this.akR.request().url().pathSegments().get(r3.size() - 1);
                return "attachment; filename=\"" + bX(str2) + "\"";
            }
            return this.akR.header(str);
        }
        Response response = this.akR;
        if (response == null) {
            return null;
        }
        return response.header(str);
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void execute() {
        if (this.akQ == null) {
            this.akQ = this.akP.build();
        }
        this.akR = this.akO.newCall(this.akQ).execute();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final InputStream getInputStream() {
        Response response = this.akR;
        if (response != null) {
            return ((com.kwad.sdk.service.a.j) ServiceProvider.get(com.kwad.sdk.service.a.j.class)).wrapInputStream(response.body().byteStream());
        }
        throw new IllegalStateException("Please invoke #execute first!");
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final int getResponseCode() {
        Response response = this.akR;
        if (response != null) {
            return response.code();
        }
        throw new IllegalStateException("Please invoke #execute first!");
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final Map<String, List<String>> vc() {
        if (this.akQ == null) {
            this.akQ = this.akP.build();
        }
        return this.akQ.headers().toMultimap();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final Map<String, List<String>> vd() {
        Response response = this.akR;
        if (response == null) {
            return null;
        }
        return response.headers().toMultimap();
    }

    @Override // com.kwad.framework.filedownloader.a.b
    public final void ve() {
        this.akQ = null;
        Response response = this.akR;
        if (response != null && response.body() != null) {
            com.kwad.sdk.crash.utils.b.closeQuietly(this.akR.body());
        }
        this.akR = null;
    }

    private j(Request.Builder builder, OkHttpClient okHttpClient) {
        this.akP = builder;
        this.akO = okHttpClient;
    }

    private j(String str, OkHttpClient okHttpClient) {
        this(new Request.Builder().url(str), okHttpClient);
    }
}
