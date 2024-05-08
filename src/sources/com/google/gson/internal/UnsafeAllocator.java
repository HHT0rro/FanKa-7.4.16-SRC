package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import sun.misc.Unsafe;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class UnsafeAllocator {
    public static void a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (!Modifier.isInterface(modifiers)) {
            if (Modifier.isAbstract(modifiers)) {
                throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
            }
            return;
        }
        throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
    }

    public static UnsafeAllocator b() {
        try {
            Field declaredField = Unsafe.class.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            final Object obj = declaredField.get(null);
            final Method method = Unsafe.class.getMethod("allocateInstance", Class.class);
            return new UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.1
                @Override // com.google.gson.internal.UnsafeAllocator
                public <T> T c(Class<T> cls) throws Exception {
                    UnsafeAllocator.a(cls);
                    return (T) Method.this.invoke(obj, cls);
                }
            };
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    final int intValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    final Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.2
                        @Override // com.google.gson.internal.UnsafeAllocator
                        public <T> T c(Class<T> cls) throws Exception {
                            UnsafeAllocator.a(cls);
                            return (T) Method.this.invoke(null, cls, Integer.valueOf(intValue));
                        }
                    };
                } catch (Exception unused2) {
                    final Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    return new UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.3
                        @Override // com.google.gson.internal.UnsafeAllocator
                        public <T> T c(Class<T> cls) throws Exception {
                            UnsafeAllocator.a(cls);
                            return (T) Method.this.invoke(null, cls, Object.class);
                        }
                    };
                }
            } catch (Exception unused3) {
                return new UnsafeAllocator() { // from class: com.google.gson.internal.UnsafeAllocator.4
                    @Override // com.google.gson.internal.UnsafeAllocator
                    public <T> T c(Class<T> cls) {
                        throw new UnsupportedOperationException("Cannot allocate " + ((Object) cls) + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
                    }
                };
            }
        }
    }

    public abstract <T> T c(Class<T> cls) throws Exception;
}
