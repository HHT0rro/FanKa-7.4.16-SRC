package com.cupidapp.live.club.model;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.profile.model.User;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubWelcomeConfirmModel {

    @Nullable
    private final ActivityModel activityInfo;

    @Nullable
    private final ClubWelcomeTipModel conciseInfo;

    @Nullable
    private final String groupDesc;

    @Nullable
    private final ImageModel groupEquity;

    @Nullable
    private final String groupExpMsg;

    @Nullable
    private final List<ClubWelcomeLevelBenefitModel> levelEquities;

    @Nullable
    private final ImageModel medalIcon;

    @Nullable
    private final ImageModel medalLevel;

    @Nullable
    private Integer stage;

    @Nullable
    private final User user;

    public ClubWelcomeConfirmModel(@Nullable ClubWelcomeTipModel clubWelcomeTipModel, @Nullable Integer num, @Nullable User user, @Nullable ImageModel imageModel, @Nullable String str, @Nullable ImageModel imageModel2, @Nullable String str2, @Nullable ImageModel imageModel3, @Nullable List<ClubWelcomeLevelBenefitModel> list, @Nullable ActivityModel activityModel) {
        this.conciseInfo = clubWelcomeTipModel;
        this.stage = num;
        this.user = user;
        this.medalIcon = imageModel;
        this.groupDesc = str;
        this.medalLevel = imageModel2;
        this.groupExpMsg = str2;
        this.groupEquity = imageModel3;
        this.levelEquities = list;
        this.activityInfo = activityModel;
    }

    @Nullable
    public final ClubWelcomeTipModel component1() {
        return this.conciseInfo;
    }

    @Nullable
    public final ActivityModel component10() {
        return this.activityInfo;
    }

    @Nullable
    public final Integer component2() {
        return this.stage;
    }

    @Nullable
    public final User component3() {
        return this.user;
    }

    @Nullable
    public final ImageModel component4() {
        return this.medalIcon;
    }

    @Nullable
    public final String component5() {
        return this.groupDesc;
    }

    @Nullable
    public final ImageModel component6() {
        return this.medalLevel;
    }

    @Nullable
    public final String component7() {
        return this.groupExpMsg;
    }

    @Nullable
    public final ImageModel component8() {
        return this.groupEquity;
    }

    @Nullable
    public final List<ClubWelcomeLevelBenefitModel> component9() {
        return this.levelEquities;
    }

    @NotNull
    public final ClubWelcomeConfirmModel copy(@Nullable ClubWelcomeTipModel clubWelcomeTipModel, @Nullable Integer num, @Nullable User user, @Nullable ImageModel imageModel, @Nullable String str, @Nullable ImageModel imageModel2, @Nullable String str2, @Nullable ImageModel imageModel3, @Nullable List<ClubWelcomeLevelBenefitModel> list, @Nullable ActivityModel activityModel) {
        return new ClubWelcomeConfirmModel(clubWelcomeTipModel, num, user, imageModel, str, imageModel2, str2, imageModel3, list, activityModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClubWelcomeConfirmModel)) {
            return false;
        }
        ClubWelcomeConfirmModel clubWelcomeConfirmModel = (ClubWelcomeConfirmModel) obj;
        return s.d(this.conciseInfo, clubWelcomeConfirmModel.conciseInfo) && s.d(this.stage, clubWelcomeConfirmModel.stage) && s.d(this.user, clubWelcomeConfirmModel.user) && s.d(this.medalIcon, clubWelcomeConfirmModel.medalIcon) && s.d(this.groupDesc, clubWelcomeConfirmModel.groupDesc) && s.d(this.medalLevel, clubWelcomeConfirmModel.medalLevel) && s.d(this.groupExpMsg, clubWelcomeConfirmModel.groupExpMsg) && s.d(this.groupEquity, clubWelcomeConfirmModel.groupEquity) && s.d(this.levelEquities, clubWelcomeConfirmModel.levelEquities) && s.d(this.activityInfo, clubWelcomeConfirmModel.activityInfo);
    }

    @Nullable
    public final ActivityModel getActivityInfo() {
        return this.activityInfo;
    }

    @Nullable
    public final ClubWelcomeTipModel getConciseInfo() {
        return this.conciseInfo;
    }

    @Nullable
    public final String getGroupDesc() {
        return this.groupDesc;
    }

    @Nullable
    public final ImageModel getGroupEquity() {
        return this.groupEquity;
    }

    @Nullable
    public final String getGroupExpMsg() {
        return this.groupExpMsg;
    }

    @Nullable
    public final List<ClubWelcomeLevelBenefitModel> getLevelEquities() {
        return this.levelEquities;
    }

    @Nullable
    public final ImageModel getMedalIcon() {
        return this.medalIcon;
    }

    @Nullable
    public final ImageModel getMedalLevel() {
        return this.medalLevel;
    }

    @Nullable
    public final Integer getStage() {
        return this.stage;
    }

    @Nullable
    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        ClubWelcomeTipModel clubWelcomeTipModel = this.conciseInfo;
        int hashCode = (clubWelcomeTipModel == null ? 0 : clubWelcomeTipModel.hashCode()) * 31;
        Integer num = this.stage;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        User user = this.user;
        int hashCode3 = (hashCode2 + (user == null ? 0 : user.hashCode())) * 31;
        ImageModel imageModel = this.medalIcon;
        int hashCode4 = (hashCode3 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str = this.groupDesc;
        int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        ImageModel imageModel2 = this.medalLevel;
        int hashCode6 = (hashCode5 + (imageModel2 == null ? 0 : imageModel2.hashCode())) * 31;
        String str2 = this.groupExpMsg;
        int hashCode7 = (hashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31;
        ImageModel imageModel3 = this.groupEquity;
        int hashCode8 = (hashCode7 + (imageModel3 == null ? 0 : imageModel3.hashCode())) * 31;
        List<ClubWelcomeLevelBenefitModel> list = this.levelEquities;
        int hashCode9 = (hashCode8 + (list == null ? 0 : list.hashCode())) * 31;
        ActivityModel activityModel = this.activityInfo;
        return hashCode9 + (activityModel != null ? activityModel.hashCode() : 0);
    }

    public final void setStage(@Nullable Integer num) {
        this.stage = num;
    }

    @NotNull
    public String toString() {
        ClubWelcomeTipModel clubWelcomeTipModel = this.conciseInfo;
        Integer num = this.stage;
        User user = this.user;
        ImageModel imageModel = this.medalIcon;
        String str = this.groupDesc;
        ImageModel imageModel2 = this.medalLevel;
        return "ClubWelcomeConfirmModel(conciseInfo=" + ((Object) clubWelcomeTipModel) + ", stage=" + ((Object) num) + ", user=" + ((Object) user) + ", medalIcon=" + ((Object) imageModel) + ", groupDesc=" + str + ", medalLevel=" + ((Object) imageModel2) + ", groupExpMsg=" + this.groupExpMsg + ", groupEquity=" + ((Object) this.groupEquity) + ", levelEquities=" + ((Object) this.levelEquities) + ", activityInfo=" + ((Object) this.activityInfo) + ")";
    }
}
