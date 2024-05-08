package com.cupidapp.live.club.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubModel {

    @Nullable
    private final Long activeScore;

    @Nullable
    private final ImageModel groupAvatar;

    @Nullable
    private final ImageModel groupIcon;

    @NotNull
    private final String groupId;

    @Nullable
    private final String groupIntro;
    private final int groupMemberCount;

    @NotNull
    private final String groupName;

    @Nullable
    private final Boolean joined;

    @Nullable
    private final String jumpUrl;

    @Nullable
    private final ImageModel levelIcon;

    @Nullable
    private final ImageModel medalIcon;

    @Nullable
    private final String medalLabel;

    @Nullable
    private final Boolean redDot;

    public ClubModel(@NotNull String groupId, @NotNull String groupName, @Nullable String str, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2, int i10, @Nullable String str2, @Nullable ImageModel imageModel3, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Long l10, @Nullable ImageModel imageModel4, @Nullable String str3) {
        s.i(groupId, "groupId");
        s.i(groupName, "groupName");
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupIntro = str;
        this.groupAvatar = imageModel;
        this.groupIcon = imageModel2;
        this.groupMemberCount = i10;
        this.jumpUrl = str2;
        this.medalIcon = imageModel3;
        this.joined = bool;
        this.redDot = bool2;
        this.activeScore = l10;
        this.levelIcon = imageModel4;
        this.medalLabel = str3;
    }

    @NotNull
    public final String component1() {
        return this.groupId;
    }

    @Nullable
    public final Boolean component10() {
        return this.redDot;
    }

    @Nullable
    public final Long component11() {
        return this.activeScore;
    }

    @Nullable
    public final ImageModel component12() {
        return this.levelIcon;
    }

    @Nullable
    public final String component13() {
        return this.medalLabel;
    }

    @NotNull
    public final String component2() {
        return this.groupName;
    }

    @Nullable
    public final String component3() {
        return this.groupIntro;
    }

    @Nullable
    public final ImageModel component4() {
        return this.groupAvatar;
    }

    @Nullable
    public final ImageModel component5() {
        return this.groupIcon;
    }

    public final int component6() {
        return this.groupMemberCount;
    }

    @Nullable
    public final String component7() {
        return this.jumpUrl;
    }

    @Nullable
    public final ImageModel component8() {
        return this.medalIcon;
    }

    @Nullable
    public final Boolean component9() {
        return this.joined;
    }

    @NotNull
    public final ClubModel copy(@NotNull String groupId, @NotNull String groupName, @Nullable String str, @Nullable ImageModel imageModel, @Nullable ImageModel imageModel2, int i10, @Nullable String str2, @Nullable ImageModel imageModel3, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Long l10, @Nullable ImageModel imageModel4, @Nullable String str3) {
        s.i(groupId, "groupId");
        s.i(groupName, "groupName");
        return new ClubModel(groupId, groupName, str, imageModel, imageModel2, i10, str2, imageModel3, bool, bool2, l10, imageModel4, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClubModel)) {
            return false;
        }
        ClubModel clubModel = (ClubModel) obj;
        return s.d(this.groupId, clubModel.groupId) && s.d(this.groupName, clubModel.groupName) && s.d(this.groupIntro, clubModel.groupIntro) && s.d(this.groupAvatar, clubModel.groupAvatar) && s.d(this.groupIcon, clubModel.groupIcon) && this.groupMemberCount == clubModel.groupMemberCount && s.d(this.jumpUrl, clubModel.jumpUrl) && s.d(this.medalIcon, clubModel.medalIcon) && s.d(this.joined, clubModel.joined) && s.d(this.redDot, clubModel.redDot) && s.d(this.activeScore, clubModel.activeScore) && s.d(this.levelIcon, clubModel.levelIcon) && s.d(this.medalLabel, clubModel.medalLabel);
    }

    @Nullable
    public final Long getActiveScore() {
        return this.activeScore;
    }

    @Nullable
    public final ImageModel getGroupAvatar() {
        return this.groupAvatar;
    }

    @Nullable
    public final ImageModel getGroupIcon() {
        return this.groupIcon;
    }

    @NotNull
    public final String getGroupId() {
        return this.groupId;
    }

    @Nullable
    public final String getGroupIntro() {
        return this.groupIntro;
    }

    public final int getGroupMemberCount() {
        return this.groupMemberCount;
    }

    @NotNull
    public final String getGroupName() {
        return this.groupName;
    }

    @Nullable
    public final Boolean getJoined() {
        return this.joined;
    }

    @Nullable
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @Nullable
    public final ImageModel getLevelIcon() {
        return this.levelIcon;
    }

    @Nullable
    public final ImageModel getMedalIcon() {
        return this.medalIcon;
    }

    @Nullable
    public final String getMedalLabel() {
        return this.medalLabel;
    }

    @Nullable
    public final Boolean getRedDot() {
        return this.redDot;
    }

    public int hashCode() {
        int hashCode = ((this.groupId.hashCode() * 31) + this.groupName.hashCode()) * 31;
        String str = this.groupIntro;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        ImageModel imageModel = this.groupAvatar;
        int hashCode3 = (hashCode2 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        ImageModel imageModel2 = this.groupIcon;
        int hashCode4 = (((hashCode3 + (imageModel2 == null ? 0 : imageModel2.hashCode())) * 31) + this.groupMemberCount) * 31;
        String str2 = this.jumpUrl;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        ImageModel imageModel3 = this.medalIcon;
        int hashCode6 = (hashCode5 + (imageModel3 == null ? 0 : imageModel3.hashCode())) * 31;
        Boolean bool = this.joined;
        int hashCode7 = (hashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.redDot;
        int hashCode8 = (hashCode7 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Long l10 = this.activeScore;
        int hashCode9 = (hashCode8 + (l10 == null ? 0 : l10.hashCode())) * 31;
        ImageModel imageModel4 = this.levelIcon;
        int hashCode10 = (hashCode9 + (imageModel4 == null ? 0 : imageModel4.hashCode())) * 31;
        String str3 = this.medalLabel;
        return hashCode10 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.groupId;
        String str2 = this.groupName;
        String str3 = this.groupIntro;
        ImageModel imageModel = this.groupAvatar;
        ImageModel imageModel2 = this.groupIcon;
        int i10 = this.groupMemberCount;
        String str4 = this.jumpUrl;
        ImageModel imageModel3 = this.medalIcon;
        Boolean bool = this.joined;
        Boolean bool2 = this.redDot;
        Long l10 = this.activeScore;
        ImageModel imageModel4 = this.levelIcon;
        return "ClubModel(groupId=" + str + ", groupName=" + str2 + ", groupIntro=" + str3 + ", groupAvatar=" + ((Object) imageModel) + ", groupIcon=" + ((Object) imageModel2) + ", groupMemberCount=" + i10 + ", jumpUrl=" + str4 + ", medalIcon=" + ((Object) imageModel3) + ", joined=" + ((Object) bool) + ", redDot=" + ((Object) bool2) + ", activeScore=" + ((Object) l10) + ", levelIcon=" + ((Object) imageModel4) + ", medalLabel=" + this.medalLabel + ")";
    }
}
