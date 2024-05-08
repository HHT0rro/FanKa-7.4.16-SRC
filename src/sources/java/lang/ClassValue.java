package java.lang;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import jdk.internal.misc.Unsafe;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class ClassValue<T> {
    private static final int HASH_INCREMENT = 1640531527;
    static final int HASH_MASK = 1073741823;
    final int hashCodeForCache = nextHashCode.getAndAdd(HASH_INCREMENT) & 1073741823;
    final Identity identity = new Identity();
    private volatile Version<T> version = new Version<>(this);
    private static final Entry<?>[] EMPTY_CACHE = {null};
    private static final AtomicInteger nextHashCode = new AtomicInteger();
    private static final Object CRITICAL_SECTION = new Object();
    private static final Unsafe UNSAFE = Unsafe.getUnsafe();

    protected abstract T computeValue(Class<?> cls);

    protected ClassValue() {
    }

    public T get(Class<?> cls) {
        Entry<?>[] cacheCarefully = getCacheCarefully(cls);
        Entry<?> probeHomeLocation = ClassValueMap.probeHomeLocation(cacheCarefully, this);
        if (match(probeHomeLocation)) {
            return (T) probeHomeLocation.value();
        }
        return getFromBackup(cacheCarefully, cls);
    }

    public void remove(Class<?> type) {
        ClassValueMap map = getMap(type);
        map.removeEntry(this);
    }

    void put(Class<?> type, T value) {
        ClassValueMap map = getMap(type);
        map.changeEntry(this, value);
    }

    private static Entry<?>[] getCacheCarefully(Class<?> type) {
        ClassValueMap map = (ClassValueMap) type.ensureExtDataPresent().classValueMap;
        if (map == null) {
            return EMPTY_CACHE;
        }
        Entry<?>[] cache = map.getCache();
        return cache;
    }

    private T getFromBackup(Entry<?>[] cache, Class<?> type) {
        Entry<T> e2 = ClassValueMap.probeBackupLocations(cache, this);
        if (e2 != null) {
            return e2.value();
        }
        return getFromHashMap(type);
    }

    /* JADX WARN: Multi-variable type inference failed */
    Entry<T> castEntry(Entry<?> entry) {
        return entry;
    }

    private T getFromHashMap(Class<?> type) {
        Entry<T> e2;
        ClassValueMap map = getMap(type);
        do {
            Entry<T> e10 = map.startEntry(this);
            if (!e10.isPromise()) {
                return e10.value();
            }
            try {
                e10 = makeEntry(e10.version(), computeValue(type));
            } finally {
                map.finishEntry(this, e10);
            }
        } while (e2 == null);
        return e2.value();
    }

    boolean match(Entry<?> e2) {
        return e2 != null && e2.get() == this.version;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Identity {
        Identity() {
        }
    }

    Version<T> version() {
        return this.version;
    }

    void bumpVersion() {
        this.version = new Version<>(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Version<T> {
        private final ClassValue<T> classValue;
        private final Entry<T> promise = new Entry<>(this);

        Version(ClassValue<T> classValue) {
            this.classValue = classValue;
        }

        ClassValue<T> classValue() {
            return this.classValue;
        }

        Entry<T> promise() {
            return this.promise;
        }

        boolean isLive() {
            return this.classValue.version() == this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Entry<T> extends WeakReference<Version<T>> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final Entry<?> DEAD_ENTRY = new Entry<>(null, null);
        final Object value;

        Entry(Version<T> version, T value) {
            super(version);
            this.value = value;
        }

        private void assertNotPromise() {
        }

        Entry(Version<T> version) {
            super(version);
            this.value = this;
        }

        T value() {
            assertNotPromise();
            return (T) this.value;
        }

        boolean isPromise() {
            return this.value == this;
        }

        Version<T> version() {
            return (Version) get();
        }

        ClassValue<T> classValueOrNull() {
            Version<T> v2 = version();
            if (v2 == null) {
                return null;
            }
            return v2.classValue();
        }

        boolean isLive() {
            Version<T> v2 = version();
            if (v2 == null) {
                return false;
            }
            if (v2.isLive()) {
                return true;
            }
            clear();
            return false;
        }

        Entry<T> refreshVersion(Version<T> v2) {
            assertNotPromise();
            Entry<T> e2 = new Entry<>(v2, this.value);
            clear();
            return e2;
        }
    }

    private static ClassValueMap getMap(Class<?> type) {
        ClassValueMap map = (ClassValueMap) type.ensureExtDataPresent().classValueMap;
        return map != null ? map : initializeMap(type);
    }

    private static ClassValueMap initializeMap(Class<?> type) {
        ClassValueMap map;
        synchronized (CRITICAL_SECTION) {
            ClassValueMap classValueMap = (ClassValueMap) type.ensureExtDataPresent().classValueMap;
            map = classValueMap;
            if (classValueMap == null) {
                map = new ClassValueMap();
                UNSAFE.storeFence();
                type.ensureExtDataPresent().classValueMap = map;
            }
        }
        return map;
    }

    static <T> Entry<T> makeEntry(Version<T> explicitVersion, T value) {
        return new Entry<>(explicitVersion, value);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ClassValueMap extends WeakHashMap<Identity, Entry<?>> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int CACHE_LOAD_LIMIT = 67;
        private static final int INITIAL_ENTRIES = 32;
        private static final int PROBE_LIMIT = 6;
        private Entry<?>[] cacheArray;
        private int cacheLoad;
        private int cacheLoadLimit;

        ClassValueMap() {
            sizeCache(32);
        }

        Entry<?>[] getCache() {
            return this.cacheArray;
        }

        synchronized <T> Entry<T> startEntry(ClassValue<T> classValue) {
            Entry<T> e2 = (Entry) get(classValue.identity);
            Version<T> v2 = classValue.version();
            if (e2 == null) {
                Entry<T> e10 = v2.promise();
                put(classValue.identity, e10);
                return e10;
            }
            if (e2.isPromise()) {
                if (e2.version() != v2) {
                    e2 = v2.promise();
                    put(classValue.identity, e2);
                }
                return e2;
            }
            if (e2.version() != v2) {
                e2 = e2.refreshVersion(v2);
                put(classValue.identity, e2);
            }
            checkCacheLoad();
            addToCache(classValue, e2);
            return e2;
        }

        synchronized <T> Entry<T> finishEntry(ClassValue<T> classValue, Entry<T> e2) {
            Entry<T> e02 = (Entry) get(classValue.identity);
            if (e2 == e02) {
                remove(classValue.identity);
                return null;
            }
            if (e02 == null || !e02.isPromise() || e02.version() != e2.version()) {
                return null;
            }
            Version<T> v2 = classValue.version();
            if (e2.version() != v2) {
                e2 = e2.refreshVersion(v2);
            }
            put(classValue.identity, e2);
            checkCacheLoad();
            addToCache(classValue, e2);
            return e2;
        }

        synchronized void removeEntry(ClassValue<?> classValue) {
            Entry<?> e2 = remove(classValue.identity);
            if (e2 != null) {
                if (e2.isPromise()) {
                    put(classValue.identity, e2);
                } else {
                    classValue.bumpVersion();
                    removeStaleEntries(classValue);
                }
            }
        }

        synchronized <T> void changeEntry(ClassValue<T> classValue, T value) {
            Entry<?> entry = get(classValue.identity);
            Version<T> version = classValue.version();
            if (entry != null) {
                if (entry.version() == version && entry.value() == value) {
                    return;
                }
                classValue.bumpVersion();
                removeStaleEntries(classValue);
            }
            Entry<T> e2 = ClassValue.makeEntry(version, value);
            put(classValue.identity, e2);
            checkCacheLoad();
            addToCache(classValue, e2);
        }

        static Entry<?> loadFromCache(Entry<?>[] cache, int i10) {
            return cache[(cache.length - 1) & i10];
        }

        static <T> Entry<T> probeHomeLocation(Entry<?>[] cache, ClassValue<T> classValue) {
            return classValue.castEntry(loadFromCache(cache, classValue.hashCodeForCache));
        }

        static <T> Entry<T> probeBackupLocations(Entry<?>[] cache, ClassValue<T> classValue) {
            Entry<?> e2;
            Entry<?> entry;
            int mask = cache.length - 1;
            int home = classValue.hashCodeForCache & mask;
            Entry<?> e22 = cache[home];
            if (e22 == null) {
                return null;
            }
            int pos2 = -1;
            for (int i10 = home + 1; i10 < home + 6 && (e2 = cache[i10 & mask]) != null; i10++) {
                if (classValue.match(e2)) {
                    cache[home] = e2;
                    if (pos2 >= 0) {
                        cache[i10 & mask] = Entry.DEAD_ENTRY;
                    } else {
                        pos2 = i10;
                    }
                    int i11 = pos2 & mask;
                    if (entryDislocation(cache, pos2, e22) < 6) {
                        entry = e22;
                    } else {
                        entry = Entry.DEAD_ENTRY;
                    }
                    cache[i11] = entry;
                    return classValue.castEntry(e2);
                }
                if (!e2.isLive() && pos2 < 0) {
                    pos2 = i10;
                }
            }
            return null;
        }

        private static int entryDislocation(Entry<?>[] cache, int pos, Entry<?> e2) {
            ClassValue<?> cv = e2.classValueOrNull();
            if (cv == null) {
                return 0;
            }
            int mask = cache.length - 1;
            return (pos - cv.hashCodeForCache) & mask;
        }

        private void sizeCache(int length) {
            this.cacheLoad = 0;
            this.cacheLoadLimit = (int) ((length * 67.0d) / 100.0d);
            this.cacheArray = new Entry[length];
        }

        private void checkCacheLoad() {
            if (this.cacheLoad >= this.cacheLoadLimit) {
                reduceCacheLoad();
            }
        }

        private void reduceCacheLoad() {
            removeStaleEntries();
            if (this.cacheLoad < this.cacheLoadLimit) {
                return;
            }
            Entry<?>[] oldCache = getCache();
            if (oldCache.length > 1073741823) {
                return;
            }
            sizeCache(oldCache.length * 2);
            for (Entry<?> e2 : oldCache) {
                if (e2 != null && e2.isLive()) {
                    addToCache(e2);
                }
            }
        }

        private void removeStaleEntries(Entry<?>[] cache, int begin, int count) {
            int mask = cache.length - 1;
            int removed = 0;
            for (int i10 = begin; i10 < begin + count; i10++) {
                Entry<?> e2 = cache[i10 & mask];
                if (e2 != null && !e2.isLive()) {
                    Entry<?> replacement = findReplacement(cache, i10);
                    cache[i10 & mask] = replacement;
                    if (replacement == null) {
                        removed++;
                    }
                }
            }
            int i11 = this.cacheLoad;
            this.cacheLoad = Math.max(0, i11 - removed);
        }

        private Entry<?> findReplacement(Entry<?>[] cache, int home1) {
            Entry<?> e2;
            int dis2;
            int home2;
            Entry<?> replacement = null;
            int haveReplacement = -1;
            int replacementPos = 0;
            int mask = cache.length - 1;
            for (int i22 = home1 + 1; i22 < home1 + 6 && (e2 = cache[i22 & mask]) != null; i22++) {
                if (e2.isLive() && (dis2 = entryDislocation(cache, i22, e2)) != 0 && (home2 = i22 - dis2) <= home1) {
                    if (home2 == home1) {
                        haveReplacement = 1;
                        replacementPos = i22;
                        replacement = e2;
                    } else if (haveReplacement <= 0) {
                        haveReplacement = 0;
                        replacementPos = i22;
                        replacement = e2;
                    }
                }
            }
            if (haveReplacement >= 0) {
                if (cache[(replacementPos + 1) & mask] != null) {
                    cache[replacementPos & mask] = Entry.DEAD_ENTRY;
                } else {
                    cache[replacementPos & mask] = null;
                    this.cacheLoad--;
                }
            }
            return replacement;
        }

        private void removeStaleEntries(ClassValue<?> classValue) {
            removeStaleEntries(getCache(), classValue.hashCodeForCache, 6);
        }

        private void removeStaleEntries() {
            Entry<?>[] cache = getCache();
            removeStaleEntries(cache, 0, (cache.length + 6) - 1);
        }

        private <T> void addToCache(Entry<T> e2) {
            ClassValue<T> classValue = e2.classValueOrNull();
            if (classValue != null) {
                addToCache(classValue, e2);
            }
        }

        private <T> void addToCache(ClassValue<T> classValue, Entry<T> e2) {
            Entry<?>[] cache = getCache();
            int mask = cache.length - 1;
            int home = classValue.hashCodeForCache & mask;
            Entry<?> e22 = placeInCache(cache, home, e2, false);
            if (e22 == null) {
                return;
            }
            int dis2 = entryDislocation(cache, home, e22);
            int home2 = home - dis2;
            for (int i22 = home2; i22 < home2 + 6 && placeInCache(cache, i22 & mask, e22, true) != null; i22++) {
            }
        }

        private Entry<?> placeInCache(Entry<?>[] cache, int pos, Entry<?> e2, boolean gently) {
            Entry<?> e22 = overwrittenEntry(cache[pos]);
            if (gently && e22 != null) {
                return e2;
            }
            cache[pos] = e2;
            return e22;
        }

        private <T> Entry<T> overwrittenEntry(Entry<T> e2) {
            if (e2 != null) {
                if (e2.isLive()) {
                    return e2;
                }
                return null;
            }
            this.cacheLoad++;
            return null;
        }
    }
}
