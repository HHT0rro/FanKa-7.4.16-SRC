package java.net;

import java.security.AccessControlContext;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* compiled from: URLClassLoader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
final class FactoryURLClassLoader extends URLClassLoader {
    static {
        ClassLoader.registerAsParallelCapable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FactoryURLClassLoader(URL[] urls, ClassLoader parent, AccessControlContext acc) {
        super(urls, parent, acc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FactoryURLClassLoader(URL[] urls, AccessControlContext acc) {
        super(urls, acc);
    }

    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        int i10;
        SecurityManager sm = System.getSecurityManager();
        if (sm != null && (i10 = name.lastIndexOf(46)) != -1) {
            sm.checkPackageAccess(name.substring(0, i10));
        }
        return super.loadClass(name, resolve);
    }
}
