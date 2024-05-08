package java.util.stream;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.stream.DistinctOps;
import java.util.stream.ReferencePipeline;
import java.util.stream.Sink;
import java.util.stream.StreamSpliterators;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
final class DistinctOps {
    private DistinctOps() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* renamed from: java.util.stream.DistinctOps$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class AnonymousClass1<T> extends ReferencePipeline.StatefulOp<T, T> {
        AnonymousClass1(AbstractPipeline abstractPipeline, StreamShape inputShape, int opFlags) {
            super(abstractPipeline, inputShape, opFlags);
        }

        <P_IN> Node<T> reduce(PipelineHelper<T> helper, Spliterator<P_IN> spliterator) {
            TerminalOp<T, LinkedHashSet<T>> reduceOp = ReduceOps.makeRef(new Supplier() { // from class: java.util.stream.DistinctOps$1$$ExternalSyntheticLambda1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return new LinkedHashSet();
                }
            }, new BiConsumer() { // from class: java.util.stream.DistinctOps$1$$ExternalSyntheticLambda2
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    ((LinkedHashSet) obj).add(obj2);
                }
            }, new BiConsumer() { // from class: java.util.stream.DistinctOps$1$$ExternalSyntheticLambda3
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    ((LinkedHashSet) obj).addAll((LinkedHashSet) obj2);
                }
            });
            return Nodes.node(reduceOp.evaluateParallel(helper, spliterator));
        }

        @Override // java.util.stream.ReferencePipeline.StatefulOp, java.util.stream.AbstractPipeline
        public <P_IN> Node<T> opEvaluateParallel(PipelineHelper<T> helper, Spliterator<P_IN> spliterator, IntFunction<T[]> generator) {
            if (StreamOpFlag.DISTINCT.isKnown(helper.getStreamAndOpFlags())) {
                return helper.evaluate(spliterator, false, generator);
            }
            if (StreamOpFlag.ORDERED.isKnown(helper.getStreamAndOpFlags())) {
                return reduce(helper, spliterator);
            }
            final AtomicBoolean seenNull = new AtomicBoolean(false);
            final ConcurrentHashMap<T, Boolean> map = new ConcurrentHashMap<>();
            TerminalOp<T, Void> forEachOp = ForEachOps.makeRef(new Consumer() { // from class: java.util.stream.DistinctOps$1$$ExternalSyntheticLambda0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    DistinctOps.AnonymousClass1.lambda$opEvaluateParallel$0(AtomicBoolean.this, map, obj);
                }
            }, false);
            forEachOp.evaluateParallel(helper, spliterator);
            Set<T> keys = map.h();
            if (seenNull.get()) {
                keys = new HashSet<>(keys);
                keys.add(null);
            }
            return Nodes.node(keys);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void lambda$opEvaluateParallel$0(AtomicBoolean seenNull, ConcurrentHashMap map, Object t2) {
            if (t2 == null) {
                seenNull.set(true);
            } else {
                map.putIfAbsent(t2, Boolean.TRUE);
            }
        }

        @Override // java.util.stream.AbstractPipeline
        public <P_IN> Spliterator<T> opEvaluateParallelLazy(PipelineHelper<T> helper, Spliterator<P_IN> spliterator) {
            if (StreamOpFlag.DISTINCT.isKnown(helper.getStreamAndOpFlags())) {
                return helper.wrapSpliterator(spliterator);
            }
            if (StreamOpFlag.ORDERED.isKnown(helper.getStreamAndOpFlags())) {
                return reduce(helper, spliterator).spliterator();
            }
            return new StreamSpliterators.DistinctSpliterator(helper.wrapSpliterator(spliterator));
        }

        @Override // java.util.stream.AbstractPipeline
        public Sink<T> opWrapSink(int flags, Sink<T> sink) {
            Objects.requireNonNull(sink);
            if (StreamOpFlag.DISTINCT.isKnown(flags)) {
                return sink;
            }
            if (StreamOpFlag.SORTED.isKnown(flags)) {
                return new Sink.ChainedReference<T, T>(sink) { // from class: java.util.stream.DistinctOps.1.1
                    T lastSeen;
                    boolean seenNull;

                    @Override // java.util.stream.Sink.ChainedReference, java.util.stream.Sink
                    public void begin(long size) {
                        this.seenNull = false;
                        this.lastSeen = null;
                        this.downstream.begin(-1L);
                    }

                    @Override // java.util.stream.Sink.ChainedReference, java.util.stream.Sink
                    public void end() {
                        this.seenNull = false;
                        this.lastSeen = null;
                        this.downstream.end();
                    }

                    @Override // java.util.function.Consumer
                    public void accept(T t2) {
                        if (t2 == null) {
                            if (!this.seenNull) {
                                this.seenNull = true;
                                Consumer consumer = this.downstream;
                                this.lastSeen = null;
                                consumer.accept(null);
                                return;
                            }
                            return;
                        }
                        T t10 = this.lastSeen;
                        if (t10 == null || !t2.equals(t10)) {
                            Consumer consumer2 = this.downstream;
                            this.lastSeen = t2;
                            consumer2.accept(t2);
                        }
                    }
                };
            }
            return new Sink.ChainedReference<T, T>(sink) { // from class: java.util.stream.DistinctOps.1.2
                Set<T> seen;

                @Override // java.util.stream.Sink.ChainedReference, java.util.stream.Sink
                public void begin(long size) {
                    this.seen = new HashSet();
                    this.downstream.begin(-1L);
                }

                @Override // java.util.stream.Sink.ChainedReference, java.util.stream.Sink
                public void end() {
                    this.seen = null;
                    this.downstream.end();
                }

                @Override // java.util.function.Consumer
                public void accept(T t2) {
                    if (!this.seen.contains(t2)) {
                        this.seen.add(t2);
                        this.downstream.accept(t2);
                    }
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> ReferencePipeline<T, T> makeRef(AbstractPipeline<?, T, ?> upstream) {
        return new AnonymousClass1(upstream, StreamShape.REFERENCE, StreamOpFlag.IS_DISTINCT | StreamOpFlag.NOT_SIZED);
    }
}
