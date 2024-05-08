package org.apache.commons.lang3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.mutable.MutableInt;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ArrayUtils {
    public static final int INDEX_NOT_FOUND = -1;
    public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
    public static final Class<?>[] EMPTY_CLASS_ARRAY = new Class[0];
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final long[] EMPTY_LONG_ARRAY = new long[0];
    public static final Long[] EMPTY_LONG_OBJECT_ARRAY = new Long[0];
    public static final int[] EMPTY_INT_ARRAY = new int[0];
    public static final Integer[] EMPTY_INTEGER_OBJECT_ARRAY = new Integer[0];
    public static final short[] EMPTY_SHORT_ARRAY = new short[0];
    public static final Short[] EMPTY_SHORT_OBJECT_ARRAY = new Short[0];
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    public static final Byte[] EMPTY_BYTE_OBJECT_ARRAY = new Byte[0];
    public static final double[] EMPTY_DOUBLE_ARRAY = new double[0];
    public static final Double[] EMPTY_DOUBLE_OBJECT_ARRAY = new Double[0];
    public static final float[] EMPTY_FLOAT_ARRAY = new float[0];
    public static final Float[] EMPTY_FLOAT_OBJECT_ARRAY = new Float[0];
    public static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];
    public static final Boolean[] EMPTY_BOOLEAN_OBJECT_ARRAY = new Boolean[0];
    public static final char[] EMPTY_CHAR_ARRAY = new char[0];
    public static final Character[] EMPTY_CHARACTER_OBJECT_ARRAY = new Character[0];

    public static <T> T[] add(T[] tArr, T t2) {
        Class<?> cls;
        if (tArr != null) {
            cls = tArr.getClass().getComponentType();
        } else if (t2 != null) {
            cls = t2.getClass();
        } else {
            throw new IllegalArgumentException("Arguments cannot both be null");
        }
        T[] tArr2 = (T[]) ((Object[]) copyArrayGrow1(tArr, cls));
        tArr2[tArr2.length - 1] = t2;
        return tArr2;
    }

    public static <T> T[] addAll(T[] tArr, T... tArr2) {
        if (tArr == null) {
            return (T[]) clone(tArr2);
        }
        if (tArr2 == null) {
            return (T[]) clone(tArr);
        }
        Class<?> componentType = tArr.getClass().getComponentType();
        T[] tArr3 = (T[]) ((Object[]) Array.newInstance(componentType, tArr.length + tArr2.length));
        System.arraycopy(tArr, 0, tArr3, 0, tArr.length);
        try {
            System.arraycopy(tArr2, 0, tArr3, tArr.length, tArr2.length);
            return tArr3;
        } catch (ArrayStoreException e2) {
            Class<?> componentType2 = tArr2.getClass().getComponentType();
            if (!componentType.isAssignableFrom(componentType2)) {
                throw new IllegalArgumentException("Cannot store " + componentType2.getName() + " in an array of " + componentType.getName(), e2);
            }
            throw e2;
        }
    }

    public static <T> T[] clone(T[] tArr) {
        if (tArr == null) {
            return null;
        }
        return (T[]) ((Object[]) tArr.clone());
    }

    public static boolean contains(Object[] objArr, Object obj) {
        return indexOf(objArr, obj) != -1;
    }

    private static Object copyArrayGrow1(Object obj, Class<?> cls) {
        if (obj != null) {
            int length = Array.getLength(obj);
            Object newInstance = Array.newInstance(obj.getClass().getComponentType(), length + 1);
            System.arraycopy(obj, 0, newInstance, 0, length);
            return newInstance;
        }
        return Array.newInstance(cls, 1);
    }

    public static int getLength(Object obj) {
        if (obj == null) {
            return 0;
        }
        return Array.getLength(obj);
    }

    public static int hashCode(Object obj) {
        return new HashCodeBuilder().append(obj).toHashCode();
    }

    public static int indexOf(Object[] objArr, Object obj) {
        return indexOf(objArr, obj, 0);
    }

    public static boolean[] insert(int i10, boolean[] zArr, boolean... zArr2) {
        if (zArr == null) {
            return null;
        }
        if (zArr2 != null && zArr2.length != 0) {
            if (i10 >= 0 && i10 <= zArr.length) {
                boolean[] zArr3 = new boolean[zArr.length + zArr2.length];
                System.arraycopy((Object) zArr2, 0, (Object) zArr3, i10, zArr2.length);
                if (i10 > 0) {
                    System.arraycopy((Object) zArr, 0, (Object) zArr3, 0, i10);
                }
                if (i10 < zArr.length) {
                    System.arraycopy((Object) zArr, i10, (Object) zArr3, zArr2.length + i10, zArr.length - i10);
                }
                return zArr3;
            }
            throw new IndexOutOfBoundsException("Index: " + i10 + ", Length: " + zArr.length);
        }
        return clone(zArr);
    }

    public static <T> boolean isArrayIndexValid(T[] tArr, int i10) {
        return getLength(tArr) != 0 && tArr.length > i10 && i10 >= 0;
    }

    public static boolean isEmpty(Object[] objArr) {
        return getLength(objArr) == 0;
    }

    @Deprecated
    public static boolean isEquals(Object obj, Object obj2) {
        return new EqualsBuilder().append(obj, obj2).isEquals();
    }

    public static <T> boolean isNotEmpty(T[] tArr) {
        return !isEmpty(tArr);
    }

    public static boolean isSameLength(Object[] objArr, Object[] objArr2) {
        return getLength(objArr) == getLength(objArr2);
    }

    public static boolean isSameType(Object obj, Object obj2) {
        if (obj != null && obj2 != null) {
            return obj.getClass().getName().equals(obj2.getClass().getName());
        }
        throw new IllegalArgumentException("The Array must not be null");
    }

    public static <T extends Comparable<? super T>> boolean isSorted(T[] tArr) {
        return isSorted(tArr, new Comparator<T>() { // from class: org.apache.commons.lang3.ArrayUtils.1
            /* JADX WARN: Incorrect types in method signature: (TT;TT;)I */
            @Override // java.util.Comparator
            public int compare(Comparable comparable, Comparable comparable2) {
                return comparable.compareTo(comparable2);
            }
        });
    }

    public static int lastIndexOf(Object[] objArr, Object obj) {
        return lastIndexOf(objArr, obj, Integer.MAX_VALUE);
    }

    public static <T> T[] nullToEmpty(T[] tArr, Class<T[]> cls) {
        if (cls != null) {
            return tArr == null ? cls.cast(Array.newInstance(cls.getComponentType(), 0)) : tArr;
        }
        throw new IllegalArgumentException("The type must not be null");
    }

    public static <T> T[] remove(T[] tArr, int i10) {
        return (T[]) ((Object[]) remove((Object) tArr, i10));
    }

    public static <T> T[] removeAll(T[] tArr, int... iArr) {
        return (T[]) ((Object[]) removeAll((Object) tArr, iArr));
    }

    public static boolean[] removeAllOccurences(boolean[] zArr, boolean z10) {
        int indexOf = indexOf(zArr, z10);
        if (indexOf == -1) {
            return clone(zArr);
        }
        int[] iArr = new int[zArr.length - indexOf];
        iArr[0] = indexOf;
        int i10 = 1;
        while (true) {
            int indexOf2 = indexOf(zArr, z10, iArr[i10 - 1] + 1);
            if (indexOf2 != -1) {
                iArr[i10] = indexOf2;
                i10++;
            } else {
                return removeAll(zArr, Arrays.copyOf(iArr, i10));
            }
        }
    }

    public static <T> T[] removeElement(T[] tArr, Object obj) {
        int indexOf = indexOf(tArr, obj);
        if (indexOf == -1) {
            return (T[]) clone(tArr);
        }
        return (T[]) remove((Object[]) tArr, indexOf);
    }

    @SafeVarargs
    public static <T> T[] removeElements(T[] tArr, T... tArr2) {
        if (!isEmpty(tArr) && !isEmpty(tArr2)) {
            HashMap hashMap = new HashMap(tArr2.length);
            for (T t2 : tArr2) {
                MutableInt mutableInt = (MutableInt) hashMap.get(t2);
                if (mutableInt == null) {
                    hashMap.put(t2, new MutableInt(1));
                } else {
                    mutableInt.increment();
                }
            }
            BitSet bitSet = new BitSet();
            for (int i10 = 0; i10 < tArr.length; i10++) {
                T t10 = tArr[i10];
                MutableInt mutableInt2 = (MutableInt) hashMap.get(t10);
                if (mutableInt2 != null) {
                    if (mutableInt2.decrementAndGet() == 0) {
                        hashMap.remove(t10);
                    }
                    bitSet.set(i10);
                }
            }
            return (T[]) ((Object[]) removeAll(tArr, bitSet));
        }
        return (T[]) clone(tArr);
    }

    public static void reverse(Object[] objArr) {
        if (objArr == null) {
            return;
        }
        reverse(objArr, 0, objArr.length);
    }

    public static void shift(Object[] objArr, int i10) {
        if (objArr == null) {
            return;
        }
        shift(objArr, 0, objArr.length, i10);
    }

    public static void shuffle(Object[] objArr) {
        shuffle(objArr, new Random());
    }

    public static <T> T[] subarray(T[] tArr, int i10, int i11) {
        if (tArr == null) {
            return null;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        if (i11 > tArr.length) {
            i11 = tArr.length;
        }
        int i12 = i11 - i10;
        Class<?> componentType = tArr.getClass().getComponentType();
        if (i12 <= 0) {
            return (T[]) ((Object[]) Array.newInstance(componentType, 0));
        }
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance(componentType, i12));
        System.arraycopy(tArr, i10, tArr2, 0, i12);
        return tArr2;
    }

    public static void swap(Object[] objArr, int i10, int i11) {
        if (objArr == null || objArr.length == 0) {
            return;
        }
        swap(objArr, i10, i11, 1);
    }

    public static <T> T[] toArray(T... tArr) {
        return tArr;
    }

    public static Map<Object, Object> toMap(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        HashMap hashMap = new HashMap((int) (objArr.length * 1.5d));
        for (int i10 = 0; i10 < objArr.length; i10++) {
            Object obj = objArr[i10];
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                hashMap.put(entry.getKey(), entry.getValue());
            } else if (obj instanceof Object[]) {
                Object[] objArr2 = (Object[]) obj;
                if (objArr2.length >= 2) {
                    hashMap.put(objArr2[0], objArr2[1]);
                } else {
                    throw new IllegalArgumentException("Array element " + i10 + ", '" + obj + "', has a length less than 2");
                }
            } else {
                throw new IllegalArgumentException("Array element " + i10 + ", '" + obj + "', is neither of type Map.Entry nor an Array");
            }
        }
        return hashMap;
    }

    public static Character[] toObject(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        if (cArr.length == 0) {
            return EMPTY_CHARACTER_OBJECT_ARRAY;
        }
        Character[] chArr = new Character[cArr.length];
        for (int i10 = 0; i10 < cArr.length; i10++) {
            chArr[i10] = Character.valueOf(cArr[i10]);
        }
        return chArr;
    }

    public static char[] toPrimitive(Character[] chArr) {
        if (chArr == null) {
            return null;
        }
        if (chArr.length == 0) {
            return EMPTY_CHAR_ARRAY;
        }
        char[] cArr = new char[chArr.length];
        for (int i10 = 0; i10 < chArr.length; i10++) {
            cArr[i10] = chArr[i10].charValue();
        }
        return cArr;
    }

    public static String toString(Object obj) {
        return toString(obj, "{}");
    }

    public static String[] toStringArray(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        if (objArr.length == 0) {
            return EMPTY_STRING_ARRAY;
        }
        String[] strArr = new String[objArr.length];
        for (int i10 = 0; i10 < objArr.length; i10++) {
            strArr[i10] = objArr[i10].toString();
        }
        return strArr;
    }

    public static long[] clone(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        return (long[]) jArr.clone();
    }

    public static boolean contains(long[] jArr, long j10) {
        return indexOf(jArr, j10) != -1;
    }

    public static int indexOf(Object[] objArr, Object obj, int i10) {
        if (objArr == null) {
            return -1;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        if (obj == null) {
            while (i10 < objArr.length) {
                if (objArr[i10] == null) {
                    return i10;
                }
                i10++;
            }
        } else {
            while (i10 < objArr.length) {
                if (obj.equals(objArr[i10])) {
                    return i10;
                }
                i10++;
            }
        }
        return -1;
    }

    public static boolean isEmpty(long[] jArr) {
        return getLength(jArr) == 0;
    }

    public static boolean isNotEmpty(long[] jArr) {
        return !isEmpty(jArr);
    }

    public static boolean isSameLength(long[] jArr, long[] jArr2) {
        return getLength(jArr) == getLength(jArr2);
    }

    public static <T> boolean isSorted(T[] tArr, Comparator<T> comparator) {
        if (comparator != null) {
            if (tArr != null && tArr.length >= 2) {
                T t2 = tArr[0];
                int length = tArr.length;
                int i10 = 1;
                while (i10 < length) {
                    T t10 = tArr[i10];
                    if (comparator.compare(t2, t10) > 0) {
                        return false;
                    }
                    i10++;
                    t2 = t10;
                }
            }
            return true;
        }
        throw new IllegalArgumentException("Comparator should not be null.");
    }

    public static int lastIndexOf(Object[] objArr, Object obj, int i10) {
        if (objArr == null || i10 < 0) {
            return -1;
        }
        if (i10 >= objArr.length) {
            i10 = objArr.length - 1;
        }
        if (obj == null) {
            while (i10 >= 0) {
                if (objArr[i10] == null) {
                    return i10;
                }
                i10--;
            }
        } else if (objArr.getClass().getComponentType().isInstance(obj)) {
            while (i10 >= 0) {
                if (obj.equals(objArr[i10])) {
                    return i10;
                }
                i10--;
            }
        }
        return -1;
    }

    public static boolean[] remove(boolean[] zArr, int i10) {
        return (boolean[]) remove((Object) zArr, i10);
    }

    public static byte[] removeAll(byte[] bArr, int... iArr) {
        return (byte[]) removeAll((Object) bArr, iArr);
    }

    public static void reverse(long[] jArr) {
        if (jArr == null) {
            return;
        }
        reverse(jArr, 0, jArr.length);
    }

    public static void shift(long[] jArr, int i10) {
        if (jArr == null) {
            return;
        }
        shift(jArr, 0, jArr.length, i10);
    }

    public static void shuffle(Object[] objArr, Random random) {
        for (int length = objArr.length; length > 1; length--) {
            swap(objArr, length - 1, random.nextInt(length), 1);
        }
    }

    public static String toString(Object obj, String str) {
        return obj == null ? str : new ToStringBuilder(obj, ToStringStyle.SIMPLE_STYLE).append(obj).toString();
    }

    public static int[] clone(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        return (int[]) iArr.clone();
    }

    public static boolean contains(int[] iArr, int i10) {
        return indexOf(iArr, i10) != -1;
    }

    public static boolean isEmpty(int[] iArr) {
        return getLength(iArr) == 0;
    }

    public static boolean isNotEmpty(int[] iArr) {
        return !isEmpty(iArr);
    }

    public static boolean isSameLength(int[] iArr, int[] iArr2) {
        return getLength(iArr) == getLength(iArr2);
    }

    public static Object[] nullToEmpty(Object[] objArr) {
        return isEmpty(objArr) ? EMPTY_OBJECT_ARRAY : objArr;
    }

    public static byte[] remove(byte[] bArr, int i10) {
        return (byte[]) remove((Object) bArr, i10);
    }

    public static short[] removeAll(short[] sArr, int... iArr) {
        return (short[]) removeAll((Object) sArr, iArr);
    }

    public static void reverse(int[] iArr) {
        if (iArr == null) {
            return;
        }
        reverse(iArr, 0, iArr.length);
    }

    public static void shift(int[] iArr, int i10) {
        if (iArr == null) {
            return;
        }
        shift(iArr, 0, iArr.length, i10);
    }

    public static void swap(long[] jArr, int i10, int i11) {
        if (jArr == null || jArr.length == 0) {
            return;
        }
        swap(jArr, i10, i11, 1);
    }

    public static short[] clone(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        return (short[]) sArr.clone();
    }

    public static boolean contains(short[] sArr, short s2) {
        return indexOf(sArr, s2) != -1;
    }

    public static boolean isEmpty(short[] sArr) {
        return getLength(sArr) == 0;
    }

    public static boolean isNotEmpty(short[] sArr) {
        return !isEmpty(sArr);
    }

    public static boolean isSameLength(short[] sArr, short[] sArr2) {
        return getLength(sArr) == getLength(sArr2);
    }

    public static char[] remove(char[] cArr, int i10) {
        return (char[]) remove((Object) cArr, i10);
    }

    public static int[] removeAll(int[] iArr, int... iArr2) {
        return (int[]) removeAll((Object) iArr, iArr2);
    }

    public static boolean[] removeElement(boolean[] zArr, boolean z10) {
        int indexOf = indexOf(zArr, z10);
        if (indexOf == -1) {
            return clone(zArr);
        }
        return remove(zArr, indexOf);
    }

    public static void reverse(short[] sArr) {
        if (sArr == null) {
            return;
        }
        reverse(sArr, 0, sArr.length);
    }

    public static void shift(short[] sArr, int i10) {
        if (sArr == null) {
            return;
        }
        shift(sArr, 0, sArr.length, i10);
    }

    public static void shuffle(boolean[] zArr) {
        shuffle(zArr, new Random());
    }

    public static char[] clone(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return (char[]) cArr.clone();
    }

    public static boolean contains(char[] cArr, char c4) {
        return indexOf(cArr, c4) != -1;
    }

    public static boolean isEmpty(char[] cArr) {
        return getLength(cArr) == 0;
    }

    public static boolean isNotEmpty(char[] cArr) {
        return !isEmpty(cArr);
    }

    public static boolean isSameLength(char[] cArr, char[] cArr2) {
        return getLength(cArr) == getLength(cArr2);
    }

    public static Class<?>[] nullToEmpty(Class<?>[] clsArr) {
        return isEmpty(clsArr) ? EMPTY_CLASS_ARRAY : clsArr;
    }

    public static double[] remove(double[] dArr, int i10) {
        return (double[]) remove((Object) dArr, i10);
    }

    public static char[] removeAll(char[] cArr, int... iArr) {
        return (char[]) removeAll((Object) cArr, iArr);
    }

    public static void reverse(char[] cArr) {
        if (cArr == null) {
            return;
        }
        reverse(cArr, 0, cArr.length);
    }

    public static void shift(char[] cArr, int i10) {
        if (cArr == null) {
            return;
        }
        shift(cArr, 0, cArr.length, i10);
    }

    public static void shuffle(boolean[] zArr, Random random) {
        for (int length = zArr.length; length > 1; length--) {
            swap(zArr, length - 1, random.nextInt(length), 1);
        }
    }

    public static void swap(int[] iArr, int i10, int i11) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        swap(iArr, i10, i11, 1);
    }

    public static boolean[] add(boolean[] zArr, boolean z10) {
        boolean[] zArr2 = (boolean[]) copyArrayGrow1(zArr, Boolean.TYPE);
        zArr2[zArr2.length - 1] = z10;
        return zArr2;
    }

    public static byte[] clone(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public static boolean contains(byte[] bArr, byte b4) {
        return indexOf(bArr, b4) != -1;
    }

    public static int indexOf(long[] jArr, long j10) {
        return indexOf(jArr, j10, 0);
    }

    public static boolean isEmpty(byte[] bArr) {
        return getLength(bArr) == 0;
    }

    public static boolean isNotEmpty(byte[] bArr) {
        return !isEmpty(bArr);
    }

    public static boolean isSameLength(byte[] bArr, byte[] bArr2) {
        return getLength(bArr) == getLength(bArr2);
    }

    public static float[] remove(float[] fArr, int i10) {
        return (float[]) remove((Object) fArr, i10);
    }

    public static long[] removeAll(long[] jArr, int... iArr) {
        return (long[]) removeAll((Object) jArr, iArr);
    }

    public static void reverse(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        reverse(bArr, 0, bArr.length);
    }

    public static void shift(byte[] bArr, int i10) {
        if (bArr == null) {
            return;
        }
        shift(bArr, 0, bArr.length, i10);
    }

    public static Long[] toObject(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        if (jArr.length == 0) {
            return EMPTY_LONG_OBJECT_ARRAY;
        }
        Long[] lArr = new Long[jArr.length];
        for (int i10 = 0; i10 < jArr.length; i10++) {
            lArr[i10] = Long.valueOf(jArr[i10]);
        }
        return lArr;
    }

    public static char[] toPrimitive(Character[] chArr, char c4) {
        if (chArr == null) {
            return null;
        }
        if (chArr.length == 0) {
            return EMPTY_CHAR_ARRAY;
        }
        char[] cArr = new char[chArr.length];
        for (int i10 = 0; i10 < chArr.length; i10++) {
            Character ch = chArr[i10];
            cArr[i10] = ch == null ? c4 : ch.charValue();
        }
        return cArr;
    }

    public static String[] toStringArray(Object[] objArr, String str) {
        if (objArr == null) {
            return null;
        }
        if (objArr.length == 0) {
            return EMPTY_STRING_ARRAY;
        }
        String[] strArr = new String[objArr.length];
        for (int i10 = 0; i10 < objArr.length; i10++) {
            Object obj = objArr[i10];
            strArr[i10] = obj == null ? str : obj.toString();
        }
        return strArr;
    }

    public static double[] clone(double[] dArr) {
        if (dArr == null) {
            return null;
        }
        return (double[]) dArr.clone();
    }

    public static boolean contains(double[] dArr, double d10) {
        return indexOf(dArr, d10) != -1;
    }

    public static int indexOf(long[] jArr, long j10, int i10) {
        if (jArr == null) {
            return -1;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        while (i10 < jArr.length) {
            if (j10 == jArr[i10]) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static boolean isEmpty(double[] dArr) {
        return getLength(dArr) == 0;
    }

    public static boolean isNotEmpty(double[] dArr) {
        return !isEmpty(dArr);
    }

    public static boolean isSameLength(double[] dArr, double[] dArr2) {
        return getLength(dArr) == getLength(dArr2);
    }

    public static int lastIndexOf(long[] jArr, long j10) {
        return lastIndexOf(jArr, j10, Integer.MAX_VALUE);
    }

    public static String[] nullToEmpty(String[] strArr) {
        return isEmpty(strArr) ? EMPTY_STRING_ARRAY : strArr;
    }

    public static int[] remove(int[] iArr, int i10) {
        return (int[]) remove((Object) iArr, i10);
    }

    public static float[] removeAll(float[] fArr, int... iArr) {
        return (float[]) removeAll((Object) fArr, iArr);
    }

    public static byte[] removeElement(byte[] bArr, byte b4) {
        int indexOf = indexOf(bArr, b4);
        if (indexOf == -1) {
            return clone(bArr);
        }
        return remove(bArr, indexOf);
    }

    public static void reverse(double[] dArr) {
        if (dArr == null) {
            return;
        }
        reverse(dArr, 0, dArr.length);
    }

    public static void shift(double[] dArr, int i10) {
        if (dArr == null) {
            return;
        }
        shift(dArr, 0, dArr.length, i10);
    }

    public static void shuffle(byte[] bArr) {
        shuffle(bArr, new Random());
    }

    public static long[] subarray(long[] jArr, int i10, int i11) {
        if (jArr == null) {
            return null;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        if (i11 > jArr.length) {
            i11 = jArr.length;
        }
        int i12 = i11 - i10;
        if (i12 <= 0) {
            return EMPTY_LONG_ARRAY;
        }
        long[] jArr2 = new long[i12];
        System.arraycopy((Object) jArr, i10, (Object) jArr2, 0, i12);
        return jArr2;
    }

    public static void swap(short[] sArr, int i10, int i11) {
        if (sArr == null || sArr.length == 0) {
            return;
        }
        swap(sArr, i10, i11, 1);
    }

    public static byte[] add(byte[] bArr, byte b4) {
        byte[] bArr2 = (byte[]) copyArrayGrow1(bArr, Byte.TYPE);
        bArr2[bArr2.length - 1] = b4;
        return bArr2;
    }

    public static float[] clone(float[] fArr) {
        if (fArr == null) {
            return null;
        }
        return (float[]) fArr.clone();
    }

    public static boolean contains(double[] dArr, double d10, double d11) {
        return indexOf(dArr, d10, 0, d11) != -1;
    }

    public static boolean isEmpty(float[] fArr) {
        return getLength(fArr) == 0;
    }

    public static boolean isNotEmpty(float[] fArr) {
        return !isEmpty(fArr);
    }

    public static boolean isSameLength(float[] fArr, float[] fArr2) {
        return getLength(fArr) == getLength(fArr2);
    }

    public static boolean isSorted(int[] iArr) {
        if (iArr != null && iArr.length >= 2) {
            int i10 = iArr[0];
            int length = iArr.length;
            int i11 = 1;
            while (i11 < length) {
                int i12 = iArr[i11];
                if (NumberUtils.compare(i10, i12) > 0) {
                    return false;
                }
                i11++;
                i10 = i12;
            }
        }
        return true;
    }

    public static int lastIndexOf(long[] jArr, long j10, int i10) {
        if (jArr == null || i10 < 0) {
            return -1;
        }
        if (i10 >= jArr.length) {
            i10 = jArr.length - 1;
        }
        while (i10 >= 0) {
            if (j10 == jArr[i10]) {
                return i10;
            }
            i10--;
        }
        return -1;
    }

    public static long[] remove(long[] jArr, int i10) {
        return (long[]) remove((Object) jArr, i10);
    }

    public static double[] removeAll(double[] dArr, int... iArr) {
        return (double[]) removeAll((Object) dArr, iArr);
    }

    public static char[] removeAllOccurences(char[] cArr, char c4) {
        int indexOf = indexOf(cArr, c4);
        if (indexOf == -1) {
            return clone(cArr);
        }
        int[] iArr = new int[cArr.length - indexOf];
        iArr[0] = indexOf;
        int i10 = 1;
        while (true) {
            int indexOf2 = indexOf(cArr, c4, iArr[i10 - 1] + 1);
            if (indexOf2 != -1) {
                iArr[i10] = indexOf2;
                i10++;
            } else {
                return removeAll(cArr, Arrays.copyOf(iArr, i10));
            }
        }
    }

    public static void reverse(float[] fArr) {
        if (fArr == null) {
            return;
        }
        reverse(fArr, 0, fArr.length);
    }

    public static void shift(float[] fArr, int i10) {
        if (fArr == null) {
            return;
        }
        shift(fArr, 0, fArr.length, i10);
    }

    public static void shuffle(byte[] bArr, Random random) {
        for (int length = bArr.length; length > 1; length--) {
            swap(bArr, length - 1, random.nextInt(length), 1);
        }
    }

    public static boolean[] clone(boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        return (boolean[]) zArr.clone();
    }

    public static boolean contains(float[] fArr, float f10) {
        return indexOf(fArr, f10) != -1;
    }

    public static int indexOf(int[] iArr, int i10) {
        return indexOf(iArr, i10, 0);
    }

    public static boolean isEmpty(boolean[] zArr) {
        return getLength(zArr) == 0;
    }

    public static boolean isNotEmpty(boolean[] zArr) {
        return !isEmpty(zArr);
    }

    public static boolean isSameLength(boolean[] zArr, boolean[] zArr2) {
        return getLength(zArr) == getLength(zArr2);
    }

    public static long[] nullToEmpty(long[] jArr) {
        return isEmpty(jArr) ? EMPTY_LONG_ARRAY : jArr;
    }

    public static short[] remove(short[] sArr, int i10) {
        return (short[]) remove((Object) sArr, i10);
    }

    public static boolean[] removeAll(boolean[] zArr, int... iArr) {
        return (boolean[]) removeAll((Object) zArr, iArr);
    }

    public static void reverse(boolean[] zArr) {
        if (zArr == null) {
            return;
        }
        reverse(zArr, 0, zArr.length);
    }

    public static void shift(boolean[] zArr, int i10) {
        if (zArr == null) {
            return;
        }
        shift(zArr, 0, zArr.length, i10);
    }

    public static void swap(char[] cArr, int i10, int i11) {
        if (cArr == null || cArr.length == 0) {
            return;
        }
        swap(cArr, i10, i11, 1);
    }

    public static char[] add(char[] cArr, char c4) {
        char[] cArr2 = (char[]) copyArrayGrow1(cArr, Character.TYPE);
        cArr2[cArr2.length - 1] = c4;
        return cArr2;
    }

    public static boolean contains(boolean[] zArr, boolean z10) {
        return indexOf(zArr, z10) != -1;
    }

    public static int indexOf(int[] iArr, int i10, int i11) {
        if (iArr == null) {
            return -1;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        while (i11 < iArr.length) {
            if (i10 == iArr[i11]) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static byte[] insert(int i10, byte[] bArr, byte... bArr2) {
        if (bArr == null) {
            return null;
        }
        if (bArr2 != null && bArr2.length != 0) {
            if (i10 >= 0 && i10 <= bArr.length) {
                byte[] bArr3 = new byte[bArr.length + bArr2.length];
                System.arraycopy((Object) bArr2, 0, (Object) bArr3, i10, bArr2.length);
                if (i10 > 0) {
                    System.arraycopy((Object) bArr, 0, (Object) bArr3, 0, i10);
                }
                if (i10 < bArr.length) {
                    System.arraycopy((Object) bArr, i10, (Object) bArr3, bArr2.length + i10, bArr.length - i10);
                }
                return bArr3;
            }
            throw new IndexOutOfBoundsException("Index: " + i10 + ", Length: " + bArr.length);
        }
        return clone(bArr);
    }

    private static Object remove(Object obj, int i10) {
        int length = getLength(obj);
        if (i10 >= 0 && i10 < length) {
            int i11 = length - 1;
            Object newInstance = Array.newInstance(obj.getClass().getComponentType(), i11);
            System.arraycopy(obj, 0, newInstance, 0, i10);
            if (i10 < i11) {
                System.arraycopy(obj, i10 + 1, newInstance, i10, (length - i10) - 1);
            }
            return newInstance;
        }
        throw new IndexOutOfBoundsException("Index: " + i10 + ", Length: " + length);
    }

    public static Object removeAll(Object obj, int... iArr) {
        int i10;
        int i11;
        int length = getLength(obj);
        int[] clone = clone(iArr);
        Arrays.sort(clone);
        if (isNotEmpty(clone)) {
            int length2 = clone.length;
            int i12 = length;
            i10 = 0;
            while (true) {
                length2--;
                if (length2 < 0) {
                    break;
                }
                i11 = clone[length2];
                if (i11 < 0 || i11 >= length) {
                    break;
                }
                if (i11 < i12) {
                    i10++;
                    i12 = i11;
                }
            }
            throw new IndexOutOfBoundsException("Index: " + i11 + ", Length: " + length);
        }
        i10 = 0;
        int i13 = length - i10;
        Object newInstance = Array.newInstance(obj.getClass().getComponentType(), i13);
        if (i10 < length) {
            int length3 = clone.length - 1;
            while (length3 >= 0) {
                int i14 = clone[length3];
                int i15 = length - i14;
                if (i15 > 1) {
                    int i16 = i15 - 1;
                    i13 -= i16;
                    System.arraycopy(obj, i14 + 1, newInstance, i13, i16);
                }
                length3--;
                length = i14;
            }
            if (length > 0) {
                System.arraycopy(obj, 0, newInstance, 0, length);
            }
        }
        return newInstance;
    }

    public static char[] removeElement(char[] cArr, char c4) {
        int indexOf = indexOf(cArr, c4);
        if (indexOf == -1) {
            return clone(cArr);
        }
        return remove(cArr, indexOf);
    }

    public static void reverse(boolean[] zArr, int i10, int i11) {
        if (zArr == null) {
            return;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        int min = Math.min(zArr.length, i11) - 1;
        while (min > i10) {
            boolean z10 = zArr[min];
            zArr[min] = zArr[i10];
            zArr[i10] = z10;
            min--;
            i10++;
        }
    }

    public static void shift(boolean[] zArr, int i10, int i11, int i12) {
        if (zArr != null && i10 < zArr.length - 1 && i11 > 0) {
            if (i10 < 0) {
                i10 = 0;
            }
            if (i11 >= zArr.length) {
                i11 = zArr.length;
            }
            int i13 = i11 - i10;
            if (i13 <= 1) {
                return;
            }
            int i14 = i12 % i13;
            if (i14 < 0) {
                i14 += i13;
            }
            while (i13 > 1 && i14 > 0) {
                int i15 = i13 - i14;
                if (i14 > i15) {
                    swap(zArr, i10, (i13 + i10) - i15, i15);
                    int i16 = i14;
                    i14 -= i15;
                    i13 = i16;
                } else if (i14 < i15) {
                    swap(zArr, i10, i10 + i15, i14);
                    i10 += i14;
                    i13 = i15;
                } else {
                    swap(zArr, i10, i15 + i10, i14);
                    return;
                }
            }
        }
    }

    public static void shuffle(char[] cArr) {
        shuffle(cArr, new Random());
    }

    public static int lastIndexOf(int[] iArr, int i10) {
        return lastIndexOf(iArr, i10, Integer.MAX_VALUE);
    }

    public static int[] nullToEmpty(int[] iArr) {
        return isEmpty(iArr) ? EMPTY_INT_ARRAY : iArr;
    }

    public static void shuffle(char[] cArr, Random random) {
        for (int length = cArr.length; length > 1; length--) {
            swap(cArr, length - 1, random.nextInt(length), 1);
        }
    }

    public static void swap(byte[] bArr, int i10, int i11) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        swap(bArr, i10, i11, 1);
    }

    public static Integer[] toObject(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        if (iArr.length == 0) {
            return EMPTY_INTEGER_OBJECT_ARRAY;
        }
        Integer[] numArr = new Integer[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            numArr[i10] = Integer.valueOf(iArr[i10]);
        }
        return numArr;
    }

    public static double[] add(double[] dArr, double d10) {
        double[] dArr2 = (double[]) copyArrayGrow1(dArr, Double.TYPE);
        dArr2[dArr2.length - 1] = d10;
        return dArr2;
    }

    public static boolean[] addAll(boolean[] zArr, boolean... zArr2) {
        if (zArr == null) {
            return clone(zArr2);
        }
        if (zArr2 == null) {
            return clone(zArr);
        }
        boolean[] zArr3 = new boolean[zArr.length + zArr2.length];
        System.arraycopy((Object) zArr, 0, (Object) zArr3, 0, zArr.length);
        System.arraycopy((Object) zArr2, 0, (Object) zArr3, zArr.length, zArr2.length);
        return zArr3;
    }

    public static int indexOf(short[] sArr, short s2) {
        return indexOf(sArr, s2, 0);
    }

    public static int lastIndexOf(int[] iArr, int i10, int i11) {
        if (iArr == null || i11 < 0) {
            return -1;
        }
        if (i11 >= iArr.length) {
            i11 = iArr.length - 1;
        }
        while (i11 >= 0) {
            if (i10 == iArr[i11]) {
                return i11;
            }
            i11--;
        }
        return -1;
    }

    public static int[] subarray(int[] iArr, int i10, int i11) {
        if (iArr == null) {
            return null;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        if (i11 > iArr.length) {
            i11 = iArr.length;
        }
        int i12 = i11 - i10;
        if (i12 <= 0) {
            return EMPTY_INT_ARRAY;
        }
        int[] iArr2 = new int[i12];
        System.arraycopy((Object) iArr, i10, (Object) iArr2, 0, i12);
        return iArr2;
    }

    public static long[] toPrimitive(Long[] lArr) {
        if (lArr == null) {
            return null;
        }
        if (lArr.length == 0) {
            return EMPTY_LONG_ARRAY;
        }
        long[] jArr = new long[lArr.length];
        for (int i10 = 0; i10 < lArr.length; i10++) {
            jArr[i10] = lArr[i10].longValue();
        }
        return jArr;
    }

    public static int indexOf(short[] sArr, short s2, int i10) {
        if (sArr == null) {
            return -1;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        while (i10 < sArr.length) {
            if (s2 == sArr[i10]) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static boolean isSorted(long[] jArr) {
        if (jArr != null && jArr.length >= 2) {
            long j10 = jArr[0];
            int length = jArr.length;
            int i10 = 1;
            while (i10 < length) {
                long j11 = jArr[i10];
                if (NumberUtils.compare(j10, j11) > 0) {
                    return false;
                }
                i10++;
                j10 = j11;
            }
        }
        return true;
    }

    public static short[] nullToEmpty(short[] sArr) {
        return isEmpty(sArr) ? EMPTY_SHORT_ARRAY : sArr;
    }

    public static double[] removeElement(double[] dArr, double d10) {
        int indexOf = indexOf(dArr, d10);
        if (indexOf == -1) {
            return clone(dArr);
        }
        return remove(dArr, indexOf);
    }

    public static void shuffle(short[] sArr) {
        shuffle(sArr, new Random());
    }

    public static void swap(double[] dArr, int i10, int i11) {
        if (dArr == null || dArr.length == 0) {
            return;
        }
        swap(dArr, i10, i11, 1);
    }

    public static float[] add(float[] fArr, float f10) {
        float[] fArr2 = (float[]) copyArrayGrow1(fArr, Float.TYPE);
        fArr2[fArr2.length - 1] = f10;
        return fArr2;
    }

    public static void reverse(byte[] bArr, int i10, int i11) {
        if (bArr == null) {
            return;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        int min = Math.min(bArr.length, i11) - 1;
        while (min > i10) {
            byte b4 = bArr[min];
            bArr[min] = bArr[i10];
            bArr[i10] = b4;
            min--;
            i10++;
        }
    }

    public static void shuffle(short[] sArr, Random random) {
        for (int length = sArr.length; length > 1; length--) {
            swap(sArr, length - 1, random.nextInt(length), 1);
        }
    }

    public static int indexOf(char[] cArr, char c4) {
        return indexOf(cArr, c4, 0);
    }

    public static int lastIndexOf(short[] sArr, short s2) {
        return lastIndexOf(sArr, s2, Integer.MAX_VALUE);
    }

    public static char[] nullToEmpty(char[] cArr) {
        return isEmpty(cArr) ? EMPTY_CHAR_ARRAY : cArr;
    }

    public static byte[] removeAllOccurences(byte[] bArr, byte b4) {
        int indexOf = indexOf(bArr, b4);
        if (indexOf == -1) {
            return clone(bArr);
        }
        int[] iArr = new int[bArr.length - indexOf];
        iArr[0] = indexOf;
        int i10 = 1;
        while (true) {
            int indexOf2 = indexOf(bArr, b4, iArr[i10 - 1] + 1);
            if (indexOf2 != -1) {
                iArr[i10] = indexOf2;
                i10++;
            } else {
                return removeAll(bArr, Arrays.copyOf(iArr, i10));
            }
        }
    }

    public static void swap(float[] fArr, int i10, int i11) {
        if (fArr == null || fArr.length == 0) {
            return;
        }
        swap(fArr, i10, i11, 1);
    }

    public static int[] add(int[] iArr, int i10) {
        int[] iArr2 = (int[]) copyArrayGrow1(iArr, Integer.TYPE);
        iArr2[iArr2.length - 1] = i10;
        return iArr2;
    }

    public static int indexOf(char[] cArr, char c4, int i10) {
        if (cArr == null) {
            return -1;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        while (i10 < cArr.length) {
            if (c4 == cArr[i10]) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static int lastIndexOf(short[] sArr, short s2, int i10) {
        if (sArr == null || i10 < 0) {
            return -1;
        }
        if (i10 >= sArr.length) {
            i10 = sArr.length - 1;
        }
        while (i10 >= 0) {
            if (s2 == sArr[i10]) {
                return i10;
            }
            i10--;
        }
        return -1;
    }

    public static float[] removeElement(float[] fArr, float f10) {
        int indexOf = indexOf(fArr, f10);
        if (indexOf == -1) {
            return clone(fArr);
        }
        return remove(fArr, indexOf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] removeElements(byte[] bArr, byte... bArr2) {
        if (!isEmpty(bArr) && !isEmpty(bArr2)) {
            HashMap hashMap = new HashMap(bArr2.length);
            for (byte b4 : bArr2) {
                Byte valueOf = Byte.valueOf(b4);
                MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
                if (mutableInt == null) {
                    hashMap.put(valueOf, new MutableInt(1));
                } else {
                    mutableInt.increment();
                }
            }
            BitSet bitSet = new BitSet();
            for (int i10 = 0; i10 < bArr.length; i10++) {
                byte b10 = bArr[i10];
                MutableInt mutableInt2 = (MutableInt) hashMap.get(Byte.valueOf(b10));
                if (mutableInt2 != null) {
                    if (mutableInt2.decrementAndGet() == 0) {
                        hashMap.remove(Byte.valueOf(b10));
                    }
                    bitSet.set(i10);
                }
            }
            return (byte[]) removeAll(bArr, bitSet);
        }
        return clone(bArr);
    }

    public static void shuffle(int[] iArr) {
        shuffle(iArr, new Random());
    }

    public static Short[] toObject(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        if (sArr.length == 0) {
            return EMPTY_SHORT_OBJECT_ARRAY;
        }
        Short[] shArr = new Short[sArr.length];
        for (int i10 = 0; i10 < sArr.length; i10++) {
            shArr[i10] = Short.valueOf(sArr[i10]);
        }
        return shArr;
    }

    public static char[] addAll(char[] cArr, char... cArr2) {
        if (cArr == null) {
            return clone(cArr2);
        }
        if (cArr2 == null) {
            return clone(cArr);
        }
        char[] cArr3 = new char[cArr.length + cArr2.length];
        System.arraycopy((Object) cArr, 0, (Object) cArr3, 0, cArr.length);
        System.arraycopy((Object) cArr2, 0, (Object) cArr3, cArr.length, cArr2.length);
        return cArr3;
    }

    public static byte[] nullToEmpty(byte[] bArr) {
        return isEmpty(bArr) ? EMPTY_BYTE_ARRAY : bArr;
    }

    public static void shift(byte[] bArr, int i10, int i11, int i12) {
        if (bArr != null && i10 < bArr.length - 1 && i11 > 0) {
            if (i10 < 0) {
                i10 = 0;
            }
            if (i11 >= bArr.length) {
                i11 = bArr.length;
            }
            int i13 = i11 - i10;
            if (i13 <= 1) {
                return;
            }
            int i14 = i12 % i13;
            if (i14 < 0) {
                i14 += i13;
            }
            while (i13 > 1 && i14 > 0) {
                int i15 = i13 - i14;
                if (i14 > i15) {
                    swap(bArr, i10, (i13 + i10) - i15, i15);
                    int i16 = i14;
                    i14 -= i15;
                    i13 = i16;
                } else if (i14 < i15) {
                    swap(bArr, i10, i10 + i15, i14);
                    i10 += i14;
                    i13 = i15;
                } else {
                    swap(bArr, i10, i15 + i10, i14);
                    return;
                }
            }
        }
    }

    public static void shuffle(int[] iArr, Random random) {
        for (int length = iArr.length; length > 1; length--) {
            swap(iArr, length - 1, random.nextInt(length), 1);
        }
    }

    public static short[] subarray(short[] sArr, int i10, int i11) {
        if (sArr == null) {
            return null;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        if (i11 > sArr.length) {
            i11 = sArr.length;
        }
        int i12 = i11 - i10;
        if (i12 <= 0) {
            return EMPTY_SHORT_ARRAY;
        }
        short[] sArr2 = new short[i12];
        System.arraycopy((Object) sArr, i10, (Object) sArr2, 0, i12);
        return sArr2;
    }

    public static void swap(boolean[] zArr, int i10, int i11) {
        if (zArr == null || zArr.length == 0) {
            return;
        }
        swap(zArr, i10, i11, 1);
    }

    public static long[] toPrimitive(Long[] lArr, long j10) {
        if (lArr == null) {
            return null;
        }
        if (lArr.length == 0) {
            return EMPTY_LONG_ARRAY;
        }
        long[] jArr = new long[lArr.length];
        for (int i10 = 0; i10 < lArr.length; i10++) {
            Long l10 = lArr[i10];
            jArr[i10] = l10 == null ? j10 : l10.longValue();
        }
        return jArr;
    }

    public static long[] add(long[] jArr, long j10) {
        long[] jArr2 = (long[]) copyArrayGrow1(jArr, Long.TYPE);
        jArr2[jArr2.length - 1] = j10;
        return jArr2;
    }

    public static int indexOf(byte[] bArr, byte b4) {
        return indexOf(bArr, b4, 0);
    }

    public static boolean isSorted(short[] sArr) {
        if (sArr != null && sArr.length >= 2) {
            short s2 = sArr[0];
            int length = sArr.length;
            int i10 = 1;
            while (i10 < length) {
                short s10 = sArr[i10];
                if (NumberUtils.compare(s2, s10) > 0) {
                    return false;
                }
                i10++;
                s2 = s10;
            }
        }
        return true;
    }

    public static void reverse(char[] cArr, int i10, int i11) {
        if (cArr == null) {
            return;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        int min = Math.min(cArr.length, i11) - 1;
        while (min > i10) {
            char c4 = cArr[min];
            cArr[min] = cArr[i10];
            cArr[i10] = c4;
            min--;
            i10++;
        }
    }

    public static int indexOf(byte[] bArr, byte b4, int i10) {
        if (bArr == null) {
            return -1;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        while (i10 < bArr.length) {
            if (b4 == bArr[i10]) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static char[] insert(int i10, char[] cArr, char... cArr2) {
        if (cArr == null) {
            return null;
        }
        if (cArr2 != null && cArr2.length != 0) {
            if (i10 >= 0 && i10 <= cArr.length) {
                char[] cArr3 = new char[cArr.length + cArr2.length];
                System.arraycopy((Object) cArr2, 0, (Object) cArr3, i10, cArr2.length);
                if (i10 > 0) {
                    System.arraycopy((Object) cArr, 0, (Object) cArr3, 0, i10);
                }
                if (i10 < cArr.length) {
                    System.arraycopy((Object) cArr, i10, (Object) cArr3, cArr2.length + i10, cArr.length - i10);
                }
                return cArr3;
            }
            throw new IndexOutOfBoundsException("Index: " + i10 + ", Length: " + cArr.length);
        }
        return clone(cArr);
    }

    public static int lastIndexOf(char[] cArr, char c4) {
        return lastIndexOf(cArr, c4, Integer.MAX_VALUE);
    }

    public static double[] nullToEmpty(double[] dArr) {
        return isEmpty(dArr) ? EMPTY_DOUBLE_ARRAY : dArr;
    }

    public static int[] removeElement(int[] iArr, int i10) {
        int indexOf = indexOf(iArr, i10);
        if (indexOf == -1) {
            return clone(iArr);
        }
        return remove(iArr, indexOf);
    }

    public static void shuffle(long[] jArr) {
        shuffle(jArr, new Random());
    }

    public static void swap(boolean[] zArr, int i10, int i11, int i12) {
        if (zArr == null || zArr.length == 0 || i10 >= zArr.length || i11 >= zArr.length) {
            return;
        }
        int i13 = 0;
        if (i10 < 0) {
            i10 = 0;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        int min = Math.min(Math.min(i12, zArr.length - i10), zArr.length - i11);
        while (i13 < min) {
            boolean z10 = zArr[i10];
            zArr[i10] = zArr[i11];
            zArr[i11] = z10;
            i13++;
            i10++;
            i11++;
        }
    }

    public static short[] add(short[] sArr, short s2) {
        short[] sArr2 = (short[]) copyArrayGrow1(sArr, Short.TYPE);
        sArr2[sArr2.length - 1] = s2;
        return sArr2;
    }

    public static int lastIndexOf(char[] cArr, char c4, int i10) {
        if (cArr == null || i10 < 0) {
            return -1;
        }
        if (i10 >= cArr.length) {
            i10 = cArr.length - 1;
        }
        while (i10 >= 0) {
            if (c4 == cArr[i10]) {
                return i10;
            }
            i10--;
        }
        return -1;
    }

    public static void shuffle(long[] jArr, Random random) {
        for (int length = jArr.length; length > 1; length--) {
            swap(jArr, length - 1, random.nextInt(length), 1);
        }
    }

    public static int indexOf(double[] dArr, double d10) {
        return indexOf(dArr, d10, 0);
    }

    public static float[] nullToEmpty(float[] fArr) {
        return isEmpty(fArr) ? EMPTY_FLOAT_ARRAY : fArr;
    }

    public static Byte[] toObject(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return EMPTY_BYTE_OBJECT_ARRAY;
        }
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr2[i10] = Byte.valueOf(bArr[i10]);
        }
        return bArr2;
    }

    @Deprecated
    public static <T> T[] add(T[] tArr, int i10, T t2) {
        Class<?> cls;
        if (tArr != null) {
            cls = tArr.getClass().getComponentType();
        } else if (t2 != null) {
            cls = t2.getClass();
        } else {
            throw new IllegalArgumentException("Array and element cannot both be null");
        }
        return (T[]) ((Object[]) add(tArr, i10, t2, cls));
    }

    public static byte[] addAll(byte[] bArr, byte... bArr2) {
        if (bArr == null) {
            return clone(bArr2);
        }
        if (bArr2 == null) {
            return clone(bArr);
        }
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy((Object) bArr, 0, (Object) bArr3, 0, bArr.length);
        System.arraycopy((Object) bArr2, 0, (Object) bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static int indexOf(double[] dArr, double d10, double d11) {
        return indexOf(dArr, d10, 0, d11);
    }

    public static Object removeAll(Object obj, BitSet bitSet) {
        int length = getLength(obj);
        Object newInstance = Array.newInstance(obj.getClass().getComponentType(), length - bitSet.cardinality());
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int nextSetBit = bitSet.nextSetBit(i10);
            if (nextSetBit == -1) {
                break;
            }
            int i12 = nextSetBit - i10;
            if (i12 > 0) {
                System.arraycopy(obj, i10, newInstance, i11, i12);
                i11 += i12;
            }
            i10 = bitSet.nextClearBit(nextSetBit);
        }
        int i13 = length - i10;
        if (i13 > 0) {
            System.arraycopy(obj, i10, newInstance, i11, i13);
        }
        return newInstance;
    }

    public static short[] removeAllOccurences(short[] sArr, short s2) {
        int indexOf = indexOf(sArr, s2);
        if (indexOf == -1) {
            return clone(sArr);
        }
        int[] iArr = new int[sArr.length - indexOf];
        iArr[0] = indexOf;
        int i10 = 1;
        while (true) {
            int indexOf2 = indexOf(sArr, s2, iArr[i10 - 1] + 1);
            if (indexOf2 != -1) {
                iArr[i10] = indexOf2;
                i10++;
            } else {
                return removeAll(sArr, Arrays.copyOf(iArr, i10));
            }
        }
    }

    public static long[] removeElement(long[] jArr, long j10) {
        int indexOf = indexOf(jArr, j10);
        if (indexOf == -1) {
            return clone(jArr);
        }
        return remove(jArr, indexOf);
    }

    public static void reverse(double[] dArr, int i10, int i11) {
        if (dArr == null) {
            return;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        int min = Math.min(dArr.length, i11) - 1;
        while (min > i10) {
            double d10 = dArr[min];
            dArr[min] = dArr[i10];
            dArr[i10] = d10;
            min--;
            i10++;
        }
    }

    public static void shuffle(float[] fArr) {
        shuffle(fArr, new Random());
    }

    public static char[] subarray(char[] cArr, int i10, int i11) {
        if (cArr == null) {
            return null;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        if (i11 > cArr.length) {
            i11 = cArr.length;
        }
        int i12 = i11 - i10;
        if (i12 <= 0) {
            return EMPTY_CHAR_ARRAY;
        }
        char[] cArr2 = new char[i12];
        System.arraycopy((Object) cArr, i10, (Object) cArr2, 0, i12);
        return cArr2;
    }

    public static int indexOf(double[] dArr, double d10, int i10) {
        if (isEmpty(dArr)) {
            return -1;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        while (i10 < dArr.length) {
            if (d10 == dArr[i10]) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static boolean isSorted(double[] dArr) {
        if (dArr != null && dArr.length >= 2) {
            double d10 = dArr[0];
            int length = dArr.length;
            int i10 = 1;
            while (i10 < length) {
                double d11 = dArr[i10];
                if (Double.compare(d10, d11) > 0) {
                    return false;
                }
                i10++;
                d10 = d11;
            }
        }
        return true;
    }

    public static int lastIndexOf(byte[] bArr, byte b4) {
        return lastIndexOf(bArr, b4, Integer.MAX_VALUE);
    }

    public static boolean[] nullToEmpty(boolean[] zArr) {
        return isEmpty(zArr) ? EMPTY_BOOLEAN_ARRAY : zArr;
    }

    public static void shuffle(float[] fArr, Random random) {
        for (int length = fArr.length; length > 1; length--) {
            swap(fArr, length - 1, random.nextInt(length), 1);
        }
    }

    public static int[] toPrimitive(Integer[] numArr) {
        if (numArr == null) {
            return null;
        }
        if (numArr.length == 0) {
            return EMPTY_INT_ARRAY;
        }
        int[] iArr = new int[numArr.length];
        for (int i10 = 0; i10 < numArr.length; i10++) {
            iArr[i10] = numArr[i10].intValue();
        }
        return iArr;
    }

    public static int lastIndexOf(byte[] bArr, byte b4, int i10) {
        if (bArr == null || i10 < 0) {
            return -1;
        }
        if (i10 >= bArr.length) {
            i10 = bArr.length - 1;
        }
        while (i10 >= 0) {
            if (b4 == bArr[i10]) {
                return i10;
            }
            i10--;
        }
        return -1;
    }

    public static void shift(char[] cArr, int i10, int i11, int i12) {
        if (cArr != null && i10 < cArr.length - 1 && i11 > 0) {
            if (i10 < 0) {
                i10 = 0;
            }
            if (i11 >= cArr.length) {
                i11 = cArr.length;
            }
            int i13 = i11 - i10;
            if (i13 <= 1) {
                return;
            }
            int i14 = i12 % i13;
            if (i14 < 0) {
                i14 += i13;
            }
            while (i13 > 1 && i14 > 0) {
                int i15 = i13 - i14;
                if (i14 > i15) {
                    swap(cArr, i10, (i13 + i10) - i15, i15);
                    int i16 = i14;
                    i14 -= i15;
                    i13 = i16;
                } else if (i14 < i15) {
                    swap(cArr, i10, i10 + i15, i14);
                    i10 += i14;
                    i13 = i15;
                } else {
                    swap(cArr, i10, i15 + i10, i14);
                    return;
                }
            }
        }
    }

    public static void swap(byte[] bArr, int i10, int i11, int i12) {
        if (bArr == null || bArr.length == 0 || i10 >= bArr.length || i11 >= bArr.length) {
            return;
        }
        int i13 = 0;
        if (i10 < 0) {
            i10 = 0;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        int min = Math.min(Math.min(i12, bArr.length - i10), bArr.length - i11);
        while (i13 < min) {
            byte b4 = bArr[i10];
            bArr[i10] = bArr[i11];
            bArr[i11] = b4;
            i13++;
            i10++;
            i11++;
        }
    }

    public static Long[] nullToEmpty(Long[] lArr) {
        return isEmpty(lArr) ? EMPTY_LONG_OBJECT_ARRAY : lArr;
    }

    public static short[] removeElement(short[] sArr, short s2) {
        int indexOf = indexOf(sArr, s2);
        if (indexOf == -1) {
            return clone(sArr);
        }
        return remove(sArr, indexOf);
    }

    public static void shuffle(double[] dArr) {
        shuffle(dArr, new Random());
    }

    @Deprecated
    public static boolean[] add(boolean[] zArr, int i10, boolean z10) {
        return (boolean[]) add(zArr, i10, Boolean.valueOf(z10), Boolean.TYPE);
    }

    public static int indexOf(double[] dArr, double d10, int i10, double d11) {
        if (isEmpty(dArr)) {
            return -1;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        double d12 = d10 - d11;
        double d13 = d10 + d11;
        while (i10 < dArr.length) {
            if (dArr[i10] >= d12 && dArr[i10] <= d13) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static void reverse(float[] fArr, int i10, int i11) {
        if (fArr == null) {
            return;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        int min = Math.min(fArr.length, i11) - 1;
        while (min > i10) {
            float f10 = fArr[min];
            fArr[min] = fArr[i10];
            fArr[i10] = f10;
            min--;
            i10++;
        }
    }

    public static void shuffle(double[] dArr, Random random) {
        for (int length = dArr.length; length > 1; length--) {
            swap(dArr, length - 1, random.nextInt(length), 1);
        }
    }

    public static Double[] toObject(double[] dArr) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return EMPTY_DOUBLE_OBJECT_ARRAY;
        }
        Double[] dArr2 = new Double[dArr.length];
        for (int i10 = 0; i10 < dArr.length; i10++) {
            dArr2[i10] = Double.valueOf(dArr[i10]);
        }
        return dArr2;
    }

    @Deprecated
    public static char[] add(char[] cArr, int i10, char c4) {
        return (char[]) add(cArr, i10, Character.valueOf(c4), Character.TYPE);
    }

    public static short[] addAll(short[] sArr, short... sArr2) {
        if (sArr == null) {
            return clone(sArr2);
        }
        if (sArr2 == null) {
            return clone(sArr);
        }
        short[] sArr3 = new short[sArr.length + sArr2.length];
        System.arraycopy((Object) sArr, 0, (Object) sArr3, 0, sArr.length);
        System.arraycopy((Object) sArr2, 0, (Object) sArr3, sArr.length, sArr2.length);
        return sArr3;
    }

    public static int lastIndexOf(double[] dArr, double d10) {
        return lastIndexOf(dArr, d10, Integer.MAX_VALUE);
    }

    public static Integer[] nullToEmpty(Integer[] numArr) {
        return isEmpty(numArr) ? EMPTY_INTEGER_OBJECT_ARRAY : numArr;
    }

    public static byte[] subarray(byte[] bArr, int i10, int i11) {
        if (bArr == null) {
            return null;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        if (i11 > bArr.length) {
            i11 = bArr.length;
        }
        int i12 = i11 - i10;
        if (i12 <= 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr2 = new byte[i12];
        System.arraycopy((Object) bArr, i10, (Object) bArr2, 0, i12);
        return bArr2;
    }

    @Deprecated
    public static byte[] add(byte[] bArr, int i10, byte b4) {
        return (byte[]) add(bArr, i10, Byte.valueOf(b4), Byte.TYPE);
    }

    public static double[] insert(int i10, double[] dArr, double... dArr2) {
        if (dArr == null) {
            return null;
        }
        if (dArr2 != null && dArr2.length != 0) {
            if (i10 >= 0 && i10 <= dArr.length) {
                double[] dArr3 = new double[dArr.length + dArr2.length];
                System.arraycopy((Object) dArr2, 0, (Object) dArr3, i10, dArr2.length);
                if (i10 > 0) {
                    System.arraycopy((Object) dArr, 0, (Object) dArr3, 0, i10);
                }
                if (i10 < dArr.length) {
                    System.arraycopy((Object) dArr, i10, (Object) dArr3, dArr2.length + i10, dArr.length - i10);
                }
                return dArr3;
            }
            throw new IndexOutOfBoundsException("Index: " + i10 + ", Length: " + dArr.length);
        }
        return clone(dArr);
    }

    public static boolean isSorted(float[] fArr) {
        if (fArr != null && fArr.length >= 2) {
            float f10 = fArr[0];
            int length = fArr.length;
            int i10 = 1;
            while (i10 < length) {
                float f11 = fArr[i10];
                if (Float.compare(f10, f11) > 0) {
                    return false;
                }
                i10++;
                f10 = f11;
            }
        }
        return true;
    }

    public static int lastIndexOf(double[] dArr, double d10, double d11) {
        return lastIndexOf(dArr, d10, Integer.MAX_VALUE, d11);
    }

    public static int[] toPrimitive(Integer[] numArr, int i10) {
        if (numArr == null) {
            return null;
        }
        if (numArr.length == 0) {
            return EMPTY_INT_ARRAY;
        }
        int[] iArr = new int[numArr.length];
        for (int i11 = 0; i11 < numArr.length; i11++) {
            Integer num = numArr[i11];
            iArr[i11] = num == null ? i10 : num.intValue();
        }
        return iArr;
    }

    @Deprecated
    public static short[] add(short[] sArr, int i10, short s2) {
        return (short[]) add(sArr, i10, Short.valueOf(s2), Short.TYPE);
    }

    public static int indexOf(float[] fArr, float f10) {
        return indexOf(fArr, f10, 0);
    }

    public static int lastIndexOf(double[] dArr, double d10, int i10) {
        if (isEmpty(dArr) || i10 < 0) {
            return -1;
        }
        if (i10 >= dArr.length) {
            i10 = dArr.length - 1;
        }
        while (i10 >= 0) {
            if (d10 == dArr[i10]) {
                return i10;
            }
            i10--;
        }
        return -1;
    }

    public static Short[] nullToEmpty(Short[] shArr) {
        return isEmpty(shArr) ? EMPTY_SHORT_OBJECT_ARRAY : shArr;
    }

    public static int[] removeAllOccurences(int[] iArr, int i10) {
        int indexOf = indexOf(iArr, i10);
        if (indexOf == -1) {
            return clone(iArr);
        }
        int[] iArr2 = new int[iArr.length - indexOf];
        iArr2[0] = indexOf;
        int i11 = 1;
        while (true) {
            int indexOf2 = indexOf(iArr, i10, iArr2[i11 - 1] + 1);
            if (indexOf2 != -1) {
                iArr2[i11] = indexOf2;
                i11++;
            } else {
                return removeAll(iArr, Arrays.copyOf(iArr2, i11));
            }
        }
    }

    public static void swap(char[] cArr, int i10, int i11, int i12) {
        if (cArr == null || cArr.length == 0 || i10 >= cArr.length || i11 >= cArr.length) {
            return;
        }
        int i13 = 0;
        if (i10 < 0) {
            i10 = 0;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        int min = Math.min(Math.min(i12, cArr.length - i10), cArr.length - i11);
        while (i13 < min) {
            char c4 = cArr[i10];
            cArr[i10] = cArr[i11];
            cArr[i11] = c4;
            i13++;
            i10++;
            i11++;
        }
    }

    @Deprecated
    public static int[] add(int[] iArr, int i10, int i11) {
        return (int[]) add(iArr, i10, Integer.valueOf(i11), Integer.TYPE);
    }

    public static int indexOf(float[] fArr, float f10, int i10) {
        if (isEmpty(fArr)) {
            return -1;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        while (i10 < fArr.length) {
            if (f10 == fArr[i10]) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static void reverse(int[] iArr, int i10, int i11) {
        if (iArr == null) {
            return;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        int min = Math.min(iArr.length, i11) - 1;
        while (min > i10) {
            int i12 = iArr[min];
            iArr[min] = iArr[i10];
            iArr[i10] = i12;
            min--;
            i10++;
        }
    }

    @Deprecated
    public static long[] add(long[] jArr, int i10, long j10) {
        return (long[]) add(jArr, i10, Long.valueOf(j10), Long.TYPE);
    }

    public static Character[] nullToEmpty(Character[] chArr) {
        return isEmpty(chArr) ? EMPTY_CHARACTER_OBJECT_ARRAY : chArr;
    }

    public static void shift(double[] dArr, int i10, int i11, int i12) {
        if (dArr != null && i10 < dArr.length - 1 && i11 > 0) {
            if (i10 < 0) {
                i10 = 0;
            }
            if (i11 >= dArr.length) {
                i11 = dArr.length;
            }
            int i13 = i11 - i10;
            if (i13 <= 1) {
                return;
            }
            int i14 = i12 % i13;
            if (i14 < 0) {
                i14 += i13;
            }
            while (i13 > 1 && i14 > 0) {
                int i15 = i13 - i14;
                if (i14 > i15) {
                    swap(dArr, i10, (i13 + i10) - i15, i15);
                    int i16 = i14;
                    i14 -= i15;
                    i13 = i16;
                } else if (i14 < i15) {
                    swap(dArr, i10, i10 + i15, i14);
                    i10 += i14;
                    i13 = i15;
                } else {
                    swap(dArr, i10, i15 + i10, i14);
                    return;
                }
            }
        }
    }

    public static Float[] toObject(float[] fArr) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return EMPTY_FLOAT_OBJECT_ARRAY;
        }
        Float[] fArr2 = new Float[fArr.length];
        for (int i10 = 0; i10 < fArr.length; i10++) {
            fArr2[i10] = Float.valueOf(fArr[i10]);
        }
        return fArr2;
    }

    @Deprecated
    public static float[] add(float[] fArr, int i10, float f10) {
        return (float[]) add(fArr, i10, Float.valueOf(f10), Float.TYPE);
    }

    public static int[] addAll(int[] iArr, int... iArr2) {
        if (iArr == null) {
            return clone(iArr2);
        }
        if (iArr2 == null) {
            return clone(iArr);
        }
        int[] iArr3 = new int[iArr.length + iArr2.length];
        System.arraycopy((Object) iArr, 0, (Object) iArr3, 0, iArr.length);
        System.arraycopy((Object) iArr2, 0, (Object) iArr3, iArr.length, iArr2.length);
        return iArr3;
    }

    public static short[] removeElements(short[] sArr, short... sArr2) {
        if (!isEmpty(sArr) && !isEmpty(sArr2)) {
            HashMap hashMap = new HashMap(sArr2.length);
            for (short s2 : sArr2) {
                Short valueOf = Short.valueOf(s2);
                MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
                if (mutableInt == null) {
                    hashMap.put(valueOf, new MutableInt(1));
                } else {
                    mutableInt.increment();
                }
            }
            BitSet bitSet = new BitSet();
            for (int i10 = 0; i10 < sArr.length; i10++) {
                short s10 = sArr[i10];
                MutableInt mutableInt2 = (MutableInt) hashMap.get(Short.valueOf(s10));
                if (mutableInt2 != null) {
                    if (mutableInt2.decrementAndGet() == 0) {
                        hashMap.remove(Short.valueOf(s10));
                    }
                    bitSet.set(i10);
                }
            }
            return (short[]) removeAll(sArr, bitSet);
        }
        return clone(sArr);
    }

    public static double[] subarray(double[] dArr, int i10, int i11) {
        if (dArr == null) {
            return null;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        if (i11 > dArr.length) {
            i11 = dArr.length;
        }
        int i12 = i11 - i10;
        if (i12 <= 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        double[] dArr2 = new double[i12];
        System.arraycopy((Object) dArr, i10, (Object) dArr2, 0, i12);
        return dArr2;
    }

    @Deprecated
    public static double[] add(double[] dArr, int i10, double d10) {
        return (double[]) add(dArr, i10, Double.valueOf(d10), Double.TYPE);
    }

    public static int indexOf(boolean[] zArr, boolean z10) {
        return indexOf(zArr, z10, 0);
    }

    public static boolean isSorted(byte[] bArr) {
        if (bArr != null && bArr.length >= 2) {
            byte b4 = bArr[0];
            int length = bArr.length;
            int i10 = 1;
            while (i10 < length) {
                byte b10 = bArr[i10];
                if (NumberUtils.compare(b4, b10) > 0) {
                    return false;
                }
                i10++;
                b4 = b10;
            }
        }
        return true;
    }

    public static int lastIndexOf(double[] dArr, double d10, int i10, double d11) {
        if (isEmpty(dArr) || i10 < 0) {
            return -1;
        }
        if (i10 >= dArr.length) {
            i10 = dArr.length - 1;
        }
        double d12 = d10 - d11;
        double d13 = d10 + d11;
        while (i10 >= 0) {
            if (dArr[i10] >= d12 && dArr[i10] <= d13) {
                return i10;
            }
            i10--;
        }
        return -1;
    }

    public static Byte[] nullToEmpty(Byte[] bArr) {
        return isEmpty(bArr) ? EMPTY_BYTE_OBJECT_ARRAY : bArr;
    }

    private static Object add(Object obj, int i10, Object obj2, Class<?> cls) {
        if (obj == null) {
            if (i10 == 0) {
                Object newInstance = Array.newInstance(cls, 1);
                Array.set(newInstance, 0, obj2);
                return newInstance;
            }
            throw new IndexOutOfBoundsException("Index: " + i10 + ", Length: 0");
        }
        int length = Array.getLength(obj);
        if (i10 <= length && i10 >= 0) {
            Object newInstance2 = Array.newInstance(cls, length + 1);
            System.arraycopy(obj, 0, newInstance2, 0, i10);
            Array.set(newInstance2, i10, obj2);
            if (i10 < length) {
                System.arraycopy(obj, i10, newInstance2, i10 + 1, length - i10);
            }
            return newInstance2;
        }
        throw new IndexOutOfBoundsException("Index: " + i10 + ", Length: " + length);
    }

    public static int indexOf(boolean[] zArr, boolean z10, int i10) {
        if (isEmpty(zArr)) {
            return -1;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        while (i10 < zArr.length) {
            if (z10 == zArr[i10]) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static void reverse(long[] jArr, int i10, int i11) {
        if (jArr == null) {
            return;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        int min = Math.min(jArr.length, i11) - 1;
        while (min > i10) {
            long j10 = jArr[min];
            jArr[min] = jArr[i10];
            jArr[i10] = j10;
            min--;
            i10++;
        }
    }

    public static void swap(double[] dArr, int i10, int i11, int i12) {
        if (dArr == null || dArr.length == 0 || i10 >= dArr.length || i11 >= dArr.length) {
            return;
        }
        int i13 = 0;
        if (i10 < 0) {
            i10 = 0;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        int min = Math.min(Math.min(i12, dArr.length - i10), dArr.length - i11);
        while (i13 < min) {
            double d10 = dArr[i10];
            dArr[i10] = dArr[i11];
            dArr[i11] = d10;
            i13++;
            i10++;
            i11++;
        }
    }

    public static short[] toPrimitive(Short[] shArr) {
        if (shArr == null) {
            return null;
        }
        if (shArr.length == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        short[] sArr = new short[shArr.length];
        for (int i10 = 0; i10 < shArr.length; i10++) {
            sArr[i10] = shArr[i10].shortValue();
        }
        return sArr;
    }

    public static Double[] nullToEmpty(Double[] dArr) {
        return isEmpty(dArr) ? EMPTY_DOUBLE_OBJECT_ARRAY : dArr;
    }

    public static long[] removeAllOccurences(long[] jArr, long j10) {
        int indexOf = indexOf(jArr, j10);
        if (indexOf == -1) {
            return clone(jArr);
        }
        int[] iArr = new int[jArr.length - indexOf];
        iArr[0] = indexOf;
        int i10 = 1;
        while (true) {
            int indexOf2 = indexOf(jArr, j10, iArr[i10 - 1] + 1);
            if (indexOf2 != -1) {
                iArr[i10] = indexOf2;
                i10++;
            } else {
                return removeAll(jArr, Arrays.copyOf(iArr, i10));
            }
        }
    }

    public static Boolean[] toObject(boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        if (zArr.length == 0) {
            return EMPTY_BOOLEAN_OBJECT_ARRAY;
        }
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i10 = 0; i10 < zArr.length; i10++) {
            boolArr[i10] = zArr[i10] ? Boolean.TRUE : Boolean.FALSE;
        }
        return boolArr;
    }

    public static long[] addAll(long[] jArr, long... jArr2) {
        if (jArr == null) {
            return clone(jArr2);
        }
        if (jArr2 == null) {
            return clone(jArr);
        }
        long[] jArr3 = new long[jArr.length + jArr2.length];
        System.arraycopy((Object) jArr, 0, (Object) jArr3, 0, jArr.length);
        System.arraycopy((Object) jArr2, 0, (Object) jArr3, jArr.length, jArr2.length);
        return jArr3;
    }

    public static float[] insert(int i10, float[] fArr, float... fArr2) {
        if (fArr == null) {
            return null;
        }
        if (fArr2 != null && fArr2.length != 0) {
            if (i10 >= 0 && i10 <= fArr.length) {
                float[] fArr3 = new float[fArr.length + fArr2.length];
                System.arraycopy((Object) fArr2, 0, (Object) fArr3, i10, fArr2.length);
                if (i10 > 0) {
                    System.arraycopy((Object) fArr, 0, (Object) fArr3, 0, i10);
                }
                if (i10 < fArr.length) {
                    System.arraycopy((Object) fArr, i10, (Object) fArr3, fArr2.length + i10, fArr.length - i10);
                }
                return fArr3;
            }
            throw new IndexOutOfBoundsException("Index: " + i10 + ", Length: " + fArr.length);
        }
        return clone(fArr);
    }

    public static int lastIndexOf(float[] fArr, float f10) {
        return lastIndexOf(fArr, f10, Integer.MAX_VALUE);
    }

    public static Float[] nullToEmpty(Float[] fArr) {
        return isEmpty(fArr) ? EMPTY_FLOAT_OBJECT_ARRAY : fArr;
    }

    public static float[] subarray(float[] fArr, int i10, int i11) {
        if (fArr == null) {
            return null;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        if (i11 > fArr.length) {
            i11 = fArr.length;
        }
        int i12 = i11 - i10;
        if (i12 <= 0) {
            return EMPTY_FLOAT_ARRAY;
        }
        float[] fArr2 = new float[i12];
        System.arraycopy((Object) fArr, i10, (Object) fArr2, 0, i12);
        return fArr2;
    }

    public static boolean isSorted(char[] cArr) {
        if (cArr != null && cArr.length >= 2) {
            char c4 = cArr[0];
            int length = cArr.length;
            int i10 = 1;
            while (i10 < length) {
                char c10 = cArr[i10];
                if (CharUtils.compare(c4, c10) > 0) {
                    return false;
                }
                i10++;
                c4 = c10;
            }
        }
        return true;
    }

    public static int lastIndexOf(float[] fArr, float f10, int i10) {
        if (isEmpty(fArr) || i10 < 0) {
            return -1;
        }
        if (i10 >= fArr.length) {
            i10 = fArr.length - 1;
        }
        while (i10 >= 0) {
            if (f10 == fArr[i10]) {
                return i10;
            }
            i10--;
        }
        return -1;
    }

    public static void reverse(Object[] objArr, int i10, int i11) {
        if (objArr == null) {
            return;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        int min = Math.min(objArr.length, i11) - 1;
        while (min > i10) {
            Object obj = objArr[min];
            objArr[min] = objArr[i10];
            objArr[i10] = obj;
            min--;
            i10++;
        }
    }

    public static void shift(float[] fArr, int i10, int i11, int i12) {
        if (fArr != null && i10 < fArr.length - 1 && i11 > 0) {
            if (i10 < 0) {
                i10 = 0;
            }
            if (i11 >= fArr.length) {
                i11 = fArr.length;
            }
            int i13 = i11 - i10;
            if (i13 <= 1) {
                return;
            }
            int i14 = i12 % i13;
            if (i14 < 0) {
                i14 += i13;
            }
            while (i13 > 1 && i14 > 0) {
                int i15 = i13 - i14;
                if (i14 > i15) {
                    swap(fArr, i10, (i13 + i10) - i15, i15);
                    int i16 = i14;
                    i14 -= i15;
                    i13 = i16;
                } else if (i14 < i15) {
                    swap(fArr, i10, i10 + i15, i14);
                    i10 += i14;
                    i13 = i15;
                } else {
                    swap(fArr, i10, i15 + i10, i14);
                    return;
                }
            }
        }
    }

    public static Boolean[] nullToEmpty(Boolean[] boolArr) {
        return isEmpty(boolArr) ? EMPTY_BOOLEAN_OBJECT_ARRAY : boolArr;
    }

    public static void swap(float[] fArr, int i10, int i11, int i12) {
        if (fArr == null || fArr.length == 0 || i10 >= fArr.length || i11 >= fArr.length) {
            return;
        }
        int i13 = 0;
        if (i10 < 0) {
            i10 = 0;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        int min = Math.min(Math.min(i12, fArr.length - i10), fArr.length - i11);
        while (i13 < min) {
            float f10 = fArr[i10];
            fArr[i10] = fArr[i11];
            fArr[i11] = f10;
            i13++;
            i10++;
            i11++;
        }
    }

    public static short[] toPrimitive(Short[] shArr, short s2) {
        if (shArr == null) {
            return null;
        }
        if (shArr.length == 0) {
            return EMPTY_SHORT_ARRAY;
        }
        short[] sArr = new short[shArr.length];
        for (int i10 = 0; i10 < shArr.length; i10++) {
            Short sh = shArr[i10];
            sArr[i10] = sh == null ? s2 : sh.shortValue();
        }
        return sArr;
    }

    public static float[] addAll(float[] fArr, float... fArr2) {
        if (fArr == null) {
            return clone(fArr2);
        }
        if (fArr2 == null) {
            return clone(fArr);
        }
        float[] fArr3 = new float[fArr.length + fArr2.length];
        System.arraycopy((Object) fArr, 0, (Object) fArr3, 0, fArr.length);
        System.arraycopy((Object) fArr2, 0, (Object) fArr3, fArr.length, fArr2.length);
        return fArr3;
    }

    public static int lastIndexOf(boolean[] zArr, boolean z10) {
        return lastIndexOf(zArr, z10, Integer.MAX_VALUE);
    }

    public static void reverse(short[] sArr, int i10, int i11) {
        if (sArr == null) {
            return;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        int min = Math.min(sArr.length, i11) - 1;
        while (min > i10) {
            short s2 = sArr[min];
            sArr[min] = sArr[i10];
            sArr[i10] = s2;
            min--;
            i10++;
        }
    }

    public static boolean[] subarray(boolean[] zArr, int i10, int i11) {
        if (zArr == null) {
            return null;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        if (i11 > zArr.length) {
            i11 = zArr.length;
        }
        int i12 = i11 - i10;
        if (i12 <= 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        boolean[] zArr2 = new boolean[i12];
        System.arraycopy((Object) zArr, i10, (Object) zArr2, 0, i12);
        return zArr2;
    }

    public static boolean isSorted(boolean[] zArr) {
        if (zArr != null && zArr.length >= 2) {
            boolean z10 = zArr[0];
            int length = zArr.length;
            int i10 = 1;
            while (i10 < length) {
                boolean z11 = zArr[i10];
                if (BooleanUtils.compare(z10, z11) > 0) {
                    return false;
                }
                i10++;
                z10 = z11;
            }
        }
        return true;
    }

    public static int lastIndexOf(boolean[] zArr, boolean z10, int i10) {
        if (isEmpty(zArr) || i10 < 0) {
            return -1;
        }
        if (i10 >= zArr.length) {
            i10 = zArr.length - 1;
        }
        while (i10 >= 0) {
            if (z10 == zArr[i10]) {
                return i10;
            }
            i10--;
        }
        return -1;
    }

    public static float[] removeAllOccurences(float[] fArr, float f10) {
        int indexOf = indexOf(fArr, f10);
        if (indexOf == -1) {
            return clone(fArr);
        }
        int[] iArr = new int[fArr.length - indexOf];
        iArr[0] = indexOf;
        int i10 = 1;
        while (true) {
            int indexOf2 = indexOf(fArr, f10, iArr[i10 - 1] + 1);
            if (indexOf2 != -1) {
                iArr[i10] = indexOf2;
                i10++;
            } else {
                return removeAll(fArr, Arrays.copyOf(iArr, i10));
            }
        }
    }

    public static void swap(int[] iArr, int i10, int i11, int i12) {
        if (iArr == null || iArr.length == 0 || i10 >= iArr.length || i11 >= iArr.length) {
            return;
        }
        int i13 = 0;
        if (i10 < 0) {
            i10 = 0;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        int min = Math.min(Math.min(i12, iArr.length - i10), iArr.length - i11);
        while (i13 < min) {
            int i14 = iArr[i10];
            iArr[i10] = iArr[i11];
            iArr[i11] = i14;
            i13++;
            i10++;
            i11++;
        }
    }

    public static void shift(int[] iArr, int i10, int i11, int i12) {
        if (iArr != null && i10 < iArr.length - 1 && i11 > 0) {
            if (i10 < 0) {
                i10 = 0;
            }
            if (i11 >= iArr.length) {
                i11 = iArr.length;
            }
            int i13 = i11 - i10;
            if (i13 <= 1) {
                return;
            }
            int i14 = i12 % i13;
            if (i14 < 0) {
                i14 += i13;
            }
            while (i13 > 1 && i14 > 0) {
                int i15 = i13 - i14;
                if (i14 > i15) {
                    swap(iArr, i10, (i13 + i10) - i15, i15);
                    int i16 = i14;
                    i14 -= i15;
                    i13 = i16;
                } else if (i14 < i15) {
                    swap(iArr, i10, i10 + i15, i14);
                    i10 += i14;
                    i13 = i15;
                } else {
                    swap(iArr, i10, i15 + i10, i14);
                    return;
                }
            }
        }
    }

    public static byte[] toPrimitive(Byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            bArr2[i10] = bArr[i10].byteValue();
        }
        return bArr2;
    }

    public static int[] insert(int i10, int[] iArr, int... iArr2) {
        if (iArr == null) {
            return null;
        }
        if (iArr2 != null && iArr2.length != 0) {
            if (i10 >= 0 && i10 <= iArr.length) {
                int[] iArr3 = new int[iArr.length + iArr2.length];
                System.arraycopy((Object) iArr2, 0, (Object) iArr3, i10, iArr2.length);
                if (i10 > 0) {
                    System.arraycopy((Object) iArr, 0, (Object) iArr3, 0, i10);
                }
                if (i10 < iArr.length) {
                    System.arraycopy((Object) iArr, i10, (Object) iArr3, iArr2.length + i10, iArr.length - i10);
                }
                return iArr3;
            }
            throw new IndexOutOfBoundsException("Index: " + i10 + ", Length: " + iArr.length);
        }
        return clone(iArr);
    }

    public static double[] addAll(double[] dArr, double... dArr2) {
        if (dArr == null) {
            return clone(dArr2);
        }
        if (dArr2 == null) {
            return clone(dArr);
        }
        double[] dArr3 = new double[dArr.length + dArr2.length];
        System.arraycopy((Object) dArr, 0, (Object) dArr3, 0, dArr.length);
        System.arraycopy((Object) dArr2, 0, (Object) dArr3, dArr.length, dArr2.length);
        return dArr3;
    }

    public static int[] removeElements(int[] iArr, int... iArr2) {
        if (!isEmpty(iArr) && !isEmpty(iArr2)) {
            HashMap hashMap = new HashMap(iArr2.length);
            for (int i10 : iArr2) {
                Integer valueOf = Integer.valueOf(i10);
                MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
                if (mutableInt == null) {
                    hashMap.put(valueOf, new MutableInt(1));
                } else {
                    mutableInt.increment();
                }
            }
            BitSet bitSet = new BitSet();
            for (int i11 = 0; i11 < iArr.length; i11++) {
                int i12 = iArr[i11];
                MutableInt mutableInt2 = (MutableInt) hashMap.get(Integer.valueOf(i12));
                if (mutableInt2 != null) {
                    if (mutableInt2.decrementAndGet() == 0) {
                        hashMap.remove(Integer.valueOf(i12));
                    }
                    bitSet.set(i11);
                }
            }
            return (int[]) removeAll(iArr, bitSet);
        }
        return clone(iArr);
    }

    public static void swap(long[] jArr, int i10, int i11, int i12) {
        if (jArr == null || jArr.length == 0 || i10 >= jArr.length || i11 >= jArr.length) {
            return;
        }
        int i13 = 0;
        if (i10 < 0) {
            i10 = 0;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        int min = Math.min(Math.min(i12, jArr.length - i10), jArr.length - i11);
        while (i13 < min) {
            long j10 = jArr[i10];
            jArr[i10] = jArr[i11];
            jArr[i11] = j10;
            i13++;
            i10++;
            i11++;
        }
    }

    public static double[] removeAllOccurences(double[] dArr, double d10) {
        int indexOf = indexOf(dArr, d10);
        if (indexOf == -1) {
            return clone(dArr);
        }
        int[] iArr = new int[dArr.length - indexOf];
        iArr[0] = indexOf;
        int i10 = 1;
        while (true) {
            int indexOf2 = indexOf(dArr, d10, iArr[i10 - 1] + 1);
            if (indexOf2 != -1) {
                iArr[i10] = indexOf2;
                i10++;
            } else {
                return removeAll(dArr, Arrays.copyOf(iArr, i10));
            }
        }
    }

    public static byte[] toPrimitive(Byte[] bArr, byte b4) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i10 = 0; i10 < bArr.length; i10++) {
            Byte b10 = bArr[i10];
            bArr2[i10] = b10 == null ? b4 : b10.byteValue();
        }
        return bArr2;
    }

    public static void shift(long[] jArr, int i10, int i11, int i12) {
        if (jArr != null && i10 < jArr.length - 1 && i11 > 0) {
            if (i10 < 0) {
                i10 = 0;
            }
            if (i11 >= jArr.length) {
                i11 = jArr.length;
            }
            int i13 = i11 - i10;
            if (i13 <= 1) {
                return;
            }
            int i14 = i12 % i13;
            if (i14 < 0) {
                i14 += i13;
            }
            while (i13 > 1 && i14 > 0) {
                int i15 = i13 - i14;
                if (i14 > i15) {
                    swap(jArr, i10, (i13 + i10) - i15, i15);
                    int i16 = i14;
                    i14 -= i15;
                    i13 = i16;
                } else if (i14 < i15) {
                    swap(jArr, i10, i10 + i15, i14);
                    i10 += i14;
                    i13 = i15;
                } else {
                    swap(jArr, i10, i15 + i10, i14);
                    return;
                }
            }
        }
    }

    public static void swap(Object[] objArr, int i10, int i11, int i12) {
        if (objArr == null || objArr.length == 0 || i10 >= objArr.length || i11 >= objArr.length) {
            return;
        }
        int i13 = 0;
        if (i10 < 0) {
            i10 = 0;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        int min = Math.min(Math.min(i12, objArr.length - i10), objArr.length - i11);
        while (i13 < min) {
            Object obj = objArr[i10];
            objArr[i10] = objArr[i11];
            objArr[i11] = obj;
            i13++;
            i10++;
            i11++;
        }
    }

    public static long[] insert(int i10, long[] jArr, long... jArr2) {
        if (jArr == null) {
            return null;
        }
        if (jArr2 != null && jArr2.length != 0) {
            if (i10 >= 0 && i10 <= jArr.length) {
                long[] jArr3 = new long[jArr.length + jArr2.length];
                System.arraycopy((Object) jArr2, 0, (Object) jArr3, i10, jArr2.length);
                if (i10 > 0) {
                    System.arraycopy((Object) jArr, 0, (Object) jArr3, 0, i10);
                }
                if (i10 < jArr.length) {
                    System.arraycopy((Object) jArr, i10, (Object) jArr3, jArr2.length + i10, jArr.length - i10);
                }
                return jArr3;
            }
            throw new IndexOutOfBoundsException("Index: " + i10 + ", Length: " + jArr.length);
        }
        return clone(jArr);
    }

    public static double[] toPrimitive(Double[] dArr) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        double[] dArr2 = new double[dArr.length];
        for (int i10 = 0; i10 < dArr.length; i10++) {
            dArr2[i10] = dArr[i10].doubleValue();
        }
        return dArr2;
    }

    public static <T> T[] removeAllOccurences(T[] tArr, T t2) {
        int indexOf = indexOf(tArr, t2);
        if (indexOf == -1) {
            return (T[]) clone(tArr);
        }
        int[] iArr = new int[tArr.length - indexOf];
        iArr[0] = indexOf;
        int i10 = 1;
        while (true) {
            int indexOf2 = indexOf(tArr, t2, iArr[i10 - 1] + 1);
            if (indexOf2 != -1) {
                iArr[i10] = indexOf2;
                i10++;
            } else {
                return (T[]) removeAll((Object[]) tArr, Arrays.copyOf(iArr, i10));
            }
        }
    }

    public static void shift(Object[] objArr, int i10, int i11, int i12) {
        if (objArr != null && i10 < objArr.length - 1 && i11 > 0) {
            if (i10 < 0) {
                i10 = 0;
            }
            if (i11 >= objArr.length) {
                i11 = objArr.length;
            }
            int i13 = i11 - i10;
            if (i13 <= 1) {
                return;
            }
            int i14 = i12 % i13;
            if (i14 < 0) {
                i14 += i13;
            }
            while (i13 > 1 && i14 > 0) {
                int i15 = i13 - i14;
                if (i14 > i15) {
                    swap(objArr, i10, (i13 + i10) - i15, i15);
                    int i16 = i14;
                    i14 -= i15;
                    i13 = i16;
                } else if (i14 < i15) {
                    swap(objArr, i10, i10 + i15, i14);
                    i10 += i14;
                    i13 = i15;
                } else {
                    swap(objArr, i10, i15 + i10, i14);
                    return;
                }
            }
        }
    }

    public static void swap(short[] sArr, int i10, int i11, int i12) {
        if (sArr == null || sArr.length == 0 || i10 >= sArr.length || i11 >= sArr.length) {
            return;
        }
        int i13 = 0;
        if (i10 < 0) {
            i10 = 0;
        }
        if (i11 < 0) {
            i11 = 0;
        }
        if (i10 == i11) {
            return;
        }
        int min = Math.min(Math.min(i12, sArr.length - i10), sArr.length - i11);
        while (i13 < min) {
            short s2 = sArr[i10];
            sArr[i10] = sArr[i11];
            sArr[i11] = s2;
            i13++;
            i10++;
            i11++;
        }
    }

    public static double[] toPrimitive(Double[] dArr, double d10) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return EMPTY_DOUBLE_ARRAY;
        }
        double[] dArr2 = new double[dArr.length];
        for (int i10 = 0; i10 < dArr.length; i10++) {
            Double d11 = dArr[i10];
            dArr2[i10] = d11 == null ? d10 : d11.doubleValue();
        }
        return dArr2;
    }

    public static short[] insert(int i10, short[] sArr, short... sArr2) {
        if (sArr == null) {
            return null;
        }
        if (sArr2 != null && sArr2.length != 0) {
            if (i10 >= 0 && i10 <= sArr.length) {
                short[] sArr3 = new short[sArr.length + sArr2.length];
                System.arraycopy((Object) sArr2, 0, (Object) sArr3, i10, sArr2.length);
                if (i10 > 0) {
                    System.arraycopy((Object) sArr, 0, (Object) sArr3, 0, i10);
                }
                if (i10 < sArr.length) {
                    System.arraycopy((Object) sArr, i10, (Object) sArr3, sArr2.length + i10, sArr.length - i10);
                }
                return sArr3;
            }
            throw new IndexOutOfBoundsException("Index: " + i10 + ", Length: " + sArr.length);
        }
        return clone(sArr);
    }

    public static char[] removeElements(char[] cArr, char... cArr2) {
        if (!isEmpty(cArr) && !isEmpty(cArr2)) {
            HashMap hashMap = new HashMap(cArr2.length);
            for (char c4 : cArr2) {
                Character valueOf = Character.valueOf(c4);
                MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
                if (mutableInt == null) {
                    hashMap.put(valueOf, new MutableInt(1));
                } else {
                    mutableInt.increment();
                }
            }
            BitSet bitSet = new BitSet();
            for (int i10 = 0; i10 < cArr.length; i10++) {
                char c10 = cArr[i10];
                MutableInt mutableInt2 = (MutableInt) hashMap.get(Character.valueOf(c10));
                if (mutableInt2 != null) {
                    if (mutableInt2.decrementAndGet() == 0) {
                        hashMap.remove(Character.valueOf(c10));
                    }
                    bitSet.set(i10);
                }
            }
            return (char[]) removeAll(cArr, bitSet);
        }
        return clone(cArr);
    }

    public static void shift(short[] sArr, int i10, int i11, int i12) {
        if (sArr != null && i10 < sArr.length - 1 && i11 > 0) {
            if (i10 < 0) {
                i10 = 0;
            }
            if (i11 >= sArr.length) {
                i11 = sArr.length;
            }
            int i13 = i11 - i10;
            if (i13 <= 1) {
                return;
            }
            int i14 = i12 % i13;
            if (i14 < 0) {
                i14 += i13;
            }
            while (i13 > 1 && i14 > 0) {
                int i15 = i13 - i14;
                if (i14 > i15) {
                    swap(sArr, i10, (i13 + i10) - i15, i15);
                    int i16 = i14;
                    i14 -= i15;
                    i13 = i16;
                } else if (i14 < i15) {
                    swap(sArr, i10, i10 + i15, i14);
                    i10 += i14;
                    i13 = i15;
                } else {
                    swap(sArr, i10, i15 + i10, i14);
                    return;
                }
            }
        }
    }

    public static float[] toPrimitive(Float[] fArr) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return EMPTY_FLOAT_ARRAY;
        }
        float[] fArr2 = new float[fArr.length];
        for (int i10 = 0; i10 < fArr.length; i10++) {
            fArr2[i10] = fArr[i10].floatValue();
        }
        return fArr2;
    }

    public static float[] toPrimitive(Float[] fArr, float f10) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return EMPTY_FLOAT_ARRAY;
        }
        float[] fArr2 = new float[fArr.length];
        for (int i10 = 0; i10 < fArr.length; i10++) {
            Float f11 = fArr[i10];
            fArr2[i10] = f11 == null ? f10 : f11.floatValue();
        }
        return fArr2;
    }

    @SafeVarargs
    public static <T> T[] insert(int i10, T[] tArr, T... tArr2) {
        if (tArr == null) {
            return null;
        }
        if (tArr2 != null && tArr2.length != 0) {
            if (i10 >= 0 && i10 <= tArr.length) {
                T[] tArr3 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), tArr.length + tArr2.length));
                System.arraycopy(tArr2, 0, tArr3, i10, tArr2.length);
                if (i10 > 0) {
                    System.arraycopy(tArr, 0, tArr3, 0, i10);
                }
                if (i10 < tArr.length) {
                    System.arraycopy(tArr, i10, tArr3, tArr2.length + i10, tArr.length - i10);
                }
                return tArr3;
            }
            throw new IndexOutOfBoundsException("Index: " + i10 + ", Length: " + tArr.length);
        }
        return (T[]) clone(tArr);
    }

    public static Object toPrimitive(Object obj) {
        if (obj == null) {
            return null;
        }
        Class<?> wrapperToPrimitive = ClassUtils.wrapperToPrimitive(obj.getClass().getComponentType());
        if (Integer.TYPE.equals(wrapperToPrimitive)) {
            return toPrimitive((Integer[]) obj);
        }
        if (Long.TYPE.equals(wrapperToPrimitive)) {
            return toPrimitive((Long[]) obj);
        }
        if (Short.TYPE.equals(wrapperToPrimitive)) {
            return toPrimitive((Short[]) obj);
        }
        if (Double.TYPE.equals(wrapperToPrimitive)) {
            return toPrimitive((Double[]) obj);
        }
        return Float.TYPE.equals(wrapperToPrimitive) ? toPrimitive((Float[]) obj) : obj;
    }

    public static long[] removeElements(long[] jArr, long... jArr2) {
        if (!isEmpty(jArr) && !isEmpty(jArr2)) {
            HashMap hashMap = new HashMap(jArr2.length);
            for (long j10 : jArr2) {
                Long valueOf = Long.valueOf(j10);
                MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
                if (mutableInt == null) {
                    hashMap.put(valueOf, new MutableInt(1));
                } else {
                    mutableInt.increment();
                }
            }
            BitSet bitSet = new BitSet();
            for (int i10 = 0; i10 < jArr.length; i10++) {
                long j11 = jArr[i10];
                MutableInt mutableInt2 = (MutableInt) hashMap.get(Long.valueOf(j11));
                if (mutableInt2 != null) {
                    if (mutableInt2.decrementAndGet() == 0) {
                        hashMap.remove(Long.valueOf(j11));
                    }
                    bitSet.set(i10);
                }
            }
            return (long[]) removeAll(jArr, bitSet);
        }
        return clone(jArr);
    }

    public static boolean[] toPrimitive(Boolean[] boolArr) {
        if (boolArr == null) {
            return null;
        }
        if (boolArr.length == 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        boolean[] zArr = new boolean[boolArr.length];
        for (int i10 = 0; i10 < boolArr.length; i10++) {
            zArr[i10] = boolArr[i10].booleanValue();
        }
        return zArr;
    }

    public static boolean[] toPrimitive(Boolean[] boolArr, boolean z10) {
        if (boolArr == null) {
            return null;
        }
        if (boolArr.length == 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        boolean[] zArr = new boolean[boolArr.length];
        for (int i10 = 0; i10 < boolArr.length; i10++) {
            Boolean bool = boolArr[i10];
            zArr[i10] = bool == null ? z10 : bool.booleanValue();
        }
        return zArr;
    }

    public static float[] removeElements(float[] fArr, float... fArr2) {
        if (!isEmpty(fArr) && !isEmpty(fArr2)) {
            HashMap hashMap = new HashMap(fArr2.length);
            for (float f10 : fArr2) {
                Float valueOf = Float.valueOf(f10);
                MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
                if (mutableInt == null) {
                    hashMap.put(valueOf, new MutableInt(1));
                } else {
                    mutableInt.increment();
                }
            }
            BitSet bitSet = new BitSet();
            for (int i10 = 0; i10 < fArr.length; i10++) {
                float f11 = fArr[i10];
                MutableInt mutableInt2 = (MutableInt) hashMap.get(Float.valueOf(f11));
                if (mutableInt2 != null) {
                    if (mutableInt2.decrementAndGet() == 0) {
                        hashMap.remove(Float.valueOf(f11));
                    }
                    bitSet.set(i10);
                }
            }
            return (float[]) removeAll(fArr, bitSet);
        }
        return clone(fArr);
    }

    public static double[] removeElements(double[] dArr, double... dArr2) {
        if (!isEmpty(dArr) && !isEmpty(dArr2)) {
            HashMap hashMap = new HashMap(dArr2.length);
            for (double d10 : dArr2) {
                Double valueOf = Double.valueOf(d10);
                MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
                if (mutableInt == null) {
                    hashMap.put(valueOf, new MutableInt(1));
                } else {
                    mutableInt.increment();
                }
            }
            BitSet bitSet = new BitSet();
            for (int i10 = 0; i10 < dArr.length; i10++) {
                double d11 = dArr[i10];
                MutableInt mutableInt2 = (MutableInt) hashMap.get(Double.valueOf(d11));
                if (mutableInt2 != null) {
                    if (mutableInt2.decrementAndGet() == 0) {
                        hashMap.remove(Double.valueOf(d11));
                    }
                    bitSet.set(i10);
                }
            }
            return (double[]) removeAll(dArr, bitSet);
        }
        return clone(dArr);
    }

    public static boolean[] removeElements(boolean[] zArr, boolean... zArr2) {
        if (!isEmpty(zArr) && !isEmpty(zArr2)) {
            HashMap hashMap = new HashMap(2);
            for (boolean z10 : zArr2) {
                Boolean valueOf = Boolean.valueOf(z10);
                MutableInt mutableInt = (MutableInt) hashMap.get(valueOf);
                if (mutableInt == null) {
                    hashMap.put(valueOf, new MutableInt(1));
                } else {
                    mutableInt.increment();
                }
            }
            BitSet bitSet = new BitSet();
            for (int i10 = 0; i10 < zArr.length; i10++) {
                boolean z11 = zArr[i10];
                MutableInt mutableInt2 = (MutableInt) hashMap.get(Boolean.valueOf(z11));
                if (mutableInt2 != null) {
                    if (mutableInt2.decrementAndGet() == 0) {
                        hashMap.remove(Boolean.valueOf(z11));
                    }
                    bitSet.set(i10);
                }
            }
            return (boolean[]) removeAll(zArr, bitSet);
        }
        return clone(zArr);
    }
}
