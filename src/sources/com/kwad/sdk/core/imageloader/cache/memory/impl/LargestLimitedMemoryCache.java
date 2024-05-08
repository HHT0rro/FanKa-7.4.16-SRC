package com.kwad.sdk.core.imageloader.cache.memory.impl;

import com.kwad.sdk.core.imageloader.cache.memory.LimitedMemoryCache;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class LargestLimitedMemoryCache extends LimitedMemoryCache {
    private final Map<DecodedResult, Integer> valueSizes;

    public LargestLimitedMemoryCache(int i10) {
        super(i10);
        this.valueSizes = Collections.synchronizedMap(new HashMap());
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.LimitedMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public void clear() {
        this.valueSizes.clear();
        super.clear();
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache
    public Reference<DecodedResult> createReference(DecodedResult decodedResult) {
        return new WeakReference(decodedResult);
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.LimitedMemoryCache
    public int getSize(DecodedResult decodedResult) {
        return decodedResult.getByteSize();
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.LimitedMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public boolean put(String str, DecodedResult decodedResult) {
        if (!super.put(str, decodedResult)) {
            return false;
        }
        this.valueSizes.put(decodedResult, Integer.valueOf(getSize(decodedResult)));
        return true;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.LimitedMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache, com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public DecodedResult remove(String str) {
        DecodedResult decodedResult = super.get(str);
        if (decodedResult != null) {
            this.valueSizes.remove(decodedResult);
        }
        return super.remove(str);
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.LimitedMemoryCache
    public DecodedResult removeNext() {
        DecodedResult decodedResult;
        Set<Map.Entry<DecodedResult, Integer>> entrySet = this.valueSizes.entrySet();
        synchronized (this.valueSizes) {
            decodedResult = null;
            Integer num = null;
            for (Map.Entry<DecodedResult, Integer> entry : entrySet) {
                if (decodedResult == null) {
                    decodedResult = entry.getKey();
                    num = entry.getValue();
                } else {
                    Integer value = entry.getValue();
                    if (value.intValue() > num.intValue()) {
                        decodedResult = entry.getKey();
                        num = value;
                    }
                }
            }
        }
        this.valueSizes.remove(decodedResult);
        return decodedResult;
    }
}
