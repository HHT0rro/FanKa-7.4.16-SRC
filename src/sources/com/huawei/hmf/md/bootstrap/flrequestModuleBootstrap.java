package com.huawei.hmf.md.bootstrap;

import com.huawei.flrequest.b;
import com.huawei.hmf.md.spec.flrequest;
import com.huawei.hmf.repository.Repository;
import com.huawei.hmf.services.ApiSet;
import com.huawei.hmf.services.ModuleProviderWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class flrequestModuleBootstrap {
    public static final String name() {
        return flrequest.name;
    }

    public static final void register(Repository repository) {
        new ModuleProviderWrapper(new b(), 1).bootstrap(repository, name(), ApiSet.builder().build());
    }
}
