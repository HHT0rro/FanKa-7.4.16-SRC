package com.huawei.hmf.orb.aidl.client.impl;

import com.huawei.hmf.orb.aidl.client.Result;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ResolveResult<T> extends Result {
    private T entity;

    public ResolveResult() {
        this.entity = null;
    }

    public T getValue() {
        return this.entity;
    }

    public ResolveResult(T t2) {
        this.entity = t2;
    }
}
