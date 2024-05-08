package com.huawei.hmf.services.inject;

import com.huawei.hmf.services.ApiSet;
import com.huawei.hmf.services.inject.Selector;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class SelectorImpl extends Selector {
    private Map<String, Object> mValue = new HashMap();

    @Override // com.huawei.hmf.services.inject.Selector
    public void add(Selector.Binder binder) {
        if (ApiSet.builder().obtain(binder.mService) != null) {
            this.mValue.put(binder.mName, binder.mService);
            return;
        }
        throw new IllegalArgumentException(binder.mService.getName() + " cannot be bind without an @ActivityDefine or @FragmentDefine Annotation");
    }

    @Override // com.huawei.hmf.services.inject.Selector
    public Selector.Binder alias(String str) {
        return new Selector.Binder(str);
    }

    public Map<String, Object> getValue() {
        return this.mValue;
    }

    @Override // com.huawei.hmf.services.inject.Selector
    public boolean isEmpty() {
        return this.mValue.isEmpty();
    }
}
