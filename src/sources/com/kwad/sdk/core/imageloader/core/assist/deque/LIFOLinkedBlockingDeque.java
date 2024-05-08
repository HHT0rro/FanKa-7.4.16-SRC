package com.kwad.sdk.core.imageloader.core.assist.deque;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class LIFOLinkedBlockingDeque<T> extends LinkedBlockingDeque<T> {
    private static final long serialVersionUID = -4114786347960826192L;

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean offer(T t2) {
        return super.offerFirst(t2);
    }

    @Override // com.kwad.sdk.core.imageloader.core.assist.deque.LinkedBlockingDeque, java.util.AbstractQueue, java.util.Queue
    public T remove() {
        return (T) super.removeFirst();
    }
}
