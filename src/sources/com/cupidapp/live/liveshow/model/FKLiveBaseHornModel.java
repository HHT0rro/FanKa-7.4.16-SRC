package com.cupidapp.live.liveshow.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveHornLinkModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveBaseHornModel {

    @NotNull
    private final FKLiveHornModel entity;

    public FKLiveBaseHornModel(@NotNull FKLiveHornModel entity) {
        s.i(entity, "entity");
        this.entity = entity;
    }

    public static /* synthetic */ FKLiveBaseHornModel copy$default(FKLiveBaseHornModel fKLiveBaseHornModel, FKLiveHornModel fKLiveHornModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            fKLiveHornModel = fKLiveBaseHornModel.entity;
        }
        return fKLiveBaseHornModel.copy(fKLiveHornModel);
    }

    @NotNull
    public final FKLiveHornModel component1() {
        return this.entity;
    }

    @NotNull
    public final FKLiveBaseHornModel copy(@NotNull FKLiveHornModel entity) {
        s.i(entity, "entity");
        return new FKLiveBaseHornModel(entity);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FKLiveBaseHornModel) && s.d(this.entity, ((FKLiveBaseHornModel) obj).entity);
    }

    @NotNull
    public final FKLiveHornModel getEntity() {
        return this.entity;
    }

    public int hashCode() {
        return this.entity.hashCode();
    }

    @NotNull
    public String toString() {
        return "FKLiveBaseHornModel(entity=" + ((Object) this.entity) + ")";
    }
}
