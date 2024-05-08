package com.cupidapp.live.setting.model;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserInfoUiModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserInfoUiModel {

    @Nullable
    private final String alohaCount;

    @Nullable
    private final String alohaGetCount;

    @Nullable
    private final ImageModel avatarImage;

    @Nullable
    private final String matchCount;

    @Nullable
    private final String name;

    @Nullable
    private final String postCount;

    @Nullable
    private final String summary;

    @NotNull
    private final User user;

    public UserInfoUiModel(@NotNull User user, @Nullable ImageModel imageModel, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        s.i(user, "user");
        this.user = user;
        this.avatarImage = imageModel;
        this.name = str;
        this.matchCount = str2;
        this.alohaGetCount = str3;
        this.alohaCount = str4;
        this.postCount = str5;
        this.summary = str6;
    }

    @NotNull
    public final User component1() {
        return this.user;
    }

    @Nullable
    public final ImageModel component2() {
        return this.avatarImage;
    }

    @Nullable
    public final String component3() {
        return this.name;
    }

    @Nullable
    public final String component4() {
        return this.matchCount;
    }

    @Nullable
    public final String component5() {
        return this.alohaGetCount;
    }

    @Nullable
    public final String component6() {
        return this.alohaCount;
    }

    @Nullable
    public final String component7() {
        return this.postCount;
    }

    @Nullable
    public final String component8() {
        return this.summary;
    }

    @NotNull
    public final UserInfoUiModel copy(@NotNull User user, @Nullable ImageModel imageModel, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        s.i(user, "user");
        return new UserInfoUiModel(user, imageModel, str, str2, str3, str4, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserInfoUiModel)) {
            return false;
        }
        UserInfoUiModel userInfoUiModel = (UserInfoUiModel) obj;
        return s.d(this.user, userInfoUiModel.user) && s.d(this.avatarImage, userInfoUiModel.avatarImage) && s.d(this.name, userInfoUiModel.name) && s.d(this.matchCount, userInfoUiModel.matchCount) && s.d(this.alohaGetCount, userInfoUiModel.alohaGetCount) && s.d(this.alohaCount, userInfoUiModel.alohaCount) && s.d(this.postCount, userInfoUiModel.postCount) && s.d(this.summary, userInfoUiModel.summary);
    }

    @Nullable
    public final String getAlohaCount() {
        return this.alohaCount;
    }

    @Nullable
    public final String getAlohaGetCount() {
        return this.alohaGetCount;
    }

    @Nullable
    public final ImageModel getAvatarImage() {
        return this.avatarImage;
    }

    @Nullable
    public final String getMatchCount() {
        return this.matchCount;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getPostCount() {
        return this.postCount;
    }

    @Nullable
    public final String getSummary() {
        return this.summary;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        int hashCode = this.user.hashCode() * 31;
        ImageModel imageModel = this.avatarImage;
        int hashCode2 = (hashCode + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str = this.name;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.matchCount;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.alohaGetCount;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.alohaCount;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.postCount;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.summary;
        return hashCode7 + (str6 != null ? str6.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        User user = this.user;
        ImageModel imageModel = this.avatarImage;
        return "UserInfoUiModel(user=" + ((Object) user) + ", avatarImage=" + ((Object) imageModel) + ", name=" + this.name + ", matchCount=" + this.matchCount + ", alohaGetCount=" + this.alohaGetCount + ", alohaCount=" + this.alohaCount + ", postCount=" + this.postCount + ", summary=" + this.summary + ")";
    }
}
