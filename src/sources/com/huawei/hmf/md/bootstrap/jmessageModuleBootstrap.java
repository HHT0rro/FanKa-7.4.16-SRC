package com.huawei.hmf.md.bootstrap;

import com.huawei.hmf.md.spec.jmessage;
import com.huawei.hmf.repository.Repository;
import com.huawei.hmf.services.ApiSet;
import com.huawei.hmf.services.ModuleProviderWrapper;
import com.huawei.jmessage.b;
import com.huawei.jmessage.impl.EventQueueImpl;
import com.huawei.jmessage.impl.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class jmessageModuleBootstrap {
    public static final String name() {
        return jmessage.name;
    }

    public static final void register(Repository repository) {
        ApiSet.Builder builder = ApiSet.builder();
        builder.add(a.class, "com.huawei.jmessage.api.EventSourceManager");
        builder.add(EventQueueImpl.class, "com.huawei.jmessage.api.EventQueue");
        new ModuleProviderWrapper(new b(), 5).bootstrap(repository, name(), builder.build());
    }
}
