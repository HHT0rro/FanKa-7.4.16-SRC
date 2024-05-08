package com.nirvana.tools.cache;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CacheManager {
    private static volatile CacheManager sInstance;
    private Context mContext;
    private Map<String, CacheHandler> mHandlers = new ConcurrentHashMap();

    public CacheManager(Context context) {
        this.mContext = context;
    }

    public static CacheManager getInstance(Context context) {
        if (sInstance == null) {
            synchronized (CacheManager.class) {
                if (sInstance == null) {
                    sInstance = new CacheManager(context);
                }
            }
        }
        return sInstance;
    }

    public CacheHandler getCacheHandler(String str) {
        return this.mHandlers.get(str);
    }

    public CacheHandler registerCacheHandler(String str, CacheRepository cacheRepository) {
        if (!this.mHandlers.containsKey(str)) {
            CacheHandler cacheHandler = new CacheHandler(cacheRepository);
            this.mHandlers.put(str, cacheHandler);
            return cacheHandler;
        }
        throw new IllegalStateException("Handler key [" + str + "] has been contained!");
    }

    public <T extends RepositoryTemplate> CacheHandler registerCacheHandler(String str, T t2) {
        if (t2 instanceof SharedPreferenceTemplate) {
            return registerCacheHandler(str, new SharedPreferenceRepository((SharedPreferenceTemplate) t2, this.mContext));
        }
        throw new IllegalArgumentException("Unsupported template!");
    }

    public void unRegisterCacheHandler(String str) {
        this.mHandlers.remove(str);
    }
}
