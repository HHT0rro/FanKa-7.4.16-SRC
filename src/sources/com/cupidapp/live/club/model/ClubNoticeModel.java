package com.cupidapp.live.club.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubNoticeModel {

    @Nullable
    private final ImageModel avatar;

    @Nullable
    private final String msg;

    @Nullable
    private final String nickname;

    @Nullable
    private final String publishTime;

    @Nullable
    private final Integer userRole;

    public ClubNoticeModel(@Nullable ImageModel imageModel, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num) {
        this.avatar = imageModel;
        this.nickname = str;
        this.publishTime = str2;
        this.msg = str3;
        this.userRole = num;
    }

    public static /* synthetic */ ClubNoticeModel copy$default(ClubNoticeModel clubNoticeModel, ImageModel imageModel, String str, String str2, String str3, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = clubNoticeModel.avatar;
        }
        if ((i10 & 2) != 0) {
            str = clubNoticeModel.nickname;
        }
        String str4 = str;
        if ((i10 & 4) != 0) {
            str2 = clubNoticeModel.publishTime;
        }
        String str5 = str2;
        if ((i10 & 8) != 0) {
            str3 = clubNoticeModel.msg;
        }
        String str6 = str3;
        if ((i10 & 16) != 0) {
            num = clubNoticeModel.userRole;
        }
        return clubNoticeModel.copy(imageModel, str4, str5, str6, num);
    }

    @Nullable
    public final ImageModel component1() {
        return this.avatar;
    }

    @Nullable
    public final String component2() {
        return this.nickname;
    }

    @Nullable
    public final String component3() {
        return this.publishTime;
    }

    @Nullable
    public final String component4() {
        return this.msg;
    }

    @Nullable
    public final Integer component5() {
        return this.userRole;
    }

    @NotNull
    public final ClubNoticeModel copy(@Nullable ImageModel imageModel, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num) {
        return new ClubNoticeModel(imageModel, str, str2, str3, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClubNoticeModel)) {
            return false;
        }
        ClubNoticeModel clubNoticeModel = (ClubNoticeModel) obj;
        return s.d(this.avatar, clubNoticeModel.avatar) && s.d(this.nickname, clubNoticeModel.nickname) && s.d(this.publishTime, clubNoticeModel.publishTime) && s.d(this.msg, clubNoticeModel.msg) && s.d(this.userRole, clubNoticeModel.userRole);
    }

    @Nullable
    public final ImageModel getAvatar() {
        return this.avatar;
    }

    @Nullable
    public final String getMsg() {
        return this.msg;
    }

    @Nullable
    public final String getNickname() {
        return this.nickname;
    }

    @Nullable
    public final String getPublishTime() {
        return this.publishTime;
    }

    @Nullable
    public final Integer getUserRole() {
        return this.userRole;
    }

    public int hashCode() {
        ImageModel imageModel = this.avatar;
        int hashCode = (imageModel == null ? 0 : imageModel.hashCode()) * 31;
        String str = this.nickname;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.publishTime;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.msg;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.userRole;
        return hashCode4 + (num != null ? num.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.avatar;
        return "ClubNoticeModel(avatar=" + ((Object) imageModel) + ", nickname=" + this.nickname + ", publishTime=" + this.publishTime + ", msg=" + this.msg + ", userRole=" + ((Object) this.userRole) + ")";
    }
}
