package com.huawei.flrequest;

import com.huawei.flexiblelayout.FLEngine;
import com.huawei.hmf.services.ApiSet;
import com.huawei.hmf.services.ModuleProvider;
import com.huawei.ok3httpservice.api.Ok3HttpService;
import com.huawei.serverrequest.api.service.HttpService;

/* compiled from: FLRequestDefine.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b extends ModuleProvider {
    @Override // com.huawei.hmf.services.ModuleProvider
    public void initialize() {
    }

    @Override // com.huawei.hmf.services.ModuleProvider
    public ApiSet register() {
        try {
            FLEngine.getInstance(getContext()).registerService(HttpService.class, new Ok3HttpService(getContext()));
        } catch (NoClassDefFoundError unused) {
        }
        return super.register();
    }
}
