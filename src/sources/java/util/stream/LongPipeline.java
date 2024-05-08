package java.util.stream;

import java.util.Iterator;
import java.util.LongSummaryStatistics;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.IntFunction;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;
import java.util.function.ToLongFunction;
import java.util.stream.DoublePipeline;
import java.util.stream.IntPipeline;
import java.util.stream.LongPipeline;
import java.util.stream.MatchOps;
import java.util.stream.Node;
import java.util.stream.ReferencePipeline;
import java.util.stream.Sink;
import java.util.stream.StreamSpliterators;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class LongPipeline<E_IN> extends AbstractPipeline<E_IN, Long, LongStream> implements LongStream {
    @Override // java.util.stream.AbstractPipeline, java.util.stream.BaseStream
    public /* bridge */ /* synthetic */ LongStream parallel() {
        return (LongStream) super.parallel();
    }

    @Override // java.util.stream.AbstractPipeline, java.util.stream.BaseStream
    public /* bridge */ /* synthetic */ LongStream sequential() {
        return (LongStream) super.sequential();
    }

    LongPipeline(Supplier<? extends Spliterator<Long>> source, int sourceFlags, boolean parallel) {
        super(source, sourceFlags, parallel);
    }

    LongPipeline(Spliterator<Long> source, int sourceFlags, boolean parallel) {
        super(source, sourceFlags, parallel);
    }

    LongPipeline(AbstractPipeline<?, E_IN, ?> upstream, int opFlags) {
        super(upstream, opFlags);
    }

    private static LongConsumer adapt(Sink<Long> sink) {
        if (sink instanceof LongConsumer) {
            return (LongConsumer) sink;
        }
        if (Tripwire.ENABLED) {
            Tripwire.trip(AbstractPipeline.class, "using LongStream.adapt(Sink<Long> s)");
        }
        Objects.requireNonNull(sink);
        return new LongPipeline$$ExternalSyntheticLambda11(sink);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Spliterator.OfLong adapt(Spliterator<Long> s2) {
        if (s2 instanceof Spliterator.OfLong) {
            return (Spliterator.OfLong) s2;
        }
        if (Tripwire.ENABLED) {
            Tripwire.trip(AbstractPipeline.class, "using LongStream.adapt(Spliterator<Long> s)");
        }
        throw new UnsupportedOperationException("LongStream.adapt(Spliterator<Long> s)");
    }

    @Override // java.util.stream.AbstractPipeline
    public final StreamShape getOutputShape() {
        return StreamShape.LONG_VALUE;
    }

    @Override // java.util.stream.AbstractPipeline
    public final <P_IN> Node<Long> evaluateToNode(PipelineHelper<Long> helper, Spliterator<P_IN> spliterator, boolean flattenTree, IntFunction<Long[]> generator) {
        return Nodes.collectLong(helper, spliterator, flattenTree);
    }

    @Override // java.util.stream.AbstractPipeline
    public final <P_IN> Spliterator<Long> wrap(PipelineHelper<Long> ph, Supplier<Spliterator<P_IN>> supplier, boolean isParallel) {
        return new StreamSpliterators.LongWrappingSpliterator(ph, supplier, isParallel);
    }

    @Override // java.util.stream.AbstractPipeline
    /* renamed from: lazySpliterator */
    public final Spliterator<Long> lazySpliterator2(Supplier<? extends Spliterator<Long>> supplier) {
        return new StreamSpliterators.DelegatingSpliterator.OfLong(supplier);
    }

    @Override // java.util.stream.AbstractPipeline
    public final boolean forEachWithCancel(Spliterator<Long> spliterator, Sink<Long> sink) {
        boolean cancelled;
        Spliterator.OfLong spl = adapt(spliterator);
        LongConsumer adaptedSink = adapt(sink);
        do {
            cancelled = sink.cancellationRequested();
            if (cancelled) {
                break;
            }
        } while (spl.tryAdvance(adaptedSink));
        return cancelled;
    }

    @Override // java.util.stream.AbstractPipeline, java.util.stream.PipelineHelper
    public final Node.Builder<Long> makeNodeBuilder(long exactSizeIfKnown, IntFunction<Long[]> generator) {
        return Nodes.longBuilder(exactSizeIfKnown);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Spliterator$OfLong] */
    @Override // java.util.stream.BaseStream, java.util.stream.DoubleStream
    public final Iterator<Long> iterator() {
        return Spliterators.iterator((Spliterator.OfLong) spliterator2());
    }

    @Override // java.util.stream.AbstractPipeline, java.util.stream.BaseStream
    /* renamed from: spliterator */
    public final Spliterator<Long> spliterator2() {
        return adapt((Spliterator<Long>) super.spliterator2());
    }

    @Override // java.util.stream.LongStream
    public final DoubleStream asDoubleStream() {
        return new DoublePipeline.StatelessOp<Long>(this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: java.util.stream.LongPipeline.1
            @Override // java.util.stream.AbstractPipeline
            public Sink<Long> opWrapSink(int flags, Sink<Double> sink) {
                return new Sink.ChainedLong<Double>(sink) { // from class: java.util.stream.LongPipeline.1.1
                    @Override // java.util.stream.Sink.OfLong, java.util.function.LongConsumer
                    public void accept(long t2) {
                        this.downstream.accept(t2);
                    }
                };
            }
        };
    }

    @Override // java.util.stream.LongStream
    public final Stream<Long> boxed() {
        return mapToObj(new LongFunction() { // from class: java.util.stream.LongPipeline$$ExternalSyntheticLambda2
            @Override // java.util.function.LongFunction
            public final Object apply(long j10) {
                return Long.valueOf(j10);
            }
        });
    }

    @Override // java.util.stream.LongStream
    public final LongStream map(final LongUnaryOperator mapper) {
        Objects.requireNonNull(mapper);
        return new StatelessOp<Long>(this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: java.util.stream.LongPipeline.2
            @Override // java.util.stream.AbstractPipeline
            public Sink<Long> opWrapSink(int flags, Sink<Long> sink) {
                return new Sink.ChainedLong<Long>(sink) { // from class: java.util.stream.LongPipeline.2.1
                    @Override // java.util.stream.Sink.OfLong, java.util.function.LongConsumer
                    public void accept(long t2) {
                        this.downstream.accept(mapper.applyAsLong(t2));
                    }
                };
            }
        };
    }

    @Override // java.util.stream.LongStream
    public final <U> Stream<U> mapToObj(final LongFunction<? extends U> mapper) {
        Objects.requireNonNull(mapper);
        return new ReferencePipeline.StatelessOp<Long, U>(this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: java.util.stream.LongPipeline.3
            @Override // java.util.stream.AbstractPipeline
            public Sink<Long> opWrapSink(int flags, Sink<U> sink) {
                return new Sink.ChainedLong<U>(sink) { // from class: java.util.stream.LongPipeline.3.1
                    @Override // java.util.stream.Sink.OfLong, java.util.function.LongConsumer
                    public void accept(long t2) {
                        this.downstream.accept(mapper.apply(t2));
                    }
                };
            }
        };
    }

    @Override // java.util.stream.LongStream
    public final IntStream mapToInt(final LongToIntFunction mapper) {
        Objects.requireNonNull(mapper);
        return new IntPipeline.StatelessOp<Long>(this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: java.util.stream.LongPipeline.4
            @Override // java.util.stream.AbstractPipeline
            public Sink<Long> opWrapSink(int flags, Sink<Integer> sink) {
                return new Sink.ChainedLong<Integer>(sink) { // from class: java.util.stream.LongPipeline.4.1
                    @Override // java.util.stream.Sink.OfLong, java.util.function.LongConsumer
                    public void accept(long t2) {
                        this.downstream.accept(mapper.applyAsInt(t2));
                    }
                };
            }
        };
    }

    @Override // java.util.stream.LongStream
    public final DoubleStream mapToDouble(final LongToDoubleFunction mapper) {
        Objects.requireNonNull(mapper);
        return new DoublePipeline.StatelessOp<Long>(this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: java.util.stream.LongPipeline.5
            @Override // java.util.stream.AbstractPipeline
            public Sink<Long> opWrapSink(int flags, Sink<Double> sink) {
                return new Sink.ChainedLong<Double>(sink) { // from class: java.util.stream.LongPipeline.5.1
                    @Override // java.util.stream.Sink.OfLong, java.util.function.LongConsumer
                    public void accept(long t2) {
                        this.downstream.accept(mapper.applyAsDouble(t2));
                    }
                };
            }
        };
    }

    @Override // java.util.stream.LongStream
    public final LongStream flatMap(final LongFunction<? extends LongStream> mapper) {
        return new StatelessOp<Long>(this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED) { // from class: java.util.stream.LongPipeline.6

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
            /* renamed from: java.util.stream.LongPipeline$6$1, reason: invalid class name */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
            public class AnonymousClass1 extends Sink.ChainedLong<Long> {
                AnonymousClass1(Sink sink) {
                    super(sink);
                }

                @Override // java.util.stream.Sink.ChainedLong, java.util.stream.Sink
                public void begin(long size) {
                    this.downstream.begin(-1L);
                }

                @Override // java.util.stream.Sink.OfLong, java.util.function.LongConsumer
                public void accept(long t2) {
                    LongStream result = (LongStream) mapper.apply(t2);
                    if (result != null) {
                        try {
                            result.sequential().forEach(new LongConsumer() { // from class: java.util.stream.LongPipeline$6$1$$ExternalSyntheticLambda0
                                @Override // java.util.function.LongConsumer
                                public final void accept(long j10) {
                                    LongPipeline.AnonymousClass6.AnonymousClass1.this.lambda$accept$0(j10);
                                }
                            });
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

                /* JADX INFO: Access modifiers changed from: private */
                public /* synthetic */ void lambda$accept$0(long i10) {
                    this.downstream.accept(i10);
                }
            }

            @Override // java.util.stream.AbstractPipeline
            public Sink<Long> opWrapSink(int flags, Sink<Long> sink) {
                return new AnonymousClass1(sink);
            }
        };
    }

    @Override // java.util.stream.BaseStream
    public LongStream unordered() {
        if (!isOrdered()) {
            return this;
        }
        return new StatelessOp<Long>(this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_ORDERED) { // from class: java.util.stream.LongPipeline.7
            @Override // java.util.stream.AbstractPipeline
            public Sink<Long> opWrapSink(int flags, Sink<Long> sink) {
                return sink;
            }
        };
    }

    @Override // java.util.stream.LongStream
    public final LongStream filter(final LongPredicate predicate) {
        Objects.requireNonNull(predicate);
        return new StatelessOp<Long>(this, StreamShape.LONG_VALUE, StreamOpFlag.NOT_SIZED) { // from class: java.util.stream.LongPipeline.8
            @Override // java.util.stream.AbstractPipeline
            public Sink<Long> opWrapSink(int flags, Sink<Long> sink) {
                return new Sink.ChainedLong<Long>(sink) { // from class: java.util.stream.LongPipeline.8.1
                    @Override // java.util.stream.Sink.ChainedLong, java.util.stream.Sink
                    public void begin(long size) {
                        this.downstream.begin(-1L);
                    }

                    @Override // java.util.stream.Sink.OfLong, java.util.function.LongConsumer
                    public void accept(long t2) {
                        if (predicate.test(t2)) {
                            this.downstream.accept(t2);
                        }
                    }
                };
            }
        };
    }

    @Override // java.util.stream.LongStream
    public final LongStream peek(final LongConsumer action) {
        Objects.requireNonNull(action);
        return new StatelessOp<Long>(this, StreamShape.LONG_VALUE, 0) { // from class: java.util.stream.LongPipeline.9
            @Override // java.util.stream.AbstractPipeline
            public Sink<Long> opWrapSink(int flags, Sink<Long> sink) {
                return new Sink.ChainedLong<Long>(sink) { // from class: java.util.stream.LongPipeline.9.1
                    @Override // java.util.stream.Sink.OfLong, java.util.function.LongConsumer
                    public void accept(long t2) {
                        action.accept(t2);
                        this.downstream.accept(t2);
                    }
                };
            }
        };
    }

    @Override // java.util.stream.LongStream
    public final LongStream limit(long maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException(Long.toString(maxSize));
        }
        return SliceOps.makeLong(this, 0L, maxSize);
    }

    @Override // java.util.stream.LongStream
    public final LongStream skip(long n10) {
        if (n10 < 0) {
            throw new IllegalArgumentException(Long.toString(n10));
        }
        if (n10 == 0) {
            return this;
        }
        return SliceOps.makeLong(this, n10, -1L);
    }

    @Override // java.util.stream.LongStream
    public final LongStream sorted() {
        return SortedOps.makeLong(this);
    }

    @Override // java.util.stream.LongStream
    public final LongStream distinct() {
        return boxed().distinct().mapToLong(new ToLongFunction() { // from class: java.util.stream.LongPipeline$$ExternalSyntheticLambda12
            @Override // java.util.function.ToLongFunction
            public final long applyAsLong(Object obj) {
                long longValue;
                longValue = ((Long) obj).longValue();
                return longValue;
            }
        });
    }

    @Override // java.util.stream.LongStream
    public void forEach(LongConsumer action) {
        evaluate(ForEachOps.makeLong(action, false));
    }

    @Override // java.util.stream.LongStream
    public void forEachOrdered(LongConsumer action) {
        evaluate(ForEachOps.makeLong(action, true));
    }

    @Override // java.util.stream.LongStream
    public final long sum() {
        return reduce(0L, new LongBinaryOperator() { // from class: java.util.stream.LongPipeline$$ExternalSyntheticLambda7
            @Override // java.util.function.LongBinaryOperator
            public final long applyAsLong(long j10, long j11) {
                return Long.sum(j10, j11);
            }
        });
    }

    @Override // java.util.stream.LongStream
    public final OptionalLong min() {
        return reduce(new LongBinaryOperator() { // from class: java.util.stream.LongPipeline$$ExternalSyntheticLambda10
            @Override // java.util.function.LongBinaryOperator
            public final long applyAsLong(long j10, long j11) {
                return Math.min(j10, j11);
            }
        });
    }

    @Override // java.util.stream.LongStream
    public final OptionalLong max() {
        return reduce(new LongBinaryOperator() { // from class: java.util.stream.LongPipeline$$ExternalSyntheticLambda1
            @Override // java.util.function.LongBinaryOperator
            public final long applyAsLong(long j10, long j11) {
                return Math.max(j10, j11);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long[] lambda$average$1() {
        return new long[2];
    }

    @Override // java.util.stream.LongStream
    public final OptionalDouble average() {
        long[] avg = (long[]) collect(new Supplier() { // from class: java.util.stream.LongPipeline$$ExternalSyntheticLambda4
            @Override // java.util.function.Supplier
            public final Object get() {
                return LongPipeline.lambda$average$1();
            }
        }, new ObjLongConsumer() { // from class: java.util.stream.LongPipeline$$ExternalSyntheticLambda5
            @Override // java.util.function.ObjLongConsumer
            public final void accept(Object obj, long j10) {
                LongPipeline.lambda$average$2((long[]) obj, j10);
            }
        }, new BiConsumer() { // from class: java.util.stream.LongPipeline$$ExternalSyntheticLambda6
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                LongPipeline.lambda$average$3((long[]) obj, (long[]) obj2);
            }
        });
        if (avg[0] > 0) {
            return OptionalDouble.of(avg[1] / avg[0]);
        }
        return OptionalDouble.empty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$average$2(long[] ll, long i10) {
        ll[0] = ll[0] + 1;
        ll[1] = ll[1] + i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$average$3(long[] ll, long[] rr) {
        ll[0] = ll[0] + rr[0];
        ll[1] = ll[1] + rr[1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long lambda$count$4(long e2) {
        return 1L;
    }

    @Override // java.util.stream.LongStream
    public final long count() {
        return map(new LongUnaryOperator() { // from class: java.util.stream.LongPipeline$$ExternalSyntheticLambda0
            @Override // java.util.function.LongUnaryOperator
            public final long applyAsLong(long j10) {
                return LongPipeline.lambda$count$4(j10);
            }
        }).sum();
    }

    @Override // java.util.stream.LongStream
    public final LongSummaryStatistics summaryStatistics() {
        return (LongSummaryStatistics) collect(new Collectors$$ExternalSyntheticLambda5(), new ObjLongConsumer() { // from class: java.util.stream.LongPipeline$$ExternalSyntheticLambda8
            @Override // java.util.function.ObjLongConsumer
            public final void accept(Object obj, long j10) {
                ((LongSummaryStatistics) obj).accept(j10);
            }
        }, new BiConsumer() { // from class: java.util.stream.LongPipeline$$ExternalSyntheticLambda9
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((LongSummaryStatistics) obj).combine((LongSummaryStatistics) obj2);
            }
        });
    }

    @Override // java.util.stream.LongStream
    public final long reduce(long identity, LongBinaryOperator op) {
        return ((Long) evaluate(ReduceOps.makeLong(identity, op))).longValue();
    }

    @Override // java.util.stream.LongStream
    public final OptionalLong reduce(LongBinaryOperator op) {
        return (OptionalLong) evaluate(ReduceOps.makeLong(op));
    }

    @Override // java.util.stream.LongStream
    public final <R> R collect(Supplier<R> supplier, ObjLongConsumer<R> objLongConsumer, final BiConsumer<R, R> biConsumer) {
        return (R) evaluate(ReduceOps.makeLong(supplier, objLongConsumer, new BinaryOperator() { // from class: java.util.stream.LongPipeline$$ExternalSyntheticLambda13
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return LongPipeline.lambda$collect$5(BiConsumer.this, obj, obj2);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$collect$5(BiConsumer combiner, Object left, Object right) {
        combiner.accept(left, right);
        return left;
    }

    @Override // java.util.stream.LongStream
    public final boolean anyMatch(LongPredicate predicate) {
        return ((Boolean) evaluate(MatchOps.makeLong(predicate, MatchOps.MatchKind.ANY))).booleanValue();
    }

    @Override // java.util.stream.LongStream
    public final boolean allMatch(LongPredicate predicate) {
        return ((Boolean) evaluate(MatchOps.makeLong(predicate, MatchOps.MatchKind.ALL))).booleanValue();
    }

    @Override // java.util.stream.LongStream
    public final boolean noneMatch(LongPredicate predicate) {
        return ((Boolean) evaluate(MatchOps.makeLong(predicate, MatchOps.MatchKind.NONE))).booleanValue();
    }

    @Override // java.util.stream.LongStream
    public final OptionalLong findFirst() {
        return (OptionalLong) evaluate(FindOps.makeLong(true));
    }

    @Override // java.util.stream.LongStream
    public final OptionalLong findAny() {
        return (OptionalLong) evaluate(FindOps.makeLong(false));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Long[] lambda$toArray$6(int x$0) {
        return new Long[x$0];
    }

    @Override // java.util.stream.LongStream
    public final long[] toArray() {
        return Nodes.flattenLong((Node.OfLong) evaluateToArrayNode(new IntFunction() { // from class: java.util.stream.LongPipeline$$ExternalSyntheticLambda3
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                return LongPipeline.lambda$toArray$6(i10);
            }
        })).asPrimitiveArray();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Head<E_IN> extends LongPipeline<E_IN> {
        @Override // java.util.stream.LongPipeline, java.util.stream.AbstractPipeline, java.util.stream.BaseStream
        public /* bridge */ /* synthetic */ LongStream parallel() {
            return (LongStream) super.parallel();
        }

        @Override // java.util.stream.LongPipeline, java.util.stream.AbstractPipeline, java.util.stream.BaseStream
        public /* bridge */ /* synthetic */ LongStream sequential() {
            return (LongStream) super.sequential();
        }

        public Head(Supplier<? extends Spliterator<Long>> source, int sourceFlags, boolean parallel) {
            super(source, sourceFlags, parallel);
        }

        public Head(Spliterator<Long> source, int sourceFlags, boolean parallel) {
            super(source, sourceFlags, parallel);
        }

        @Override // java.util.stream.AbstractPipeline
        public final boolean opIsStateful() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.stream.AbstractPipeline
        public final Sink<E_IN> opWrapSink(int flags, Sink<Long> sink) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.stream.LongPipeline, java.util.stream.LongStream
        public void forEach(LongConsumer action) {
            if (!isParallel()) {
                LongPipeline.adapt(sourceStageSpliterator()).forEachRemaining(action);
            } else {
                super.forEach(action);
            }
        }

        @Override // java.util.stream.LongPipeline, java.util.stream.LongStream
        public void forEachOrdered(LongConsumer action) {
            if (!isParallel()) {
                LongPipeline.adapt(sourceStageSpliterator()).forEachRemaining(action);
            } else {
                super.forEachOrdered(action);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class StatelessOp<E_IN> extends LongPipeline<E_IN> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        @Override // java.util.stream.LongPipeline, java.util.stream.AbstractPipeline, java.util.stream.BaseStream
        public /* bridge */ /* synthetic */ LongStream parallel() {
            return (LongStream) super.parallel();
        }

        @Override // java.util.stream.LongPipeline, java.util.stream.AbstractPipeline, java.util.stream.BaseStream
        public /* bridge */ /* synthetic */ LongStream sequential() {
            return (LongStream) super.sequential();
        }

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
    public static abstract class StatefulOp<E_IN> extends LongPipeline<E_IN> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        @Override // java.util.stream.AbstractPipeline
        public abstract <P_IN> Node<Long> opEvaluateParallel(PipelineHelper<Long> pipelineHelper, Spliterator<P_IN> spliterator, IntFunction<Long[]> intFunction);

        @Override // java.util.stream.LongPipeline, java.util.stream.AbstractPipeline, java.util.stream.BaseStream
        public /* bridge */ /* synthetic */ LongStream parallel() {
            return (LongStream) super.parallel();
        }

        @Override // java.util.stream.LongPipeline, java.util.stream.AbstractPipeline, java.util.stream.BaseStream
        public /* bridge */ /* synthetic */ LongStream sequential() {
            return (LongStream) super.sequential();
        }

        public StatefulOp(AbstractPipeline<?, E_IN, ?> upstream, StreamShape inputShape, int opFlags) {
            super(upstream, opFlags);
        }

        @Override // java.util.stream.AbstractPipeline
        public final boolean opIsStateful() {
            return true;
        }
    }
}
