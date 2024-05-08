package com.cupidapp.live.profile.model;

import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FriendPraiseModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FriendPraiseResult implements Serializable {

    @Nullable
    private final Boolean canEdit;

    @Nullable
    private final List<FriendPraiseDetailModel> list;

    @Nullable
    private final String nextCursorId;

    @Nullable
    private final FriendPraiseShareModel share;

    public FriendPraiseResult(@Nullable List<FriendPraiseDetailModel> list, @Nullable String str, @Nullable FriendPraiseShareModel friendPraiseShareModel, @Nullable Boolean bool) {
        this.list = list;
        this.nextCursorId = str;
        this.share = friendPraiseShareModel;
        this.canEdit = bool;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FriendPraiseResult copy$default(FriendPraiseResult friendPraiseResult, List list, String str, FriendPraiseShareModel friendPraiseShareModel, Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = friendPraiseResult.list;
        }
        if ((i10 & 2) != 0) {
            str = friendPraiseResult.nextCursorId;
        }
        if ((i10 & 4) != 0) {
            friendPraiseShareModel = friendPraiseResult.share;
        }
        if ((i10 & 8) != 0) {
            bool = friendPraiseResult.canEdit;
        }
        return friendPraiseResult.copy(list, str, friendPraiseShareModel, bool);
    }

    @Nullable
    public final List<FriendPraiseDetailModel> component1() {
        return this.list;
    }

    @Nullable
    public final String component2() {
        return this.nextCursorId;
    }

    @Nullable
    public final FriendPraiseShareModel component3() {
        return this.share;
    }

    @Nullable
    public final Boolean component4() {
        return this.canEdit;
    }

    @NotNull
    public final FriendPraiseResult copy(@Nullable List<FriendPraiseDetailModel> list, @Nullable String str, @Nullable FriendPraiseShareModel friendPraiseShareModel, @Nullable Boolean bool) {
        return new FriendPraiseResult(list, str, friendPraiseShareModel, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FriendPraiseResult)) {
            return false;
        }
        FriendPraiseResult friendPraiseResult = (FriendPraiseResult) obj;
        return s.d(this.list, friendPraiseResult.list) && s.d(this.nextCursorId, friendPraiseResult.nextCursorId) && s.d(this.share, friendPraiseResult.share) && s.d(this.canEdit, friendPraiseResult.canEdit);
    }

    @Nullable
    public final Boolean getCanEdit() {
        return this.canEdit;
    }

    @Nullable
    public final List<FriendPraiseDetailModel> getList() {
        return this.list;
    }

    @Nullable
    public final String getNextCursorId() {
        return this.nextCursorId;
    }

    @Nullable
    public final FriendPraiseShareModel getShare() {
        return this.share;
    }

    public int hashCode() {
        List<FriendPraiseDetailModel> list = this.list;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.nextCursorId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        FriendPraiseShareModel friendPraiseShareModel = this.share;
        int hashCode3 = (hashCode2 + (friendPraiseShareModel == null ? 0 : friendPraiseShareModel.hashCode())) * 31;
        Boolean bool = this.canEdit;
        return hashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        List<FriendPraiseDetailModel> list = this.list;
        return "FriendPraiseResult(list=" + ((Object) list) + ", nextCursorId=" + this.nextCursorId + ", share=" + ((Object) this.share) + ", canEdit=" + ((Object) this.canEdit) + ")";
    }
}
