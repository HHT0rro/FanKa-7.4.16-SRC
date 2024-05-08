package com.huawei.flrequest.api;

import android.content.Context;
import androidx.annotation.NonNull;
import com.huawei.flrequest.impl.list.FLListRequestImpl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLListRequestBuilder {

    /* renamed from: a, reason: collision with root package name */
    private Context f28691a;

    /* renamed from: b, reason: collision with root package name */
    private int f28692b;

    /* renamed from: c, reason: collision with root package name */
    private String f28693c;

    /* renamed from: d, reason: collision with root package name */
    private Object f28694d;

    /* renamed from: e, reason: collision with root package name */
    private String f28695e;

    /* renamed from: f, reason: collision with root package name */
    private FLRequestType f28696f = FLRequestType.REQUEST_SERVER;

    public FLListRequestBuilder(@NonNull Context context, int i10, String str) {
        this.f28691a = context;
        this.f28692b = i10;
        this.f28693c = str;
    }

    public FLListRequest build() throws FLRequestException {
        FLListRequestImpl fLListRequestImpl = new FLListRequestImpl(this.f28691a);
        fLListRequestImpl.setRequestType(this.f28696f);
        fLListRequestImpl.setExtra(this.f28694d);
        fLListRequestImpl.setReferrer(this.f28695e);
        fLListRequestImpl.setDataId(this.f28693c);
        fLListRequestImpl.setPageNum(this.f28692b);
        return fLListRequestImpl;
    }

    public FLListRequestBuilder extra(Object obj) {
        this.f28694d = obj;
        return this;
    }

    public FLListRequestBuilder referrer(String str) {
        this.f28695e = str;
        return this;
    }

    public FLListRequestBuilder requestType(FLRequestType fLRequestType) {
        this.f28696f = fLRequestType;
        return this;
    }
}
