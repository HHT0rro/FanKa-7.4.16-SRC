package com.cupidapp.live.feed.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PostLimitFriendsModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PostLimitFriendsModel {

    @NotNull
    private final List<UserWithPostLimitStatusModel> data;

    @Nullable
    private final String rcmdType;

    @Nullable
    private final String title;

    public PostLimitFriendsModel(@Nullable String str, @NotNull List<UserWithPostLimitStatusModel> data, @Nullable String str2) {
        s.i(data, "data");
        this.title = str;
        this.data = data;
        this.rcmdType = str2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PostLimitFriendsModel copy$default(PostLimitFriendsModel postLimitFriendsModel, String str, List list, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = postLimitFriendsModel.title;
        }
        if ((i10 & 2) != 0) {
            list = postLimitFriendsModel.data;
        }
        if ((i10 & 4) != 0) {
            str2 = postLimitFriendsModel.rcmdType;
        }
        return postLimitFriendsModel.copy(str, list, str2);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final List<UserWithPostLimitStatusModel> component2() {
        return this.data;
    }

    @Nullable
    public final String component3() {
        return this.rcmdType;
    }

    @NotNull
    public final PostLimitFriendsModel copy(@Nullable String str, @NotNull List<UserWithPostLimitStatusModel> data, @Nullable String str2) {
        s.i(data, "data");
        return new PostLimitFriendsModel(str, data, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PostLimitFriendsModel)) {
            return false;
        }
        PostLimitFriendsModel postLimitFriendsModel = (PostLimitFriendsModel) obj;
        return s.d(this.title, postLimitFriendsModel.title) && s.d(this.data, postLimitFriendsModel.data) && s.d(this.rcmdType, postLimitFriendsModel.rcmdType);
    }

    @NotNull
    public final List<UserWithPostLimitStatusModel> getData() {
        return this.data;
    }

    @Nullable
    public final String getRcmdType() {
        return this.rcmdType;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.data.hashCode()) * 31;
        String str2 = this.rcmdType;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.title;
        List<UserWithPostLimitStatusModel> list = this.data;
        return "PostLimitFriendsModel(title=" + str + ", data=" + ((Object) list) + ", rcmdType=" + this.rcmdType + ")";
    }

    public /* synthetic */ PostLimitFriendsModel(String str, List list, String str2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, list, (i10 & 4) != 0 ? null : str2);
    }
}
