package java.util;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.RecursiveTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class DualPivotQuicksort {
    private static final int DELTA = 6;
    private static final int MAX_BYTE_INDEX = 384;
    private static final int MAX_INSERTION_SORT_SIZE = 44;
    private static final int MAX_MIXED_INSERTION_SORT_SIZE = 65;
    private static final int MAX_RECURSION_DEPTH = 384;
    private static final int MAX_RUN_CAPACITY = 5120;
    private static final int MAX_SHORT_INDEX = 98304;
    private static final int MIN_BYTE_COUNTING_SORT_SIZE = 64;
    private static final int MIN_FIRST_RUNS_FACTOR = 7;
    private static final int MIN_FIRST_RUN_SIZE = 16;
    private static final int MIN_PARALLEL_MERGE_PARTS_SIZE = 4096;
    private static final int MIN_PARALLEL_SORT_SIZE = 4096;
    private static final int MIN_RUN_COUNT = 4;
    private static final int MIN_SHORT_OR_CHAR_COUNTING_SORT_SIZE = 1750;
    private static final int MIN_TRY_MERGE_SIZE = 4096;
    private static final int NUM_BYTE_VALUES = 256;
    private static final int NUM_CHAR_VALUES = 65536;
    private static final int NUM_SHORT_VALUES = 65536;

    private DualPivotQuicksort() {
    }

    private static int getDepth(int parallelism, int size) {
        int depth = 0;
        while (true) {
            int i10 = parallelism >> 3;
            parallelism = i10;
            if (i10 <= 0) {
                break;
            }
            int i11 = size >> 2;
            size = i11;
            if (i11 <= 0) {
                break;
            }
            depth -= 2;
        }
        return depth;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void sort(int[] a10, int parallelism, int low, int high) {
        int size = high - low;
        if (parallelism > 1 && size > 4096) {
            int depth = getDepth(parallelism, size >> 12);
            int[] b4 = depth == 0 ? null : new int[size];
            new Sorter(null, a10, b4, low, size, low, depth).invoke();
            return;
        }
        sort((Sorter) null, a10, 0, low, high);
    }

    static void sort(Sorter sorter, int[] a10, int bits, int low, int high) {
        int e2;
        int bits2 = bits;
        int high2 = high;
        while (true) {
            int end = high2 - 1;
            int size = high2 - low;
            if (size < bits2 + 65 && (bits2 & 1) > 0) {
                mixedInsertionSort(a10, low, high2 - (((size >> 5) << 3) * 3), high2);
                return;
            }
            if (size < 44) {
                insertionSort(a10, low, high2);
                return;
            }
            if ((bits2 == 0 || (size > 4096 && (bits2 & 1) > 0)) && tryMergeRuns(sorter, a10, low, size)) {
                return;
            }
            bits2 += 6;
            if (bits2 > 384) {
                heapSort(a10, low, high2);
                return;
            }
            int step = ((size >> 3) * 3) + 3;
            int e12 = low + step;
            int ak = end - step;
            int e32 = (e12 + ak) >>> 1;
            int e22 = (e12 + e32) >>> 1;
            int e42 = (e32 + ak) >>> 1;
            int a32 = a10[e32];
            if (a10[ak] < a10[e22]) {
                int t2 = a10[ak];
                a10[ak] = a10[e22];
                a10[e22] = t2;
            }
            int t10 = a10[e42];
            if (t10 < a10[e12]) {
                int t11 = a10[e42];
                a10[e42] = a10[e12];
                a10[e12] = t11;
            }
            int t12 = a10[ak];
            if (t12 < a10[e42]) {
                int t13 = a10[ak];
                a10[ak] = a10[e42];
                a10[e42] = t13;
            }
            int t14 = a10[e22];
            if (t14 < a10[e12]) {
                int t15 = a10[e22];
                a10[e22] = a10[e12];
                a10[e12] = t15;
            }
            int t16 = a10[e42];
            if (t16 < a10[e22]) {
                int t17 = a10[e42];
                a10[e42] = a10[e22];
                a10[e22] = t17;
            }
            int t18 = a10[e22];
            if (a32 < t18) {
                if (a32 < a10[e12]) {
                    a10[e32] = a10[e22];
                    a10[e22] = a10[e12];
                    a10[e12] = a32;
                } else {
                    a10[e32] = a10[e22];
                    a10[e22] = a32;
                }
            } else if (a32 > a10[e42]) {
                if (a32 > a10[ak]) {
                    a10[e32] = a10[e42];
                    a10[e42] = a10[ak];
                    a10[ak] = a32;
                } else {
                    a10[e32] = a10[e42];
                    a10[e42] = a32;
                }
            }
            int lower = low;
            int upper = end;
            if (a10[e12] < a10[e22] && a10[e22] < a10[e32] && a10[e32] < a10[e42] && a10[e42] < a10[ak]) {
                int pivot1 = a10[e12];
                int pivot2 = a10[ak];
                a10[e12] = a10[lower];
                a10[ak] = a10[upper];
                while (true) {
                    lower++;
                    int e13 = e12;
                    if (a10[lower] >= pivot1) {
                        break;
                    } else {
                        e12 = e13;
                    }
                }
                do {
                    upper--;
                } while (a10[upper] > pivot2);
                lower--;
                int k10 = lower;
                int upper2 = upper + 1;
                int e52 = upper2;
                while (true) {
                    int unused = k10;
                    int unused2 = e52 - 1;
                    if (unused2 <= lower) {
                        break;
                    }
                    int e53 = ak;
                    int e54 = a10[unused2];
                    if (e54 < pivot1) {
                        while (true) {
                            if (lower >= unused2) {
                                e2 = e22;
                                break;
                            }
                            lower++;
                            e2 = e22;
                            if (a10[lower] < pivot1) {
                                e22 = e2;
                            } else {
                                if (a10[lower] > pivot2) {
                                    upper2--;
                                    a10[unused2] = a10[upper2];
                                    a10[upper2] = a10[lower];
                                } else {
                                    a10[unused2] = a10[lower];
                                }
                                a10[lower] = e54;
                            }
                        }
                    } else {
                        e2 = e22;
                        if (e54 > pivot2) {
                            upper2--;
                            a10[unused2] = a10[upper2];
                            a10[upper2] = e54;
                        }
                    }
                    ak = e53;
                    e22 = e2;
                    e52 = unused2;
                    k10 = unused;
                }
                int k11 = a10[lower];
                a10[low] = k11;
                a10[lower] = pivot1;
                a10[end] = a10[upper2];
                a10[upper2] = pivot2;
                if (size <= 4096 || sorter == null) {
                    sort(sorter, a10, bits2 | 1, lower + 1, upper2);
                    sort(sorter, a10, bits2 | 1, upper2 + 1, high2);
                } else {
                    sorter.forkSorter(bits2 | 1, lower + 1, upper2);
                    sorter.forkSorter(bits2 | 1, upper2 + 1, high2);
                }
            } else {
                int pivot = a10[e32];
                a10[e32] = a10[lower];
                int upper3 = upper + 1;
                int k12 = upper3;
                while (true) {
                    k12--;
                    if (k12 <= lower) {
                        break;
                    }
                    int ak2 = a10[k12];
                    if (ak2 != pivot) {
                        a10[k12] = pivot;
                        if (ak2 < pivot) {
                            do {
                                lower++;
                            } while (a10[lower] < pivot);
                            if (a10[lower] > pivot) {
                                upper3--;
                                a10[upper3] = a10[lower];
                            }
                            a10[lower] = ak2;
                        } else {
                            upper3--;
                            a10[upper3] = ak2;
                        }
                    }
                }
                int k13 = a10[lower];
                a10[low] = k13;
                a10[lower] = pivot;
                if (size <= 4096 || sorter == null) {
                    sort(sorter, a10, bits2 | 1, upper3, high2);
                } else {
                    sorter.forkSorter(bits2 | 1, upper3, high2);
                }
            }
            high2 = lower;
        }
    }

    private static void mixedInsertionSort(int[] a10, int low, int end, int high) {
        if (end != high) {
            int pin = a10[end];
            int p10 = high;
            while (true) {
                low++;
                if (low >= end) {
                    break;
                }
                int i10 = low;
                int ai = a10[low];
                if (ai < a10[i10 - 1]) {
                    int i11 = i10 - 1;
                    a10[i10] = a10[i11];
                    while (true) {
                        i11--;
                        if (ai >= a10[i11]) {
                            break;
                        } else {
                            a10[i11 + 1] = a10[i11];
                        }
                    }
                    a10[i11 + 1] = ai;
                } else if (p10 > i10 && ai > pin) {
                    do {
                        p10--;
                    } while (a10[p10] > pin);
                    if (p10 > i10) {
                        ai = a10[p10];
                        a10[p10] = a10[i10];
                    }
                    while (true) {
                        i10--;
                        if (ai >= a10[i10]) {
                            break;
                        } else {
                            a10[i10 + 1] = a10[i10];
                        }
                    }
                    a10[i10 + 1] = ai;
                }
            }
            while (low < high) {
                int i12 = low;
                int a12 = a10[low];
                int low2 = low + 1;
                int a22 = a10[low2];
                if (a12 > a22) {
                    while (true) {
                        i12--;
                        if (a12 >= a10[i12]) {
                            break;
                        } else {
                            a10[i12 + 2] = a10[i12];
                        }
                    }
                    int i13 = i12 + 1;
                    a10[i13 + 1] = a12;
                    while (true) {
                        i13--;
                        if (a22 >= a10[i13]) {
                            break;
                        } else {
                            a10[i13 + 1] = a10[i13];
                        }
                    }
                    a10[i13 + 1] = a22;
                } else if (a12 < a10[i12 - 1]) {
                    while (true) {
                        i12--;
                        if (a22 >= a10[i12]) {
                            break;
                        } else {
                            a10[i12 + 2] = a10[i12];
                        }
                    }
                    int i14 = i12 + 1;
                    a10[i14 + 1] = a22;
                    while (true) {
                        i14--;
                        if (a12 >= a10[i14]) {
                            break;
                        } else {
                            a10[i14 + 1] = a10[i14];
                        }
                    }
                    a10[i14 + 1] = a12;
                }
                low = low2 + 1;
            }
            return;
        }
        while (true) {
            low++;
            if (low < end) {
                int i15 = low;
                int ai2 = a10[low];
                while (true) {
                    i15--;
                    if (ai2 < a10[i15]) {
                        a10[i15 + 1] = a10[i15];
                    }
                }
                a10[i15 + 1] = ai2;
            } else {
                return;
            }
        }
    }

    private static void insertionSort(int[] a10, int low, int high) {
        int k10 = low;
        while (true) {
            k10++;
            if (k10 < high) {
                int i10 = k10;
                int ai = a10[k10];
                if (ai < a10[i10 - 1]) {
                    while (true) {
                        i10--;
                        if (i10 < low || ai >= a10[i10]) {
                            break;
                        } else {
                            a10[i10 + 1] = a10[i10];
                        }
                    }
                    a10[i10 + 1] = ai;
                }
            } else {
                return;
            }
        }
    }

    private static void heapSort(int[] a10, int low, int high) {
        int k10 = (low + high) >>> 1;
        while (k10 > low) {
            k10--;
            pushDown(a10, k10, a10[k10], low, high);
        }
        while (true) {
            high--;
            if (high > low) {
                int max = a10[low];
                pushDown(a10, low, a10[high], low, high);
                a10[high] = max;
            } else {
                return;
            }
        }
    }

    private static void pushDown(int[] a10, int p10, int value, int low, int high) {
        while (true) {
            int k10 = ((p10 << 1) - low) + 2;
            if (k10 > high) {
                break;
            }
            if (k10 == high || a10[k10] < a10[k10 - 1]) {
                k10--;
            }
            if (a10[k10] <= value) {
                break;
            }
            int p11 = k10;
            a10[p10] = a10[k10];
            p10 = p11;
        }
        a10[p10] = value;
    }

    private static boolean tryMergeRuns(Sorter sorter, int[] a10, int low, int size) {
        int offset;
        int[] b4;
        int[] b10;
        int high = low + size;
        int k10 = low + 1;
        int[] run = null;
        int count = 1;
        int last = low;
        while (k10 < high) {
            if (a10[k10 - 1] < a10[k10]) {
                do {
                    k10++;
                    if (k10 >= high) {
                        break;
                    }
                } while (a10[k10 - 1] <= a10[k10]);
            } else if (a10[k10 - 1] > a10[k10]) {
                do {
                    k10++;
                    if (k10 >= high) {
                        break;
                    }
                } while (a10[k10 - 1] >= a10[k10]);
                int i10 = last - 1;
                int j10 = k10;
                while (true) {
                    i10++;
                    j10--;
                    if (i10 >= j10 || a10[i10] <= a10[j10]) {
                        break;
                    }
                    int ai = a10[i10];
                    a10[i10] = a10[j10];
                    a10[j10] = ai;
                }
            } else {
                int ak = a10[k10];
                do {
                    k10++;
                    if (k10 >= high) {
                        break;
                    }
                } while (ak == a10[k10]);
                if (k10 < high) {
                    continue;
                }
            }
            if (run == null) {
                if (k10 == high) {
                    return true;
                }
                if (k10 - low < 16) {
                    return false;
                }
                int[] run2 = new int[((size >> 10) | 127) & 1023];
                run2[0] = low;
                run = run2;
            } else if (a10[last - 1] > a10[last]) {
                if (count > ((k10 - low) >> 7) || (count = count + 1) == MAX_RUN_CAPACITY) {
                    return false;
                }
                if (count == run.length) {
                    run = Arrays.copyOf(run, count << 1);
                }
            }
            last = k10;
            run[count] = k10;
        }
        if (count > 1) {
            if (sorter == null || (b10 = (int[]) sorter.f50462b) == null) {
                int[] b11 = new int[size];
                offset = low;
                b4 = b11;
            } else {
                int offset2 = sorter.offset;
                offset = offset2;
                b4 = b10;
            }
            mergeRuns(a10, b4, offset, 1, sorter != null, run, 0, count);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int[] mergeRuns(int[] a10, int[] b4, int offset, int aim, boolean parallel, int[] run, int lo, int hi) {
        int mi;
        int[] a22;
        int[] a12;
        if (hi - lo == 1) {
            if (aim >= 0) {
                return a10;
            }
            int i10 = run[hi];
            int j10 = i10 - offset;
            int low = run[lo];
            while (i10 > low) {
                j10--;
                i10--;
                b4[j10] = a10[i10];
            }
            return b4;
        }
        int mi2 = lo;
        int rmi = (run[lo] + run[hi]) >>> 1;
        while (true) {
            mi = mi2 + 1;
            if (run[mi + 1] > rmi) {
                break;
            }
            mi2 = mi;
        }
        if (parallel && hi - lo > 4) {
            RunMerger merger = new RunMerger(a10, b4, offset, 0, run, mi, hi).forkMe();
            a12 = mergeRuns(a10, b4, offset, -aim, true, run, lo, mi);
            a22 = (int[]) merger.getDestination();
        } else {
            int[] a13 = mergeRuns(a10, b4, offset, -aim, false, run, lo, mi);
            a22 = mergeRuns(a10, b4, offset, 0, false, run, mi, hi);
            a12 = a13;
        }
        int[] dst = a12 == a10 ? b4 : a10;
        int k10 = a12 == a10 ? run[lo] - offset : run[lo];
        int lo1 = a12 == b4 ? run[lo] - offset : run[lo];
        int hi1 = a12 == b4 ? run[mi] - offset : run[mi];
        int lo2 = a22 == b4 ? run[mi] - offset : run[mi];
        int hi2 = a22 == b4 ? run[hi] - offset : run[hi];
        if (parallel) {
            new Merger(null, dst, k10, a12, lo1, hi1, a22, lo2, hi2).invoke();
        } else {
            mergeParts((Merger) null, dst, k10, a12, lo1, hi1, a22, lo2, hi2);
        }
        return dst;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mergeParts(Merger merger, int[] dst, int k10, int[] a12, int lo1, int hi1, int[] a22, int lo2, int hi2) {
        int k11;
        int lo12;
        int hi12;
        int lo22;
        int hi22;
        int i10;
        if (merger != null && a12 == a22) {
            int lo13 = lo1;
            int hi13 = hi1;
            int lo23 = lo2;
            int hi23 = hi2;
            while (true) {
                if (hi13 - lo13 >= hi23 - lo23) {
                    lo12 = lo13;
                    hi12 = hi13;
                    lo22 = lo23;
                    hi22 = hi23;
                } else {
                    int lo = lo13;
                    int hi = hi13;
                    lo12 = lo23;
                    hi12 = hi23;
                    lo22 = lo;
                    hi22 = hi;
                }
                if (hi12 - lo12 < 4096) {
                    break;
                }
                int mi1 = (lo12 + hi12) >>> 1;
                int key = a12[mi1];
                int mi2 = hi22;
                int loo = lo22;
                int mi22 = mi2;
                while (loo < mi22) {
                    int t2 = (loo + mi22) >>> 1;
                    if (key > a22[t2]) {
                        loo = t2 + 1;
                    } else {
                        mi22 = t2;
                    }
                }
                int d10 = ((mi22 - lo22) + mi1) - lo12;
                int key2 = hi22;
                merger.forkMerger(dst, k10 + d10, a12, mi1, hi12, a22, mi22, key2);
                hi13 = mi1;
                hi23 = mi22;
                lo13 = lo12;
                lo23 = lo22;
            }
            k11 = k10;
        } else {
            k11 = k10;
            lo12 = lo1;
            hi12 = hi1;
            lo22 = lo2;
            hi22 = hi2;
        }
        while (lo12 < hi12 && lo22 < hi22) {
            int k12 = k11 + 1;
            if (a12[lo12] < a22[lo22]) {
                i10 = a12[lo12];
                lo12++;
            } else {
                i10 = a22[lo22];
                lo22++;
            }
            dst[k11] = i10;
            k11 = k12;
        }
        if (dst != a12 || k11 < lo12) {
            while (lo12 < hi12) {
                dst[k11] = a12[lo12];
                k11++;
                lo12++;
            }
        }
        if (dst != a22 || k11 < lo22) {
            while (lo22 < hi22) {
                dst[k11] = a22[lo22];
                k11++;
                lo22++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void sort(long[] a10, int parallelism, int low, int high) {
        int size = high - low;
        if (parallelism > 1 && size > 4096) {
            int depth = getDepth(parallelism, size >> 12);
            long[] b4 = depth == 0 ? null : new long[size];
            new Sorter(null, a10, b4, low, size, low, depth).invoke();
            return;
        }
        sort((Sorter) null, a10, 0, low, high);
    }

    static void sort(Sorter sorter, long[] a10, int bits, int low, int high) {
        int lower;
        int bits2 = bits;
        int high2 = high;
        while (true) {
            int end = high2 - 1;
            int size = high2 - low;
            if (size < bits2 + 65 && (bits2 & 1) > 0) {
                mixedInsertionSort(a10, low, high2 - (((size >> 5) << 3) * 3), high2);
                return;
            }
            if (size < 44) {
                insertionSort(a10, low, high2);
                return;
            }
            if ((bits2 == 0 || (size > 4096 && (bits2 & 1) > 0)) && tryMergeRuns(sorter, a10, low, size)) {
                return;
            }
            bits2 += 6;
            if (bits2 > 384) {
                heapSort(a10, low, high2);
                return;
            }
            int step = ((size >> 3) * 3) + 3;
            int k10 = low + step;
            int e52 = end - step;
            int e32 = (k10 + e52) >>> 1;
            int e2 = (k10 + e32) >>> 1;
            int e42 = (e32 + e52) >>> 1;
            long a32 = a10[e32];
            if (a10[e52] < a10[e2]) {
                long t2 = a10[e52];
                a10[e52] = a10[e2];
                a10[e2] = t2;
            }
            long t10 = a10[e42];
            if (t10 < a10[k10]) {
                long t11 = a10[e42];
                a10[e42] = a10[k10];
                a10[k10] = t11;
            }
            long t12 = a10[e52];
            if (t12 < a10[e42]) {
                long t13 = a10[e52];
                a10[e52] = a10[e42];
                a10[e42] = t13;
            }
            long t14 = a10[e2];
            if (t14 < a10[k10]) {
                long t15 = a10[e2];
                a10[e2] = a10[k10];
                a10[k10] = t15;
            }
            long t16 = a10[e42];
            if (t16 < a10[e2]) {
                long t17 = a10[e42];
                a10[e42] = a10[e2];
                a10[e2] = t17;
            }
            long t18 = a10[e2];
            if (a32 < t18) {
                if (a32 < a10[k10]) {
                    a10[e32] = a10[e2];
                    a10[e2] = a10[k10];
                    a10[k10] = a32;
                } else {
                    a10[e32] = a10[e2];
                    a10[e2] = a32;
                }
            } else if (a32 > a10[e42]) {
                if (a32 > a10[e52]) {
                    a10[e32] = a10[e42];
                    a10[e42] = a10[e52];
                    a10[e52] = a32;
                } else {
                    a10[e32] = a10[e42];
                    a10[e42] = a32;
                }
            }
            int lower2 = low;
            int upper = end;
            if (a10[k10] < a10[e2] && a10[e2] < a10[e32] && a10[e32] < a10[e42] && a10[e42] < a10[e52]) {
                long pivot1 = a10[k10];
                long pivot2 = a10[e52];
                a10[k10] = a10[lower2];
                a10[e52] = a10[upper];
                do {
                    lower2++;
                } while (a10[lower2] < pivot1);
                do {
                    upper--;
                } while (a10[upper] > pivot2);
                int upper2 = upper + 1;
                int k11 = upper2;
                lower = lower2 - 1;
                int upper3 = upper2;
                while (true) {
                    int e12 = k10;
                    int e13 = k11 - 1;
                    if (e13 <= lower) {
                        break;
                    }
                    long ak = a10[e13];
                    if (ak >= pivot1) {
                        if (ak > pivot2) {
                            upper3--;
                            a10[e13] = a10[upper3];
                            a10[upper3] = ak;
                        }
                        k11 = e13;
                        k10 = e12;
                    }
                    while (true) {
                        if (lower < e13) {
                            lower++;
                            if (a10[lower] >= pivot1) {
                                if (a10[lower] > pivot2) {
                                    upper3--;
                                    a10[e13] = a10[upper3];
                                    a10[upper3] = a10[lower];
                                } else {
                                    a10[e13] = a10[lower];
                                }
                                a10[lower] = ak;
                            }
                        }
                    }
                    k11 = e13;
                    k10 = e12;
                }
                a10[low] = a10[lower];
                a10[lower] = pivot1;
                a10[end] = a10[upper3];
                a10[upper3] = pivot2;
                if (size <= 4096 || sorter == null) {
                    sort(sorter, a10, bits2 | 1, lower + 1, upper3);
                    sort(sorter, a10, bits2 | 1, upper3 + 1, high2);
                } else {
                    sorter.forkSorter(bits2 | 1, lower + 1, upper3);
                    sorter.forkSorter(bits2 | 1, upper3 + 1, high2);
                }
            } else {
                long pivot = a10[e32];
                a10[e32] = a10[lower2];
                int upper4 = upper + 1;
                int k12 = upper4;
                int upper5 = upper4;
                int lower3 = lower2;
                while (true) {
                    k12--;
                    if (k12 <= lower3) {
                        break;
                    }
                    long ak2 = a10[k12];
                    if (ak2 != pivot) {
                        a10[k12] = pivot;
                        if (ak2 < pivot) {
                            do {
                                lower3++;
                            } while (a10[lower3] < pivot);
                            if (a10[lower3] > pivot) {
                                upper5--;
                                a10[upper5] = a10[lower3];
                            }
                            a10[lower3] = ak2;
                        } else {
                            upper5--;
                            a10[upper5] = ak2;
                        }
                    }
                }
                a10[low] = a10[lower3];
                a10[lower3] = pivot;
                if (size <= 4096 || sorter == null) {
                    sort(sorter, a10, bits2 | 1, upper5, high2);
                } else {
                    sorter.forkSorter(bits2 | 1, upper5, high2);
                }
                lower = lower3;
            }
            high2 = lower;
        }
    }

    private static void mixedInsertionSort(long[] a10, int low, int end, int high) {
        if (end != high) {
            long pin = a10[end];
            int p10 = high;
            while (true) {
                low++;
                if (low >= end) {
                    break;
                }
                int i10 = low;
                long ai = a10[low];
                if (ai < a10[i10 - 1]) {
                    int i11 = i10 - 1;
                    a10[i10] = a10[i11];
                    while (true) {
                        i11--;
                        if (ai >= a10[i11]) {
                            break;
                        } else {
                            a10[i11 + 1] = a10[i11];
                        }
                    }
                    a10[i11 + 1] = ai;
                } else if (p10 > i10 && ai > pin) {
                    do {
                        p10--;
                    } while (a10[p10] > pin);
                    if (p10 > i10) {
                        ai = a10[p10];
                        a10[p10] = a10[i10];
                    }
                    while (true) {
                        i10--;
                        if (ai >= a10[i10]) {
                            break;
                        } else {
                            a10[i10 + 1] = a10[i10];
                        }
                    }
                    a10[i10 + 1] = ai;
                }
            }
            while (low < high) {
                int i12 = low;
                long a12 = a10[low];
                int low2 = low + 1;
                long a22 = a10[low2];
                if (a12 > a22) {
                    while (true) {
                        i12--;
                        if (a12 >= a10[i12]) {
                            break;
                        } else {
                            a10[i12 + 2] = a10[i12];
                        }
                    }
                    int i13 = i12 + 1;
                    a10[i13 + 1] = a12;
                    while (true) {
                        i13--;
                        if (a22 >= a10[i13]) {
                            break;
                        } else {
                            a10[i13 + 1] = a10[i13];
                        }
                    }
                    a10[i13 + 1] = a22;
                } else if (a12 < a10[i12 - 1]) {
                    while (true) {
                        i12--;
                        if (a22 >= a10[i12]) {
                            break;
                        } else {
                            a10[i12 + 2] = a10[i12];
                        }
                    }
                    int i14 = i12 + 1;
                    a10[i14 + 1] = a22;
                    while (true) {
                        i14--;
                        if (a12 >= a10[i14]) {
                            break;
                        } else {
                            a10[i14 + 1] = a10[i14];
                        }
                    }
                    a10[i14 + 1] = a12;
                }
                low = low2 + 1;
            }
            return;
        }
        while (true) {
            low++;
            if (low < end) {
                int i15 = low;
                long ai2 = a10[low];
                while (true) {
                    i15--;
                    if (ai2 < a10[i15]) {
                        a10[i15 + 1] = a10[i15];
                    }
                }
                a10[i15 + 1] = ai2;
            } else {
                return;
            }
        }
    }

    private static void insertionSort(long[] a10, int low, int high) {
        int k10 = low;
        while (true) {
            k10++;
            if (k10 < high) {
                int i10 = k10;
                long ai = a10[k10];
                if (ai < a10[i10 - 1]) {
                    while (true) {
                        i10--;
                        if (i10 < low || ai >= a10[i10]) {
                            break;
                        } else {
                            a10[i10 + 1] = a10[i10];
                        }
                    }
                    a10[i10 + 1] = ai;
                }
            } else {
                return;
            }
        }
    }

    private static void heapSort(long[] a10, int low, int high) {
        int k10 = (low + high) >>> 1;
        while (k10 > low) {
            k10--;
            pushDown(a10, k10, a10[k10], low, high);
        }
        while (true) {
            high--;
            if (high > low) {
                long max = a10[low];
                pushDown(a10, low, a10[high], low, high);
                a10[high] = max;
            } else {
                return;
            }
        }
    }

    private static void pushDown(long[] a10, int p10, long value, int low, int high) {
        while (true) {
            int k10 = ((p10 << 1) - low) + 2;
            if (k10 > high) {
                break;
            }
            if (k10 == high || a10[k10] < a10[k10 - 1]) {
                k10--;
            }
            if (a10[k10] <= value) {
                break;
            }
            int p11 = k10;
            a10[p10] = a10[k10];
            p10 = p11;
        }
        a10[p10] = value;
    }

    private static boolean tryMergeRuns(Sorter sorter, long[] a10, int low, int size) {
        int offset;
        long[] b4;
        long[] b10;
        int high = low + size;
        int k10 = low + 1;
        int[] run = null;
        int count = 1;
        int last = low;
        while (k10 < high) {
            if (a10[k10 - 1] < a10[k10]) {
                do {
                    k10++;
                    if (k10 >= high) {
                        break;
                    }
                } while (a10[k10 - 1] <= a10[k10]);
            } else if (a10[k10 - 1] > a10[k10]) {
                do {
                    k10++;
                    if (k10 >= high) {
                        break;
                    }
                } while (a10[k10 - 1] >= a10[k10]);
                int i10 = last - 1;
                int j10 = k10;
                while (true) {
                    i10++;
                    j10--;
                    if (i10 >= j10 || a10[i10] <= a10[j10]) {
                        break;
                    }
                    long ai = a10[i10];
                    a10[i10] = a10[j10];
                    a10[j10] = ai;
                }
            } else {
                long ak = a10[k10];
                do {
                    k10++;
                    if (k10 >= high) {
                        break;
                    }
                } while (ak == a10[k10]);
                if (k10 < high) {
                    continue;
                }
            }
            if (run == null) {
                if (k10 == high) {
                    return true;
                }
                if (k10 - low < 16) {
                    return false;
                }
                int[] run2 = new int[((size >> 10) | 127) & 1023];
                run2[0] = low;
                run = run2;
            } else if (a10[last - 1] > a10[last]) {
                if (count > ((k10 - low) >> 7) || (count = count + 1) == MAX_RUN_CAPACITY) {
                    return false;
                }
                if (count == run.length) {
                    run = Arrays.copyOf(run, count << 1);
                }
            }
            last = k10;
            run[count] = k10;
        }
        if (count > 1) {
            if (sorter == null || (b10 = (long[]) sorter.f50462b) == null) {
                long[] b11 = new long[size];
                offset = low;
                b4 = b11;
            } else {
                int offset2 = sorter.offset;
                offset = offset2;
                b4 = b10;
            }
            mergeRuns(a10, b4, offset, 1, sorter != null, run, 0, count);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long[] mergeRuns(long[] a10, long[] b4, int offset, int aim, boolean parallel, int[] run, int lo, int hi) {
        int mi;
        long[] a22;
        long[] a12;
        if (hi - lo == 1) {
            if (aim >= 0) {
                return a10;
            }
            int i10 = run[hi];
            int j10 = i10 - offset;
            int low = run[lo];
            while (i10 > low) {
                j10--;
                i10--;
                b4[j10] = a10[i10];
            }
            return b4;
        }
        int mi2 = lo;
        int rmi = (run[lo] + run[hi]) >>> 1;
        while (true) {
            mi = mi2 + 1;
            if (run[mi + 1] > rmi) {
                break;
            }
            mi2 = mi;
        }
        if (parallel && hi - lo > 4) {
            RunMerger merger = new RunMerger(a10, b4, offset, 0, run, mi, hi).forkMe();
            a12 = mergeRuns(a10, b4, offset, -aim, true, run, lo, mi);
            a22 = (long[]) merger.getDestination();
        } else {
            long[] a13 = mergeRuns(a10, b4, offset, -aim, false, run, lo, mi);
            a22 = mergeRuns(a10, b4, offset, 0, false, run, mi, hi);
            a12 = a13;
        }
        long[] dst = a12 == a10 ? b4 : a10;
        int k10 = a12 == a10 ? run[lo] - offset : run[lo];
        int lo1 = a12 == b4 ? run[lo] - offset : run[lo];
        int hi1 = a12 == b4 ? run[mi] - offset : run[mi];
        int lo2 = a22 == b4 ? run[mi] - offset : run[mi];
        int hi2 = a22 == b4 ? run[hi] - offset : run[hi];
        if (parallel) {
            new Merger(null, dst, k10, a12, lo1, hi1, a22, lo2, hi2).invoke();
        } else {
            mergeParts((Merger) null, dst, k10, a12, lo1, hi1, a22, lo2, hi2);
        }
        return dst;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mergeParts(Merger merger, long[] dst, int k10, long[] a12, int lo1, int hi1, long[] a22, int lo2, int hi2) {
        int k11;
        int lo12;
        int hi12;
        int lo22;
        int hi22;
        long j10;
        if (merger != null && a12 == a22) {
            int lo13 = lo1;
            int hi13 = hi1;
            int lo23 = lo2;
            int hi23 = hi2;
            while (true) {
                if (hi13 - lo13 >= hi23 - lo23) {
                    lo12 = lo13;
                    hi12 = hi13;
                    lo22 = lo23;
                    hi22 = hi23;
                } else {
                    int lo = lo13;
                    int hi = hi13;
                    lo12 = lo23;
                    hi12 = hi23;
                    lo22 = lo;
                    hi22 = hi;
                }
                if (hi12 - lo12 < 4096) {
                    break;
                }
                int mi1 = (lo12 + hi12) >>> 1;
                long key = a12[mi1];
                int mi2 = hi22;
                int loo = lo22;
                int mi22 = mi2;
                while (loo < mi22) {
                    int t2 = (loo + mi22) >>> 1;
                    if (key > a22[t2]) {
                        loo = t2 + 1;
                    } else {
                        mi22 = t2;
                    }
                }
                int d10 = ((mi22 - lo22) + mi1) - lo12;
                int i10 = mi22;
                int mi23 = mi22;
                int mi24 = hi22;
                merger.forkMerger(dst, k10 + d10, a12, mi1, hi12, a22, i10, mi24);
                hi13 = mi1;
                hi23 = mi23;
                lo13 = lo12;
                lo23 = lo22;
            }
            k11 = k10;
        } else {
            k11 = k10;
            lo12 = lo1;
            hi12 = hi1;
            lo22 = lo2;
            hi22 = hi2;
        }
        while (lo12 < hi12 && lo22 < hi22) {
            int k12 = k11 + 1;
            if (a12[lo12] < a22[lo22]) {
                j10 = a12[lo12];
                lo12++;
            } else {
                j10 = a22[lo22];
                lo22++;
            }
            dst[k11] = j10;
            k11 = k12;
        }
        if (dst != a12 || k11 < lo12) {
            while (lo12 < hi12) {
                dst[k11] = a12[lo12];
                k11++;
                lo12++;
            }
        }
        if (dst != a22 || k11 < lo22) {
            while (lo22 < hi22) {
                dst[k11] = a22[lo22];
                k11++;
                lo22++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void sort(byte[] a10, int low, int high) {
        if (high - low > 64) {
            countingSort(a10, low, high);
        } else {
            insertionSort(a10, low, high);
        }
    }

    private static void insertionSort(byte[] a10, int low, int high) {
        int k10 = low;
        while (true) {
            k10++;
            if (k10 < high) {
                int i10 = k10;
                byte ai = a10[k10];
                if (ai < a10[i10 - 1]) {
                    while (true) {
                        i10--;
                        if (i10 < low || ai >= a10[i10]) {
                            break;
                        } else {
                            a10[i10 + 1] = a10[i10];
                        }
                    }
                    a10[i10 + 1] = ai;
                }
            } else {
                return;
            }
        }
    }

    private static void countingSort(byte[] a10, int low, int high) {
        int i10;
        int[] count = new int[256];
        int i11 = high;
        while (i11 > low) {
            i11--;
            int i12 = a10[i11] & 255;
            count[i12] = count[i12] + 1;
        }
        int i13 = high - low;
        if (i13 > 256) {
            int i14 = 384;
            while (true) {
                i14--;
                if (i14 > 127) {
                    int value = i14 & 255;
                    int low2 = high - count[value];
                    while (high > low2) {
                        high--;
                        a10[high] = (byte) value;
                    }
                } else {
                    return;
                }
            }
        } else {
            int i15 = 384;
            while (high > low) {
                while (true) {
                    i10 = i15 - 1;
                    if (count[i10 & 255] != 0) {
                        break;
                    } else {
                        i15 = i10;
                    }
                }
                int value2 = i10 & 255;
                int c4 = count[value2];
                do {
                    high--;
                    a10[high] = (byte) value2;
                    c4--;
                } while (c4 > 0);
                i15 = i10;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void sort(char[] a10, int low, int high) {
        if (high - low > 1750) {
            countingSort(a10, low, high);
        } else {
            sort(a10, 0, low, high);
        }
    }

    static void sort(char[] a10, int bits, int low, int high) {
        int e52;
        int bits2 = bits;
        int high2 = high;
        while (true) {
            int end = high2 - 1;
            int size = high2 - low;
            if (size < 44) {
                insertionSort(a10, low, high2);
                return;
            }
            bits2 += 6;
            if (bits2 > 384) {
                countingSort(a10, low, high2);
                return;
            }
            int step = ((size >> 3) * 3) + 3;
            int e12 = low + step;
            int e53 = end - step;
            int e32 = (e12 + e53) >>> 1;
            int e2 = (e12 + e32) >>> 1;
            int e42 = (e32 + e53) >>> 1;
            char a32 = a10[e32];
            if (a10[e53] < a10[e2]) {
                char t2 = a10[e53];
                a10[e53] = a10[e2];
                a10[e2] = t2;
            }
            char t10 = a10[e42];
            if (t10 < a10[e12]) {
                char t11 = a10[e42];
                a10[e42] = a10[e12];
                a10[e12] = t11;
            }
            char t12 = a10[e53];
            if (t12 < a10[e42]) {
                char t13 = a10[e53];
                a10[e53] = a10[e42];
                a10[e42] = t13;
            }
            char t14 = a10[e2];
            if (t14 < a10[e12]) {
                char t15 = a10[e2];
                a10[e2] = a10[e12];
                a10[e12] = t15;
            }
            char t16 = a10[e42];
            if (t16 < a10[e2]) {
                char t17 = a10[e42];
                a10[e42] = a10[e2];
                a10[e2] = t17;
            }
            char t18 = a10[e2];
            if (a32 < t18) {
                if (a32 < a10[e12]) {
                    a10[e32] = a10[e2];
                    a10[e2] = a10[e12];
                    a10[e12] = a32;
                } else {
                    a10[e32] = a10[e2];
                    a10[e2] = a32;
                }
            } else if (a32 > a10[e42]) {
                if (a32 > a10[e53]) {
                    a10[e32] = a10[e42];
                    a10[e42] = a10[e53];
                    a10[e53] = a32;
                } else {
                    a10[e32] = a10[e42];
                    a10[e42] = a32;
                }
            }
            int lower = low;
            int upper = end;
            if (a10[e12] < a10[e2] && a10[e2] < a10[e32] && a10[e32] < a10[e42] && a10[e42] < a10[e53]) {
                char pivot1 = a10[e12];
                char pivot2 = a10[e53];
                a10[e12] = a10[lower];
                a10[e53] = a10[upper];
                while (true) {
                    lower++;
                    int step2 = step;
                    if (a10[lower] >= pivot1) {
                        break;
                    } else {
                        step = step2;
                    }
                }
                do {
                    upper--;
                } while (a10[upper] > pivot2);
                lower--;
                int k10 = lower;
                int upper2 = upper + 1;
                int e13 = upper2;
                while (true) {
                    int unused = k10;
                    int unused2 = e13 - 1;
                    if (unused2 <= lower) {
                        break;
                    }
                    int e14 = e12;
                    char ak = a10[unused2];
                    if (ak < pivot1) {
                        while (true) {
                            if (lower >= unused2) {
                                e52 = e53;
                                break;
                            }
                            lower++;
                            e52 = e53;
                            if (a10[lower] < pivot1) {
                                e53 = e52;
                            } else {
                                if (a10[lower] <= pivot2) {
                                    a10[unused2] = a10[lower];
                                } else {
                                    upper2--;
                                    a10[unused2] = a10[upper2];
                                    a10[upper2] = a10[lower];
                                }
                                a10[lower] = ak;
                            }
                        }
                    } else {
                        e52 = e53;
                        if (ak > pivot2) {
                            upper2--;
                            a10[unused2] = a10[upper2];
                            a10[upper2] = ak;
                        }
                    }
                    e12 = e14;
                    e53 = e52;
                    e13 = unused2;
                    k10 = unused;
                }
                a10[low] = a10[lower];
                a10[lower] = pivot1;
                a10[end] = a10[upper2];
                a10[upper2] = pivot2;
                sort(a10, bits2 | 1, lower + 1, upper2);
                sort(a10, bits2 | 1, upper2 + 1, high2);
            } else {
                char pivot = a10[e32];
                a10[e32] = a10[lower];
                int upper3 = upper + 1;
                int k11 = upper3;
                while (true) {
                    k11--;
                    if (k11 <= lower) {
                        break;
                    }
                    char ak2 = a10[k11];
                    if (ak2 != pivot) {
                        a10[k11] = pivot;
                        if (ak2 < pivot) {
                            do {
                                lower++;
                            } while (a10[lower] < pivot);
                            if (a10[lower] > pivot) {
                                upper3--;
                                a10[upper3] = a10[lower];
                            }
                            a10[lower] = ak2;
                        } else {
                            upper3--;
                            a10[upper3] = ak2;
                        }
                    }
                }
                a10[low] = a10[lower];
                a10[lower] = pivot;
                sort(a10, bits2 | 1, upper3, high2);
            }
            high2 = lower;
        }
    }

    private static void insertionSort(char[] a10, int low, int high) {
        int k10 = low;
        while (true) {
            k10++;
            if (k10 < high) {
                int i10 = k10;
                char ai = a10[k10];
                if (ai < a10[i10 - 1]) {
                    while (true) {
                        i10--;
                        if (i10 < low || ai >= a10[i10]) {
                            break;
                        } else {
                            a10[i10 + 1] = a10[i10];
                        }
                    }
                    a10[i10 + 1] = ai;
                }
            } else {
                return;
            }
        }
    }

    private static void countingSort(char[] a10, int low, int high) {
        int i10;
        int[] count = new int[65536];
        int i11 = high;
        while (i11 > low) {
            i11--;
            char c4 = a10[i11];
            count[c4] = count[c4] + 1;
        }
        int i12 = high - low;
        if (i12 > 65536) {
            int i13 = 65536;
            while (i13 > 0) {
                i13--;
                int low2 = high - count[i13];
                while (high > low2) {
                    high--;
                    a10[high] = (char) i13;
                }
            }
            return;
        }
        int i14 = 65536;
        while (high > low) {
            while (true) {
                i10 = i14 - 1;
                if (count[i10] != 0) {
                    break;
                } else {
                    i14 = i10;
                }
            }
            int c10 = count[i10];
            do {
                high--;
                a10[high] = (char) i10;
                c10--;
            } while (c10 > 0);
            i14 = i10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void sort(short[] a10, int low, int high) {
        if (high - low > 1750) {
            countingSort(a10, low, high);
        } else {
            sort(a10, 0, low, high);
        }
    }

    static void sort(short[] a10, int bits, int low, int high) {
        int e52;
        int bits2 = bits;
        int high2 = high;
        while (true) {
            int end = high2 - 1;
            int size = high2 - low;
            if (size < 44) {
                insertionSort(a10, low, high2);
                return;
            }
            bits2 += 6;
            if (bits2 > 384) {
                countingSort(a10, low, high2);
                return;
            }
            int step = ((size >> 3) * 3) + 3;
            int e12 = low + step;
            int e53 = end - step;
            int e32 = (e12 + e53) >>> 1;
            int e2 = (e12 + e32) >>> 1;
            int e42 = (e32 + e53) >>> 1;
            short a32 = a10[e32];
            if (a10[e53] < a10[e2]) {
                short t2 = a10[e53];
                a10[e53] = a10[e2];
                a10[e2] = t2;
            }
            short t10 = a10[e42];
            if (t10 < a10[e12]) {
                short t11 = a10[e42];
                a10[e42] = a10[e12];
                a10[e12] = t11;
            }
            short t12 = a10[e53];
            if (t12 < a10[e42]) {
                short t13 = a10[e53];
                a10[e53] = a10[e42];
                a10[e42] = t13;
            }
            short t14 = a10[e2];
            if (t14 < a10[e12]) {
                short t15 = a10[e2];
                a10[e2] = a10[e12];
                a10[e12] = t15;
            }
            short t16 = a10[e42];
            if (t16 < a10[e2]) {
                short t17 = a10[e42];
                a10[e42] = a10[e2];
                a10[e2] = t17;
            }
            short t18 = a10[e2];
            if (a32 < t18) {
                if (a32 < a10[e12]) {
                    a10[e32] = a10[e2];
                    a10[e2] = a10[e12];
                    a10[e12] = a32;
                } else {
                    a10[e32] = a10[e2];
                    a10[e2] = a32;
                }
            } else if (a32 > a10[e42]) {
                if (a32 > a10[e53]) {
                    a10[e32] = a10[e42];
                    a10[e42] = a10[e53];
                    a10[e53] = a32;
                } else {
                    a10[e32] = a10[e42];
                    a10[e42] = a32;
                }
            }
            int lower = low;
            int upper = end;
            if (a10[e12] < a10[e2] && a10[e2] < a10[e32] && a10[e32] < a10[e42] && a10[e42] < a10[e53]) {
                short pivot1 = a10[e12];
                short pivot2 = a10[e53];
                a10[e12] = a10[lower];
                a10[e53] = a10[upper];
                while (true) {
                    lower++;
                    int step2 = step;
                    if (a10[lower] >= pivot1) {
                        break;
                    } else {
                        step = step2;
                    }
                }
                do {
                    upper--;
                } while (a10[upper] > pivot2);
                lower--;
                int k10 = lower;
                int upper2 = upper + 1;
                int e13 = upper2;
                while (true) {
                    int unused = k10;
                    int unused2 = e13 - 1;
                    if (unused2 <= lower) {
                        break;
                    }
                    int e14 = e12;
                    short ak = a10[unused2];
                    if (ak < pivot1) {
                        while (true) {
                            if (lower >= unused2) {
                                e52 = e53;
                                break;
                            }
                            lower++;
                            e52 = e53;
                            if (a10[lower] < pivot1) {
                                e53 = e52;
                            } else {
                                if (a10[lower] <= pivot2) {
                                    a10[unused2] = a10[lower];
                                } else {
                                    upper2--;
                                    a10[unused2] = a10[upper2];
                                    a10[upper2] = a10[lower];
                                }
                                a10[lower] = ak;
                            }
                        }
                    } else {
                        e52 = e53;
                        if (ak > pivot2) {
                            upper2--;
                            a10[unused2] = a10[upper2];
                            a10[upper2] = ak;
                        }
                    }
                    e12 = e14;
                    e53 = e52;
                    e13 = unused2;
                    k10 = unused;
                }
                a10[low] = a10[lower];
                a10[lower] = pivot1;
                a10[end] = a10[upper2];
                a10[upper2] = pivot2;
                sort(a10, bits2 | 1, lower + 1, upper2);
                sort(a10, bits2 | 1, upper2 + 1, high2);
            } else {
                short pivot = a10[e32];
                a10[e32] = a10[lower];
                int upper3 = upper + 1;
                int k11 = upper3;
                while (true) {
                    k11--;
                    if (k11 <= lower) {
                        break;
                    }
                    short ak2 = a10[k11];
                    if (ak2 != pivot) {
                        a10[k11] = pivot;
                        if (ak2 < pivot) {
                            do {
                                lower++;
                            } while (a10[lower] < pivot);
                            if (a10[lower] > pivot) {
                                upper3--;
                                a10[upper3] = a10[lower];
                            }
                            a10[lower] = ak2;
                        } else {
                            upper3--;
                            a10[upper3] = ak2;
                        }
                    }
                }
                a10[low] = a10[lower];
                a10[lower] = pivot;
                sort(a10, bits2 | 1, upper3, high2);
            }
            high2 = lower;
        }
    }

    private static void insertionSort(short[] a10, int low, int high) {
        int k10 = low;
        while (true) {
            k10++;
            if (k10 < high) {
                int i10 = k10;
                short ai = a10[k10];
                if (ai < a10[i10 - 1]) {
                    while (true) {
                        i10--;
                        if (i10 < low || ai >= a10[i10]) {
                            break;
                        } else {
                            a10[i10 + 1] = a10[i10];
                        }
                    }
                    a10[i10 + 1] = ai;
                }
            } else {
                return;
            }
        }
    }

    private static void countingSort(short[] a10, int low, int high) {
        int i10;
        int[] count = new int[65536];
        int i11 = high;
        while (i11 > low) {
            i11--;
            int i12 = 65535 & a10[i11];
            count[i12] = count[i12] + 1;
        }
        int i13 = high - low;
        if (i13 > 65536) {
            int i14 = MAX_SHORT_INDEX;
            while (true) {
                i14--;
                if (i14 > 32767) {
                    int value = i14 & 65535;
                    int low2 = high - count[value];
                    while (high > low2) {
                        high--;
                        a10[high] = (short) value;
                    }
                } else {
                    return;
                }
            }
        } else {
            int i15 = MAX_SHORT_INDEX;
            while (high > low) {
                while (true) {
                    i10 = i15 - 1;
                    if (count[i10 & 65535] != 0) {
                        break;
                    } else {
                        i15 = i10;
                    }
                }
                int value2 = i10 & 65535;
                int c4 = count[value2];
                do {
                    high--;
                    a10[high] = (short) value2;
                    c4--;
                } while (c4 > 0);
                i15 = i10;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void sort(float[] a10, int parallelism, int low, int high) {
        int i10;
        int low2 = low;
        int k10 = high;
        int high2 = high;
        int numNegativeZero = 0;
        while (k10 > low2) {
            k10--;
            float ak = a10[k10];
            if (ak == 0.0f && Float.floatToRawIntBits(ak) < 0) {
                numNegativeZero++;
                a10[k10] = 0.0f;
            } else if (ak != ak) {
                high2--;
                a10[k10] = a10[high2];
                a10[high2] = ak;
            }
        }
        int size = high2 - low2;
        if (parallelism <= 1 || size <= 4096) {
            i10 = 1;
            sort((Sorter) null, a10, 0, low2, high2);
        } else {
            int depth = getDepth(parallelism, size >> 12);
            float[] b4 = depth != 0 ? new float[size] : null;
            i10 = 1;
            new Sorter(null, a10, b4, low, size, low, depth).invoke();
        }
        int numNegativeZero2 = numNegativeZero + i10;
        if (numNegativeZero2 == i10) {
            return;
        }
        while (low2 <= high2) {
            int middle = (low2 + high2) >>> i10;
            if (a10[middle] < 0.0f) {
                low2 = middle + 1;
            } else {
                high2 = middle - 1;
            }
        }
        while (true) {
            numNegativeZero2--;
            if (numNegativeZero2 > 0) {
                high2++;
                a10[high2] = -0.0f;
            } else {
                return;
            }
        }
    }

    static void sort(Sorter sorter, float[] a10, int bits, int low, int high) {
        int bits2 = bits;
        int high2 = high;
        while (true) {
            int end = high2 - 1;
            int size = high2 - low;
            if (size < bits2 + 65 && (bits2 & 1) > 0) {
                mixedInsertionSort(a10, low, high2 - (((size >> 5) << 3) * 3), high2);
                return;
            }
            if (size < 44) {
                insertionSort(a10, low, high2);
                return;
            }
            if ((bits2 == 0 || (size > 4096 && (bits2 & 1) > 0)) && tryMergeRuns(sorter, a10, low, size)) {
                return;
            }
            bits2 += 6;
            if (bits2 > 384) {
                heapSort(a10, low, high2);
                return;
            }
            int k10 = ((size >> 3) * 3) + 3;
            int e12 = low + k10;
            int e52 = end - k10;
            int e32 = (e12 + e52) >>> 1;
            int e2 = (e12 + e32) >>> 1;
            int e42 = (e32 + e52) >>> 1;
            float a32 = a10[e32];
            if (a10[e52] < a10[e2]) {
                float t2 = a10[e52];
                a10[e52] = a10[e2];
                a10[e2] = t2;
            }
            float t10 = a10[e42];
            if (t10 < a10[e12]) {
                float t11 = a10[e42];
                a10[e42] = a10[e12];
                a10[e12] = t11;
            }
            float t12 = a10[e52];
            if (t12 < a10[e42]) {
                float t13 = a10[e52];
                a10[e52] = a10[e42];
                a10[e42] = t13;
            }
            float t14 = a10[e2];
            if (t14 < a10[e12]) {
                float t15 = a10[e2];
                a10[e2] = a10[e12];
                a10[e12] = t15;
            }
            float t16 = a10[e42];
            if (t16 < a10[e2]) {
                float t17 = a10[e42];
                a10[e42] = a10[e2];
                a10[e2] = t17;
            }
            float t18 = a10[e2];
            if (a32 < t18) {
                if (a32 < a10[e12]) {
                    a10[e32] = a10[e2];
                    a10[e2] = a10[e12];
                    a10[e12] = a32;
                } else {
                    a10[e32] = a10[e2];
                    a10[e2] = a32;
                }
            } else if (a32 > a10[e42]) {
                if (a32 > a10[e52]) {
                    a10[e32] = a10[e42];
                    a10[e42] = a10[e52];
                    a10[e52] = a32;
                } else {
                    a10[e32] = a10[e42];
                    a10[e42] = a32;
                }
            }
            int lower = low;
            int upper = end;
            if (a10[e12] < a10[e2] && a10[e2] < a10[e32] && a10[e32] < a10[e42] && a10[e42] < a10[e52]) {
                float pivot1 = a10[e12];
                float pivot2 = a10[e52];
                a10[e12] = a10[lower];
                a10[e52] = a10[upper];
                do {
                    lower++;
                } while (a10[lower] < pivot1);
                do {
                    upper--;
                } while (a10[upper] > pivot2);
                lower--;
                int upper2 = upper + 1;
                int k11 = upper2;
                int upper3 = upper2;
                while (true) {
                    int step = k10;
                    int step2 = k11 - 1;
                    if (step2 <= lower) {
                        break;
                    }
                    float ak = a10[step2];
                    if (ak >= pivot1) {
                        if (ak > pivot2) {
                            upper3--;
                            a10[step2] = a10[upper3];
                            a10[upper3] = ak;
                        }
                        k11 = step2;
                        k10 = step;
                    }
                    while (true) {
                        if (lower < step2) {
                            lower++;
                            if (a10[lower] >= pivot1) {
                                if (a10[lower] > pivot2) {
                                    upper3--;
                                    a10[step2] = a10[upper3];
                                    a10[upper3] = a10[lower];
                                } else {
                                    a10[step2] = a10[lower];
                                }
                                a10[lower] = ak;
                            }
                        }
                    }
                    k11 = step2;
                    k10 = step;
                }
                a10[low] = a10[lower];
                a10[lower] = pivot1;
                a10[end] = a10[upper3];
                a10[upper3] = pivot2;
                if (size <= 4096 || sorter == null) {
                    sort(sorter, a10, bits2 | 1, lower + 1, upper3);
                    sort(sorter, a10, bits2 | 1, upper3 + 1, high2);
                } else {
                    sorter.forkSorter(bits2 | 1, lower + 1, upper3);
                    sorter.forkSorter(bits2 | 1, upper3 + 1, high2);
                }
            } else {
                float pivot = a10[e32];
                a10[e32] = a10[lower];
                int upper4 = upper + 1;
                int k12 = upper4;
                int upper5 = upper4;
                while (true) {
                    k12--;
                    if (k12 <= lower) {
                        break;
                    }
                    float ak2 = a10[k12];
                    if (ak2 != pivot) {
                        a10[k12] = pivot;
                        if (ak2 < pivot) {
                            do {
                                lower++;
                            } while (a10[lower] < pivot);
                            if (a10[lower] > pivot) {
                                upper5--;
                                a10[upper5] = a10[lower];
                            }
                            a10[lower] = ak2;
                        } else {
                            upper5--;
                            a10[upper5] = ak2;
                        }
                    }
                }
                a10[low] = a10[lower];
                a10[lower] = pivot;
                if (size <= 4096 || sorter == null) {
                    sort(sorter, a10, bits2 | 1, upper5, high2);
                } else {
                    sorter.forkSorter(bits2 | 1, upper5, high2);
                }
            }
            high2 = lower;
        }
    }

    private static void mixedInsertionSort(float[] a10, int low, int end, int high) {
        if (end != high) {
            float pin = a10[end];
            int p10 = high;
            while (true) {
                low++;
                if (low >= end) {
                    break;
                }
                int i10 = low;
                float ai = a10[low];
                if (ai < a10[i10 - 1]) {
                    int i11 = i10 - 1;
                    a10[i10] = a10[i11];
                    while (true) {
                        i11--;
                        if (ai >= a10[i11]) {
                            break;
                        } else {
                            a10[i11 + 1] = a10[i11];
                        }
                    }
                    a10[i11 + 1] = ai;
                } else if (p10 > i10 && ai > pin) {
                    do {
                        p10--;
                    } while (a10[p10] > pin);
                    if (p10 > i10) {
                        ai = a10[p10];
                        a10[p10] = a10[i10];
                    }
                    while (true) {
                        i10--;
                        if (ai >= a10[i10]) {
                            break;
                        } else {
                            a10[i10 + 1] = a10[i10];
                        }
                    }
                    a10[i10 + 1] = ai;
                }
            }
            while (low < high) {
                int i12 = low;
                float a12 = a10[low];
                int low2 = low + 1;
                float a22 = a10[low2];
                if (a12 > a22) {
                    while (true) {
                        i12--;
                        if (a12 >= a10[i12]) {
                            break;
                        } else {
                            a10[i12 + 2] = a10[i12];
                        }
                    }
                    int i13 = i12 + 1;
                    a10[i13 + 1] = a12;
                    while (true) {
                        i13--;
                        if (a22 >= a10[i13]) {
                            break;
                        } else {
                            a10[i13 + 1] = a10[i13];
                        }
                    }
                    a10[i13 + 1] = a22;
                } else if (a12 < a10[i12 - 1]) {
                    while (true) {
                        i12--;
                        if (a22 >= a10[i12]) {
                            break;
                        } else {
                            a10[i12 + 2] = a10[i12];
                        }
                    }
                    int i14 = i12 + 1;
                    a10[i14 + 1] = a22;
                    while (true) {
                        i14--;
                        if (a12 >= a10[i14]) {
                            break;
                        } else {
                            a10[i14 + 1] = a10[i14];
                        }
                    }
                    a10[i14 + 1] = a12;
                }
                low = low2 + 1;
            }
            return;
        }
        while (true) {
            low++;
            if (low < end) {
                int i15 = low;
                float ai2 = a10[low];
                while (true) {
                    i15--;
                    if (ai2 < a10[i15]) {
                        a10[i15 + 1] = a10[i15];
                    }
                }
                a10[i15 + 1] = ai2;
            } else {
                return;
            }
        }
    }

    private static void insertionSort(float[] a10, int low, int high) {
        int k10 = low;
        while (true) {
            k10++;
            if (k10 < high) {
                int i10 = k10;
                float ai = a10[k10];
                if (ai < a10[i10 - 1]) {
                    while (true) {
                        i10--;
                        if (i10 < low || ai >= a10[i10]) {
                            break;
                        } else {
                            a10[i10 + 1] = a10[i10];
                        }
                    }
                    a10[i10 + 1] = ai;
                }
            } else {
                return;
            }
        }
    }

    private static void heapSort(float[] a10, int low, int high) {
        int k10 = (low + high) >>> 1;
        while (k10 > low) {
            k10--;
            pushDown(a10, k10, a10[k10], low, high);
        }
        while (true) {
            high--;
            if (high > low) {
                float max = a10[low];
                pushDown(a10, low, a10[high], low, high);
                a10[high] = max;
            } else {
                return;
            }
        }
    }

    private static void pushDown(float[] a10, int p10, float value, int low, int high) {
        while (true) {
            int k10 = ((p10 << 1) - low) + 2;
            if (k10 > high) {
                break;
            }
            if (k10 == high || a10[k10] < a10[k10 - 1]) {
                k10--;
            }
            if (a10[k10] <= value) {
                break;
            }
            int p11 = k10;
            a10[p10] = a10[k10];
            p10 = p11;
        }
        a10[p10] = value;
    }

    private static boolean tryMergeRuns(Sorter sorter, float[] a10, int low, int size) {
        int offset;
        float[] b4;
        float[] b10;
        int high = low + size;
        int k10 = low + 1;
        int[] run = null;
        int count = 1;
        int last = low;
        while (k10 < high) {
            if (a10[k10 - 1] < a10[k10]) {
                do {
                    k10++;
                    if (k10 >= high) {
                        break;
                    }
                } while (a10[k10 - 1] <= a10[k10]);
            } else if (a10[k10 - 1] > a10[k10]) {
                do {
                    k10++;
                    if (k10 >= high) {
                        break;
                    }
                } while (a10[k10 - 1] >= a10[k10]);
                int i10 = last - 1;
                int j10 = k10;
                while (true) {
                    i10++;
                    j10--;
                    if (i10 >= j10 || a10[i10] <= a10[j10]) {
                        break;
                    }
                    float ai = a10[i10];
                    a10[i10] = a10[j10];
                    a10[j10] = ai;
                }
            } else {
                float ak = a10[k10];
                do {
                    k10++;
                    if (k10 >= high) {
                        break;
                    }
                } while (ak == a10[k10]);
                if (k10 < high) {
                    continue;
                }
            }
            if (run == null) {
                if (k10 == high) {
                    return true;
                }
                if (k10 - low < 16) {
                    return false;
                }
                int[] run2 = new int[((size >> 10) | 127) & 1023];
                run2[0] = low;
                run = run2;
            } else if (a10[last - 1] > a10[last]) {
                if (count > ((k10 - low) >> 7) || (count = count + 1) == MAX_RUN_CAPACITY) {
                    return false;
                }
                if (count == run.length) {
                    run = Arrays.copyOf(run, count << 1);
                }
            }
            last = k10;
            run[count] = k10;
        }
        if (count > 1) {
            if (sorter == null || (b10 = (float[]) sorter.f50462b) == null) {
                float[] b11 = new float[size];
                offset = low;
                b4 = b11;
            } else {
                int offset2 = sorter.offset;
                offset = offset2;
                b4 = b10;
            }
            mergeRuns(a10, b4, offset, 1, sorter != null, run, 0, count);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float[] mergeRuns(float[] a10, float[] b4, int offset, int aim, boolean parallel, int[] run, int lo, int hi) {
        int mi;
        float[] a22;
        float[] a12;
        if (hi - lo == 1) {
            if (aim >= 0) {
                return a10;
            }
            int i10 = run[hi];
            int j10 = i10 - offset;
            int low = run[lo];
            while (i10 > low) {
                j10--;
                i10--;
                b4[j10] = a10[i10];
            }
            return b4;
        }
        int mi2 = lo;
        int rmi = (run[lo] + run[hi]) >>> 1;
        while (true) {
            mi = mi2 + 1;
            if (run[mi + 1] > rmi) {
                break;
            }
            mi2 = mi;
        }
        if (parallel && hi - lo > 4) {
            RunMerger merger = new RunMerger(a10, b4, offset, 0, run, mi, hi).forkMe();
            a12 = mergeRuns(a10, b4, offset, -aim, true, run, lo, mi);
            a22 = (float[]) merger.getDestination();
        } else {
            float[] a13 = mergeRuns(a10, b4, offset, -aim, false, run, lo, mi);
            a22 = mergeRuns(a10, b4, offset, 0, false, run, mi, hi);
            a12 = a13;
        }
        float[] dst = a12 == a10 ? b4 : a10;
        int k10 = a12 == a10 ? run[lo] - offset : run[lo];
        int lo1 = a12 == b4 ? run[lo] - offset : run[lo];
        int hi1 = a12 == b4 ? run[mi] - offset : run[mi];
        int lo2 = a22 == b4 ? run[mi] - offset : run[mi];
        int hi2 = a22 == b4 ? run[hi] - offset : run[hi];
        if (parallel) {
            new Merger(null, dst, k10, a12, lo1, hi1, a22, lo2, hi2).invoke();
        } else {
            mergeParts((Merger) null, dst, k10, a12, lo1, hi1, a22, lo2, hi2);
        }
        return dst;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mergeParts(Merger merger, float[] dst, int k10, float[] a12, int lo1, int hi1, float[] a22, int lo2, int hi2) {
        int k11;
        int lo12;
        int hi12;
        int lo22;
        int hi22;
        float f10;
        if (merger != null && a12 == a22) {
            int lo13 = lo1;
            int hi13 = hi1;
            int lo23 = lo2;
            int hi23 = hi2;
            while (true) {
                if (hi13 - lo13 >= hi23 - lo23) {
                    lo12 = lo13;
                    hi12 = hi13;
                    lo22 = lo23;
                    hi22 = hi23;
                } else {
                    int lo = lo13;
                    int hi = hi13;
                    lo12 = lo23;
                    hi12 = hi23;
                    lo22 = lo;
                    hi22 = hi;
                }
                if (hi12 - lo12 < 4096) {
                    break;
                }
                int mi1 = (lo12 + hi12) >>> 1;
                float key = a12[mi1];
                int mi2 = hi22;
                int loo = lo22;
                int mi22 = mi2;
                while (loo < mi22) {
                    int t2 = (loo + mi22) >>> 1;
                    if (key > a22[t2]) {
                        loo = t2 + 1;
                    } else {
                        mi22 = t2;
                    }
                }
                int d10 = ((mi22 - lo22) + mi1) - lo12;
                int i10 = mi22;
                int mi23 = mi22;
                int mi24 = hi22;
                merger.forkMerger(dst, k10 + d10, a12, mi1, hi12, a22, i10, mi24);
                hi13 = mi1;
                hi23 = mi23;
                lo13 = lo12;
                lo23 = lo22;
            }
            k11 = k10;
        } else {
            k11 = k10;
            lo12 = lo1;
            hi12 = hi1;
            lo22 = lo2;
            hi22 = hi2;
        }
        while (lo12 < hi12 && lo22 < hi22) {
            int k12 = k11 + 1;
            if (a12[lo12] < a22[lo22]) {
                f10 = a12[lo12];
                lo12++;
            } else {
                f10 = a22[lo22];
                lo22++;
            }
            dst[k11] = f10;
            k11 = k12;
        }
        if (dst != a12 || k11 < lo12) {
            while (lo12 < hi12) {
                dst[k11] = a12[lo12];
                k11++;
                lo12++;
            }
        }
        if (dst != a22 || k11 < lo22) {
            while (lo22 < hi22) {
                dst[k11] = a22[lo22];
                k11++;
                lo22++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void sort(double[] a10, int parallelism, int low, int high) {
        int i10;
        int low2 = low;
        int k10 = high;
        int high2 = high;
        int numNegativeZero = 0;
        while (k10 > low2) {
            k10--;
            double ak = a10[k10];
            if (ak == ShadowDrawableWrapper.COS_45 && Double.doubleToRawLongBits(ak) < 0) {
                numNegativeZero++;
                a10[k10] = 0.0d;
            } else if (ak != ak) {
                high2--;
                a10[k10] = a10[high2];
                a10[high2] = ak;
            }
        }
        int size = high2 - low2;
        if (parallelism <= 1 || size <= 4096) {
            i10 = 1;
            sort((Sorter) null, a10, 0, low2, high2);
        } else {
            int depth = getDepth(parallelism, size >> 12);
            double[] b4 = depth != 0 ? new double[size] : null;
            i10 = 1;
            new Sorter(null, a10, b4, low, size, low, depth).invoke();
        }
        int numNegativeZero2 = numNegativeZero + i10;
        if (numNegativeZero2 == i10) {
            return;
        }
        while (low2 <= high2) {
            int middle = (low2 + high2) >>> i10;
            if (a10[middle] < ShadowDrawableWrapper.COS_45) {
                low2 = middle + 1;
            } else {
                high2 = middle - 1;
            }
        }
        while (true) {
            numNegativeZero2--;
            if (numNegativeZero2 > 0) {
                high2++;
                a10[high2] = -0.0d;
            } else {
                return;
            }
        }
    }

    static void sort(Sorter sorter, double[] a10, int bits, int low, int high) {
        int lower;
        int bits2 = bits;
        int high2 = high;
        while (true) {
            int end = high2 - 1;
            int size = high2 - low;
            if (size < bits2 + 65 && (bits2 & 1) > 0) {
                mixedInsertionSort(a10, low, high2 - (((size >> 5) << 3) * 3), high2);
                return;
            }
            if (size < 44) {
                insertionSort(a10, low, high2);
                return;
            }
            if ((bits2 == 0 || (size > 4096 && (bits2 & 1) > 0)) && tryMergeRuns(sorter, a10, low, size)) {
                return;
            }
            bits2 += 6;
            if (bits2 > 384) {
                heapSort(a10, low, high2);
                return;
            }
            int step = ((size >> 3) * 3) + 3;
            int k10 = low + step;
            int e52 = end - step;
            int e32 = (k10 + e52) >>> 1;
            int e2 = (k10 + e32) >>> 1;
            int e42 = (e32 + e52) >>> 1;
            double a32 = a10[e32];
            if (a10[e52] < a10[e2]) {
                double t2 = a10[e52];
                a10[e52] = a10[e2];
                a10[e2] = t2;
            }
            double t10 = a10[e42];
            if (t10 < a10[k10]) {
                double t11 = a10[e42];
                a10[e42] = a10[k10];
                a10[k10] = t11;
            }
            double t12 = a10[e52];
            if (t12 < a10[e42]) {
                double t13 = a10[e52];
                a10[e52] = a10[e42];
                a10[e42] = t13;
            }
            double t14 = a10[e2];
            if (t14 < a10[k10]) {
                double t15 = a10[e2];
                a10[e2] = a10[k10];
                a10[k10] = t15;
            }
            double t16 = a10[e42];
            if (t16 < a10[e2]) {
                double t17 = a10[e42];
                a10[e42] = a10[e2];
                a10[e2] = t17;
            }
            double t18 = a10[e2];
            if (a32 < t18) {
                if (a32 < a10[k10]) {
                    a10[e32] = a10[e2];
                    a10[e2] = a10[k10];
                    a10[k10] = a32;
                } else {
                    a10[e32] = a10[e2];
                    a10[e2] = a32;
                }
            } else if (a32 > a10[e42]) {
                if (a32 > a10[e52]) {
                    a10[e32] = a10[e42];
                    a10[e42] = a10[e52];
                    a10[e52] = a32;
                } else {
                    a10[e32] = a10[e42];
                    a10[e42] = a32;
                }
            }
            int lower2 = low;
            int upper = end;
            if (a10[k10] < a10[e2] && a10[e2] < a10[e32] && a10[e32] < a10[e42] && a10[e42] < a10[e52]) {
                double pivot1 = a10[k10];
                double pivot2 = a10[e52];
                a10[k10] = a10[lower2];
                a10[e52] = a10[upper];
                do {
                    lower2++;
                } while (a10[lower2] < pivot1);
                do {
                    upper--;
                } while (a10[upper] > pivot2);
                int upper2 = upper + 1;
                int k11 = upper2;
                lower = lower2 - 1;
                int upper3 = upper2;
                while (true) {
                    int e12 = k10;
                    int e13 = k11 - 1;
                    if (e13 <= lower) {
                        break;
                    }
                    double ak = a10[e13];
                    if (ak >= pivot1) {
                        if (ak > pivot2) {
                            upper3--;
                            a10[e13] = a10[upper3];
                            a10[upper3] = ak;
                        }
                        k11 = e13;
                        k10 = e12;
                    }
                    while (true) {
                        if (lower < e13) {
                            lower++;
                            if (a10[lower] >= pivot1) {
                                if (a10[lower] > pivot2) {
                                    upper3--;
                                    a10[e13] = a10[upper3];
                                    a10[upper3] = a10[lower];
                                } else {
                                    a10[e13] = a10[lower];
                                }
                                a10[lower] = ak;
                            }
                        }
                    }
                    k11 = e13;
                    k10 = e12;
                }
                a10[low] = a10[lower];
                a10[lower] = pivot1;
                a10[end] = a10[upper3];
                a10[upper3] = pivot2;
                if (size <= 4096 || sorter == null) {
                    sort(sorter, a10, bits2 | 1, lower + 1, upper3);
                    sort(sorter, a10, bits2 | 1, upper3 + 1, high2);
                } else {
                    sorter.forkSorter(bits2 | 1, lower + 1, upper3);
                    sorter.forkSorter(bits2 | 1, upper3 + 1, high2);
                }
            } else {
                double pivot = a10[e32];
                a10[e32] = a10[lower2];
                int upper4 = upper + 1;
                int k12 = upper4;
                int upper5 = upper4;
                int lower3 = lower2;
                while (true) {
                    k12--;
                    if (k12 <= lower3) {
                        break;
                    }
                    double ak2 = a10[k12];
                    if (ak2 != pivot) {
                        a10[k12] = pivot;
                        if (ak2 < pivot) {
                            do {
                                lower3++;
                            } while (a10[lower3] < pivot);
                            if (a10[lower3] > pivot) {
                                upper5--;
                                a10[upper5] = a10[lower3];
                            }
                            a10[lower3] = ak2;
                        } else {
                            upper5--;
                            a10[upper5] = ak2;
                        }
                    }
                }
                a10[low] = a10[lower3];
                a10[lower3] = pivot;
                if (size <= 4096 || sorter == null) {
                    sort(sorter, a10, bits2 | 1, upper5, high2);
                } else {
                    sorter.forkSorter(bits2 | 1, upper5, high2);
                }
                lower = lower3;
            }
            high2 = lower;
        }
    }

    private static void mixedInsertionSort(double[] a10, int low, int end, int high) {
        if (end != high) {
            double pin = a10[end];
            int p10 = high;
            while (true) {
                low++;
                if (low >= end) {
                    break;
                }
                int i10 = low;
                double ai = a10[low];
                if (ai < a10[i10 - 1]) {
                    int i11 = i10 - 1;
                    a10[i10] = a10[i11];
                    while (true) {
                        i11--;
                        if (ai >= a10[i11]) {
                            break;
                        } else {
                            a10[i11 + 1] = a10[i11];
                        }
                    }
                    a10[i11 + 1] = ai;
                } else if (p10 > i10 && ai > pin) {
                    do {
                        p10--;
                    } while (a10[p10] > pin);
                    if (p10 > i10) {
                        ai = a10[p10];
                        a10[p10] = a10[i10];
                    }
                    while (true) {
                        i10--;
                        if (ai >= a10[i10]) {
                            break;
                        } else {
                            a10[i10 + 1] = a10[i10];
                        }
                    }
                    a10[i10 + 1] = ai;
                }
            }
            while (low < high) {
                int i12 = low;
                double a12 = a10[low];
                int low2 = low + 1;
                double a22 = a10[low2];
                if (a12 > a22) {
                    while (true) {
                        i12--;
                        if (a12 >= a10[i12]) {
                            break;
                        } else {
                            a10[i12 + 2] = a10[i12];
                        }
                    }
                    int i13 = i12 + 1;
                    a10[i13 + 1] = a12;
                    while (true) {
                        i13--;
                        if (a22 >= a10[i13]) {
                            break;
                        } else {
                            a10[i13 + 1] = a10[i13];
                        }
                    }
                    a10[i13 + 1] = a22;
                } else if (a12 < a10[i12 - 1]) {
                    while (true) {
                        i12--;
                        if (a22 >= a10[i12]) {
                            break;
                        } else {
                            a10[i12 + 2] = a10[i12];
                        }
                    }
                    int i14 = i12 + 1;
                    a10[i14 + 1] = a22;
                    while (true) {
                        i14--;
                        if (a12 >= a10[i14]) {
                            break;
                        } else {
                            a10[i14 + 1] = a10[i14];
                        }
                    }
                    a10[i14 + 1] = a12;
                }
                low = low2 + 1;
            }
            return;
        }
        while (true) {
            low++;
            if (low < end) {
                int i15 = low;
                double ai2 = a10[low];
                while (true) {
                    i15--;
                    if (ai2 < a10[i15]) {
                        a10[i15 + 1] = a10[i15];
                    }
                }
                a10[i15 + 1] = ai2;
            } else {
                return;
            }
        }
    }

    private static void insertionSort(double[] a10, int low, int high) {
        int k10 = low;
        while (true) {
            k10++;
            if (k10 < high) {
                int i10 = k10;
                double ai = a10[k10];
                if (ai < a10[i10 - 1]) {
                    while (true) {
                        i10--;
                        if (i10 < low || ai >= a10[i10]) {
                            break;
                        } else {
                            a10[i10 + 1] = a10[i10];
                        }
                    }
                    a10[i10 + 1] = ai;
                }
            } else {
                return;
            }
        }
    }

    private static void heapSort(double[] a10, int low, int high) {
        int k10 = (low + high) >>> 1;
        while (k10 > low) {
            k10--;
            pushDown(a10, k10, a10[k10], low, high);
        }
        while (true) {
            high--;
            if (high > low) {
                double max = a10[low];
                pushDown(a10, low, a10[high], low, high);
                a10[high] = max;
            } else {
                return;
            }
        }
    }

    private static void pushDown(double[] a10, int p10, double value, int low, int high) {
        while (true) {
            int k10 = ((p10 << 1) - low) + 2;
            if (k10 > high) {
                break;
            }
            if (k10 == high || a10[k10] < a10[k10 - 1]) {
                k10--;
            }
            if (a10[k10] <= value) {
                break;
            }
            int p11 = k10;
            a10[p10] = a10[k10];
            p10 = p11;
        }
        a10[p10] = value;
    }

    private static boolean tryMergeRuns(Sorter sorter, double[] a10, int low, int size) {
        int offset;
        double[] b4;
        double[] b10;
        int high = low + size;
        int k10 = low + 1;
        int[] run = null;
        int count = 1;
        int last = low;
        while (k10 < high) {
            if (a10[k10 - 1] < a10[k10]) {
                do {
                    k10++;
                    if (k10 >= high) {
                        break;
                    }
                } while (a10[k10 - 1] <= a10[k10]);
            } else if (a10[k10 - 1] > a10[k10]) {
                do {
                    k10++;
                    if (k10 >= high) {
                        break;
                    }
                } while (a10[k10 - 1] >= a10[k10]);
                int i10 = last - 1;
                int j10 = k10;
                while (true) {
                    i10++;
                    j10--;
                    if (i10 >= j10 || a10[i10] <= a10[j10]) {
                        break;
                    }
                    double ai = a10[i10];
                    a10[i10] = a10[j10];
                    a10[j10] = ai;
                }
            } else {
                double ak = a10[k10];
                do {
                    k10++;
                    if (k10 >= high) {
                        break;
                    }
                } while (ak == a10[k10]);
                if (k10 < high) {
                    continue;
                }
            }
            if (run == null) {
                if (k10 == high) {
                    return true;
                }
                if (k10 - low < 16) {
                    return false;
                }
                int[] run2 = new int[((size >> 10) | 127) & 1023];
                run2[0] = low;
                run = run2;
            } else if (a10[last - 1] > a10[last]) {
                if (count > ((k10 - low) >> 7) || (count = count + 1) == MAX_RUN_CAPACITY) {
                    return false;
                }
                if (count == run.length) {
                    run = Arrays.copyOf(run, count << 1);
                }
            }
            last = k10;
            run[count] = k10;
        }
        if (count > 1) {
            if (sorter == null || (b10 = (double[]) sorter.f50462b) == null) {
                double[] b11 = new double[size];
                offset = low;
                b4 = b11;
            } else {
                int offset2 = sorter.offset;
                offset = offset2;
                b4 = b10;
            }
            mergeRuns(a10, b4, offset, 1, sorter != null, run, 0, count);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double[] mergeRuns(double[] a10, double[] b4, int offset, int aim, boolean parallel, int[] run, int lo, int hi) {
        int mi;
        double[] a22;
        double[] a12;
        if (hi - lo == 1) {
            if (aim >= 0) {
                return a10;
            }
            int i10 = run[hi];
            int j10 = i10 - offset;
            int low = run[lo];
            while (i10 > low) {
                j10--;
                i10--;
                b4[j10] = a10[i10];
            }
            return b4;
        }
        int mi2 = lo;
        int rmi = (run[lo] + run[hi]) >>> 1;
        while (true) {
            mi = mi2 + 1;
            if (run[mi + 1] > rmi) {
                break;
            }
            mi2 = mi;
        }
        if (parallel && hi - lo > 4) {
            RunMerger merger = new RunMerger(a10, b4, offset, 0, run, mi, hi).forkMe();
            a12 = mergeRuns(a10, b4, offset, -aim, true, run, lo, mi);
            a22 = (double[]) merger.getDestination();
        } else {
            double[] a13 = mergeRuns(a10, b4, offset, -aim, false, run, lo, mi);
            a22 = mergeRuns(a10, b4, offset, 0, false, run, mi, hi);
            a12 = a13;
        }
        double[] dst = a12 == a10 ? b4 : a10;
        int k10 = a12 == a10 ? run[lo] - offset : run[lo];
        int lo1 = a12 == b4 ? run[lo] - offset : run[lo];
        int hi1 = a12 == b4 ? run[mi] - offset : run[mi];
        int lo2 = a22 == b4 ? run[mi] - offset : run[mi];
        int hi2 = a22 == b4 ? run[hi] - offset : run[hi];
        if (parallel) {
            new Merger(null, dst, k10, a12, lo1, hi1, a22, lo2, hi2).invoke();
        } else {
            mergeParts((Merger) null, dst, k10, a12, lo1, hi1, a22, lo2, hi2);
        }
        return dst;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void mergeParts(Merger merger, double[] dst, int k10, double[] a12, int lo1, int hi1, double[] a22, int lo2, int hi2) {
        int k11;
        int lo12;
        int hi12;
        int lo22;
        int hi22;
        double d10;
        if (merger != null && a12 == a22) {
            int lo13 = lo1;
            int hi13 = hi1;
            int lo23 = lo2;
            int hi23 = hi2;
            while (true) {
                if (hi13 - lo13 >= hi23 - lo23) {
                    lo12 = lo13;
                    hi12 = hi13;
                    lo22 = lo23;
                    hi22 = hi23;
                } else {
                    int lo = lo13;
                    int hi = hi13;
                    lo12 = lo23;
                    hi12 = hi23;
                    lo22 = lo;
                    hi22 = hi;
                }
                if (hi12 - lo12 < 4096) {
                    break;
                }
                int mi1 = (lo12 + hi12) >>> 1;
                double key = a12[mi1];
                int mi2 = hi22;
                int loo = lo22;
                int mi22 = mi2;
                while (loo < mi22) {
                    int t2 = (loo + mi22) >>> 1;
                    if (key > a22[t2]) {
                        loo = t2 + 1;
                    } else {
                        mi22 = t2;
                    }
                }
                int d11 = ((mi22 - lo22) + mi1) - lo12;
                int i10 = mi22;
                int mi23 = mi22;
                int mi24 = hi22;
                merger.forkMerger(dst, k10 + d11, a12, mi1, hi12, a22, i10, mi24);
                hi13 = mi1;
                hi23 = mi23;
                lo13 = lo12;
                lo23 = lo22;
            }
            k11 = k10;
        } else {
            k11 = k10;
            lo12 = lo1;
            hi12 = hi1;
            lo22 = lo2;
            hi22 = hi2;
        }
        while (lo12 < hi12 && lo22 < hi22) {
            int k12 = k11 + 1;
            if (a12[lo12] < a22[lo22]) {
                d10 = a12[lo12];
                lo12++;
            } else {
                d10 = a22[lo22];
                lo22++;
            }
            dst[k11] = d10;
            k11 = k12;
        }
        if (dst != a12 || k11 < lo12) {
            while (lo12 < hi12) {
                dst[k11] = a12[lo12];
                k11++;
                lo12++;
            }
        }
        if (dst != a22 || k11 < lo22) {
            while (lo22 < hi22) {
                dst[k11] = a22[lo22];
                k11++;
                lo22++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Sorter extends CountedCompleter<Void> {
        private static final long serialVersionUID = 20180818;

        /* renamed from: a, reason: collision with root package name */
        private final Object f50461a;

        /* renamed from: b, reason: collision with root package name */
        private final Object f50462b;
        private final int depth;
        private final int low;
        private final int offset;
        private final int size;

        private Sorter(CountedCompleter<?> parent, Object a10, Object b4, int low, int size, int offset, int depth) {
            super(parent);
            this.f50461a = a10;
            this.f50462b = b4;
            this.low = low;
            this.size = size;
            this.offset = offset;
            this.depth = depth;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            int i10 = this.depth;
            if (i10 < 0) {
                setPendingCount(2);
                int half = this.size >> 1;
                new Sorter(this, this.f50462b, this.f50461a, this.low, half, this.offset, this.depth + 1).fork();
                new Sorter(this, this.f50462b, this.f50461a, this.low + half, this.size - half, this.offset, this.depth + 1).compute();
            } else {
                Object obj = this.f50461a;
                if (obj instanceof int[]) {
                    int i11 = this.low;
                    DualPivotQuicksort.sort(this, (int[]) obj, i10, i11, this.size + i11);
                } else if (obj instanceof long[]) {
                    int i12 = this.low;
                    DualPivotQuicksort.sort(this, (long[]) obj, i10, i12, this.size + i12);
                } else if (obj instanceof float[]) {
                    int i13 = this.low;
                    DualPivotQuicksort.sort(this, (float[]) obj, i10, i13, this.size + i13);
                } else if (obj instanceof double[]) {
                    int i14 = this.low;
                    DualPivotQuicksort.sort(this, (double[]) obj, i10, i14, this.size + i14);
                } else {
                    throw new IllegalArgumentException("Unknown type of array: " + this.f50461a.getClass().getName());
                }
            }
            tryComplete();
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void onCompletion(CountedCompleter<?> caller) {
            int i10 = this.depth;
            if (i10 < 0) {
                int mi = this.low + (this.size >> 1);
                boolean src = (i10 & 1) == 0;
                CountedCompleter countedCompleter = null;
                Object obj = this.f50461a;
                int i11 = this.low;
                if (!src) {
                    i11 -= this.offset;
                }
                int i12 = i11;
                Object obj2 = this.f50462b;
                int i13 = this.low;
                if (src) {
                    i13 -= this.offset;
                }
                int i14 = i13;
                int i15 = src ? mi - this.offset : mi;
                int i16 = src ? mi - this.offset : mi;
                int i17 = this.low + this.size;
                if (src) {
                    i17 -= this.offset;
                }
                new Merger(countedCompleter, obj, i12, obj2, i14, i15, obj2, i16, i17).invoke();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void forkSorter(int depth, int low, int high) {
            addToPendingCount(1);
            Object a10 = this.f50461a;
            new Sorter(this, a10, this.f50462b, low, high - low, this.offset, depth).fork();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class Merger extends CountedCompleter<Void> {
        private static final long serialVersionUID = 20180818;

        /* renamed from: a1, reason: collision with root package name */
        private final Object f50456a1;

        /* renamed from: a2, reason: collision with root package name */
        private final Object f50457a2;
        private final Object dst;
        private final int hi1;
        private final int hi2;

        /* renamed from: k, reason: collision with root package name */
        private final int f50458k;
        private final int lo1;
        private final int lo2;

        private Merger(CountedCompleter<?> parent, Object dst, int k10, Object a12, int lo1, int hi1, Object a22, int lo2, int hi2) {
            super(parent);
            this.dst = dst;
            this.f50458k = k10;
            this.f50456a1 = a12;
            this.lo1 = lo1;
            this.hi1 = hi1;
            this.f50457a2 = a22;
            this.lo2 = lo2;
            this.hi2 = hi2;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            Object obj = this.dst;
            if (obj instanceof int[]) {
                DualPivotQuicksort.mergeParts(this, (int[]) obj, this.f50458k, (int[]) this.f50456a1, this.lo1, this.hi1, (int[]) this.f50457a2, this.lo2, this.hi2);
            } else if (obj instanceof long[]) {
                DualPivotQuicksort.mergeParts(this, (long[]) obj, this.f50458k, (long[]) this.f50456a1, this.lo1, this.hi1, (long[]) this.f50457a2, this.lo2, this.hi2);
            } else if (obj instanceof float[]) {
                DualPivotQuicksort.mergeParts(this, (float[]) obj, this.f50458k, (float[]) this.f50456a1, this.lo1, this.hi1, (float[]) this.f50457a2, this.lo2, this.hi2);
            } else if (obj instanceof double[]) {
                DualPivotQuicksort.mergeParts(this, (double[]) obj, this.f50458k, (double[]) this.f50456a1, this.lo1, this.hi1, (double[]) this.f50457a2, this.lo2, this.hi2);
            } else {
                throw new IllegalArgumentException("Unknown type of array: " + this.dst.getClass().getName());
            }
            propagateCompletion();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void forkMerger(Object dst, int k10, Object a12, int lo1, int hi1, Object a22, int lo2, int hi2) {
            addToPendingCount(1);
            new Merger(this, dst, k10, a12, lo1, hi1, a22, lo2, hi2).fork();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class RunMerger extends RecursiveTask<Object> {
        private static final long serialVersionUID = 20180818;

        /* renamed from: a, reason: collision with root package name */
        private final Object f50459a;
        private final int aim;

        /* renamed from: b, reason: collision with root package name */
        private final Object f50460b;
        private final int hi;
        private final int lo;
        private final int offset;
        private final int[] run;

        private RunMerger(Object a10, Object b4, int offset, int aim, int[] run, int lo, int hi) {
            this.f50459a = a10;
            this.f50460b = b4;
            this.offset = offset;
            this.aim = aim;
            this.run = run;
            this.lo = lo;
            this.hi = hi;
        }

        @Override // java.util.concurrent.RecursiveTask
        protected final Object compute() {
            Object obj = this.f50459a;
            if (obj instanceof int[]) {
                return DualPivotQuicksort.mergeRuns((int[]) obj, (int[]) this.f50460b, this.offset, this.aim, true, this.run, this.lo, this.hi);
            }
            if (obj instanceof long[]) {
                return DualPivotQuicksort.mergeRuns((long[]) obj, (long[]) this.f50460b, this.offset, this.aim, true, this.run, this.lo, this.hi);
            }
            if (obj instanceof float[]) {
                return DualPivotQuicksort.mergeRuns((float[]) obj, (float[]) this.f50460b, this.offset, this.aim, true, this.run, this.lo, this.hi);
            }
            if (obj instanceof double[]) {
                return DualPivotQuicksort.mergeRuns((double[]) obj, (double[]) this.f50460b, this.offset, this.aim, true, this.run, this.lo, this.hi);
            }
            throw new IllegalArgumentException("Unknown type of array: " + this.f50459a.getClass().getName());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public RunMerger forkMe() {
            fork();
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object getDestination() {
            join();
            return getRawResult();
        }
    }
}
