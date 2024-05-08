package org.apache.commons.lang3;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.apache.commons.lang3.mutable.MutableInt;
import org.apache.commons.lang3.text.StrBuilder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ObjectUtils {
    private static final char AT_SIGN = '@';
    public static final Null NULL = new Null();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class Null implements Serializable {
        private static final long serialVersionUID = 7092611880189329093L;

        private Object readResolve() {
            return ObjectUtils.NULL;
        }
    }

    public static byte CONST(byte b4) {
        return b4;
    }

    public static char CONST(char c4) {
        return c4;
    }

    public static double CONST(double d10) {
        return d10;
    }

    public static float CONST(float f10) {
        return f10;
    }

    public static int CONST(int i10) {
        return i10;
    }

    public static long CONST(long j10) {
        return j10;
    }

    public static <T> T CONST(T t2) {
        return t2;
    }

    public static short CONST(short s2) {
        return s2;
    }

    public static boolean CONST(boolean z10) {
        return z10;
    }

    public static byte CONST_BYTE(int i10) {
        if (i10 >= -128 && i10 <= 127) {
            return (byte) i10;
        }
        throw new IllegalArgumentException("Supplied value must be a valid byte literal between -128 and 127: [" + i10 + "]");
    }

    public static short CONST_SHORT(int i10) {
        if (i10 >= -32768 && i10 <= 32767) {
            return (short) i10;
        }
        throw new IllegalArgumentException("Supplied value must be a valid byte literal between -32768 and 32767: [" + i10 + "]");
    }

    public static boolean allNotNull(Object... objArr) {
        if (objArr == null) {
            return false;
        }
        for (Object obj : objArr) {
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean anyNotNull(Object... objArr) {
        return firstNonNull(objArr) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T clone(T t2) {
        if (!(t2 instanceof Cloneable)) {
            return null;
        }
        if (t2.getClass().isArray()) {
            Class<?> componentType = t2.getClass().getComponentType();
            if (componentType.isPrimitive()) {
                int length = Array.getLength(t2);
                T t10 = (T) Array.newInstance(componentType, length);
                while (true) {
                    int i10 = length - 1;
                    if (length <= 0) {
                        return t10;
                    }
                    Array.set(t10, i10, Array.get(t2, i10));
                    length = i10;
                }
            } else {
                return (T) ((Object[]) t2).clone();
            }
        } else {
            try {
                return (T) t2.getClass().getMethod("clone", new Class[0]).invoke(t2, new Object[0]);
            } catch (IllegalAccessException e2) {
                throw new CloneFailedException("Cannot clone Cloneable type " + t2.getClass().getName(), e2);
            } catch (NoSuchMethodException e10) {
                throw new CloneFailedException("Cloneable type " + t2.getClass().getName() + " has no clone method", e10);
            } catch (InvocationTargetException e11) {
                throw new CloneFailedException("Exception cloning Cloneable type " + t2.getClass().getName(), e11.getCause());
            }
        }
    }

    public static <T> T cloneIfPossible(T t2) {
        T t10 = (T) clone(t2);
        return t10 == null ? t2 : t10;
    }

    public static <T extends Comparable<? super T>> int compare(T t2, T t10) {
        return compare(t2, t10, false);
    }

    public static <T> T defaultIfNull(T t2, T t10) {
        return t2 != null ? t2 : t10;
    }

    @Deprecated
    public static boolean equals(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    @SafeVarargs
    public static <T> T firstNonNull(T... tArr) {
        if (tArr == null) {
            return null;
        }
        for (T t2 : tArr) {
            if (t2 != null) {
                return t2;
            }
        }
        return null;
    }

    @Deprecated
    public static int hashCode(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Deprecated
    public static int hashCodeMulti(Object... objArr) {
        int i10 = 1;
        if (objArr != null) {
            for (Object obj : objArr) {
                i10 = (i10 * 31) + hashCode(obj);
            }
        }
        return i10;
    }

    public static String identityToString(Object obj) {
        if (obj == null) {
            return null;
        }
        String name = obj.getClass().getName();
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        StringBuilder sb2 = new StringBuilder(name.length() + 1 + hexString.length());
        sb2.append(name);
        sb2.append(AT_SIGN);
        sb2.append(hexString);
        return sb2.toString();
    }

    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() == 0;
        }
        if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        return false;
    }

    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    @SafeVarargs
    public static <T extends Comparable<? super T>> T max(T... tArr) {
        T t2 = null;
        if (tArr != null) {
            for (T t10 : tArr) {
                if (compare(t10, t2, false) > 0) {
                    t2 = t10;
                }
            }
        }
        return t2;
    }

    @SafeVarargs
    public static <T extends Comparable<? super T>> T median(T... tArr) {
        Validate.notEmpty(tArr);
        Validate.noNullElements(tArr);
        TreeSet treeSet = new TreeSet();
        Collections.addAll(treeSet, tArr);
        return (T) treeSet.toArray()[(treeSet.size() - 1) / 2];
    }

    @SafeVarargs
    public static <T extends Comparable<? super T>> T min(T... tArr) {
        T t2 = null;
        if (tArr != null) {
            for (T t10 : tArr) {
                if (compare(t10, t2, true) < 0) {
                    t2 = t10;
                }
            }
        }
        return t2;
    }

    @SafeVarargs
    public static <T> T mode(T... tArr) {
        if (!ArrayUtils.isNotEmpty(tArr)) {
            return null;
        }
        HashMap hashMap = new HashMap(tArr.length);
        int i10 = 0;
        for (T t2 : tArr) {
            MutableInt mutableInt = (MutableInt) hashMap.get(t2);
            if (mutableInt == null) {
                hashMap.put(t2, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
        }
        while (true) {
            T t10 = null;
            for (Map.Entry entry : hashMap.entrySet()) {
                int intValue = ((MutableInt) entry.getValue()).intValue();
                if (intValue == i10) {
                    break;
                }
                if (intValue > i10) {
                    t10 = (T) entry.getKey();
                    i10 = intValue;
                }
            }
            return t10;
        }
    }

    public static boolean notEqual(Object obj, Object obj2) {
        return !equals(obj, obj2);
    }

    @Deprecated
    public static String toString(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static <T extends Comparable<? super T>> int compare(T t2, T t10, boolean z10) {
        if (t2 == t10) {
            return 0;
        }
        if (t2 == null) {
            return z10 ? 1 : -1;
        }
        if (t10 == null) {
            return z10 ? -1 : 1;
        }
        return t2.compareTo(t10);
    }

    @Deprecated
    public static String toString(Object obj, String str) {
        return obj == null ? str : obj.toString();
    }

    @SafeVarargs
    public static <T> T median(Comparator<T> comparator, T... tArr) {
        Validate.notEmpty(tArr, "null/empty items", new Object[0]);
        Validate.noNullElements(tArr);
        Validate.notNull(comparator, "null comparator", new Object[0]);
        TreeSet treeSet = new TreeSet(comparator);
        Collections.addAll(treeSet, tArr);
        return (T) treeSet.toArray()[(treeSet.size() - 1) / 2];
    }

    public static void identityToString(Appendable appendable, Object obj) throws IOException {
        Validate.notNull(obj, "Cannot get the toString of a null object", new Object[0]);
        appendable.append(obj.getClass().getName()).append(AT_SIGN).append(Integer.toHexString(System.identityHashCode(obj)));
    }

    @Deprecated
    public static void identityToString(StrBuilder strBuilder, Object obj) {
        Validate.notNull(obj, "Cannot get the toString of a null object", new Object[0]);
        String name = obj.getClass().getName();
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        strBuilder.ensureCapacity(strBuilder.length() + name.length() + 1 + hexString.length());
        strBuilder.append(name).append(AT_SIGN).append(hexString);
    }

    public static void identityToString(StringBuffer stringBuffer, Object obj) {
        Validate.notNull(obj, "Cannot get the toString of a null object", new Object[0]);
        String name = obj.getClass().getName();
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        stringBuffer.ensureCapacity(stringBuffer.length() + name.length() + 1 + hexString.length());
        stringBuffer.append(name);
        stringBuffer.append(AT_SIGN);
        stringBuffer.append(hexString);
    }

    public static void identityToString(StringBuilder sb2, Object obj) {
        Validate.notNull(obj, "Cannot get the toString of a null object", new Object[0]);
        String name = obj.getClass().getName();
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        sb2.ensureCapacity(sb2.length() + name.length() + 1 + hexString.length());
        sb2.append(name);
        sb2.append(AT_SIGN);
        sb2.append(hexString);
    }
}
