package com.cupidapp.live.liveshow.pk.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkGrpcModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkCancelPrepareGrpcModel {

    @NotNull
    private final MultiPkCancelPrepareModel entity;

    public MultiPkCancelPrepareGrpcModel(@NotNull MultiPkCancelPrepareModel entity) {
        s.i(entity, "entity");
        this.entity = entity;
    }

    public static /* synthetic */ MultiPkCancelPrepareGrpcModel copy$default(MultiPkCancelPrepareGrpcModel multiPkCancelPrepareGrpcModel, MultiPkCancelPrepareModel multiPkCancelPrepareModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            multiPkCancelPrepareModel = multiPkCancelPrepareGrpcModel.entity;
        }
        return multiPkCancelPrepareGrpcModel.copy(multiPkCancelPrepareModel);
    }

    @NotNull
    public final MultiPkCancelPrepareModel component1() {
        return this.entity;
    }

    @NotNull
    public final MultiPkCancelPrepareGrpcModel copy(@NotNull MultiPkCancelPrepareModel entity) {
        s.i(entity, "entity");
        return new MultiPkCancelPrepareGrpcModel(entity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MultiPkCancelPrepareGrpcModel) && s.d(this.entity, ((MultiPkCancelPrepareGrpcModel) obj).entity);
    }

    @NotNull
    public final MultiPkCancelPrepareModel getEntity() {
        return this.entity;
    }

    public int hashCode() {
        return this.entity.hashCode();
    }

    @NotNull
    public String toString() {
        return "MultiPkCancelPrepareGrpcModel(entity=" + ((Object) this.entity) + ")";
    }
}
