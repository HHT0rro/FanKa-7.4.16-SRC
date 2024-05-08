package java.lang;

import com.baidu.mobads.sdk.internal.ck;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* compiled from: ClassLoader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class BootClassLoader extends ClassLoader {
    private static BootClassLoader instance;

    public static synchronized BootClassLoader getInstance() {
        BootClassLoader bootClassLoader;
        synchronized (BootClassLoader.class) {
            if (instance == null) {
                instance = new BootClassLoader();
            }
            bootClassLoader = instance;
        }
        return bootClassLoader;
    }

    public BootClassLoader() {
        super(null);
    }

    @Override // java.lang.ClassLoader
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return Class.classForName(name, false, null);
    }

    @Override // java.lang.ClassLoader
    protected URL findResource(String name) {
        return VMClassLoader.getResource(name);
    }

    @Override // java.lang.ClassLoader
    protected Enumeration<URL> findResources(String resName) throws IOException {
        return Collections.enumeration(VMClassLoader.getResources(resName));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ClassLoader
    public Package getPackage(String name) {
        Package pack;
        if (name != null && !name.isEmpty()) {
            synchronized (this) {
                pack = super.getPackage(name);
                if (pack == null) {
                    pack = definePackage(name, "Unknown", ck.f10046d, "Unknown", "Unknown", ck.f10046d, "Unknown", null);
                }
            }
            return pack;
        }
        return null;
    }

    @Override // java.lang.ClassLoader
    public URL getResource(String resName) {
        return findResource(resName);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String className, boolean resolve) throws ClassNotFoundException {
        Class<?> clazz = findLoadedClass(className);
        if (clazz == null) {
            return findClass(className);
        }
        return clazz;
    }

    @Override // java.lang.ClassLoader
    public Enumeration<URL> getResources(String resName) throws IOException {
        return findResources(resName);
    }
}
