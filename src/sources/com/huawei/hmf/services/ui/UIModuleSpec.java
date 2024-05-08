package com.huawei.hmf.services.ui;

import com.huawei.hmf.services.ApiSpec;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class UIModuleSpec extends ApiSpec {
    public Class<?> mProtocol;
    public Class<?> mResult;

    public UIModuleSpec(Class<?> cls) {
        this(cls, null, null);
    }

    public Class<?> getProtocol() {
        return this.mProtocol;
    }

    public Class<?> getResult() {
        return this.mResult;
    }

    public UIModuleSpec(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        super(cls);
        this.mProtocol = cls2;
        this.mResult = cls3;
    }
}
