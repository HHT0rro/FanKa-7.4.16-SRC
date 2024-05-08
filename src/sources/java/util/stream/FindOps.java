package java.util.stream;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.FindOps;
import java.util.stream.Sink;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
final class FindOps {
    private FindOps() {
    }

    public static <T> TerminalOp<T, Optional<T>> makeRef(boolean mustFindFirst) {
        return new FindOp(mustFindFirst, StreamShape.REFERENCE, Optional.empty(), new Predicate() { // from class: java.util.stream.FindOps$$ExternalSyntheticLambda4
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Optional) obj).isPresent();
            }
        }, new Supplier() { // from class: java.util.stream.FindOps$$ExternalSyntheticLambda5
            @Override // java.util.function.Supplier
            public final Object get() {
                return new FindOps.FindSink.OfRef();
            }
        });
    }

    public static TerminalOp<Integer, OptionalInt> makeInt(boolean mustFindFirst) {
        return new FindOp(mustFindFirst, StreamShape.INT_VALUE, OptionalInt.empty(), new Predicate() { // from class: java.util.stream.FindOps$$ExternalSyntheticLambda6
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((OptionalInt) obj).isPresent();
            }
        }, new Supplier() { // from class: java.util.stream.FindOps$$ExternalSyntheticLambda7
            @Override // java.util.function.Supplier
            public final Object get() {
                return new FindOps.FindSink.OfInt();
            }
        });
    }

    public static TerminalOp<Long, OptionalLong> makeLong(boolean mustFindFirst) {
        return new FindOp(mustFindFirst, StreamShape.LONG_VALUE, OptionalLong.empty(), new Predicate() { // from class: java.util.stream.FindOps$$ExternalSyntheticLambda2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((OptionalLong) obj).isPresent();
            }
        }, new Supplier() { // from class: java.util.stream.FindOps$$ExternalSyntheticLambda3
            @Override // java.util.function.Supplier
            public final Object get() {
                return new FindOps.FindSink.OfLong();
            }
        });
    }

    public static TerminalOp<Double, OptionalDouble> makeDouble(boolean mustFindFirst) {
        return new FindOp(mustFindFirst, StreamShape.DOUBLE_VALUE, OptionalDouble.empty(), new Predicate() { // from class: java.util.stream.FindOps$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((OptionalDouble) obj).isPresent();
            }
        }, new Supplier() { // from class: java.util.stream.FindOps$$ExternalSyntheticLambda1
            @Override // java.util.function.Supplier
            public final Object get() {
                return new FindOps.FindSink.OfDouble();
            }
        });
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class FindOp<T, O> implements TerminalOp<T, O> {
        final O emptyValue;
        final boolean mustFindFirst;
        final Predicate<O> presentPredicate;
        private final StreamShape shape;
        final Supplier<TerminalSink<T, O>> sinkSupplier;

        FindOp(boolean mustFindFirst, StreamShape shape, O emptyValue, Predicate<O> presentPredicate, Supplier<TerminalSink<T, O>> sinkSupplier) {
            this.mustFindFirst = mustFindFirst;
            this.shape = shape;
            this.emptyValue = emptyValue;
            this.presentPredicate = presentPredicate;
            this.sinkSupplier = sinkSupplier;
        }

        @Override // java.util.stream.TerminalOp
        public int getOpFlags() {
            return StreamOpFlag.IS_SHORT_CIRCUIT | (this.mustFindFirst ? 0 : StreamOpFlag.NOT_ORDERED);
        }

        @Override // java.util.stream.TerminalOp
        public StreamShape inputShape() {
            return this.shape;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.stream.TerminalOp
        public <S> O evaluateSequential(PipelineHelper<T> pipelineHelper, Spliterator<S> spliterator) {
            O o10 = (O) ((TerminalSink) pipelineHelper.wrapAndCopyInto(this.sinkSupplier.get(), spliterator)).get();
            return o10 != null ? o10 : this.emptyValue;
        }

        @Override // java.util.stream.TerminalOp
        public <P_IN> O evaluateParallel(PipelineHelper<T> helper, Spliterator<P_IN> spliterator) {
            return new FindTask(this, helper, spliterator).invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static abstract class FindSink<T, O> implements TerminalSink<T, O> {
        boolean hasValue;
        T value;

        FindSink() {
        }

        @Override // java.util.function.Consumer
        public void accept(T value) {
            if (!this.hasValue) {
                this.hasValue = true;
                this.value = value;
            }
        }

        @Override // java.util.stream.Sink
        public boolean cancellationRequested() {
            return this.hasValue;
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static final class OfRef<T> extends FindSink<T, Optional<T>> {
            @Override // java.util.function.Supplier
            public Optional<T> get() {
                if (this.hasValue) {
                    return Optional.of(this.value);
                }
                return null;
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static final class OfInt extends FindSink<Integer, OptionalInt> implements Sink.OfInt {
            @Override // java.util.stream.Sink.OfInt
            public /* bridge */ /* synthetic */ void accept(Integer num) {
                super.accept((OfInt) num);
            }

            @Override // java.util.stream.Sink, java.util.stream.Sink.OfInt, java.util.function.IntConsumer
            public void accept(int value) {
                accept((OfInt) Integer.valueOf(value));
            }

            @Override // java.util.function.Supplier
            public OptionalInt get() {
                if (this.hasValue) {
                    return OptionalInt.of(((Integer) this.value).intValue());
                }
                return null;
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static final class OfLong extends FindSink<Long, OptionalLong> implements Sink.OfLong {
            @Override // java.util.stream.Sink.OfLong
            public /* bridge */ /* synthetic */ void accept(Long l10) {
                super.accept((OfLong) l10);
            }

            @Override // java.util.stream.Sink, java.util.stream.Sink.OfLong, java.util.function.LongConsumer
            public void accept(long value) {
                accept((OfLong) Long.valueOf(value));
            }

            @Override // java.util.function.Supplier
            public OptionalLong get() {
                if (this.hasValue) {
                    return OptionalLong.of(((Long) this.value).longValue());
                }
                return null;
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
        static final class OfDouble extends FindSink<Double, OptionalDouble> implements Sink.OfDouble {
            @Override // java.util.stream.Sink.OfDouble
            public /* bridge */ /* synthetic */ void accept(Double d10) {
                super.accept((OfDouble) d10);
            }

            @Override // java.util.stream.Sink, java.util.function.DoubleConsumer
            public void accept(double value) {
                accept((OfDouble) Double.valueOf(value));
            }

            @Override // java.util.function.Supplier
            public OptionalDouble get() {
                if (this.hasValue) {
                    return OptionalDouble.of(((Double) this.value).doubleValue());
                }
                return null;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    private static final class FindTask<P_IN, P_OUT, O> extends AbstractShortCircuitTask<P_IN, P_OUT, O, FindTask<P_IN, P_OUT, O>> {
        private final FindOp<P_OUT, O> op;

        FindTask(FindOp<P_OUT, O> op, PipelineHelper<P_OUT> helper, Spliterator<P_IN> spliterator) {
            super(helper, spliterator);
            this.op = op;
        }

        FindTask(FindTask<P_IN, P_OUT, O> parent, Spliterator<P_IN> spliterator) {
            super(parent, spliterator);
            this.op = parent.op;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.util.stream.AbstractTask
        public FindTask<P_IN, P_OUT, O> makeChild(Spliterator<P_IN> spliterator) {
            return new FindTask<>(this, spliterator);
        }

        @Override // java.util.stream.AbstractShortCircuitTask
        protected O getEmptyResult() {
            return this.op.emptyValue;
        }

        private void foundResult(O answer) {
            if (isLeftmostNode()) {
                shortCircuit(answer);
            } else {
                cancelLaterNodes();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.util.stream.AbstractTask
        public O doLeaf() {
            O o10 = (O) ((TerminalSink) this.helper.wrapAndCopyInto(this.op.sinkSupplier.get(), this.spliterator)).get();
            if (!this.op.mustFindFirst) {
                if (o10 != null) {
                    shortCircuit(o10);
                }
                return null;
            }
            if (o10 == null) {
                return null;
            }
            foundResult(o10);
            return o10;
        }

        @Override // java.util.stream.AbstractTask, java.util.concurrent.CountedCompleter
        public void onCompletion(CountedCompleter<?> caller) {
            if (this.op.mustFindFirst) {
                FindTask<P_IN, P_OUT, O> child = (FindTask) this.leftChild;
                FindTask<P_IN, P_OUT, O> p10 = null;
                while (true) {
                    if (child != p10) {
                        O result = child.getLocalResult();
                        if (result == null || !this.op.presentPredicate.test(result)) {
                            p10 = child;
                            child = (FindTask) this.rightChild;
                        } else {
                            setLocalResult(result);
                            foundResult(result);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            super.onCompletion(caller);
        }
    }
}
