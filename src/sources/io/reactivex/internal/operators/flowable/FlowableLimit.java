package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class FlowableLimit<T> extends AbstractFlowableWithUpstream<T, T> {

    /* renamed from: n, reason: collision with root package name */
    public final long f50123n;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class LimitSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = 2288246011222124525L;
        public final Subscriber<? super T> downstream;
        public long remaining;
        public Subscription upstream;

        public LimitSubscriber(Subscriber<? super T> subscriber, long j10) {
            this.downstream = subscriber;
            this.remaining = j10;
            lazySet(j10);
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            if (this.remaining > 0) {
                this.remaining = 0L;
                this.downstream.onComplete();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (this.remaining > 0) {
                this.remaining = 0L;
                this.downstream.onError(th);
            } else {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t2) {
            long j10 = this.remaining;
            if (j10 > 0) {
                long j11 = j10 - 1;
                this.remaining = j11;
                this.downstream.onNext(t2);
                if (j11 == 0) {
                    this.upstream.cancel();
                    this.downstream.onComplete();
                }
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                if (this.remaining == 0) {
                    subscription.cancel();
                    EmptySubscription.complete(this.downstream);
                } else {
                    this.upstream = subscription;
                    this.downstream.onSubscribe(this);
                }
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j10) {
            long j11;
            long j12;
            if (!SubscriptionHelper.validate(j10)) {
                return;
            }
            do {
                j11 = get();
                if (j11 == 0) {
                    return;
                } else {
                    j12 = j11 <= j10 ? j11 : j10;
                }
            } while (!compareAndSet(j11, j11 - j12));
            this.upstream.request(j12);
        }
    }

    public FlowableLimit(Flowable<T> flowable, long j10) {
        super(flowable);
        this.f50123n = j10;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new LimitSubscriber(subscriber, this.f50123n));
    }
}
