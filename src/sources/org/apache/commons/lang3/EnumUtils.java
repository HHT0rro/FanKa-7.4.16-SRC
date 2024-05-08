package org.apache.commons.lang3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class EnumUtils {
    private static final String CANNOT_STORE_S_S_VALUES_IN_S_BITS = "Cannot store %s %s values in %s bits";
    private static final String ENUM_CLASS_MUST_BE_DEFINED = "EnumClass must be defined.";
    private static final String NULL_ELEMENTS_NOT_PERMITTED = "null elements not permitted";
    private static final String S_DOES_NOT_SEEM_TO_BE_AN_ENUM_TYPE = "%s does not seem to be an Enum type";

    private static <E extends Enum<E>> Class<E> asEnum(Class<E> cls) {
        Validate.notNull(cls, ENUM_CLASS_MUST_BE_DEFINED, new Object[0]);
        Validate.isTrue(cls.isEnum(), S_DOES_NOT_SEEM_TO_BE_AN_ENUM_TYPE, cls);
        return cls;
    }

    private static <E extends Enum<E>> Class<E> checkBitVectorable(Class<E> cls) {
        Enum[] enumArr = (Enum[]) asEnum(cls).getEnumConstants();
        Validate.isTrue(enumArr.length <= 64, CANNOT_STORE_S_S_VALUES_IN_S_BITS, Integer.valueOf(enumArr.length), cls.getSimpleName(), 64);
        return cls;
    }

    public static <E extends Enum<E>> long generateBitVector(Class<E> cls, Iterable<? extends E> iterable) {
        checkBitVectorable(cls);
        Validate.notNull(iterable);
        Iterator<? extends E> iterator2 = iterable.iterator2();
        long j10 = 0;
        while (iterator2.hasNext()) {
            E next = iterator2.next();
            Validate.isTrue(next != null, NULL_ELEMENTS_NOT_PERMITTED, new Object[0]);
            j10 |= 1 << next.ordinal();
        }
        return j10;
    }

    public static <E extends Enum<E>> long[] generateBitVectors(Class<E> cls, Iterable<? extends E> iterable) {
        asEnum(cls);
        Validate.notNull(iterable);
        EnumSet noneOf = EnumSet.noneOf(cls);
        Iterator<? extends E> iterator2 = iterable.iterator2();
        while (true) {
            boolean z10 = true;
            if (!iterator2.hasNext()) {
                break;
            }
            E next = iterator2.next();
            if (next == null) {
                z10 = false;
            }
            Validate.isTrue(z10, NULL_ELEMENTS_NOT_PERMITTED, new Object[0]);
            noneOf.add(next);
        }
        long[] jArr = new long[((cls.getEnumConstants().length - 1) / 64) + 1];
        Iterator<E> it = noneOf.iterator2();
        while (it.hasNext()) {
            Enum r02 = (Enum) it.next();
            int ordinal = r02.ordinal() / 64;
            jArr[ordinal] = jArr[ordinal] | (1 << (r02.ordinal() % 64));
        }
        ArrayUtils.reverse(jArr);
        return jArr;
    }

    public static <E extends Enum<E>> E getEnum(Class<E> cls, String str) {
        if (str == null) {
            return null;
        }
        try {
            return (E) Enum.valueOf(cls, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static <E extends Enum<E>> E getEnumIgnoreCase(Class<E> cls, String str) {
        if (str != null && cls.isEnum()) {
            for (E e2 : cls.getEnumConstants()) {
                if (e2.name().equalsIgnoreCase(str)) {
                    return e2;
                }
            }
        }
        return null;
    }

    public static <E extends Enum<E>> List<E> getEnumList(Class<E> cls) {
        return new ArrayList(Arrays.asList(cls.getEnumConstants()));
    }

    public static <E extends Enum<E>> Map<String, E> getEnumMap(Class<E> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (E e2 : cls.getEnumConstants()) {
            linkedHashMap.put(e2.name(), e2);
        }
        return linkedHashMap;
    }

    public static <E extends Enum<E>> boolean isValidEnum(Class<E> cls, String str) {
        return getEnum(cls, str) != null;
    }

    public static <E extends Enum<E>> boolean isValidEnumIgnoreCase(Class<E> cls, String str) {
        return getEnumIgnoreCase(cls, str) != null;
    }

    public static <E extends Enum<E>> EnumSet<E> processBitVector(Class<E> cls, long j10) {
        checkBitVectorable(cls).getEnumConstants();
        return processBitVectors(cls, j10);
    }

    public static <E extends Enum<E>> EnumSet<E> processBitVectors(Class<E> cls, long... jArr) {
        EnumSet<E> noneOf = EnumSet.noneOf(asEnum(cls));
        long[] clone = ArrayUtils.clone((long[]) Validate.notNull(jArr));
        ArrayUtils.reverse(clone);
        for (E e2 : cls.getEnumConstants()) {
            int ordinal = e2.ordinal() / 64;
            if (ordinal < clone.length && (clone[ordinal] & (1 << (e2.ordinal() % 64))) != 0) {
                noneOf.add(e2);
            }
        }
        return noneOf;
    }

    @SafeVarargs
    public static <E extends Enum<E>> long generateBitVector(Class<E> cls, E... eArr) {
        Validate.noNullElements(eArr);
        return generateBitVector(cls, Arrays.asList(eArr));
    }

    @SafeVarargs
    public static <E extends Enum<E>> long[] generateBitVectors(Class<E> cls, E... eArr) {
        asEnum(cls);
        Validate.noNullElements(eArr);
        EnumSet noneOf = EnumSet.noneOf(cls);
        Collections.addAll(noneOf, eArr);
        long[] jArr = new long[((cls.getEnumConstants().length - 1) / 64) + 1];
        Iterator<E> it = noneOf.iterator2();
        while (it.hasNext()) {
            Enum r02 = (Enum) it.next();
            int ordinal = r02.ordinal() / 64;
            jArr[ordinal] = jArr[ordinal] | (1 << (r02.ordinal() % 64));
        }
        ArrayUtils.reverse(jArr);
        return jArr;
    }
}
