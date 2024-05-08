package com.google.common.reflect;

import com.google.common.collect.Sets;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Set;

/* compiled from: TypeVisitor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public final Set<Type> f26755a = Sets.d();

    public final void a(Type... typeArr) {
        for (Type type : typeArr) {
            if (type != null && this.f26755a.add(type)) {
                try {
                    if (type instanceof TypeVariable) {
                        e((TypeVariable) type);
                    } else if (type instanceof WildcardType) {
                        f((WildcardType) type);
                    } else if (type instanceof ParameterizedType) {
                        d((ParameterizedType) type);
                    } else if (type instanceof Class) {
                        b((Class) type);
                    } else if (type instanceof GenericArrayType) {
                        c((GenericArrayType) type);
                    } else {
                        String valueOf = String.valueOf(type);
                        StringBuilder sb2 = new StringBuilder(valueOf.length() + 14);
                        sb2.append("Unknown type: ");
                        sb2.append(valueOf);
                        throw new AssertionError((Object) sb2.toString());
                    }
                } catch (Throwable th) {
                    this.f26755a.remove(type);
                    throw th;
                }
            }
        }
    }

    public void b(Class<?> cls) {
    }

    public void c(GenericArrayType genericArrayType) {
    }

    public void d(ParameterizedType parameterizedType) {
    }

    public abstract void e(TypeVariable<?> typeVariable);

    public abstract void f(WildcardType wildcardType);
}
