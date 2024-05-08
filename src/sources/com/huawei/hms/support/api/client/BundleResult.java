package com.huawei.hms.support.api.client;

import android.os.Bundle;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class BundleResult {

    /* renamed from: a, reason: collision with root package name */
    private int f31833a;

    /* renamed from: b, reason: collision with root package name */
    private Bundle f31834b;

    public BundleResult(int i10, Bundle bundle) {
        this.f31833a = i10;
        this.f31834b = bundle;
    }

    public int getResultCode() {
        return this.f31833a;
    }

    public Bundle getRspBody() {
        return this.f31834b;
    }

    public void setResultCode(int i10) {
        this.f31833a = i10;
    }

    public void setRspBody(Bundle bundle) {
        this.f31834b = bundle;
    }
}
