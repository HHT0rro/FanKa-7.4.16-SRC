package com.cupidapp.live.liveshow.pk.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkGrpcModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkEndGrpcModel {

    @NotNull
    private final MultiPkEndModel entity;

    public MultiPkEndGrpcModel(@NotNull MultiPkEndModel entity) {
        s.i(entity, "entity");
        this.entity = entity;
    }

    public static /* synthetic */ MultiPkEndGrpcModel copy$default(MultiPkEndGrpcModel multiPkEndGrpcModel, MultiPkEndModel multiPkEndModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            multiPkEndModel = multiPkEndGrpcModel.entity;
        }
        return multiPkEndGrpcModel.copy(multiPkEndModel);
    }

    @NotNull
    public final MultiPkEndModel component1() {
        return this.entity;
    }

    @NotNull
    public final MultiPkEndGrpcModel copy(@NotNull MultiPkEndModel entity) {
        s.i(entity, "entity");
        return new MultiPkEndGrpcModel(entity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MultiPkEndGrpcModel) && s.d(this.entity, ((MultiPkEndGrpcModel) obj).entity);
    }

    @NotNull
    public final MultiPkEndModel getEntity() {
        return this.entity;
    }

    public int hashCode() {
        return this.entity.hashCode();
    }

    @NotNull
    public String toString() {
        return "MultiPkEndGrpcModel(entity=" + ((Object) this.entity) + ")";
    }
}
