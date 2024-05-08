package com.huawei.hmf.services.inject;

import com.huawei.hmf.services.ApiSet;
import com.huawei.hmf.services.Module;
import com.huawei.hmf.services.ui.UIModule;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class UIModuleCreator implements InjectInstanceCreator<UIModule> {
    private final Class mService;

    public UIModuleCreator(Class cls) {
        this.mService = cls;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.huawei.hmf.services.inject.InjectInstanceCreator
    public UIModule createInstance(Module module, String str) {
        return new UIModule(module, ApiSet.builder().obtain(this.mService));
    }
}
