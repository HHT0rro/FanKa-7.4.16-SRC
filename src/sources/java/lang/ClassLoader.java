package java.lang;

import dalvik.system.PathClassLoader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.security.ProtectionDomain;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sun.misc.CompoundEnumeration;
import sun.reflect.CallerSensitive;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class ClassLoader {
    private transient long allocator;
    private transient long classTable;
    private final HashMap<String, Package> packages;
    private final ClassLoader parent;
    public final Map<List<Class<?>>, Class<?>> proxyCache;

    /* renamed from: -$$Nest$smcreateSystemClassLoader, reason: not valid java name */
    static /* bridge */ /* synthetic */ ClassLoader m3130$$Nest$smcreateSystemClassLoader() {
        return createSystemClassLoader();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class SystemClassLoader {
        public static ClassLoader loader = ClassLoader.m3130$$Nest$smcreateSystemClassLoader();

        private SystemClassLoader() {
        }
    }

    private static ClassLoader createSystemClassLoader() {
        String classPath = System.getProperty("java.class.path", ".");
        String librarySearchPath = System.getProperty("java.library.path", "");
        return new PathClassLoader(classPath, librarySearchPath, BootClassLoader.getInstance());
    }

    private static Void checkCreateClassLoader() {
        return null;
    }

    private ClassLoader(Void unused, ClassLoader parent) {
        this.proxyCache = new HashMap();
        this.packages = new HashMap<>();
        this.parent = parent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ClassLoader(ClassLoader parent) {
        this(checkCreateClassLoader(), parent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ClassLoader() {
        this(checkCreateClassLoader(), getSystemClassLoader());
    }

    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return loadClass(name, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class<?> c4 = findLoadedClass(name);
        if (c4 == null) {
            try {
                ClassLoader classLoader = this.parent;
                if (classLoader != null) {
                    c4 = classLoader.loadClass(name, false);
                } else {
                    c4 = findBootstrapClassOrNull(name);
                }
            } catch (ClassNotFoundException e2) {
            }
            if (c4 == null) {
                return findClass(name);
            }
            return c4;
        }
        return c4;
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        throw new ClassNotFoundException(name);
    }

    @Deprecated
    protected final Class<?> defineClass(byte[] b4, int off, int len) throws ClassFormatError {
        throw new UnsupportedOperationException("can't load this type of class file");
    }

    protected final Class<?> defineClass(String name, byte[] b4, int off, int len) throws ClassFormatError {
        throw new UnsupportedOperationException("can't load this type of class file");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Class<?> defineClass(String name, byte[] b4, int off, int len, ProtectionDomain protectionDomain) throws ClassFormatError {
        throw new UnsupportedOperationException("can't load this type of class file");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Class<?> defineClass(String name, ByteBuffer b4, ProtectionDomain protectionDomain) throws ClassFormatError {
        throw new UnsupportedOperationException("can't load this type of class file");
    }

    protected final void resolveClass(Class<?> c4) {
    }

    protected final Class<?> findSystemClass(String name) throws ClassNotFoundException {
        return Class.forName(name, false, getSystemClassLoader());
    }

    private Class<?> findBootstrapClassOrNull(String name) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Class<?> findLoadedClass(String name) {
        ClassLoader loader;
        if (this == BootClassLoader.getInstance()) {
            loader = null;
        } else {
            loader = this;
        }
        return VMClassLoader.findLoadedClass(loader, name);
    }

    protected final void setSigners(Class<?> c4, Object[] signers) {
    }

    public URL getResource(String name) {
        URL url;
        ClassLoader classLoader = this.parent;
        if (classLoader != null) {
            url = classLoader.getResource(name);
        } else {
            url = getBootstrapResource(name);
        }
        if (url == null) {
            URL url2 = findResource(name);
            return url2;
        }
        return url;
    }

    public Enumeration<URL> getResources(String name) throws IOException {
        Enumeration<URL>[] tmp = new Enumeration[2];
        ClassLoader classLoader = this.parent;
        if (classLoader != null) {
            tmp[0] = classLoader.getResources(name);
        } else {
            tmp[0] = getBootstrapResources(name);
        }
        tmp[1] = findResources(name);
        return new CompoundEnumeration(tmp);
    }

    protected URL findResource(String name) {
        return null;
    }

    protected Enumeration<URL> findResources(String name) throws IOException {
        return Collections.emptyEnumeration();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallerSensitive
    public static boolean registerAsParallelCapable() {
        return true;
    }

    public static URL getSystemResource(String name) {
        ClassLoader system = getSystemClassLoader();
        if (system == null) {
            return getBootstrapResource(name);
        }
        return system.getResource(name);
    }

    public static Enumeration<URL> getSystemResources(String name) throws IOException {
        ClassLoader system = getSystemClassLoader();
        if (system == null) {
            return getBootstrapResources(name);
        }
        return system.getResources(name);
    }

    private static URL getBootstrapResource(String name) {
        return null;
    }

    private static Enumeration<URL> getBootstrapResources(String name) throws IOException {
        return null;
    }

    public InputStream getResourceAsStream(String name) {
        URL url = getResource(name);
        if (url != null) {
            try {
                return url.openStream();
            } catch (IOException e2) {
                return null;
            }
        }
        return null;
    }

    public static InputStream getSystemResourceAsStream(String name) {
        URL url = getSystemResource(name);
        if (url != null) {
            try {
                return url.openStream();
            } catch (IOException e2) {
                return null;
            }
        }
        return null;
    }

    @CallerSensitive
    public final ClassLoader getParent() {
        return this.parent;
    }

    @CallerSensitive
    public static ClassLoader getSystemClassLoader() {
        return SystemClassLoader.loader;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ClassLoader getClassLoader(Class<?> caller) {
        if (caller == null) {
            return null;
        }
        return caller.getClassLoader();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Package definePackage(String name, String specTitle, String specVersion, String specVendor, String implTitle, String implVersion, String implVendor, URL sealBase) throws IllegalArgumentException {
        Package pkg;
        synchronized (this.packages) {
            if (this.packages.get(name) != null) {
                throw new IllegalArgumentException(name);
            }
            pkg = new Package(name, specTitle, specVersion, specVendor, implTitle, implVersion, implVendor, sealBase, this);
            this.packages.put(name, pkg);
        }
        return pkg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Package getPackage(String name) {
        Package pkg;
        synchronized (this.packages) {
            pkg = this.packages.get(name);
        }
        return pkg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Package[] getPackages() {
        Map<String, Package> map;
        synchronized (this.packages) {
            map = new HashMap<>(this.packages);
        }
        return (Package[]) map.values().toArray(new Package[map.size()]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String findLibrary(String libname) {
        return null;
    }

    public void setDefaultAssertionStatus(boolean enabled) {
    }

    public void setPackageAssertionStatus(String packageName, boolean enabled) {
    }

    public void setClassAssertionStatus(String className, boolean enabled) {
    }

    public void clearAssertionStatus() {
    }
}
