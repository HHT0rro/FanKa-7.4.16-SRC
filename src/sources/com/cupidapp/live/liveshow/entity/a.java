package com.cupidapp.live.liveshow.entity;

import com.cupidapp.live.base.grpc.AnchorInfoBorderConnectorMessage;
import com.cupidapp.live.base.grpc.CommentConnectorMessage;
import com.cupidapp.live.base.grpc.ConnectorMessageEvent;
import com.cupidapp.live.base.grpc.FullLiveVisibleGiftConnectorMessage;
import com.cupidapp.live.base.grpc.GiftConnectorMessage;
import com.cupidapp.live.base.grpc.KickOutLiveRoomMessageModel;
import com.cupidapp.live.base.grpc.LiveAnchorLvlExpChangeConnectorMessage;
import com.cupidapp.live.base.grpc.LiveAnchorLvlUpgradeAnimationConnectorMessage;
import com.cupidapp.live.base.grpc.LiveAnchorPrivilegeEndUseConnectorMessage;
import com.cupidapp.live.base.grpc.LiveAnchorPrivilegeHintConnectorMessage;
import com.cupidapp.live.base.grpc.LiveAnchorPrivilegeInUseConnectorMessage;
import com.cupidapp.live.base.grpc.LiveAnchorPrivilegeLineUpConnectorMessage;
import com.cupidapp.live.base.grpc.LiveBroadcastConnectorMessage;
import com.cupidapp.live.base.grpc.LiveConnectAcceptConnectorMessage;
import com.cupidapp.live.base.grpc.LiveConnectEndConnectorMessage;
import com.cupidapp.live.base.grpc.LiveConnectPushStreamStartMessage;
import com.cupidapp.live.base.grpc.LiveCriticalHitConnectorMessage;
import com.cupidapp.live.base.grpc.LiveEndConnectorMessage;
import com.cupidapp.live.base.grpc.LiveGiftCollectionConnectorMessage;
import com.cupidapp.live.base.grpc.LivePkAppointRejectConnectMessage;
import com.cupidapp.live.base.grpc.LivePkAppointRequestConnectorMessage;
import com.cupidapp.live.base.grpc.LivePkChatConnectorMessage;
import com.cupidapp.live.base.grpc.LivePkCloseAudioConnectorMessage;
import com.cupidapp.live.base.grpc.LivePkEndConnectorMessage;
import com.cupidapp.live.base.grpc.LivePkFirstBloodConnectorMessage;
import com.cupidapp.live.base.grpc.LivePkRandPairedMessage;
import com.cupidapp.live.base.grpc.LivePkStartConnectorMessage;
import com.cupidapp.live.base.grpc.LivePkUpdateConnectorMessage;
import com.cupidapp.live.base.grpc.LiveShowAnimationConnectorMessageModel;
import com.cupidapp.live.base.grpc.LiveShowMoreMenuUnreadMessageModel;
import com.cupidapp.live.base.grpc.LiveShowShakeConnectorMessage;
import com.cupidapp.live.base.grpc.LiveShowTagConnectorMessageModel;
import com.cupidapp.live.base.grpc.LiveStickerUpdateConnectorMessageModel;
import com.cupidapp.live.base.grpc.NewLiveConnectRequestConnectorMessage;
import com.cupidapp.live.base.grpc.NotifyConnectorMessage;
import com.cupidapp.live.base.grpc.RedEnvelopeConnectorMessage;
import com.cupidapp.live.base.grpc.RefreshFollowLiveStatusMessageModel;
import com.cupidapp.live.base.grpc.StarChallengeChestConnectorMessage;
import com.cupidapp.live.base.grpc.StarChallengeLvlUpgradeConnectorMessage;
import com.cupidapp.live.base.grpc.StartPrayContestConnectorMessage;
import com.cupidapp.live.base.grpc.UserEntryConnectorMessage;
import com.cupidapp.live.base.grpc.ViewerLeaveConnectorMessage;
import com.cupidapp.live.liveshow.model.FKLiveHornModel;
import com.cupidapp.live.liveshow.model.HeatValuesModel;
import com.cupidapp.live.liveshow.model.SignInInfoModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkAgreeInvitingModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkCancelInvitingModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkCancelPrepareModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkEndModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkFirstBloodModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkInteractModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkInvitationModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkMixSuccessModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkMuteOthersModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkRefuseInvitingModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkScoreUpdateModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkStartModel;
import com.cupidapp.live.liveshow.pk.view.FKLivePkStatus;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveGrpcEntity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface a {

    /* compiled from: FKLiveGrpcEntity.kt */
    @kotlin.d
    /* renamed from: com.cupidapp.live.liveshow.entity.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class C0157a {
        public static void A(@NotNull a aVar, @NotNull MultiPkMuteOthersModel messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void B(@NotNull a aVar, @NotNull MultiPkRefuseInvitingModel messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void C(@NotNull a aVar, @NotNull MultiPkScoreUpdateModel messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void D(@NotNull a aVar, @NotNull MultiPkStartModel messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void E(@NotNull a aVar, @NotNull NotifyConnectorMessage messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void F(@NotNull a aVar, @NotNull LivePkAppointRejectConnectMessage messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void G(@NotNull a aVar, @NotNull LivePkAppointRequestConnectorMessage messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void H(@NotNull a aVar, @NotNull LivePkChatConnectorMessage messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void I(@NotNull a aVar, @NotNull LivePkFirstBloodConnectorMessage messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void J(@NotNull a aVar, @NotNull LivePkRandPairedMessage messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void K(@NotNull a aVar, @NotNull FKLivePkStatus status) {
            s.i(status, "status");
        }

        public static void L(@NotNull a aVar, @NotNull LivePkUpdateConnectorMessage messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void M(@NotNull a aVar, @NotNull RedEnvelopeConnectorMessage messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void N(@NotNull a aVar, @NotNull RefreshFollowLiveStatusMessageModel message) {
            s.i(message, "message");
        }

        public static void O(@NotNull a aVar, @Nullable HeatValuesModel heatValuesModel) {
        }

        public static void P(@NotNull a aVar, @Nullable String str, @Nullable String str2) {
        }

        public static void Q(@NotNull a aVar, @NotNull SignInInfoModel messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void R(@NotNull a aVar, @NotNull LiveShowAnimationConnectorMessageModel messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void S(@NotNull a aVar, @NotNull LiveShowTagConnectorMessageModel messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void T(@NotNull a aVar, @NotNull LiveShowMoreMenuUnreadMessageModel messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void U(@NotNull a aVar, @NotNull StarChallengeChestConnectorMessage messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void V(@NotNull a aVar, @NotNull StarChallengeLvlUpgradeConnectorMessage messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void W(@NotNull a aVar, @NotNull LiveStickerUpdateConnectorMessageModel message) {
            s.i(message, "message");
        }

        public static void X(@NotNull a aVar, @NotNull UserEntryConnectorMessage messageModel, @NotNull ConnectorMessageEvent event) {
            s.i(messageModel, "messageModel");
            s.i(event, "event");
        }

        public static void Y(@NotNull a aVar, @NotNull ViewerLeaveConnectorMessage messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void a(@NotNull a aVar, @NotNull AnchorInfoBorderConnectorMessage messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void b(@NotNull a aVar, @NotNull LiveAnchorLvlExpChangeConnectorMessage messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void c(@NotNull a aVar, @NotNull LiveAnchorLvlUpgradeAnimationConnectorMessage messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void d(@NotNull a aVar, @NotNull LiveAnchorPrivilegeEndUseConnectorMessage messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void e(@NotNull a aVar, @NotNull LiveAnchorPrivilegeHintConnectorMessage messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void f(@NotNull a aVar, @NotNull LiveAnchorPrivilegeInUseConnectorMessage messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void g(@NotNull a aVar, @NotNull LiveAnchorPrivilegeLineUpConnectorMessage messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void h(@NotNull a aVar, @NotNull LiveBroadcastConnectorMessage messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void i(@NotNull a aVar, @NotNull CommentConnectorMessage messageModel, @NotNull ConnectorMessageEvent event) {
            s.i(messageModel, "messageModel");
            s.i(event, "event");
        }

        public static void j(@NotNull a aVar, @NotNull LiveConnectAcceptConnectorMessage messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void k(@NotNull a aVar, @NotNull LiveConnectPushStreamStartMessage messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void l(@NotNull a aVar, @NotNull NewLiveConnectRequestConnectorMessage messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void m(@NotNull a aVar, @NotNull LiveCriticalHitConnectorMessage messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void n(@NotNull a aVar, @NotNull FullLiveVisibleGiftConnectorMessage message) {
            s.i(message, "message");
        }

        public static void o(@NotNull a aVar, @NotNull LiveGiftCollectionConnectorMessage messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void p(@NotNull a aVar, @NotNull GiftConnectorMessage messageModel, @NotNull ConnectorMessageEvent event) {
            s.i(messageModel, "messageModel");
            s.i(event, "event");
        }

        public static void q(@NotNull a aVar, @NotNull FKLiveHornModel messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void r(@NotNull a aVar, @NotNull KickOutLiveRoomMessageModel messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void s(@NotNull a aVar, @NotNull LiveShowShakeConnectorMessage messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void t(@NotNull a aVar, @NotNull StartPrayContestConnectorMessage messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void u(@NotNull a aVar, @NotNull MultiPkAgreeInvitingModel messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void v(@NotNull a aVar, @NotNull MultiPkCancelInvitingModel messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void w(@NotNull a aVar, @NotNull MultiPkFirstBloodModel messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void x(@NotNull a aVar, @NotNull MultiPkInteractModel messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void y(@NotNull a aVar, @NotNull MultiPkInvitationModel messageModel) {
            s.i(messageModel, "messageModel");
        }

        public static void z(@NotNull a aVar, @NotNull MultiPkMixSuccessModel messageModel) {
            s.i(messageModel, "messageModel");
        }
    }

    void A(@NotNull KickOutLiveRoomMessageModel kickOutLiveRoomMessageModel);

    void A0(@NotNull RefreshFollowLiveStatusMessageModel refreshFollowLiveStatusMessageModel);

    void B(@NotNull LivePkAppointRejectConnectMessage livePkAppointRejectConnectMessage);

    void B0(@NotNull LiveConnectPushStreamStartMessage liveConnectPushStreamStartMessage);

    void C0(@NotNull LiveCriticalHitConnectorMessage liveCriticalHitConnectorMessage);

    void D(@NotNull LiveBroadcastConnectorMessage liveBroadcastConnectorMessage);

    void D0(@NotNull LivePkUpdateConnectorMessage livePkUpdateConnectorMessage);

    void E(@NotNull RedEnvelopeConnectorMessage redEnvelopeConnectorMessage);

    void F(@NotNull LiveStickerUpdateConnectorMessageModel liveStickerUpdateConnectorMessageModel);

    void F0(@NotNull MultiPkAgreeInvitingModel multiPkAgreeInvitingModel);

    void K(@NotNull MultiPkCancelPrepareModel multiPkCancelPrepareModel);

    void L0(@NotNull LiveAnchorPrivilegeEndUseConnectorMessage liveAnchorPrivilegeEndUseConnectorMessage);

    void M(@NotNull ViewerLeaveConnectorMessage viewerLeaveConnectorMessage);

    void N(@NotNull LiveEndConnectorMessage liveEndConnectorMessage);

    void R(@NotNull LiveShowMoreMenuUnreadMessageModel liveShowMoreMenuUnreadMessageModel);

    void S(@NotNull LiveConnectEndConnectorMessage liveConnectEndConnectorMessage);

    void T(@NotNull LivePkChatConnectorMessage livePkChatConnectorMessage);

    void W(@NotNull LivePkEndConnectorMessage livePkEndConnectorMessage);

    void X(@NotNull LivePkCloseAudioConnectorMessage livePkCloseAudioConnectorMessage);

    void Y(@NotNull LiveAnchorPrivilegeInUseConnectorMessage liveAnchorPrivilegeInUseConnectorMessage);

    void a(@NotNull StarChallengeLvlUpgradeConnectorMessage starChallengeLvlUpgradeConnectorMessage);

    void a0(@NotNull StarChallengeChestConnectorMessage starChallengeChestConnectorMessage);

    void b(@NotNull LivePkStartConnectorMessage livePkStartConnectorMessage);

    void b0(@NotNull CommentConnectorMessage commentConnectorMessage, @NotNull ConnectorMessageEvent connectorMessageEvent);

    void d(@NotNull LiveAnchorPrivilegeLineUpConnectorMessage liveAnchorPrivilegeLineUpConnectorMessage);

    void d0(@NotNull FKLiveHornModel fKLiveHornModel);

    void e(@NotNull LivePkAppointRequestConnectorMessage livePkAppointRequestConnectorMessage);

    void e0(@NotNull LiveAnchorPrivilegeHintConnectorMessage liveAnchorPrivilegeHintConnectorMessage);

    void f(@NotNull NotifyConnectorMessage notifyConnectorMessage);

    void f0(@NotNull LiveShowTagConnectorMessageModel liveShowTagConnectorMessageModel);

    void g(@NotNull MultiPkScoreUpdateModel multiPkScoreUpdateModel);

    void g0(@NotNull MultiPkMixSuccessModel multiPkMixSuccessModel);

    void h(@Nullable HeatValuesModel heatValuesModel);

    void h0(@NotNull AnchorInfoBorderConnectorMessage anchorInfoBorderConnectorMessage);

    void i(@NotNull LiveShowShakeConnectorMessage liveShowShakeConnectorMessage);

    void j(@NotNull GiftConnectorMessage giftConnectorMessage, @NotNull ConnectorMessageEvent connectorMessageEvent);

    void j0(@Nullable String str, @Nullable String str2);

    void k0(@NotNull MultiPkMuteOthersModel multiPkMuteOthersModel);

    void l(@NotNull NewLiveConnectRequestConnectorMessage newLiveConnectRequestConnectorMessage);

    void l0(@NotNull LivePkFirstBloodConnectorMessage livePkFirstBloodConnectorMessage);

    void m(@NotNull LiveAnchorLvlUpgradeAnimationConnectorMessage liveAnchorLvlUpgradeAnimationConnectorMessage);

    void n(@NotNull StartPrayContestConnectorMessage startPrayContestConnectorMessage);

    void o(@NotNull MultiPkCancelInvitingModel multiPkCancelInvitingModel);

    void o0(@NotNull LiveAnchorLvlExpChangeConnectorMessage liveAnchorLvlExpChangeConnectorMessage);

    void p(@NotNull FKLivePkStatus fKLivePkStatus);

    void q0(@NotNull MultiPkInvitationModel multiPkInvitationModel);

    void r(@NotNull MultiPkInteractModel multiPkInteractModel);

    void r0(@NotNull MultiPkRefuseInvitingModel multiPkRefuseInvitingModel);

    void s(@NotNull UserEntryConnectorMessage userEntryConnectorMessage, @NotNull ConnectorMessageEvent connectorMessageEvent);

    void t(@NotNull LiveShowAnimationConnectorMessageModel liveShowAnimationConnectorMessageModel);

    void u(@NotNull LivePkRandPairedMessage livePkRandPairedMessage);

    void u0(@NotNull SignInInfoModel signInInfoModel);

    void v0(@NotNull LiveGiftCollectionConnectorMessage liveGiftCollectionConnectorMessage);

    void w(@NotNull FullLiveVisibleGiftConnectorMessage fullLiveVisibleGiftConnectorMessage);

    void w0(@NotNull MultiPkEndModel multiPkEndModel);

    void x(@NotNull MultiPkStartModel multiPkStartModel);

    void x0(@NotNull MultiPkFirstBloodModel multiPkFirstBloodModel);

    void y0(@NotNull LiveConnectAcceptConnectorMessage liveConnectAcceptConnectorMessage);
}
