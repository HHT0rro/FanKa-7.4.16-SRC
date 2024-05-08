package com.cupidapp.live.liveshow.pk.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkGrpcModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkAgreeInvitingGrpcModel {

    @NotNull
    private final MultiPkAgreeInvitingModel entity;

    public MultiPkAgreeInvitingGrpcModel(@NotNull MultiPkAgreeInvitingModel entity) {
        s.i(entity, "entity");
        this.entity = entity;
    }

    public static /* synthetic */ MultiPkAgreeInvitingGrpcModel copy$default(MultiPkAgreeInvitingGrpcModel multiPkAgreeInvitingGrpcModel, MultiPkAgreeInvitingModel multiPkAgreeInvitingModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            multiPkAgreeInvitingModel = multiPkAgreeInvitingGrpcModel.entity;
        }
        return multiPkAgreeInvitingGrpcModel.copy(multiPkAgreeInvitingModel);
    }

    @NotNull
    public final MultiPkAgreeInvitingModel component1() {
        return this.entity;
    }

    @NotNull
    public final MultiPkAgreeInvitingGrpcModel copy(@NotNull MultiPkAgreeInvitingModel entity) {
        s.i(entity, "entity");
        return new MultiPkAgreeInvitingGrpcModel(entity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MultiPkAgreeInvitingGrpcModel) && s.d(this.entity, ((MultiPkAgreeInvitingGrpcModel) obj).entity);
    }

    @NotNull
    public final MultiPkAgreeInvitingModel getEntity() {
        return this.entity;
    }

    public int hashCode() {
        return this.entity.hashCode();
    }

    @NotNull
    public String toString() {
        return "MultiPkAgreeInvitingGrpcModel(entity=" + ((Object) this.entity) + ")";
    }
}
