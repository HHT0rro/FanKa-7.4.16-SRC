package com.huawei.pnodesupport;

import com.huawei.hmf.services.ApiSet;
import com.huawei.hmf.services.ModuleProvider;
import com.huawei.pnodesupport.api.FLPNodeSupport;

/* compiled from: PNodeSupportDefine.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b extends ModuleProvider {
    @Override // com.huawei.hmf.services.ModuleProvider
    public void initialize() {
    }

    @Override // com.huawei.hmf.services.ModuleProvider
    public ApiSet register() {
        FLPNodeSupport.init(getContext());
        return super.register();
    }
}
