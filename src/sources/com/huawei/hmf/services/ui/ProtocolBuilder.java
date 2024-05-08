package com.huawei.hmf.services.ui;

import com.huawei.hmf.services.ApiSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ProtocolBuilder {
    private final UIModule mUIModule;

    private ProtocolBuilder(UIModule uIModule) {
        this.mUIModule = uIModule;
    }

    public static ProtocolBuilder builder(Class<?> cls) {
        return new ProtocolBuilder(new UIModule("default", ApiSet.builder().obtain(cls)));
    }

    public ProtocolRef build() {
        return new ProtocolRef(this.mUIModule.getUIModuleSpec().mProtocol, this.mUIModule.createProtocol());
    }
}
