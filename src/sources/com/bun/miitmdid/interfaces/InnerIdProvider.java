package com.bun.miitmdid.interfaces;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface InnerIdProvider extends IdSupplier {
    boolean isSync();

    void shutDown();

    void startAction(IIdentifierListener iIdentifierListener);
}
