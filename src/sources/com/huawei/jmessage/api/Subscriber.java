package com.huawei.jmessage.api;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Subscriber {
    public static final int INVALID_ID = 0;
    private static AtomicInteger sSubscriberId = new AtomicInteger(0);
    private final EventCallback mConsumer;
    private final int mId = generateId();
    private final Object mParam;
    private final String mTopic;

    public Subscriber(String str, Object obj, EventCallback eventCallback) {
        this.mTopic = str;
        this.mParam = obj;
        this.mConsumer = eventCallback;
    }

    private static int generateId() {
        return sSubscriberId.incrementAndGet();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Subscriber.class != obj.getClass()) {
            return false;
        }
        Subscriber subscriber = (Subscriber) obj;
        return this.mId == subscriber.mId && Objects.equals(this.mTopic, subscriber.mTopic) && Objects.equals(this.mParam, subscriber.mParam) && Objects.equals(this.mConsumer, subscriber.mConsumer);
    }

    public EventCallback getConsumer() {
        return this.mConsumer;
    }

    public int getId() {
        return this.mId;
    }

    public Object getParam() {
        return this.mParam;
    }

    public String getTopic() {
        return this.mTopic;
    }

    public int hashCode() {
        return Objects.hash(this.mTopic, this.mParam, this.mConsumer, Integer.valueOf(this.mId));
    }
}
