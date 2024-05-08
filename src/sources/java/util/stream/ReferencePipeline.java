package java.util.stream;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collector;
import java.util.stream.DoublePipeline;
import java.util.stream.IntPipeline;
import java.util.stream.LongPipeline;
import java.util.stream.MatchOps;
import java.util.stream.Node;
import java.util.stream.Sink;
import java.util.stream.StreamSpliterators;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class ReferencePipeline<P_IN, P_OUT> extends AbstractPipeline<P_IN, P_OUT, Stream<P_OUT>> implements Stream<P_OUT> {
    ReferencePipeline(Supplier<? extends Spliterator<?>> source, int sourceFlags, boolean parallel) {
        super(source, sourceFlags, parallel);
    }

    ReferencePipeline(Spliterator<?> source, int sourceFlags, boolean parallel) {
        super(source, sourceFlags, parallel);
    }

    ReferencePipeline(AbstractPipeline<?, P_IN, ?> upstream, int opFlags) {
        super(upstream, opFlags);
    }

    @Override // java.util.stream.AbstractPipeline
    public final StreamShape getOutputShape() {
        return StreamShape.REFERENCE;
    }

    @Override // java.util.stream.AbstractPipeline
    public final <P_IN> Node<P_OUT> evaluateToNode(PipelineHelper<P_OUT> helper, Spliterator<P_IN> spliterator, boolean flattenTree, IntFunction<P_OUT[]> generator) {
        return Nodes.collect(helper, spliterator, flattenTree, generator);
    }

    @Override // java.util.stream.AbstractPipeline
    public final <P_IN> Spliterator<P_OUT> wrap(PipelineHelper<P_OUT> ph, Supplier<Spliterator<P_IN>> supplier, boolean isParallel) {
        return new StreamSpliterators.WrappingSpliterator(ph, supplier, isParallel);
    }

    @Override // java.util.stream.AbstractPipeline
    /* renamed from: lazySpliterator */
    public final Spliterator<P_OUT> lazySpliterator2(Supplier<? extends Spliterator<P_OUT>> supplier) {
        return new StreamSpliterators.DelegatingSpliterator(supplier);
    }

    @Override // java.util.stream.AbstractPipeline
    public final boolean forEachWithCancel(Spliterator<P_OUT> spliterator, Sink<P_OUT> sink) {
        boolean cancelled;
        do {
            cancelled = sink.cancellationRequested();
            if (cancelled) {
                break;
            }
        } while (spliterator.tryAdvance(sink));
        return cancelled;
    }

    @Override // java.util.stream.AbstractPipeline, java.util.stream.PipelineHelper
    public final Node.Builder<P_OUT> makeNodeBuilder(long exactSizeIfKnown, IntFunction<P_OUT[]> generator) {
        return Nodes.builder(exactSizeIfKnown, generator);
    }

    @Override // java.util.stream.BaseStream, java.util.stream.DoubleStream
    public final Iterator<P_OUT> iterator() {
        return Spliterators.iterator(spliterator2());
    }

    @Override // java.util.stream.BaseStream
    public Stream<P_OUT> unordered() {
        if (!isOrdered()) {
            return this;
        }
        return new StatelessOp<P_OUT, P_OUT>(this, StreamShape.REFERENCE, StreamOpFlag.NOT_ORDERED) { // from class: java.util.stream.ReferencePipeline.1
            @Override // java.util.stream.AbstractPipeline
            public Sink<P_OUT> opWrapSink(int flags, Sink<P_OUT> sink) {
                return sink;
            }
        };
    }

    @Override // java.util.stream.Stream
    public final Stream<P_OUT> filter(final Predicate<? super P_OUT> predicate) {
        Objects.requireNonNull(predicate);
        return new StatelessOp<P_OUT, P_OUT>(this, StreamShape.REFERENCE, StreamOpFlag.NOT_SIZED) { // from class: java.util.stream.ReferencePipeline.2
            @Override // java.util.stream.AbstractPipeline
            public Sink<P_OUT> opWrapSink(int flags, Sink<P_OUT> sink) {
                return new Sink.ChainedReference<P_OUT, P_OUT>(sink) { // from class: java.util.stream.ReferencePipeline.2.1
                    @Override // java.util.stream.Sink.ChainedReference, java.util.stream.Sink
                    public void begin(long size) {
                        this.downstream.begin(-1L);
                    }

                    @Override // java.util.function.Consumer
                    public void accept(P_OUT u10) {
                        if (predicate.test(u10)) {
                            this.downstream.accept(u10);
                        }
                    }
                };
            }
        };
    }

    @Override // java.util.stream.Stream
    public final <R> Stream<R> map(final Function<? super P_OUT, ? extends R> mapper) {
        Objects.requireNonNull(mapper);
        return new StatelessOp<P_OUT, R>(this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: java.util.stream.ReferencePipeline.3
            @Override // java.util.stream.AbstractPipeline
            public Sink<P_OUT> opWrapSink(int flags, Sink<R> sink) {
                return new Sink.ChainedReference<P_OUT, R>(sink) { // from class: java.util.stream.ReferencePipeline.3.1
                    @Override // java.util.function.Consumer
                    public void accept(P_OUT u10) {
                        this.downstream.accept(mapper.apply(u10));
                    }
                };
            }
        };
    }

    @Override // java.util.stream.Stream
    public final IntStream mapToInt(final ToIntFunction<? super P_OUT> mapper) {
        Objects.requireNonNull(mapper);
        return new IntPipeline.StatelessOp<P_OUT>(this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: java.util.stream.ReferencePipeline.4
            @Override // java.util.stream.AbstractPipeline
            public Sink<P_OUT> opWrapSink(int flags, Sink<Integer> sink) {
                return new Sink.ChainedReference<P_OUT, Integer>(sink) { // from class: java.util.stream.ReferencePipeline.4.1
                    @Override // java.util.function.Consumer
                    public void accept(P_OUT u10) {
                        this.downstream.accept(mapper.applyAsInt(u10));
                    }
                };
            }
        };
    }

    @Override // java.util.stream.Stream
    public final LongStream mapToLong(final ToLongFunction<? super P_OUT> mapper) {
        Objects.requireNonNull(mapper);
        return new LongPipeline.StatelessOp<P_OUT>(this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: java.util.stream.ReferencePipeline.5
            @Override // java.util.stream.AbstractPipeline
            public Sink<P_OUT> opWrapSink(int flags, Sink<Long> sink) {
                return new Sink.ChainedReference<P_OUT, Long>(sink) { // from class: java.util.stream.ReferencePipeline.5.1
                    @Override // java.util.function.Consumer
                    public void accept(P_OUT u10) {
                        this.downstream.accept(mapper.applyAsLong(u10));
                    }
                };
            }
        };
    }

    @Override // java.util.stream.Stream
    public final DoubleStream mapToDouble(final ToDoubleFunction<? super P_OUT> mapper) {
        Objects.requireNonNull(mapper);
        return new DoublePipeline.StatelessOp<P_OUT>(this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: java.util.stream.ReferencePipeline.6
            @Override // java.util.stream.AbstractPipeline
            public Sink<P_OUT> opWrapSink(int flags, Sink<Double> sink) {
                return new Sink.ChainedReference<P_OUT, Double>(sink) { // from class: java.util.stream.ReferencePipeline.6.1
                    @Override // java.util.function.Consumer
                    public void accept(P_OUT u10) {
                        this.downstream.accept(mapper.applyAsDouble(u10));
                    }
                };
            }
        };
    }

    @Override // java.util.stream.Stream
    public final <R> Stream<R> flatMap(final Function<? super P_OUT, ? extends Stream<? extends R>> mapper) {
        Objects.requireNonNull(mapper);
        return new StatelessOp<P_OUT, R>(this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED) { // from class: java.util.stream.ReferencePipeline.7
            @Override // java.util.stream.AbstractPipeline
            public Sink<P_OUT> opWrapSink(int flags, Sink<R> sink) {
                return new Sink.ChainedReference<P_OUT, R>(sink) { // from class: java.util.stream.ReferencePipeline.7.1
                    @Override // java.util.stream.Sink.ChainedReference, java.util.stream.Sink
                    public void begin(long size) {
                        this.downstream.begin(-1L);
                    }

                    @Override // java.util.function.Consumer
                    public void accept(P_OUT u10) {
                        Stream<? extends R> result = (Stream) mapper.apply(u10);
                        if (result != null) {
                            try {
                                result.sequential().forEach(this.downstream);
                            } catch (Throwable th) {
                                if (result != null) {
                                    try {
                                        result.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                }
                                throw th;
                            }
                        }
                        if (result != null) {
                            result.close();
                        }
                    }
                };
            }
        };
    }

    @Override // java.util.stream.Stream
    public final IntStream flatMapToInt(final Function<? super P_OUT, ? extends IntStream> mapper) {
        Objects.requireNonNull(mapper);
        return new IntPipeline.StatelessOp<P_OUT>(this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED) { // from class: java.util.stream.ReferencePipeline.8
            @Override // java.util.stream.AbstractPipeline
            public Sink<P_OUT> opWrapSink(int flags, Sink<Integer> sink) {
                return new Sink.ChainedReference<P_OUT, Integer>(sink) { // from class: java.util.stream.ReferencePipeline.8.1
                    IntConsumer downstreamAsInt;

                    {
                        Sink<? super E_OUT> sink2 = this.downstream;
                        Objects.requireNonNull(sink2);
                        this.downstreamAsInt = new IntPipeline$$ExternalSyntheticLambda1(sink2);
                    }

                    @Override // java.util.stream.Sink.ChainedReference, java.util.stream.Sink
                    public void begin(long size) {
                        this.downstream.begin(-1L);
                    }

                    @Override // java.util.function.Consumer
                    public void accept(P_OUT u10) {
                        IntStream result = (IntStream) mapper.apply(u10);
                        if (result != null) {
                            try {
                                result.sequential().forEach(this.downstreamAsInt);
                            } catch (Throwable th) {
                                if (result != null) {
                                    try {
                                        result.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                }
                                throw th;
                            }
                        }
                        if (result != null) {
                            result.close();
                        }
                    }
                };
            }
        };
    }

    @Override // java.util.stream.Stream
    public final DoubleStream flatMapToDouble(final Function<? super P_OUT, ? extends DoubleStream> mapper) {
        Objects.requireNonNull(mapper);
        return new DoublePipeline.StatelessOp<P_OUT>(this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED) { // from class: java.util.stream.ReferencePipeline.9
            @Override // java.util.stream.AbstractPipeline
            public Sink<P_OUT> opWrapSink(int flags, Sink<Double> sink) {
                return new Sink.ChainedReference<P_OUT, Double>(sink) { // from class: java.util.stream.ReferencePipeline.9.1
                    DoubleConsumer downstreamAsDouble;

                    {
                        Sink<? super E_OUT> sink2 = this.downstream;
                        Objects.requireNonNull(sink2);
                        this.downstreamAsDouble = new DoublePipeline$$ExternalSyntheticLambda5(sink2);
                    }

                    @Override // java.util.stream.Sink.ChainedReference, java.util.stream.Sink
                    public void begin(long size) {
                        this.downstream.begin(-1L);
                    }

                    @Override // java.util.function.Consumer
                    public void accept(P_OUT u10) {
                        DoubleStream result = (DoubleStream) mapper.apply(u10);
                        if (result != null) {
                            try {
                                result.sequential().forEach(this.downstreamAsDouble);
                            } catch (Throwable th) {
                                if (result != null) {
                                    try {
                                        result.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                }
                                throw th;
                            }
                        }
                        if (result != null) {
                            result.close();
                        }
                    }
                };
            }
        };
    }

    @Override // java.util.stream.Stream
    public final LongStream flatMapToLong(final Function<? super P_OUT, ? extends LongStream> mapper) {
        Objects.requireNonNull(mapper);
        return new LongPipeline.StatelessOp<P_OUT>(this, StreamShape.REFERENCE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED) { // from class: java.util.stream.ReferencePipeline.10
            @Override // java.util.stream.AbstractPipeline
            public Sink<P_OUT> opWrapSink(int flags, Sink<Long> sink) {
                return new Sink.ChainedReference<P_OUT, Long>(sink) { // from class: java.util.stream.ReferencePipeline.10.1
                    LongConsumer downstreamAsLong;

                    {
                        Sink<? super E_OUT> sink2 = this.downstream;
                        Objects.requireNonNull(sink2);
                        this.downstreamAsLong = new LongPipeline$$ExternalSyntheticLambda11(sink2);
                    }

                    @Override // java.util.stream.Sink.ChainedReference, java.util.stream.Sink
                    public void begin(long size) {
                        this.downstream.begin(-1L);
                    }

                    @Override // java.util.function.Consumer
                    public void accept(P_OUT u10) {
                        LongStream result = (LongStream) mapper.apply(u10);
                        if (result != null) {
                            try {
                                result.sequential().forEach(this.downstreamAsLong);
                            } catch (Throwable th) {
                                if (result != null) {
                                    try {
                                        result.close();
                                    } catch (Throwable th2) {
                                        th.addSuppressed(th2);
                                    }
                                }
                                throw th;
                            }
                        }
                        if (result != null) {
                            result.close();
                        }
                    }
                };
            }
        };
    }

    @Override // java.util.stream.Stream
    public final Stream<P_OUT> peek(final Consumer<? super P_OUT> action) {
        Objects.requireNonNull(action);
        return new StatelessOp<P_OUT, P_OUT>(this, StreamShape.REFERENCE, 0) { // from class: java.util.stream.ReferencePipeline.11
            @Override // java.util.stream.AbstractPipeline
            public Sink<P_OUT> opWrapSink(int flags, Sink<P_OUT> sink) {
                return new Sink.ChainedReference<P_OUT, P_OUT>(sink) { // from class: java.util.stream.ReferencePipeline.11.1
                    @Override // java.util.function.Consumer
                    public void accept(P_OUT u10) {
                        action.accept(u10);
                        this.downstream.accept(u10);
                    }
                };
            }
        };
    }

    @Override // java.util.stream.Stream
    public final Stream<P_OUT> distinct() {
        return DistinctOps.makeRef(this);
    }

    @Override // java.util.stream.Stream
    public final Stream<P_OUT> sorted() {
        return SortedOps.makeRef(this);
    }

    @Override // java.util.stream.Stream
    public final Stream<P_OUT> sorted(Comparator<? super P_OUT> comparator) {
        return SortedOps.makeRef(this, comparator);
    }

    @Override // java.util.stream.Stream
    public final Stream<P_OUT> limit(long maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException(Long.toString(maxSize));
        }
        return SliceOps.makeRef(this, 0L, maxSize);
    }

    @Override // java.util.stream.Stream
    public final Stream<P_OUT> skip(long n10) {
        if (n10 < 0) {
            throw new IllegalArgumentException(Long.toString(n10));
        }
        if (n10 == 0) {
            return this;
        }
        return SliceOps.makeRef(this, n10, -1L);
    }

    @Override // java.util.stream.Stream
    public void forEach(Consumer<? super P_OUT> action) {
        evaluate(ForEachOps.makeRef(action, false));
    }

    @Override // java.util.stream.Stream
    public void forEachOrdered(Consumer<? super P_OUT> action) {
        evaluate(ForEachOps.makeRef(action, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.stream.Stream
    public final <A> A[] toArray(IntFunction<A[]> intFunction) {
        return (A[]) Nodes.flatten(evaluateToArrayNode(intFunction), intFunction).asArray(intFunction);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object[] lambda$toArray$0(int x$0) {
        return new Object[x$0];
    }

    @Override // java.util.stream.Stream
    public final Object[] toArray() {
        return toArray(new IntFunction() { // from class: java.util.stream.ReferencePipeline$$ExternalSyntheticLambda0
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                return ReferencePipeline.lambda$toArray$0(i10);
            }
        });
    }

    @Override // java.util.stream.Stream
    public final boolean anyMatch(Predicate<? super P_OUT> predicate) {
        return ((Boolean) evaluate(MatchOps.makeRef(predicate, MatchOps.MatchKind.ANY))).booleanValue();
    }

    @Override // java.util.stream.Stream
    public final boolean allMatch(Predicate<? super P_OUT> predicate) {
        return ((Boolean) evaluate(MatchOps.makeRef(predicate, MatchOps.MatchKind.ALL))).booleanValue();
    }

    @Override // java.util.stream.Stream
    public final boolean noneMatch(Predicate<? super P_OUT> predicate) {
        return ((Boolean) evaluate(MatchOps.makeRef(predicate, MatchOps.MatchKind.NONE))).booleanValue();
    }

    @Override // java.util.stream.Stream
    public final Optional<P_OUT> findFirst() {
        return (Optional) evaluate(FindOps.makeRef(true));
    }

    @Override // java.util.stream.Stream
    public final Optional<P_OUT> findAny() {
        return (Optional) evaluate(FindOps.makeRef(false));
    }

    @Override // java.util.stream.Stream
    public final P_OUT reduce(P_OUT p_out, BinaryOperator<P_OUT> binaryOperator) {
        return (P_OUT) evaluate(ReduceOps.makeRef(p_out, binaryOperator, binaryOperator));
    }

    @Override // java.util.stream.Stream
    public final Optional<P_OUT> reduce(BinaryOperator<P_OUT> accumulator) {
        return (Optional) evaluate(ReduceOps.makeRef(accumulator));
    }

    @Override // java.util.stream.Stream
    public final <R> R reduce(R r10, BiFunction<R, ? super P_OUT, R> biFunction, BinaryOperator<R> binaryOperator) {
        return (R) evaluate(ReduceOps.makeRef(r10, (BiFunction<R, ? super T, R>) biFunction, binaryOperator));
    }

    @Override // java.util.stream.Stream
    public final <R, A> R collect(Collector<? super P_OUT, A, R> collector) {
        final A a10;
        if (isParallel() && collector.characteristics().contains(Collector.Characteristics.CONCURRENT) && (!isOrdered() || collector.characteristics().contains(Collector.Characteristics.UNORDERED))) {
            a10 = collector.supplier().get();
            final BiConsumer<A, ? super P_OUT> accumulator = collector.accumulator();
            forEach(new Consumer() { // from class: java.util.stream.ReferencePipeline$$ExternalSyntheticLambda1
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    BiConsumer.this.accept(a10, obj);
                }
            });
        } else {
            a10 = (A) evaluate(ReduceOps.makeRef(collector));
        }
        if (collector.characteristics().contains(Collector.Characteristics.IDENTITY_FINISH)) {
            return a10;
        }
        return (R) collector.finisher().apply(a10);
    }

    @Override // java.util.stream.Stream
    public final <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super P_OUT> biConsumer, BiConsumer<R, R> biConsumer2) {
        return (R) evaluate(ReduceOps.makeRef(supplier, biConsumer, biConsumer2));
    }

    @Override // java.util.stream.Stream
    public final Optional<P_OUT> max(Comparator<? super P_OUT> comparator) {
        return reduce(BinaryOperator.maxBy(comparator));
    }

    @Override // java.util.stream.Stream
    public final Optional<P_OUT> min(Comparator<? super P_OUT> comparator) {
        return reduce(BinaryOperator.minBy(comparator));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long lambda$count$2(Object e2) {
        return 1L;
    }

    @Override // java.util.stream.Stream
    public final long count() {
        return mapToLong(new ToLongFunction() { // from class: java.util.stream.ReferencePipeline$$ExternalSyntheticLambda2
            @Override // java.util.function.ToLongFunction
            public final long applyAsLong(Object obj) {
                return ReferencePipeline.lambda$count$2(obj);
            }
        }).sum();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Head<E_IN, E_OUT> extends ReferencePipeline<E_IN, E_OUT> {
        public Head(Supplier<? extends Spliterator<?>> source, int sourceFlags, boolean parallel) {
            super(source, sourceFlags, parallel);
        }

        public Head(Spliterator<?> source, int sourceFlags, boolean parallel) {
            super(source, sourceFlags, parallel);
        }

        @Override // java.util.stream.AbstractPipeline
        public final boolean opIsStateful() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.stream.AbstractPipeline
        public final Sink<E_IN> opWrapSink(int flags, Sink<E_OUT> sink) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.stream.ReferencePipeline, java.util.stream.Stream
        public void forEach(Consumer<? super E_OUT> consumer) {
            if (!isParallel()) {
                sourceStageSpliterator().forEachRemaining(consumer);
            } else {
                super.forEach(consumer);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.stream.ReferencePipeline, java.util.stream.Stream
        public void forEachOrdered(Consumer<? super E_OUT> consumer) {
            if (!isParallel()) {
                sourceStageSpliterator().forEachRemaining(consumer);
            } else {
                super.forEachOrdered(consumer);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class StatelessOp<E_IN, E_OUT> extends ReferencePipeline<E_IN, E_OUT> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        public StatelessOp(AbstractPipeline<?, E_IN, ?> upstream, StreamShape inputShape, int opFlags) {
            super(upstream, opFlags);
        }

        @Override // java.util.stream.AbstractPipeline
        public final boolean opIsStateful() {
            return false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class StatefulOp<E_IN, E_OUT> extends ReferencePipeline<E_IN, E_OUT> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        @Override // java.util.stream.AbstractPipeline
        public abstract <P_IN> Node<E_OUT> opEvaluateParallel(PipelineHelper<E_OUT> pipelineHelper, Spliterator<P_IN> spliterator, IntFunction<E_OUT[]> intFunction);

        public StatefulOp(AbstractPipeline<?, E_IN, ?> upstream, StreamShape inputShape, int opFlags) {
            super(upstream, opFlags);
        }

        @Override // java.util.stream.AbstractPipeline
        public final boolean opIsStateful() {
            return true;
        }
    }
}
