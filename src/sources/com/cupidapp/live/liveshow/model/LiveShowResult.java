package com.cupidapp.live.liveshow.model;

import b2.a;
import com.cupidapp.live.liveshow.constants.FKLiveType;
import com.cupidapp.live.liveshow.view.tag.LiveShowTagListModel;
import com.cupidapp.live.profile.model.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.t;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveShowResult implements Serializable {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @Nullable
    private final List<LiveActivityModel> activities;

    @Nullable
    private final List<BadgeModel> adBadge;

    @Nullable
    private final String adminListWebUrl;

    @Nullable
    private final AnchorGradeInfoModel anchorGradeInfo;

    @Nullable
    private final AnchorInfoBorderModel anchorProfileBorder;
    private final long balance;
    private int barrageCardCount;

    @Nullable
    private final Boolean barrageEnabled;

    @Nullable
    private final String closedAudioLiveShowId;

    @Nullable
    private final FKCriticalHitModel critInfo;

    @Nullable
    private final LiveMenuBtnModel dressUpBtn;

    @Nullable
    private final LiveMenuBtnModel dressUpStoreBtn;
    private boolean fanClubAvailable;

    @Nullable
    private final LiveMenuBtnModel fragmentBtn;

    @Nullable
    private final GiftCollectionModel giftCollect;

    @Nullable
    private final String giftPackageAnimationKey;

    @Nullable
    private final LiveMenuBtnModel giftWall;

    @Nullable
    private final LiveCommentGuideModel guide;

    @Nullable
    private final HeatValuesModel heatValues;

    @Nullable
    private final Boolean hideBlockInvitationsButton;

    @Nullable
    private final LiveMenuBtnModel liveNobility;

    @NotNull
    private LiveShowModel liveShow;

    @Nullable
    private final List<LiveShowTagListModel> liveShowTagList;

    @Nullable
    private final PrayContestModel lotteryBattleInfo;

    @Nullable
    private final PrayContestModel lotteryBattleNormalInfo;

    @Nullable
    private final FKTurnTableModel lotteryBtn;

    @Nullable
    private final LiveMenuBtnModel magicRefine;

    @Nullable
    private final Integer maxHornTextLength;

    @Nullable
    private final Integer maxMessageTextLength;
    private int memberInClubStatus;

    @Nullable
    private final String pkContributionPath;

    @Nullable
    private final LivePkIconModel pkIcon;

    @Nullable
    private LiveShowModel pkLiveShow;

    @Nullable
    private final PopupInfoModel popupInfo;

    @Nullable
    private QuickGiftModel quickGift;

    @Nullable
    private final List<CommentModel> recentComments;

    @Nullable
    private final String redPacketCreateUrl;

    @Nullable
    private final String redPacketHoverText;

    @Nullable
    private final RedEnvelopeModel redPacketInfo;

    @Nullable
    private final Boolean showMultiPlayer;

    @Nullable
    private final SignInInfoModel signInInfo;

    @Nullable
    private final Map<String, List<User>> sofa;

    @Nullable
    private final StarChallengeChestModel starLevelChest;

    @Nullable
    private final LiveStickerViewInfoModel sticker;

    @Nullable
    private final LiveMenuBtnModel stickerEntryInfo;

    @Nullable
    private final LiveMenuBtnModel streamFollowBtn;

    @Nullable
    private final FollowLiveStatusModel streamFollowProcessPie;
    private final int taskCount;

    /* compiled from: FKLiveShowResult.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LiveShowResult a(@NotNull LiveShowModel model) {
            s.i(model, "model");
            return new LiveShowResult(model, null, null, null, 0L, 0, null, null, null, null, null, null, null, null, null, 0, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, -2, 65535, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LiveShowResult(@NotNull LiveShowModel liveShow, @Nullable HeatValuesModel heatValuesModel, @Nullable LiveShowModel liveShowModel, @Nullable LivePkIconModel livePkIconModel, long j10, int i10, @Nullable List<BadgeModel> list, @Nullable List<CommentModel> list2, @Nullable String str, @Nullable PopupInfoModel popupInfoModel, @Nullable String str2, @Nullable Map<String, ? extends List<User>> map, @Nullable String str3, @Nullable AnchorGradeInfoModel anchorGradeInfoModel, @Nullable SignInInfoModel signInInfoModel, int i11, boolean z10, @Nullable FKTurnTableModel fKTurnTableModel, @Nullable FKCriticalHitModel fKCriticalHitModel, @Nullable GiftCollectionModel giftCollectionModel, @Nullable PrayContestModel prayContestModel, @Nullable PrayContestModel prayContestModel2, @Nullable List<LiveActivityModel> list3, @Nullable LiveCommentGuideModel liveCommentGuideModel, @Nullable RedEnvelopeModel redEnvelopeModel, @Nullable String str4, @Nullable String str5, @Nullable LiveMenuBtnModel liveMenuBtnModel, @Nullable String str6, @Nullable StarChallengeChestModel starChallengeChestModel, @Nullable AnchorInfoBorderModel anchorInfoBorderModel, @Nullable List<LiveShowTagListModel> list4, @Nullable LiveMenuBtnModel liveMenuBtnModel2, @Nullable LiveMenuBtnModel liveMenuBtnModel3, @Nullable LiveMenuBtnModel liveMenuBtnModel4, @Nullable LiveMenuBtnModel liveMenuBtnModel5, int i12, @Nullable Integer num, @Nullable Integer num2, @Nullable Boolean bool, @Nullable LiveStickerViewInfoModel liveStickerViewInfoModel, @Nullable LiveMenuBtnModel liveMenuBtnModel6, @Nullable LiveMenuBtnModel liveMenuBtnModel7, @Nullable FollowLiveStatusModel followLiveStatusModel, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable QuickGiftModel quickGiftModel, @Nullable LiveMenuBtnModel liveMenuBtnModel8) {
        s.i(liveShow, "liveShow");
        this.liveShow = liveShow;
        this.heatValues = heatValuesModel;
        this.pkLiveShow = liveShowModel;
        this.pkIcon = livePkIconModel;
        this.balance = j10;
        this.taskCount = i10;
        this.adBadge = list;
        this.recentComments = list2;
        this.giftPackageAnimationKey = str;
        this.popupInfo = popupInfoModel;
        this.closedAudioLiveShowId = str2;
        this.sofa = map;
        this.pkContributionPath = str3;
        this.anchorGradeInfo = anchorGradeInfoModel;
        this.signInInfo = signInInfoModel;
        this.memberInClubStatus = i11;
        this.fanClubAvailable = z10;
        this.lotteryBtn = fKTurnTableModel;
        this.critInfo = fKCriticalHitModel;
        this.giftCollect = giftCollectionModel;
        this.lotteryBattleInfo = prayContestModel;
        this.lotteryBattleNormalInfo = prayContestModel2;
        this.activities = list3;
        this.guide = liveCommentGuideModel;
        this.redPacketInfo = redEnvelopeModel;
        this.redPacketCreateUrl = str4;
        this.redPacketHoverText = str5;
        this.fragmentBtn = liveMenuBtnModel;
        this.adminListWebUrl = str6;
        this.starLevelChest = starChallengeChestModel;
        this.anchorProfileBorder = anchorInfoBorderModel;
        this.liveShowTagList = list4;
        this.dressUpStoreBtn = liveMenuBtnModel2;
        this.dressUpBtn = liveMenuBtnModel3;
        this.liveNobility = liveMenuBtnModel4;
        this.giftWall = liveMenuBtnModel5;
        this.barrageCardCount = i12;
        this.maxMessageTextLength = num;
        this.maxHornTextLength = num2;
        this.barrageEnabled = bool;
        this.sticker = liveStickerViewInfoModel;
        this.stickerEntryInfo = liveMenuBtnModel6;
        this.streamFollowBtn = liveMenuBtnModel7;
        this.streamFollowProcessPie = followLiveStatusModel;
        this.showMultiPlayer = bool2;
        this.hideBlockInvitationsButton = bool3;
        this.quickGift = quickGiftModel;
        this.magicRefine = liveMenuBtnModel8;
    }

    @NotNull
    public final LiveShowModel component1() {
        return this.liveShow;
    }

    @Nullable
    public final PopupInfoModel component10() {
        return this.popupInfo;
    }

    @Nullable
    public final String component11() {
        return this.closedAudioLiveShowId;
    }

    @Nullable
    public final Map<String, List<User>> component12() {
        return this.sofa;
    }

    @Nullable
    public final String component13() {
        return this.pkContributionPath;
    }

    @Nullable
    public final AnchorGradeInfoModel component14() {
        return this.anchorGradeInfo;
    }

    @Nullable
    public final SignInInfoModel component15() {
        return this.signInInfo;
    }

    public final int component16() {
        return this.memberInClubStatus;
    }

    public final boolean component17() {
        return this.fanClubAvailable;
    }

    @Nullable
    public final FKTurnTableModel component18() {
        return this.lotteryBtn;
    }

    @Nullable
    public final FKCriticalHitModel component19() {
        return this.critInfo;
    }

    @Nullable
    public final HeatValuesModel component2() {
        return this.heatValues;
    }

    @Nullable
    public final GiftCollectionModel component20() {
        return this.giftCollect;
    }

    @Nullable
    public final PrayContestModel component21() {
        return this.lotteryBattleInfo;
    }

    @Nullable
    public final PrayContestModel component22() {
        return this.lotteryBattleNormalInfo;
    }

    @Nullable
    public final List<LiveActivityModel> component23() {
        return this.activities;
    }

    @Nullable
    public final LiveCommentGuideModel component24() {
        return this.guide;
    }

    @Nullable
    public final RedEnvelopeModel component25() {
        return this.redPacketInfo;
    }

    @Nullable
    public final String component26() {
        return this.redPacketCreateUrl;
    }

    @Nullable
    public final String component27() {
        return this.redPacketHoverText;
    }

    @Nullable
    public final LiveMenuBtnModel component28() {
        return this.fragmentBtn;
    }

    @Nullable
    public final String component29() {
        return this.adminListWebUrl;
    }

    @Nullable
    public final LiveShowModel component3() {
        return this.pkLiveShow;
    }

    @Nullable
    public final StarChallengeChestModel component30() {
        return this.starLevelChest;
    }

    @Nullable
    public final AnchorInfoBorderModel component31() {
        return this.anchorProfileBorder;
    }

    @Nullable
    public final List<LiveShowTagListModel> component32() {
        return this.liveShowTagList;
    }

    @Nullable
    public final LiveMenuBtnModel component33() {
        return this.dressUpStoreBtn;
    }

    @Nullable
    public final LiveMenuBtnModel component34() {
        return this.dressUpBtn;
    }

    @Nullable
    public final LiveMenuBtnModel component35() {
        return this.liveNobility;
    }

    @Nullable
    public final LiveMenuBtnModel component36() {
        return this.giftWall;
    }

    public final int component37() {
        return this.barrageCardCount;
    }

    @Nullable
    public final Integer component38() {
        return this.maxMessageTextLength;
    }

    @Nullable
    public final Integer component39() {
        return this.maxHornTextLength;
    }

    @Nullable
    public final LivePkIconModel component4() {
        return this.pkIcon;
    }

    @Nullable
    public final Boolean component40() {
        return this.barrageEnabled;
    }

    @Nullable
    public final LiveStickerViewInfoModel component41() {
        return this.sticker;
    }

    @Nullable
    public final LiveMenuBtnModel component42() {
        return this.stickerEntryInfo;
    }

    @Nullable
    public final LiveMenuBtnModel component43() {
        return this.streamFollowBtn;
    }

    @Nullable
    public final FollowLiveStatusModel component44() {
        return this.streamFollowProcessPie;
    }

    @Nullable
    public final Boolean component45() {
        return this.showMultiPlayer;
    }

    @Nullable
    public final Boolean component46() {
        return this.hideBlockInvitationsButton;
    }

    @Nullable
    public final QuickGiftModel component47() {
        return this.quickGift;
    }

    @Nullable
    public final LiveMenuBtnModel component48() {
        return this.magicRefine;
    }

    public final long component5() {
        return this.balance;
    }

    public final int component6() {
        return this.taskCount;
    }

    @Nullable
    public final List<BadgeModel> component7() {
        return this.adBadge;
    }

    @Nullable
    public final List<CommentModel> component8() {
        return this.recentComments;
    }

    @Nullable
    public final String component9() {
        return this.giftPackageAnimationKey;
    }

    @NotNull
    public final LiveShowResult copy(@NotNull LiveShowModel liveShow, @Nullable HeatValuesModel heatValuesModel, @Nullable LiveShowModel liveShowModel, @Nullable LivePkIconModel livePkIconModel, long j10, int i10, @Nullable List<BadgeModel> list, @Nullable List<CommentModel> list2, @Nullable String str, @Nullable PopupInfoModel popupInfoModel, @Nullable String str2, @Nullable Map<String, ? extends List<User>> map, @Nullable String str3, @Nullable AnchorGradeInfoModel anchorGradeInfoModel, @Nullable SignInInfoModel signInInfoModel, int i11, boolean z10, @Nullable FKTurnTableModel fKTurnTableModel, @Nullable FKCriticalHitModel fKCriticalHitModel, @Nullable GiftCollectionModel giftCollectionModel, @Nullable PrayContestModel prayContestModel, @Nullable PrayContestModel prayContestModel2, @Nullable List<LiveActivityModel> list3, @Nullable LiveCommentGuideModel liveCommentGuideModel, @Nullable RedEnvelopeModel redEnvelopeModel, @Nullable String str4, @Nullable String str5, @Nullable LiveMenuBtnModel liveMenuBtnModel, @Nullable String str6, @Nullable StarChallengeChestModel starChallengeChestModel, @Nullable AnchorInfoBorderModel anchorInfoBorderModel, @Nullable List<LiveShowTagListModel> list4, @Nullable LiveMenuBtnModel liveMenuBtnModel2, @Nullable LiveMenuBtnModel liveMenuBtnModel3, @Nullable LiveMenuBtnModel liveMenuBtnModel4, @Nullable LiveMenuBtnModel liveMenuBtnModel5, int i12, @Nullable Integer num, @Nullable Integer num2, @Nullable Boolean bool, @Nullable LiveStickerViewInfoModel liveStickerViewInfoModel, @Nullable LiveMenuBtnModel liveMenuBtnModel6, @Nullable LiveMenuBtnModel liveMenuBtnModel7, @Nullable FollowLiveStatusModel followLiveStatusModel, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable QuickGiftModel quickGiftModel, @Nullable LiveMenuBtnModel liveMenuBtnModel8) {
        s.i(liveShow, "liveShow");
        return new LiveShowResult(liveShow, heatValuesModel, liveShowModel, livePkIconModel, j10, i10, list, list2, str, popupInfoModel, str2, map, str3, anchorGradeInfoModel, signInInfoModel, i11, z10, fKTurnTableModel, fKCriticalHitModel, giftCollectionModel, prayContestModel, prayContestModel2, list3, liveCommentGuideModel, redEnvelopeModel, str4, str5, liveMenuBtnModel, str6, starChallengeChestModel, anchorInfoBorderModel, list4, liveMenuBtnModel2, liveMenuBtnModel3, liveMenuBtnModel4, liveMenuBtnModel5, i12, num, num2, bool, liveStickerViewInfoModel, liveMenuBtnModel6, liveMenuBtnModel7, followLiveStatusModel, bool2, bool3, quickGiftModel, liveMenuBtnModel8);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveShowResult)) {
            return false;
        }
        LiveShowResult liveShowResult = (LiveShowResult) obj;
        return s.d(this.liveShow, liveShowResult.liveShow) && s.d(this.heatValues, liveShowResult.heatValues) && s.d(this.pkLiveShow, liveShowResult.pkLiveShow) && s.d(this.pkIcon, liveShowResult.pkIcon) && this.balance == liveShowResult.balance && this.taskCount == liveShowResult.taskCount && s.d(this.adBadge, liveShowResult.adBadge) && s.d(this.recentComments, liveShowResult.recentComments) && s.d(this.giftPackageAnimationKey, liveShowResult.giftPackageAnimationKey) && s.d(this.popupInfo, liveShowResult.popupInfo) && s.d(this.closedAudioLiveShowId, liveShowResult.closedAudioLiveShowId) && s.d(this.sofa, liveShowResult.sofa) && s.d(this.pkContributionPath, liveShowResult.pkContributionPath) && s.d(this.anchorGradeInfo, liveShowResult.anchorGradeInfo) && s.d(this.signInInfo, liveShowResult.signInInfo) && this.memberInClubStatus == liveShowResult.memberInClubStatus && this.fanClubAvailable == liveShowResult.fanClubAvailable && s.d(this.lotteryBtn, liveShowResult.lotteryBtn) && s.d(this.critInfo, liveShowResult.critInfo) && s.d(this.giftCollect, liveShowResult.giftCollect) && s.d(this.lotteryBattleInfo, liveShowResult.lotteryBattleInfo) && s.d(this.lotteryBattleNormalInfo, liveShowResult.lotteryBattleNormalInfo) && s.d(this.activities, liveShowResult.activities) && s.d(this.guide, liveShowResult.guide) && s.d(this.redPacketInfo, liveShowResult.redPacketInfo) && s.d(this.redPacketCreateUrl, liveShowResult.redPacketCreateUrl) && s.d(this.redPacketHoverText, liveShowResult.redPacketHoverText) && s.d(this.fragmentBtn, liveShowResult.fragmentBtn) && s.d(this.adminListWebUrl, liveShowResult.adminListWebUrl) && s.d(this.starLevelChest, liveShowResult.starLevelChest) && s.d(this.anchorProfileBorder, liveShowResult.anchorProfileBorder) && s.d(this.liveShowTagList, liveShowResult.liveShowTagList) && s.d(this.dressUpStoreBtn, liveShowResult.dressUpStoreBtn) && s.d(this.dressUpBtn, liveShowResult.dressUpBtn) && s.d(this.liveNobility, liveShowResult.liveNobility) && s.d(this.giftWall, liveShowResult.giftWall) && this.barrageCardCount == liveShowResult.barrageCardCount && s.d(this.maxMessageTextLength, liveShowResult.maxMessageTextLength) && s.d(this.maxHornTextLength, liveShowResult.maxHornTextLength) && s.d(this.barrageEnabled, liveShowResult.barrageEnabled) && s.d(this.sticker, liveShowResult.sticker) && s.d(this.stickerEntryInfo, liveShowResult.stickerEntryInfo) && s.d(this.streamFollowBtn, liveShowResult.streamFollowBtn) && s.d(this.streamFollowProcessPie, liveShowResult.streamFollowProcessPie) && s.d(this.showMultiPlayer, liveShowResult.showMultiPlayer) && s.d(this.hideBlockInvitationsButton, liveShowResult.hideBlockInvitationsButton) && s.d(this.quickGift, liveShowResult.quickGift) && s.d(this.magicRefine, liveShowResult.magicRefine);
    }

    @Nullable
    public final List<LiveActivityModel> getActivities() {
        return this.activities;
    }

    @Nullable
    public final List<BadgeModel> getAdBadge() {
        return this.adBadge;
    }

    @Nullable
    public final String getAdminListWebUrl() {
        return this.adminListWebUrl;
    }

    @Nullable
    public final AnchorGradeInfoModel getAnchorGradeInfo() {
        return this.anchorGradeInfo;
    }

    @Nullable
    public final AnchorInfoBorderModel getAnchorProfileBorder() {
        return this.anchorProfileBorder;
    }

    public final long getBalance() {
        return this.balance;
    }

    public final int getBarrageCardCount() {
        return this.barrageCardCount;
    }

    @Nullable
    public final Boolean getBarrageEnabled() {
        return this.barrageEnabled;
    }

    @Nullable
    public final String getClosedAudioLiveShowId() {
        return this.closedAudioLiveShowId;
    }

    @Nullable
    public final FKCriticalHitModel getCritInfo() {
        return this.critInfo;
    }

    @NotNull
    public final List<String> getCurrentAllStreamIdList() {
        String streamId;
        List<String> o10 = kotlin.collections.s.o(this.liveShow.getStreamId());
        LiveShowModel liveShowModel = this.pkLiveShow;
        if (liveShowModel != null && (streamId = liveShowModel.getStreamId()) != null) {
            if (streamId.length() > 0) {
                o10.add(streamId);
            }
        }
        List<LiveShowModel> connectLive = this.liveShow.getConnectLive();
        if (connectLive != null) {
            for (LiveShowModel liveShowModel2 : connectLive) {
                if (liveShowModel2.getStreamId().length() > 0) {
                    o10.add(liveShowModel2.getStreamId());
                }
            }
        }
        MultiPkInfoModel multiPkInfo = this.liveShow.getMultiPkInfo();
        if (multiPkInfo != null) {
            if (multiPkInfo.getMixStreamId().length() > 0) {
                o10.add(multiPkInfo.getMixStreamId());
            }
            List<MultiPkAnchorInfoModel> anchors = multiPkInfo.getAnchors();
            ArrayList arrayList = new ArrayList(t.t(anchors, 10));
            Iterator<MultiPkAnchorInfoModel> iterator2 = anchors.iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(iterator2.next().getStreamId());
            }
            o10.addAll(arrayList);
        }
        return o10;
    }

    @Nullable
    public final LiveMenuBtnModel getDressUpBtn() {
        return this.dressUpBtn;
    }

    @Nullable
    public final LiveMenuBtnModel getDressUpStoreBtn() {
        return this.dressUpStoreBtn;
    }

    public final boolean getFanClubAvailable() {
        return this.fanClubAvailable;
    }

    @Nullable
    public final LiveMenuBtnModel getFragmentBtn() {
        return this.fragmentBtn;
    }

    @Nullable
    public final GiftCollectionModel getGiftCollect() {
        return this.giftCollect;
    }

    @Nullable
    public final String getGiftPackageAnimationKey() {
        return this.giftPackageAnimationKey;
    }

    @Nullable
    public final LiveMenuBtnModel getGiftWall() {
        return this.giftWall;
    }

    @Nullable
    public final LiveCommentGuideModel getGuide() {
        return this.guide;
    }

    @Nullable
    public final HeatValuesModel getHeatValues() {
        return this.heatValues;
    }

    @Nullable
    public final Boolean getHideBlockInvitationsButton() {
        return this.hideBlockInvitationsButton;
    }

    @Nullable
    public final LiveMenuBtnModel getLiveNobility() {
        return this.liveNobility;
    }

    @NotNull
    public final LiveShowModel getLiveShow() {
        return this.liveShow;
    }

    @Nullable
    public final List<LiveShowTagListModel> getLiveShowTagList() {
        return this.liveShowTagList;
    }

    @NotNull
    public final FKLiveType getLiveType() {
        return hasPkLive() ? FKLiveType.PK : hasMultiPk() ? FKLiveType.MULTI_PK : this.liveShow.hasConnectLive() ? FKLiveType.CHAT : FKLiveType.COMMON;
    }

    @Nullable
    public final PrayContestModel getLotteryBattleInfo() {
        return this.lotteryBattleInfo;
    }

    @Nullable
    public final PrayContestModel getLotteryBattleNormalInfo() {
        return this.lotteryBattleNormalInfo;
    }

    @Nullable
    public final FKTurnTableModel getLotteryBtn() {
        return this.lotteryBtn;
    }

    @Nullable
    public final LiveMenuBtnModel getMagicRefine() {
        return this.magicRefine;
    }

    @Nullable
    public final Integer getMaxHornTextLength() {
        return this.maxHornTextLength;
    }

    @Nullable
    public final Integer getMaxMessageTextLength() {
        return this.maxMessageTextLength;
    }

    public final int getMemberInClubStatus() {
        return this.memberInClubStatus;
    }

    @Nullable
    public final String getPkContributionPath() {
        return this.pkContributionPath;
    }

    @Nullable
    public final LivePkIconModel getPkIcon() {
        return this.pkIcon;
    }

    @Nullable
    public final LiveShowModel getPkLiveShow() {
        return this.pkLiveShow;
    }

    @Nullable
    public final PopupInfoModel getPopupInfo() {
        return this.popupInfo;
    }

    @Nullable
    public final QuickGiftModel getQuickGift() {
        return this.quickGift;
    }

    @Nullable
    public final List<CommentModel> getRecentComments() {
        return this.recentComments;
    }

    @Nullable
    public final String getRedPacketCreateUrl() {
        return this.redPacketCreateUrl;
    }

    @Nullable
    public final String getRedPacketHoverText() {
        return this.redPacketHoverText;
    }

    @Nullable
    public final RedEnvelopeModel getRedPacketInfo() {
        return this.redPacketInfo;
    }

    @Nullable
    public final Boolean getShowMultiPlayer() {
        return this.showMultiPlayer;
    }

    @Nullable
    public final SignInInfoModel getSignInInfo() {
        return this.signInInfo;
    }

    @Nullable
    public final Map<String, List<User>> getSofa() {
        return this.sofa;
    }

    @Nullable
    public final StarChallengeChestModel getStarLevelChest() {
        return this.starLevelChest;
    }

    @Nullable
    public final LiveStickerViewInfoModel getSticker() {
        return this.sticker;
    }

    @Nullable
    public final LiveMenuBtnModel getStickerEntryInfo() {
        return this.stickerEntryInfo;
    }

    @Nullable
    public final LiveMenuBtnModel getStreamFollowBtn() {
        return this.streamFollowBtn;
    }

    @Nullable
    public final FollowLiveStatusModel getStreamFollowProcessPie() {
        return this.streamFollowProcessPie;
    }

    public final int getTaskCount() {
        return this.taskCount;
    }

    public final boolean hasMultiPk() {
        String mixStreamId = this.liveShow.getMixStreamId();
        return !(mixStreamId == null || mixStreamId.length() == 0);
    }

    public final boolean hasPkLive() {
        return this.pkLiveShow != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.liveShow.hashCode() * 31;
        HeatValuesModel heatValuesModel = this.heatValues;
        int hashCode2 = (hashCode + (heatValuesModel == null ? 0 : heatValuesModel.hashCode())) * 31;
        LiveShowModel liveShowModel = this.pkLiveShow;
        int hashCode3 = (hashCode2 + (liveShowModel == null ? 0 : liveShowModel.hashCode())) * 31;
        LivePkIconModel livePkIconModel = this.pkIcon;
        int hashCode4 = (((((hashCode3 + (livePkIconModel == null ? 0 : livePkIconModel.hashCode())) * 31) + a.a(this.balance)) * 31) + this.taskCount) * 31;
        List<BadgeModel> list = this.adBadge;
        int hashCode5 = (hashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        List<CommentModel> list2 = this.recentComments;
        int hashCode6 = (hashCode5 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str = this.giftPackageAnimationKey;
        int hashCode7 = (hashCode6 + (str == null ? 0 : str.hashCode())) * 31;
        PopupInfoModel popupInfoModel = this.popupInfo;
        int hashCode8 = (hashCode7 + (popupInfoModel == null ? 0 : popupInfoModel.hashCode())) * 31;
        String str2 = this.closedAudioLiveShowId;
        int hashCode9 = (hashCode8 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Map<String, List<User>> map = this.sofa;
        int hashCode10 = (hashCode9 + (map == null ? 0 : map.hashCode())) * 31;
        String str3 = this.pkContributionPath;
        int hashCode11 = (hashCode10 + (str3 == null ? 0 : str3.hashCode())) * 31;
        AnchorGradeInfoModel anchorGradeInfoModel = this.anchorGradeInfo;
        int hashCode12 = (hashCode11 + (anchorGradeInfoModel == null ? 0 : anchorGradeInfoModel.hashCode())) * 31;
        SignInInfoModel signInInfoModel = this.signInInfo;
        int hashCode13 = (((hashCode12 + (signInInfoModel == null ? 0 : signInInfoModel.hashCode())) * 31) + this.memberInClubStatus) * 31;
        boolean z10 = this.fanClubAvailable;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode13 + i10) * 31;
        FKTurnTableModel fKTurnTableModel = this.lotteryBtn;
        int hashCode14 = (i11 + (fKTurnTableModel == null ? 0 : fKTurnTableModel.hashCode())) * 31;
        FKCriticalHitModel fKCriticalHitModel = this.critInfo;
        int hashCode15 = (hashCode14 + (fKCriticalHitModel == null ? 0 : fKCriticalHitModel.hashCode())) * 31;
        GiftCollectionModel giftCollectionModel = this.giftCollect;
        int hashCode16 = (hashCode15 + (giftCollectionModel == null ? 0 : giftCollectionModel.hashCode())) * 31;
        PrayContestModel prayContestModel = this.lotteryBattleInfo;
        int hashCode17 = (hashCode16 + (prayContestModel == null ? 0 : prayContestModel.hashCode())) * 31;
        PrayContestModel prayContestModel2 = this.lotteryBattleNormalInfo;
        int hashCode18 = (hashCode17 + (prayContestModel2 == null ? 0 : prayContestModel2.hashCode())) * 31;
        List<LiveActivityModel> list3 = this.activities;
        int hashCode19 = (hashCode18 + (list3 == null ? 0 : list3.hashCode())) * 31;
        LiveCommentGuideModel liveCommentGuideModel = this.guide;
        int hashCode20 = (hashCode19 + (liveCommentGuideModel == null ? 0 : liveCommentGuideModel.hashCode())) * 31;
        RedEnvelopeModel redEnvelopeModel = this.redPacketInfo;
        int hashCode21 = (hashCode20 + (redEnvelopeModel == null ? 0 : redEnvelopeModel.hashCode())) * 31;
        String str4 = this.redPacketCreateUrl;
        int hashCode22 = (hashCode21 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.redPacketHoverText;
        int hashCode23 = (hashCode22 + (str5 == null ? 0 : str5.hashCode())) * 31;
        LiveMenuBtnModel liveMenuBtnModel = this.fragmentBtn;
        int hashCode24 = (hashCode23 + (liveMenuBtnModel == null ? 0 : liveMenuBtnModel.hashCode())) * 31;
        String str6 = this.adminListWebUrl;
        int hashCode25 = (hashCode24 + (str6 == null ? 0 : str6.hashCode())) * 31;
        StarChallengeChestModel starChallengeChestModel = this.starLevelChest;
        int hashCode26 = (hashCode25 + (starChallengeChestModel == null ? 0 : starChallengeChestModel.hashCode())) * 31;
        AnchorInfoBorderModel anchorInfoBorderModel = this.anchorProfileBorder;
        int hashCode27 = (hashCode26 + (anchorInfoBorderModel == null ? 0 : anchorInfoBorderModel.hashCode())) * 31;
        List<LiveShowTagListModel> list4 = this.liveShowTagList;
        int hashCode28 = (hashCode27 + (list4 == null ? 0 : list4.hashCode())) * 31;
        LiveMenuBtnModel liveMenuBtnModel2 = this.dressUpStoreBtn;
        int hashCode29 = (hashCode28 + (liveMenuBtnModel2 == null ? 0 : liveMenuBtnModel2.hashCode())) * 31;
        LiveMenuBtnModel liveMenuBtnModel3 = this.dressUpBtn;
        int hashCode30 = (hashCode29 + (liveMenuBtnModel3 == null ? 0 : liveMenuBtnModel3.hashCode())) * 31;
        LiveMenuBtnModel liveMenuBtnModel4 = this.liveNobility;
        int hashCode31 = (hashCode30 + (liveMenuBtnModel4 == null ? 0 : liveMenuBtnModel4.hashCode())) * 31;
        LiveMenuBtnModel liveMenuBtnModel5 = this.giftWall;
        int hashCode32 = (((hashCode31 + (liveMenuBtnModel5 == null ? 0 : liveMenuBtnModel5.hashCode())) * 31) + this.barrageCardCount) * 31;
        Integer num = this.maxMessageTextLength;
        int hashCode33 = (hashCode32 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.maxHornTextLength;
        int hashCode34 = (hashCode33 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.barrageEnabled;
        int hashCode35 = (hashCode34 + (bool == null ? 0 : bool.hashCode())) * 31;
        LiveStickerViewInfoModel liveStickerViewInfoModel = this.sticker;
        int hashCode36 = (hashCode35 + (liveStickerViewInfoModel == null ? 0 : liveStickerViewInfoModel.hashCode())) * 31;
        LiveMenuBtnModel liveMenuBtnModel6 = this.stickerEntryInfo;
        int hashCode37 = (hashCode36 + (liveMenuBtnModel6 == null ? 0 : liveMenuBtnModel6.hashCode())) * 31;
        LiveMenuBtnModel liveMenuBtnModel7 = this.streamFollowBtn;
        int hashCode38 = (hashCode37 + (liveMenuBtnModel7 == null ? 0 : liveMenuBtnModel7.hashCode())) * 31;
        FollowLiveStatusModel followLiveStatusModel = this.streamFollowProcessPie;
        int hashCode39 = (hashCode38 + (followLiveStatusModel == null ? 0 : followLiveStatusModel.hashCode())) * 31;
        Boolean bool2 = this.showMultiPlayer;
        int hashCode40 = (hashCode39 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.hideBlockInvitationsButton;
        int hashCode41 = (hashCode40 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        QuickGiftModel quickGiftModel = this.quickGift;
        int hashCode42 = (hashCode41 + (quickGiftModel == null ? 0 : quickGiftModel.hashCode())) * 31;
        LiveMenuBtnModel liveMenuBtnModel8 = this.magicRefine;
        return hashCode42 + (liveMenuBtnModel8 != null ? liveMenuBtnModel8.hashCode() : 0);
    }

    public final void setBarrageCardCount(int i10) {
        this.barrageCardCount = i10;
    }

    public final void setFanClubAvailable(boolean z10) {
        this.fanClubAvailable = z10;
    }

    public final void setLiveShow(@NotNull LiveShowModel liveShowModel) {
        s.i(liveShowModel, "<set-?>");
        this.liveShow = liveShowModel;
    }

    public final void setMemberInClubStatus(int i10) {
        this.memberInClubStatus = i10;
    }

    public final void setPkLiveShow(@Nullable LiveShowModel liveShowModel) {
        this.pkLiveShow = liveShowModel;
    }

    public final void setQuickGift(@Nullable QuickGiftModel quickGiftModel) {
        this.quickGift = quickGiftModel;
    }

    @NotNull
    public String toString() {
        LiveShowModel liveShowModel = this.liveShow;
        HeatValuesModel heatValuesModel = this.heatValues;
        LiveShowModel liveShowModel2 = this.pkLiveShow;
        LivePkIconModel livePkIconModel = this.pkIcon;
        long j10 = this.balance;
        int i10 = this.taskCount;
        List<BadgeModel> list = this.adBadge;
        List<CommentModel> list2 = this.recentComments;
        String str = this.giftPackageAnimationKey;
        PopupInfoModel popupInfoModel = this.popupInfo;
        String str2 = this.closedAudioLiveShowId;
        Map<String, List<User>> map = this.sofa;
        String str3 = this.pkContributionPath;
        AnchorGradeInfoModel anchorGradeInfoModel = this.anchorGradeInfo;
        SignInInfoModel signInInfoModel = this.signInInfo;
        int i11 = this.memberInClubStatus;
        boolean z10 = this.fanClubAvailable;
        FKTurnTableModel fKTurnTableModel = this.lotteryBtn;
        FKCriticalHitModel fKCriticalHitModel = this.critInfo;
        GiftCollectionModel giftCollectionModel = this.giftCollect;
        PrayContestModel prayContestModel = this.lotteryBattleInfo;
        PrayContestModel prayContestModel2 = this.lotteryBattleNormalInfo;
        List<LiveActivityModel> list3 = this.activities;
        LiveCommentGuideModel liveCommentGuideModel = this.guide;
        RedEnvelopeModel redEnvelopeModel = this.redPacketInfo;
        String str4 = this.redPacketCreateUrl;
        String str5 = this.redPacketHoverText;
        LiveMenuBtnModel liveMenuBtnModel = this.fragmentBtn;
        String str6 = this.adminListWebUrl;
        StarChallengeChestModel starChallengeChestModel = this.starLevelChest;
        AnchorInfoBorderModel anchorInfoBorderModel = this.anchorProfileBorder;
        List<LiveShowTagListModel> list4 = this.liveShowTagList;
        LiveMenuBtnModel liveMenuBtnModel2 = this.dressUpStoreBtn;
        LiveMenuBtnModel liveMenuBtnModel3 = this.dressUpBtn;
        LiveMenuBtnModel liveMenuBtnModel4 = this.liveNobility;
        LiveMenuBtnModel liveMenuBtnModel5 = this.giftWall;
        return "LiveShowResult(liveShow=" + ((Object) liveShowModel) + ", heatValues=" + ((Object) heatValuesModel) + ", pkLiveShow=" + ((Object) liveShowModel2) + ", pkIcon=" + ((Object) livePkIconModel) + ", balance=" + j10 + ", taskCount=" + i10 + ", adBadge=" + ((Object) list) + ", recentComments=" + ((Object) list2) + ", giftPackageAnimationKey=" + str + ", popupInfo=" + ((Object) popupInfoModel) + ", closedAudioLiveShowId=" + str2 + ", sofa=" + ((Object) map) + ", pkContributionPath=" + str3 + ", anchorGradeInfo=" + ((Object) anchorGradeInfoModel) + ", signInInfo=" + ((Object) signInInfoModel) + ", memberInClubStatus=" + i11 + ", fanClubAvailable=" + z10 + ", lotteryBtn=" + ((Object) fKTurnTableModel) + ", critInfo=" + ((Object) fKCriticalHitModel) + ", giftCollect=" + ((Object) giftCollectionModel) + ", lotteryBattleInfo=" + ((Object) prayContestModel) + ", lotteryBattleNormalInfo=" + ((Object) prayContestModel2) + ", activities=" + ((Object) list3) + ", guide=" + ((Object) liveCommentGuideModel) + ", redPacketInfo=" + ((Object) redEnvelopeModel) + ", redPacketCreateUrl=" + str4 + ", redPacketHoverText=" + str5 + ", fragmentBtn=" + ((Object) liveMenuBtnModel) + ", adminListWebUrl=" + str6 + ", starLevelChest=" + ((Object) starChallengeChestModel) + ", anchorProfileBorder=" + ((Object) anchorInfoBorderModel) + ", liveShowTagList=" + ((Object) list4) + ", dressUpStoreBtn=" + ((Object) liveMenuBtnModel2) + ", dressUpBtn=" + ((Object) liveMenuBtnModel3) + ", liveNobility=" + ((Object) liveMenuBtnModel4) + ", giftWall=" + ((Object) liveMenuBtnModel5) + ", barrageCardCount=" + this.barrageCardCount + ", maxMessageTextLength=" + ((Object) this.maxMessageTextLength) + ", maxHornTextLength=" + ((Object) this.maxHornTextLength) + ", barrageEnabled=" + ((Object) this.barrageEnabled) + ", sticker=" + ((Object) this.sticker) + ", stickerEntryInfo=" + ((Object) this.stickerEntryInfo) + ", streamFollowBtn=" + ((Object) this.streamFollowBtn) + ", streamFollowProcessPie=" + ((Object) this.streamFollowProcessPie) + ", showMultiPlayer=" + ((Object) this.showMultiPlayer) + ", hideBlockInvitationsButton=" + ((Object) this.hideBlockInvitationsButton) + ", quickGift=" + ((Object) this.quickGift) + ", magicRefine=" + ((Object) this.magicRefine) + ")";
    }

    public /* synthetic */ LiveShowResult(LiveShowModel liveShowModel, HeatValuesModel heatValuesModel, LiveShowModel liveShowModel2, LivePkIconModel livePkIconModel, long j10, int i10, List list, List list2, String str, PopupInfoModel popupInfoModel, String str2, Map map, String str3, AnchorGradeInfoModel anchorGradeInfoModel, SignInInfoModel signInInfoModel, int i11, boolean z10, FKTurnTableModel fKTurnTableModel, FKCriticalHitModel fKCriticalHitModel, GiftCollectionModel giftCollectionModel, PrayContestModel prayContestModel, PrayContestModel prayContestModel2, List list3, LiveCommentGuideModel liveCommentGuideModel, RedEnvelopeModel redEnvelopeModel, String str4, String str5, LiveMenuBtnModel liveMenuBtnModel, String str6, StarChallengeChestModel starChallengeChestModel, AnchorInfoBorderModel anchorInfoBorderModel, List list4, LiveMenuBtnModel liveMenuBtnModel2, LiveMenuBtnModel liveMenuBtnModel3, LiveMenuBtnModel liveMenuBtnModel4, LiveMenuBtnModel liveMenuBtnModel5, int i12, Integer num, Integer num2, Boolean bool, LiveStickerViewInfoModel liveStickerViewInfoModel, LiveMenuBtnModel liveMenuBtnModel6, LiveMenuBtnModel liveMenuBtnModel7, FollowLiveStatusModel followLiveStatusModel, Boolean bool2, Boolean bool3, QuickGiftModel quickGiftModel, LiveMenuBtnModel liveMenuBtnModel8, int i13, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this(liveShowModel, (i13 & 2) != 0 ? null : heatValuesModel, (i13 & 4) != 0 ? null : liveShowModel2, (i13 & 8) != 0 ? null : livePkIconModel, (i13 & 16) != 0 ? 0L : j10, (i13 & 32) != 0 ? 0 : i10, (i13 & 64) != 0 ? null : list, (i13 & 128) != 0 ? null : list2, (i13 & 256) != 0 ? null : str, (i13 & 512) != 0 ? null : popupInfoModel, (i13 & 1024) != 0 ? null : str2, (i13 & 2048) != 0 ? null : map, (i13 & 4096) != 0 ? null : str3, (i13 & 8192) != 0 ? null : anchorGradeInfoModel, (i13 & 16384) != 0 ? null : signInInfoModel, (i13 & 32768) != 0 ? 0 : i11, (i13 & 65536) != 0 ? false : z10, (i13 & 131072) != 0 ? null : fKTurnTableModel, (i13 & 262144) != 0 ? null : fKCriticalHitModel, (i13 & 524288) != 0 ? null : giftCollectionModel, (i13 & 1048576) != 0 ? null : prayContestModel, (i13 & 2097152) != 0 ? null : prayContestModel2, (i13 & 4194304) != 0 ? null : list3, (i13 & 8388608) != 0 ? null : liveCommentGuideModel, (i13 & 16777216) != 0 ? null : redEnvelopeModel, (i13 & 33554432) != 0 ? null : str4, (i13 & 67108864) != 0 ? null : str5, (i13 & 134217728) != 0 ? null : liveMenuBtnModel, (i13 & 268435456) != 0 ? null : str6, (i13 & 536870912) != 0 ? null : starChallengeChestModel, (i13 & 1073741824) != 0 ? null : anchorInfoBorderModel, (i13 & Integer.MIN_VALUE) != 0 ? null : list4, (i14 & 1) != 0 ? null : liveMenuBtnModel2, (i14 & 2) != 0 ? null : liveMenuBtnModel3, (i14 & 4) != 0 ? null : liveMenuBtnModel4, (i14 & 8) != 0 ? null : liveMenuBtnModel5, (i14 & 16) != 0 ? 0 : i12, (i14 & 32) != 0 ? null : num, (i14 & 64) != 0 ? null : num2, (i14 & 128) != 0 ? Boolean.TRUE : bool, (i14 & 256) != 0 ? null : liveStickerViewInfoModel, (i14 & 512) != 0 ? null : liveMenuBtnModel6, (i14 & 1024) != 0 ? null : liveMenuBtnModel7, (i14 & 2048) != 0 ? null : followLiveStatusModel, (i14 & 4096) != 0 ? null : bool2, (i14 & 8192) != 0 ? null : bool3, (i14 & 16384) != 0 ? null : quickGiftModel, (i14 & 32768) != 0 ? null : liveMenuBtnModel8);
    }
}
