package java.util;

import java.util.function.BiFunction;
import java.util.function.Supplier;
import jdk.internal.util.Preconditions;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Objects {
    private Objects() {
        throw new AssertionError((Object) "No java.util.Objects instances for you!");
    }

    public static boolean equals(Object a10, Object b4) {
        return a10 == b4 || (a10 != null && a10.equals(b4));
    }

    public static boolean deepEquals(Object a10, Object b4) {
        if (a10 == b4) {
            return true;
        }
        if (a10 == null || b4 == null) {
            return false;
        }
        return Arrays.deepEquals0(a10, b4);
    }

    public static int hashCode(Object o10) {
        if (o10 != null) {
            return o10.hashCode();
        }
        return 0;
    }

    public static int hash(Object... values) {
        return Arrays.hashCode(values);
    }

    public static String toString(Object o10) {
        return String.valueOf(o10);
    }

    public static String toString(Object o10, String nullDefault) {
        return o10 != null ? o10.toString() : nullDefault;
    }

    public static <T> int compare(T a10, T b4, Comparator<? super T> c4) {
        if (a10 == b4) {
            return 0;
        }
        return c4.compare(a10, b4);
    }

    public static <T> T requireNonNull(T obj) {
        if (obj == null) {
            throw new NullPointerException();
        }
        return obj;
    }

    public static <T> T requireNonNull(T obj, String message) {
        if (obj == null) {
            throw new NullPointerException(message);
        }
        return obj;
    }

    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean nonNull(Object obj) {
        return obj != null;
    }

    public static <T> T requireNonNullElse(T t2, T t10) {
        return t2 != null ? t2 : (T) requireNonNull(t10, "defaultObj");
    }

    public static <T> T requireNonNullElseGet(T t2, Supplier<? extends T> supplier) {
        return t2 != null ? t2 : (T) requireNonNull(((Supplier) requireNonNull(supplier, "supplier")).get(), "supplier.get()");
    }

    public static <T> T requireNonNull(T obj, Supplier<String> messageSupplier) {
        if (obj == null) {
            throw new NullPointerException(messageSupplier == null ? null : messageSupplier.get());
        }
        return obj;
    }

    public static int checkIndex(int index, int length) {
        return Preconditions.checkIndex(index, length, (BiFunction) null);
    }

    public static int checkFromToIndex(int fromIndex, int toIndex, int length) {
        return Preconditions.checkFromToIndex(fromIndex, toIndex, length, (BiFunction) null);
    }

    public static int checkFromIndexSize(int fromIndex, int size, int length) {
        return Preconditions.checkFromIndexSize(fromIndex, size, length, (BiFunction) null);
    }

    public static long checkIndex(long index, long length) {
        return Preconditions.checkIndex(index, length, (BiFunction) null);
    }

    public static long checkFromToIndex(long fromIndex, long toIndex, long length) {
        return Preconditions.checkFromToIndex(fromIndex, toIndex, length, (BiFunction) null);
    }

    public static long checkFromIndexSize(long fromIndex, long size, long length) {
        return Preconditions.checkFromIndexSize(fromIndex, size, length, (BiFunction) null);
    }
}
