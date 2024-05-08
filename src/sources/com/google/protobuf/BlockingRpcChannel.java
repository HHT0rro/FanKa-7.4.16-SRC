package com.google.protobuf;

import com.google.protobuf.Descriptors;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface BlockingRpcChannel {
    Message callBlockingMethod(Descriptors.MethodDescriptor methodDescriptor, RpcController rpcController, Message message, Message message2) throws ServiceException;
}
