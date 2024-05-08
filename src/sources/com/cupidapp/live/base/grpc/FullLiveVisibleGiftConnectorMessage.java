package com.cupidapp.live.base.grpc;

import com.cupidapp.live.liveshow.model.FullLiveVisibleGiftModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FullLiveVisibleGiftConnectorMessage {

    @Nullable
    private final FullLiveVisibleGiftModel entity;

    public FullLiveVisibleGiftConnectorMessage(@Nullable FullLiveVisibleGiftModel fullLiveVisibleGiftModel) {
        this.entity = fullLiveVisibleGiftModel;
    }

    public static /* synthetic */ FullLiveVisibleGiftConnectorMessage copy$default(FullLiveVisibleGiftConnectorMessage fullLiveVisibleGiftConnectorMessage, FullLiveVisibleGiftModel fullLiveVisibleGiftModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            fullLiveVisibleGiftModel = fullLiveVisibleGiftConnectorMessage.entity;
        }
        return fullLiveVisibleGiftConnectorMessage.copy(fullLiveVisibleGiftModel);
    }

    @Nullable
    public final FullLiveVisibleGiftModel component1() {
        return this.entity;
    }

    @NotNull
    public final FullLiveVisibleGiftConnectorMessage copy(@Nullable FullLiveVisibleGiftModel fullLiveVisibleGiftModel) {
        return new FullLiveVisibleGiftConnectorMessage(fullLiveVisibleGiftModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FullLiveVisibleGiftConnectorMessage) && kotlin.jvm.internal.s.d(this.entity, ((FullLiveVisibleGiftConnectorMessage) obj).entity);
    }

    @Nullable
    public final FullLiveVisibleGiftModel getEntity() {
        return this.entity;
    }

    public int hashCode() {
        FullLiveVisibleGiftModel fullLiveVisibleGiftModel = this.entity;
        if (fullLiveVisibleGiftModel == null) {
            return 0;
        }
        return fullLiveVisibleGiftModel.hashCode();
    }

    @NotNull
    public String toString() {
        return "FullLiveVisibleGiftConnectorMessage(entity=" + ((Object) this.entity) + ")";
    }
}
