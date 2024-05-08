package com.huawei.hms.feature.dynamic.e;

import dalvik.system.PathClassLoader;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class a extends PathClassLoader {

    /* renamed from: a, reason: collision with root package name */
    public static final String f29894a = a.class.getSimpleName();

    public a(String str, ClassLoader classLoader) {
        super(str, classLoader);
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str, boolean z10) throws ClassNotFoundException {
        if (!str.startsWith("java.") && !str.startsWith("android.")) {
            try {
                return findClass(str);
            } catch (ClassNotFoundException unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Cannot find The class:");
                sb2.append(str);
            }
        }
        return super.loadClass(str, z10);
    }
}
