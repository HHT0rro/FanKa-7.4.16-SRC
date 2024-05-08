package com.huawei.hmf.md.bootstrap;

import com.huawei.appgallery.agd.pageframe.PageFrameDefine;
import com.huawei.appgallery.agd.pageframe.download.DownloadImpl;
import com.huawei.hmf.md.spec.ActionSupport;
import com.huawei.hmf.repository.Repository;
import com.huawei.hmf.services.ApiSet;
import com.huawei.hmf.services.ModuleProviderWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class ActionSupportModuleBootstrap {
    public static final String name() {
        return ActionSupport.name;
    }

    public static final void register(Repository repository) {
        ApiSet.Builder builder = ApiSet.builder();
        builder.add(DownloadImpl.class, "com.huawei.appgallery.agd.pageframe.api.IAgdDownload");
        new ModuleProviderWrapper(new PageFrameDefine(), 5).bootstrap(repository, name(), builder.build());
    }
}
