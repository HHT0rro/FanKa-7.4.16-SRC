package com.huawei.hmf.orb;

import com.huawei.hmf.orb.aidl.RemoteUIModule;
import com.huawei.hmf.services.ApiSet;
import com.huawei.hmf.services.ApiSpec;
import com.huawei.hmf.services.Module;
import com.huawei.hmf.services.internal.ApiFactory;
import com.huawei.hmf.services.internal.ObjectCache;
import com.huawei.hmf.services.ui.UIModule;

/* compiled from: RemoteRepository.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
class RemoteModule extends Module {
    private ObjectCache mCache;
    private RemoteInvoker mInvoker;

    public RemoteModule(String str, ApiSet apiSet, RemoteInvoker remoteInvoker) {
        super(str, apiSet);
        this.mInvoker = remoteInvoker;
        this.mCache = new ObjectCache();
    }

    @Override // com.huawei.hmf.services.Module
    public <T> T create(ApiSpec apiSpec) {
        try {
            return (T) ApiFactory.create(this.mCache, apiSpec, this.mInvoker);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.huawei.hmf.services.Module
    public UIModule createUIModule(String str) {
        ApiSpec apiSpec = getApiSet().getApiSpec(str);
        if (apiSpec == null) {
            return null;
        }
        return new RemoteUIModule(this, apiSpec, this.mInvoker, str);
    }
}
