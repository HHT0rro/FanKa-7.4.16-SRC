package com.huawei.hmf.md.bootstrap;

import com.huawei.hmf.md.spec.qcardsupport;
import com.huawei.hmf.repository.Repository;
import com.huawei.hmf.services.ApiSet;
import com.huawei.hmf.services.ModuleProviderWrapper;
import com.huawei.qcardsupport.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class qcardsupportModuleBootstrap {
    public static final String name() {
        return qcardsupport.name;
    }

    public static final void register(Repository repository) {
        new ModuleProviderWrapper(new b(), 1).bootstrap(repository, name(), ApiSet.builder().build());
    }
}
