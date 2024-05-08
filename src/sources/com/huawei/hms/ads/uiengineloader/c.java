package com.huawei.hms.ads.uiengineloader;

import dalvik.system.PathClassLoader;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class c extends PathClassLoader {

    /* renamed from: a, reason: collision with root package name */
    private static final String f29439a = c.class.getSimpleName();

    public c(String str, ClassLoader classLoader) {
        super(str, classLoader);
    }

    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String str, boolean z10) throws ClassNotFoundException {
        if (!str.startsWith("java.") && !str.startsWith("android.")) {
            try {
                return findClass(str);
            } catch (ClassNotFoundException unused) {
                aa.c(f29439a, "Cannot find The class:".concat(str));
            }
        }
        return super.loadClass(str, z10);
    }
}
