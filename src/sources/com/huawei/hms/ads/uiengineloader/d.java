package com.huawei.hms.ads.uiengineloader;

import dalvik.system.DexClassLoader;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class d extends DexClassLoader {

    /* renamed from: a, reason: collision with root package name */
    private static final String f29440a = d.class.getSimpleName();

    public d(String str, String str2, ClassLoader classLoader) {
        super(str, str2, null, classLoader);
    }

    @Override // java.lang.ClassLoader
    public final Class<?> loadClass(String str, boolean z10) throws ClassNotFoundException {
        if (!str.startsWith("java.") && !str.startsWith("android.")) {
            try {
                return findClass(str);
            } catch (ClassNotFoundException unused) {
                aa.c(f29440a, "Cannot find The class:".concat(str));
            }
        }
        return super.loadClass(str, z10);
    }
}
