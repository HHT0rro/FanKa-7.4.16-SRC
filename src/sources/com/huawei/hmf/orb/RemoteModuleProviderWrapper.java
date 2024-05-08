package com.huawei.hmf.orb;

import com.huawei.hmf.annotation.ModuleExport;
import com.huawei.hmf.services.ApiSet;
import com.huawei.hmf.services.Module;
import com.huawei.hmf.services.ModuleProvider;
import com.huawei.hmf.services.ModuleProviderWrapper;

/* compiled from: RemoteRepository.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
class RemoteModuleProviderWrapper extends ModuleProviderWrapper {
    private RemoteInvoker mInvoker;

    /* compiled from: RemoteRepository.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class DummyModule extends ModuleProvider {
        private DummyModule() {
        }
    }

    public RemoteModuleProviderWrapper(RemoteInvoker remoteInvoker) {
        super(new DummyModule(), ModuleExport.Type.REMOTE.getValue());
        this.mInvoker = remoteInvoker;
    }

    @Override // com.huawei.hmf.services.ModuleProviderWrapper
    public Module createModule(String str, ApiSet apiSet) {
        return new RemoteModule(str, apiSet, this.mInvoker);
    }
}
