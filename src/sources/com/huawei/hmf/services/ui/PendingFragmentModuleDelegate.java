package com.huawei.hmf.services.ui;

import android.app.Fragment;
import android.os.Bundle;

/* compiled from: FragmentModuleDelegate.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
class PendingFragmentModuleDelegate extends FragmentModuleDelegate implements IPendingFragmentModule {
    private final Bundle mBundle;
    private final Object mFragment;

    public PendingFragmentModuleDelegate(Object obj, Bundle bundle) {
        super(null);
        this.mFragment = obj;
        this.mBundle = bundle;
    }

    @Override // com.huawei.hmf.services.ui.IPendingFragmentModule
    public Bundle getBundle() {
        return this.mBundle;
    }

    @Override // com.huawei.hmf.services.ui.FragmentModuleDelegate
    public <T extends Fragment> T getFragment() {
        throw new IllegalArgumentException("The fragment type is android.support.v4.app.Fragment");
    }

    @Override // com.huawei.hmf.services.ui.IPendingFragmentModule
    public Object getPendingFragment() {
        return this.mFragment;
    }

    @Override // com.huawei.hmf.services.ui.FragmentModuleDelegate
    public <T> T getProtocol() {
        return null;
    }

    @Override // com.huawei.hmf.services.ui.FragmentModuleDelegate
    public <R> R queryInterface(Class<R> cls) {
        return null;
    }
}
