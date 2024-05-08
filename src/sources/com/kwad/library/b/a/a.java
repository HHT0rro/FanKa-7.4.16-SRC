package com.kwad.library.b.a;

import android.app.Activity;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a extends PathClassLoader {
    private static final List<ClassLoader> aiD = new CopyOnWriteArrayList();
    private final BaseDexClassLoader aiC;

    public a(BaseDexClassLoader baseDexClassLoader) {
        super("", baseDexClassLoader);
        this.aiC = baseDexClassLoader;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final Class<?> findClass(String str) {
        Class<?> loadClass;
        Class loadClass2;
        Class cls = null;
        try {
            loadClass2 = this.aiC.loadClass(str);
        } catch (Throwable th) {
            th = th;
        }
        if (Activity.class.isAssignableFrom(loadClass2)) {
            return loadClass2;
        }
        th = null;
        cls = loadClass2;
        if (cls != null) {
            return cls;
        }
        Iterator<ClassLoader> iterator2 = aiD.iterator2();
        while (iterator2.hasNext()) {
            try {
                loadClass = iterator2.next().loadClass(str);
            } catch (Throwable unused) {
            }
            if (loadClass != null) {
                return loadClass;
            }
        }
        if (th instanceof ClassNotFoundException) {
            throw th;
        }
        throw new ClassNotFoundException(str, th);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final String findLibrary(String str) {
        return this.aiC.findLibrary(str);
    }

    @Override // java.lang.ClassLoader
    public final URL getResource(String str) {
        return this.aiC.getResource(str);
    }

    @Override // java.lang.ClassLoader
    public final InputStream getResourceAsStream(String str) {
        return this.aiC.getResourceAsStream(str);
    }

    @Override // java.lang.ClassLoader
    public final Enumeration<URL> getResources(String str) {
        return this.aiC.getResources(str);
    }

    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String str) {
        return findClass(str);
    }

    @Override // dalvik.system.BaseDexClassLoader
    public final String toString() {
        return this.aiC.toString();
    }
}
