package com.cupidapp.live.base.network;

import com.android.internal.logging.nano.MetricsProto;
import org.jetbrains.annotations.Nullable;

/* compiled from: RequestErrorCode.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum RequestErrorCode {
    Ok(200, null),
    NullResult(-1, "数据错误"),
    AuthFail(401, null),
    UserIllegal(MetricsProto.MetricsEvent.ACTION_SHOW_APP_DISAMBIG_APP_FEATURED, null),
    NotFound(404, null),
    ServerError(500, null),
    RequestParamValidationFail(501, null),
    ThresholdHit(503, null),
    UserNotFound(200502, null),
    UsernameUsed(200503, null),
    EmailUsed(200504, null),
    ImageUploadFail(200505, null),
    AudioUploadFail(200506, null),
    EmotionNotFound(200507, null),
    LicenseInvalid(200508, null),
    InvalidPassword(200509, null),
    InvalidEmail(200510, null),
    InvalidPasswordResetCode(200511, null),
    BlockByYourSelf(200513, null),
    BlockByOther(200514, null),
    InboxForFriendsOnly(200515, null),
    InboxExcessive(200763, null),
    MobileNumberRegistered(200516, null),
    InvalidMobileVerifyCode(200517, null),
    MatchNoMoreToday(200518, null),
    MatchNoMoreData(200519, null),
    InvalidMobileNumber(200520, null),
    InvalidSummary(200522, null),
    MatchNope(200523, null),
    InvalidAccessToken(200524, null),
    ConnectRemoteFail(200525, null),
    InvalidDescription(200526, null),
    InvalidComment(200527, null),
    InvalidCode(200528, null),
    GuidDuplicate(200529, null),
    AlreadyConnect(200530, null),
    ErrorMatchRegionTraverseOver(200531, null),
    ErrorServiceUnavailable(200532, null),
    ErrorSnapMessageUnpacked(200533, null),
    VersionTooLow(200539, null),
    ErrorTempInboxSessionExpired(200540, null),
    ErrorNoLocation(200542, null),
    YouBlacklistedTheOtherPerson(200706, null),
    LiveShowIsOver(200604, null),
    CannotWatchThisLiveShow(200627, null),
    MatchUserFrequentlyAlohaPunishment(200700, null),
    ImproperNickName(200610, null),
    NickNameIsTooShort(200713, null),
    NickNameIsTooLong(200714, null),
    ImproperContent(200715, null),
    UserLevelNotMatch(200641, null),
    ClosedAcceptConnection(200642, null),
    MaxConnectionLimit(200643, null),
    ConnectingOnOtherDevice(200645, null),
    ConnectionApplicationOnOtherDevice(200646, null),
    NoCertification(200652, null),
    JumpToNoCloseWeb(MetricsProto.MetricsEvent.USER_DICTIONARY_SETTINGS, null),
    BindMobileFirst(200672, null),
    SuperLikeNoPermission(200762, null),
    InsufficientBalance(200607, null),
    FocusNoRemains(200768, null),
    CloseFriendNoRemains(200769, null),
    PasswordError(200671, null),
    MultiAccountSwitchFail(200771, null),
    ForUserExposureExperience(200793, null),
    MessageSendTimeoutNotCancel(200536, null),
    KickOutLiveRoom(200805, null),
    FeedTopFail(200820, null),
    ClubSendRedPacketInsufficientBalance(2000503, null),
    MakeSureExposure(200832, null),
    CanNotExposure(200833, null),
    QuickGiftSendFail(200834, null);


    @Nullable
    private final String message;
    private final int value;

    RequestErrorCode(int i10, String str) {
        this.value = i10;
        this.message = str;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    public final int getValue() {
        return this.value;
    }
}
