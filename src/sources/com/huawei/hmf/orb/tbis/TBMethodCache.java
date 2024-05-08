package com.huawei.hmf.orb.tbis;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: TBMethod.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
class TBMethodCache {
    private Map<Class, List<TBMethod>> cache = new HashMap();

    public List<TBMethod> get(Class cls) {
        List<TBMethod> list = this.cache.get(cls);
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public List<TBMethod> put(Class cls, List<TBMethod> list) {
        this.cache.put(cls, list);
        return Collections.unmodifiableList(list);
    }
}
