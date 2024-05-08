package com.huawei.serverrequest;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.by;
import com.huawei.serverrequest.api.ServerResponse;
import com.huawei.serverrequest.api.service.HttpException;
import com.huawei.serverrequest.api.service.HttpResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Map;

/* compiled from: ServerResponseImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class f implements ServerResponse {

    /* renamed from: a, reason: collision with root package name */
    private final ServerResponse.ResponseBody f34817a;

    /* renamed from: b, reason: collision with root package name */
    private final ServerResponse.ResponseType f34818b;

    public f(a aVar, ServerResponse.ResponseType responseType) {
        this.f34817a = aVar;
        this.f34818b = responseType;
    }

    @Override // com.huawei.serverrequest.api.ServerResponse
    @NonNull
    public ServerResponse.ResponseBody getResponse() {
        return this.f34817a;
    }

    @Override // com.huawei.serverrequest.api.ServerResponse
    @NonNull
    public ServerResponse.ResponseType getResponseType() {
        return this.f34818b;
    }

    /* compiled from: ServerResponseImpl.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements ServerResponse.ResponseBody {

        /* renamed from: a, reason: collision with root package name */
        private boolean f34819a = false;

        /* renamed from: b, reason: collision with root package name */
        private final long f34820b;

        /* renamed from: c, reason: collision with root package name */
        private final InputStream f34821c;

        /* renamed from: d, reason: collision with root package name */
        private String f34822d;

        /* renamed from: e, reason: collision with root package name */
        private HttpResponse f34823e;

        public a(String str) {
            this.f34822d = str;
            this.f34821c = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
            this.f34820b = str.getBytes(StandardCharsets.UTF_8).length;
        }

        @Override // com.huawei.serverrequest.api.service.HttpResponse
        public void cancel() {
            HttpResponse httpResponse;
            if (this.f34819a || (httpResponse = this.f34823e) == null) {
                return;
            }
            httpResponse.cancel();
            this.f34819a = true;
        }

        @Override // com.huawei.serverrequest.api.service.HttpResponse
        public long contentLength() {
            return this.f34820b;
        }

        @Override // com.huawei.serverrequest.api.service.HttpResponse
        public Map<String, String> headers() {
            HttpResponse httpResponse = this.f34823e;
            if (httpResponse != null) {
                return httpResponse.headers();
            }
            return Collections.emptyMap();
        }

        @Override // com.huawei.serverrequest.api.service.HttpResponse
        public InputStream inputStream() {
            return this.f34821c;
        }

        @Override // com.huawei.serverrequest.api.service.HttpResponse
        public int statusCode() {
            HttpResponse httpResponse = this.f34823e;
            if (httpResponse != null) {
                return httpResponse.statusCode();
            }
            return 200;
        }

        @Override // com.huawei.serverrequest.api.service.HttpResponse
        public String statusMessage() {
            HttpResponse httpResponse = this.f34823e;
            return httpResponse != null ? httpResponse.statusMessage() : by.f9988k;
        }

        @Override // com.huawei.serverrequest.api.service.HttpResponse
        public String string() throws HttpException {
            synchronized (f.class) {
                if (TextUtils.isEmpty(this.f34822d)) {
                    synchronized (f.class) {
                        this.f34822d = this.f34823e.string();
                        this.f34819a = true;
                    }
                }
            }
            return this.f34822d;
        }

        @Override // com.huawei.serverrequest.api.service.HttpResponse
        @NonNull
        public String url() {
            HttpResponse httpResponse = this.f34823e;
            return httpResponse != null ? httpResponse.url() : "";
        }

        public a(HttpResponse httpResponse) {
            this.f34823e = httpResponse;
            this.f34821c = httpResponse.inputStream();
            this.f34820b = httpResponse.contentLength();
        }
    }
}
