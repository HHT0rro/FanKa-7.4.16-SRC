package java.lang.reflect;

import dalvik.annotation.optimization.FastNative;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Array {
    @FastNative
    private static native Object createMultiArray(Class<?> cls, int[] iArr) throws NegativeArraySizeException;

    @FastNative
    private static native Object createObjectArray(Class<?> cls, int i10) throws NegativeArraySizeException;

    private Array() {
    }

    public static Object newInstance(Class<?> componentType, int length) throws NegativeArraySizeException {
        return newArray(componentType, length);
    }

    public static Object newInstance(Class<?> componentType, int... dimensions) throws IllegalArgumentException, NegativeArraySizeException {
        if (dimensions.length <= 0 || dimensions.length > 255) {
            throw new IllegalArgumentException("Bad number of dimensions: " + dimensions.length);
        }
        if (componentType == Void.TYPE) {
            throw new IllegalArgumentException("Can't allocate an array of void");
        }
        if (componentType == null) {
            throw new NullPointerException("componentType == null");
        }
        return createMultiArray(componentType, dimensions);
    }

    public static int getLength(Object array) {
        if (array instanceof Object[]) {
            return ((Object[]) array).length;
        }
        if (array instanceof boolean[]) {
            return ((boolean[]) array).length;
        }
        if (array instanceof byte[]) {
            return ((byte[]) array).length;
        }
        if (array instanceof char[]) {
            return ((char[]) array).length;
        }
        if (array instanceof double[]) {
            return ((double[]) array).length;
        }
        if (array instanceof float[]) {
            return ((float[]) array).length;
        }
        if (array instanceof int[]) {
            return ((int[]) array).length;
        }
        if (array instanceof long[]) {
            return ((long[]) array).length;
        }
        if (array instanceof short[]) {
            return ((short[]) array).length;
        }
        throw badArray(array);
    }

    public static Object get(Object array, int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof Object[]) {
            return ((Object[]) array)[index];
        }
        if (array instanceof boolean[]) {
            return ((boolean[]) array)[index] ? Boolean.TRUE : Boolean.FALSE;
        }
        if (array instanceof byte[]) {
            return Byte.valueOf(((byte[]) array)[index]);
        }
        if (array instanceof char[]) {
            return Character.valueOf(((char[]) array)[index]);
        }
        if (array instanceof short[]) {
            return Short.valueOf(((short[]) array)[index]);
        }
        if (array instanceof int[]) {
            return Integer.valueOf(((int[]) array)[index]);
        }
        if (array instanceof long[]) {
            return Long.valueOf(((long[]) array)[index]);
        }
        if (array instanceof float[]) {
            return new Float(((float[]) array)[index]);
        }
        if (array instanceof double[]) {
            return new Double(((double[]) array)[index]);
        }
        if (array == null) {
            throw new NullPointerException("array == null");
        }
        throw notAnArray(array);
    }

    public static boolean getBoolean(Object array, int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof boolean[]) {
            return ((boolean[]) array)[index];
        }
        throw badArray(array);
    }

    public static byte getByte(Object array, int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof byte[]) {
            return ((byte[]) array)[index];
        }
        throw badArray(array);
    }

    public static char getChar(Object array, int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof char[]) {
            return ((char[]) array)[index];
        }
        throw badArray(array);
    }

    public static short getShort(Object array, int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof short[]) {
            return ((short[]) array)[index];
        }
        if (array instanceof byte[]) {
            return ((byte[]) array)[index];
        }
        throw badArray(array);
    }

    public static int getInt(Object array, int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof int[]) {
            return ((int[]) array)[index];
        }
        if (array instanceof byte[]) {
            return ((byte[]) array)[index];
        }
        if (array instanceof char[]) {
            return ((char[]) array)[index];
        }
        if (array instanceof short[]) {
            return ((short[]) array)[index];
        }
        throw badArray(array);
    }

    public static long getLong(Object array, int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof long[]) {
            return ((long[]) array)[index];
        }
        if (array instanceof byte[]) {
            return ((byte[]) array)[index];
        }
        if (array instanceof char[]) {
            return ((char[]) array)[index];
        }
        if (array instanceof int[]) {
            return ((int[]) array)[index];
        }
        if (array instanceof short[]) {
            return ((short[]) array)[index];
        }
        throw badArray(array);
    }

    public static float getFloat(Object array, int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof float[]) {
            return ((float[]) array)[index];
        }
        if (array instanceof byte[]) {
            return ((byte[]) array)[index];
        }
        if (array instanceof char[]) {
            return ((char[]) array)[index];
        }
        if (array instanceof int[]) {
            return ((int[]) array)[index];
        }
        if (array instanceof long[]) {
            return (float) ((long[]) array)[index];
        }
        if (array instanceof short[]) {
            return ((short[]) array)[index];
        }
        throw badArray(array);
    }

    public static double getDouble(Object array, int index) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof double[]) {
            return ((double[]) array)[index];
        }
        if (array instanceof byte[]) {
            return ((byte[]) array)[index];
        }
        if (array instanceof char[]) {
            return ((char[]) array)[index];
        }
        if (array instanceof float[]) {
            return ((float[]) array)[index];
        }
        if (array instanceof int[]) {
            return ((int[]) array)[index];
        }
        if (array instanceof long[]) {
            return ((long[]) array)[index];
        }
        if (array instanceof short[]) {
            return ((short[]) array)[index];
        }
        throw badArray(array);
    }

    public static void set(Object array, int index, Object value) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (!array.getClass().isArray()) {
            throw notAnArray(array);
        }
        if (array instanceof Object[]) {
            if (value != null && !array.getClass().getComponentType().isInstance(value)) {
                throw incompatibleType(array);
            }
            ((Object[]) array)[index] = value;
            return;
        }
        if (value == null) {
            throw new IllegalArgumentException("Primitive array can't take null values.");
        }
        if (value instanceof Boolean) {
            setBoolean(array, index, ((Boolean) value).booleanValue());
            return;
        }
        if (value instanceof Byte) {
            setByte(array, index, ((Byte) value).byteValue());
            return;
        }
        if (value instanceof Character) {
            setChar(array, index, ((Character) value).charValue());
            return;
        }
        if (value instanceof Short) {
            setShort(array, index, ((Short) value).shortValue());
            return;
        }
        if (value instanceof Integer) {
            setInt(array, index, ((Integer) value).intValue());
            return;
        }
        if (value instanceof Long) {
            setLong(array, index, ((Long) value).longValue());
        } else if (value instanceof Float) {
            setFloat(array, index, ((Float) value).floatValue());
        } else if (value instanceof Double) {
            setDouble(array, index, ((Double) value).doubleValue());
        }
    }

    public static void setBoolean(Object array, int index, boolean z10) {
        if (array instanceof boolean[]) {
            ((boolean[]) array)[index] = z10;
            return;
        }
        throw badArray(array);
    }

    public static void setByte(Object array, int index, byte b4) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof byte[]) {
            ((byte[]) array)[index] = b4;
            return;
        }
        if (array instanceof double[]) {
            ((double[]) array)[index] = b4;
            return;
        }
        if (array instanceof float[]) {
            ((float[]) array)[index] = b4;
            return;
        }
        if (array instanceof int[]) {
            ((int[]) array)[index] = b4;
        } else if (array instanceof long[]) {
            ((long[]) array)[index] = b4;
        } else {
            if (array instanceof short[]) {
                ((short[]) array)[index] = b4;
                return;
            }
            throw badArray(array);
        }
    }

    public static void setChar(Object array, int index, char c4) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof char[]) {
            ((char[]) array)[index] = c4;
            return;
        }
        if (array instanceof double[]) {
            ((double[]) array)[index] = c4;
            return;
        }
        if (array instanceof float[]) {
            ((float[]) array)[index] = c4;
        } else if (array instanceof int[]) {
            ((int[]) array)[index] = c4;
        } else {
            if (array instanceof long[]) {
                ((long[]) array)[index] = c4;
                return;
            }
            throw badArray(array);
        }
    }

    public static void setShort(Object array, int index, short s2) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof short[]) {
            ((short[]) array)[index] = s2;
            return;
        }
        if (array instanceof double[]) {
            ((double[]) array)[index] = s2;
            return;
        }
        if (array instanceof float[]) {
            ((float[]) array)[index] = s2;
        } else if (array instanceof int[]) {
            ((int[]) array)[index] = s2;
        } else {
            if (array instanceof long[]) {
                ((long[]) array)[index] = s2;
                return;
            }
            throw badArray(array);
        }
    }

    public static void setInt(Object array, int index, int i10) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof int[]) {
            ((int[]) array)[index] = i10;
            return;
        }
        if (array instanceof double[]) {
            ((double[]) array)[index] = i10;
        } else if (array instanceof float[]) {
            ((float[]) array)[index] = i10;
        } else {
            if (array instanceof long[]) {
                ((long[]) array)[index] = i10;
                return;
            }
            throw badArray(array);
        }
    }

    public static void setLong(Object array, int index, long l10) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof long[]) {
            ((long[]) array)[index] = l10;
        } else if (array instanceof double[]) {
            ((double[]) array)[index] = l10;
        } else {
            if (array instanceof float[]) {
                ((float[]) array)[index] = (float) l10;
                return;
            }
            throw badArray(array);
        }
    }

    public static void setFloat(Object array, int index, float f10) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof float[]) {
            ((float[]) array)[index] = f10;
        } else {
            if (array instanceof double[]) {
                ((double[]) array)[index] = f10;
                return;
            }
            throw badArray(array);
        }
    }

    public static void setDouble(Object array, int index, double d10) throws IllegalArgumentException, ArrayIndexOutOfBoundsException {
        if (array instanceof double[]) {
            ((double[]) array)[index] = d10;
            return;
        }
        throw badArray(array);
    }

    private static Object newArray(Class<?> componentType, int length) throws NegativeArraySizeException {
        if (!componentType.isPrimitive()) {
            return createObjectArray(componentType, length);
        }
        if (componentType == Character.TYPE) {
            return new char[length];
        }
        if (componentType == Integer.TYPE) {
            return new int[length];
        }
        if (componentType == Byte.TYPE) {
            return new byte[length];
        }
        if (componentType == Boolean.TYPE) {
            return new boolean[length];
        }
        if (componentType == Short.TYPE) {
            return new short[length];
        }
        if (componentType == Long.TYPE) {
            return new long[length];
        }
        if (componentType == Float.TYPE) {
            return new float[length];
        }
        if (componentType == Double.TYPE) {
            return new double[length];
        }
        if (componentType == Void.TYPE) {
            throw new IllegalArgumentException("Can't allocate an array of void");
        }
        throw new AssertionError();
    }

    private static IllegalArgumentException notAnArray(Object o10) {
        throw new IllegalArgumentException("Not an array: " + ((Object) o10.getClass()));
    }

    private static IllegalArgumentException incompatibleType(Object o10) {
        throw new IllegalArgumentException("Array has incompatible type: " + ((Object) o10.getClass()));
    }

    private static RuntimeException badArray(Object array) {
        if (array == null) {
            throw new NullPointerException("array == null");
        }
        if (!array.getClass().isArray()) {
            throw notAnArray(array);
        }
        throw incompatibleType(array);
    }
}
