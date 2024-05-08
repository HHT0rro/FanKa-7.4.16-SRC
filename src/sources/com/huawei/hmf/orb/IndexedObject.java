package com.huawei.hmf.orb;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class IndexedObject<T> {
    private long mId = RemoteSession.nextID();
    private T mObject;

    public IndexedObject(T t2) {
        this.mObject = t2;
    }

    public T get() {
        return this.mObject;
    }

    public long id() {
        return this.mId;
    }

    public void set(T t2) {
        this.mObject = t2;
    }
}
