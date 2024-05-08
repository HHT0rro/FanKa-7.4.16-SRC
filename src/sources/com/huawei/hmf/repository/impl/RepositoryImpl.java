package com.huawei.hmf.repository.impl;

import com.huawei.hmf.repository.ModuleRegistry;
import com.huawei.hmf.repository.Repository;
import com.huawei.hmf.services.Module;
import com.huawei.hmf.services.ModuleProviderWrapper;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class RepositoryImpl implements Repository {
    private Map<String, ModuleProviderWrapper> mModuleProviderWrapperMap = new HashMap();

    public RepositoryImpl(boolean z10) {
        if (z10) {
            ModuleRegistry.register(this);
        }
    }

    public void clearRegister() {
        this.mModuleProviderWrapperMap.clear();
    }

    public ModuleProviderWrapper getModuleProviderWrapper(String str) {
        return this.mModuleProviderWrapperMap.get(str);
    }

    @Override // com.huawei.hmf.repository.Repository
    public Module lookup(String str) {
        ModuleProviderWrapper moduleProviderWrapper = this.mModuleProviderWrapperMap.get(str);
        if (moduleProviderWrapper != null) {
            return moduleProviderWrapper.getModule();
        }
        return null;
    }

    @Override // com.huawei.hmf.repository.Repository
    public void register(String str, ModuleProviderWrapper moduleProviderWrapper) {
        if (this.mModuleProviderWrapperMap.get(str) == null) {
            this.mModuleProviderWrapperMap.put(str, moduleProviderWrapper);
        }
    }
}
