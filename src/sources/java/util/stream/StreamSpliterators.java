package java.util.stream;

import java.util.Comparator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleSupplier;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;
import java.util.function.LongConsumer;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import java.util.stream.Sink;
import java.util.stream.SpinedBuffer;
import java.util.stream.StreamSpliterators;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class StreamSpliterators {
    StreamSpliterators() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class AbstractWrappingSpliterator<P_IN, P_OUT, T_BUFFER extends AbstractSpinedBuffer> implements Spliterator<P_OUT> {
        T_BUFFER buffer;
        Sink<P_IN> bufferSink;
        boolean finished;
        final boolean isParallel;
        long nextToConsume;
        final PipelineHelper<P_OUT> ph;
        BooleanSupplier pusher;
        Spliterator<P_IN> spliterator;
        private Supplier<Spliterator<P_IN>> spliteratorSupplier;

        abstract void initPartialTraversalState();

        abstract AbstractWrappingSpliterator<P_IN, P_OUT, ?> wrap(Spliterator<P_IN> spliterator);

        AbstractWrappingSpliterator(PipelineHelper<P_OUT> ph, Supplier<Spliterator<P_IN>> spliteratorSupplier, boolean parallel) {
            this.ph = ph;
            this.spliteratorSupplier = spliteratorSupplier;
            this.spliterator = null;
            this.isParallel = parallel;
        }

        AbstractWrappingSpliterator(PipelineHelper<P_OUT> ph, Spliterator<P_IN> spliterator, boolean parallel) {
            this.ph = ph;
            this.spliteratorSupplier = null;
            this.spliterator = spliterator;
            this.isParallel = parallel;
        }

        final void init() {
            if (this.spliterator == null) {
                this.spliterator = this.spliteratorSupplier.get();
                this.spliteratorSupplier = null;
            }
        }

        final boolean doAdvance() {
            T_BUFFER t_buffer = this.buffer;
            if (t_buffer == null) {
                if (this.finished) {
                    return false;
                }
                init();
                initPartialTraversalState();
                this.nextToConsume = 0L;
                this.bufferSink.begin(this.spliterator.getExactSizeIfKnown());
                return fillBuffer();
            }
            long j10 = this.nextToConsume + 1;
            this.nextToConsume = j10;
            boolean hasNext = j10 < t_buffer.count();
            if (!hasNext) {
                this.nextToConsume = 0L;
                this.buffer.clear();
                return fillBuffer();
            }
            return hasNext;
        }

        @Override // java.util.Spliterator
        public Spliterator<P_OUT> trySplit() {
            if (!this.isParallel || this.finished) {
                return null;
            }
            init();
            Spliterator<P_IN> split = this.spliterator.trySplit();
            if (split == null) {
                return null;
            }
            return wrap(split);
        }

        private boolean fillBuffer() {
            while (this.buffer.count() == 0) {
                if (this.bufferSink.cancellationRequested() || !this.pusher.getAsBoolean()) {
                    if (this.finished) {
                        return false;
                    }
                    this.bufferSink.end();
                    this.finished = true;
                }
            }
            return true;
        }

        @Override // java.util.Spliterator
        public final long estimateSize() {
            init();
            return this.spliterator.estimateSize();
        }

        @Override // java.util.Spliterator
        public final long getExactSizeIfKnown() {
            init();
            if (StreamOpFlag.SIZED.isKnown(this.ph.getStreamAndOpFlags())) {
                return this.spliterator.getExactSizeIfKnown();
            }
            return -1L;
        }

        @Override // java.util.Spliterator
        public final int characteristics() {
            init();
            int c4 = StreamOpFlag.toCharacteristics(StreamOpFlag.toStreamFlags(this.ph.getStreamAndOpFlags()));
            if ((c4 & 64) != 0) {
                return (c4 & (-16449)) | (this.spliterator.characteristics() & 16448);
            }
            return c4;
        }

        @Override // java.util.Spliterator
        public Comparator<? super P_OUT> getComparator() {
            if (!hasCharacteristics(4)) {
                throw new IllegalStateException();
            }
            return null;
        }

        public final String toString() {
            return String.format("%s[%s]", getClass().getName(), this.spliterator);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class WrappingSpliterator<P_IN, P_OUT> extends AbstractWrappingSpliterator<P_IN, P_OUT, SpinedBuffer<P_OUT>> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public WrappingSpliterator(PipelineHelper<P_OUT> ph, Supplier<Spliterator<P_IN>> supplier, boolean parallel) {
            super(ph, supplier, parallel);
        }

        WrappingSpliterator(PipelineHelper<P_OUT> ph, Spliterator<P_IN> spliterator, boolean parallel) {
            super(ph, spliterator, parallel);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // java.util.stream.StreamSpliterators.AbstractWrappingSpliterator
        public WrappingSpliterator<P_IN, P_OUT> wrap(Spliterator<P_IN> s2) {
            return new WrappingSpliterator<>(this.ph, s2, this.isParallel);
        }

        @Override // java.util.stream.StreamSpliterators.AbstractWrappingSpliterator
        void initPartialTraversalState() {
            final SpinedBuffer<P_OUT> b4 = new SpinedBuffer<>();
            this.buffer = b4;
            PipelineHelper<P_OUT> pipelineHelper = this.ph;
            Objects.requireNonNull(b4);
            this.bufferSink = pipelineHelper.wrapSink(new Sink() { // from class: java.util.stream.StreamSpliterators$WrappingSpliterator$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    SpinedBuffer.this.accept(obj);
                }
            });
            this.pusher = new BooleanSupplier() { // from class: java.util.stream.StreamSpliterators$WrappingSpliterator$$ExternalSyntheticLambda1
                @Override // java.util.function.BooleanSupplier
                public final boolean getAsBoolean() {
                    boolean lambda$initPartialTraversalState$0;
                    lambda$initPartialTraversalState$0 = StreamSpliterators.WrappingSpliterator.this.lambda$initPartialTraversalState$0();
                    return lambda$initPartialTraversalState$0;
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$initPartialTraversalState$0() {
            return this.spliterator.tryAdvance(this.bufferSink);
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super P_OUT> consumer) {
            Objects.requireNonNull(consumer);
            boolean doAdvance = doAdvance();
            if (doAdvance) {
                consumer.accept((Object) ((SpinedBuffer) this.buffer).get(this.nextToConsume));
            }
            return doAdvance;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(final Consumer<? super P_OUT> consumer) {
            if (this.buffer == 0 && !this.finished) {
                Objects.requireNonNull(consumer);
                init();
                PipelineHelper<P_OUT> pipelineHelper = this.ph;
                Objects.requireNonNull(consumer);
                pipelineHelper.wrapAndCopyInto(new Sink() { // from class: java.util.stream.StreamSpliterators$WrappingSpliterator$$ExternalSyntheticLambda2
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        Consumer.this.accept(obj);
                    }
                }, this.spliterator);
                this.finished = true;
                return;
            }
            do {
            } while (tryAdvance(consumer));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class IntWrappingSpliterator<P_IN> extends AbstractWrappingSpliterator<P_IN, Integer, SpinedBuffer.OfInt> implements Spliterator.OfInt {
        /* JADX INFO: Access modifiers changed from: package-private */
        public IntWrappingSpliterator(PipelineHelper<Integer> ph, Supplier<Spliterator<P_IN>> supplier, boolean parallel) {
            super(ph, supplier, parallel);
        }

        IntWrappingSpliterator(PipelineHelper<Integer> ph, Spliterator<P_IN> spliterator, boolean parallel) {
            super(ph, spliterator, parallel);
        }

        @Override // java.util.stream.StreamSpliterators.AbstractWrappingSpliterator
        AbstractWrappingSpliterator<P_IN, Integer, ?> wrap(Spliterator<P_IN> s2) {
            return new IntWrappingSpliterator((PipelineHelper<Integer>) this.ph, (Spliterator) s2, this.isParallel);
        }

        @Override // java.util.stream.StreamSpliterators.AbstractWrappingSpliterator
        void initPartialTraversalState() {
            final SpinedBuffer.OfInt b4 = new SpinedBuffer.OfInt();
            this.buffer = b4;
            PipelineHelper<P_OUT> pipelineHelper = this.ph;
            Objects.requireNonNull(b4);
            this.bufferSink = pipelineHelper.wrapSink(new Sink.OfInt() { // from class: java.util.stream.StreamSpliterators$IntWrappingSpliterator$$ExternalSyntheticLambda0
                @Override // java.util.stream.Sink.OfInt, java.util.function.IntConsumer
                public final void accept(int i10) {
                    SpinedBuffer.OfInt.this.accept(i10);
                }
            });
            this.pusher = new BooleanSupplier() { // from class: java.util.stream.StreamSpliterators$IntWrappingSpliterator$$ExternalSyntheticLambda1
                @Override // java.util.function.BooleanSupplier
                public final boolean getAsBoolean() {
                    boolean lambda$initPartialTraversalState$0;
                    lambda$initPartialTraversalState$0 = StreamSpliterators.IntWrappingSpliterator.this.lambda$initPartialTraversalState$0();
                    return lambda$initPartialTraversalState$0;
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$initPartialTraversalState$0() {
            return this.spliterator.tryAdvance(this.bufferSink);
        }

        @Override // java.util.stream.StreamSpliterators.AbstractWrappingSpliterator, java.util.Spliterator
        public Spliterator.OfInt trySplit() {
            return (Spliterator.OfInt) super.trySplit();
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive
        public boolean tryAdvance(IntConsumer consumer) {
            Objects.requireNonNull(consumer);
            boolean hasNext = doAdvance();
            if (hasNext) {
                consumer.accept(((SpinedBuffer.OfInt) this.buffer).get(this.nextToConsume));
            }
            return hasNext;
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive
        public void forEachRemaining(final IntConsumer consumer) {
            if (this.buffer == 0 && !this.finished) {
                Objects.requireNonNull(consumer);
                init();
                PipelineHelper<P_OUT> pipelineHelper = this.ph;
                Objects.requireNonNull(consumer);
                pipelineHelper.wrapAndCopyInto(new Sink.OfInt() { // from class: java.util.stream.StreamSpliterators$IntWrappingSpliterator$$ExternalSyntheticLambda2
                    @Override // java.util.stream.Sink.OfInt, java.util.function.IntConsumer
                    public final void accept(int i10) {
                        IntConsumer.this.accept(i10);
                    }
                }, this.spliterator);
                this.finished = true;
                return;
            }
            do {
            } while (tryAdvance(consumer));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class LongWrappingSpliterator<P_IN> extends AbstractWrappingSpliterator<P_IN, Long, SpinedBuffer.OfLong> implements Spliterator.OfLong {
        /* JADX INFO: Access modifiers changed from: package-private */
        public LongWrappingSpliterator(PipelineHelper<Long> ph, Supplier<Spliterator<P_IN>> supplier, boolean parallel) {
            super(ph, supplier, parallel);
        }

        LongWrappingSpliterator(PipelineHelper<Long> ph, Spliterator<P_IN> spliterator, boolean parallel) {
            super(ph, spliterator, parallel);
        }

        @Override // java.util.stream.StreamSpliterators.AbstractWrappingSpliterator
        AbstractWrappingSpliterator<P_IN, Long, ?> wrap(Spliterator<P_IN> s2) {
            return new LongWrappingSpliterator((PipelineHelper<Long>) this.ph, (Spliterator) s2, this.isParallel);
        }

        @Override // java.util.stream.StreamSpliterators.AbstractWrappingSpliterator
        void initPartialTraversalState() {
            final SpinedBuffer.OfLong b4 = new SpinedBuffer.OfLong();
            this.buffer = b4;
            PipelineHelper<P_OUT> pipelineHelper = this.ph;
            Objects.requireNonNull(b4);
            this.bufferSink = pipelineHelper.wrapSink(new Sink.OfLong() { // from class: java.util.stream.StreamSpliterators$LongWrappingSpliterator$$ExternalSyntheticLambda1
                @Override // java.util.stream.Sink.OfLong, java.util.function.LongConsumer
                public final void accept(long j10) {
                    SpinedBuffer.OfLong.this.accept(j10);
                }
            });
            this.pusher = new BooleanSupplier() { // from class: java.util.stream.StreamSpliterators$LongWrappingSpliterator$$ExternalSyntheticLambda2
                @Override // java.util.function.BooleanSupplier
                public final boolean getAsBoolean() {
                    boolean lambda$initPartialTraversalState$0;
                    lambda$initPartialTraversalState$0 = StreamSpliterators.LongWrappingSpliterator.this.lambda$initPartialTraversalState$0();
                    return lambda$initPartialTraversalState$0;
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$initPartialTraversalState$0() {
            return this.spliterator.tryAdvance(this.bufferSink);
        }

        @Override // java.util.stream.StreamSpliterators.AbstractWrappingSpliterator, java.util.Spliterator
        public Spliterator.OfLong trySplit() {
            return (Spliterator.OfLong) super.trySplit();
        }

        @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive
        public boolean tryAdvance(LongConsumer consumer) {
            Objects.requireNonNull(consumer);
            boolean hasNext = doAdvance();
            if (hasNext) {
                consumer.accept(((SpinedBuffer.OfLong) this.buffer).get(this.nextToConsume));
            }
            return hasNext;
        }

        @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive
        public void forEachRemaining(final LongConsumer consumer) {
            if (this.buffer == 0 && !this.finished) {
                Objects.requireNonNull(consumer);
                init();
                PipelineHelper<P_OUT> pipelineHelper = this.ph;
                Objects.requireNonNull(consumer);
                pipelineHelper.wrapAndCopyInto(new Sink.OfLong() { // from class: java.util.stream.StreamSpliterators$LongWrappingSpliterator$$ExternalSyntheticLambda0
                    @Override // java.util.stream.Sink.OfLong, java.util.function.LongConsumer
                    public final void accept(long j10) {
                        LongConsumer.this.accept(j10);
                    }
                }, this.spliterator);
                this.finished = true;
                return;
            }
            do {
            } while (tryAdvance(consumer));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class DoubleWrappingSpliterator<P_IN> extends AbstractWrappingSpliterator<P_IN, Double, SpinedBuffer.OfDouble> implements Spliterator.OfDouble {
        /* JADX INFO: Access modifiers changed from: package-private */
        public DoubleWrappingSpliterator(PipelineHelper<Double> ph, Supplier<Spliterator<P_IN>> supplier, boolean parallel) {
            super(ph, supplier, parallel);
        }

        DoubleWrappingSpliterator(PipelineHelper<Double> ph, Spliterator<P_IN> spliterator, boolean parallel) {
            super(ph, spliterator, parallel);
        }

        @Override // java.util.stream.StreamSpliterators.AbstractWrappingSpliterator
        AbstractWrappingSpliterator<P_IN, Double, ?> wrap(Spliterator<P_IN> s2) {
            return new DoubleWrappingSpliterator((PipelineHelper<Double>) this.ph, (Spliterator) s2, this.isParallel);
        }

        @Override // java.util.stream.StreamSpliterators.AbstractWrappingSpliterator
        void initPartialTraversalState() {
            final SpinedBuffer.OfDouble b4 = new SpinedBuffer.OfDouble();
            this.buffer = b4;
            PipelineHelper<P_OUT> pipelineHelper = this.ph;
            Objects.requireNonNull(b4);
            this.bufferSink = pipelineHelper.wrapSink(new Sink.OfDouble() { // from class: java.util.stream.StreamSpliterators$DoubleWrappingSpliterator$$ExternalSyntheticLambda0
                @Override // java.util.stream.Sink.OfDouble, java.util.stream.Sink, java.util.function.DoubleConsumer
                public final void accept(double d10) {
                    SpinedBuffer.OfDouble.this.accept(d10);
                }
            });
            this.pusher = new BooleanSupplier() { // from class: java.util.stream.StreamSpliterators$DoubleWrappingSpliterator$$ExternalSyntheticLambda1
                @Override // java.util.function.BooleanSupplier
                public final boolean getAsBoolean() {
                    boolean lambda$initPartialTraversalState$0;
                    lambda$initPartialTraversalState$0 = StreamSpliterators.DoubleWrappingSpliterator.this.lambda$initPartialTraversalState$0();
                    return lambda$initPartialTraversalState$0;
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$initPartialTraversalState$0() {
            return this.spliterator.tryAdvance(this.bufferSink);
        }

        @Override // java.util.stream.StreamSpliterators.AbstractWrappingSpliterator, java.util.Spliterator
        public Spliterator.OfDouble trySplit() {
            return (Spliterator.OfDouble) super.trySplit();
        }

        @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive
        public boolean tryAdvance(DoubleConsumer consumer) {
            Objects.requireNonNull(consumer);
            boolean hasNext = doAdvance();
            if (hasNext) {
                consumer.accept(((SpinedBuffer.OfDouble) this.buffer).get(this.nextToConsume));
            }
            return hasNext;
        }

        @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive
        public void forEachRemaining(final DoubleConsumer consumer) {
            if (this.buffer == 0 && !this.finished) {
                Objects.requireNonNull(consumer);
                init();
                PipelineHelper<P_OUT> pipelineHelper = this.ph;
                Objects.requireNonNull(consumer);
                pipelineHelper.wrapAndCopyInto(new Sink.OfDouble() { // from class: java.util.stream.StreamSpliterators$DoubleWrappingSpliterator$$ExternalSyntheticLambda2
                    @Override // java.util.stream.Sink.OfDouble, java.util.stream.Sink, java.util.function.DoubleConsumer
                    public final void accept(double d10) {
                        DoubleConsumer.this.accept(d10);
                    }
                }, this.spliterator);
                this.finished = true;
                return;
            }
            do {
            } while (tryAdvance(consumer));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class DelegatingSpliterator<T, T_SPLITR extends Spliterator<T>> implements Spliterator<T> {

        /* renamed from: s, reason: collision with root package name */
        private T_SPLITR f50518s;
        private final Supplier<? extends T_SPLITR> supplier;

        /* JADX INFO: Access modifiers changed from: package-private */
        public DelegatingSpliterator(Supplier<? extends T_SPLITR> supplier) {
            this.supplier = supplier;
        }

        T_SPLITR get() {
            if (this.f50518s == null) {
                this.f50518s = this.supplier.get();
            }
            return this.f50518s;
        }

        @Override // java.util.Spliterator
        public T_SPLITR trySplit() {
            return (T_SPLITR) get().trySplit();
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super T> consumer) {
            return get().tryAdvance(consumer);
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super T> consumer) {
            get().forEachRemaining(consumer);
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return get().estimateSize();
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return get().characteristics();
        }

        @Override // java.util.Spliterator
        public Comparator<? super T> getComparator() {
            return get().getComparator();
        }

        @Override // java.util.Spliterator
        public long getExactSizeIfKnown() {
            return get().getExactSizeIfKnown();
        }

        public String toString() {
            return getClass().getName() + "[" + ((Object) get()) + "]";
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static class OfPrimitive<T, T_CONS, T_SPLITR extends Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>> extends DelegatingSpliterator<T, T_SPLITR> implements Spliterator.OfPrimitive<T, T_CONS, T_SPLITR> {
            @Override // java.util.stream.StreamSpliterators.DelegatingSpliterator, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
                return (Spliterator.OfPrimitive) super.trySplit();
            }

            OfPrimitive(Supplier<? extends T_SPLITR> supplier) {
                super(supplier);
            }

            @Override // java.util.Spliterator.OfPrimitive
            public boolean tryAdvance(T_CONS consumer) {
                return ((Spliterator.OfPrimitive) get()).tryAdvance((Spliterator.OfPrimitive) consumer);
            }

            @Override // java.util.Spliterator.OfPrimitive
            public void forEachRemaining(T_CONS consumer) {
                ((Spliterator.OfPrimitive) get()).forEachRemaining((Spliterator.OfPrimitive) consumer);
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static final class OfInt extends OfPrimitive<Integer, IntConsumer, Spliterator.OfInt> implements Spliterator.OfInt {
            @Override // java.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
                super.forEachRemaining((OfInt) intConsumer);
            }

            @Override // java.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
                return super.tryAdvance((OfInt) intConsumer);
            }

            @Override // java.util.stream.StreamSpliterators.DelegatingSpliterator.OfPrimitive, java.util.stream.StreamSpliterators.DelegatingSpliterator, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfInt trySplit() {
                return (Spliterator.OfInt) super.trySplit();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public OfInt(Supplier<Spliterator.OfInt> supplier) {
                super(supplier);
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static final class OfLong extends OfPrimitive<Long, LongConsumer, Spliterator.OfLong> implements Spliterator.OfLong {
            @Override // java.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
                super.forEachRemaining((OfLong) longConsumer);
            }

            @Override // java.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
                return super.tryAdvance((OfLong) longConsumer);
            }

            @Override // java.util.stream.StreamSpliterators.DelegatingSpliterator.OfPrimitive, java.util.stream.StreamSpliterators.DelegatingSpliterator, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfLong trySplit() {
                return (Spliterator.OfLong) super.trySplit();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public OfLong(Supplier<Spliterator.OfLong> supplier) {
                super(supplier);
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static final class OfDouble extends OfPrimitive<Double, DoubleConsumer, Spliterator.OfDouble> implements Spliterator.OfDouble {
            @Override // java.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
                super.forEachRemaining((OfDouble) doubleConsumer);
            }

            @Override // java.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
                return super.tryAdvance((OfDouble) doubleConsumer);
            }

            @Override // java.util.stream.StreamSpliterators.DelegatingSpliterator.OfPrimitive, java.util.stream.StreamSpliterators.DelegatingSpliterator, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfDouble trySplit() {
                return (Spliterator.OfDouble) super.trySplit();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public OfDouble(Supplier<Spliterator.OfDouble> supplier) {
                super(supplier);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class SliceSpliterator<T, T_SPLITR extends Spliterator<T>> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        long fence;
        long index;

        /* renamed from: s, reason: collision with root package name */
        T_SPLITR f50524s;
        final long sliceFence;
        final long sliceOrigin;

        protected abstract T_SPLITR makeSpliterator(T_SPLITR t_splitr, long j10, long j11, long j12, long j13);

        SliceSpliterator(T_SPLITR s2, long sliceOrigin, long sliceFence, long origin, long fence) {
            this.f50524s = s2;
            this.sliceOrigin = sliceOrigin;
            this.sliceFence = sliceFence;
            this.index = origin;
            this.fence = fence;
        }

        public T_SPLITR trySplit() {
            long j10 = this.sliceOrigin;
            long j11 = this.fence;
            if (j10 >= j11 || this.index >= j11) {
                return null;
            }
            while (true) {
                T_SPLITR t_splitr = (T_SPLITR) this.f50524s.trySplit();
                if (t_splitr == null) {
                    return null;
                }
                long estimateSize = this.index + t_splitr.estimateSize();
                long min = Math.min(estimateSize, this.sliceFence);
                long j12 = this.sliceOrigin;
                if (j12 >= min) {
                    this.index = min;
                } else {
                    long j13 = this.sliceFence;
                    if (min >= j13) {
                        this.f50524s = t_splitr;
                        this.fence = min;
                    } else {
                        long j14 = this.index;
                        if (j14 >= j12 && estimateSize <= j13) {
                            this.index = min;
                            return t_splitr;
                        }
                        this.index = min;
                        return makeSpliterator(t_splitr, j12, j13, j14, min);
                    }
                }
            }
        }

        public long estimateSize() {
            long j10 = this.sliceOrigin;
            long j11 = this.fence;
            if (j10 < j11) {
                return j11 - Math.max(j10, this.index);
            }
            return 0L;
        }

        public int characteristics() {
            return this.f50524s.characteristics();
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static final class OfRef<T> extends SliceSpliterator<T, Spliterator<T>> implements Spliterator<T> {
            /* JADX INFO: Access modifiers changed from: package-private */
            public OfRef(Spliterator<T> s2, long sliceOrigin, long sliceFence) {
                this(s2, sliceOrigin, sliceFence, 0L, Math.min(s2.estimateSize(), sliceFence));
            }

            private OfRef(Spliterator<T> s2, long sliceOrigin, long sliceFence, long origin, long fence) {
                super(s2, sliceOrigin, sliceFence, origin, fence);
            }

            @Override // java.util.stream.StreamSpliterators.SliceSpliterator
            protected Spliterator<T> makeSpliterator(Spliterator<T> s2, long sliceOrigin, long sliceFence, long origin, long fence) {
                return new OfRef(s2, sliceOrigin, sliceFence, origin, fence);
            }

            @Override // java.util.Spliterator
            public boolean tryAdvance(Consumer<? super T> action) {
                Objects.requireNonNull(action);
                if (this.sliceOrigin >= this.fence) {
                    return false;
                }
                while (this.sliceOrigin > this.index) {
                    this.f50524s.tryAdvance(new Consumer() { // from class: java.util.stream.StreamSpliterators$SliceSpliterator$OfRef$$ExternalSyntheticLambda1
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            StreamSpliterators.SliceSpliterator.OfRef.lambda$tryAdvance$0(obj);
                        }
                    });
                    this.index++;
                }
                if (this.index >= this.fence) {
                    return false;
                }
                this.index++;
                return this.f50524s.tryAdvance(action);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public static /* synthetic */ void lambda$tryAdvance$0(Object e2) {
            }

            @Override // java.util.Spliterator
            public void forEachRemaining(Consumer<? super T> action) {
                Objects.requireNonNull(action);
                if (this.sliceOrigin < this.fence && this.index < this.fence) {
                    if (this.index >= this.sliceOrigin && this.index + this.f50524s.estimateSize() <= this.sliceFence) {
                        this.f50524s.forEachRemaining(action);
                        this.index = this.fence;
                        return;
                    }
                    while (this.sliceOrigin > this.index) {
                        this.f50524s.tryAdvance(new Consumer() { // from class: java.util.stream.StreamSpliterators$SliceSpliterator$OfRef$$ExternalSyntheticLambda0
                            @Override // java.util.function.Consumer
                            public final void accept(Object obj) {
                                StreamSpliterators.SliceSpliterator.OfRef.lambda$forEachRemaining$1(obj);
                            }
                        });
                        this.index++;
                    }
                    while (this.index < this.fence) {
                        this.f50524s.tryAdvance(action);
                        this.index++;
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public static /* synthetic */ void lambda$forEachRemaining$1(Object e2) {
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static abstract class OfPrimitive<T, T_SPLITR extends Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>, T_CONS> extends SliceSpliterator<T, T_SPLITR> implements Spliterator.OfPrimitive<T, T_CONS, T_SPLITR> {
            protected abstract T_CONS emptyConsumer();

            @Override // java.util.stream.StreamSpliterators.SliceSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
                return (Spliterator.OfPrimitive) super.trySplit();
            }

            OfPrimitive(T_SPLITR s2, long sliceOrigin, long sliceFence) {
                this(s2, sliceOrigin, sliceFence, 0L, Math.min(s2.estimateSize(), sliceFence));
            }

            private OfPrimitive(T_SPLITR s2, long sliceOrigin, long sliceFence, long origin, long fence) {
                super(s2, sliceOrigin, sliceFence, origin, fence);
            }

            @Override // java.util.Spliterator.OfPrimitive
            public boolean tryAdvance(T_CONS action) {
                Objects.requireNonNull(action);
                if (this.sliceOrigin >= this.fence) {
                    return false;
                }
                while (this.sliceOrigin > this.index) {
                    ((Spliterator.OfPrimitive) this.f50524s).tryAdvance((Spliterator.OfPrimitive) emptyConsumer());
                    this.index++;
                }
                if (this.index >= this.fence) {
                    return false;
                }
                this.index++;
                return ((Spliterator.OfPrimitive) this.f50524s).tryAdvance((Spliterator.OfPrimitive) action);
            }

            @Override // java.util.Spliterator.OfPrimitive
            public void forEachRemaining(T_CONS action) {
                Objects.requireNonNull(action);
                if (this.sliceOrigin < this.fence && this.index < this.fence) {
                    if (this.index >= this.sliceOrigin && this.index + ((Spliterator.OfPrimitive) this.f50524s).estimateSize() <= this.sliceFence) {
                        ((Spliterator.OfPrimitive) this.f50524s).forEachRemaining((Spliterator.OfPrimitive) action);
                        this.index = this.fence;
                        return;
                    }
                    while (this.sliceOrigin > this.index) {
                        ((Spliterator.OfPrimitive) this.f50524s).tryAdvance((Spliterator.OfPrimitive) emptyConsumer());
                        this.index++;
                    }
                    while (this.index < this.fence) {
                        ((Spliterator.OfPrimitive) this.f50524s).tryAdvance((Spliterator.OfPrimitive) action);
                        this.index++;
                    }
                }
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static final class OfInt extends OfPrimitive<Integer, Spliterator.OfInt, IntConsumer> implements Spliterator.OfInt {
            @Override // java.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
                super.forEachRemaining((OfInt) intConsumer);
            }

            @Override // java.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
                return super.tryAdvance((OfInt) intConsumer);
            }

            @Override // java.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive, java.util.stream.StreamSpliterators.SliceSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfInt trySplit() {
                return (Spliterator.OfInt) super.trySplit();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public OfInt(Spliterator.OfInt s2, long sliceOrigin, long sliceFence) {
                super(s2, sliceOrigin, sliceFence);
            }

            OfInt(Spliterator.OfInt s2, long sliceOrigin, long sliceFence, long origin, long fence) {
                super(s2, sliceOrigin, sliceFence, origin, fence);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.util.stream.StreamSpliterators.SliceSpliterator
            public Spliterator.OfInt makeSpliterator(Spliterator.OfInt s2, long sliceOrigin, long sliceFence, long origin, long fence) {
                return new OfInt(s2, sliceOrigin, sliceFence, origin, fence);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public static /* synthetic */ void lambda$emptyConsumer$0(int e2) {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive
            public IntConsumer emptyConsumer() {
                return new IntConsumer() { // from class: java.util.stream.StreamSpliterators$SliceSpliterator$OfInt$$ExternalSyntheticLambda0
                    @Override // java.util.function.IntConsumer
                    public final void accept(int i10) {
                        StreamSpliterators.SliceSpliterator.OfInt.lambda$emptyConsumer$0(i10);
                    }
                };
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static final class OfLong extends OfPrimitive<Long, Spliterator.OfLong, LongConsumer> implements Spliterator.OfLong {
            @Override // java.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
                super.forEachRemaining((OfLong) longConsumer);
            }

            @Override // java.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
                return super.tryAdvance((OfLong) longConsumer);
            }

            @Override // java.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive, java.util.stream.StreamSpliterators.SliceSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfLong trySplit() {
                return (Spliterator.OfLong) super.trySplit();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public OfLong(Spliterator.OfLong s2, long sliceOrigin, long sliceFence) {
                super(s2, sliceOrigin, sliceFence);
            }

            OfLong(Spliterator.OfLong s2, long sliceOrigin, long sliceFence, long origin, long fence) {
                super(s2, sliceOrigin, sliceFence, origin, fence);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.util.stream.StreamSpliterators.SliceSpliterator
            public Spliterator.OfLong makeSpliterator(Spliterator.OfLong s2, long sliceOrigin, long sliceFence, long origin, long fence) {
                return new OfLong(s2, sliceOrigin, sliceFence, origin, fence);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public static /* synthetic */ void lambda$emptyConsumer$0(long e2) {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive
            public LongConsumer emptyConsumer() {
                return new LongConsumer() { // from class: java.util.stream.StreamSpliterators$SliceSpliterator$OfLong$$ExternalSyntheticLambda0
                    @Override // java.util.function.LongConsumer
                    public final void accept(long j10) {
                        StreamSpliterators.SliceSpliterator.OfLong.lambda$emptyConsumer$0(j10);
                    }
                };
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static final class OfDouble extends OfPrimitive<Double, Spliterator.OfDouble, DoubleConsumer> implements Spliterator.OfDouble {
            @Override // java.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
                super.forEachRemaining((OfDouble) doubleConsumer);
            }

            @Override // java.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
                return super.tryAdvance((OfDouble) doubleConsumer);
            }

            @Override // java.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive, java.util.stream.StreamSpliterators.SliceSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfDouble trySplit() {
                return (Spliterator.OfDouble) super.trySplit();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public OfDouble(Spliterator.OfDouble s2, long sliceOrigin, long sliceFence) {
                super(s2, sliceOrigin, sliceFence);
            }

            OfDouble(Spliterator.OfDouble s2, long sliceOrigin, long sliceFence, long origin, long fence) {
                super(s2, sliceOrigin, sliceFence, origin, fence);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.util.stream.StreamSpliterators.SliceSpliterator
            public Spliterator.OfDouble makeSpliterator(Spliterator.OfDouble s2, long sliceOrigin, long sliceFence, long origin, long fence) {
                return new OfDouble(s2, sliceOrigin, sliceFence, origin, fence);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public static /* synthetic */ void lambda$emptyConsumer$0(double e2) {
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.util.stream.StreamSpliterators.SliceSpliterator.OfPrimitive
            public DoubleConsumer emptyConsumer() {
                return new DoubleConsumer() { // from class: java.util.stream.StreamSpliterators$SliceSpliterator$OfDouble$$ExternalSyntheticLambda0
                    @Override // java.util.function.DoubleConsumer
                    public final void accept(double d10) {
                        StreamSpliterators.SliceSpliterator.OfDouble.lambda$emptyConsumer$0(d10);
                    }
                };
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class UnorderedSliceSpliterator<T, T_SPLITR extends Spliterator<T>> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final int CHUNK_SIZE = 128;
        private final AtomicLong permits;

        /* renamed from: s, reason: collision with root package name */
        protected final T_SPLITR f50525s;
        private final long skipThreshold;
        protected final boolean unlimited;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public enum PermitStatus {
            NO_MORE,
            MAYBE_MORE,
            UNLIMITED
        }

        protected abstract T_SPLITR makeSpliterator(T_SPLITR t_splitr);

        UnorderedSliceSpliterator(T_SPLITR s2, long skip, long limit) {
            this.f50525s = s2;
            this.unlimited = limit < 0;
            this.skipThreshold = limit >= 0 ? limit : 0L;
            this.permits = new AtomicLong(limit >= 0 ? skip + limit : skip);
        }

        UnorderedSliceSpliterator(T_SPLITR s2, UnorderedSliceSpliterator<T, T_SPLITR> parent) {
            this.f50525s = s2;
            this.unlimited = parent.unlimited;
            this.permits = parent.permits;
            this.skipThreshold = parent.skipThreshold;
        }

        protected final long acquirePermits(long numElements) {
            long remainingPermits;
            long grabbing;
            do {
                remainingPermits = this.permits.get();
                if (remainingPermits == 0) {
                    if (this.unlimited) {
                        return numElements;
                    }
                    return 0L;
                }
                grabbing = Math.min(remainingPermits, numElements);
                if (grabbing <= 0) {
                    break;
                }
            } while (!this.permits.compareAndSet(remainingPermits, remainingPermits - grabbing));
            if (this.unlimited) {
                return Math.max(numElements - grabbing, 0L);
            }
            long j10 = this.skipThreshold;
            if (remainingPermits > j10) {
                return Math.max(grabbing - (remainingPermits - j10), 0L);
            }
            return grabbing;
        }

        protected final PermitStatus permitStatus() {
            if (this.permits.get() > 0) {
                return PermitStatus.MAYBE_MORE;
            }
            return this.unlimited ? PermitStatus.UNLIMITED : PermitStatus.NO_MORE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final T_SPLITR trySplit() {
            Spliterator<T> trySplit;
            if (this.permits.get() == 0 || (trySplit = this.f50525s.trySplit()) == null) {
                return null;
            }
            return (T_SPLITR) makeSpliterator(trySplit);
        }

        public final long estimateSize() {
            return this.f50525s.estimateSize();
        }

        public final int characteristics() {
            return this.f50525s.characteristics() & (-16465);
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static final class OfRef<T> extends UnorderedSliceSpliterator<T, Spliterator<T>> implements Spliterator<T>, Consumer<T> {
            T tmpSlot;

            /* JADX INFO: Access modifiers changed from: package-private */
            public OfRef(Spliterator<T> s2, long skip, long limit) {
                super(s2, skip, limit);
            }

            OfRef(Spliterator<T> s2, OfRef<T> parent) {
                super(s2, parent);
            }

            @Override // java.util.function.Consumer
            public final void accept(T t2) {
                this.tmpSlot = t2;
            }

            @Override // java.util.Spliterator
            public boolean tryAdvance(Consumer<? super T> consumer) {
                Objects.requireNonNull(consumer);
                while (permitStatus() != PermitStatus.NO_MORE && this.f50525s.tryAdvance(this)) {
                    if (acquirePermits(1L) == 1) {
                        consumer.accept(this.tmpSlot);
                        this.tmpSlot = null;
                        return true;
                    }
                }
                return false;
            }

            @Override // java.util.Spliterator
            public void forEachRemaining(Consumer<? super T> action) {
                Objects.requireNonNull(action);
                ArrayBuffer.OfRef<T> sb2 = null;
                while (true) {
                    PermitStatus permitStatus = permitStatus();
                    if (permitStatus != PermitStatus.NO_MORE) {
                        if (permitStatus == PermitStatus.MAYBE_MORE) {
                            if (sb2 == null) {
                                sb2 = new ArrayBuffer.OfRef<>(128);
                            } else {
                                sb2.reset();
                            }
                            long permitsRequested = 0;
                            while (this.f50525s.tryAdvance(sb2)) {
                                long j10 = 1 + permitsRequested;
                                permitsRequested = j10;
                                if (j10 >= 128) {
                                    break;
                                }
                            }
                            if (permitsRequested == 0) {
                                return;
                            } else {
                                sb2.forEach(action, acquirePermits(permitsRequested));
                            }
                        } else {
                            this.f50525s.forEachRemaining(action);
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }

            @Override // java.util.stream.StreamSpliterators.UnorderedSliceSpliterator
            protected Spliterator<T> makeSpliterator(Spliterator<T> s2) {
                return new OfRef(s2, this);
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static abstract class OfPrimitive<T, T_CONS, T_BUFF extends ArrayBuffer.OfPrimitive<T_CONS>, T_SPLITR extends Spliterator.OfPrimitive<T, T_CONS, T_SPLITR>> extends UnorderedSliceSpliterator<T, T_SPLITR> implements Spliterator.OfPrimitive<T, T_CONS, T_SPLITR> {
            protected abstract void acceptConsumed(T_CONS t_cons);

            protected abstract T_BUFF bufferCreate(int i10);

            @Override // java.util.stream.StreamSpliterators.UnorderedSliceSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfPrimitive trySplit() {
                return (Spliterator.OfPrimitive) super.trySplit();
            }

            OfPrimitive(T_SPLITR s2, long skip, long limit) {
                super(s2, skip, limit);
            }

            OfPrimitive(T_SPLITR s2, OfPrimitive<T, T_CONS, T_BUFF, T_SPLITR> parent) {
                super(s2, parent);
            }

            @Override // java.util.Spliterator.OfPrimitive
            public boolean tryAdvance(T_CONS action) {
                Objects.requireNonNull(action);
                while (permitStatus() != PermitStatus.NO_MORE && ((Spliterator.OfPrimitive) this.f50525s).tryAdvance(this)) {
                    if (acquirePermits(1L) == 1) {
                        acceptConsumed(action);
                        return true;
                    }
                }
                return false;
            }

            @Override // java.util.Spliterator.OfPrimitive
            public void forEachRemaining(T_CONS action) {
                Objects.requireNonNull(action);
                T_BUFF sb2 = null;
                while (true) {
                    PermitStatus permitStatus = permitStatus();
                    if (permitStatus != PermitStatus.NO_MORE) {
                        if (permitStatus == PermitStatus.MAYBE_MORE) {
                            if (sb2 == null) {
                                sb2 = bufferCreate(128);
                            } else {
                                sb2.reset();
                            }
                            T_BUFF t_buff = sb2;
                            long permitsRequested = 0;
                            while (((Spliterator.OfPrimitive) this.f50525s).tryAdvance((Spliterator.OfPrimitive) t_buff)) {
                                long j10 = 1 + permitsRequested;
                                permitsRequested = j10;
                                if (j10 >= 128) {
                                    break;
                                }
                            }
                            if (permitsRequested == 0) {
                                return;
                            } else {
                                sb2.forEach(action, acquirePermits(permitsRequested));
                            }
                        } else {
                            ((Spliterator.OfPrimitive) this.f50525s).forEachRemaining((Spliterator.OfPrimitive) action);
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static final class OfInt extends OfPrimitive<Integer, IntConsumer, ArrayBuffer.OfInt, Spliterator.OfInt> implements Spliterator.OfInt, IntConsumer {
            int tmpValue;

            @Override // java.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
                super.forEachRemaining((OfInt) intConsumer);
            }

            @Override // java.util.Spliterator.OfInt
            public /* bridge */ /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
                return super.tryAdvance((OfInt) intConsumer);
            }

            @Override // java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive, java.util.stream.StreamSpliterators.UnorderedSliceSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfInt trySplit() {
                return (Spliterator.OfInt) super.trySplit();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public OfInt(Spliterator.OfInt s2, long skip, long limit) {
                super(s2, skip, limit);
            }

            OfInt(Spliterator.OfInt s2, OfInt parent) {
                super(s2, parent);
            }

            @Override // java.util.function.IntConsumer
            public void accept(int value) {
                this.tmpValue = value;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive
            public void acceptConsumed(IntConsumer action) {
                action.accept(this.tmpValue);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive
            public ArrayBuffer.OfInt bufferCreate(int initialCapacity) {
                return new ArrayBuffer.OfInt(initialCapacity);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.util.stream.StreamSpliterators.UnorderedSliceSpliterator
            public Spliterator.OfInt makeSpliterator(Spliterator.OfInt s2) {
                return new OfInt(s2, this);
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static final class OfLong extends OfPrimitive<Long, LongConsumer, ArrayBuffer.OfLong, Spliterator.OfLong> implements Spliterator.OfLong, LongConsumer {
            long tmpValue;

            @Override // java.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
                super.forEachRemaining((OfLong) longConsumer);
            }

            @Override // java.util.Spliterator.OfLong
            public /* bridge */ /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
                return super.tryAdvance((OfLong) longConsumer);
            }

            @Override // java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive, java.util.stream.StreamSpliterators.UnorderedSliceSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfLong trySplit() {
                return (Spliterator.OfLong) super.trySplit();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public OfLong(Spliterator.OfLong s2, long skip, long limit) {
                super(s2, skip, limit);
            }

            OfLong(Spliterator.OfLong s2, OfLong parent) {
                super(s2, parent);
            }

            @Override // java.util.function.LongConsumer
            public void accept(long value) {
                this.tmpValue = value;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive
            public void acceptConsumed(LongConsumer action) {
                action.accept(this.tmpValue);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive
            public ArrayBuffer.OfLong bufferCreate(int initialCapacity) {
                return new ArrayBuffer.OfLong(initialCapacity);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.util.stream.StreamSpliterators.UnorderedSliceSpliterator
            public Spliterator.OfLong makeSpliterator(Spliterator.OfLong s2) {
                return new OfLong(s2, this);
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static final class OfDouble extends OfPrimitive<Double, DoubleConsumer, ArrayBuffer.OfDouble, Spliterator.OfDouble> implements Spliterator.OfDouble, DoubleConsumer {
            double tmpValue;

            @Override // java.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
                super.forEachRemaining((OfDouble) doubleConsumer);
            }

            @Override // java.util.Spliterator.OfDouble
            public /* bridge */ /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
                return super.tryAdvance((OfDouble) doubleConsumer);
            }

            @Override // java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive, java.util.stream.StreamSpliterators.UnorderedSliceSpliterator, java.util.Spliterator.OfPrimitive, java.util.Spliterator
            public /* bridge */ /* synthetic */ Spliterator.OfDouble trySplit() {
                return (Spliterator.OfDouble) super.trySplit();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public OfDouble(Spliterator.OfDouble s2, long skip, long limit) {
                super(s2, skip, limit);
            }

            OfDouble(Spliterator.OfDouble s2, OfDouble parent) {
                super(s2, parent);
            }

            @Override // java.util.function.DoubleConsumer
            public void accept(double value) {
                this.tmpValue = value;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive
            public void acceptConsumed(DoubleConsumer action) {
                action.accept(this.tmpValue);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.stream.StreamSpliterators.UnorderedSliceSpliterator.OfPrimitive
            public ArrayBuffer.OfDouble bufferCreate(int initialCapacity) {
                return new ArrayBuffer.OfDouble(initialCapacity);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // java.util.stream.StreamSpliterators.UnorderedSliceSpliterator
            public Spliterator.OfDouble makeSpliterator(Spliterator.OfDouble s2) {
                return new OfDouble(s2, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static final class DistinctSpliterator<T> implements Spliterator<T>, Consumer<T> {
        private static final Object NULL_VALUE = new Object();

        /* renamed from: s, reason: collision with root package name */
        private final Spliterator<T> f50519s;
        private final ConcurrentHashMap<T, Boolean> seen;
        private T tmpSlot;

        /* JADX INFO: Access modifiers changed from: package-private */
        public DistinctSpliterator(Spliterator<T> s2) {
            this(s2, new ConcurrentHashMap());
        }

        private DistinctSpliterator(Spliterator<T> s2, ConcurrentHashMap<T, Boolean> seen) {
            this.f50519s = s2;
            this.seen = seen;
        }

        @Override // java.util.function.Consumer
        public void accept(T t2) {
            this.tmpSlot = t2;
        }

        private T mapNull(T t2) {
            return t2 != null ? t2 : (T) NULL_VALUE;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super T> consumer) {
            while (this.f50519s.tryAdvance(this)) {
                if (this.seen.putIfAbsent(mapNull(this.tmpSlot), Boolean.TRUE) == null) {
                    consumer.accept(this.tmpSlot);
                    this.tmpSlot = null;
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(final Consumer<? super T> action) {
            this.f50519s.forEachRemaining(new Consumer() { // from class: java.util.stream.StreamSpliterators$DistinctSpliterator$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    StreamSpliterators.DistinctSpliterator.this.lambda$forEachRemaining$0(action, obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ void lambda$forEachRemaining$0(Consumer action, Object obj) {
            if (this.seen.putIfAbsent(mapNull(obj), Boolean.TRUE) == null) {
                action.accept(obj);
            }
        }

        @Override // java.util.Spliterator
        public Spliterator<T> trySplit() {
            Spliterator<T> split = this.f50519s.trySplit();
            if (split != null) {
                return new DistinctSpliterator(split, this.seen);
            }
            return null;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.f50519s.estimateSize();
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return (this.f50519s.characteristics() & (-16469)) | 1;
        }

        @Override // java.util.Spliterator
        public Comparator<? super T> getComparator() {
            return this.f50519s.getComparator();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class InfiniteSupplyingSpliterator<T> implements Spliterator<T> {
        long estimate;

        protected InfiniteSupplyingSpliterator(long estimate) {
            this.estimate = estimate;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.estimate;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return 1024;
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static final class OfRef<T> extends InfiniteSupplyingSpliterator<T> {

            /* renamed from: s, reason: collision with root package name */
            final Supplier<? extends T> f50523s;

            /* JADX INFO: Access modifiers changed from: package-private */
            public OfRef(long size, Supplier<? extends T> s2) {
                super(size);
                this.f50523s = s2;
            }

            @Override // java.util.Spliterator
            public boolean tryAdvance(Consumer<? super T> consumer) {
                Objects.requireNonNull(consumer);
                consumer.accept(this.f50523s.get());
                return true;
            }

            @Override // java.util.Spliterator
            public Spliterator<T> trySplit() {
                if (this.estimate == 0) {
                    return null;
                }
                long j10 = this.estimate >>> 1;
                this.estimate = j10;
                return new OfRef(j10, this.f50523s);
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static final class OfInt extends InfiniteSupplyingSpliterator<Integer> implements Spliterator.OfInt {

            /* renamed from: s, reason: collision with root package name */
            final IntSupplier f50521s;

            /* JADX INFO: Access modifiers changed from: package-private */
            public OfInt(long size, IntSupplier s2) {
                super(size);
                this.f50521s = s2;
            }

            @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive
            public boolean tryAdvance(IntConsumer action) {
                Objects.requireNonNull(action);
                action.accept(this.f50521s.getAsInt());
                return true;
            }

            @Override // java.util.Spliterator
            public Spliterator.OfInt trySplit() {
                if (this.estimate == 0) {
                    return null;
                }
                long j10 = this.estimate >>> 1;
                this.estimate = j10;
                return new OfInt(j10, this.f50521s);
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static final class OfLong extends InfiniteSupplyingSpliterator<Long> implements Spliterator.OfLong {

            /* renamed from: s, reason: collision with root package name */
            final LongSupplier f50522s;

            /* JADX INFO: Access modifiers changed from: package-private */
            public OfLong(long size, LongSupplier s2) {
                super(size);
                this.f50522s = s2;
            }

            @Override // java.util.Spliterator.OfLong, java.util.Spliterator.OfPrimitive
            public boolean tryAdvance(LongConsumer action) {
                Objects.requireNonNull(action);
                action.accept(this.f50522s.getAsLong());
                return true;
            }

            @Override // java.util.Spliterator
            public Spliterator.OfLong trySplit() {
                if (this.estimate == 0) {
                    return null;
                }
                long j10 = this.estimate >>> 1;
                this.estimate = j10;
                return new OfLong(j10, this.f50522s);
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static final class OfDouble extends InfiniteSupplyingSpliterator<Double> implements Spliterator.OfDouble {

            /* renamed from: s, reason: collision with root package name */
            final DoubleSupplier f50520s;

            /* JADX INFO: Access modifiers changed from: package-private */
            public OfDouble(long size, DoubleSupplier s2) {
                super(size);
                this.f50520s = s2;
            }

            @Override // java.util.Spliterator.OfDouble, java.util.Spliterator.OfPrimitive
            public boolean tryAdvance(DoubleConsumer action) {
                Objects.requireNonNull(action);
                action.accept(this.f50520s.getAsDouble());
                return true;
            }

            @Override // java.util.Spliterator
            public Spliterator.OfDouble trySplit() {
                if (this.estimate == 0) {
                    return null;
                }
                long j10 = this.estimate >>> 1;
                this.estimate = j10;
                return new OfDouble(j10, this.f50520s);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    static abstract class ArrayBuffer {
        int index;

        ArrayBuffer() {
        }

        void reset() {
            this.index = 0;
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static final class OfRef<T> extends ArrayBuffer implements Consumer<T> {
            final Object[] array;

            OfRef(int size) {
                this.array = new Object[size];
            }

            @Override // java.util.function.Consumer
            public void accept(T t2) {
                Object[] objArr = this.array;
                int i10 = this.index;
                this.index = i10 + 1;
                objArr[i10] = t2;
            }

            public void forEach(Consumer<? super T> action, long fence) {
                for (int i10 = 0; i10 < fence; i10++) {
                    action.accept(this.array[i10]);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static abstract class OfPrimitive<T_CONS> extends ArrayBuffer {
            int index;

            abstract void forEach(T_CONS t_cons, long j10);

            OfPrimitive() {
            }

            @Override // java.util.stream.StreamSpliterators.ArrayBuffer
            void reset() {
                this.index = 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static final class OfInt extends OfPrimitive<IntConsumer> implements IntConsumer {
            final int[] array;

            OfInt(int size) {
                this.array = new int[size];
            }

            @Override // java.util.function.IntConsumer
            public void accept(int t2) {
                int[] iArr = this.array;
                int i10 = this.index;
                this.index = i10 + 1;
                iArr[i10] = t2;
            }

            @Override // java.util.stream.StreamSpliterators.ArrayBuffer.OfPrimitive
            public void forEach(IntConsumer action, long fence) {
                for (int i10 = 0; i10 < fence; i10++) {
                    action.accept(this.array[i10]);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static final class OfLong extends OfPrimitive<LongConsumer> implements LongConsumer {
            final long[] array;

            OfLong(int size) {
                this.array = new long[size];
            }

            @Override // java.util.function.LongConsumer
            public void accept(long t2) {
                long[] jArr = this.array;
                int i10 = this.index;
                this.index = i10 + 1;
                jArr[i10] = t2;
            }

            @Override // java.util.stream.StreamSpliterators.ArrayBuffer.OfPrimitive
            public void forEach(LongConsumer action, long fence) {
                for (int i10 = 0; i10 < fence; i10++) {
                    action.accept(this.array[i10]);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        public static final class OfDouble extends OfPrimitive<DoubleConsumer> implements DoubleConsumer {
            final double[] array;

            OfDouble(int size) {
                this.array = new double[size];
            }

            @Override // java.util.function.DoubleConsumer
            public void accept(double t2) {
                double[] dArr = this.array;
                int i10 = this.index;
                this.index = i10 + 1;
                dArr[i10] = t2;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // java.util.stream.StreamSpliterators.ArrayBuffer.OfPrimitive
            public void forEach(DoubleConsumer action, long fence) {
                for (int i10 = 0; i10 < fence; i10++) {
                    action.accept(this.array[i10]);
                }
            }
        }
    }
}
