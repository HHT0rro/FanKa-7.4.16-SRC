package com.cupidapp.live.match.view;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.match.model.MatchCardItemModel;
import com.cupidapp.live.profile.model.MBTIInfoModel;
import com.cupidapp.live.profile.model.UserTagModel;
import com.cupidapp.live.profile.model.UserVipDetailModel;
import com.cupidapp.live.profile.model.ZodiacElfInfoModel;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKSwipeCardUserInfoLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKSwipeCardUserInfoModel {

    @Nullable
    private final String activeDesc;

    @Nullable
    private final String basicInfo;

    @Nullable
    private final ImageModel clubMedal;

    @NotNull
    private final MatchCardItemModel matchCardInfo;

    @Nullable
    private final MBTIInfoModel mbtiInfo;

    @Nullable
    private final String name;

    @Nullable
    private final String newUserTag;

    @Nullable
    private final ImageModel profileLevelIcon;

    @Nullable
    private final List<UserTagModel> userTags;

    @Nullable
    private final String userTagsEmptyText;

    @Nullable
    private final UserVipDetailModel vipModel;

    @Nullable
    private final ZodiacElfInfoModel zodiacInfo;

    public FKSwipeCardUserInfoModel(@Nullable String str, @Nullable UserVipDetailModel userVipDetailModel, @Nullable String str2, @Nullable String str3, @Nullable List<UserTagModel> list, @Nullable String str4, @NotNull MatchCardItemModel matchCardInfo, @Nullable String str5, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2, @Nullable ZodiacElfInfoModel zodiacElfInfoModel, @Nullable MBTIInfoModel mBTIInfoModel) {
        kotlin.jvm.internal.s.i(matchCardInfo, "matchCardInfo");
        this.name = str;
        this.vipModel = userVipDetailModel;
        this.activeDesc = str2;
        this.basicInfo = str3;
        this.userTags = list;
        this.userTagsEmptyText = str4;
        this.matchCardInfo = matchCardInfo;
        this.newUserTag = str5;
        this.profileLevelIcon = imageModel;
        this.clubMedal = imageModel2;
        this.zodiacInfo = zodiacElfInfoModel;
        this.mbtiInfo = mBTIInfoModel;
    }

    @Nullable
    public final String component1() {
        return this.name;
    }

    @Nullable
    public final ImageModel component10() {
        return this.clubMedal;
    }

    @Nullable
    public final ZodiacElfInfoModel component11() {
        return this.zodiacInfo;
    }

    @Nullable
    public final MBTIInfoModel component12() {
        return this.mbtiInfo;
    }

    @Nullable
    public final UserVipDetailModel component2() {
        return this.vipModel;
    }

    @Nullable
    public final String component3() {
        return this.activeDesc;
    }

    @Nullable
    public final String component4() {
        return this.basicInfo;
    }

    @Nullable
    public final List<UserTagModel> component5() {
        return this.userTags;
    }

    @Nullable
    public final String component6() {
        return this.userTagsEmptyText;
    }

    @NotNull
    public final MatchCardItemModel component7() {
        return this.matchCardInfo;
    }

    @Nullable
    public final String component8() {
        return this.newUserTag;
    }

    @Nullable
    public final ImageModel component9() {
        return this.profileLevelIcon;
    }

    @NotNull
    public final FKSwipeCardUserInfoModel copy(@Nullable String str, @Nullable UserVipDetailModel userVipDetailModel, @Nullable String str2, @Nullable String str3, @Nullable List<UserTagModel> list, @Nullable String str4, @NotNull MatchCardItemModel matchCardInfo, @Nullable String str5, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2, @Nullable ZodiacElfInfoModel zodiacElfInfoModel, @Nullable MBTIInfoModel mBTIInfoModel) {
        kotlin.jvm.internal.s.i(matchCardInfo, "matchCardInfo");
        return new FKSwipeCardUserInfoModel(str, userVipDetailModel, str2, str3, list, str4, matchCardInfo, str5, imageModel, imageModel2, zodiacElfInfoModel, mBTIInfoModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKSwipeCardUserInfoModel)) {
            return false;
        }
        FKSwipeCardUserInfoModel fKSwipeCardUserInfoModel = (FKSwipeCardUserInfoModel) obj;
        return kotlin.jvm.internal.s.d(this.name, fKSwipeCardUserInfoModel.name) && kotlin.jvm.internal.s.d(this.vipModel, fKSwipeCardUserInfoModel.vipModel) && kotlin.jvm.internal.s.d(this.activeDesc, fKSwipeCardUserInfoModel.activeDesc) && kotlin.jvm.internal.s.d(this.basicInfo, fKSwipeCardUserInfoModel.basicInfo) && kotlin.jvm.internal.s.d(this.userTags, fKSwipeCardUserInfoModel.userTags) && kotlin.jvm.internal.s.d(this.userTagsEmptyText, fKSwipeCardUserInfoModel.userTagsEmptyText) && kotlin.jvm.internal.s.d(this.matchCardInfo, fKSwipeCardUserInfoModel.matchCardInfo) && kotlin.jvm.internal.s.d(this.newUserTag, fKSwipeCardUserInfoModel.newUserTag) && kotlin.jvm.internal.s.d(this.profileLevelIcon, fKSwipeCardUserInfoModel.profileLevelIcon) && kotlin.jvm.internal.s.d(this.clubMedal, fKSwipeCardUserInfoModel.clubMedal) && kotlin.jvm.internal.s.d(this.zodiacInfo, fKSwipeCardUserInfoModel.zodiacInfo) && kotlin.jvm.internal.s.d(this.mbtiInfo, fKSwipeCardUserInfoModel.mbtiInfo);
    }

    @Nullable
    public final String getActiveDesc() {
        return this.activeDesc;
    }

    @Nullable
    public final String getBasicInfo() {
        return this.basicInfo;
    }

    @Nullable
    public final ImageModel getClubMedal() {
        return this.clubMedal;
    }

    @NotNull
    public final MatchCardItemModel getMatchCardInfo() {
        return this.matchCardInfo;
    }

    @Nullable
    public final MBTIInfoModel getMbtiInfo() {
        return this.mbtiInfo;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getNewUserTag() {
        return this.newUserTag;
    }

    @Nullable
    public final ImageModel getProfileLevelIcon() {
        return this.profileLevelIcon;
    }

    @Nullable
    public final List<UserTagModel> getUserTags() {
        return this.userTags;
    }

    @Nullable
    public final String getUserTagsEmptyText() {
        return this.userTagsEmptyText;
    }

    @Nullable
    public final UserVipDetailModel getVipModel() {
        return this.vipModel;
    }

    @Nullable
    public final ZodiacElfInfoModel getZodiacInfo() {
        return this.zodiacInfo;
    }

    public int hashCode() {
        String str = this.name;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        UserVipDetailModel userVipDetailModel = this.vipModel;
        int hashCode2 = (hashCode + (userVipDetailModel == null ? 0 : userVipDetailModel.hashCode())) * 31;
        String str2 = this.activeDesc;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.basicInfo;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<UserTagModel> list = this.userTags;
        int hashCode5 = (hashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        String str4 = this.userTagsEmptyText;
        int hashCode6 = (((hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.matchCardInfo.hashCode()) * 31;
        String str5 = this.newUserTag;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        ImageModel imageModel = this.profileLevelIcon;
        int hashCode8 = (hashCode7 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        ImageModel imageModel2 = this.clubMedal;
        int hashCode9 = (hashCode8 + (imageModel2 == null ? 0 : imageModel2.hashCode())) * 31;
        ZodiacElfInfoModel zodiacElfInfoModel = this.zodiacInfo;
        int hashCode10 = (hashCode9 + (zodiacElfInfoModel == null ? 0 : zodiacElfInfoModel.hashCode())) * 31;
        MBTIInfoModel mBTIInfoModel = this.mbtiInfo;
        return hashCode10 + (mBTIInfoModel != null ? mBTIInfoModel.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.name;
        UserVipDetailModel userVipDetailModel = this.vipModel;
        String str2 = this.activeDesc;
        String str3 = this.basicInfo;
        List<UserTagModel> list = this.userTags;
        String str4 = this.userTagsEmptyText;
        MatchCardItemModel matchCardItemModel = this.matchCardInfo;
        return "FKSwipeCardUserInfoModel(name=" + str + ", vipModel=" + ((Object) userVipDetailModel) + ", activeDesc=" + str2 + ", basicInfo=" + str3 + ", userTags=" + ((Object) list) + ", userTagsEmptyText=" + str4 + ", matchCardInfo=" + ((Object) matchCardItemModel) + ", newUserTag=" + this.newUserTag + ", profileLevelIcon=" + ((Object) this.profileLevelIcon) + ", clubMedal=" + ((Object) this.clubMedal) + ", zodiacInfo=" + ((Object) this.zodiacInfo) + ", mbtiInfo=" + ((Object) this.mbtiInfo) + ")";
    }
}
