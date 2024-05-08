package java.util;

import java.util.concurrent.CountedCompleter;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class ArraysParallelSortHelpers {
    ArraysParallelSortHelpers() {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class EmptyCompleter extends CountedCompleter<Void> {
        static final long serialVersionUID = 2446542900576103244L;

        EmptyCompleter(CountedCompleter<?> p10) {
            super(p10);
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class Relay extends CountedCompleter<Void> {
        static final long serialVersionUID = 2446542900576103244L;
        final CountedCompleter<?> task;

        Relay(CountedCompleter<?> task) {
            super(null, 1);
            this.task = task;
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void compute() {
        }

        @Override // java.util.concurrent.CountedCompleter
        public final void onCompletion(CountedCompleter<?> t2) {
            this.task.compute();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class FJObject {
        FJObject() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static final class Sorter<T> extends CountedCompleter<Void> {
            static final long serialVersionUID = 2446542900576103244L;

            /* renamed from: a, reason: collision with root package name */
            final T[] f50429a;
            final int base;
            Comparator<? super T> comparator;
            final int gran;
            final int size;

            /* renamed from: w, reason: collision with root package name */
            final T[] f50430w;
            final int wbase;

            /* JADX INFO: Access modifiers changed from: package-private */
            public Sorter(CountedCompleter<?> par, T[] a10, T[] w3, int base, int size, int wbase, int gran, Comparator<? super T> comparator) {
                super(par);
                this.f50429a = a10;
                this.f50430w = w3;
                this.base = base;
                this.size = size;
                this.wbase = wbase;
                this.gran = gran;
                this.comparator = comparator;
            }

            @Override // java.util.concurrent.CountedCompleter
            public final void compute() {
                CountedCompleter<?> s2 = this;
                Comparator<? super T> c4 = this.comparator;
                T[] a10 = this.f50429a;
                T[] w3 = this.f50430w;
                int b4 = this.base;
                int n10 = this.size;
                int wb2 = this.wbase;
                int g3 = this.gran;
                int n11 = n10;
                while (n11 > g3) {
                    int h10 = n11 >>> 1;
                    int q10 = h10 >>> 1;
                    int u10 = h10 + q10;
                    int g10 = n11 - h10;
                    int n12 = n11;
                    int g11 = g3;
                    int g12 = b4;
                    int wb3 = wb2;
                    int b10 = b4;
                    Comparator<? super T> comparator = c4;
                    Relay fc2 = new Relay(new Merger(s2, w3, a10, wb2, h10, wb2 + h10, g10, g12, g11, comparator));
                    Relay rc2 = new Relay(new Merger(fc2, a10, w3, b10 + h10, q10, b10 + u10, n12 - u10, wb3 + h10, g11, comparator));
                    new Sorter(rc2, a10, w3, b10 + u10, n12 - u10, wb3 + u10, g11, comparator).fork();
                    T[] w10 = w3;
                    T[] a11 = a10;
                    new Sorter(rc2, a10, w3, b10 + h10, q10, wb3 + h10, g11, c4).fork();
                    Comparator<? super T> c10 = c4;
                    Relay bc2 = new Relay(new Merger(fc2, a11, w10, b10, q10, b10 + q10, h10 - q10, wb3, g11, c10));
                    new Sorter(bc2, a11, w10, b10 + q10, h10 - q10, wb3 + q10, g11, c10).fork();
                    CountedCompleter<?> s10 = new EmptyCompleter(bc2);
                    n11 = q10;
                    w3 = w10;
                    s2 = s10;
                    g3 = g11;
                    wb2 = wb3;
                    b4 = b10;
                    a10 = a11;
                    c4 = c10;
                }
                CountedCompleter<?> s11 = s2;
                int n13 = n11;
                int b11 = b4;
                T[] a12 = a10;
                Comparator<? super T> c11 = c4;
                int i10 = b11 + n13;
                TimSort.sort(a12, b11, i10, c11, w3, wb2, n13);
                s11.tryComplete();
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static final class Merger<T> extends CountedCompleter<Void> {
            static final long serialVersionUID = 2446542900576103244L;

            /* renamed from: a, reason: collision with root package name */
            final T[] f50427a;
            Comparator<? super T> comparator;
            final int gran;
            final int lbase;
            final int lsize;
            final int rbase;
            final int rsize;

            /* renamed from: w, reason: collision with root package name */
            final T[] f50428w;
            final int wbase;

            Merger(CountedCompleter<?> par, T[] a10, T[] w3, int lbase, int lsize, int rbase, int rsize, int wbase, int gran, Comparator<? super T> comparator) {
                super(par);
                this.f50427a = a10;
                this.f50428w = w3;
                this.lbase = lbase;
                this.lsize = lsize;
                this.rbase = rbase;
                this.rsize = rsize;
                this.wbase = wbase;
                this.gran = gran;
                this.comparator = comparator;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.CountedCompleter
            public final void compute() {
                int i10;
                int i11;
                Object obj;
                Comparator<? super T> comparator = this.comparator;
                T[] tArr = this.f50427a;
                T[] tArr2 = this.f50428w;
                int i12 = this.lbase;
                int i13 = this.lsize;
                int i14 = this.rbase;
                int i15 = this.rsize;
                int i16 = this.wbase;
                int i17 = this.gran;
                if (tArr == null || tArr2 == null || i12 < 0 || i14 < 0 || i16 < 0 || comparator == null) {
                    throw new IllegalStateException();
                }
                int i18 = i13;
                int i19 = i15;
                while (true) {
                    int i20 = 1;
                    if (i18 >= i19) {
                        if (i18 <= i17) {
                            break;
                        }
                        int i21 = i19;
                        int i22 = i18 >>> 1;
                        Object obj2 = (Object) tArr[i22 + i12];
                        int i23 = 0;
                        while (i23 < i21) {
                            int i24 = (i23 + i21) >>> i20;
                            if (comparator.compare(obj2, (Object) tArr[i24 + i14]) <= 0) {
                                i21 = i24;
                            } else {
                                i23 = i24 + 1;
                            }
                            i20 = 1;
                        }
                        i11 = i21;
                        i10 = i22;
                        int i25 = i17;
                        Merger merger = new Merger(this, tArr, tArr2, i12 + i10, i18 - i10, i14 + i11, i19 - i11, i16 + i10 + i11, i25, comparator);
                        i19 = i11;
                        i18 = i10;
                        addToPendingCount(1);
                        merger.fork();
                        i17 = i25;
                        i16 = i16;
                        tArr = (T[]) tArr;
                        i14 = i14;
                    } else {
                        if (i19 <= i17) {
                            break;
                        }
                        int i26 = i18;
                        int i27 = i19 >>> 1;
                        Object obj3 = (Object) tArr[i27 + i14];
                        int i28 = 0;
                        while (i28 < i26) {
                            int i29 = (i28 + i26) >>> 1;
                            if (comparator.compare(obj3, (Object) tArr[i29 + i12]) <= 0) {
                                i26 = i29;
                            } else {
                                i28 = i29 + 1;
                            }
                        }
                        i10 = i26;
                        i11 = i27;
                        int i252 = i17;
                        Merger merger2 = new Merger(this, tArr, tArr2, i12 + i10, i18 - i10, i14 + i11, i19 - i11, i16 + i10 + i11, i252, comparator);
                        i19 = i11;
                        i18 = i10;
                        addToPendingCount(1);
                        merger2.fork();
                        i17 = i252;
                        i16 = i16;
                        tArr = (T[]) tArr;
                        i14 = i14;
                    }
                }
                int i30 = i12 + i18;
                int i31 = i14 + i19;
                while (i12 < i30 && i14 < i31) {
                    Object obj4 = (Object) tArr[i12];
                    Object obj5 = (Object) tArr[i14];
                    if (comparator.compare(obj4, obj5) <= 0) {
                        i12++;
                        obj = obj4;
                    } else {
                        i14++;
                        obj = obj5;
                    }
                    tArr2[i16] = obj;
                    i16++;
                }
                if (i14 < i31) {
                    System.arraycopy(tArr, i14, tArr2, i16, i31 - i14);
                } else if (i12 < i30) {
                    System.arraycopy(tArr, i12, tArr2, i16, i30 - i12);
                }
                tryComplete();
            }
        }
    }
}
