package java.util;

import XI.CA.XI.K0;
import com.android.internal.logging.nano.MetricsProto;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayPrefixHelpers;
import java.util.ArraysParallelSortHelpers;
import java.util.Spliterator;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import jdk.internal.util.ArraysSupport;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Arrays {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int INSERTIONSORT_THRESHOLD = 7;
    public static final int MIN_ARRAY_SORT_GRAN = 8192;

    private Arrays() {
    }

    public static void sort(int[] a10) {
        DualPivotQuicksort.sort(a10, 0, 0, a10.length);
    }

    public static void sort(int[] a10, int fromIndex, int toIndex) {
        rangeCheck(a10.length, fromIndex, toIndex);
        DualPivotQuicksort.sort(a10, 0, fromIndex, toIndex);
    }

    public static void sort(long[] a10) {
        DualPivotQuicksort.sort(a10, 0, 0, a10.length);
    }

    public static void sort(long[] a10, int fromIndex, int toIndex) {
        rangeCheck(a10.length, fromIndex, toIndex);
        DualPivotQuicksort.sort(a10, 0, fromIndex, toIndex);
    }

    public static void sort(short[] a10) {
        DualPivotQuicksort.sort(a10, 0, a10.length);
    }

    public static void sort(short[] a10, int fromIndex, int toIndex) {
        rangeCheck(a10.length, fromIndex, toIndex);
        DualPivotQuicksort.sort(a10, fromIndex, toIndex);
    }

    public static void sort(char[] a10) {
        DualPivotQuicksort.sort(a10, 0, a10.length);
    }

    public static void sort(char[] a10, int fromIndex, int toIndex) {
        rangeCheck(a10.length, fromIndex, toIndex);
        DualPivotQuicksort.sort(a10, fromIndex, toIndex);
    }

    public static void sort(byte[] a10) {
        DualPivotQuicksort.sort(a10, 0, a10.length);
    }

    public static void sort(byte[] a10, int fromIndex, int toIndex) {
        rangeCheck(a10.length, fromIndex, toIndex);
        DualPivotQuicksort.sort(a10, fromIndex, toIndex);
    }

    public static void sort(float[] a10) {
        DualPivotQuicksort.sort(a10, 0, 0, a10.length);
    }

    public static void sort(float[] a10, int fromIndex, int toIndex) {
        rangeCheck(a10.length, fromIndex, toIndex);
        DualPivotQuicksort.sort(a10, 0, fromIndex, toIndex);
    }

    public static void sort(double[] a10) {
        DualPivotQuicksort.sort(a10, 0, 0, a10.length);
    }

    public static void sort(double[] a10, int fromIndex, int toIndex) {
        rangeCheck(a10.length, fromIndex, toIndex);
        DualPivotQuicksort.sort(a10, 0, fromIndex, toIndex);
    }

    public static void parallelSort(byte[] a10) {
        DualPivotQuicksort.sort(a10, 0, a10.length);
    }

    public static void parallelSort(byte[] a10, int fromIndex, int toIndex) {
        rangeCheck(a10.length, fromIndex, toIndex);
        DualPivotQuicksort.sort(a10, fromIndex, toIndex);
    }

    public static void parallelSort(char[] a10) {
        DualPivotQuicksort.sort(a10, 0, a10.length);
    }

    public static void parallelSort(char[] a10, int fromIndex, int toIndex) {
        rangeCheck(a10.length, fromIndex, toIndex);
        DualPivotQuicksort.sort(a10, fromIndex, toIndex);
    }

    public static void parallelSort(short[] a10) {
        DualPivotQuicksort.sort(a10, 0, a10.length);
    }

    public static void parallelSort(short[] a10, int fromIndex, int toIndex) {
        rangeCheck(a10.length, fromIndex, toIndex);
        DualPivotQuicksort.sort(a10, fromIndex, toIndex);
    }

    public static void parallelSort(int[] a10) {
        DualPivotQuicksort.sort(a10, ForkJoinPool.getCommonPoolParallelism(), 0, a10.length);
    }

    public static void parallelSort(int[] a10, int fromIndex, int toIndex) {
        rangeCheck(a10.length, fromIndex, toIndex);
        DualPivotQuicksort.sort(a10, ForkJoinPool.getCommonPoolParallelism(), fromIndex, toIndex);
    }

    public static void parallelSort(long[] a10) {
        DualPivotQuicksort.sort(a10, ForkJoinPool.getCommonPoolParallelism(), 0, a10.length);
    }

    public static void parallelSort(long[] a10, int fromIndex, int toIndex) {
        rangeCheck(a10.length, fromIndex, toIndex);
        DualPivotQuicksort.sort(a10, ForkJoinPool.getCommonPoolParallelism(), fromIndex, toIndex);
    }

    public static void parallelSort(float[] a10) {
        DualPivotQuicksort.sort(a10, ForkJoinPool.getCommonPoolParallelism(), 0, a10.length);
    }

    public static void parallelSort(float[] a10, int fromIndex, int toIndex) {
        rangeCheck(a10.length, fromIndex, toIndex);
        DualPivotQuicksort.sort(a10, ForkJoinPool.getCommonPoolParallelism(), fromIndex, toIndex);
    }

    public static void parallelSort(double[] a10) {
        DualPivotQuicksort.sort(a10, ForkJoinPool.getCommonPoolParallelism(), 0, a10.length);
    }

    public static void parallelSort(double[] a10, int fromIndex, int toIndex) {
        rangeCheck(a10.length, fromIndex, toIndex);
        DualPivotQuicksort.sort(a10, ForkJoinPool.getCommonPoolParallelism(), fromIndex, toIndex);
    }

    static void rangeCheck(int arrayLength, int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            throw new IllegalArgumentException("fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
        }
        if (fromIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(fromIndex);
        }
        if (toIndex > arrayLength) {
            throw new ArrayIndexOutOfBoundsException(toIndex);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class NaturalOrder implements Comparator<Object> {
        static final NaturalOrder INSTANCE = new NaturalOrder();

        NaturalOrder() {
        }

        @Override // java.util.Comparator
        public int compare(Object first, Object second) {
            return ((Comparable) first).compareTo(second);
        }
    }

    public static <T extends Comparable<? super T>> void parallelSort(T[] a10) {
        int p10;
        int n10 = a10.length;
        if (n10 <= 8192 || (p10 = ForkJoinPool.getCommonPoolParallelism()) == 1) {
            TimSort.sort(a10, 0, n10, NaturalOrder.INSTANCE, null, 0, 0);
        } else {
            int g3 = n10 / (p10 << 2);
            new ArraysParallelSortHelpers.FJObject.Sorter(null, a10, (Comparable[]) Array.newInstance(a10.getClass().getComponentType(), n10), 0, n10, 0, g3 <= 8192 ? 8192 : g3, NaturalOrder.INSTANCE).invoke();
        }
    }

    public static <T extends Comparable<? super T>> void parallelSort(T[] a10, int fromIndex, int toIndex) {
        int p10;
        rangeCheck(a10.length, fromIndex, toIndex);
        int n10 = toIndex - fromIndex;
        if (n10 <= 8192 || (p10 = ForkJoinPool.getCommonPoolParallelism()) == 1) {
            TimSort.sort(a10, fromIndex, toIndex, NaturalOrder.INSTANCE, null, 0, 0);
        } else {
            int g3 = n10 / (p10 << 2);
            new ArraysParallelSortHelpers.FJObject.Sorter(null, a10, (Comparable[]) Array.newInstance(a10.getClass().getComponentType(), n10), fromIndex, n10, 0, g3 <= 8192 ? 8192 : g3, NaturalOrder.INSTANCE).invoke();
        }
    }

    public static <T> void parallelSort(T[] a10, Comparator<? super T> cmp) {
        int p10;
        if (cmp == null) {
            cmp = NaturalOrder.INSTANCE;
        }
        int n10 = a10.length;
        if (n10 <= 8192 || (p10 = ForkJoinPool.getCommonPoolParallelism()) == 1) {
            TimSort.sort(a10, 0, n10, cmp, null, 0, 0);
        } else {
            int g3 = n10 / (p10 << 2);
            new ArraysParallelSortHelpers.FJObject.Sorter(null, a10, (Object[]) Array.newInstance(a10.getClass().getComponentType(), n10), 0, n10, 0, g3 <= 8192 ? 8192 : g3, cmp).invoke();
        }
    }

    public static <T> void parallelSort(T[] a10, int fromIndex, int toIndex, Comparator<? super T> cmp) {
        Comparator<? super T> cmp2;
        int p10;
        rangeCheck(a10.length, fromIndex, toIndex);
        if (cmp != null) {
            cmp2 = cmp;
        } else {
            cmp2 = NaturalOrder.INSTANCE;
        }
        int n10 = toIndex - fromIndex;
        if (n10 <= 8192 || (p10 = ForkJoinPool.getCommonPoolParallelism()) == 1) {
            TimSort.sort(a10, fromIndex, toIndex, cmp2, null, 0, 0);
        } else {
            int g3 = n10 / (p10 << 2);
            new ArraysParallelSortHelpers.FJObject.Sorter(null, a10, (Object[]) Array.newInstance(a10.getClass().getComponentType(), n10), fromIndex, n10, 0, g3 <= 8192 ? 8192 : g3, cmp2).invoke();
        }
    }

    public static void sort(Object[] a10) {
        ComparableTimSort.sort(a10, 0, a10.length, null, 0, 0);
    }

    public static void sort(Object[] a10, int fromIndex, int toIndex) {
        rangeCheck(a10.length, fromIndex, toIndex);
        ComparableTimSort.sort(a10, fromIndex, toIndex, null, 0, 0);
    }

    private static void mergeSort(Object[] src, Object[] dest, int low, int high, int off) {
        int length = high - low;
        if (length < 7) {
            for (int i10 = low; i10 < high; i10++) {
                for (int j10 = i10; j10 > low && ((Comparable) dest[j10 - 1]).compareTo(dest[j10]) > 0; j10--) {
                    swap(dest, j10, j10 - 1);
                }
            }
            return;
        }
        int low2 = low + off;
        int high2 = high + off;
        int mid = (low2 + high2) >>> 1;
        mergeSort(dest, src, low2, mid, -off);
        mergeSort(dest, src, mid, high2, -off);
        if (((Comparable) src[mid - 1]).compareTo(src[mid]) <= 0) {
            System.arraycopy(src, low2, dest, low, length);
            return;
        }
        int p10 = low2;
        int q10 = mid;
        for (int i11 = low; i11 < high; i11++) {
            if (q10 >= high2 || (p10 < mid && ((Comparable) src[p10]).compareTo(src[q10]) <= 0)) {
                int q11 = p10 + 1;
                dest[i11] = src[p10];
                p10 = q11;
            } else {
                dest[i11] = src[q10];
                q10++;
            }
        }
    }

    private static void swap(Object[] x10, int a10, int b4) {
        Object t2 = x10[a10];
        x10[a10] = x10[b4];
        x10[b4] = t2;
    }

    public static <T> void sort(T[] a10, Comparator<? super T> c4) {
        if (c4 == null) {
            sort(a10);
        } else {
            TimSort.sort(a10, 0, a10.length, c4, null, 0, 0);
        }
    }

    public static <T> void sort(T[] a10, int fromIndex, int toIndex, Comparator<? super T> c4) {
        if (c4 == null) {
            sort(a10, fromIndex, toIndex);
        } else {
            rangeCheck(a10.length, fromIndex, toIndex);
            TimSort.sort(a10, fromIndex, toIndex, c4, null, 0, 0);
        }
    }

    public static <T> void parallelPrefix(T[] array, BinaryOperator<T> op) {
        Objects.requireNonNull(op);
        if (array.length > 0) {
            new ArrayPrefixHelpers.CumulateTask(null, op, array, 0, array.length).invoke();
        }
    }

    public static <T> void parallelPrefix(T[] array, int fromIndex, int toIndex, BinaryOperator<T> op) {
        Objects.requireNonNull(op);
        rangeCheck(array.length, fromIndex, toIndex);
        if (fromIndex < toIndex) {
            new ArrayPrefixHelpers.CumulateTask(null, op, array, fromIndex, toIndex).invoke();
        }
    }

    public static void parallelPrefix(long[] array, LongBinaryOperator op) {
        Objects.requireNonNull(op);
        if (array.length > 0) {
            new ArrayPrefixHelpers.LongCumulateTask(null, op, array, 0, array.length).invoke();
        }
    }

    public static void parallelPrefix(long[] array, int fromIndex, int toIndex, LongBinaryOperator op) {
        Objects.requireNonNull(op);
        rangeCheck(array.length, fromIndex, toIndex);
        if (fromIndex < toIndex) {
            new ArrayPrefixHelpers.LongCumulateTask(null, op, array, fromIndex, toIndex).invoke();
        }
    }

    public static void parallelPrefix(double[] array, DoubleBinaryOperator op) {
        Objects.requireNonNull(op);
        if (array.length > 0) {
            new ArrayPrefixHelpers.DoubleCumulateTask(null, op, array, 0, array.length).invoke();
        }
    }

    public static void parallelPrefix(double[] array, int fromIndex, int toIndex, DoubleBinaryOperator op) {
        Objects.requireNonNull(op);
        rangeCheck(array.length, fromIndex, toIndex);
        if (fromIndex < toIndex) {
            new ArrayPrefixHelpers.DoubleCumulateTask(null, op, array, fromIndex, toIndex).invoke();
        }
    }

    public static void parallelPrefix(int[] array, IntBinaryOperator op) {
        Objects.requireNonNull(op);
        if (array.length > 0) {
            new ArrayPrefixHelpers.IntCumulateTask(null, op, array, 0, array.length).invoke();
        }
    }

    public static void parallelPrefix(int[] array, int fromIndex, int toIndex, IntBinaryOperator op) {
        Objects.requireNonNull(op);
        rangeCheck(array.length, fromIndex, toIndex);
        if (fromIndex < toIndex) {
            new ArrayPrefixHelpers.IntCumulateTask(null, op, array, fromIndex, toIndex).invoke();
        }
    }

    public static int binarySearch(long[] a10, long key) {
        return binarySearch0(a10, 0, a10.length, key);
    }

    public static int binarySearch(long[] a10, int fromIndex, int toIndex, long key) {
        rangeCheck(a10.length, fromIndex, toIndex);
        return binarySearch0(a10, fromIndex, toIndex, key);
    }

    private static int binarySearch0(long[] a10, int fromIndex, int toIndex, long key) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = a10[mid];
            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    public static int binarySearch(int[] a10, int key) {
        return binarySearch0(a10, 0, a10.length, key);
    }

    public static int binarySearch(int[] a10, int fromIndex, int toIndex, int key) {
        rangeCheck(a10.length, fromIndex, toIndex);
        return binarySearch0(a10, fromIndex, toIndex, key);
    }

    private static int binarySearch0(int[] a10, int fromIndex, int toIndex, int key) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a10[mid];
            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    public static int binarySearch(short[] a10, short key) {
        return binarySearch0(a10, 0, a10.length, key);
    }

    public static int binarySearch(short[] a10, int fromIndex, int toIndex, short key) {
        rangeCheck(a10.length, fromIndex, toIndex);
        return binarySearch0(a10, fromIndex, toIndex, key);
    }

    private static int binarySearch0(short[] a10, int fromIndex, int toIndex, short key) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            short midVal = a10[mid];
            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    public static int binarySearch(char[] a10, char key) {
        return binarySearch0(a10, 0, a10.length, key);
    }

    public static int binarySearch(char[] a10, int fromIndex, int toIndex, char key) {
        rangeCheck(a10.length, fromIndex, toIndex);
        return binarySearch0(a10, fromIndex, toIndex, key);
    }

    private static int binarySearch0(char[] a10, int fromIndex, int toIndex, char key) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            char midVal = a10[mid];
            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    public static int binarySearch(byte[] a10, byte key) {
        return binarySearch0(a10, 0, a10.length, key);
    }

    public static int binarySearch(byte[] a10, int fromIndex, int toIndex, byte key) {
        rangeCheck(a10.length, fromIndex, toIndex);
        return binarySearch0(a10, fromIndex, toIndex, key);
    }

    private static int binarySearch0(byte[] a10, int fromIndex, int toIndex, byte key) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            byte midVal = a10[mid];
            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    public static int binarySearch(double[] a10, double key) {
        return binarySearch0(a10, 0, a10.length, key);
    }

    public static int binarySearch(double[] a10, int fromIndex, int toIndex, double key) {
        rangeCheck(a10.length, fromIndex, toIndex);
        return binarySearch0(a10, fromIndex, toIndex, key);
    }

    private static int binarySearch0(double[] a10, int fromIndex, int toIndex, double key) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            double midVal = a10[mid];
            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                long midBits = Double.doubleToLongBits(midVal);
                long keyBits = Double.doubleToLongBits(key);
                if (midBits == keyBits) {
                    return mid;
                }
                if (midBits < keyBits) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -(low + 1);
    }

    public static int binarySearch(float[] a10, float key) {
        return binarySearch0(a10, 0, a10.length, key);
    }

    public static int binarySearch(float[] a10, int fromIndex, int toIndex, float key) {
        rangeCheck(a10.length, fromIndex, toIndex);
        return binarySearch0(a10, fromIndex, toIndex, key);
    }

    private static int binarySearch0(float[] a10, int fromIndex, int toIndex, float key) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            float midVal = a10[mid];
            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                int midBits = Float.floatToIntBits(midVal);
                int keyBits = Float.floatToIntBits(key);
                if (midBits == keyBits) {
                    return mid;
                }
                if (midBits < keyBits) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -(low + 1);
    }

    public static int binarySearch(Object[] a10, Object key) {
        return binarySearch0(a10, 0, a10.length, key);
    }

    public static int binarySearch(Object[] a10, int fromIndex, int toIndex, Object key) {
        rangeCheck(a10.length, fromIndex, toIndex);
        return binarySearch0(a10, fromIndex, toIndex, key);
    }

    private static int binarySearch0(Object[] a10, int fromIndex, int toIndex, Object key) {
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            Comparable midVal = (Comparable) a10[mid];
            int cmp = midVal.compareTo(key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    public static <T> int binarySearch(T[] a10, T key, Comparator<? super T> c4) {
        return binarySearch0(a10, 0, a10.length, key, c4);
    }

    public static <T> int binarySearch(T[] a10, int fromIndex, int toIndex, T key, Comparator<? super T> c4) {
        rangeCheck(a10.length, fromIndex, toIndex);
        return binarySearch0(a10, fromIndex, toIndex, key, c4);
    }

    private static <T> int binarySearch0(T[] a10, int fromIndex, int toIndex, T key, Comparator<? super T> c4) {
        if (c4 == null) {
            return binarySearch0(a10, fromIndex, toIndex, key);
        }
        int low = fromIndex;
        int high = toIndex - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            T midVal = a10[mid];
            int cmp = c4.compare(midVal, key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    public static boolean equals(long[] a10, long[] a22) {
        int length;
        if (a10 == a22) {
            return true;
        }
        if (a10 != null && a22 != null && a22.length == (length = a10.length) && ArraysSupport.mismatch(a10, a22, length) < 0) {
            return true;
        }
        return false;
    }

    public static boolean equals(long[] a10, int aFromIndex, int aToIndex, long[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        return aLength == bLength && ArraysSupport.mismatch(a10, aFromIndex, b4, bFromIndex, aLength) < 0;
    }

    public static boolean equals(int[] a10, int[] a22) {
        int length;
        if (a10 == a22) {
            return true;
        }
        if (a10 != null && a22 != null && a22.length == (length = a10.length) && ArraysSupport.mismatch(a10, a22, length) < 0) {
            return true;
        }
        return false;
    }

    public static boolean equals(int[] a10, int aFromIndex, int aToIndex, int[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        return aLength == bLength && ArraysSupport.mismatch(a10, aFromIndex, b4, bFromIndex, aLength) < 0;
    }

    public static boolean equals(short[] a10, short[] a22) {
        int length;
        if (a10 == a22) {
            return true;
        }
        if (a10 != null && a22 != null && a22.length == (length = a10.length) && ArraysSupport.mismatch(a10, a22, length) < 0) {
            return true;
        }
        return false;
    }

    public static boolean equals(short[] a10, int aFromIndex, int aToIndex, short[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        return aLength == bLength && ArraysSupport.mismatch(a10, aFromIndex, b4, bFromIndex, aLength) < 0;
    }

    public static boolean equals(char[] a10, char[] a22) {
        int length;
        if (a10 == a22) {
            return true;
        }
        if (a10 != null && a22 != null && a22.length == (length = a10.length) && ArraysSupport.mismatch(a10, a22, length) < 0) {
            return true;
        }
        return false;
    }

    public static boolean equals(char[] a10, int aFromIndex, int aToIndex, char[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        return aLength == bLength && ArraysSupport.mismatch(a10, aFromIndex, b4, bFromIndex, aLength) < 0;
    }

    public static boolean equals(byte[] a10, byte[] a22) {
        int length;
        if (a10 == a22) {
            return true;
        }
        if (a10 != null && a22 != null && a22.length == (length = a10.length) && ArraysSupport.mismatch(a10, a22, length) < 0) {
            return true;
        }
        return false;
    }

    public static boolean equals(byte[] a10, int aFromIndex, int aToIndex, byte[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        return aLength == bLength && ArraysSupport.mismatch(a10, aFromIndex, b4, bFromIndex, aLength) < 0;
    }

    public static boolean equals(boolean[] a10, boolean[] a22) {
        int length;
        if (a10 == a22) {
            return true;
        }
        if (a10 != null && a22 != null && a22.length == (length = a10.length) && ArraysSupport.mismatch(a10, a22, length) < 0) {
            return true;
        }
        return false;
    }

    public static boolean equals(boolean[] a10, int aFromIndex, int aToIndex, boolean[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        return aLength == bLength && ArraysSupport.mismatch(a10, aFromIndex, b4, bFromIndex, aLength) < 0;
    }

    public static boolean equals(double[] a10, double[] a22) {
        int length;
        if (a10 == a22) {
            return true;
        }
        if (a10 != null && a22 != null && a22.length == (length = a10.length) && ArraysSupport.mismatch(a10, a22, length) < 0) {
            return true;
        }
        return false;
    }

    public static boolean equals(double[] a10, int aFromIndex, int aToIndex, double[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        return aLength == bLength && ArraysSupport.mismatch(a10, aFromIndex, b4, bFromIndex, aLength) < 0;
    }

    public static boolean equals(float[] a10, float[] a22) {
        int length;
        if (a10 == a22) {
            return true;
        }
        if (a10 != null && a22 != null && a22.length == (length = a10.length) && ArraysSupport.mismatch(a10, a22, length) < 0) {
            return true;
        }
        return false;
    }

    public static boolean equals(float[] a10, int aFromIndex, int aToIndex, float[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        return aLength == bLength && ArraysSupport.mismatch(a10, aFromIndex, b4, bFromIndex, aLength) < 0;
    }

    public static boolean equals(Object[] a10, Object[] a22) {
        int length;
        if (a10 == a22) {
            return true;
        }
        if (a10 == null || a22 == null || a22.length != (length = a10.length)) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10++) {
            if (!Objects.equals(a10[i10], a22[i10])) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(Object[] a10, int aFromIndex, int aToIndex, Object[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        if (aLength != bLength) {
            return false;
        }
        int i10 = 0;
        while (i10 < aLength) {
            int aFromIndex2 = aFromIndex + 1;
            int bFromIndex2 = bFromIndex + 1;
            if (!Objects.equals(a10[aFromIndex], b4[bFromIndex])) {
                return false;
            }
            i10++;
            aFromIndex = aFromIndex2;
            bFromIndex = bFromIndex2;
        }
        return true;
    }

    public static <T> boolean equals(T[] a10, T[] a22, Comparator<? super T> cmp) {
        int length;
        Objects.requireNonNull(cmp);
        if (a10 == a22) {
            return true;
        }
        if (a10 == null || a22 == null || a22.length != (length = a10.length)) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10++) {
            if (cmp.compare(a10[i10], a22[i10]) != 0) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean equals(T[] a10, int aFromIndex, int aToIndex, T[] b4, int bFromIndex, int bToIndex, Comparator<? super T> cmp) {
        Objects.requireNonNull(cmp);
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        if (aLength != bLength) {
            return false;
        }
        int i10 = 0;
        while (i10 < aLength) {
            int aFromIndex2 = aFromIndex + 1;
            int bFromIndex2 = bFromIndex + 1;
            if (cmp.compare(a10[aFromIndex], b4[bFromIndex]) != 0) {
                return false;
            }
            i10++;
            aFromIndex = aFromIndex2;
            bFromIndex = bFromIndex2;
        }
        return true;
    }

    public static void fill(long[] a10, long val) {
        int len = a10.length;
        for (int i10 = 0; i10 < len; i10++) {
            a10[i10] = val;
        }
    }

    public static void fill(long[] a10, int fromIndex, int toIndex, long val) {
        rangeCheck(a10.length, fromIndex, toIndex);
        for (int i10 = fromIndex; i10 < toIndex; i10++) {
            a10[i10] = val;
        }
    }

    public static void fill(int[] a10, int val) {
        int len = a10.length;
        for (int i10 = 0; i10 < len; i10++) {
            a10[i10] = val;
        }
    }

    public static void fill(int[] a10, int fromIndex, int toIndex, int val) {
        rangeCheck(a10.length, fromIndex, toIndex);
        for (int i10 = fromIndex; i10 < toIndex; i10++) {
            a10[i10] = val;
        }
    }

    public static void fill(short[] a10, short val) {
        int len = a10.length;
        for (int i10 = 0; i10 < len; i10++) {
            a10[i10] = val;
        }
    }

    public static void fill(short[] a10, int fromIndex, int toIndex, short val) {
        rangeCheck(a10.length, fromIndex, toIndex);
        for (int i10 = fromIndex; i10 < toIndex; i10++) {
            a10[i10] = val;
        }
    }

    public static void fill(char[] a10, char val) {
        int len = a10.length;
        for (int i10 = 0; i10 < len; i10++) {
            a10[i10] = val;
        }
    }

    public static void fill(char[] a10, int fromIndex, int toIndex, char val) {
        rangeCheck(a10.length, fromIndex, toIndex);
        for (int i10 = fromIndex; i10 < toIndex; i10++) {
            a10[i10] = val;
        }
    }

    public static void fill(byte[] a10, byte val) {
        int len = a10.length;
        for (int i10 = 0; i10 < len; i10++) {
            a10[i10] = val;
        }
    }

    public static void fill(byte[] a10, int fromIndex, int toIndex, byte val) {
        rangeCheck(a10.length, fromIndex, toIndex);
        for (int i10 = fromIndex; i10 < toIndex; i10++) {
            a10[i10] = val;
        }
    }

    public static void fill(boolean[] a10, boolean val) {
        int len = a10.length;
        for (int i10 = 0; i10 < len; i10++) {
            a10[i10] = val;
        }
    }

    public static void fill(boolean[] a10, int fromIndex, int toIndex, boolean val) {
        rangeCheck(a10.length, fromIndex, toIndex);
        for (int i10 = fromIndex; i10 < toIndex; i10++) {
            a10[i10] = val;
        }
    }

    public static void fill(double[] a10, double val) {
        int len = a10.length;
        for (int i10 = 0; i10 < len; i10++) {
            a10[i10] = val;
        }
    }

    public static void fill(double[] a10, int fromIndex, int toIndex, double val) {
        rangeCheck(a10.length, fromIndex, toIndex);
        for (int i10 = fromIndex; i10 < toIndex; i10++) {
            a10[i10] = val;
        }
    }

    public static void fill(float[] a10, float val) {
        int len = a10.length;
        for (int i10 = 0; i10 < len; i10++) {
            a10[i10] = val;
        }
    }

    public static void fill(float[] a10, int fromIndex, int toIndex, float val) {
        rangeCheck(a10.length, fromIndex, toIndex);
        for (int i10 = fromIndex; i10 < toIndex; i10++) {
            a10[i10] = val;
        }
    }

    public static void fill(Object[] a10, Object val) {
        int len = a10.length;
        for (int i10 = 0; i10 < len; i10++) {
            a10[i10] = val;
        }
    }

    public static void fill(Object[] a10, int fromIndex, int toIndex, Object val) {
        rangeCheck(a10.length, fromIndex, toIndex);
        for (int i10 = fromIndex; i10 < toIndex; i10++) {
            a10[i10] = val;
        }
    }

    public static <T> T[] copyOf(T[] tArr, int i10) {
        return (T[]) copyOf(tArr, i10, tArr.getClass());
    }

    public static <T, U> T[] copyOf(U[] uArr, int i10, Class<? extends T[]> cls) {
        T[] tArr;
        if (cls == Object[].class) {
            tArr = (T[]) new Object[i10];
        } else {
            tArr = (T[]) ((Object[]) Array.newInstance(cls.getComponentType(), i10));
        }
        System.arraycopy(uArr, 0, tArr, 0, Math.min(uArr.length, i10));
        return tArr;
    }

    public static byte[] copyOf(byte[] original, int newLength) {
        byte[] copy = new byte[newLength];
        System.arraycopy((Object) original, 0, (Object) copy, 0, Math.min(original.length, newLength));
        return copy;
    }

    public static short[] copyOf(short[] original, int newLength) {
        short[] copy = new short[newLength];
        System.arraycopy((Object) original, 0, (Object) copy, 0, Math.min(original.length, newLength));
        return copy;
    }

    public static int[] copyOf(int[] original, int newLength) {
        int[] copy = new int[newLength];
        System.arraycopy((Object) original, 0, (Object) copy, 0, Math.min(original.length, newLength));
        return copy;
    }

    public static long[] copyOf(long[] original, int newLength) {
        long[] copy = new long[newLength];
        System.arraycopy((Object) original, 0, (Object) copy, 0, Math.min(original.length, newLength));
        return copy;
    }

    public static char[] copyOf(char[] original, int newLength) {
        char[] copy = new char[newLength];
        System.arraycopy((Object) original, 0, (Object) copy, 0, Math.min(original.length, newLength));
        return copy;
    }

    public static float[] copyOf(float[] original, int newLength) {
        float[] copy = new float[newLength];
        System.arraycopy((Object) original, 0, (Object) copy, 0, Math.min(original.length, newLength));
        return copy;
    }

    public static double[] copyOf(double[] original, int newLength) {
        double[] copy = new double[newLength];
        System.arraycopy((Object) original, 0, (Object) copy, 0, Math.min(original.length, newLength));
        return copy;
    }

    public static boolean[] copyOf(boolean[] original, int newLength) {
        boolean[] copy = new boolean[newLength];
        System.arraycopy((Object) original, 0, (Object) copy, 0, Math.min(original.length, newLength));
        return copy;
    }

    public static <T> T[] copyOfRange(T[] tArr, int i10, int i11) {
        return (T[]) copyOfRange(tArr, i10, i11, tArr.getClass());
    }

    public static <T, U> T[] copyOfRange(U[] uArr, int i10, int i11, Class<? extends T[]> cls) {
        T[] tArr;
        int i12 = i11 - i10;
        if (i12 < 0) {
            throw new IllegalArgumentException(i10 + " > " + i11);
        }
        if (cls == Object[].class) {
            tArr = (T[]) new Object[i12];
        } else {
            tArr = (T[]) ((Object[]) Array.newInstance(cls.getComponentType(), i12));
        }
        System.arraycopy(uArr, i10, tArr, 0, Math.min(uArr.length - i10, i12));
        return tArr;
    }

    public static byte[] copyOfRange(byte[] original, int from, int to) {
        int newLength = to - from;
        if (newLength < 0) {
            throw new IllegalArgumentException(from + " > " + to);
        }
        byte[] copy = new byte[newLength];
        System.arraycopy((Object) original, from, (Object) copy, 0, Math.min(original.length - from, newLength));
        return copy;
    }

    public static short[] copyOfRange(short[] original, int from, int to) {
        int newLength = to - from;
        if (newLength < 0) {
            throw new IllegalArgumentException(from + " > " + to);
        }
        short[] copy = new short[newLength];
        System.arraycopy((Object) original, from, (Object) copy, 0, Math.min(original.length - from, newLength));
        return copy;
    }

    public static int[] copyOfRange(int[] original, int from, int to) {
        int newLength = to - from;
        if (newLength < 0) {
            throw new IllegalArgumentException(from + " > " + to);
        }
        int[] copy = new int[newLength];
        System.arraycopy((Object) original, from, (Object) copy, 0, Math.min(original.length - from, newLength));
        return copy;
    }

    public static long[] copyOfRange(long[] original, int from, int to) {
        int newLength = to - from;
        if (newLength < 0) {
            throw new IllegalArgumentException(from + " > " + to);
        }
        long[] copy = new long[newLength];
        System.arraycopy((Object) original, from, (Object) copy, 0, Math.min(original.length - from, newLength));
        return copy;
    }

    public static char[] copyOfRange(char[] original, int from, int to) {
        int newLength = to - from;
        if (newLength < 0) {
            throw new IllegalArgumentException(from + " > " + to);
        }
        char[] copy = new char[newLength];
        System.arraycopy((Object) original, from, (Object) copy, 0, Math.min(original.length - from, newLength));
        return copy;
    }

    public static float[] copyOfRange(float[] original, int from, int to) {
        int newLength = to - from;
        if (newLength < 0) {
            throw new IllegalArgumentException(from + " > " + to);
        }
        float[] copy = new float[newLength];
        System.arraycopy((Object) original, from, (Object) copy, 0, Math.min(original.length - from, newLength));
        return copy;
    }

    public static double[] copyOfRange(double[] original, int from, int to) {
        int newLength = to - from;
        if (newLength < 0) {
            throw new IllegalArgumentException(from + " > " + to);
        }
        double[] copy = new double[newLength];
        System.arraycopy((Object) original, from, (Object) copy, 0, Math.min(original.length - from, newLength));
        return copy;
    }

    public static boolean[] copyOfRange(boolean[] original, int from, int to) {
        int newLength = to - from;
        if (newLength < 0) {
            throw new IllegalArgumentException(from + " > " + to);
        }
        boolean[] copy = new boolean[newLength];
        System.arraycopy((Object) original, from, (Object) copy, 0, Math.min(original.length - from, newLength));
        return copy;
    }

    @SafeVarargs
    public static <T> List<T> asList(T... a10) {
        return new ArrayList(a10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class ArrayList<E> extends AbstractList<E> implements RandomAccess, Serializable {
        private static final long serialVersionUID = -2764017481108945198L;

        /* renamed from: a, reason: collision with root package name */
        private final E[] f50426a;

        ArrayList(E[] eArr) {
            this.f50426a = (E[]) ((Object[]) Objects.requireNonNull(eArr));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f50426a.length;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return (Object[]) this.f50426a.clone();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            int size = size();
            if (tArr.length < size) {
                return (T[]) Arrays.copyOf(this.f50426a, size, tArr.getClass());
            }
            System.arraycopy(this.f50426a, 0, tArr, 0, size);
            if (tArr.length > size) {
                tArr[size] = null;
            }
            return tArr;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int index) {
            return this.f50426a[index];
        }

        @Override // java.util.AbstractList, java.util.List
        public E set(int index, E element) {
            E[] eArr = this.f50426a;
            E oldValue = eArr[index];
            eArr[index] = element;
            return oldValue;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object o10) {
            E[] a10 = this.f50426a;
            if (o10 == null) {
                for (int i10 = 0; i10 < a10.length; i10++) {
                    if (a10[i10] == null) {
                        return i10;
                    }
                }
                return -1;
            }
            for (int i11 = 0; i11 < a10.length; i11++) {
                if (o10.equals(a10[i11])) {
                    return i11;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o10) {
            return indexOf(o10) >= 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<E> spliterator() {
            return Spliterators.spliterator(this.f50426a, 16);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super E> consumer) {
            Objects.requireNonNull(consumer);
            for (K0 k02 : this.f50426a) {
                consumer.accept(k02);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public void replaceAll(UnaryOperator<E> unaryOperator) {
            Objects.requireNonNull(unaryOperator);
            E[] eArr = this.f50426a;
            for (int i10 = 0; i10 < eArr.length; i10++) {
                eArr[i10] = unaryOperator.apply(eArr[i10]);
            }
        }

        @Override // java.util.List
        public void sort(Comparator<? super E> c4) {
            Arrays.sort(this.f50426a, c4);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<E> iterator2() {
            return new ArrayItr(this.f50426a);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static class ArrayItr<E> implements Iterator<E> {

        /* renamed from: a, reason: collision with root package name */
        private final E[] f50425a;
        private int cursor;

        ArrayItr(E[] a10) {
            this.f50425a = a10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor < this.f50425a.length;
        }

        @Override // java.util.Iterator
        public E next() {
            int i10 = this.cursor;
            E[] eArr = this.f50425a;
            if (i10 >= eArr.length) {
                throw new NoSuchElementException();
            }
            this.cursor = i10 + 1;
            return eArr[i10];
        }
    }

    public static int hashCode(long[] a10) {
        if (a10 == null) {
            return 0;
        }
        int result = 1;
        for (long element : a10) {
            int elementHash = (int) ((element >>> 32) ^ element);
            result = (result * 31) + elementHash;
        }
        return result;
    }

    public static int hashCode(int[] a10) {
        if (a10 == null) {
            return 0;
        }
        int result = 1;
        for (int element : a10) {
            result = (result * 31) + element;
        }
        return result;
    }

    public static int hashCode(short[] a10) {
        if (a10 == null) {
            return 0;
        }
        int result = 1;
        for (short element : a10) {
            result = (result * 31) + element;
        }
        return result;
    }

    public static int hashCode(char[] a10) {
        if (a10 == null) {
            return 0;
        }
        int result = 1;
        for (char element : a10) {
            result = (result * 31) + element;
        }
        return result;
    }

    public static int hashCode(byte[] a10) {
        if (a10 == null) {
            return 0;
        }
        int result = 1;
        for (byte element : a10) {
            result = (result * 31) + element;
        }
        return result;
    }

    public static int hashCode(boolean[] a10) {
        if (a10 == null) {
            return 0;
        }
        int result = 1;
        int length = a10.length;
        for (int i10 = 0; i10 < length; i10++) {
            boolean element = a10[i10];
            result = (result * 31) + (element ? MetricsProto.MetricsEvent.AUTOFILL_SERVICE_DISABLED_APP : MetricsProto.MetricsEvent.ANOMALY_TYPE_UNOPTIMIZED_BT);
        }
        return result;
    }

    public static int hashCode(float[] a10) {
        if (a10 == null) {
            return 0;
        }
        int result = 1;
        for (float element : a10) {
            result = (result * 31) + Float.floatToIntBits(element);
        }
        return result;
    }

    public static int hashCode(double[] a10) {
        if (a10 == null) {
            return 0;
        }
        int result = 1;
        for (double element : a10) {
            long bits = Double.doubleToLongBits(element);
            result = (result * 31) + ((int) ((bits >>> 32) ^ bits));
        }
        return result;
    }

    public static int hashCode(Object[] a10) {
        if (a10 == null) {
            return 0;
        }
        int result = 1;
        int length = a10.length;
        for (int i10 = 0; i10 < length; i10++) {
            Object element = a10[i10];
            result = (result * 31) + (element == null ? 0 : element.hashCode());
        }
        return result;
    }

    public static int deepHashCode(Object[] a10) {
        int elementHash;
        if (a10 == null) {
            return 0;
        }
        int result = 1;
        for (Object element : a10) {
            if (element == null) {
                elementHash = 0;
            } else {
                Class<?> cl = element.getClass().getComponentType();
                if (cl == null) {
                    elementHash = element.hashCode();
                } else if (element instanceof Object[]) {
                    elementHash = deepHashCode((Object[]) element);
                } else {
                    elementHash = primitiveArrayHashCode(element, cl);
                }
            }
            result = (result * 31) + elementHash;
        }
        return result;
    }

    private static int primitiveArrayHashCode(Object a10, Class<?> cl) {
        return cl == Byte.TYPE ? hashCode((byte[]) a10) : cl == Integer.TYPE ? hashCode((int[]) a10) : cl == Long.TYPE ? hashCode((long[]) a10) : cl == Character.TYPE ? hashCode((char[]) a10) : cl == Short.TYPE ? hashCode((short[]) a10) : cl == Boolean.TYPE ? hashCode((boolean[]) a10) : cl == Double.TYPE ? hashCode((double[]) a10) : hashCode((float[]) a10);
    }

    public static boolean deepEquals(Object[] a12, Object[] a22) {
        int length;
        if (a12 == a22) {
            return true;
        }
        if (a12 == null || a22 == null || a22.length != (length = a12.length)) {
            return false;
        }
        for (int i10 = 0; i10 < length; i10++) {
            Object e12 = a12[i10];
            Object e2 = a22[i10];
            if (e12 != e2) {
                if (e12 == null) {
                    return false;
                }
                boolean eq = deepEquals0(e12, e2);
                if (!eq) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean deepEquals0(Object e12, Object e2) {
        if ((e12 instanceof Object[]) && (e2 instanceof Object[])) {
            boolean eq = deepEquals((Object[]) e12, (Object[]) e2);
            return eq;
        }
        boolean eq2 = e12 instanceof byte[];
        if (eq2 && (e2 instanceof byte[])) {
            boolean eq3 = equals((byte[]) e12, (byte[]) e2);
            return eq3;
        }
        boolean eq4 = e12 instanceof short[];
        if (eq4 && (e2 instanceof short[])) {
            boolean eq5 = equals((short[]) e12, (short[]) e2);
            return eq5;
        }
        boolean eq6 = e12 instanceof int[];
        if (eq6 && (e2 instanceof int[])) {
            boolean eq7 = equals((int[]) e12, (int[]) e2);
            return eq7;
        }
        boolean eq8 = e12 instanceof long[];
        if (eq8 && (e2 instanceof long[])) {
            boolean eq9 = equals((long[]) e12, (long[]) e2);
            return eq9;
        }
        boolean eq10 = e12 instanceof char[];
        if (eq10 && (e2 instanceof char[])) {
            boolean eq11 = equals((char[]) e12, (char[]) e2);
            return eq11;
        }
        boolean eq12 = e12 instanceof float[];
        if (eq12 && (e2 instanceof float[])) {
            boolean eq13 = equals((float[]) e12, (float[]) e2);
            return eq13;
        }
        boolean eq14 = e12 instanceof double[];
        if (eq14 && (e2 instanceof double[])) {
            boolean eq15 = equals((double[]) e12, (double[]) e2);
            return eq15;
        }
        boolean eq16 = e12 instanceof boolean[];
        if (eq16 && (e2 instanceof boolean[])) {
            boolean eq17 = equals((boolean[]) e12, (boolean[]) e2);
            return eq17;
        }
        boolean eq18 = e12.equals(e2);
        return eq18;
    }

    public static String toString(long[] a10) {
        if (a10 == null) {
            return "null";
        }
        int iMax = a10.length - 1;
        if (iMax == -1) {
            return "[]";
        }
        StringBuilder b4 = new StringBuilder();
        b4.append('[');
        int i10 = 0;
        while (true) {
            b4.append(a10[i10]);
            if (i10 == iMax) {
                return b4.append(']').toString();
            }
            b4.append(", ");
            i10++;
        }
    }

    public static String toString(int[] a10) {
        if (a10 == null) {
            return "null";
        }
        int iMax = a10.length - 1;
        if (iMax == -1) {
            return "[]";
        }
        StringBuilder b4 = new StringBuilder();
        b4.append('[');
        int i10 = 0;
        while (true) {
            b4.append(a10[i10]);
            if (i10 == iMax) {
                return b4.append(']').toString();
            }
            b4.append(", ");
            i10++;
        }
    }

    public static String toString(short[] a10) {
        if (a10 == null) {
            return "null";
        }
        int iMax = a10.length - 1;
        if (iMax == -1) {
            return "[]";
        }
        StringBuilder b4 = new StringBuilder();
        b4.append('[');
        int i10 = 0;
        while (true) {
            b4.append((int) a10[i10]);
            if (i10 == iMax) {
                return b4.append(']').toString();
            }
            b4.append(", ");
            i10++;
        }
    }

    public static String toString(char[] a10) {
        if (a10 == null) {
            return "null";
        }
        int iMax = a10.length - 1;
        if (iMax == -1) {
            return "[]";
        }
        StringBuilder b4 = new StringBuilder();
        b4.append('[');
        int i10 = 0;
        while (true) {
            b4.append(a10[i10]);
            if (i10 == iMax) {
                return b4.append(']').toString();
            }
            b4.append(", ");
            i10++;
        }
    }

    public static String toString(byte[] a10) {
        if (a10 == null) {
            return "null";
        }
        int iMax = a10.length - 1;
        if (iMax == -1) {
            return "[]";
        }
        StringBuilder b4 = new StringBuilder();
        b4.append('[');
        int i10 = 0;
        while (true) {
            b4.append((int) a10[i10]);
            if (i10 == iMax) {
                return b4.append(']').toString();
            }
            b4.append(", ");
            i10++;
        }
    }

    public static String toString(boolean[] a10) {
        if (a10 == null) {
            return "null";
        }
        int iMax = a10.length - 1;
        if (iMax == -1) {
            return "[]";
        }
        StringBuilder b4 = new StringBuilder();
        b4.append('[');
        int i10 = 0;
        while (true) {
            b4.append(a10[i10]);
            if (i10 == iMax) {
                return b4.append(']').toString();
            }
            b4.append(", ");
            i10++;
        }
    }

    public static String toString(float[] a10) {
        if (a10 == null) {
            return "null";
        }
        int iMax = a10.length - 1;
        if (iMax == -1) {
            return "[]";
        }
        StringBuilder b4 = new StringBuilder();
        b4.append('[');
        int i10 = 0;
        while (true) {
            b4.append(a10[i10]);
            if (i10 == iMax) {
                return b4.append(']').toString();
            }
            b4.append(", ");
            i10++;
        }
    }

    public static String toString(double[] a10) {
        if (a10 == null) {
            return "null";
        }
        int iMax = a10.length - 1;
        if (iMax == -1) {
            return "[]";
        }
        StringBuilder b4 = new StringBuilder();
        b4.append('[');
        int i10 = 0;
        while (true) {
            b4.append(a10[i10]);
            if (i10 == iMax) {
                return b4.append(']').toString();
            }
            b4.append(", ");
            i10++;
        }
    }

    public static String toString(Object[] a10) {
        if (a10 == null) {
            return "null";
        }
        int iMax = a10.length - 1;
        if (iMax == -1) {
            return "[]";
        }
        StringBuilder b4 = new StringBuilder();
        b4.append('[');
        int i10 = 0;
        while (true) {
            b4.append(String.valueOf(a10[i10]));
            if (i10 == iMax) {
                return b4.append(']').toString();
            }
            b4.append(", ");
            i10++;
        }
    }

    public static String deepToString(Object[] a10) {
        if (a10 == null) {
            return "null";
        }
        int bufLen = a10.length * 20;
        if (a10.length != 0 && bufLen <= 0) {
            bufLen = Integer.MAX_VALUE;
        }
        StringBuilder buf = new StringBuilder(bufLen);
        deepToString(a10, buf, new HashSet());
        return buf.toString();
    }

    private static void deepToString(Object[] a10, StringBuilder buf, Set<Object[]> dejaVu) {
        if (a10 == null) {
            buf.append("null");
            return;
        }
        int iMax = a10.length - 1;
        if (iMax == -1) {
            buf.append("[]");
            return;
        }
        dejaVu.add(a10);
        buf.append('[');
        int i10 = 0;
        while (true) {
            Object element = a10[i10];
            if (element == null) {
                buf.append("null");
            } else {
                Class<?> eClass = element.getClass();
                if (eClass.isArray()) {
                    if (eClass == byte[].class) {
                        buf.append(toString((byte[]) element));
                    } else if (eClass == short[].class) {
                        buf.append(toString((short[]) element));
                    } else if (eClass == int[].class) {
                        buf.append(toString((int[]) element));
                    } else if (eClass == long[].class) {
                        buf.append(toString((long[]) element));
                    } else if (eClass == char[].class) {
                        buf.append(toString((char[]) element));
                    } else if (eClass == float[].class) {
                        buf.append(toString((float[]) element));
                    } else if (eClass == double[].class) {
                        buf.append(toString((double[]) element));
                    } else if (eClass == boolean[].class) {
                        buf.append(toString((boolean[]) element));
                    } else if (dejaVu.contains(element)) {
                        buf.append("[...]");
                    } else {
                        deepToString((Object[]) element, buf, dejaVu);
                    }
                } else {
                    buf.append(element.toString());
                }
            }
            if (i10 != iMax) {
                buf.append(", ");
                i10++;
            } else {
                buf.append(']');
                dejaVu.remove(a10);
                return;
            }
        }
    }

    public static <T> void setAll(T[] array, IntFunction<? extends T> generator) {
        Objects.requireNonNull(generator);
        for (int i10 = 0; i10 < array.length; i10++) {
            array[i10] = generator.apply(i10);
        }
    }

    public static <T> void parallelSetAll(final T[] array, final IntFunction<? extends T> generator) {
        Objects.requireNonNull(generator);
        IntStream.range(0, array.length).parallel().forEach(new IntConsumer() { // from class: java.util.Arrays$$ExternalSyntheticLambda3
            @Override // java.util.function.IntConsumer
            public final void accept(int i10) {
                Arrays.lambda$parallelSetAll$0(array, generator, i10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$parallelSetAll$0(Object[] array, IntFunction generator, int i10) {
        array[i10] = generator.apply(i10);
    }

    public static void setAll(int[] array, IntUnaryOperator generator) {
        Objects.requireNonNull(generator);
        for (int i10 = 0; i10 < array.length; i10++) {
            array[i10] = generator.applyAsInt(i10);
        }
    }

    public static void parallelSetAll(final int[] array, final IntUnaryOperator generator) {
        Objects.requireNonNull(generator);
        IntStream.range(0, array.length).parallel().forEach(new IntConsumer() { // from class: java.util.Arrays$$ExternalSyntheticLambda2
            @Override // java.util.function.IntConsumer
            public final void accept(int i10) {
                Arrays.lambda$parallelSetAll$1(array, generator, i10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$parallelSetAll$1(int[] array, IntUnaryOperator generator, int i10) {
        array[i10] = generator.applyAsInt(i10);
    }

    public static void setAll(long[] array, IntToLongFunction generator) {
        Objects.requireNonNull(generator);
        for (int i10 = 0; i10 < array.length; i10++) {
            array[i10] = generator.applyAsLong(i10);
        }
    }

    public static void parallelSetAll(final long[] array, final IntToLongFunction generator) {
        Objects.requireNonNull(generator);
        IntStream.range(0, array.length).parallel().forEach(new IntConsumer() { // from class: java.util.Arrays$$ExternalSyntheticLambda0
            @Override // java.util.function.IntConsumer
            public final void accept(int i10) {
                Arrays.lambda$parallelSetAll$2(array, generator, i10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$parallelSetAll$2(long[] array, IntToLongFunction generator, int i10) {
        array[i10] = generator.applyAsLong(i10);
    }

    public static void setAll(double[] array, IntToDoubleFunction generator) {
        Objects.requireNonNull(generator);
        for (int i10 = 0; i10 < array.length; i10++) {
            array[i10] = generator.applyAsDouble(i10);
        }
    }

    public static void parallelSetAll(final double[] array, final IntToDoubleFunction generator) {
        Objects.requireNonNull(generator);
        IntStream.range(0, array.length).parallel().forEach(new IntConsumer() { // from class: java.util.Arrays$$ExternalSyntheticLambda1
            @Override // java.util.function.IntConsumer
            public final void accept(int i10) {
                Arrays.lambda$parallelSetAll$3(array, generator, i10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$parallelSetAll$3(double[] array, IntToDoubleFunction generator, int i10) {
        array[i10] = generator.applyAsDouble(i10);
    }

    public static <T> Spliterator<T> spliterator(T[] array) {
        return Spliterators.spliterator(array, DownloadErrorCode.ERROR_OUTPUT_STREAM_SET_LENGTH_IO);
    }

    public static <T> Spliterator<T> spliterator(T[] array, int startInclusive, int endExclusive) {
        return Spliterators.spliterator(array, startInclusive, endExclusive, DownloadErrorCode.ERROR_OUTPUT_STREAM_SET_LENGTH_IO);
    }

    public static Spliterator.OfInt spliterator(int[] array) {
        return Spliterators.spliterator(array, DownloadErrorCode.ERROR_OUTPUT_STREAM_SET_LENGTH_IO);
    }

    public static Spliterator.OfInt spliterator(int[] array, int startInclusive, int endExclusive) {
        return Spliterators.spliterator(array, startInclusive, endExclusive, DownloadErrorCode.ERROR_OUTPUT_STREAM_SET_LENGTH_IO);
    }

    public static Spliterator.OfLong spliterator(long[] array) {
        return Spliterators.spliterator(array, DownloadErrorCode.ERROR_OUTPUT_STREAM_SET_LENGTH_IO);
    }

    public static Spliterator.OfLong spliterator(long[] array, int startInclusive, int endExclusive) {
        return Spliterators.spliterator(array, startInclusive, endExclusive, DownloadErrorCode.ERROR_OUTPUT_STREAM_SET_LENGTH_IO);
    }

    public static Spliterator.OfDouble spliterator(double[] array) {
        return Spliterators.spliterator(array, DownloadErrorCode.ERROR_OUTPUT_STREAM_SET_LENGTH_IO);
    }

    public static Spliterator.OfDouble spliterator(double[] array, int startInclusive, int endExclusive) {
        return Spliterators.spliterator(array, startInclusive, endExclusive, DownloadErrorCode.ERROR_OUTPUT_STREAM_SET_LENGTH_IO);
    }

    public static <T> Stream<T> stream(T[] array) {
        return stream(array, 0, array.length);
    }

    public static <T> Stream<T> stream(T[] array, int startInclusive, int endExclusive) {
        return StreamSupport.stream(spliterator(array, startInclusive, endExclusive), false);
    }

    public static IntStream stream(int[] array) {
        return stream(array, 0, array.length);
    }

    public static IntStream stream(int[] array, int startInclusive, int endExclusive) {
        return StreamSupport.intStream(spliterator(array, startInclusive, endExclusive), false);
    }

    public static LongStream stream(long[] array) {
        return stream(array, 0, array.length);
    }

    public static LongStream stream(long[] array, int startInclusive, int endExclusive) {
        return StreamSupport.longStream(spliterator(array, startInclusive, endExclusive), false);
    }

    public static DoubleStream stream(double[] array) {
        return stream(array, 0, array.length);
    }

    public static DoubleStream stream(double[] array, int startInclusive, int endExclusive) {
        return StreamSupport.doubleStream(spliterator(array, startInclusive, endExclusive), false);
    }

    public static int compare(boolean[] a10, boolean[] b4) {
        if (a10 == b4) {
            return 0;
        }
        if (a10 == null || b4 == null) {
            return a10 == null ? -1 : 1;
        }
        int i10 = ArraysSupport.mismatch(a10, b4, Math.min(a10.length, b4.length));
        if (i10 >= 0) {
            return Boolean.compare(a10[i10], b4[i10]);
        }
        return a10.length - b4.length;
    }

    public static int compare(boolean[] a10, int aFromIndex, int aToIndex, boolean[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        int i10 = ArraysSupport.mismatch(a10, aFromIndex, b4, bFromIndex, Math.min(aLength, bLength));
        if (i10 >= 0) {
            return Boolean.compare(a10[aFromIndex + i10], b4[bFromIndex + i10]);
        }
        return aLength - bLength;
    }

    public static int compare(byte[] a10, byte[] b4) {
        if (a10 == b4) {
            return 0;
        }
        if (a10 == null || b4 == null) {
            return a10 == null ? -1 : 1;
        }
        int i10 = ArraysSupport.mismatch(a10, b4, Math.min(a10.length, b4.length));
        if (i10 >= 0) {
            return Byte.compare(a10[i10], b4[i10]);
        }
        return a10.length - b4.length;
    }

    public static int compare(byte[] a10, int aFromIndex, int aToIndex, byte[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        int i10 = ArraysSupport.mismatch(a10, aFromIndex, b4, bFromIndex, Math.min(aLength, bLength));
        if (i10 >= 0) {
            return Byte.compare(a10[aFromIndex + i10], b4[bFromIndex + i10]);
        }
        return aLength - bLength;
    }

    public static int compareUnsigned(byte[] a10, byte[] b4) {
        if (a10 == b4) {
            return 0;
        }
        if (a10 == null || b4 == null) {
            return a10 == null ? -1 : 1;
        }
        int i10 = ArraysSupport.mismatch(a10, b4, Math.min(a10.length, b4.length));
        if (i10 >= 0) {
            return Byte.compareUnsigned(a10[i10], b4[i10]);
        }
        return a10.length - b4.length;
    }

    public static int compareUnsigned(byte[] a10, int aFromIndex, int aToIndex, byte[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        int i10 = ArraysSupport.mismatch(a10, aFromIndex, b4, bFromIndex, Math.min(aLength, bLength));
        if (i10 >= 0) {
            return Byte.compareUnsigned(a10[aFromIndex + i10], b4[bFromIndex + i10]);
        }
        return aLength - bLength;
    }

    public static int compare(short[] a10, short[] b4) {
        if (a10 == b4) {
            return 0;
        }
        if (a10 == null || b4 == null) {
            return a10 == null ? -1 : 1;
        }
        int i10 = ArraysSupport.mismatch(a10, b4, Math.min(a10.length, b4.length));
        if (i10 >= 0) {
            return Short.compare(a10[i10], b4[i10]);
        }
        return a10.length - b4.length;
    }

    public static int compare(short[] a10, int aFromIndex, int aToIndex, short[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        int i10 = ArraysSupport.mismatch(a10, aFromIndex, b4, bFromIndex, Math.min(aLength, bLength));
        if (i10 >= 0) {
            return Short.compare(a10[aFromIndex + i10], b4[bFromIndex + i10]);
        }
        return aLength - bLength;
    }

    public static int compareUnsigned(short[] a10, short[] b4) {
        if (a10 == b4) {
            return 0;
        }
        if (a10 == null || b4 == null) {
            return a10 == null ? -1 : 1;
        }
        int i10 = ArraysSupport.mismatch(a10, b4, Math.min(a10.length, b4.length));
        if (i10 >= 0) {
            return Short.compareUnsigned(a10[i10], b4[i10]);
        }
        return a10.length - b4.length;
    }

    public static int compareUnsigned(short[] a10, int aFromIndex, int aToIndex, short[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        int i10 = ArraysSupport.mismatch(a10, aFromIndex, b4, bFromIndex, Math.min(aLength, bLength));
        if (i10 >= 0) {
            return Short.compareUnsigned(a10[aFromIndex + i10], b4[bFromIndex + i10]);
        }
        return aLength - bLength;
    }

    public static int compare(char[] a10, char[] b4) {
        if (a10 == b4) {
            return 0;
        }
        if (a10 == null || b4 == null) {
            return a10 == null ? -1 : 1;
        }
        int i10 = ArraysSupport.mismatch(a10, b4, Math.min(a10.length, b4.length));
        if (i10 >= 0) {
            return Character.compare(a10[i10], b4[i10]);
        }
        return a10.length - b4.length;
    }

    public static int compare(char[] a10, int aFromIndex, int aToIndex, char[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        int i10 = ArraysSupport.mismatch(a10, aFromIndex, b4, bFromIndex, Math.min(aLength, bLength));
        if (i10 >= 0) {
            return Character.compare(a10[aFromIndex + i10], b4[bFromIndex + i10]);
        }
        return aLength - bLength;
    }

    public static int compare(int[] a10, int[] b4) {
        if (a10 == b4) {
            return 0;
        }
        if (a10 == null || b4 == null) {
            return a10 == null ? -1 : 1;
        }
        int i10 = ArraysSupport.mismatch(a10, b4, Math.min(a10.length, b4.length));
        if (i10 >= 0) {
            return Integer.compare(a10[i10], b4[i10]);
        }
        return a10.length - b4.length;
    }

    public static int compare(int[] a10, int aFromIndex, int aToIndex, int[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        int i10 = ArraysSupport.mismatch(a10, aFromIndex, b4, bFromIndex, Math.min(aLength, bLength));
        if (i10 >= 0) {
            return Integer.compare(a10[aFromIndex + i10], b4[bFromIndex + i10]);
        }
        return aLength - bLength;
    }

    public static int compareUnsigned(int[] a10, int[] b4) {
        if (a10 == b4) {
            return 0;
        }
        if (a10 == null || b4 == null) {
            return a10 == null ? -1 : 1;
        }
        int i10 = ArraysSupport.mismatch(a10, b4, Math.min(a10.length, b4.length));
        if (i10 >= 0) {
            return Integer.compareUnsigned(a10[i10], b4[i10]);
        }
        return a10.length - b4.length;
    }

    public static int compareUnsigned(int[] a10, int aFromIndex, int aToIndex, int[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        int i10 = ArraysSupport.mismatch(a10, aFromIndex, b4, bFromIndex, Math.min(aLength, bLength));
        if (i10 >= 0) {
            return Integer.compareUnsigned(a10[aFromIndex + i10], b4[bFromIndex + i10]);
        }
        return aLength - bLength;
    }

    public static int compare(long[] a10, long[] b4) {
        if (a10 == b4) {
            return 0;
        }
        if (a10 == null || b4 == null) {
            return a10 == null ? -1 : 1;
        }
        int i10 = ArraysSupport.mismatch(a10, b4, Math.min(a10.length, b4.length));
        if (i10 >= 0) {
            return Long.compare(a10[i10], b4[i10]);
        }
        return a10.length - b4.length;
    }

    public static int compare(long[] a10, int aFromIndex, int aToIndex, long[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        int i10 = ArraysSupport.mismatch(a10, aFromIndex, b4, bFromIndex, Math.min(aLength, bLength));
        if (i10 >= 0) {
            return Long.compare(a10[aFromIndex + i10], b4[bFromIndex + i10]);
        }
        return aLength - bLength;
    }

    public static int compareUnsigned(long[] a10, long[] b4) {
        if (a10 == b4) {
            return 0;
        }
        if (a10 == null || b4 == null) {
            return a10 == null ? -1 : 1;
        }
        int i10 = ArraysSupport.mismatch(a10, b4, Math.min(a10.length, b4.length));
        if (i10 >= 0) {
            return Long.compareUnsigned(a10[i10], b4[i10]);
        }
        return a10.length - b4.length;
    }

    public static int compareUnsigned(long[] a10, int aFromIndex, int aToIndex, long[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        int i10 = ArraysSupport.mismatch(a10, aFromIndex, b4, bFromIndex, Math.min(aLength, bLength));
        if (i10 >= 0) {
            return Long.compareUnsigned(a10[aFromIndex + i10], b4[bFromIndex + i10]);
        }
        return aLength - bLength;
    }

    public static int compare(float[] a10, float[] b4) {
        if (a10 == b4) {
            return 0;
        }
        if (a10 == null || b4 == null) {
            return a10 == null ? -1 : 1;
        }
        int i10 = ArraysSupport.mismatch(a10, b4, Math.min(a10.length, b4.length));
        if (i10 >= 0) {
            return Float.compare(a10[i10], b4[i10]);
        }
        return a10.length - b4.length;
    }

    public static int compare(float[] a10, int aFromIndex, int aToIndex, float[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        int i10 = ArraysSupport.mismatch(a10, aFromIndex, b4, bFromIndex, Math.min(aLength, bLength));
        if (i10 >= 0) {
            return Float.compare(a10[aFromIndex + i10], b4[bFromIndex + i10]);
        }
        return aLength - bLength;
    }

    public static int compare(double[] a10, double[] b4) {
        if (a10 == b4) {
            return 0;
        }
        if (a10 == null || b4 == null) {
            return a10 == null ? -1 : 1;
        }
        int i10 = ArraysSupport.mismatch(a10, b4, Math.min(a10.length, b4.length));
        if (i10 >= 0) {
            return Double.compare(a10[i10], b4[i10]);
        }
        return a10.length - b4.length;
    }

    public static int compare(double[] a10, int aFromIndex, int aToIndex, double[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        int i10 = ArraysSupport.mismatch(a10, aFromIndex, b4, bFromIndex, Math.min(aLength, bLength));
        if (i10 >= 0) {
            return Double.compare(a10[aFromIndex + i10], b4[bFromIndex + i10]);
        }
        return aLength - bLength;
    }

    public static <T extends Comparable<? super T>> int compare(T[] a10, T[] b4) {
        if (a10 == b4) {
            return 0;
        }
        if (a10 == null || b4 == null) {
            return a10 == null ? -1 : 1;
        }
        int length = Math.min(a10.length, b4.length);
        for (int i10 = 0; i10 < length; i10++) {
            T oa2 = a10[i10];
            T ob2 = b4[i10];
            if (oa2 != ob2) {
                if (oa2 == null || ob2 == null) {
                    return oa2 == null ? -1 : 1;
                }
                int v2 = oa2.compareTo(ob2);
                if (v2 != 0) {
                    return v2;
                }
            }
        }
        return a10.length - b4.length;
    }

    public static <T extends Comparable<? super T>> int compare(T[] a10, int aFromIndex, int aToIndex, T[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        int length = Math.min(aLength, bLength);
        int i10 = 0;
        while (i10 < length) {
            int aFromIndex2 = aFromIndex + 1;
            T oa2 = a10[aFromIndex];
            int bFromIndex2 = bFromIndex + 1;
            T ob2 = b4[bFromIndex];
            if (oa2 != ob2) {
                if (oa2 == null || ob2 == null) {
                    return oa2 == null ? -1 : 1;
                }
                int v2 = oa2.compareTo(ob2);
                if (v2 != 0) {
                    return v2;
                }
            }
            i10++;
            aFromIndex = aFromIndex2;
            bFromIndex = bFromIndex2;
        }
        int i11 = aLength - bLength;
        return i11;
    }

    public static <T> int compare(T[] a10, T[] b4, Comparator<? super T> cmp) {
        int v2;
        Objects.requireNonNull(cmp);
        if (a10 == b4) {
            return 0;
        }
        if (a10 == null || b4 == null) {
            return a10 == null ? -1 : 1;
        }
        int length = Math.min(a10.length, b4.length);
        for (int i10 = 0; i10 < length; i10++) {
            T oa2 = a10[i10];
            T ob2 = b4[i10];
            if (oa2 != ob2 && (v2 = cmp.compare(oa2, ob2)) != 0) {
                return v2;
            }
        }
        int i11 = a10.length;
        return i11 - b4.length;
    }

    public static <T> int compare(T[] a10, int aFromIndex, int aToIndex, T[] b4, int bFromIndex, int bToIndex, Comparator<? super T> cmp) {
        int v2;
        Objects.requireNonNull(cmp);
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        int length = Math.min(aLength, bLength);
        int i10 = 0;
        while (i10 < length) {
            int aFromIndex2 = aFromIndex + 1;
            T oa2 = a10[aFromIndex];
            int bFromIndex2 = bFromIndex + 1;
            T ob2 = b4[bFromIndex];
            if (oa2 == ob2 || (v2 = cmp.compare(oa2, ob2)) == 0) {
                i10++;
                aFromIndex = aFromIndex2;
                bFromIndex = bFromIndex2;
            } else {
                return v2;
            }
        }
        int i11 = aLength - bLength;
        return i11;
    }

    public static int mismatch(boolean[] a10, boolean[] b4) {
        int length = Math.min(a10.length, b4.length);
        if (a10 == b4) {
            return -1;
        }
        int i10 = ArraysSupport.mismatch(a10, b4, length);
        return (i10 >= 0 || a10.length == b4.length) ? i10 : length;
    }

    public static int mismatch(boolean[] a10, int aFromIndex, int aToIndex, boolean[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        int length = Math.min(aLength, bLength);
        int i10 = ArraysSupport.mismatch(a10, aFromIndex, b4, bFromIndex, length);
        return (i10 >= 0 || aLength == bLength) ? i10 : length;
    }

    public static int mismatch(byte[] a10, byte[] b4) {
        int length = Math.min(a10.length, b4.length);
        if (a10 == b4) {
            return -1;
        }
        int i10 = ArraysSupport.mismatch(a10, b4, length);
        return (i10 >= 0 || a10.length == b4.length) ? i10 : length;
    }

    public static int mismatch(byte[] a10, int aFromIndex, int aToIndex, byte[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        int length = Math.min(aLength, bLength);
        int i10 = ArraysSupport.mismatch(a10, aFromIndex, b4, bFromIndex, length);
        return (i10 >= 0 || aLength == bLength) ? i10 : length;
    }

    public static int mismatch(char[] a10, char[] b4) {
        int length = Math.min(a10.length, b4.length);
        if (a10 == b4) {
            return -1;
        }
        int i10 = ArraysSupport.mismatch(a10, b4, length);
        return (i10 >= 0 || a10.length == b4.length) ? i10 : length;
    }

    public static int mismatch(char[] a10, int aFromIndex, int aToIndex, char[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        int length = Math.min(aLength, bLength);
        int i10 = ArraysSupport.mismatch(a10, aFromIndex, b4, bFromIndex, length);
        return (i10 >= 0 || aLength == bLength) ? i10 : length;
    }

    public static int mismatch(short[] a10, short[] b4) {
        int length = Math.min(a10.length, b4.length);
        if (a10 == b4) {
            return -1;
        }
        int i10 = ArraysSupport.mismatch(a10, b4, length);
        return (i10 >= 0 || a10.length == b4.length) ? i10 : length;
    }

    public static int mismatch(short[] a10, int aFromIndex, int aToIndex, short[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        int length = Math.min(aLength, bLength);
        int i10 = ArraysSupport.mismatch(a10, aFromIndex, b4, bFromIndex, length);
        return (i10 >= 0 || aLength == bLength) ? i10 : length;
    }

    public static int mismatch(int[] a10, int[] b4) {
        int length = Math.min(a10.length, b4.length);
        if (a10 == b4) {
            return -1;
        }
        int i10 = ArraysSupport.mismatch(a10, b4, length);
        return (i10 >= 0 || a10.length == b4.length) ? i10 : length;
    }

    public static int mismatch(int[] a10, int aFromIndex, int aToIndex, int[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        int length = Math.min(aLength, bLength);
        int i10 = ArraysSupport.mismatch(a10, aFromIndex, b4, bFromIndex, length);
        return (i10 >= 0 || aLength == bLength) ? i10 : length;
    }

    public static int mismatch(long[] a10, long[] b4) {
        int length = Math.min(a10.length, b4.length);
        if (a10 == b4) {
            return -1;
        }
        int i10 = ArraysSupport.mismatch(a10, b4, length);
        return (i10 >= 0 || a10.length == b4.length) ? i10 : length;
    }

    public static int mismatch(long[] a10, int aFromIndex, int aToIndex, long[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        int length = Math.min(aLength, bLength);
        int i10 = ArraysSupport.mismatch(a10, aFromIndex, b4, bFromIndex, length);
        return (i10 >= 0 || aLength == bLength) ? i10 : length;
    }

    public static int mismatch(float[] a10, float[] b4) {
        int length = Math.min(a10.length, b4.length);
        if (a10 == b4) {
            return -1;
        }
        int i10 = ArraysSupport.mismatch(a10, b4, length);
        return (i10 >= 0 || a10.length == b4.length) ? i10 : length;
    }

    public static int mismatch(float[] a10, int aFromIndex, int aToIndex, float[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        int length = Math.min(aLength, bLength);
        int i10 = ArraysSupport.mismatch(a10, aFromIndex, b4, bFromIndex, length);
        return (i10 >= 0 || aLength == bLength) ? i10 : length;
    }

    public static int mismatch(double[] a10, double[] b4) {
        int length = Math.min(a10.length, b4.length);
        if (a10 == b4) {
            return -1;
        }
        int i10 = ArraysSupport.mismatch(a10, b4, length);
        return (i10 >= 0 || a10.length == b4.length) ? i10 : length;
    }

    public static int mismatch(double[] a10, int aFromIndex, int aToIndex, double[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        int length = Math.min(aLength, bLength);
        int i10 = ArraysSupport.mismatch(a10, aFromIndex, b4, bFromIndex, length);
        return (i10 >= 0 || aLength == bLength) ? i10 : length;
    }

    public static int mismatch(Object[] a10, Object[] b4) {
        int length = Math.min(a10.length, b4.length);
        if (a10 == b4) {
            return -1;
        }
        for (int i10 = 0; i10 < length; i10++) {
            if (!Objects.equals(a10[i10], b4[i10])) {
                return i10;
            }
        }
        int i11 = a10.length;
        if (i11 != b4.length) {
            return length;
        }
        return -1;
    }

    public static int mismatch(Object[] a10, int aFromIndex, int aToIndex, Object[] b4, int bFromIndex, int bToIndex) {
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        int length = Math.min(aLength, bLength);
        int i10 = 0;
        while (i10 < length) {
            int aFromIndex2 = aFromIndex + 1;
            int bFromIndex2 = bFromIndex + 1;
            if (Objects.equals(a10[aFromIndex], b4[bFromIndex])) {
                i10++;
                aFromIndex = aFromIndex2;
                bFromIndex = bFromIndex2;
            } else {
                return i10;
            }
        }
        if (aLength != bLength) {
            return length;
        }
        return -1;
    }

    public static <T> int mismatch(T[] a10, T[] b4, Comparator<? super T> cmp) {
        Objects.requireNonNull(cmp);
        int length = Math.min(a10.length, b4.length);
        if (a10 == b4) {
            return -1;
        }
        for (int i10 = 0; i10 < length; i10++) {
            T oa2 = a10[i10];
            T ob2 = b4[i10];
            if (oa2 != ob2) {
                int v2 = cmp.compare(oa2, ob2);
                if (v2 != 0) {
                    return i10;
                }
            }
        }
        int i11 = a10.length;
        if (i11 != b4.length) {
            return length;
        }
        return -1;
    }

    public static <T> int mismatch(T[] a10, int aFromIndex, int aToIndex, T[] b4, int bFromIndex, int bToIndex, Comparator<? super T> cmp) {
        Objects.requireNonNull(cmp);
        rangeCheck(a10.length, aFromIndex, aToIndex);
        rangeCheck(b4.length, bFromIndex, bToIndex);
        int aLength = aToIndex - aFromIndex;
        int bLength = bToIndex - bFromIndex;
        int length = Math.min(aLength, bLength);
        int i10 = 0;
        while (i10 < length) {
            int aFromIndex2 = aFromIndex + 1;
            T oa2 = a10[aFromIndex];
            int bFromIndex2 = bFromIndex + 1;
            T ob2 = b4[bFromIndex];
            if (oa2 != ob2) {
                int v2 = cmp.compare(oa2, ob2);
                if (v2 != 0) {
                    return i10;
                }
            }
            i10++;
            aFromIndex = aFromIndex2;
            bFromIndex = bFromIndex2;
        }
        if (aLength != bLength) {
            return length;
        }
        return -1;
    }
}
