package com.cupidapp.live.liveshow.pk.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkGrpcModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkInvitationGrpcModel {

    @NotNull
    private final MultiPkInvitationModel entity;

    public MultiPkInvitationGrpcModel(@NotNull MultiPkInvitationModel entity) {
        s.i(entity, "entity");
        this.entity = entity;
    }

    public static /* synthetic */ MultiPkInvitationGrpcModel copy$default(MultiPkInvitationGrpcModel multiPkInvitationGrpcModel, MultiPkInvitationModel multiPkInvitationModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            multiPkInvitationModel = multiPkInvitationGrpcModel.entity;
        }
        return multiPkInvitationGrpcModel.copy(multiPkInvitationModel);
    }

    @NotNull
    public final MultiPkInvitationModel component1() {
        return this.entity;
    }

    @NotNull
    public final MultiPkInvitationGrpcModel copy(@NotNull MultiPkInvitationModel entity) {
        s.i(entity, "entity");
        return new MultiPkInvitationGrpcModel(entity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MultiPkInvitationGrpcModel) && s.d(this.entity, ((MultiPkInvitationGrpcModel) obj).entity);
    }

    @NotNull
    public final MultiPkInvitationModel getEntity() {
        return this.entity;
    }

    public int hashCode() {
        return this.entity.hashCode();
    }

    @NotNull
    public String toString() {
        return "MultiPkInvitationGrpcModel(entity=" + ((Object) this.entity) + ")";
    }
}
