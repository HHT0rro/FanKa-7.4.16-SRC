package com.huawei.hmf.orb;

import com.huawei.hmf.repository.ComponentRepository;
import com.huawei.hmf.repository.impl.RepositoryImpl;
import com.huawei.hmf.services.ApiSet;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class RemoteModuleBootstrap {
    private List<RegistryInfo> mStubList = new ArrayList();
    private final ApiSet.Builder mApiProxyBuilder = ApiSet.builder();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class RegistryInfo {
        public String alias;
        public Class service;
        public Class serviceInterface;
        public String uri;

        private RegistryInfo() {
        }
    }

    public abstract String getName();

    public ApiSet getProxy() {
        proxies();
        return this.mApiProxyBuilder.build();
    }

    public ApiSet getStub() {
        stubs();
        ApiSet.Builder builder = ApiSet.builder();
        ApiSet apiSet = ((RepositoryImpl) ComponentRepository.getRepository()).getModuleProviderWrapper(getName()).getApiSet();
        for (RegistryInfo registryInfo : this.mStubList) {
            String str = registryInfo.alias;
            if (str != null) {
                if (apiSet.getApiSpec(str, registryInfo.serviceInterface) != null) {
                    builder.add(registryInfo.uri, registryInfo.service, false);
                }
            } else if (apiSet.getApiSpec(registryInfo.serviceInterface) != null) {
                builder.add(registryInfo.uri, registryInfo.service, false);
            }
        }
        return builder.build();
    }

    public abstract void proxies();

    public void registryProxy(Class<?> cls, String str, Class<?> cls2, boolean z10) {
        this.mApiProxyBuilder.add(cls, str, cls2, z10);
    }

    public void registryStub(Class<?> cls, String str, String str2, Class<?> cls2) {
        RegistryInfo registryInfo = new RegistryInfo();
        registryInfo.serviceInterface = cls;
        registryInfo.alias = str;
        registryInfo.uri = str2;
        registryInfo.service = cls2;
        this.mStubList.add(registryInfo);
    }

    public abstract void stubs();

    public void registryProxy(String str, Class<?> cls, Class<?> cls2) {
        this.mApiProxyBuilder.add(str, (Class<?>) null, cls, cls2);
    }
}
