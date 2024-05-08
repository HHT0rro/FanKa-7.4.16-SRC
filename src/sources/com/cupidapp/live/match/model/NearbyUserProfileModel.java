package com.cupidapp.live.match.model;

import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.profile.model.UserVipDetailModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: MatchModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearbyUserProfileModel implements Serializable {

    @Nullable
    private Integer age;

    @Nullable
    private Boolean aloha;

    @Nullable
    private Boolean alohaGet;
    private final boolean annualSsvip;
    private final boolean annualSvip;
    private final boolean annualVip;

    @Nullable
    private List<ImageModel> avatarFeeds;

    @NotNull
    private final String basicInfo;
    private boolean canGreet;
    private final boolean canSendInboxMessage;

    @NotNull
    private List<NearbyUserFeedModel> feeds;

    /* renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f16839id;

    @Nullable
    private final String individuationFrameConfig;

    @Nullable
    private Boolean match;

    @NotNull
    private final String name;

    @Nullable
    private final ImageModel profileLevelIcon;

    @Nullable
    private final String similarity;
    private final boolean ssvip;

    @Nullable
    private final String summary;
    private boolean superLikedByMe;
    private final boolean superLikedMe;
    private final boolean svip;

    @Nullable
    private final String travelCity;
    private final boolean vip;
    private final boolean vipIconHide;

    public NearbyUserProfileModel(@NotNull String id2, @NotNull List<NearbyUserFeedModel> feeds, @NotNull String name, @NotNull String basicInfo, @Nullable String str, @Nullable String str2, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, @Nullable Integer num, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable List<ImageModel> list, boolean z17, boolean z18, @Nullable ImageModel imageModel, @Nullable String str3, boolean z19, boolean z20, @Nullable String str4) {
        s.i(id2, "id");
        s.i(feeds, "feeds");
        s.i(name, "name");
        s.i(basicInfo, "basicInfo");
        this.f16839id = id2;
        this.feeds = feeds;
        this.name = name;
        this.basicInfo = basicInfo;
        this.similarity = str;
        this.summary = str2;
        this.vip = z10;
        this.annualVip = z11;
        this.svip = z12;
        this.annualSvip = z13;
        this.canSendInboxMessage = z14;
        this.vipIconHide = z15;
        this.canGreet = z16;
        this.age = num;
        this.aloha = bool;
        this.alohaGet = bool2;
        this.match = bool3;
        this.avatarFeeds = list;
        this.superLikedMe = z17;
        this.superLikedByMe = z18;
        this.profileLevelIcon = imageModel;
        this.individuationFrameConfig = str3;
        this.ssvip = z19;
        this.annualSsvip = z20;
        this.travelCity = str4;
    }

    @NotNull
    public final String component1() {
        return this.f16839id;
    }

    public final boolean component10() {
        return this.annualSvip;
    }

    public final boolean component11() {
        return this.canSendInboxMessage;
    }

    public final boolean component12() {
        return this.vipIconHide;
    }

    public final boolean component13() {
        return this.canGreet;
    }

    @Nullable
    public final Integer component14() {
        return this.age;
    }

    @Nullable
    public final Boolean component15() {
        return this.aloha;
    }

    @Nullable
    public final Boolean component16() {
        return this.alohaGet;
    }

    @Nullable
    public final Boolean component17() {
        return this.match;
    }

    @Nullable
    public final List<ImageModel> component18() {
        return this.avatarFeeds;
    }

    public final boolean component19() {
        return this.superLikedMe;
    }

    @NotNull
    public final List<NearbyUserFeedModel> component2() {
        return this.feeds;
    }

    public final boolean component20() {
        return this.superLikedByMe;
    }

    @Nullable
    public final ImageModel component21() {
        return this.profileLevelIcon;
    }

    @Nullable
    public final String component22() {
        return this.individuationFrameConfig;
    }

    public final boolean component23() {
        return this.ssvip;
    }

    public final boolean component24() {
        return this.annualSsvip;
    }

    @Nullable
    public final String component25() {
        return this.travelCity;
    }

    @NotNull
    public final String component3() {
        return this.name;
    }

    @NotNull
    public final String component4() {
        return this.basicInfo;
    }

    @Nullable
    public final String component5() {
        return this.similarity;
    }

    @Nullable
    public final String component6() {
        return this.summary;
    }

    public final boolean component7() {
        return this.vip;
    }

    public final boolean component8() {
        return this.annualVip;
    }

    public final boolean component9() {
        return this.svip;
    }

    @NotNull
    public final NearbyUserProfileModel copy(@NotNull String id2, @NotNull List<NearbyUserFeedModel> feeds, @NotNull String name, @NotNull String basicInfo, @Nullable String str, @Nullable String str2, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, @Nullable Integer num, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable List<ImageModel> list, boolean z17, boolean z18, @Nullable ImageModel imageModel, @Nullable String str3, boolean z19, boolean z20, @Nullable String str4) {
        s.i(id2, "id");
        s.i(feeds, "feeds");
        s.i(name, "name");
        s.i(basicInfo, "basicInfo");
        return new NearbyUserProfileModel(id2, feeds, name, basicInfo, str, str2, z10, z11, z12, z13, z14, z15, z16, num, bool, bool2, bool3, list, z17, z18, imageModel, str3, z19, z20, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NearbyUserProfileModel)) {
            return false;
        }
        NearbyUserProfileModel nearbyUserProfileModel = (NearbyUserProfileModel) obj;
        return s.d(this.f16839id, nearbyUserProfileModel.f16839id) && s.d(this.feeds, nearbyUserProfileModel.feeds) && s.d(this.name, nearbyUserProfileModel.name) && s.d(this.basicInfo, nearbyUserProfileModel.basicInfo) && s.d(this.similarity, nearbyUserProfileModel.similarity) && s.d(this.summary, nearbyUserProfileModel.summary) && this.vip == nearbyUserProfileModel.vip && this.annualVip == nearbyUserProfileModel.annualVip && this.svip == nearbyUserProfileModel.svip && this.annualSvip == nearbyUserProfileModel.annualSvip && this.canSendInboxMessage == nearbyUserProfileModel.canSendInboxMessage && this.vipIconHide == nearbyUserProfileModel.vipIconHide && this.canGreet == nearbyUserProfileModel.canGreet && s.d(this.age, nearbyUserProfileModel.age) && s.d(this.aloha, nearbyUserProfileModel.aloha) && s.d(this.alohaGet, nearbyUserProfileModel.alohaGet) && s.d(this.match, nearbyUserProfileModel.match) && s.d(this.avatarFeeds, nearbyUserProfileModel.avatarFeeds) && this.superLikedMe == nearbyUserProfileModel.superLikedMe && this.superLikedByMe == nearbyUserProfileModel.superLikedByMe && s.d(this.profileLevelIcon, nearbyUserProfileModel.profileLevelIcon) && s.d(this.individuationFrameConfig, nearbyUserProfileModel.individuationFrameConfig) && this.ssvip == nearbyUserProfileModel.ssvip && this.annualSsvip == nearbyUserProfileModel.annualSsvip && s.d(this.travelCity, nearbyUserProfileModel.travelCity);
    }

    @Nullable
    public final Integer getAge() {
        return this.age;
    }

    @Nullable
    public final Boolean getAloha() {
        return this.aloha;
    }

    @Nullable
    public final Boolean getAlohaGet() {
        return this.alohaGet;
    }

    public final boolean getAnnualSsvip() {
        return this.annualSsvip;
    }

    public final boolean getAnnualSvip() {
        return this.annualSvip;
    }

    public final boolean getAnnualVip() {
        return this.annualVip;
    }

    @Nullable
    public final List<ImageModel> getAvatarFeeds() {
        return this.avatarFeeds;
    }

    @NotNull
    public final String getBasicInfo() {
        return this.basicInfo;
    }

    public final boolean getCanGreet() {
        return this.canGreet;
    }

    public final boolean getCanSendInboxMessage() {
        return this.canSendInboxMessage;
    }

    @NotNull
    public final List<NearbyUserFeedModel> getFeeds() {
        return this.feeds;
    }

    @NotNull
    public final String getId() {
        return this.f16839id;
    }

    @Nullable
    public final String getIndividuationFrameConfig() {
        return this.individuationFrameConfig;
    }

    @Nullable
    public final Boolean getMatch() {
        return this.match;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final ImageModel getProfileLevelIcon() {
        return this.profileLevelIcon;
    }

    @Nullable
    public final String getSimilarity() {
        return this.similarity;
    }

    public final boolean getSsvip() {
        return this.ssvip;
    }

    @Nullable
    public final String getSummary() {
        return this.summary;
    }

    public final boolean getSuperLikedByMe() {
        return this.superLikedByMe;
    }

    public final boolean getSuperLikedMe() {
        return this.superLikedMe;
    }

    public final boolean getSvip() {
        return this.svip;
    }

    @Nullable
    public final String getTravelCity() {
        return this.travelCity;
    }

    public final boolean getVip() {
        return this.vip;
    }

    public final boolean getVipIconHide() {
        return this.vipIconHide;
    }

    @NotNull
    public final UserVipDetailModel getVipModel() {
        return new UserVipDetailModel(this.vip, this.annualVip, this.svip, this.annualSvip, this.ssvip, this.annualSsvip, this.vipIconHide);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.f16839id.hashCode() * 31) + this.feeds.hashCode()) * 31) + this.name.hashCode()) * 31) + this.basicInfo.hashCode()) * 31;
        String str = this.similarity;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.summary;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        boolean z10 = this.vip;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode3 + i10) * 31;
        boolean z11 = this.annualVip;
        int i12 = z11;
        if (z11 != 0) {
            i12 = 1;
        }
        int i13 = (i11 + i12) * 31;
        boolean z12 = this.svip;
        int i14 = z12;
        if (z12 != 0) {
            i14 = 1;
        }
        int i15 = (i13 + i14) * 31;
        boolean z13 = this.annualSvip;
        int i16 = z13;
        if (z13 != 0) {
            i16 = 1;
        }
        int i17 = (i15 + i16) * 31;
        boolean z14 = this.canSendInboxMessage;
        int i18 = z14;
        if (z14 != 0) {
            i18 = 1;
        }
        int i19 = (i17 + i18) * 31;
        boolean z15 = this.vipIconHide;
        int i20 = z15;
        if (z15 != 0) {
            i20 = 1;
        }
        int i21 = (i19 + i20) * 31;
        boolean z16 = this.canGreet;
        int i22 = z16;
        if (z16 != 0) {
            i22 = 1;
        }
        int i23 = (i21 + i22) * 31;
        Integer num = this.age;
        int hashCode4 = (i23 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.aloha;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.alohaGet;
        int hashCode6 = (hashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.match;
        int hashCode7 = (hashCode6 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        List<ImageModel> list = this.avatarFeeds;
        int hashCode8 = (hashCode7 + (list == null ? 0 : list.hashCode())) * 31;
        boolean z17 = this.superLikedMe;
        int i24 = z17;
        if (z17 != 0) {
            i24 = 1;
        }
        int i25 = (hashCode8 + i24) * 31;
        boolean z18 = this.superLikedByMe;
        int i26 = z18;
        if (z18 != 0) {
            i26 = 1;
        }
        int i27 = (i25 + i26) * 31;
        ImageModel imageModel = this.profileLevelIcon;
        int hashCode9 = (i27 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str3 = this.individuationFrameConfig;
        int hashCode10 = (hashCode9 + (str3 == null ? 0 : str3.hashCode())) * 31;
        boolean z19 = this.ssvip;
        int i28 = z19;
        if (z19 != 0) {
            i28 = 1;
        }
        int i29 = (hashCode10 + i28) * 31;
        boolean z20 = this.annualSsvip;
        int i30 = (i29 + (z20 ? 1 : z20 ? 1 : 0)) * 31;
        String str4 = this.travelCity;
        return i30 + (str4 != null ? str4.hashCode() : 0);
    }

    public final boolean isMyself() {
        String str = this.f16839id;
        User X = g.f52734a.X();
        return s.d(str, X != null ? X.userId() : null);
    }

    public final boolean isNotShowSuperLikeBtn() {
        if (!this.superLikedByMe && !s.d(this.match, Boolean.TRUE)) {
            String str = this.f16839id;
            g gVar = g.f52734a;
            User X = gVar.X();
            if (!s.d(str, X != null ? X.userId() : null) && gVar.M3()) {
                return false;
            }
        }
        return true;
    }

    public final void setAge(@Nullable Integer num) {
        this.age = num;
    }

    public final void setAloha(@Nullable Boolean bool) {
        this.aloha = bool;
    }

    public final void setAlohaGet(@Nullable Boolean bool) {
        this.alohaGet = bool;
    }

    public final void setAvatarFeeds(@Nullable List<ImageModel> list) {
        this.avatarFeeds = list;
    }

    public final void setCanGreet(boolean z10) {
        this.canGreet = z10;
    }

    public final void setFeeds(@NotNull List<NearbyUserFeedModel> list) {
        s.i(list, "<set-?>");
        this.feeds = list;
    }

    public final void setMatch(@Nullable Boolean bool) {
        this.match = bool;
    }

    public final void setSuperLikedByMe(boolean z10) {
        this.superLikedByMe = z10;
    }

    @NotNull
    public String toString() {
        String str = this.f16839id;
        List<NearbyUserFeedModel> list = this.feeds;
        String str2 = this.name;
        String str3 = this.basicInfo;
        String str4 = this.similarity;
        String str5 = this.summary;
        boolean z10 = this.vip;
        boolean z11 = this.annualVip;
        boolean z12 = this.svip;
        boolean z13 = this.annualSvip;
        boolean z14 = this.canSendInboxMessage;
        boolean z15 = this.vipIconHide;
        boolean z16 = this.canGreet;
        Integer num = this.age;
        Boolean bool = this.aloha;
        Boolean bool2 = this.alohaGet;
        Boolean bool3 = this.match;
        List<ImageModel> list2 = this.avatarFeeds;
        boolean z17 = this.superLikedMe;
        boolean z18 = this.superLikedByMe;
        ImageModel imageModel = this.profileLevelIcon;
        return "NearbyUserProfileModel(id=" + str + ", feeds=" + ((Object) list) + ", name=" + str2 + ", basicInfo=" + str3 + ", similarity=" + str4 + ", summary=" + str5 + ", vip=" + z10 + ", annualVip=" + z11 + ", svip=" + z12 + ", annualSvip=" + z13 + ", canSendInboxMessage=" + z14 + ", vipIconHide=" + z15 + ", canGreet=" + z16 + ", age=" + ((Object) num) + ", aloha=" + ((Object) bool) + ", alohaGet=" + ((Object) bool2) + ", match=" + ((Object) bool3) + ", avatarFeeds=" + ((Object) list2) + ", superLikedMe=" + z17 + ", superLikedByMe=" + z18 + ", profileLevelIcon=" + ((Object) imageModel) + ", individuationFrameConfig=" + this.individuationFrameConfig + ", ssvip=" + this.ssvip + ", annualSsvip=" + this.annualSsvip + ", travelCity=" + this.travelCity + ")";
    }

    public /* synthetic */ NearbyUserProfileModel(String str, List list, String str2, String str3, String str4, String str5, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, Integer num, Boolean bool, Boolean bool2, Boolean bool3, List list2, boolean z17, boolean z18, ImageModel imageModel, String str6, boolean z19, boolean z20, String str7, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? new ArrayList() : list, str2, str3, str4, str5, (i10 & 64) != 0 ? false : z10, (i10 & 128) != 0 ? false : z11, (i10 & 256) != 0 ? false : z12, (i10 & 512) != 0 ? false : z13, (i10 & 1024) != 0 ? false : z14, (i10 & 2048) != 0 ? false : z15, (i10 & 4096) != 0 ? true : z16, (i10 & 8192) != 0 ? null : num, (i10 & 16384) != 0 ? Boolean.FALSE : bool, (32768 & i10) != 0 ? Boolean.FALSE : bool2, (65536 & i10) != 0 ? Boolean.FALSE : bool3, (131072 & i10) != 0 ? new ArrayList() : list2, (262144 & i10) != 0 ? false : z17, (524288 & i10) != 0 ? false : z18, imageModel, str6, (4194304 & i10) != 0 ? false : z19, (8388608 & i10) != 0 ? false : z20, (i10 & 16777216) != 0 ? null : str7);
    }
}
