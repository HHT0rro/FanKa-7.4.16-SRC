package com.cupidapp.live.base.network.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: ProfileResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum ViewProfilePrefer {
    ChatToProfile("chatToProfile"),
    ChatStatusToProfile("chatStatusToProfile"),
    URLSchemeToProfile("URLSchemeToProfile"),
    FeedToProfile("feedToProfile"),
    FeedDetailToProfile("feedDetailToProfile"),
    FeedDetailCommentToProfile("feedDetailCommentToProfile"),
    FeedCommentToProfile("feedCommentToProfile"),
    FeedLikeToProfile("feedLikeToProfile"),
    AlohaToProfile("alohaToProfile"),
    NotifyLikeToProfile("notifyLikeToProfile"),
    NotifyMentionToProfile("notifyMentionToProfile"),
    NotifyPostLikeToProfile("notifyPostLikeToProfile"),
    SearchToProfile("searchToProfile"),
    BlackListToProfile("blackListToProfile"),
    FollowerToProfile("followerToProfile"),
    FollowingUserToProfile("followingUserToProfile"),
    NearbyToProfile("NearbyToProfile"),
    LiveShowMiniProfileToProfile("liveShowMiniProfileToProfile"),
    SettingToProfile("settingToProfile"),
    VisitorToProfile("visitorToProfile"),
    MatchPushToProfile("matchPushToProfile"),
    MatchUserListToProfile("matchUserListToProfile"),
    NearByMapToProfile("nearbyMapToProfile"),
    FootmarkToProfile("footmarkToProfile"),
    FocusToProfile("focusToProfile"),
    MaskMatch("maskMatch"),
    MaskAudioRoom("maskAudioRoom"),
    PostLimitToProfile("postLimitDetailToProfile"),
    postLimitViewerListToProfile("postLimitViewerListToProfile"),
    ReceivedFriendPraise("receivedFriendPraise"),
    SendFriendPraise("sendFriendPraise"),
    FriendPraiseDetail("friendPraiseDetail"),
    SpecialExposureToProfile("specialExposureToProfile"),
    AiGraph("aiGraph"),
    VoiceRoom("voiceRoom");


    @NotNull
    private final String value;

    ViewProfilePrefer(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
