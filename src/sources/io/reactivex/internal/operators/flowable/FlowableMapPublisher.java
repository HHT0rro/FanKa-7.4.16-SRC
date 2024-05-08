package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.flowable.FlowableMap;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class FlowableMapPublisher<T, U> extends Flowable<U> {
    public final Function<? super T, ? extends U> mapper;
    public final Publisher<T> source;

    public FlowableMapPublisher(Publisher<T> publisher, Function<? super T, ? extends U> function) {
        this.source = publisher;
        this.mapper = function;
    }

    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super U> subscriber) {
        this.source.subscribe(new FlowableMap.MapSubscriber(subscriber, this.mapper));
    }
}
