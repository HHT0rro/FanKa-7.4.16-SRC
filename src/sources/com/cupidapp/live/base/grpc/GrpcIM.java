package com.cupidapp.live.base.grpc;

import android.content.Context;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.base.grpc.CuConnectorOuterClass;
import com.cupidapp.live.base.network.gson.GsonUtil;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ServiceInfoModel;
import com.cupidapp.live.base.utils.r0;
import com.cupidapp.live.chat.model.RefreshSessionLiveStatusGrpcModel;
import com.cupidapp.live.chat2.model.ChatGuideGrpcModel;
import com.cupidapp.live.club.model.ClubEnterRequestConnectorMessageModel;
import com.cupidapp.live.club.model.ClubMessageCancelConnectorMessageModel;
import com.cupidapp.live.club.model.ClubNewMessageConnectorMessageModel;
import com.cupidapp.live.club.model.ClubTopMsgConnectorMessageModel;
import com.cupidapp.live.consult.model.ConsultAnchorInfoChangeGrpcModel;
import com.cupidapp.live.consult.model.ConsultApplyConnectGrpcModel;
import com.cupidapp.live.consult.model.ConsultCommentGrpcModel;
import com.cupidapp.live.consult.model.ConsultConnectSuccessGrpcModel;
import com.cupidapp.live.consult.model.ConsultHangUpConnectGrpcModel;
import com.cupidapp.live.consult.model.ConsultOnlineInfoGrpcModel;
import com.cupidapp.live.consult.model.ConsultRequestConnectGrpcModel;
import com.cupidapp.live.consult.model.ConsultRoomEndGrpcModel;
import com.cupidapp.live.consult.model.EnterNewRoomSuccessGrpcModel;
import com.cupidapp.live.consult.model.RequestConnectCountGrpcModel;
import com.cupidapp.live.liveshow.model.FKLiveBaseHornModel;
import com.cupidapp.live.liveshow.model.FollowAnchorModel;
import com.cupidapp.live.liveshow.model.SignInInfoModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkAgreeInvitingGrpcModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkCancelInvitingGrpcModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkCancelPrepareGrpcModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkEndGrpcModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkFirstBloodGrpcModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkInteractGrpcModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkInvitationGrpcModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkMixSuccessGrpcModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkMuteOthersGrpcModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkRefuseInvitingGrpcModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkScoreUpdateGrpcModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkStartGrpcModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatConnectorMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatDiceModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatLeaveRoom;
import com.cupidapp.live.maskparty.model.MaskPartyChatNotifyMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatTypingModel;
import com.cupidapp.live.maskparty.model.MaskPartyHangUpMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyMatchSuccessModel;
import com.cupidapp.live.maskparty.model.MaskPartyMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyRecommendModel;
import com.cupidapp.live.maskparty.model.ScriptTaskScoreModel;
import com.cupidapp.live.push.FKPushModel;
import com.cupidapp.live.track.group.GroupLiveLog;
import com.cupidapp.live.voiceparty.model.MaskPartyShowProfileModel;
import com.cupidapp.live.voiceparty.model.VoicePartyGameNewSysTipModel;
import com.cupidapp.live.voiceparty.model.VoicePartyGameRequestModel;
import com.cupidapp.live.voiceparty.model.VoicePartyLateNightModel;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: GrpcIM.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class GrpcIM extends GrpcIMBase {
    private static long authMessageId;
    private static long clearExpiredNeedAckMsgIdTime;

    @Nullable
    private static String consultRoomId;

    @Nullable
    private static String liveShowId;
    private static boolean liveShowing;

    @Nullable
    private static Boolean liveViewer;

    @NotNull
    public static final GrpcIM INSTANCE = new GrpcIM();

    @NotNull
    private static final AtomicLong autoIncrementId = new AtomicLong(1);

    @NotNull
    private static final HashMap<Long, Long> needAckMsgIdMap = new HashMap<>();

    /* compiled from: GrpcIM.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CuConnectorOuterClass.MessageType.values().length];
            try {
                iArr[CuConnectorOuterClass.MessageType.RequestReply.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.NewComment.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.NewGift.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LiveShowEnd.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.NewNotify.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.ViewerEnter.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LiveBroadcast.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LiveConnectAccept.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LiveConnectEnd.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.NewLiveConnectRequest.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LiveShake.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LiveConnectPushStreamStart.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.ViewerLeave.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LivePkStart.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LivePkUpdate.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LivePkChat.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LivePkEnd.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.PushMessage.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LiveHorn.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LivePkAppointRequest.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LivePkAppointReject.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LivePkCloseAudio.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LivePkRandPaired.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.AnchorLvlUpgradeAnimation.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.AnchorLvlExpChange.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.AnchorPrivilegeHint.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.AnchorPrivilegeInUse.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.AnchorPrivilegeLineUp.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.AnchorPrivilegeLineUnUse.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LivePkFirstBlood.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LiveLotteryCrit.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LiveHeatValueChange.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.MaskMatchRecPopover.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.MaskMatchSuccess.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.MaskMatchNewMessage.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.MaskMatchMessageRemove.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.MaskMatchNewSysTip.ordinal()] = 37;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.MaskMatchPlayDice.ordinal()] = 38;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.MaskMatchTyping.ordinal()] = 39;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.CanPlayNewRound.ordinal()] = 40;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.MaskMatchLeaveRoom.ordinal()] = 41;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.ShowUserCanSendImageGuide.ordinal()] = 42;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.MaskMatchOnHookPopup.ordinal()] = 43;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.AudioGameRequest.ordinal()] = 44;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.AudioGameNewSysTip.ordinal()] = 45;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.AudioGameLightMode.ordinal()] = 46;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.GameShowProfile.ordinal()] = 47;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.ClientUiElementChange.ordinal()] = 48;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LiveRoomElementChange.ordinal()] = 49;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LotteryBattleStart.ordinal()] = 50;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.DynamicGuide.ordinal()] = 51;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.UnreadCountsUpdate.ordinal()] = 52;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LiveRedPacket.ordinal()] = 53;
            } catch (NoSuchFieldError unused53) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.MaskMatchDoublePlayRoleInfo.ordinal()] = 54;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.MaskMatchScriptTechnicalScore.ordinal()] = 55;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LiveKickOut.ordinal()] = 56;
            } catch (NoSuchFieldError unused56) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.AnchorProfileBorder.ordinal()] = 57;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.AnchorStarLevelChest.ordinal()] = 58;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.AnchorStarLevelUpgradeAnimation.ordinal()] = 59;
            } catch (NoSuchFieldError unused59) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LiveRoomTag.ordinal()] = 60;
            } catch (NoSuchFieldError unused60) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LiveMenuRedDot.ordinal()] = 61;
            } catch (NoSuchFieldError unused61) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LiveRoomAnimation.ordinal()] = 62;
            } catch (NoSuchFieldError unused62) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LiveRocketAnimation.ordinal()] = 63;
            } catch (NoSuchFieldError unused63) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LiveStickerUpdate.ordinal()] = 64;
            } catch (NoSuchFieldError unused64) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.GroupMessageNew.ordinal()] = 65;
            } catch (NoSuchFieldError unused65) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.GroupMessageCancel.ordinal()] = 66;
            } catch (NoSuchFieldError unused66) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.GroupApplySubmit.ordinal()] = 67;
            } catch (NoSuchFieldError unused67) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.GroupMessageTop.ordinal()] = 68;
            } catch (NoSuchFieldError unused68) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.StreamFollowProcessPie.ordinal()] = 69;
            } catch (NoSuchFieldError unused69) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.NewVoiceRoomEnded.ordinal()] = 70;
            } catch (NoSuchFieldError unused70) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.VoiceConnectApplyChange.ordinal()] = 71;
            } catch (NoSuchFieldError unused71) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.VoiceConnectAnchorAgree.ordinal()] = 72;
            } catch (NoSuchFieldError unused72) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.VoiceConnectUserJoinedRoom.ordinal()] = 73;
            } catch (NoSuchFieldError unused73) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.VoiceConnectSuccess.ordinal()] = 74;
            } catch (NoSuchFieldError unused74) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.VoiceConnectHangUp.ordinal()] = 75;
            } catch (NoSuchFieldError unused75) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.VoiceConnectWait.ordinal()] = 76;
            } catch (NoSuchFieldError unused76) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.NewVoiceRoomComment.ordinal()] = 77;
            } catch (NoSuchFieldError unused77) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.VoiceRoomOnlineInfo.ordinal()] = 78;
            } catch (NoSuchFieldError unused78) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.VoiceRoomAnchorInfoChange.ordinal()] = 79;
            } catch (NoSuchFieldError unused79) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.ChatGuide.ordinal()] = 80;
            } catch (NoSuchFieldError unused80) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.RefreshSession.ordinal()] = 81;
            } catch (NoSuchFieldError unused81) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LivePkMultiplayerStart.ordinal()] = 82;
            } catch (NoSuchFieldError unused82) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LivePkMultiplayerUpdate.ordinal()] = 83;
            } catch (NoSuchFieldError unused83) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LivePkMultiplayerInvited.ordinal()] = 84;
            } catch (NoSuchFieldError unused84) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LivePkMultiplayerInviteAgree.ordinal()] = 85;
            } catch (NoSuchFieldError unused85) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LivePkMultiplayerInviteRejected.ordinal()] = 86;
            } catch (NoSuchFieldError unused86) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LivePkMultiplayerChat.ordinal()] = 87;
            } catch (NoSuchFieldError unused87) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LivePkMultiplayerEnd.ordinal()] = 88;
            } catch (NoSuchFieldError unused88) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LivePkMultiplayerCloseAudio.ordinal()] = 89;
            } catch (NoSuchFieldError unused89) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LivePkMultiplayerFirstBlood.ordinal()] = 90;
            } catch (NoSuchFieldError unused90) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LivePkMultiplayerMixStreamDone.ordinal()] = 91;
            } catch (NoSuchFieldError unused91) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LivePkMultiplayerPrepareCancel.ordinal()] = 92;
            } catch (NoSuchFieldError unused92) {
            }
            try {
                iArr[CuConnectorOuterClass.MessageType.LivePkMultiplayerInviteCancel.ordinal()] = 93;
            } catch (NoSuchFieldError unused93) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private GrpcIM() {
    }

    private final void handleData(final CuConnectorOuterClass.ConnectorMessage connectorMessage) {
        final Object fromJson;
        if (!connectorMessage.getNeedAck() || sendAck(connectorMessage.getMessageId())) {
            Gson b4 = GsonUtil.f12000a.b();
            LiveShowConnectorMessage liveShowConnectorMessage = (LiveShowConnectorMessage) b4.fromJson(connectorMessage.getBody(), LiveShowConnectorMessage.class);
            CuConnectorOuterClass.MessageType type = connectorMessage.getType();
            switch (type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
                case 2:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) CommentConnectorMessage.class);
                    break;
                case 3:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) GiftConnectorMessage.class);
                    break;
                case 4:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) LiveEndConnectorMessage.class);
                    break;
                case 5:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) NotifyConnectorMessage.class);
                    break;
                case 6:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) UserEntryConnectorMessage.class);
                    break;
                case 7:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) LiveBroadcastConnectorMessage.class);
                    break;
                case 8:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) LiveConnectAcceptConnectorMessage.class);
                    break;
                case 9:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) LiveConnectEndConnectorMessage.class);
                    break;
                case 10:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) NewLiveConnectRequestConnectorMessage.class);
                    break;
                case 11:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) LiveShowShakeConnectorMessage.class);
                    break;
                case 12:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) LiveConnectPushStreamStartMessage.class);
                    break;
                case 13:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) ViewerLeaveConnectorMessage.class);
                    break;
                case 14:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) LivePkStartConnectorMessage.class);
                    break;
                case 15:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) LivePkUpdateConnectorMessage.class);
                    break;
                case 16:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) LivePkChatConnectorMessage.class);
                    break;
                case 17:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) LivePkEndConnectorMessage.class);
                    break;
                case 18:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) FKPushModel.class);
                    break;
                case 19:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) FKLiveBaseHornModel.class);
                    break;
                case 20:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) LivePkAppointRequestConnectorMessage.class);
                    break;
                case 21:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) LivePkAppointRejectConnectMessage.class);
                    break;
                case 22:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) LivePkCloseAudioConnectorMessage.class);
                    break;
                case 23:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) LivePkRandPairedMessage.class);
                    break;
                case 24:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) LiveAnchorLvlUpgradeAnimationConnectorMessage.class);
                    break;
                case 25:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) LiveAnchorLvlExpChangeConnectorMessage.class);
                    break;
                case 26:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) LiveAnchorPrivilegeHintConnectorMessage.class);
                    break;
                case 27:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) LiveAnchorPrivilegeInUseConnectorMessage.class);
                    break;
                case 28:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) LiveAnchorPrivilegeLineUpConnectorMessage.class);
                    break;
                case 29:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) LiveAnchorPrivilegeEndUseConnectorMessage.class);
                    break;
                case 30:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) LivePkFirstBloodConnectorMessage.class);
                    break;
                case 31:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) LiveCriticalHitConnectorMessage.class);
                    break;
                case 32:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) LiveHotConnectorMessage.class);
                    break;
                case 33:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) MaskPartyRecommendModel.class);
                    break;
                case 34:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) MaskPartyMatchSuccessModel.class);
                    break;
                case 35:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) MaskPartyMessageModel.class);
                    break;
                case 36:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) MaskPartyMessageModel.class);
                    break;
                case 37:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) MaskPartyChatNotifyMessageModel.class);
                    break;
                case 38:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) MaskPartyChatDiceModel.class);
                    break;
                case 39:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) MaskPartyChatTypingModel.class);
                    break;
                case 40:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) MaskPartyChatConnectorMessageModel.class);
                    break;
                case 41:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) MaskPartyChatLeaveRoom.class);
                    break;
                case 42:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) MaskPartyChatConnectorMessageModel.class);
                    break;
                case 43:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) MaskPartyHangUpMessageModel.class);
                    break;
                case 44:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) VoicePartyGameRequestModel.class);
                    break;
                case 45:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) VoicePartyGameNewSysTipModel.class);
                    break;
                case 46:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) VoicePartyLateNightModel.class);
                    break;
                case 47:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) MaskPartyShowProfileModel.class);
                    break;
                case 48:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) SignInInfoModel.class);
                    break;
                case 49:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) LiveGiftCollectionConnectorMessage.class);
                    break;
                case 50:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) StartPrayContestConnectorMessage.class);
                    break;
                case 51:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) DynamicGuideModel.class);
                    break;
                case 52:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) FollowAnchorModel.class);
                    break;
                case 53:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) RedEnvelopeConnectorMessage.class);
                    break;
                case 54:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) MaskPartyChatConnectorMessageModel.class);
                    break;
                case 55:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) ScriptTaskScoreModel.class);
                    break;
                case 56:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) KickOutLiveRoomMessageModel.class);
                    break;
                case 57:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) AnchorInfoBorderConnectorMessage.class);
                    break;
                case 58:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) StarChallengeChestConnectorMessage.class);
                    break;
                case 59:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) StarChallengeLvlUpgradeConnectorMessage.class);
                    break;
                case 60:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) LiveShowTagConnectorMessageModel.class);
                    break;
                case 61:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) LiveShowMoreMenuUnreadMessageModel.class);
                    break;
                case 62:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) LiveShowAnimationConnectorMessageModel.class);
                    break;
                case 63:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) FullLiveVisibleGiftConnectorMessage.class);
                    break;
                case 64:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) LiveStickerUpdateConnectorMessageModel.class);
                    break;
                case 65:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) ClubNewMessageConnectorMessageModel.class);
                    break;
                case 66:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) ClubMessageCancelConnectorMessageModel.class);
                    break;
                case 67:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) ClubEnterRequestConnectorMessageModel.class);
                    break;
                case 68:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) ClubTopMsgConnectorMessageModel.class);
                    break;
                case 69:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) RefreshFollowLiveStatusMessageModel.class);
                    break;
                case 70:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) ConsultRoomEndGrpcModel.class);
                    break;
                case 71:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) ConsultRequestConnectGrpcModel.class);
                    break;
                case 72:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) ConsultApplyConnectGrpcModel.class);
                    break;
                case 73:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) EnterNewRoomSuccessGrpcModel.class);
                    break;
                case 74:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) ConsultConnectSuccessGrpcModel.class);
                    break;
                case 75:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) ConsultHangUpConnectGrpcModel.class);
                    break;
                case 76:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) RequestConnectCountGrpcModel.class);
                    break;
                case 77:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) ConsultCommentGrpcModel.class);
                    break;
                case 78:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) ConsultOnlineInfoGrpcModel.class);
                    break;
                case 79:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) ConsultAnchorInfoChangeGrpcModel.class);
                    break;
                case 80:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) ChatGuideGrpcModel.class);
                    break;
                case 81:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) RefreshSessionLiveStatusGrpcModel.class);
                    break;
                case 82:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) MultiPkStartGrpcModel.class);
                    break;
                case 83:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) MultiPkScoreUpdateGrpcModel.class);
                    break;
                case 84:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) MultiPkInvitationGrpcModel.class);
                    break;
                case 85:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) MultiPkAgreeInvitingGrpcModel.class);
                    break;
                case 86:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) MultiPkRefuseInvitingGrpcModel.class);
                    break;
                case 87:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) MultiPkInteractGrpcModel.class);
                    break;
                case 88:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) MultiPkEndGrpcModel.class);
                    break;
                case 89:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) MultiPkMuteOthersGrpcModel.class);
                    break;
                case 90:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) MultiPkFirstBloodGrpcModel.class);
                    break;
                case 91:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) MultiPkMixSuccessGrpcModel.class);
                    break;
                case 92:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) MultiPkCancelPrepareGrpcModel.class);
                    break;
                case 93:
                    fromJson = b4.fromJson(connectorMessage.getBody(), (Class<Object>) MultiPkCancelInvitingGrpcModel.class);
                    break;
                default:
                    fromJson = kotlin.p.f51048a;
                    break;
            }
            kotlin.jvm.internal.s.h(fromJson, "when (type) {\n          …          }\n            }");
            com.cupidapp.live.base.utils.j.f12332a.a(GrpcIMBase.TAG, "handlerData value=" + ((Object) connectorMessage) + ", model=" + fromJson);
            EventBus.c().l(new ConnectorMessageEvent(connectorMessage, fromJson, liveShowConnectorMessage));
            String body = connectorMessage.getBody();
            if (body == null || body.length() == 0) {
                return;
            }
            GrpcIMBase.runInMainThread$default(INSTANCE, new Runnable() { // from class: com.cupidapp.live.base.grpc.h
                @Override // java.lang.Runnable
                public final void run() {
                    GrpcIM.handleData$lambda$5$lambda$4(CuConnectorOuterClass.ConnectorMessage.this, fromJson);
                }
            }, 0L, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleData$lambda$5$lambda$4(CuConnectorOuterClass.ConnectorMessage message, Object model) {
        kotlin.jvm.internal.s.i(message, "$message");
        kotlin.jvm.internal.s.i(model, "$model");
        GrpcMessageRouter grpcMessageRouter = GrpcMessageRouter.INSTANCE;
        CuConnectorOuterClass.MessageType type = message.getType();
        kotlin.jvm.internal.s.h(type, "message.type");
        grpcMessageRouter.onDispatchGrpcMessage(type, model);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onConnectorClosed$lambda$3(GrpcIM this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        y0.a.f54658a.c(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onConnectorReceived$lambda$2$lambda$1(GrpcIM this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        y0.a.b(y0.a.f54658a, this$0, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onEvent$lambda$6(InLiveShowHeartBeatEvent event) {
        kotlin.jvm.internal.s.i(event, "$event");
        if (liveShowing == event.getInLiveShow() && kotlin.jvm.internal.s.d(liveViewer, event.getViewer()) && (kotlin.jvm.internal.s.d(liveShowId, event.getLiveShowId()) || kotlin.jvm.internal.s.d(consultRoomId, event.getConsultRoomId()))) {
            return;
        }
        GrpcIM grpcIM = INSTANCE;
        boolean inLiveShow = event.getInLiveShow();
        liveShowing = inLiveShow;
        liveViewer = null;
        liveShowId = null;
        consultRoomId = null;
        if (inLiveShow && event.getViewer() != null && (event.getLiveShowId() != null || event.getConsultRoomId() != null)) {
            liveViewer = event.getViewer();
            liveShowId = event.getLiveShowId();
            consultRoomId = event.getConsultRoomId();
        }
        grpcIM.stopHeartbeat();
        grpcIM.startHeartbeat();
    }

    private final boolean sendAck(long j10) {
        long currentTimeMillis = System.currentTimeMillis() - 60000;
        if (clearExpiredNeedAckMsgIdTime <= currentTimeMillis) {
            clearExpiredNeedAckMsgIdTime = System.currentTimeMillis();
            Iterator<Map.Entry<Long, Long>> iterator2 = needAckMsgIdMap.entrySet().iterator2();
            while (iterator2.hasNext()) {
                Map.Entry<Long, Long> next = iterator2.next();
                kotlin.jvm.internal.s.h(next, "iterator.next()");
                Long value = next.getValue();
                kotlin.jvm.internal.s.h(value, "entry.value");
                if (value.longValue() <= currentTimeMillis) {
                    iterator2.remove();
                }
            }
        }
        HashMap<Long, Long> hashMap = needAckMsgIdMap;
        if (hashMap.containsKey(Long.valueOf(j10))) {
            return false;
        }
        sendMessageDirect(CuConnectorOuterClass.ConnectorMessage.newBuilder().setType(CuConnectorOuterClass.MessageType.ACK).setInReplyMessageId(j10).build());
        hashMap.put(Long.valueOf(j10), Long.valueOf(System.currentTimeMillis()));
        return true;
    }

    private final void sendAuthRequest() {
        p1.g gVar = p1.g.f52734a;
        String G1 = gVar.G1();
        kotlin.jvm.internal.s.f(G1);
        String g3 = gVar.g();
        if (g3 == null) {
            g3 = "";
        }
        String str = g3;
        String i10 = com.cupidapp.live.base.network.a.f11902a.i();
        r0.a aVar = r0.f12373a;
        Context baseContext = AppApplication.f11612d.h().getBaseContext();
        kotlin.jvm.internal.s.h(baseContext, "AppApplication.shareInstance.baseContext");
        authMessageId = sendRequest(new AuthRequestModel(G1, "7.4.16", str, 0, i10, null, aVar.b(baseContext).getType(), 32, null));
    }

    private final void sendClientPing() {
        sendRequest(new HeartbeatRequestModel(System.currentTimeMillis(), liveShowId, consultRoomId, liveViewer, AppApplication.f11612d.e()));
        if (!liveShowing || liveShowId == null) {
            return;
        }
        GroupLiveLog groupLiveLog = GroupLiveLog.f18698a;
        Boolean bool = liveViewer;
        groupLiveLog.f(bool != null ? bool.booleanValue() : false);
    }

    private final long sendRequest(BaseGrpcRequestModel baseGrpcRequestModel) {
        long andIncrement = autoIncrementId.getAndIncrement();
        sendMessageDirect(CuConnectorOuterClass.ConnectorMessage.newBuilder().setType(baseGrpcRequestModel.getMessageType()).setMessageId(andIncrement).setBody(baseGrpcRequestModel.toJson()).build());
        return andIncrement;
    }

    public final void connect() {
        ConstantsResult q10;
        ServiceInfoModel connector;
        p1.g gVar = p1.g.f52734a;
        String G1 = gVar.G1();
        if ((G1 == null || G1.length() == 0) || (q10 = gVar.q()) == null || (connector = q10.getConnector()) == null) {
            return;
        }
        if (connector.getHost().length() > 0) {
            INSTANCE.connect(connector.getHost(), connector.getPort());
        }
    }

    @Override // com.cupidapp.live.base.grpc.GrpcIMBase
    public void onConnectorClosed() {
        GrpcIMBase.runInMainThread$default(this, new Runnable() { // from class: com.cupidapp.live.base.grpc.j
            @Override // java.lang.Runnable
            public final void run() {
                GrpcIM.onConnectorClosed$lambda$3(GrpcIM.this);
            }
        }, 0L, 2, null);
    }

    @Override // com.cupidapp.live.base.grpc.GrpcIMBase
    public void onConnectorPing() {
        sendClientPing();
    }

    @Override // com.cupidapp.live.base.grpc.GrpcIMBase
    public void onConnectorPingTimeout() {
    }

    @Override // com.cupidapp.live.base.grpc.GrpcIMBase
    public void onConnectorReady() {
        sendAuthRequest();
    }

    @Override // com.cupidapp.live.base.grpc.GrpcIMBase
    public void onConnectorReceived(@Nullable CuConnectorOuterClass.ConnectorMessage connectorMessage) {
        if (connectorMessage != null) {
            CuConnectorOuterClass.MessageType type = connectorMessage.getType();
            if ((type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) == 1) {
                if (connectorMessage.getInReplyMessageId() == authMessageId && connectorMessage.getReplyCode() == CuConnectorOuterClass.ReplyCode.Success.getNumber()) {
                    GrpcIM grpcIM = INSTANCE;
                    grpcIM.startHeartbeat();
                    GrpcIMBase.runInMainThread$default(grpcIM, new Runnable() { // from class: com.cupidapp.live.base.grpc.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            GrpcIM.onConnectorReceived$lambda$2$lambda$1(GrpcIM.this);
                        }
                    }, 0L, 2, null);
                    return;
                }
                return;
            }
            INSTANCE.handleData(connectorMessage);
        }
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull final InLiveShowHeartBeatEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        GrpcIMBase.runInWorkThread$default(this, new Runnable() { // from class: com.cupidapp.live.base.grpc.k
            @Override // java.lang.Runnable
            public final void run() {
                GrpcIM.onEvent$lambda$6(InLiveShowHeartBeatEvent.this);
            }
        }, 0L, 2, null);
    }
}
