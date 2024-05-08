package com.cupidapp.live.base.grpc;

import com.cupidapp.live.liveshow.model.AnchorInfoBorderModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AnchorInfoBorderConnectorMessage {

    @Nullable
    private final AnchorInfoBorderModel entity;

    public AnchorInfoBorderConnectorMessage(@Nullable AnchorInfoBorderModel anchorInfoBorderModel) {
        this.entity = anchorInfoBorderModel;
    }

    public static /* synthetic */ AnchorInfoBorderConnectorMessage copy$default(AnchorInfoBorderConnectorMessage anchorInfoBorderConnectorMessage, AnchorInfoBorderModel anchorInfoBorderModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            anchorInfoBorderModel = anchorInfoBorderConnectorMessage.entity;
        }
        return anchorInfoBorderConnectorMessage.copy(anchorInfoBorderModel);
    }

    @Nullable
    public final AnchorInfoBorderModel component1() {
        return this.entity;
    }

    @NotNull
    public final AnchorInfoBorderConnectorMessage copy(@Nullable AnchorInfoBorderModel anchorInfoBorderModel) {
        return new AnchorInfoBorderConnectorMessage(anchorInfoBorderModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AnchorInfoBorderConnectorMessage) && kotlin.jvm.internal.s.d(this.entity, ((AnchorInfoBorderConnectorMessage) obj).entity);
    }

    @Nullable
    public final AnchorInfoBorderModel getEntity() {
        return this.entity;
    }

    public int hashCode() {
        AnchorInfoBorderModel anchorInfoBorderModel = this.entity;
        if (anchorInfoBorderModel == null) {
            return 0;
        }
        return anchorInfoBorderModel.hashCode();
    }

    @NotNull
    public String toString() {
        return "AnchorInfoBorderConnectorMessage(entity=" + ((Object) this.entity) + ")";
    }
}
