package com.huawei.hmf.repository;

import com.huawei.hmf.services.Module;
import com.huawei.hmf.services.ModuleProviderWrapper;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface Repository {
    Module lookup(String str);

    void register(String str, ModuleProviderWrapper moduleProviderWrapper);
}
