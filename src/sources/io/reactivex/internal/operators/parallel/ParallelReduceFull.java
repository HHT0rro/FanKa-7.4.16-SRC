package io.reactivex.internal.operators.parallel;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ParallelReduceFull<T> extends Flowable<T> {
    public final BiFunction<T, T, T> reducer;
    public final ParallelFlowable<? extends T> source;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ParallelReduceFullInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        private static final long serialVersionUID = -7954444275102466525L;
        public boolean done;
        public final ParallelReduceFullMainSubscriber<T> parent;
        public final BiFunction<T, T, T> reducer;
        public T value;

        public ParallelReduceFullInnerSubscriber(ParallelReduceFullMainSubscriber<T> parallelReduceFullMainSubscriber, BiFunction<T, T, T> biFunction) {
            this.parent = parallelReduceFullMainSubscriber;
            this.reducer = biFunction;
        }

        public void cancel() {
            SubscriptionHelper.cancel(this);
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.innerComplete(this.value);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                this.parent.innerError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t2) {
            if (this.done) {
                return;
            }
            T t10 = this.value;
            if (t10 == null) {
                this.value = t2;
                return;
            }
            try {
                this.value = (T) ObjectHelper.requireNonNull(this.reducer.apply(t10, t2), "The reducer returned a null value");
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                get().cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.setOnce(this, subscription, Long.MAX_VALUE);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class ParallelReduceFullMainSubscriber<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = -5370107872170712765L;
        public final AtomicReference<SlotPair<T>> current;
        public final AtomicReference<Throwable> error;
        public final BiFunction<T, T, T> reducer;
        public final AtomicInteger remaining;
        public final ParallelReduceFullInnerSubscriber<T>[] subscribers;

        public ParallelReduceFullMainSubscriber(Subscriber<? super T> subscriber, int i10, BiFunction<T, T, T> biFunction) {
            super(subscriber);
            this.current = new AtomicReference<>();
            this.remaining = new AtomicInteger();
            this.error = new AtomicReference<>();
            ParallelReduceFullInnerSubscriber<T>[] parallelReduceFullInnerSubscriberArr = new ParallelReduceFullInnerSubscriber[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                parallelReduceFullInnerSubscriberArr[i11] = new ParallelReduceFullInnerSubscriber<>(this, biFunction);
            }
            this.subscribers = parallelReduceFullInnerSubscriberArr;
            this.reducer = biFunction;
            this.remaining.lazySet(i10);
        }

        public SlotPair<T> addValue(T t2) {
            SlotPair<T> slotPair;
            int tryAcquireSlot;
            while (true) {
                slotPair = this.current.get();
                if (slotPair == null) {
                    slotPair = new SlotPair<>();
                    if (!this.current.compareAndSet(null, slotPair)) {
                        continue;
                    }
                }
                tryAcquireSlot = slotPair.tryAcquireSlot();
                if (tryAcquireSlot >= 0) {
                    break;
                }
                this.current.compareAndSet(slotPair, null);
            }
            if (tryAcquireSlot == 0) {
                slotPair.first = t2;
            } else {
                slotPair.second = t2;
            }
            if (!slotPair.releaseSlot()) {
                return null;
            }
            this.current.compareAndSet(slotPair, null);
            return slotPair;
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, org.reactivestreams.Subscription
        public void cancel() {
            for (ParallelReduceFullInnerSubscriber<T> parallelReduceFullInnerSubscriber : this.subscribers) {
                parallelReduceFullInnerSubscriber.cancel();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
        
            if (r2.remaining.decrementAndGet() != 0) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
        
            r3 = r2.current.get();
            r2.current.lazySet(null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0037, code lost:
        
            if (r3 == null) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
        
            complete(r3.first);
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
        
            r2.downstream.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:1:0x0000, code lost:
        
            if (r3 != null) goto L3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0044, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
        
            r3 = addValue(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
        
            if (r3 == null) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
        
            r3 = (T) io.reactivex.internal.functions.ObjectHelper.requireNonNull(r2.reducer.apply(r3.first, r3.second), "The reducer returned a null value");
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x001a, code lost:
        
            io.reactivex.exceptions.Exceptions.throwIfFatal(r3);
            innerError(r3);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void innerComplete(T r3) {
            /*
                r2 = this;
                if (r3 == 0) goto L21
            L2:
                io.reactivex.internal.operators.parallel.ParallelReduceFull$SlotPair r3 = r2.addValue(r3)
                if (r3 == 0) goto L21
                io.reactivex.functions.BiFunction<T, T, T> r0 = r2.reducer     // Catch: java.lang.Throwable -> L19
                T r1 = r3.first     // Catch: java.lang.Throwable -> L19
                T r3 = r3.second     // Catch: java.lang.Throwable -> L19
                java.lang.Object r3 = r0.apply(r1, r3)     // Catch: java.lang.Throwable -> L19
                java.lang.String r0 = "The reducer returned a null value"
                java.lang.Object r3 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r3, r0)     // Catch: java.lang.Throwable -> L19
                goto L2
            L19:
                r3 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r3)
                r2.innerError(r3)
                return
            L21:
                java.util.concurrent.atomic.AtomicInteger r3 = r2.remaining
                int r3 = r3.decrementAndGet()
                if (r3 != 0) goto L44
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.parallel.ParallelReduceFull$SlotPair<T>> r3 = r2.current
                java.lang.Object r3 = r3.get()
                io.reactivex.internal.operators.parallel.ParallelReduceFull$SlotPair r3 = (io.reactivex.internal.operators.parallel.ParallelReduceFull.SlotPair) r3
                java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.parallel.ParallelReduceFull$SlotPair<T>> r0 = r2.current
                r1 = 0
                r0.lazySet(r1)
                if (r3 == 0) goto L3f
                T r3 = r3.first
                r2.complete(r3)
                goto L44
            L3f:
                org.reactivestreams.Subscriber<? super T> r3 = r2.downstream
                r3.onComplete()
            L44:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.parallel.ParallelReduceFull.ParallelReduceFullMainSubscriber.innerComplete(java.lang.Object):void");
        }

        public void innerError(Throwable th) {
            if (this.error.compareAndSet(null, th)) {
                cancel();
                this.downstream.onError(th);
            } else if (th != this.error.get()) {
                RxJavaPlugins.onError(th);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class SlotPair<T> extends AtomicInteger {
        private static final long serialVersionUID = 473971317683868662L;
        public T first;
        public final AtomicInteger releaseIndex = new AtomicInteger();
        public T second;

        public boolean releaseSlot() {
            return this.releaseIndex.incrementAndGet() == 2;
        }

        public int tryAcquireSlot() {
            int i10;
            do {
                i10 = get();
                if (i10 >= 2) {
                    return -1;
                }
            } while (!compareAndSet(i10, i10 + 1));
            return i10;
        }
    }

    public ParallelReduceFull(ParallelFlowable<? extends T> parallelFlowable, BiFunction<T, T, T> biFunction) {
        this.source = parallelFlowable;
        this.reducer = biFunction;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        ParallelReduceFullMainSubscriber parallelReduceFullMainSubscriber = new ParallelReduceFullMainSubscriber(subscriber, this.source.parallelism(), this.reducer);
        subscriber.onSubscribe(parallelReduceFullMainSubscriber);
        this.source.subscribe(parallelReduceFullMainSubscriber.subscribers);
    }
}
