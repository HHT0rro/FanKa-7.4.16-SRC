package com.google.protobuf;

import com.google.protobuf.Descriptors;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface RpcChannel {
    void callMethod(Descriptors.MethodDescriptor methodDescriptor, RpcController rpcController, Message message, Message message2, RpcCallback<Message> rpcCallback);
}
