package sun.misc;

import dalvik.annotation.optimization.FastNative;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import sun.reflect.Reflection;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class4.dex
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Unsafe {
    public static final int INVALID_FIELD_OFFSET = -1;
    private static final Unsafe THE_ONE;
    private static final Unsafe theUnsafe;

    @FastNative
    private static native int getArrayBaseOffsetForComponentType(Class cls);

    @FastNative
    private static native int getArrayIndexScaleForComponentType(Class cls);

    @FastNative
    public native int addressSize();

    public native Object allocateInstance(Class<?> cls);

    @FastNative
    public native long allocateMemory(long j10);

    @FastNative
    public native boolean compareAndSwapInt(Object obj, long j10, int i10, int i11);

    @FastNative
    public native boolean compareAndSwapLong(Object obj, long j10, long j11, long j12);

    @FastNative
    public native boolean compareAndSwapObject(Object obj, long j10, Object obj2, Object obj3);

    @FastNative
    public native void copyMemory(long j10, long j11, long j12);

    @FastNative
    public native void copyMemoryFromPrimitiveArray(Object obj, long j10, long j11, long j12);

    @FastNative
    public native void copyMemoryToPrimitiveArray(long j10, Object obj, long j11, long j12);

    @FastNative
    public native void freeMemory(long j10);

    @FastNative
    public native void fullFence();

    @FastNative
    public native boolean getBoolean(Object obj, long j10);

    @FastNative
    public native byte getByte(long j10);

    @FastNative
    public native byte getByte(Object obj, long j10);

    @FastNative
    public native char getChar(long j10);

    @FastNative
    public native char getChar(Object obj, long j10);

    @FastNative
    public native double getDouble(long j10);

    @FastNative
    public native double getDouble(Object obj, long j10);

    @FastNative
    public native float getFloat(long j10);

    @FastNative
    public native float getFloat(Object obj, long j10);

    @FastNative
    public native int getInt(long j10);

    @FastNative
    public native int getInt(Object obj, long j10);

    @FastNative
    public native int getIntVolatile(Object obj, long j10);

    @FastNative
    public native long getLong(long j10);

    @FastNative
    public native long getLong(Object obj, long j10);

    @FastNative
    public native long getLongVolatile(Object obj, long j10);

    @FastNative
    public native Object getObject(Object obj, long j10);

    @FastNative
    public native Object getObjectVolatile(Object obj, long j10);

    @FastNative
    public native short getShort(long j10);

    @FastNative
    public native short getShort(Object obj, long j10);

    @FastNative
    public native void loadFence();

    @FastNative
    public native int pageSize();

    public native void park(boolean z10, long j10);

    @FastNative
    public native void putBoolean(Object obj, long j10, boolean z10);

    @FastNative
    public native void putByte(long j10, byte b4);

    @FastNative
    public native void putByte(Object obj, long j10, byte b4);

    @FastNative
    public native void putChar(long j10, char c4);

    @FastNative
    public native void putChar(Object obj, long j10, char c4);

    @FastNative
    public native void putDouble(long j10, double d10);

    @FastNative
    public native void putDouble(Object obj, long j10, double d10);

    @FastNative
    public native void putFloat(long j10, float f10);

    @FastNative
    public native void putFloat(Object obj, long j10, float f10);

    @FastNative
    public native void putInt(long j10, int i10);

    @FastNative
    public native void putInt(Object obj, long j10, int i10);

    @FastNative
    public native void putIntVolatile(Object obj, long j10, int i10);

    @FastNative
    public native void putLong(long j10, long j11);

    @FastNative
    public native void putLong(Object obj, long j10, long j11);

    @FastNative
    public native void putLongVolatile(Object obj, long j10, long j11);

    @FastNative
    public native void putObject(Object obj, long j10, Object obj2);

    @FastNative
    public native void putObjectVolatile(Object obj, long j10, Object obj2);

    @FastNative
    public native void putOrderedInt(Object obj, long j10, int i10);

    @FastNative
    public native void putOrderedLong(Object obj, long j10, long j11);

    @FastNative
    public native void putOrderedObject(Object obj, long j10, Object obj2);

    @FastNative
    public native void putShort(long j10, short s2);

    @FastNative
    public native void putShort(Object obj, long j10, short s2);

    @FastNative
    public native void setMemory(long j10, long j11, byte b4);

    @FastNative
    public native void storeFence();

    @FastNative
    public native void unpark(Object obj);

    static {
        Unsafe unsafe = new Unsafe();
        THE_ONE = unsafe;
        theUnsafe = unsafe;
    }

    private Unsafe() {
    }

    public static Unsafe getUnsafe() {
        Class<?> caller = Reflection.getCallerClass();
        ClassLoader calling = caller == null ? null : caller.getClassLoader();
        if (calling != null && calling != Unsafe.class.getClassLoader()) {
            throw new SecurityException("Unsafe access denied");
        }
        return THE_ONE;
    }

    public long objectFieldOffset(Field field) {
        if (Modifier.isStatic(field.getModifiers())) {
            throw new IllegalArgumentException("valid for instance fields only");
        }
        return field.getOffset();
    }

    public int arrayBaseOffset(Class clazz) {
        Class<?> component = clazz.getComponentType();
        if (component == null) {
            throw new IllegalArgumentException("Valid for array classes only: " + ((Object) clazz));
        }
        return getArrayBaseOffsetForComponentType(component);
    }

    public int arrayIndexScale(Class clazz) {
        Class<?> component = clazz.getComponentType();
        if (component == null) {
            throw new IllegalArgumentException("Valid for array classes only: " + ((Object) clazz));
        }
        return getArrayIndexScaleForComponentType(component);
    }

    public final int getAndAddInt(Object o10, long offset, int delta) {
        int v2;
        do {
            v2 = getIntVolatile(o10, offset);
        } while (!compareAndSwapInt(o10, offset, v2, v2 + delta));
        return v2;
    }

    public final long getAndAddLong(Object o10, long offset, long delta) {
        long v2;
        do {
            v2 = getLongVolatile(o10, offset);
        } while (!compareAndSwapLong(o10, offset, v2, v2 + delta));
        return v2;
    }

    public final int getAndSetInt(Object o10, long offset, int newValue) {
        int v2;
        do {
            v2 = getIntVolatile(o10, offset);
        } while (!compareAndSwapInt(o10, offset, v2, newValue));
        return v2;
    }

    public final long getAndSetLong(Object o10, long offset, long newValue) {
        long v2;
        do {
            v2 = getLongVolatile(o10, offset);
        } while (!compareAndSwapLong(o10, offset, v2, newValue));
        return v2;
    }

    public final Object getAndSetObject(Object o10, long offset, Object newValue) {
        Object v2;
        do {
            v2 = getObjectVolatile(o10, offset);
        } while (!compareAndSwapObject(o10, offset, v2, newValue));
        return v2;
    }
}
