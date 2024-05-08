package com.cupidapp.live.profile.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CloseFriendListModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class CloseFriendListModel {

    @Nullable
    private final List<User> closeFriendList;

    @Nullable
    private final String nextCursorId;

    @Nullable
    private final List<User> recommendList;

    public CloseFriendListModel(@Nullable List<User> list, @Nullable List<User> list2, @Nullable String str) {
        this.closeFriendList = list;
        this.recommendList = list2;
        this.nextCursorId = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CloseFriendListModel copy$default(CloseFriendListModel closeFriendListModel, List list, List list2, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = closeFriendListModel.closeFriendList;
        }
        if ((i10 & 2) != 0) {
            list2 = closeFriendListModel.recommendList;
        }
        if ((i10 & 4) != 0) {
            str = closeFriendListModel.nextCursorId;
        }
        return closeFriendListModel.copy(list, list2, str);
    }

    @Nullable
    public final List<User> component1() {
        return this.closeFriendList;
    }

    @Nullable
    public final List<User> component2() {
        return this.recommendList;
    }

    @Nullable
    public final String component3() {
        return this.nextCursorId;
    }

    @NotNull
    public final CloseFriendListModel copy(@Nullable List<User> list, @Nullable List<User> list2, @Nullable String str) {
        return new CloseFriendListModel(list, list2, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CloseFriendListModel)) {
            return false;
        }
        CloseFriendListModel closeFriendListModel = (CloseFriendListModel) obj;
        return s.d(this.closeFriendList, closeFriendListModel.closeFriendList) && s.d(this.recommendList, closeFriendListModel.recommendList) && s.d(this.nextCursorId, closeFriendListModel.nextCursorId);
    }

    @Nullable
    public final List<User> getCloseFriendList() {
        return this.closeFriendList;
    }

    @Nullable
    public final String getNextCursorId() {
        return this.nextCursorId;
    }

    @Nullable
    public final List<User> getRecommendList() {
        return this.recommendList;
    }

    public int hashCode() {
        List<User> list = this.closeFriendList;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<User> list2 = this.recommendList;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str = this.nextCursorId;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        List<User> list = this.closeFriendList;
        List<User> list2 = this.recommendList;
        return "CloseFriendListModel(closeFriendList=" + ((Object) list) + ", recommendList=" + ((Object) list2) + ", nextCursorId=" + this.nextCursorId + ")";
    }
}
