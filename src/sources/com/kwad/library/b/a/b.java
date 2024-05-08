package com.kwad.library.b.a;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b extends BaseDexClassLoader {
    private final List<String> aiE;
    private final List<String> aiF;
    private final ClassLoader aiG;

    public b(ClassLoader classLoader, String str, @Nullable File file, String str2, List<String> list, List<String> list2) {
        super(str, file, str2, classLoader);
        this.aiG = classLoader;
        this.aiE = list;
        this.aiF = list2;
        while (classLoader.getParent() != null) {
            classLoader = classLoader.getParent();
        }
        new StringBuilder("mParent is ").append(classLoader.getClass().getName());
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public final String findLibrary(String str) {
        String findLibrary = super.findLibrary(str);
        return (TextUtils.isEmpty(findLibrary) && (this.aiG instanceof BaseDexClassLoader)) ? ((BaseDexClassLoader) this.aiG).findLibrary(str) : findLibrary;
    }

    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String str, boolean z10) {
        List<String> list = this.aiE;
        if (list != null && list.contains(str)) {
            StringBuilder sb2 = new StringBuilder("loadClass ");
            sb2.append(str);
            sb2.append(" from host by interface");
            return super.loadClass(str, z10);
        }
        List<String> list2 = this.aiF;
        if (list2 != null) {
            Iterator<String> iterator2 = list2.iterator2();
            while (iterator2.hasNext()) {
                if (str.startsWith(iterator2.next() + ".")) {
                    return super.loadClass(str, z10);
                }
            }
        }
        Class<?> findLoadedClass = findLoadedClass(str);
        if (findLoadedClass != null) {
            return findLoadedClass;
        }
        try {
            return findClass(str);
        } catch (ClassNotFoundException e2) {
            try {
                return getParent().loadClass(str);
            } catch (ClassNotFoundException e10) {
                e10.addSuppressed(e2);
                throw e10;
            }
        }
    }
}
