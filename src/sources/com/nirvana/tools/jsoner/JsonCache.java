package com.nirvana.tools.jsoner;

import android.util.LruCache;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class JsonCache {
    private LruCache<Class, a> mJsonCache = new LruCache<>(100);

    public void clearCache() {
        this.mJsonCache.evictAll();
    }

    public a getJsonClass(Class cls) {
        return this.mJsonCache.get(cls);
    }

    public void putJsonClass(Class cls, a aVar) {
        this.mJsonCache.put(cls, aVar);
    }
}
