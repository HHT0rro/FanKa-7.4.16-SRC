package com.huawei.hms.feature.dynamic.e;

import dalvik.system.DexClassLoader;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class b extends DexClassLoader {

    /* renamed from: a, reason: collision with root package name */
    public static final String f29895a = b.class.getSimpleName();

    public b(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, str2, str3, classLoader);
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
