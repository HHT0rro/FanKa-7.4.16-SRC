package java.lang.invoke;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Modifier;
import java.util.Objects;
import sun.invoke.util.Wrapper;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class ConstantBootstraps {
    private ConstantBootstraps() {
        throw new AssertionError();
    }

    public static Object nullConstant(MethodHandles.Lookup lookup, String name, Class<?> type) {
        if (((Class) Objects.requireNonNull(type)).isPrimitive()) {
            throw new IllegalArgumentException(String.format("not reference: %s", type));
        }
        return null;
    }

    public static Class<?> primitiveClass(MethodHandles.Lookup lookup, String name, Class<?> type) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(type);
        if (type != Class.class) {
            throw new IllegalArgumentException();
        }
        if (name.length() != 1) {
            throw new IllegalArgumentException(String.format("not primitive: %s", name));
        }
        return Wrapper.forPrimitiveType(name.charAt(0)).primitiveType();
    }

    public static <E extends Enum<E>> E enumConstant(MethodHandles.Lookup lookup, String str, Class<E> cls) {
        Objects.requireNonNull(lookup);
        Objects.requireNonNull(str);
        Objects.requireNonNull(cls);
        validateClassAccess(lookup, cls);
        return (E) Enum.valueOf(cls, str);
    }

    public static Object getStaticFinal(MethodHandles.Lookup lookup, String name, Class<?> type, Class<?> declaringClass) {
        Objects.requireNonNull(lookup);
        Objects.requireNonNull(name);
        Objects.requireNonNull(type);
        Objects.requireNonNull(declaringClass);
        try {
            MethodHandle mh = lookup.findStaticGetter(declaringClass, name, type);
            MethodHandleInfo info = lookup.revealDirect(mh);
            if (!Modifier.isFinal(info.getModifiers())) {
                throw new IncompatibleClassChangeError("not a final field: " + name);
            }
            try {
                return (Object) mh.invoke();
            } catch (Error | RuntimeException e2) {
                throw e2;
            } catch (Throwable e10) {
                throw new LinkageError("Unexpected throwable", e10);
            }
        } catch (ReflectiveOperationException ex) {
            throw MethodHandleNatives.mapLookupExceptionToError(ex);
        }
    }

    public static Object getStaticFinal(MethodHandles.Lookup lookup, String name, Class<?> type) {
        Class<?> declaring;
        Objects.requireNonNull(type);
        if (type.isPrimitive()) {
            declaring = Wrapper.forPrimitiveType(type).wrapperType();
        } else {
            declaring = type;
        }
        return getStaticFinal(lookup, name, type, declaring);
    }

    public static Object invoke(MethodHandles.Lookup lookup, String name, Class<?> type, MethodHandle handle, Object... args) throws Throwable {
        Objects.requireNonNull(type);
        Objects.requireNonNull(handle);
        Objects.requireNonNull(args);
        if (type != handle.type().returnType()) {
            handle = handle.asType(handle.type().changeReturnType(type)).withVarargs(handle.isVarargsCollector());
        }
        return handle.invokeWithArguments(args);
    }

    public static VarHandle fieldVarHandle(MethodHandles.Lookup lookup, String name, Class<VarHandle> type, Class<?> declaringClass, Class<?> fieldType) {
        Objects.requireNonNull(lookup);
        Objects.requireNonNull(name);
        Objects.requireNonNull(type);
        Objects.requireNonNull(declaringClass);
        Objects.requireNonNull(fieldType);
        if (type != VarHandle.class) {
            throw new IllegalArgumentException();
        }
        try {
            return lookup.findVarHandle(declaringClass, name, fieldType);
        } catch (ReflectiveOperationException e2) {
            throw MethodHandleNatives.mapLookupExceptionToError(e2);
        }
    }

    public static VarHandle staticFieldVarHandle(MethodHandles.Lookup lookup, String name, Class<VarHandle> type, Class<?> declaringClass, Class<?> fieldType) {
        Objects.requireNonNull(lookup);
        Objects.requireNonNull(name);
        Objects.requireNonNull(type);
        Objects.requireNonNull(declaringClass);
        Objects.requireNonNull(fieldType);
        if (type != VarHandle.class) {
            throw new IllegalArgumentException();
        }
        try {
            return lookup.findStaticVarHandle(declaringClass, name, fieldType);
        } catch (ReflectiveOperationException e2) {
            throw MethodHandleNatives.mapLookupExceptionToError(e2);
        }
    }

    public static VarHandle arrayVarHandle(MethodHandles.Lookup lookup, String name, Class<VarHandle> type, Class<?> arrayClass) {
        Objects.requireNonNull(lookup);
        Objects.requireNonNull(type);
        Objects.requireNonNull(arrayClass);
        if (type != VarHandle.class) {
            throw new IllegalArgumentException();
        }
        return MethodHandles.arrayElementVarHandle(validateClassAccess(lookup, arrayClass));
    }

    public static Object explicitCast(MethodHandles.Lookup lookup, String name, Class<?> dstType, Object value) throws ClassCastException {
        if (dstType == Void.TYPE) {
            throw new ClassCastException("Can not convert to void");
        }
        if (dstType == Object.class) {
            return value;
        }
        MethodHandle id2 = MethodHandles.identity(dstType);
        MethodType mt = MethodType.methodType(dstType, (Class<?>) Object.class);
        MethodHandle conv = MethodHandles.explicitCastArguments(id2, mt);
        try {
            return (Object) conv.invoke(value);
        } catch (Error | RuntimeException e2) {
            throw e2;
        } catch (Throwable throwable) {
            throw new InternalError(throwable);
        }
    }

    private static <T> Class<T> validateClassAccess(MethodHandles.Lookup lookup, Class<T> type) {
        try {
            lookup.accessClass(type);
            return type;
        } catch (ReflectiveOperationException ex) {
            throw MethodHandleNatives.mapLookupExceptionToError(ex);
        }
    }
}
