package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class FlowableDelay<T> extends AbstractFlowableWithUpstream<T, T> {
    public final long delay;
    public final boolean delayError;
    public final Scheduler scheduler;
    public final TimeUnit unit;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class DelaySubscriber<T> implements FlowableSubscriber<T>, Subscription {
        public final long delay;
        public final boolean delayError;
        public final Subscriber<? super T> downstream;
        public final TimeUnit unit;
        public Subscription upstream;

        /* renamed from: w, reason: collision with root package name */
        public final Scheduler.Worker f50118w;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public final class OnComplete implements Runnable {
            public OnComplete() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelaySubscriber.this.downstream.onComplete();
                } finally {
                    DelaySubscriber.this.f50118w.dispose();
                }
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public final class OnError implements Runnable {

            /* renamed from: t, reason: collision with root package name */
            private final Throwable f50119t;

            public OnError(Throwable th) {
                this.f50119t = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelaySubscriber.this.downstream.onError(this.f50119t);
                } finally {
                    DelaySubscriber.this.f50118w.dispose();
                }
            }
        }

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public final class OnNext implements Runnable {

            /* renamed from: t, reason: collision with root package name */
            private final T f50120t;

            public OnNext(T t2) {
                this.f50120t = t2;
            }

            @Override // java.lang.Runnable
            public void run() {
                DelaySubscriber.this.downstream.onNext(this.f50120t);
            }
        }

        public DelaySubscriber(Subscriber<? super T> subscriber, long j10, TimeUnit timeUnit, Scheduler.Worker worker, boolean z10) {
            this.downstream = subscriber;
            this.delay = j10;
            this.unit = timeUnit;
            this.f50118w = worker;
            this.delayError = z10;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
            this.f50118w.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f50118w.schedule(new OnComplete(), this.delay, this.unit);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f50118w.schedule(new OnError(th), this.delayError ? this.delay : 0L, this.unit);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t2) {
            this.f50118w.schedule(new OnNext(t2), this.delay, this.unit);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j10) {
            this.upstream.request(j10);
        }
    }

    public FlowableDelay(Flowable<T> flowable, long j10, TimeUnit timeUnit, Scheduler scheduler, boolean z10) {
        super(flowable);
        this.delay = j10;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.delayError = z10;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new DelaySubscriber(this.delayError ? subscriber : new SerializedSubscriber(subscriber), this.delay, this.unit, this.scheduler.createWorker(), this.delayError));
    }
}
