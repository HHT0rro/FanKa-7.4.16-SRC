package com.cupidapp.live.liveshow.pk.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkGrpcModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkRefuseInvitingGrpcModel {

    @NotNull
    private final MultiPkRefuseInvitingModel entity;

    public MultiPkRefuseInvitingGrpcModel(@NotNull MultiPkRefuseInvitingModel entity) {
        s.i(entity, "entity");
        this.entity = entity;
    }

    public static /* synthetic */ MultiPkRefuseInvitingGrpcModel copy$default(MultiPkRefuseInvitingGrpcModel multiPkRefuseInvitingGrpcModel, MultiPkRefuseInvitingModel multiPkRefuseInvitingModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            multiPkRefuseInvitingModel = multiPkRefuseInvitingGrpcModel.entity;
        }
        return multiPkRefuseInvitingGrpcModel.copy(multiPkRefuseInvitingModel);
    }

    @NotNull
    public final MultiPkRefuseInvitingModel component1() {
        return this.entity;
    }

    @NotNull
    public final MultiPkRefuseInvitingGrpcModel copy(@NotNull MultiPkRefuseInvitingModel entity) {
        s.i(entity, "entity");
        return new MultiPkRefuseInvitingGrpcModel(entity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MultiPkRefuseInvitingGrpcModel) && s.d(this.entity, ((MultiPkRefuseInvitingGrpcModel) obj).entity);
    }

    @NotNull
    public final MultiPkRefuseInvitingModel getEntity() {
        return this.entity;
    }

    public int hashCode() {
        return this.entity.hashCode();
    }

    @NotNull
    public String toString() {
        return "MultiPkRefuseInvitingGrpcModel(entity=" + ((Object) this.entity) + ")";
    }
}
