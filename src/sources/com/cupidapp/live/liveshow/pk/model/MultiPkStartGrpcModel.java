package com.cupidapp.live.liveshow.pk.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkGrpcModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkStartGrpcModel {

    @NotNull
    private final MultiPkStartModel entity;

    public MultiPkStartGrpcModel(@NotNull MultiPkStartModel entity) {
        s.i(entity, "entity");
        this.entity = entity;
    }

    public static /* synthetic */ MultiPkStartGrpcModel copy$default(MultiPkStartGrpcModel multiPkStartGrpcModel, MultiPkStartModel multiPkStartModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            multiPkStartModel = multiPkStartGrpcModel.entity;
        }
        return multiPkStartGrpcModel.copy(multiPkStartModel);
    }

    @NotNull
    public final MultiPkStartModel component1() {
        return this.entity;
    }

    @NotNull
    public final MultiPkStartGrpcModel copy(@NotNull MultiPkStartModel entity) {
        s.i(entity, "entity");
        return new MultiPkStartGrpcModel(entity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MultiPkStartGrpcModel) && s.d(this.entity, ((MultiPkStartGrpcModel) obj).entity);
    }

    @NotNull
    public final MultiPkStartModel getEntity() {
        return this.entity;
    }

    public int hashCode() {
        return this.entity.hashCode();
    }

    @NotNull
    public String toString() {
        return "MultiPkStartGrpcModel(entity=" + ((Object) this.entity) + ")";
    }
}
