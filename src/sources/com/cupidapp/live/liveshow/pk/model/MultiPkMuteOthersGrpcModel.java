package com.cupidapp.live.liveshow.pk.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkGrpcModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkMuteOthersGrpcModel {

    @NotNull
    private final MultiPkMuteOthersModel entity;

    public MultiPkMuteOthersGrpcModel(@NotNull MultiPkMuteOthersModel entity) {
        s.i(entity, "entity");
        this.entity = entity;
    }

    public static /* synthetic */ MultiPkMuteOthersGrpcModel copy$default(MultiPkMuteOthersGrpcModel multiPkMuteOthersGrpcModel, MultiPkMuteOthersModel multiPkMuteOthersModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            multiPkMuteOthersModel = multiPkMuteOthersGrpcModel.entity;
        }
        return multiPkMuteOthersGrpcModel.copy(multiPkMuteOthersModel);
    }

    @NotNull
    public final MultiPkMuteOthersModel component1() {
        return this.entity;
    }

    @NotNull
    public final MultiPkMuteOthersGrpcModel copy(@NotNull MultiPkMuteOthersModel entity) {
        s.i(entity, "entity");
        return new MultiPkMuteOthersGrpcModel(entity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MultiPkMuteOthersGrpcModel) && s.d(this.entity, ((MultiPkMuteOthersGrpcModel) obj).entity);
    }

    @NotNull
    public final MultiPkMuteOthersModel getEntity() {
        return this.entity;
    }

    public int hashCode() {
        return this.entity.hashCode();
    }

    @NotNull
    public String toString() {
        return "MultiPkMuteOthersGrpcModel(entity=" + ((Object) this.entity) + ")";
    }
}
