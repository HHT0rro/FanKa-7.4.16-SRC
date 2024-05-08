package io.grpc.stub;

import com.google.common.base.o;
import com.huawei.quickcard.base.Attributes;
import io.grpc.ExperimentalApi;
import java.util.Iterator;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/4694")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class StreamObservers {
    public static <V> void copyWithFlowControl(final Iterator<V> it, final CallStreamObserver<V> callStreamObserver) {
        o.s(it, "source");
        o.s(callStreamObserver, Attributes.Style.TARGET);
        callStreamObserver.setOnReadyHandler(new Runnable() { // from class: io.grpc.stub.StreamObservers.1FlowControllingOnReadyHandler
            private boolean completed;

            @Override // java.lang.Runnable
            public void run() {
                if (this.completed) {
                    return;
                }
                while (CallStreamObserver.this.isReady() && it.hasNext()) {
                    CallStreamObserver.this.onNext(it.next());
                }
                if (it.hasNext()) {
                    return;
                }
                this.completed = true;
                CallStreamObserver.this.onCompleted();
            }
        });
    }

    public static <V> void copyWithFlowControl(Iterable<V> iterable, CallStreamObserver<V> callStreamObserver) {
        o.s(iterable, "source");
        copyWithFlowControl(iterable.iterator2(), callStreamObserver);
    }
}
