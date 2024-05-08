package java.util;

import com.huawei.openalliance.ad.constant.u;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class ServiceLoader<S> implements Iterable<S> {
    private static final String PREFIX = "META-INF/services/";
    private final ClassLoader loader;
    private ServiceLoader<S>.LazyIterator lookupIterator;
    private LinkedHashMap<String, S> providers = new LinkedHashMap<>();
    private final Class<S> service;

    public void reload() {
        this.providers.clear();
        this.lookupIterator = new LazyIterator(this.service, this.loader);
    }

    private ServiceLoader(Class<S> svc, ClassLoader cl) {
        this.service = (Class) Objects.requireNonNull(svc, "Service interface cannot be null");
        this.loader = cl == null ? ClassLoader.getSystemClassLoader() : cl;
        reload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void fail(Class<?> service, String msg, Throwable cause) throws ServiceConfigurationError {
        throw new ServiceConfigurationError(service.getName() + ": " + msg, cause);
    }

    private static void fail(Class<?> service, String msg) throws ServiceConfigurationError {
        throw new ServiceConfigurationError(service.getName() + ": " + msg);
    }

    private static void fail(Class<?> service, URL u10, int line, String msg) throws ServiceConfigurationError {
        fail(service, ((Object) u10) + u.bD + line + ": " + msg);
    }

    private int parseLine(Class<?> service, URL u10, BufferedReader r10, int lc2, List<String> names) throws IOException, ServiceConfigurationError {
        String ln = r10.readLine();
        if (ln == null) {
            return -1;
        }
        int ci = ln.indexOf(35);
        if (ci >= 0) {
            ln = ln.substring(0, ci);
        }
        String ln2 = ln.trim();
        int n10 = ln2.length();
        if (n10 != 0) {
            if (ln2.indexOf(32) >= 0 || ln2.indexOf(9) >= 0) {
                fail(service, u10, lc2, "Illegal configuration-file syntax");
            }
            int cp = ln2.codePointAt(0);
            if (!Character.isJavaIdentifierStart(cp)) {
                fail(service, u10, lc2, "Illegal provider-class name: " + ln2);
            }
            int i10 = Character.charCount(cp);
            while (i10 < n10) {
                int cp2 = ln2.codePointAt(i10);
                if (!Character.isJavaIdentifierPart(cp2) && cp2 != 46) {
                    fail(service, u10, lc2, "Illegal provider-class name: " + ln2);
                }
                i10 += Character.charCount(cp2);
            }
            if (!this.providers.containsKey(ln2) && !names.contains(ln2)) {
                names.add(ln2);
            }
        }
        return lc2 + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005e A[Catch: IOException -> 0x005a, TRY_LEAVE, TryCatch #0 {IOException -> 0x005a, blocks: (B:38:0x0056, B:31:0x005e), top: B:37:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Iterator, java.util.Iterator<java.lang.String>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Iterator<java.lang.String> parse(java.lang.Class<?> r10, java.net.URL r11) throws java.util.ServiceConfigurationError {
        /*
            r9 = this;
            java.lang.String r0 = "Error closing configuration file"
            r1 = 0
            r2 = 0
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.io.InputStream r3 = r11.openStream()     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L3b
            r1 = r3
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L3b
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L3b
            java.lang.String r4 = "utf-8"
            r3.<init>(r1, r4)     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L3b
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L37 java.io.IOException -> L3b
            r2 = 1
        L1b:
            r3 = r9
            r4 = r10
            r5 = r11
            r7 = r2
            int r3 = r3.parseLine(r4, r5, r6, r7, r8)     // Catch: java.io.IOException -> L35 java.lang.Throwable -> L53
            r2 = r3
            if (r3 < 0) goto L27
            goto L1b
        L27:
            r6.close()     // Catch: java.io.IOException -> L30
            if (r1 == 0) goto L2f
            r1.close()     // Catch: java.io.IOException -> L30
        L2f:
            goto L4e
        L30:
            r2 = move-exception
            fail(r10, r0, r2)
            goto L4e
        L35:
            r2 = move-exception
            goto L3e
        L37:
            r3 = move-exception
            r6 = r2
            r2 = r3
            goto L54
        L3b:
            r3 = move-exception
            r6 = r2
            r2 = r3
        L3e:
            java.lang.String r3 = "Error reading configuration file"
            fail(r10, r3, r2)     // Catch: java.lang.Throwable -> L53
            if (r6 == 0) goto L48
            r6.close()     // Catch: java.io.IOException -> L30
        L48:
            if (r1 == 0) goto L2f
            r1.close()     // Catch: java.io.IOException -> L30
            goto L2f
        L4e:
            java.util.Iterator r0 = r8.iterator2()
            return r0
        L53:
            r2 = move-exception
        L54:
            if (r6 == 0) goto L5c
            r6.close()     // Catch: java.io.IOException -> L5a
            goto L5c
        L5a:
            r3 = move-exception
            goto L62
        L5c:
            if (r1 == 0) goto L66
            r1.close()     // Catch: java.io.IOException -> L5a
            goto L66
        L62:
            fail(r10, r0, r3)
            goto L67
        L66:
        L67:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.ServiceLoader.parse(java.lang.Class, java.net.URL):java.util.Iterator");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class LazyIterator implements Iterator<S> {
        Enumeration<URL> configs;
        ClassLoader loader;
        String nextName;
        Iterator<String> pending;
        Class<S> service;

        private LazyIterator(Class<S> service, ClassLoader loader) {
            this.configs = null;
            this.pending = null;
            this.nextName = null;
            this.service = service;
            this.loader = loader;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x005b A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x005d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x003d -> B:7:0x003d). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0036 -> B:7:0x003d). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private boolean hasNextService() {
            /*
                r4 = this;
                java.lang.String r0 = r4.nextName
                r1 = 1
                if (r0 == 0) goto L6
                return r1
            L6:
                java.util.Enumeration<java.net.URL> r0 = r4.configs
                if (r0 != 0) goto L3d
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L35
                r0.<init>()     // Catch: java.io.IOException -> L35
                java.lang.String r2 = "META-INF/services/"
                java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.io.IOException -> L35
                java.lang.Class<S> r2 = r4.service     // Catch: java.io.IOException -> L35
                java.lang.String r2 = r2.getName()     // Catch: java.io.IOException -> L35
                java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.io.IOException -> L35
                java.lang.String r0 = r0.toString()     // Catch: java.io.IOException -> L35
                java.lang.ClassLoader r2 = r4.loader     // Catch: java.io.IOException -> L35
                if (r2 != 0) goto L2e
                java.util.Enumeration r2 = java.lang.ClassLoader.getSystemResources(r0)     // Catch: java.io.IOException -> L35
                r4.configs = r2     // Catch: java.io.IOException -> L35
                goto L34
            L2e:
                java.util.Enumeration r2 = r2.getResources(r0)     // Catch: java.io.IOException -> L35
                r4.configs = r2     // Catch: java.io.IOException -> L35
            L34:
                goto L3d
            L35:
                r0 = move-exception
                java.lang.Class<S> r2 = r4.service
                java.lang.String r3 = "Error locating configuration files"
                java.util.ServiceLoader.m3422$$Nest$smfail(r2, r3, r0)
            L3d:
                java.util.Iterator<java.lang.String> r0 = r4.pending
                if (r0 == 0) goto L53
                boolean r0 = r0.hasNext()
                if (r0 != 0) goto L48
                goto L53
            L48:
                java.util.Iterator<java.lang.String> r0 = r4.pending
                java.lang.Object r0 = r0.next()
                java.lang.String r0 = (java.lang.String) r0
                r4.nextName = r0
                return r1
            L53:
                java.util.Enumeration<java.net.URL> r0 = r4.configs
                boolean r0 = r0.hasMoreElements()
                if (r0 != 0) goto L5d
                r0 = 0
                return r0
            L5d:
                java.util.ServiceLoader r0 = java.util.ServiceLoader.this
                java.lang.Class<S> r2 = r4.service
                java.util.Enumeration<java.net.URL> r3 = r4.configs
                java.lang.Object r3 = r3.nextElement()
                java.net.URL r3 = (java.net.URL) r3
                java.util.Iterator r0 = java.util.ServiceLoader.m3421$$Nest$mparse(r0, r2, r3)
                r4.pending = r0
                goto L3d
            */
            throw new UnsupportedOperationException("Method not decompiled: java.util.ServiceLoader.LazyIterator.hasNextService():boolean");
        }

        private S nextService() {
            if (!hasNextService()) {
                throw new NoSuchElementException();
            }
            String cn2 = this.nextName;
            this.nextName = null;
            Class<?> c4 = null;
            try {
                c4 = Class.forName(cn2, false, this.loader);
            } catch (ClassNotFoundException x10) {
                ServiceLoader.fail(this.service, "Provider " + cn2 + " not found", x10);
            }
            if (!this.service.isAssignableFrom(c4)) {
                ClassCastException cce = new ClassCastException(this.service.getCanonicalName() + " is not assignable from " + c4.getCanonicalName());
                ServiceLoader.fail(this.service, "Provider " + cn2 + " not a subtype", cce);
            }
            try {
                S p10 = this.service.cast(c4.newInstance());
                ServiceLoader.this.providers.put(cn2, p10);
                return p10;
            } catch (Throwable x11) {
                ServiceLoader.fail(this.service, "Provider " + cn2 + " could not be instantiated", x11);
                throw new Error();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return hasNextService();
        }

        @Override // java.util.Iterator
        public S next() {
            return (S) nextService();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<S> iterator2() {
        return new Iterator<S>() { // from class: java.util.ServiceLoader.1
            Iterator<Map.Entry<String, S>> knownProviders;

            {
                this.knownProviders = ServiceLoader.this.providers.entrySet().iterator2();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.knownProviders.hasNext()) {
                    return true;
                }
                return ServiceLoader.this.lookupIterator.hasNext();
            }

            @Override // java.util.Iterator
            public S next() {
                if (this.knownProviders.hasNext()) {
                    return this.knownProviders.next().getValue();
                }
                return (S) ServiceLoader.this.lookupIterator.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static <S> ServiceLoader<S> load(Class<S> service, ClassLoader loader) {
        return new ServiceLoader<>(service, loader);
    }

    public static <S> ServiceLoader<S> load(Class<S> service) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        return load(service, cl);
    }

    public static <S> ServiceLoader<S> loadInstalled(Class<S> service) {
        ClassLoader prev = null;
        for (ClassLoader cl = ClassLoader.getSystemClassLoader(); cl != null; cl = cl.getParent()) {
            prev = cl;
        }
        return load(service, prev);
    }

    public static <S> S loadFromSystemProperty(Class<S> cls) {
        try {
            String property = System.getProperty(cls.getName());
            if (property != null) {
                return (S) ClassLoader.getSystemClassLoader().loadClass(property).newInstance();
            }
            return null;
        } catch (Exception e2) {
            throw new Error(e2);
        }
    }

    public Optional<S> findFirst() {
        Iterator<S> iterator = iterator2();
        if (iterator.hasNext()) {
            return Optional.of(iterator.next());
        }
        return Optional.empty();
    }

    public String toString() {
        return "java.util.ServiceLoader[" + this.service.getName() + "]";
    }
}
