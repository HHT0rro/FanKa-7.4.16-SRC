package com.google.common.eventbus;

import com.google.common.base.j;
import com.google.common.base.o;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class DeadEvent {
    private final Object event;
    private final Object source;

    public DeadEvent(Object obj, Object obj2) {
        this.source = o.r(obj);
        this.event = o.r(obj2);
    }

    public Object getEvent() {
        return this.event;
    }

    public Object getSource() {
        return this.source;
    }

    public String toString() {
        return j.c(this).d("source", this.source).d("event", this.event).toString();
    }
}
