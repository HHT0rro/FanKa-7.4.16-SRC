package org.apache.commons.lang3;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class Validate {
    private static final String DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE = "The value %s is not in the specified exclusive range of %s to %s";
    private static final String DEFAULT_FINITE_EX_MESSAGE = "The value is invalid: %f";
    private static final String DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE = "The value %s is not in the specified inclusive range of %s to %s";
    private static final String DEFAULT_IS_ASSIGNABLE_EX_MESSAGE = "Cannot assign a %s to a %s";
    private static final String DEFAULT_IS_INSTANCE_OF_EX_MESSAGE = "Expected type: %s, actual: %s";
    private static final String DEFAULT_IS_NULL_EX_MESSAGE = "The validated object is null";
    private static final String DEFAULT_IS_TRUE_EX_MESSAGE = "The validated expression is false";
    private static final String DEFAULT_MATCHES_PATTERN_EX = "The string %s does not match the pattern %s";
    private static final String DEFAULT_NOT_BLANK_EX_MESSAGE = "The validated character sequence is blank";
    private static final String DEFAULT_NOT_EMPTY_ARRAY_EX_MESSAGE = "The validated array is empty";
    private static final String DEFAULT_NOT_EMPTY_CHAR_SEQUENCE_EX_MESSAGE = "The validated character sequence is empty";
    private static final String DEFAULT_NOT_EMPTY_COLLECTION_EX_MESSAGE = "The validated collection is empty";
    private static final String DEFAULT_NOT_EMPTY_MAP_EX_MESSAGE = "The validated map is empty";
    private static final String DEFAULT_NOT_NAN_EX_MESSAGE = "The validated value is not a number";
    private static final String DEFAULT_NO_NULL_ELEMENTS_ARRAY_EX_MESSAGE = "The validated array contains null element at index: %d";
    private static final String DEFAULT_NO_NULL_ELEMENTS_COLLECTION_EX_MESSAGE = "The validated collection contains null element at index: %d";
    private static final String DEFAULT_VALID_INDEX_ARRAY_EX_MESSAGE = "The validated array index is invalid: %d";
    private static final String DEFAULT_VALID_INDEX_CHAR_SEQUENCE_EX_MESSAGE = "The validated character sequence index is invalid: %d";
    private static final String DEFAULT_VALID_INDEX_COLLECTION_EX_MESSAGE = "The validated collection index is invalid: %d";
    private static final String DEFAULT_VALID_STATE_EX_MESSAGE = "The validated state is false";

    public static <T> void exclusiveBetween(T t2, T t10, Comparable<T> comparable) {
        if (comparable.compareTo(t2) <= 0 || comparable.compareTo(t10) >= 0) {
            throw new IllegalArgumentException(String.format(DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE, comparable, t2, t10));
        }
    }

    public static void finite(double d10) {
        finite(d10, DEFAULT_FINITE_EX_MESSAGE, Double.valueOf(d10));
    }

    public static <T> void inclusiveBetween(T t2, T t10, Comparable<T> comparable) {
        if (comparable.compareTo(t2) < 0 || comparable.compareTo(t10) > 0) {
            throw new IllegalArgumentException(String.format(DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE, comparable, t2, t10));
        }
    }

    public static void isAssignableFrom(Class<?> cls, Class<?> cls2) {
        if (cls.isAssignableFrom(cls2)) {
            return;
        }
        Object[] objArr = new Object[2];
        objArr[0] = cls2 == null ? "null" : cls2.getName();
        objArr[1] = cls.getName();
        throw new IllegalArgumentException(String.format(DEFAULT_IS_ASSIGNABLE_EX_MESSAGE, objArr));
    }

    public static void isInstanceOf(Class<?> cls, Object obj) {
        if (cls.isInstance(obj)) {
            return;
        }
        Object[] objArr = new Object[2];
        objArr[0] = cls.getName();
        objArr[1] = obj == null ? "null" : obj.getClass().getName();
        throw new IllegalArgumentException(String.format(DEFAULT_IS_INSTANCE_OF_EX_MESSAGE, objArr));
    }

    public static void isTrue(boolean z10, String str, long j10) {
        if (!z10) {
            throw new IllegalArgumentException(String.format(str, Long.valueOf(j10)));
        }
    }

    public static void matchesPattern(CharSequence charSequence, String str) {
        if (!Pattern.matches(str, charSequence)) {
            throw new IllegalArgumentException(String.format(DEFAULT_MATCHES_PATTERN_EX, charSequence, str));
        }
    }

    public static <T> T[] noNullElements(T[] tArr, String str, Object... objArr) {
        notNull(tArr);
        for (int i10 = 0; i10 < tArr.length; i10++) {
            if (tArr[i10] == null) {
                throw new IllegalArgumentException(String.format(str, ArrayUtils.add((Integer[]) objArr, Integer.valueOf(i10))));
            }
        }
        return tArr;
    }

    public static <T extends CharSequence> T notBlank(T t2, String str, Object... objArr) {
        if (t2 != null) {
            if (StringUtils.isBlank(t2)) {
                throw new IllegalArgumentException(String.format(str, objArr));
            }
            return t2;
        }
        throw new NullPointerException(String.format(str, objArr));
    }

    public static <T> T[] notEmpty(T[] tArr, String str, Object... objArr) {
        if (tArr != null) {
            if (tArr.length != 0) {
                return tArr;
            }
            throw new IllegalArgumentException(String.format(str, objArr));
        }
        throw new NullPointerException(String.format(str, objArr));
    }

    public static void notNaN(double d10) {
        notNaN(d10, DEFAULT_NOT_NAN_EX_MESSAGE, new Object[0]);
    }

    public static <T> T notNull(T t2) {
        return (T) notNull(t2, DEFAULT_IS_NULL_EX_MESSAGE, new Object[0]);
    }

    public static <T> T[] validIndex(T[] tArr, int i10, String str, Object... objArr) {
        notNull(tArr);
        if (i10 < 0 || i10 >= tArr.length) {
            throw new IndexOutOfBoundsException(String.format(str, objArr));
        }
        return tArr;
    }

    public static void validState(boolean z10) {
        if (!z10) {
            throw new IllegalStateException(DEFAULT_VALID_STATE_EX_MESSAGE);
        }
    }

    public static void finite(double d10, String str, Object... objArr) {
        if (Double.isNaN(d10) || Double.isInfinite(d10)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void isTrue(boolean z10, String str, double d10) {
        if (!z10) {
            throw new IllegalArgumentException(String.format(str, Double.valueOf(d10)));
        }
    }

    public static void notNaN(double d10, String str, Object... objArr) {
        if (Double.isNaN(d10)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T> T notNull(T t2, String str, Object... objArr) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(String.format(str, objArr));
    }

    public static void validState(boolean z10, String str, Object... objArr) {
        if (!z10) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    public static <T> void exclusiveBetween(T t2, T t10, Comparable<T> comparable, String str, Object... objArr) {
        if (comparable.compareTo(t2) <= 0 || comparable.compareTo(t10) >= 0) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T> void inclusiveBetween(T t2, T t10, Comparable<T> comparable, String str, Object... objArr) {
        if (comparable.compareTo(t2) < 0 || comparable.compareTo(t10) > 0) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void isTrue(boolean z10, String str, Object... objArr) {
        if (!z10) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void matchesPattern(CharSequence charSequence, String str, String str2, Object... objArr) {
        if (!Pattern.matches(str, charSequence)) {
            throw new IllegalArgumentException(String.format(str2, objArr));
        }
    }

    public static void isTrue(boolean z10) {
        if (!z10) {
            throw new IllegalArgumentException(DEFAULT_IS_TRUE_EX_MESSAGE);
        }
    }

    public static <T extends CharSequence> T notBlank(T t2) {
        return (T) notBlank(t2, DEFAULT_NOT_BLANK_EX_MESSAGE, new Object[0]);
    }

    public static <T> T[] notEmpty(T[] tArr) {
        return (T[]) notEmpty(tArr, DEFAULT_NOT_EMPTY_ARRAY_EX_MESSAGE, new Object[0]);
    }

    public static <T> T[] validIndex(T[] tArr, int i10) {
        return (T[]) validIndex(tArr, i10, DEFAULT_VALID_INDEX_ARRAY_EX_MESSAGE, Integer.valueOf(i10));
    }

    public static void exclusiveBetween(long j10, long j11, long j12) {
        if (j12 <= j10 || j12 >= j11) {
            throw new IllegalArgumentException(String.format(DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE, Long.valueOf(j12), Long.valueOf(j10), Long.valueOf(j11)));
        }
    }

    public static void inclusiveBetween(long j10, long j11, long j12) {
        if (j12 < j10 || j12 > j11) {
            throw new IllegalArgumentException(String.format(DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE, Long.valueOf(j12), Long.valueOf(j10), Long.valueOf(j11)));
        }
    }

    public static void isAssignableFrom(Class<?> cls, Class<?> cls2, String str, Object... objArr) {
        if (!cls.isAssignableFrom(cls2)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void isInstanceOf(Class<?> cls, Object obj, String str, Object... objArr) {
        if (!cls.isInstance(obj)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T extends Collection<?>> T notEmpty(T t2, String str, Object... objArr) {
        if (t2 != null) {
            if (t2.isEmpty()) {
                throw new IllegalArgumentException(String.format(str, objArr));
            }
            return t2;
        }
        throw new NullPointerException(String.format(str, objArr));
    }

    public static <T extends Collection<?>> T validIndex(T t2, int i10, String str, Object... objArr) {
        notNull(t2);
        if (i10 < 0 || i10 >= t2.size()) {
            throw new IndexOutOfBoundsException(String.format(str, objArr));
        }
        return t2;
    }

    public static void exclusiveBetween(long j10, long j11, long j12, String str) {
        if (j12 <= j10 || j12 >= j11) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void inclusiveBetween(long j10, long j11, long j12, String str) {
        if (j12 < j10 || j12 > j11) {
            throw new IllegalArgumentException(str);
        }
    }

    public static <T> T[] noNullElements(T[] tArr) {
        return (T[]) noNullElements(tArr, DEFAULT_NO_NULL_ELEMENTS_ARRAY_EX_MESSAGE, new Object[0]);
    }

    public static void exclusiveBetween(double d10, double d11, double d12) {
        if (d12 <= d10 || d12 >= d11) {
            throw new IllegalArgumentException(String.format(DEFAULT_EXCLUSIVE_BETWEEN_EX_MESSAGE, Double.valueOf(d12), Double.valueOf(d10), Double.valueOf(d11)));
        }
    }

    public static void inclusiveBetween(double d10, double d11, double d12) {
        if (d12 < d10 || d12 > d11) {
            throw new IllegalArgumentException(String.format(DEFAULT_INCLUSIVE_BETWEEN_EX_MESSAGE, Double.valueOf(d12), Double.valueOf(d10), Double.valueOf(d11)));
        }
    }

    public static <T extends Iterable<?>> T noNullElements(T t2, String str, Object... objArr) {
        notNull(t2);
        Iterator iterator2 = t2.iterator2();
        int i10 = 0;
        while (iterator2.hasNext()) {
            if (iterator2.next() == null) {
                throw new IllegalArgumentException(String.format(str, ArrayUtils.addAll(objArr, Integer.valueOf(i10))));
            }
            i10++;
        }
        return t2;
    }

    public static void exclusiveBetween(double d10, double d11, double d12, String str) {
        if (d12 <= d10 || d12 >= d11) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void inclusiveBetween(double d10, double d11, double d12, String str) {
        if (d12 < d10 || d12 > d11) {
            throw new IllegalArgumentException(str);
        }
    }

    public static <T extends Collection<?>> T notEmpty(T t2) {
        return (T) notEmpty(t2, DEFAULT_NOT_EMPTY_COLLECTION_EX_MESSAGE, new Object[0]);
    }

    public static <T extends Collection<?>> T validIndex(T t2, int i10) {
        return (T) validIndex(t2, i10, DEFAULT_VALID_INDEX_COLLECTION_EX_MESSAGE, Integer.valueOf(i10));
    }

    public static <T extends Map<?, ?>> T notEmpty(T t2, String str, Object... objArr) {
        if (t2 != null) {
            if (t2.isEmpty()) {
                throw new IllegalArgumentException(String.format(str, objArr));
            }
            return t2;
        }
        throw new NullPointerException(String.format(str, objArr));
    }

    public static <T extends CharSequence> T validIndex(T t2, int i10, String str, Object... objArr) {
        notNull(t2);
        if (i10 < 0 || i10 >= t2.length()) {
            throw new IndexOutOfBoundsException(String.format(str, objArr));
        }
        return t2;
    }

    public static <T extends Iterable<?>> T noNullElements(T t2) {
        return (T) noNullElements(t2, DEFAULT_NO_NULL_ELEMENTS_COLLECTION_EX_MESSAGE, new Object[0]);
    }

    public static <T extends Map<?, ?>> T notEmpty(T t2) {
        return (T) notEmpty(t2, DEFAULT_NOT_EMPTY_MAP_EX_MESSAGE, new Object[0]);
    }

    public static <T extends CharSequence> T validIndex(T t2, int i10) {
        return (T) validIndex(t2, i10, DEFAULT_VALID_INDEX_CHAR_SEQUENCE_EX_MESSAGE, Integer.valueOf(i10));
    }

    public static <T extends CharSequence> T notEmpty(T t2, String str, Object... objArr) {
        if (t2 != null) {
            if (t2.length() != 0) {
                return t2;
            }
            throw new IllegalArgumentException(String.format(str, objArr));
        }
        throw new NullPointerException(String.format(str, objArr));
    }

    public static <T extends CharSequence> T notEmpty(T t2) {
        return (T) notEmpty(t2, DEFAULT_NOT_EMPTY_CHAR_SEQUENCE_EX_MESSAGE, new Object[0]);
    }
}
