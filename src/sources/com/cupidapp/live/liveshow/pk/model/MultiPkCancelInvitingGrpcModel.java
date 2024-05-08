package com.cupidapp.live.liveshow.pk.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkGrpcModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkCancelInvitingGrpcModel {

    @NotNull
    private final MultiPkCancelInvitingModel entity;

    public MultiPkCancelInvitingGrpcModel(@NotNull MultiPkCancelInvitingModel entity) {
        s.i(entity, "entity");
        this.entity = entity;
    }

    public static /* synthetic */ MultiPkCancelInvitingGrpcModel copy$default(MultiPkCancelInvitingGrpcModel multiPkCancelInvitingGrpcModel, MultiPkCancelInvitingModel multiPkCancelInvitingModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            multiPkCancelInvitingModel = multiPkCancelInvitingGrpcModel.entity;
        }
        return multiPkCancelInvitingGrpcModel.copy(multiPkCancelInvitingModel);
    }

    @NotNull
    public final MultiPkCancelInvitingModel component1() {
        return this.entity;
    }

    @NotNull
    public final MultiPkCancelInvitingGrpcModel copy(@NotNull MultiPkCancelInvitingModel entity) {
        s.i(entity, "entity");
        return new MultiPkCancelInvitingGrpcModel(entity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MultiPkCancelInvitingGrpcModel) && s.d(this.entity, ((MultiPkCancelInvitingGrpcModel) obj).entity);
    }

    @NotNull
    public final MultiPkCancelInvitingModel getEntity() {
        return this.entity;
    }

    public int hashCode() {
        return this.entity.hashCode();
    }

    @NotNull
    public String toString() {
        return "MultiPkCancelInvitingGrpcModel(entity=" + ((Object) this.entity) + ")";
    }
}
