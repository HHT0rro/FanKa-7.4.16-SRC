package com.huawei.hmf.services;

import com.huawei.hmf.annotation.ModuleExport;
import com.huawei.hmf.repository.Repository;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ModuleProviderWrapper extends ModuleProvider {
    private ApiSet mApiSet;
    private volatile Module mModule;
    private ModuleProvider mModuleProvider;
    private final int mType;

    public ModuleProviderWrapper(ModuleProvider moduleProvider) {
        this(moduleProvider, ModuleExport.Type.LOCAL.getValue());
    }

    public final void bootstrap(Repository repository, String str, ApiSet apiSet) {
        setModuleName(str);
        this.mModuleProvider.setModuleName(str);
        ApiSet register = register();
        this.mApiSet = register;
        if (register == null) {
            this.mApiSet = apiSet;
        }
        if (this.mApiSet != null) {
            repository.register(str, this);
        }
    }

    public Module createModule(String str, ApiSet apiSet) {
        Module module = new Module(getModuleName(), apiSet);
        module.setInterceptor(this.mModuleProvider.getInterceptor());
        return module;
    }

    @Override // com.huawei.hmf.services.ModuleProvider
    public void dependency() {
        this.mModuleProvider.dependency();
    }

    public ApiSet getApiSet() {
        return this.mApiSet;
    }

    public Module getModule() {
        if (this.mModule == null) {
            synchronized (this) {
                if (this.mModule == null) {
                    initialize();
                    this.mModule = createModule(getModuleName(), this.mApiSet);
                }
            }
        }
        return this.mModule;
    }

    @Override // com.huawei.hmf.services.ModuleProvider
    public void initialize() {
        this.mModuleProvider.initialize();
    }

    public boolean isRegistered(Class cls, String str) {
        return str != null ? this.mApiSet.getApiSpec(str, cls) != null : this.mApiSet.getApiSpec(cls) != null;
    }

    public boolean isType(ModuleExport.Type type) {
        return (this.mType & type.getValue()) == type.getValue();
    }

    @Override // com.huawei.hmf.services.ModuleProvider
    public ApiSet register() {
        return this.mModuleProvider.register();
    }

    public ModuleProviderWrapper(ModuleProvider moduleProvider, int i10) {
        this.mModuleProvider = moduleProvider;
        this.mType = i10;
    }
}
