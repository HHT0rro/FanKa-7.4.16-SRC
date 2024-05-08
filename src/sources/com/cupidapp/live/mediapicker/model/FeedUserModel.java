package com.cupidapp.live.mediapicker.model;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.profile.model.User;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserVideoListModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FeedUserModel implements Serializable {

    @Nullable
    private final ImageModel avatarImage;

    @Nullable
    private final String label;
    private boolean liked;
    private final boolean likedMe;

    @Nullable
    private final String name;

    @Nullable
    private final String onlineLiveShowId;
    private final boolean onlineShowOpen;

    @NotNull
    private final String userId;

    public FeedUserModel(@NotNull String userId, @Nullable String str, @Nullable String str2, @Nullable ImageModel imageModel, boolean z10, boolean z11, boolean z12, @Nullable String str3) {
        s.i(userId, "userId");
        this.userId = userId;
        this.label = str;
        this.name = str2;
        this.avatarImage = imageModel;
        this.likedMe = z10;
        this.liked = z11;
        this.onlineShowOpen = z12;
        this.onlineLiveShowId = str3;
    }

    @NotNull
    public final String component1() {
        return this.userId;
    }

    @Nullable
    public final String component2() {
        return this.label;
    }

    @Nullable
    public final String component3() {
        return this.name;
    }

    @Nullable
    public final ImageModel component4() {
        return this.avatarImage;
    }

    public final boolean component5() {
        return this.likedMe;
    }

    public final boolean component6() {
        return this.liked;
    }

    public final boolean component7() {
        return this.onlineShowOpen;
    }

    @Nullable
    public final String component8() {
        return this.onlineLiveShowId;
    }

    @NotNull
    public final FeedUserModel copy(@NotNull String userId, @Nullable String str, @Nullable String str2, @Nullable ImageModel imageModel, boolean z10, boolean z11, boolean z12, @Nullable String str3) {
        s.i(userId, "userId");
        return new FeedUserModel(userId, str, str2, imageModel, z10, z11, z12, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedUserModel)) {
            return false;
        }
        FeedUserModel feedUserModel = (FeedUserModel) obj;
        return s.d(this.userId, feedUserModel.userId) && s.d(this.label, feedUserModel.label) && s.d(this.name, feedUserModel.name) && s.d(this.avatarImage, feedUserModel.avatarImage) && this.likedMe == feedUserModel.likedMe && this.liked == feedUserModel.liked && this.onlineShowOpen == feedUserModel.onlineShowOpen && s.d(this.onlineLiveShowId, feedUserModel.onlineLiveShowId);
    }

    @Nullable
    public final ImageModel getAvatarImage() {
        return this.avatarImage;
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    public final boolean getLiked() {
        return this.liked;
    }

    public final boolean getLikedMe() {
        return this.likedMe;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getOnlineLiveShowId() {
        return this.onlineLiveShowId;
    }

    public final boolean getOnlineShowOpen() {
        return this.onlineShowOpen;
    }

    @NotNull
    public final String getRelationship() {
        boolean z10 = this.liked;
        return (z10 && this.likedMe) ? "匹配" : z10 ? "关注了对方" : this.likedMe ? "被对方关注" : isMe() ? "自己" : "无关系";
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.userId.hashCode() * 31;
        String str = this.label;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.name;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        ImageModel imageModel = this.avatarImage;
        int hashCode4 = (hashCode3 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        boolean z10 = this.likedMe;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode4 + i10) * 31;
        boolean z11 = this.liked;
        int i12 = z11;
        if (z11 != 0) {
            i12 = 1;
        }
        int i13 = (i11 + i12) * 31;
        boolean z12 = this.onlineShowOpen;
        int i14 = (i13 + (z12 ? 1 : z12 ? 1 : 0)) * 31;
        String str3 = this.onlineLiveShowId;
        return i14 + (str3 != null ? str3.hashCode() : 0);
    }

    public final boolean isMe() {
        User X = p1.g.f52734a.X();
        return s.d(X != null ? X.userId() : null, this.userId);
    }

    public final void setLiked(boolean z10) {
        this.liked = z10;
    }

    @NotNull
    public String toString() {
        String str = this.userId;
        String str2 = this.label;
        String str3 = this.name;
        ImageModel imageModel = this.avatarImage;
        return "FeedUserModel(userId=" + str + ", label=" + str2 + ", name=" + str3 + ", avatarImage=" + ((Object) imageModel) + ", likedMe=" + this.likedMe + ", liked=" + this.liked + ", onlineShowOpen=" + this.onlineShowOpen + ", onlineLiveShowId=" + this.onlineLiveShowId + ")";
    }

    public final void userLiked() {
        if (this.liked) {
            return;
        }
        this.liked = true;
    }

    public /* synthetic */ FeedUserModel(String str, String str2, String str3, ImageModel imageModel, boolean z10, boolean z11, boolean z12, String str4, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, imageModel, (i10 & 16) != 0 ? false : z10, (i10 & 32) != 0 ? false : z11, (i10 & 64) != 0 ? false : z12, str4);
    }
}
