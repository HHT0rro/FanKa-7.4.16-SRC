package com.huawei.hmf.md.tbis;

import com.huawei.appgallery.agd.pageframe.api.IAgdDownload;
import com.huawei.hmf.md.spec.ActionSupport;
import com.huawei.hmf.orb.tbis.TBModuleRegistry;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class ActionSupportRegistry extends TBModuleRegistry {
    public static final String name() {
        return ActionSupport.name;
    }

    @Override // com.huawei.hmf.orb.tbis.TBModuleRegistry
    public final String getName() {
        return name();
    }

    @Override // com.huawei.hmf.orb.tbis.TBModuleRegistry
    public final void registry() {
        add("IAgdDownload", IAgdDownload.class, null);
    }
}
