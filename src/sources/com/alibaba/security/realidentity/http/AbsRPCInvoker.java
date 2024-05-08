package com.alibaba.security.realidentity.http;

import com.alibaba.security.realidentity.http.base.Request;
import com.alibaba.security.realidentity.http.base.RetrofitHttpCallback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class AbsRPCInvoker {
    public static final String TAG = "AbsRPCInvoker";

    public abstract void enqueue(Request request, RetrofitHttpCallback retrofitHttpCallback);
}
