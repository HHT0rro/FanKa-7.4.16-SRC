package com.huawei.hms.ads.dynamicloader;

import com.huawei.hms.ads.uiengineloader.aa;
import dalvik.system.DexClassLoader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class c extends DexClassLoader {

    /* renamed from: a, reason: collision with root package name */
    private static final String f29153a = c.class.getSimpleName();

    public c(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, str2, str3, classLoader);
    }

    private static void a(List list, Enumeration enumeration) {
        while (enumeration.hasMoreElements()) {
            list.add(enumeration.nextElement());
        }
    }

    @Override // java.lang.ClassLoader
    public final URL getResource(String str) {
        URL resource;
        ClassLoader systemClassLoader = DexClassLoader.getSystemClassLoader();
        if (systemClassLoader == null) {
            aa.c("DelegateLastPathClssLdr", "Failed to get SystemClassLoader");
            resource = null;
        } else {
            resource = systemClassLoader.getResource(str);
        }
        return resource == null ? findResource(str) : resource;
    }

    @Override // java.lang.ClassLoader
    public final Enumeration getResources(String str) {
        String str2;
        String str3;
        ArrayList arrayList = new ArrayList();
        ClassLoader systemClassLoader = DexClassLoader.getSystemClassLoader();
        if (systemClassLoader != null) {
            try {
                a(arrayList, systemClassLoader.getResources(str));
            } catch (IOException unused) {
                str2 = f29153a;
                str3 = "Add Enumeration failed.";
            }
            a(arrayList, findResources(str));
            return Collections.enumeration(arrayList);
        }
        str2 = f29153a;
        str3 = "Failed to get SystemClassLoader";
        aa.c(str2, str3);
        a(arrayList, findResources(str));
        return Collections.enumeration(arrayList);
    }

    @Override // java.lang.ClassLoader
    public final Class loadClass(String str, boolean z10) throws ClassNotFoundException {
        if (str.startsWith("java.")) {
            try {
                return super.loadClass(str, z10);
            } catch (ClassNotFoundException unused) {
                aa.c(f29153a, "Load class failed.");
            }
        }
        try {
            return findClass(str);
        } catch (ClassNotFoundException unused2) {
            return super.loadClass(str, z10);
        }
    }
}
