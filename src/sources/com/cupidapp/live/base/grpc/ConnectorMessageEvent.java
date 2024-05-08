package com.cupidapp.live.base.grpc;

import com.cupidapp.live.base.grpc.CuConnectorOuterClass;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConnectorMessageEvent.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConnectorMessageEvent {

    @Nullable
    private LiveShowConnectorMessage baseInfoMessageModel;

    @NotNull
    private final CuConnectorOuterClass.ConnectorMessage message;

    @NotNull
    private final Object model;

    public ConnectorMessageEvent(@NotNull CuConnectorOuterClass.ConnectorMessage message, @NotNull Object model, @Nullable LiveShowConnectorMessage liveShowConnectorMessage) {
        kotlin.jvm.internal.s.i(message, "message");
        kotlin.jvm.internal.s.i(model, "model");
        this.message = message;
        this.model = model;
        this.baseInfoMessageModel = liveShowConnectorMessage;
    }

    public static /* synthetic */ ConnectorMessageEvent copy$default(ConnectorMessageEvent connectorMessageEvent, CuConnectorOuterClass.ConnectorMessage connectorMessage, Object obj, LiveShowConnectorMessage liveShowConnectorMessage, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            connectorMessage = connectorMessageEvent.message;
        }
        if ((i10 & 2) != 0) {
            obj = connectorMessageEvent.model;
        }
        if ((i10 & 4) != 0) {
            liveShowConnectorMessage = connectorMessageEvent.baseInfoMessageModel;
        }
        return connectorMessageEvent.copy(connectorMessage, obj, liveShowConnectorMessage);
    }

    @NotNull
    public final CuConnectorOuterClass.ConnectorMessage component1() {
        return this.message;
    }

    @NotNull
    public final Object component2() {
        return this.model;
    }

    @Nullable
    public final LiveShowConnectorMessage component3() {
        return this.baseInfoMessageModel;
    }

    @NotNull
    public final ConnectorMessageEvent copy(@NotNull CuConnectorOuterClass.ConnectorMessage message, @NotNull Object model, @Nullable LiveShowConnectorMessage liveShowConnectorMessage) {
        kotlin.jvm.internal.s.i(message, "message");
        kotlin.jvm.internal.s.i(model, "model");
        return new ConnectorMessageEvent(message, model, liveShowConnectorMessage);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConnectorMessageEvent)) {
            return false;
        }
        ConnectorMessageEvent connectorMessageEvent = (ConnectorMessageEvent) obj;
        return kotlin.jvm.internal.s.d(this.message, connectorMessageEvent.message) && kotlin.jvm.internal.s.d(this.model, connectorMessageEvent.model) && kotlin.jvm.internal.s.d(this.baseInfoMessageModel, connectorMessageEvent.baseInfoMessageModel);
    }

    @Nullable
    public final LiveShowConnectorMessage getBaseInfoMessageModel() {
        return this.baseInfoMessageModel;
    }

    @NotNull
    public final CuConnectorOuterClass.ConnectorMessage getMessage() {
        return this.message;
    }

    @NotNull
    public final Object getModel() {
        return this.model;
    }

    public int hashCode() {
        int hashCode = ((this.message.hashCode() * 31) + this.model.hashCode()) * 31;
        LiveShowConnectorMessage liveShowConnectorMessage = this.baseInfoMessageModel;
        return hashCode + (liveShowConnectorMessage == null ? 0 : liveShowConnectorMessage.hashCode());
    }

    public final void setBaseInfoMessageModel(@Nullable LiveShowConnectorMessage liveShowConnectorMessage) {
        this.baseInfoMessageModel = liveShowConnectorMessage;
    }

    @NotNull
    public String toString() {
        CuConnectorOuterClass.ConnectorMessage connectorMessage = this.message;
        return "ConnectorMessageEvent(message=" + ((Object) connectorMessage) + ", model=" + this.model + ", baseInfoMessageModel=" + ((Object) this.baseInfoMessageModel) + ")";
    }

    public /* synthetic */ ConnectorMessageEvent(CuConnectorOuterClass.ConnectorMessage connectorMessage, Object obj, LiveShowConnectorMessage liveShowConnectorMessage, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(connectorMessage, obj, (i10 & 4) != 0 ? null : liveShowConnectorMessage);
    }
}
