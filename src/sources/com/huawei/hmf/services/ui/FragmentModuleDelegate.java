package com.huawei.hmf.services.ui;

import android.app.Fragment;
import android.os.Bundle;
import com.huawei.hmf.annotation.FragmentDefine;
import com.huawei.hmf.repository.ComponentRepository;
import com.huawei.hmf.services.ui.internal.FragmentData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FragmentModuleDelegate {
    private static final String TAG = "FragmentModuleDelegate";
    private Fragment mFragment;

    public FragmentModuleDelegate(Fragment fragment) {
        this.mFragment = fragment;
    }

    public static FragmentModuleDelegate create(Fragment fragment) {
        return new FragmentModuleDelegate(fragment);
    }

    public <T extends Fragment> T getFragment() {
        return (T) this.mFragment;
    }

    public <T> T getProtocol() {
        Bundle arguments = this.mFragment.getArguments();
        if (arguments == null) {
            return null;
        }
        if (this.mFragment.getActivity() != null) {
            FragmentData fragmentData = new FragmentData(arguments);
            String moduleName = fragmentData.getModuleName();
            if (moduleName != null) {
                ComponentRepository.getRepository().lookup(moduleName);
            }
            return (T) fragmentData.getProtocol((FragmentDefine) this.mFragment.getClass().getAnnotation(FragmentDefine.class));
        }
        throw new IllegalArgumentException("Activity is null, fragment may not bind to any activity");
    }

    public <R> R queryInterface(Class<R> cls) {
        if (cls.isInstance(this.mFragment)) {
            return (R) this.mFragment;
        }
        return null;
    }

    public static FragmentModuleDelegate create(Object obj, Bundle bundle) {
        if (obj instanceof Fragment) {
            Fragment fragment = (Fragment) obj;
            fragment.setArguments(bundle);
            return create(fragment);
        }
        return new PendingFragmentModuleDelegate(obj, bundle);
    }
}
