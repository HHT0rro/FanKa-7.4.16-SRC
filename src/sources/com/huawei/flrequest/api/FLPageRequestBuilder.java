package com.huawei.flrequest.api;

import android.content.Context;
import androidx.annotation.NonNull;
import com.huawei.flrequest.impl.page.FLPageRequestImpl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLPageRequestBuilder {

    /* renamed from: a, reason: collision with root package name */
    private Context f28698a;

    /* renamed from: b, reason: collision with root package name */
    private String f28699b;

    /* renamed from: c, reason: collision with root package name */
    private Object f28700c;

    /* renamed from: d, reason: collision with root package name */
    private String f28701d;

    /* renamed from: e, reason: collision with root package name */
    private FLRequestType f28702e = FLRequestType.REQUEST_SERVER;

    public FLPageRequestBuilder(@NonNull Context context) {
        this.f28698a = context;
    }

    public FLPageRequest build() throws FLRequestException {
        FLPageRequestImpl fLPageRequestImpl = new FLPageRequestImpl(this.f28698a);
        fLPageRequestImpl.setPageId(this.f28699b);
        fLPageRequestImpl.setRequestType(this.f28702e);
        fLPageRequestImpl.setExtra(this.f28700c);
        fLPageRequestImpl.setReferrer(this.f28701d);
        return fLPageRequestImpl;
    }

    public FLPageRequestBuilder extra(Object obj) {
        this.f28700c = obj;
        return this;
    }

    public FLPageRequestBuilder pageId(String str) {
        this.f28699b = str;
        return this;
    }

    public FLPageRequestBuilder referrer(String str) {
        this.f28701d = str;
        return this;
    }

    public FLPageRequestBuilder requestType(FLRequestType fLRequestType) {
        this.f28702e = fLRequestType;
        return this;
    }
}
