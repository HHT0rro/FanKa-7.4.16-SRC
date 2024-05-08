package com.cupidapp.live.base.grpc;

import com.cupidapp.live.base.grpc.CuConnectorOuterClass;
import com.cupidapp.live.base.network.gson.GsonUtil;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class BaseGrpcRequestModel implements Serializable {
    @NotNull
    public abstract CuConnectorOuterClass.MessageType getMessageType();

    @NotNull
    public final String toJson() {
        String json = GsonUtil.f12000a.b().toJson(this);
        kotlin.jvm.internal.s.h(json, "GsonUtil.pureGson.toJson(this)");
        return json;
    }
}
