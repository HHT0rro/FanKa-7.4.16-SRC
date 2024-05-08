package com.cupidapp.live.base.grpc;

import com.cupidapp.live.liveshow.model.NewLiveConnectRequestModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class NewLiveConnectRequestConnectorMessage {

    @Nullable
    private final NewLiveConnectRequestModel entity;

    @NotNull
    private final String liveShowId;

    public NewLiveConnectRequestConnectorMessage(@NotNull String liveShowId, @Nullable NewLiveConnectRequestModel newLiveConnectRequestModel) {
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        this.liveShowId = liveShowId;
        this.entity = newLiveConnectRequestModel;
    }

    public static /* synthetic */ NewLiveConnectRequestConnectorMessage copy$default(NewLiveConnectRequestConnectorMessage newLiveConnectRequestConnectorMessage, String str, NewLiveConnectRequestModel newLiveConnectRequestModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = newLiveConnectRequestConnectorMessage.liveShowId;
        }
        if ((i10 & 2) != 0) {
            newLiveConnectRequestModel = newLiveConnectRequestConnectorMessage.entity;
        }
        return newLiveConnectRequestConnectorMessage.copy(str, newLiveConnectRequestModel);
    }

    @NotNull
    public final String component1() {
        return this.liveShowId;
    }

    @Nullable
    public final NewLiveConnectRequestModel component2() {
        return this.entity;
    }

    @NotNull
    public final NewLiveConnectRequestConnectorMessage copy(@NotNull String liveShowId, @Nullable NewLiveConnectRequestModel newLiveConnectRequestModel) {
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        return new NewLiveConnectRequestConnectorMessage(liveShowId, newLiveConnectRequestModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NewLiveConnectRequestConnectorMessage)) {
            return false;
        }
        NewLiveConnectRequestConnectorMessage newLiveConnectRequestConnectorMessage = (NewLiveConnectRequestConnectorMessage) obj;
        return kotlin.jvm.internal.s.d(this.liveShowId, newLiveConnectRequestConnectorMessage.liveShowId) && kotlin.jvm.internal.s.d(this.entity, newLiveConnectRequestConnectorMessage.entity);
    }

    @Nullable
    public final NewLiveConnectRequestModel getEntity() {
        return this.entity;
    }

    @NotNull
    public final String getLiveShowId() {
        return this.liveShowId;
    }

    public int hashCode() {
        int hashCode = this.liveShowId.hashCode() * 31;
        NewLiveConnectRequestModel newLiveConnectRequestModel = this.entity;
        return hashCode + (newLiveConnectRequestModel == null ? 0 : newLiveConnectRequestModel.hashCode());
    }

    @NotNull
    public String toString() {
        return "NewLiveConnectRequestConnectorMessage(liveShowId=" + this.liveShowId + ", entity=" + ((Object) this.entity) + ")";
    }
}
