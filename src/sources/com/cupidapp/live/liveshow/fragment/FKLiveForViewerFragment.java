package com.cupidapp.live.liveshow.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.grpc.AnchorInfoBorderConnectorMessage;
import com.cupidapp.live.base.grpc.CommentConnectorMessage;
import com.cupidapp.live.base.grpc.ConnectorMessageEvent;
import com.cupidapp.live.base.grpc.FKGRPCMessageIdCounter;
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
import com.cupidapp.live.base.grpc.LiveShowAnimationMessageModel;
import com.cupidapp.live.base.grpc.LiveShowMoreMenuUnreadMessageModel;
import com.cupidapp.live.base.grpc.LiveShowShakeConnectorMessage;
import com.cupidapp.live.base.grpc.LiveShowTagConnectorMessageModel;
import com.cupidapp.live.base.grpc.LiveStickerUpdateConnectorMessageModel;
import com.cupidapp.live.base.grpc.NewLiveConnectRequestConnectorMessage;
import com.cupidapp.live.base.grpc.NotifyConnectorMessage;
import com.cupidapp.live.base.grpc.NotifyMessageModel;
import com.cupidapp.live.base.grpc.NotifyMessageType;
import com.cupidapp.live.base.grpc.RedEnvelopeConnectorMessage;
import com.cupidapp.live.base.grpc.RefreshFollowLiveStatusMessageModel;
import com.cupidapp.live.base.grpc.StarChallengeChestConnectorMessage;
import com.cupidapp.live.base.grpc.StarChallengeLvlUpgradeConnectorMessage;
import com.cupidapp.live.base.grpc.StartPrayContestConnectorMessage;
import com.cupidapp.live.base.grpc.UserEntryConnectorMessage;
import com.cupidapp.live.base.grpc.UserEntryDirection;
import com.cupidapp.live.base.grpc.ViewerLeaveConnectorMessage;
import com.cupidapp.live.base.grpc.ViewerLeaveModel;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.RequestErrorCode;
import com.cupidapp.live.base.network.ResultException;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.FollowPrefer;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.network.model.SwipeCardUserLikeResult;
import com.cupidapp.live.base.router.jumper.ExitFanClubEvent;
import com.cupidapp.live.base.router.jumper.ShowAutoLightUpDialogEvent;
import com.cupidapp.live.base.sensorslog.MiniWindowCloseMethod;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.liveshow.activity.FKBaseLiveActivity;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerActivity;
import com.cupidapp.live.liveshow.activity.FKLiveOpenWebFragmentEvent;
import com.cupidapp.live.liveshow.adapter.FKLiveCommentMessageViewModel;
import com.cupidapp.live.liveshow.adapter.FKLiveGiftMessageViewModel;
import com.cupidapp.live.liveshow.adapter.FKLiveMessageViewModel;
import com.cupidapp.live.liveshow.adapter.FKLiveSystemMessageViewModel;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.constants.FKLiveType;
import com.cupidapp.live.liveshow.entity.FKLiveGrpcEntity;
import com.cupidapp.live.liveshow.entity.FKLiveUtil;
import com.cupidapp.live.liveshow.entity.a;
import com.cupidapp.live.liveshow.entity.j;
import com.cupidapp.live.liveshow.fanclub.FKFanClubManager;
import com.cupidapp.live.liveshow.fanclub.model.FanClubStatus;
import com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment;
import com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindow;
import com.cupidapp.live.liveshow.model.AnchorModel;
import com.cupidapp.live.liveshow.model.AnimationType;
import com.cupidapp.live.liveshow.model.BadgeModel;
import com.cupidapp.live.liveshow.model.CommentModel;
import com.cupidapp.live.liveshow.model.FKCriticalHitModel;
import com.cupidapp.live.liveshow.model.FKLiveHornModel;
import com.cupidapp.live.liveshow.model.FKTurnTableModel;
import com.cupidapp.live.liveshow.model.GiftAnimationModel;
import com.cupidapp.live.liveshow.model.GiftCollectionModel;
import com.cupidapp.live.liveshow.model.GiftItemModel;
import com.cupidapp.live.liveshow.model.GiftListResult;
import com.cupidapp.live.liveshow.model.GiftModel;
import com.cupidapp.live.liveshow.model.HeatValuesModel;
import com.cupidapp.live.liveshow.model.LiveActivityModel;
import com.cupidapp.live.liveshow.model.LiveCommentGuideType;
import com.cupidapp.live.liveshow.model.LiveConnectRequestCheckResult;
import com.cupidapp.live.liveshow.model.LiveCoverTagModel;
import com.cupidapp.live.liveshow.model.LiveEndModel;
import com.cupidapp.live.liveshow.model.LiveMenuBtnModel;
import com.cupidapp.live.liveshow.model.LiveShowAnimationModel;
import com.cupidapp.live.liveshow.model.LiveShowGiftModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.LiveShowPkWarResult;
import com.cupidapp.live.liveshow.model.LiveShowRankTagListModel;
import com.cupidapp.live.liveshow.model.LiveShowResult;
import com.cupidapp.live.liveshow.model.MultiPkInfoModel;
import com.cupidapp.live.liveshow.model.PopupInfoModel;
import com.cupidapp.live.liveshow.model.QuickGiftModel;
import com.cupidapp.live.liveshow.model.RedEnvelopeTagModel;
import com.cupidapp.live.liveshow.model.SignInInfoModel;
import com.cupidapp.live.liveshow.model.StarChallengeLvlUpgradeModel;
import com.cupidapp.live.liveshow.model.SummaryDataResult;
import com.cupidapp.live.liveshow.model.SummaryModel;
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
import com.cupidapp.live.liveshow.pk.view.FKLivePkStatusAnimationLayout;
import com.cupidapp.live.liveshow.pk.view.FKLivePkWarLayout;
import com.cupidapp.live.liveshow.pk.view.MultiPkForViewerLayout;
import com.cupidapp.live.liveshow.view.FKLiveSendGiftCriticalHitView;
import com.cupidapp.live.liveshow.view.FollowLiveStatusLayout;
import com.cupidapp.live.liveshow.view.LiveRedEnvelopeView;
import com.cupidapp.live.liveshow.view.bottommenu.FKLiveForViewerBottomMenuLayout;
import com.cupidapp.live.liveshow.view.bottommenu.FKLiveForViewerMoreMenuFragment;
import com.cupidapp.live.liveshow.view.bottommenu.MenuType;
import com.cupidapp.live.liveshow.view.comment.FKLiveBarrageLayout;
import com.cupidapp.live.liveshow.view.comment.FKLiveCommentLayout;
import com.cupidapp.live.liveshow.view.comment.FKLiveShowCommentEditTextLayout;
import com.cupidapp.live.liveshow.view.comment.LiveAlohaActorGuideLayout;
import com.cupidapp.live.liveshow.view.comment.LiveCommentGuideHelper;
import com.cupidapp.live.liveshow.view.comment.ShowCommentEvent;
import com.cupidapp.live.liveshow.view.giftcollection.GiftCollectionLayout;
import com.cupidapp.live.liveshow.view.giftpicker.fragment.DiamondBalanceFragment;
import com.cupidapp.live.liveshow.view.giftpicker.fragment.FKLiveGiftPickerFragment;
import com.cupidapp.live.liveshow.view.giftpicker.fragment.OpenDiamondBalanceEvent;
import com.cupidapp.live.liveshow.view.giftpicker.fragment.OpenLiveGiftEvent;
import com.cupidapp.live.liveshow.view.giftpicker.helper.SendGiftHelper;
import com.cupidapp.live.liveshow.view.giftpicker.view.ContinuousSendGiftLayout;
import com.cupidapp.live.liveshow.view.giftpicker.view.FKLiveGiftEnterAnimationLayout;
import com.cupidapp.live.liveshow.view.giftpicker.view.HideGiftDetailDescriptionEvent;
import com.cupidapp.live.liveshow.view.giftpicker.view.QuickGiftAnimationLayout;
import com.cupidapp.live.liveshow.view.giftpicker.view.SendGiftSuccessEvent;
import com.cupidapp.live.liveshow.view.giftplayer.FKLiveGiftAnimationLayout;
import com.cupidapp.live.liveshow.view.giftplayer.FullLiveVisibleGiftLayout;
import com.cupidapp.live.liveshow.view.guide.FKLiveNetworkErrorLayout;
import com.cupidapp.live.liveshow.view.horn.FKLiveBaseHornLayout;
import com.cupidapp.live.liveshow.view.liveinfo.FKActorInfoAndAudienceLayout;
import com.cupidapp.live.liveshow.view.liveinfo.FKLiveBroadcastLayout;
import com.cupidapp.live.liveshow.view.liveinfo.FKLiveShowActivityLayout;
import com.cupidapp.live.liveshow.view.liveinfo.FKLiveShowAdLayout;
import com.cupidapp.live.liveshow.view.liveinfo.FKLiveTopStartPositionLayout;
import com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfilePhotoFragment;
import com.cupidapp.live.liveshow.view.miniprofile.FKMiniProfilePhotoViewModel;
import com.cupidapp.live.liveshow.view.praybattle.FKLivePrayBattleView;
import com.cupidapp.live.liveshow.view.remoteconnect.fragment.FKLiveRequestConnectFragment;
import com.cupidapp.live.liveshow.view.remoteconnect.view.LiveConnectEntranceView;
import com.cupidapp.live.liveshow.view.remoteconnect.view.LiveConnectLayout;
import com.cupidapp.live.liveshow.view.remoteconnect.view.LiveConnectStatus;
import com.cupidapp.live.liveshow.view.remoteconnect.view.b;
import com.cupidapp.live.liveshow.view.shake.FKLiveShakeAnimationLayout;
import com.cupidapp.live.liveshow.view.shake.InsertShakeCommentEvent;
import com.cupidapp.live.liveshow.view.starchallenge.StarChallengeChestView;
import com.cupidapp.live.liveshow.view.starchallenge.StarChallengeLvlUpgradeLayout;
import com.cupidapp.live.liveshow.view.sticker.LiveStickerEditMaskLayout;
import com.cupidapp.live.liveshow.view.summary.FKLiveEndLayout;
import com.cupidapp.live.liveshow.view.summary.FKLiveForStreamerSummaryLayout;
import com.cupidapp.live.liveshow.view.summary.FKLiveForViewerSummaryLayout;
import com.cupidapp.live.liveshow.view.tag.LiveShowRankTagListLayout;
import com.cupidapp.live.liveshow.view.viewerenter.FKLiveViewerEnterCarLayout;
import com.cupidapp.live.liveshow.view.viewerenter.FKLiveViewerEnterDefaultLayout;
import com.cupidapp.live.liveshow.view.viewerenter.LiveViewerRightEnterAnimatorLayout;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupLiveLog;
import com.irisdt.client.live.LiveProtos;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;
import z0.g;
import z0.y;

/* compiled from: FKLiveForViewerFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveForViewerFragment extends FKBaseFragment implements com.cupidapp.live.liveshow.entity.a {

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public static final a f15014v = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public boolean f15016f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public FKLiveRequestConnectFragment f15017g;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public String f15020j;

    /* renamed from: l, reason: collision with root package name */
    public boolean f15022l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.base.utils.i f15023m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f15024n;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    public FKLiveShowCommentEditTextLayout f15026p;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public GiftModel f15028r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public String f15029s;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15031u = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    public boolean f15015e = true;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Lazy f15018h = kotlin.c.b(new Function0<FKGRPCMessageIdCounter>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$grpcMessageIdCounter$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKGRPCMessageIdCounter invoke() {
            return new FKGRPCMessageIdCounter();
        }
    });

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f15019i = kotlin.c.b(new Function0<LiveInRoomSensorModel>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$liveInRoomSensorModel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final LiveInRoomSensorModel invoke() {
            Bundle arguments = FKLiveForViewerFragment.this.getArguments();
            if (arguments != null) {
                return (LiveInRoomSensorModel) g.b(arguments, LiveInRoomSensorModel.class);
            }
            return null;
        }
    });

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.liveshow.entity.c f15021k = new i();

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public final Lazy f15025o = kotlin.c.b(new Function0<FKFanClubManager>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$fanClubManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKFanClubManager invoke() {
            Context context = FKLiveForViewerFragment.this.getContext();
            FragmentManager parentFragmentManager = FKLiveForViewerFragment.this.getParentFragmentManager();
            s.h(parentFragmentManager, "parentFragmentManager");
            return new FKFanClubManager(context, parentFragmentManager);
        }
    });

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public LiveConnectStatus f15027q = LiveConnectStatus.Request;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public final Lazy f15030t = kotlin.c.b(new Function0<SendGiftHelper>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$sendGiftHelper$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final SendGiftHelper invoke() {
            return new SendGiftHelper();
        }
    });

    /* compiled from: FKLiveForViewerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKLiveForViewerFragment a(@Nullable LiveInRoomSensorModel liveInRoomSensorModel) {
            FKLiveForViewerFragment fKLiveForViewerFragment = new FKLiveForViewerFragment();
            Bundle bundle = new Bundle();
            if (liveInRoomSensorModel != null) {
                z0.g.d(bundle, liveInRoomSensorModel);
            }
            fKLiveForViewerFragment.setArguments(bundle);
            return fKLiveForViewerFragment;
        }
    }

    /* compiled from: FKLiveForViewerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15032a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f15033b;

        static {
            int[] iArr = new int[FKLivePkStatus.values().length];
            try {
                iArr[FKLivePkStatus.LivePkStart.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FKLivePkStatus.LivePkInProgress.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FKLivePkStatus.LivePkInteractive.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f15032a = iArr;
            int[] iArr2 = new int[FKLiveType.values().length];
            try {
                iArr2[FKLiveType.PK.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[FKLiveType.MULTI_PK.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FKLiveType.CHAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            f15033b = iArr2;
        }
    }

    /* compiled from: FKLiveForViewerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements com.cupidapp.live.liveshow.view.summary.b {
        public c() {
        }

        @Override // com.cupidapp.live.liveshow.view.summary.b
        public void a(@NotNull AnchorModel anchor) {
            s.i(anchor, "anchor");
            FKLiveMiniProfilePhotoFragment.f15759g.a(FKLiveForViewerFragment.this.getParentFragmentManager(), new FKMiniProfilePhotoViewModel(anchor.getPopularFeedList(), anchor.getUser()));
        }

        @Override // com.cupidapp.live.liveshow.view.summary.b
        public void b() {
            FragmentActivity activity = FKLiveForViewerFragment.this.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    /* compiled from: FKLiveForViewerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class d implements com.cupidapp.live.liveshow.view.remoteconnect.view.b {
        public d() {
        }

        @Override // com.cupidapp.live.liveshow.view.remoteconnect.view.b
        public void a() {
            FKLiveForViewerFragment.this.f15027q = LiveConnectStatus.Request;
            ((LiveConnectEntranceView) FKLiveForViewerFragment.this.S0(R$id.live_connect_view)).b(FKLiveForViewerFragment.this.f15027q);
        }

        @Override // com.cupidapp.live.liveshow.view.remoteconnect.view.b
        public void b() {
            FKLiveRequestConnectFragment fKLiveRequestConnectFragment = FKLiveForViewerFragment.this.f15017g;
            if (fKLiveRequestConnectFragment != null) {
                fKLiveRequestConnectFragment.dismiss();
            }
        }

        @Override // com.cupidapp.live.liveshow.view.remoteconnect.view.b
        public void c(boolean z10) {
            FKLiveForViewerFragment.this.f15016f = z10;
            GiftCollectionLayout giftCollectionLayout = (GiftCollectionLayout) FKLiveForViewerFragment.this.S0(R$id.viewer_gift_collection_layout);
            if (giftCollectionLayout != null) {
                giftCollectionLayout.g(!z10);
            }
        }

        @Override // com.cupidapp.live.liveshow.view.remoteconnect.view.b
        public void d() {
            b.a.c(this);
        }

        @Override // com.cupidapp.live.liveshow.view.remoteconnect.view.b
        public void e() {
            b.a.b(this);
        }
    }

    /* compiled from: FKLiveForViewerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class e implements com.cupidapp.live.liveshow.view.comment.f {

        /* compiled from: FKLiveForViewerFragment.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f15040a;

            static {
                int[] iArr = new int[LiveCommentGuideType.values().length];
                try {
                    iArr[LiveCommentGuideType.AlohaType.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LiveCommentGuideType.ChatType.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[LiveCommentGuideType.SendGiftType.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f15040a = iArr;
            }
        }

        public e() {
        }

        @Override // com.cupidapp.live.liveshow.view.comment.f
        public void a(@NotNull LiveCommentGuideType messageType) {
            s.i(messageType, "messageType");
            int i10 = a.f15040a[messageType.ordinal()];
            if (i10 == 1) {
                FKLiveForViewerFragment.this.H1();
                return;
            }
            if (i10 == 2) {
                FKLiveForViewerFragment.q2(FKLiveForViewerFragment.this, true, null, 2, null);
            } else {
                if (i10 != 3) {
                    return;
                }
                FKLiveForViewerFragment.this.f15029s = null;
                FKLiveForViewerFragment.h2(FKLiveForViewerFragment.this, null, null, 3, null);
            }
        }
    }

    /* compiled from: FKLiveForViewerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class f implements com.cupidapp.live.liveshow.pk.view.i {
        public f() {
        }

        @Override // com.cupidapp.live.liveshow.pk.view.i
        public void a() {
            FKLiveForViewerFragment fKLiveForViewerFragment = FKLiveForViewerFragment.this;
            int i10 = R$id.viewerLiveTextureView;
            TextureView textureView = (TextureView) fKLiveForViewerFragment.S0(i10);
            if (textureView != null) {
                textureView.setVisibility(0);
            }
            LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
            if (liveShowModel != null) {
                FKLiveForViewerFragment fKLiveForViewerFragment2 = FKLiveForViewerFragment.this;
                liveShowModel.setMultiPkInfo(null);
                liveShowModel.setMixStreamId(null);
                FKLiveUtil.D(FKLiveUtil.f14913a, liveShowModel.getStreamId(), (TextureView) fKLiveForViewerFragment2.S0(i10), null, null, 12, null);
            }
            ((LiveStickerEditMaskLayout) FKLiveForViewerFragment.this.S0(R$id.viewer_sticker_edit_mask_layout)).setCanDisplaySticker(true);
            FKLiveForViewerFragment.this.C2(false);
            FKLiveForViewerFragment.this.m2(false);
        }

        @Override // com.cupidapp.live.liveshow.pk.view.i
        public void b() {
            FKLiveForViewerFragment.this.R1();
        }
    }

    /* compiled from: FKLiveForViewerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class g implements com.cupidapp.live.liveshow.view.giftpicker.fragment.a {
        public g() {
        }

        @Override // com.cupidapp.live.liveshow.view.giftpicker.fragment.a
        public void a() {
            FKLiveForViewerFragment.this.f15029s = null;
            if (FKLiveForViewerFragment.this.f15028r == null) {
                return;
            }
            FKLiveForViewerFragment fKLiveForViewerFragment = FKLiveForViewerFragment.this;
            GiftModel giftModel = fKLiveForViewerFragment.f15028r;
            String itemId = giftModel != null ? giftModel.getItemId() : null;
            GiftModel giftModel2 = FKLiveForViewerFragment.this.f15028r;
            fKLiveForViewerFragment.g2(itemId, giftModel2 != null ? giftModel2.getFenceId() : null);
        }
    }

    /* compiled from: FKLiveForViewerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class h implements com.cupidapp.live.liveshow.view.giftpicker.fragment.b {
        public h() {
        }

        @Override // com.cupidapp.live.liveshow.view.giftpicker.fragment.b
        public void a() {
            FKLiveCommentLayout fKLiveCommentLayout = (FKLiveCommentLayout) FKLiveForViewerFragment.this.S0(R$id.viewerLiveCommentLayout);
            if (fKLiveCommentLayout != null) {
                fKLiveCommentLayout.setVisibility(0);
            }
            FKLiveForViewerBottomMenuLayout fKLiveForViewerBottomMenuLayout = (FKLiveForViewerBottomMenuLayout) FKLiveForViewerFragment.this.S0(R$id.viewerLiveMenuLayout);
            if (fKLiveForViewerBottomMenuLayout != null) {
                fKLiveForViewerBottomMenuLayout.setVisibility(0);
            }
            FKLivePkWarLayout fKLivePkWarLayout = (FKLivePkWarLayout) FKLiveForViewerFragment.this.S0(R$id.viewerLivePkWarLayout);
            if (fKLivePkWarLayout != null) {
                fKLivePkWarLayout.C(false);
            }
        }

        @Override // com.cupidapp.live.liveshow.view.giftpicker.fragment.b
        public void b(@NotNull GiftItemModel gift, @Nullable String str, int i10) {
            s.i(gift, "gift");
            FKLiveForViewerFragment.this.f15028r = gift instanceof GiftModel ? (GiftModel) gift : null;
            FKLiveForViewerFragment fKLiveForViewerFragment = FKLiveForViewerFragment.this;
            fKLiveForViewerFragment.k2(gift, str, i10, fKLiveForViewerFragment.f15029s);
        }
    }

    /* compiled from: FKLiveForViewerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class i extends com.cupidapp.live.liveshow.entity.c {
        public i() {
        }

        @Override // com.cupidapp.live.liveshow.entity.c, com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
        public void onPlayStateUpdate(int i10, @Nullable String str) {
            super.onPlayStateUpdate(i10, str);
            FKLiveForViewerFragment.this.b2(i10, str);
        }
    }

    /* compiled from: FKLiveForViewerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class j implements com.cupidapp.live.liveshow.view.giftpicker.helper.c {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GiftItemModel f15046b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f15047c;

        public j(GiftItemModel giftItemModel, int i10) {
            this.f15046b = giftItemModel;
            this.f15047c = i10;
        }

        @Override // com.cupidapp.live.liveshow.view.giftpicker.helper.c
        public void a(@Nullable String str) {
            FKLiveForViewerFragment.this.r2(this.f15046b, this.f15047c, str);
        }

        @Override // com.cupidapp.live.liveshow.view.giftpicker.helper.c
        public void b() {
            FKLiveForViewerFragment.this.X1();
        }
    }

    /* compiled from: FKLiveForViewerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class k implements com.cupidapp.live.liveshow.view.comment.e {
        public k() {
        }

        @Override // com.cupidapp.live.liveshow.view.comment.e
        public void a() {
            FKLiveForViewerFragment.this.W1();
        }

        @Override // com.cupidapp.live.liveshow.view.comment.e
        public void b(boolean z10, @NotNull CommentModel comment, boolean z11) {
            s.i(comment, "comment");
            FKLiveForViewerFragment.this.G1(z10, comment, z11);
        }
    }

    /* compiled from: FKLiveForViewerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class l implements com.cupidapp.live.liveshow.view.giftpicker.view.c {
        public l() {
        }

        @Override // com.cupidapp.live.liveshow.view.giftpicker.view.c
        public void a() {
            FKLiveForViewerFragment.this.X1();
        }

        @Override // com.cupidapp.live.liveshow.view.giftpicker.view.c
        public void b(@NotNull GiftItemModel gift, int i10, @Nullable String str) {
            s.i(gift, "gift");
            FKLiveForViewerFragment.this.k2(gift, null, i10, str);
        }
    }

    /* compiled from: FKLiveForViewerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class m implements com.cupidapp.live.liveshow.view.remoteconnect.fragment.j {
        public m() {
        }

        @Override // com.cupidapp.live.liveshow.view.remoteconnect.fragment.j
        public void a() {
            FKLiveForViewerFragment.this.f15027q = LiveConnectStatus.Wait;
            ((LiveConnectEntranceView) FKLiveForViewerFragment.this.S0(R$id.live_connect_view)).b(FKLiveForViewerFragment.this.f15027q);
        }

        @Override // com.cupidapp.live.liveshow.view.remoteconnect.fragment.j
        public void b() {
            FKLiveForViewerFragment.this.f15027q = LiveConnectStatus.Request;
            ((LiveConnectEntranceView) FKLiveForViewerFragment.this.S0(R$id.live_connect_view)).b(FKLiveForViewerFragment.this.f15027q);
        }
    }

    public static /* synthetic */ void E2(FKLiveForViewerFragment fKLiveForViewerFragment, long j10, List list, List list2, boolean z10, int i10, Object obj) {
        fKLiveForViewerFragment.D2(j10, list, list2, (i10 & 8) != 0 ? true : z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f2(FKLiveForViewerFragment fKLiveForViewerFragment, boolean z10, Function1 function1, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            function1 = null;
        }
        fKLiveForViewerFragment.e2(z10, function1);
    }

    public static /* synthetic */ void h2(FKLiveForViewerFragment fKLiveForViewerFragment, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        fKLiveForViewerFragment.g2(str, str2);
    }

    public static /* synthetic */ void q2(FKLiveForViewerFragment fKLiveForViewerFragment, boolean z10, Integer num, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            num = null;
        }
        fKLiveForViewerFragment.p2(z10, num);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void A(@NotNull KickOutLiveRoomMessageModel messageModel) {
        s.i(messageModel, "messageModel");
        FKLiveUtil.f14913a.m();
        com.cupidapp.live.base.view.h.f12779a.t(messageModel.getEntity().getMessage());
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void A0(@NotNull RefreshFollowLiveStatusMessageModel message) {
        s.i(message, "message");
        ((FollowLiveStatusLayout) S0(R$id.follow_live_status_layout)).q(message.getEntity());
    }

    public final void A2(boolean z10) {
        String itemId;
        ((ConstraintLayout) S0(R$id.viewerContainerLayout)).setVisibility(8);
        if (z10) {
            LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
            if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null) {
                return;
            }
            Disposable disposed = NetworkClient.f11868a.r().x(itemId).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<LiveEndModel, p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$showSummaryForViewerLayout$$inlined$handle$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(LiveEndModel liveEndModel) {
                    m2621invoke(liveEndModel);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2621invoke(LiveEndModel liveEndModel) {
                    LiveEndModel liveEndModel2 = liveEndModel;
                    ((FKLiveEndLayout) FKLiveForViewerFragment.this.S0(R$id.viewer_live_end_layout)).i(liveEndModel2.getAnchorInfo(), liveEndModel2.getRcmdLiveShows());
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$showSummaryForViewerLayout$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    s.i(it, "it");
                    ((FKLiveForViewerSummaryLayout) FKLiveForViewerFragment.this.S0(R$id.viewerLiveForViewerSummaryLayout)).c(R$string.live_show_is_over);
                    return Boolean.TRUE;
                }
            }, this)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                H(disposed);
            }
            s.h(disposed, "disposed");
        } else {
            ((FKLiveForViewerSummaryLayout) S0(R$id.viewerLiveForViewerSummaryLayout)).c(R$string.cannot_watch_this_live);
        }
        FKLiveUtil.f14913a.m();
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void B(@NotNull LivePkAppointRejectConnectMessage livePkAppointRejectConnectMessage) {
        a.C0157a.F(this, livePkAppointRejectConnectMessage);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void B0(@NotNull LiveConnectPushStreamStartMessage liveConnectPushStreamStartMessage) {
        a.C0157a.k(this, liveConnectPushStreamStartMessage);
    }

    public final void B2() {
        com.cupidapp.live.base.utils.i iVar = this.f15023m;
        if (iVar != null) {
            iVar.g();
        }
        this.f15023m = null;
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void C0(@NotNull LiveCriticalHitConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        s2(messageModel.getEntity().getCritInfo());
        ((FKLiveForViewerBottomMenuLayout) S0(R$id.viewerLiveMenuLayout)).p(messageModel.getEntity().getLotteryBtn());
    }

    public final void C2(boolean z10) {
        if (z10) {
            ((FKLiveGiftEnterAnimationLayout) S0(R$id.viewerLiveGiftEnterAnimationLayout)).setTranslationY(((FKLiveGiftEnterAnimationLayout) S0(r3)).getHeight() - z0.h.c(this, 30.0f));
            return;
        }
        ((FKLiveGiftEnterAnimationLayout) S0(R$id.viewerLiveGiftEnterAnimationLayout)).setTranslationY(0.0f);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void D(@NotNull LiveBroadcastConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        FKLiveBroadcastLayout fKLiveBroadcastLayout = (FKLiveBroadcastLayout) S0(R$id.viewerLiveBroadcastLayout);
        if (fKLiveBroadcastLayout != null) {
            fKLiveBroadcastLayout.e(messageModel.getEntity());
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void D0(@NotNull LivePkUpdateConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        ((FKLivePkWarLayout) S0(R$id.viewerLivePkWarLayout)).a0(messageModel);
    }

    public final void D2(long j10, final List<LiveActivityModel> list, final List<BadgeModel> list2, final boolean z10) {
        P1().checkAndUpdate(j10, new Function0<p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$updateLiveActivityLayout$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (z10) {
                    ((FKLiveShowActivityLayout) this.S0(R$id.viewer_live_show_activity_layout)).s(list, true);
                }
                ((FKLiveShowAdLayout) this.S0(R$id.viewer_live_show_ad_layout)).s(list2, true);
            }
        });
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void E(@NotNull RedEnvelopeConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        ((LiveRedEnvelopeView) S0(R$id.viewer_red_envelope_view)).c(messageModel.getEntity());
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void F(@NotNull LiveStickerUpdateConnectorMessageModel message) {
        s.i(message, "message");
        ((LiveStickerEditMaskLayout) S0(R$id.viewer_sticker_edit_mask_layout)).r(true, message.getEntity());
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void F0(@NotNull MultiPkAgreeInvitingModel messageModel) {
        s.i(messageModel, "messageModel");
        ((MultiPkForViewerLayout) S0(R$id.viewer_multi_pk_layout)).i(messageModel.getPkLiveShowId(), messageModel.getPkUser());
    }

    public final void F1(FKLiveMessageViewModel fKLiveMessageViewModel) {
        FKLiveCommentMessageViewModel fKLiveCommentMessageViewModel = fKLiveMessageViewModel instanceof FKLiveCommentMessageViewModel ? (FKLiveCommentMessageViewModel) fKLiveMessageViewModel : null;
        if (fKLiveCommentMessageViewModel != null && fKLiveCommentMessageViewModel.getCommentModel().getBarrage()) {
            ((FKLiveBarrageLayout) S0(R$id.viewerLiveBarrageLayout)).e(fKLiveCommentMessageViewModel.getCommentModel());
        }
        FKLiveCommentLayout fKLiveCommentLayout = (FKLiveCommentLayout) S0(R$id.viewerLiveCommentLayout);
        if (fKLiveCommentLayout != null) {
            fKLiveCommentLayout.e(fKLiveMessageViewModel);
        }
    }

    public final void G1(boolean z10, CommentModel commentModel, boolean z11) {
        if (z10) {
            F1(new FKLiveCommentMessageViewModel(commentModel, z10));
        }
        if (z11) {
            ((FKLiveCommentLayout) S0(R$id.viewerLiveCommentLayout)).d(LiveCommentGuideType.AlohaType);
        }
    }

    public final void H1() {
        final LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel != null) {
            if (liveShowModel.getUser().getAloha()) {
                com.cupidapp.live.base.view.h.f12779a.q(R$string.has_followed);
                return;
            }
            Disposable disposed = a.C0836a.o(NetworkClient.f11868a.N(), liveShowModel.getUser().userId(), null, liveShowModel.getItemId(), FollowPrefer.LiveShow.getValue(), 0, null, null, null, 242, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<SwipeCardUserLikeResult, p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$alohaActor$lambda$1$$inlined$handle$default$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                    m2613invoke(swipeCardUserLikeResult);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2613invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                    LiveShowModel.this.getUser().setAloha(true);
                    ((FKActorInfoAndAudienceLayout) this.S0(R$id.viewerLiveActorUserInfoLayout)).setFollowView(swipeCardUserLikeResult.getUser());
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                H(disposed);
            }
            s.h(disposed, "disposed");
        }
    }

    public final void I1() {
        ImageView closeViewerLiveShowImageView = (ImageView) S0(R$id.closeViewerLiveShowImageView);
        s.h(closeViewerLiveShowImageView, "closeViewerLiveShowImageView");
        y.d(closeViewerLiveShowImageView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$bindClickEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                FKLiveForViewerFragment.this.L1();
            }
        });
        ((FKLiveForViewerBottomMenuLayout) S0(R$id.viewerLiveMenuLayout)).setClickListener(new FKLiveForViewerBottomMenuLayout.a() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$bindClickEvent$2
            @Override // com.cupidapp.live.liveshow.view.bottommenu.FKLiveForViewerBottomMenuLayout.a
            public void a() {
                FKLiveForViewerFragment.this.v2();
            }

            @Override // com.cupidapp.live.liveshow.view.bottommenu.FKLiveForViewerBottomMenuLayout.a
            public void b() {
                PopupInfoModel popupInfo;
                LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
                if (fkLiveShowResult == null || (popupInfo = fkLiveShowResult.getPopupInfo()) == null) {
                    return;
                }
                FKLiveForViewerFragment fKLiveForViewerFragment = FKLiveForViewerFragment.this;
                fKLiveForViewerFragment.B2();
                fKLiveForViewerFragment.j2(popupInfo.getUrl());
            }

            @Override // com.cupidapp.live.liveshow.view.bottommenu.FKLiveForViewerBottomMenuLayout.a
            public void c() {
                final FKLiveForViewerFragment fKLiveForViewerFragment = FKLiveForViewerFragment.this;
                fKLiveForViewerFragment.e2(false, new Function1<Integer, p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$bindClickEvent$2$fanClubClick$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Integer num) {
                        invoke(num.intValue());
                        return p.f51048a;
                    }

                    public final void invoke(int i10) {
                        ((FKLiveForViewerBottomMenuLayout) FKLiveForViewerFragment.this.S0(R$id.viewerLiveMenuLayout)).setFanClubBtnStatus(i10);
                    }
                });
            }

            @Override // com.cupidapp.live.liveshow.view.bottommenu.FKLiveForViewerBottomMenuLayout.a
            public void d() {
                FKLiveForViewerFragment.this.f15029s = null;
                FKLiveForViewerFragment.h2(FKLiveForViewerFragment.this, null, null, 3, null);
            }

            @Override // com.cupidapp.live.liveshow.view.bottommenu.FKLiveForViewerBottomMenuLayout.a
            public void e() {
                SensorsLogKeyButtonClick.LiveShowRoom.MessageBox.click();
                ((FKLiveGiftAnimationLayout) FKLiveForViewerFragment.this.S0(R$id.viewerLiveGiftAnimationLayout)).setResumeOrStopPlayGiftAnimation(true);
                FKLiveForViewerFragment.q2(FKLiveForViewerFragment.this, false, null, 2, null);
            }

            @Override // com.cupidapp.live.liveshow.view.bottommenu.FKLiveForViewerBottomMenuLayout.a
            public void f(int i10) {
                QuickGiftModel quickGift;
                LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
                if (fkLiveShowResult == null || (quickGift = fkLiveShowResult.getQuickGift()) == null) {
                    return;
                }
                FKLiveForViewerFragment fKLiveForViewerFragment = FKLiveForViewerFragment.this;
                fKLiveForViewerFragment.X1();
                n1.a.f52091a.a(fKLiveForViewerFragment.getContext(), 100L);
                ((QuickGiftAnimationLayout) fKLiveForViewerFragment.S0(R$id.quick_gift_animation_layout)).s(quickGift, i10);
            }
        });
        ((FKLiveForViewerSummaryLayout) S0(R$id.viewerLiveForViewerSummaryLayout)).b(new Function0<p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$bindClickEvent$3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FragmentActivity activity = FKLiveForViewerFragment.this.getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                }
            }
        });
        ((FKLiveEndLayout) S0(R$id.viewer_live_end_layout)).setListener(new c());
        ((LiveConnectLayout) S0(R$id.viewer_connect_layout)).setConnectListener(new d());
        ((FKLivePkWarLayout) S0(R$id.viewerLivePkWarLayout)).setFKLivePkWarCallback(new com.cupidapp.live.liveshow.pk.view.c() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$bindClickEvent$6
            @Override // com.cupidapp.live.liveshow.pk.view.c
            public void a(int i10, int i11) {
                ((TextureView) FKLiveForViewerFragment.this.S0(R$id.viewerLiveTextureView)).setVisibility(8);
                ((LiveStickerEditMaskLayout) FKLiveForViewerFragment.this.S0(R$id.viewer_sticker_edit_mask_layout)).setCanDisplaySticker(false);
            }

            @Override // com.cupidapp.live.liveshow.pk.view.c
            public void b(final boolean z10) {
                FKLivePkStatusAnimationLayout fKLivePkStatusAnimationLayout = (FKLivePkStatusAnimationLayout) FKLiveForViewerFragment.this.S0(R$id.viewerPkStatusAnimationLayout);
                final FKLiveForViewerFragment fKLiveForViewerFragment = FKLiveForViewerFragment.this;
                fKLivePkStatusAnimationLayout.c(z10, new Function0<p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$bindClickEvent$6$showPkStatusAnimation$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ p invoke() {
                        invoke2();
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        FKLivePkWarLayout fKLivePkWarLayout = (FKLivePkWarLayout) FKLiveForViewerFragment.this.S0(R$id.viewerLivePkWarLayout);
                        if (fKLivePkWarLayout != null) {
                            fKLivePkWarLayout.O(z10);
                        }
                    }
                });
            }

            @Override // com.cupidapp.live.liveshow.pk.view.c
            public void c(int i10) {
            }

            @Override // com.cupidapp.live.liveshow.pk.view.c
            public void d() {
                FKLiveForViewerFragment fKLiveForViewerFragment = FKLiveForViewerFragment.this;
                int i10 = R$id.viewerLiveTextureView;
                ((TextureView) fKLiveForViewerFragment.S0(i10)).setVisibility(0);
                FKLiveUtil fKLiveUtil = FKLiveUtil.f14913a;
                LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
                String streamId = liveShowModel != null ? liveShowModel.getStreamId() : null;
                TextureView viewerLiveTextureView = (TextureView) FKLiveForViewerFragment.this.S0(i10);
                s.h(viewerLiveTextureView, "viewerLiveTextureView");
                fKLiveUtil.M(streamId, viewerLiveTextureView);
                ((LiveStickerEditMaskLayout) FKLiveForViewerFragment.this.S0(R$id.viewer_sticker_edit_mask_layout)).setCanDisplaySticker(true);
            }
        });
        ((FKActorInfoAndAudienceLayout) S0(R$id.viewerLiveActorUserInfoLayout)).setListener(new com.cupidapp.live.liveshow.view.liveinfo.b() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$bindClickEvent$7
            @Override // com.cupidapp.live.liveshow.view.liveinfo.b
            public void c() {
                final FKLiveForViewerFragment fKLiveForViewerFragment = FKLiveForViewerFragment.this;
                fKLiveForViewerFragment.e2(true, new Function1<Integer, p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$bindClickEvent$7$fanClubClick$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Integer num) {
                        invoke(num.intValue());
                        return p.f51048a;
                    }

                    public final void invoke(int i10) {
                        ((FKLiveForViewerBottomMenuLayout) FKLiveForViewerFragment.this.S0(R$id.viewerLiveMenuLayout)).setFanClubBtnStatus(i10);
                    }
                });
            }
        });
        ((FKLiveCommentLayout) S0(R$id.viewerLiveCommentLayout)).setListener(new e());
        LiveCommentGuideHelper.f15387a.g(new Function1<LiveCommentGuideType, p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$bindClickEvent$9
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LiveCommentGuideType liveCommentGuideType) {
                invoke2(liveCommentGuideType);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull LiveCommentGuideType type) {
                FKLiveShowCommentEditTextLayout fKLiveShowCommentEditTextLayout;
                s.i(type, "type");
                if (type == LiveCommentGuideType.AlohaAlertType) {
                    fKLiveShowCommentEditTextLayout = FKLiveForViewerFragment.this.f15026p;
                    if ((fKLiveShowCommentEditTextLayout != null && fKLiveShowCommentEditTextLayout.p()) || FKLiveGiftPickerFragment.f15447n.b()) {
                        return;
                    }
                    LiveAlohaActorGuideLayout.a aVar = LiveAlohaActorGuideLayout.f15382f;
                    Context context = FKLiveForViewerFragment.this.getContext();
                    final FKLiveForViewerFragment fKLiveForViewerFragment = FKLiveForViewerFragment.this;
                    aVar.a(context, new Function0<p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$bindClickEvent$9.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ p invoke() {
                            invoke2();
                            return p.f51048a;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            FKLiveForViewerFragment.this.H1();
                        }
                    });
                    return;
                }
                FKLiveCommentLayout fKLiveCommentLayout = (FKLiveCommentLayout) FKLiveForViewerFragment.this.S0(R$id.viewerLiveCommentLayout);
                if (fKLiveCommentLayout != null) {
                    fKLiveCommentLayout.d(type);
                }
            }
        });
        LiveConnectEntranceView live_connect_view = (LiveConnectEntranceView) S0(R$id.live_connect_view);
        s.h(live_connect_view, "live_connect_view");
        y.d(live_connect_view, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$bindClickEvent$10
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0083  */
            /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(@org.jetbrains.annotations.Nullable android.view.View r9) {
                /*
                    r8 = this;
                    com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment r9 = com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment.this
                    boolean r9 = com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment.i1(r9)
                    if (r9 == 0) goto L2a
                    com.cupidapp.live.liveshow.constants.FKLiveConstantsData r9 = com.cupidapp.live.liveshow.constants.FKLiveConstantsData.INSTANCE
                    com.cupidapp.live.liveshow.model.LiveShowModel r9 = r9.getRemoteConnectLiveShow()
                    r0 = 1
                    r1 = 0
                    if (r9 == 0) goto L19
                    boolean r9 = r9.isRemoteConnect()
                    if (r9 != r0) goto L19
                    goto L1a
                L19:
                    r0 = 0
                L1a:
                    if (r0 == 0) goto L2a
                    com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment r9 = com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment.this
                    int r0 = com.cupidapp.live.R$id.viewer_connect_layout
                    android.view.View r9 = r9.S0(r0)
                    com.cupidapp.live.liveshow.view.remoteconnect.view.LiveConnectLayout r9 = (com.cupidapp.live.liveshow.view.remoteconnect.view.LiveConnectLayout) r9
                    r9.D()
                    goto L7b
                L2a:
                    com.cupidapp.live.liveshow.constants.FKLiveConstantsData r9 = com.cupidapp.live.liveshow.constants.FKLiveConstantsData.INSTANCE
                    com.cupidapp.live.liveshow.model.LiveShowModel r9 = r9.getLiveShowModel()
                    if (r9 == 0) goto L7b
                    com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment r0 = com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment.this
                    com.cupidapp.live.base.network.NetworkClient r1 = com.cupidapp.live.base.network.NetworkClient.f11868a
                    u2.a r1 = r1.r()
                    java.lang.String r9 = r9.getItemId()
                    io.reactivex.Observable r9 = r1.w0(r9)
                    r1 = 0
                    com.cupidapp.live.base.network.i r2 = new com.cupidapp.live.base.network.i
                    r2.<init>()
                    io.reactivex.Observable r9 = r9.flatMap(r2)
                    io.reactivex.Scheduler r2 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
                    io.reactivex.Observable r9 = r9.observeOn(r2)
                    com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$bindClickEvent$10$invoke$lambda$1$$inlined$handle$default$1 r2 = new com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$bindClickEvent$10$invoke$lambda$1$$inlined$handle$default$1
                    r2.<init>()
                    com.cupidapp.live.base.network.e r3 = new com.cupidapp.live.base.network.e
                    r3.<init>(r2)
                    com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2 r2 = new com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2
                    r2.<init>(r1, r0)
                    com.cupidapp.live.base.network.e r1 = new com.cupidapp.live.base.network.e
                    r1.<init>(r2)
                    io.reactivex.disposables.Disposable r9 = r9.subscribe(r3, r1)
                    java.lang.String r1 = "disposed"
                    if (r9 == 0) goto L78
                    kotlin.jvm.internal.s.h(r9, r1)
                    if (r0 == 0) goto L78
                    r0.H(r9)
                L78:
                    kotlin.jvm.internal.s.h(r9, r1)
                L7b:
                    com.cupidapp.live.liveshow.constants.FKLiveConstantsData r9 = com.cupidapp.live.liveshow.constants.FKLiveConstantsData.INSTANCE
                    com.cupidapp.live.liveshow.model.LiveShowModel r9 = r9.getLiveShowModel()
                    if (r9 == 0) goto L9b
                    com.cupidapp.live.base.sensorslog.SensorsLogLiveShow r0 = com.cupidapp.live.base.sensorslog.SensorsLogLiveShow.f12212a
                    java.lang.String r1 = r9.getItemId()
                    com.cupidapp.live.profile.model.User r9 = r9.getUser()
                    java.lang.String r2 = r9.userId()
                    com.irisdt.client.live.LiveProtos$Type r3 = com.irisdt.client.live.LiveProtos.Type.CONNECT
                    r4 = 0
                    r5 = 0
                    r6 = 24
                    r7 = 0
                    com.cupidapp.live.base.sensorslog.SensorsLogLiveShow.g(r0, r1, r2, r3, r4, r5, r6, r7)
                L9b:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$bindClickEvent$10.invoke2(android.view.View):void");
            }
        });
        ((FKLiveGiftEnterAnimationLayout) S0(R$id.viewerLiveGiftEnterAnimationLayout)).setGiftEnterAnimationFinished(new Function0<p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$bindClickEvent$11
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FKLiveForViewerFragment.this.m2(false);
            }
        });
        ((QuickGiftAnimationLayout) S0(R$id.quick_gift_animation_layout)).setRefreshQuickGift(new Function1<QuickGiftModel, p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$bindClickEvent$12
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(QuickGiftModel quickGiftModel) {
                invoke2(quickGiftModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QuickGiftModel it) {
                s.i(it, "it");
                ((FKLiveForViewerBottomMenuLayout) FKLiveForViewerFragment.this.S0(R$id.viewerLiveMenuLayout)).q(it);
            }
        });
    }

    public final void J1() {
        ((MultiPkForViewerLayout) S0(R$id.viewer_multi_pk_layout)).setMultiPkForViewerListener(new f());
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void K(@NotNull MultiPkCancelPrepareModel messageModel) {
        s.i(messageModel, "messageModel");
        String liveShowId = messageModel.getLiveShowId();
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        boolean d10 = s.d(liveShowId, liveShowModel != null ? liveShowModel.getItemId() : null);
        if (!messageModel.isInitiator() && !d10) {
            ((MultiPkForViewerLayout) S0(R$id.viewer_multi_pk_layout)).C(messageModel.getLiveShowId());
            return;
        }
        MultiPkForViewerLayout viewer_multi_pk_layout = (MultiPkForViewerLayout) S0(R$id.viewer_multi_pk_layout);
        s.h(viewer_multi_pk_layout, "viewer_multi_pk_layout");
        MultiPkForViewerLayout.r(viewer_multi_pk_layout, false, 1, null);
    }

    public final void K1(float f10) {
        List<View> N1 = N1();
        if (N1 != null) {
            Iterator<View> iterator2 = N1.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().setTranslationX(f10);
            }
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void L0(@NotNull LiveAnchorPrivilegeEndUseConnectorMessage liveAnchorPrivilegeEndUseConnectorMessage) {
        a.C0157a.d(this, liveAnchorPrivilegeEndUseConnectorMessage);
    }

    public final void L1() {
        User user;
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
        if (liveShowModel == null || (user = liveShowModel.getUser()) == null) {
            return;
        }
        LiveShowModel liveShowModel2 = fKLiveConstantsData.getLiveShowModel();
        if ((liveShowModel2 != null ? s.d(liveShowModel2.isObsStream(), Boolean.TRUE) : false) && user.getMe()) {
            o2();
            return;
        }
        this.f15020j = "直播间点叉";
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void M(@NotNull ViewerLeaveConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        FKActorInfoAndAudienceLayout fKActorInfoAndAudienceLayout = (FKActorInfoAndAudienceLayout) S0(R$id.viewerLiveActorUserInfoLayout);
        ViewerLeaveModel entity = messageModel.getEntity();
        fKActorInfoAndAudienceLayout.z(entity != null ? entity.getUserId() : null);
    }

    public final boolean M1() {
        List<LiveShowModel> connectLive;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        LiveShowModel liveShowModel2 = null;
        if (liveShowModel != null && (connectLive = liveShowModel.getConnectLive()) != null) {
            Iterator<LiveShowModel> iterator2 = connectLive.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                LiveShowModel next = iterator2.next();
                if (next.isRemoteConnect()) {
                    liveShowModel2 = next;
                    break;
                }
            }
            liveShowModel2 = liveShowModel2;
        }
        if (liveShowModel2 == null) {
            return false;
        }
        ((LiveConnectLayout) S0(R$id.viewer_connect_layout)).C();
        return true;
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void N(@NotNull LiveEndConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        String message = messageModel.getEntity().getMessage();
        String style = messageModel.getEntity().getStyle();
        if (!(message == null || message.length() == 0)) {
            if (!(style == null || style.length() == 0) && s.d(style, "alert")) {
                FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, getContext(), false, 2, null).n(message), 0, null, null, 7, null), null, 1, null);
            }
        }
        ((FKLiveEndLayout) S0(R$id.viewer_live_end_layout)).i(messageModel.getEntity().getAnchorInfo(), messageModel.getEntity().getRcmdLiveShows());
        FKLiveUtil.f14913a.m();
        if (FKLiveConstantsData.INSTANCE.getRemoteConnectLiveShow() != null) {
            ((LiveConnectLayout) S0(R$id.viewer_connect_layout)).y();
        }
        FollowLiveStatusLayout.f15289g.k();
        com.cupidapp.live.base.fragment.b.f11807a.b();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f15031u.clear();
    }

    public final List<View> N1() {
        if (!isResumed() || a2()) {
            return null;
        }
        return kotlin.collections.s.m((LiveShowRankTagListLayout) S0(R$id.viewer_live_show_tag_layout), (LinearLayout) S0(R$id.pray_layout), (FKLiveTopStartPositionLayout) S0(R$id.viewerLiveTopStartPositionLayout), (FKLiveBarrageLayout) S0(R$id.viewerLiveBarrageLayout), (FKLiveBroadcastLayout) S0(R$id.viewerLiveBroadcastLayout), (FKLiveGiftEnterAnimationLayout) S0(R$id.viewerLiveGiftEnterAnimationLayout), (FrameLayout) S0(R$id.viewerLiveUserEnterDefaultContainerLayout), (FrameLayout) S0(R$id.viewerLiveUserEnterCarContainerLayout), (FKLiveCommentLayout) S0(R$id.viewerLiveCommentLayout), (FKLiveShowAdLayout) S0(R$id.viewer_live_show_ad_layout), (FKLiveShowActivityLayout) S0(R$id.viewer_live_show_activity_layout), (ContinuousSendGiftLayout) S0(R$id.continuous_send_layout), (FKLiveGiftAnimationLayout) S0(R$id.viewerLiveGiftAnimationLayout), (FKLiveShakeAnimationLayout) S0(R$id.viewerLiveShakeAnimationLayout), (QuickGiftAnimationLayout) S0(R$id.quick_gift_animation_layout), (FKLiveGiftAnimationLayout) S0(R$id.common_animation_layout), (FKActorInfoAndAudienceLayout) S0(R$id.viewerLiveActorUserInfoLayout), (FKLiveBaseHornLayout) S0(R$id.liveHornLayout), (FKLiveForViewerBottomMenuLayout) S0(R$id.viewerLiveMenuLayout), (GiftCollectionLayout) S0(R$id.viewer_gift_collection_layout), (LiveConnectEntranceView) S0(R$id.live_connect_view), (LiveViewerRightEnterAnimatorLayout) S0(R$id.right_enter_animator_layout), (FollowLiveStatusLayout) S0(R$id.follow_live_status_layout));
    }

    public final FKFanClubManager O1() {
        return (FKFanClubManager) this.f15025o.getValue();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public boolean P0() {
        return this.f15024n;
    }

    public final FKGRPCMessageIdCounter P1() {
        return (FKGRPCMessageIdCounter) this.f15018h.getValue();
    }

    public final LiveInRoomSensorModel Q1() {
        return (LiveInRoomSensorModel) this.f15019i.getValue();
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void R(@NotNull LiveShowMoreMenuUnreadMessageModel messageModel) {
        LiveMenuBtnModel dressUpBtn;
        s.i(messageModel, "messageModel");
        List<String> list = messageModel.getList();
        if (!(list == null || list.isEmpty())) {
            ((FKLiveForViewerBottomMenuLayout) S0(R$id.viewerLiveMenuLayout)).A(true);
            for (String str : list) {
                if (s.d(str, MenuType.MyOutfit.getType())) {
                    LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
                    dressUpBtn = fkLiveShowResult != null ? fkLiveShowResult.getDressUpBtn() : null;
                    if (dressUpBtn != null) {
                        dressUpBtn.setUnread(true);
                    }
                } else if (s.d(str, MenuType.GiftWall.getType())) {
                    LiveShowResult fkLiveShowResult2 = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
                    dressUpBtn = fkLiveShowResult2 != null ? fkLiveShowResult2.getGiftWall() : null;
                    if (dressUpBtn != null) {
                        dressUpBtn.setUnread(true);
                    }
                } else if (s.d(str, MenuType.FollowLive.getType())) {
                    LiveShowResult fkLiveShowResult3 = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
                    dressUpBtn = fkLiveShowResult3 != null ? fkLiveShowResult3.getStreamFollowBtn() : null;
                    if (dressUpBtn != null) {
                        dressUpBtn.setUnread(true);
                    }
                }
            }
            return;
        }
        ((FKLiveForViewerBottomMenuLayout) S0(R$id.viewerLiveMenuLayout)).s();
    }

    public final void R1() {
        String itemId;
        Boolean bool;
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null) {
            return;
        }
        LiveShowModel liveShowModel2 = fKLiveConstantsData.getLiveShowModel();
        String streamId = liveShowModel2 != null ? liveShowModel2.getStreamId() : null;
        FKLiveUtil fKLiveUtil = FKLiveUtil.f14913a;
        List<String> c4 = fKLiveUtil.c();
        if (c4 == null || c4.isEmpty()) {
            com.cupidapp.live.liveshow.entity.c cVar = this.f15021k;
            TextureView viewerLiveTextureView = (TextureView) S0(R$id.viewerLiveTextureView);
            s.h(viewerLiveTextureView, "viewerLiveTextureView");
            FKLiveUtil.k(fKLiveUtil, cVar, itemId, viewerLiveTextureView, false, 8, null);
            FKLiveGrpcEntity.f14907e.a().o(true, this);
            bool = null;
        } else {
            com.cupidapp.live.liveshow.entity.j c10 = j.a.c(com.cupidapp.live.liveshow.entity.j.f14922f, null, 1, null);
            if (c10 != null) {
                c10.F(this.f15021k);
            }
            TextureView viewerLiveTextureView2 = (TextureView) S0(R$id.viewerLiveTextureView);
            s.h(viewerLiveTextureView2, "viewerLiveTextureView");
            fKLiveUtil.M(streamId, viewerLiveTextureView2);
            FKLiveGrpcEntity.f14907e.a().r(this);
            bool = Boolean.TRUE;
        }
        u2.a r10 = NetworkClient.f11868a.r();
        LiveShowModel liveShowModel3 = fKLiveConstantsData.getLiveShowModel();
        Disposable disposed = r10.g0(itemId, liveShowModel3 != null ? liveShowModel3.getRecommendId() : null, bool).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<LiveShowResult, p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$getLiveInfoData$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LiveShowResult liveShowResult) {
                m2615invoke(liveShowResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2615invoke(LiveShowResult liveShowResult) {
                com.cupidapp.live.liveshow.entity.c cVar2;
                LiveShowResult liveShowResult2 = liveShowResult;
                FKLiveForViewerFragment.this.V1(liveShowResult2, false);
                FKLiveUtil.f14913a.G(liveShowResult2.getCurrentAllStreamIdList());
                FKLivePkWarLayout fKLivePkWarLayout = (FKLivePkWarLayout) FKLiveForViewerFragment.this.S0(R$id.viewerLivePkWarLayout);
                boolean hasPkLive = liveShowResult2.hasPkLive();
                cVar2 = FKLiveForViewerFragment.this.f15021k;
                fKLivePkWarLayout.Q(hasPkLive, true, cVar2);
                FKLiveForViewerFragment.this.n2(liveShowResult2.getClosedAudioLiveShowId());
                LiveConnectLayout viewer_connect_layout = (LiveConnectLayout) FKLiveForViewerFragment.this.S0(R$id.viewer_connect_layout);
                s.h(viewer_connect_layout, "viewer_connect_layout");
                LiveConnectLayout.x(viewer_connect_layout, true, false, false, 6, null);
                if (liveShowResult2.getLiveShow().getMultiPkInfo() != null) {
                    FKLiveForViewerFragment.this.i2(null, liveShowResult2.getLiveShow().getMultiPkInfo());
                    return;
                }
                FKLiveForViewerFragment fKLiveForViewerFragment = FKLiveForViewerFragment.this;
                int i10 = R$id.viewer_multi_pk_layout;
                MultiPkForViewerLayout viewer_multi_pk_layout = (MultiPkForViewerLayout) fKLiveForViewerFragment.S0(i10);
                s.h(viewer_multi_pk_layout, "viewer_multi_pk_layout");
                if (viewer_multi_pk_layout.getVisibility() == 0) {
                    MultiPkForViewerLayout viewer_multi_pk_layout2 = (MultiPkForViewerLayout) FKLiveForViewerFragment.this.S0(i10);
                    s.h(viewer_multi_pk_layout2, "viewer_multi_pk_layout");
                    MultiPkForViewerLayout.r(viewer_multi_pk_layout2, false, 1, null);
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$getLiveInfoData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                if (it instanceof ResultException) {
                    ResultException resultException = (ResultException) it;
                    Integer errorCode = resultException.getErrorCode();
                    int value = RequestErrorCode.KickOutLiveRoom.getValue();
                    if (errorCode != null && errorCode.intValue() == value) {
                        h.f12779a.t(resultException.getErrorMessage());
                        FragmentActivity activity = FKLiveForViewerFragment.this.getActivity();
                        if (activity != null) {
                            activity.finish();
                        }
                        return Boolean.TRUE;
                    }
                }
                FKLiveForViewerFragment.this.U1(it);
                return Boolean.TRUE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void S(@NotNull LiveConnectEndConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        LiveShowModel remoteConnectLiveShow = FKLiveConstantsData.INSTANCE.getRemoteConnectLiveShow();
        if (remoteConnectLiveShow != null && remoteConnectLiveShow.isRemoteConnect()) {
            com.cupidapp.live.base.view.h.f12779a.k(R$string.others_has_hung_up);
            this.f15027q = LiveConnectStatus.Request;
            ((LiveConnectEntranceView) S0(R$id.live_connect_view)).b(this.f15027q);
        }
        ((LiveConnectLayout) S0(R$id.viewer_connect_layout)).y();
    }

    @Nullable
    public View S0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f15031u;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i10)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    @Nullable
    public final String S1() {
        return this.f15020j;
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void T(@NotNull LivePkChatConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        ((FKLivePkWarLayout) S0(R$id.viewerLivePkWarLayout)).X(messageModel, true);
    }

    public final SendGiftHelper T1() {
        return (SendGiftHelper) this.f15030t.getValue();
    }

    public final void U1(Throwable th) {
        FKLiveConstantsData.INSTANCE.setFkLiveType(FKLiveType.FINISH);
        com.cupidapp.live.base.network.j.f12008a.e(th, getActivity(), i0.g(kotlin.f.a(Integer.valueOf(RequestErrorCode.LiveShowIsOver.getValue()), new Function1<String, p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$handleLiveShowResultError$errorCodeHandle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(String str) {
                invoke2(str);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable String str) {
                FKLiveForViewerFragment.this.A2(true);
            }
        }), kotlin.f.a(Integer.valueOf(RequestErrorCode.CannotWatchThisLiveShow.getValue()), new Function1<String, p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$handleLiveShowResultError$errorCodeHandle$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(String str) {
                invoke2(str);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable String str) {
                FKLiveForViewerFragment.this.A2(false);
            }
        })), new Function0<p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$handleLiveShowResultError$handleErrorCallback$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ((FKLiveNetworkErrorLayout) FKLiveForViewerFragment.this.S0(R$id.viewerLiveNetworkErrorLayout)).setVisibility(0);
            }
        });
    }

    public final void V1(LiveShowResult liveShowResult, boolean z10) {
        FKLiveConstantsData.INSTANCE.setFkLiveShowResult(liveShowResult);
        p1.g.f52734a.W1(liveShowResult.getBalance());
        FKActorInfoAndAudienceLayout fKActorInfoAndAudienceLayout = (FKActorInfoAndAudienceLayout) S0(R$id.viewerLiveActorUserInfoLayout);
        LiveShowModel liveShow = liveShowResult.getLiveShow();
        LiveInRoomSensorModel Q1 = Q1();
        fKActorInfoAndAudienceLayout.o(liveShow, Q1 != null ? Q1.getEnterSource() : null);
        fKActorInfoAndAudienceLayout.m(liveShowResult.getAnchorGradeInfo());
        fKActorInfoAndAudienceLayout.s(liveShowResult.getHeatValues());
        fKActorInfoAndAudienceLayout.q(liveShowResult.getAnchorProfileBorder());
        fKActorInfoAndAudienceLayout.t();
        ((FKLiveForStreamerSummaryLayout) S0(R$id.viewerLiveForStreamerSummaryLayout)).d(liveShowResult.getLiveShow().getUser());
        LiveShowModel pkLiveShow = liveShowResult.getPkLiveShow();
        if (pkLiveShow != null) {
            FKLivePkWarLayout viewerLivePkWarLayout = (FKLivePkWarLayout) S0(R$id.viewerLivePkWarLayout);
            s.h(viewerLivePkWarLayout, "viewerLivePkWarLayout");
            FKLivePkWarLayout.F(viewerLivePkWarLayout, liveShowResult.getLiveShow(), pkLiveShow, liveShowResult.getSofa(), liveShowResult.getPkContributionPath(), z10, true, false, 64, null);
        }
        ((FKLiveShowAdLayout) S0(R$id.viewer_live_show_ad_layout)).s(liveShowResult.getAdBadge(), true);
        ((FKLiveShowActivityLayout) S0(R$id.viewer_live_show_activity_layout)).s(liveShowResult.getActivities(), true);
        ((FKLiveCommentLayout) S0(R$id.viewerLiveCommentLayout)).k(liveShowResult);
        List<CommentModel> recentComments = liveShowResult.getRecentComments();
        if (recentComments != null) {
            for (CommentModel commentModel : recentComments) {
                if (commentModel.getBarrage()) {
                    ((FKLiveBarrageLayout) S0(R$id.viewerLiveBarrageLayout)).e(commentModel);
                }
            }
        }
        FKLiveForViewerBottomMenuLayout fKLiveForViewerBottomMenuLayout = (FKLiveForViewerBottomMenuLayout) S0(R$id.viewerLiveMenuLayout);
        PopupInfoModel popupInfo = liveShowResult.getPopupInfo();
        fKLiveForViewerBottomMenuLayout.setLiveRechargePackageButtonVisible(popupInfo != null ? popupInfo.getIcon() : null);
        fKLiveForViewerBottomMenuLayout.G();
        ((LiveShowRankTagListLayout) S0(R$id.viewer_live_show_tag_layout)).a(liveShowResult.getLiveShowTagList());
        ((FKLivePrayBattleView) S0(R$id.viewerLivePrayBattleView)).f(liveShowResult.getLotteryBattleInfo(), liveShowResult.getLotteryBattleNormalInfo(), true);
        s2(liveShowResult.getCritInfo());
        ((GiftCollectionLayout) S0(R$id.viewer_gift_collection_layout)).h(liveShowResult.getGiftCollect());
        ((LiveRedEnvelopeView) S0(R$id.viewer_red_envelope_view)).c(liveShowResult.getRedPacketInfo());
        ((StarChallengeChestView) S0(R$id.viewer_star_challenge_chest_view)).i(liveShowResult.getStarLevelChest(), true);
        LiveConnectEntranceView live_connect_view = (LiveConnectEntranceView) S0(R$id.live_connect_view);
        s.h(live_connect_view, "live_connect_view");
        live_connect_view.setVisibility(liveShowResult.getLiveShow().getAnchorCanConnectLive() ? 0 : 8);
        ((LiveStickerEditMaskLayout) S0(R$id.viewer_sticker_edit_mask_layout)).r(true, liveShowResult.getSticker());
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void W(@NotNull LivePkEndConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        ((FKLivePkWarLayout) S0(R$id.viewerLivePkWarLayout)).Y(true, messageModel);
    }

    public final void W1() {
        FragmentActivity activity = getActivity();
        final FKBaseLiveActivity fKBaseLiveActivity = activity instanceof FKBaseLiveActivity ? (FKBaseLiveActivity) activity : null;
        if (fKBaseLiveActivity != null) {
            fKBaseLiveActivity.w1(new Function2<Integer, Boolean, p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$hideCommentDialog$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ p mo1743invoke(Integer num, Boolean bool) {
                    invoke(num.intValue(), bool.booleanValue());
                    return p.f51048a;
                }

                public final void invoke(int i10, boolean z10) {
                    FKLiveShowCommentEditTextLayout fKLiveShowCommentEditTextLayout;
                    if (z10) {
                        return;
                    }
                    fKLiveShowCommentEditTextLayout = FKLiveForViewerFragment.this.f15026p;
                    if (fKLiveShowCommentEditTextLayout != null) {
                        fKLiveShowCommentEditTextLayout.t();
                    }
                    FKLiveGiftAnimationLayout fKLiveGiftAnimationLayout = (FKLiveGiftAnimationLayout) FKLiveForViewerFragment.this.S0(R$id.viewerLiveGiftAnimationLayout);
                    if (fKLiveGiftAnimationLayout != null) {
                        fKLiveGiftAnimationLayout.setResumeOrStopPlayGiftAnimation(false);
                    }
                    fKBaseLiveActivity.D1();
                }
            });
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void X(@NotNull LivePkCloseAudioConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        LiveShowModel pkLiveShowModel = FKLiveConstantsData.INSTANCE.getPkLiveShowModel();
        if (pkLiveShowModel != null && s.d(messageModel.getEntity().getLiveShowId(), pkLiveShowModel.getItemId())) {
            ((FKLivePkWarLayout) S0(R$id.viewerLivePkWarLayout)).i0(true, messageModel.getEntity().getClose());
            FKLiveUtil.f14913a.w(messageModel.getEntity().getClose(), pkLiveShowModel.getStreamId());
        }
    }

    public final void X1() {
        T1().c();
        ((ContinuousSendGiftLayout) S0(R$id.continuous_send_layout)).a();
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void Y(@NotNull LiveAnchorPrivilegeInUseConnectorMessage liveAnchorPrivilegeInUseConnectorMessage) {
        a.C0157a.f(this, liveAnchorPrivilegeInUseConnectorMessage);
    }

    public final void Y1() {
        String itemId;
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null) {
            return;
        }
        LiveInRoomSensorModel Q1 = Q1();
        Boolean bool = s.d(Q1 != null ? Q1.getEnterSource() : null, "LiveShowEnterMiniLive") ? Boolean.TRUE : null;
        u2.a r10 = NetworkClient.f11868a.r();
        LiveShowModel liveShowModel2 = fKLiveConstantsData.getLiveShowModel();
        Disposable disposed = r10.g0(itemId, liveShowModel2 != null ? liveShowModel2.getRecommendId() : null, bool).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<LiveShowResult, p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$initLiveShowData$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LiveShowResult liveShowResult) {
                m2616invoke(liveShowResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2616invoke(LiveShowResult liveShowResult) {
                com.cupidapp.live.liveshow.entity.c cVar;
                LiveShowResult liveShowResult2 = liveShowResult;
                FragmentActivity activity = FKLiveForViewerFragment.this.getActivity();
                if (activity != null && activity.isFinishing()) {
                    return;
                }
                ((FKActorInfoAndAudienceLayout) FKLiveForViewerFragment.this.S0(R$id.viewerLiveActorUserInfoLayout)).setVisibility(0);
                FKLiveForViewerFragment fKLiveForViewerFragment = FKLiveForViewerFragment.this;
                int i10 = R$id.viewerLiveMenuLayout;
                ((FKLiveForViewerBottomMenuLayout) fKLiveForViewerFragment.S0(i10)).setVisibility(0);
                FKLiveForViewerBottomMenuLayout fKLiveForViewerBottomMenuLayout = (FKLiveForViewerBottomMenuLayout) FKLiveForViewerFragment.this.S0(i10);
                fKLiveForViewerBottomMenuLayout.q(liveShowResult2.getQuickGift());
                fKLiveForViewerBottomMenuLayout.r(liveShowResult2.getLotteryBtn(), liveShowResult2.getFanClubAvailable(), liveShowResult2.getMemberInClubStatus());
                fKLiveForViewerBottomMenuLayout.C(liveShowResult2.getRedPacketHoverText());
                fKLiveForViewerBottomMenuLayout.B(liveShowResult2);
                FKLiveForViewerFragment.this.V1(liveShowResult2, true);
                ((FKLiveTopStartPositionLayout) FKLiveForViewerFragment.this.S0(R$id.viewerLiveTopStartPositionLayout)).b(liveShowResult2.getLiveShow());
                FKLiveUtil fKLiveUtil = FKLiveUtil.f14913a;
                cVar = FKLiveForViewerFragment.this.f15021k;
                String itemId2 = liveShowResult2.getLiveShow().getItemId();
                TextureView viewerLiveTextureView = (TextureView) FKLiveForViewerFragment.this.S0(R$id.viewerLiveTextureView);
                s.h(viewerLiveTextureView, "viewerLiveTextureView");
                FKLiveUtil.k(fKLiveUtil, cVar, itemId2, viewerLiveTextureView, false, 8, null);
                FKLiveForViewerFragment.this.l2();
                FKLiveForViewerFragment.this.w2(liveShowResult2.getPopupInfo());
                LiveCommentGuideHelper.f15387a.j(liveShowResult2.getGuide());
                ((FollowLiveStatusLayout) FKLiveForViewerFragment.this.S0(R$id.follow_live_status_layout)).m(liveShowResult2.getStreamFollowProcessPie());
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$initLiveShowData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                if (it instanceof ResultException) {
                    ResultException resultException = (ResultException) it;
                    Integer errorCode = resultException.getErrorCode();
                    int value = RequestErrorCode.KickOutLiveRoom.getValue();
                    if (errorCode != null && errorCode.intValue() == value) {
                        h.f12779a.t(resultException.getErrorMessage());
                        FragmentActivity activity = FKLiveForViewerFragment.this.getActivity();
                        if (activity != null) {
                            activity.finish();
                        }
                        return Boolean.TRUE;
                    }
                }
                FKLiveForViewerFragment.this.U1(it);
                return Boolean.TRUE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void Z1() {
        Context context = getContext();
        if (context != null) {
            ConstraintLayout viewerLiveActorInfoAndCloseLayout = (ConstraintLayout) S0(R$id.viewerLiveActorInfoAndCloseLayout);
            s.h(viewerLiveActorInfoAndCloseLayout, "viewerLiveActorInfoAndCloseLayout");
            com.cupidapp.live.base.view.s.b(context, viewerLiveActorInfoAndCloseLayout);
        }
        FKLiveGrpcEntity.f14907e.a().r(this);
        FKLiveGiftEnterAnimationLayout fKLiveGiftEnterAnimationLayout = (FKLiveGiftEnterAnimationLayout) S0(R$id.viewerLiveGiftEnterAnimationLayout);
        LiveInRoomSensorModel Q1 = Q1();
        fKLiveGiftEnterAnimationLayout.e(false, Q1 != null ? Q1.getEnterSource() : null);
        ((FKLiveShakeAnimationLayout) S0(R$id.viewerLiveShakeAnimationLayout)).setShakeable(true);
        ((FKLiveGiftAnimationLayout) S0(R$id.viewerLiveGiftAnimationLayout)).e(getActivity());
        ((FKLiveBarrageLayout) S0(R$id.viewerLiveBarrageLayout)).c(false);
        FKLiveForViewerBottomMenuLayout fKLiveForViewerBottomMenuLayout = (FKLiveForViewerBottomMenuLayout) S0(R$id.viewerLiveMenuLayout);
        LiveInRoomSensorModel Q12 = Q1();
        fKLiveForViewerBottomMenuLayout.setEnterSource(Q12 != null ? Q12.getEnterSource() : null);
        FKLiveCommentLayout fKLiveCommentLayout = (FKLiveCommentLayout) S0(R$id.viewerLiveCommentLayout);
        LiveInRoomSensorModel Q13 = Q1();
        fKLiveCommentLayout.h(Q13 != null ? Q13.getEnterSource() : null);
        ((FullLiveVisibleGiftLayout) S0(R$id.viewer_full_live_visible_gift_layout)).g(this);
        ((LiveStickerEditMaskLayout) S0(R$id.viewer_sticker_edit_mask_layout)).w();
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void a(@NotNull StarChallengeLvlUpgradeConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        StarChallengeLvlUpgradeLayout starChallengeLvlUpgradeLayout = (StarChallengeLvlUpgradeLayout) S0(R$id.viewer_star_challenge_lvl_upgrade_layout);
        StarChallengeLvlUpgradeModel entity = messageModel.getEntity();
        starChallengeLvlUpgradeLayout.d(entity != null ? entity.getText() : null);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void a0(@NotNull StarChallengeChestConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        ((StarChallengeChestView) S0(R$id.viewer_star_challenge_chest_view)).i(messageModel.getEntity(), true);
    }

    public final boolean a2() {
        return ((FKLiveForViewerSummaryLayout) S0(R$id.viewerLiveForViewerSummaryLayout)).getVisibility() == 0 || ((FKLiveForStreamerSummaryLayout) S0(R$id.viewerLiveForStreamerSummaryLayout)).getVisibility() == 0 || ((FKLiveNetworkErrorLayout) S0(R$id.viewerLiveNetworkErrorLayout)).getVisibility() == 0 || ((FKLiveEndLayout) S0(R$id.viewer_live_end_layout)).getVisibility() == 0;
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void b(@NotNull LivePkStartConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        FKLiveGrpcEntity.f14907e.a().m(getContext(), new Function1<LiveShowPkWarResult, p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$livePkStartConnector$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LiveShowPkWarResult liveShowPkWarResult) {
                invoke2(liveShowPkWarResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull LiveShowPkWarResult it) {
                com.cupidapp.live.liveshow.entity.c cVar;
                s.i(it, "it");
                FKLivePkWarLayout fKLivePkWarLayout = (FKLivePkWarLayout) FKLiveForViewerFragment.this.S0(R$id.viewerLivePkWarLayout);
                cVar = FKLiveForViewerFragment.this.f15021k;
                fKLivePkWarLayout.Z(it, true, cVar);
            }
        });
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void b0(@NotNull CommentConnectorMessage messageModel, @NotNull ConnectorMessageEvent event) {
        s.i(messageModel, "messageModel");
        s.i(event, "event");
        E2(this, event.getMessage().getMessageId(), messageModel.getActivities(), messageModel.getLiveAdBadge(), false, 8, null);
        F1(new FKLiveCommentMessageViewModel(messageModel.getEntity(), false, 2, null));
        ((FKActorInfoAndAudienceLayout) S0(R$id.viewerLiveActorUserInfoLayout)).k(messageModel.getViewersSeat());
    }

    public final void b2(int i10, String str) {
        MultiPkInfoModel multiPkInfo;
        LiveConnectLayout liveConnectLayout;
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
        if (!s.d(str, liveShowModel != null ? liveShowModel.getStreamId() : null)) {
            LiveShowModel pkLiveShowModel = fKLiveConstantsData.getPkLiveShowModel();
            if (s.d(str, pkLiveShowModel != null ? pkLiveShowModel.getStreamId() : null)) {
                FKLivePkWarLayout fKLivePkWarLayout = (FKLivePkWarLayout) S0(R$id.viewerLivePkWarLayout);
                if (fKLivePkWarLayout != null) {
                    fKLivePkWarLayout.V(str);
                }
                LiveShowResult fkLiveShowResult = fKLiveConstantsData.getFkLiveShowResult();
                n2(fkLiveShowResult != null ? fkLiveShowResult.getClosedAudioLiveShowId() : null);
                return;
            }
            if (i10 != 0) {
                com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "未知 拉流失败 playerCallback streamID:" + str + " errorCode " + i10);
                return;
            }
            com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "未知 拉流成功 playerCallback streamID:" + str);
            return;
        }
        if (i10 != 0) {
            com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "主播 拉流失败 playerCallback streamID:" + str + " errorCode " + i10);
            return;
        }
        com.cupidapp.live.base.utils.j.f12332a.a("ZGEntityLog", "主播 拉流成功 playerCallback streamID:" + str);
        LiveShowResult fkLiveShowResult2 = fKLiveConstantsData.getFkLiveShowResult();
        FKLiveType liveType = fkLiveShowResult2 != null ? fkLiveShowResult2.getLiveType() : null;
        int i11 = liveType == null ? -1 : b.f15033b[liveType.ordinal()];
        if (i11 == 1) {
            int i12 = R$id.viewerLivePkWarLayout;
            FKLivePkWarLayout fKLivePkWarLayout2 = (FKLivePkWarLayout) S0(i12);
            if (fKLivePkWarLayout2 != null) {
                fKLivePkWarLayout2.Q(true, true, this.f15021k);
            }
            FKLivePkWarLayout fKLivePkWarLayout3 = (FKLivePkWarLayout) S0(i12);
            if (fKLivePkWarLayout3 != null) {
                fKLivePkWarLayout3.V(str);
                return;
            }
            return;
        }
        if (i11 != 2) {
            if (i11 == 3 && (liveConnectLayout = (LiveConnectLayout) S0(R$id.viewer_connect_layout)) != null) {
                LiveConnectLayout.x(liveConnectLayout, true, false, false, 6, null);
                return;
            }
            return;
        }
        LiveShowModel liveShowModel2 = fKLiveConstantsData.getLiveShowModel();
        if (liveShowModel2 == null || (multiPkInfo = liveShowModel2.getMultiPkInfo()) == null) {
            return;
        }
        i2(null, multiPkInfo);
    }

    public final void c2(boolean z10) {
        this.f15022l = z10;
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void d(@NotNull LiveAnchorPrivilegeLineUpConnectorMessage liveAnchorPrivilegeLineUpConnectorMessage) {
        a.C0157a.g(this, liveAnchorPrivilegeLineUpConnectorMessage);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void d0(@NotNull FKLiveHornModel messageModel) {
        s.i(messageModel, "messageModel");
        a.C0157a.q(this, messageModel);
        ((FKLiveBaseHornLayout) S0(R$id.liveHornLayout)).f(messageModel);
    }

    public final void d2() {
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel != null) {
            DiamondBalanceFragment.a.d(DiamondBalanceFragment.f15433o, getParentFragmentManager(), null, liveShowModel.getItemId(), null, SensorPosition.LiveShowRoom, null, new g(), 32, null);
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void e(@NotNull LivePkAppointRequestConnectorMessage livePkAppointRequestConnectorMessage) {
        a.C0157a.G(this, livePkAppointRequestConnectorMessage);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void e0(@NotNull LiveAnchorPrivilegeHintConnectorMessage liveAnchorPrivilegeHintConnectorMessage) {
        a.C0157a.e(this, liveAnchorPrivilegeHintConnectorMessage);
    }

    public final void e2(final boolean z10, final Function1<? super Integer, p> function1) {
        User user;
        final String userId;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (user = liveShowModel.getUser()) == null || (userId = user.userId()) == null) {
            return;
        }
        R0();
        O1().l(userId, new Function1<Integer, p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$openFanClubDialog$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Integer num) {
                invoke2(num);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Integer num) {
                FKLiveForViewerFragment.this.Q0();
                if (num != null) {
                    Function1<Integer, p> function12 = function1;
                    int intValue = num.intValue();
                    LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
                    if (fkLiveShowResult != null) {
                        fkLiveShowResult.setMemberInClubStatus(num.intValue());
                    }
                    if (function12 != null) {
                        function12.invoke(Integer.valueOf(intValue));
                    }
                }
                int status = FanClubStatus.HasJoined.getStatus();
                boolean z11 = true;
                if (num == null || num.intValue() != status) {
                    int status2 = FanClubStatus.Expired.getStatus();
                    if (num == null || num.intValue() != status2) {
                        z11 = false;
                    }
                }
                FKLiveForViewerFragment.this.t2(z11, z10);
                GroupLiveLog.f18698a.b(z11, userId, z10);
            }
        }, new Function0<p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$openFanClubDialog$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FKLiveForViewerFragment.this.Q0();
            }
        });
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void f(@NotNull NotifyConnectorMessage messageModel) {
        FKLiveCommentLayout fKLiveCommentLayout;
        s.i(messageModel, "messageModel");
        NotifyMessageModel entity = messageModel.getEntity();
        String message = entity.getMessage();
        if (message == null || message.length() == 0) {
            return;
        }
        int messageType = entity.getMessageType();
        if (messageType == NotifyMessageType.SystemMessage.getType()) {
            F1(new FKLiveSystemMessageViewModel(entity.getMessage(), messageModel.getEntity().getUser(), messageModel.getEntity().getSystemLabels()));
        } else if (messageType == NotifyMessageType.CommentGuideMessage.getType() && (fKLiveCommentLayout = (FKLiveCommentLayout) S0(R$id.viewerLiveCommentLayout)) != null) {
            fKLiveCommentLayout.f(entity, false);
        }
        if (s.d(entity.getStyle(), "alert")) {
            FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, getContext(), false, 2, null).n(entity.getMessage()), 0, null, null, 7, null), null, 1, null);
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void f0(@NotNull LiveShowTagConnectorMessageModel messageModel) {
        s.i(messageModel, "messageModel");
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel != null) {
            Disposable disposed = NetworkClient.f11868a.r().X(liveShowModel.getItemId(), messageModel.getEntity().getMessageKey()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<LiveShowRankTagListModel, p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$liveShowTagConnector$lambda$19$$inlined$handle$default$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(LiveShowRankTagListModel liveShowRankTagListModel) {
                    m2618invoke(liveShowRankTagListModel);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2618invoke(LiveShowRankTagListModel liveShowRankTagListModel) {
                    ((LiveShowRankTagListLayout) FKLiveForViewerFragment.this.S0(R$id.viewer_live_show_tag_layout)).d(liveShowRankTagListModel.getLiveShowTagList());
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                H(disposed);
            }
            s.h(disposed, "disposed");
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void g(@NotNull MultiPkScoreUpdateModel messageModel) {
        s.i(messageModel, "messageModel");
        ((MultiPkForViewerLayout) S0(R$id.viewer_multi_pk_layout)).B(messageModel);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void g0(@NotNull MultiPkMixSuccessModel messageModel) {
        s.i(messageModel, "messageModel");
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel != null) {
            liveShowModel.setMixStreamId(messageModel.getMixStreamId());
        }
        i2(messageModel, null);
    }

    public final void g2(final String str, final String str2) {
        LiveShowModel liveShowModel;
        String itemId;
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        if (fKLiveConstantsData.getFkLiveType() == FKLiveType.FINISH || FKLiveGiftPickerFragment.f15447n.b() || (liveShowModel = fKLiveConstantsData.getLiveShowModel()) == null || (itemId = liveShowModel.getItemId()) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.r().I0(itemId).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<GiftListResult, p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$openGift$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(GiftListResult giftListResult) {
                m2619invoke(giftListResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2619invoke(GiftListResult giftListResult) {
                FKLiveForViewerFragment.this.f15028r = null;
                ((FKLiveCommentLayout) FKLiveForViewerFragment.this.S0(R$id.viewerLiveCommentLayout)).setVisibility(4);
                ((FKLiveForViewerBottomMenuLayout) FKLiveForViewerFragment.this.S0(R$id.viewerLiveMenuLayout)).setVisibility(4);
                ((FKLivePkWarLayout) FKLiveForViewerFragment.this.S0(R$id.viewerLivePkWarLayout)).C(true);
                FKLiveGiftPickerFragment.f15447n.c(FKLiveForViewerFragment.this.getParentFragmentManager(), giftListResult, str, str2, new FKLiveForViewerFragment.h());
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void h(@Nullable HeatValuesModel heatValuesModel) {
        FKActorInfoAndAudienceLayout fKActorInfoAndAudienceLayout = (FKActorInfoAndAudienceLayout) S0(R$id.viewerLiveActorUserInfoLayout);
        if (fKActorInfoAndAudienceLayout != null) {
            fKActorInfoAndAudienceLayout.s(heatValuesModel);
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void h0(@NotNull AnchorInfoBorderConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        ((FKActorInfoAndAudienceLayout) S0(R$id.viewerLiveActorUserInfoLayout)).q(messageModel.getEntity());
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void i(@NotNull LiveShowShakeConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        CommentModel comment = messageModel.getEntity().getComment();
        if (comment != null) {
            F1(new FKLiveCommentMessageViewModel(comment, false, 2, null));
        }
        ((FKLiveShakeAnimationLayout) S0(R$id.viewerLiveShakeAnimationLayout)).k(messageModel.getEntity());
    }

    public final void i2(MultiPkMixSuccessModel multiPkMixSuccessModel, MultiPkInfoModel multiPkInfoModel) {
        FKLiveUtil fKLiveUtil = FKLiveUtil.f14913a;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        FKLiveUtil.J(fKLiveUtil, liveShowModel != null ? liveShowModel.getStreamId() : null, false, 2, null);
        TextureView textureView = (TextureView) S0(R$id.viewerLiveTextureView);
        if (textureView != null) {
            textureView.setVisibility(8);
        }
        MultiPkForViewerLayout multiPkForViewerLayout = (MultiPkForViewerLayout) S0(R$id.viewer_multi_pk_layout);
        if (multiPkForViewerLayout != null) {
            multiPkForViewerLayout.z(multiPkMixSuccessModel, multiPkInfoModel);
        }
        ((LiveStickerEditMaskLayout) S0(R$id.viewer_sticker_edit_mask_layout)).setCanDisplaySticker(false);
        C2(true);
        if (((FKLiveGiftEnterAnimationLayout) S0(R$id.viewerLiveGiftEnterAnimationLayout)).h()) {
            m2(true);
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void j(@NotNull GiftConnectorMessage messageModel, @NotNull ConnectorMessageEvent event) {
        String animationKey;
        s.i(messageModel, "messageModel");
        s.i(event, "event");
        E2(this, event.getMessage().getMessageId(), messageModel.getActivities(), messageModel.getLiveAdBadge(), false, 8, null);
        LiveShowGiftModel entity = messageModel.getEntity();
        if (entity.getGift().getShowInGiftBox()) {
            ((FKLiveGiftEnterAnimationLayout) S0(R$id.viewerLiveGiftEnterAnimationLayout)).j(messageModel.getEntity());
            m2(true);
        }
        if (entity.getGift().getShowInCommentArea()) {
            F1(new FKLiveGiftMessageViewModel(messageModel.getEntity().getSender(), messageModel.getEntity().getLiveGiftCommentLabels(), entity.getOriginalGift(), entity.getGift(), messageModel.getEntity().getDesc(), entity.getCount(), entity.getBackgroundColor(), entity.getBorderColor(), entity.getLeftTopImage(), entity.getRightTopImage(), entity.getLeftBottomImage(), entity.getRightBottomImage(), entity.getGradientDirection()));
        }
        GiftAnimationModel giftAnimation = entity.getGiftAnimation();
        if (giftAnimation != null && (animationKey = giftAnimation.getAnimationKey()) != null) {
            FKLiveGiftAnimationLayout viewerLiveGiftAnimationLayout = (FKLiveGiftAnimationLayout) S0(R$id.viewerLiveGiftAnimationLayout);
            s.h(viewerLiveGiftAnimationLayout, "viewerLiveGiftAnimationLayout");
            FKLiveGiftAnimationLayout.h(viewerLiveGiftAnimationLayout, new LiveShowAnimationModel(animationKey, giftAnimation.getSoundKey(), AnimationType.Gift), false, entity.getCount(), 2, null);
        }
        ((FKActorInfoAndAudienceLayout) S0(R$id.viewerLiveActorUserInfoLayout)).k(messageModel.getViewersSeat());
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void j0(@Nullable String str, @Nullable String str2) {
        FKActorInfoAndAudienceLayout fKActorInfoAndAudienceLayout = (FKActorInfoAndAudienceLayout) S0(R$id.viewerLiveActorUserInfoLayout);
        if (fKActorInfoAndAudienceLayout != null) {
            fKActorInfoAndAudienceLayout.y(str);
        }
    }

    public final void j2(String str) {
        FragmentActivity activity = getActivity();
        FKLiveForViewerActivity fKLiveForViewerActivity = activity instanceof FKLiveForViewerActivity ? (FKLiveForViewerActivity) activity : null;
        if (fKLiveForViewerActivity != null) {
            fKLiveForViewerActivity.v1(str);
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void k0(@NotNull MultiPkMuteOthersModel messageModel) {
        s.i(messageModel, "messageModel");
        ((MultiPkForViewerLayout) S0(R$id.viewer_multi_pk_layout)).x(messageModel.getLiveShowId(), messageModel.getClose());
    }

    public final void k2(GiftItemModel giftItemModel, String str, int i10, String str2) {
        ((QuickGiftAnimationLayout) S0(R$id.quick_gift_animation_layout)).v();
        T1().d(getContext(), giftItemModel, str, i10, str2, new j(giftItemModel, i10));
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void l(@NotNull NewLiveConnectRequestConnectorMessage newLiveConnectRequestConnectorMessage) {
        a.C0157a.l(this, newLiveConnectRequestConnectorMessage);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void l0(@NotNull LivePkFirstBloodConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        ((FKLivePkWarLayout) S0(R$id.viewerLivePkWarLayout)).m0(messageModel.getEntity().getLiveShowId());
    }

    public final void l2() {
        FKLiveConstantsData fKLiveConstantsData;
        LiveShowModel liveShowModel;
        FragmentActivity activity = getActivity();
        if (activity != null && activity.isFinishing()) {
            return;
        }
        LiveInRoomSensorModel Q1 = Q1();
        if (s.d(Q1 != null ? Q1.getEnterSource() : null, "LiveShowEnterMiniLive") || (liveShowModel = (fKLiveConstantsData = FKLiveConstantsData.INSTANCE).getLiveShowModel()) == null) {
            return;
        }
        SensorsLogLiveShow sensorsLogLiveShow = SensorsLogLiveShow.f12212a;
        LiveInRoomSensorModel Q12 = Q1();
        String enterSource = Q12 != null ? Q12.getEnterSource() : null;
        String itemId = liveShowModel.getItemId();
        String userId = liveShowModel.getUser().userId();
        Boolean valueOf = Boolean.valueOf(liveShowModel.getUser().getAloha());
        LiveInRoomSensorModel Q13 = Q1();
        SensorScene scene = Q13 != null ? Q13.getScene() : null;
        String viewerCount = liveShowModel.getViewerCount();
        Integer anchorPrivilegeType = liveShowModel.getAnchorPrivilegeType();
        String fkLiveStrategyId = fKLiveConstantsData.getFkLiveStrategyId();
        LiveInRoomSensorModel Q14 = Q1();
        SensorPosition sensorPosition = Q14 != null ? Q14.getSensorPosition() : null;
        LiveProtos.CoverType coverType = liveShowModel.getCoverType();
        LiveCoverTagModel coverTag = liveShowModel.getCoverTag();
        String id2 = coverTag != null ? coverTag.getId() : null;
        LiveInRoomSensorModel Q15 = Q1();
        String userType = Q15 != null ? Q15.getUserType() : null;
        LiveInRoomSensorModel Q16 = Q1();
        Double score = Q16 != null ? Q16.getScore() : null;
        RedEnvelopeTagModel redPacketInfo = liveShowModel.getRedPacketInfo();
        sensorsLogLiveShow.c(enterSource, itemId, userId, valueOf, scene, viewerCount, anchorPrivilegeType, fkLiveStrategyId, sensorPosition, coverType, id2, userType, score, redPacketInfo != null ? redPacketInfo.getIconCategory() : null);
        fKLiveConstantsData.setLiveShowViewDuration(Long.valueOf(System.currentTimeMillis()));
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void m(@NotNull LiveAnchorLvlUpgradeAnimationConnectorMessage liveAnchorLvlUpgradeAnimationConnectorMessage) {
        a.C0157a.c(this, liveAnchorLvlUpgradeAnimationConnectorMessage);
    }

    public final void m2(boolean z10) {
        if (((MultiPkForViewerLayout) S0(R$id.viewer_multi_pk_layout)).getVisibility() == 0) {
            ((FKLiveCommentLayout) S0(R$id.viewerLiveCommentLayout)).setAlpha(z10 ? 0.4f : 1.0f);
        } else {
            ((FKLiveCommentLayout) S0(R$id.viewerLiveCommentLayout)).setAlpha(1.0f);
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void n(@NotNull StartPrayContestConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        ((FKLivePrayBattleView) S0(R$id.viewerLivePrayBattleView)).f(messageModel.getEntity().getLotteryBattleInfo(), messageModel.getEntity().getLotteryBattleNormalInfo(), true);
    }

    public final void n2(String str) {
        LiveShowModel pkLiveShowModel = FKLiveConstantsData.INSTANCE.getPkLiveShowModel();
        if (pkLiveShowModel != null) {
            if (s.d(str, pkLiveShowModel.getItemId())) {
                FKLivePkWarLayout fKLivePkWarLayout = (FKLivePkWarLayout) S0(R$id.viewerLivePkWarLayout);
                if (fKLivePkWarLayout != null) {
                    fKLivePkWarLayout.i0(true, true);
                }
                FKLiveUtil.f14913a.w(true, pkLiveShowModel.getStreamId());
                return;
            }
            FKLiveUtil.f14913a.w(false, pkLiveShowModel.getStreamId());
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void o(@NotNull MultiPkCancelInvitingModel multiPkCancelInvitingModel) {
        a.C0157a.v(this, multiPkCancelInvitingModel);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void o0(@NotNull LiveAnchorLvlExpChangeConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        ((FKActorInfoAndAudienceLayout) S0(R$id.viewerLiveActorUserInfoLayout)).m(messageModel.getEntity());
    }

    public final void o2() {
        final String itemId;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null) {
            return;
        }
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, getContext(), false, 2, null), R$string.liveshow_finish_confirm_title, 0, 2, null), R$string.liveshow_finish_confirm, null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$showCloseObsStreamLiveAlert$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FKLiveForViewerFragment.this.R0();
                Observable<Result<SummaryDataResult>> E = NetworkClient.f11868a.r().E(itemId);
                final FKLiveForViewerFragment fKLiveForViewerFragment = FKLiveForViewerFragment.this;
                Disposable disposed = E.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<SummaryDataResult, p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$showCloseObsStreamLiveAlert$1$invoke$$inlined$handle$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(SummaryDataResult summaryDataResult) {
                        m2620invoke(summaryDataResult);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2620invoke(SummaryDataResult summaryDataResult) {
                        FKLiveForViewerFragment.this.Q0();
                        FKLiveForViewerFragment.this.z2(summaryDataResult.getSummary());
                    }
                }), new e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$showCloseObsStreamLiveAlert$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull Throwable it) {
                        s.i(it, "it");
                        FKLiveForViewerFragment.this.Q0();
                        return Boolean.FALSE;
                    }
                }, fKLiveForViewerFragment)));
                if (disposed != null) {
                    s.h(disposed, "disposed");
                    if (fKLiveForViewerFragment != null) {
                        fKLiveForViewerFragment.H(disposed);
                    }
                }
                s.h(disposed, "disposed");
            }
        }, 2, null), R$string.liveshow_finish_cancel, null, 2, null), null, 1, null);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public boolean onBackPressed() {
        if (this.f15027q == LiveConnectStatus.Wait) {
            u2.a r10 = NetworkClient.f11868a.r();
            LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
            Disposable disposed = r10.k(liveShowModel != null ? liveShowModel.getItemId() : null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$onBackPressed$$inlined$handle$default$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Object obj) {
                    invoke2(obj);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object obj) {
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                H(disposed);
            }
            s.h(disposed, "disposed");
        }
        FragmentActivity activity = getActivity();
        FKLiveForViewerActivity fKLiveForViewerActivity = activity instanceof FKLiveForViewerActivity ? (FKLiveForViewerActivity) activity : null;
        if (fKLiveForViewerActivity == null) {
            return false;
        }
        if (fKLiveForViewerActivity.m1() || M1()) {
            return true;
        }
        if (this.f15020j == null) {
            this.f15020j = "直播间手势关闭";
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_liveshow_for_viewer, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        y0.a.f54658a.c(this);
        this.f15021k = null;
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ((FKLiveForViewerBottomMenuLayout) S0(R$id.viewerLiveMenuLayout)).J();
        ((FKLiveBarrageLayout) S0(R$id.viewerLiveBarrageLayout)).b();
        ((ContinuousSendGiftLayout) S0(R$id.continuous_send_layout)).a();
        ((FKLiveBroadcastLayout) S0(R$id.viewerLiveBroadcastLayout)).j();
        ((FKLiveGiftAnimationLayout) S0(R$id.viewerLiveGiftAnimationLayout)).c();
        ((FKLiveGiftAnimationLayout) S0(R$id.common_animation_layout)).c();
        ((FKLiveBaseHornLayout) S0(R$id.liveHornLayout)).j();
        B2();
        ((FKLivePkStatusAnimationLayout) S0(R$id.viewerPkStatusAnimationLayout)).d();
        ((FKLiveShowAdLayout) S0(R$id.viewer_live_show_ad_layout)).p();
        ((FKLiveShowActivityLayout) S0(R$id.viewer_live_show_activity_layout)).p();
        ((FKLiveSendGiftCriticalHitView) S0(R$id.viewerLiveCriticalHitView)).m();
        ((LiveRedEnvelopeView) S0(R$id.viewer_red_envelope_view)).f();
        ((StarChallengeChestView) S0(R$id.viewer_star_challenge_chest_view)).k();
        SensorsLogLiveShow.f12212a.n();
        LiveCommentGuideHelper.f15387a.f();
        N0();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull SendGiftSuccessEvent event) {
        s.i(event, "event");
        DiamondBalanceFragment.f15433o.a();
        FKLiveGiftPickerFragment.f15447n.a();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.f15016f) {
            LiveShowModel remoteConnectLiveShow = FKLiveConstantsData.INSTANCE.getRemoteConnectLiveShow();
            boolean z10 = false;
            if (remoteConnectLiveShow != null && remoteConnectLiveShow.isRemoteConnect()) {
                z10 = true;
            }
            if (z10) {
                ((LiveConnectLayout) S0(R$id.viewer_connect_layout)).I();
            }
        }
        ((FKLiveShakeAnimationLayout) S0(R$id.viewerLiveShakeAnimationLayout)).o();
        X1();
        ((QuickGiftAnimationLayout) S0(R$id.quick_gift_animation_layout)).v();
        ((FKLiveForViewerBottomMenuLayout) S0(R$id.viewerLiveMenuLayout)).J();
        ((FKActorInfoAndAudienceLayout) S0(R$id.viewerLiveActorUserInfoLayout)).x();
        com.cupidapp.live.liveshow.entity.j c4 = j.a.c(com.cupidapp.live.liveshow.entity.j.f14922f, null, 1, null);
        if (c4 != null) {
            c4.F(null);
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f15015e) {
            this.f15015e = false;
            Z1();
            Y1();
        } else {
            FKLiveMiniWindow.G(FKLiveMiniWindow.f15074m.a(), MiniWindowCloseMethod.CloseMethodEnterLive, false, false, 4, null);
            R1();
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        y0.a.b(y0.a.f54658a, this, null, 2, null);
        I1();
        J1();
        ((FKLiveBaseHornLayout) S0(R$id.liveHornLayout)).k();
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void p(@NotNull FKLivePkStatus status) {
        s.i(status, "status");
        if (FKLiveGiftPickerFragment.f15447n.b()) {
            int i10 = b.f15032a[status.ordinal()];
            if (i10 != 1 && i10 != 2 && i10 != 3) {
                EventBus.c().l(new HideGiftDetailDescriptionEvent(false));
            } else {
                EventBus.c().l(new HideGiftDetailDescriptionEvent(true));
            }
        }
    }

    public final void p2(boolean z10, Integer num) {
        FKLiveShowCommentEditTextLayout fKLiveShowCommentEditTextLayout;
        if (this.f15026p == null) {
            Context context = getContext();
            if (context != null) {
                fKLiveShowCommentEditTextLayout = new FKLiveShowCommentEditTextLayout(context);
                fKLiveShowCommentEditTextLayout.setCommentListener(new k());
            } else {
                fKLiveShowCommentEditTextLayout = null;
            }
            this.f15026p = fKLiveShowCommentEditTextLayout;
        }
        FKLiveShowCommentEditTextLayout fKLiveShowCommentEditTextLayout2 = this.f15026p;
        if (fKLiveShowCommentEditTextLayout2 != null) {
            fKLiveShowCommentEditTextLayout2.C(z10, num);
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void q0(@NotNull MultiPkInvitationModel multiPkInvitationModel) {
        a.C0157a.y(this, multiPkInvitationModel);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void r(@NotNull MultiPkInteractModel messageModel) {
        s.i(messageModel, "messageModel");
        ((MultiPkForViewerLayout) S0(R$id.viewer_multi_pk_layout)).P(messageModel.getResult());
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void r0(@NotNull MultiPkRefuseInvitingModel multiPkRefuseInvitingModel) {
        a.C0157a.B(this, multiPkRefuseInvitingModel);
    }

    public final void r2(GiftItemModel giftItemModel, int i10, String str) {
        ((ContinuousSendGiftLayout) S0(R$id.continuous_send_layout)).c(giftItemModel, i10, str, new l());
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void s(@NotNull UserEntryConnectorMessage messageModel, @NotNull ConnectorMessageEvent event) {
        s.i(messageModel, "messageModel");
        s.i(event, "event");
        if (messageModel.getEntity().getUserEntryDirection() == UserEntryDirection.R2L) {
            ((FKLiveViewerEnterCarLayout) S0(R$id.viewerLiveUserEnterCarLayout)).h(messageModel.getEntity());
        } else {
            ((FKLiveViewerEnterDefaultLayout) S0(R$id.viewerLiveUserEnterDefaultLayout)).m(messageModel.getEntity());
        }
        String animation = messageModel.getEntity().getAnimation();
        if (animation != null) {
            FKLiveGiftAnimationLayout viewerLiveGiftAnimationLayout = (FKLiveGiftAnimationLayout) S0(R$id.viewerLiveGiftAnimationLayout);
            s.h(viewerLiveGiftAnimationLayout, "viewerLiveGiftAnimationLayout");
            FKLiveGiftAnimationLayout.h(viewerLiveGiftAnimationLayout, new LiveShowAnimationModel(animation, null, AnimationType.UserEntry), true, 0, 4, null);
            ((LiveViewerRightEnterAnimatorLayout) S0(R$id.right_enter_animator_layout)).g(messageModel.getEntity());
        }
        ((FKActorInfoAndAudienceLayout) S0(R$id.viewerLiveActorUserInfoLayout)).k(messageModel.getViewersSeat());
        D2(event.getMessage().getMessageId(), null, messageModel.getLiveAdBadge(), false);
        ((FKLiveCommentLayout) S0(R$id.viewerLiveCommentLayout)).g(messageModel.getEntity().getUser(), messageModel.getEntity().getEnterText(), messageModel.getEntity().getTextEnterLabels());
    }

    public final void s2(FKCriticalHitModel fKCriticalHitModel) {
        ((FKLiveSendGiftCriticalHitView) S0(R$id.viewerLiveCriticalHitView)).e(fKCriticalHitModel, true, new Function0<p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$showCriticalHit$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FKTurnTableModel lotteryBtn;
                LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
                if (fkLiveShowResult == null || (lotteryBtn = fkLiveShowResult.getLotteryBtn()) == null) {
                    return;
                }
                FKLiveForViewerFragment fKLiveForViewerFragment = FKLiveForViewerFragment.this;
                lotteryBtn.setCrit(false);
                ((FKLiveForViewerBottomMenuLayout) fKLiveForViewerFragment.S0(R$id.viewerLiveMenuLayout)).p(lotteryBtn);
            }
        });
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void t(@NotNull LiveShowAnimationConnectorMessageModel messageModel) {
        s.i(messageModel, "messageModel");
        LiveShowAnimationMessageModel entity = messageModel.getEntity();
        if (entity.getPlayImmediately()) {
            FKLiveGiftAnimationLayout common_animation_layout = (FKLiveGiftAnimationLayout) S0(R$id.common_animation_layout);
            s.h(common_animation_layout, "common_animation_layout");
            FKLiveGiftAnimationLayout.h(common_animation_layout, new LiveShowAnimationModel(entity.getAnimationResKey(), entity.getAudioResKey(), AnimationType.ExtraAnimation), false, 0, 6, null);
        } else {
            FKLiveGiftAnimationLayout viewerLiveGiftAnimationLayout = (FKLiveGiftAnimationLayout) S0(R$id.viewerLiveGiftAnimationLayout);
            s.h(viewerLiveGiftAnimationLayout, "viewerLiveGiftAnimationLayout");
            FKLiveGiftAnimationLayout.h(viewerLiveGiftAnimationLayout, new LiveShowAnimationModel(entity.getAnimationResKey(), entity.getAudioResKey(), AnimationType.Animation), false, 0, 6, null);
        }
    }

    public final void t2(boolean z10, boolean z11) {
        if (z10) {
            O1().s();
        } else {
            O1().t(z11, new Function0<p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$showFanClubDialog$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
                    if (fkLiveShowResult != null) {
                        fkLiveShowResult.setMemberInClubStatus(FanClubStatus.HasJoined.getStatus());
                    }
                    ((FKLiveForViewerBottomMenuLayout) FKLiveForViewerFragment.this.S0(R$id.viewerLiveMenuLayout)).setFanClubBtnStatus(FanClubStatus.HasJoined.getStatus());
                    ((FKActorInfoAndAudienceLayout) FKLiveForViewerFragment.this.S0(R$id.viewerLiveActorUserInfoLayout)).r();
                }
            });
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void u(@NotNull LivePkRandPairedMessage livePkRandPairedMessage) {
        a.C0157a.J(this, livePkRandPairedMessage);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void u0(@NotNull SignInInfoModel messageModel) {
        s.i(messageModel, "messageModel");
        LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
        SignInInfoModel signInInfo = fkLiveShowResult != null ? fkLiveShowResult.getSignInInfo() : null;
        if (signInInfo != null) {
            signInInfo.setUnreadCount(messageModel.getUnreadCount());
        }
        if (messageModel.getUnreadCount() > 0) {
            ((FKLiveForViewerBottomMenuLayout) S0(R$id.viewerLiveMenuLayout)).A(true);
        } else {
            ((FKLiveForViewerBottomMenuLayout) S0(R$id.viewerLiveMenuLayout)).s();
        }
    }

    public final void u2() {
        e2(false, new Function1<Integer, p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$showFansGroup$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Integer num) {
                invoke(num.intValue());
                return p.f51048a;
            }

            public final void invoke(int i10) {
                FKLiveForViewerBottomMenuLayout fKLiveForViewerBottomMenuLayout = (FKLiveForViewerBottomMenuLayout) FKLiveForViewerFragment.this.S0(R$id.viewerLiveMenuLayout);
                if (fKLiveForViewerBottomMenuLayout != null) {
                    fKLiveForViewerBottomMenuLayout.setFanClubBtnStatus(i10);
                }
            }
        });
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void v0(@NotNull LiveGiftCollectionConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        Disposable disposed = NetworkClient.f11868a.r().G0(messageModel.getLiveShowId()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<GiftCollectionModel, p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$liveGiftCollectionConnector$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(GiftCollectionModel giftCollectionModel) {
                m2617invoke(giftCollectionModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2617invoke(GiftCollectionModel giftCollectionModel) {
                ((GiftCollectionLayout) FKLiveForViewerFragment.this.S0(R$id.viewer_gift_collection_layout)).h(giftCollectionModel);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void v2() {
        FKLiveForViewerMoreMenuFragment.a aVar = FKLiveForViewerMoreMenuFragment.f15330i;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
        boolean z10 = (fkLiveShowResult != null ? fkLiveShowResult.getLotteryBtn() : null) != null;
        LiveInRoomSensorModel Q1 = Q1();
        aVar.a(parentFragmentManager, z10, Q1 != null ? Q1.getEnterSource() : null, new Function1<MenuType, p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$showMoreMenuDialog$1

            /* compiled from: FKLiveForViewerFragment.kt */
            @kotlin.d
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f15051a;

                static {
                    int[] iArr = new int[MenuType.values().length];
                    try {
                        iArr[MenuType.FanClub.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[MenuType.RedEnvelope.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[MenuType.MagicRefine.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[MenuType.DressUpMall.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[MenuType.MyOutfit.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr[MenuType.Noble.ordinal()] = 6;
                    } catch (NoSuchFieldError unused6) {
                    }
                    try {
                        iArr[MenuType.GiftWall.ordinal()] = 7;
                    } catch (NoSuchFieldError unused7) {
                    }
                    try {
                        iArr[MenuType.FollowLive.ordinal()] = 8;
                    } catch (NoSuchFieldError unused8) {
                    }
                    try {
                        iArr[MenuType.Share.ordinal()] = 9;
                    } catch (NoSuchFieldError unused9) {
                    }
                    try {
                        iArr[MenuType.GiftEffects.ordinal()] = 10;
                    } catch (NoSuchFieldError unused10) {
                    }
                    f15051a = iArr;
                }
            }

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(MenuType menuType) {
                invoke2(menuType);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MenuType it) {
                s.i(it, "it");
                switch (a.f15051a[it.ordinal()]) {
                    case 1:
                        FKLiveForViewerFragment.f2(FKLiveForViewerFragment.this, false, null, 2, null);
                        return;
                    case 2:
                        ((FKLiveForViewerBottomMenuLayout) FKLiveForViewerFragment.this.S0(R$id.viewerLiveMenuLayout)).v();
                        return;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        ((FKLiveForViewerBottomMenuLayout) FKLiveForViewerFragment.this.S0(R$id.viewerLiveMenuLayout)).s();
                        return;
                    case 9:
                        FKLiveForViewerFragment.this.y2();
                        return;
                    case 10:
                        if (s.d(p1.g.f52734a.Y0(), Boolean.FALSE)) {
                            ((FKLiveGiftAnimationLayout) FKLiveForViewerFragment.this.S0(R$id.viewerLiveGiftAnimationLayout)).d();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        });
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void w(@NotNull FullLiveVisibleGiftConnectorMessage message) {
        s.i(message, "message");
        ((FullLiveVisibleGiftLayout) S0(R$id.viewer_full_live_visible_gift_layout)).d(message.getEntity());
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void w0(@NotNull MultiPkEndModel messageModel) {
        s.i(messageModel, "messageModel");
        String liveShowId = messageModel.getLiveShowId();
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        boolean d10 = s.d(liveShowId, liveShowModel != null ? liveShowModel.getItemId() : null);
        if (!messageModel.isInitiator() && !d10 && !messageModel.getEnded()) {
            ((MultiPkForViewerLayout) S0(R$id.viewer_multi_pk_layout)).C(messageModel.getLiveShowId());
            return;
        }
        MultiPkForViewerLayout viewer_multi_pk_layout = (MultiPkForViewerLayout) S0(R$id.viewer_multi_pk_layout);
        s.h(viewer_multi_pk_layout, "viewer_multi_pk_layout");
        MultiPkForViewerLayout.r(viewer_multi_pk_layout, false, 1, null);
    }

    public final void w2(final PopupInfoModel popupInfoModel) {
        if (popupInfoModel != null && popupInfoModel.getAutoPopup()) {
            com.cupidapp.live.base.utils.i iVar = new com.cupidapp.live.base.utils.i();
            this.f15023m = iVar;
            com.cupidapp.live.base.utils.i.d(iVar, 10, 1, new Function0<p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$showRechargePackageDialog$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    boolean z10;
                    FragmentActivity activity = FKLiveForViewerFragment.this.getActivity();
                    FKLiveForViewerActivity fKLiveForViewerActivity = activity instanceof FKLiveForViewerActivity ? (FKLiveForViewerActivity) activity : null;
                    boolean u12 = fKLiveForViewerActivity != null ? fKLiveForViewerActivity.u1() : false;
                    z10 = FKLiveForViewerFragment.this.f15022l;
                    if (z10 || DiamondBalanceFragment.f15433o.b() || u12) {
                        return;
                    }
                    FKLiveForViewerFragment.this.j2(popupInfoModel.getUrl());
                }
            }, null, 8, null);
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void x(@NotNull MultiPkStartModel messageModel) {
        s.i(messageModel, "messageModel");
        ((MultiPkForViewerLayout) S0(R$id.viewer_multi_pk_layout)).O(messageModel.getCountdownSec(), messageModel.getJumpUrl(), messageModel.getPkPairId(), true);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void x0(@NotNull MultiPkFirstBloodModel messageModel) {
        s.i(messageModel, "messageModel");
        ((MultiPkForViewerLayout) S0(R$id.viewer_multi_pk_layout)).J(messageModel.getLiveShowId());
    }

    public final void x2(@NotNull LiveConnectRequestCheckResult result) {
        s.i(result, "result");
        FKLiveRequestConnectFragment a10 = FKLiveRequestConnectFragment.f15849i.a(result, new m());
        this.f15017g = a10;
        if (a10 != null) {
            a10.s1(getParentFragmentManager());
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void y0(@NotNull LiveConnectAcceptConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        this.f15027q = LiveConnectStatus.Connect;
        LiveShowModel remoteConnectLiveShow = FKLiveConstantsData.INSTANCE.getRemoteConnectLiveShow();
        if (remoteConnectLiveShow != null && remoteConnectLiveShow.isRemoteConnect()) {
            ((LiveConnectEntranceView) S0(R$id.live_connect_view)).b(this.f15027q);
        }
        ((LiveConnectLayout) S0(R$id.viewer_connect_layout)).w(true, true, true);
        FragmentActivity activity = getActivity();
        FKLiveForViewerActivity fKLiveForViewerActivity = activity instanceof FKLiveForViewerActivity ? (FKLiveForViewerActivity) activity : null;
        if (fKLiveForViewerActivity != null) {
            fKLiveForViewerActivity.R1(false);
        }
    }

    public final void y2() {
        FragmentActivity activity = getActivity();
        FKLiveForViewerActivity fKLiveForViewerActivity = activity instanceof FKLiveForViewerActivity ? (FKLiveForViewerActivity) activity : null;
        if (fKLiveForViewerActivity != null) {
            fKLiveForViewerActivity.A1();
        }
    }

    public final void z2(SummaryModel summaryModel) {
        int i10 = R$id.viewerLiveForStreamerSummaryLayout;
        if (((FKLiveForStreamerSummaryLayout) S0(i10)).getVisibility() == 0) {
            return;
        }
        FKLiveGrpcEntity.f14907e.a().k();
        FKLiveUtil.f14913a.m();
        ((FKLiveForStreamerSummaryLayout) S0(i10)).c(new Function0<p>() { // from class: com.cupidapp.live.liveshow.fragment.FKLiveForViewerFragment$showSummaryForStreamerLayout$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FragmentActivity activity = FKLiveForViewerFragment.this.getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                }
            }
        });
        ((FKLiveForStreamerSummaryLayout) S0(i10)).e(summaryModel);
        ((ConstraintLayout) S0(R$id.viewerContainerLayout)).setVisibility(8);
        ((FKLiveForStreamerSummaryLayout) S0(i10)).setVisibility(0);
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull InsertShakeCommentEvent event) {
        s.i(event, "event");
        F1(new FKLiveCommentMessageViewModel(event.getComment(), false, 2, null));
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull OpenLiveGiftEvent event) {
        s.i(event, "event");
        FragmentActivity activity = getActivity();
        FKLiveForViewerActivity fKLiveForViewerActivity = activity instanceof FKLiveForViewerActivity ? (FKLiveForViewerActivity) activity : null;
        if (fKLiveForViewerActivity != null) {
            fKLiveForViewerActivity.m1();
        }
        O1().j();
        this.f15029s = event.getEntrance();
        g2(event.getGiftId(), event.getFenceId());
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull FKLiveOpenWebFragmentEvent event) {
        s.i(event, "event");
        FragmentActivity activity = getActivity();
        FKLiveForViewerActivity fKLiveForViewerActivity = activity instanceof FKLiveForViewerActivity ? (FKLiveForViewerActivity) activity : null;
        if (fKLiveForViewerActivity != null) {
            fKLiveForViewerActivity.d2(event.getUrl(), event.getCover());
        }
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ShowAutoLightUpDialogEvent event) {
        s.i(event, "event");
        O1().u();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ExitFanClubEvent event) {
        s.i(event, "event");
        LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
        if (fkLiveShowResult != null) {
            fkLiveShowResult.setMemberInClubStatus(FanClubStatus.Exited.getStatus());
        }
        ((FKLiveForViewerBottomMenuLayout) S0(R$id.viewerLiveMenuLayout)).setFanClubBtnStatus(FanClubStatus.Exited.getStatus());
        ((FKActorInfoAndAudienceLayout) S0(R$id.viewerLiveActorUserInfoLayout)).r();
        FragmentActivity activity = getActivity();
        FKLiveForViewerActivity fKLiveForViewerActivity = activity instanceof FKLiveForViewerActivity ? (FKLiveForViewerActivity) activity : null;
        if (fKLiveForViewerActivity != null) {
            fKLiveForViewerActivity.m1();
        }
        O1().j();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ShowCommentEvent event) {
        s.i(event, "event");
        p2(false, Integer.valueOf(event.getType()));
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull OpenDiamondBalanceEvent event) {
        s.i(event, "event");
        d2();
    }
}
