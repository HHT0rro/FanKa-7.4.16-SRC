package com.cupidapp.live.base.grpc;

import com.cupidapp.live.liveshow.model.RedEnvelopeModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RedEnvelopeConnectorMessage {

    @Nullable
    private final RedEnvelopeModel entity;

    public RedEnvelopeConnectorMessage(@Nullable RedEnvelopeModel redEnvelopeModel) {
        this.entity = redEnvelopeModel;
    }

    public static /* synthetic */ RedEnvelopeConnectorMessage copy$default(RedEnvelopeConnectorMessage redEnvelopeConnectorMessage, RedEnvelopeModel redEnvelopeModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            redEnvelopeModel = redEnvelopeConnectorMessage.entity;
        }
        return redEnvelopeConnectorMessage.copy(redEnvelopeModel);
    }

    @Nullable
    public final RedEnvelopeModel component1() {
        return this.entity;
    }

    @NotNull
    public final RedEnvelopeConnectorMessage copy(@Nullable RedEnvelopeModel redEnvelopeModel) {
        return new RedEnvelopeConnectorMessage(redEnvelopeModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RedEnvelopeConnectorMessage) && kotlin.jvm.internal.s.d(this.entity, ((RedEnvelopeConnectorMessage) obj).entity);
    }

    @Nullable
    public final RedEnvelopeModel getEntity() {
        return this.entity;
    }

    public int hashCode() {
        RedEnvelopeModel redEnvelopeModel = this.entity;
        if (redEnvelopeModel == null) {
            return 0;
        }
        return redEnvelopeModel.hashCode();
    }

    @NotNull
    public String toString() {
        return "RedEnvelopeConnectorMessage(entity=" + ((Object) this.entity) + ")";
    }
}
