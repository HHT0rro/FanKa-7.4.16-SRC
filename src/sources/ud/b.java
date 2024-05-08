package ud;

import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: PlatformImplementations.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f54017a;

    static {
        a aVar;
        Object newInstance;
        try {
            newInstance = wd.a.class.newInstance();
            s.h(newInstance, "forName(\"kotlin.internal…entations\").newInstance()");
            try {
                try {
                } catch (ClassCastException e2) {
                    ClassLoader classLoader = newInstance.getClass().getClassLoader();
                    ClassLoader classLoader2 = a.class.getClassLoader();
                    if (s.d(classLoader, classLoader2)) {
                        throw e2;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + ((Object) classLoader) + ", base type classloader: " + ((Object) classLoader2), e2);
                }
            } catch (ClassNotFoundException unused) {
                Object newInstance2 = vd.a.class.newInstance();
                s.h(newInstance2, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    try {
                        if (newInstance2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        aVar = (a) newInstance2;
                    } catch (ClassNotFoundException unused2) {
                        aVar = new a();
                    }
                } catch (ClassCastException e10) {
                    ClassLoader classLoader3 = newInstance2.getClass().getClassLoader();
                    ClassLoader classLoader4 = a.class.getClassLoader();
                    if (s.d(classLoader3, classLoader4)) {
                        throw e10;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + ((Object) classLoader3) + ", base type classloader: " + ((Object) classLoader4), e10);
                }
            }
        } catch (ClassNotFoundException unused3) {
            Object newInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
            s.h(newInstance3, "forName(\"kotlin.internal…entations\").newInstance()");
            try {
                try {
                    if (newInstance3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    aVar = (a) newInstance3;
                } catch (ClassNotFoundException unused4) {
                    Object newInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                    s.h(newInstance4, "forName(\"kotlin.internal…entations\").newInstance()");
                    try {
                        if (newInstance4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                        }
                        aVar = (a) newInstance4;
                    } catch (ClassCastException e11) {
                        ClassLoader classLoader5 = newInstance4.getClass().getClassLoader();
                        ClassLoader classLoader6 = a.class.getClassLoader();
                        if (s.d(classLoader5, classLoader6)) {
                            throw e11;
                        }
                        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + ((Object) classLoader5) + ", base type classloader: " + ((Object) classLoader6), e11);
                    }
                }
            } catch (ClassCastException e12) {
                ClassLoader classLoader7 = newInstance3.getClass().getClassLoader();
                ClassLoader classLoader8 = a.class.getClassLoader();
                if (s.d(classLoader7, classLoader8)) {
                    throw e12;
                }
                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + ((Object) classLoader7) + ", base type classloader: " + ((Object) classLoader8), e12);
            }
        }
        if (newInstance == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
        }
        aVar = (a) newInstance;
        f54017a = aVar;
    }
}
