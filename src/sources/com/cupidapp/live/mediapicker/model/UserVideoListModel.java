package com.cupidapp.live.mediapicker.model;

import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserVideoListModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserVideoListModel implements Serializable {

    @Nullable
    private final String readParam;
    private boolean unread;

    @NotNull
    private final FeedUserModel user;

    @Nullable
    private final List<FeedItemModel> videoList;

    public UserVideoListModel(@NotNull FeedUserModel user, @Nullable List<FeedItemModel> list, boolean z10, @Nullable String str) {
        s.i(user, "user");
        this.user = user;
        this.videoList = list;
        this.unread = z10;
        this.readParam = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UserVideoListModel copy$default(UserVideoListModel userVideoListModel, FeedUserModel feedUserModel, List list, boolean z10, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            feedUserModel = userVideoListModel.user;
        }
        if ((i10 & 2) != 0) {
            list = userVideoListModel.videoList;
        }
        if ((i10 & 4) != 0) {
            z10 = userVideoListModel.unread;
        }
        if ((i10 & 8) != 0) {
            str = userVideoListModel.readParam;
        }
        return userVideoListModel.copy(feedUserModel, list, z10, str);
    }

    @NotNull
    public final FeedUserModel component1() {
        return this.user;
    }

    @Nullable
    public final List<FeedItemModel> component2() {
        return this.videoList;
    }

    public final boolean component3() {
        return this.unread;
    }

    @Nullable
    public final String component4() {
        return this.readParam;
    }

    @NotNull
    public final UserVideoListModel copy(@NotNull FeedUserModel user, @Nullable List<FeedItemModel> list, boolean z10, @Nullable String str) {
        s.i(user, "user");
        return new UserVideoListModel(user, list, z10, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserVideoListModel)) {
            return false;
        }
        UserVideoListModel userVideoListModel = (UserVideoListModel) obj;
        return s.d(this.user, userVideoListModel.user) && s.d(this.videoList, userVideoListModel.videoList) && this.unread == userVideoListModel.unread && s.d(this.readParam, userVideoListModel.readParam);
    }

    @Nullable
    public final String getReadParam() {
        return this.readParam;
    }

    public final boolean getUnread() {
        return this.unread;
    }

    @NotNull
    public final FeedUserModel getUser() {
        return this.user;
    }

    @Nullable
    public final List<FeedItemModel> getVideoList() {
        return this.videoList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.user.hashCode() * 31;
        List<FeedItemModel> list = this.videoList;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        boolean z10 = this.unread;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode2 + i10) * 31;
        String str = this.readParam;
        return i11 + (str != null ? str.hashCode() : 0);
    }

    public final void setUnread(boolean z10) {
        this.unread = z10;
    }

    @NotNull
    public String toString() {
        FeedUserModel feedUserModel = this.user;
        List<FeedItemModel> list = this.videoList;
        return "UserVideoListModel(user=" + ((Object) feedUserModel) + ", videoList=" + ((Object) list) + ", unread=" + this.unread + ", readParam=" + this.readParam + ")";
    }

    public /* synthetic */ UserVideoListModel(FeedUserModel feedUserModel, List list, boolean z10, String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(feedUserModel, list, (i10 & 4) != 0 ? false : z10, str);
    }
}
