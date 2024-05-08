package com.google.common.collect;

/* compiled from: ForwardingObject.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class z {
    public abstract Object delegate();

    public String toString() {
        return delegate().toString();
    }
}
