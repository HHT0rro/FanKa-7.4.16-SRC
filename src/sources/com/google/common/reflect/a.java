package com.google.common.reflect;

import com.google.common.base.o;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;

/* compiled from: Invokable.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class a<T, R> implements AnnotatedElement, Member {

    /* renamed from: b, reason: collision with root package name */
    public final AccessibleObject f26739b;

    /* renamed from: c, reason: collision with root package name */
    public final Member f26740c;

    /* compiled from: Invokable.java */
    /* renamed from: com.google.common.reflect.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class C0240a<T> extends a<T, T> {

        /* renamed from: d, reason: collision with root package name */
        public final Constructor<?> f26741d;

        public C0240a(Constructor<?> constructor) {
            super(constructor);
            this.f26741d = constructor;
        }

        public Type[] b() {
            Type[] genericParameterTypes = this.f26741d.getGenericParameterTypes();
            if (genericParameterTypes.length <= 0 || !c()) {
                return genericParameterTypes;
            }
            Class<?>[] parameterTypes = this.f26741d.getParameterTypes();
            return (genericParameterTypes.length == parameterTypes.length && parameterTypes[0] == getDeclaringClass().getEnclosingClass()) ? (Type[]) Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length) : genericParameterTypes;
        }

        public final boolean c() {
            Class<?> declaringClass = this.f26741d.getDeclaringClass();
            if (declaringClass.getEnclosingConstructor() != null) {
                return true;
            }
            if (declaringClass.getEnclosingMethod() != null) {
                return !Modifier.isStatic(r1.getModifiers());
            }
            return (declaringClass.getEnclosingClass() == null || Modifier.isStatic(declaringClass.getModifiers())) ? false : true;
        }
    }

    /* compiled from: Invokable.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class b<T> extends a<T, Object> {

        /* renamed from: d, reason: collision with root package name */
        public final Method f26742d;

        public b(Method method) {
            super(method);
            this.f26742d = method;
        }
    }

    public <M extends AccessibleObject & Member> a(M m10) {
        o.r(m10);
        this.f26739b = m10;
        this.f26740c = m10;
    }

    public TypeToken<T> a() {
        return TypeToken.of((Class) getDeclaringClass());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return a().equals(aVar.a()) && this.f26740c.equals(aVar.f26740c);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        return (A) this.f26739b.getAnnotation(cls);
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getAnnotations() {
        return this.f26739b.getAnnotations();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getDeclaredAnnotations() {
        return this.f26739b.getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.Member
    public final Class<? super T> getDeclaringClass() {
        return (Class<? super T>) this.f26740c.getDeclaringClass();
    }

    @Override // java.lang.reflect.Member
    public final int getModifiers() {
        return this.f26740c.getModifiers();
    }

    @Override // java.lang.reflect.Member
    public final String getName() {
        return this.f26740c.getName();
    }

    public int hashCode() {
        return this.f26740c.hashCode();
    }

    @Override // java.lang.reflect.AnnotatedElement
    public final boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return this.f26739b.isAnnotationPresent(cls);
    }

    @Override // java.lang.reflect.Member
    public final boolean isSynthetic() {
        return this.f26740c.isSynthetic();
    }

    public String toString() {
        return this.f26740c.toString();
    }
}
