package com.huawei.hmf.services.ui.internal;

import android.os.Bundle;
import com.huawei.hmf.annotation.FragmentDefine;
import com.huawei.hmf.services.codec.MessageCodec;
import com.huawei.hmf.services.inject.InjectBindingRegistry;
import com.huawei.hmf.services.inject.ModuleInjection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FragmentData {
    private Bundle mBundle;
    private InjectBindingRegistry mInjectBindingRegistry;

    public FragmentData(InjectBindingRegistry injectBindingRegistry, String str) {
        this(new Bundle());
        this.mBundle.putString(BundleKey.MODULE_NAME, str);
        this.mInjectBindingRegistry = injectBindingRegistry;
    }

    private Object inject(Object obj) {
        Bundle bundle = this.mBundle;
        this.mInjectBindingRegistry = (InjectBindingRegistry) new MessageCodec().decode(bundle == null ? null : bundle.getBundle(InjectBindingRegistry.DESCRIPTOR), (Bundle) new InjectBindingRegistry());
        return new ModuleInjection(this.mInjectBindingRegistry).inject(obj);
    }

    public String getModuleName() {
        Bundle bundle = this.mBundle;
        if (bundle == null) {
            return null;
        }
        return bundle.getString(BundleKey.MODULE_NAME);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T getProtocol(FragmentDefine fragmentDefine) {
        Object newInstance;
        if (fragmentDefine.protocol().isInterface()) {
            newInstance = new PojoGenerator(fragmentDefine.protocol());
        } else {
            try {
                newInstance = fragmentDefine.protocol().newInstance();
            } catch (Exception unused) {
                return null;
            }
        }
        new MessageCodec().decode(this.mBundle, (Bundle) newInstance);
        T t2 = (T) inject(newInstance);
        return t2 instanceof PojoGenerator ? (T) ((PojoGenerator) t2).get() : t2;
    }

    public void setProtocol(Object obj) {
        MessageCodec messageCodec = new MessageCodec();
        if (obj != null) {
            messageCodec.encode(obj, this.mBundle);
        }
        this.mBundle.putBundle(InjectBindingRegistry.DESCRIPTOR, messageCodec.encode(this.mInjectBindingRegistry, new Bundle()));
    }

    public Bundle toBundle() {
        return this.mBundle;
    }

    public FragmentData(Bundle bundle) {
        this.mBundle = bundle;
    }
}
