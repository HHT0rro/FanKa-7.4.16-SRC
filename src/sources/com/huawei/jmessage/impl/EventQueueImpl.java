package com.huawei.jmessage.impl;

import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.hmf.annotation.ApiDefine;
import com.huawei.hmf.annotation.Singleton;
import com.huawei.jmessage.api.EventCallback;
import com.huawei.jmessage.api.EventQueue;
import com.huawei.jmessage.api.MessageChannelPayload;
import com.huawei.jmessage.api.Subscriber;
import com.huawei.jmessage.sources.MessageChannelSource;
import com.koushikdutta.quack.JavaScriptObject;

@ApiDefine(alias = "mq", uri = EventQueue.class)
@Singleton
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class EventQueueImpl implements EventQueue {

    /* renamed from: b, reason: collision with root package name */
    private static final String f32031b = "EventQueueImpl";

    /* renamed from: a, reason: collision with root package name */
    private final a f32032a = a.a();

    private MessageChannelSource.Payload a(Object obj, Object obj2) {
        MessageChannelPayload messageChannelPayload;
        if (obj instanceof MessageChannelPayload) {
            messageChannelPayload = (MessageChannelPayload) obj;
        } else {
            messageChannelPayload = obj instanceof JavaScriptObject ? (MessageChannelPayload) c.a((JavaScriptObject) obj, new d()) : null;
        }
        if (messageChannelPayload != null) {
            MessageChannelSource.Payload payload = new MessageChannelSource.Payload();
            payload.setTarget(obj2);
            payload.setMessageChannelPayload(messageChannelPayload);
            return payload;
        }
        Log.e(f32031b, "The 'payload' is not supported, expected MessageChannelPayload or JavaScriptObject: " + obj);
        return null;
    }

    @Override // com.huawei.jmessage.api.EventQueue
    public void publish(String str, Object obj) {
        b a10 = this.f32032a.a(str);
        if (a10 != null) {
            a10.fire(c.a(obj, (Class<?>) FLMap.class));
        }
    }

    @Override // com.huawei.jmessage.api.EventQueue
    public int subscribe(String str, EventCallback eventCallback) {
        return subscribe(str, null, eventCallback);
    }

    @Override // com.huawei.jmessage.api.EventQueue
    public void unsubscribe(int i10) {
        b a10 = this.f32032a.a(i10);
        if (a10 != null) {
            a10.b(i10);
            if (a10.c()) {
                a10.d();
            }
        }
    }

    @Override // com.huawei.jmessage.api.EventQueue
    public int subscribe(String str, Object obj, EventCallback eventCallback) {
        b a10 = this.f32032a.a(str);
        if (a10 == null) {
            return 0;
        }
        Subscriber subscriber = new Subscriber(str, c.a(obj, (Class<?>) FLMap.class), eventCallback);
        if (a10.a(subscriber)) {
            return subscriber.getId();
        }
        return 0;
    }

    @Override // com.huawei.jmessage.api.EventQueue
    public void publish(String str, Object obj, Object obj2) {
        publish(str, a(obj, obj2));
    }
}
