package java.util;

import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Spliterators {
    private static final Spliterator<Object> EMPTY_SPLITERATOR = new EmptySpliterator.OfRef();
    private static final Spliterator.OfInt EMPTY_INT_SPLITERATOR = new EmptySpliterator.OfInt();
    private static final Spliterator.OfLong EMPTY_LONG_SPLITERATOR = new EmptySpliterator.OfLong();
    private static final Spliterator.OfDouble EMPTY_DOUBLE_SPLITERATOR = new EmptySpliterator.OfDouble();

    private Spliterators() {
    }

    public static <T> Spliterator<T> emptySpliterator() {
        return (Spliterator<T>) EMPTY_SPLITERATOR;
    }

    public static Spliterator.OfInt emptyIntSpliterator() {
        return EMPTY_INT_SPLITERATOR;
    }

    public static Spliterator.OfLong emptyLongSpliterator() {
        return EMPTY_LONG_SPLITERATOR;
    }

    public static Spliterator.OfDouble emptyDoubleSpliterator() {
        return EMPTY_DOUBLE_SPLITERATOR;
    }

    public static <T> Spliterator<T> spliterator(Object[] array, int additionalCharacteristics) {
        return new ArraySpliterator((Object[]) Objects.requireNonNull(array), additionalCharacteristics);
    }

    public static <T> Spliterator<T> spliterator(Object[] array, int fromIndex, int toIndex, int additionalCharacteristics) {
        checkFromToBounds(((Object[]) Objects.requireNonNull(array)).length, fromIndex, toIndex);
        return new ArraySpliterator(array, fromIndex, toIndex, additionalCharacteristics);
    }

    public static Spliterator.OfInt spliterator(int[] array, int additionalCharacteristics) {
        return new IntArraySpliterator((int[]) Objects.requireNonNull(array), additionalCharacteristics);
    }

    public static Spliterator.OfInt spliterator(int[] array, int fromIndex, int toIndex, int additionalCharacteristics) {
        checkFromToBounds(((int[]) Objects.requireNonNull(array)).length, fromIndex, toIndex);
        return new IntArraySpliterator(array, fromIndex, toIndex, additionalCharacteristics);
    }

    public static Spliterator.OfLong spliterator(long[] array, int additionalCharacteristics) {
        return new LongArraySpliterator((long[]) Objects.requireNonNull(array), additionalCharacteristics);
    }

    public static Spliterator.OfLong spliterator(long[] array, int fromIndex, int toIndex, int additionalCharacteristics) {
        checkFromToBounds(((long[]) Objects.requireNonNull(array)).length, fromIndex, toIndex);
        return new LongArraySpliterator(array, fromIndex, toIndex, additionalCharacteristics);
    }

    public static Spliterator.OfDouble spliterator(double[] array, int additionalCharacteristics) {
        return new DoubleArraySpliterator((double[]) Objects.requireNonNull(array), additionalCharacteristics);
    }

    public static Spliterator.OfDouble spliterator(double[] array, int fromIndex, int toIndex, int additionalCharacteristics) {
        checkFromToBounds(((double[]) Objects.requireNonNull(array)).length, fromIndex, toIndex);
        return new DoubleArraySpliterator(array, fromIndex, toIndex, additionalCharacteristics);
    }

    private static void checkFromToBounds(int arrayLength, int origin, int fence) {
        if (origin > fence) {
            throw new ArrayIndexOutOfBoundsException("origin(" + origin + ") > fence(" + fence + ")");
        }
        if (origin < 0) {
            throw new ArrayIndexOutOfBoundsException(origin);
        }
        if (fence > arrayLength) {
            throw new ArrayIndexOutOfBoundsException(fence);
        }
    }

    public static <T> Spliterator<T> spliterator(Collection<? extends T> c4, int characteristics) {
        return new IteratorSpliterator((Collection) Objects.requireNonNull(c4), characteristics);
    }

    public static <T> Spliterator<T> spliterator(Iterator<? extends T> iterator, long size, int characteristics) {
        return new IteratorSpliterator((Iterator) Objects.requireNonNull(iterator), size, characteristics);
    }

    public static <T> Spliterator<T> spliteratorUnknownSize(Iterator<? extends T> iterator, int characteristics) {
        return new IteratorSpliterator((Iterator) Objects.requireNonNull(iterator), characteristics);
    }

    public static Spliterator.OfInt spliterator(PrimitiveIterator.OfInt iterator, long size, int characteristics) {
        return new IntIteratorSpliterator((PrimitiveIterator.OfInt) Objects.requireNonNull(iterator), size, characteristics);
    }

    public static Spliterator.OfInt spliteratorUnknownSize(PrimitiveIterator.OfInt iterator, int characteristics) {
        return new IntIteratorSpliterator((PrimitiveIterator.OfInt) Objects.requireNonNull(iterator), characteristics);
    }

    public static Spliterator.OfLong spliterator(PrimitiveIterator.OfLong iterator, long size, int characteristics) {
        return new LongIteratorSpliterator((PrimitiveIterator.OfLong) Objects.requireNonNull(iterator), size, characteristics);
    }

    public static Spliterator.OfLong spliteratorUnknownSize(PrimitiveIterator.OfLong iterator, int characteristics) {
        return new LongIteratorSpliterator((PrimitiveIterator.OfLong) Objects.requireNonNull(iterator), characteristics);
    }

    public static Spliterator.OfDouble spliterator(PrimitiveIterator.OfDouble iterator, long size, int characteristics) {
        return new DoubleIteratorSpliterator((PrimitiveIterator.OfDouble) Objects.requireNonNull(iterator), size, characteristics);
    }

    public static Spliterator.OfDouble spliteratorUnknownSize(PrimitiveIterator.OfDouble iterator, int characteristics) {
        return new DoubleIteratorSpliterator((PrimitiveIterator.OfDouble) Objects.requireNonNull(iterator), characteristics);
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.Spliterators$1Adapter, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    class C1Adapter<T> implements Iterator<T>, Consumer<T> {
        T nextElement;
        final /* synthetic */ Spliterator val$spliterator;
        boolean valueReady = false;

        C1Adapter(Spliterator spliterator) {
            this.val$spliterator = spliterator;
        }

        @Override // java.util.function.Consumer
        public void accept(T t2) {
            this.valueReady = true;
            this.nextElement = t2;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.valueReady) {
                this.val$spliterator.tryAdvance(this);
            }
            return this.valueReady;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.valueReady && !hasNext()) {
                throw new NoSuchElementException();
            }
            this.valueReady = false;
            T t2 = this.nextElement;
            this.nextElement = null;
            return t2;
        }

        @Override // java.util.Iterator
        public void forEachRemaining(Consumer<? super T> consumer) {
            Objects.requireNonNull(consumer);
            if (this.valueReady) {
                this.valueReady = false;
                T t2 = this.nextElement;
                this.nextElement = null;
                consumer.accept(t2);
            }
            this.val$spliterator.forEachRemaining(consumer);
        }
    }

    public static <T> Iterator<T> iterator(Spliterator<? extends T> spliterator) {
        Objects.requireNonNull(spliterator);
        return new C1Adapter(spliterator);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.Spliterators$2Adapter, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    class C2Adapter implements PrimitiveIterator.OfInt, IntConsumer {
        int nextElement;
        final /* synthetic */ Spliterator.OfInt val$spliterator;
        boolean valueReady = false;

        C2Adapter(Spliterator.OfInt ofInt) {
            this.val$spliterator = ofInt;
        }

        @Override // java.util.function.IntConsumer
        public void accept(int t2) {
            this.valueReady = true;
            this.nextElement = t2;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.valueReady) {
                this.val$spliterator.tryAdvance((IntConsumer) this);
            }
            return this.valueReady;
        }

        @Override // java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            if (!this.valueReady && !hasNext()) {
                throw new NoSuchElementException();
            }
            this.valueReady = false;
            return this.nextElement;
        }

        @Override // java.util.PrimitiveIterator.OfInt, java.util.PrimitiveIterator
        public void forEachRemaining(IntConsumer action) {
            Objects.requireNonNull(action);
            if (this.valueReady) {
                this.valueReady = false;
                action.accept(this.nextElement);
            }
            this.val$spliterator.forEachRemaining(action);
        }
    }

    public static PrimitiveIterator.OfInt iterator(Spliterator.OfInt spliterator) {
        Objects.requireNonNull(spliterator);
        return new C2Adapter(spliterator);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.Spliterators$3Adapter, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    class C3Adapter implements PrimitiveIterator.OfLong, LongConsumer {
        long nextElement;
        final /* synthetic */ Spliterator.OfLong val$spliterator;
        boolean valueReady = false;

        C3Adapter(Spliterator.OfLong ofLong) {
            this.val$spliterator = ofLong;
        }

        @Override // java.util.function.LongConsumer
        public void accept(long t2) {
            this.valueReady = true;
            this.nextElement = t2;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.valueReady) {
                this.val$spliterator.tryAdvance((LongConsumer) this);
            }
            return this.valueReady;
        }

        @Override // java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            if (!this.valueReady && !hasNext()) {
                throw new NoSuchElementException();
            }
            this.valueReady = false;
            return this.nextElement;
        }

        @Override // java.util.PrimitiveIterator.OfLong, java.util.PrimitiveIterator
        public void forEachRemaining(LongConsumer action) {
            Objects.requireNonNull(action);
            if (this.valueReady) {
                this.valueReady = false;
                action.accept(this.nextElement);
            }
            this.val$spliterator.forEachRemaining(action);
        }
    }

    public static PrimitiveIterator.OfLong iterator(Spliterator.OfLong spliterator) {
        Objects.requireNonNull(spliterator);
        return new C3Adapter(spliterator);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.Spliterators$4Adapter, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    class C4Adapter implements PrimitiveIterator.OfDouble, DoubleConsumer {
        double nextElement;
        final /* synthetic */ Spliterator.OfDouble val$spliterator;
        boolean valueReady = false;

        C4Adapter(Spliterator.OfDouble ofDouble) {
            this.val$spliterator = ofDouble;
        }

        @Override // java.util.function.DoubleConsumer
        public void accept(double t2) {
            this.valueReady = true;
            this.nextElement = t2;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.valueReady) {
                this.val$spliterator.tryAdvance((DoubleConsumer) this);
            }
            return this.valueReady;
        }

        @Override // java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            if (!this.valueReady && !hasNext()) {
                throw new NoSuchElementException();
            }
            this.valueReady = false;
            return this.nextElement;
        }

        @Override // java.util.PrimitiveIterator.OfDouble, java.util.PrimitiveIterator
        public void forEachRemaining(DoubleConsumer action) {
            Objects.requireNonNull(action);
            if (this.valueReady) {
                this.valueReady = false;
                action.accept(this.nextElement);
            }
            this.val$spliterator.forEachRemaining(action);
        }
    }

    public static PrimitiveIterator.OfDouble iterator(Spliterator.OfDouble spliterator) {
        Objects.requireNonNull(spliterator);
        return new C4Adapter(spliterator);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static abstract class EmptySpliterator<T, S extends Spliterator<T>, C> {
        EmptySpliterator() {
        }

        public S trySplit() {
            return null;
        }

        public boolean tryAdvance(C consumer) {
            Objects.requireNonNull(consumer);
            return false;
        }

        public void forEachRemaining(C consumer) {
            Objects.requireNonNull(consumer);
        }

        public long estimateSize() {
            return 0L;
        }

        public int characteristics() {
            return 16448;
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        private static final class OfRef<T> extends EmptySpliterator<T, Spliterator<T>, Consumer<? super T>> implements Spliterator<T> {
            @Override // java.util.Spliterator
            public /* bridge */ /* synthetic */ void forEachRemaining(Consumer consumer) {
                super.forEachRemaining((OfRef<T>) consumer);
            }

            @Override // java.util.Spliterator
            public /* bridge */ /* synthetic */ boolean tryAdvance(Consumer consumer) {
                return super.tryAdvance((OfRef<T>) consumer);
            }

            OfRef() {
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        private static final class OfInt extends EmptySpliterator<Integer, Spliterator.OfInt, IntConsumer> implements Spliterator.OfInt {
            @Override // java.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
                super.forEachRemaining((OfInt) intConsumer);
            }

            @Override // java.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
                return super.tryAdvance((OfInt) intConsumer);
            }

            @Override // java.util.Spliterators.EmptySpliterator, java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfInt trySplit() {
                return (Spliterator.OfInt) super.trySplit();
            }

            @Override // java.util.Spliterators.EmptySpliterator, java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
                return (Spliterator.OfPrimitive) super.trySplit();
            }

            OfInt() {
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        private static final class OfLong extends EmptySpliterator<Long, Spliterator.OfLong, LongConsumer> implements Spliterator.OfLong {
            @Override // java.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
                super.forEachRemaining((OfLong) longConsumer);
            }

            @Override // java.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
                return super.tryAdvance((OfLong) longConsumer);
            }

            @Override // java.util.Spliterators.EmptySpliterator, java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfLong trySplit() {
                return (Spliterator.OfLong) super.trySplit();
            }

            @Override // java.util.Spliterators.EmptySpliterator, java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
                return (Spliterator.OfPrimitive) super.trySplit();
            }

            OfLong() {
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        private static final class OfDouble extends EmptySpliterator<Double, Spliterator.OfDouble, DoubleConsumer> implements Spliterator.OfDouble {
            @Override // java.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
                super.forEachRemaining((OfDouble) doubleConsumer);
            }

            @Override // java.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
                return super.tryAdvance((OfDouble) doubleConsumer);
            }

            @Override // java.util.Spliterators.EmptySpliterator, java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfDouble trySplit() {
                return (Spliterator.OfDouble) super.trySplit();
            }

            @Override // java.util.Spliterators.EmptySpliterator, java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
                return (Spliterator.OfPrimitive) super.trySplit();
            }

            OfDouble() {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class ArraySpliterator<T> implements Spliterator<T> {
        private final Object[] array;
        private final int characteristics;
        private final int fence;
        private int index;

        public ArraySpliterator(Object[] array, int additionalCharacteristics) {
            this(array, 0, array.length, additionalCharacteristics);
        }

        public ArraySpliterator(Object[] array, int origin, int fence, int additionalCharacteristics) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.characteristics = additionalCharacteristics | 64 | 16384;
        }

        @Override // java.util.Spliterator
        public Spliterator<T> trySplit() {
            int lo = this.index;
            int mid = (this.fence + lo) >>> 1;
            if (lo >= mid) {
                return null;
            }
            Object[] objArr = this.array;
            this.index = mid;
            return new ArraySpliterator(objArr, lo, mid, this.characteristics);
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super T> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            Object[] a10 = this.array;
            int length = a10.length;
            int hi = this.fence;
            if (length >= hi) {
                int i10 = this.index;
                int i11 = i10;
                if (i10 >= 0) {
                    this.index = hi;
                    if (i11 >= hi) {
                        return;
                    }
                    do {
                        action.accept(a10[i11]);
                        i11++;
                    } while (i11 < hi);
                }
            }
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super T> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            int i10 = this.index;
            if (i10 >= 0 && i10 < this.fence) {
                Object[] objArr = this.array;
                this.index = i10 + 1;
                action.accept(objArr[i10]);
                return true;
            }
            return false;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // java.util.Spliterator
        public Comparator<? super T> getComparator() {
            if (hasCharacteristics(4)) {
                return null;
            }
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class IntArraySpliterator implements Spliterator.OfInt {
        private final int[] array;
        private final int characteristics;
        private final int fence;
        private int index;

        public IntArraySpliterator(int[] array, int additionalCharacteristics) {
            this(array, 0, array.length, additionalCharacteristics);
        }

        public IntArraySpliterator(int[] array, int origin, int fence, int additionalCharacteristics) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.characteristics = additionalCharacteristics | 64 | 16384;
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public Spliterator.OfInt trySplit() {
            int lo = this.index;
            int mid = (this.fence + lo) >>> 1;
            if (lo >= mid) {
                return null;
            }
            int[] iArr = this.array;
            this.index = mid;
            return new IntArraySpliterator(iArr, lo, mid, this.characteristics);
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive
        public void forEachRemaining(IntConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            int[] a10 = this.array;
            int length = a10.length;
            int hi = this.fence;
            if (length >= hi) {
                int i10 = this.index;
                int i11 = i10;
                if (i10 >= 0) {
                    this.index = hi;
                    if (i11 >= hi) {
                        return;
                    }
                    do {
                        action.accept(a10[i11]);
                        i11++;
                    } while (i11 < hi);
                }
            }
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive
        public boolean tryAdvance(IntConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            int i10 = this.index;
            if (i10 >= 0 && i10 < this.fence) {
                int[] iArr = this.array;
                this.index = i10 + 1;
                action.accept(iArr[i10]);
                return true;
            }
            return false;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // java.util.Spliterator
        public Comparator<? super Integer> getComparator() {
            if (hasCharacteristics(4)) {
                return null;
            }
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class LongArraySpliterator implements Spliterator.OfLong {
        private final long[] array;
        private final int characteristics;
        private final int fence;
        private int index;

        public LongArraySpliterator(long[] array, int additionalCharacteristics) {
            this(array, 0, array.length, additionalCharacteristics);
        }

        public LongArraySpliterator(long[] array, int origin, int fence, int additionalCharacteristics) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.characteristics = additionalCharacteristics | 64 | 16384;
        }

        @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public Spliterator.OfLong trySplit() {
            int lo = this.index;
            int mid = (this.fence + lo) >>> 1;
            if (lo >= mid) {
                return null;
            }
            long[] jArr = this.array;
            this.index = mid;
            return new LongArraySpliterator(jArr, lo, mid, this.characteristics);
        }

        @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive
        public void forEachRemaining(LongConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            long[] a10 = this.array;
            int length = a10.length;
            int hi = this.fence;
            if (length >= hi) {
                int i10 = this.index;
                int i11 = i10;
                if (i10 >= 0) {
                    this.index = hi;
                    if (i11 >= hi) {
                        return;
                    }
                    do {
                        action.accept(a10[i11]);
                        i11++;
                    } while (i11 < hi);
                }
            }
        }

        @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive
        public boolean tryAdvance(LongConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            int i10 = this.index;
            if (i10 >= 0 && i10 < this.fence) {
                long[] jArr = this.array;
                this.index = i10 + 1;
                action.accept(jArr[i10]);
                return true;
            }
            return false;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // java.util.Spliterator
        public Comparator<? super Long> getComparator() {
            if (hasCharacteristics(4)) {
                return null;
            }
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class DoubleArraySpliterator implements Spliterator.OfDouble {
        private final double[] array;
        private final int characteristics;
        private final int fence;
        private int index;

        public DoubleArraySpliterator(double[] array, int additionalCharacteristics) {
            this(array, 0, array.length, additionalCharacteristics);
        }

        public DoubleArraySpliterator(double[] array, int origin, int fence, int additionalCharacteristics) {
            this.array = array;
            this.index = origin;
            this.fence = fence;
            this.characteristics = additionalCharacteristics | 64 | 16384;
        }

        @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public Spliterator.OfDouble trySplit() {
            int lo = this.index;
            int mid = (this.fence + lo) >>> 1;
            if (lo >= mid) {
                return null;
            }
            double[] dArr = this.array;
            this.index = mid;
            return new DoubleArraySpliterator(dArr, lo, mid, this.characteristics);
        }

        @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive
        public void forEachRemaining(DoubleConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            double[] a10 = this.array;
            int length = a10.length;
            int hi = this.fence;
            if (length >= hi) {
                int i10 = this.index;
                int i11 = i10;
                if (i10 >= 0) {
                    this.index = hi;
                    if (i11 >= hi) {
                        return;
                    }
                    do {
                        action.accept(a10[i11]);
                        i11++;
                    } while (i11 < hi);
                }
            }
        }

        @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive
        public boolean tryAdvance(DoubleConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            int i10 = this.index;
            if (i10 >= 0 && i10 < this.fence) {
                double[] dArr = this.array;
                this.index = i10 + 1;
                action.accept(dArr[i10]);
                return true;
            }
            return false;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.fence - this.index;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // java.util.Spliterator
        public Comparator<? super Double> getComparator() {
            if (hasCharacteristics(4)) {
                return null;
            }
            throw new IllegalStateException();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class AbstractSpliterator<T> implements Spliterator<T> {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        private int batch;
        private final int characteristics;
        private long est;

        /* JADX INFO: Access modifiers changed from: protected */
        public AbstractSpliterator(long est, int additionalCharacteristics) {
            int i10;
            this.est = est;
            if ((additionalCharacteristics & 64) != 0) {
                i10 = additionalCharacteristics | 16384;
            } else {
                i10 = additionalCharacteristics;
            }
            this.characteristics = i10;
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static final class HoldingConsumer<T> implements Consumer<T> {
            Object value;

            HoldingConsumer() {
            }

            @Override // java.util.function.Consumer
            public void accept(T value) {
                this.value = value;
            }
        }

        @Override // java.util.Spliterator
        public Spliterator<T> trySplit() {
            HoldingConsumer<T> holder = new HoldingConsumer<>();
            long s2 = this.est;
            if (s2 > 1 && tryAdvance(holder)) {
                int n10 = this.batch + 1024;
                if (n10 > s2) {
                    n10 = (int) s2;
                }
                if (n10 > 33554432) {
                    n10 = 33554432;
                }
                Object[] a10 = new Object[n10];
                int j10 = 0;
                do {
                    a10[j10] = holder.value;
                    j10++;
                    if (j10 >= n10) {
                        break;
                    }
                } while (tryAdvance(holder));
                this.batch = j10;
                long j11 = this.est;
                if (j11 != Long.MAX_VALUE) {
                    this.est = j11 - j10;
                }
                return new ArraySpliterator(a10, 0, j10, characteristics());
            }
            return null;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class AbstractIntSpliterator implements Spliterator.OfInt {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        private int batch;
        private final int characteristics;
        private long est;

        protected AbstractIntSpliterator(long est, int additionalCharacteristics) {
            int i10;
            this.est = est;
            if ((additionalCharacteristics & 64) != 0) {
                i10 = additionalCharacteristics | 16384;
            } else {
                i10 = additionalCharacteristics;
            }
            this.characteristics = i10;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static final class HoldingIntConsumer implements IntConsumer {
            int value;

            HoldingIntConsumer() {
            }

            @Override // java.util.function.IntConsumer
            public void accept(int value) {
                this.value = value;
            }
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public Spliterator.OfInt trySplit() {
            HoldingIntConsumer holder = new HoldingIntConsumer();
            long s2 = this.est;
            if (s2 > 1 && tryAdvance((IntConsumer) holder)) {
                int n10 = this.batch + 1024;
                if (n10 > s2) {
                    n10 = (int) s2;
                }
                if (n10 > 33554432) {
                    n10 = 33554432;
                }
                int[] a10 = new int[n10];
                int j10 = 0;
                do {
                    a10[j10] = holder.value;
                    j10++;
                    if (j10 >= n10) {
                        break;
                    }
                } while (tryAdvance((IntConsumer) holder));
                this.batch = j10;
                long j11 = this.est;
                if (j11 != Long.MAX_VALUE) {
                    this.est = j11 - j10;
                }
                return new IntArraySpliterator(a10, 0, j10, characteristics());
            }
            return null;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class AbstractLongSpliterator implements Spliterator.OfLong {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        private int batch;
        private final int characteristics;
        private long est;

        protected AbstractLongSpliterator(long est, int additionalCharacteristics) {
            int i10;
            this.est = est;
            if ((additionalCharacteristics & 64) != 0) {
                i10 = additionalCharacteristics | 16384;
            } else {
                i10 = additionalCharacteristics;
            }
            this.characteristics = i10;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static final class HoldingLongConsumer implements LongConsumer {
            long value;

            HoldingLongConsumer() {
            }

            @Override // java.util.function.LongConsumer
            public void accept(long value) {
                this.value = value;
            }
        }

        @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public Spliterator.OfLong trySplit() {
            HoldingLongConsumer holder = new HoldingLongConsumer();
            long s2 = this.est;
            if (s2 > 1 && tryAdvance((LongConsumer) holder)) {
                int n10 = this.batch + 1024;
                if (n10 > s2) {
                    n10 = (int) s2;
                }
                if (n10 > 33554432) {
                    n10 = 33554432;
                }
                long[] a10 = new long[n10];
                int j10 = 0;
                do {
                    a10[j10] = holder.value;
                    j10++;
                    if (j10 >= n10) {
                        break;
                    }
                } while (tryAdvance((LongConsumer) holder));
                this.batch = j10;
                long j11 = this.est;
                if (j11 != Long.MAX_VALUE) {
                    this.est = j11 - j10;
                }
                return new LongArraySpliterator(a10, 0, j10, characteristics());
            }
            return null;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class AbstractDoubleSpliterator implements Spliterator.OfDouble {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        private int batch;
        private final int characteristics;
        private long est;

        protected AbstractDoubleSpliterator(long est, int additionalCharacteristics) {
            int i10;
            this.est = est;
            if ((additionalCharacteristics & 64) != 0) {
                i10 = additionalCharacteristics | 16384;
            } else {
                i10 = additionalCharacteristics;
            }
            this.characteristics = i10;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static final class HoldingDoubleConsumer implements DoubleConsumer {
            double value;

            HoldingDoubleConsumer() {
            }

            @Override // java.util.function.DoubleConsumer
            public void accept(double value) {
                this.value = value;
            }
        }

        @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public Spliterator.OfDouble trySplit() {
            HoldingDoubleConsumer holder = new HoldingDoubleConsumer();
            long s2 = this.est;
            if (s2 > 1 && tryAdvance((DoubleConsumer) holder)) {
                int n10 = this.batch + 1024;
                if (n10 > s2) {
                    n10 = (int) s2;
                }
                if (n10 > 33554432) {
                    n10 = 33554432;
                }
                double[] a10 = new double[n10];
                int j10 = 0;
                do {
                    a10[j10] = holder.value;
                    j10++;
                    if (j10 >= n10) {
                        break;
                    }
                } while (tryAdvance((DoubleConsumer) holder));
                this.batch = j10;
                long j11 = this.est;
                if (j11 != Long.MAX_VALUE) {
                    this.est = j11 - j10;
                }
                return new DoubleArraySpliterator(a10, 0, j10, characteristics());
            }
            return null;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class IteratorSpliterator<T> implements Spliterator<T> {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        private int batch;
        private final int characteristics;
        private final Collection<? extends T> collection;
        private long est;
        private Iterator<? extends T> it;

        public IteratorSpliterator(Collection<? extends T> collection, int characteristics) {
            int i10;
            this.collection = collection;
            this.it = null;
            if ((characteristics & 4096) == 0) {
                i10 = characteristics | 64 | 16384;
            } else {
                i10 = characteristics;
            }
            this.characteristics = i10;
        }

        public IteratorSpliterator(Iterator<? extends T> iterator, long size, int characteristics) {
            int i10;
            this.collection = null;
            this.it = iterator;
            this.est = size;
            if ((characteristics & 4096) == 0) {
                i10 = characteristics | 64 | 16384;
            } else {
                i10 = characteristics;
            }
            this.characteristics = i10;
        }

        public IteratorSpliterator(Iterator<? extends T> iterator, int characteristics) {
            this.collection = null;
            this.it = iterator;
            this.est = Long.MAX_VALUE;
            this.characteristics = characteristics & (-16449);
        }

        @Override // java.util.Spliterator
        public Spliterator<T> trySplit() {
            long s2;
            Iterator<? extends T> it = this.it;
            Iterator<? extends T> i10 = it;
            if (it == null) {
                Iterator<? extends T> iterator2 = this.collection.iterator2();
                this.it = iterator2;
                i10 = iterator2;
                s2 = this.collection.size();
                this.est = s2;
            } else {
                s2 = this.est;
            }
            if (s2 > 1 && i10.hasNext()) {
                int n10 = this.batch + 1024;
                if (n10 > s2) {
                    n10 = (int) s2;
                }
                if (n10 > 33554432) {
                    n10 = 33554432;
                }
                Object[] a10 = new Object[n10];
                int j10 = 0;
                do {
                    a10[j10] = i10.next();
                    j10++;
                    if (j10 >= n10) {
                        break;
                    }
                } while (i10.hasNext());
                this.batch = j10;
                long j11 = this.est;
                if (j11 != Long.MAX_VALUE) {
                    this.est = j11 - j10;
                }
                return new ArraySpliterator(a10, 0, j10, this.characteristics);
            }
            return null;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super T> action) {
            if (action == null) {
                throw new NullPointerException();
            }
            Iterator<? extends T> it = this.it;
            Iterator<? extends T> i10 = it;
            if (it == null) {
                Iterator<? extends T> iterator2 = this.collection.iterator2();
                this.it = iterator2;
                i10 = iterator2;
                this.est = this.collection.size();
            }
            i10.forEachRemaining(action);
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super T> consumer) {
            if (consumer == null) {
                throw new NullPointerException();
            }
            if (this.it == null) {
                this.it = this.collection.iterator2();
                this.est = this.collection.size();
            }
            if (this.it.hasNext()) {
                consumer.accept(this.it.next());
                return true;
            }
            return false;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            if (this.it == null) {
                this.it = this.collection.iterator2();
                long size = this.collection.size();
                this.est = size;
                return size;
            }
            return this.est;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // java.util.Spliterator
        public Comparator<? super T> getComparator() {
            if (hasCharacteristics(4)) {
                return null;
            }
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class IntIteratorSpliterator implements Spliterator.OfInt {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        private int batch;
        private final int characteristics;
        private long est;
        private final PrimitiveIterator.OfInt it;

        public IntIteratorSpliterator(PrimitiveIterator.OfInt iterator, long size, int characteristics) {
            int i10;
            this.it = iterator;
            this.est = size;
            if ((characteristics & 4096) == 0) {
                i10 = characteristics | 64 | 16384;
            } else {
                i10 = characteristics;
            }
            this.characteristics = i10;
        }

        public IntIteratorSpliterator(PrimitiveIterator.OfInt iterator, int characteristics) {
            this.it = iterator;
            this.est = Long.MAX_VALUE;
            this.characteristics = characteristics & (-16449);
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public Spliterator.OfInt trySplit() {
            PrimitiveIterator.OfInt i10 = this.it;
            long s2 = this.est;
            if (s2 > 1 && i10.hasNext()) {
                int n10 = this.batch + 1024;
                if (n10 > s2) {
                    n10 = (int) s2;
                }
                if (n10 > 33554432) {
                    n10 = 33554432;
                }
                int[] a10 = new int[n10];
                int j10 = 0;
                do {
                    a10[j10] = i10.nextInt();
                    j10++;
                    if (j10 >= n10) {
                        break;
                    }
                } while (i10.hasNext());
                this.batch = j10;
                long j11 = this.est;
                if (j11 != Long.MAX_VALUE) {
                    this.est = j11 - j10;
                }
                return new IntArraySpliterator(a10, 0, j10, this.characteristics);
            }
            return null;
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive
        public void forEachRemaining(IntConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            this.it.forEachRemaining(action);
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive
        public boolean tryAdvance(IntConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            if (this.it.hasNext()) {
                action.accept(this.it.nextInt());
                return true;
            }
            return false;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // java.util.Spliterator
        public Comparator<? super Integer> getComparator() {
            if (hasCharacteristics(4)) {
                return null;
            }
            throw new IllegalStateException();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class LongIteratorSpliterator implements Spliterator.OfLong {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        private int batch;
        private final int characteristics;
        private long est;
        private final PrimitiveIterator.OfLong it;

        public LongIteratorSpliterator(PrimitiveIterator.OfLong iterator, long size, int characteristics) {
            int i10;
            this.it = iterator;
            this.est = size;
            if ((characteristics & 4096) == 0) {
                i10 = characteristics | 64 | 16384;
            } else {
                i10 = characteristics;
            }
            this.characteristics = i10;
        }

        public LongIteratorSpliterator(PrimitiveIterator.OfLong iterator, int characteristics) {
            this.it = iterator;
            this.est = Long.MAX_VALUE;
            this.characteristics = characteristics & (-16449);
        }

        @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public Spliterator.OfLong trySplit() {
            PrimitiveIterator.OfLong i10 = this.it;
            long s2 = this.est;
            if (s2 > 1 && i10.hasNext()) {
                int n10 = this.batch + 1024;
                if (n10 > s2) {
                    n10 = (int) s2;
                }
                if (n10 > 33554432) {
                    n10 = 33554432;
                }
                long[] a10 = new long[n10];
                int j10 = 0;
                do {
                    a10[j10] = i10.nextLong();
                    j10++;
                    if (j10 >= n10) {
                        break;
                    }
                } while (i10.hasNext());
                this.batch = j10;
                long j11 = this.est;
                if (j11 != Long.MAX_VALUE) {
                    this.est = j11 - j10;
                }
                return new LongArraySpliterator(a10, 0, j10, this.characteristics);
            }
            return null;
        }

        @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive
        public void forEachRemaining(LongConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            this.it.forEachRemaining(action);
        }

        @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive
        public boolean tryAdvance(LongConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            if (this.it.hasNext()) {
                action.accept(this.it.nextLong());
                return true;
            }
            return false;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // java.util.Spliterator
        public Comparator<? super Long> getComparator() {
            if (hasCharacteristics(4)) {
                return null;
            }
            throw new IllegalStateException();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static final class DoubleIteratorSpliterator implements Spliterator.OfDouble {
        static final int BATCH_UNIT = 1024;
        static final int MAX_BATCH = 33554432;
        private int batch;
        private final int characteristics;
        private long est;
        private final PrimitiveIterator.OfDouble it;

        public DoubleIteratorSpliterator(PrimitiveIterator.OfDouble iterator, long size, int characteristics) {
            int i10;
            this.it = iterator;
            this.est = size;
            if ((characteristics & 4096) == 0) {
                i10 = characteristics | 64 | 16384;
            } else {
                i10 = characteristics;
            }
            this.characteristics = i10;
        }

        public DoubleIteratorSpliterator(PrimitiveIterator.OfDouble iterator, int characteristics) {
            this.it = iterator;
            this.est = Long.MAX_VALUE;
            this.characteristics = characteristics & (-16449);
        }

        @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public Spliterator.OfDouble trySplit() {
            PrimitiveIterator.OfDouble i10 = this.it;
            long s2 = this.est;
            if (s2 > 1 && i10.hasNext()) {
                int n10 = this.batch + 1024;
                if (n10 > s2) {
                    n10 = (int) s2;
                }
                if (n10 > 33554432) {
                    n10 = 33554432;
                }
                double[] a10 = new double[n10];
                int j10 = 0;
                do {
                    a10[j10] = i10.nextDouble();
                    j10++;
                    if (j10 >= n10) {
                        break;
                    }
                } while (i10.hasNext());
                this.batch = j10;
                long j11 = this.est;
                if (j11 != Long.MAX_VALUE) {
                    this.est = j11 - j10;
                }
                return new DoubleArraySpliterator(a10, 0, j10, this.characteristics);
            }
            return null;
        }

        @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive
        public void forEachRemaining(DoubleConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            this.it.forEachRemaining(action);
        }

        @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive
        public boolean tryAdvance(DoubleConsumer action) {
            if (action == null) {
                throw new NullPointerException();
            }
            if (this.it.hasNext()) {
                action.accept(this.it.nextDouble());
                return true;
            }
            return false;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.est;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.characteristics;
        }

        @Override // java.util.Spliterator
        public Comparator<? super Double> getComparator() {
            if (hasCharacteristics(4)) {
                return null;
            }
            throw new IllegalStateException();
        }
    }
}
