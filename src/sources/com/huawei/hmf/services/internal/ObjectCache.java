package com.huawei.hmf.services.internal;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ObjectCache {
    private Map<Class<?>, Object> objectBlock = new HashMap();

    public void clear() {
        this.objectBlock.clear();
    }

    public Object get(Class<?> cls) {
        return this.objectBlock.get(cls);
    }

    public void put(Class<?> cls, Object obj) {
        this.objectBlock.put(cls, obj);
    }
}
