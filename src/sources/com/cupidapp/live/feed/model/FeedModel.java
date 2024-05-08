package com.cupidapp.live.feed.model;

import b2.a;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.VideoModel;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.share.model.ShareOperateType;
import com.cupidapp.live.feed.FeedSensorType;
import com.cupidapp.live.feed.FeedType;
import com.cupidapp.live.hashtag.model.HashTag;
import com.cupidapp.live.mentionuser.model.ReplaceAtModel;
import com.cupidapp.live.profile.logic.c;
import com.cupidapp.live.profile.model.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.t;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedModel implements IBaseFeedModel, Serializable {

    @Nullable
    private final String adContextUrl;

    @Nullable
    private final AdTipModel adTip;

    @Nullable
    private final Boolean boosting;

    @Nullable
    private final BottomGuideModel bottomGuide;

    @Nullable
    private final String buttonText;

    @Nullable
    private final List<String> clickTrackUrlList;
    private final boolean closeFriendOnly;
    private int commentCount;

    @Nullable
    private final String content;
    private final long createTimeMillis;

    @Nullable
    private CustomTag customTag;

    @Nullable
    private String description;

    @Nullable
    private Boolean dynamicTop;

    @Nullable
    private final Integer exposureCount;

    @Nullable
    private Integer feedShareCount;

    @Nullable
    private final String flowContent;

    @Nullable
    private final PromotionNearByGuideModel guide;
    private boolean hasMoreComment;

    @Nullable
    private HashTag hashtag;

    @Nullable
    private final String hotTag;

    @Nullable
    private ImageModel image;

    @Nullable
    private final Integer imageCount;

    @Nullable
    private List<FeedImageInfoModel> imageInfoList;

    @Nullable
    private final String jumpUrl;

    @Nullable
    private final String label;

    @Nullable
    private final Double latitude;
    private int likeCount;
    private boolean liked;

    @Nullable
    private final List<UserWithPostLimitStatusModel> list;

    @Nullable
    private final Double longitude;

    @Nullable
    private final FeedModel post;

    @Nullable
    private final PostBoostModel postBoostInfo;

    @NotNull
    private final String postId;

    @Nullable
    private final String postStatisticsCallback;

    @Nullable
    private String postStatisticsSource;
    private final boolean privateFeed;

    @Nullable
    private final String publishIpCityName;

    @Nullable
    private final String rcmdType;

    @Nullable
    private List<PostCommentModel> recentComments;

    @Nullable
    private String recommendId;

    @Nullable
    private final List<ReplaceAtModel> replaceAtList;

    @Nullable
    private final String reportData;

    @Nullable
    private final String shareContent;

    @Nullable
    private final String shareLink;

    @Nullable
    private final String shareTitle;
    private boolean showAlohaBtn;

    @Nullable
    private final List<String> showTrackUrlList;

    @Nullable
    private final Boolean specialExposureSetting;

    @Nullable
    private final SponsorModel sponsorExtraInfo;

    @Nullable
    private final String strategyId;

    @Nullable
    private final Integer tagId;

    @Nullable
    private final String title;

    @NotNull
    private final String type;

    @Nullable
    private final String url;

    @NotNull
    private User user;

    @Nullable
    private final String venue;

    @Nullable
    private final Boolean venueAbroad;

    @Nullable
    private String venueId;

    @Nullable
    private VideoModel video;

    public FeedModel(@NotNull User user, @NotNull String postId, boolean z10, int i10, @Nullable ImageModel imageModel, @Nullable List<FeedImageInfoModel> list, @Nullable VideoModel videoModel, long j10, @Nullable Double d10, @Nullable Double d11, @Nullable String str, @Nullable Boolean bool, @Nullable String str2, @NotNull String type, @Nullable String str3, boolean z11, @Nullable List<PostCommentModel> list2, @Nullable HashTag hashTag, int i11, @Nullable String str4, @Nullable String str5, @Nullable Integer num, boolean z12, @Nullable String str6, @Nullable CustomTag customTag, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable String str13, @Nullable String str14, @Nullable String str15, @Nullable String str16, @Nullable String str17, boolean z13, boolean z14, @Nullable Boolean bool2, @Nullable PostBoostModel postBoostModel, @Nullable String str18, @Nullable List<String> list3, @Nullable List<String> list4, @Nullable String str19, @Nullable List<ReplaceAtModel> list5, @Nullable SponsorModel sponsorModel, @Nullable AdTipModel adTipModel, @Nullable String str20, @Nullable List<UserWithPostLimitStatusModel> list6, @Nullable String str21, @Nullable PromotionNearByGuideModel promotionNearByGuideModel, @Nullable String str22, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable FeedModel feedModel, @Nullable BottomGuideModel bottomGuideModel) {
        s.i(user, "user");
        s.i(postId, "postId");
        s.i(type, "type");
        this.user = user;
        this.postId = postId;
        this.liked = z10;
        this.likeCount = i10;
        this.image = imageModel;
        this.imageInfoList = list;
        this.video = videoModel;
        this.createTimeMillis = j10;
        this.latitude = d10;
        this.longitude = d11;
        this.venue = str;
        this.venueAbroad = bool;
        this.venueId = str2;
        this.type = type;
        this.url = str3;
        this.hasMoreComment = z11;
        this.recentComments = list2;
        this.hashtag = hashTag;
        this.commentCount = i11;
        this.description = str4;
        this.label = str5;
        this.exposureCount = num;
        this.showAlohaBtn = z12;
        this.recommendId = str6;
        this.customTag = customTag;
        this.reportData = str7;
        this.shareContent = str8;
        this.shareLink = str9;
        this.shareTitle = str10;
        this.title = str11;
        this.hotTag = str12;
        this.imageCount = num2;
        this.tagId = num3;
        this.feedShareCount = num4;
        this.content = str13;
        this.buttonText = str14;
        this.jumpUrl = str15;
        this.flowContent = str16;
        this.strategyId = str17;
        this.privateFeed = z13;
        this.closeFriendOnly = z14;
        this.boosting = bool2;
        this.postBoostInfo = postBoostModel;
        this.postStatisticsSource = str18;
        this.showTrackUrlList = list3;
        this.clickTrackUrlList = list4;
        this.adContextUrl = str19;
        this.replaceAtList = list5;
        this.sponsorExtraInfo = sponsorModel;
        this.adTip = adTipModel;
        this.publishIpCityName = str20;
        this.list = list6;
        this.rcmdType = str21;
        this.guide = promotionNearByGuideModel;
        this.postStatisticsCallback = str22;
        this.dynamicTop = bool3;
        this.specialExposureSetting = bool4;
        this.post = feedModel;
        this.bottomGuide = bottomGuideModel;
    }

    public final boolean canPostBoost() {
        PostBoostModel postBoostModel = this.postBoostInfo;
        return ((postBoostModel != null ? postBoostModel.getImage() : null) == null || this.postBoostInfo.getPostBoostWebUrl() == null || !c.f17839a.a(this.user.userId())) ? false : true;
    }

    public final boolean canShowAdSpread(@Nullable SensorPosition sensorPosition) {
        return (!haveAdTip() || c.f17839a.a(this.user.userId()) || sensorPosition == SensorPosition.FeedDetail) ? false : true;
    }

    public final boolean canShowPostSpread(@Nullable SensorPosition sensorPosition) {
        PostBoostModel postBoostModel = this.postBoostInfo;
        return ((postBoostModel != null ? postBoostModel.getPostBoostWebUrl() : null) == null || c.f17839a.a(this.user.userId()) || sensorPosition == SensorPosition.FeedDetail) ? false : true;
    }

    public final void cancelPraise() {
        int i10 = this.likeCount;
        if (i10 == 0 || !this.liked) {
            return;
        }
        this.likeCount = i10 - 1;
        this.liked = false;
    }

    public final boolean checkHaveSponsorTip() {
        SponsorModel sponsorModel = this.sponsorExtraInfo;
        if (sponsorModel != null) {
            String title = sponsorModel.getTitle();
            if (!(title == null || title.length() == 0)) {
                String url = this.sponsorExtraInfo.getUrl();
                if (!(url == null || url.length() == 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    @NotNull
    public final User component1() {
        return this.user;
    }

    @Nullable
    public final Double component10() {
        return this.longitude;
    }

    @Nullable
    public final String component11() {
        return this.venue;
    }

    @Nullable
    public final Boolean component12() {
        return this.venueAbroad;
    }

    @Nullable
    public final String component13() {
        return this.venueId;
    }

    @NotNull
    public final String component14() {
        return this.type;
    }

    @Nullable
    public final String component15() {
        return this.url;
    }

    public final boolean component16() {
        return this.hasMoreComment;
    }

    @Nullable
    public final List<PostCommentModel> component17() {
        return this.recentComments;
    }

    @Nullable
    public final HashTag component18() {
        return this.hashtag;
    }

    public final int component19() {
        return this.commentCount;
    }

    @NotNull
    public final String component2() {
        return this.postId;
    }

    @Nullable
    public final String component20() {
        return this.description;
    }

    @Nullable
    public final String component21() {
        return this.label;
    }

    @Nullable
    public final Integer component22() {
        return this.exposureCount;
    }

    public final boolean component23() {
        return this.showAlohaBtn;
    }

    @Nullable
    public final String component24() {
        return this.recommendId;
    }

    @Nullable
    public final CustomTag component25() {
        return this.customTag;
    }

    @Nullable
    public final String component26() {
        return this.reportData;
    }

    @Nullable
    public final String component27() {
        return this.shareContent;
    }

    @Nullable
    public final String component28() {
        return this.shareLink;
    }

    @Nullable
    public final String component29() {
        return this.shareTitle;
    }

    public final boolean component3() {
        return this.liked;
    }

    @Nullable
    public final String component30() {
        return this.title;
    }

    @Nullable
    public final String component31() {
        return this.hotTag;
    }

    @Nullable
    public final Integer component32() {
        return this.imageCount;
    }

    @Nullable
    public final Integer component33() {
        return this.tagId;
    }

    @Nullable
    public final Integer component34() {
        return this.feedShareCount;
    }

    @Nullable
    public final String component35() {
        return this.content;
    }

    @Nullable
    public final String component36() {
        return this.buttonText;
    }

    @Nullable
    public final String component37() {
        return this.jumpUrl;
    }

    @Nullable
    public final String component38() {
        return this.flowContent;
    }

    @Nullable
    public final String component39() {
        return this.strategyId;
    }

    public final int component4() {
        return this.likeCount;
    }

    public final boolean component40() {
        return this.privateFeed;
    }

    public final boolean component41() {
        return this.closeFriendOnly;
    }

    @Nullable
    public final Boolean component42() {
        return this.boosting;
    }

    @Nullable
    public final PostBoostModel component43() {
        return this.postBoostInfo;
    }

    @Nullable
    public final String component44() {
        return this.postStatisticsSource;
    }

    @Nullable
    public final List<String> component45() {
        return this.showTrackUrlList;
    }

    @Nullable
    public final List<String> component46() {
        return this.clickTrackUrlList;
    }

    @Nullable
    public final String component47() {
        return this.adContextUrl;
    }

    @Nullable
    public final List<ReplaceAtModel> component48() {
        return this.replaceAtList;
    }

    @Nullable
    public final SponsorModel component49() {
        return this.sponsorExtraInfo;
    }

    @Nullable
    public final ImageModel component5() {
        return this.image;
    }

    @Nullable
    public final AdTipModel component50() {
        return this.adTip;
    }

    @Nullable
    public final String component51() {
        return this.publishIpCityName;
    }

    @Nullable
    public final List<UserWithPostLimitStatusModel> component52() {
        return this.list;
    }

    @Nullable
    public final String component53() {
        return this.rcmdType;
    }

    @Nullable
    public final PromotionNearByGuideModel component54() {
        return this.guide;
    }

    @Nullable
    public final String component55() {
        return this.postStatisticsCallback;
    }

    @Nullable
    public final Boolean component56() {
        return this.dynamicTop;
    }

    @Nullable
    public final Boolean component57() {
        return this.specialExposureSetting;
    }

    @Nullable
    public final FeedModel component58() {
        return this.post;
    }

    @Nullable
    public final BottomGuideModel component59() {
        return this.bottomGuide;
    }

    @Nullable
    public final List<FeedImageInfoModel> component6() {
        return this.imageInfoList;
    }

    @Nullable
    public final VideoModel component7() {
        return this.video;
    }

    public final long component8() {
        return this.createTimeMillis;
    }

    @Nullable
    public final Double component9() {
        return this.latitude;
    }

    @NotNull
    public final FeedModel copy(@NotNull User user, @NotNull String postId, boolean z10, int i10, @Nullable ImageModel imageModel, @Nullable List<FeedImageInfoModel> list, @Nullable VideoModel videoModel, long j10, @Nullable Double d10, @Nullable Double d11, @Nullable String str, @Nullable Boolean bool, @Nullable String str2, @NotNull String type, @Nullable String str3, boolean z11, @Nullable List<PostCommentModel> list2, @Nullable HashTag hashTag, int i11, @Nullable String str4, @Nullable String str5, @Nullable Integer num, boolean z12, @Nullable String str6, @Nullable CustomTag customTag, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable String str13, @Nullable String str14, @Nullable String str15, @Nullable String str16, @Nullable String str17, boolean z13, boolean z14, @Nullable Boolean bool2, @Nullable PostBoostModel postBoostModel, @Nullable String str18, @Nullable List<String> list3, @Nullable List<String> list4, @Nullable String str19, @Nullable List<ReplaceAtModel> list5, @Nullable SponsorModel sponsorModel, @Nullable AdTipModel adTipModel, @Nullable String str20, @Nullable List<UserWithPostLimitStatusModel> list6, @Nullable String str21, @Nullable PromotionNearByGuideModel promotionNearByGuideModel, @Nullable String str22, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable FeedModel feedModel, @Nullable BottomGuideModel bottomGuideModel) {
        s.i(user, "user");
        s.i(postId, "postId");
        s.i(type, "type");
        return new FeedModel(user, postId, z10, i10, imageModel, list, videoModel, j10, d10, d11, str, bool, str2, type, str3, z11, list2, hashTag, i11, str4, str5, num, z12, str6, customTag, str7, str8, str9, str10, str11, str12, num2, num3, num4, str13, str14, str15, str16, str17, z13, z14, bool2, postBoostModel, str18, list3, list4, str19, list5, sponsorModel, adTipModel, str20, list6, str21, promotionNearByGuideModel, str22, bool3, bool4, feedModel, bottomGuideModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedModel)) {
            return false;
        }
        FeedModel feedModel = (FeedModel) obj;
        return s.d(this.user, feedModel.user) && s.d(this.postId, feedModel.postId) && this.liked == feedModel.liked && this.likeCount == feedModel.likeCount && s.d(this.image, feedModel.image) && s.d(this.imageInfoList, feedModel.imageInfoList) && s.d(this.video, feedModel.video) && this.createTimeMillis == feedModel.createTimeMillis && s.d(this.latitude, feedModel.latitude) && s.d(this.longitude, feedModel.longitude) && s.d(this.venue, feedModel.venue) && s.d(this.venueAbroad, feedModel.venueAbroad) && s.d(this.venueId, feedModel.venueId) && s.d(this.type, feedModel.type) && s.d(this.url, feedModel.url) && this.hasMoreComment == feedModel.hasMoreComment && s.d(this.recentComments, feedModel.recentComments) && s.d(this.hashtag, feedModel.hashtag) && this.commentCount == feedModel.commentCount && s.d(this.description, feedModel.description) && s.d(this.label, feedModel.label) && s.d(this.exposureCount, feedModel.exposureCount) && this.showAlohaBtn == feedModel.showAlohaBtn && s.d(this.recommendId, feedModel.recommendId) && s.d(this.customTag, feedModel.customTag) && s.d(this.reportData, feedModel.reportData) && s.d(this.shareContent, feedModel.shareContent) && s.d(this.shareLink, feedModel.shareLink) && s.d(this.shareTitle, feedModel.shareTitle) && s.d(this.title, feedModel.title) && s.d(this.hotTag, feedModel.hotTag) && s.d(this.imageCount, feedModel.imageCount) && s.d(this.tagId, feedModel.tagId) && s.d(this.feedShareCount, feedModel.feedShareCount) && s.d(this.content, feedModel.content) && s.d(this.buttonText, feedModel.buttonText) && s.d(this.jumpUrl, feedModel.jumpUrl) && s.d(this.flowContent, feedModel.flowContent) && s.d(this.strategyId, feedModel.strategyId) && this.privateFeed == feedModel.privateFeed && this.closeFriendOnly == feedModel.closeFriendOnly && s.d(this.boosting, feedModel.boosting) && s.d(this.postBoostInfo, feedModel.postBoostInfo) && s.d(this.postStatisticsSource, feedModel.postStatisticsSource) && s.d(this.showTrackUrlList, feedModel.showTrackUrlList) && s.d(this.clickTrackUrlList, feedModel.clickTrackUrlList) && s.d(this.adContextUrl, feedModel.adContextUrl) && s.d(this.replaceAtList, feedModel.replaceAtList) && s.d(this.sponsorExtraInfo, feedModel.sponsorExtraInfo) && s.d(this.adTip, feedModel.adTip) && s.d(this.publishIpCityName, feedModel.publishIpCityName) && s.d(this.list, feedModel.list) && s.d(this.rcmdType, feedModel.rcmdType) && s.d(this.guide, feedModel.guide) && s.d(this.postStatisticsCallback, feedModel.postStatisticsCallback) && s.d(this.dynamicTop, feedModel.dynamicTop) && s.d(this.specialExposureSetting, feedModel.specialExposureSetting) && s.d(this.post, feedModel.post) && s.d(this.bottomGuide, feedModel.bottomGuide);
    }

    @Nullable
    public final String getAdContextUrl() {
        return this.adContextUrl;
    }

    @Nullable
    public final AdTipModel getAdTip() {
        return this.adTip;
    }

    @Nullable
    public final Boolean getBoosting() {
        return this.boosting;
    }

    @Nullable
    public final BottomGuideModel getBottomGuide() {
        return this.bottomGuide;
    }

    @Nullable
    public final String getButtonText() {
        return this.buttonText;
    }

    @Nullable
    public final List<String> getClickTrackUrlList() {
        return this.clickTrackUrlList;
    }

    public final boolean getCloseFriendOnly() {
        return this.closeFriendOnly;
    }

    public final int getCommentCount() {
        return this.commentCount;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    public final long getCreateTimeMillis() {
        return this.createTimeMillis;
    }

    @Nullable
    public final CustomTag getCustomTag() {
        return this.customTag;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final Boolean getDynamicTop() {
        return this.dynamicTop;
    }

    @Nullable
    public final Integer getExposureCount() {
        return this.exposureCount;
    }

    @NotNull
    public final String getFeedContentType() {
        return this.video != null ? "VIDEO" : "PHOTO";
    }

    @Nullable
    public final Integer getFeedShareCount() {
        return this.feedShareCount;
    }

    @Nullable
    public final String getFlowContent() {
        return this.flowContent;
    }

    @Nullable
    public final PromotionNearByGuideModel getGuide() {
        return this.guide;
    }

    public final boolean getHasMoreComment() {
        return this.hasMoreComment;
    }

    @Nullable
    public final HashTag getHashtag() {
        return this.hashtag;
    }

    @Nullable
    public final String getHotTag() {
        return this.hotTag;
    }

    @Nullable
    public final ImageModel getImage() {
        return this.image;
    }

    @Nullable
    /* renamed from: getImageCount, reason: collision with other method in class */
    public final Integer m2577getImageCount() {
        return this.imageCount;
    }

    @Nullable
    public final List<FeedImageInfoModel> getImageInfoList() {
        return this.imageInfoList;
    }

    @Nullable
    public final List<ImageModel> getImageList() {
        ImageModel imageModel = this.image;
        if (imageModel != null) {
            s.f(imageModel);
            return kotlin.collections.s.o(imageModel);
        }
        List<FeedImageInfoModel> list = this.imageInfoList;
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(t.t(list, 10));
        Iterator<FeedImageInfoModel> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next().getImage());
        }
        return CollectionsKt___CollectionsKt.z0(arrayList);
    }

    public final int getImageListCount() {
        List<ImageModel> imageList = getImageList();
        if (imageList != null) {
            return imageList.size();
        }
        return 0;
    }

    @Nullable
    public final ImageModel getImageListFirst() {
        List<ImageModel> imageList = getImageList();
        if (imageList != null) {
            return (ImageModel) CollectionsKt___CollectionsKt.V(imageList);
        }
        return null;
    }

    @Nullable
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    public final Double getLatitude() {
        return this.latitude;
    }

    public final int getLikeCount() {
        return this.likeCount;
    }

    public final boolean getLiked() {
        return this.liked;
    }

    @Nullable
    public final List<UserWithPostLimitStatusModel> getList() {
        return this.list;
    }

    @Nullable
    public final Double getLongitude() {
        return this.longitude;
    }

    @Nullable
    public final FeedModel getPost() {
        return this.post;
    }

    @Nullable
    public final PostBoostModel getPostBoostInfo() {
        return this.postBoostInfo;
    }

    @NotNull
    public final String getPostId() {
        return this.postId;
    }

    @Nullable
    public final String getPostStatisticsCallback() {
        return this.postStatisticsCallback;
    }

    @Nullable
    public final String getPostStatisticsSource() {
        return this.postStatisticsSource;
    }

    public final boolean getPrivateFeed() {
        return this.privateFeed;
    }

    @Nullable
    public final String getPublishIpCityName() {
        return this.publishIpCityName;
    }

    @Nullable
    public final String getRcmdType() {
        return this.rcmdType;
    }

    @Nullable
    public final List<PostCommentModel> getRecentComments() {
        return this.recentComments;
    }

    @Nullable
    public final String getRecommendId() {
        return this.recommendId;
    }

    @Nullable
    public final List<ReplaceAtModel> getReplaceAtList() {
        return this.replaceAtList;
    }

    @Nullable
    public final String getReportData() {
        return this.reportData;
    }

    @Override // com.cupidapp.live.feed.model.IBaseFeedModel
    @NotNull
    public String getSensorFeedType() {
        String value;
        String str = this.type;
        if (s.d(str, FeedType.ImagePost.getValue())) {
            if (getImageCount() > 1) {
                value = FeedSensorType.MultipleImagePost.getValue();
            } else {
                value = FeedSensorType.ImagePost.getValue();
            }
        } else if (s.d(str, FeedType.VideoPost.getValue())) {
            value = FeedSensorType.VideoPost.getValue();
        } else {
            value = s.d(str, FeedType.ShowCase.getValue()) ? FeedSensorType.ShowCase.getValue() : "";
        }
        return haveSponsor() ? FeedSensorType.SponsorPost.getValue() : value;
    }

    @Nullable
    public final String getShareContent() {
        return this.shareContent;
    }

    @Nullable
    public final String getShareLink() {
        return this.shareLink;
    }

    @NotNull
    public final ShareOperateType getShareOperateType() {
        return this.privateFeed ? ShareOperateType.UN_PRIVATE : ShareOperateType.PRIVATE;
    }

    @Nullable
    public final String getShareTitle() {
        return this.shareTitle;
    }

    public final boolean getShowAlohaBtn() {
        return this.showAlohaBtn;
    }

    @Nullable
    public final List<String> getShowTrackUrlList() {
        return this.showTrackUrlList;
    }

    @Nullable
    public final Boolean getSpecialExposureSetting() {
        return this.specialExposureSetting;
    }

    @Nullable
    public final SponsorModel getSponsorExtraInfo() {
        return this.sponsorExtraInfo;
    }

    @Nullable
    public final String getStrategyId() {
        return this.strategyId;
    }

    @Nullable
    public final Integer getTagId() {
        return this.tagId;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final User getUser() {
        return this.user;
    }

    @Nullable
    public final String getVenue() {
        return this.venue;
    }

    @Nullable
    public final Boolean getVenueAbroad() {
        return this.venueAbroad;
    }

    @Nullable
    public final String getVenueId() {
        return this.venueId;
    }

    @Nullable
    public final VideoModel getVideo() {
        return this.video;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.user.hashCode() * 31) + this.postId.hashCode()) * 31;
        boolean z10 = this.liked;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (((hashCode + i10) * 31) + this.likeCount) * 31;
        ImageModel imageModel = this.image;
        int hashCode2 = (i11 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        List<FeedImageInfoModel> list = this.imageInfoList;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        VideoModel videoModel = this.video;
        int hashCode4 = (((hashCode3 + (videoModel == null ? 0 : videoModel.hashCode())) * 31) + a.a(this.createTimeMillis)) * 31;
        Double d10 = this.latitude;
        int hashCode5 = (hashCode4 + (d10 == null ? 0 : d10.hashCode())) * 31;
        Double d11 = this.longitude;
        int hashCode6 = (hashCode5 + (d11 == null ? 0 : d11.hashCode())) * 31;
        String str = this.venue;
        int hashCode7 = (hashCode6 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.venueAbroad;
        int hashCode8 = (hashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.venueId;
        int hashCode9 = (((hashCode8 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.type.hashCode()) * 31;
        String str3 = this.url;
        int hashCode10 = (hashCode9 + (str3 == null ? 0 : str3.hashCode())) * 31;
        boolean z11 = this.hasMoreComment;
        int i12 = z11;
        if (z11 != 0) {
            i12 = 1;
        }
        int i13 = (hashCode10 + i12) * 31;
        List<PostCommentModel> list2 = this.recentComments;
        int hashCode11 = (i13 + (list2 == null ? 0 : list2.hashCode())) * 31;
        HashTag hashTag = this.hashtag;
        int hashCode12 = (((hashCode11 + (hashTag == null ? 0 : hashTag.hashCode())) * 31) + this.commentCount) * 31;
        String str4 = this.description;
        int hashCode13 = (hashCode12 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.label;
        int hashCode14 = (hashCode13 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.exposureCount;
        int hashCode15 = (hashCode14 + (num == null ? 0 : num.hashCode())) * 31;
        boolean z12 = this.showAlohaBtn;
        int i14 = z12;
        if (z12 != 0) {
            i14 = 1;
        }
        int i15 = (hashCode15 + i14) * 31;
        String str6 = this.recommendId;
        int hashCode16 = (i15 + (str6 == null ? 0 : str6.hashCode())) * 31;
        CustomTag customTag = this.customTag;
        int hashCode17 = (hashCode16 + (customTag == null ? 0 : customTag.hashCode())) * 31;
        String str7 = this.reportData;
        int hashCode18 = (hashCode17 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.shareContent;
        int hashCode19 = (hashCode18 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.shareLink;
        int hashCode20 = (hashCode19 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.shareTitle;
        int hashCode21 = (hashCode20 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.title;
        int hashCode22 = (hashCode21 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.hotTag;
        int hashCode23 = (hashCode22 + (str12 == null ? 0 : str12.hashCode())) * 31;
        Integer num2 = this.imageCount;
        int hashCode24 = (hashCode23 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.tagId;
        int hashCode25 = (hashCode24 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.feedShareCount;
        int hashCode26 = (hashCode25 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str13 = this.content;
        int hashCode27 = (hashCode26 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.buttonText;
        int hashCode28 = (hashCode27 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.jumpUrl;
        int hashCode29 = (hashCode28 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.flowContent;
        int hashCode30 = (hashCode29 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.strategyId;
        int hashCode31 = (hashCode30 + (str17 == null ? 0 : str17.hashCode())) * 31;
        boolean z13 = this.privateFeed;
        int i16 = z13;
        if (z13 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode31 + i16) * 31;
        boolean z14 = this.closeFriendOnly;
        int i18 = (i17 + (z14 ? 1 : z14 ? 1 : 0)) * 31;
        Boolean bool2 = this.boosting;
        int hashCode32 = (i18 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        PostBoostModel postBoostModel = this.postBoostInfo;
        int hashCode33 = (hashCode32 + (postBoostModel == null ? 0 : postBoostModel.hashCode())) * 31;
        String str18 = this.postStatisticsSource;
        int hashCode34 = (hashCode33 + (str18 == null ? 0 : str18.hashCode())) * 31;
        List<String> list3 = this.showTrackUrlList;
        int hashCode35 = (hashCode34 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<String> list4 = this.clickTrackUrlList;
        int hashCode36 = (hashCode35 + (list4 == null ? 0 : list4.hashCode())) * 31;
        String str19 = this.adContextUrl;
        int hashCode37 = (hashCode36 + (str19 == null ? 0 : str19.hashCode())) * 31;
        List<ReplaceAtModel> list5 = this.replaceAtList;
        int hashCode38 = (hashCode37 + (list5 == null ? 0 : list5.hashCode())) * 31;
        SponsorModel sponsorModel = this.sponsorExtraInfo;
        int hashCode39 = (hashCode38 + (sponsorModel == null ? 0 : sponsorModel.hashCode())) * 31;
        AdTipModel adTipModel = this.adTip;
        int hashCode40 = (hashCode39 + (adTipModel == null ? 0 : adTipModel.hashCode())) * 31;
        String str20 = this.publishIpCityName;
        int hashCode41 = (hashCode40 + (str20 == null ? 0 : str20.hashCode())) * 31;
        List<UserWithPostLimitStatusModel> list6 = this.list;
        int hashCode42 = (hashCode41 + (list6 == null ? 0 : list6.hashCode())) * 31;
        String str21 = this.rcmdType;
        int hashCode43 = (hashCode42 + (str21 == null ? 0 : str21.hashCode())) * 31;
        PromotionNearByGuideModel promotionNearByGuideModel = this.guide;
        int hashCode44 = (hashCode43 + (promotionNearByGuideModel == null ? 0 : promotionNearByGuideModel.hashCode())) * 31;
        String str22 = this.postStatisticsCallback;
        int hashCode45 = (hashCode44 + (str22 == null ? 0 : str22.hashCode())) * 31;
        Boolean bool3 = this.dynamicTop;
        int hashCode46 = (hashCode45 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.specialExposureSetting;
        int hashCode47 = (hashCode46 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        FeedModel feedModel = this.post;
        int hashCode48 = (hashCode47 + (feedModel == null ? 0 : feedModel.hashCode())) * 31;
        BottomGuideModel bottomGuideModel = this.bottomGuide;
        return hashCode48 + (bottomGuideModel != null ? bottomGuideModel.hashCode() : 0);
    }

    public final boolean haveAdTip() {
        AdTipModel adTipModel = this.adTip;
        return (adTipModel != null ? adTipModel.getTitle() : null) != null;
    }

    public final boolean haveSponsor() {
        return this.sponsorExtraInfo != null;
    }

    public final boolean isPostBoostSpread() {
        return s.d(this.boosting, Boolean.TRUE);
    }

    public final boolean isUnAlohaFeed() {
        return (this.sponsorExtraInfo != null || this.user.getAloha() || this.user.getMe()) ? false : true;
    }

    public final void praise() {
        if (this.liked) {
            return;
        }
        this.likeCount++;
        this.liked = true;
    }

    public final void setCommentCount(int i10) {
        this.commentCount = i10;
    }

    public final void setCustomTag(@Nullable CustomTag customTag) {
        this.customTag = customTag;
    }

    public final void setDescription(@Nullable String str) {
        this.description = str;
    }

    public final void setDynamicTop(@Nullable Boolean bool) {
        this.dynamicTop = bool;
    }

    public final void setFeedShareCount(@Nullable Integer num) {
        this.feedShareCount = num;
    }

    public final void setHasMoreComment(boolean z10) {
        this.hasMoreComment = z10;
    }

    public final void setHashtag(@Nullable HashTag hashTag) {
        this.hashtag = hashTag;
    }

    public final void setImage(@Nullable ImageModel imageModel) {
        this.image = imageModel;
    }

    public final void setImageInfoList(@Nullable List<FeedImageInfoModel> list) {
        this.imageInfoList = list;
    }

    public final void setLikeCount(int i10) {
        this.likeCount = i10;
    }

    public final void setLiked(boolean z10) {
        this.liked = z10;
    }

    public final void setPostStatisticsSource(@Nullable String str) {
        this.postStatisticsSource = str;
    }

    public final void setRecentComments(@Nullable List<PostCommentModel> list) {
        this.recentComments = list;
    }

    public final void setRecommendId(@Nullable String str) {
        this.recommendId = str;
    }

    public final void setShowAlohaBtn(boolean z10) {
        this.showAlohaBtn = z10;
    }

    public final void setUser(@NotNull User user) {
        s.i(user, "<set-?>");
        this.user = user;
    }

    public final void setVenueId(@Nullable String str) {
        this.venueId = str;
    }

    public final void setVideo(@Nullable VideoModel videoModel) {
        this.video = videoModel;
    }

    public final void share() {
        Integer num = this.feedShareCount;
        this.feedShareCount = Integer.valueOf((num != null ? num.intValue() : 0) + 1);
    }

    @NotNull
    public String toString() {
        User user = this.user;
        String str = this.postId;
        boolean z10 = this.liked;
        int i10 = this.likeCount;
        ImageModel imageModel = this.image;
        List<FeedImageInfoModel> list = this.imageInfoList;
        VideoModel videoModel = this.video;
        long j10 = this.createTimeMillis;
        Double d10 = this.latitude;
        Double d11 = this.longitude;
        String str2 = this.venue;
        Boolean bool = this.venueAbroad;
        String str3 = this.venueId;
        String str4 = this.type;
        String str5 = this.url;
        boolean z11 = this.hasMoreComment;
        List<PostCommentModel> list2 = this.recentComments;
        HashTag hashTag = this.hashtag;
        int i11 = this.commentCount;
        String str6 = this.description;
        String str7 = this.label;
        Integer num = this.exposureCount;
        boolean z12 = this.showAlohaBtn;
        String str8 = this.recommendId;
        CustomTag customTag = this.customTag;
        String str9 = this.reportData;
        String str10 = this.shareContent;
        String str11 = this.shareLink;
        String str12 = this.shareTitle;
        String str13 = this.title;
        String str14 = this.hotTag;
        Integer num2 = this.imageCount;
        Integer num3 = this.tagId;
        Integer num4 = this.feedShareCount;
        String str15 = this.content;
        String str16 = this.buttonText;
        String str17 = this.jumpUrl;
        String str18 = this.flowContent;
        String str19 = this.strategyId;
        boolean z13 = this.privateFeed;
        boolean z14 = this.closeFriendOnly;
        Boolean bool2 = this.boosting;
        PostBoostModel postBoostModel = this.postBoostInfo;
        String str20 = this.postStatisticsSource;
        List<String> list3 = this.showTrackUrlList;
        List<String> list4 = this.clickTrackUrlList;
        String str21 = this.adContextUrl;
        List<ReplaceAtModel> list5 = this.replaceAtList;
        SponsorModel sponsorModel = this.sponsorExtraInfo;
        AdTipModel adTipModel = this.adTip;
        String str22 = this.publishIpCityName;
        List<UserWithPostLimitStatusModel> list6 = this.list;
        String str23 = this.rcmdType;
        PromotionNearByGuideModel promotionNearByGuideModel = this.guide;
        return "FeedModel(user=" + ((Object) user) + ", postId=" + str + ", liked=" + z10 + ", likeCount=" + i10 + ", image=" + ((Object) imageModel) + ", imageInfoList=" + ((Object) list) + ", video=" + ((Object) videoModel) + ", createTimeMillis=" + j10 + ", latitude=" + ((Object) d10) + ", longitude=" + ((Object) d11) + ", venue=" + str2 + ", venueAbroad=" + ((Object) bool) + ", venueId=" + str3 + ", type=" + str4 + ", url=" + str5 + ", hasMoreComment=" + z11 + ", recentComments=" + ((Object) list2) + ", hashtag=" + ((Object) hashTag) + ", commentCount=" + i11 + ", description=" + str6 + ", label=" + str7 + ", exposureCount=" + ((Object) num) + ", showAlohaBtn=" + z12 + ", recommendId=" + str8 + ", customTag=" + ((Object) customTag) + ", reportData=" + str9 + ", shareContent=" + str10 + ", shareLink=" + str11 + ", shareTitle=" + str12 + ", title=" + str13 + ", hotTag=" + str14 + ", imageCount=" + ((Object) num2) + ", tagId=" + ((Object) num3) + ", feedShareCount=" + ((Object) num4) + ", content=" + str15 + ", buttonText=" + str16 + ", jumpUrl=" + str17 + ", flowContent=" + str18 + ", strategyId=" + str19 + ", privateFeed=" + z13 + ", closeFriendOnly=" + z14 + ", boosting=" + ((Object) bool2) + ", postBoostInfo=" + ((Object) postBoostModel) + ", postStatisticsSource=" + str20 + ", showTrackUrlList=" + ((Object) list3) + ", clickTrackUrlList=" + ((Object) list4) + ", adContextUrl=" + str21 + ", replaceAtList=" + ((Object) list5) + ", sponsorExtraInfo=" + ((Object) sponsorModel) + ", adTip=" + ((Object) adTipModel) + ", publishIpCityName=" + str22 + ", list=" + ((Object) list6) + ", rcmdType=" + str23 + ", guide=" + ((Object) promotionNearByGuideModel) + ", postStatisticsCallback=" + this.postStatisticsCallback + ", dynamicTop=" + ((Object) this.dynamicTop) + ", specialExposureSetting=" + ((Object) this.specialExposureSetting) + ", post=" + ((Object) this.post) + ", bottomGuide=" + ((Object) this.bottomGuide) + ")";
    }

    public final int getImageCount() {
        Integer num = this.imageCount;
        return num != null ? num.intValue() : getImageListCount();
    }

    public /* synthetic */ FeedModel(User user, String str, boolean z10, int i10, ImageModel imageModel, List list, VideoModel videoModel, long j10, Double d10, Double d11, String str2, Boolean bool, String str3, String str4, String str5, boolean z11, List list2, HashTag hashTag, int i11, String str6, String str7, Integer num, boolean z12, String str8, CustomTag customTag, String str9, String str10, String str11, String str12, String str13, String str14, Integer num2, Integer num3, Integer num4, String str15, String str16, String str17, String str18, String str19, boolean z13, boolean z14, Boolean bool2, PostBoostModel postBoostModel, String str20, List list3, List list4, String str21, List list5, SponsorModel sponsorModel, AdTipModel adTipModel, String str22, List list6, String str23, PromotionNearByGuideModel promotionNearByGuideModel, String str24, Boolean bool3, Boolean bool4, FeedModel feedModel, BottomGuideModel bottomGuideModel, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(user, str, (i12 & 4) != 0 ? false : z10, i10, imageModel, list, videoModel, (i12 & 128) != 0 ? 0L : j10, d10, d11, str2, bool, str3, str4, str5, (32768 & i12) != 0 ? false : z11, list2, hashTag, (262144 & i12) != 0 ? 0 : i11, str6, str7, num, (i12 & 4194304) != 0 ? false : z12, str8, customTag, str9, (67108864 & i12) != 0 ? "" : str10, (134217728 & i12) != 0 ? null : str11, (268435456 & i12) != 0 ? "" : str12, (i12 & 536870912) != 0 ? null : str13, str14, num2, num3, num4, (i13 & 4) != 0 ? null : str15, (i13 & 8) != 0 ? null : str16, (i13 & 16) != 0 ? null : str17, (i13 & 32) != 0 ? null : str18, str19, (i13 & 128) != 0 ? false : z13, (i13 & 256) != 0 ? false : z14, (i13 & 512) != 0 ? Boolean.FALSE : bool2, (i13 & 1024) != 0 ? null : postBoostModel, (i13 & 2048) != 0 ? null : str20, list3, list4, str21, list5, sponsorModel, adTipModel, str22, (524288 & i13) != 0 ? null : list6, (1048576 & i13) != 0 ? null : str23, (2097152 & i13) != 0 ? null : promotionNearByGuideModel, (i13 & 4194304) != 0 ? null : str24, (8388608 & i13) != 0 ? null : bool3, bool4, feedModel, bottomGuideModel);
    }
}
