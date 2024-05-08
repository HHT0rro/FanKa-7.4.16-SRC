package com.huawei.ok3httpservice.api;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.ok3httpservice.b;
import com.huawei.serverrequest.api.service.HttpException;
import com.huawei.serverrequest.api.service.HttpRequest;
import com.huawei.serverrequest.api.service.HttpResponse;
import com.huawei.serverrequest.api.service.HttpService;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import xa.c;
import xa.d;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Ok3HttpService implements HttpService {

    /* renamed from: d, reason: collision with root package name */
    private static final String f32097d = "Ok3HttpService";

    /* renamed from: e, reason: collision with root package name */
    private static final int f32098e = 3;

    /* renamed from: f, reason: collision with root package name */
    private static final int f32099f = 6;

    /* renamed from: a, reason: collision with root package name */
    private final Context f32100a;

    /* renamed from: b, reason: collision with root package name */
    private volatile OkHttpClient f32101b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private HttpService.BuildHttpClientDelegate f32102c;

    public Ok3HttpService(@NonNull Context context) {
        this.f32100a = context.getApplicationContext();
    }

    private OkHttpClient a() {
        if (this.f32101b == null) {
            synchronized (Ok3HttpService.class) {
                if (this.f32101b == null) {
                    b bVar = new b();
                    b(bVar.a());
                    HttpService.BuildHttpClientDelegate buildHttpClientDelegate = this.f32102c;
                    if (buildHttpClientDelegate != null) {
                        buildHttpClientDelegate.onBuildHttpClient(bVar);
                    }
                    this.f32101b = bVar.a().build();
                }
            }
        }
        return this.f32101b;
    }

    private void b(OkHttpClient.Builder builder) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout(6L, timeUnit);
        builder.readTimeout(6L, timeUnit);
        builder.writeTimeout(6L, timeUnit);
        a(builder);
    }

    @Override // com.huawei.serverrequest.api.service.HttpService
    @NonNull
    public HttpResponse execute(@NonNull HttpRequest httpRequest) throws HttpException {
        return a(httpRequest, 3);
    }

    @Override // com.huawei.serverrequest.api.service.HttpService
    public void setDelegate(@Nullable HttpService.BuildHttpClientDelegate buildHttpClientDelegate) {
        this.f32102c = buildHttpClientDelegate;
    }

    private void a(OkHttpClient.Builder builder) {
        try {
            builder.sslSocketFactory(c.b(this.f32100a), d.a(this.f32100a));
            builder.hostnameVerifier(new ya.b());
        } catch (IOException | IllegalAccessException | KeyManagementException | KeyStoreException | NoSuchAlgorithmException | CertificateException e2) {
            Log.e(f32097d, "init security ssl errors： " + e2.getMessage());
        }
    }

    @NonNull
    private HttpResponse a(@NonNull HttpRequest httpRequest, int i10) throws HttpException {
        try {
            return a(httpRequest);
        } catch (HttpException e2) {
            if (i10 > 0) {
                if (com.huawei.ok3httpservice.c.a(e2)) {
                    Log.i(f32097d, "retry executeInBackground, request: " + ((Object) httpRequest));
                    return a(httpRequest, i10 - 1);
                }
                throw e2;
            }
            throw e2;
        }
    }

    @NonNull
    private HttpResponse a(@NonNull HttpRequest httpRequest) throws HttpException {
        if (com.huawei.ok3httpservice.d.b(this.f32100a)) {
            Request.Builder url = new Request.Builder().url(httpRequest.url());
            if ("GET".equalsIgnoreCase(httpRequest.method())) {
                url.get();
            } else if ("POST".equalsIgnoreCase(httpRequest.method())) {
                String str = "" + httpRequest.contentType();
                try {
                    url.method(httpRequest.method(), RequestBody.create(MediaType.get(str), httpRequest.body()));
                } catch (Exception unused) {
                    String str2 = "invalid content type: " + str;
                    Log.w(f32097d, str2);
                    throw new HttpException(4, str2);
                }
            } else {
                String str3 = "unsupported method: " + httpRequest.method();
                Log.w(f32097d, str3);
                throw new HttpException(4, str3);
            }
            Call newCall = a().newCall(url.headers(Headers.of(httpRequest.headers())).build());
            try {
                return a(newCall, httpRequest, newCall.execute());
            } catch (InterruptedIOException e2) {
                String str4 = "executeInBackground, timeout, request: " + ((Object) httpRequest) + ", e = " + e2.getMessage();
                Log.e(f32097d, str4);
                throw new HttpException(1, str4, e2);
            } catch (IOException e10) {
                String str5 = "executeInBackground, io exception, request: " + ((Object) httpRequest) + ", e = " + e10.getMessage();
                Log.e(f32097d, str5);
                throw new HttpException(2, str5, e10);
            }
        }
        String str6 = "executeInBackground, no network, request: " + ((Object) httpRequest);
        Log.e(f32097d, str6);
        throw new HttpException(3, str6);
    }

    @NonNull
    private static HttpResponse a(@NonNull final Call call, @NonNull final HttpRequest httpRequest, final Response response) throws HttpException {
        final ResponseBody body = response.body();
        if (body != null) {
            return new HttpResponse() { // from class: com.huawei.ok3httpservice.api.Ok3HttpService.1
                @Override // com.huawei.serverrequest.api.service.HttpResponse
                public void cancel() {
                    call.cancel();
                }

                @Override // com.huawei.serverrequest.api.service.HttpResponse
                public long contentLength() {
                    return body.contentLength();
                }

                @Override // com.huawei.serverrequest.api.service.HttpResponse
                public Map<String, String> headers() {
                    HashMap hashMap = new HashMap();
                    Headers headers = Response.this.headers();
                    for (int i10 = 0; i10 < headers.size(); i10++) {
                        hashMap.put(headers.name(i10), headers.value(i10));
                    }
                    return hashMap;
                }

                @Override // com.huawei.serverrequest.api.service.HttpResponse
                public InputStream inputStream() {
                    return body.byteStream();
                }

                @Override // com.huawei.serverrequest.api.service.HttpResponse
                public int statusCode() {
                    return Response.this.code();
                }

                @Override // com.huawei.serverrequest.api.service.HttpResponse
                public String statusMessage() {
                    return Response.this.message();
                }

                @Override // com.huawei.serverrequest.api.service.HttpResponse
                public String string() throws HttpException {
                    try {
                        return body.string();
                    } catch (IOException e2) {
                        String str = "read response string failed: " + ((Object) httpRequest) + ", e = " + e2.getMessage();
                        Log.e(Ok3HttpService.f32097d, str);
                        throw new HttpException(2, str, e2);
                    }
                }

                @Override // com.huawei.serverrequest.api.service.HttpResponse
                @NonNull
                public String url() {
                    return Response.this.request().url().url().toString();
                }
            };
        }
        String str = "missing response body for request: " + ((Object) httpRequest);
        Log.e(f32097d, str);
        throw new HttpException(2, str);
    }
}
