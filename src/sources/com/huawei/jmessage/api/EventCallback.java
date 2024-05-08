package com.huawei.jmessage.api;

import android.os.RemoteException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface EventCallback {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class Message {
        public Object payload;
        public int subscribeId;
        public String topic;

        public <T> T getPayload(Class<T> cls) {
            Object obj = this.payload;
            if (obj != null && cls.isAssignableFrom(obj.getClass())) {
                return (T) this.payload;
            }
            return null;
        }
    }

    void call(Message message) throws RemoteException;
}
