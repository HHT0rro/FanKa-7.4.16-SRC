package com.huawei.jmessage.api;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface EventQueue {
    void publish(String str, Object obj);

    void publish(String str, Object obj, Object obj2);

    int subscribe(String str, EventCallback eventCallback);

    int subscribe(String str, Object obj, EventCallback eventCallback);

    void unsubscribe(int i10);
}
