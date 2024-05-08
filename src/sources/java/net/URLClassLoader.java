package java.net;

import java.io.Closeable;
import java.io.File;
import java.io.FilePermission;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.CodeSigner;
import java.security.CodeSource;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.security.SecureClassLoader;
import java.util.Enumeration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import org.apache.commons.io.IOUtils;
import sun.misc.Resource;
import sun.misc.URLClassPath;
import sun.net.www.ParseUtil;
import sun.net.www.protocol.file.FileURLConnection;
import sun.security.util.SecurityConstants;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class URLClassLoader extends SecureClassLoader implements Closeable {
    private final AccessControlContext acc;
    private WeakHashMap<Closeable, Void> closeables;
    private final URLClassPath ucp;

    public URLClassLoader(URL[] urls, ClassLoader parent) {
        super(parent);
        this.closeables = new WeakHashMap<>();
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkCreateClassLoader();
        }
        AccessControlContext context = AccessController.getContext();
        this.acc = context;
        this.ucp = new URLClassPath(urls, context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public URLClassLoader(URL[] urls, ClassLoader parent, AccessControlContext acc) {
        super(parent);
        this.closeables = new WeakHashMap<>();
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkCreateClassLoader();
        }
        this.acc = acc;
        this.ucp = new URLClassPath(urls, acc);
    }

    public URLClassLoader(URL[] urls) {
        this.closeables = new WeakHashMap<>();
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkCreateClassLoader();
        }
        AccessControlContext context = AccessController.getContext();
        this.acc = context;
        this.ucp = new URLClassPath(urls, context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public URLClassLoader(URL[] urls, AccessControlContext acc) {
        this.closeables = new WeakHashMap<>();
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkCreateClassLoader();
        }
        this.acc = acc;
        this.ucp = new URLClassPath(urls, acc);
    }

    public URLClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(parent);
        this.closeables = new WeakHashMap<>();
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkCreateClassLoader();
        }
        AccessControlContext context = AccessController.getContext();
        this.acc = context;
        this.ucp = new URLClassPath(urls, factory, context);
    }

    @Override // java.lang.ClassLoader
    public InputStream getResourceAsStream(String name) {
        URL url = getResource(name);
        if (url == null) {
            return null;
        }
        try {
            URLConnection urlc = url.openConnection();
            InputStream is = urlc.getInputStream();
            if (urlc instanceof JarURLConnection) {
                JarURLConnection juc = (JarURLConnection) urlc;
                JarFile jar = juc.getJarFile();
                synchronized (this.closeables) {
                    if (!this.closeables.containsKey(jar)) {
                        this.closeables.put(jar, null);
                    }
                }
                return is;
            }
            if (urlc instanceof FileURLConnection) {
                synchronized (this.closeables) {
                    this.closeables.put(is, null);
                }
            }
            return is;
        } catch (IOException e2) {
            return null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkPermission(new RuntimePermission("closeClassLoader"));
        }
        List<IOException> errors = this.ucp.closeLoaders();
        synchronized (this.closeables) {
            Set<Closeable> keys = this.closeables.h();
            for (Closeable c4 : keys) {
                try {
                    c4.close();
                } catch (IOException ioex) {
                    errors.add(ioex);
                }
            }
            this.closeables.clear();
        }
        if (errors.isEmpty()) {
            return;
        }
        IOException firstex = errors.remove(0);
        for (IOException error : errors) {
            firstex.addSuppressed(error);
        }
        throw firstex;
    }

    protected void addURL(URL url) {
        this.ucp.addURL(url);
    }

    public URL[] getURLs() {
        return this.ucp.getURLs();
    }

    @Override // java.lang.ClassLoader
    protected Class<?> findClass(final String name) throws ClassNotFoundException {
        try {
            Class<?> result = (Class) AccessController.doPrivileged(new PrivilegedExceptionAction<Class<?>>() { // from class: java.net.URLClassLoader.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.security.PrivilegedExceptionAction
                public Class<?> run() throws ClassNotFoundException {
                    String path = name.replace('.', IOUtils.DIR_SEPARATOR_UNIX).concat(".class");
                    Resource res = URLClassLoader.this.ucp.getResource(path, false);
                    if (res != null) {
                        try {
                            return URLClassLoader.this.defineClass(name, res);
                        } catch (IOException e2) {
                            throw new ClassNotFoundException(name, e2);
                        }
                    }
                    return null;
                }
            }, this.acc);
            if (result == null) {
                throw new ClassNotFoundException(name);
            }
            return result;
        } catch (PrivilegedActionException pae) {
            throw ((ClassNotFoundException) pae.getException());
        }
    }

    private Package getAndVerifyPackage(String pkgname, Manifest man, URL url) {
        Package pkg = getPackage(pkgname);
        if (pkg != null) {
            if (pkg.isSealed()) {
                if (!pkg.isSealed(url)) {
                    throw new SecurityException("sealing violation: package " + pkgname + " is sealed");
                }
            } else if (man != null && isSealed(pkgname, man)) {
                throw new SecurityException("sealing violation: can't seal package " + pkgname + ": already loaded");
            }
        }
        return pkg;
    }

    private void definePackageInternal(String pkgname, Manifest man, URL url) {
        if (getAndVerifyPackage(pkgname, man, url) == null) {
            try {
                if (man != null) {
                    definePackage(pkgname, man, url);
                } else {
                    definePackage(pkgname, null, null, null, null, null, null, null);
                }
            } catch (IllegalArgumentException e2) {
                if (getAndVerifyPackage(pkgname, man, url) == null) {
                    throw new AssertionError((Object) ("Cannot find package " + pkgname));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Class<?> defineClass(String name, Resource res) throws IOException {
        System.nanoTime();
        int i10 = name.lastIndexOf(46);
        URL url = res.getCodeSourceURL();
        if (i10 != -1) {
            String pkgname = name.substring(0, i10);
            Manifest man = res.getManifest();
            definePackageInternal(pkgname, man, url);
        }
        ByteBuffer bb2 = res.getByteBuffer();
        if (bb2 != null) {
            CodeSigner[] signers = res.getCodeSigners();
            CodeSource cs = new CodeSource(url, signers);
            return defineClass(name, bb2, cs);
        }
        byte[] b4 = res.getBytes();
        CodeSigner[] signers2 = res.getCodeSigners();
        CodeSource cs2 = new CodeSource(url, signers2);
        return defineClass(name, b4, 0, b4.length, cs2);
    }

    protected Package definePackage(String name, Manifest man, URL url) throws IllegalArgumentException {
        String specVersion;
        String specVendor;
        String implTitle;
        String implVersion;
        String implVendor;
        String sealed;
        URL sealBase;
        String path = name.replace('.', IOUtils.DIR_SEPARATOR_UNIX).concat("/");
        String specTitle = null;
        String specVersion2 = null;
        String specVendor2 = null;
        String implTitle2 = null;
        String implVersion2 = null;
        String implVendor2 = null;
        String sealed2 = null;
        Attributes attr = man.getAttributes(path);
        if (attr != null) {
            specTitle = attr.getValue(Attributes.Name.SPECIFICATION_TITLE);
            specVersion2 = attr.getValue(Attributes.Name.SPECIFICATION_VERSION);
            specVendor2 = attr.getValue(Attributes.Name.SPECIFICATION_VENDOR);
            implTitle2 = attr.getValue(Attributes.Name.IMPLEMENTATION_TITLE);
            implVersion2 = attr.getValue(Attributes.Name.IMPLEMENTATION_VERSION);
            implVendor2 = attr.getValue(Attributes.Name.IMPLEMENTATION_VENDOR);
            sealed2 = attr.getValue(Attributes.Name.SEALED);
        }
        Attributes attr2 = man.getMainAttributes();
        if (attr2 == null) {
            specVersion = specVersion2;
            specVendor = specVendor2;
            implTitle = implTitle2;
            implVersion = implVersion2;
            implVendor = implVendor2;
            sealed = sealed2;
        } else {
            if (specTitle == null) {
                specTitle = attr2.getValue(Attributes.Name.SPECIFICATION_TITLE);
            }
            if (specVersion2 == null) {
                specVersion2 = attr2.getValue(Attributes.Name.SPECIFICATION_VERSION);
            }
            if (specVendor2 == null) {
                specVendor2 = attr2.getValue(Attributes.Name.SPECIFICATION_VENDOR);
            }
            if (implTitle2 == null) {
                implTitle2 = attr2.getValue(Attributes.Name.IMPLEMENTATION_TITLE);
            }
            if (implVersion2 == null) {
                implVersion2 = attr2.getValue(Attributes.Name.IMPLEMENTATION_VERSION);
            }
            if (implVendor2 == null) {
                implVendor2 = attr2.getValue(Attributes.Name.IMPLEMENTATION_VENDOR);
            }
            if (sealed2 != null) {
                specVersion = specVersion2;
                specVendor = specVendor2;
                implTitle = implTitle2;
                implVersion = implVersion2;
                implVendor = implVendor2;
                sealed = sealed2;
            } else {
                String sealed3 = attr2.getValue(Attributes.Name.SEALED);
                specVersion = specVersion2;
                specVendor = specVendor2;
                implTitle = implTitle2;
                implVersion = implVersion2;
                implVendor = implVendor2;
                sealed = sealed3;
            }
        }
        if (!"true".equalsIgnoreCase(sealed)) {
            sealBase = null;
        } else {
            sealBase = url;
        }
        return definePackage(name, specTitle, specVersion, specVendor, implTitle, implVersion, implVendor, sealBase);
    }

    private boolean isSealed(String name, Manifest man) {
        Attributes attr;
        String path = name.replace('.', IOUtils.DIR_SEPARATOR_UNIX).concat("/");
        Attributes attr2 = man.getAttributes(path);
        String sealed = null;
        if (attr2 != null) {
            sealed = attr2.getValue(Attributes.Name.SEALED);
        }
        if (sealed == null && (attr = man.getMainAttributes()) != null) {
            sealed = attr.getValue(Attributes.Name.SEALED);
        }
        return "true".equalsIgnoreCase(sealed);
    }

    @Override // java.lang.ClassLoader
    public URL findResource(final String name) {
        URL url = (URL) AccessController.doPrivileged(new PrivilegedAction<URL>() { // from class: java.net.URLClassLoader.2
            @Override // java.security.PrivilegedAction
            public URL run() {
                return URLClassLoader.this.ucp.findResource(name, true);
            }
        }, this.acc);
        if (url != null) {
            return this.ucp.checkURL(url);
        }
        return null;
    }

    @Override // java.lang.ClassLoader
    public Enumeration<URL> findResources(String name) throws IOException {
        final Enumeration<URL> e2 = this.ucp.findResources(name, true);
        return new Enumeration<URL>() { // from class: java.net.URLClassLoader.3
            private URL url = null;

            private boolean next() {
                URL checkURL;
                if (this.url != null) {
                    return true;
                }
                do {
                    URL u10 = (URL) AccessController.doPrivileged(new PrivilegedAction<URL>() { // from class: java.net.URLClassLoader.3.1
                        @Override // java.security.PrivilegedAction
                        public URL run() {
                            if (!e2.hasMoreElements()) {
                                return null;
                            }
                            return (URL) e2.nextElement();
                        }
                    }, URLClassLoader.this.acc);
                    if (u10 == null) {
                        break;
                    }
                    checkURL = URLClassLoader.this.ucp.checkURL(u10);
                    this.url = checkURL;
                } while (checkURL == null);
                return this.url != null;
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

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return next();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.security.SecureClassLoader
    public PermissionCollection getPermissions(CodeSource codesource) {
        Permission p10;
        URLConnection urlConnection;
        PermissionCollection perms = super.getPermissions(codesource);
        URL url = codesource.getLocation();
        try {
            urlConnection = url.openConnection();
            p10 = urlConnection.getPermission();
        } catch (IOException e2) {
            p10 = null;
            urlConnection = null;
        }
        if (p10 instanceof FilePermission) {
            String path = p10.getName();
            if (path.endsWith(File.separator)) {
                p10 = new FilePermission(path + "-", "read");
            }
        } else if (p10 == null && url.getProtocol().equals("file")) {
            String path2 = ParseUtil.decode(url.getFile().replace(IOUtils.DIR_SEPARATOR_UNIX, File.separatorChar));
            if (path2.endsWith(File.separator)) {
                path2 = path2 + "-";
            }
            p10 = new FilePermission(path2, "read");
        } else {
            URL locUrl = url;
            if (urlConnection instanceof JarURLConnection) {
                locUrl = ((JarURLConnection) urlConnection).getJarFileURL();
            }
            String host = locUrl.getHost();
            if (host != null && host.length() > 0) {
                p10 = new SocketPermission(host, SecurityConstants.SOCKET_CONNECT_ACCEPT_ACTION);
            }
        }
        if (p10 != null) {
            final SecurityManager sm = System.getSecurityManager();
            if (sm != null) {
                final Permission fp = p10;
                AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: java.net.URLClassLoader.4
                    @Override // java.security.PrivilegedAction
                    public Void run() throws SecurityException {
                        sm.checkPermission(fp);
                        return null;
                    }
                }, this.acc);
            }
            perms.add(p10);
        }
        return perms;
    }

    public static URLClassLoader newInstance(final URL[] urls, final ClassLoader parent) {
        final AccessControlContext acc = AccessController.getContext();
        URLClassLoader ucl = (URLClassLoader) AccessController.doPrivileged(new PrivilegedAction<URLClassLoader>() { // from class: java.net.URLClassLoader.5
            @Override // java.security.PrivilegedAction
            public URLClassLoader run() {
                return new FactoryURLClassLoader(urls, parent, acc);
            }
        });
        return ucl;
    }

    public static URLClassLoader newInstance(final URL[] urls) {
        final AccessControlContext acc = AccessController.getContext();
        URLClassLoader ucl = (URLClassLoader) AccessController.doPrivileged(new PrivilegedAction<URLClassLoader>() { // from class: java.net.URLClassLoader.6
            @Override // java.security.PrivilegedAction
            public URLClassLoader run() {
                return new FactoryURLClassLoader(urls, acc);
            }
        });
        return ucl;
    }

    static {
        ClassLoader.registerAsParallelCapable();
    }
}
