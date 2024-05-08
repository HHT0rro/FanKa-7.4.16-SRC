package com.google.common.eventbus;

import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
final class Dispatcher$PerThreadQueuedDispatcher$Event {
    private final Object event;
    private final Iterator<Object> subscribers;

    private Dispatcher$PerThreadQueuedDispatcher$Event(Object obj, Iterator<Object> it) {
        this.event = obj;
        this.subscribers = it;
    }
}
