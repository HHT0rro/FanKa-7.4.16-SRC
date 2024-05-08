package java.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Predicate;
import java.util.jar.JarEntry;
import jdk.internal.reflect.CallerSensitive;
import jdk.internal.reflect.Reflection;
import org.apache.commons.io.IOUtils;
import sun.security.action.GetPropertyAction;
import sun.util.locale.BaseLocale;
import sun.util.locale.LocaleObjectCache;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class ResourceBundle {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int INITIAL_CACHE_SIZE = 32;
    private static final String UNKNOWN_FORMAT = "";
    private volatile CacheKey cacheKey;
    private volatile boolean expired;
    private volatile Set<String> keySet;
    private String name;
    private static final ResourceBundle NONEXISTENT_BUNDLE = new ResourceBundle() { // from class: java.util.ResourceBundle.1
        @Override // java.util.ResourceBundle
        public Enumeration<String> getKeys() {
            return null;
        }

        @Override // java.util.ResourceBundle
        protected Object handleGetObject(String key) {
            return null;
        }

        public String toString() {
            return "NONEXISTENT_BUNDLE";
        }
    };
    private static final ConcurrentMap<CacheKey, BundleReference> cacheList = new ConcurrentHashMap(32);
    private static final ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
    private static final boolean TRACE_ON = Boolean.valueOf(GetPropertyAction.privilegedGetProperty("resource.bundle.debug", "false")).booleanValue();
    protected ResourceBundle parent = null;
    private Locale locale = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface CacheKeyReference {
        CacheKey getCacheKey();
    }

    public abstract Enumeration<String> getKeys();

    protected abstract Object handleGetObject(String str);

    public String getBaseBundleName() {
        return this.name;
    }

    public final String getString(String key) {
        return (String) getObject(key);
    }

    public final String[] getStringArray(String key) {
        return (String[]) getObject(key);
    }

    public final Object getObject(String key) {
        Object obj = handleGetObject(key);
        if (obj == null) {
            ResourceBundle resourceBundle = this.parent;
            if (resourceBundle != null) {
                obj = resourceBundle.getObject(key);
            }
            if (obj == null) {
                throw new MissingResourceException("Can't find resource for bundle " + getClass().getName() + ", key " + key, getClass().getName(), key);
            }
        }
        return obj;
    }

    public Locale getLocale() {
        return this.locale;
    }

    private static ClassLoader getLoader(Class<?> caller) {
        ClassLoader cl = caller == null ? null : caller.getClassLoader();
        if (cl == null) {
            return RBClassLoader.INSTANCE;
        }
        return cl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class RBClassLoader extends ClassLoader {
        private static final RBClassLoader INSTANCE = (RBClassLoader) AccessController.doPrivileged(new PrivilegedAction<RBClassLoader>() { // from class: java.util.ResourceBundle.RBClassLoader.1
            @Override // java.security.PrivilegedAction
            public RBClassLoader run() {
                return new RBClassLoader();
            }
        });
        private static final ClassLoader loader = ClassLoader.getSystemClassLoader();

        private RBClassLoader() {
        }

        @Override // java.lang.ClassLoader
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            ClassLoader classLoader = loader;
            if (classLoader != null) {
                return classLoader.loadClass(name);
            }
            return Class.forName(name);
        }

        @Override // java.lang.ClassLoader
        public URL getResource(String name) {
            ClassLoader classLoader = loader;
            if (classLoader != null) {
                return classLoader.getResource(name);
            }
            return ClassLoader.getSystemResource(name);
        }

        @Override // java.lang.ClassLoader
        public InputStream getResourceAsStream(String name) {
            ClassLoader classLoader = loader;
            if (classLoader != null) {
                return classLoader.getResourceAsStream(name);
            }
            return ClassLoader.getSystemResourceAsStream(name);
        }
    }

    protected void setParent(ResourceBundle parent) {
        this.parent = parent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class CacheKey {
        private volatile Throwable cause;
        private volatile long expirationTime;
        private volatile String format;
        private volatile long loadTime;
        private final KeyElementReference<ClassLoader> loaderRef;
        private volatile Locale locale;
        private final String name;

        CacheKey(String baseName, Locale locale, ClassLoader loader) {
            this.name = baseName;
            this.locale = locale;
            if (loader == null) {
                this.loaderRef = null;
            } else {
                this.loaderRef = new KeyElementReference<>(loader, ResourceBundle.referenceQueue, this);
            }
        }

        CacheKey(CacheKey src) {
            this.name = src.name;
            this.locale = src.locale;
            KeyElementReference<ClassLoader> keyElementReference = src.loaderRef;
            if (keyElementReference == null) {
                this.loaderRef = null;
            } else {
                ClassLoader loader = keyElementReference.get();
                this.loaderRef = new KeyElementReference<>(loader, ResourceBundle.referenceQueue, this);
            }
            this.format = src.format;
            this.loadTime = src.loadTime;
            this.expirationTime = src.expirationTime;
        }

        String getName() {
            return this.name;
        }

        Locale getLocale() {
            return this.locale;
        }

        CacheKey setLocale(Locale locale) {
            this.locale = locale;
            return this;
        }

        ClassLoader getLoader() {
            KeyElementReference<ClassLoader> keyElementReference = this.loaderRef;
            if (keyElementReference != null) {
                return keyElementReference.get();
            }
            return null;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            try {
                CacheKey otherEntry = (CacheKey) other;
                if (!this.name.equals(otherEntry.name) || !this.locale.equals(otherEntry.locale)) {
                    return false;
                }
                KeyElementReference<ClassLoader> keyElementReference = this.loaderRef;
                if (keyElementReference == null) {
                    if (otherEntry.loaderRef == null) {
                        return true;
                    }
                    return false;
                }
                ClassLoader loader = keyElementReference.get();
                KeyElementReference<ClassLoader> keyElementReference2 = otherEntry.loaderRef;
                if (keyElementReference2 != null && loader != null && keyElementReference2.refersTo(loader)) {
                    return true;
                }
                return false;
            } catch (ClassCastException | NullPointerException e2) {
                return false;
            }
        }

        public int hashCode() {
            int hashCode = (this.name.hashCode() << 3) ^ this.locale.hashCode();
            ClassLoader loader = getLoader();
            if (loader != null) {
                return hashCode ^ loader.hashCode();
            }
            return hashCode;
        }

        String getFormat() {
            return this.format;
        }

        void setFormat(String format) {
            this.format = format;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCause(Throwable cause) {
            if (this.cause == null) {
                this.cause = cause;
            } else if (this.cause instanceof ClassNotFoundException) {
                this.cause = cause;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Throwable getCause() {
            return this.cause;
        }

        public String toString() {
            String l10 = this.locale.toString();
            if (l10.isEmpty()) {
                if (!this.locale.getVariant().isEmpty()) {
                    l10 = "__" + this.locale.getVariant();
                } else {
                    l10 = "\"\"";
                }
            }
            return "CacheKey[" + this.name + ", locale=" + l10 + ", classLoader" + ((Object) getLoader()) + ", format=" + this.format + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class KeyElementReference<T> extends WeakReference<T> implements CacheKeyReference {
        private final CacheKey cacheKey;

        KeyElementReference(T referent, ReferenceQueue<Object> q10, CacheKey key) {
            super(referent, q10);
            this.cacheKey = key;
        }

        @Override // java.util.ResourceBundle.CacheKeyReference
        public CacheKey getCacheKey() {
            return this.cacheKey;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class BundleReference extends SoftReference<ResourceBundle> implements CacheKeyReference {
        private final CacheKey cacheKey;

        BundleReference(ResourceBundle referent, ReferenceQueue<Object> q10, CacheKey key) {
            super(referent, q10);
            this.cacheKey = key;
        }

        @Override // java.util.ResourceBundle.CacheKeyReference
        public CacheKey getCacheKey() {
            return this.cacheKey;
        }
    }

    @CallerSensitive
    public static final ResourceBundle getBundle(String baseName) {
        Class<?> caller = Reflection.getCallerClass();
        return getBundleImpl(baseName, Locale.getDefault(), caller, getDefaultControl(caller, baseName));
    }

    @CallerSensitive
    public static final ResourceBundle getBundle(String baseName, Control control) {
        Class<?> caller = Reflection.getCallerClass();
        Locale targetLocale = Locale.getDefault();
        return getBundleImpl(baseName, targetLocale, caller, control);
    }

    @CallerSensitive
    public static final ResourceBundle getBundle(String baseName, Locale locale) {
        Class<?> caller = Reflection.getCallerClass();
        return getBundleImpl(baseName, locale, caller, getDefaultControl(caller, baseName));
    }

    @CallerSensitive
    public static final ResourceBundle getBundle(String baseName, Locale targetLocale, Control control) {
        Class<?> caller = Reflection.getCallerClass();
        return getBundleImpl(baseName, targetLocale, caller, control);
    }

    @CallerSensitive
    public static ResourceBundle getBundle(String baseName, Locale locale, ClassLoader loader) {
        if (loader == null) {
            throw new NullPointerException();
        }
        Class<?> caller = Reflection.getCallerClass();
        return getBundleImpl(baseName, locale, caller, loader, getDefaultControl(caller, baseName));
    }

    @CallerSensitive
    public static ResourceBundle getBundle(String baseName, Locale targetLocale, ClassLoader loader, Control control) {
        if (loader == null || control == null) {
            throw new NullPointerException();
        }
        Class<?> caller = Reflection.getCallerClass();
        return getBundleImpl(baseName, targetLocale, caller, loader, control);
    }

    private static Control getDefaultControl(String baseName) {
        return Control.INSTANCE;
    }

    private static Control getDefaultControl(Class<?> caller, String baseName) {
        return getDefaultControl(baseName);
    }

    private static ResourceBundle getBundleImpl(String baseName, Locale locale, Class<?> caller, Control control) {
        return getBundleImpl(baseName, locale, caller, caller.getClassLoader(), control);
    }

    private static ResourceBundle getBundleImpl(String baseName, Locale locale, Class<?> caller, ClassLoader loader, Control control) {
        if (caller == null) {
            throw new InternalError("null caller");
        }
        return getBundleImpl(baseName, locale, loader, control);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00bb, code lost:
    
        if (r17 != null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00bd, code lost:
    
        r17 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.ResourceBundle getBundleImpl(java.lang.String r20, java.util.Locale r21, java.lang.ClassLoader r22, java.util.ResourceBundle.Control r23) {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.ResourceBundle.getBundleImpl(java.lang.String, java.util.Locale, java.lang.ClassLoader, java.util.ResourceBundle$Control):java.util.ResourceBundle");
    }

    private static boolean checkList(List<?> a10) {
        boolean valid = (a10 == null || a10.isEmpty()) ? false : true;
        if (valid) {
            int size = a10.size();
            for (int i10 = 0; valid && i10 < size; i10++) {
                valid = a10.get(i10) != null;
            }
        }
        return valid;
    }

    private static ResourceBundle findBundle(CacheKey cacheKey, List<Locale> candidateLocales, List<String> formats, int index, Control control, ResourceBundle baseBundle) {
        Locale targetLocale = candidateLocales.get(index);
        ResourceBundle parent = null;
        if (index != candidateLocales.size() - 1) {
            parent = findBundle(cacheKey, candidateLocales, formats, index + 1, control, baseBundle);
        } else if (baseBundle != null && Locale.ROOT.equals(targetLocale)) {
            return baseBundle;
        }
        while (true) {
            Object ref = referenceQueue.poll();
            if (ref == null) {
                break;
            }
            cacheList.remove(((CacheKeyReference) ref).getCacheKey());
        }
        boolean expiredBundle = false;
        cacheKey.setLocale(targetLocale);
        ResourceBundle bundle = findBundleInCache(cacheKey, control);
        if (isValidBundle(bundle) && !(expiredBundle = bundle.expired)) {
            if (bundle.parent == parent) {
                return bundle;
            }
            ConcurrentMap<CacheKey, BundleReference> concurrentMap = cacheList;
            BundleReference bundleRef = concurrentMap.get(cacheKey);
            if (bundleRef != null && bundleRef.refersTo(bundle)) {
                concurrentMap.remove(cacheKey, bundleRef);
            }
        }
        ResourceBundle resourceBundle = NONEXISTENT_BUNDLE;
        if (bundle != resourceBundle) {
            trace("findBundle: %d %s %s formats: %s%n", Integer.valueOf(index), candidateLocales, cacheKey, formats);
            ResourceBundle bundle2 = loadBundle(cacheKey, formats, control, expiredBundle);
            if (bundle2 != null) {
                if (bundle2.parent == null) {
                    bundle2.setParent(parent);
                }
                bundle2.locale = targetLocale;
                return putBundleInCache(cacheKey, bundle2, control);
            }
            putBundleInCache(cacheKey, resourceBundle, control);
        }
        return parent;
    }

    private static ResourceBundle loadBundle(CacheKey cacheKey, List<String> formats, Control control, boolean reload) {
        Locale targetLocale = cacheKey.getLocale();
        Iterator<String> iterator2 = formats.iterator2();
        ResourceBundle bundle = null;
        while (true) {
            if (!iterator2.hasNext()) {
                break;
            }
            String format = iterator2.next();
            try {
                ResourceBundle bundle2 = control.newBundle(cacheKey.getName(), targetLocale, format, cacheKey.getLoader(), reload);
                bundle = bundle2;
            } catch (Exception | LinkageError error) {
                cacheKey.setCause(error);
            }
            if (bundle != null) {
                cacheKey.setFormat(format);
                bundle.name = cacheKey.getName();
                bundle.locale = targetLocale;
                bundle.expired = false;
                break;
            }
        }
        return bundle;
    }

    private static boolean isValidBundle(ResourceBundle bundle) {
        return (bundle == null || bundle == NONEXISTENT_BUNDLE) ? false : true;
    }

    private static boolean hasValidParentChain(ResourceBundle bundle) {
        long now = System.currentTimeMillis();
        while (bundle != null) {
            if (bundle.expired) {
                return false;
            }
            CacheKey key = bundle.cacheKey;
            if (key != null) {
                long expirationTime = key.expirationTime;
                if (expirationTime >= 0 && expirationTime <= now) {
                    return false;
                }
            }
            bundle = bundle.parent;
        }
        return true;
    }

    private static void throwMissingResourceException(String baseName, Locale locale, Throwable cause) {
        if (cause instanceof MissingResourceException) {
            cause = null;
        }
        throw new MissingResourceException("Can't find bundle for base name " + baseName + ", locale " + ((Object) locale), baseName + "_" + ((Object) locale), "", cause);
    }

    private static ResourceBundle findBundleInCache(CacheKey cacheKey, Control control) {
        ResourceBundle bundle;
        long expirationTime;
        ConcurrentMap<CacheKey, BundleReference> concurrentMap = cacheList;
        BundleReference bundleRef = concurrentMap.get(cacheKey);
        if (bundleRef == null || (bundle = bundleRef.get()) == null) {
            return null;
        }
        ResourceBundle p10 = bundle.parent;
        if (p10 != null && p10.expired) {
            bundle.expired = true;
            bundle.cacheKey = null;
            concurrentMap.remove(cacheKey, bundleRef);
            return null;
        }
        CacheKey key = bundleRef.getCacheKey();
        long expirationTime2 = key.expirationTime;
        if (bundle.expired || expirationTime2 < 0) {
            return bundle;
        }
        if (expirationTime2 <= System.currentTimeMillis()) {
            if (bundle == NONEXISTENT_BUNDLE) {
                concurrentMap.remove(cacheKey, bundleRef);
                return null;
            }
            synchronized (bundle) {
                try {
                    expirationTime = key.expirationTime;
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (!bundle.expired && expirationTime >= 0) {
                        if (expirationTime <= System.currentTimeMillis()) {
                            try {
                                bundle.expired = control.needsReload(key.getName(), key.getLocale(), key.getFormat(), key.getLoader(), bundle, key.loadTime);
                            } catch (Exception e2) {
                                cacheKey.setCause(e2);
                            }
                            if (bundle.expired) {
                                bundle.cacheKey = null;
                                cacheList.remove(cacheKey, bundleRef);
                            } else {
                                try {
                                    setExpirationTime(key, control);
                                } catch (Throwable th2) {
                                    th = th2;
                                    while (true) {
                                        try {
                                            break;
                                        } catch (Throwable th3) {
                                            th = th3;
                                        }
                                    }
                                    throw th;
                                }
                            }
                        }
                    }
                    return bundle;
                } catch (Throwable th4) {
                    th = th4;
                    while (true) {
                        break;
                        break;
                    }
                    throw th;
                }
            }
        }
        return bundle;
    }

    private static ResourceBundle putBundleInCache(CacheKey cacheKey, ResourceBundle bundle, Control control) {
        setExpirationTime(cacheKey, control);
        if (cacheKey.expirationTime != -1) {
            CacheKey key = new CacheKey(cacheKey);
            BundleReference bundleRef = new BundleReference(bundle, referenceQueue, key);
            bundle.cacheKey = key;
            ConcurrentMap<CacheKey, BundleReference> concurrentMap = cacheList;
            BundleReference result = concurrentMap.putIfAbsent(key, bundleRef);
            if (result != null) {
                ResourceBundle rb2 = result.get();
                if (rb2 != null && !rb2.expired) {
                    bundle.cacheKey = null;
                    bundleRef.clear();
                    return rb2;
                }
                concurrentMap.put(key, bundleRef);
                return bundle;
            }
            return bundle;
        }
        return bundle;
    }

    private static void setExpirationTime(CacheKey cacheKey, Control control) {
        long ttl = control.getTimeToLive(cacheKey.getName(), cacheKey.getLocale());
        if (ttl >= 0) {
            long now = System.currentTimeMillis();
            cacheKey.loadTime = now;
            cacheKey.expirationTime = now + ttl;
        } else {
            if (ttl >= -2) {
                cacheKey.expirationTime = ttl;
                return;
            }
            throw new IllegalArgumentException("Invalid Control: TTL=" + ttl);
        }
    }

    @CallerSensitive
    public static final void clearCache() {
        clearCache(getLoader(Reflection.getCallerClass()));
    }

    public static final void clearCache(final ClassLoader loader) {
        Objects.requireNonNull(loader);
        cacheList.h().removeIf(new Predicate() { // from class: java.util.ResourceBundle$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ResourceBundle.lambda$clearCache$0(ClassLoader.this, (ResourceBundle.CacheKey) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$clearCache$0(ClassLoader loader, CacheKey key) {
        return key.getLoader() == loader;
    }

    public boolean containsKey(String key) {
        if (key == null) {
            throw new NullPointerException();
        }
        for (ResourceBundle rb2 = this; rb2 != null; rb2 = rb2.parent) {
            if (rb2.handleKeySet().contains(key)) {
                return true;
            }
        }
        return false;
    }

    public Set<String> keySet() {
        Set<String> keys = new HashSet<>();
        for (ResourceBundle rb2 = this; rb2 != null; rb2 = rb2.parent) {
            keys.addAll(rb2.handleKeySet());
        }
        return keys;
    }

    protected Set<String> handleKeySet() {
        if (this.keySet == null) {
            synchronized (this) {
                if (this.keySet == null) {
                    Set<String> keys = new HashSet<>();
                    Enumeration<String> enumKeys = getKeys();
                    while (enumKeys.hasMoreElements()) {
                        String key = enumKeys.nextElement();
                        if (handleGetObject(key) != null) {
                            keys.add(key);
                        }
                    }
                    this.keySet = keys;
                }
            }
        }
        return this.keySet;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Control {
        public static final long TTL_DONT_CACHE = -1;
        public static final long TTL_NO_EXPIRATION_CONTROL = -2;
        public static final List<String> FORMAT_DEFAULT = List.of("java.class", "java.properties");
        public static final List<String> FORMAT_CLASS = List.of("java.class");
        public static final List<String> FORMAT_PROPERTIES = List.of("java.properties");
        private static final Control INSTANCE = new Control();
        private static final CandidateListCache CANDIDATES_CACHE = new CandidateListCache();

        protected Control() {
        }

        public static final Control getControl(List<String> formats) {
            if (formats.equals(FORMAT_PROPERTIES)) {
                return SingleFormatControl.PROPERTIES_ONLY;
            }
            if (formats.equals(FORMAT_CLASS)) {
                return SingleFormatControl.CLASS_ONLY;
            }
            if (formats.equals(FORMAT_DEFAULT)) {
                return INSTANCE;
            }
            throw new IllegalArgumentException();
        }

        public static final Control getNoFallbackControl(List<String> formats) {
            if (formats.equals(FORMAT_DEFAULT)) {
                return NoFallbackControl.NO_FALLBACK;
            }
            if (formats.equals(FORMAT_PROPERTIES)) {
                return NoFallbackControl.PROPERTIES_ONLY_NO_FALLBACK;
            }
            if (formats.equals(FORMAT_CLASS)) {
                return NoFallbackControl.CLASS_ONLY_NO_FALLBACK;
            }
            throw new IllegalArgumentException();
        }

        public List<String> getFormats(String baseName) {
            if (baseName == null) {
                throw new NullPointerException();
            }
            return FORMAT_DEFAULT;
        }

        public List<Locale> getCandidateLocales(String baseName, Locale locale) {
            if (baseName == null) {
                throw new NullPointerException();
            }
            return new ArrayList(CANDIDATES_CACHE.get(locale.getBaseLocale()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static class CandidateListCache extends LocaleObjectCache<BaseLocale, List<Locale>> {
            private CandidateListCache() {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code restructure failed: missing block: B:36:0x0087, code lost:
            
                if (r2.equals("HK") != false) goto L43;
             */
            @Override // sun.util.locale.LocaleObjectCache
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.util.List<java.util.Locale> createObject(sun.util.locale.BaseLocale r16) {
                /*
                    Method dump skipped, instructions count: 300
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ResourceBundle.Control.CandidateListCache.createObject(sun.util.locale.BaseLocale):java.util.List");
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code restructure failed: missing block: B:32:0x0087, code lost:
            
                if (r9.equals("Hans") != false) goto L32;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private static java.util.List<java.util.Locale> getDefaultList(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11) {
                /*
                    r0 = 0
                    boolean r1 = r11.isEmpty()
                    r2 = 0
                    r3 = -1
                    if (r1 != 0) goto L25
                    java.util.LinkedList r1 = new java.util.LinkedList
                    r1.<init>()
                    r0 = r1
                    int r1 = r11.length()
                L13:
                    if (r1 == r3) goto L25
                    java.lang.String r4 = r11.substring(r2, r1)
                    r0.add(r4)
                    int r1 = r1 + (-1)
                    r4 = 95
                    int r1 = r11.lastIndexOf(r4, r1)
                    goto L13
                L25:
                    java.util.LinkedList r1 = new java.util.LinkedList
                    r1.<init>()
                    r4 = 0
                    if (r0 == 0) goto L45
                    java.util.Iterator r5 = r0.iterator2()
                L31:
                    boolean r6 = r5.hasNext()
                    if (r6 == 0) goto L45
                    java.lang.Object r6 = r5.next()
                    java.lang.String r6 = (java.lang.String) r6
                    java.util.Locale r7 = java.util.Locale.getInstance(r8, r9, r10, r6, r4)
                    r1.add(r7)
                    goto L31
                L45:
                    boolean r5 = r10.isEmpty()
                    java.lang.String r6 = ""
                    if (r5 != 0) goto L54
                    java.util.Locale r5 = java.util.Locale.getInstance(r8, r9, r10, r6, r4)
                    r1.add(r5)
                L54:
                    boolean r5 = r9.isEmpty()
                    if (r5 != 0) goto Lbc
                    java.util.Locale r5 = java.util.Locale.getInstance(r8, r9, r6, r6, r4)
                    r1.add(r5)
                    java.lang.String r5 = "zh"
                    boolean r5 = r8.equals(r5)
                    if (r5 == 0) goto L95
                    boolean r5 = r10.isEmpty()
                    if (r5 == 0) goto L95
                    int r5 = r9.hashCode()
                    switch(r5) {
                        case 2241694: goto L81;
                        case 2241695: goto L77;
                        default: goto L76;
                    }
                L76:
                    goto L8a
                L77:
                    java.lang.String r2 = "Hant"
                    boolean r2 = r9.equals(r2)
                    if (r2 == 0) goto L76
                    r2 = 1
                    goto L8b
                L81:
                    java.lang.String r5 = "Hans"
                    boolean r5 = r9.equals(r5)
                    if (r5 == 0) goto L76
                    goto L8b
                L8a:
                    r2 = r3
                L8b:
                    switch(r2) {
                        case 0: goto L92;
                        case 1: goto L8f;
                        default: goto L8e;
                    }
                L8e:
                    goto L95
                L8f:
                    java.lang.String r10 = "TW"
                    goto L95
                L92:
                    java.lang.String r10 = "CN"
                L95:
                    if (r0 == 0) goto Laf
                    java.util.Iterator r2 = r0.iterator2()
                L9b:
                    boolean r3 = r2.hasNext()
                    if (r3 == 0) goto Laf
                    java.lang.Object r3 = r2.next()
                    java.lang.String r3 = (java.lang.String) r3
                    java.util.Locale r5 = java.util.Locale.getInstance(r8, r6, r10, r3, r4)
                    r1.add(r5)
                    goto L9b
                Laf:
                    boolean r2 = r10.isEmpty()
                    if (r2 != 0) goto Lbc
                    java.util.Locale r2 = java.util.Locale.getInstance(r8, r6, r10, r6, r4)
                    r1.add(r2)
                Lbc:
                    boolean r2 = r8.isEmpty()
                    if (r2 != 0) goto Lc9
                    java.util.Locale r2 = java.util.Locale.getInstance(r8, r6, r6, r6, r4)
                    r1.add(r2)
                Lc9:
                    java.util.Locale r2 = java.util.Locale.ROOT
                    r1.add(r2)
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: java.util.ResourceBundle.Control.CandidateListCache.getDefaultList(java.lang.String, java.lang.String, java.lang.String, java.lang.String):java.util.List");
            }
        }

        public Locale getFallbackLocale(String baseName, Locale locale) {
            if (baseName == null) {
                throw new NullPointerException();
            }
            Locale defaultLocale = Locale.getDefault();
            if (locale.equals(defaultLocale)) {
                return null;
            }
            return defaultLocale;
        }

        public ResourceBundle newBundle(String baseName, Locale locale, String format, final ClassLoader loader, final boolean reload) throws IllegalAccessException, InstantiationException, IOException {
            final Constructor<?> constructor;
            String bundleName = toBundleName(baseName, locale);
            ResourceBundle bundle = null;
            if (format.equals("java.class")) {
                try {
                    Class<?> c4 = loader.loadClass(bundleName);
                    if (ResourceBundle.class.isAssignableFrom(c4)) {
                        try {
                            constructor = c4.getConstructor(new Class[0]);
                        } catch (InvocationTargetException e2) {
                            ResourceBundle.uncheckedThrow(e2);
                        }
                        if (!Modifier.isPublic(constructor.getModifiers())) {
                            return null;
                        }
                        PrivilegedAction<Void> pa1 = new PrivilegedAction() { // from class: java.util.ResourceBundle$Control$$ExternalSyntheticLambda0
                            @Override // java.security.PrivilegedAction
                            public final Object run() {
                                return ResourceBundle.Control.lambda$newBundle$0(Constructor.this);
                            }
                        };
                        AccessController.doPrivileged(pa1);
                        bundle = (ResourceBundle) constructor.newInstance(null);
                        return bundle;
                    }
                    throw new ClassCastException(c4.getName() + " cannot be cast to ResourceBundle");
                } catch (ClassNotFoundException | NoSuchMethodException e10) {
                    return null;
                }
            }
            if (format.equals("java.properties")) {
                final String resourceName = toResourceName0(bundleName, "properties");
                if (resourceName == null) {
                    return null;
                }
                try {
                    InputStream stream = (InputStream) AccessController.doPrivileged(new PrivilegedExceptionAction<InputStream>() { // from class: java.util.ResourceBundle.Control.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // java.security.PrivilegedExceptionAction
                        public InputStream run() throws IOException {
                            URL url = loader.getResource(resourceName);
                            if (url == null) {
                                return null;
                            }
                            URLConnection connection = url.openConnection();
                            if (reload) {
                                connection.setUseCaches(false);
                            }
                            return connection.getInputStream();
                        }
                    });
                    if (stream == null) {
                        return null;
                    }
                    try {
                        ResourceBundle bundle2 = new PropertyResourceBundle(new InputStreamReader(stream, StandardCharsets.UTF_8));
                        return bundle2;
                    } finally {
                        stream.close();
                    }
                } catch (PrivilegedActionException e11) {
                    throw ((IOException) e11.getException());
                }
            }
            throw new IllegalArgumentException("unknown format: " + format);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ Void lambda$newBundle$0(Constructor ctor) {
            ctor.setAccessible(true);
            return null;
        }

        public long getTimeToLive(String baseName, Locale locale) {
            if (baseName == null || locale == null) {
                throw new NullPointerException();
            }
            return -2L;
        }

        public boolean needsReload(String baseName, Locale locale, String format, ClassLoader loader, ResourceBundle bundle, long loadTime) {
            if (bundle == null) {
                throw new NullPointerException();
            }
            try {
            } catch (NullPointerException e2) {
                npe = e2;
            } catch (Exception e10) {
            }
            try {
                String resourceName = toResourceName0(toBundleName(baseName, locale), (format.equals("java.class") || format.equals("java.properties")) ? format.substring(5) : format);
                if (resourceName == null) {
                    return false;
                }
                try {
                    URL url = loader.getResource(resourceName);
                    if (url == null) {
                        return false;
                    }
                    long lastModified = 0;
                    URLConnection connection = url.openConnection();
                    if (connection != null) {
                        connection.setUseCaches(false);
                        if (connection instanceof JarURLConnection) {
                            JarEntry ent = ((JarURLConnection) connection).getJarEntry();
                            if (ent != null) {
                                lastModified = ent.getTime();
                                if (lastModified == -1) {
                                    lastModified = 0;
                                }
                            }
                        } else {
                            lastModified = connection.getLastModified();
                        }
                    }
                    boolean result = lastModified >= loadTime;
                    return result;
                } catch (NullPointerException npe) {
                    throw npe;
                } catch (Exception e11) {
                    return false;
                }
            } catch (NullPointerException e12) {
                npe = e12;
                throw npe;
            } catch (Exception e13) {
                return false;
            }
        }

        public String toBundleName(String baseName, Locale locale) {
            if (locale == Locale.ROOT) {
                return baseName;
            }
            String language = locale.getLanguage();
            String script = locale.getScript();
            String country = locale.getCountry();
            String variant = locale.getVariant();
            if (language == "" && country == "" && variant == "") {
                return baseName;
            }
            StringBuilder sb2 = new StringBuilder(baseName);
            sb2.append('_');
            if (script != "") {
                if (variant != "") {
                    sb2.append(language).append('_').append(script).append('_').append(country).append('_').append(variant);
                } else if (country != "") {
                    sb2.append(language).append('_').append(script).append('_').append(country);
                } else {
                    sb2.append(language).append('_').append(script);
                }
            } else if (variant != "") {
                sb2.append(language).append('_').append(country).append('_').append(variant);
            } else if (country != "") {
                sb2.append(language).append('_').append(country);
            } else {
                sb2.append(language);
            }
            return sb2.toString();
        }

        public final String toResourceName(String bundleName, String suffix) {
            StringBuilder sb2 = new StringBuilder(bundleName.length() + 1 + suffix.length());
            sb2.append(bundleName.replace('.', IOUtils.DIR_SEPARATOR_UNIX)).append('.').append(suffix);
            return sb2.toString();
        }

        private String toResourceName0(String bundleName, String suffix) {
            if (bundleName.contains("://")) {
                return null;
            }
            return toResourceName(bundleName, suffix);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends Throwable> void uncheckedThrow(Throwable t2) throws Throwable {
        if (t2 != null) {
            throw t2;
        }
        throw new Error("Unknown Exception");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class SingleFormatControl extends Control {
        private final List<String> formats;
        private static final Control PROPERTIES_ONLY = new SingleFormatControl(FORMAT_PROPERTIES);
        private static final Control CLASS_ONLY = new SingleFormatControl(FORMAT_CLASS);

        protected SingleFormatControl(List<String> formats) {
            this.formats = formats;
        }

        @Override // java.util.ResourceBundle.Control
        public List<String> getFormats(String baseName) {
            if (baseName == null) {
                throw new NullPointerException();
            }
            return this.formats;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class NoFallbackControl extends SingleFormatControl {
        private static final Control NO_FALLBACK = new NoFallbackControl(FORMAT_DEFAULT);
        private static final Control PROPERTIES_ONLY_NO_FALLBACK = new NoFallbackControl(FORMAT_PROPERTIES);
        private static final Control CLASS_ONLY_NO_FALLBACK = new NoFallbackControl(FORMAT_CLASS);

        protected NoFallbackControl(List<String> formats) {
            super(formats);
        }

        @Override // java.util.ResourceBundle.Control
        public Locale getFallbackLocale(String baseName, Locale locale) {
            if (baseName == null || locale == null) {
                throw new NullPointerException();
            }
            return null;
        }
    }

    private static void trace(String format, Object... params) {
        if (TRACE_ON) {
            System.out.format(format, params);
        }
    }
}
