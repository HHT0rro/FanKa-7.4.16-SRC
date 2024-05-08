package com.huawei.hmf.services.ui;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ProtocolRef {
    private Class<?> mInterface;
    private Object mValue;

    public ProtocolRef(Class<?> cls, Object obj) {
        this.mValue = obj;
        this.mInterface = cls;
    }

    public Class<?> getType() {
        return this.mInterface;
    }

    public <T> T getValue() {
        return (T) this.mValue;
    }
}
