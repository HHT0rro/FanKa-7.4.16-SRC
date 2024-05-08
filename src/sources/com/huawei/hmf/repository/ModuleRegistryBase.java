package com.huawei.hmf.repository;

import com.huawei.hmf.orb.IMessageEntity;
import com.huawei.hmf.orb.RemoteModuleBootstrap;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class ModuleRegistryBase implements IMessageEntity {
    private Map<String, RemoteModuleBootstrap> mRemoteModuleBootstrapMap;

    public synchronized Object getRemoteModuleBootstrap(String str) {
        if (this.mRemoteModuleBootstrapMap == null) {
            HashMap hashMap = new HashMap();
            this.mRemoteModuleBootstrapMap = hashMap;
            registerRemoteModule(hashMap);
        }
        return this.mRemoteModuleBootstrapMap.get(str);
    }

    public abstract void register(Repository repository);

    public abstract void registerRemoteModule(Map map);
}
