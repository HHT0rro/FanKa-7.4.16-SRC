package com.cupidapp.live.club.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubEnterRequestUserModel {

    @Nullable
    private final Integer applyStatus;

    @Nullable
    private final String applyTime;

    @Nullable
    private final ImageModel avatarImage;

    @Nullable
    private final String confirmNickname;

    @Nullable
    private final String jumpUrl;

    @Nullable
    private final String nickname;

    public ClubEnterRequestUserModel(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable ImageModel imageModel, @Nullable String str3, @Nullable String str4) {
        this.nickname = str;
        this.applyTime = str2;
        this.applyStatus = num;
        this.avatarImage = imageModel;
        this.confirmNickname = str3;
        this.jumpUrl = str4;
    }

    public static /* synthetic */ ClubEnterRequestUserModel copy$default(ClubEnterRequestUserModel clubEnterRequestUserModel, String str, String str2, Integer num, ImageModel imageModel, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = clubEnterRequestUserModel.nickname;
        }
        if ((i10 & 2) != 0) {
            str2 = clubEnterRequestUserModel.applyTime;
        }
        String str5 = str2;
        if ((i10 & 4) != 0) {
            num = clubEnterRequestUserModel.applyStatus;
        }
        Integer num2 = num;
        if ((i10 & 8) != 0) {
            imageModel = clubEnterRequestUserModel.avatarImage;
        }
        ImageModel imageModel2 = imageModel;
        if ((i10 & 16) != 0) {
            str3 = clubEnterRequestUserModel.confirmNickname;
        }
        String str6 = str3;
        if ((i10 & 32) != 0) {
            str4 = clubEnterRequestUserModel.jumpUrl;
        }
        return clubEnterRequestUserModel.copy(str, str5, num2, imageModel2, str6, str4);
    }

    @Nullable
    public final String component1() {
        return this.nickname;
    }

    @Nullable
    public final String component2() {
        return this.applyTime;
    }

    @Nullable
    public final Integer component3() {
        return this.applyStatus;
    }

    @Nullable
    public final ImageModel component4() {
        return this.avatarImage;
    }

    @Nullable
    public final String component5() {
        return this.confirmNickname;
    }

    @Nullable
    public final String component6() {
        return this.jumpUrl;
    }

    @NotNull
    public final ClubEnterRequestUserModel copy(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable ImageModel imageModel, @Nullable String str3, @Nullable String str4) {
        return new ClubEnterRequestUserModel(str, str2, num, imageModel, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClubEnterRequestUserModel)) {
            return false;
        }
        ClubEnterRequestUserModel clubEnterRequestUserModel = (ClubEnterRequestUserModel) obj;
        return s.d(this.nickname, clubEnterRequestUserModel.nickname) && s.d(this.applyTime, clubEnterRequestUserModel.applyTime) && s.d(this.applyStatus, clubEnterRequestUserModel.applyStatus) && s.d(this.avatarImage, clubEnterRequestUserModel.avatarImage) && s.d(this.confirmNickname, clubEnterRequestUserModel.confirmNickname) && s.d(this.jumpUrl, clubEnterRequestUserModel.jumpUrl);
    }

    @Nullable
    public final Integer getApplyStatus() {
        return this.applyStatus;
    }

    @Nullable
    public final String getApplyTime() {
        return this.applyTime;
    }

    @Nullable
    public final ImageModel getAvatarImage() {
        return this.avatarImage;
    }

    @Nullable
    public final String getConfirmNickname() {
        return this.confirmNickname;
    }

    @Nullable
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @Nullable
    public final String getNickname() {
        return this.nickname;
    }

    public int hashCode() {
        String str = this.nickname;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.applyTime;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.applyStatus;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        ImageModel imageModel = this.avatarImage;
        int hashCode4 = (hashCode3 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str3 = this.confirmNickname;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.jumpUrl;
        return hashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.nickname;
        String str2 = this.applyTime;
        Integer num = this.applyStatus;
        ImageModel imageModel = this.avatarImage;
        return "ClubEnterRequestUserModel(nickname=" + str + ", applyTime=" + str2 + ", applyStatus=" + ((Object) num) + ", avatarImage=" + ((Object) imageModel) + ", confirmNickname=" + this.confirmNickname + ", jumpUrl=" + this.jumpUrl + ")";
    }
}
