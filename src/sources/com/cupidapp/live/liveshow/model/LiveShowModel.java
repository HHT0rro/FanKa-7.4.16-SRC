package com.cupidapp.live.liveshow.model;

import android.text.TextUtils;
import b2.a;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.liveshow.constants.FKLiveType;
import com.cupidapp.live.profile.model.User;
import com.irisdt.client.live.LiveProtos;
import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveShowModel implements Serializable {

    @Nullable
    private final List<AdModel> adList;
    private final boolean anchorCanConnectLive;

    @NotNull
    private final String anchorGradeWebUrl;
    private final int anchorLevel;

    @Nullable
    private final Integer anchorPrivilegeType;
    private final long appId;

    @NotNull
    private final String appSign;

    @NotNull
    private String barrageHintText;

    @NotNull
    private final String channelId;

    @NotNull
    private final String channelKey;

    @NotNull
    private final String channelName;

    @Nullable
    private final List<LiveShowModel> connectLive;

    @Nullable
    private final String coverData;

    @NotNull
    private final ImageModel coverImage;

    @Nullable
    private final LiveCoverTagModel coverTag;

    @Nullable
    private final List<LiveCoverTagModel> coverTags;

    @Nullable
    private final BadgeModel deco;
    private final long endTime;
    private final boolean ended;

    @Nullable
    private final Boolean hasCover;
    private final boolean hasWaterMark;

    @Nullable
    private final String heatValue;

    @Nullable
    private final Boolean highQualityCoverUser;

    @Nullable
    private final Boolean isObsStream;

    @NotNull
    private final String itemId;

    @Nullable
    private final ImageModel levelBadgeImage;

    @Nullable
    private final String liveConnectType;

    @Nullable
    private final String liveStreamSupplierId;

    @Nullable
    private String locationInfo;
    private final boolean mine;

    @Nullable
    private String mixStreamId;

    @Nullable
    private MultiPkInfoModel multiPkInfo;
    private final boolean pk;

    @Nullable
    private final LivePkingInfoModel pkingInfo;

    @Nullable
    private String recommendId;

    @Nullable
    private final RedEnvelopeTagModel redPacketInfo;

    @NotNull
    private final String salt;

    @Nullable
    private Double score;

    @Nullable
    private final String storeUrl;

    @Nullable
    private String strategyId;

    @NotNull
    private final String streamId;

    @Nullable
    private final String title;

    @NotNull
    private final String type;
    private final long uid;
    private final boolean useTestEnv;

    @NotNull
    private User user;

    @Nullable
    private final String userProfileSummaryInfo;

    @Nullable
    private String userType;

    @NotNull
    private final String vendorKey;

    @NotNull
    private String viewerCount;

    @Nullable
    private final String viewerMissionUrl;

    public LiveShowModel(@NotNull String itemId, @NotNull String type, @Nullable String str, @NotNull ImageModel coverImage, @NotNull User user, @NotNull String vendorKey, @NotNull String channelName, @NotNull String channelKey, long j10, boolean z10, @NotNull String viewerCount, boolean z11, long j11, long j12, @NotNull String appSign, @NotNull String streamId, @NotNull String channelId, @Nullable String str2, @NotNull String salt, boolean z12, @Nullable BadgeModel badgeModel, boolean z13, @Nullable String str3, boolean z14, @Nullable List<LiveShowModel> list, @Nullable String str4, @Nullable LivePkingInfoModel livePkingInfoModel, @NotNull String barrageHintText, @Nullable Boolean bool, @Nullable String str5, @Nullable String str6, @Nullable ImageModel imageModel, int i10, @NotNull String anchorGradeWebUrl, @Nullable Integer num, @Nullable String str7, @Nullable String str8, boolean z15, @Nullable LiveCoverTagModel liveCoverTagModel, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable String str9, @Nullable Double d10, @Nullable List<AdModel> list2, @Nullable RedEnvelopeTagModel redEnvelopeTagModel, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable MultiPkInfoModel multiPkInfoModel, @Nullable List<LiveCoverTagModel> list3) {
        s.i(itemId, "itemId");
        s.i(type, "type");
        s.i(coverImage, "coverImage");
        s.i(user, "user");
        s.i(vendorKey, "vendorKey");
        s.i(channelName, "channelName");
        s.i(channelKey, "channelKey");
        s.i(viewerCount, "viewerCount");
        s.i(appSign, "appSign");
        s.i(streamId, "streamId");
        s.i(channelId, "channelId");
        s.i(salt, "salt");
        s.i(barrageHintText, "barrageHintText");
        s.i(anchorGradeWebUrl, "anchorGradeWebUrl");
        this.itemId = itemId;
        this.type = type;
        this.title = str;
        this.coverImage = coverImage;
        this.user = user;
        this.vendorKey = vendorKey;
        this.channelName = channelName;
        this.channelKey = channelKey;
        this.uid = j10;
        this.mine = z10;
        this.viewerCount = viewerCount;
        this.ended = z11;
        this.endTime = j11;
        this.appId = j12;
        this.appSign = appSign;
        this.streamId = streamId;
        this.channelId = channelId;
        this.locationInfo = str2;
        this.salt = salt;
        this.useTestEnv = z12;
        this.deco = badgeModel;
        this.hasWaterMark = z13;
        this.liveStreamSupplierId = str3;
        this.anchorCanConnectLive = z14;
        this.connectLive = list;
        this.recommendId = str4;
        this.pkingInfo = livePkingInfoModel;
        this.barrageHintText = barrageHintText;
        this.isObsStream = bool;
        this.userProfileSummaryInfo = str5;
        this.strategyId = str6;
        this.levelBadgeImage = imageModel;
        this.anchorLevel = i10;
        this.anchorGradeWebUrl = anchorGradeWebUrl;
        this.anchorPrivilegeType = num;
        this.storeUrl = str7;
        this.viewerMissionUrl = str8;
        this.pk = z15;
        this.coverTag = liveCoverTagModel;
        this.hasCover = bool2;
        this.highQualityCoverUser = bool3;
        this.userType = str9;
        this.score = d10;
        this.adList = list2;
        this.redPacketInfo = redEnvelopeTagModel;
        this.liveConnectType = str10;
        this.coverData = str11;
        this.heatValue = str12;
        this.multiPkInfo = multiPkInfoModel;
        this.coverTags = list3;
    }

    @NotNull
    public final String component1() {
        return this.itemId;
    }

    public final boolean component10() {
        return this.mine;
    }

    @NotNull
    public final String component11() {
        return this.viewerCount;
    }

    public final boolean component12() {
        return this.ended;
    }

    public final long component13() {
        return this.endTime;
    }

    public final long component14() {
        return this.appId;
    }

    @NotNull
    public final String component15() {
        return this.appSign;
    }

    @NotNull
    public final String component16() {
        return this.streamId;
    }

    @NotNull
    public final String component17() {
        return this.channelId;
    }

    @Nullable
    public final String component18() {
        return this.locationInfo;
    }

    @NotNull
    public final String component19() {
        return this.salt;
    }

    @NotNull
    public final String component2() {
        return this.type;
    }

    public final boolean component20() {
        return this.useTestEnv;
    }

    @Nullable
    public final BadgeModel component21() {
        return this.deco;
    }

    public final boolean component22() {
        return this.hasWaterMark;
    }

    @Nullable
    public final String component23() {
        return this.liveStreamSupplierId;
    }

    public final boolean component24() {
        return this.anchorCanConnectLive;
    }

    @Nullable
    public final List<LiveShowModel> component25() {
        return this.connectLive;
    }

    @Nullable
    public final String component26() {
        return this.recommendId;
    }

    @Nullable
    public final LivePkingInfoModel component27() {
        return this.pkingInfo;
    }

    @NotNull
    public final String component28() {
        return this.barrageHintText;
    }

    @Nullable
    public final Boolean component29() {
        return this.isObsStream;
    }

    @Nullable
    public final String component3() {
        return this.title;
    }

    @Nullable
    public final String component30() {
        return this.userProfileSummaryInfo;
    }

    @Nullable
    public final String component31() {
        return this.strategyId;
    }

    @Nullable
    public final ImageModel component32() {
        return this.levelBadgeImage;
    }

    public final int component33() {
        return this.anchorLevel;
    }

    @NotNull
    public final String component34() {
        return this.anchorGradeWebUrl;
    }

    @Nullable
    public final Integer component35() {
        return this.anchorPrivilegeType;
    }

    @Nullable
    public final String component36() {
        return this.storeUrl;
    }

    @Nullable
    public final String component37() {
        return this.viewerMissionUrl;
    }

    public final boolean component38() {
        return this.pk;
    }

    @Nullable
    public final LiveCoverTagModel component39() {
        return this.coverTag;
    }

    @NotNull
    public final ImageModel component4() {
        return this.coverImage;
    }

    @Nullable
    public final Boolean component40() {
        return this.hasCover;
    }

    @Nullable
    public final Boolean component41() {
        return this.highQualityCoverUser;
    }

    @Nullable
    public final String component42() {
        return this.userType;
    }

    @Nullable
    public final Double component43() {
        return this.score;
    }

    @Nullable
    public final List<AdModel> component44() {
        return this.adList;
    }

    @Nullable
    public final RedEnvelopeTagModel component45() {
        return this.redPacketInfo;
    }

    @Nullable
    public final String component46() {
        return this.liveConnectType;
    }

    @Nullable
    public final String component47() {
        return this.coverData;
    }

    @Nullable
    public final String component48() {
        return this.heatValue;
    }

    @Nullable
    public final MultiPkInfoModel component49() {
        return this.multiPkInfo;
    }

    @NotNull
    public final User component5() {
        return this.user;
    }

    @Nullable
    public final List<LiveCoverTagModel> component50() {
        return this.coverTags;
    }

    @NotNull
    public final String component6() {
        return this.vendorKey;
    }

    @NotNull
    public final String component7() {
        return this.channelName;
    }

    @NotNull
    public final String component8() {
        return this.channelKey;
    }

    public final long component9() {
        return this.uid;
    }

    @NotNull
    public final LiveShowModel copy(@NotNull String itemId, @NotNull String type, @Nullable String str, @NotNull ImageModel coverImage, @NotNull User user, @NotNull String vendorKey, @NotNull String channelName, @NotNull String channelKey, long j10, boolean z10, @NotNull String viewerCount, boolean z11, long j11, long j12, @NotNull String appSign, @NotNull String streamId, @NotNull String channelId, @Nullable String str2, @NotNull String salt, boolean z12, @Nullable BadgeModel badgeModel, boolean z13, @Nullable String str3, boolean z14, @Nullable List<LiveShowModel> list, @Nullable String str4, @Nullable LivePkingInfoModel livePkingInfoModel, @NotNull String barrageHintText, @Nullable Boolean bool, @Nullable String str5, @Nullable String str6, @Nullable ImageModel imageModel, int i10, @NotNull String anchorGradeWebUrl, @Nullable Integer num, @Nullable String str7, @Nullable String str8, boolean z15, @Nullable LiveCoverTagModel liveCoverTagModel, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable String str9, @Nullable Double d10, @Nullable List<AdModel> list2, @Nullable RedEnvelopeTagModel redEnvelopeTagModel, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable MultiPkInfoModel multiPkInfoModel, @Nullable List<LiveCoverTagModel> list3) {
        s.i(itemId, "itemId");
        s.i(type, "type");
        s.i(coverImage, "coverImage");
        s.i(user, "user");
        s.i(vendorKey, "vendorKey");
        s.i(channelName, "channelName");
        s.i(channelKey, "channelKey");
        s.i(viewerCount, "viewerCount");
        s.i(appSign, "appSign");
        s.i(streamId, "streamId");
        s.i(channelId, "channelId");
        s.i(salt, "salt");
        s.i(barrageHintText, "barrageHintText");
        s.i(anchorGradeWebUrl, "anchorGradeWebUrl");
        return new LiveShowModel(itemId, type, str, coverImage, user, vendorKey, channelName, channelKey, j10, z10, viewerCount, z11, j11, j12, appSign, streamId, channelId, str2, salt, z12, badgeModel, z13, str3, z14, list, str4, livePkingInfoModel, barrageHintText, bool, str5, str6, imageModel, i10, anchorGradeWebUrl, num, str7, str8, z15, liveCoverTagModel, bool2, bool3, str9, d10, list2, redEnvelopeTagModel, str10, str11, str12, multiPkInfoModel, list3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveShowModel)) {
            return false;
        }
        LiveShowModel liveShowModel = (LiveShowModel) obj;
        return s.d(this.itemId, liveShowModel.itemId) && s.d(this.type, liveShowModel.type) && s.d(this.title, liveShowModel.title) && s.d(this.coverImage, liveShowModel.coverImage) && s.d(this.user, liveShowModel.user) && s.d(this.vendorKey, liveShowModel.vendorKey) && s.d(this.channelName, liveShowModel.channelName) && s.d(this.channelKey, liveShowModel.channelKey) && this.uid == liveShowModel.uid && this.mine == liveShowModel.mine && s.d(this.viewerCount, liveShowModel.viewerCount) && this.ended == liveShowModel.ended && this.endTime == liveShowModel.endTime && this.appId == liveShowModel.appId && s.d(this.appSign, liveShowModel.appSign) && s.d(this.streamId, liveShowModel.streamId) && s.d(this.channelId, liveShowModel.channelId) && s.d(this.locationInfo, liveShowModel.locationInfo) && s.d(this.salt, liveShowModel.salt) && this.useTestEnv == liveShowModel.useTestEnv && s.d(this.deco, liveShowModel.deco) && this.hasWaterMark == liveShowModel.hasWaterMark && s.d(this.liveStreamSupplierId, liveShowModel.liveStreamSupplierId) && this.anchorCanConnectLive == liveShowModel.anchorCanConnectLive && s.d(this.connectLive, liveShowModel.connectLive) && s.d(this.recommendId, liveShowModel.recommendId) && s.d(this.pkingInfo, liveShowModel.pkingInfo) && s.d(this.barrageHintText, liveShowModel.barrageHintText) && s.d(this.isObsStream, liveShowModel.isObsStream) && s.d(this.userProfileSummaryInfo, liveShowModel.userProfileSummaryInfo) && s.d(this.strategyId, liveShowModel.strategyId) && s.d(this.levelBadgeImage, liveShowModel.levelBadgeImage) && this.anchorLevel == liveShowModel.anchorLevel && s.d(this.anchorGradeWebUrl, liveShowModel.anchorGradeWebUrl) && s.d(this.anchorPrivilegeType, liveShowModel.anchorPrivilegeType) && s.d(this.storeUrl, liveShowModel.storeUrl) && s.d(this.viewerMissionUrl, liveShowModel.viewerMissionUrl) && this.pk == liveShowModel.pk && s.d(this.coverTag, liveShowModel.coverTag) && s.d(this.hasCover, liveShowModel.hasCover) && s.d(this.highQualityCoverUser, liveShowModel.highQualityCoverUser) && s.d(this.userType, liveShowModel.userType) && s.d(this.score, liveShowModel.score) && s.d(this.adList, liveShowModel.adList) && s.d(this.redPacketInfo, liveShowModel.redPacketInfo) && s.d(this.liveConnectType, liveShowModel.liveConnectType) && s.d(this.coverData, liveShowModel.coverData) && s.d(this.heatValue, liveShowModel.heatValue) && s.d(this.multiPkInfo, liveShowModel.multiPkInfo) && s.d(this.coverTags, liveShowModel.coverTags);
    }

    @Nullable
    public final List<AdModel> getAdList() {
        return this.adList;
    }

    public final boolean getAnchorCanConnectLive() {
        return this.anchorCanConnectLive;
    }

    @NotNull
    public final String getAnchorGradeWebUrl() {
        return this.anchorGradeWebUrl;
    }

    public final int getAnchorLevel() {
        return this.anchorLevel;
    }

    @Nullable
    public final Integer getAnchorPrivilegeType() {
        return this.anchorPrivilegeType;
    }

    public final long getAppId() {
        return this.appId;
    }

    @NotNull
    public final String getAppSign() {
        return this.appSign;
    }

    @NotNull
    public final String getBarrageHintText() {
        return this.barrageHintText;
    }

    @NotNull
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    public final String getChannelKey() {
        return this.channelKey;
    }

    @NotNull
    public final String getChannelName() {
        return this.channelName;
    }

    @Nullable
    public final List<LiveShowModel> getConnectLive() {
        return this.connectLive;
    }

    @Nullable
    public final String getCoverData() {
        return this.coverData;
    }

    @NotNull
    public final ImageModel getCoverImage() {
        return this.coverImage;
    }

    @Nullable
    public final LiveCoverTagModel getCoverTag() {
        return this.coverTag;
    }

    @Nullable
    public final List<LiveCoverTagModel> getCoverTags() {
        return this.coverTags;
    }

    @NotNull
    public final LiveProtos.CoverType getCoverType() {
        Boolean bool = this.hasCover;
        Boolean bool2 = Boolean.TRUE;
        if (s.d(bool, bool2)) {
            if (s.d(this.highQualityCoverUser, bool2)) {
                return LiveProtos.CoverType.HIGH_QUALITY;
            }
            return LiveProtos.CoverType.WITH;
        }
        return LiveProtos.CoverType.WITHOUT;
    }

    @Nullable
    public final BadgeModel getDeco() {
        return this.deco;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final boolean getEnded() {
        return this.ended;
    }

    @NotNull
    public final String getFormatHeatValue() {
        String str = this.heatValue;
        return str == null || str.length() == 0 ? "0" : this.heatValue;
    }

    @Nullable
    public final Boolean getHasCover() {
        return this.hasCover;
    }

    public final boolean getHasWaterMark() {
        return this.hasWaterMark;
    }

    @Nullable
    public final String getHeatValue() {
        return this.heatValue;
    }

    @Nullable
    public final Boolean getHighQualityCoverUser() {
        return this.highQualityCoverUser;
    }

    @NotNull
    public final String getItemId() {
        return this.itemId;
    }

    @Nullable
    public final ImageModel getLevelBadgeImage() {
        return this.levelBadgeImage;
    }

    @Nullable
    public final String getLiveConnectType() {
        return this.liveConnectType;
    }

    @Nullable
    public final String getLiveStreamSupplierId() {
        return this.liveStreamSupplierId;
    }

    @NotNull
    public final FKLiveType getLiveType() {
        return hasConnectLive() ? FKLiveType.CHAT : this.pk ? FKLiveType.PK : this.ended ? FKLiveType.FINISH : FKLiveType.COMMON;
    }

    @Nullable
    public final String getLocationInfo() {
        return this.locationInfo;
    }

    public final boolean getMine() {
        return this.mine;
    }

    @Nullable
    public final String getMixStreamId() {
        String str = this.mixStreamId;
        if (str != null) {
            return str;
        }
        MultiPkInfoModel multiPkInfoModel = this.multiPkInfo;
        if (multiPkInfoModel != null) {
            return multiPkInfoModel.getMixStreamId();
        }
        return null;
    }

    @Nullable
    public final MultiPkInfoModel getMultiPkInfo() {
        return this.multiPkInfo;
    }

    public final boolean getPk() {
        return this.pk;
    }

    @Nullable
    public final LivePkingInfoModel getPkingInfo() {
        return this.pkingInfo;
    }

    @Nullable
    public final String getRecommendId() {
        return this.recommendId;
    }

    @Nullable
    public final RedEnvelopeTagModel getRedPacketInfo() {
        return this.redPacketInfo;
    }

    @NotNull
    public final String getSalt() {
        return this.salt;
    }

    @Nullable
    public final Double getScore() {
        return this.score;
    }

    @Nullable
    public final String getStoreUrl() {
        return this.storeUrl;
    }

    @Nullable
    public final String getStrategyId() {
        return this.strategyId;
    }

    @NotNull
    public final String getStreamId() {
        return this.streamId;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public final long getUid() {
        return this.uid;
    }

    public final boolean getUseTestEnv() {
        return this.useTestEnv;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    @Nullable
    public final String getUserProfileSummaryInfo() {
        return this.userProfileSummaryInfo;
    }

    @Nullable
    public final String getUserType() {
        return this.userType;
    }

    @NotNull
    public final String getVendorKey() {
        return this.vendorKey;
    }

    @NotNull
    public final String getViewerCount() {
        return this.viewerCount;
    }

    @Nullable
    public final String getViewerMissionUrl() {
        return this.viewerMissionUrl;
    }

    public final boolean hasConnectLive() {
        List<LiveShowModel> list = this.connectLive;
        return !(list == null || list.isEmpty());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.itemId.hashCode() * 31) + this.type.hashCode()) * 31;
        String str = this.title;
        int hashCode2 = (((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.coverImage.hashCode()) * 31) + this.user.hashCode()) * 31) + this.vendorKey.hashCode()) * 31) + this.channelName.hashCode()) * 31) + this.channelKey.hashCode()) * 31) + a.a(this.uid)) * 31;
        boolean z10 = this.mine;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int hashCode3 = (((hashCode2 + i10) * 31) + this.viewerCount.hashCode()) * 31;
        boolean z11 = this.ended;
        int i11 = z11;
        if (z11 != 0) {
            i11 = 1;
        }
        int a10 = (((((((((((hashCode3 + i11) * 31) + a.a(this.endTime)) * 31) + a.a(this.appId)) * 31) + this.appSign.hashCode()) * 31) + this.streamId.hashCode()) * 31) + this.channelId.hashCode()) * 31;
        String str2 = this.locationInfo;
        int hashCode4 = (((a10 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.salt.hashCode()) * 31;
        boolean z12 = this.useTestEnv;
        int i12 = z12;
        if (z12 != 0) {
            i12 = 1;
        }
        int i13 = (hashCode4 + i12) * 31;
        BadgeModel badgeModel = this.deco;
        int hashCode5 = (i13 + (badgeModel == null ? 0 : badgeModel.hashCode())) * 31;
        boolean z13 = this.hasWaterMark;
        int i14 = z13;
        if (z13 != 0) {
            i14 = 1;
        }
        int i15 = (hashCode5 + i14) * 31;
        String str3 = this.liveStreamSupplierId;
        int hashCode6 = (i15 + (str3 == null ? 0 : str3.hashCode())) * 31;
        boolean z14 = this.anchorCanConnectLive;
        int i16 = z14;
        if (z14 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode6 + i16) * 31;
        List<LiveShowModel> list = this.connectLive;
        int hashCode7 = (i17 + (list == null ? 0 : list.hashCode())) * 31;
        String str4 = this.recommendId;
        int hashCode8 = (hashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        LivePkingInfoModel livePkingInfoModel = this.pkingInfo;
        int hashCode9 = (((hashCode8 + (livePkingInfoModel == null ? 0 : livePkingInfoModel.hashCode())) * 31) + this.barrageHintText.hashCode()) * 31;
        Boolean bool = this.isObsStream;
        int hashCode10 = (hashCode9 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str5 = this.userProfileSummaryInfo;
        int hashCode11 = (hashCode10 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.strategyId;
        int hashCode12 = (hashCode11 + (str6 == null ? 0 : str6.hashCode())) * 31;
        ImageModel imageModel = this.levelBadgeImage;
        int hashCode13 = (((((hashCode12 + (imageModel == null ? 0 : imageModel.hashCode())) * 31) + this.anchorLevel) * 31) + this.anchorGradeWebUrl.hashCode()) * 31;
        Integer num = this.anchorPrivilegeType;
        int hashCode14 = (hashCode13 + (num == null ? 0 : num.hashCode())) * 31;
        String str7 = this.storeUrl;
        int hashCode15 = (hashCode14 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.viewerMissionUrl;
        int hashCode16 = (hashCode15 + (str8 == null ? 0 : str8.hashCode())) * 31;
        boolean z15 = this.pk;
        int i18 = (hashCode16 + (z15 ? 1 : z15 ? 1 : 0)) * 31;
        LiveCoverTagModel liveCoverTagModel = this.coverTag;
        int hashCode17 = (i18 + (liveCoverTagModel == null ? 0 : liveCoverTagModel.hashCode())) * 31;
        Boolean bool2 = this.hasCover;
        int hashCode18 = (hashCode17 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.highQualityCoverUser;
        int hashCode19 = (hashCode18 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str9 = this.userType;
        int hashCode20 = (hashCode19 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Double d10 = this.score;
        int hashCode21 = (hashCode20 + (d10 == null ? 0 : d10.hashCode())) * 31;
        List<AdModel> list2 = this.adList;
        int hashCode22 = (hashCode21 + (list2 == null ? 0 : list2.hashCode())) * 31;
        RedEnvelopeTagModel redEnvelopeTagModel = this.redPacketInfo;
        int hashCode23 = (hashCode22 + (redEnvelopeTagModel == null ? 0 : redEnvelopeTagModel.hashCode())) * 31;
        String str10 = this.liveConnectType;
        int hashCode24 = (hashCode23 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.coverData;
        int hashCode25 = (hashCode24 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.heatValue;
        int hashCode26 = (hashCode25 + (str12 == null ? 0 : str12.hashCode())) * 31;
        MultiPkInfoModel multiPkInfoModel = this.multiPkInfo;
        int hashCode27 = (hashCode26 + (multiPkInfoModel == null ? 0 : multiPkInfoModel.hashCode())) * 31;
        List<LiveCoverTagModel> list3 = this.coverTags;
        return hashCode27 + (list3 != null ? list3.hashCode() : 0);
    }

    @Nullable
    public final Boolean isObsStream() {
        return this.isObsStream;
    }

    public final boolean isRemoteConnect() {
        return TextUtils.equals(this.liveStreamSupplierId, g.f52734a.g());
    }

    public final boolean isStreamer() {
        User X = g.f52734a.X();
        return s.d(X != null ? X.userId() : null, this.user.userId());
    }

    public final void setBarrageHintText(@NotNull String str) {
        s.i(str, "<set-?>");
        this.barrageHintText = str;
    }

    public final void setLocationInfo(@Nullable String str) {
        this.locationInfo = str;
    }

    public final void setMixStreamId(@Nullable String str) {
        this.mixStreamId = str;
    }

    public final void setMultiPkInfo(@Nullable MultiPkInfoModel multiPkInfoModel) {
        this.multiPkInfo = multiPkInfoModel;
    }

    public final void setRecommendId(@Nullable String str) {
        this.recommendId = str;
    }

    public final void setScore(@Nullable Double d10) {
        this.score = d10;
    }

    public final void setStrategyId(@Nullable String str) {
        this.strategyId = str;
    }

    public final void setUser(@NotNull User user) {
        s.i(user, "<set-?>");
        this.user = user;
    }

    public final void setUserType(@Nullable String str) {
        this.userType = str;
    }

    public final void setViewerCount(@NotNull String str) {
        s.i(str, "<set-?>");
        this.viewerCount = str;
    }

    @NotNull
    public String toString() {
        String str = this.itemId;
        String str2 = this.type;
        String str3 = this.title;
        ImageModel imageModel = this.coverImage;
        User user = this.user;
        String str4 = this.vendorKey;
        String str5 = this.channelName;
        String str6 = this.channelKey;
        long j10 = this.uid;
        boolean z10 = this.mine;
        String str7 = this.viewerCount;
        boolean z11 = this.ended;
        long j11 = this.endTime;
        long j12 = this.appId;
        String str8 = this.appSign;
        String str9 = this.streamId;
        String str10 = this.channelId;
        String str11 = this.locationInfo;
        String str12 = this.salt;
        boolean z12 = this.useTestEnv;
        BadgeModel badgeModel = this.deco;
        boolean z13 = this.hasWaterMark;
        String str13 = this.liveStreamSupplierId;
        boolean z14 = this.anchorCanConnectLive;
        List<LiveShowModel> list = this.connectLive;
        String str14 = this.recommendId;
        LivePkingInfoModel livePkingInfoModel = this.pkingInfo;
        String str15 = this.barrageHintText;
        Boolean bool = this.isObsStream;
        String str16 = this.userProfileSummaryInfo;
        String str17 = this.strategyId;
        ImageModel imageModel2 = this.levelBadgeImage;
        int i10 = this.anchorLevel;
        String str18 = this.anchorGradeWebUrl;
        Integer num = this.anchorPrivilegeType;
        String str19 = this.storeUrl;
        String str20 = this.viewerMissionUrl;
        boolean z15 = this.pk;
        LiveCoverTagModel liveCoverTagModel = this.coverTag;
        Boolean bool2 = this.hasCover;
        Boolean bool3 = this.highQualityCoverUser;
        String str21 = this.userType;
        Double d10 = this.score;
        List<AdModel> list2 = this.adList;
        RedEnvelopeTagModel redEnvelopeTagModel = this.redPacketInfo;
        return "LiveShowModel(itemId=" + str + ", type=" + str2 + ", title=" + str3 + ", coverImage=" + ((Object) imageModel) + ", user=" + ((Object) user) + ", vendorKey=" + str4 + ", channelName=" + str5 + ", channelKey=" + str6 + ", uid=" + j10 + ", mine=" + z10 + ", viewerCount=" + str7 + ", ended=" + z11 + ", endTime=" + j11 + ", appId=" + j12 + ", appSign=" + str8 + ", streamId=" + str9 + ", channelId=" + str10 + ", locationInfo=" + str11 + ", salt=" + str12 + ", useTestEnv=" + z12 + ", deco=" + ((Object) badgeModel) + ", hasWaterMark=" + z13 + ", liveStreamSupplierId=" + str13 + ", anchorCanConnectLive=" + z14 + ", connectLive=" + ((Object) list) + ", recommendId=" + str14 + ", pkingInfo=" + ((Object) livePkingInfoModel) + ", barrageHintText=" + str15 + ", isObsStream=" + ((Object) bool) + ", userProfileSummaryInfo=" + str16 + ", strategyId=" + str17 + ", levelBadgeImage=" + ((Object) imageModel2) + ", anchorLevel=" + i10 + ", anchorGradeWebUrl=" + str18 + ", anchorPrivilegeType=" + ((Object) num) + ", storeUrl=" + str19 + ", viewerMissionUrl=" + str20 + ", pk=" + z15 + ", coverTag=" + ((Object) liveCoverTagModel) + ", hasCover=" + ((Object) bool2) + ", highQualityCoverUser=" + ((Object) bool3) + ", userType=" + str21 + ", score=" + ((Object) d10) + ", adList=" + ((Object) list2) + ", redPacketInfo=" + ((Object) redEnvelopeTagModel) + ", liveConnectType=" + this.liveConnectType + ", coverData=" + this.coverData + ", heatValue=" + this.heatValue + ", multiPkInfo=" + ((Object) this.multiPkInfo) + ", coverTags=" + ((Object) this.coverTags) + ")";
    }

    public /* synthetic */ LiveShowModel(String str, String str2, String str3, ImageModel imageModel, User user, String str4, String str5, String str6, long j10, boolean z10, String str7, boolean z11, long j11, long j12, String str8, String str9, String str10, String str11, String str12, boolean z12, BadgeModel badgeModel, boolean z13, String str13, boolean z14, List list, String str14, LivePkingInfoModel livePkingInfoModel, String str15, Boolean bool, String str16, String str17, ImageModel imageModel2, int i10, String str18, Integer num, String str19, String str20, boolean z15, LiveCoverTagModel liveCoverTagModel, Boolean bool2, Boolean bool3, String str21, Double d10, List list2, RedEnvelopeTagModel redEnvelopeTagModel, String str22, String str23, String str24, MultiPkInfoModel multiPkInfoModel, List list3, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, imageModel, user, str4, str5, str6, j10, z10, (i11 & 1024) != 0 ? "0" : str7, z11, j11, j12, str8, str9, str10, str11, str12, z12, badgeModel, (2097152 & i11) != 0 ? false : z13, str13, (i11 & 8388608) != 0 ? false : z14, list, str14, livePkingInfoModel, str15, bool, str16, str17, imageModel2, i10, str18, num, str19, str20, z15, liveCoverTagModel, bool2, bool3, str21, d10, (i12 & 2048) != 0 ? null : list2, redEnvelopeTagModel, str22, str23, str24, multiPkInfoModel, list3);
    }
}
