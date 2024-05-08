package com.cupidapp.live.liveshow.pk.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkGrpcModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkMixSuccessGrpcModel {

    @NotNull
    private final MultiPkMixSuccessModel entity;

    public MultiPkMixSuccessGrpcModel(@NotNull MultiPkMixSuccessModel entity) {
        s.i(entity, "entity");
        this.entity = entity;
    }

    public static /* synthetic */ MultiPkMixSuccessGrpcModel copy$default(MultiPkMixSuccessGrpcModel multiPkMixSuccessGrpcModel, MultiPkMixSuccessModel multiPkMixSuccessModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            multiPkMixSuccessModel = multiPkMixSuccessGrpcModel.entity;
        }
        return multiPkMixSuccessGrpcModel.copy(multiPkMixSuccessModel);
    }

    @NotNull
    public final MultiPkMixSuccessModel component1() {
        return this.entity;
    }

    @NotNull
    public final MultiPkMixSuccessGrpcModel copy(@NotNull MultiPkMixSuccessModel entity) {
        s.i(entity, "entity");
        return new MultiPkMixSuccessGrpcModel(entity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MultiPkMixSuccessGrpcModel) && s.d(this.entity, ((MultiPkMixSuccessGrpcModel) obj).entity);
    }

    @NotNull
    public final MultiPkMixSuccessModel getEntity() {
        return this.entity;
    }

    public int hashCode() {
        return this.entity.hashCode();
    }

    @NotNull
    public String toString() {
        return "MultiPkMixSuccessGrpcModel(entity=" + ((Object) this.entity) + ")";
    }
}
