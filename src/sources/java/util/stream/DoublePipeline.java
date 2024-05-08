package java.util.stream;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.DoubleSummaryStatistics;
import java.util.Iterator;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
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
public abstract class DoublePipeline<E_IN> extends AbstractPipeline<E_IN, Double, DoubleStream> implements DoubleStream {
    @Override // java.util.stream.AbstractPipeline, java.util.stream.BaseStream
    public /* bridge */ /* synthetic */ DoubleStream parallel() {
        return (DoubleStream) super.parallel();
    }

    @Override // java.util.stream.AbstractPipeline, java.util.stream.BaseStream
    public /* bridge */ /* synthetic */ DoubleStream sequential() {
        return (DoubleStream) super.sequential();
    }

    DoublePipeline(Supplier<? extends Spliterator<Double>> source, int sourceFlags, boolean parallel) {
        super(source, sourceFlags, parallel);
    }

    DoublePipeline(Spliterator<Double> source, int sourceFlags, boolean parallel) {
        super(source, sourceFlags, parallel);
    }

    DoublePipeline(AbstractPipeline<?, E_IN, ?> upstream, int opFlags) {
        super(upstream, opFlags);
    }

    private static DoubleConsumer adapt(Sink<Double> sink) {
        if (sink instanceof DoubleConsumer) {
            return (DoubleConsumer) sink;
        }
        if (Tripwire.ENABLED) {
            Tripwire.trip(AbstractPipeline.class, "using DoubleStream.adapt(Sink<Double> s)");
        }
        Objects.requireNonNull(sink);
        return new DoublePipeline$$ExternalSyntheticLambda5(sink);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Spliterator.OfDouble adapt(Spliterator<Double> s2) {
        if (s2 instanceof Spliterator.OfDouble) {
            return (Spliterator.OfDouble) s2;
        }
        if (Tripwire.ENABLED) {
            Tripwire.trip(AbstractPipeline.class, "using DoubleStream.adapt(Spliterator<Double> s)");
        }
        throw new UnsupportedOperationException("DoubleStream.adapt(Spliterator<Double> s)");
    }

    @Override // java.util.stream.AbstractPipeline
    public final StreamShape getOutputShape() {
        return StreamShape.DOUBLE_VALUE;
    }

    @Override // java.util.stream.AbstractPipeline
    public final <P_IN> Node<Double> evaluateToNode(PipelineHelper<Double> helper, Spliterator<P_IN> spliterator, boolean flattenTree, IntFunction<Double[]> generator) {
        return Nodes.collectDouble(helper, spliterator, flattenTree);
    }

    @Override // java.util.stream.AbstractPipeline
    public final <P_IN> Spliterator<Double> wrap(PipelineHelper<Double> ph, Supplier<Spliterator<P_IN>> supplier, boolean isParallel) {
        return new StreamSpliterators.DoubleWrappingSpliterator(ph, supplier, isParallel);
    }

    @Override // java.util.stream.AbstractPipeline
    /* renamed from: lazySpliterator, reason: merged with bridge method [inline-methods] */
    public final Spliterator<Double> lazySpliterator2(Supplier<? extends Spliterator<Double>> supplier) {
        return new StreamSpliterators.DelegatingSpliterator.OfDouble(supplier);
    }

    @Override // java.util.stream.AbstractPipeline
    public final boolean forEachWithCancel(Spliterator<Double> spliterator, Sink<Double> sink) {
        boolean cancelled;
        Spliterator.OfDouble spl = adapt(spliterator);
        DoubleConsumer adaptedSink = adapt(sink);
        do {
            cancelled = sink.cancellationRequested();
            if (cancelled) {
                break;
            }
        } while (spl.tryAdvance(adaptedSink));
        return cancelled;
    }

    @Override // java.util.stream.AbstractPipeline, java.util.stream.PipelineHelper
    public final Node.Builder<Double> makeNodeBuilder(long exactSizeIfKnown, IntFunction<Double[]> generator) {
        return Nodes.doubleBuilder(exactSizeIfKnown);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Spliterator$OfDouble] */
    @Override // java.util.stream.BaseStream, java.util.stream.DoubleStream
    public final Iterator<Double> iterator() {
        return Spliterators.iterator((Spliterator.OfDouble) spliterator2());
    }

    @Override // java.util.stream.AbstractPipeline, java.util.stream.BaseStream
    /* renamed from: spliterator */
    public final Spliterator<Double> spliterator2() {
        return adapt((Spliterator<Double>) super.spliterator2());
    }

    @Override // java.util.stream.DoubleStream
    public final Stream<Double> boxed() {
        return mapToObj(new DoubleFunction() { // from class: java.util.stream.DoublePipeline$$ExternalSyntheticLambda6
            @Override // java.util.function.DoubleFunction
            public final Object apply(double d10) {
                return Double.valueOf(d10);
            }
        });
    }

    @Override // java.util.stream.DoubleStream
    public final DoubleStream map(final DoubleUnaryOperator mapper) {
        Objects.requireNonNull(mapper);
        return new StatelessOp<Double>(this, StreamShape.DOUBLE_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: java.util.stream.DoublePipeline.1
            @Override // java.util.stream.AbstractPipeline
            public Sink<Double> opWrapSink(int flags, Sink<Double> sink) {
                return new Sink.ChainedDouble<Double>(sink) { // from class: java.util.stream.DoublePipeline.1.1
                    @Override // java.util.stream.Sink.OfDouble, java.util.stream.Sink, java.util.function.DoubleConsumer
                    public void accept(double t2) {
                        this.downstream.accept(mapper.applyAsDouble(t2));
                    }
                };
            }
        };
    }

    @Override // java.util.stream.DoubleStream
    public final <U> Stream<U> mapToObj(final DoubleFunction<? extends U> mapper) {
        Objects.requireNonNull(mapper);
        return new ReferencePipeline.StatelessOp<Double, U>(this, StreamShape.DOUBLE_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: java.util.stream.DoublePipeline.2
            @Override // java.util.stream.AbstractPipeline
            public Sink<Double> opWrapSink(int flags, Sink<U> sink) {
                return new Sink.ChainedDouble<U>(sink) { // from class: java.util.stream.DoublePipeline.2.1
                    @Override // java.util.stream.Sink.OfDouble, java.util.stream.Sink, java.util.function.DoubleConsumer
                    public void accept(double t2) {
                        this.downstream.accept(mapper.apply(t2));
                    }
                };
            }
        };
    }

    @Override // java.util.stream.DoubleStream
    public final IntStream mapToInt(final DoubleToIntFunction mapper) {
        Objects.requireNonNull(mapper);
        return new IntPipeline.StatelessOp<Double>(this, StreamShape.DOUBLE_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: java.util.stream.DoublePipeline.3
            @Override // java.util.stream.AbstractPipeline
            public Sink<Double> opWrapSink(int flags, Sink<Integer> sink) {
                return new Sink.ChainedDouble<Integer>(sink) { // from class: java.util.stream.DoublePipeline.3.1
                    @Override // java.util.stream.Sink.OfDouble, java.util.stream.Sink, java.util.function.DoubleConsumer
                    public void accept(double t2) {
                        this.downstream.accept(mapper.applyAsInt(t2));
                    }
                };
            }
        };
    }

    @Override // java.util.stream.DoubleStream
    public final LongStream mapToLong(final DoubleToLongFunction mapper) {
        Objects.requireNonNull(mapper);
        return new LongPipeline.StatelessOp<Double>(this, StreamShape.DOUBLE_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT) { // from class: java.util.stream.DoublePipeline.4
            @Override // java.util.stream.AbstractPipeline
            public Sink<Double> opWrapSink(int flags, Sink<Long> sink) {
                return new Sink.ChainedDouble<Long>(sink) { // from class: java.util.stream.DoublePipeline.4.1
                    @Override // java.util.stream.Sink.OfDouble, java.util.stream.Sink, java.util.function.DoubleConsumer
                    public void accept(double t2) {
                        this.downstream.accept(mapper.applyAsLong(t2));
                    }
                };
            }
        };
    }

    @Override // java.util.stream.DoubleStream
    public final DoubleStream flatMap(final DoubleFunction<? extends DoubleStream> mapper) {
        return new StatelessOp<Double>(this, StreamShape.DOUBLE_VALUE, StreamOpFlag.NOT_SORTED | StreamOpFlag.NOT_DISTINCT | StreamOpFlag.NOT_SIZED) { // from class: java.util.stream.DoublePipeline.5

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
            /* renamed from: java.util.stream.DoublePipeline$5$1, reason: invalid class name */
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
            public class AnonymousClass1 extends Sink.ChainedDouble<Double> {
                AnonymousClass1(Sink sink) {
                    super(sink);
                }

                @Override // java.util.stream.Sink.ChainedDouble, java.util.stream.Sink
                public void begin(long size) {
                    this.downstream.begin(-1L);
                }

                @Override // java.util.stream.Sink.OfDouble, java.util.stream.Sink, java.util.function.DoubleConsumer
                public void accept(double t2) {
                    DoubleStream result = (DoubleStream) mapper.apply(t2);
                    if (result != null) {
                        try {
                            result.sequential().forEach(new DoubleConsumer() { // from class: java.util.stream.DoublePipeline$5$1$$ExternalSyntheticLambda0
                                @Override // java.util.function.DoubleConsumer
                                public final void accept(double d10) {
                                    DoublePipeline.AnonymousClass5.AnonymousClass1.this.lambda$accept$0(d10);
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
                public /* synthetic */ void lambda$accept$0(double i10) {
                    this.downstream.accept(i10);
                }
            }

            @Override // java.util.stream.AbstractPipeline
            public Sink<Double> opWrapSink(int flags, Sink<Double> sink) {
                return new AnonymousClass1(sink);
            }
        };
    }

    @Override // java.util.stream.BaseStream
    public DoubleStream unordered() {
        if (!isOrdered()) {
            return this;
        }
        return new StatelessOp<Double>(this, StreamShape.DOUBLE_VALUE, StreamOpFlag.NOT_ORDERED) { // from class: java.util.stream.DoublePipeline.6
            @Override // java.util.stream.AbstractPipeline
            public Sink<Double> opWrapSink(int flags, Sink<Double> sink) {
                return sink;
            }
        };
    }

    @Override // java.util.stream.DoubleStream
    public final DoubleStream filter(final DoublePredicate predicate) {
        Objects.requireNonNull(predicate);
        return new StatelessOp<Double>(this, StreamShape.DOUBLE_VALUE, StreamOpFlag.NOT_SIZED) { // from class: java.util.stream.DoublePipeline.7
            @Override // java.util.stream.AbstractPipeline
            public Sink<Double> opWrapSink(int flags, Sink<Double> sink) {
                return new Sink.ChainedDouble<Double>(sink) { // from class: java.util.stream.DoublePipeline.7.1
                    @Override // java.util.stream.Sink.ChainedDouble, java.util.stream.Sink
                    public void begin(long size) {
                        this.downstream.begin(-1L);
                    }

                    @Override // java.util.stream.Sink.OfDouble, java.util.stream.Sink, java.util.function.DoubleConsumer
                    public void accept(double t2) {
                        if (predicate.test(t2)) {
                            this.downstream.accept(t2);
                        }
                    }
                };
            }
        };
    }

    @Override // java.util.stream.DoubleStream
    public final DoubleStream peek(final DoubleConsumer action) {
        Objects.requireNonNull(action);
        return new StatelessOp<Double>(this, StreamShape.DOUBLE_VALUE, 0) { // from class: java.util.stream.DoublePipeline.8
            @Override // java.util.stream.AbstractPipeline
            public Sink<Double> opWrapSink(int flags, Sink<Double> sink) {
                return new Sink.ChainedDouble<Double>(sink) { // from class: java.util.stream.DoublePipeline.8.1
                    @Override // java.util.stream.Sink.OfDouble, java.util.stream.Sink, java.util.function.DoubleConsumer
                    public void accept(double t2) {
                        action.accept(t2);
                        this.downstream.accept(t2);
                    }
                };
            }
        };
    }

    @Override // java.util.stream.DoubleStream
    public final DoubleStream limit(long maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException(Long.toString(maxSize));
        }
        return SliceOps.makeDouble(this, 0L, maxSize);
    }

    @Override // java.util.stream.DoubleStream
    public final DoubleStream skip(long n10) {
        if (n10 < 0) {
            throw new IllegalArgumentException(Long.toString(n10));
        }
        if (n10 == 0) {
            return this;
        }
        return SliceOps.makeDouble(this, n10, -1L);
    }

    @Override // java.util.stream.DoubleStream
    public final DoubleStream sorted() {
        return SortedOps.makeDouble(this);
    }

    @Override // java.util.stream.DoubleStream
    public final DoubleStream distinct() {
        return boxed().distinct().mapToDouble(new ToDoubleFunction() { // from class: java.util.stream.DoublePipeline$$ExternalSyntheticLambda3
            @Override // java.util.function.ToDoubleFunction
            public final double applyAsDouble(Object obj) {
                double doubleValue;
                doubleValue = ((Double) obj).doubleValue();
                return doubleValue;
            }
        });
    }

    @Override // java.util.stream.DoubleStream
    public void forEach(DoubleConsumer consumer) {
        evaluate(ForEachOps.makeDouble(consumer, false));
    }

    @Override // java.util.stream.DoubleStream
    public void forEachOrdered(DoubleConsumer consumer) {
        evaluate(ForEachOps.makeDouble(consumer, true));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ double[] lambda$sum$1() {
        return new double[3];
    }

    @Override // java.util.stream.DoubleStream
    public final double sum() {
        double[] summation = (double[]) collect(new Supplier() { // from class: java.util.stream.DoublePipeline$$ExternalSyntheticLambda9
            @Override // java.util.function.Supplier
            public final Object get() {
                return DoublePipeline.lambda$sum$1();
            }
        }, new ObjDoubleConsumer() { // from class: java.util.stream.DoublePipeline$$ExternalSyntheticLambda10
            @Override // java.util.function.ObjDoubleConsumer
            public final void accept(Object obj, double d10) {
                DoublePipeline.lambda$sum$2((double[]) obj, d10);
            }
        }, new BiConsumer() { // from class: java.util.stream.DoublePipeline$$ExternalSyntheticLambda11
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                DoublePipeline.lambda$sum$3((double[]) obj, (double[]) obj2);
            }
        });
        return Collectors.computeFinalSum(summation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$sum$2(double[] ll, double d10) {
        Collectors.sumWithCompensation(ll, d10);
        ll[2] = ll[2] + d10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$sum$3(double[] ll, double[] rr) {
        Collectors.sumWithCompensation(ll, rr[0]);
        Collectors.sumWithCompensation(ll, rr[1]);
        ll[2] = ll[2] + rr[2];
    }

    @Override // java.util.stream.DoubleStream
    public final OptionalDouble min() {
        return reduce(new DoubleBinaryOperator() { // from class: java.util.stream.DoublePipeline$$ExternalSyntheticLambda2
            @Override // java.util.function.DoubleBinaryOperator
            public final double applyAsDouble(double d10, double d11) {
                return Math.min(d10, d11);
            }
        });
    }

    @Override // java.util.stream.DoubleStream
    public final OptionalDouble max() {
        return reduce(new DoubleBinaryOperator() { // from class: java.util.stream.DoublePipeline$$ExternalSyntheticLambda4
            @Override // java.util.function.DoubleBinaryOperator
            public final double applyAsDouble(double d10, double d11) {
                return Math.max(d10, d11);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ double[] lambda$average$4() {
        return new double[4];
    }

    @Override // java.util.stream.DoubleStream
    public final OptionalDouble average() {
        double[] avg = (double[]) collect(new Supplier() { // from class: java.util.stream.DoublePipeline$$ExternalSyntheticLambda13
            @Override // java.util.function.Supplier
            public final Object get() {
                return DoublePipeline.lambda$average$4();
            }
        }, new ObjDoubleConsumer() { // from class: java.util.stream.DoublePipeline$$ExternalSyntheticLambda14
            @Override // java.util.function.ObjDoubleConsumer
            public final void accept(Object obj, double d10) {
                DoublePipeline.lambda$average$5((double[]) obj, d10);
            }
        }, new BiConsumer() { // from class: java.util.stream.DoublePipeline$$ExternalSyntheticLambda15
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                DoublePipeline.lambda$average$6((double[]) obj, (double[]) obj2);
            }
        });
        if (avg[2] > ShadowDrawableWrapper.COS_45) {
            return OptionalDouble.of(Collectors.computeFinalSum(avg) / avg[2]);
        }
        return OptionalDouble.empty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$average$5(double[] ll, double d10) {
        ll[2] = ll[2] + 1.0d;
        Collectors.sumWithCompensation(ll, d10);
        ll[3] = ll[3] + d10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$average$6(double[] ll, double[] rr) {
        Collectors.sumWithCompensation(ll, rr[0]);
        Collectors.sumWithCompensation(ll, rr[1]);
        ll[2] = ll[2] + rr[2];
        ll[3] = ll[3] + rr[3];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ long lambda$count$7(double e2) {
        return 1L;
    }

    @Override // java.util.stream.DoubleStream
    public final long count() {
        return mapToLong(new DoubleToLongFunction() { // from class: java.util.stream.DoublePipeline$$ExternalSyntheticLambda12
            @Override // java.util.function.DoubleToLongFunction
            public final long applyAsLong(double d10) {
                return DoublePipeline.lambda$count$7(d10);
            }
        }).sum();
    }

    @Override // java.util.stream.DoubleStream
    public final DoubleSummaryStatistics summaryStatistics() {
        return (DoubleSummaryStatistics) collect(new Collectors$$ExternalSyntheticLambda2(), new ObjDoubleConsumer() { // from class: java.util.stream.DoublePipeline$$ExternalSyntheticLambda7
            @Override // java.util.function.ObjDoubleConsumer
            public final void accept(Object obj, double d10) {
                ((DoubleSummaryStatistics) obj).accept(d10);
            }
        }, new BiConsumer() { // from class: java.util.stream.DoublePipeline$$ExternalSyntheticLambda8
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((DoubleSummaryStatistics) obj).combine((DoubleSummaryStatistics) obj2);
            }
        });
    }

    @Override // java.util.stream.DoubleStream
    public final double reduce(double identity, DoubleBinaryOperator op) {
        return ((Double) evaluate(ReduceOps.makeDouble(identity, op))).doubleValue();
    }

    @Override // java.util.stream.DoubleStream
    public final OptionalDouble reduce(DoubleBinaryOperator op) {
        return (OptionalDouble) evaluate(ReduceOps.makeDouble(op));
    }

    @Override // java.util.stream.DoubleStream
    public final <R> R collect(Supplier<R> supplier, ObjDoubleConsumer<R> objDoubleConsumer, final BiConsumer<R, R> biConsumer) {
        return (R) evaluate(ReduceOps.makeDouble(supplier, objDoubleConsumer, new BinaryOperator() { // from class: java.util.stream.DoublePipeline$$ExternalSyntheticLambda1
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return DoublePipeline.lambda$collect$8(BiConsumer.this, obj, obj2);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$collect$8(BiConsumer combiner, Object left, Object right) {
        combiner.accept(left, right);
        return left;
    }

    @Override // java.util.stream.DoubleStream
    public final boolean anyMatch(DoublePredicate predicate) {
        return ((Boolean) evaluate(MatchOps.makeDouble(predicate, MatchOps.MatchKind.ANY))).booleanValue();
    }

    @Override // java.util.stream.DoubleStream
    public final boolean allMatch(DoublePredicate predicate) {
        return ((Boolean) evaluate(MatchOps.makeDouble(predicate, MatchOps.MatchKind.ALL))).booleanValue();
    }

    @Override // java.util.stream.DoubleStream
    public final boolean noneMatch(DoublePredicate predicate) {
        return ((Boolean) evaluate(MatchOps.makeDouble(predicate, MatchOps.MatchKind.NONE))).booleanValue();
    }

    @Override // java.util.stream.DoubleStream
    public final OptionalDouble findFirst() {
        return (OptionalDouble) evaluate(FindOps.makeDouble(true));
    }

    @Override // java.util.stream.DoubleStream
    public final OptionalDouble findAny() {
        return (OptionalDouble) evaluate(FindOps.makeDouble(false));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Double[] lambda$toArray$9(int x$0) {
        return new Double[x$0];
    }

    @Override // java.util.stream.DoubleStream
    public final double[] toArray() {
        return Nodes.flattenDouble((Node.OfDouble) evaluateToArrayNode(new IntFunction() { // from class: java.util.stream.DoublePipeline$$ExternalSyntheticLambda0
            @Override // java.util.function.IntFunction
            public final Object apply(int i10) {
                return DoublePipeline.lambda$toArray$9(i10);
            }
        })).asPrimitiveArray();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Head<E_IN> extends DoublePipeline<E_IN> {
        @Override // java.util.stream.DoublePipeline, java.util.stream.AbstractPipeline, java.util.stream.BaseStream
        public /* bridge */ /* synthetic */ DoubleStream parallel() {
            return (DoubleStream) super.parallel();
        }

        @Override // java.util.stream.DoublePipeline, java.util.stream.AbstractPipeline, java.util.stream.BaseStream
        public /* bridge */ /* synthetic */ DoubleStream sequential() {
            return (DoubleStream) super.sequential();
        }

        public Head(Supplier<? extends Spliterator<Double>> source, int sourceFlags, boolean parallel) {
            super(source, sourceFlags, parallel);
        }

        public Head(Spliterator<Double> source, int sourceFlags, boolean parallel) {
            super(source, sourceFlags, parallel);
        }

        @Override // java.util.stream.AbstractPipeline
        public final boolean opIsStateful() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.stream.AbstractPipeline
        public final Sink<E_IN> opWrapSink(int flags, Sink<Double> sink) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.stream.DoublePipeline, java.util.stream.DoubleStream
        public void forEach(DoubleConsumer consumer) {
            if (!isParallel()) {
                DoublePipeline.adapt(sourceStageSpliterator()).forEachRemaining(consumer);
            } else {
                super.forEach(consumer);
            }
        }

        @Override // java.util.stream.DoublePipeline, java.util.stream.DoubleStream
        public void forEachOrdered(DoubleConsumer consumer) {
            if (!isParallel()) {
                DoublePipeline.adapt(sourceStageSpliterator()).forEachRemaining(consumer);
            } else {
                super.forEachOrdered(consumer);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class StatelessOp<E_IN> extends DoublePipeline<E_IN> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        @Override // java.util.stream.DoublePipeline, java.util.stream.AbstractPipeline, java.util.stream.BaseStream
        public /* bridge */ /* synthetic */ DoubleStream parallel() {
            return (DoubleStream) super.parallel();
        }

        @Override // java.util.stream.DoublePipeline, java.util.stream.AbstractPipeline, java.util.stream.BaseStream
        public /* bridge */ /* synthetic */ DoubleStream sequential() {
            return (DoubleStream) super.sequential();
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
    public static abstract class StatefulOp<E_IN> extends DoublePipeline<E_IN> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        @Override // java.util.stream.AbstractPipeline
        public abstract <P_IN> Node<Double> opEvaluateParallel(PipelineHelper<Double> pipelineHelper, Spliterator<P_IN> spliterator, IntFunction<Double[]> intFunction);

        @Override // java.util.stream.DoublePipeline, java.util.stream.AbstractPipeline, java.util.stream.BaseStream
        public /* bridge */ /* synthetic */ DoubleStream parallel() {
            return (DoubleStream) super.parallel();
        }

        @Override // java.util.stream.DoublePipeline, java.util.stream.AbstractPipeline, java.util.stream.BaseStream
        public /* bridge */ /* synthetic */ DoubleStream sequential() {
            return (DoubleStream) super.sequential();
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
