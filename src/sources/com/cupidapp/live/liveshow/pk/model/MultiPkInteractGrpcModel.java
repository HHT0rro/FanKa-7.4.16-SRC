package com.cupidapp.live.liveshow.pk.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkGrpcModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkInteractGrpcModel {

    @NotNull
    private final MultiPkInteractModel entity;

    public MultiPkInteractGrpcModel(@NotNull MultiPkInteractModel entity) {
        s.i(entity, "entity");
        this.entity = entity;
    }

    public static /* synthetic */ MultiPkInteractGrpcModel copy$default(MultiPkInteractGrpcModel multiPkInteractGrpcModel, MultiPkInteractModel multiPkInteractModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            multiPkInteractModel = multiPkInteractGrpcModel.entity;
        }
        return multiPkInteractGrpcModel.copy(multiPkInteractModel);
    }

    @NotNull
    public final MultiPkInteractModel component1() {
        return this.entity;
    }

    @NotNull
    public final MultiPkInteractGrpcModel copy(@NotNull MultiPkInteractModel entity) {
        s.i(entity, "entity");
        return new MultiPkInteractGrpcModel(entity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MultiPkInteractGrpcModel) && s.d(this.entity, ((MultiPkInteractGrpcModel) obj).entity);
    }

    @NotNull
    public final MultiPkInteractModel getEntity() {
        return this.entity;
    }

    public int hashCode() {
        return this.entity.hashCode();
    }

    @NotNull
    public String toString() {
        return "MultiPkInteractGrpcModel(entity=" + ((Object) this.entity) + ")";
    }
}
