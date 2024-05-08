package com.ss.android.socialbase.downloader.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class LruCache<K, T> extends LinkedHashMap<K, T> {
    private static final int DEFAULT_SIZE = 4;
    private int mMaxSize;

    public LruCache() {
        this(4, 4);
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, T> entry) {
        return size() > this.mMaxSize;
    }

    public void setMaxSize(int i10) {
        this.mMaxSize = i10;
    }

    public LruCache(int i10, int i11) {
        this(i10, i11, true);
    }

    public LruCache(int i10, int i11, boolean z10) {
        super(i10, 0.75f, z10);
        setMaxSize(i11);
    }
}
