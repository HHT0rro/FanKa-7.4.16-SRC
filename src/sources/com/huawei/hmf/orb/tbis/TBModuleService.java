package com.huawei.hmf.orb.tbis;

import com.huawei.hmf.orb.RemoteConnector;
import com.huawei.hmf.orb.RemoteRepository;
import com.huawei.hmf.orb.exception.ConnectRemoteException;
import com.huawei.hmf.orb.tbis.TBModuleRegistry;
import com.huawei.hmf.repository.ComponentRepository;
import com.huawei.hmf.repository.Repository;
import com.huawei.hmf.services.Module;
import com.huawei.hmf.services.ui.UIModule;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class TBModuleService {
    private static final String TAG = "TBModuleService";
    private final TBModuleRegistry mModuleRegistry;
    private Repository mRepository;

    public TBModuleService(TBModuleRegistry tBModuleRegistry) {
        this.mModuleRegistry = tBModuleRegistry;
        this.mRepository = ComponentRepository.getRepository();
    }

    public Object create(String str) {
        TBModuleRegistry.RegistryInfo registry = this.mModuleRegistry.getRegistry(str);
        return create(str, registry != null ? registry.alias : null);
    }

    public TBUIModule createUIModule(String str) {
        Module lookup;
        UIModule createUIModule;
        Repository repository = this.mRepository;
        if (repository == null || (lookup = repository.lookup(getName())) == null || (createUIModule = lookup.createUIModule(str)) == null) {
            return null;
        }
        return new TBUIModule(createUIModule);
    }

    public void destroy() {
        Repository repository = this.mRepository;
        if (repository instanceof RemoteRepository) {
            ((RemoteRepository) repository).close();
        }
    }

    public String getName() {
        return this.mModuleRegistry.getName();
    }

    public final Class<?> getService(String str) {
        TBModuleRegistry.RegistryInfo registry = this.mModuleRegistry.getRegistry(str);
        if (registry == null) {
            return null;
        }
        return registry.uri;
    }

    public TBModuleService(TBModuleRegistry tBModuleRegistry, RemoteConnector remoteConnector) {
        this.mModuleRegistry = tBModuleRegistry;
        try {
            this.mRepository = ComponentRepository.getRepository(remoteConnector);
        } catch (ConnectRemoteException e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("connect to remote repository failed:");
            sb2.append((Object) e2.getStatus());
        }
    }

    public Object create(String str, String str2) {
        if (this.mRepository == null) {
            return null;
        }
        Class<?> service = getService(str);
        Module lookup = this.mRepository.lookup(getName());
        if (lookup == null || service == null) {
            return null;
        }
        if (str2 != null) {
            return lookup.create(service, str2);
        }
        return lookup.create(service);
    }
}
