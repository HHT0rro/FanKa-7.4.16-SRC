package kotlinx.coroutines.internal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: FastServiceLoader.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f51395a = new k();

    public final <S> S a(String str, ClassLoader classLoader, Class<S> cls) {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + ((Object) cls) + ", but found " + ((Object) cls2)).toString());
    }

    public final <S> List<S> b(Class<S> cls, ClassLoader classLoader) {
        try {
            return d(cls, classLoader);
        } catch (Throwable unused) {
            return CollectionsKt___CollectionsKt.x0(ServiceLoader.load(cls, classLoader));
        }
    }

    @NotNull
    public final List<u> c() {
        u uVar;
        if (!l.a()) {
            return b(u.class, u.class.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            u uVar2 = null;
            try {
                uVar = (u) u.class.cast(Class.forName("kotlinx.coroutines.android.a", true, u.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused) {
                uVar = null;
            }
            if (uVar != null) {
                arrayList.add(uVar);
            }
            try {
                uVar2 = (u) u.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, u.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused2) {
            }
            if (uVar2 == null) {
                return arrayList;
            }
            arrayList.add(uVar2);
            return arrayList;
        } catch (Throwable unused3) {
            return b(u.class, u.class.getClassLoader());
        }
    }

    @NotNull
    public final <S> List<S> d(@NotNull Class<S> cls, @NotNull ClassLoader classLoader) {
        ArrayList list = Collections.list(classLoader.getResources("META-INF/services/" + cls.getName()));
        kotlin.jvm.internal.s.h(list, "list(this)");
        ArrayList arrayList = new ArrayList();
        Iterator<E> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            kotlin.collections.x.x(arrayList, f51395a.e((URL) iterator2.next()));
        }
        Set A0 = CollectionsKt___CollectionsKt.A0(arrayList);
        if (!A0.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(kotlin.collections.t.t(A0, 10));
            Iterator<E> iterator22 = A0.iterator2();
            while (iterator22.hasNext()) {
                arrayList2.add(f51395a.a((String) iterator22.next(), classLoader, cls));
            }
            return arrayList2;
        }
        throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
    }

    public final List<String> e(URL url) {
        BufferedReader bufferedReader;
        String url2 = url.toString();
        if (kotlin.text.p.F(url2, "jar", false, 2, null)) {
            String N0 = StringsKt__StringsKt.N0(StringsKt__StringsKt.I0(url2, "jar:file:", null, 2, null), '!', null, 2, null);
            String I0 = StringsKt__StringsKt.I0(url2, "!/", null, 2, null);
            JarFile jarFile = new JarFile(N0, false);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(I0)), "UTF-8"));
                try {
                    List<String> f10 = f51395a.f(bufferedReader);
                    kotlin.io.b.a(bufferedReader, null);
                    jarFile.close();
                    return f10;
                } finally {
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        jarFile.close();
                        throw th2;
                    } catch (Throwable th3) {
                        kotlin.a.a(th, th3);
                        throw th;
                    }
                }
            }
        } else {
            bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            try {
                List<String> f11 = f51395a.f(bufferedReader);
                kotlin.io.b.a(bufferedReader, null);
                return f11;
            } catch (Throwable th4) {
                try {
                    throw th4;
                } finally {
                }
            }
        }
    }

    public final List<String> f(BufferedReader bufferedReader) {
        boolean z10;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return CollectionsKt___CollectionsKt.x0(linkedHashSet);
            }
            String obj = StringsKt__StringsKt.P0(StringsKt__StringsKt.O0(readLine, "#", null, 2, null)).toString();
            int i10 = 0;
            while (true) {
                if (i10 >= obj.length()) {
                    z10 = true;
                    break;
                }
                char charAt = obj.charAt(i10);
                if (!(charAt == '.' || Character.isJavaIdentifierPart(charAt))) {
                    z10 = false;
                    break;
                }
                i10++;
            }
            if (z10) {
                if (obj.length() > 0) {
                    linkedHashSet.add(obj);
                }
            } else {
                throw new IllegalArgumentException(("Illegal service provider class name: " + obj).toString());
            }
        }
    }
}
