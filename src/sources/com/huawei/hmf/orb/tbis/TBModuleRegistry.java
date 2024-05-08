package com.huawei.hmf.orb.tbis;

import android.text.TextUtils;
import com.huawei.hmf.repository.ComponentRepository;
import com.huawei.hmf.repository.impl.RepositoryImpl;
import com.huawei.hmf.services.ModuleProviderWrapper;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class TBModuleRegistry {
    private ModuleProviderWrapper mModuleWrapper;
    private Map<String, RegistryInfo> mServiceMap = new HashMap();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class RegistryInfo {
        public String alias;
        public Class<?> uri;
    }

    static {
        RegistryInit.init();
    }

    public TBModuleRegistry() {
        ModuleProviderWrapper moduleProviderWrapper = ((RepositoryImpl) ComponentRepository.getRepository()).getModuleProviderWrapper(getName());
        this.mModuleWrapper = moduleProviderWrapper;
        if (moduleProviderWrapper != null) {
            registry();
        }
    }

    public final void add(String str, Class cls, String str2) {
        if (this.mModuleWrapper.isRegistered(cls, str2)) {
            RegistryInfo registryInfo = new RegistryInfo();
            registryInfo.uri = cls;
            if (!TextUtils.isEmpty(str2)) {
                registryInfo.alias = str2;
                if (this.mServiceMap.get(str2) == null) {
                    this.mServiceMap.put(str2, registryInfo);
                }
                str = str + "-" + str2;
            }
            this.mServiceMap.put(str, registryInfo);
        }
    }

    public abstract String getName();

    public final RegistryInfo getRegistry(String str) {
        return this.mServiceMap.get(str);
    }

    public abstract void registry();
}
