package com.cupidapp.live.consult.model;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.consult.activity.ConsultViewerActivity;
import com.cupidapp.live.consult.fragment.ShowConsultMiniProfileModel;
import com.cupidapp.live.profile.model.User;
import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultLiveModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultLiveModel implements Serializable {
    private final int aId;

    @Nullable
    private Integer anchorLevel;

    @Nullable
    private final ConsultAnchorTaskModel anchorTask;

    @NotNull
    private final String category;

    @Nullable
    private final ImageModel categoryIcon;

    @Nullable
    private final Integer connectGuideFreq;

    @Nullable
    private final Integer connectGuideTimeLimit;

    @Nullable
    private final ConsultConnectUserModel connectingUserInfo;

    @Nullable
    private final ImageModel cover;

    @Nullable
    private final Boolean ended;

    @Nullable
    private final Integer heartbeatSeconds;

    /* renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f13828id;

    @Nullable
    private ImageModel levelIcon;

    @NotNull
    private final String privateMapKey;

    @Nullable
    private final List<ConsultCommentModel> recentComments;

    @Nullable
    private final String reportData;

    @Nullable
    private final String requestId;

    @Nullable
    private final Boolean suspend;

    @Nullable
    private final String title;

    @NotNull
    private final User user;

    @Nullable
    private final String userProfileUrl;

    @NotNull
    private final String userSig;

    @Nullable
    private final String viewerCount;

    @Nullable
    private final Integer viewerRealCount;

    @Nullable
    private final String voiceConnectType;

    @Nullable
    private final Integer waitCount;

    public ConsultLiveModel(@NotNull String id2, @Nullable String str, @NotNull String category, @NotNull User user, @NotNull String userSig, int i10, @NotNull String privateMapKey, @Nullable ImageModel imageModel, @Nullable Integer num, @Nullable String str2, @Nullable String str3, @Nullable ConsultConnectUserModel consultConnectUserModel, @Nullable String str4, @Nullable Integer num2, @Nullable Integer num3, @Nullable List<ConsultCommentModel> list, @Nullable ConsultAnchorTaskModel consultAnchorTaskModel, @Nullable ImageModel imageModel2, @Nullable Boolean bool, @Nullable String str5, @Nullable Integer num4, @Nullable ImageModel imageModel3, @Nullable Integer num5, @Nullable Integer num6, @Nullable String str6, @Nullable Boolean bool2) {
        s.i(id2, "id");
        s.i(category, "category");
        s.i(user, "user");
        s.i(userSig, "userSig");
        s.i(privateMapKey, "privateMapKey");
        this.f13828id = id2;
        this.title = str;
        this.category = category;
        this.user = user;
        this.userSig = userSig;
        this.aId = i10;
        this.privateMapKey = privateMapKey;
        this.levelIcon = imageModel;
        this.anchorLevel = num;
        this.voiceConnectType = str2;
        this.requestId = str3;
        this.connectingUserInfo = consultConnectUserModel;
        this.viewerCount = str4;
        this.viewerRealCount = num2;
        this.waitCount = num3;
        this.recentComments = list;
        this.anchorTask = consultAnchorTaskModel;
        this.cover = imageModel2;
        this.ended = bool;
        this.reportData = str5;
        this.heartbeatSeconds = num4;
        this.categoryIcon = imageModel3;
        this.connectGuideTimeLimit = num5;
        this.connectGuideFreq = num6;
        this.userProfileUrl = str6;
        this.suspend = bool2;
    }

    @NotNull
    public final String component1() {
        return this.f13828id;
    }

    @Nullable
    public final String component10() {
        return this.voiceConnectType;
    }

    @Nullable
    public final String component11() {
        return this.requestId;
    }

    @Nullable
    public final ConsultConnectUserModel component12() {
        return this.connectingUserInfo;
    }

    @Nullable
    public final String component13() {
        return this.viewerCount;
    }

    @Nullable
    public final Integer component14() {
        return this.viewerRealCount;
    }

    @Nullable
    public final Integer component15() {
        return this.waitCount;
    }

    @Nullable
    public final List<ConsultCommentModel> component16() {
        return this.recentComments;
    }

    @Nullable
    public final ConsultAnchorTaskModel component17() {
        return this.anchorTask;
    }

    @Nullable
    public final ImageModel component18() {
        return this.cover;
    }

    @Nullable
    public final Boolean component19() {
        return this.ended;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component20() {
        return this.reportData;
    }

    @Nullable
    public final Integer component21() {
        return this.heartbeatSeconds;
    }

    @Nullable
    public final ImageModel component22() {
        return this.categoryIcon;
    }

    @Nullable
    public final Integer component23() {
        return this.connectGuideTimeLimit;
    }

    @Nullable
    public final Integer component24() {
        return this.connectGuideFreq;
    }

    @Nullable
    public final String component25() {
        return this.userProfileUrl;
    }

    @Nullable
    public final Boolean component26() {
        return this.suspend;
    }

    @NotNull
    public final String component3() {
        return this.category;
    }

    @NotNull
    public final User component4() {
        return this.user;
    }

    @NotNull
    public final String component5() {
        return this.userSig;
    }

    public final int component6() {
        return this.aId;
    }

    @NotNull
    public final String component7() {
        return this.privateMapKey;
    }

    @Nullable
    public final ImageModel component8() {
        return this.levelIcon;
    }

    @Nullable
    public final Integer component9() {
        return this.anchorLevel;
    }

    @NotNull
    public final ConsultLiveModel copy(@NotNull String id2, @Nullable String str, @NotNull String category, @NotNull User user, @NotNull String userSig, int i10, @NotNull String privateMapKey, @Nullable ImageModel imageModel, @Nullable Integer num, @Nullable String str2, @Nullable String str3, @Nullable ConsultConnectUserModel consultConnectUserModel, @Nullable String str4, @Nullable Integer num2, @Nullable Integer num3, @Nullable List<ConsultCommentModel> list, @Nullable ConsultAnchorTaskModel consultAnchorTaskModel, @Nullable ImageModel imageModel2, @Nullable Boolean bool, @Nullable String str5, @Nullable Integer num4, @Nullable ImageModel imageModel3, @Nullable Integer num5, @Nullable Integer num6, @Nullable String str6, @Nullable Boolean bool2) {
        s.i(id2, "id");
        s.i(category, "category");
        s.i(user, "user");
        s.i(userSig, "userSig");
        s.i(privateMapKey, "privateMapKey");
        return new ConsultLiveModel(id2, str, category, user, userSig, i10, privateMapKey, imageModel, num, str2, str3, consultConnectUserModel, str4, num2, num3, list, consultAnchorTaskModel, imageModel2, bool, str5, num4, imageModel3, num5, num6, str6, bool2);
    }

    @NotNull
    public final ConsultViewerActivity.Config createConfig(@Nullable String str, @Nullable String str2) {
        return new ConsultViewerActivity.Config(this.f13828id, this.category, str, str2, null, 16, null);
    }

    @NotNull
    public final ShowConsultMiniProfileModel createMiniProfileModel() {
        return new ShowConsultMiniProfileModel(this.user.userId(), this.user.getAvatarImage(), this.user.getName(), this.levelIcon, this.reportData, this.userProfileUrl);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsultLiveModel)) {
            return false;
        }
        ConsultLiveModel consultLiveModel = (ConsultLiveModel) obj;
        return s.d(this.f13828id, consultLiveModel.f13828id) && s.d(this.title, consultLiveModel.title) && s.d(this.category, consultLiveModel.category) && s.d(this.user, consultLiveModel.user) && s.d(this.userSig, consultLiveModel.userSig) && this.aId == consultLiveModel.aId && s.d(this.privateMapKey, consultLiveModel.privateMapKey) && s.d(this.levelIcon, consultLiveModel.levelIcon) && s.d(this.anchorLevel, consultLiveModel.anchorLevel) && s.d(this.voiceConnectType, consultLiveModel.voiceConnectType) && s.d(this.requestId, consultLiveModel.requestId) && s.d(this.connectingUserInfo, consultLiveModel.connectingUserInfo) && s.d(this.viewerCount, consultLiveModel.viewerCount) && s.d(this.viewerRealCount, consultLiveModel.viewerRealCount) && s.d(this.waitCount, consultLiveModel.waitCount) && s.d(this.recentComments, consultLiveModel.recentComments) && s.d(this.anchorTask, consultLiveModel.anchorTask) && s.d(this.cover, consultLiveModel.cover) && s.d(this.ended, consultLiveModel.ended) && s.d(this.reportData, consultLiveModel.reportData) && s.d(this.heartbeatSeconds, consultLiveModel.heartbeatSeconds) && s.d(this.categoryIcon, consultLiveModel.categoryIcon) && s.d(this.connectGuideTimeLimit, consultLiveModel.connectGuideTimeLimit) && s.d(this.connectGuideFreq, consultLiveModel.connectGuideFreq) && s.d(this.userProfileUrl, consultLiveModel.userProfileUrl) && s.d(this.suspend, consultLiveModel.suspend);
    }

    public final int getAId() {
        return this.aId;
    }

    @Nullable
    public final Integer getAnchorLevel() {
        return this.anchorLevel;
    }

    @Nullable
    public final ConsultAnchorTaskModel getAnchorTask() {
        return this.anchorTask;
    }

    @NotNull
    public final String getCategory() {
        return this.category;
    }

    @Nullable
    public final ImageModel getCategoryIcon() {
        return this.categoryIcon;
    }

    @Nullable
    public final Integer getConnectGuideFreq() {
        return this.connectGuideFreq;
    }

    @Nullable
    public final Integer getConnectGuideTimeLimit() {
        return this.connectGuideTimeLimit;
    }

    @Nullable
    public final ConsultConnectUserModel getConnectingUserInfo() {
        return this.connectingUserInfo;
    }

    @Nullable
    public final ImageModel getCover() {
        return this.cover;
    }

    @Nullable
    public final Boolean getEnded() {
        return this.ended;
    }

    @Nullable
    public final Integer getHeartbeatSeconds() {
        return this.heartbeatSeconds;
    }

    @NotNull
    public final String getId() {
        return this.f13828id;
    }

    @Nullable
    public final ImageModel getLevelIcon() {
        return this.levelIcon;
    }

    @NotNull
    public final String getPrivateMapKey() {
        return this.privateMapKey;
    }

    @Nullable
    public final List<ConsultCommentModel> getRecentComments() {
        return this.recentComments;
    }

    @Nullable
    public final String getReportData() {
        return this.reportData;
    }

    @Nullable
    public final String getRequestId() {
        return this.requestId;
    }

    @Nullable
    public final Boolean getSuspend() {
        return this.suspend;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    @Nullable
    public final String getUserProfileUrl() {
        return this.userProfileUrl;
    }

    @NotNull
    public final String getUserSig() {
        return this.userSig;
    }

    @Nullable
    public final String getViewerCount() {
        return this.viewerCount;
    }

    @Nullable
    public final Integer getViewerRealCount() {
        return this.viewerRealCount;
    }

    @Nullable
    public final String getVoiceConnectType() {
        return this.voiceConnectType;
    }

    @Nullable
    public final Integer getWaitCount() {
        return this.waitCount;
    }

    public int hashCode() {
        int hashCode = this.f13828id.hashCode() * 31;
        String str = this.title;
        int hashCode2 = (((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.category.hashCode()) * 31) + this.user.hashCode()) * 31) + this.userSig.hashCode()) * 31) + this.aId) * 31) + this.privateMapKey.hashCode()) * 31;
        ImageModel imageModel = this.levelIcon;
        int hashCode3 = (hashCode2 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        Integer num = this.anchorLevel;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.voiceConnectType;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.requestId;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        ConsultConnectUserModel consultConnectUserModel = this.connectingUserInfo;
        int hashCode7 = (hashCode6 + (consultConnectUserModel == null ? 0 : consultConnectUserModel.hashCode())) * 31;
        String str4 = this.viewerCount;
        int hashCode8 = (hashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num2 = this.viewerRealCount;
        int hashCode9 = (hashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.waitCount;
        int hashCode10 = (hashCode9 + (num3 == null ? 0 : num3.hashCode())) * 31;
        List<ConsultCommentModel> list = this.recentComments;
        int hashCode11 = (hashCode10 + (list == null ? 0 : list.hashCode())) * 31;
        ConsultAnchorTaskModel consultAnchorTaskModel = this.anchorTask;
        int hashCode12 = (hashCode11 + (consultAnchorTaskModel == null ? 0 : consultAnchorTaskModel.hashCode())) * 31;
        ImageModel imageModel2 = this.cover;
        int hashCode13 = (hashCode12 + (imageModel2 == null ? 0 : imageModel2.hashCode())) * 31;
        Boolean bool = this.ended;
        int hashCode14 = (hashCode13 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str5 = this.reportData;
        int hashCode15 = (hashCode14 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num4 = this.heartbeatSeconds;
        int hashCode16 = (hashCode15 + (num4 == null ? 0 : num4.hashCode())) * 31;
        ImageModel imageModel3 = this.categoryIcon;
        int hashCode17 = (hashCode16 + (imageModel3 == null ? 0 : imageModel3.hashCode())) * 31;
        Integer num5 = this.connectGuideTimeLimit;
        int hashCode18 = (hashCode17 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.connectGuideFreq;
        int hashCode19 = (hashCode18 + (num6 == null ? 0 : num6.hashCode())) * 31;
        String str6 = this.userProfileUrl;
        int hashCode20 = (hashCode19 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Boolean bool2 = this.suspend;
        return hashCode20 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public final void setAnchorLevel(@Nullable Integer num) {
        this.anchorLevel = num;
    }

    public final void setLevelIcon(@Nullable ImageModel imageModel) {
        this.levelIcon = imageModel;
    }

    @NotNull
    public String toString() {
        String str = this.f13828id;
        String str2 = this.title;
        String str3 = this.category;
        User user = this.user;
        String str4 = this.userSig;
        int i10 = this.aId;
        String str5 = this.privateMapKey;
        ImageModel imageModel = this.levelIcon;
        Integer num = this.anchorLevel;
        String str6 = this.voiceConnectType;
        String str7 = this.requestId;
        ConsultConnectUserModel consultConnectUserModel = this.connectingUserInfo;
        String str8 = this.viewerCount;
        Integer num2 = this.viewerRealCount;
        Integer num3 = this.waitCount;
        List<ConsultCommentModel> list = this.recentComments;
        ConsultAnchorTaskModel consultAnchorTaskModel = this.anchorTask;
        ImageModel imageModel2 = this.cover;
        Boolean bool = this.ended;
        String str9 = this.reportData;
        Integer num4 = this.heartbeatSeconds;
        ImageModel imageModel3 = this.categoryIcon;
        Integer num5 = this.connectGuideTimeLimit;
        Integer num6 = this.connectGuideFreq;
        return "ConsultLiveModel(id=" + str + ", title=" + str2 + ", category=" + str3 + ", user=" + ((Object) user) + ", userSig=" + str4 + ", aId=" + i10 + ", privateMapKey=" + str5 + ", levelIcon=" + ((Object) imageModel) + ", anchorLevel=" + ((Object) num) + ", voiceConnectType=" + str6 + ", requestId=" + str7 + ", connectingUserInfo=" + ((Object) consultConnectUserModel) + ", viewerCount=" + str8 + ", viewerRealCount=" + ((Object) num2) + ", waitCount=" + ((Object) num3) + ", recentComments=" + ((Object) list) + ", anchorTask=" + ((Object) consultAnchorTaskModel) + ", cover=" + ((Object) imageModel2) + ", ended=" + ((Object) bool) + ", reportData=" + str9 + ", heartbeatSeconds=" + ((Object) num4) + ", categoryIcon=" + ((Object) imageModel3) + ", connectGuideTimeLimit=" + ((Object) num5) + ", connectGuideFreq=" + ((Object) num6) + ", userProfileUrl=" + this.userProfileUrl + ", suspend=" + ((Object) this.suspend) + ")";
    }
}
