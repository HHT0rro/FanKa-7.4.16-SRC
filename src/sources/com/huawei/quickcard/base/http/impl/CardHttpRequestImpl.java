package com.huawei.quickcard.base.http.impl;

import androidx.annotation.NonNull;
import com.huawei.quickcard.base.http.CardHttpRequest;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CardHttpRequestImpl implements CardHttpRequest {

    /* renamed from: a, reason: collision with root package name */
    private String f33360a;

    /* renamed from: b, reason: collision with root package name */
    private CardHttpRequest.RequestMethod f33361b;

    /* renamed from: c, reason: collision with root package name */
    private String f33362c;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f33363d;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, String> f33364e;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private String f33365a;

        /* renamed from: b, reason: collision with root package name */
        private CardHttpRequest.RequestMethod f33366b;

        /* renamed from: c, reason: collision with root package name */
        private String f33367c;

        /* renamed from: d, reason: collision with root package name */
        private byte[] f33368d;

        /* renamed from: e, reason: collision with root package name */
        private Map<String, String> f33369e = new LinkedHashMap(4);

        private Builder() {
        }

        public static Builder create() {
            return new Builder();
        }

        public Builder addHeaders(String str, String str2) {
            this.f33369e.put(str, str2);
            return this;
        }

        public Builder body(byte[] bArr) {
            this.f33368d = bArr;
            return this;
        }

        public CardHttpRequestImpl build() {
            CardHttpRequestImpl cardHttpRequestImpl = new CardHttpRequestImpl();
            cardHttpRequestImpl.f33360a = this.f33365a;
            cardHttpRequestImpl.f33363d = this.f33368d;
            cardHttpRequestImpl.f33362c = this.f33367c;
            cardHttpRequestImpl.f33361b = this.f33366b;
            cardHttpRequestImpl.f33364e = this.f33369e;
            return cardHttpRequestImpl;
        }

        public Builder contentType(String str) {
            this.f33367c = str;
            return this;
        }

        public Builder method(CardHttpRequest.RequestMethod requestMethod) {
            this.f33366b = requestMethod;
            return this;
        }

        public Builder removeHeader(String str) {
            this.f33369e.remove(str);
            return this;
        }

        public Builder uri(String str) {
            this.f33365a = str;
            return this;
        }

        public Builder addHeaders(Map<String, String> map) {
            this.f33369e.putAll(map);
            return this;
        }
    }

    @Override // com.huawei.quickcard.base.http.CardHttpRequest
    @NonNull
    public byte[] body() {
        byte[] bArr = this.f33363d;
        return bArr == null ? new byte[0] : (byte[]) bArr.clone();
    }

    @Override // com.huawei.quickcard.base.http.CardHttpRequest
    @NonNull
    public String contentType() {
        return this.f33362c;
    }

    @Override // com.huawei.quickcard.base.http.CardHttpRequest
    @NonNull
    public Map<String, String> headers() {
        return this.f33364e;
    }

    @Override // com.huawei.quickcard.base.http.CardHttpRequest
    @NonNull
    public CardHttpRequest.RequestMethod method() {
        return this.f33361b;
    }

    @Override // com.huawei.quickcard.base.http.CardHttpRequest
    @NonNull
    public String url() {
        return this.f33360a;
    }
}
