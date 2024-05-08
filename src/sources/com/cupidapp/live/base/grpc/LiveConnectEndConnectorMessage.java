package com.cupidapp.live.base.grpc;

import com.cupidapp.live.liveshow.model.LiveConnectEndModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveConnectEndConnectorMessage {

    @Nullable
    private final LiveConnectEndModel entity;

    @NotNull
    private final String liveShowId;

    public LiveConnectEndConnectorMessage(@NotNull String liveShowId, @Nullable LiveConnectEndModel liveConnectEndModel) {
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        this.liveShowId = liveShowId;
        this.entity = liveConnectEndModel;
    }

    public static /* synthetic */ LiveConnectEndConnectorMessage copy$default(LiveConnectEndConnectorMessage liveConnectEndConnectorMessage, String str, LiveConnectEndModel liveConnectEndModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = liveConnectEndConnectorMessage.liveShowId;
        }
        if ((i10 & 2) != 0) {
            liveConnectEndModel = liveConnectEndConnectorMessage.entity;
        }
        return liveConnectEndConnectorMessage.copy(str, liveConnectEndModel);
    }

    @NotNull
    public final String component1() {
        return this.liveShowId;
    }

    @Nullable
    public final LiveConnectEndModel component2() {
        return this.entity;
    }

    @NotNull
    public final LiveConnectEndConnectorMessage copy(@NotNull String liveShowId, @Nullable LiveConnectEndModel liveConnectEndModel) {
        kotlin.jvm.internal.s.i(liveShowId, "liveShowId");
        return new LiveConnectEndConnectorMessage(liveShowId, liveConnectEndModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveConnectEndConnectorMessage)) {
            return false;
        }
        LiveConnectEndConnectorMessage liveConnectEndConnectorMessage = (LiveConnectEndConnectorMessage) obj;
        return kotlin.jvm.internal.s.d(this.liveShowId, liveConnectEndConnectorMessage.liveShowId) && kotlin.jvm.internal.s.d(this.entity, liveConnectEndConnectorMessage.entity);
    }

    @Nullable
    public final LiveConnectEndModel getEntity() {
        return this.entity;
    }

    @NotNull
    public final String getLiveShowId() {
        return this.liveShowId;
    }

    public int hashCode() {
        int hashCode = this.liveShowId.hashCode() * 31;
        LiveConnectEndModel liveConnectEndModel = this.entity;
        return hashCode + (liveConnectEndModel == null ? 0 : liveConnectEndModel.hashCode());
    }

    @NotNull
    public String toString() {
        return "LiveConnectEndConnectorMessage(liveShowId=" + this.liveShowId + ", entity=" + ((Object) this.entity) + ")";
    }
}
