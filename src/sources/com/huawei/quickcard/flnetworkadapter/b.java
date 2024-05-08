package com.huawei.quickcard.flnetworkadapter;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.http.ContentType;
import com.huawei.serverrequest.api.ServerRequest;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b implements ServerRequest {

    /* renamed from: a, reason: collision with root package name */
    private String f33703a;

    /* renamed from: b, reason: collision with root package name */
    private String f33704b;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, String> f33705c;

    /* renamed from: d, reason: collision with root package name */
    private String f33706d;

    /* renamed from: e, reason: collision with root package name */
    private String f33707e;

    /* renamed from: f, reason: collision with root package name */
    private ServerRequest.RequestType f33708f;

    /* renamed from: g, reason: collision with root package name */
    private String f33709g;

    /* renamed from: h, reason: collision with root package name */
    private long f33710h;

    /* renamed from: i, reason: collision with root package name */
    private String f33711i;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private String f33712a;

        /* renamed from: b, reason: collision with root package name */
        private String f33713b = ContentType.TEXT_PLAIN_UTF8;

        /* renamed from: c, reason: collision with root package name */
        private Map<String, String> f33714c;

        /* renamed from: d, reason: collision with root package name */
        private String f33715d;

        /* renamed from: e, reason: collision with root package name */
        private String f33716e;

        /* renamed from: f, reason: collision with root package name */
        private ServerRequest.RequestType f33717f;

        /* renamed from: g, reason: collision with root package name */
        private String f33718g;

        /* renamed from: h, reason: collision with root package name */
        private long f33719h;

        /* renamed from: i, reason: collision with root package name */
        private String f33720i;

        private a() {
        }

        public static a b() {
            return new a();
        }

        public a a(Map<String, String> map) {
            this.f33714c = map;
            return this;
        }

        public a c(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f33713b = str;
            }
            return this;
        }

        public a d(String str) {
            this.f33716e = str;
            return this;
        }

        public a e(String str) {
            this.f33720i = str;
            return this;
        }

        public a f(String str) {
            this.f33712a = str;
            return this;
        }

        public a a(String str) {
            this.f33715d = str;
            return this;
        }

        public a b(String str) {
            this.f33718g = str;
            return this;
        }

        public a a(ServerRequest.RequestType requestType) {
            this.f33717f = requestType;
            return this;
        }

        public a a(long j10) {
            this.f33719h = j10;
            return this;
        }

        public b a() {
            b bVar = new b();
            bVar.f33705c = this.f33714c;
            bVar.f33709g = this.f33718g;
            bVar.f33706d = this.f33715d;
            bVar.f33707e = this.f33716e;
            bVar.f33708f = this.f33717f;
            bVar.f33703a = this.f33712a;
            bVar.f33704b = this.f33713b;
            bVar.f33710h = this.f33719h;
            bVar.f33711i = this.f33720i;
            return bVar;
        }
    }

    @Override // com.huawei.serverrequest.api.ServerRequest
    @NonNull
    public String getBody() throws Exception {
        return this.f33706d;
    }

    @Override // com.huawei.serverrequest.api.ServerRequest
    public long getCacheExpireTime() {
        return this.f33710h;
    }

    @Override // com.huawei.serverrequest.api.ServerRequest
    public String getCacheId() {
        return this.f33709g;
    }

    @Override // com.huawei.serverrequest.api.ServerRequest
    @NonNull
    public String getContentType() {
        return this.f33704b;
    }

    @Override // com.huawei.serverrequest.api.ServerRequest
    @NonNull
    public Map<String, String> getHeaders() {
        return this.f33705c;
    }

    @Override // com.huawei.serverrequest.api.ServerRequest
    public String getId() {
        return this.f33707e;
    }

    @Override // com.huawei.serverrequest.api.ServerRequest
    public ServerRequest.RequestType getRequestType() {
        return this.f33708f;
    }

    @Override // com.huawei.serverrequest.api.ServerRequest
    @NonNull
    public String getUrl() {
        return this.f33703a;
    }

    @Override // com.huawei.serverrequest.api.ServerRequest
    @NonNull
    public String method() {
        return this.f33711i;
    }
}
