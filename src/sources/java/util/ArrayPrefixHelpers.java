package java.util;

import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinPool;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class ArrayPrefixHelpers {
    static final int CUMULATE = 1;
    static final int FINISHED = 4;
    static final int MIN_PARTITION = 16;
    static final int SUMMED = 2;

    private ArrayPrefixHelpers() {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class CumulateTask<T> extends CountedCompleter<Void> {
        private static final long serialVersionUID = 5293554502939613543L;
        final T[] array;
        final int fence;
        final BinaryOperator<T> function;
        final int hi;
        T in;
        CumulateTask<T> left;
        final int lo;
        final int origin;
        T out;
        CumulateTask<T> right;
        final int threshold;

        public CumulateTask(CumulateTask<T> parent, BinaryOperator<T> function, T[] array, int lo, int hi) {
            super(parent);
            this.function = function;
            this.array = array;
            this.origin = lo;
            this.lo = lo;
            this.fence = hi;
            this.hi = hi;
            int p10 = (hi - lo) / (ForkJoinPool.getCommonPoolParallelism() << 3);
            this.threshold = p10 > 16 ? p10 : 16;
        }

        CumulateTask(CumulateTask<T> parent, BinaryOperator<T> function, T[] array, int origin, int fence, int threshold, int lo, int hi) {
            super(parent);
            this.function = function;
            this.array = array;
            this.origin = origin;
            this.fence = fence;
            this.threshold = threshold;
            this.lo = lo;
            this.hi = hi;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            T[] tArr;
            int i10;
            int pendingCount;
            int i11;
            T t2;
            int i12;
            T t10;
            int i13;
            CumulateTask<T> cumulateTask;
            BinaryOperator<T> binaryOperator = this.function;
            if (binaryOperator == null || (tArr = this.array) == null) {
                throw new NullPointerException();
            }
            int i14 = this.threshold;
            int i15 = this.origin;
            int i16 = this.fence;
            CumulateTask<T> cumulateTask2 = this;
            while (true) {
                int i17 = cumulateTask2.lo;
                if (i17 >= 0 && (i10 = cumulateTask2.hi) <= tArr.length) {
                    if (i10 - i17 <= i14) {
                        int i18 = i10;
                        do {
                            pendingCount = cumulateTask2.getPendingCount();
                            if ((pendingCount & 4) == 0) {
                                if ((pendingCount & 1) != 0) {
                                    i11 = 4;
                                } else {
                                    i11 = i17 > i15 ? 2 : 6;
                                }
                            } else {
                                return;
                            }
                        } while (!cumulateTask2.compareAndSetPendingCount(pendingCount, pendingCount | i11));
                        if (i11 != 2) {
                            if (i17 == i15) {
                                t10 = tArr[i15];
                                i13 = i15 + 1;
                            } else {
                                t10 = cumulateTask2.in;
                                i13 = i17;
                            }
                            int i19 = i13;
                            while (true) {
                                int i20 = i18;
                                if (i19 >= i20) {
                                    break;
                                }
                                T apply = binaryOperator.apply(t10, tArr[i19]);
                                t10 = apply;
                                tArr[i19] = apply;
                                i19++;
                                i18 = i20;
                            }
                            t2 = t10;
                        } else if (i18 < i16) {
                            T t11 = tArr[i17];
                            for (int i21 = i17 + 1; i21 < i18; i21++) {
                                t11 = binaryOperator.apply(t11, tArr[i21]);
                            }
                            t2 = t11;
                        } else {
                            t2 = cumulateTask2.in;
                        }
                        cumulateTask2.out = t2;
                        while (true) {
                            CumulateTask<T> cumulateTask3 = (CumulateTask) cumulateTask2.getCompleter();
                            if (cumulateTask3 == null) {
                                if ((i11 & 4) != 0) {
                                    cumulateTask2.quietlyComplete();
                                    return;
                                }
                                return;
                            }
                            int pendingCount2 = cumulateTask3.getPendingCount();
                            if ((pendingCount2 & i11 & 4) != 0) {
                                cumulateTask2 = cumulateTask3;
                                i12 = i14;
                            } else if ((pendingCount2 & i11 & 2) != 0) {
                                CumulateTask<T> cumulateTask4 = cumulateTask3.left;
                                if (cumulateTask4 != null) {
                                    CumulateTask<T> cumulateTask5 = cumulateTask3.right;
                                    if (cumulateTask5 != null) {
                                        T t12 = cumulateTask4.out;
                                        i12 = i14;
                                        cumulateTask3.out = cumulateTask5.hi == i16 ? t12 : (T) binaryOperator.apply(t12, cumulateTask5.out);
                                    } else {
                                        i12 = i14;
                                    }
                                } else {
                                    i12 = i14;
                                }
                                int i22 = ((pendingCount2 & 1) == 0 && cumulateTask3.lo == i15) ? 1 : 0;
                                int i23 = pendingCount2 | i11 | i22;
                                if (i23 == pendingCount2 || cumulateTask3.compareAndSetPendingCount(pendingCount2, i23)) {
                                    i11 = 2;
                                    cumulateTask2 = cumulateTask3;
                                    if (i22 != 0) {
                                        cumulateTask3.fork();
                                    }
                                }
                            } else {
                                i12 = i14;
                                if (cumulateTask3.compareAndSetPendingCount(pendingCount2, pendingCount2 | i11)) {
                                    return;
                                }
                            }
                            i14 = i12;
                        }
                    } else {
                        CumulateTask<T> cumulateTask6 = cumulateTask2.left;
                        CumulateTask<T> cumulateTask7 = cumulateTask2.right;
                        if (cumulateTask6 == null) {
                            int i24 = (i17 + i10) >>> 1;
                            CumulateTask<T> cumulateTask8 = cumulateTask2;
                            CumulateTask<T> cumulateTask9 = new CumulateTask<>(cumulateTask8, binaryOperator, tArr, i15, i16, i14, i24, i10);
                            cumulateTask2.right = cumulateTask9;
                            CumulateTask<T> cumulateTask10 = new CumulateTask<>(cumulateTask8, binaryOperator, tArr, i15, i16, i14, i17, i24);
                            cumulateTask2.left = cumulateTask10;
                            cumulateTask2 = cumulateTask10;
                            cumulateTask = cumulateTask9;
                        } else {
                            T t13 = cumulateTask2.in;
                            cumulateTask6.in = t13;
                            CumulateTask<T> cumulateTask11 = null;
                            CumulateTask<T> cumulateTask12 = null;
                            if (cumulateTask7 != null) {
                                T t14 = cumulateTask6.out;
                                cumulateTask7.in = i17 == i15 ? t14 : (T) binaryOperator.apply(t13, t14);
                                while (true) {
                                    int pendingCount3 = cumulateTask7.getPendingCount();
                                    if ((pendingCount3 & 1) == 0) {
                                        if (cumulateTask7.compareAndSetPendingCount(pendingCount3, pendingCount3 | 1)) {
                                            cumulateTask12 = cumulateTask7;
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                            }
                            while (true) {
                                int pendingCount4 = cumulateTask6.getPendingCount();
                                if ((pendingCount4 & 1) == 0) {
                                    if (cumulateTask6.compareAndSetPendingCount(pendingCount4, pendingCount4 | 1)) {
                                        if (cumulateTask12 != null) {
                                            cumulateTask11 = cumulateTask12;
                                        }
                                        cumulateTask2 = cumulateTask6;
                                    }
                                } else {
                                    cumulateTask2 = cumulateTask12;
                                    break;
                                }
                            }
                            if (cumulateTask2 != null) {
                                cumulateTask = cumulateTask11;
                            } else {
                                return;
                            }
                        }
                        if (cumulateTask != null) {
                            cumulateTask.fork();
                        }
                    }
                }
                return;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class LongCumulateTask extends CountedCompleter<Void> {
        private static final long serialVersionUID = -5074099945909284273L;
        final long[] array;
        final int fence;
        final LongBinaryOperator function;
        final int hi;
        long in;
        LongCumulateTask left;
        final int lo;
        final int origin;
        long out;
        LongCumulateTask right;
        final int threshold;

        public LongCumulateTask(LongCumulateTask parent, LongBinaryOperator function, long[] array, int lo, int hi) {
            super(parent);
            this.function = function;
            this.array = array;
            this.origin = lo;
            this.lo = lo;
            this.fence = hi;
            this.hi = hi;
            int p10 = (hi - lo) / (ForkJoinPool.getCommonPoolParallelism() << 3);
            this.threshold = p10 > 16 ? p10 : 16;
        }

        LongCumulateTask(LongCumulateTask parent, LongBinaryOperator function, long[] array, int origin, int fence, int threshold, int lo, int hi) {
            super(parent);
            this.function = function;
            this.array = array;
            this.origin = origin;
            this.fence = fence;
            this.threshold = threshold;
            this.lo = lo;
            this.hi = hi;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            long[] a10;
            int h10;
            int b4;
            int i10;
            int state;
            int h11;
            long sum;
            int th;
            long sum2;
            int h12;
            long applyAsLong;
            int first;
            LongCumulateTask t2;
            LongBinaryOperator fn = this.function;
            if (fn == null || (a10 = this.array) == null) {
                throw new NullPointerException();
            }
            int th2 = this.threshold;
            int org2 = this.origin;
            int fnc = this.fence;
            LongCumulateTask t10 = this;
            while (true) {
                int l10 = t10.lo;
                if (l10 >= 0 && (h10 = t10.hi) <= a10.length) {
                    if (h10 - l10 > th2) {
                        LongCumulateTask lt = t10.left;
                        LongCumulateTask rt = t10.right;
                        if (lt == null) {
                            int mid = (l10 + h10) >>> 1;
                            LongCumulateTask longCumulateTask = t10;
                            LongCumulateTask f10 = new LongCumulateTask(longCumulateTask, fn, a10, org2, fnc, th2, mid, h10);
                            t10.right = f10;
                            LongCumulateTask t11 = new LongCumulateTask(longCumulateTask, fn, a10, org2, fnc, th2, l10, mid);
                            t10.left = t11;
                            t10 = t11;
                            t2 = f10;
                        } else {
                            long pin = t10.in;
                            lt.in = pin;
                            LongCumulateTask f11 = null;
                            LongCumulateTask t12 = null;
                            if (rt != null) {
                                long lout = lt.out;
                                rt.in = l10 == org2 ? lout : fn.applyAsLong(pin, lout);
                                while (true) {
                                    int c4 = rt.getPendingCount();
                                    if ((c4 & 1) == 0) {
                                        if (rt.compareAndSetPendingCount(c4, c4 | 1)) {
                                            t12 = rt;
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                            }
                            while (true) {
                                int c10 = lt.getPendingCount();
                                if ((c10 & 1) == 0) {
                                    if (lt.compareAndSetPendingCount(c10, c10 | 1)) {
                                        if (t12 != null) {
                                            f11 = t12;
                                        }
                                        t10 = lt;
                                    }
                                } else {
                                    t10 = t12;
                                    break;
                                }
                            }
                            if (t10 == null) {
                                return;
                            } else {
                                t2 = f11;
                            }
                        }
                        if (t2 != null) {
                            t2.fork();
                        }
                    } else {
                        int h13 = h10;
                        do {
                            b4 = t10.getPendingCount();
                            i10 = 4;
                            if ((b4 & 4) == 0) {
                                if ((b4 & 1) != 0) {
                                    state = 4;
                                } else {
                                    state = l10 > org2 ? 2 : 6;
                                }
                            } else {
                                return;
                            }
                        } while (!t10.compareAndSetPendingCount(b4, b4 | state));
                        if (state != 2) {
                            if (l10 == org2) {
                                sum = a10[org2];
                                first = org2 + 1;
                            } else {
                                sum = t10.in;
                                first = l10;
                            }
                            int i11 = first;
                            while (true) {
                                h11 = h13;
                                if (i11 >= h11) {
                                    break;
                                }
                                long applyAsLong2 = fn.applyAsLong(sum, a10[i11]);
                                sum = applyAsLong2;
                                a10[i11] = applyAsLong2;
                                i11++;
                                h13 = h11;
                            }
                        } else {
                            h11 = h13;
                            if (h11 < fnc) {
                                long sum3 = a10[l10];
                                sum = sum3;
                                for (int i12 = l10 + 1; i12 < h11; i12++) {
                                    sum = fn.applyAsLong(sum, a10[i12]);
                                }
                            } else {
                                sum = t10.in;
                            }
                        }
                        t10.out = sum;
                        while (true) {
                            LongCumulateTask par = (LongCumulateTask) t10.getCompleter();
                            if (par == null) {
                                if ((state & 4) != 0) {
                                    t10.quietlyComplete();
                                    return;
                                }
                                return;
                            }
                            int b10 = par.getPendingCount();
                            if ((b10 & state & i10) != 0) {
                                th = th2;
                                t10 = par;
                                sum2 = sum;
                                h12 = h11;
                            } else if ((b10 & state & 2) != 0) {
                                LongCumulateTask lt2 = par.left;
                                if (lt2 != null) {
                                    LongCumulateTask rt2 = par.right;
                                    if (rt2 == null) {
                                        sum2 = sum;
                                        h12 = h11;
                                        th = th2;
                                    } else {
                                        h12 = h11;
                                        long lout2 = lt2.out;
                                        th = th2;
                                        if (rt2.hi == fnc) {
                                            sum2 = sum;
                                            applyAsLong = lout2;
                                        } else {
                                            sum2 = sum;
                                            applyAsLong = fn.applyAsLong(lout2, rt2.out);
                                        }
                                        par.out = applyAsLong;
                                    }
                                } else {
                                    th = th2;
                                    sum2 = sum;
                                    h12 = h11;
                                }
                                int refork = ((b10 & 1) == 0 && par.lo == org2) ? 1 : 0;
                                int nextState = b10 | state | refork;
                                if (nextState == b10 || par.compareAndSetPendingCount(b10, nextState)) {
                                    state = 2;
                                    t10 = par;
                                    if (refork != 0) {
                                        par.fork();
                                    }
                                }
                            } else {
                                th = th2;
                                sum2 = sum;
                                h12 = h11;
                                if (par.compareAndSetPendingCount(b10, b10 | state)) {
                                    return;
                                }
                            }
                            th2 = th;
                            h11 = h12;
                            sum = sum2;
                            i10 = 4;
                        }
                    }
                }
                return;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class DoubleCumulateTask extends CountedCompleter<Void> {
        private static final long serialVersionUID = -586947823794232033L;
        final double[] array;
        final int fence;
        final DoubleBinaryOperator function;
        final int hi;
        double in;
        DoubleCumulateTask left;
        final int lo;
        final int origin;
        double out;
        DoubleCumulateTask right;
        final int threshold;

        public DoubleCumulateTask(DoubleCumulateTask parent, DoubleBinaryOperator function, double[] array, int lo, int hi) {
            super(parent);
            this.function = function;
            this.array = array;
            this.origin = lo;
            this.lo = lo;
            this.fence = hi;
            this.hi = hi;
            int p10 = (hi - lo) / (ForkJoinPool.getCommonPoolParallelism() << 3);
            this.threshold = p10 > 16 ? p10 : 16;
        }

        DoubleCumulateTask(DoubleCumulateTask parent, DoubleBinaryOperator function, double[] array, int origin, int fence, int threshold, int lo, int hi) {
            super(parent);
            this.function = function;
            this.array = array;
            this.origin = origin;
            this.fence = fence;
            this.threshold = threshold;
            this.lo = lo;
            this.hi = hi;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            double[] a10;
            int h10;
            int b4;
            int i10;
            int state;
            int h11;
            double sum;
            int th;
            double sum2;
            int h12;
            double applyAsDouble;
            int first;
            DoubleCumulateTask t2;
            DoubleBinaryOperator fn = this.function;
            if (fn == null || (a10 = this.array) == null) {
                throw new NullPointerException();
            }
            int th2 = this.threshold;
            int org2 = this.origin;
            int fnc = this.fence;
            DoubleCumulateTask t10 = this;
            while (true) {
                int l10 = t10.lo;
                if (l10 >= 0 && (h10 = t10.hi) <= a10.length) {
                    if (h10 - l10 > th2) {
                        DoubleCumulateTask lt = t10.left;
                        DoubleCumulateTask rt = t10.right;
                        if (lt == null) {
                            int mid = (l10 + h10) >>> 1;
                            DoubleCumulateTask doubleCumulateTask = t10;
                            DoubleCumulateTask f10 = new DoubleCumulateTask(doubleCumulateTask, fn, a10, org2, fnc, th2, mid, h10);
                            t10.right = f10;
                            DoubleCumulateTask t11 = new DoubleCumulateTask(doubleCumulateTask, fn, a10, org2, fnc, th2, l10, mid);
                            t10.left = t11;
                            t10 = t11;
                            t2 = f10;
                        } else {
                            double pin = t10.in;
                            lt.in = pin;
                            DoubleCumulateTask f11 = null;
                            DoubleCumulateTask t12 = null;
                            if (rt != null) {
                                double lout = lt.out;
                                rt.in = l10 == org2 ? lout : fn.applyAsDouble(pin, lout);
                                while (true) {
                                    int c4 = rt.getPendingCount();
                                    if ((c4 & 1) == 0) {
                                        if (rt.compareAndSetPendingCount(c4, c4 | 1)) {
                                            t12 = rt;
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                            }
                            while (true) {
                                int c10 = lt.getPendingCount();
                                if ((c10 & 1) == 0) {
                                    if (lt.compareAndSetPendingCount(c10, c10 | 1)) {
                                        if (t12 != null) {
                                            f11 = t12;
                                        }
                                        t10 = lt;
                                    }
                                } else {
                                    t10 = t12;
                                    break;
                                }
                            }
                            if (t10 == null) {
                                return;
                            } else {
                                t2 = f11;
                            }
                        }
                        if (t2 != null) {
                            t2.fork();
                        }
                    } else {
                        int h13 = h10;
                        do {
                            b4 = t10.getPendingCount();
                            i10 = 4;
                            if ((b4 & 4) == 0) {
                                if ((b4 & 1) != 0) {
                                    state = 4;
                                } else {
                                    state = l10 > org2 ? 2 : 6;
                                }
                            } else {
                                return;
                            }
                        } while (!t10.compareAndSetPendingCount(b4, b4 | state));
                        if (state != 2) {
                            if (l10 == org2) {
                                sum = a10[org2];
                                first = org2 + 1;
                            } else {
                                sum = t10.in;
                                first = l10;
                            }
                            int i11 = first;
                            while (true) {
                                h11 = h13;
                                if (i11 >= h11) {
                                    break;
                                }
                                double applyAsDouble2 = fn.applyAsDouble(sum, a10[i11]);
                                sum = applyAsDouble2;
                                a10[i11] = applyAsDouble2;
                                i11++;
                                h13 = h11;
                            }
                        } else {
                            h11 = h13;
                            if (h11 < fnc) {
                                double sum3 = a10[l10];
                                sum = sum3;
                                for (int i12 = l10 + 1; i12 < h11; i12++) {
                                    sum = fn.applyAsDouble(sum, a10[i12]);
                                }
                            } else {
                                sum = t10.in;
                            }
                        }
                        t10.out = sum;
                        while (true) {
                            DoubleCumulateTask par = (DoubleCumulateTask) t10.getCompleter();
                            if (par == null) {
                                if ((state & 4) != 0) {
                                    t10.quietlyComplete();
                                    return;
                                }
                                return;
                            }
                            int b10 = par.getPendingCount();
                            if ((b10 & state & i10) != 0) {
                                th = th2;
                                t10 = par;
                                sum2 = sum;
                                h12 = h11;
                            } else if ((b10 & state & 2) != 0) {
                                DoubleCumulateTask lt2 = par.left;
                                if (lt2 != null) {
                                    DoubleCumulateTask rt2 = par.right;
                                    if (rt2 == null) {
                                        sum2 = sum;
                                        h12 = h11;
                                        th = th2;
                                    } else {
                                        h12 = h11;
                                        double lout2 = lt2.out;
                                        th = th2;
                                        if (rt2.hi == fnc) {
                                            sum2 = sum;
                                            applyAsDouble = lout2;
                                        } else {
                                            sum2 = sum;
                                            applyAsDouble = fn.applyAsDouble(lout2, rt2.out);
                                        }
                                        par.out = applyAsDouble;
                                    }
                                } else {
                                    th = th2;
                                    sum2 = sum;
                                    h12 = h11;
                                }
                                int refork = ((b10 & 1) == 0 && par.lo == org2) ? 1 : 0;
                                int nextState = b10 | state | refork;
                                if (nextState == b10 || par.compareAndSetPendingCount(b10, nextState)) {
                                    state = 2;
                                    t10 = par;
                                    if (refork != 0) {
                                        par.fork();
                                    }
                                }
                            } else {
                                th = th2;
                                sum2 = sum;
                                h12 = h11;
                                if (par.compareAndSetPendingCount(b10, b10 | state)) {
                                    return;
                                }
                            }
                            th2 = th;
                            h11 = h12;
                            sum = sum2;
                            i10 = 4;
                        }
                    }
                }
                return;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class IntCumulateTask extends CountedCompleter<Void> {
        private static final long serialVersionUID = 3731755594596840961L;
        final int[] array;
        final int fence;
        final IntBinaryOperator function;
        final int hi;
        int in;
        IntCumulateTask left;
        final int lo;
        final int origin;
        int out;
        IntCumulateTask right;
        final int threshold;

        public IntCumulateTask(IntCumulateTask parent, IntBinaryOperator function, int[] array, int lo, int hi) {
            super(parent);
            this.function = function;
            this.array = array;
            this.origin = lo;
            this.lo = lo;
            this.fence = hi;
            this.hi = hi;
            int p10 = (hi - lo) / (ForkJoinPool.getCommonPoolParallelism() << 3);
            this.threshold = p10 > 16 ? p10 : 16;
        }

        IntCumulateTask(IntCumulateTask parent, IntBinaryOperator function, int[] array, int origin, int fence, int threshold, int lo, int hi) {
            super(parent);
            this.function = function;
            this.array = array;
            this.origin = origin;
            this.fence = fence;
            this.threshold = threshold;
            this.lo = lo;
            this.hi = hi;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
            int[] a10;
            int h10;
            int b4;
            int i10;
            int i11;
            int state;
            int first;
            IntCumulateTask rt;
            int sum;
            int first2;
            IntCumulateTask t2;
            IntBinaryOperator fn = this.function;
            if (fn == null || (a10 = this.array) == null) {
                throw new NullPointerException();
            }
            int th = this.threshold;
            int org2 = this.origin;
            int fnc = this.fence;
            IntCumulateTask t10 = this;
            while (true) {
                int l10 = t10.lo;
                if (l10 >= 0 && (h10 = t10.hi) <= a10.length) {
                    if (h10 - l10 <= th) {
                        int h11 = h10;
                        do {
                            b4 = t10.getPendingCount();
                            i10 = 4;
                            if ((b4 & 4) == 0) {
                                i11 = 2;
                                if ((b4 & 1) != 0) {
                                    state = 4;
                                } else {
                                    state = l10 > org2 ? 2 : 6;
                                }
                            } else {
                                return;
                            }
                        } while (!t10.compareAndSetPendingCount(b4, b4 | state));
                        if (state != 2) {
                            if (l10 == org2) {
                                sum = a10[org2];
                                first2 = org2 + 1;
                            } else {
                                sum = t10.in;
                                first2 = l10;
                            }
                            int i12 = first2;
                            while (true) {
                                int h12 = h11;
                                if (i12 >= h12) {
                                    break;
                                }
                                int applyAsInt = fn.applyAsInt(sum, a10[i12]);
                                sum = applyAsInt;
                                a10[i12] = applyAsInt;
                                i12++;
                                h11 = h12;
                            }
                            first = sum;
                        } else if (h11 < fnc) {
                            int sum2 = a10[l10];
                            for (int i13 = l10 + 1; i13 < h11; i13++) {
                                sum2 = fn.applyAsInt(sum2, a10[i13]);
                            }
                            first = sum2;
                        } else {
                            int sum3 = t10.in;
                            first = sum3;
                        }
                        t10.out = first;
                        while (true) {
                            IntCumulateTask par = (IntCumulateTask) t10.getCompleter();
                            if (par == null) {
                                if ((state & 4) != 0) {
                                    t10.quietlyComplete();
                                    return;
                                }
                                return;
                            }
                            int b10 = par.getPendingCount();
                            if ((b10 & state & i10) != 0) {
                                t10 = par;
                            } else if ((b10 & state & i11) != 0) {
                                IntCumulateTask lt = par.left;
                                if (lt != null && (rt = par.right) != null) {
                                    int lout = lt.out;
                                    par.out = rt.hi == fnc ? lout : fn.applyAsInt(lout, rt.out);
                                }
                                int refork = ((b10 & 1) == 0 && par.lo == org2) ? 1 : 0;
                                int nextState = b10 | state | refork;
                                if (nextState == b10 || par.compareAndSetPendingCount(b10, nextState)) {
                                    state = 2;
                                    t10 = par;
                                    if (refork != 0) {
                                        par.fork();
                                    }
                                }
                            } else if (par.compareAndSetPendingCount(b10, b10 | state)) {
                                return;
                            }
                            i10 = 4;
                            i11 = 2;
                        }
                    } else {
                        IntCumulateTask lt2 = t10.left;
                        IntCumulateTask rt2 = t10.right;
                        if (lt2 == null) {
                            int mid = (l10 + h10) >>> 1;
                            IntCumulateTask intCumulateTask = t10;
                            IntCumulateTask f10 = new IntCumulateTask(intCumulateTask, fn, a10, org2, fnc, th, mid, h10);
                            t10.right = f10;
                            IntCumulateTask t11 = new IntCumulateTask(intCumulateTask, fn, a10, org2, fnc, th, l10, mid);
                            t10.left = t11;
                            t10 = t11;
                            t2 = f10;
                        } else {
                            int pin = t10.in;
                            lt2.in = pin;
                            IntCumulateTask f11 = null;
                            IntCumulateTask t12 = null;
                            if (rt2 != null) {
                                int lout2 = lt2.out;
                                rt2.in = l10 == org2 ? lout2 : fn.applyAsInt(pin, lout2);
                                while (true) {
                                    int c4 = rt2.getPendingCount();
                                    if ((c4 & 1) == 0) {
                                        if (rt2.compareAndSetPendingCount(c4, c4 | 1)) {
                                            t12 = rt2;
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                            }
                            while (true) {
                                int c10 = lt2.getPendingCount();
                                if ((c10 & 1) == 0) {
                                    if (lt2.compareAndSetPendingCount(c10, c10 | 1)) {
                                        if (t12 != null) {
                                            f11 = t12;
                                        }
                                        t10 = lt2;
                                    }
                                } else {
                                    t10 = t12;
                                    break;
                                }
                            }
                            if (t10 != null) {
                                t2 = f11;
                            } else {
                                return;
                            }
                        }
                        if (t2 != null) {
                            t2.fork();
                        }
                    }
                }
                return;
            }
        }
    }
}
