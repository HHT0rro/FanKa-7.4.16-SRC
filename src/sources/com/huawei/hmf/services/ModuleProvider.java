package com.huawei.hmf.services;

import android.content.Context;
import com.huawei.hmf.services.interception.Interceptor;
import com.huawei.hmf.services.internal.ApplicationContext;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class ModuleProvider {
    private Interceptor mInterceptor;
    private String mModuleName;

    public void dependency() {
    }

    public final Context getContext() {
        return ApplicationContext.getContext();
    }

    public Interceptor getInterceptor() {
        return this.mInterceptor;
    }

    public final String getModuleName() {
        return this.mModuleName;
    }

    public void initialize() {
    }

    public ApiSet register() {
        return null;
    }

    public void setInterceptor(Interceptor interceptor) {
        this.mInterceptor = interceptor;
    }

    public final void setModuleName(String str) {
        this.mModuleName = str;
    }
}
