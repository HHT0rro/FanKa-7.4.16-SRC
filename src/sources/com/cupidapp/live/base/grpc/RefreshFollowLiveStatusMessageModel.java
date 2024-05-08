package com.cupidapp.live.base.grpc;

import com.cupidapp.live.liveshow.model.FollowLiveStatusModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RefreshFollowLiveStatusMessageModel {

    @Nullable
    private final FollowLiveStatusModel entity;

    public RefreshFollowLiveStatusMessageModel(@Nullable FollowLiveStatusModel followLiveStatusModel) {
        this.entity = followLiveStatusModel;
    }

    public static /* synthetic */ RefreshFollowLiveStatusMessageModel copy$default(RefreshFollowLiveStatusMessageModel refreshFollowLiveStatusMessageModel, FollowLiveStatusModel followLiveStatusModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            followLiveStatusModel = refreshFollowLiveStatusMessageModel.entity;
        }
        return refreshFollowLiveStatusMessageModel.copy(followLiveStatusModel);
    }

    @Nullable
    public final FollowLiveStatusModel component1() {
        return this.entity;
    }

    @NotNull
    public final RefreshFollowLiveStatusMessageModel copy(@Nullable FollowLiveStatusModel followLiveStatusModel) {
        return new RefreshFollowLiveStatusMessageModel(followLiveStatusModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RefreshFollowLiveStatusMessageModel) && kotlin.jvm.internal.s.d(this.entity, ((RefreshFollowLiveStatusMessageModel) obj).entity);
    }

    @Nullable
    public final FollowLiveStatusModel getEntity() {
        return this.entity;
    }

    public int hashCode() {
        FollowLiveStatusModel followLiveStatusModel = this.entity;
        if (followLiveStatusModel == null) {
            return 0;
        }
        return followLiveStatusModel.hashCode();
    }

    @NotNull
    public String toString() {
        return "RefreshFollowLiveStatusMessageModel(entity=" + ((Object) this.entity) + ")";
    }
}
