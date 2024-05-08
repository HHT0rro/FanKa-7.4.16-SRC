package com.google.protobuf;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface RpcController {
    String errorText();

    boolean failed();

    boolean isCanceled();

    void notifyOnCancel(RpcCallback<Object> rpcCallback);

    void reset();

    void setFailed(String str);

    void startCancel();
}
