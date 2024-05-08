package com.cupidapp.live.liveshow.pk.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkGrpcModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkFirstBloodGrpcModel {

    @NotNull
    private final MultiPkFirstBloodModel entity;

    public MultiPkFirstBloodGrpcModel(@NotNull MultiPkFirstBloodModel entity) {
        s.i(entity, "entity");
        this.entity = entity;
    }

    public static /* synthetic */ MultiPkFirstBloodGrpcModel copy$default(MultiPkFirstBloodGrpcModel multiPkFirstBloodGrpcModel, MultiPkFirstBloodModel multiPkFirstBloodModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            multiPkFirstBloodModel = multiPkFirstBloodGrpcModel.entity;
        }
        return multiPkFirstBloodGrpcModel.copy(multiPkFirstBloodModel);
    }

    @NotNull
    public final MultiPkFirstBloodModel component1() {
        return this.entity;
    }

    @NotNull
    public final MultiPkFirstBloodGrpcModel copy(@NotNull MultiPkFirstBloodModel entity) {
        s.i(entity, "entity");
        return new MultiPkFirstBloodGrpcModel(entity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MultiPkFirstBloodGrpcModel) && s.d(this.entity, ((MultiPkFirstBloodGrpcModel) obj).entity);
    }

    @NotNull
    public final MultiPkFirstBloodModel getEntity() {
        return this.entity;
    }

    public int hashCode() {
        return this.entity.hashCode();
    }

    @NotNull
    public String toString() {
        return "MultiPkFirstBloodGrpcModel(entity=" + ((Object) this.entity) + ")";
    }
}
