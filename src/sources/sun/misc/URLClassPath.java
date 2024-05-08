package sun.misc;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilePermission;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.SocketPermission;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.security.AccessControlContext;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.CodeSigner;
import java.security.Permission;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import jdk.internal.util.jar.JarIndex;
import sun.net.util.URLUtil;
import sun.net.www.ParseUtil;
import sun.security.action.GetPropertyAction;
import sun.security.util.SecurityConstants;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class URLClassPath {
    private static final boolean DEBUG;
    private static final boolean DEBUG_LOOKUP_CACHE;
    private static final boolean DISABLE_ACC_CHECKING;
    private static final boolean DISABLE_JAR_CHECKING;
    static final String JAVA_VERSION = (String) AccessController.doPrivileged(new GetPropertyAction("java.version"));
    static final String USER_AGENT_JAVA_VERSION = "UA-Java-Version";
    private static volatile boolean lookupCacheEnabled;
    private final AccessControlContext acc;
    private boolean closed;
    private URLStreamHandler jarHandler;
    HashMap<String, Loader> lmap;
    ArrayList<Loader> loaders;
    private ClassLoader lookupCacheLoader;
    private URL[] lookupCacheURLs;
    private ArrayList<URL> path;
    Stack<URL> urls;

    static {
        boolean z10 = true;
        DEBUG = AccessController.doPrivileged(new GetPropertyAction("sun.misc.URLClassPath.debug")) != null;
        DEBUG_LOOKUP_CACHE = AccessController.doPrivileged(new GetPropertyAction("sun.misc.URLClassPath.debugLookupCache")) != null;
        String p10 = (String) AccessController.doPrivileged(new GetPropertyAction("sun.misc.URLClassPath.disableJarChecking"));
        DISABLE_JAR_CHECKING = p10 != null && (p10.equals("true") || p10.equals(""));
        String p11 = (String) AccessController.doPrivileged(new GetPropertyAction("jdk.net.URLClassPath.disableRestrictedPermissions"));
        if (p11 == null || (!p11.equals("true") && !p11.equals(""))) {
            z10 = false;
        }
        DISABLE_ACC_CHECKING = z10;
        lookupCacheEnabled = false;
    }

    public URLClassPath(URL[] urls, URLStreamHandlerFactory factory, AccessControlContext acc) {
        this.path = new ArrayList<>();
        this.urls = new Stack<>();
        this.loaders = new ArrayList<>();
        this.lmap = new HashMap<>();
        this.closed = false;
        for (URL url : urls) {
            this.path.add(url);
        }
        push(urls);
        if (factory != null) {
            this.jarHandler = factory.createURLStreamHandler("jar");
        }
        if (DISABLE_ACC_CHECKING) {
            this.acc = null;
        } else {
            this.acc = acc;
        }
    }

    public URLClassPath(URL[] urls) {
        this(urls, null, null);
    }

    public URLClassPath(URL[] urls, AccessControlContext acc) {
        this(urls, null, acc);
    }

    public synchronized List<IOException> closeLoaders() {
        if (this.closed) {
            return Collections.emptyList();
        }
        List<IOException> result = new LinkedList<>();
        Iterator<Loader> iterator2 = this.loaders.iterator2();
        while (iterator2.hasNext()) {
            Loader loader = iterator2.next();
            try {
                loader.close();
            } catch (IOException e2) {
                result.add(e2);
            }
        }
        this.closed = true;
        return result;
    }

    public synchronized void addURL(URL url) {
        if (this.closed) {
            return;
        }
        synchronized (this.urls) {
            if (url != null) {
                try {
                    if (!this.path.contains(url)) {
                        this.urls.add(0, url);
                        this.path.add(url);
                        if (this.lookupCacheURLs != null) {
                            disableAllLookupCaches();
                        }
                    }
                } finally {
                    th = th;
                    while (true) {
                        try {
                            break;
                        } catch (Throwable th) {
                            th = th;
                        }
                    }
                }
            }
        }
    }

    public URL[] getURLs() {
        URL[] urlArr;
        synchronized (this.urls) {
            ArrayList<URL> arrayList = this.path;
            urlArr = (URL[]) arrayList.toArray(new URL[arrayList.size()]);
        }
        return urlArr;
    }

    public URL findResource(String name, boolean check) {
        int[] cache = getLookupCache(name);
        int i10 = 0;
        while (true) {
            Loader loader = getNextLoader(cache, i10);
            if (loader != null) {
                URL url = loader.findResource(name, check);
                if (url == null) {
                    i10++;
                } else {
                    return url;
                }
            } else {
                return null;
            }
        }
    }

    public Resource getResource(String name, boolean check) {
        if (DEBUG) {
            System.err.println("URLClassPath.getResource(\"" + name + "\")");
        }
        int[] cache = getLookupCache(name);
        int i10 = 0;
        while (true) {
            Loader loader = getNextLoader(cache, i10);
            if (loader != null) {
                Resource res = loader.getResource(name, check);
                if (res == null) {
                    i10++;
                } else {
                    return res;
                }
            } else {
                return null;
            }
        }
    }

    public Enumeration<URL> findResources(String name, boolean check) {
        return new Enumeration<URL>(name, check) { // from class: sun.misc.URLClassPath.1
            private int[] cache;
            final /* synthetic */ boolean val$check;
            final /* synthetic */ String val$name;
            private int index = 0;
            private URL url = null;

            {
                this.val$name = name;
                this.val$check = check;
                this.cache = URLClassPath.this.getLookupCache(name);
            }

            private boolean next() {
                URL findResource;
                if (this.url != null) {
                    return true;
                }
                do {
                    URLClassPath uRLClassPath = URLClassPath.this;
                    int[] iArr = this.cache;
                    int i10 = this.index;
                    this.index = i10 + 1;
                    Loader loader = uRLClassPath.getNextLoader(iArr, i10);
                    if (loader != null) {
                        findResource = loader.findResource(this.val$name, this.val$check);
                        this.url = findResource;
                    } else {
                        return false;
                    }
                } while (findResource == null);
                return true;
            }

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return next();
            }

            @Override // java.util.Enumeration
            public URL nextElement() {
                if (!next()) {
                    throw new NoSuchElementException();
                }
                URL u10 = this.url;
                this.url = null;
                return u10;
            }
        };
    }

    public Resource getResource(String name) {
        return getResource(name, true);
    }

    public Enumeration<Resource> getResources(String name, boolean check) {
        return new Enumeration<Resource>(name, check) { // from class: sun.misc.URLClassPath.2
            private int[] cache;
            private int index = 0;
            private Resource res = null;
            final /* synthetic */ boolean val$check;
            final /* synthetic */ String val$name;

            {
                this.val$name = name;
                this.val$check = check;
                this.cache = URLClassPath.this.getLookupCache(name);
            }

            private boolean next() {
                Resource resource;
                if (this.res != null) {
                    return true;
                }
                do {
                    URLClassPath uRLClassPath = URLClassPath.this;
                    int[] iArr = this.cache;
                    int i10 = this.index;
                    this.index = i10 + 1;
                    Loader loader = uRLClassPath.getNextLoader(iArr, i10);
                    if (loader != null) {
                        resource = loader.getResource(this.val$name, this.val$check);
                        this.res = resource;
                    } else {
                        return false;
                    }
                } while (resource == null);
                return true;
            }

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return next();
            }

            @Override // java.util.Enumeration
            public Resource nextElement() {
                if (!next()) {
                    throw new NoSuchElementException();
                }
                Resource r10 = this.res;
                this.res = null;
                return r10;
            }
        };
    }

    public Enumeration<Resource> getResources(String name) {
        return getResources(name, true);
    }

    synchronized void initLookupCache(ClassLoader loader) {
        URL[] lookupCacheURLs = getLookupCacheURLs(loader);
        this.lookupCacheURLs = lookupCacheURLs;
        if (lookupCacheURLs != null) {
            this.lookupCacheLoader = loader;
        } else {
            disableAllLookupCaches();
        }
    }

    static void disableAllLookupCaches() {
        lookupCacheEnabled = false;
    }

    private URL[] getLookupCacheURLs(ClassLoader loader) {
        return null;
    }

    private static int[] getLookupCacheForClassLoader(ClassLoader loader, String name) {
        return null;
    }

    private static boolean knownToNotExist0(ClassLoader loader, String className) {
        return false;
    }

    synchronized boolean knownToNotExist(String className) {
        if (this.lookupCacheURLs == null || !lookupCacheEnabled) {
            return false;
        }
        return knownToNotExist0(this.lookupCacheLoader, className);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized int[] getLookupCache(String name) {
        if (this.lookupCacheURLs != null && lookupCacheEnabled) {
            int[] cache = getLookupCacheForClassLoader(this.lookupCacheLoader, name);
            if (cache != null && cache.length > 0) {
                int maxindex = cache[cache.length - 1];
                if (!ensureLoaderOpened(maxindex)) {
                    if (DEBUG_LOOKUP_CACHE) {
                        System.out.println("Expanded loaders FAILED " + this.loaders.size() + " for maxindex=" + maxindex);
                    }
                    return null;
                }
            }
            return cache;
        }
        return null;
    }

    private boolean ensureLoaderOpened(int index) {
        if (this.loaders.size() <= index) {
            if (getLoader(index) == null || !lookupCacheEnabled) {
                return false;
            }
            if (DEBUG_LOOKUP_CACHE) {
                System.out.println("Expanded loaders " + this.loaders.size() + " to index=" + index);
                return true;
            }
            return true;
        }
        return true;
    }

    private synchronized void validateLookupCache(int index, String urlNoFragString) {
        if (this.lookupCacheURLs != null && lookupCacheEnabled) {
            URL[] urlArr = this.lookupCacheURLs;
            if (index < urlArr.length && urlNoFragString.equals(URLUtil.urlNoFragString(urlArr[index]))) {
                return;
            }
            if (DEBUG || DEBUG_LOOKUP_CACHE) {
                System.out.println("WARNING: resource lookup cache invalidated for lookupCacheLoader at " + index);
            }
            disableAllLookupCaches();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Loader getNextLoader(int[] cache, int index) {
        if (this.closed) {
            return null;
        }
        if (cache != null) {
            if (index >= cache.length) {
                return null;
            }
            Loader loader = this.loaders.get(cache[index]);
            if (DEBUG_LOOKUP_CACHE) {
                System.out.println("HASCACHE: Loading from : " + cache[index] + " = " + ((Object) loader.getBaseURL()));
            }
            return loader;
        }
        return getLoader(index);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:48:0x0085
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    private synchronized sun.misc.URLClassPath.Loader getLoader(int r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.closed     // Catch: java.lang.Throwable -> Lae
            r1 = 0
            if (r0 == 0) goto L8
            monitor-exit(r7)
            return r1
        L8:
            java.util.ArrayList<sun.misc.URLClassPath$Loader> r0 = r7.loaders     // Catch: java.lang.Throwable -> Lae
            int r0 = r0.size()     // Catch: java.lang.Throwable -> Lae
            int r2 = r8 + 1
            if (r0 >= r2) goto L88
            java.util.Stack<java.net.URL> r0 = r7.urls     // Catch: java.lang.Throwable -> Lae
            monitor-enter(r0)     // Catch: java.lang.Throwable -> Lae
            java.util.Stack<java.net.URL> r2 = r7.urls     // Catch: java.lang.Throwable -> L85
            boolean r2 = r2.empty()     // Catch: java.lang.Throwable -> L85
            if (r2 == 0) goto L22
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L20
            monitor-exit(r7)
            return r1
        L20:
            r1 = move-exception
            goto L86
        L22:
            java.util.Stack<java.net.URL> r2 = r7.urls     // Catch: java.lang.Throwable -> L85
            java.lang.Object r2 = r2.pop()     // Catch: java.lang.Throwable -> L85
            java.net.URL r2 = (java.net.URL) r2     // Catch: java.lang.Throwable -> L85
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L85
            java.lang.String r0 = sun.net.util.URLUtil.urlNoFragString(r2)     // Catch: java.lang.Throwable -> Lae
            java.util.HashMap<java.lang.String, sun.misc.URLClassPath$Loader> r3 = r7.lmap     // Catch: java.lang.Throwable -> Lae
            boolean r3 = r3.containsKey(r0)     // Catch: java.lang.Throwable -> Lae
            if (r3 == 0) goto L38
            goto L8
        L38:
            sun.misc.URLClassPath$Loader r3 = r7.getLoader(r2)     // Catch: java.lang.SecurityException -> L5b java.io.IOException -> L83 java.lang.Throwable -> Lae
            java.net.URL[] r4 = r3.getClassPath()     // Catch: java.lang.SecurityException -> L5b java.io.IOException -> L83 java.lang.Throwable -> Lae
            if (r4 == 0) goto L45
            r7.push(r4)     // Catch: java.lang.SecurityException -> L5b java.io.IOException -> L83 java.lang.Throwable -> Lae
        L45:
            java.util.ArrayList<sun.misc.URLClassPath$Loader> r4 = r7.loaders     // Catch: java.lang.Throwable -> Lae
            int r4 = r4.size()     // Catch: java.lang.Throwable -> Lae
            r7.validateLookupCache(r4, r0)     // Catch: java.lang.Throwable -> Lae
            java.util.ArrayList<sun.misc.URLClassPath$Loader> r4 = r7.loaders     // Catch: java.lang.Throwable -> Lae
            r4.add(r3)     // Catch: java.lang.Throwable -> Lae
            java.util.HashMap<java.lang.String, sun.misc.URLClassPath$Loader> r4 = r7.lmap     // Catch: java.lang.Throwable -> Lae
            r4.put(r0, r3)     // Catch: java.lang.Throwable -> Lae
            goto L8
        L5b:
            r3 = move-exception
            boolean r4 = sun.misc.URLClassPath.DEBUG     // Catch: java.lang.Throwable -> Lae
            if (r4 == 0) goto L82
            java.io.PrintStream r4 = java.lang.System.err     // Catch: java.lang.Throwable -> Lae
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lae
            r5.<init>()     // Catch: java.lang.Throwable -> Lae
            java.lang.String r6 = "Failed to access "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> Lae
            java.lang.StringBuilder r5 = r5.append(r2)     // Catch: java.lang.Throwable -> Lae
            java.lang.String r6 = ", "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> Lae
            java.lang.StringBuilder r5 = r5.append(r3)     // Catch: java.lang.Throwable -> Lae
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> Lae
            r4.println(r5)     // Catch: java.lang.Throwable -> Lae
        L82:
            goto L8
        L83:
            r3 = move-exception
            goto L8
        L85:
            r1 = move-exception
        L86:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L85
            throw r1     // Catch: java.lang.Throwable -> Lae
        L88:
            boolean r0 = sun.misc.URLClassPath.DEBUG_LOOKUP_CACHE     // Catch: java.lang.Throwable -> Lae
            if (r0 == 0) goto La4
            java.io.PrintStream r0 = java.lang.System.out     // Catch: java.lang.Throwable -> Lae
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lae
            r1.<init>()     // Catch: java.lang.Throwable -> Lae
            java.lang.String r2 = "NOCACHE: Loading from : "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lae
            java.lang.StringBuilder r1 = r1.append(r8)     // Catch: java.lang.Throwable -> Lae
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lae
            r0.println(r1)     // Catch: java.lang.Throwable -> Lae
        La4:
            java.util.ArrayList<sun.misc.URLClassPath$Loader> r0 = r7.loaders     // Catch: java.lang.Throwable -> Lae
            java.lang.Object r0 = r0.get(r8)     // Catch: java.lang.Throwable -> Lae
            sun.misc.URLClassPath$Loader r0 = (sun.misc.URLClassPath.Loader) r0     // Catch: java.lang.Throwable -> Lae
            monitor-exit(r7)
            return r0
        Lae:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.misc.URLClassPath.getLoader(int):sun.misc.URLClassPath$Loader");
    }

    private Loader getLoader(final URL url) throws IOException {
        try {
            return (Loader) AccessController.doPrivileged(new PrivilegedExceptionAction<Loader>() { // from class: sun.misc.URLClassPath.3
                @Override // java.security.PrivilegedExceptionAction
                public Loader run() throws IOException {
                    String file = url.getFile();
                    if (file != null && file.endsWith("/")) {
                        if ("file".equals(url.getProtocol())) {
                            return new FileLoader(url);
                        }
                        return new Loader(url);
                    }
                    return new JarLoader(url, URLClassPath.this.jarHandler, URLClassPath.this.lmap, URLClassPath.this.acc);
                }
            }, this.acc);
        } catch (PrivilegedActionException pae) {
            throw ((IOException) pae.getException());
        }
    }

    private void push(URL[] us) {
        synchronized (this.urls) {
            for (int i10 = us.length - 1; i10 >= 0; i10--) {
                this.urls.push(us[i10]);
            }
        }
    }

    public static URL[] pathToURLs(String path) {
        StringTokenizer st = new StringTokenizer(path, File.pathSeparator);
        URL[] urls = new URL[st.countTokens()];
        int count = 0;
        while (st.hasMoreTokens()) {
            File f10 = new File(st.nextToken());
            try {
                f10 = new File(f10.getCanonicalPath());
            } catch (IOException e2) {
            }
            int count2 = count + 1;
            try {
                urls[count] = ParseUtil.fileToEncodedURL(f10);
            } catch (IOException e10) {
            }
            count = count2;
        }
        if (urls.length != count) {
            URL[] tmp = new URL[count];
            System.arraycopy(urls, 0, tmp, 0, count);
            return tmp;
        }
        return urls;
    }

    public URL checkURL(URL url) {
        try {
            check(url);
            return url;
        } catch (Exception e2) {
            return null;
        }
    }

    static void check(URL url) throws IOException {
        URLConnection urlConnection;
        Permission perm;
        SecurityManager security = System.getSecurityManager();
        if (security != null && (perm = (urlConnection = url.openConnection()).getPermission()) != null) {
            try {
                security.checkPermission(perm);
            } catch (SecurityException se) {
                if ((perm instanceof FilePermission) && perm.getActions().indexOf("read") != -1) {
                    security.checkRead(perm.getName());
                    return;
                }
                if ((perm instanceof SocketPermission) && perm.getActions().indexOf(SecurityConstants.SOCKET_CONNECT_ACTION) != -1) {
                    URL locUrl = url;
                    if (urlConnection instanceof JarURLConnection) {
                        locUrl = ((JarURLConnection) urlConnection).getJarFileURL();
                    }
                    security.checkConnect(locUrl.getHost(), locUrl.getPort());
                    return;
                }
                throw se;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Loader implements Closeable {
        private final URL base;
        private JarFile jarfile;

        Loader(URL url) {
            this.base = url;
        }

        URL getBaseURL() {
            return this.base;
        }

        URL findResource(String name, boolean check) {
            try {
                URL url = new URL(this.base, ParseUtil.encodePath(name, false));
                if (check) {
                    try {
                        URLClassPath.check(url);
                    } catch (Exception e2) {
                        return null;
                    }
                }
                URLConnection uc2 = url.openConnection();
                if (uc2 instanceof HttpURLConnection) {
                    HttpURLConnection hconn = (HttpURLConnection) uc2;
                    hconn.setRequestMethod("HEAD");
                    if (hconn.getResponseCode() >= 400) {
                        return null;
                    }
                } else {
                    uc2.setUseCaches(false);
                    InputStream is = uc2.getInputStream();
                    is.close();
                }
                return url;
            } catch (MalformedURLException e10) {
                throw new IllegalArgumentException("name");
            }
        }

        Resource getResource(final String name, boolean check) {
            try {
                final URL url = new URL(this.base, ParseUtil.encodePath(name, false));
                if (check) {
                    try {
                        URLClassPath.check(url);
                    } catch (Exception e2) {
                        return null;
                    }
                }
                final URLConnection uc2 = url.openConnection();
                uc2.getInputStream();
                if (uc2 instanceof JarURLConnection) {
                    JarURLConnection juc = (JarURLConnection) uc2;
                    this.jarfile = JarLoader.checkJar(juc.getJarFile());
                }
                return new Resource() { // from class: sun.misc.URLClassPath.Loader.1
                    @Override // sun.misc.Resource
                    public String getName() {
                        return name;
                    }

                    @Override // sun.misc.Resource
                    public URL getURL() {
                        return url;
                    }

                    @Override // sun.misc.Resource
                    public URL getCodeSourceURL() {
                        return Loader.this.base;
                    }

                    @Override // sun.misc.Resource
                    public InputStream getInputStream() throws IOException {
                        return uc2.getInputStream();
                    }

                    @Override // sun.misc.Resource
                    public int getContentLength() throws IOException {
                        return uc2.getContentLength();
                    }
                };
            } catch (MalformedURLException e10) {
                throw new IllegalArgumentException("name");
            }
        }

        Resource getResource(String name) {
            return getResource(name, true);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            JarFile jarFile = this.jarfile;
            if (jarFile != null) {
                jarFile.close();
            }
        }

        URL[] getClassPath() throws IOException {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class JarLoader extends Loader {
        private final AccessControlContext acc;
        private boolean closed;
        private final URL csu;
        private URLStreamHandler handler;
        private JarIndex index;
        private JarFile jar;
        private final HashMap<String, Loader> lmap;

        JarLoader(URL url, URLStreamHandler jarHandler, HashMap<String, Loader> loaderMap, AccessControlContext acc) throws IOException {
            super(new URL("jar", "", -1, ((Object) url) + "!/", jarHandler));
            this.closed = false;
            this.csu = url;
            this.handler = jarHandler;
            this.lmap = loaderMap;
            this.acc = acc;
            ensureOpen();
        }

        @Override // sun.misc.URLClassPath.Loader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                ensureOpen();
                this.jar.close();
            }
        }

        JarFile getJarFile() {
            return this.jar;
        }

        private boolean isOptimizable(URL url) {
            return "file".equals(url.getProtocol());
        }

        private void ensureOpen() throws IOException {
            if (this.jar == null) {
                try {
                    AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() { // from class: sun.misc.URLClassPath.JarLoader.1
                        @Override // java.security.PrivilegedExceptionAction
                        public Void run() throws IOException {
                            if (URLClassPath.DEBUG) {
                                System.err.println("Opening " + ((Object) JarLoader.this.csu));
                                Thread.dumpStack();
                            }
                            JarLoader jarLoader = JarLoader.this;
                            jarLoader.jar = jarLoader.getJarFile(jarLoader.csu);
                            JarLoader jarLoader2 = JarLoader.this;
                            jarLoader2.index = JarIndex.getJarIndex(jarLoader2.jar);
                            if (JarLoader.this.index != null) {
                                String[] jarfiles = JarLoader.this.index.getJarFiles();
                                for (String str : jarfiles) {
                                    try {
                                        URL jarURL = new URL(JarLoader.this.csu, str);
                                        String urlNoFragString = URLUtil.urlNoFragString(jarURL);
                                        if (!JarLoader.this.lmap.containsKey(urlNoFragString)) {
                                            JarLoader.this.lmap.put(urlNoFragString, null);
                                        }
                                    } catch (MalformedURLException e2) {
                                    }
                                }
                            }
                            return null;
                        }
                    }, this.acc);
                } catch (PrivilegedActionException pae) {
                    throw ((IOException) pae.getException());
                }
            }
        }

        static JarFile checkJar(JarFile jar) throws IOException {
            if (System.getSecurityManager() != null && !URLClassPath.DISABLE_JAR_CHECKING && !jar.startsWithLocHeader()) {
                IOException x10 = new IOException("Invalid Jar file");
                try {
                    jar.close();
                    throw x10;
                } catch (IOException ex) {
                    x10.addSuppressed(ex);
                    throw x10;
                }
            }
            return jar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JarFile getJarFile(URL url) throws IOException {
            if (isOptimizable(url)) {
                FileURLMapper p10 = new FileURLMapper(url);
                if (!p10.exists()) {
                    throw new FileNotFoundException(p10.getPath());
                }
                return checkJar(new JarFile(p10.getPath()));
            }
            URLConnection uc2 = getBaseURL().openConnection();
            uc2.setRequestProperty(URLClassPath.USER_AGENT_JAVA_VERSION, URLClassPath.JAVA_VERSION);
            JarFile jarFile = ((JarURLConnection) uc2).getJarFile();
            return checkJar(jarFile);
        }

        JarIndex getIndex() {
            try {
                ensureOpen();
                return this.index;
            } catch (IOException e2) {
                throw new InternalError(e2);
            }
        }

        Resource checkResource(final String name, boolean check, final JarEntry entry) {
            try {
                final URL url = new URL(getBaseURL(), ParseUtil.encodePath(name, false));
                if (check) {
                    URLClassPath.check(url);
                }
                return new Resource() { // from class: sun.misc.URLClassPath.JarLoader.2
                    @Override // sun.misc.Resource
                    public String getName() {
                        return name;
                    }

                    @Override // sun.misc.Resource
                    public URL getURL() {
                        return url;
                    }

                    @Override // sun.misc.Resource
                    public URL getCodeSourceURL() {
                        return JarLoader.this.csu;
                    }

                    @Override // sun.misc.Resource
                    public InputStream getInputStream() throws IOException {
                        return JarLoader.this.jar.getInputStream(entry);
                    }

                    @Override // sun.misc.Resource
                    public int getContentLength() {
                        return (int) entry.getSize();
                    }

                    @Override // sun.misc.Resource
                    public Manifest getManifest() throws IOException {
                        return JarLoader.this.jar.getManifest();
                    }

                    @Override // sun.misc.Resource
                    public Certificate[] getCertificates() {
                        return entry.getCertificates();
                    }

                    @Override // sun.misc.Resource
                    public CodeSigner[] getCodeSigners() {
                        return entry.getCodeSigners();
                    }
                };
            } catch (MalformedURLException e2) {
                return null;
            } catch (IOException e10) {
                return null;
            } catch (AccessControlException e11) {
                return null;
            }
        }

        boolean validIndex(String name) {
            String packageName = name;
            int pos = name.lastIndexOf("/");
            if (pos != -1) {
                packageName = name.substring(0, pos);
            }
            Enumeration<JarEntry> enum_ = this.jar.entries();
            while (enum_.hasMoreElements()) {
                ZipEntry entry = enum_.nextElement();
                String entryName = entry.getName();
                int pos2 = entryName.lastIndexOf("/");
                if (pos2 != -1) {
                    entryName = entryName.substring(0, pos2);
                }
                if (entryName.equals(packageName)) {
                    return true;
                }
            }
            return false;
        }

        @Override // sun.misc.URLClassPath.Loader
        URL findResource(String name, boolean check) {
            Resource rsc = getResource(name, check);
            if (rsc != null) {
                return rsc.getURL();
            }
            return null;
        }

        @Override // sun.misc.URLClassPath.Loader
        Resource getResource(String name, boolean check) {
            try {
                ensureOpen();
                JarEntry entry = this.jar.getJarEntry(name);
                if (entry != null) {
                    return checkResource(name, check, entry);
                }
                if (this.index == null) {
                    return null;
                }
                HashSet<String> visited = new HashSet<>();
                return getResource(name, check, visited);
            } catch (IOException e2) {
                throw new InternalError(e2);
            }
        }

        Resource getResource(String name, boolean check, Set<String> visited) {
            LinkedList<String> jarFilesList;
            Resource res;
            String substring;
            int count = 0;
            LinkedList<String> linkedList = this.index.get(name);
            LinkedList<String> jarFilesList2 = linkedList;
            if (linkedList == null) {
                return null;
            }
            do {
                int size = jarFilesList2.size();
                String[] jarFiles = (String[]) jarFilesList2.toArray(new String[size]);
                while (count < size) {
                    int count2 = count + 1;
                    String jarName = jarFiles[count];
                    try {
                        final URL url = new URL(this.csu, jarName);
                        String urlNoFragString = URLUtil.urlNoFragString(url);
                        JarLoader jarLoader = (JarLoader) this.lmap.get(urlNoFragString);
                        JarLoader newLoader = jarLoader;
                        if (jarLoader == null) {
                            newLoader = (JarLoader) AccessController.doPrivileged(new PrivilegedExceptionAction<JarLoader>() { // from class: sun.misc.URLClassPath.JarLoader.3
                                @Override // java.security.PrivilegedExceptionAction
                                public JarLoader run() throws IOException {
                                    return new JarLoader(url, JarLoader.this.handler, JarLoader.this.lmap, JarLoader.this.acc);
                                }
                            }, this.acc);
                            JarIndex newIndex = newLoader.getIndex();
                            if (newIndex == null) {
                                jarFilesList = jarFilesList2;
                            } else {
                                int pos = jarName.lastIndexOf("/");
                                JarIndex jarIndex = this.index;
                                if (pos == -1) {
                                    jarFilesList = jarFilesList2;
                                    substring = null;
                                } else {
                                    jarFilesList = jarFilesList2;
                                    try {
                                        substring = jarName.substring(0, pos + 1);
                                    } catch (MalformedURLException e2) {
                                    } catch (PrivilegedActionException e10) {
                                    }
                                }
                                newIndex.merge(jarIndex, substring);
                            }
                            this.lmap.put(urlNoFragString, newLoader);
                        } else {
                            jarFilesList = jarFilesList2;
                        }
                        boolean visitedURL = !visited.add(URLUtil.urlNoFragString(url));
                        if (!visitedURL) {
                            try {
                                newLoader.ensureOpen();
                                JarEntry entry = newLoader.jar.getJarEntry(name);
                                if (entry != null) {
                                    return newLoader.checkResource(name, check, entry);
                                }
                                if (!newLoader.validIndex(name)) {
                                    throw new InvalidJarIndexException("Invalid index");
                                }
                            } catch (IOException e11) {
                                throw new InternalError(e11);
                            }
                        }
                        if (!visitedURL && newLoader != this && newLoader.getIndex() != null && (res = newLoader.getResource(name, check, visited)) != null) {
                            return res;
                        }
                    } catch (MalformedURLException e12) {
                        jarFilesList = jarFilesList2;
                    } catch (PrivilegedActionException e13) {
                        jarFilesList = jarFilesList2;
                    }
                    count = count2;
                    jarFilesList2 = jarFilesList;
                }
                jarFilesList2 = this.index.get(name);
            } while (count < jarFilesList2.size());
            return null;
        }

        @Override // sun.misc.URLClassPath.Loader
        URL[] getClassPath() throws IOException {
            Manifest man;
            Attributes attr;
            String value;
            if (this.index != null) {
                return null;
            }
            ensureOpen();
            parseExtensionsDependencies();
            if (!this.jar.hasClassPathAttribute() || (man = this.jar.getManifest()) == null || (attr = man.getMainAttributes()) == null || (value = attr.getValue(Attributes.Name.CLASS_PATH)) == null) {
                return null;
            }
            return parseClassPath(this.csu, value);
        }

        private void parseExtensionsDependencies() throws IOException {
        }

        private URL[] parseClassPath(URL base, String value) throws MalformedURLException {
            StringTokenizer st = new StringTokenizer(value);
            URL[] urls = new URL[st.countTokens()];
            int i10 = 0;
            while (st.hasMoreTokens()) {
                String path = st.nextToken();
                urls[i10] = new URL(base, path);
                i10++;
            }
            return urls;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class FileLoader extends Loader {
        private File dir;

        FileLoader(URL url) throws IOException {
            super(url);
            if (!"file".equals(url.getProtocol())) {
                throw new IllegalArgumentException("url");
            }
            String path = url.getFile().replace(org.apache.commons.io.IOUtils.DIR_SEPARATOR_UNIX, File.separatorChar);
            this.dir = new File(ParseUtil.decode(path)).getCanonicalFile();
        }

        @Override // sun.misc.URLClassPath.Loader
        URL findResource(String name, boolean check) {
            Resource rsc = getResource(name, check);
            if (rsc != null) {
                return rsc.getURL();
            }
            return null;
        }

        @Override // sun.misc.URLClassPath.Loader
        Resource getResource(final String name, boolean check) {
            final File file;
            try {
                URL normalizedBase = new URL(getBaseURL(), ".");
                final URL url = new URL(getBaseURL(), ParseUtil.encodePath(name, false));
                if (!url.getFile().startsWith(normalizedBase.getFile())) {
                    return null;
                }
                if (check) {
                    URLClassPath.check(url);
                }
                if (name.indexOf("..") != -1) {
                    file = new File(this.dir, name.replace(org.apache.commons.io.IOUtils.DIR_SEPARATOR_UNIX, File.separatorChar)).getCanonicalFile();
                    if (!file.getPath().startsWith(this.dir.getPath())) {
                        return null;
                    }
                } else {
                    file = new File(this.dir, name.replace(org.apache.commons.io.IOUtils.DIR_SEPARATOR_UNIX, File.separatorChar));
                }
                if (!file.exists()) {
                    return null;
                }
                return new Resource() { // from class: sun.misc.URLClassPath.FileLoader.1
                    @Override // sun.misc.Resource
                    public String getName() {
                        return name;
                    }

                    @Override // sun.misc.Resource
                    public URL getURL() {
                        return url;
                    }

                    @Override // sun.misc.Resource
                    public URL getCodeSourceURL() {
                        return FileLoader.this.getBaseURL();
                    }

                    @Override // sun.misc.Resource
                    public InputStream getInputStream() throws IOException {
                        return new FileInputStream(file);
                    }

                    @Override // sun.misc.Resource
                    public int getContentLength() throws IOException {
                        return (int) file.length();
                    }
                };
            } catch (Exception e2) {
                return null;
            }
        }
    }
}
