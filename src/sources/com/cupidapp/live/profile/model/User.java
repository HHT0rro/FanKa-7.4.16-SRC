package com.cupidapp.live.profile.model;

import android.content.Context;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.VideoModel;
import com.cupidapp.live.chat.model.ChatStatusItemModel;
import com.cupidapp.live.profile.holder.ProfileFriendPraiseModel;
import com.cupidapp.live.setting.model.AvatarProfileModel;
import com.cupidapp.live.superboost.model.UnLimitRemainsUIModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.t;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: User.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class User implements Serializable {

    @NotNull
    public static final a Companion = new a(null);
    private static final String TAG = User.class.getSimpleName();

    @SerializedName("avatarImage")
    @Nullable
    private ImageModel _avatarImage;

    @Nullable
    private final String activeDesc;

    @Nullable
    private String activeInfo;

    @Nullable
    private final Long activeTime;

    @Nullable
    private final ImageModel adminIcon;

    @Nullable
    private final Integer age;
    private boolean aloha;
    private int alohaCount;
    private boolean alohaGet;
    private final int alohaGetCount;
    private boolean alohaGetRequired;
    private boolean alohaGetShow;

    @Nullable
    private final Integer anchorLevel;
    private final boolean annualSsvip;
    private final boolean annualSvip;
    private final boolean annualVip;

    @Nullable
    private final AuditInfoUser auditInfoUser;

    @Nullable
    private final List<ImageModel> avatarFeeds;

    @Nullable
    private final String avatarImageId;

    @NotNull
    private List<AvatarProfileModel> avatarProfile;

    @Nullable
    private final String avatarTip;
    private long balance;
    private boolean ban;

    @Nullable
    private final String basicInfo;

    @Nullable
    private final String birthday;
    private boolean block;
    private boolean canSendInboxMessage;

    @Nullable
    private ChatStatusItemModel chatStatus;

    @Nullable
    private String chatStatusTime;

    @Nullable
    private final String cityCode;
    private boolean closeFriend;

    @Nullable
    private final ImageModel dailyRankIcon;

    @Nullable
    private final String desc;

    @Nullable
    private final String displayRegion;

    @Nullable
    private final String distance;

    @Nullable
    private final Double distanceKm;

    @Nullable
    private final FansClubMedalModel fansGroupIcon;
    private boolean focus;

    @Nullable
    private final String formatAlohaCount;

    @Nullable
    private final String formatAlohaGetCount;

    @Nullable
    private final String formatMatchCount;

    @Nullable
    private final String formatPostCount;

    @Nullable
    private final UserClubModel groupInfo;

    @Nullable
    private final ImageModel groupMedal;
    private final boolean hadLiveShowOnce;
    private boolean hasPrivacy;

    @Nullable
    private final String heiAndWei;

    @Nullable
    private final Integer height;
    private final boolean highRisk;

    @Nullable
    private final String highRiskNotice;

    /* renamed from: id, reason: collision with root package name */
    @Nullable
    private String f17843id;
    private boolean inProbationPeriod;

    @Nullable
    private final String individuationFrameConfig;

    @Nullable
    private final Integer infoProgress;

    @Nullable
    private final List<String> interest;

    @Nullable
    private final String ipToCityName;
    private final boolean isVideoAvatarValid;

    @Nullable
    private final String label;

    @Nullable
    private final String lastOnline;

    @Nullable
    private final Long lastOnlineMinutes;

    @Nullable
    private ImageModel levelIcon;

    @Nullable
    private final String location;

    @Nullable
    private String locationInfo;
    private final boolean locked;

    @Nullable
    private ImageModel maskAvatar;

    @Nullable
    private final String maskName;
    private boolean match;
    private int matchCount;

    @Nullable
    private final MBTIInfoModel mbtiInfo;

    /* renamed from: me, reason: collision with root package name */
    private boolean f17844me;

    @Nullable
    private final ImageModel medalImage;

    @Nullable
    private final String name;
    private final boolean nameMask;
    private boolean newMatch;

    @Nullable
    private final ImageModel newUserIcon;

    @Nullable
    private final String newUserTag;

    @Nullable
    private final String nickname;

    @Nullable
    private final ImageModel nobleIcon;

    @Nullable
    private final Boolean officialAccount;

    @Nullable
    private final ImageModel officialAccountIcon;
    private boolean online;

    @Nullable
    private final String onlineLiveShowId;
    private final boolean onlineShowOpen;
    private final boolean onlyDefaultAvatar;
    private int postCount;

    @Nullable
    private final ProfileFriendPraiseModel praise;
    private final boolean pro;
    private boolean profileIncomplete;

    @Nullable
    private final ImageModel profileLevelIcon;

    @Nullable
    private final List<ProfileMBTIModel> profileSpecCardList;

    @Nullable
    private List<ProfileSpecListModel> profileSpecList;

    @Nullable
    private Integer readStatus;

    @Nullable
    private final List<String> region;

    @Nullable
    private final String regionCode;

    @Nullable
    private final String reportData;

    @Nullable
    private final String role;

    @Nullable
    private final Boolean shake;

    @Nullable
    private final String shareContent;

    @Nullable
    private final String shareLink;

    @Nullable
    private final String shareTitle;
    private boolean showLocationIcon;
    private final boolean showMosaic;
    private final boolean showStoryLabel;
    private boolean skipReceiveFeed;

    @Nullable
    private final Boolean snapCapture;
    private final boolean ssvip;

    @Nullable
    private final List<FKStoryLabelItemModel> storyLabelList;

    @Nullable
    private final String sumCommission;

    @Nullable
    private String sumConsume;

    @Nullable
    private final String sumViewerCount;

    @Nullable
    private final String summary;

    @Nullable
    private String summaryInfo;

    @Nullable
    private Integer superLikeRemains;
    private boolean superLikedByMe;

    @Nullable
    private Integer superLikedByMeCombos;
    private boolean superLikedMe;

    @Nullable
    private Integer superLikedMeCombos;
    private final boolean svip;

    @Nullable
    private final String tag;

    @Nullable
    private final String todayCommission;

    @Nullable
    private final String travelCity;

    @Nullable
    private final String type;

    @Nullable
    private final Integer uid;

    @Nullable
    private String userId;

    @Nullable
    private String userProfileSummaryInfo;

    @Nullable
    private final Integer userRole;

    @Nullable
    private final List<UserTagModel> userTags;

    @Nullable
    private final String userTagsEmptyText;

    @Nullable
    private final Integer viewerLevel;
    private final boolean vip;
    private int vipAd;
    private final boolean vipIconHide;

    @Nullable
    private final ImageModel weekRankIcon;

    @Nullable
    private final Integer weight;

    @Nullable
    private final String zodiac;

    @Nullable
    private ZodiacElfInfoModel zodiacInfo;

    /* compiled from: User.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public User(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z10, @Nullable String str4, boolean z11, long j10, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable Integer num, @Nullable String str11, boolean z12, @Nullable String str12, int i10, boolean z13, @Nullable Integer num2, @Nullable String str13, @Nullable Integer num3, @Nullable String str14, @Nullable String str15, @Nullable Long l10, @Nullable ImageModel imageModel, @Nullable String str16, int i11, int i12, int i13, boolean z14, boolean z15, boolean z16, @Nullable String str17, @Nullable Integer num4, @Nullable String str18, boolean z17, boolean z18, boolean z19, boolean z20, @Nullable List<String> list, @Nullable List<ProfileSpecListModel> list2, @Nullable String str19, @Nullable Double d10, boolean z21, @Nullable Long l11, @Nullable String str20, boolean z22, boolean z23, boolean z24, boolean z25, @Nullable ImageModel imageModel2, boolean z26, boolean z27, @NotNull List<AvatarProfileModel> avatarProfile, @Nullable List<ImageModel> list3, @Nullable String str21, @Nullable String str22, @Nullable String str23, @Nullable String str24, boolean z28, @Nullable String str25, @Nullable Integer num5, @Nullable Integer num6, @Nullable String str26, boolean z29, boolean z30, boolean z31, boolean z32, boolean z33, boolean z34, @Nullable String str27, @Nullable String str28, @Nullable String str29, @Nullable String str30, @Nullable String str31, @Nullable Boolean bool, boolean z35, int i14, @Nullable List<UserTagModel> list4, @Nullable String str32, @Nullable String str33, @Nullable Boolean bool2, @Nullable Integer num7, @Nullable String str34, @Nullable ImageModel imageModel3, boolean z36, boolean z37, @Nullable List<FKStoryLabelItemModel> list5, boolean z38, boolean z39, @Nullable Integer num8, @Nullable Integer num9, boolean z40, @Nullable Integer num10, @Nullable String str35, @Nullable ChatStatusItemModel chatStatusItemModel, @Nullable Integer num11, @Nullable String str36, @Nullable String str37, @Nullable String str38, @Nullable String str39, boolean z41, @Nullable ImageModel imageModel4, @Nullable String str40, boolean z42, @Nullable String str41, boolean z43, @Nullable AuditInfoUser auditInfoUser, @Nullable FansClubMedalModel fansClubMedalModel, @Nullable ImageModel imageModel5, @Nullable String str42, @Nullable List<String> list6, @Nullable ImageModel imageModel6, @Nullable ProfileFriendPraiseModel profileFriendPraiseModel, @Nullable String str43, @Nullable String str44, @Nullable String str45, @Nullable String str46, @Nullable ImageModel imageModel7, @Nullable String str47, boolean z44, boolean z45, boolean z46, @Nullable ImageModel imageModel8, @Nullable ImageModel imageModel9, @Nullable ImageModel imageModel10, @Nullable Integer num12, @Nullable UserClubModel userClubModel, @Nullable ImageModel imageModel11, @Nullable ZodiacElfInfoModel zodiacElfInfoModel, @Nullable Boolean bool3, @Nullable ImageModel imageModel12, @Nullable MBTIInfoModel mBTIInfoModel, @Nullable List<ProfileMBTIModel> list7, @Nullable String str48) {
        s.i(avatarProfile, "avatarProfile");
        this.userId = str;
        this.f17843id = str2;
        this.name = str3;
        this.onlineShowOpen = z10;
        this.onlineLiveShowId = str4;
        this.hadLiveShowOnce = z11;
        this.balance = j10;
        this.sumCommission = str5;
        this.todayCommission = str6;
        this.sumViewerCount = str7;
        this.shareLink = str8;
        this.shareTitle = str9;
        this.shareContent = str10;
        this.height = num;
        this.nickname = str11;
        this.pro = z12;
        this.regionCode = str12;
        this.postCount = i10;
        this.f17844me = z13;
        this.weight = num2;
        this.birthday = str13;
        this.age = num3;
        this.zodiac = str14;
        this.cityCode = str15;
        this.activeTime = l10;
        this._avatarImage = imageModel;
        this.displayRegion = str16;
        this.alohaCount = i11;
        this.matchCount = i12;
        this.alohaGetCount = i13;
        this.alohaGet = z14;
        this.alohaGetRequired = z15;
        this.alohaGetShow = z16;
        this.avatarImageId = str17;
        this.uid = num4;
        this.type = str18;
        this.ban = z17;
        this.aloha = z18;
        this.focus = z19;
        this.closeFriend = z20;
        this.region = list;
        this.profileSpecList = list2;
        this.distance = str19;
        this.distanceKm = d10;
        this.match = z21;
        this.lastOnlineMinutes = l11;
        this.sumConsume = str20;
        this.hasPrivacy = z22;
        this.block = z23;
        this.newMatch = z24;
        this.profileIncomplete = z25;
        this.levelIcon = imageModel2;
        this.showLocationIcon = z26;
        this.inProbationPeriod = z27;
        this.avatarProfile = avatarProfile;
        this.avatarFeeds = list3;
        this.summary = str21;
        this.activeInfo = str22;
        this.locationInfo = str23;
        this.summaryInfo = str24;
        this.locked = z28;
        this.userProfileSummaryInfo = str25;
        this.anchorLevel = num5;
        this.viewerLevel = num6;
        this.label = str26;
        this.highRisk = z29;
        this.vip = z30;
        this.annualVip = z31;
        this.svip = z32;
        this.annualSvip = z33;
        this.vipIconHide = z34;
        this.highRiskNotice = str27;
        this.reportData = str28;
        this.heiAndWei = str29;
        this.lastOnline = str30;
        this.location = str31;
        this.snapCapture = bool;
        this.nameMask = z35;
        this.vipAd = i14;
        this.userTags = list4;
        this.userTagsEmptyText = str32;
        this.tag = str33;
        this.shake = bool2;
        this.infoProgress = num7;
        this.avatarTip = str34;
        this.medalImage = imageModel3;
        this.skipReceiveFeed = z36;
        this.showStoryLabel = z37;
        this.storyLabelList = list5;
        this.superLikedMe = z38;
        this.superLikedByMe = z39;
        this.superLikedMeCombos = num8;
        this.superLikedByMeCombos = num9;
        this.canSendInboxMessage = z40;
        this.superLikeRemains = num10;
        this.ipToCityName = str35;
        this.chatStatus = chatStatusItemModel;
        this.readStatus = num11;
        this.chatStatusTime = str36;
        this.activeDesc = str37;
        this.basicInfo = str38;
        this.role = str39;
        this.online = z41;
        this.maskAvatar = imageModel4;
        this.desc = str40;
        this.isVideoAvatarValid = z42;
        this.newUserTag = str41;
        this.onlyDefaultAvatar = z43;
        this.auditInfoUser = auditInfoUser;
        this.fansGroupIcon = fansClubMedalModel;
        this.newUserIcon = imageModel5;
        this.maskName = str42;
        this.interest = list6;
        this.adminIcon = imageModel6;
        this.praise = profileFriendPraiseModel;
        this.formatAlohaCount = str43;
        this.formatAlohaGetCount = str44;
        this.formatMatchCount = str45;
        this.formatPostCount = str46;
        this.profileLevelIcon = imageModel7;
        this.individuationFrameConfig = str47;
        this.ssvip = z44;
        this.annualSsvip = z45;
        this.showMosaic = z46;
        this.dailyRankIcon = imageModel8;
        this.weekRankIcon = imageModel9;
        this.nobleIcon = imageModel10;
        this.userRole = num12;
        this.groupInfo = userClubModel;
        this.groupMedal = imageModel11;
        this.zodiacInfo = zodiacElfInfoModel;
        this.officialAccount = bool3;
        this.officialAccountIcon = imageModel12;
        this.mbtiInfo = mBTIInfoModel;
        this.profileSpecCardList = list7;
        this.travelCity = str48;
    }

    private final String component1() {
        return this.userId;
    }

    private final String component2() {
        return this.f17843id;
    }

    private final ImageModel component26() {
        return this._avatarImage;
    }

    @Nullable
    public final String component10() {
        return this.sumViewerCount;
    }

    @Nullable
    public final String component100() {
        return this.activeDesc;
    }

    @Nullable
    public final String component101() {
        return this.basicInfo;
    }

    @Nullable
    public final String component102() {
        return this.role;
    }

    public final boolean component103() {
        return this.online;
    }

    @Nullable
    public final ImageModel component104() {
        return this.maskAvatar;
    }

    @Nullable
    public final String component105() {
        return this.desc;
    }

    public final boolean component106() {
        return this.isVideoAvatarValid;
    }

    @Nullable
    public final String component107() {
        return this.newUserTag;
    }

    public final boolean component108() {
        return this.onlyDefaultAvatar;
    }

    @Nullable
    public final AuditInfoUser component109() {
        return this.auditInfoUser;
    }

    @Nullable
    public final String component11() {
        return this.shareLink;
    }

    @Nullable
    public final FansClubMedalModel component110() {
        return this.fansGroupIcon;
    }

    @Nullable
    public final ImageModel component111() {
        return this.newUserIcon;
    }

    @Nullable
    public final String component112() {
        return this.maskName;
    }

    @Nullable
    public final List<String> component113() {
        return this.interest;
    }

    @Nullable
    public final ImageModel component114() {
        return this.adminIcon;
    }

    @Nullable
    public final ProfileFriendPraiseModel component115() {
        return this.praise;
    }

    @Nullable
    public final String component116() {
        return this.formatAlohaCount;
    }

    @Nullable
    public final String component117() {
        return this.formatAlohaGetCount;
    }

    @Nullable
    public final String component118() {
        return this.formatMatchCount;
    }

    @Nullable
    public final String component119() {
        return this.formatPostCount;
    }

    @Nullable
    public final String component12() {
        return this.shareTitle;
    }

    @Nullable
    public final ImageModel component120() {
        return this.profileLevelIcon;
    }

    @Nullable
    public final String component121() {
        return this.individuationFrameConfig;
    }

    public final boolean component122() {
        return this.ssvip;
    }

    public final boolean component123() {
        return this.annualSsvip;
    }

    public final boolean component124() {
        return this.showMosaic;
    }

    @Nullable
    public final ImageModel component125() {
        return this.dailyRankIcon;
    }

    @Nullable
    public final ImageModel component126() {
        return this.weekRankIcon;
    }

    @Nullable
    public final ImageModel component127() {
        return this.nobleIcon;
    }

    @Nullable
    public final Integer component128() {
        return this.userRole;
    }

    @Nullable
    public final UserClubModel component129() {
        return this.groupInfo;
    }

    @Nullable
    public final String component13() {
        return this.shareContent;
    }

    @Nullable
    public final ImageModel component130() {
        return this.groupMedal;
    }

    @Nullable
    public final ZodiacElfInfoModel component131() {
        return this.zodiacInfo;
    }

    @Nullable
    public final Boolean component132() {
        return this.officialAccount;
    }

    @Nullable
    public final ImageModel component133() {
        return this.officialAccountIcon;
    }

    @Nullable
    public final MBTIInfoModel component134() {
        return this.mbtiInfo;
    }

    @Nullable
    public final List<ProfileMBTIModel> component135() {
        return this.profileSpecCardList;
    }

    @Nullable
    public final String component136() {
        return this.travelCity;
    }

    @Nullable
    public final Integer component14() {
        return this.height;
    }

    @Nullable
    public final String component15() {
        return this.nickname;
    }

    public final boolean component16() {
        return this.pro;
    }

    @Nullable
    public final String component17() {
        return this.regionCode;
    }

    public final int component18() {
        return this.postCount;
    }

    public final boolean component19() {
        return this.f17844me;
    }

    @Nullable
    public final Integer component20() {
        return this.weight;
    }

    @Nullable
    public final String component21() {
        return this.birthday;
    }

    @Nullable
    public final Integer component22() {
        return this.age;
    }

    @Nullable
    public final String component23() {
        return this.zodiac;
    }

    @Nullable
    public final String component24() {
        return this.cityCode;
    }

    @Nullable
    public final Long component25() {
        return this.activeTime;
    }

    @Nullable
    public final String component27() {
        return this.displayRegion;
    }

    public final int component28() {
        return this.alohaCount;
    }

    public final int component29() {
        return this.matchCount;
    }

    @Nullable
    public final String component3() {
        return this.name;
    }

    public final int component30() {
        return this.alohaGetCount;
    }

    public final boolean component31() {
        return this.alohaGet;
    }

    public final boolean component32() {
        return this.alohaGetRequired;
    }

    public final boolean component33() {
        return this.alohaGetShow;
    }

    @Nullable
    public final String component34() {
        return this.avatarImageId;
    }

    @Nullable
    public final Integer component35() {
        return this.uid;
    }

    @Nullable
    public final String component36() {
        return this.type;
    }

    public final boolean component37() {
        return this.ban;
    }

    public final boolean component38() {
        return this.aloha;
    }

    public final boolean component39() {
        return this.focus;
    }

    public final boolean component4() {
        return this.onlineShowOpen;
    }

    public final boolean component40() {
        return this.closeFriend;
    }

    @Nullable
    public final List<String> component41() {
        return this.region;
    }

    @Nullable
    public final List<ProfileSpecListModel> component42() {
        return this.profileSpecList;
    }

    @Nullable
    public final String component43() {
        return this.distance;
    }

    @Nullable
    public final Double component44() {
        return this.distanceKm;
    }

    public final boolean component45() {
        return this.match;
    }

    @Nullable
    public final Long component46() {
        return this.lastOnlineMinutes;
    }

    @Nullable
    public final String component47() {
        return this.sumConsume;
    }

    public final boolean component48() {
        return this.hasPrivacy;
    }

    public final boolean component49() {
        return this.block;
    }

    @Nullable
    public final String component5() {
        return this.onlineLiveShowId;
    }

    public final boolean component50() {
        return this.newMatch;
    }

    public final boolean component51() {
        return this.profileIncomplete;
    }

    @Nullable
    public final ImageModel component52() {
        return this.levelIcon;
    }

    public final boolean component53() {
        return this.showLocationIcon;
    }

    public final boolean component54() {
        return this.inProbationPeriod;
    }

    @NotNull
    public final List<AvatarProfileModel> component55() {
        return this.avatarProfile;
    }

    @Nullable
    public final List<ImageModel> component56() {
        return this.avatarFeeds;
    }

    @Nullable
    public final String component57() {
        return this.summary;
    }

    @Nullable
    public final String component58() {
        return this.activeInfo;
    }

    @Nullable
    public final String component59() {
        return this.locationInfo;
    }

    public final boolean component6() {
        return this.hadLiveShowOnce;
    }

    @Nullable
    public final String component60() {
        return this.summaryInfo;
    }

    public final boolean component61() {
        return this.locked;
    }

    @Nullable
    public final String component62() {
        return this.userProfileSummaryInfo;
    }

    @Nullable
    public final Integer component63() {
        return this.anchorLevel;
    }

    @Nullable
    public final Integer component64() {
        return this.viewerLevel;
    }

    @Nullable
    public final String component65() {
        return this.label;
    }

    public final boolean component66() {
        return this.highRisk;
    }

    public final boolean component67() {
        return this.vip;
    }

    public final boolean component68() {
        return this.annualVip;
    }

    public final boolean component69() {
        return this.svip;
    }

    public final long component7() {
        return this.balance;
    }

    public final boolean component70() {
        return this.annualSvip;
    }

    public final boolean component71() {
        return this.vipIconHide;
    }

    @Nullable
    public final String component72() {
        return this.highRiskNotice;
    }

    @Nullable
    public final String component73() {
        return this.reportData;
    }

    @Nullable
    public final String component74() {
        return this.heiAndWei;
    }

    @Nullable
    public final String component75() {
        return this.lastOnline;
    }

    @Nullable
    public final String component76() {
        return this.location;
    }

    @Nullable
    public final Boolean component77() {
        return this.snapCapture;
    }

    public final boolean component78() {
        return this.nameMask;
    }

    public final int component79() {
        return this.vipAd;
    }

    @Nullable
    public final String component8() {
        return this.sumCommission;
    }

    @Nullable
    public final List<UserTagModel> component80() {
        return this.userTags;
    }

    @Nullable
    public final String component81() {
        return this.userTagsEmptyText;
    }

    @Nullable
    public final String component82() {
        return this.tag;
    }

    @Nullable
    public final Boolean component83() {
        return this.shake;
    }

    @Nullable
    public final Integer component84() {
        return this.infoProgress;
    }

    @Nullable
    public final String component85() {
        return this.avatarTip;
    }

    @Nullable
    public final ImageModel component86() {
        return this.medalImage;
    }

    public final boolean component87() {
        return this.skipReceiveFeed;
    }

    public final boolean component88() {
        return this.showStoryLabel;
    }

    @Nullable
    public final List<FKStoryLabelItemModel> component89() {
        return this.storyLabelList;
    }

    @Nullable
    public final String component9() {
        return this.todayCommission;
    }

    public final boolean component90() {
        return this.superLikedMe;
    }

    public final boolean component91() {
        return this.superLikedByMe;
    }

    @Nullable
    public final Integer component92() {
        return this.superLikedMeCombos;
    }

    @Nullable
    public final Integer component93() {
        return this.superLikedByMeCombos;
    }

    public final boolean component94() {
        return this.canSendInboxMessage;
    }

    @Nullable
    public final Integer component95() {
        return this.superLikeRemains;
    }

    @Nullable
    public final String component96() {
        return this.ipToCityName;
    }

    @Nullable
    public final ChatStatusItemModel component97() {
        return this.chatStatus;
    }

    @Nullable
    public final Integer component98() {
        return this.readStatus;
    }

    @Nullable
    public final String component99() {
        return this.chatStatusTime;
    }

    @NotNull
    public final User copy(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z10, @Nullable String str4, boolean z11, long j10, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable Integer num, @Nullable String str11, boolean z12, @Nullable String str12, int i10, boolean z13, @Nullable Integer num2, @Nullable String str13, @Nullable Integer num3, @Nullable String str14, @Nullable String str15, @Nullable Long l10, @Nullable ImageModel imageModel, @Nullable String str16, int i11, int i12, int i13, boolean z14, boolean z15, boolean z16, @Nullable String str17, @Nullable Integer num4, @Nullable String str18, boolean z17, boolean z18, boolean z19, boolean z20, @Nullable List<String> list, @Nullable List<ProfileSpecListModel> list2, @Nullable String str19, @Nullable Double d10, boolean z21, @Nullable Long l11, @Nullable String str20, boolean z22, boolean z23, boolean z24, boolean z25, @Nullable ImageModel imageModel2, boolean z26, boolean z27, @NotNull List<AvatarProfileModel> avatarProfile, @Nullable List<ImageModel> list3, @Nullable String str21, @Nullable String str22, @Nullable String str23, @Nullable String str24, boolean z28, @Nullable String str25, @Nullable Integer num5, @Nullable Integer num6, @Nullable String str26, boolean z29, boolean z30, boolean z31, boolean z32, boolean z33, boolean z34, @Nullable String str27, @Nullable String str28, @Nullable String str29, @Nullable String str30, @Nullable String str31, @Nullable Boolean bool, boolean z35, int i14, @Nullable List<UserTagModel> list4, @Nullable String str32, @Nullable String str33, @Nullable Boolean bool2, @Nullable Integer num7, @Nullable String str34, @Nullable ImageModel imageModel3, boolean z36, boolean z37, @Nullable List<FKStoryLabelItemModel> list5, boolean z38, boolean z39, @Nullable Integer num8, @Nullable Integer num9, boolean z40, @Nullable Integer num10, @Nullable String str35, @Nullable ChatStatusItemModel chatStatusItemModel, @Nullable Integer num11, @Nullable String str36, @Nullable String str37, @Nullable String str38, @Nullable String str39, boolean z41, @Nullable ImageModel imageModel4, @Nullable String str40, boolean z42, @Nullable String str41, boolean z43, @Nullable AuditInfoUser auditInfoUser, @Nullable FansClubMedalModel fansClubMedalModel, @Nullable ImageModel imageModel5, @Nullable String str42, @Nullable List<String> list6, @Nullable ImageModel imageModel6, @Nullable ProfileFriendPraiseModel profileFriendPraiseModel, @Nullable String str43, @Nullable String str44, @Nullable String str45, @Nullable String str46, @Nullable ImageModel imageModel7, @Nullable String str47, boolean z44, boolean z45, boolean z46, @Nullable ImageModel imageModel8, @Nullable ImageModel imageModel9, @Nullable ImageModel imageModel10, @Nullable Integer num12, @Nullable UserClubModel userClubModel, @Nullable ImageModel imageModel11, @Nullable ZodiacElfInfoModel zodiacElfInfoModel, @Nullable Boolean bool3, @Nullable ImageModel imageModel12, @Nullable MBTIInfoModel mBTIInfoModel, @Nullable List<ProfileMBTIModel> list7, @Nullable String str48) {
        s.i(avatarProfile, "avatarProfile");
        return new User(str, str2, str3, z10, str4, z11, j10, str5, str6, str7, str8, str9, str10, num, str11, z12, str12, i10, z13, num2, str13, num3, str14, str15, l10, imageModel, str16, i11, i12, i13, z14, z15, z16, str17, num4, str18, z17, z18, z19, z20, list, list2, str19, d10, z21, l11, str20, z22, z23, z24, z25, imageModel2, z26, z27, avatarProfile, list3, str21, str22, str23, str24, z28, str25, num5, num6, str26, z29, z30, z31, z32, z33, z34, str27, str28, str29, str30, str31, bool, z35, i14, list4, str32, str33, bool2, num7, str34, imageModel3, z36, z37, list5, z38, z39, num8, num9, z40, num10, str35, chatStatusItemModel, num11, str36, str37, str38, str39, z41, imageModel4, str40, z42, str41, z43, auditInfoUser, fansClubMedalModel, imageModel5, str42, list6, imageModel6, profileFriendPraiseModel, str43, str44, str45, str46, imageModel7, str47, z44, z45, z46, imageModel8, imageModel9, imageModel10, num12, userClubModel, imageModel11, zodiacElfInfoModel, bool3, imageModel12, mBTIInfoModel, list7, str48);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        return s.d(this.userId, user.userId) && s.d(this.f17843id, user.f17843id) && s.d(this.name, user.name) && this.onlineShowOpen == user.onlineShowOpen && s.d(this.onlineLiveShowId, user.onlineLiveShowId) && this.hadLiveShowOnce == user.hadLiveShowOnce && this.balance == user.balance && s.d(this.sumCommission, user.sumCommission) && s.d(this.todayCommission, user.todayCommission) && s.d(this.sumViewerCount, user.sumViewerCount) && s.d(this.shareLink, user.shareLink) && s.d(this.shareTitle, user.shareTitle) && s.d(this.shareContent, user.shareContent) && s.d(this.height, user.height) && s.d(this.nickname, user.nickname) && this.pro == user.pro && s.d(this.regionCode, user.regionCode) && this.postCount == user.postCount && this.f17844me == user.f17844me && s.d(this.weight, user.weight) && s.d(this.birthday, user.birthday) && s.d(this.age, user.age) && s.d(this.zodiac, user.zodiac) && s.d(this.cityCode, user.cityCode) && s.d(this.activeTime, user.activeTime) && s.d(this._avatarImage, user._avatarImage) && s.d(this.displayRegion, user.displayRegion) && this.alohaCount == user.alohaCount && this.matchCount == user.matchCount && this.alohaGetCount == user.alohaGetCount && this.alohaGet == user.alohaGet && this.alohaGetRequired == user.alohaGetRequired && this.alohaGetShow == user.alohaGetShow && s.d(this.avatarImageId, user.avatarImageId) && s.d(this.uid, user.uid) && s.d(this.type, user.type) && this.ban == user.ban && this.aloha == user.aloha && this.focus == user.focus && this.closeFriend == user.closeFriend && s.d(this.region, user.region) && s.d(this.profileSpecList, user.profileSpecList) && s.d(this.distance, user.distance) && s.d(this.distanceKm, user.distanceKm) && this.match == user.match && s.d(this.lastOnlineMinutes, user.lastOnlineMinutes) && s.d(this.sumConsume, user.sumConsume) && this.hasPrivacy == user.hasPrivacy && this.block == user.block && this.newMatch == user.newMatch && this.profileIncomplete == user.profileIncomplete && s.d(this.levelIcon, user.levelIcon) && this.showLocationIcon == user.showLocationIcon && this.inProbationPeriod == user.inProbationPeriod && s.d(this.avatarProfile, user.avatarProfile) && s.d(this.avatarFeeds, user.avatarFeeds) && s.d(this.summary, user.summary) && s.d(this.activeInfo, user.activeInfo) && s.d(this.locationInfo, user.locationInfo) && s.d(this.summaryInfo, user.summaryInfo) && this.locked == user.locked && s.d(this.userProfileSummaryInfo, user.userProfileSummaryInfo) && s.d(this.anchorLevel, user.anchorLevel) && s.d(this.viewerLevel, user.viewerLevel) && s.d(this.label, user.label) && this.highRisk == user.highRisk && this.vip == user.vip && this.annualVip == user.annualVip && this.svip == user.svip && this.annualSvip == user.annualSvip && this.vipIconHide == user.vipIconHide && s.d(this.highRiskNotice, user.highRiskNotice) && s.d(this.reportData, user.reportData) && s.d(this.heiAndWei, user.heiAndWei) && s.d(this.lastOnline, user.lastOnline) && s.d(this.location, user.location) && s.d(this.snapCapture, user.snapCapture) && this.nameMask == user.nameMask && this.vipAd == user.vipAd && s.d(this.userTags, user.userTags) && s.d(this.userTagsEmptyText, user.userTagsEmptyText) && s.d(this.tag, user.tag) && s.d(this.shake, user.shake) && s.d(this.infoProgress, user.infoProgress) && s.d(this.avatarTip, user.avatarTip) && s.d(this.medalImage, user.medalImage) && this.skipReceiveFeed == user.skipReceiveFeed && this.showStoryLabel == user.showStoryLabel && s.d(this.storyLabelList, user.storyLabelList) && this.superLikedMe == user.superLikedMe && this.superLikedByMe == user.superLikedByMe && s.d(this.superLikedMeCombos, user.superLikedMeCombos) && s.d(this.superLikedByMeCombos, user.superLikedByMeCombos) && this.canSendInboxMessage == user.canSendInboxMessage && s.d(this.superLikeRemains, user.superLikeRemains) && s.d(this.ipToCityName, user.ipToCityName) && s.d(this.chatStatus, user.chatStatus) && s.d(this.readStatus, user.readStatus) && s.d(this.chatStatusTime, user.chatStatusTime) && s.d(this.activeDesc, user.activeDesc) && s.d(this.basicInfo, user.basicInfo) && s.d(this.role, user.role) && this.online == user.online && s.d(this.maskAvatar, user.maskAvatar) && s.d(this.desc, user.desc) && this.isVideoAvatarValid == user.isVideoAvatarValid && s.d(this.newUserTag, user.newUserTag) && this.onlyDefaultAvatar == user.onlyDefaultAvatar && s.d(this.auditInfoUser, user.auditInfoUser) && s.d(this.fansGroupIcon, user.fansGroupIcon) && s.d(this.newUserIcon, user.newUserIcon) && s.d(this.maskName, user.maskName) && s.d(this.interest, user.interest) && s.d(this.adminIcon, user.adminIcon) && s.d(this.praise, user.praise) && s.d(this.formatAlohaCount, user.formatAlohaCount) && s.d(this.formatAlohaGetCount, user.formatAlohaGetCount) && s.d(this.formatMatchCount, user.formatMatchCount) && s.d(this.formatPostCount, user.formatPostCount) && s.d(this.profileLevelIcon, user.profileLevelIcon) && s.d(this.individuationFrameConfig, user.individuationFrameConfig) && this.ssvip == user.ssvip && this.annualSsvip == user.annualSsvip && this.showMosaic == user.showMosaic && s.d(this.dailyRankIcon, user.dailyRankIcon) && s.d(this.weekRankIcon, user.weekRankIcon) && s.d(this.nobleIcon, user.nobleIcon) && s.d(this.userRole, user.userRole) && s.d(this.groupInfo, user.groupInfo) && s.d(this.groupMedal, user.groupMedal) && s.d(this.zodiacInfo, user.zodiacInfo) && s.d(this.officialAccount, user.officialAccount) && s.d(this.officialAccountIcon, user.officialAccountIcon) && s.d(this.mbtiInfo, user.mbtiInfo) && s.d(this.profileSpecCardList, user.profileSpecCardList) && s.d(this.travelCity, user.travelCity);
    }

    @Nullable
    public final String getActiveDesc() {
        return this.activeDesc;
    }

    @Nullable
    public final String getActiveInfo() {
        return this.activeInfo;
    }

    @Nullable
    public final Long getActiveTime() {
        return this.activeTime;
    }

    @Nullable
    public final ImageModel getAdminIcon() {
        return this.adminIcon;
    }

    @Nullable
    public final Integer getAge() {
        return this.age;
    }

    public final boolean getAloha() {
        return this.aloha;
    }

    public final int getAlohaCount() {
        return this.alohaCount;
    }

    public final boolean getAlohaGet() {
        return this.alohaGet;
    }

    public final int getAlohaGetCount() {
        return this.alohaGetCount;
    }

    public final boolean getAlohaGetRequired() {
        return this.alohaGetRequired;
    }

    public final boolean getAlohaGetShow() {
        return this.alohaGetShow;
    }

    @Nullable
    public final Integer getAnchorLevel() {
        return this.anchorLevel;
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
    public final AuditInfoUser getAuditInfoUser() {
        return this.auditInfoUser;
    }

    @Nullable
    public final List<ImageModel> getAvatarFeeds() {
        return this.avatarFeeds;
    }

    @Nullable
    public final ImageModel getAvatarImage() {
        AvatarProfileModel avatarProfileModel;
        ImageModel imageModel = this._avatarImage;
        if (imageModel != null) {
            return imageModel;
        }
        List<AvatarProfileModel> list = this.avatarProfile;
        if (list == null || (avatarProfileModel = (AvatarProfileModel) CollectionsKt___CollectionsKt.V(list)) == null) {
            return null;
        }
        return avatarProfileModel.getAvatarImage();
    }

    @Nullable
    public final String getAvatarImageId() {
        return this.avatarImageId;
    }

    @NotNull
    public final List<String> getAvatarImageIds() {
        List<AvatarProfileModel> list = this.avatarProfile;
        ArrayList arrayList = new ArrayList(t.t(list, 10));
        Iterator<AvatarProfileModel> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            ImageModel avatarImage = iterator2.next().getAvatarImage();
            arrayList.add(avatarImage != null ? avatarImage.getImageId() : null);
        }
        return arrayList;
    }

    @NotNull
    public final List<String> getAvatarImageIdsByReset(@Nullable String str, @Nullable String str2) {
        List<String> z02 = CollectionsKt___CollectionsKt.z0(getAvatarImageIds());
        int indexOf = z02.indexOf(str);
        if (indexOf >= 0) {
            z02.add(indexOf, str2);
            z02.remove(str);
        } else {
            z02.add(str2);
        }
        return z02;
    }

    @NotNull
    public final List<AvatarProfileModel> getAvatarProfile() {
        return this.avatarProfile;
    }

    @Nullable
    public final String getAvatarTip() {
        return this.avatarTip;
    }

    public final long getBalance() {
        return this.balance;
    }

    public final boolean getBan() {
        return this.ban;
    }

    @Nullable
    public final String getBasicInfo() {
        return this.basicInfo;
    }

    @Nullable
    public final String getBirthday() {
        return this.birthday;
    }

    public final boolean getBlock() {
        return this.block;
    }

    public final boolean getCanSendInboxMessage() {
        return this.canSendInboxMessage;
    }

    @Nullable
    public final ChatStatusItemModel getChatStatus() {
        return this.chatStatus;
    }

    @Nullable
    public final String getChatStatusTime() {
        return this.chatStatusTime;
    }

    @Nullable
    public final String getCityCode() {
        return this.cityCode;
    }

    public final boolean getCloseFriend() {
        return this.closeFriend;
    }

    @Nullable
    public final ImageModel getDailyRankIcon() {
        return this.dailyRankIcon;
    }

    @Nullable
    public final String getDesc() {
        return this.desc;
    }

    @Nullable
    public final String getDisplayRegion() {
        return this.displayRegion;
    }

    @Nullable
    public final String getDistance() {
        return this.distance;
    }

    @Nullable
    public final Double getDistanceKm() {
        return this.distanceKm;
    }

    @Nullable
    public final FansClubMedalModel getFansGroupIcon() {
        return this.fansGroupIcon;
    }

    public final boolean getFocus() {
        return this.focus;
    }

    @Nullable
    public final String getFormatAlohaCount() {
        return this.formatAlohaCount;
    }

    @Nullable
    public final String getFormatAlohaGetCount() {
        return this.formatAlohaGetCount;
    }

    @Nullable
    public final String getFormatMatchCount() {
        return this.formatMatchCount;
    }

    @Nullable
    public final String getFormatPostCount() {
        return this.formatPostCount;
    }

    @Nullable
    public final UserClubModel getGroupInfo() {
        return this.groupInfo;
    }

    @Nullable
    public final ImageModel getGroupMedal() {
        return this.groupMedal;
    }

    public final boolean getHadLiveShowOnce() {
        return this.hadLiveShowOnce;
    }

    public final boolean getHasPrivacy() {
        return this.hasPrivacy;
    }

    @Nullable
    public final String getHeiAndWei() {
        return this.heiAndWei;
    }

    @Nullable
    public final Integer getHeight() {
        return this.height;
    }

    public final boolean getHighRisk() {
        return this.highRisk;
    }

    @Nullable
    public final String getHighRiskNotice() {
        return this.highRiskNotice;
    }

    public final boolean getInProbationPeriod() {
        return this.inProbationPeriod;
    }

    @Nullable
    public final String getIndividuationFrameConfig() {
        return this.individuationFrameConfig;
    }

    @Nullable
    public final Integer getInfoProgress() {
        return this.infoProgress;
    }

    @Nullable
    public final List<String> getInterest() {
        return this.interest;
    }

    @Nullable
    public final String getIpToCityName() {
        return this.ipToCityName;
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    public final String getLastOnline() {
        return this.lastOnline;
    }

    @Nullable
    public final Long getLastOnlineMinutes() {
        return this.lastOnlineMinutes;
    }

    @Nullable
    public final ImageModel getLevelIcon() {
        return this.levelIcon;
    }

    @Nullable
    public final String getLocation() {
        return this.location;
    }

    @Nullable
    public final String getLocationInfo() {
        return this.locationInfo;
    }

    public final boolean getLocked() {
        return this.locked;
    }

    @Nullable
    public final ImageModel getMaskAvatar() {
        return this.maskAvatar;
    }

    @Nullable
    public final String getMaskName() {
        return this.maskName;
    }

    @Nullable
    public final ImageModel getMaskOrRealAvatarImage(boolean z10) {
        return z10 ? this.maskAvatar : getAvatarImage();
    }

    public final boolean getMatch() {
        return this.match;
    }

    public final int getMatchCount() {
        return this.matchCount;
    }

    @Nullable
    public final MBTIInfoModel getMbtiInfo() {
        return this.mbtiInfo;
    }

    public final boolean getMe() {
        return this.f17844me;
    }

    @Nullable
    public final ImageModel getMedalImage() {
        return this.medalImage;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public final boolean getNameMask() {
        return this.nameMask;
    }

    public final boolean getNewMatch() {
        return this.newMatch;
    }

    @Nullable
    public final ImageModel getNewUserIcon() {
        return this.newUserIcon;
    }

    @Nullable
    public final String getNewUserTag() {
        return this.newUserTag;
    }

    @Nullable
    public final String getNickname() {
        return this.nickname;
    }

    @Nullable
    public final ImageModel getNobleIcon() {
        return this.nobleIcon;
    }

    @Nullable
    public final Boolean getOfficialAccount() {
        return this.officialAccount;
    }

    @Nullable
    public final ImageModel getOfficialAccountIcon() {
        return this.officialAccountIcon;
    }

    public final boolean getOnline() {
        return this.online;
    }

    @Nullable
    public final String getOnlineLiveShowId() {
        return this.onlineLiveShowId;
    }

    public final boolean getOnlineShowOpen() {
        return this.onlineShowOpen;
    }

    public final boolean getOnlyDefaultAvatar() {
        return this.onlyDefaultAvatar;
    }

    public final int getPostCount() {
        return this.postCount;
    }

    @Nullable
    public final ProfileFriendPraiseModel getPraise() {
        return this.praise;
    }

    public final boolean getPro() {
        return this.pro;
    }

    public final boolean getProfileIncomplete() {
        return this.profileIncomplete;
    }

    @Nullable
    public final ImageModel getProfileLevelIcon() {
        return this.profileLevelIcon;
    }

    @Nullable
    public final List<ProfileMBTIModel> getProfileSpecCardList() {
        return this.profileSpecCardList;
    }

    @Nullable
    public final List<ProfileSpecListModel> getProfileSpecList() {
        return this.profileSpecList;
    }

    @Nullable
    public final Integer getReadStatus() {
        return this.readStatus;
    }

    @Nullable
    public final List<String> getRegion() {
        return this.region;
    }

    @Nullable
    public final String getRegionCode() {
        return this.regionCode;
    }

    @NotNull
    public final String getRelationship() {
        return this.match ? "匹配" : this.aloha ? "关注了对方" : this.alohaGet ? "被对方关注" : this.f17844me ? "自己" : "无关系";
    }

    @Nullable
    public final String getReportData() {
        return this.reportData;
    }

    @Nullable
    public final String getRole() {
        return this.role;
    }

    @NotNull
    public final String getSensorRelationship() {
        return this.match ? "MATCH" : this.aloha ? "FOLLOW" : this.alohaGet ? "BE_FOLLOW" : this.f17844me ? "ME" : "IRRELEVANCY";
    }

    @Nullable
    public final Boolean getShake() {
        return this.shake;
    }

    @Nullable
    public final String getShareContent() {
        return this.shareContent;
    }

    @Nullable
    public final String getShareLink() {
        return this.shareLink;
    }

    @Nullable
    public final String getShareTitle() {
        return this.shareTitle;
    }

    public final boolean getShowLocationIcon() {
        return this.showLocationIcon;
    }

    public final boolean getShowMosaic() {
        return this.showMosaic;
    }

    public final boolean getShowStoryLabel() {
        return this.showStoryLabel;
    }

    public final boolean getSkipReceiveFeed() {
        return this.skipReceiveFeed;
    }

    @Nullable
    public final Boolean getSnapCapture() {
        return this.snapCapture;
    }

    public final boolean getSsvip() {
        return this.ssvip;
    }

    @Nullable
    public final List<FKStoryLabelItemModel> getStoryLabelList() {
        return this.storyLabelList;
    }

    @Nullable
    public final String getSumCommission() {
        return this.sumCommission;
    }

    @Nullable
    public final String getSumConsume() {
        return this.sumConsume;
    }

    @Nullable
    public final String getSumViewerCount() {
        return this.sumViewerCount;
    }

    @Nullable
    public final String getSummary() {
        return this.summary;
    }

    @Nullable
    public final String getSummaryInfo() {
        return this.summaryInfo;
    }

    @Nullable
    public final Integer getSuperLikeRemains() {
        return this.superLikeRemains;
    }

    public final boolean getSuperLikedByMe() {
        return this.superLikedByMe;
    }

    @Nullable
    public final Integer getSuperLikedByMeCombos() {
        return this.superLikedByMeCombos;
    }

    public final boolean getSuperLikedMe() {
        return this.superLikedMe;
    }

    @Nullable
    public final Integer getSuperLikedMeCombos() {
        return this.superLikedMeCombos;
    }

    public final boolean getSvip() {
        return this.svip;
    }

    @Nullable
    public final String getTag() {
        return this.tag;
    }

    @Nullable
    public final String getTodayCommission() {
        return this.todayCommission;
    }

    @Nullable
    public final String getTravelCity() {
        return this.travelCity;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final Integer getUid() {
        return this.uid;
    }

    @NotNull
    public final UnLimitRemainsUIModel getUnLimitSuperLikeRemains(@NotNull Context context) {
        s.i(context, "context");
        return UnLimitRemainsUIModel.Companion.a(context, this.superLikeRemains);
    }

    @Nullable
    public final String getUserProfileSummaryInfo() {
        return this.userProfileSummaryInfo;
    }

    @Nullable
    public final Integer getUserRole() {
        return this.userRole;
    }

    @Nullable
    public final List<UserTagModel> getUserTags() {
        return this.userTags;
    }

    @Nullable
    public final String getUserTagsEmptyText() {
        return this.userTagsEmptyText;
    }

    @NotNull
    public final UserVipDetailModel getUserVipModel() {
        return new UserVipDetailModel(this.vip, this.annualVip, this.svip, this.annualSvip, this.ssvip, this.annualSsvip, this.vipIconHide);
    }

    @NotNull
    public final Pair<String, String> getVideoIdAndCoverId() {
        ImageModel avatarImage;
        VideoModel avatarVideo;
        List<AvatarProfileModel> list = this.avatarProfile;
        ArrayList arrayList = new ArrayList();
        for (AvatarProfileModel avatarProfileModel : list) {
            if (avatarProfileModel.getAvatarVideo() != null) {
                arrayList.add(avatarProfileModel);
            }
        }
        AvatarProfileModel avatarProfileModel2 = (AvatarProfileModel) CollectionsKt___CollectionsKt.V(arrayList);
        String str = null;
        String videoId = (avatarProfileModel2 == null || (avatarVideo = avatarProfileModel2.getAvatarVideo()) == null) ? null : avatarVideo.getVideoId();
        if (avatarProfileModel2 != null && (avatarImage = avatarProfileModel2.getAvatarImage()) != null) {
            str = avatarImage.getImageId();
        }
        return new Pair<>(videoId, str);
    }

    @Nullable
    public final Integer getViewerLevel() {
        return this.viewerLevel;
    }

    public final boolean getVip() {
        return this.vip;
    }

    public final int getVipAd() {
        return this.vipAd;
    }

    public final boolean getVipIconHide() {
        return this.vipIconHide;
    }

    @Nullable
    public final ImageModel getWeekRankIcon() {
        return this.weekRankIcon;
    }

    @Nullable
    public final Integer getWeight() {
        return this.weight;
    }

    @Nullable
    public final String getZodiac() {
        return this.zodiac;
    }

    @Nullable
    public final ZodiacElfInfoModel getZodiacInfo() {
        return this.zodiacInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.userId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f17843id;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.name;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        boolean z10 = this.onlineShowOpen;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode3 + i10) * 31;
        String str4 = this.onlineLiveShowId;
        int hashCode4 = (i11 + (str4 == null ? 0 : str4.hashCode())) * 31;
        boolean z11 = this.hadLiveShowOnce;
        int i12 = z11;
        if (z11 != 0) {
            i12 = 1;
        }
        int a10 = (((hashCode4 + i12) * 31) + b2.a.a(this.balance)) * 31;
        String str5 = this.sumCommission;
        int hashCode5 = (a10 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.todayCommission;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.sumViewerCount;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.shareLink;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.shareTitle;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.shareContent;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Integer num = this.height;
        int hashCode11 = (hashCode10 + (num == null ? 0 : num.hashCode())) * 31;
        String str11 = this.nickname;
        int hashCode12 = (hashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
        boolean z12 = this.pro;
        int i13 = z12;
        if (z12 != 0) {
            i13 = 1;
        }
        int i14 = (hashCode12 + i13) * 31;
        String str12 = this.regionCode;
        int hashCode13 = (((i14 + (str12 == null ? 0 : str12.hashCode())) * 31) + this.postCount) * 31;
        boolean z13 = this.f17844me;
        int i15 = z13;
        if (z13 != 0) {
            i15 = 1;
        }
        int i16 = (hashCode13 + i15) * 31;
        Integer num2 = this.weight;
        int hashCode14 = (i16 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str13 = this.birthday;
        int hashCode15 = (hashCode14 + (str13 == null ? 0 : str13.hashCode())) * 31;
        Integer num3 = this.age;
        int hashCode16 = (hashCode15 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str14 = this.zodiac;
        int hashCode17 = (hashCode16 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.cityCode;
        int hashCode18 = (hashCode17 + (str15 == null ? 0 : str15.hashCode())) * 31;
        Long l10 = this.activeTime;
        int hashCode19 = (hashCode18 + (l10 == null ? 0 : l10.hashCode())) * 31;
        ImageModel imageModel = this._avatarImage;
        int hashCode20 = (hashCode19 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str16 = this.displayRegion;
        int hashCode21 = (((((((hashCode20 + (str16 == null ? 0 : str16.hashCode())) * 31) + this.alohaCount) * 31) + this.matchCount) * 31) + this.alohaGetCount) * 31;
        boolean z14 = this.alohaGet;
        int i17 = z14;
        if (z14 != 0) {
            i17 = 1;
        }
        int i18 = (hashCode21 + i17) * 31;
        boolean z15 = this.alohaGetRequired;
        int i19 = z15;
        if (z15 != 0) {
            i19 = 1;
        }
        int i20 = (i18 + i19) * 31;
        boolean z16 = this.alohaGetShow;
        int i21 = z16;
        if (z16 != 0) {
            i21 = 1;
        }
        int i22 = (i20 + i21) * 31;
        String str17 = this.avatarImageId;
        int hashCode22 = (i22 + (str17 == null ? 0 : str17.hashCode())) * 31;
        Integer num4 = this.uid;
        int hashCode23 = (hashCode22 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str18 = this.type;
        int hashCode24 = (hashCode23 + (str18 == null ? 0 : str18.hashCode())) * 31;
        boolean z17 = this.ban;
        int i23 = z17;
        if (z17 != 0) {
            i23 = 1;
        }
        int i24 = (hashCode24 + i23) * 31;
        boolean z18 = this.aloha;
        int i25 = z18;
        if (z18 != 0) {
            i25 = 1;
        }
        int i26 = (i24 + i25) * 31;
        boolean z19 = this.focus;
        int i27 = z19;
        if (z19 != 0) {
            i27 = 1;
        }
        int i28 = (i26 + i27) * 31;
        boolean z20 = this.closeFriend;
        int i29 = z20;
        if (z20 != 0) {
            i29 = 1;
        }
        int i30 = (i28 + i29) * 31;
        List<String> list = this.region;
        int hashCode25 = (i30 + (list == null ? 0 : list.hashCode())) * 31;
        List<ProfileSpecListModel> list2 = this.profileSpecList;
        int hashCode26 = (hashCode25 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str19 = this.distance;
        int hashCode27 = (hashCode26 + (str19 == null ? 0 : str19.hashCode())) * 31;
        Double d10 = this.distanceKm;
        int hashCode28 = (hashCode27 + (d10 == null ? 0 : d10.hashCode())) * 31;
        boolean z21 = this.match;
        int i31 = z21;
        if (z21 != 0) {
            i31 = 1;
        }
        int i32 = (hashCode28 + i31) * 31;
        Long l11 = this.lastOnlineMinutes;
        int hashCode29 = (i32 + (l11 == null ? 0 : l11.hashCode())) * 31;
        String str20 = this.sumConsume;
        int hashCode30 = (hashCode29 + (str20 == null ? 0 : str20.hashCode())) * 31;
        boolean z22 = this.hasPrivacy;
        int i33 = z22;
        if (z22 != 0) {
            i33 = 1;
        }
        int i34 = (hashCode30 + i33) * 31;
        boolean z23 = this.block;
        int i35 = z23;
        if (z23 != 0) {
            i35 = 1;
        }
        int i36 = (i34 + i35) * 31;
        boolean z24 = this.newMatch;
        int i37 = z24;
        if (z24 != 0) {
            i37 = 1;
        }
        int i38 = (i36 + i37) * 31;
        boolean z25 = this.profileIncomplete;
        int i39 = z25;
        if (z25 != 0) {
            i39 = 1;
        }
        int i40 = (i38 + i39) * 31;
        ImageModel imageModel2 = this.levelIcon;
        int hashCode31 = (i40 + (imageModel2 == null ? 0 : imageModel2.hashCode())) * 31;
        boolean z26 = this.showLocationIcon;
        int i41 = z26;
        if (z26 != 0) {
            i41 = 1;
        }
        int i42 = (hashCode31 + i41) * 31;
        boolean z27 = this.inProbationPeriod;
        int i43 = z27;
        if (z27 != 0) {
            i43 = 1;
        }
        int hashCode32 = (((i42 + i43) * 31) + this.avatarProfile.hashCode()) * 31;
        List<ImageModel> list3 = this.avatarFeeds;
        int hashCode33 = (hashCode32 + (list3 == null ? 0 : list3.hashCode())) * 31;
        String str21 = this.summary;
        int hashCode34 = (hashCode33 + (str21 == null ? 0 : str21.hashCode())) * 31;
        String str22 = this.activeInfo;
        int hashCode35 = (hashCode34 + (str22 == null ? 0 : str22.hashCode())) * 31;
        String str23 = this.locationInfo;
        int hashCode36 = (hashCode35 + (str23 == null ? 0 : str23.hashCode())) * 31;
        String str24 = this.summaryInfo;
        int hashCode37 = (hashCode36 + (str24 == null ? 0 : str24.hashCode())) * 31;
        boolean z28 = this.locked;
        int i44 = z28;
        if (z28 != 0) {
            i44 = 1;
        }
        int i45 = (hashCode37 + i44) * 31;
        String str25 = this.userProfileSummaryInfo;
        int hashCode38 = (i45 + (str25 == null ? 0 : str25.hashCode())) * 31;
        Integer num5 = this.anchorLevel;
        int hashCode39 = (hashCode38 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.viewerLevel;
        int hashCode40 = (hashCode39 + (num6 == null ? 0 : num6.hashCode())) * 31;
        String str26 = this.label;
        int hashCode41 = (hashCode40 + (str26 == null ? 0 : str26.hashCode())) * 31;
        boolean z29 = this.highRisk;
        int i46 = z29;
        if (z29 != 0) {
            i46 = 1;
        }
        int i47 = (hashCode41 + i46) * 31;
        boolean z30 = this.vip;
        int i48 = z30;
        if (z30 != 0) {
            i48 = 1;
        }
        int i49 = (i47 + i48) * 31;
        boolean z31 = this.annualVip;
        int i50 = z31;
        if (z31 != 0) {
            i50 = 1;
        }
        int i51 = (i49 + i50) * 31;
        boolean z32 = this.svip;
        int i52 = z32;
        if (z32 != 0) {
            i52 = 1;
        }
        int i53 = (i51 + i52) * 31;
        boolean z33 = this.annualSvip;
        int i54 = z33;
        if (z33 != 0) {
            i54 = 1;
        }
        int i55 = (i53 + i54) * 31;
        boolean z34 = this.vipIconHide;
        int i56 = z34;
        if (z34 != 0) {
            i56 = 1;
        }
        int i57 = (i55 + i56) * 31;
        String str27 = this.highRiskNotice;
        int hashCode42 = (i57 + (str27 == null ? 0 : str27.hashCode())) * 31;
        String str28 = this.reportData;
        int hashCode43 = (hashCode42 + (str28 == null ? 0 : str28.hashCode())) * 31;
        String str29 = this.heiAndWei;
        int hashCode44 = (hashCode43 + (str29 == null ? 0 : str29.hashCode())) * 31;
        String str30 = this.lastOnline;
        int hashCode45 = (hashCode44 + (str30 == null ? 0 : str30.hashCode())) * 31;
        String str31 = this.location;
        int hashCode46 = (hashCode45 + (str31 == null ? 0 : str31.hashCode())) * 31;
        Boolean bool = this.snapCapture;
        int hashCode47 = (hashCode46 + (bool == null ? 0 : bool.hashCode())) * 31;
        boolean z35 = this.nameMask;
        int i58 = z35;
        if (z35 != 0) {
            i58 = 1;
        }
        int i59 = (((hashCode47 + i58) * 31) + this.vipAd) * 31;
        List<UserTagModel> list4 = this.userTags;
        int hashCode48 = (i59 + (list4 == null ? 0 : list4.hashCode())) * 31;
        String str32 = this.userTagsEmptyText;
        int hashCode49 = (hashCode48 + (str32 == null ? 0 : str32.hashCode())) * 31;
        String str33 = this.tag;
        int hashCode50 = (hashCode49 + (str33 == null ? 0 : str33.hashCode())) * 31;
        Boolean bool2 = this.shake;
        int hashCode51 = (hashCode50 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num7 = this.infoProgress;
        int hashCode52 = (hashCode51 + (num7 == null ? 0 : num7.hashCode())) * 31;
        String str34 = this.avatarTip;
        int hashCode53 = (hashCode52 + (str34 == null ? 0 : str34.hashCode())) * 31;
        ImageModel imageModel3 = this.medalImage;
        int hashCode54 = (hashCode53 + (imageModel3 == null ? 0 : imageModel3.hashCode())) * 31;
        boolean z36 = this.skipReceiveFeed;
        int i60 = z36;
        if (z36 != 0) {
            i60 = 1;
        }
        int i61 = (hashCode54 + i60) * 31;
        boolean z37 = this.showStoryLabel;
        int i62 = z37;
        if (z37 != 0) {
            i62 = 1;
        }
        int i63 = (i61 + i62) * 31;
        List<FKStoryLabelItemModel> list5 = this.storyLabelList;
        int hashCode55 = (i63 + (list5 == null ? 0 : list5.hashCode())) * 31;
        boolean z38 = this.superLikedMe;
        int i64 = z38;
        if (z38 != 0) {
            i64 = 1;
        }
        int i65 = (hashCode55 + i64) * 31;
        boolean z39 = this.superLikedByMe;
        int i66 = z39;
        if (z39 != 0) {
            i66 = 1;
        }
        int i67 = (i65 + i66) * 31;
        Integer num8 = this.superLikedMeCombos;
        int hashCode56 = (i67 + (num8 == null ? 0 : num8.hashCode())) * 31;
        Integer num9 = this.superLikedByMeCombos;
        int hashCode57 = (hashCode56 + (num9 == null ? 0 : num9.hashCode())) * 31;
        boolean z40 = this.canSendInboxMessage;
        int i68 = z40;
        if (z40 != 0) {
            i68 = 1;
        }
        int i69 = (hashCode57 + i68) * 31;
        Integer num10 = this.superLikeRemains;
        int hashCode58 = (i69 + (num10 == null ? 0 : num10.hashCode())) * 31;
        String str35 = this.ipToCityName;
        int hashCode59 = (hashCode58 + (str35 == null ? 0 : str35.hashCode())) * 31;
        ChatStatusItemModel chatStatusItemModel = this.chatStatus;
        int hashCode60 = (hashCode59 + (chatStatusItemModel == null ? 0 : chatStatusItemModel.hashCode())) * 31;
        Integer num11 = this.readStatus;
        int hashCode61 = (hashCode60 + (num11 == null ? 0 : num11.hashCode())) * 31;
        String str36 = this.chatStatusTime;
        int hashCode62 = (hashCode61 + (str36 == null ? 0 : str36.hashCode())) * 31;
        String str37 = this.activeDesc;
        int hashCode63 = (hashCode62 + (str37 == null ? 0 : str37.hashCode())) * 31;
        String str38 = this.basicInfo;
        int hashCode64 = (hashCode63 + (str38 == null ? 0 : str38.hashCode())) * 31;
        String str39 = this.role;
        int hashCode65 = (hashCode64 + (str39 == null ? 0 : str39.hashCode())) * 31;
        boolean z41 = this.online;
        int i70 = z41;
        if (z41 != 0) {
            i70 = 1;
        }
        int i71 = (hashCode65 + i70) * 31;
        ImageModel imageModel4 = this.maskAvatar;
        int hashCode66 = (i71 + (imageModel4 == null ? 0 : imageModel4.hashCode())) * 31;
        String str40 = this.desc;
        int hashCode67 = (hashCode66 + (str40 == null ? 0 : str40.hashCode())) * 31;
        boolean z42 = this.isVideoAvatarValid;
        int i72 = z42;
        if (z42 != 0) {
            i72 = 1;
        }
        int i73 = (hashCode67 + i72) * 31;
        String str41 = this.newUserTag;
        int hashCode68 = (i73 + (str41 == null ? 0 : str41.hashCode())) * 31;
        boolean z43 = this.onlyDefaultAvatar;
        int i74 = z43;
        if (z43 != 0) {
            i74 = 1;
        }
        int i75 = (hashCode68 + i74) * 31;
        AuditInfoUser auditInfoUser = this.auditInfoUser;
        int hashCode69 = (i75 + (auditInfoUser == null ? 0 : auditInfoUser.hashCode())) * 31;
        FansClubMedalModel fansClubMedalModel = this.fansGroupIcon;
        int hashCode70 = (hashCode69 + (fansClubMedalModel == null ? 0 : fansClubMedalModel.hashCode())) * 31;
        ImageModel imageModel5 = this.newUserIcon;
        int hashCode71 = (hashCode70 + (imageModel5 == null ? 0 : imageModel5.hashCode())) * 31;
        String str42 = this.maskName;
        int hashCode72 = (hashCode71 + (str42 == null ? 0 : str42.hashCode())) * 31;
        List<String> list6 = this.interest;
        int hashCode73 = (hashCode72 + (list6 == null ? 0 : list6.hashCode())) * 31;
        ImageModel imageModel6 = this.adminIcon;
        int hashCode74 = (hashCode73 + (imageModel6 == null ? 0 : imageModel6.hashCode())) * 31;
        ProfileFriendPraiseModel profileFriendPraiseModel = this.praise;
        int hashCode75 = (hashCode74 + (profileFriendPraiseModel == null ? 0 : profileFriendPraiseModel.hashCode())) * 31;
        String str43 = this.formatAlohaCount;
        int hashCode76 = (hashCode75 + (str43 == null ? 0 : str43.hashCode())) * 31;
        String str44 = this.formatAlohaGetCount;
        int hashCode77 = (hashCode76 + (str44 == null ? 0 : str44.hashCode())) * 31;
        String str45 = this.formatMatchCount;
        int hashCode78 = (hashCode77 + (str45 == null ? 0 : str45.hashCode())) * 31;
        String str46 = this.formatPostCount;
        int hashCode79 = (hashCode78 + (str46 == null ? 0 : str46.hashCode())) * 31;
        ImageModel imageModel7 = this.profileLevelIcon;
        int hashCode80 = (hashCode79 + (imageModel7 == null ? 0 : imageModel7.hashCode())) * 31;
        String str47 = this.individuationFrameConfig;
        int hashCode81 = (hashCode80 + (str47 == null ? 0 : str47.hashCode())) * 31;
        boolean z44 = this.ssvip;
        int i76 = z44;
        if (z44 != 0) {
            i76 = 1;
        }
        int i77 = (hashCode81 + i76) * 31;
        boolean z45 = this.annualSsvip;
        int i78 = z45;
        if (z45 != 0) {
            i78 = 1;
        }
        int i79 = (i77 + i78) * 31;
        boolean z46 = this.showMosaic;
        int i80 = (i79 + (z46 ? 1 : z46 ? 1 : 0)) * 31;
        ImageModel imageModel8 = this.dailyRankIcon;
        int hashCode82 = (i80 + (imageModel8 == null ? 0 : imageModel8.hashCode())) * 31;
        ImageModel imageModel9 = this.weekRankIcon;
        int hashCode83 = (hashCode82 + (imageModel9 == null ? 0 : imageModel9.hashCode())) * 31;
        ImageModel imageModel10 = this.nobleIcon;
        int hashCode84 = (hashCode83 + (imageModel10 == null ? 0 : imageModel10.hashCode())) * 31;
        Integer num12 = this.userRole;
        int hashCode85 = (hashCode84 + (num12 == null ? 0 : num12.hashCode())) * 31;
        UserClubModel userClubModel = this.groupInfo;
        int hashCode86 = (hashCode85 + (userClubModel == null ? 0 : userClubModel.hashCode())) * 31;
        ImageModel imageModel11 = this.groupMedal;
        int hashCode87 = (hashCode86 + (imageModel11 == null ? 0 : imageModel11.hashCode())) * 31;
        ZodiacElfInfoModel zodiacElfInfoModel = this.zodiacInfo;
        int hashCode88 = (hashCode87 + (zodiacElfInfoModel == null ? 0 : zodiacElfInfoModel.hashCode())) * 31;
        Boolean bool3 = this.officialAccount;
        int hashCode89 = (hashCode88 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        ImageModel imageModel12 = this.officialAccountIcon;
        int hashCode90 = (hashCode89 + (imageModel12 == null ? 0 : imageModel12.hashCode())) * 31;
        MBTIInfoModel mBTIInfoModel = this.mbtiInfo;
        int hashCode91 = (hashCode90 + (mBTIInfoModel == null ? 0 : mBTIInfoModel.hashCode())) * 31;
        List<ProfileMBTIModel> list7 = this.profileSpecCardList;
        int hashCode92 = (hashCode91 + (list7 == null ? 0 : list7.hashCode())) * 31;
        String str48 = this.travelCity;
        return hashCode92 + (str48 != null ? str48.hashCode() : 0);
    }

    public final boolean isAlohaMatched() {
        return s.d("匹配", getRelationship());
    }

    public final boolean isFollowed() {
        String relationship = getRelationship();
        return s.d(relationship, "匹配") || s.d(relationship, "关注了对方");
    }

    public final boolean isMyself() {
        String userId = userId();
        User X = g.f52734a.X();
        return s.d(userId, X != null ? X.userId() : null);
    }

    public final boolean isNotShowSuperLikeBtn() {
        return isSuperlikeByMe() || this.match || this.f17844me || !g.f52734a.M3();
    }

    public final boolean isSVip() {
        return this.svip || this.annualSvip;
    }

    public final boolean isSsvip() {
        return this.ssvip || this.annualSsvip;
    }

    public final boolean isSuperlikeByMe() {
        Integer num = this.superLikedByMeCombos;
        return (num != null ? num.intValue() : 0) > 0 || this.superLikedByMe;
    }

    public final boolean isSuperlikeMe() {
        Integer num = this.superLikedMeCombos;
        return (num != null ? num.intValue() : 0) > 0 || this.superLikedMe;
    }

    public final boolean isVideoAvatarValid() {
        return this.isVideoAvatarValid;
    }

    public final boolean isVip() {
        return this.vip || this.annualVip;
    }

    public final void setActiveInfo(@Nullable String str) {
        this.activeInfo = str;
    }

    public final void setAloha(boolean z10) {
        this.aloha = z10;
    }

    public final void setAlohaCount(int i10) {
        this.alohaCount = i10;
    }

    public final void setAlohaGet(boolean z10) {
        this.alohaGet = z10;
    }

    public final void setAlohaGetRequired(boolean z10) {
        this.alohaGetRequired = z10;
    }

    public final void setAlohaGetShow(boolean z10) {
        this.alohaGetShow = z10;
    }

    public final void setAvatarImage(@Nullable ImageModel imageModel) {
        this._avatarImage = imageModel;
    }

    public final void setAvatarProfile(@NotNull List<AvatarProfileModel> list) {
        s.i(list, "<set-?>");
        this.avatarProfile = list;
    }

    public final void setBalance(long j10) {
        this.balance = j10;
    }

    public final void setBan(boolean z10) {
        this.ban = z10;
    }

    public final void setBlock(boolean z10) {
        this.block = z10;
    }

    public final void setCanSendInboxMessage(boolean z10) {
        this.canSendInboxMessage = z10;
    }

    public final void setChatStatus(@Nullable ChatStatusItemModel chatStatusItemModel) {
        this.chatStatus = chatStatusItemModel;
    }

    public final void setChatStatusTime(@Nullable String str) {
        this.chatStatusTime = str;
    }

    public final void setCloseFriend(boolean z10) {
        this.closeFriend = z10;
    }

    public final void setFocus(boolean z10) {
        this.focus = z10;
    }

    public final void setHasPrivacy(boolean z10) {
        this.hasPrivacy = z10;
    }

    public final void setInProbationPeriod(boolean z10) {
        this.inProbationPeriod = z10;
    }

    public final void setLevelIcon(@Nullable ImageModel imageModel) {
        this.levelIcon = imageModel;
    }

    public final void setLocationInfo(@Nullable String str) {
        this.locationInfo = str;
    }

    public final void setMaskAvatar(@Nullable ImageModel imageModel) {
        this.maskAvatar = imageModel;
    }

    public final void setMatch(boolean z10) {
        this.match = z10;
    }

    public final void setMatchCount(int i10) {
        this.matchCount = i10;
    }

    public final void setMe(boolean z10) {
        this.f17844me = z10;
    }

    public final void setNewMatch(boolean z10) {
        this.newMatch = z10;
    }

    public final void setOnline(boolean z10) {
        this.online = z10;
    }

    public final void setPostCount(int i10) {
        this.postCount = i10;
    }

    public final void setProfileIncomplete(boolean z10) {
        this.profileIncomplete = z10;
    }

    public final void setProfileSpecList(@Nullable List<ProfileSpecListModel> list) {
        this.profileSpecList = list;
    }

    public final void setReadStatus(@Nullable Integer num) {
        this.readStatus = num;
    }

    public final void setShowLocationIcon(boolean z10) {
        this.showLocationIcon = z10;
    }

    public final void setSkipReceiveFeed(boolean z10) {
        this.skipReceiveFeed = z10;
    }

    public final void setSumConsume(@Nullable String str) {
        this.sumConsume = str;
    }

    public final void setSummaryInfo(@Nullable String str) {
        this.summaryInfo = str;
    }

    public final void setSuperLikeRemains(@Nullable Integer num) {
        this.superLikeRemains = num;
    }

    public final void setSuperLikedByMe(boolean z10) {
        this.superLikedByMe = z10;
    }

    public final void setSuperLikedByMeCombos(@Nullable Integer num) {
        this.superLikedByMeCombos = num;
    }

    public final void setSuperLikedMe(boolean z10) {
        this.superLikedMe = z10;
    }

    public final void setSuperLikedMeCombos(@Nullable Integer num) {
        this.superLikedMeCombos = num;
    }

    public final void setUserProfileSummaryInfo(@Nullable String str) {
        this.userProfileSummaryInfo = str;
    }

    public final void setVipAd(int i10) {
        this.vipAd = i10;
    }

    public final void setZodiacInfo(@Nullable ZodiacElfInfoModel zodiacElfInfoModel) {
        this.zodiacInfo = zodiacElfInfoModel;
    }

    @NotNull
    public String toString() {
        String str = this.userId;
        String str2 = this.f17843id;
        String str3 = this.name;
        boolean z10 = this.onlineShowOpen;
        String str4 = this.onlineLiveShowId;
        boolean z11 = this.hadLiveShowOnce;
        long j10 = this.balance;
        String str5 = this.sumCommission;
        String str6 = this.todayCommission;
        String str7 = this.sumViewerCount;
        String str8 = this.shareLink;
        String str9 = this.shareTitle;
        String str10 = this.shareContent;
        Integer num = this.height;
        String str11 = this.nickname;
        boolean z12 = this.pro;
        String str12 = this.regionCode;
        int i10 = this.postCount;
        boolean z13 = this.f17844me;
        Integer num2 = this.weight;
        String str13 = this.birthday;
        Integer num3 = this.age;
        String str14 = this.zodiac;
        String str15 = this.cityCode;
        Long l10 = this.activeTime;
        ImageModel imageModel = this._avatarImage;
        String str16 = this.displayRegion;
        int i11 = this.alohaCount;
        int i12 = this.matchCount;
        int i13 = this.alohaGetCount;
        boolean z14 = this.alohaGet;
        boolean z15 = this.alohaGetRequired;
        boolean z16 = this.alohaGetShow;
        String str17 = this.avatarImageId;
        Integer num4 = this.uid;
        String str18 = this.type;
        boolean z17 = this.ban;
        boolean z18 = this.aloha;
        boolean z19 = this.focus;
        boolean z20 = this.closeFriend;
        List<String> list = this.region;
        List<ProfileSpecListModel> list2 = this.profileSpecList;
        String str19 = this.distance;
        Double d10 = this.distanceKm;
        boolean z21 = this.match;
        Long l11 = this.lastOnlineMinutes;
        String str20 = this.sumConsume;
        boolean z22 = this.hasPrivacy;
        boolean z23 = this.block;
        boolean z24 = this.newMatch;
        boolean z25 = this.profileIncomplete;
        ImageModel imageModel2 = this.levelIcon;
        boolean z26 = this.showLocationIcon;
        boolean z27 = this.inProbationPeriod;
        List<AvatarProfileModel> list3 = this.avatarProfile;
        List<ImageModel> list4 = this.avatarFeeds;
        String str21 = this.summary;
        String str22 = this.activeInfo;
        String str23 = this.locationInfo;
        String str24 = this.summaryInfo;
        boolean z28 = this.locked;
        String str25 = this.userProfileSummaryInfo;
        Integer num5 = this.anchorLevel;
        Integer num6 = this.viewerLevel;
        String str26 = this.label;
        boolean z29 = this.highRisk;
        boolean z30 = this.vip;
        boolean z31 = this.annualVip;
        boolean z32 = this.svip;
        boolean z33 = this.annualSvip;
        boolean z34 = this.vipIconHide;
        String str27 = this.highRiskNotice;
        String str28 = this.reportData;
        String str29 = this.heiAndWei;
        String str30 = this.lastOnline;
        String str31 = this.location;
        Boolean bool = this.snapCapture;
        boolean z35 = this.nameMask;
        int i14 = this.vipAd;
        List<UserTagModel> list5 = this.userTags;
        String str32 = this.userTagsEmptyText;
        String str33 = this.tag;
        Boolean bool2 = this.shake;
        Integer num7 = this.infoProgress;
        String str34 = this.avatarTip;
        ImageModel imageModel3 = this.medalImage;
        boolean z36 = this.skipReceiveFeed;
        boolean z37 = this.showStoryLabel;
        List<FKStoryLabelItemModel> list6 = this.storyLabelList;
        boolean z38 = this.superLikedMe;
        boolean z39 = this.superLikedByMe;
        Integer num8 = this.superLikedMeCombos;
        Integer num9 = this.superLikedByMeCombos;
        boolean z40 = this.canSendInboxMessage;
        Integer num10 = this.superLikeRemains;
        String str35 = this.ipToCityName;
        ChatStatusItemModel chatStatusItemModel = this.chatStatus;
        Integer num11 = this.readStatus;
        String str36 = this.chatStatusTime;
        String str37 = this.activeDesc;
        String str38 = this.basicInfo;
        String str39 = this.role;
        boolean z41 = this.online;
        ImageModel imageModel4 = this.maskAvatar;
        String str40 = this.desc;
        boolean z42 = this.isVideoAvatarValid;
        String str41 = this.newUserTag;
        boolean z43 = this.onlyDefaultAvatar;
        AuditInfoUser auditInfoUser = this.auditInfoUser;
        FansClubMedalModel fansClubMedalModel = this.fansGroupIcon;
        ImageModel imageModel5 = this.newUserIcon;
        String str42 = this.maskName;
        List<String> list7 = this.interest;
        ImageModel imageModel6 = this.adminIcon;
        ProfileFriendPraiseModel profileFriendPraiseModel = this.praise;
        String str43 = this.formatAlohaCount;
        String str44 = this.formatAlohaGetCount;
        String str45 = this.formatMatchCount;
        String str46 = this.formatPostCount;
        ImageModel imageModel7 = this.profileLevelIcon;
        String str47 = this.individuationFrameConfig;
        boolean z44 = this.ssvip;
        boolean z45 = this.annualSsvip;
        boolean z46 = this.showMosaic;
        ImageModel imageModel8 = this.dailyRankIcon;
        ImageModel imageModel9 = this.weekRankIcon;
        ImageModel imageModel10 = this.nobleIcon;
        Integer num12 = this.userRole;
        UserClubModel userClubModel = this.groupInfo;
        ImageModel imageModel11 = this.groupMedal;
        ZodiacElfInfoModel zodiacElfInfoModel = this.zodiacInfo;
        Boolean bool3 = this.officialAccount;
        ImageModel imageModel12 = this.officialAccountIcon;
        MBTIInfoModel mBTIInfoModel = this.mbtiInfo;
        List<ProfileMBTIModel> list8 = this.profileSpecCardList;
        return "User(userId=" + str + ", id=" + str2 + ", name=" + str3 + ", onlineShowOpen=" + z10 + ", onlineLiveShowId=" + str4 + ", hadLiveShowOnce=" + z11 + ", balance=" + j10 + ", sumCommission=" + str5 + ", todayCommission=" + str6 + ", sumViewerCount=" + str7 + ", shareLink=" + str8 + ", shareTitle=" + str9 + ", shareContent=" + str10 + ", height=" + ((Object) num) + ", nickname=" + str11 + ", pro=" + z12 + ", regionCode=" + str12 + ", postCount=" + i10 + ", me=" + z13 + ", weight=" + ((Object) num2) + ", birthday=" + str13 + ", age=" + ((Object) num3) + ", zodiac=" + str14 + ", cityCode=" + str15 + ", activeTime=" + ((Object) l10) + ", _avatarImage=" + ((Object) imageModel) + ", displayRegion=" + str16 + ", alohaCount=" + i11 + ", matchCount=" + i12 + ", alohaGetCount=" + i13 + ", alohaGet=" + z14 + ", alohaGetRequired=" + z15 + ", alohaGetShow=" + z16 + ", avatarImageId=" + str17 + ", uid=" + ((Object) num4) + ", type=" + str18 + ", ban=" + z17 + ", aloha=" + z18 + ", focus=" + z19 + ", closeFriend=" + z20 + ", region=" + ((Object) list) + ", profileSpecList=" + ((Object) list2) + ", distance=" + str19 + ", distanceKm=" + ((Object) d10) + ", match=" + z21 + ", lastOnlineMinutes=" + ((Object) l11) + ", sumConsume=" + str20 + ", hasPrivacy=" + z22 + ", block=" + z23 + ", newMatch=" + z24 + ", profileIncomplete=" + z25 + ", levelIcon=" + ((Object) imageModel2) + ", showLocationIcon=" + z26 + ", inProbationPeriod=" + z27 + ", avatarProfile=" + ((Object) list3) + ", avatarFeeds=" + ((Object) list4) + ", summary=" + str21 + ", activeInfo=" + str22 + ", locationInfo=" + str23 + ", summaryInfo=" + str24 + ", locked=" + z28 + ", userProfileSummaryInfo=" + str25 + ", anchorLevel=" + ((Object) num5) + ", viewerLevel=" + ((Object) num6) + ", label=" + str26 + ", highRisk=" + z29 + ", vip=" + z30 + ", annualVip=" + z31 + ", svip=" + z32 + ", annualSvip=" + z33 + ", vipIconHide=" + z34 + ", highRiskNotice=" + str27 + ", reportData=" + str28 + ", heiAndWei=" + str29 + ", lastOnline=" + str30 + ", location=" + str31 + ", snapCapture=" + ((Object) bool) + ", nameMask=" + z35 + ", vipAd=" + i14 + ", userTags=" + ((Object) list5) + ", userTagsEmptyText=" + str32 + ", tag=" + str33 + ", shake=" + ((Object) bool2) + ", infoProgress=" + ((Object) num7) + ", avatarTip=" + str34 + ", medalImage=" + ((Object) imageModel3) + ", skipReceiveFeed=" + z36 + ", showStoryLabel=" + z37 + ", storyLabelList=" + ((Object) list6) + ", superLikedMe=" + z38 + ", superLikedByMe=" + z39 + ", superLikedMeCombos=" + ((Object) num8) + ", superLikedByMeCombos=" + ((Object) num9) + ", canSendInboxMessage=" + z40 + ", superLikeRemains=" + ((Object) num10) + ", ipToCityName=" + str35 + ", chatStatus=" + ((Object) chatStatusItemModel) + ", readStatus=" + ((Object) num11) + ", chatStatusTime=" + str36 + ", activeDesc=" + str37 + ", basicInfo=" + str38 + ", role=" + str39 + ", online=" + z41 + ", maskAvatar=" + ((Object) imageModel4) + ", desc=" + str40 + ", isVideoAvatarValid=" + z42 + ", newUserTag=" + str41 + ", onlyDefaultAvatar=" + z43 + ", auditInfoUser=" + ((Object) auditInfoUser) + ", fansGroupIcon=" + ((Object) fansClubMedalModel) + ", newUserIcon=" + ((Object) imageModel5) + ", maskName=" + str42 + ", interest=" + ((Object) list7) + ", adminIcon=" + ((Object) imageModel6) + ", praise=" + ((Object) profileFriendPraiseModel) + ", formatAlohaCount=" + str43 + ", formatAlohaGetCount=" + str44 + ", formatMatchCount=" + str45 + ", formatPostCount=" + str46 + ", profileLevelIcon=" + ((Object) imageModel7) + ", individuationFrameConfig=" + str47 + ", ssvip=" + z44 + ", annualSsvip=" + z45 + ", showMosaic=" + z46 + ", dailyRankIcon=" + ((Object) imageModel8) + ", weekRankIcon=" + ((Object) imageModel9) + ", nobleIcon=" + ((Object) imageModel10) + ", userRole=" + ((Object) num12) + ", groupInfo=" + ((Object) userClubModel) + ", groupMedal=" + ((Object) imageModel11) + ", zodiacInfo=" + ((Object) zodiacElfInfoModel) + ", officialAccount=" + ((Object) bool3) + ", officialAccountIcon=" + ((Object) imageModel12) + ", mbtiInfo=" + ((Object) mBTIInfoModel) + ", profileSpecCardList=" + ((Object) list8) + ", travelCity=" + this.travelCity + ")";
    }

    @NotNull
    public final String userId() {
        String str;
        String str2 = this.f17843id;
        if (str2 == null || str2.length() == 0) {
            str = this.userId;
            if (str == null) {
                return "";
            }
        } else {
            str = this.f17843id;
            if (str == null) {
                return "";
            }
        }
        return str;
    }

    public /* synthetic */ User(String str, String str2, String str3, boolean z10, String str4, boolean z11, long j10, String str5, String str6, String str7, String str8, String str9, String str10, Integer num, String str11, boolean z12, String str12, int i10, boolean z13, Integer num2, String str13, Integer num3, String str14, String str15, Long l10, ImageModel imageModel, String str16, int i11, int i12, int i13, boolean z14, boolean z15, boolean z16, String str17, Integer num4, String str18, boolean z17, boolean z18, boolean z19, boolean z20, List list, List list2, String str19, Double d10, boolean z21, Long l11, String str20, boolean z22, boolean z23, boolean z24, boolean z25, ImageModel imageModel2, boolean z26, boolean z27, List list3, List list4, String str21, String str22, String str23, String str24, boolean z28, String str25, Integer num5, Integer num6, String str26, boolean z29, boolean z30, boolean z31, boolean z32, boolean z33, boolean z34, String str27, String str28, String str29, String str30, String str31, Boolean bool, boolean z35, int i14, List list5, String str32, String str33, Boolean bool2, Integer num7, String str34, ImageModel imageModel3, boolean z36, boolean z37, List list6, boolean z38, boolean z39, Integer num8, Integer num9, boolean z40, Integer num10, String str35, ChatStatusItemModel chatStatusItemModel, Integer num11, String str36, String str37, String str38, String str39, boolean z41, ImageModel imageModel4, String str40, boolean z42, String str41, boolean z43, AuditInfoUser auditInfoUser, FansClubMedalModel fansClubMedalModel, ImageModel imageModel5, String str42, List list7, ImageModel imageModel6, ProfileFriendPraiseModel profileFriendPraiseModel, String str43, String str44, String str45, String str46, ImageModel imageModel7, String str47, boolean z44, boolean z45, boolean z46, ImageModel imageModel8, ImageModel imageModel9, ImageModel imageModel10, Integer num12, UserClubModel userClubModel, ImageModel imageModel11, ZodiacElfInfoModel zodiacElfInfoModel, Boolean bool3, ImageModel imageModel12, MBTIInfoModel mBTIInfoModel, List list8, String str48, int i15, int i16, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i15 & 1) != 0 ? null : str, (i15 & 2) != 0 ? null : str2, (i15 & 4) != 0 ? null : str3, (i15 & 8) != 0 ? false : z10, (i15 & 16) != 0 ? null : str4, (i15 & 32) != 0 ? false : z11, (i15 & 64) != 0 ? 0L : j10, (i15 & 128) != 0 ? null : str5, (i15 & 256) != 0 ? null : str6, (i15 & 512) != 0 ? null : str7, (i15 & 1024) != 0 ? null : str8, (i15 & 2048) != 0 ? "" : str9, (i15 & 4096) != 0 ? "" : str10, (i15 & 8192) != 0 ? null : num, (i15 & 16384) != 0 ? null : str11, (i15 & 32768) != 0 ? false : z12, (i15 & 65536) != 0 ? null : str12, (i15 & 131072) != 0 ? 0 : i10, (i15 & 262144) != 0 ? false : z13, (i15 & 524288) != 0 ? null : num2, (i15 & 1048576) != 0 ? null : str13, (i15 & 2097152) != 0 ? null : num3, (i15 & 4194304) != 0 ? null : str14, (i15 & 8388608) != 0 ? null : str15, (i15 & 16777216) != 0 ? null : l10, (i15 & 33554432) != 0 ? null : imageModel, (i15 & 67108864) != 0 ? null : str16, (i15 & 134217728) != 0 ? 0 : i11, (i15 & 268435456) != 0 ? 0 : i12, (i15 & 536870912) != 0 ? 0 : i13, (i15 & 1073741824) != 0 ? false : z14, (i15 & Integer.MIN_VALUE) != 0 ? false : z15, (i16 & 1) != 0 ? false : z16, (i16 & 2) != 0 ? null : str17, (i16 & 4) != 0 ? null : num4, (i16 & 8) != 0 ? null : str18, (i16 & 16) != 0 ? false : z17, (i16 & 32) != 0 ? false : z18, (i16 & 64) != 0 ? false : z19, (i16 & 128) != 0 ? false : z20, (i16 & 256) != 0 ? null : list, (i16 & 512) != 0 ? null : list2, (i16 & 1024) != 0 ? null : str19, (i16 & 2048) != 0 ? null : d10, (i16 & 4096) != 0 ? false : z21, (i16 & 8192) != 0 ? null : l11, (i16 & 16384) != 0 ? null : str20, (i16 & 32768) != 0 ? false : z22, (i16 & 65536) != 0 ? false : z23, (i16 & 131072) != 0 ? false : z24, (262144 & i16) != 0 ? false : z25, (524288 & i16) != 0 ? null : imageModel2, (1048576 & i16) != 0 ? false : z26, (2097152 & i16) != 0 ? false : z27, (4194304 & i16) != 0 ? new ArrayList() : list3, (8388608 & i16) != 0 ? new ArrayList() : list4, (16777216 & i16) != 0 ? null : str21, (i16 & 33554432) != 0 ? null : str22, (i16 & 67108864) != 0 ? null : str23, (134217728 & i16) != 0 ? null : str24, (268435456 & i16) != 0 ? false : z28, (536870912 & i16) != 0 ? null : str25, (1073741824 & i16) != 0 ? null : num5, (i16 & Integer.MIN_VALUE) != 0 ? null : num6, (i17 & 1) != 0 ? null : str26, (i17 & 2) != 0 ? false : z29, (i17 & 4) != 0 ? false : z30, (i17 & 8) != 0 ? false : z31, (i17 & 16) != 0 ? false : z32, (i17 & 32) != 0 ? false : z33, (i17 & 64) != 0 ? false : z34, (i17 & 128) != 0 ? null : str27, (i17 & 256) != 0 ? null : str28, (i17 & 512) != 0 ? null : str29, (i17 & 1024) != 0 ? null : str30, (i17 & 2048) != 0 ? null : str31, (i17 & 4096) != 0 ? Boolean.FALSE : bool, (i17 & 8192) != 0 ? false : z35, (i17 & 16384) != 0 ? 0 : i14, (32768 & i17) != 0 ? null : list5, (i17 & 65536) != 0 ? null : str32, (i17 & 131072) != 0 ? null : str33, (262144 & i17) != 0 ? null : bool2, (524288 & i17) != 0 ? null : num7, (1048576 & i17) != 0 ? null : str34, (2097152 & i17) != 0 ? null : imageModel3, (4194304 & i17) != 0 ? false : z36, (8388608 & i17) != 0 ? false : z37, (16777216 & i17) != 0 ? null : list6, (i17 & 33554432) != 0 ? false : z38, (i17 & 67108864) != 0 ? false : z39, num8, num9, (536870912 & i17) != 0 ? false : z40, (i17 & 1073741824) != 0 ? 0 : num10, str35, (i18 & 1) != 0 ? null : chatStatusItemModel, (i18 & 2) != 0 ? null : num11, str36, str37, str38, str39, (i18 & 64) != 0 ? false : z41, imageModel4, str40, (i18 & 512) != 0 ? true : z42, str41, (i18 & 2048) != 0 ? false : z43, auditInfoUser, fansClubMedalModel, imageModel5, str42, list7, imageModel6, profileFriendPraiseModel, str43, str44, str45, str46, imageModel7, str47, (i18 & 33554432) != 0 ? false : z44, (i18 & 67108864) != 0 ? false : z45, z46, imageModel8, imageModel9, imageModel10, num12, userClubModel, imageModel11, zodiacElfInfoModel, (i19 & 8) != 0 ? Boolean.FALSE : bool3, imageModel12, mBTIInfoModel, list8, str48);
    }
}
