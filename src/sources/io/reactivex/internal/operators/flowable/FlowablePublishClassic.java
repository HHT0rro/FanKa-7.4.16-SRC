package io.reactivex.internal.operators.flowable;

import org.reactivestreams.Publisher;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface FlowablePublishClassic<T> {
    int publishBufferSize();

    Publisher<T> publishSource();
}
