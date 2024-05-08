package com.cupidapp.live.base.grpc;

import com.cupidapp.live.base.grpc.CuConnectorOuterClass;
import org.jetbrains.annotations.NotNull;

/* compiled from: IGrpcMessageListener.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface IGrpcMessageListener {
    void onReceiveGrpcMessage(@NotNull CuConnectorOuterClass.MessageType messageType, @NotNull Object obj);
}
