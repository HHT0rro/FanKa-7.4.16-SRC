package com.huawei.quickcard.flnetworkadapter;

import androidx.annotation.NonNull;
import com.huawei.quickcard.base.http.CardHttpResponse;
import java.io.IOException;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c implements CardHttpResponse {

    /* renamed from: a, reason: collision with root package name */
    private int f33721a;

    /* renamed from: b, reason: collision with root package name */
    private String f33722b;

    /* renamed from: c, reason: collision with root package name */
    private String f33723c;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, Object> f33724d;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f33725a;

        /* renamed from: b, reason: collision with root package name */
        private String f33726b;

        /* renamed from: c, reason: collision with root package name */
        private String f33727c;

        /* renamed from: d, reason: collision with root package name */
        private Map<String, Object> f33728d;

        private a() {
        }

        public static a b() {
            return new a();
        }

        public a a(int i10) {
            this.f33725a = i10;
            return this;
        }

        public a a(String str) {
            this.f33727c = str;
            return this;
        }

        public a b(String str) {
            this.f33726b = str;
            return this;
        }

        public a a(Map<String, Object> map) {
            this.f33728d = map;
            return this;
        }

        public c a() {
            c cVar = new c();
            cVar.f33721a = this.f33725a;
            cVar.f33723c = this.f33727c;
            cVar.f33722b = this.f33726b;
            cVar.f33724d = this.f33728d;
            return cVar;
        }
    }

    @Override // com.huawei.quickcard.base.http.CardHttpResponse
    public int getCode() {
        return this.f33721a;
    }

    @Override // com.huawei.quickcard.base.http.CardHttpResponse
    public Map<String, Object> getHeaders() {
        return this.f33724d;
    }

    @Override // com.huawei.quickcard.base.http.CardHttpResponse
    public String getMessage() {
        return this.f33723c;
    }

    @Override // com.huawei.quickcard.base.http.CardHttpResponse
    @NonNull
    public String getResponse() throws IOException {
        return this.f33722b;
    }

    @Override // com.huawei.quickcard.base.http.CardHttpResponse
    public /* synthetic */ boolean isSuccessful() {
        return com.huawei.quickcard.base.http.a.a(this);
    }
}
