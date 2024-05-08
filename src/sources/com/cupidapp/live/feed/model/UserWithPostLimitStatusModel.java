package com.cupidapp.live.feed.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PostLimitFriendsModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class UserWithPostLimitStatusModel implements Serializable {

    @Nullable
    private Boolean aloha;

    @NotNull
    private final ImageModel avatarImage;

    @Nullable
    private final String avatarInfo;

    /* renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f14613id;

    /* renamed from: me, reason: collision with root package name */
    @Nullable
    private final Boolean f14614me;

    @Nullable
    private final String name;

    @Nullable
    private Integer readStatus;

    public UserWithPostLimitStatusModel(@NotNull String id2, @NotNull ImageModel avatarImage, @Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable Boolean bool, @Nullable Boolean bool2) {
        s.i(id2, "id");
        s.i(avatarImage, "avatarImage");
        this.f14613id = id2;
        this.avatarImage = avatarImage;
        this.name = str;
        this.readStatus = num;
        this.avatarInfo = str2;
        this.aloha = bool;
        this.f14614me = bool2;
    }

    public static /* synthetic */ UserWithPostLimitStatusModel copy$default(UserWithPostLimitStatusModel userWithPostLimitStatusModel, String str, ImageModel imageModel, String str2, Integer num, String str3, Boolean bool, Boolean bool2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = userWithPostLimitStatusModel.f14613id;
        }
        if ((i10 & 2) != 0) {
            imageModel = userWithPostLimitStatusModel.avatarImage;
        }
        ImageModel imageModel2 = imageModel;
        if ((i10 & 4) != 0) {
            str2 = userWithPostLimitStatusModel.name;
        }
        String str4 = str2;
        if ((i10 & 8) != 0) {
            num = userWithPostLimitStatusModel.readStatus;
        }
        Integer num2 = num;
        if ((i10 & 16) != 0) {
            str3 = userWithPostLimitStatusModel.avatarInfo;
        }
        String str5 = str3;
        if ((i10 & 32) != 0) {
            bool = userWithPostLimitStatusModel.aloha;
        }
        Boolean bool3 = bool;
        if ((i10 & 64) != 0) {
            bool2 = userWithPostLimitStatusModel.f14614me;
        }
        return userWithPostLimitStatusModel.copy(str, imageModel2, str4, num2, str5, bool3, bool2);
    }

    @NotNull
    public final String component1() {
        return this.f14613id;
    }

    @NotNull
    public final ImageModel component2() {
        return this.avatarImage;
    }

    @Nullable
    public final String component3() {
        return this.name;
    }

    @Nullable
    public final Integer component4() {
        return this.readStatus;
    }

    @Nullable
    public final String component5() {
        return this.avatarInfo;
    }

    @Nullable
    public final Boolean component6() {
        return this.aloha;
    }

    @Nullable
    public final Boolean component7() {
        return this.f14614me;
    }

    @NotNull
    public final UserWithPostLimitStatusModel copy(@NotNull String id2, @NotNull ImageModel avatarImage, @Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable Boolean bool, @Nullable Boolean bool2) {
        s.i(id2, "id");
        s.i(avatarImage, "avatarImage");
        return new UserWithPostLimitStatusModel(id2, avatarImage, str, num, str2, bool, bool2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserWithPostLimitStatusModel)) {
            return false;
        }
        UserWithPostLimitStatusModel userWithPostLimitStatusModel = (UserWithPostLimitStatusModel) obj;
        return s.d(this.f14613id, userWithPostLimitStatusModel.f14613id) && s.d(this.avatarImage, userWithPostLimitStatusModel.avatarImage) && s.d(this.name, userWithPostLimitStatusModel.name) && s.d(this.readStatus, userWithPostLimitStatusModel.readStatus) && s.d(this.avatarInfo, userWithPostLimitStatusModel.avatarInfo) && s.d(this.aloha, userWithPostLimitStatusModel.aloha) && s.d(this.f14614me, userWithPostLimitStatusModel.f14614me);
    }

    @Nullable
    public final Boolean getAloha() {
        return this.aloha;
    }

    @NotNull
    public final ImageModel getAvatarImage() {
        return this.avatarImage;
    }

    @Nullable
    public final String getAvatarInfo() {
        return this.avatarInfo;
    }

    @NotNull
    public final String getId() {
        return this.f14613id;
    }

    @Nullable
    public final Boolean getMe() {
        return this.f14614me;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Integer getReadStatus() {
        return this.readStatus;
    }

    public int hashCode() {
        int hashCode = ((this.f14613id.hashCode() * 31) + this.avatarImage.hashCode()) * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.readStatus;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.avatarInfo;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.aloha;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.f14614me;
        return hashCode5 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public final void setAloha(@Nullable Boolean bool) {
        this.aloha = bool;
    }

    public final void setReadStatus(@Nullable Integer num) {
        this.readStatus = num;
    }

    @NotNull
    public String toString() {
        String str = this.f14613id;
        ImageModel imageModel = this.avatarImage;
        String str2 = this.name;
        Integer num = this.readStatus;
        return "UserWithPostLimitStatusModel(id=" + str + ", avatarImage=" + ((Object) imageModel) + ", name=" + str2 + ", readStatus=" + ((Object) num) + ", avatarInfo=" + this.avatarInfo + ", aloha=" + ((Object) this.aloha) + ", me=" + ((Object) this.f14614me) + ")";
    }

    public /* synthetic */ UserWithPostLimitStatusModel(String str, ImageModel imageModel, String str2, Integer num, String str3, Boolean bool, Boolean bool2, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, imageModel, str2, (i10 & 8) != 0 ? null : num, (i10 & 16) != 0 ? null : str3, bool, bool2);
    }
}
