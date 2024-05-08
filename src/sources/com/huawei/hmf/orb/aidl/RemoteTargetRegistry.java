package com.huawei.hmf.orb.aidl;

import com.huawei.hmf.orb.CommonCode;
import com.huawei.hmf.orb.RemoteModuleBootstrap;
import com.huawei.hmf.orb.RemoteTarget;
import com.huawei.hmf.orb.exception.ApiNotExistException;
import com.huawei.hmf.orb.exception.GeneralException;
import com.huawei.hmf.repository.ModuleRegistry;
import com.huawei.hmf.services.ApiSet;
import com.huawei.hmf.services.ApiSpec;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class RemoteTargetRegistry {
    private static Map<String, RemoteTargetRegistry> mMap = new HashMap();
    private final String mModule;
    private final ApiSet mStubApiSet;

    private RemoteTargetRegistry(RemoteModuleBootstrap remoteModuleBootstrap, String str) {
        this.mStubApiSet = remoteModuleBootstrap.getStub();
        this.mModule = str;
    }

    public static synchronized RemoteTargetRegistry getRegistry(String str) {
        synchronized (RemoteTargetRegistry.class) {
            RemoteTargetRegistry remoteTargetRegistry = mMap.get(str);
            if (remoteTargetRegistry == null) {
                RemoteModuleBootstrap remoteModuleBootstrap = (RemoteModuleBootstrap) ModuleRegistry.getRemoteModuleBootstrap(str);
                if (remoteModuleBootstrap == null) {
                    return null;
                }
                RemoteTargetRegistry remoteTargetRegistry2 = new RemoteTargetRegistry(remoteModuleBootstrap, str);
                mMap.put(str, remoteTargetRegistry2);
                remoteTargetRegistry = remoteTargetRegistry2;
            }
            return remoteTargetRegistry;
        }
    }

    public RemoteTarget createRemoteTarget(String str) throws GeneralException {
        ApiSpec apiSpec = this.mStubApiSet.getApiSpec(str);
        if (apiSpec == null) {
            return null;
        }
        try {
            return RemoteTarget.builder().module(this.mModule).build(apiSpec.getType());
        } catch (ApiNotExistException unused) {
            throw new GeneralException(CommonCode.ErrorCode.API_NOT_EXIST);
        } catch (Exception e2) {
            throw new GeneralException(CommonCode.ErrorCode.INTERNAL_ERROR, e2);
        }
    }
}
