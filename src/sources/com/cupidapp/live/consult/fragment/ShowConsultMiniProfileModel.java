package com.cupidapp.live.consult.fragment;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultMiniProfileFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ShowConsultMiniProfileModel implements Serializable {

    @Nullable
    private final ImageModel avatarImage;

    @Nullable
    private final ImageModel levelIcon;

    @Nullable
    private final String name;

    @Nullable
    private final String reportData;

    @NotNull
    private final String userId;

    @Nullable
    private final String userProfileUrl;

    public ShowConsultMiniProfileModel(@NotNull String userId, @Nullable ImageModel imageModel, @Nullable String str, @Nullable ImageModel imageModel2, @Nullable String str2, @Nullable String str3) {
        s.i(userId, "userId");
        this.userId = userId;
        this.avatarImage = imageModel;
        this.name = str;
        this.levelIcon = imageModel2;
        this.reportData = str2;
        this.userProfileUrl = str3;
    }

    public static /* synthetic */ ShowConsultMiniProfileModel copy$default(ShowConsultMiniProfileModel showConsultMiniProfileModel, String str, ImageModel imageModel, String str2, ImageModel imageModel2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = showConsultMiniProfileModel.userId;
        }
        if ((i10 & 2) != 0) {
            imageModel = showConsultMiniProfileModel.avatarImage;
        }
        ImageModel imageModel3 = imageModel;
        if ((i10 & 4) != 0) {
            str2 = showConsultMiniProfileModel.name;
        }
        String str5 = str2;
        if ((i10 & 8) != 0) {
            imageModel2 = showConsultMiniProfileModel.levelIcon;
        }
        ImageModel imageModel4 = imageModel2;
        if ((i10 & 16) != 0) {
            str3 = showConsultMiniProfileModel.reportData;
        }
        String str6 = str3;
        if ((i10 & 32) != 0) {
            str4 = showConsultMiniProfileModel.userProfileUrl;
        }
        return showConsultMiniProfileModel.copy(str, imageModel3, str5, imageModel4, str6, str4);
    }

    @NotNull
    public final String component1() {
        return this.userId;
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
    public final ImageModel component4() {
        return this.levelIcon;
    }

    @Nullable
    public final String component5() {
        return this.reportData;
    }

    @Nullable
    public final String component6() {
        return this.userProfileUrl;
    }

    @NotNull
    public final ShowConsultMiniProfileModel copy(@NotNull String userId, @Nullable ImageModel imageModel, @Nullable String str, @Nullable ImageModel imageModel2, @Nullable String str2, @Nullable String str3) {
        s.i(userId, "userId");
        return new ShowConsultMiniProfileModel(userId, imageModel, str, imageModel2, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShowConsultMiniProfileModel)) {
            return false;
        }
        ShowConsultMiniProfileModel showConsultMiniProfileModel = (ShowConsultMiniProfileModel) obj;
        return s.d(this.userId, showConsultMiniProfileModel.userId) && s.d(this.avatarImage, showConsultMiniProfileModel.avatarImage) && s.d(this.name, showConsultMiniProfileModel.name) && s.d(this.levelIcon, showConsultMiniProfileModel.levelIcon) && s.d(this.reportData, showConsultMiniProfileModel.reportData) && s.d(this.userProfileUrl, showConsultMiniProfileModel.userProfileUrl);
    }

    @Nullable
    public final ImageModel getAvatarImage() {
        return this.avatarImage;
    }

    @Nullable
    public final ImageModel getLevelIcon() {
        return this.levelIcon;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getReportData() {
        return this.reportData;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    @Nullable
    public final String getUserProfileUrl() {
        return this.userProfileUrl;
    }

    public int hashCode() {
        int hashCode = this.userId.hashCode() * 31;
        ImageModel imageModel = this.avatarImage;
        int hashCode2 = (hashCode + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str = this.name;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        ImageModel imageModel2 = this.levelIcon;
        int hashCode4 = (hashCode3 + (imageModel2 == null ? 0 : imageModel2.hashCode())) * 31;
        String str2 = this.reportData;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.userProfileUrl;
        return hashCode5 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.userId;
        ImageModel imageModel = this.avatarImage;
        String str2 = this.name;
        ImageModel imageModel2 = this.levelIcon;
        return "ShowConsultMiniProfileModel(userId=" + str + ", avatarImage=" + ((Object) imageModel) + ", name=" + str2 + ", levelIcon=" + ((Object) imageModel2) + ", reportData=" + this.reportData + ", userProfileUrl=" + this.userProfileUrl + ")";
    }
}
