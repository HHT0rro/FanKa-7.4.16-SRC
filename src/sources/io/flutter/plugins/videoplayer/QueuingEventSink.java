package io.flutter.plugins.videoplayer;

import io.flutter.plugin.common.EventChannel;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
final class QueuingEventSink implements EventChannel.EventSink {
    private EventChannel.EventSink delegate;
    private final ArrayList<Object> eventQueue = new ArrayList<>();
    private boolean done = false;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class EndOfStreamEvent {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class ErrorEvent {
        public String code;
        public Object details;
        public String message;

        public ErrorEvent(String str, String str2, Object obj) {
            this.code = str;
            this.message = str2;
            this.details = obj;
        }
    }

    private void enqueue(Object obj) {
        if (this.done) {
            return;
        }
        this.eventQueue.add(obj);
    }

    private void maybeFlush() {
        if (this.delegate == null) {
            return;
        }
        Iterator<Object> iterator2 = this.eventQueue.iterator2();
        while (iterator2.hasNext()) {
            Object next = iterator2.next();
            if (next instanceof EndOfStreamEvent) {
                this.delegate.endOfStream();
            } else if (next instanceof ErrorEvent) {
                ErrorEvent errorEvent = (ErrorEvent) next;
                this.delegate.error(errorEvent.code, errorEvent.message, errorEvent.details);
            } else {
                this.delegate.success(next);
            }
        }
        this.eventQueue.clear();
    }

    @Override // io.flutter.plugin.common.EventChannel.EventSink
    public void endOfStream() {
        enqueue(new EndOfStreamEvent());
        maybeFlush();
        this.done = true;
    }

    @Override // io.flutter.plugin.common.EventChannel.EventSink
    public void error(String str, String str2, Object obj) {
        enqueue(new ErrorEvent(str, str2, obj));
        maybeFlush();
    }

    public void setDelegate(EventChannel.EventSink eventSink) {
        this.delegate = eventSink;
        maybeFlush();
    }

    @Override // io.flutter.plugin.common.EventChannel.EventSink
    public void success(Object obj) {
        enqueue(obj);
        maybeFlush();
    }
}
