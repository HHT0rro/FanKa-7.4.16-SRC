package com.huawei.hmf.services;

import android.os.Bundle;
import com.huawei.hmf.services.interception.ActionInvocation;
import com.huawei.hmf.services.interception.CreateOptions;
import com.huawei.hmf.services.interception.Interceptor;
import com.huawei.hmf.services.interception.Signature;
import com.huawei.hmf.services.internal.ApiFactory;
import com.huawei.hmf.services.ui.UIModule;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class Module {
    private ApiSet mApiSet;
    private Interceptor mInterceptor;
    private String mName;

    public Module(String str, ApiSet apiSet) {
        this.mName = str;
        this.mApiSet = apiSet;
    }

    private void intercept(Class cls, String str, String str2, Bundle bundle) {
        if (this.mInterceptor == null || CreateOptions.doNotIntercept(bundle)) {
            return;
        }
        Signature signature = new Signature(cls);
        signature.setAlias(str2);
        signature.setDeclaringTypeName(str);
        signature.setName(Signature.ConstructorMethod);
        this.mInterceptor.after(ActionInvocation.builder().moduleName(this.mName).signature(signature).build());
    }

    public <T> T create(Class<T> cls) {
        return (T) create(cls, (Bundle) null);
    }

    public UIModule createUIModule(String str) {
        ApiSpec apiSpec = this.mApiSet.getApiSpec(str);
        if (apiSpec == null) {
            return null;
        }
        UIModule uIModule = new UIModule(this, apiSpec);
        if (!uIModule.isActivityModule()) {
            intercept(apiSpec.getType(), apiSpec.getTypeName(), str, null);
        }
        return uIModule;
    }

    public ApiSet getApiSet() {
        return this.mApiSet;
    }

    public Interceptor getInterceptor() {
        return this.mInterceptor;
    }

    public String getName() {
        return this.mName;
    }

    public void setInterceptor(Interceptor interceptor) {
        this.mInterceptor = interceptor;
    }

    public <T> T create(Class<T> cls, String str) {
        return (T) create(cls, str, null);
    }

    public <T> T create(Class<T> cls, Bundle bundle) {
        ApiSpec apiSpec = this.mApiSet.getApiSpec(cls);
        if (apiSpec == null) {
            return null;
        }
        T t2 = (T) create(apiSpec);
        intercept(cls, apiSpec.getTypeName(), null, bundle);
        return t2;
    }

    public Module(Module module) {
        this(module.mName, module.mApiSet);
    }

    public <T> T create(Class<T> cls, String str, Bundle bundle) {
        ApiSpec apiSpec = this.mApiSet.getApiSpec(str, cls);
        if (apiSpec == null) {
            return null;
        }
        T t2 = (T) create(apiSpec);
        intercept(cls, apiSpec.getTypeName(), str, bundle);
        return t2;
    }

    public <T> T create(ApiSpec apiSpec) {
        return (T) ApiFactory.create(apiSpec);
    }
}
