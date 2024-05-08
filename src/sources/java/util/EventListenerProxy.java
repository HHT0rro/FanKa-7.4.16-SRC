package java.util;

import java.util.EventListener;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class EventListenerProxy<T extends EventListener> implements EventListener {
    private final T listener;

    public EventListenerProxy(T listener) {
        this.listener = listener;
    }

    public T getListener() {
        return this.listener;
    }
}
