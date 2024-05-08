package com.cupidapp.live.liveshow.pk.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkGrpcModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkScoreUpdateGrpcModel {

    @NotNull
    private final MultiPkScoreUpdateModel entity;

    public MultiPkScoreUpdateGrpcModel(@NotNull MultiPkScoreUpdateModel entity) {
        s.i(entity, "entity");
        this.entity = entity;
    }

    public static /* synthetic */ MultiPkScoreUpdateGrpcModel copy$default(MultiPkScoreUpdateGrpcModel multiPkScoreUpdateGrpcModel, MultiPkScoreUpdateModel multiPkScoreUpdateModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            multiPkScoreUpdateModel = multiPkScoreUpdateGrpcModel.entity;
        }
        return multiPkScoreUpdateGrpcModel.copy(multiPkScoreUpdateModel);
    }

    @NotNull
    public final MultiPkScoreUpdateModel component1() {
        return this.entity;
    }

    @NotNull
    public final MultiPkScoreUpdateGrpcModel copy(@NotNull MultiPkScoreUpdateModel entity) {
        s.i(entity, "entity");
        return new MultiPkScoreUpdateGrpcModel(entity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MultiPkScoreUpdateGrpcModel) && s.d(this.entity, ((MultiPkScoreUpdateGrpcModel) obj).entity);
    }

    @NotNull
    public final MultiPkScoreUpdateModel getEntity() {
        return this.entity;
    }

    public int hashCode() {
        return this.entity.hashCode();
    }

    @NotNull
    public String toString() {
        return "MultiPkScoreUpdateGrpcModel(entity=" + ((Object) this.entity) + ")";
    }
}
