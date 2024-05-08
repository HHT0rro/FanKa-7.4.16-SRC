package java.util.stream;

import java.util.Comparator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.SpinedBuffer;
import java.util.stream.Stream;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Streams {
    static final Object NONE = new Object();

    private Streams() {
        throw new Error("no instances");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class RangeIntSpliterator implements Spliterator.OfInt {
        private static final int BALANCED_SPLIT_THRESHOLD = 16777216;
        private static final int RIGHT_BALANCED_SPLIT_RATIO = 8;
        private int from;
        private int last;
        private final int upTo;

        /* JADX INFO: Access modifiers changed from: package-private */
        public RangeIntSpliterator(int i10, int i11, boolean z10) {
            this(i10, i11, z10 ? 1 : 0);
        }

        private RangeIntSpliterator(int from, int upTo, int last) {
            this.from = from;
            this.upTo = upTo;
            this.last = last;
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive
        public boolean tryAdvance(IntConsumer consumer) {
            Objects.requireNonNull(consumer);
            int i10 = this.from;
            if (i10 < this.upTo) {
                this.from++;
                consumer.accept(i10);
                return true;
            }
            if (this.last <= 0) {
                return false;
            }
            this.last = 0;
            consumer.accept(i10);
            return true;
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive
        public void forEachRemaining(IntConsumer consumer) {
            Objects.requireNonNull(consumer);
            int i10 = this.from;
            int hUpTo = this.upTo;
            int hLast = this.last;
            this.from = this.upTo;
            this.last = 0;
            while (i10 < hUpTo) {
                consumer.accept(i10);
                i10++;
            }
            if (hLast > 0) {
                consumer.accept(i10);
            }
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return (this.upTo - this.from) + this.last;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 17749;
        }

        @Override // java.util.Spliterator
        public Comparator<? super Integer> getComparator() {
            return null;
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public Spliterator.OfInt trySplit() {
            long size = estimateSize();
            if (size <= 1) {
                return null;
            }
            int i10 = this.from;
            int splitPoint = splitPoint(size) + i10;
            this.from = splitPoint;
            return new RangeIntSpliterator(i10, splitPoint, 0);
        }

        private int splitPoint(long size) {
            int d10 = size < 16777216 ? 2 : 8;
            return (int) (size / d10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class RangeLongSpliterator implements Spliterator.OfLong {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long BALANCED_SPLIT_THRESHOLD = 16777216;
        private static final long RIGHT_BALANCED_SPLIT_RATIO = 8;
        private long from;
        private int last;
        private final long upTo;

        /* JADX INFO: Access modifiers changed from: package-private */
        public RangeLongSpliterator(long j10, long j11, boolean z10) {
            this(j10, j11, z10 ? 1 : 0);
        }

        private RangeLongSpliterator(long from, long upTo, int last) {
            this.from = from;
            this.upTo = upTo;
            this.last = last;
        }

        @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive
        public boolean tryAdvance(LongConsumer consumer) {
            Objects.requireNonNull(consumer);
            long i10 = this.from;
            if (i10 < this.upTo) {
                this.from++;
                consumer.accept(i10);
                return true;
            }
            if (this.last <= 0) {
                return false;
            }
            this.last = 0;
            consumer.accept(i10);
            return true;
        }

        @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive
        public void forEachRemaining(LongConsumer consumer) {
            Objects.requireNonNull(consumer);
            long i10 = this.from;
            long hUpTo = this.upTo;
            int hLast = this.last;
            this.from = this.upTo;
            this.last = 0;
            while (i10 < hUpTo) {
                consumer.accept(i10);
                i10 = 1 + i10;
            }
            if (hLast > 0) {
                consumer.accept(i10);
            }
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return (this.upTo - this.from) + this.last;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 17749;
        }

        @Override // java.util.Spliterator
        public Comparator<? super Long> getComparator() {
            return null;
        }

        @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public Spliterator.OfLong trySplit() {
            long size = estimateSize();
            if (size <= 1) {
                return null;
            }
            long j10 = this.from;
            long splitPoint = splitPoint(size) + j10;
            this.from = splitPoint;
            return new RangeLongSpliterator(j10, splitPoint, 0);
        }

        private long splitPoint(long size) {
            long d10 = size < BALANCED_SPLIT_THRESHOLD ? 2L : 8L;
            return size / d10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class AbstractStreamBuilderImpl<T, S extends Spliterator<T>> implements Spliterator<T> {
        int count;

        private AbstractStreamBuilderImpl() {
        }

        @Override // java.util.Spliterator
        public S trySplit() {
            return null;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return (-this.count) - 1;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 17488;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class StreamBuilderImpl<T> extends AbstractStreamBuilderImpl<T, Spliterator<T>> implements Stream.Builder<T> {
        SpinedBuffer<T> buffer;
        T first;

        /* JADX INFO: Access modifiers changed from: package-private */
        public StreamBuilderImpl() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public StreamBuilderImpl(T t2) {
            super();
            this.first = t2;
            this.count = -2;
        }

        @Override // java.util.stream.Stream.Builder, java.util.function.Consumer
        public void accept(T t2) {
            if (this.count == 0) {
                this.first = t2;
                this.count++;
            } else {
                if (this.count > 0) {
                    if (this.buffer == null) {
                        SpinedBuffer<T> spinedBuffer = new SpinedBuffer<>();
                        this.buffer = spinedBuffer;
                        spinedBuffer.accept(this.first);
                        this.count++;
                    }
                    this.buffer.accept(t2);
                    return;
                }
                throw new IllegalStateException();
            }
        }

        @Override // java.util.stream.Stream.Builder
        public Stream.Builder<T> add(T t2) {
            accept(t2);
            return this;
        }

        @Override // java.util.stream.Stream.Builder
        public Stream<T> build() {
            int c4 = this.count;
            if (c4 >= 0) {
                this.count = (-this.count) - 1;
                return c4 < 2 ? StreamSupport.stream(this, false) : StreamSupport.stream(this.buffer.spliterator(), false);
            }
            throw new IllegalStateException();
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super T> consumer) {
            Objects.requireNonNull(consumer);
            if (this.count == -2) {
                consumer.accept(this.first);
                this.count = -1;
                return true;
            }
            return false;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super T> consumer) {
            Objects.requireNonNull(consumer);
            if (this.count == -2) {
                consumer.accept(this.first);
                this.count = -1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class IntStreamBuilderImpl extends AbstractStreamBuilderImpl<Integer, Spliterator.OfInt> implements IntStream.Builder, Spliterator.OfInt {
        SpinedBuffer.OfInt buffer;
        int first;

        @Override // java.util.stream.Streams.AbstractStreamBuilderImpl, java.util.Spliterator
        public /* bridge */ /* synthetic */ Spliterator.OfInt trySplit() {
            return (Spliterator.OfInt) super.trySplit();
        }

        @Override // java.util.stream.Streams.AbstractStreamBuilderImpl, java.util.Spliterator
        public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
            return (Spliterator.OfPrimitive) super.trySplit();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public IntStreamBuilderImpl() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public IntStreamBuilderImpl(int t2) {
            super();
            this.first = t2;
            this.count = -2;
        }

        @Override // java.util.stream.IntStream.Builder, java.util.function.IntConsumer
        public void accept(int t2) {
            if (this.count == 0) {
                this.first = t2;
                this.count++;
            } else {
                if (this.count > 0) {
                    if (this.buffer == null) {
                        SpinedBuffer.OfInt ofInt = new SpinedBuffer.OfInt();
                        this.buffer = ofInt;
                        ofInt.accept(this.first);
                        this.count++;
                    }
                    this.buffer.accept(t2);
                    return;
                }
                throw new IllegalStateException();
            }
        }

        @Override // java.util.stream.IntStream.Builder
        public IntStream build() {
            int c4 = this.count;
            if (c4 >= 0) {
                this.count = (-this.count) - 1;
                return c4 < 2 ? StreamSupport.intStream(this, false) : StreamSupport.intStream(this.buffer.spliterator(), false);
            }
            throw new IllegalStateException();
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive
        public boolean tryAdvance(IntConsumer action) {
            Objects.requireNonNull(action);
            if (this.count == -2) {
                action.accept(this.first);
                this.count = -1;
                return true;
            }
            return false;
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive
        public void forEachRemaining(IntConsumer action) {
            Objects.requireNonNull(action);
            if (this.count == -2) {
                action.accept(this.first);
                this.count = -1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class LongStreamBuilderImpl extends AbstractStreamBuilderImpl<Long, Spliterator.OfLong> implements LongStream.Builder, Spliterator.OfLong {
        SpinedBuffer.OfLong buffer;
        long first;

        @Override // java.util.stream.Streams.AbstractStreamBuilderImpl, java.util.Spliterator
        public /* bridge */ /* synthetic */ Spliterator.OfLong trySplit() {
            return (Spliterator.OfLong) super.trySplit();
        }

        @Override // java.util.stream.Streams.AbstractStreamBuilderImpl, java.util.Spliterator
        public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
            return (Spliterator.OfPrimitive) super.trySplit();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public LongStreamBuilderImpl() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public LongStreamBuilderImpl(long t2) {
            super();
            this.first = t2;
            this.count = -2;
        }

        @Override // java.util.stream.LongStream.Builder, java.util.function.LongConsumer
        public void accept(long t2) {
            if (this.count == 0) {
                this.first = t2;
                this.count++;
            } else {
                if (this.count > 0) {
                    if (this.buffer == null) {
                        SpinedBuffer.OfLong ofLong = new SpinedBuffer.OfLong();
                        this.buffer = ofLong;
                        ofLong.accept(this.first);
                        this.count++;
                    }
                    this.buffer.accept(t2);
                    return;
                }
                throw new IllegalStateException();
            }
        }

        @Override // java.util.stream.LongStream.Builder
        public LongStream build() {
            int c4 = this.count;
            if (c4 >= 0) {
                this.count = (-this.count) - 1;
                return c4 < 2 ? StreamSupport.longStream(this, false) : StreamSupport.longStream(this.buffer.spliterator(), false);
            }
            throw new IllegalStateException();
        }

        @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive
        public boolean tryAdvance(LongConsumer action) {
            Objects.requireNonNull(action);
            if (this.count == -2) {
                action.accept(this.first);
                this.count = -1;
                return true;
            }
            return false;
        }

        @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive
        public void forEachRemaining(LongConsumer action) {
            Objects.requireNonNull(action);
            if (this.count == -2) {
                action.accept(this.first);
                this.count = -1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class DoubleStreamBuilderImpl extends AbstractStreamBuilderImpl<Double, Spliterator.OfDouble> implements DoubleStream.Builder, Spliterator.OfDouble {
        SpinedBuffer.OfDouble buffer;
        double first;

        @Override // java.util.stream.Streams.AbstractStreamBuilderImpl, java.util.Spliterator
        public /* bridge */ /* synthetic */ Spliterator.OfDouble trySplit() {
            return (Spliterator.OfDouble) super.trySplit();
        }

        @Override // java.util.stream.Streams.AbstractStreamBuilderImpl, java.util.Spliterator
        public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
            return (Spliterator.OfPrimitive) super.trySplit();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public DoubleStreamBuilderImpl() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public DoubleStreamBuilderImpl(double t2) {
            super();
            this.first = t2;
            this.count = -2;
        }

        @Override // java.util.stream.DoubleStream.Builder, java.util.function.DoubleConsumer
        public void accept(double t2) {
            if (this.count == 0) {
                this.first = t2;
                this.count++;
            } else {
                if (this.count > 0) {
                    if (this.buffer == null) {
                        SpinedBuffer.OfDouble ofDouble = new SpinedBuffer.OfDouble();
                        this.buffer = ofDouble;
                        ofDouble.accept(this.first);
                        this.count++;
                    }
                    this.buffer.accept(t2);
                    return;
                }
                throw new IllegalStateException();
            }
        }

        @Override // java.util.stream.DoubleStream.Builder
        public DoubleStream build() {
            int c4 = this.count;
            if (c4 >= 0) {
                this.count = (-this.count) - 1;
                return c4 < 2 ? StreamSupport.doubleStream(this, false) : StreamSupport.doubleStream(this.buffer.spliterator(), false);
            }
            throw new IllegalStateException();
        }

        @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive
        public boolean tryAdvance(DoubleConsumer action) {
            Objects.requireNonNull(action);
            if (this.count == -2) {
                action.accept(this.first);
                this.count = -1;
                return true;
            }
            return false;
        }

        @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive
        public void forEachRemaining(DoubleConsumer action) {
            Objects.requireNonNull(action);
            if (this.count == -2) {
                action.accept(this.first);
                this.count = -1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class ConcatSpliterator<T, T_SPLITR extends Spliterator<T>> implements Spliterator<T> {
        protected final T_SPLITR aSpliterator;
        protected final T_SPLITR bSpliterator;
        boolean beforeSplit = true;
        final boolean unsized;

        public ConcatSpliterator(T_SPLITR aSpliterator, T_SPLITR bSpliterator) {
            this.aSpliterator = aSpliterator;
            this.bSpliterator = bSpliterator;
            this.unsized = aSpliterator.estimateSize() + bSpliterator.estimateSize() < 0;
        }

        @Override // java.util.Spliterator
        public T_SPLITR trySplit() {
            T_SPLITR t_splitr = this.beforeSplit ? this.aSpliterator : (T_SPLITR) this.bSpliterator.trySplit();
            this.beforeSplit = false;
            return t_splitr;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super T> consumer) {
            if (this.beforeSplit) {
                boolean hasNext = this.aSpliterator.tryAdvance(consumer);
                if (!hasNext) {
                    this.beforeSplit = false;
                    return this.bSpliterator.tryAdvance(consumer);
                }
                return hasNext;
            }
            return this.bSpliterator.tryAdvance(consumer);
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super T> consumer) {
            if (this.beforeSplit) {
                this.aSpliterator.forEachRemaining(consumer);
            }
            this.bSpliterator.forEachRemaining(consumer);
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            if (this.beforeSplit) {
                long size = this.aSpliterator.estimateSize() + this.bSpliterator.estimateSize();
                if (size >= 0) {
                    return size;
                }
                return Long.MAX_VALUE;
            }
            return this.bSpliterator.estimateSize();
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            if (this.beforeSplit) {
                return this.aSpliterator.characteristics() & this.bSpliterator.characteristics() & (~((this.unsized ? 16448 : 0) | 5));
            }
            return this.bSpliterator.characteristics();
        }

        @Override // java.util.Spliterator
        public Comparator<? super T> getComparator() {
            if (this.beforeSplit) {
                throw new IllegalStateException();
            }
            return this.bSpliterator.getComparator();
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static class OfRef<T> extends ConcatSpliterator<T, Spliterator<T>> {
            /* JADX INFO: Access modifiers changed from: package-private */
            public OfRef(Spliterator<T> aSpliterator, Spliterator<T> bSpliterator) {
                super(aSpliterator, bSpliterator);
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        private static abstract class OfPrimitive<T, T_CONS, T_SPLITR extends Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>> extends ConcatSpliterator<T, T_SPLITR> implements Spliterator.OfPrimitive<T, T_CONS, T_SPLITR> {
            @Override // java.util.stream.Streams.ConcatSpliterator, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
                return (Spliterator.OfPrimitive) super.trySplit();
            }

            private OfPrimitive(T_SPLITR aSpliterator, T_SPLITR bSpliterator) {
                super(aSpliterator, bSpliterator);
            }

            @Override // java.util.Spliterator.OfPrimitive
            public boolean tryAdvance(T_CONS action) {
                if (this.beforeSplit) {
                    boolean hasNext = ((Spliterator.OfPrimitive) this.aSpliterator).tryAdvance((Spliterator.OfPrimitive) action);
                    if (!hasNext) {
                        this.beforeSplit = false;
                        return ((Spliterator.OfPrimitive) this.bSpliterator).tryAdvance((Spliterator.OfPrimitive) action);
                    }
                    return hasNext;
                }
                return ((Spliterator.OfPrimitive) this.bSpliterator).tryAdvance((Spliterator.OfPrimitive) action);
            }

            @Override // java.util.Spliterator.OfPrimitive
            public void forEachRemaining(T_CONS action) {
                if (this.beforeSplit) {
                    ((Spliterator.OfPrimitive) this.aSpliterator).forEachRemaining((Spliterator.OfPrimitive) action);
                }
                ((Spliterator.OfPrimitive) this.bSpliterator).forEachRemaining((Spliterator.OfPrimitive) action);
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static class OfInt extends OfPrimitive<Integer, IntConsumer, Spliterator.OfInt> implements Spliterator.OfInt {
            @Override // java.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
                super.forEachRemaining((OfInt) intConsumer);
            }

            @Override // java.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
                return super.tryAdvance((OfInt) intConsumer);
            }

            @Override // java.util.stream.Streams.ConcatSpliterator.OfPrimitive, java.util.stream.Streams.ConcatSpliterator, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfInt trySplit() {
                return (Spliterator.OfInt) super.trySplit();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public OfInt(Spliterator.OfInt aSpliterator, Spliterator.OfInt bSpliterator) {
                super(aSpliterator, bSpliterator);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static class OfLong extends OfPrimitive<Long, LongConsumer, Spliterator.OfLong> implements Spliterator.OfLong {
            @Override // java.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
                super.forEachRemaining((OfLong) longConsumer);
            }

            @Override // java.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
                return super.tryAdvance((OfLong) longConsumer);
            }

            @Override // java.util.stream.Streams.ConcatSpliterator.OfPrimitive, java.util.stream.Streams.ConcatSpliterator, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfLong trySplit() {
                return (Spliterator.OfLong) super.trySplit();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public OfLong(Spliterator.OfLong aSpliterator, Spliterator.OfLong bSpliterator) {
                super(aSpliterator, bSpliterator);
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static class OfDouble extends OfPrimitive<Double, DoubleConsumer, Spliterator.OfDouble> implements Spliterator.OfDouble {
            @Override // java.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
                super.forEachRemaining((OfDouble) doubleConsumer);
            }

            @Override // java.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
                return super.tryAdvance((OfDouble) doubleConsumer);
            }

            @Override // java.util.stream.Streams.ConcatSpliterator.OfPrimitive, java.util.stream.Streams.ConcatSpliterator, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfDouble trySplit() {
                return (Spliterator.OfDouble) super.trySplit();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public OfDouble(Spliterator.OfDouble aSpliterator, Spliterator.OfDouble bSpliterator) {
                super(aSpliterator, bSpliterator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable composeWithExceptions(final Runnable a10, final Runnable b4) {
        return new Runnable() { // from class: java.util.stream.Streams.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Runnable.this.run();
                    b4.run();
                } catch (Throwable e12) {
                    try {
                        b4.run();
                    } catch (Throwable e2) {
                        try {
                            e12.addSuppressed(e2);
                        } catch (Throwable th) {
                        }
                    }
                    throw e12;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable composedClose(final BaseStream<?, ?> a10, final BaseStream<?, ?> b4) {
        return new Runnable() { // from class: java.util.stream.Streams.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BaseStream.this.close();
                    b4.close();
                } catch (Throwable e12) {
                    try {
                        b4.close();
                    } catch (Throwable e2) {
                        try {
                            e12.addSuppressed(e2);
                        } catch (Throwable th) {
                        }
                    }
                    throw e12;
                }
            }
        };
    }
}
