package com.huawei.hmf.md.tbis;

import com.huawei.hmf.md.spec.jmessage;
import com.huawei.hmf.orb.tbis.TBModuleRegistry;
import com.huawei.jmessage.api.EventQueue;
import com.huawei.jmessage.api.EventSourceManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class jmessageRegistry extends TBModuleRegistry {
    public static final String name() {
        return jmessage.name;
    }

    @Override // com.huawei.hmf.orb.tbis.TBModuleRegistry
    public final String getName() {
        return name();
    }

    @Override // com.huawei.hmf.orb.tbis.TBModuleRegistry
    public final void registry() {
        add("EventSourceManager", EventSourceManager.class, null);
        add("EventQueue", EventQueue.class, "mq");
    }
}
