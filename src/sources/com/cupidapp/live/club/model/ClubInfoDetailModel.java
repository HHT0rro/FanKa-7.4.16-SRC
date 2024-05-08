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
public final class ClubInfoDetailModel {

    @Nullable
    private final String activityCreationUrl;

    @Nullable
    private final Boolean activityRedDot;

    @Nullable
    private final String announce;

    @Nullable
    private final ImageModel avatarImage;

    @Nullable
    private final ClubWelcomeConfirmModel confirmTip;

    @Nullable
    private final String detailUrl;

    @Nullable
    private final ImageModel groupLevelIcon;

    @Nullable
    private final String groupLevelUrl;

    /* renamed from: id, reason: collision with root package name */
    @Nullable
    private final String f13612id;

    @Nullable
    private final Integer memberCount;

    @Nullable
    private final List<User> members;
    private final boolean msgSwitch;

    @Nullable
    private final String name;

    @Nullable
    private final Boolean newApplyRedDot;

    @Nullable
    private final String reportData;

    @Nullable
    private final String summary;

    @Nullable
    private final Integer userRole;

    public ClubInfoDetailModel(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num, @Nullable Boolean bool, @Nullable List<User> list, @Nullable Boolean bool2, @Nullable ImageModel imageModel, @Nullable String str5, @Nullable String str6, @Nullable Integer num2, boolean z10, @Nullable String str7, @Nullable ClubWelcomeConfirmModel clubWelcomeConfirmModel, @Nullable ImageModel imageModel2, @Nullable String str8) {
        this.f13612id = str;
        this.name = str2;
        this.summary = str3;
        this.announce = str4;
        this.memberCount = num;
        this.newApplyRedDot = bool;
        this.members = list;
        this.activityRedDot = bool2;
        this.avatarImage = imageModel;
        this.reportData = str5;
        this.detailUrl = str6;
        this.userRole = num2;
        this.msgSwitch = z10;
        this.activityCreationUrl = str7;
        this.confirmTip = clubWelcomeConfirmModel;
        this.groupLevelIcon = imageModel2;
        this.groupLevelUrl = str8;
    }

    @Nullable
    public final String component1() {
        return this.f13612id;
    }

    @Nullable
    public final String component10() {
        return this.reportData;
    }

    @Nullable
    public final String component11() {
        return this.detailUrl;
    }

    @Nullable
    public final Integer component12() {
        return this.userRole;
    }

    public final boolean component13() {
        return this.msgSwitch;
    }

    @Nullable
    public final String component14() {
        return this.activityCreationUrl;
    }

    @Nullable
    public final ClubWelcomeConfirmModel component15() {
        return this.confirmTip;
    }

    @Nullable
    public final ImageModel component16() {
        return this.groupLevelIcon;
    }

    @Nullable
    public final String component17() {
        return this.groupLevelUrl;
    }

    @Nullable
    public final String component2() {
        return this.name;
    }

    @Nullable
    public final String component3() {
        return this.summary;
    }

    @Nullable
    public final String component4() {
        return this.announce;
    }

    @Nullable
    public final Integer component5() {
        return this.memberCount;
    }

    @Nullable
    public final Boolean component6() {
        return this.newApplyRedDot;
    }

    @Nullable
    public final List<User> component7() {
        return this.members;
    }

    @Nullable
    public final Boolean component8() {
        return this.activityRedDot;
    }

    @Nullable
    public final ImageModel component9() {
        return this.avatarImage;
    }

    @NotNull
    public final ClubInfoDetailModel copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num, @Nullable Boolean bool, @Nullable List<User> list, @Nullable Boolean bool2, @Nullable ImageModel imageModel, @Nullable String str5, @Nullable String str6, @Nullable Integer num2, boolean z10, @Nullable String str7, @Nullable ClubWelcomeConfirmModel clubWelcomeConfirmModel, @Nullable ImageModel imageModel2, @Nullable String str8) {
        return new ClubInfoDetailModel(str, str2, str3, str4, num, bool, list, bool2, imageModel, str5, str6, num2, z10, str7, clubWelcomeConfirmModel, imageModel2, str8);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClubInfoDetailModel)) {
            return false;
        }
        ClubInfoDetailModel clubInfoDetailModel = (ClubInfoDetailModel) obj;
        return s.d(this.f13612id, clubInfoDetailModel.f13612id) && s.d(this.name, clubInfoDetailModel.name) && s.d(this.summary, clubInfoDetailModel.summary) && s.d(this.announce, clubInfoDetailModel.announce) && s.d(this.memberCount, clubInfoDetailModel.memberCount) && s.d(this.newApplyRedDot, clubInfoDetailModel.newApplyRedDot) && s.d(this.members, clubInfoDetailModel.members) && s.d(this.activityRedDot, clubInfoDetailModel.activityRedDot) && s.d(this.avatarImage, clubInfoDetailModel.avatarImage) && s.d(this.reportData, clubInfoDetailModel.reportData) && s.d(this.detailUrl, clubInfoDetailModel.detailUrl) && s.d(this.userRole, clubInfoDetailModel.userRole) && this.msgSwitch == clubInfoDetailModel.msgSwitch && s.d(this.activityCreationUrl, clubInfoDetailModel.activityCreationUrl) && s.d(this.confirmTip, clubInfoDetailModel.confirmTip) && s.d(this.groupLevelIcon, clubInfoDetailModel.groupLevelIcon) && s.d(this.groupLevelUrl, clubInfoDetailModel.groupLevelUrl);
    }

    @Nullable
    public final String getActivityCreationUrl() {
        return this.activityCreationUrl;
    }

    @Nullable
    public final Boolean getActivityRedDot() {
        return this.activityRedDot;
    }

    @Nullable
    public final String getAnnounce() {
        return this.announce;
    }

    @Nullable
    public final ImageModel getAvatarImage() {
        return this.avatarImage;
    }

    @Nullable
    public final ClubWelcomeConfirmModel getConfirmTip() {
        return this.confirmTip;
    }

    @Nullable
    public final String getDetailUrl() {
        return this.detailUrl;
    }

    @Nullable
    public final ImageModel getGroupLevelIcon() {
        return this.groupLevelIcon;
    }

    @Nullable
    public final String getGroupLevelUrl() {
        return this.groupLevelUrl;
    }

    @Nullable
    public final String getId() {
        return this.f13612id;
    }

    @Nullable
    public final Integer getMemberCount() {
        return this.memberCount;
    }

    @Nullable
    public final List<User> getMembers() {
        return this.members;
    }

    public final boolean getMsgSwitch() {
        return this.msgSwitch;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final Boolean getNewApplyRedDot() {
        return this.newApplyRedDot;
    }

    @Nullable
    public final String getReportData() {
        return this.reportData;
    }

    @Nullable
    public final String getSummary() {
        return this.summary;
    }

    @Nullable
    public final Integer getUserRole() {
        return this.userRole;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.f13612id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.summary;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.announce;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.memberCount;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.newApplyRedDot;
        int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        List<User> list = this.members;
        int hashCode7 = (hashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool2 = this.activityRedDot;
        int hashCode8 = (hashCode7 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        ImageModel imageModel = this.avatarImage;
        int hashCode9 = (hashCode8 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str5 = this.reportData;
        int hashCode10 = (hashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.detailUrl;
        int hashCode11 = (hashCode10 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Integer num2 = this.userRole;
        int hashCode12 = (hashCode11 + (num2 == null ? 0 : num2.hashCode())) * 31;
        boolean z10 = this.msgSwitch;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode12 + i10) * 31;
        String str7 = this.activityCreationUrl;
        int hashCode13 = (i11 + (str7 == null ? 0 : str7.hashCode())) * 31;
        ClubWelcomeConfirmModel clubWelcomeConfirmModel = this.confirmTip;
        int hashCode14 = (hashCode13 + (clubWelcomeConfirmModel == null ? 0 : clubWelcomeConfirmModel.hashCode())) * 31;
        ImageModel imageModel2 = this.groupLevelIcon;
        int hashCode15 = (hashCode14 + (imageModel2 == null ? 0 : imageModel2.hashCode())) * 31;
        String str8 = this.groupLevelUrl;
        return hashCode15 + (str8 != null ? str8.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.f13612id;
        String str2 = this.name;
        String str3 = this.summary;
        String str4 = this.announce;
        Integer num = this.memberCount;
        Boolean bool = this.newApplyRedDot;
        List<User> list = this.members;
        Boolean bool2 = this.activityRedDot;
        ImageModel imageModel = this.avatarImage;
        String str5 = this.reportData;
        String str6 = this.detailUrl;
        Integer num2 = this.userRole;
        boolean z10 = this.msgSwitch;
        String str7 = this.activityCreationUrl;
        ClubWelcomeConfirmModel clubWelcomeConfirmModel = this.confirmTip;
        ImageModel imageModel2 = this.groupLevelIcon;
        return "ClubInfoDetailModel(id=" + str + ", name=" + str2 + ", summary=" + str3 + ", announce=" + str4 + ", memberCount=" + ((Object) num) + ", newApplyRedDot=" + ((Object) bool) + ", members=" + ((Object) list) + ", activityRedDot=" + ((Object) bool2) + ", avatarImage=" + ((Object) imageModel) + ", reportData=" + str5 + ", detailUrl=" + str6 + ", userRole=" + ((Object) num2) + ", msgSwitch=" + z10 + ", activityCreationUrl=" + str7 + ", confirmTip=" + ((Object) clubWelcomeConfirmModel) + ", groupLevelIcon=" + ((Object) imageModel2) + ", groupLevelUrl=" + this.groupLevelUrl + ")";
    }
}
