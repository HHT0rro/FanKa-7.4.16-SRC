package jdk.internal.misc;

import com.tencent.connect.common.Constants;
import dalvik.annotation.optimization.FastNative;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import sun.reflect.Reflection;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Unsafe {
    public static final int ADDRESS_SIZE;
    public static final int ARRAY_BOOLEAN_BASE_OFFSET;
    public static final int ARRAY_BOOLEAN_INDEX_SCALE;
    public static final int ARRAY_BYTE_BASE_OFFSET;
    public static final int ARRAY_BYTE_INDEX_SCALE;
    public static final int ARRAY_CHAR_BASE_OFFSET;
    public static final int ARRAY_CHAR_INDEX_SCALE;
    public static final int ARRAY_DOUBLE_BASE_OFFSET;
    public static final int ARRAY_DOUBLE_INDEX_SCALE;
    public static final int ARRAY_FLOAT_BASE_OFFSET;
    public static final int ARRAY_FLOAT_INDEX_SCALE;
    public static final int ARRAY_INT_BASE_OFFSET;
    public static final int ARRAY_INT_INDEX_SCALE;
    public static final int ARRAY_LONG_BASE_OFFSET;
    public static final int ARRAY_LONG_INDEX_SCALE;
    public static final int ARRAY_OBJECT_BASE_OFFSET;
    public static final int ARRAY_OBJECT_INDEX_SCALE;
    public static final int ARRAY_SHORT_BASE_OFFSET;
    public static final int ARRAY_SHORT_INDEX_SCALE;
    public static final int INVALID_FIELD_OFFSET = -1;
    private static final Unsafe THE_ONE;
    private static final Unsafe theUnsafe;

    @FastNative
    private native void copyMemory0(Object obj, long j10, Object obj2, long j11, long j12);

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
    public final native boolean compareAndSetInt(Object obj, long j10, int i10, int i11);

    @FastNative
    public final native boolean compareAndSetLong(Object obj, long j10, long j11, long j12);

    @FastNative
    public final native boolean compareAndSetReference(Object obj, long j10, Object obj2, Object obj3);

    @FastNative
    public native boolean compareAndSwapInt(Object obj, long j10, int i10, int i11);

    @FastNative
    public native boolean compareAndSwapLong(Object obj, long j10, long j11, long j12);

    @FastNative
    public native boolean compareAndSwapObject(Object obj, long j10, Object obj2, Object obj3);

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
    public native Object getReference(Object obj, long j10);

    @FastNative
    public native Object getReferenceVolatile(Object obj, long j10);

    @FastNative
    public native short getShort(long j10);

    @FastNative
    public native short getShort(Object obj, long j10);

    @FastNative
    public native void loadFence();

    @FastNative
    public native int pageSize();

    public native void park(boolean z10, long j10);

    public native void park(boolean z10, long j10, int i10);

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
    public native void putOrderedInt(Object obj, long j10, int i10);

    @FastNative
    public native void putOrderedLong(Object obj, long j10, long j11);

    @FastNative
    public native void putOrderedObject(Object obj, long j10, Object obj2);

    @FastNative
    public native void putReference(Object obj, long j10, Object obj2);

    @FastNative
    public native void putReferenceVolatile(Object obj, long j10, Object obj2);

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
        ARRAY_BOOLEAN_BASE_OFFSET = unsafe.arrayBaseOffset(boolean[].class);
        ARRAY_BYTE_BASE_OFFSET = unsafe.arrayBaseOffset(byte[].class);
        ARRAY_SHORT_BASE_OFFSET = unsafe.arrayBaseOffset(short[].class);
        ARRAY_CHAR_BASE_OFFSET = unsafe.arrayBaseOffset(char[].class);
        ARRAY_INT_BASE_OFFSET = unsafe.arrayBaseOffset(int[].class);
        ARRAY_LONG_BASE_OFFSET = unsafe.arrayBaseOffset(long[].class);
        ARRAY_FLOAT_BASE_OFFSET = unsafe.arrayBaseOffset(float[].class);
        ARRAY_DOUBLE_BASE_OFFSET = unsafe.arrayBaseOffset(double[].class);
        ARRAY_OBJECT_BASE_OFFSET = unsafe.arrayBaseOffset(Object[].class);
        ARRAY_BOOLEAN_INDEX_SCALE = unsafe.arrayIndexScale(boolean[].class);
        ARRAY_BYTE_INDEX_SCALE = unsafe.arrayIndexScale(byte[].class);
        ARRAY_SHORT_INDEX_SCALE = unsafe.arrayIndexScale(short[].class);
        ARRAY_CHAR_INDEX_SCALE = unsafe.arrayIndexScale(char[].class);
        ARRAY_INT_INDEX_SCALE = unsafe.arrayIndexScale(int[].class);
        ARRAY_LONG_INDEX_SCALE = unsafe.arrayIndexScale(long[].class);
        ARRAY_FLOAT_INDEX_SCALE = unsafe.arrayIndexScale(float[].class);
        ARRAY_DOUBLE_INDEX_SCALE = unsafe.arrayIndexScale(double[].class);
        ARRAY_OBJECT_INDEX_SCALE = unsafe.arrayIndexScale(Object[].class);
        ADDRESS_SIZE = unsafe.addressSize();
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

    private RuntimeException invalidInput() {
        return new IllegalArgumentException();
    }

    private boolean is32BitClean(long value) {
        return (value >>> 32) == 0;
    }

    private void checkSize(long size) {
        if (ADDRESS_SIZE == 4) {
            if (!is32BitClean(size)) {
                throw invalidInput();
            }
        } else if (size < 0) {
            throw invalidInput();
        }
    }

    private void checkNativeAddress(long address) {
        if (ADDRESS_SIZE == 4 && (((address >> 32) + 1) & (-2)) != 0) {
            throw invalidInput();
        }
    }

    private void checkOffset(Object o10, long offset) {
        if (ADDRESS_SIZE == 4) {
            if (!is32BitClean(offset)) {
                throw invalidInput();
            }
        } else if (offset < 0) {
            throw invalidInput();
        }
    }

    private void checkPointer(Object o10, long offset) {
        if (o10 == null) {
            checkNativeAddress(offset);
        } else {
            checkOffset(o10, offset);
        }
    }

    private void checkPrimitiveArray(Class<?> c4) {
        Class<?> componentType = c4.getComponentType();
        if (componentType == null || !componentType.isPrimitive()) {
            throw invalidInput();
        }
    }

    private void checkPrimitivePointer(Object o10, long offset) {
        checkPointer(o10, offset);
        if (o10 != null) {
            checkPrimitiveArray(o10.getClass());
        }
    }

    public void copyMemory(Object srcBase, long srcOffset, Object destBase, long destOffset, long bytes) {
        copyMemoryChecks(srcBase, srcOffset, destBase, destOffset, bytes);
        if (bytes == 0) {
            return;
        }
        copyMemory0(srcBase, srcOffset, destBase, destOffset, bytes);
    }

    public void copyMemory(long srcAddr, long dstAddr, long bytes) {
        copyMemory(null, srcAddr, null, dstAddr, bytes);
    }

    private void copyMemoryChecks(Object srcBase, long srcOffset, Object destBase, long destOffset, long bytes) {
        checkSize(bytes);
        checkPrimitivePointer(srcBase, srcOffset);
        checkPrimitivePointer(destBase, destOffset);
    }

    public long objectFieldOffset(Field f10) {
        if (Modifier.isStatic(f10.getModifiers())) {
            throw new IllegalArgumentException("valid for instance fields only");
        }
        return f10.getOffset();
    }

    public long objectFieldOffset(Class<?> c4, String name) {
        if (c4 == null || name == null) {
            throw new NullPointerException();
        }
        Field field = null;
        Field[] fields = c4.getDeclaredFields();
        int length = fields.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            Field f10 = fields[i10];
            if (!f10.getName().equals(name)) {
                i10++;
            } else {
                field = f10;
                break;
            }
        }
        if (field == null) {
            throw new InternalError();
        }
        return objectFieldOffset(field);
    }

    public void ensureClassInitialized(Class<?> c4) {
        if (c4 == null) {
            throw new NullPointerException();
        }
        try {
            Class.forName(c4.getName(), true, c4.getClassLoader());
        } catch (ClassNotFoundException e2) {
        }
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

    public final boolean weakCompareAndSetReference(Object o10, long offset, Object expected, Object x10) {
        return compareAndSetReference(o10, offset, expected, x10);
    }

    public final boolean weakCompareAndSetInt(Object o10, long offset, int expected, int x10) {
        return compareAndSetInt(o10, offset, expected, x10);
    }

    public final Object getReferenceAcquire(Object o10, long offset) {
        return getReferenceVolatile(o10, offset);
    }

    public final int getIntAcquire(Object o10, long offset) {
        return getIntVolatile(o10, offset);
    }

    public final long getLongAcquire(Object o10, long offset) {
        return getLongVolatile(o10, offset);
    }

    public final void putReferenceRelease(Object o10, long offset, Object x10) {
        putReferenceVolatile(o10, offset, x10);
    }

    public final void putIntRelease(Object o10, long offset, int x10) {
        putIntVolatile(o10, offset, x10);
    }

    public final void putLongRelease(Object o10, long offset, long x10) {
        putLongVolatile(o10, offset, x10);
    }

    public final Object getReferenceOpaque(Object o10, long offset) {
        return getReferenceVolatile(o10, offset);
    }

    public final int getIntOpaque(Object o10, long offset) {
        return getIntVolatile(o10, offset);
    }

    public final long getLongOpaque(Object o10, long offset) {
        return getLongVolatile(o10, offset);
    }

    public final void putReferenceOpaque(Object o10, long offset, Object x10) {
        putReferenceVolatile(o10, offset, x10);
    }

    public final void putIntOpaque(Object o10, long offset, int x10) {
        putIntVolatile(o10, offset, x10);
    }

    public final void putLongOpaque(Object o10, long offset, long x10) {
        putLongVolatile(o10, offset, x10);
    }

    public final int getAndAddInt(Object o10, long offset, int delta) {
        int v2;
        do {
            v2 = getIntVolatile(o10, offset);
        } while (!weakCompareAndSetInt(o10, offset, v2, v2 + delta));
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
        } while (!weakCompareAndSetInt(o10, offset, v2, newValue));
        return v2;
    }

    public final long getAndSetLong(Object o10, long offset, long newValue) {
        long v2;
        do {
            v2 = getLongVolatile(o10, offset);
        } while (!compareAndSwapLong(o10, offset, v2, newValue));
        return v2;
    }

    public final Object getAndSetReference(Object o10, long offset, Object newValue) {
        Object v2;
        do {
            v2 = getReferenceVolatile(o10, offset);
        } while (!weakCompareAndSetReference(o10, offset, v2, newValue));
        return v2;
    }

    public final int getAndBitwiseOrInt(Object o10, long offset, int mask) {
        int current;
        do {
            current = getIntVolatile(o10, offset);
        } while (!weakCompareAndSetInt(o10, offset, current, current | mask));
        return current;
    }

    public final int getAndBitwiseAndInt(Object o10, long offset, int mask) {
        int current;
        do {
            current = getIntVolatile(o10, offset);
        } while (!weakCompareAndSetInt(o10, offset, current, current & mask));
        return current;
    }

    public final int getAndBitwiseXorInt(Object o10, long offset, int mask) {
        int current;
        do {
            current = getIntVolatile(o10, offset);
        } while (!weakCompareAndSetInt(o10, offset, current, current ^ mask));
        return current;
    }

    public final void loadLoadFence() {
        loadFence();
    }

    public final void storeStoreFence() {
        storeFence();
    }

    public final long getLongUnaligned(Object o10, long offset) {
        if ((offset & 7) == 0) {
            return getLong(o10, offset);
        }
        if ((offset & 3) == 0) {
            return makeLong(getInt(o10, offset), getInt(o10, offset + 4));
        }
        if ((offset & 1) == 0) {
            return makeLong(getShort(o10, offset), getShort(o10, offset + 2), getShort(o10, offset + 4), getShort(o10, offset + 6));
        }
        return makeLong(getByte(o10, offset), getByte(o10, offset + 1), getByte(o10, offset + 2), getByte(o10, offset + 3), getByte(o10, offset + 4), getByte(o10, offset + 5), getByte(o10, offset + 6), getByte(o10, offset + 7));
    }

    public final int getIntUnaligned(Object o10, long offset) {
        if ((offset & 3) == 0) {
            return getInt(o10, offset);
        }
        if ((offset & 1) == 0) {
            return makeInt(getShort(o10, offset), getShort(o10, 2 + offset));
        }
        return makeInt(getByte(o10, offset), getByte(o10, 1 + offset), getByte(o10, 2 + offset), getByte(o10, 3 + offset));
    }

    private static int pickPos(int top, int pos) {
        return UnsafeConstants.BIG_ENDIAN ? top - pos : pos;
    }

    private static long makeLong(byte i02, byte i12, byte i22, byte i32, byte i42, byte i52, byte i62, byte i72) {
        return (toUnsignedLong(i02) << pickPos(56, 0)) | (toUnsignedLong(i12) << pickPos(56, 8)) | (toUnsignedLong(i22) << pickPos(56, 16)) | (toUnsignedLong(i32) << pickPos(56, 24)) | (toUnsignedLong(i42) << pickPos(56, 32)) | (toUnsignedLong(i52) << pickPos(56, 40)) | (toUnsignedLong(i62) << pickPos(56, 48)) | (toUnsignedLong(i72) << pickPos(56, 56));
    }

    private static long makeLong(short i02, short i12, short i22, short i32) {
        return (toUnsignedLong(i02) << pickPos(48, 0)) | (toUnsignedLong(i12) << pickPos(48, 16)) | (toUnsignedLong(i22) << pickPos(48, 32)) | (toUnsignedLong(i32) << pickPos(48, 48));
    }

    private static long makeLong(int i02, int i12) {
        return (toUnsignedLong(i02) << pickPos(32, 0)) | (toUnsignedLong(i12) << pickPos(32, 32));
    }

    private static int makeInt(short i02, short i12) {
        return (toUnsignedInt(i02) << pickPos(16, 0)) | (toUnsignedInt(i12) << pickPos(16, 16));
    }

    private static int makeInt(byte i02, byte i12, byte i22, byte i32) {
        return (toUnsignedInt(i02) << pickPos(24, 0)) | (toUnsignedInt(i12) << pickPos(24, 8)) | (toUnsignedInt(i22) << pickPos(24, 16)) | (toUnsignedInt(i32) << pickPos(24, 24));
    }

    private static short makeShort(byte i02, byte i12) {
        return (short) ((toUnsignedInt(i02) << pickPos(8, 0)) | (toUnsignedInt(i12) << pickPos(8, 8)));
    }

    private static int toUnsignedInt(byte n10) {
        return n10 & 255;
    }

    private static int toUnsignedInt(short n10) {
        return 65535 & n10;
    }

    private static long toUnsignedLong(byte n10) {
        return n10 & 255;
    }

    private static long toUnsignedLong(short n10) {
        return n10 & 65535;
    }

    private static long toUnsignedLong(int n10) {
        return n10 & 4294967295L;
    }

    @Deprecated(forRemoval = true, since = Constants.VIA_REPORT_TYPE_SET_AVATAR)
    public final Object getObject(Object o10, long offset) {
        return getReference(o10, offset);
    }

    @Deprecated(forRemoval = true, since = Constants.VIA_REPORT_TYPE_SET_AVATAR)
    public final Object getObjectVolatile(Object o10, long offset) {
        return getReferenceVolatile(o10, offset);
    }

    @Deprecated(forRemoval = true, since = Constants.VIA_REPORT_TYPE_SET_AVATAR)
    public final Object getObjectAcquire(Object o10, long offset) {
        return getReferenceAcquire(o10, offset);
    }

    @Deprecated(forRemoval = true, since = Constants.VIA_REPORT_TYPE_SET_AVATAR)
    public final void putObject(Object o10, long offset, Object x10) {
        putReference(o10, offset, x10);
    }

    @Deprecated(forRemoval = true, since = Constants.VIA_REPORT_TYPE_SET_AVATAR)
    public final void putObjectVolatile(Object o10, long offset, Object x10) {
        putReferenceVolatile(o10, offset, x10);
    }

    @Deprecated(forRemoval = true, since = Constants.VIA_REPORT_TYPE_SET_AVATAR)
    public final void putObjectRelease(Object o10, long offset, Object x10) {
        putReferenceRelease(o10, offset, x10);
    }

    @Deprecated(forRemoval = true, since = Constants.VIA_REPORT_TYPE_SET_AVATAR)
    public final Object getAndSetObject(Object o10, long offset, Object newValue) {
        return getAndSetReference(o10, offset, newValue);
    }

    @Deprecated(forRemoval = true, since = Constants.VIA_REPORT_TYPE_SET_AVATAR)
    public final boolean compareAndSetObject(Object o10, long offset, Object expected, Object x10) {
        return compareAndSetReference(o10, offset, expected, x10);
    }
}
