package com.cupidapp.live.liveshow.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLivePkResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LivePkFriendListResult {
    private final boolean appointAccept;

    @Nullable
    private final List<LivePkUserModel> friendList;

    @Nullable
    private final List<LivePkUserModel> requestList;

    public LivePkFriendListResult(boolean z10, @Nullable List<LivePkUserModel> list, @Nullable List<LivePkUserModel> list2) {
        this.appointAccept = z10;
        this.friendList = list;
        this.requestList = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LivePkFriendListResult copy$default(LivePkFriendListResult livePkFriendListResult, boolean z10, List list, List list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = livePkFriendListResult.appointAccept;
        }
        if ((i10 & 2) != 0) {
            list = livePkFriendListResult.friendList;
        }
        if ((i10 & 4) != 0) {
            list2 = livePkFriendListResult.requestList;
        }
        return livePkFriendListResult.copy(z10, list, list2);
    }

    public final boolean component1() {
        return this.appointAccept;
    }

    @Nullable
    public final List<LivePkUserModel> component2() {
        return this.friendList;
    }

    @Nullable
    public final List<LivePkUserModel> component3() {
        return this.requestList;
    }

    @NotNull
    public final LivePkFriendListResult copy(boolean z10, @Nullable List<LivePkUserModel> list, @Nullable List<LivePkUserModel> list2) {
        return new LivePkFriendListResult(z10, list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LivePkFriendListResult)) {
            return false;
        }
        LivePkFriendListResult livePkFriendListResult = (LivePkFriendListResult) obj;
        return this.appointAccept == livePkFriendListResult.appointAccept && s.d(this.friendList, livePkFriendListResult.friendList) && s.d(this.requestList, livePkFriendListResult.requestList);
    }

    public final boolean getAppointAccept() {
        return this.appointAccept;
    }

    @Nullable
    public final List<LivePkUserModel> getFriendList() {
        return this.friendList;
    }

    @Nullable
    public final List<LivePkUserModel> getRequestList() {
        return this.requestList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z10 = this.appointAccept;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        List<LivePkUserModel> list = this.friendList;
        int hashCode = (i10 + (list == null ? 0 : list.hashCode())) * 31;
        List<LivePkUserModel> list2 = this.requestList;
        return hashCode + (list2 != null ? list2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "LivePkFriendListResult(appointAccept=" + this.appointAccept + ", friendList=" + ((Object) this.friendList) + ", requestList=" + ((Object) this.requestList) + ")";
    }
}
