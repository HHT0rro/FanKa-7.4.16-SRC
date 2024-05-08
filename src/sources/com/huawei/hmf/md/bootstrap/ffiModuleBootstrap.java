package com.huawei.hmf.md.bootstrap;

import com.huawei.ffi.b;
import com.huawei.ffi.c;
import com.huawei.ffi.d;
import com.huawei.ffi.e;
import com.huawei.ffi.f;
import com.huawei.hmf.md.spec.ffi;
import com.huawei.hmf.repository.Repository;
import com.huawei.hmf.services.ApiSet;
import com.huawei.hmf.services.ModuleProviderWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class ffiModuleBootstrap {
    public static final String name() {
        return ffi.name;
    }

    public static final void register(Repository repository) {
        ApiSet.Builder builder = ApiSet.builder();
        builder.add(d.class, "java.util.Map");
        builder.add(e.class, "java.util.Map");
        builder.add(c.class, "java.util.List");
        builder.add(f.class, "com.huawei.ffi.api.JavaCall");
        new ModuleProviderWrapper(new b(), 5).bootstrap(repository, name(), builder.build());
    }
}
