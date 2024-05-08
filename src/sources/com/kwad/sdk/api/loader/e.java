package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import dalvik.system.DexClassLoader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e {
    private static final List<String> amh;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a extends DexClassLoader {
        private final ClassLoader ami;

        public a(String str, String str2, String str3, ClassLoader classLoader) {
            super(str, str2, str3, classLoader);
            this.ami = classLoader;
            classLoader.getClass();
        }

        private static boolean cb(String str) {
            return !TextUtils.isEmpty(str) && str.startsWith("com.kwad.sdk.api");
        }

        @Override // java.lang.ClassLoader
        public final Class<?> loadClass(String str, boolean z10) {
            if (cb(str)) {
                return getParent().loadClass(str);
            }
            Class<?> findLoadedClass = findLoadedClass(str);
            if (findLoadedClass != null) {
                return findLoadedClass;
            }
            try {
                findLoadedClass = findClass(str);
            } catch (ClassNotFoundException unused) {
            }
            return findLoadedClass != null ? findLoadedClass : super.loadClass(str, z10);
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        amh = arrayList;
        arrayList.add("com.kwad.sdk");
        arrayList.add("com.ksad");
        arrayList.add("com.kwai");
        arrayList.add("kwad.support");
        arrayList.add("android.support.rastermill");
    }

    @NonNull
    public static ClassLoader a(Context context, ClassLoader classLoader, String str, String str2, String str3) {
        if (t.b(context, "useContextClassLoader", false)) {
            classLoader = context.getClassLoader();
        }
        return new a(str, str2, str3, classLoader);
    }
}
