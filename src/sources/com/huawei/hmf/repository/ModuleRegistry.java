package com.huawei.hmf.repository;

import com.huawei.hmf.md.bootstrap.ActionSupportModuleBootstrap;
import com.huawei.hmf.md.bootstrap.ffiModuleBootstrap;
import com.huawei.hmf.md.bootstrap.jmessageModuleBootstrap;
import com.huawei.hmf.md.bootstrap.qcardsupportModuleBootstrap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ModuleRegistry {
    public static Object getRemoteModuleBootstrap(String str) {
        return null;
    }

    public static void register(Repository repository) {
        ffiModuleBootstrap.register(repository);
        jmessageModuleBootstrap.register(repository);
        qcardsupportModuleBootstrap.register(repository);
        ActionSupportModuleBootstrap.register(repository);
    }
}
