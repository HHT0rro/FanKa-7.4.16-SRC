package com.cupidapp.live.club.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ActivityModel {

    @Nullable
    private final String actTimeInfo;

    @NotNull
    private final String activityId;

    @NotNull
    private final String activityName;

    @Nullable
    private final Float activityScore;

    @Nullable
    private final ImageModel coverImage;

    @NotNull
    private final String groupId;

    @Nullable
    private final String jumpUrl;

    @Nullable
    private final ImageModel sponsorAvatar;

    @Nullable
    private final String summaryInfo;

    public ActivityModel(@NotNull String groupId, @NotNull String activityId, @NotNull String activityName, @Nullable String str, @Nullable String str2, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2, @Nullable String str3, @Nullable Float f10) {
        s.i(groupId, "groupId");
        s.i(activityId, "activityId");
        s.i(activityName, "activityName");
        this.groupId = groupId;
        this.activityId = activityId;
        this.activityName = activityName;
        this.jumpUrl = str;
        this.summaryInfo = str2;
        this.sponsorAvatar = imageModel;
        this.coverImage = imageModel2;
        this.actTimeInfo = str3;
        this.activityScore = f10;
    }

    @NotNull
    public final String component1() {
        return this.groupId;
    }

    @NotNull
    public final String component2() {
        return this.activityId;
    }

    @NotNull
    public final String component3() {
        return this.activityName;
    }

    @Nullable
    public final String component4() {
        return this.jumpUrl;
    }

    @Nullable
    public final String component5() {
        return this.summaryInfo;
    }

    @Nullable
    public final ImageModel component6() {
        return this.sponsorAvatar;
    }

    @Nullable
    public final ImageModel component7() {
        return this.coverImage;
    }

    @Nullable
    public final String component8() {
        return this.actTimeInfo;
    }

    @Nullable
    public final Float component9() {
        return this.activityScore;
    }

    @NotNull
    public final ActivityModel copy(@NotNull String groupId, @NotNull String activityId, @NotNull String activityName, @Nullable String str, @Nullable String str2, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2, @Nullable String str3, @Nullable Float f10) {
        s.i(groupId, "groupId");
        s.i(activityId, "activityId");
        s.i(activityName, "activityName");
        return new ActivityModel(groupId, activityId, activityName, str, str2, imageModel, imageModel2, str3, f10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityModel)) {
            return false;
        }
        ActivityModel activityModel = (ActivityModel) obj;
        return s.d(this.groupId, activityModel.groupId) && s.d(this.activityId, activityModel.activityId) && s.d(this.activityName, activityModel.activityName) && s.d(this.jumpUrl, activityModel.jumpUrl) && s.d(this.summaryInfo, activityModel.summaryInfo) && s.d(this.sponsorAvatar, activityModel.sponsorAvatar) && s.d(this.coverImage, activityModel.coverImage) && s.d(this.actTimeInfo, activityModel.actTimeInfo) && s.d(this.activityScore, activityModel.activityScore);
    }

    @Nullable
    public final String getActTimeInfo() {
        return this.actTimeInfo;
    }

    @NotNull
    public final String getActivityId() {
        return this.activityId;
    }

    @NotNull
    public final String getActivityName() {
        return this.activityName;
    }

    @Nullable
    public final Float getActivityScore() {
        return this.activityScore;
    }

    @Nullable
    public final ImageModel getCoverImage() {
        return this.coverImage;
    }

    @NotNull
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @Nullable
    public final ImageModel getSponsorAvatar() {
        return this.sponsorAvatar;
    }

    @Nullable
    public final String getSummaryInfo() {
        return this.summaryInfo;
    }

    public int hashCode() {
        int hashCode = ((((this.groupId.hashCode() * 31) + this.activityId.hashCode()) * 31) + this.activityName.hashCode()) * 31;
        String str = this.jumpUrl;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.summaryInfo;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        ImageModel imageModel = this.sponsorAvatar;
        int hashCode4 = (hashCode3 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        ImageModel imageModel2 = this.coverImage;
        int hashCode5 = (hashCode4 + (imageModel2 == null ? 0 : imageModel2.hashCode())) * 31;
        String str3 = this.actTimeInfo;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Float f10 = this.activityScore;
        return hashCode6 + (f10 != null ? f10.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.groupId;
        String str2 = this.activityId;
        String str3 = this.activityName;
        String str4 = this.jumpUrl;
        String str5 = this.summaryInfo;
        ImageModel imageModel = this.sponsorAvatar;
        ImageModel imageModel2 = this.coverImage;
        return "ActivityModel(groupId=" + str + ", activityId=" + str2 + ", activityName=" + str3 + ", jumpUrl=" + str4 + ", summaryInfo=" + str5 + ", sponsorAvatar=" + ((Object) imageModel) + ", coverImage=" + ((Object) imageModel2) + ", actTimeInfo=" + this.actTimeInfo + ", activityScore=" + ((Object) this.activityScore) + ")";
    }
}
