package com.huawei.quickcard.okhttp;

import androidx.annotation.NonNull;
import com.huawei.quickcard.base.http.CardHttpResponse;
import java.io.IOException;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b implements CardHttpResponse {

    /* renamed from: a, reason: collision with root package name */
    private int f34153a;

    /* renamed from: b, reason: collision with root package name */
    private String f34154b;

    /* renamed from: c, reason: collision with root package name */
    private String f34155c;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, Object> f34156d;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private int f34157a;

        /* renamed from: b, reason: collision with root package name */
        private String f34158b;

        /* renamed from: c, reason: collision with root package name */
        private String f34159c;

        /* renamed from: d, reason: collision with root package name */
        private Map<String, Object> f34160d;

        private a() {
        }

        public static a b() {
            return new a();
        }

        public a a(int i10) {
            this.f34157a = i10;
            return this;
        }

        public a a(String str) {
            this.f34159c = str;
            return this;
        }

        public a b(String str) {
            this.f34158b = str;
            return this;
        }

        public a a(Map<String, Object> map) {
            this.f34160d = map;
            return this;
        }

        public b a() {
            b bVar = new b();
            bVar.f34153a = this.f34157a;
            bVar.f34154b = this.f34158b;
            bVar.f34155c = this.f34159c;
            bVar.f34156d = this.f34160d;
            return bVar;
        }
    }

    @Override // com.huawei.quickcard.base.http.CardHttpResponse
    public int getCode() {
        return this.f34153a;
    }

    @Override // com.huawei.quickcard.base.http.CardHttpResponse
    public Map<String, Object> getHeaders() {
        return this.f34156d;
    }

    @Override // com.huawei.quickcard.base.http.CardHttpResponse
    public String getMessage() {
        return this.f34155c;
    }

    @Override // com.huawei.quickcard.base.http.CardHttpResponse
    @NonNull
    public String getResponse() throws IOException {
        return this.f34154b;
    }

    @Override // com.huawei.quickcard.base.http.CardHttpResponse
    public /* synthetic */ boolean isSuccessful() {
        return com.huawei.quickcard.base.http.a.a(this);
    }
}
