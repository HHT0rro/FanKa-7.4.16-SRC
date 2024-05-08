package io.reactivex.internal.fuseable;

import io.reactivex.FlowableSubscriber;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface ConditionalSubscriber<T> extends FlowableSubscriber<T> {
    boolean tryOnNext(T t2);
}
