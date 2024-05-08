package com.google.common.util.concurrent;

import com.google.common.collect.Ordering;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: FuturesGetChecked.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final Ordering<Constructor<?>> f26818a = Ordering.natural().onResultOf(new a()).reverse();

    /* compiled from: FuturesGetChecked.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements com.google.common.base.g<Constructor<?>, Boolean> {
        @Override // com.google.common.base.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Constructor<?> constructor) {
            return Boolean.valueOf(Arrays.asList(constructor.getParameterTypes()).contains(String.class));
        }
    }

    public static void a(Class<? extends Exception> cls) {
        com.google.common.base.o.m(c(cls), "Futures.getChecked exception type (%s) must not be a RuntimeException", cls);
        com.google.common.base.o.m(b(cls), "Futures.getChecked exception type (%s) must be an accessible class with an accessible constructor whose parameters (if any) must be of type String and/or Throwable", cls);
    }

    public static boolean b(Class<? extends Exception> cls) {
        try {
            e(cls, new Exception());
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean c(Class<? extends Exception> cls) {
        return !RuntimeException.class.isAssignableFrom(cls);
    }

    public static <X> X d(Constructor<X> constructor, Throwable th) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] objArr = new Object[parameterTypes.length];
        for (int i10 = 0; i10 < parameterTypes.length; i10++) {
            Class<?> cls = parameterTypes[i10];
            if (cls.equals(String.class)) {
                objArr[i10] = th.toString();
            } else {
                if (!cls.equals(Throwable.class)) {
                    return null;
                }
                objArr[i10] = th;
            }
        }
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public static <X extends Exception> X e(Class<X> cls, Throwable th) {
        Iterator iterator2 = f(Arrays.asList(cls.getConstructors())).iterator2();
        while (iterator2.hasNext()) {
            X x10 = (X) d((Constructor) iterator2.next(), th);
            if (x10 != null) {
                if (x10.getCause() == null) {
                    x10.initCause(th);
                }
                return x10;
            }
        }
        String valueOf = String.valueOf(cls);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 82);
        sb2.append("No appropriate constructor for exception of type ");
        sb2.append(valueOf);
        sb2.append(" in response to chained exception");
        throw new IllegalArgumentException(sb2.toString(), th);
    }

    public static <X extends Exception> List<Constructor<X>> f(List<Constructor<X>> list) {
        return (List<Constructor<X>>) f26818a.sortedCopy(list);
    }
}
