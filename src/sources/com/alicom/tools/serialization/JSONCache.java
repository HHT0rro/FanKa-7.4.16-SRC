package com.alicom.tools.serialization;

import android.util.LruCache;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class JSONCache {
    private LruCache<Class, JSONClass> mJsonCache = new LruCache<>(100);

    public void clearCache() {
        this.mJsonCache.evictAll();
    }

    public JSONClass getJsonClass(Class cls) {
        return this.mJsonCache.get(cls);
    }

    public void putJsonClass(Class cls, JSONClass jSONClass) {
        this.mJsonCache.put(cls, jSONClass);
    }
}
