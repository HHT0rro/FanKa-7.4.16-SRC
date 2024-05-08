package com.cupidapp.live.liveshow.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.extension.NetworkStateConstants;
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
import com.cupidapp.live.base.network.download.LaunchDownloader;
import com.cupidapp.live.base.network.download.LiveBeautyDownloader;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.sensorslog.MiniWindowCloseMethod;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.base.sensorslog.TrackAppErrorType;
import com.cupidapp.live.base.view.FKAlertLayout;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.consult.helper.ConsultFloatWindowHelper;
import com.cupidapp.live.liveshow.adapter.FKLiveCommentMessageViewModel;
import com.cupidapp.live.liveshow.adapter.FKLiveGiftMessageViewModel;
import com.cupidapp.live.liveshow.adapter.FKLiveMessageViewModel;
import com.cupidapp.live.liveshow.adapter.FKLiveSystemMessageViewModel;
import com.cupidapp.live.liveshow.beauty.model.FKLiveBeautyEditCacheModel;
import com.cupidapp.live.liveshow.beauty.view.FKLiveBeautyGLSurfaceView;
import com.cupidapp.live.liveshow.beauty.view.FKLiveBeautyLayout;
import com.cupidapp.live.liveshow.beauty.view.ShowStickerEvent;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.constants.FKLiveType;
import com.cupidapp.live.liveshow.entity.FKLiveGrpcEntity;
import com.cupidapp.live.liveshow.entity.FKLiveUtil;
import com.cupidapp.live.liveshow.entity.a;
import com.cupidapp.live.liveshow.entity.j;
import com.cupidapp.live.liveshow.event.PlayLiveEvent;
import com.cupidapp.live.liveshow.fanclub.FKFanClubManager;
import com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindow;
import com.cupidapp.live.liveshow.model.AnchorGradeInfoModel;
import com.cupidapp.live.liveshow.model.AnimationType;
import com.cupidapp.live.liveshow.model.BadgeModel;
import com.cupidapp.live.liveshow.model.CommentModel;
import com.cupidapp.live.liveshow.model.FKLiveHornModel;
import com.cupidapp.live.liveshow.model.GiftAnimationModel;
import com.cupidapp.live.liveshow.model.GiftCollectionModel;
import com.cupidapp.live.liveshow.model.GiftItemModel;
import com.cupidapp.live.liveshow.model.HeatValuesModel;
import com.cupidapp.live.liveshow.model.LiveActivityModel;
import com.cupidapp.live.liveshow.model.LiveConnectAcceptResult;
import com.cupidapp.live.liveshow.model.LiveMenuBtnModel;
import com.cupidapp.live.liveshow.model.LivePkType;
import com.cupidapp.live.liveshow.model.LiveShowAnimationModel;
import com.cupidapp.live.liveshow.model.LiveShowGiftModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.LiveShowPkWarResult;
import com.cupidapp.live.liveshow.model.LiveShowRankTagListModel;
import com.cupidapp.live.liveshow.model.LiveShowResult;
import com.cupidapp.live.liveshow.model.LiveStickerResult;
import com.cupidapp.live.liveshow.model.MultiPkInfoModel;
import com.cupidapp.live.liveshow.model.NewLiveConnectRequestModel;
import com.cupidapp.live.liveshow.model.SignInInfoModel;
import com.cupidapp.live.liveshow.model.StarChallengeLvlUpgradeModel;
import com.cupidapp.live.liveshow.model.SummaryDataResult;
import com.cupidapp.live.liveshow.model.SummaryModel;
import com.cupidapp.live.liveshow.pk.model.AcceptInvitingResult;
import com.cupidapp.live.liveshow.pk.model.MultiPkAgreeInvitingModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkAnchorModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkCancelInvitingModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkCancelPrepareModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkEndModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkFirstBloodModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkInteractModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkInvitationModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkInviteStatus;
import com.cupidapp.live.liveshow.pk.model.MultiPkMixSuccessModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkMuteOthersModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkPrepareModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkRefuseInvitingModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkScoreUpdateModel;
import com.cupidapp.live.liveshow.pk.model.MultiPkStartModel;
import com.cupidapp.live.liveshow.pk.util.FKLivePkManager;
import com.cupidapp.live.liveshow.pk.util.MultiPersonPkPresenter;
import com.cupidapp.live.liveshow.pk.view.FKLivePkStatus;
import com.cupidapp.live.liveshow.pk.view.FKLivePkStatusAnimationLayout;
import com.cupidapp.live.liveshow.pk.view.FKLivePkWarLayout;
import com.cupidapp.live.liveshow.pk.view.MultiPersonPkState;
import com.cupidapp.live.liveshow.pk.view.MultiPkLayout;
import com.cupidapp.live.liveshow.view.FKLiveSendGiftCriticalHitView;
import com.cupidapp.live.liveshow.view.FKLiveStreamerOpenLiveLayout;
import com.cupidapp.live.liveshow.view.LiveRedEnvelopeView;
import com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout;
import com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerMoreMenuFragment;
import com.cupidapp.live.liveshow.view.bottommenu.MenuType;
import com.cupidapp.live.liveshow.view.comment.FKLiveBarrageLayout;
import com.cupidapp.live.liveshow.view.comment.FKLiveCommentLayout;
import com.cupidapp.live.liveshow.view.dialog.LiveHeatCountDesDialog;
import com.cupidapp.live.liveshow.view.giftcollection.GiftCollectionLayout;
import com.cupidapp.live.liveshow.view.giftpicker.helper.StickerGiftHelper;
import com.cupidapp.live.liveshow.view.giftpicker.view.FKLiveGiftEnterAnimationLayout;
import com.cupidapp.live.liveshow.view.giftplayer.FKLiveGiftAnimationLayout;
import com.cupidapp.live.liveshow.view.giftplayer.FullLiveVisibleGiftLayout;
import com.cupidapp.live.liveshow.view.horn.FKLiveBaseHornLayout;
import com.cupidapp.live.liveshow.view.liveinfo.FKActorInfoAndAudienceLayout;
import com.cupidapp.live.liveshow.view.liveinfo.FKLiveBroadcastLayout;
import com.cupidapp.live.liveshow.view.liveinfo.FKLiveShowActivityLayout;
import com.cupidapp.live.liveshow.view.liveinfo.FKLiveShowAdLayout;
import com.cupidapp.live.liveshow.view.miniprofile.FKLiveMiniProfileFragment;
import com.cupidapp.live.liveshow.view.music.FKLiveMusicDismissEvent;
import com.cupidapp.live.liveshow.view.music.FKLiveMusicFragment;
import com.cupidapp.live.liveshow.view.music.view.FKMusicPlayerLayout;
import com.cupidapp.live.liveshow.view.praybattle.FKLivePrayBattleView;
import com.cupidapp.live.liveshow.view.privilege.FKLivePrivilegeDialogLayout;
import com.cupidapp.live.liveshow.view.privilege.FKLivePrivilegeStatusLayout;
import com.cupidapp.live.liveshow.view.remoteconnect.fragment.FKLiveConnectUserPickerFragment;
import com.cupidapp.live.liveshow.view.remoteconnect.fragment.i;
import com.cupidapp.live.liveshow.view.remoteconnect.view.LiveConnectLayout;
import com.cupidapp.live.liveshow.view.remoteconnect.view.b;
import com.cupidapp.live.liveshow.view.shake.FKLiveShakeAnimationLayout;
import com.cupidapp.live.liveshow.view.shake.InsertShakeCommentEvent;
import com.cupidapp.live.liveshow.view.starchallenge.StarChallengeChestView;
import com.cupidapp.live.liveshow.view.starchallenge.StarChallengeLvlUpgradeLayout;
import com.cupidapp.live.liveshow.view.sticker.LiveStickerEditMaskLayout;
import com.cupidapp.live.liveshow.view.summary.FKLiveForStreamerSummaryLayout;
import com.cupidapp.live.liveshow.view.tag.LiveShowRankTagListLayout;
import com.cupidapp.live.liveshow.view.viewerenter.FKLiveViewerEnterCarLayout;
import com.cupidapp.live.liveshow.view.viewerenter.FKLiveViewerEnterDefaultLayout;
import com.cupidapp.live.liveshow.view.viewerenter.LiveViewerRightEnterAnimatorLayout;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupLiveLog;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
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
import u2.a;
import z0.h;
import z0.t;
import z0.y;

/* compiled from: FKLiveForStreamerBeautyActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveForStreamerBeautyActivity extends FKBaseLiveActivity implements com.cupidapp.live.liveshow.entity.a {

    @NotNull
    public static final a Q = new a(null);
    public boolean A;

    @Nullable
    public FKLiveConnectUserPickerFragment B;

    @Nullable
    public FKLiveMusicFragment D;

    @Nullable
    public String E;

    @Nullable
    public List<String> M;

    @Nullable
    public Disposable N;

    /* renamed from: z, reason: collision with root package name */
    public boolean f14753z;

    @NotNull
    public Map<Integer, View> P = new LinkedHashMap();

    @NotNull
    public final Lazy C = kotlin.c.b(new Function0<FKGRPCMessageIdCounter>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$grpcMessageIdCounter$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKGRPCMessageIdCounter invoke() {
            return new FKGRPCMessageIdCounter();
        }
    });

    @NotNull
    public final Lazy F = kotlin.c.b(new Function0<FKLivePkManager>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$livePkManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLivePkManager invoke() {
            return new FKLivePkManager(FKLiveForStreamerBeautyActivity.this.getSupportFragmentManager());
        }
    });

    @Nullable
    public Integer G = 0;

    @NotNull
    public final Lazy H = kotlin.c.b(new Function0<FKFanClubManager>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$fanClubManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKFanClubManager invoke() {
            FKLiveForStreamerBeautyActivity fKLiveForStreamerBeautyActivity = FKLiveForStreamerBeautyActivity.this;
            FragmentManager supportFragmentManager = fKLiveForStreamerBeautyActivity.getSupportFragmentManager();
            s.h(supportFragmentManager, "supportFragmentManager");
            return new FKFanClubManager(fKLiveForStreamerBeautyActivity, supportFragmentManager);
        }
    });

    @NotNull
    public final Lazy I = kotlin.c.b(new Function0<com.cupidapp.live.liveshow.pk.util.c>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$multiPkManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final com.cupidapp.live.liveshow.pk.util.c invoke() {
            FragmentManager supportFragmentManager = FKLiveForStreamerBeautyActivity.this.getSupportFragmentManager();
            s.h(supportFragmentManager, "supportFragmentManager");
            return new com.cupidapp.live.liveshow.pk.util.c(supportFragmentManager);
        }
    });

    @NotNull
    public final Lazy J = kotlin.c.b(new Function0<f1.b>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$networkStateUtil$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final f1.b invoke() {
            return new f1.b();
        }
    });

    @NotNull
    public final com.cupidapp.live.liveshow.entity.d K = new l();

    @Nullable
    public com.cupidapp.live.liveshow.entity.c L = new k();

    @NotNull
    public final Lazy O = kotlin.c.b(new Function0<MultiPersonPkPresenter>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$multiPkPresenter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final MultiPersonPkPresenter invoke() {
            return new MultiPersonPkPresenter(FKLiveForStreamerBeautyActivity.this);
        }
    });

    /* compiled from: FKLiveForStreamerBeautyActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context) {
            Intent intent = new Intent(context, (Class<?>) FKLiveForStreamerBeautyActivity.class);
            if (context != null) {
                context.startActivity(intent);
            }
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    /* compiled from: FKLiveForStreamerBeautyActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14754a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f14755b;

        static {
            int[] iArr = new int[FKLiveType.values().length];
            try {
                iArr[FKLiveType.PK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f14754a = iArr;
            int[] iArr2 = new int[FKLivePkStatus.values().length];
            try {
                iArr2[FKLivePkStatus.LivePkInProgress.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[FKLivePkStatus.LivePkInteractive.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            f14755b = iArr2;
        }
    }

    /* compiled from: FKLiveForStreamerBeautyActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements com.cupidapp.live.liveshow.beauty.view.a {
        public c() {
        }

        @Override // com.cupidapp.live.liveshow.beauty.view.a
        public void a() {
            FKLiveStreamerOpenLiveLayout fKLiveStreamerOpenLiveLayout = (FKLiveStreamerOpenLiveLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamerOpenLiveLayout);
            if (fKLiveStreamerOpenLiveLayout != null) {
                fKLiveStreamerOpenLiveLayout.L();
            }
        }
    }

    /* compiled from: FKLiveForStreamerBeautyActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class d implements com.cupidapp.live.liveshow.view.c {
        public d() {
        }

        @Override // com.cupidapp.live.liveshow.view.c
        public void a() {
            r2.i.f53231b.l();
        }

        @Override // com.cupidapp.live.liveshow.view.c
        public void b(@NotNull String title, boolean z10, @NotNull String pushStatus) {
            s.i(title, "title");
            s.i(pushStatus, "pushStatus");
            FKLiveForStreamerBeautyActivity.this.O2(title, z10, pushStatus);
        }

        @Override // com.cupidapp.live.liveshow.view.c
        public void c() {
            FKLiveStreamerOpenLiveLayout fKLiveStreamerOpenLiveLayout = (FKLiveStreamerOpenLiveLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamerOpenLiveLayout);
            if (fKLiveStreamerOpenLiveLayout != null) {
                fKLiveStreamerOpenLiveLayout.A();
            }
            FKLiveBeautyLayout fKLiveBeautyLayout = (FKLiveBeautyLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamerBeautyLayout);
            Property<View, Float> ALPHA = View.ALPHA;
            s.h(ALPHA, "ALPHA");
            fKLiveBeautyLayout.e(ALPHA);
        }
    }

    /* compiled from: FKLiveForStreamerBeautyActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class e implements com.cupidapp.live.liveshow.view.remoteconnect.view.b {
        public e() {
        }

        @Override // com.cupidapp.live.liveshow.view.remoteconnect.view.b
        public void a() {
            b.a.a(this);
        }

        @Override // com.cupidapp.live.liveshow.view.remoteconnect.view.b
        public void b() {
            b.a.d(this);
        }

        @Override // com.cupidapp.live.liveshow.view.remoteconnect.view.b
        public void c(boolean z10) {
            ((GiftCollectionLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamer_gift_collection_layout)).g(!z10);
        }

        @Override // com.cupidapp.live.liveshow.view.remoteconnect.view.b
        public void d() {
            FKLiveConnectUserPickerFragment fKLiveConnectUserPickerFragment = FKLiveForStreamerBeautyActivity.this.B;
            if (fKLiveConnectUserPickerFragment != null) {
                fKLiveConnectUserPickerFragment.dismiss();
            }
        }

        @Override // com.cupidapp.live.liveshow.view.remoteconnect.view.b
        public void e() {
            FKLiveConnectUserPickerFragment fKLiveConnectUserPickerFragment = FKLiveForStreamerBeautyActivity.this.B;
            if (fKLiveConnectUserPickerFragment != null) {
                fKLiveConnectUserPickerFragment.l1();
            }
        }
    }

    /* compiled from: FKLiveForStreamerBeautyActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class f implements com.cupidapp.live.liveshow.pk.util.b {
        public f() {
        }

        @Override // com.cupidapp.live.liveshow.pk.util.b
        public void a() {
            FKLiveForStreamerBeautyActivity.this.V0();
        }

        @Override // com.cupidapp.live.liveshow.pk.util.b
        public void b() {
            FKLiveForStreamerBeautyActivity.this.e1();
        }

        @Override // com.cupidapp.live.liveshow.pk.util.b
        public void c(@NotNull MultiPkPrepareModel prepareResult) {
            s.i(prepareResult, "prepareResult");
            MultiPkLayout streamer_multi_pk_layout = (MultiPkLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamer_multi_pk_layout);
            s.h(streamer_multi_pk_layout, "streamer_multi_pk_layout");
            MultiPkLayout.C(streamer_multi_pk_layout, true, prepareResult.getRtmpUrlPrefix(), prepareResult.getMixStreamId(), null, 8, null);
        }

        @Override // com.cupidapp.live.liveshow.pk.util.b
        public void d() {
            ((MultiPkLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamer_multi_pk_layout)).w();
        }
    }

    /* compiled from: FKLiveForStreamerBeautyActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class g implements com.cupidapp.live.liveshow.pk.view.e {
        public g() {
        }

        @Override // com.cupidapp.live.liveshow.pk.view.e
        public void a() {
            FKLiveForStreamerBeautyActivity.this.F2().b();
            ((FKLiveBeautyGLSurfaceView) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamerLiveTextureView)).e();
            ((FKLiveForStreamerBottomMenuLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamerLiveMenuLayout)).t(LivePkType.MultiPk, false);
            ((LiveStickerEditMaskLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamer_sticker_edit_mask_layout)).setCanDisplaySticker(true);
            FKLiveForStreamerBeautyActivity.this.b3(false);
            FKLiveForStreamerBeautyActivity.this.T2(false);
        }

        @Override // com.cupidapp.live.liveshow.pk.view.e
        public void b() {
            FKLiveForStreamerBeautyActivity.this.V2();
        }

        @Override // com.cupidapp.live.liveshow.pk.view.e
        public void c(int i10, int i11) {
            ((FKLiveBeautyGLSurfaceView) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamerLiveTextureView)).f(z0.h.c(this, 2.0f), ((MultiPkLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamer_multi_pk_layout)).getY(), i10, i11, 0.0f);
            ((FKLiveForStreamerBottomMenuLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamerLiveMenuLayout)).t(LivePkType.MultiPk, true);
            ((LiveStickerEditMaskLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamer_sticker_edit_mask_layout)).setCanDisplaySticker(false);
            FKLiveForStreamerBeautyActivity.this.b3(true);
            if (((FKLiveGiftEnterAnimationLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamerGiftEnterAnimationLayout)).h()) {
                FKLiveForStreamerBeautyActivity.this.T2(true);
            }
        }

        @Override // com.cupidapp.live.liveshow.pk.view.e
        public void d(int i10) {
            ((FKLiveBeautyGLSurfaceView) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamerLiveTextureView)).setY(i10);
        }

        @Override // com.cupidapp.live.liveshow.pk.view.e
        public void e() {
            FKLiveForStreamerBeautyActivity.this.G2().g();
        }

        @Override // com.cupidapp.live.liveshow.pk.view.e
        public void f(@NotNull MultiPersonPkState pkState) {
            s.i(pkState, "pkState");
            FKLiveForStreamerBeautyActivity.this.G2().e(pkState);
        }

        @Override // com.cupidapp.live.liveshow.pk.view.e
        public void g(@NotNull String liveShowId, @NotNull MultiPkInviteStatus inviteStatus) {
            s.i(liveShowId, "liveShowId");
            s.i(inviteStatus, "inviteStatus");
            FKLiveForStreamerBeautyActivity.this.F2().a(liveShowId, inviteStatus);
        }

        @Override // com.cupidapp.live.liveshow.pk.view.e
        public void h(int i10, int i11) {
            FKLiveBeautyGLSurfaceView streamerLiveTextureView = (FKLiveBeautyGLSurfaceView) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamerLiveTextureView);
            s.h(streamerLiveTextureView, "streamerLiveTextureView");
            y.n(streamerLiveTextureView, Integer.valueOf(i10), Integer.valueOf(i11));
        }

        @Override // com.cupidapp.live.liveshow.pk.view.e
        public void i() {
            FKLiveForStreamerBeautyActivity.this.G2().m();
        }
    }

    /* compiled from: FKLiveForStreamerBeautyActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class h implements com.cupidapp.live.liveshow.pk.util.a {
        public h() {
        }

        @Override // com.cupidapp.live.liveshow.pk.util.a
        public void a() {
            FKLiveForStreamerBeautyActivity.this.G2().h();
        }
    }

    /* compiled from: FKLiveForStreamerBeautyActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class i implements LiveBeautyDownloader.a {
        public i() {
        }

        @Override // com.cupidapp.live.base.network.download.LiveBeautyDownloader.a
        public void onError() {
            FKAlertLayout.f12456d.d(FKLiveForStreamerBeautyActivity.this.getWindow());
            FKLiveForStreamerBeautyActivity.this.U2();
        }

        @Override // com.cupidapp.live.base.network.download.LiveBeautyDownloader.a
        public void onFinish() {
            FKAlertLayout.f12456d.d(FKLiveForStreamerBeautyActivity.this.getWindow());
            FKLiveForStreamerBeautyActivity.this.n2();
        }

        @Override // com.cupidapp.live.base.network.download.LiveBeautyDownloader.a
        public void onSuccess() {
            FKAlertLayout.f12456d.d(FKLiveForStreamerBeautyActivity.this.getWindow());
            com.cupidapp.live.base.view.h.f12779a.b(R$string.download_success);
            FKLiveForStreamerBeautyActivity.this.n2();
        }
    }

    /* compiled from: FKLiveForStreamerBeautyActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class j implements com.cupidapp.live.liveshow.view.music.d<String> {
        public j() {
        }

        @Override // com.cupidapp.live.liveshow.view.music.d
        public void a(@NotNull String string, @Nullable Integer num) {
            s.i(string, "string");
            FKLiveForStreamerBeautyActivity.this.V0();
        }

        @Override // com.cupidapp.live.liveshow.view.music.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void success(@NotNull String data) {
            s.i(data, "data");
            FKLiveForStreamerBeautyActivity.this.V0();
            FKLiveForStreamerBeautyActivity.this.E = data;
            FKLiveForStreamerBeautyActivity.this.W2();
            FKLiveUtil fKLiveUtil = FKLiveUtil.f14913a;
            fKLiveUtil.d();
            FKLiveBeautyGLSurfaceView streamerLiveTextureView = (FKLiveBeautyGLSurfaceView) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamerLiveTextureView);
            s.h(streamerLiveTextureView, "streamerLiveTextureView");
            fKLiveUtil.v(streamerLiveTextureView);
        }
    }

    /* compiled from: FKLiveForStreamerBeautyActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class k extends com.cupidapp.live.liveshow.entity.c {
        public k() {
        }

        @Override // com.cupidapp.live.liveshow.entity.c, com.zego.zegoliveroom.callback.IZegoLivePlayerCallback
        public void onPlayStateUpdate(int i10, @Nullable String str) {
            super.onPlayStateUpdate(i10, str);
            if (i10 == 0) {
                FKLiveForStreamerBeautyActivity.this.M2(str);
            }
        }
    }

    /* compiled from: FKLiveForStreamerBeautyActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class l extends com.cupidapp.live.liveshow.entity.d {
        public l() {
        }

        @Override // com.cupidapp.live.liveshow.entity.d, com.zego.zegoliveroom.callback.IZegoLivePublisherCallback
        public void onPublishStateUpdate(int i10, @Nullable String str, @Nullable HashMap<String, Object> hashMap) {
            super.onPublishStateUpdate(i10, str, hashMap);
            if (i10 == 0) {
                LiveConnectLayout streamer_connect_layout = (LiveConnectLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamer_connect_layout);
                s.h(streamer_connect_layout, "streamer_connect_layout");
                LiveConnectLayout.x(streamer_connect_layout, false, false, false, 7, null);
                return;
            }
            LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
            if (s.d(str, liveShowModel != null ? liveShowModel.getStreamId() : null)) {
                FKLiveForStreamerBeautyActivity.this.Y2();
                j1.f.f50231a.a(TrackAppErrorType.PUBLISH_STREAM_FAILED, "streamID: " + str + " stateCode: " + i10);
            }
        }
    }

    /* compiled from: FKLiveForStreamerBeautyActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class m implements com.cupidapp.live.liveshow.pk.fragment.b {
        public m() {
        }

        @Override // com.cupidapp.live.liveshow.pk.fragment.b
        public void a(@NotNull MultiPkAnchorModel model, int i10) {
            s.i(model, "model");
            ((MultiPkLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamer_multi_pk_layout)).x(model, i10);
        }

        @Override // com.cupidapp.live.liveshow.pk.fragment.b
        public void b(@NotNull MultiPkAnchorModel model) {
            s.i(model, "model");
            ((MultiPkLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamer_multi_pk_layout)).F(model.getLiveShowId());
        }
    }

    public static /* synthetic */ void d3(FKLiveForStreamerBeautyActivity fKLiveForStreamerBeautyActivity, long j10, List list, List list2, boolean z10, int i10, Object obj) {
        fKLiveForStreamerBeautyActivity.c3(j10, list, list2, (i10 & 8) != 0 ? true : z10);
    }

    public static final boolean p2(FKLiveForStreamerBeautyActivity this$0, View view, MotionEvent motionEvent) {
        s.i(this$0, "this$0");
        if (motionEvent.getAction() != 1) {
            return this$0.u1();
        }
        ((FrameLayout) this$0.G1(R$id.streamerLiveWebContainerLayout)).performClick();
        return this$0.m1();
    }

    public static final void v2(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void A(@NotNull KickOutLiveRoomMessageModel kickOutLiveRoomMessageModel) {
        a.C0157a.r(this, kickOutLiveRoomMessageModel);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void A0(@NotNull RefreshFollowLiveStatusMessageModel refreshFollowLiveStatusMessageModel) {
        a.C0157a.N(this, refreshFollowLiveStatusMessageModel);
    }

    public final void A2() {
        String itemId;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.r().E(itemId).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<SummaryDataResult, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$finishLiveSHow$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SummaryDataResult summaryDataResult) {
                m2595invoke(summaryDataResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2595invoke(SummaryDataResult summaryDataResult) {
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void B(@NotNull LivePkAppointRejectConnectMessage messageModel) {
        s.i(messageModel, "messageModel");
        if (messageModel.getEntity().isAppointed()) {
            D2().g(messageModel.getEntity().getUserName(), this);
        } else {
            D2().i();
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void B0(@NotNull LiveConnectPushStreamStartMessage messageModel) {
        s.i(messageModel, "messageModel");
        LiveConnectLayout streamer_connect_layout = (LiveConnectLayout) G1(R$id.streamer_connect_layout);
        s.h(streamer_connect_layout, "streamer_connect_layout");
        LiveConnectLayout.x(streamer_connect_layout, false, true, false, 5, null);
    }

    public final FKFanClubManager B2() {
        return (FKFanClubManager) this.H.getValue();
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void C0(@NotNull LiveCriticalHitConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        FKLiveSendGiftCriticalHitView streamerLiveCriticalHitView = (FKLiveSendGiftCriticalHitView) G1(R$id.streamerLiveCriticalHitView);
        s.h(streamerLiveCriticalHitView, "streamerLiveCriticalHitView");
        FKLiveSendGiftCriticalHitView.f(streamerLiveCriticalHitView, messageModel.getEntity().getCritInfo(), false, null, 4, null);
    }

    public final FKGRPCMessageIdCounter C2() {
        return (FKGRPCMessageIdCounter) this.C.getValue();
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void D(@NotNull LiveBroadcastConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        ((FKLiveBroadcastLayout) G1(R$id.streamerLiveBroadcastLayout)).e(messageModel.getEntity());
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void D0(@NotNull LivePkUpdateConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        ((FKLivePkWarLayout) G1(R$id.streamerLivePkWarLayout)).a0(messageModel);
    }

    public final FKLivePkManager D2() {
        return (FKLivePkManager) this.F.getValue();
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void E(@NotNull RedEnvelopeConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        ((LiveRedEnvelopeView) G1(R$id.streamer_red_envelope_view)).c(messageModel.getEntity());
    }

    public final void E2() {
        String userId;
        User X = p1.g.f52734a.X();
        if (X == null || (userId = X.userId()) == null) {
            return;
        }
        Disposable disposed = a.C0826a.d(NetworkClient.f11868a.r(), userId, 0, 2, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<LiveStickerResult, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$getLiveStickers$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LiveStickerResult liveStickerResult) {
                m2596invoke(liveStickerResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2596invoke(LiveStickerResult liveStickerResult) {
                ((FKLiveBeautyLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamerBeautyLayout)).m(liveStickerResult.getLightenChildPrivilege());
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void F(@NotNull LiveStickerUpdateConnectorMessageModel liveStickerUpdateConnectorMessageModel) {
        a.C0157a.W(this, liveStickerUpdateConnectorMessageModel);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void F0(@NotNull MultiPkAgreeInvitingModel messageModel) {
        s.i(messageModel, "messageModel");
        ((MultiPkLayout) G1(R$id.streamer_multi_pk_layout)).g(messageModel.getPkLiveShowId(), messageModel.getPkStreamId());
        F2().a(messageModel.getPkLiveShowId(), MultiPkInviteStatus.Accept);
    }

    public final com.cupidapp.live.liveshow.pk.util.c F2() {
        return (com.cupidapp.live.liveshow.pk.util.c) this.I.getValue();
    }

    @Nullable
    public View G1(int i10) {
        Map<Integer, View> map = this.P;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final MultiPersonPkPresenter G2() {
        return (MultiPersonPkPresenter) this.O.getValue();
    }

    public final f1.b H2() {
        return (f1.b) this.J.getValue();
    }

    public final void I2(LiveShowResult liveShowResult) {
        if (liveShowResult == null) {
            return;
        }
        FKLiveConstantsData.INSTANCE.setFkLiveShowResult(liveShowResult);
        AnchorGradeInfoModel anchorGradeInfo = liveShowResult.getAnchorGradeInfo();
        this.G = anchorGradeInfo != null ? Integer.valueOf(anchorGradeInfo.getLevel()) : null;
        FKLiveGrpcEntity.p(FKLiveGrpcEntity.f14907e.a(), false, null, 2, null);
        FKActorInfoAndAudienceLayout handleLiveShowResultSuccess$lambda$6 = (FKActorInfoAndAudienceLayout) G1(R$id.streamerLiveActorUserInfoLayout);
        s.h(handleLiveShowResultSuccess$lambda$6, "handleLiveShowResultSuccess$lambda$6");
        FKActorInfoAndAudienceLayout.p(handleLiveShowResultSuccess$lambda$6, liveShowResult.getLiveShow(), null, 2, null);
        handleLiveShowResultSuccess$lambda$6.m(liveShowResult.getAnchorGradeInfo());
        handleLiveShowResultSuccess$lambda$6.s(liveShowResult.getHeatValues());
        handleLiveShowResultSuccess$lambda$6.q(liveShowResult.getAnchorProfileBorder());
        int i10 = R$id.streamerLiveMenuLayout;
        FKLiveForStreamerBottomMenuLayout fKLiveForStreamerBottomMenuLayout = (FKLiveForStreamerBottomMenuLayout) G1(i10);
        fKLiveForStreamerBottomMenuLayout.s(liveShowResult.getPkIcon());
        fKLiveForStreamerBottomMenuLayout.setConnectLayoutVisible(liveShowResult.getLiveShow().getAnchorCanConnectLive());
        String redPacketCreateUrl = liveShowResult.getRedPacketCreateUrl();
        fKLiveForStreamerBottomMenuLayout.u(!(redPacketCreateUrl == null || redPacketCreateUrl.length() == 0));
        ((FKLiveForStreamerSummaryLayout) G1(R$id.streamerLiveSummaryLayout)).d(liveShowResult.getLiveShow().getUser());
        LiveShowModel pkLiveShow = liveShowResult.getPkLiveShow();
        if (pkLiveShow != null) {
            FKLivePkWarLayout streamerLivePkWarLayout = (FKLivePkWarLayout) G1(R$id.streamerLivePkWarLayout);
            s.h(streamerLivePkWarLayout, "streamerLivePkWarLayout");
            FKLivePkWarLayout.F(streamerLivePkWarLayout, liveShowResult.getLiveShow(), pkLiveShow, liveShowResult.getSofa(), liveShowResult.getPkContributionPath(), false, false, false, 64, null);
        }
        ((FKLiveShowAdLayout) G1(R$id.streamer_live_ad_layout)).s(liveShowResult.getAdBadge(), false);
        ((FKLiveShowActivityLayout) G1(R$id.streamer_live_activity_layout)).s(liveShowResult.getActivities(), false);
        ((LiveShowRankTagListLayout) G1(R$id.streamer_live_show_tag_layout)).a(liveShowResult.getLiveShowTagList());
        ((FKLivePrayBattleView) G1(R$id.streamerLivePrayBattleView)).f(liveShowResult.getLotteryBattleInfo(), liveShowResult.getLotteryBattleNormalInfo(), false);
        FKLiveSendGiftCriticalHitView streamerLiveCriticalHitView = (FKLiveSendGiftCriticalHitView) G1(R$id.streamerLiveCriticalHitView);
        s.h(streamerLiveCriticalHitView, "streamerLiveCriticalHitView");
        FKLiveSendGiftCriticalHitView.f(streamerLiveCriticalHitView, liveShowResult.getCritInfo(), false, null, 4, null);
        ((GiftCollectionLayout) G1(R$id.streamer_gift_collection_layout)).h(liveShowResult.getGiftCollect());
        ((StarChallengeChestView) G1(R$id.streamer_star_challenge_chest_view)).i(liveShowResult.getStarLevelChest(), false);
        ((LiveStickerEditMaskLayout) G1(R$id.streamer_sticker_edit_mask_layout)).r(false, liveShowResult.getSticker());
        ((FKLiveForStreamerBottomMenuLayout) G1(i10)).F(liveShowResult);
    }

    public final void J2() {
        FKLiveUtil.f14913a.y();
        r2.i.f53231b.q();
        ((FKLiveBeautyGLSurfaceView) G1(R$id.streamerLiveTextureView)).setSurface();
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void K(@NotNull MultiPkCancelPrepareModel messageModel) {
        s.i(messageModel, "messageModel");
        String liveShowId = messageModel.getLiveShowId();
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
        if (s.d(liveShowId, liveShowModel != null ? liveShowModel.getItemId() : null)) {
            return;
        }
        if (messageModel.isInitiator()) {
            ((MultiPkLayout) G1(R$id.streamer_multi_pk_layout)).w();
        } else {
            String liveShowId2 = messageModel.getLiveShowId();
            LiveShowModel liveShowModel2 = fKLiveConstantsData.getLiveShowModel();
            if (!s.d(liveShowId2, liveShowModel2 != null ? liveShowModel2.getItemId() : null)) {
                ((MultiPkLayout) G1(R$id.streamer_multi_pk_layout)).G(messageModel.getLiveShowId());
            }
        }
        String liveShowId3 = messageModel.getLiveShowId();
        LiveShowModel liveShowModel3 = fKLiveConstantsData.getLiveShowModel();
        if (s.d(liveShowId3, liveShowModel3 != null ? liveShowModel3.getItemId() : null)) {
            return;
        }
        com.cupidapp.live.base.view.h.f12779a.m(this, messageModel.getTips());
    }

    public final void K2() {
        r2.i.f53231b.x();
        if (((FKLiveStreamerOpenLiveLayout) G1(R$id.streamerOpenLiveLayout)).getVisibility() != 0) {
            FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
            if (fKLiveConstantsData.getFkLiveShowResult() == null) {
                return;
            }
            FKLiveUtil fKLiveUtil = FKLiveUtil.f14913a;
            com.cupidapp.live.liveshow.entity.d dVar = this.K;
            FKLiveBeautyGLSurfaceView streamerLiveTextureView = (FKLiveBeautyGLSurfaceView) G1(R$id.streamerLiveTextureView);
            s.h(streamerLiveTextureView, "streamerLiveTextureView");
            fKLiveUtil.E(dVar, streamerLiveTextureView);
            LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
            if (liveShowModel != null) {
                P2(liveShowModel);
            }
            ((FKActorInfoAndAudienceLayout) G1(R$id.streamerLiveActorUserInfoLayout)).t();
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void L0(@NotNull LiveAnchorPrivilegeEndUseConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        int i10 = R$id.streamerLivePrivilegeStatusLayout;
        ((FKLivePrivilegeStatusLayout) G1(i10)).setVisibility(8);
        ((FKLivePrivilegeStatusLayout) G1(i10)).g();
        ((LinearLayout) G1(R$id.streamer_ad_and_activity_layout)).setVisibility(0);
    }

    public final void L2() {
        p1.g gVar = p1.g.f52734a;
        gVar.x2(true);
        ConstraintLayout streamerLiveActorInfoAndCloseLayout = (ConstraintLayout) G1(R$id.streamerLiveActorInfoAndCloseLayout);
        s.h(streamerLiveActorInfoAndCloseLayout, "streamerLiveActorInfoAndCloseLayout");
        com.cupidapp.live.base.view.s.b(this, streamerLiveActorInfoAndCloseLayout);
        ((ConstraintLayout) G1(R$id.streamerUILayout)).setVisibility(0);
        FKLiveGrpcEntity.f14907e.a().r(this);
        ((FKLiveBarrageLayout) G1(R$id.streamerLiveBarrageLayout)).c(true);
        I2(FKLiveConstantsData.INSTANCE.getFkLiveShowResult());
        FKLiveUtil fKLiveUtil = FKLiveUtil.f14913a;
        com.cupidapp.live.liveshow.entity.d dVar = this.K;
        FKLiveBeautyGLSurfaceView streamerLiveTextureView = (FKLiveBeautyGLSurfaceView) G1(R$id.streamerLiveTextureView);
        s.h(streamerLiveTextureView, "streamerLiveTextureView");
        fKLiveUtil.i(dVar, streamerLiveTextureView);
        com.cupidapp.live.base.view.h.f12779a.c(this, gVar.T() ? R$string.live_start_camera_mirror_open_tip : R$string.live_start_camera_mirror_close_tip);
        FKLiveGiftEnterAnimationLayout streamerGiftEnterAnimationLayout = (FKLiveGiftEnterAnimationLayout) G1(R$id.streamerGiftEnterAnimationLayout);
        s.h(streamerGiftEnterAnimationLayout, "streamerGiftEnterAnimationLayout");
        FKLiveGiftEnterAnimationLayout.f(streamerGiftEnterAnimationLayout, true, null, 2, null);
        ((FKLiveShakeAnimationLayout) G1(R$id.streamerShakeAnimationLayout)).setShakeable(false);
        ((FKLiveGiftAnimationLayout) G1(R$id.streamerLiveGiftAnimationLayout)).e(this);
        ((FKLiveCommentLayout) G1(R$id.streamerLiveCommentLayout)).j(true);
        ((FullLiveVisibleGiftLayout) G1(R$id.streamer_full_live_visible_gift_layout)).g(this);
        o2();
        r2();
        q2();
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void M(@NotNull ViewerLeaveConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        FKActorInfoAndAudienceLayout fKActorInfoAndAudienceLayout = (FKActorInfoAndAudienceLayout) G1(R$id.streamerLiveActorUserInfoLayout);
        ViewerLeaveModel entity = messageModel.getEntity();
        fKActorInfoAndAudienceLayout.z(entity != null ? entity.getUserId() : null);
    }

    public final void M2(String str) {
        LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
        FKLiveType liveType = fkLiveShowResult != null ? fkLiveShowResult.getLiveType() : null;
        if ((liveType == null ? -1 : b.f14754a[liveType.ordinal()]) == 1) {
            ((FKLivePkWarLayout) G1(R$id.streamerLivePkWarLayout)).V(str);
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void N(@NotNull LiveEndConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        String message = messageModel.getEntity().getMessage();
        String style = messageModel.getEntity().getStyle();
        if (!(message == null || message.length() == 0)) {
            if (!(style == null || style.length() == 0) && s.d(style, "alert")) {
                FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, this, false, 2, null).n(message), 0, null, null, 7, null), null, 1, null);
            }
        }
        w2();
        StickerGiftHelper.f15469a.e();
    }

    public final void N2() {
        if (z0.h.g(this) == NetworkStateConstants.DISCONNECT) {
            com.cupidapp.live.base.view.h.f12779a.r(this, R$string.please_check_your_network);
            return;
        }
        if (this.E != null) {
            W2();
            return;
        }
        e1();
        User X = p1.g.f52734a.X();
        if (X == null) {
            return;
        }
        String userId = Base64.encodeToString(l1.a.c(X.userId(), "4503fb7f0f6ebe50"), 2);
        com.cupidapp.live.liveshow.view.music.c cVar = com.cupidapp.live.liveshow.view.music.c.f15798a;
        s.h(userId, "userId");
        cVar.d(this, "Finka", userId, new j());
    }

    public final void O2(final String str, boolean z10, final String str2) {
        e1();
        Disposable disposed = a.C0826a.h(NetworkClient.f11868a.r(), str, null, Boolean.valueOf(z10), 2, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<LiveShowResult, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$openLive$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LiveShowResult liveShowResult) {
                m2599invoke(liveShowResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2599invoke(LiveShowResult liveShowResult) {
                FKLiveForStreamerBeautyActivity fKLiveForStreamerBeautyActivity = FKLiveForStreamerBeautyActivity.this;
                int i10 = R$id.streamerOpenLiveLayout;
                ((FKLiveStreamerOpenLiveLayout) fKLiveForStreamerBeautyActivity.G1(i10)).J(true);
                FKLiveConstantsData.INSTANCE.setFkLiveShowResult(liveShowResult);
                FKLiveForStreamerBeautyActivity.this.S2(str, str2);
                ((FKLiveStreamerOpenLiveLayout) FKLiveForStreamerBeautyActivity.this.G1(i10)).A();
                ((ConstraintLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamerUILayout)).setVisibility(0);
                FKLiveForStreamerBeautyActivity.this.A = true;
                j.a aVar = j.f14922f;
                final FKLiveForStreamerBeautyActivity fKLiveForStreamerBeautyActivity2 = FKLiveForStreamerBeautyActivity.this;
                aVar.b(new Function2<Boolean, Boolean, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$openLive$1$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ p mo1743invoke(Boolean bool, Boolean bool2) {
                        invoke(bool.booleanValue(), bool2.booleanValue());
                        return p.f51048a;
                    }

                    public final void invoke(boolean z11, boolean z12) {
                        FKLiveForStreamerBeautyActivity.this.V0();
                        FKLiveForStreamerBeautyActivity.this.L2();
                        ((FKActorInfoAndAudienceLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamerLiveActorUserInfoLayout)).t();
                    }
                });
                LaunchDownloader.f11925a.v(FKLiveForStreamerBeautyActivity.this);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$openLive$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                FKLiveForStreamerBeautyActivity fKLiveForStreamerBeautyActivity = FKLiveForStreamerBeautyActivity.this;
                int i10 = R$id.streamerOpenLiveLayout;
                ((FKLiveStreamerOpenLiveLayout) fKLiveForStreamerBeautyActivity.G1(i10)).setVisibility(0);
                ((FKLiveStreamerOpenLiveLayout) FKLiveForStreamerBeautyActivity.this.G1(i10)).L();
                ((FKLiveStreamerOpenLiveLayout) FKLiveForStreamerBeautyActivity.this.G1(i10)).J(true);
                FKLiveForStreamerBeautyActivity.this.V0();
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void P2(LiveShowModel liveShowModel) {
        Disposable disposed = NetworkClient.f11868a.r().g0(liveShowModel.getItemId(), liveShowModel.getRecommendId(), Boolean.TRUE).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<LiveShowResult, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$refreshLiveShowData$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LiveShowResult liveShowResult) {
                m2600invoke(liveShowResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2600invoke(LiveShowResult liveShowResult) {
                com.cupidapp.live.liveshow.entity.c cVar;
                LiveShowResult liveShowResult2 = liveShowResult;
                FKLiveForStreamerBeautyActivity.this.I2(liveShowResult2);
                FKLiveUtil.f14913a.G(liveShowResult2.getCurrentAllStreamIdList());
                FKLivePkWarLayout fKLivePkWarLayout = (FKLivePkWarLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamerLivePkWarLayout);
                cVar = FKLiveForStreamerBeautyActivity.this.L;
                fKLivePkWarLayout.Q(true, false, cVar);
                LiveConnectLayout streamer_connect_layout = (LiveConnectLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamer_connect_layout);
                s.h(streamer_connect_layout, "streamer_connect_layout");
                LiveConnectLayout.x(streamer_connect_layout, false, false, false, 7, null);
                if (liveShowResult2.getLiveShow().getMultiPkInfo() != null) {
                    MultiPkLayout multiPkLayout = (MultiPkLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamer_multi_pk_layout);
                    MultiPkInfoModel multiPkInfo = liveShowResult2.getLiveShow().getMultiPkInfo();
                    s.f(multiPkInfo);
                    multiPkLayout.E(multiPkInfo);
                    return;
                }
                FKLiveForStreamerBeautyActivity fKLiveForStreamerBeautyActivity = FKLiveForStreamerBeautyActivity.this;
                int i10 = R$id.streamer_multi_pk_layout;
                MultiPkLayout streamer_multi_pk_layout = (MultiPkLayout) fKLiveForStreamerBeautyActivity.G1(i10);
                s.h(streamer_multi_pk_layout, "streamer_multi_pk_layout");
                if (streamer_multi_pk_layout.getVisibility() == 0) {
                    ((MultiPkLayout) FKLiveForStreamerBeautyActivity.this.G1(i10)).w();
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void Q2() {
        f1.b.b(H2(), this, new Function0<p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$registerNetwork$1
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
                z10 = FKLiveForStreamerBeautyActivity.this.A;
                if (z10) {
                    FKLiveForStreamerBeautyActivity.this.t2();
                }
            }
        }, null, 4, null);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void R(@NotNull LiveShowMoreMenuUnreadMessageModel messageModel) {
        String str;
        List<String> list;
        s.i(messageModel, "messageModel");
        List<String> list2 = messageModel.getList();
        if (!(list2 == null || list2.isEmpty())) {
            ((FKLiveForStreamerBottomMenuLayout) G1(R$id.streamerLiveMenuLayout)).G(true);
            Iterator<String> iterator2 = list2.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    str = null;
                    break;
                } else {
                    str = iterator2.next();
                    if (kotlin.text.p.r(str, MenuType.GiftWall.getType(), true)) {
                        break;
                    }
                }
            }
            if (str != null) {
                LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
                LiveMenuBtnModel giftWall = fkLiveShowResult != null ? fkLiveShowResult.getGiftWall() : null;
                if (giftWall != null) {
                    giftWall.setUnread(true);
                }
            }
            if (this.M == null) {
                this.M = new ArrayList();
            }
            String tips = messageModel.getTips();
            if (tips != null && (list = this.M) != null) {
                list.add(tips);
            }
            u2();
            return;
        }
        ((FKLiveForStreamerBottomMenuLayout) G1(R$id.streamerLiveMenuLayout)).w();
    }

    public final void R2(String str, String str2, boolean z10, SensorsLogLiveShow.LivePkResult livePkResult) {
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        User user = liveShowModel != null ? liveShowModel.getUser() : null;
        SensorsLogLiveShow sensorsLogLiveShow = SensorsLogLiveShow.f12212a;
        String userId = user != null ? user.userId() : null;
        int i10 = R$id.streamerLivePkWarLayout;
        int pkDurationOrPunishDuration = ((FKLivePkWarLayout) G1(i10)).getPkDurationOrPunishDuration();
        Integer g3 = FKLiveGrpcEntity.f14907e.a().g();
        sensorsLogLiveShow.k(str, str2, userId, z10, pkDurationOrPunishDuration, g3 != null ? g3.intValue() : 0, livePkResult, ((FKLivePkWarLayout) G1(i10)).getMyGiftCountInPk());
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void S(@NotNull LiveConnectEndConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        com.cupidapp.live.base.view.h.f12779a.k(R$string.others_has_hung_up);
        ((LiveConnectLayout) G1(R$id.streamer_connect_layout)).y();
    }

    public final void S2(String str, String str2) {
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel != null) {
            SensorsLogLiveShow.f12212a.t(liveShowModel.getItemId(), str, str2);
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void T(@NotNull LivePkChatConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        String matchId = messageModel.getEntity().getMatchId();
        String liveShowId = messageModel.getLiveShowId();
        int i10 = R$id.streamerLivePkWarLayout;
        R2(matchId, liveShowId, true, ((FKLivePkWarLayout) G1(i10)).U(messageModel.getEntity().getWinnerLiveShowIds()));
        ((FKLivePkWarLayout) G1(i10)).X(messageModel, false);
    }

    public final void T2(boolean z10) {
        if (((MultiPkLayout) G1(R$id.streamer_multi_pk_layout)).getVisibility() == 0) {
            ((FKLiveCommentLayout) G1(R$id.streamerLiveCommentLayout)).setAlpha(z10 ? 0.4f : 1.0f);
        } else {
            ((FKLiveCommentLayout) G1(R$id.streamerLiveCommentLayout)).setAlpha(1.0f);
        }
    }

    public final void U2() {
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, this, false, 2, null), R$string.download_failed, 0, 2, null).j(false), R$string.re_download, null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$showDownloadFailedPrompt$1
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
                FKLiveForStreamerBeautyActivity.this.z2();
            }
        }, 2, null), 0, new Function0<p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$showDownloadFailedPrompt$2
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
                FKLiveForStreamerBeautyActivity.this.finish();
            }
        }, 1, null), null, 1, null);
    }

    public final void V2() {
        F2().d(G2().f(), new m());
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void W(@NotNull LivePkEndConnectorMessage messageModel) {
        SensorsLogLiveShow.LivePkResult livePkResult;
        SensorsLogLiveShow.LivePkResult livePkResult2;
        s.i(messageModel, "messageModel");
        int i10 = b.f14755b[FKLiveGrpcEntity.f14907e.a().f().ordinal()];
        boolean z10 = true;
        if (i10 != 1) {
            livePkResult2 = i10 == 2 ? ((FKLivePkWarLayout) G1(R$id.streamerLivePkWarLayout)).getPkResult() : null;
            z10 = false;
        } else {
            String userId = messageModel.getEntity().getPkUser().userId();
            User X = p1.g.f52734a.X();
            if (s.d(userId, X != null ? X.userId() : null)) {
                livePkResult = SensorsLogLiveShow.LivePkResult.LivePkFailed;
            } else {
                livePkResult = SensorsLogLiveShow.LivePkResult.LivePkWin;
            }
            livePkResult2 = livePkResult;
        }
        R2(messageModel.getEntity().getMatchId(), messageModel.getLiveShowId(), z10, livePkResult2);
        ((FKLivePkWarLayout) G1(R$id.streamerLivePkWarLayout)).Y(false, messageModel);
        X2(messageModel.getEntity().getPkUser(), messageModel.getEntity().getEndingType());
    }

    public final void W2() {
        if (this.D == null) {
            this.D = new FKLiveMusicFragment();
        }
        FKLiveMusicFragment fKLiveMusicFragment = this.D;
        if (fKLiveMusicFragment != null) {
            fKLiveMusicFragment.m1(getSupportFragmentManager());
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void X(@NotNull LivePkCloseAudioConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        String liveShowId = messageModel.getEntity().getLiveShowId();
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (s.d(liveShowId, liveShowModel != null ? liveShowModel.getItemId() : null)) {
            ((FKLivePkWarLayout) G1(R$id.streamerLivePkWarLayout)).i0(false, messageModel.getEntity().getClose());
        }
    }

    public final void X2(User user, int i10) {
        String userId = user.userId();
        User X = p1.g.f52734a.X();
        if (s.d(userId, X != null ? X.userId() : null)) {
            return;
        }
        if (i10 == 0) {
            com.cupidapp.live.base.view.h.f12779a.s(this, getString(R$string.end_live_pk, new Object[]{user.getName()}));
        } else {
            if (i10 != 1) {
                return;
            }
            com.cupidapp.live.base.view.h.f12779a.s(this, getString(R$string.live_pk_dropped, new Object[]{user.getName()}));
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void Y(@NotNull LiveAnchorPrivilegeInUseConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        ((LinearLayout) G1(R$id.streamer_ad_and_activity_layout)).setVisibility(8);
        ((FKLivePrivilegeStatusLayout) G1(R$id.streamerLivePrivilegeStatusLayout)).c(messageModel);
    }

    public final void Y2() {
        FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, this, false, 2, null), R$string.publish_failed_prompt, 0, 2, null), R$string.i_know, null, null, 6, null), null, 1, null);
    }

    public final void Z2(SummaryModel summaryModel) {
        int i10 = R$id.streamerLiveSummaryLayout;
        if (((FKLiveForStreamerSummaryLayout) G1(i10)).getVisibility() == 0) {
            return;
        }
        this.A = false;
        FKLiveGrpcEntity.f14907e.a().k();
        FKLiveUtil.f14913a.m();
        ((FKLiveForStreamerSummaryLayout) G1(i10)).c(new Function0<p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$showSummaryForStreamerLayout$1
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
                FKLiveForStreamerBeautyActivity.this.onBackPressed();
            }
        });
        ((FKLiveForStreamerSummaryLayout) G1(i10)).e(summaryModel);
        ((ConstraintLayout) G1(R$id.streamerUILayout)).setVisibility(8);
        ((FKLiveForStreamerSummaryLayout) G1(i10)).setVisibility(0);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void a(@NotNull StarChallengeLvlUpgradeConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        StarChallengeLvlUpgradeLayout starChallengeLvlUpgradeLayout = (StarChallengeLvlUpgradeLayout) G1(R$id.streamer_star_challenge_lvl_upgrade_layout);
        StarChallengeLvlUpgradeModel entity = messageModel.getEntity();
        starChallengeLvlUpgradeLayout.d(entity != null ? entity.getText() : null);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void a0(@NotNull StarChallengeChestConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        ((StarChallengeChestView) G1(R$id.streamer_star_challenge_chest_view)).i(messageModel.getEntity(), false);
    }

    public final void a3() {
        FKLiveGrpcEntity.f14907e.a().m(this, new Function1<LiveShowPkWarResult, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$startLivePkConnect$1
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
                FKLivePkWarLayout fKLivePkWarLayout = (FKLivePkWarLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamerLivePkWarLayout);
                cVar = FKLiveForStreamerBeautyActivity.this.L;
                fKLivePkWarLayout.Z(it, false, cVar);
            }
        });
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void b(@NotNull LivePkStartConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        if (AppApplication.f11612d.e()) {
            D2().h();
            LiveHeatCountDesDialog p12 = p1();
            if (p12 != null) {
                p12.c();
            }
            FKLiveMiniProfileFragment q12 = q1();
            if (q12 != null) {
                q12.Q0();
            }
        } else {
            D2().j(null, messageModel.getEntity().getPkType());
        }
        a3();
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel != null) {
            SensorsLogLiveShow.f12212a.m(messageModel.getEntity().getMatchId(), messageModel.getLiveShowId(), liveShowModel.getUser().userId(), messageModel.getEntity().getPkType());
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void b0(@NotNull CommentConnectorMessage messageModel, @NotNull ConnectorMessageEvent event) {
        s.i(messageModel, "messageModel");
        s.i(event, "event");
        d3(this, event.getMessage().getMessageId(), messageModel.getActivities(), messageModel.getLiveAdBadge(), false, 8, null);
        m2(new FKLiveCommentMessageViewModel(messageModel.getEntity(), false, 2, null));
        ((FKActorInfoAndAudienceLayout) G1(R$id.streamerLiveActorUserInfoLayout)).k(messageModel.getViewersSeat());
    }

    public final void b3(boolean z10) {
        if (z10) {
            ((FKLiveGiftEnterAnimationLayout) G1(R$id.streamerGiftEnterAnimationLayout)).setTranslationY(((FKLiveGiftEnterAnimationLayout) G1(r3)).getHeight() - z0.h.c(this, 50.0f));
            return;
        }
        ((FKLiveGiftEnterAnimationLayout) G1(R$id.streamerGiftEnterAnimationLayout)).setTranslationY(0.0f);
    }

    public final void c3(long j10, final List<LiveActivityModel> list, final List<BadgeModel> list2, final boolean z10) {
        C2().checkAndUpdate(j10, new Function0<p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$updateActivityLayout$1
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
                    ((FKLiveShowActivityLayout) this.G1(R$id.streamer_live_activity_layout)).s(list, false);
                }
                ((FKLiveShowAdLayout) this.G1(R$id.streamer_live_ad_layout)).s(list2, false);
            }
        });
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void d(@NotNull LiveAnchorPrivilegeLineUpConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        ((LinearLayout) G1(R$id.streamer_ad_and_activity_layout)).setVisibility(8);
        ((FKLivePrivilegeStatusLayout) G1(R$id.streamerLivePrivilegeStatusLayout)).d(messageModel);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void d0(@NotNull FKLiveHornModel messageModel) {
        s.i(messageModel, "messageModel");
        a.C0157a.q(this, messageModel);
        ((FKLiveBaseHornLayout) G1(R$id.liveHornLayout)).f(messageModel);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void e(@NotNull LivePkAppointRequestConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        if (AppApplication.f11612d.e()) {
            D2().f();
            D2().p(messageModel.getEntity(), new Function0<p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$livePkAppointRequestConnector$1
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
                    FKLiveMiniProfileFragment q12 = FKLiveForStreamerBeautyActivity.this.q1();
                    if (q12 != null) {
                        q12.Q0();
                    }
                    LiveHeatCountDesDialog p12 = FKLiveForStreamerBeautyActivity.this.p1();
                    if (p12 != null) {
                        p12.c();
                    }
                }
            });
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void e0(@NotNull LiveAnchorPrivilegeHintConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        FKLivePrivilegeDialogLayout.f15837c.a(this, messageModel);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void f(@NotNull NotifyConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        NotifyMessageModel entity = messageModel.getEntity();
        String message = entity.getMessage();
        if (message == null || message.length() == 0) {
            return;
        }
        int messageType = entity.getMessageType();
        if (messageType == NotifyMessageType.SystemMessage.getType()) {
            m2(new FKLiveSystemMessageViewModel(entity.getMessage(), messageModel.getEntity().getUser(), messageModel.getEntity().getSystemLabels()));
        } else if (messageType == NotifyMessageType.CommentGuideMessage.getType()) {
            ((FKLiveCommentLayout) G1(R$id.streamerLiveCommentLayout)).f(entity, true);
        }
        if (s.d(entity.getStyle(), "alert")) {
            FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, this, false, 2, null).n(entity.getMessage()), 0, null, null, 7, null), null, 1, null);
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void f0(@NotNull LiveShowTagConnectorMessageModel messageModel) {
        s.i(messageModel, "messageModel");
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel != null) {
            Disposable disposed = NetworkClient.f11868a.r().X(liveShowModel.getItemId(), messageModel.getEntity().getMessageKey()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<LiveShowRankTagListModel, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$liveShowTagConnector$lambda$22$$inlined$handle$default$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(LiveShowRankTagListModel liveShowRankTagListModel) {
                    m2598invoke(liveShowRankTagListModel);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2598invoke(LiveShowRankTagListModel liveShowRankTagListModel) {
                    ((LiveShowRankTagListLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamer_live_show_tag_layout)).d(liveShowRankTagListModel.getLiveShowTagList());
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                H(disposed);
            }
            s.h(disposed, "disposed");
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if (((FKLiveStreamerOpenLiveLayout) G1(R$id.streamerOpenLiveLayout)).getVisibility() == 8) {
            A2();
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void g(@NotNull MultiPkScoreUpdateModel messageModel) {
        s.i(messageModel, "messageModel");
        ((MultiPkLayout) G1(R$id.streamer_multi_pk_layout)).D(messageModel);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void g0(@NotNull MultiPkMixSuccessModel multiPkMixSuccessModel) {
        a.C0157a.z(this, multiPkMixSuccessModel);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void h(@Nullable HeatValuesModel heatValuesModel) {
        FKActorInfoAndAudienceLayout fKActorInfoAndAudienceLayout = (FKActorInfoAndAudienceLayout) G1(R$id.streamerLiveActorUserInfoLayout);
        if (fKActorInfoAndAudienceLayout != null) {
            fKActorInfoAndAudienceLayout.s(heatValuesModel);
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void h0(@NotNull AnchorInfoBorderConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        ((FKActorInfoAndAudienceLayout) G1(R$id.streamerLiveActorUserInfoLayout)).q(messageModel.getEntity());
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void i(@NotNull LiveShowShakeConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        CommentModel comment = messageModel.getEntity().getComment();
        if (comment != null) {
            m2(new FKLiveCommentMessageViewModel(comment, false, 2, null));
        }
        ((FKLiveShakeAnimationLayout) G1(R$id.streamerShakeAnimationLayout)).k(messageModel.getEntity());
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void j(@NotNull GiftConnectorMessage messageModel, @NotNull ConnectorMessageEvent event) {
        String animationKey;
        s.i(messageModel, "messageModel");
        s.i(event, "event");
        d3(this, event.getMessage().getMessageId(), messageModel.getActivities(), messageModel.getLiveAdBadge(), false, 8, null);
        LiveShowGiftModel entity = messageModel.getEntity();
        GiftItemModel gift = entity.getGift();
        if (gift.getShowInGiftBox()) {
            ((FKLiveGiftEnterAnimationLayout) G1(R$id.streamerGiftEnterAnimationLayout)).j(entity);
            T2(true);
        }
        if (gift.getShowInCommentArea()) {
            m2(new FKLiveGiftMessageViewModel(entity.getSender(), messageModel.getEntity().getLiveGiftCommentLabels(), entity.getOriginalGift(), gift, entity.getDesc(), entity.getCount(), entity.getBackgroundColor(), entity.getBorderColor(), entity.getLeftTopImage(), entity.getRightTopImage(), entity.getLeftBottomImage(), entity.getRightBottomImage(), entity.getGradientDirection()));
        }
        GiftAnimationModel giftAnimation = entity.getGiftAnimation();
        if (giftAnimation != null && (animationKey = giftAnimation.getAnimationKey()) != null) {
            FKLiveGiftAnimationLayout streamerLiveGiftAnimationLayout = (FKLiveGiftAnimationLayout) G1(R$id.streamerLiveGiftAnimationLayout);
            s.h(streamerLiveGiftAnimationLayout, "streamerLiveGiftAnimationLayout");
            FKLiveGiftAnimationLayout.h(streamerLiveGiftAnimationLayout, new LiveShowAnimationModel(animationKey, giftAnimation.getSoundKey(), AnimationType.Gift), false, entity.getCount(), 2, null);
        }
        ((FKActorInfoAndAudienceLayout) G1(R$id.streamerLiveActorUserInfoLayout)).k(messageModel.getViewersSeat());
        StickerGiftHelper.f15469a.d(gift);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void j0(@Nullable String str, @Nullable String str2) {
        FKActorInfoAndAudienceLayout fKActorInfoAndAudienceLayout = (FKActorInfoAndAudienceLayout) G1(R$id.streamerLiveActorUserInfoLayout);
        if (fKActorInfoAndAudienceLayout != null) {
            fKActorInfoAndAudienceLayout.y(str);
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void k0(@NotNull MultiPkMuteOthersModel multiPkMuteOthersModel) {
        a.C0157a.A(this, multiPkMuteOthersModel);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void l(@NotNull NewLiveConnectRequestConnectorMessage messageModel) {
        FKLiveConnectUserPickerFragment fKLiveConnectUserPickerFragment;
        s.i(messageModel, "messageModel");
        NewLiveConnectRequestModel entity = messageModel.getEntity();
        if (entity != null) {
            ((FKLiveForStreamerBottomMenuLayout) G1(R$id.streamerLiveMenuLayout)).q(entity.getWaitingToConnectCount(), true);
            FKLiveConnectUserPickerFragment fKLiveConnectUserPickerFragment2 = this.B;
            if (!(fKLiveConnectUserPickerFragment2 != null && fKLiveConnectUserPickerFragment2.isResumed()) || (fKLiveConnectUserPickerFragment = this.B) == null) {
                return;
            }
            fKLiveConnectUserPickerFragment.n1();
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void l0(@NotNull LivePkFirstBloodConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        ((FKLivePkWarLayout) G1(R$id.streamerLivePkWarLayout)).m0(messageModel.getEntity().getLiveShowId());
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void m(@NotNull LiveAnchorLvlUpgradeAnimationConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        FKLiveGiftAnimationLayout streamerLiveGiftAnimationLayout = (FKLiveGiftAnimationLayout) G1(R$id.streamerLiveGiftAnimationLayout);
        s.h(streamerLiveGiftAnimationLayout, "streamerLiveGiftAnimationLayout");
        FKLiveGiftAnimationLayout.h(streamerLiveGiftAnimationLayout, new LiveShowAnimationModel(messageModel.getAnimationUrl(), null, AnimationType.AnchorUpgrade), true, 0, 4, null);
    }

    public final void m2(FKLiveMessageViewModel fKLiveMessageViewModel) {
        FKLiveCommentMessageViewModel fKLiveCommentMessageViewModel = fKLiveMessageViewModel instanceof FKLiveCommentMessageViewModel ? (FKLiveCommentMessageViewModel) fKLiveMessageViewModel : null;
        if (fKLiveCommentMessageViewModel != null && fKLiveCommentMessageViewModel.getCommentModel().getBarrage()) {
            ((FKLiveBarrageLayout) G1(R$id.streamerLiveBarrageLayout)).e(fKLiveCommentMessageViewModel.getCommentModel());
        } else {
            ((FKLiveCommentLayout) G1(R$id.streamerLiveCommentLayout)).e(fKLiveMessageViewModel);
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void n(@NotNull StartPrayContestConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        ((FKLivePrayBattleView) G1(R$id.streamerLivePrayBattleView)).f(messageModel.getEntity().getLotteryBattleInfo(), messageModel.getEntity().getLotteryBattleNormalInfo(), false);
    }

    public final void n2() {
        ((FKLiveBeautyLayout) G1(R$id.streamerBeautyLayout)).setListener(new c());
        FKLiveStreamerOpenLiveLayout fKLiveStreamerOpenLiveLayout = (FKLiveStreamerOpenLiveLayout) G1(R$id.streamerOpenLiveLayout);
        if (fKLiveStreamerOpenLiveLayout != null) {
            fKLiveStreamerOpenLiveLayout.setOpenLiveLayoutListener(new d());
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void o(@NotNull MultiPkCancelInvitingModel messageModel) {
        s.i(messageModel, "messageModel");
        String pkLiveShowId = messageModel.getPkLiveShowId();
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (s.d(pkLiveShowId, liveShowModel != null ? liveShowModel.getItemId() : null)) {
            com.cupidapp.live.base.view.h.f12779a.k(R$string.others_has_cancelled_invitation);
            F2().c();
        } else {
            ((MultiPkLayout) G1(R$id.streamer_multi_pk_layout)).F(messageModel.getPkLiveShowId());
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void o0(@NotNull LiveAnchorLvlExpChangeConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        ((FKActorInfoAndAudienceLayout) G1(R$id.streamerLiveActorUserInfoLayout)).m(messageModel.getEntity());
        int level = messageModel.getEntity().getLevel();
        Integer num = this.G;
        if (num != null && level == num.intValue()) {
            return;
        }
        this.G = Integer.valueOf(messageModel.getEntity().getLevel());
        E2();
    }

    @Override // com.cupidapp.live.liveshow.activity.FKBaseLiveActivity
    @Nullable
    public FrameLayout o1() {
        return (FrameLayout) G1(R$id.streamerLiveTopRankLayout);
    }

    public final void o2() {
        ImageView closeStreamerLiveShowImageView = (ImageView) G1(R$id.closeStreamerLiveShowImageView);
        s.h(closeStreamerLiveShowImageView, "closeStreamerLiveShowImageView");
        y.d(closeStreamerLiveShowImageView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$bindClickEvent$1
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
                FKLiveForStreamerBeautyActivity.this.onBackPressed();
            }
        });
        ((FKLiveForStreamerBottomMenuLayout) G1(R$id.streamerLiveMenuLayout)).setClickListener(new FKLiveForStreamerBottomMenuLayout.a() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$bindClickEvent$2

            /* compiled from: FKLiveForStreamerBeautyActivity.kt */
            @kotlin.d
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f14757a;

                static {
                    int[] iArr = new int[LivePkType.values().length];
                    try {
                        iArr[LivePkType.DoublePk.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[LivePkType.MultiPk.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f14757a = iArr;
                }
            }

            /* compiled from: FKLiveForStreamerBeautyActivity.kt */
            @kotlin.d
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
            public static final class b implements i {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ FKLiveForStreamerBeautyActivity f14758a;

                public b(FKLiveForStreamerBeautyActivity fKLiveForStreamerBeautyActivity) {
                    this.f14758a = fKLiveForStreamerBeautyActivity;
                }

                @Override // com.cupidapp.live.liveshow.view.remoteconnect.fragment.i
                public void a(@Nullable LiveConnectAcceptResult liveConnectAcceptResult, @Nullable String str) {
                    LiveShowModel liveShow;
                    List<LiveShowModel> connectLive;
                    LiveShowModel liveShowModel;
                    String streamId;
                    Integer waitingToConnectCount;
                    LiveShowModel liveShow2;
                    if (liveConnectAcceptResult != null && (liveShow2 = liveConnectAcceptResult.getLiveShow()) != null) {
                        FKLiveConstantsData.INSTANCE.setLiveShowModel(liveShow2);
                    }
                    if (liveConnectAcceptResult != null && (waitingToConnectCount = liveConnectAcceptResult.getWaitingToConnectCount()) != null) {
                        ((FKLiveForStreamerBottomMenuLayout) this.f14758a.G1(R$id.streamerLiveMenuLayout)).q(waitingToConnectCount.intValue(), false);
                    }
                    if (liveConnectAcceptResult == null || (liveShow = liveConnectAcceptResult.getLiveShow()) == null || (connectLive = liveShow.getConnectLive()) == null) {
                        return;
                    }
                    Iterator<LiveShowModel> iterator2 = connectLive.iterator2();
                    while (true) {
                        if (!iterator2.hasNext()) {
                            liveShowModel = null;
                            break;
                        } else {
                            liveShowModel = iterator2.next();
                            if (s.d(liveShowModel.getUser().userId(), str)) {
                                break;
                            }
                        }
                    }
                    LiveShowModel liveShowModel2 = liveShowModel;
                    if (liveShowModel2 == null || (streamId = liveShowModel2.getStreamId()) == null) {
                        return;
                    }
                    ((LiveConnectLayout) this.f14758a.G1(R$id.streamer_connect_layout)).G(streamId);
                }
            }

            @Override // com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout.a
            public void a() {
                FKLiveForStreamerMoreMenuFragment.a aVar = FKLiveForStreamerMoreMenuFragment.f15321i;
                FragmentManager supportFragmentManager = FKLiveForStreamerBeautyActivity.this.getSupportFragmentManager();
                final FKLiveForStreamerBeautyActivity fKLiveForStreamerBeautyActivity = FKLiveForStreamerBeautyActivity.this;
                aVar.a(supportFragmentManager, new Function1<MenuType, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$bindClickEvent$2$moreClick$1

                    /* compiled from: FKLiveForStreamerBeautyActivity.kt */
                    @kotlin.d
                    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
                    public /* synthetic */ class a {

                        /* renamed from: a, reason: collision with root package name */
                        public static final /* synthetic */ int[] f14759a;

                        static {
                            int[] iArr = new int[MenuType.values().length];
                            try {
                                iArr[MenuType.FanClub.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[MenuType.Music.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            try {
                                iArr[MenuType.GiftEffects.ordinal()] = 3;
                            } catch (NoSuchFieldError unused3) {
                            }
                            try {
                                iArr[MenuType.MagicRefine.ordinal()] = 4;
                            } catch (NoSuchFieldError unused4) {
                            }
                            try {
                                iArr[MenuType.GiftWall.ordinal()] = 5;
                            } catch (NoSuchFieldError unused5) {
                            }
                            try {
                                iArr[MenuType.Sticker.ordinal()] = 6;
                            } catch (NoSuchFieldError unused6) {
                            }
                            f14759a = iArr;
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
                        FKFanClubManager B2;
                        s.i(it, "it");
                        switch (a.f14759a[it.ordinal()]) {
                            case 1:
                                B2 = FKLiveForStreamerBeautyActivity.this.B2();
                                B2.q();
                                return;
                            case 2:
                                FKLiveForStreamerBeautyActivity.this.N2();
                                return;
                            case 3:
                                if (s.d(p1.g.f52734a.Y0(), Boolean.FALSE)) {
                                    ((FKLiveGiftAnimationLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamerLiveGiftAnimationLayout)).d();
                                    return;
                                }
                                return;
                            case 4:
                            case 5:
                            case 6:
                                ((FKLiveForStreamerBottomMenuLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamerLiveMenuLayout)).w();
                                return;
                            default:
                                return;
                        }
                    }
                });
            }

            @Override // com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout.a
            public void b() {
                FKLiveForStreamerBeautyActivity fKLiveForStreamerBeautyActivity = FKLiveForStreamerBeautyActivity.this;
                LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
                FKBaseLiveActivity.C1(fKLiveForStreamerBeautyActivity, fkLiveShowResult != null ? fkLiveShowResult.getRedPacketCreateUrl() : null, false, 2, null);
            }

            @Override // com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout.a
            public void c() {
                Observable<Result<Object>> b02 = NetworkClient.f11868a.r().b0();
                final FKLiveForStreamerBeautyActivity fKLiveForStreamerBeautyActivity = FKLiveForStreamerBeautyActivity.this;
                Disposable disposed = b02.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$bindClickEvent$2$startPkClick$$inlined$handle$default$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Object obj) {
                        invoke2(obj);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object obj) {
                        FKLiveForStreamerBeautyActivity.this.s2();
                    }
                }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, fKLiveForStreamerBeautyActivity)));
                if (disposed != null) {
                    s.h(disposed, "disposed");
                    if (fKLiveForStreamerBeautyActivity != null) {
                        fKLiveForStreamerBeautyActivity.H(disposed);
                    }
                }
                s.h(disposed, "disposed");
            }

            @Override // com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout.a
            public void d() {
                FKLiveBeautyLayout fKLiveBeautyLayout = (FKLiveBeautyLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamerBeautyLayout);
                Property<View, Float> ALPHA = View.ALPHA;
                s.h(ALPHA, "ALPHA");
                fKLiveBeautyLayout.e(ALPHA);
            }

            @Override // com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout.a
            public void e(@NotNull LivePkType pkType) {
                s.i(pkType, "pkType");
                int i10 = a.f14757a[pkType.ordinal()];
                if (i10 == 1) {
                    ((FKLivePkWarLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamerLivePkWarLayout)).T();
                } else {
                    if (i10 != 2) {
                        return;
                    }
                    ((MultiPkLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamer_multi_pk_layout)).Q();
                }
            }

            @Override // com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout.a
            public void f() {
                FKLiveForStreamerBeautyActivity fKLiveForStreamerBeautyActivity = FKLiveForStreamerBeautyActivity.this;
                fKLiveForStreamerBeautyActivity.B = FKLiveConnectUserPickerFragment.f15841k.a(new b(fKLiveForStreamerBeautyActivity));
                FKLiveConnectUserPickerFragment fKLiveConnectUserPickerFragment = FKLiveForStreamerBeautyActivity.this.B;
                if (fKLiveConnectUserPickerFragment != null) {
                    FragmentManager supportFragmentManager = FKLiveForStreamerBeautyActivity.this.getSupportFragmentManager();
                    s.h(supportFragmentManager, "supportFragmentManager");
                    fKLiveConnectUserPickerFragment.w1(supportFragmentManager);
                }
            }

            @Override // com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout.a
            public void g() {
                LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
                if (liveShowModel != null) {
                    FKBaseLiveActivity.C1(FKLiveForStreamerBeautyActivity.this, liveShowModel.getAnchorGradeWebUrl(), false, 2, null);
                }
            }

            @Override // com.cupidapp.live.liveshow.view.bottommenu.FKLiveForStreamerBottomMenuLayout.a
            public void h(boolean z10) {
                FKLiveForStreamerBeautyActivity.this.y2(z10);
            }
        });
        ((LiveConnectLayout) G1(R$id.streamer_connect_layout)).setConnectListener(new e());
        ((FrameLayout) G1(R$id.streamerLiveWebContainerLayout)).setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.liveshow.activity.c
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean p22;
                p22 = FKLiveForStreamerBeautyActivity.p2(FKLiveForStreamerBeautyActivity.this, view, motionEvent);
                return p22;
            }
        });
        ((FKLivePkWarLayout) G1(R$id.streamerLivePkWarLayout)).setFKLivePkWarCallback(new com.cupidapp.live.liveshow.pk.view.c() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$bindClickEvent$5
            @Override // com.cupidapp.live.liveshow.pk.view.c
            public void a(int i10, int i11) {
                if (i10 > 0 && i11 > 0) {
                    ((FKLiveBeautyGLSurfaceView) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamerLiveTextureView)).f(0.0f, ((FKLivePkWarLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamerLivePkWarLayout)).getY(), i10, i11, h.c(this, 20.0f));
                }
                ((FKLiveForStreamerBottomMenuLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamerLiveMenuLayout)).t(LivePkType.DoublePk, true);
                ((LiveStickerEditMaskLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamer_sticker_edit_mask_layout)).setCanDisplaySticker(false);
            }

            @Override // com.cupidapp.live.liveshow.pk.view.c
            public void b(final boolean z10) {
                FKLivePkStatusAnimationLayout fKLivePkStatusAnimationLayout = (FKLivePkStatusAnimationLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamerPkStatusAnimationLayout);
                final FKLiveForStreamerBeautyActivity fKLiveForStreamerBeautyActivity = FKLiveForStreamerBeautyActivity.this;
                fKLivePkStatusAnimationLayout.c(z10, new Function0<p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$bindClickEvent$5$showPkStatusAnimation$1
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
                        ((FKLivePkWarLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamerLivePkWarLayout)).O(z10);
                    }
                });
            }

            @Override // com.cupidapp.live.liveshow.pk.view.c
            public void c(int i10) {
                ((FKLiveBeautyGLSurfaceView) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamerLiveTextureView)).setY(i10);
            }

            @Override // com.cupidapp.live.liveshow.pk.view.c
            public void d() {
                ((FKLiveBeautyGLSurfaceView) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamerLiveTextureView)).e();
                ((FKLiveForStreamerBottomMenuLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamerLiveMenuLayout)).t(LivePkType.DoublePk, false);
                ((LiveStickerEditMaskLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamer_sticker_edit_mask_layout)).setCanDisplaySticker(true);
            }
        });
        FKMusicPlayerLayout musicPlayerLayout = (FKMusicPlayerLayout) G1(R$id.musicPlayerLayout);
        s.h(musicPlayerLayout, "musicPlayerLayout");
        y.d(musicPlayerLayout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$bindClickEvent$6
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
                FKLiveMusicFragment fKLiveMusicFragment;
                fKLiveMusicFragment = FKLiveForStreamerBeautyActivity.this.D;
                if (fKLiveMusicFragment != null) {
                    fKLiveMusicFragment.m1(FKLiveForStreamerBeautyActivity.this.getSupportFragmentManager());
                }
            }
        });
        ((FKLiveGiftEnterAnimationLayout) G1(R$id.streamerGiftEnterAnimationLayout)).setGiftEnterAnimationFinished(new Function0<p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$bindClickEvent$7
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
                FKLiveForStreamerBeautyActivity.this.T2(false);
            }
        });
    }

    @Override // com.cupidapp.live.liveshow.activity.FKBaseLiveActivity, com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        super.onActivityResult(i10, i11, intent);
        FKLiveStreamerOpenLiveLayout fKLiveStreamerOpenLiveLayout = (FKLiveStreamerOpenLiveLayout) G1(R$id.streamerOpenLiveLayout);
        if (fKLiveStreamerOpenLiveLayout != null) {
            fKLiveStreamerOpenLiveLayout.G(i10, i11, intent);
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        int i10 = R$id.streamerBeautyLayout;
        if (((FKLiveBeautyLayout) G1(i10)).getVisibility() == 0) {
            boolean d10 = ((FKLiveBeautyLayout) G1(i10)).d();
            if (this.A || d10) {
                return;
            }
            ((FKLiveStreamerOpenLiveLayout) G1(R$id.streamerOpenLiveLayout)).L();
            return;
        }
        if (!this.f14753z && this.A) {
            if (m1() || x2()) {
                return;
            }
            FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, this, false, 2, null), R$string.liveshow_finish_confirm_title, 0, 2, null), R$string.liveshow_finish_confirm, null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$onBackPressed$1
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
                    FKLiveForStreamerBeautyActivity.this.w2();
                }
            }, 2, null), R$string.liveshow_finish_cancel, null, 2, null), null, 1, null);
            return;
        }
        super.onBackPressed();
    }

    @Override // com.cupidapp.live.liveshow.activity.FKBaseLiveActivity, com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ConsultFloatWindowHelper.f13810b.i();
        FKLiveMiniWindow.G(FKLiveMiniWindow.f15074m.a(), MiniWindowCloseMethod.CloseMethodOther, false, true, 2, null);
        y1(false);
        p1.g gVar = p1.g.f52734a;
        if (gVar.S().c() == null) {
            gVar.S().d(new FKLiveBeautyEditCacheModel(new LinkedHashMap(), null, 2, null));
        }
        FKLiveConstantsData.INSTANCE.resetLiveConstantsData();
        setContentView(R$layout.activity_liveshow_for_streamer_beauty);
        z2();
        FKLiveUtil.f14913a.g();
        J2();
        E2();
        Q2();
    }

    @Override // com.cupidapp.live.liveshow.activity.FKBaseLiveActivity, com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.M = null;
        Disposable disposable = this.N;
        if (disposable != null) {
            disposable.dispose();
        }
        this.N = null;
        FKLiveBaseHornLayout fKLiveBaseHornLayout = (FKLiveBaseHornLayout) G1(R$id.liveHornLayout);
        if (fKLiveBaseHornLayout != null) {
            fKLiveBaseHornLayout.j();
        }
        FKLiveUtil fKLiveUtil = FKLiveUtil.f14913a;
        fKLiveUtil.L();
        ((FKLiveGiftAnimationLayout) G1(R$id.streamerLiveGiftAnimationLayout)).c();
        fKLiveUtil.m();
        FKLiveGrpcEntity.f14907e.a().v();
        ((FKLiveBarrageLayout) G1(R$id.streamerLiveBarrageLayout)).b();
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        fKLiveConstantsData.resetLiveConstantsData();
        fKLiveConstantsData.resetLiveVideoCapture();
        r2.i.f53231b.t();
        ((FKLivePkStatusAnimationLayout) G1(R$id.streamerPkStatusAnimationLayout)).d();
        ((FKLivePrivilegeStatusLayout) G1(R$id.streamerLivePrivilegeStatusLayout)).g();
        ((FKLiveShowAdLayout) G1(R$id.streamer_live_ad_layout)).p();
        ((FKLiveShowActivityLayout) G1(R$id.streamer_live_activity_layout)).p();
        ((FKLiveForStreamerBottomMenuLayout) G1(R$id.streamerLiveMenuLayout)).v();
        ((FKLiveSendGiftCriticalHitView) G1(R$id.streamerLiveCriticalHitView)).m();
        ((FKLiveStreamerOpenLiveLayout) G1(R$id.streamerOpenLiveLayout)).N();
        ((LiveRedEnvelopeView) G1(R$id.streamer_red_envelope_view)).f();
        ((StarChallengeChestView) G1(R$id.streamer_star_challenge_chest_view)).k();
        SensorsLogLiveShow.f12212a.n();
        EventBus.c().l(new PlayLiveEvent());
        H2().c();
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull FKLiveOpenWebFragmentEvent event) {
        s.i(event, "event");
        B1(event.getUrl(), event.getCover());
    }

    @Override // com.cupidapp.live.liveshow.activity.FKBaseLiveActivity, com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        r2.i.f53231b.v();
        FKLiveUtil.f14913a.K();
        ((FKLiveShakeAnimationLayout) G1(R$id.streamerShakeAnimationLayout)).o();
    }

    @Override // com.cupidapp.live.liveshow.activity.FKBaseLiveActivity, com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        FKLiveStreamerOpenLiveLayout fKLiveStreamerOpenLiveLayout;
        super.onResume();
        if (!this.A && (fKLiveStreamerOpenLiveLayout = (FKLiveStreamerOpenLiveLayout) G1(R$id.streamerOpenLiveLayout)) != null) {
            fKLiveStreamerOpenLiveLayout.t();
        }
        K2();
        FKLiveMusicFragment fKLiveMusicFragment = this.D;
        if (fKLiveMusicFragment != null) {
            fKLiveMusicFragment.f1();
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void p(@NotNull FKLivePkStatus fKLivePkStatus) {
        a.C0157a.K(this, fKLivePkStatus);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void q0(@NotNull MultiPkInvitationModel messageModel) {
        s.i(messageModel, "messageModel");
        String inviteeShowId = messageModel.getInviteeShowId();
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        boolean d10 = s.d(inviteeShowId, liveShowModel != null ? liveShowModel.getItemId() : null);
        if (AppApplication.f11612d.e() && d10) {
            D2().h();
            G2().k(messageModel.getPkPrepareId());
            F2().e(messageModel, new Function1<AcceptInvitingResult, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$liveMultiPkInvitationConnector$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(AcceptInvitingResult acceptInvitingResult) {
                    invoke2(acceptInvitingResult);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable AcceptInvitingResult acceptInvitingResult) {
                    if (acceptInvitingResult != null) {
                        ((MultiPkLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamer_multi_pk_layout)).B(false, acceptInvitingResult.getRtmpUrlPrefix(), acceptInvitingResult.getMixStreamId(), acceptInvitingResult.getPkUsers());
                    }
                }
            });
        }
        if (d10) {
            return;
        }
        MultiPkLayout streamer_multi_pk_layout = (MultiPkLayout) G1(R$id.streamer_multi_pk_layout);
        s.h(streamer_multi_pk_layout, "streamer_multi_pk_layout");
        MultiPkLayout.y(streamer_multi_pk_layout, messageModel.getMultiPkAnchorModel(), 0, 2, null);
    }

    public final void q2() {
        G2().l(new f());
        ((MultiPkLayout) G1(R$id.streamer_multi_pk_layout)).setMultiPkListener(new g());
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void r(@NotNull MultiPkInteractModel messageModel) {
        s.i(messageModel, "messageModel");
        ((MultiPkLayout) G1(R$id.streamer_multi_pk_layout)).V(messageModel);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void r0(@NotNull MultiPkRefuseInvitingModel messageModel) {
        s.i(messageModel, "messageModel");
        ((MultiPkLayout) G1(R$id.streamer_multi_pk_layout)).F(messageModel.getPkLiveShowId());
        F2().a(messageModel.getPkLiveShowId(), MultiPkInviteStatus.Refuse);
    }

    public final void r2() {
        D2().k(new h());
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void s(@NotNull UserEntryConnectorMessage messageModel, @NotNull ConnectorMessageEvent event) {
        s.i(messageModel, "messageModel");
        s.i(event, "event");
        if (messageModel.getEntity().getUserEntryDirection() == UserEntryDirection.R2L) {
            ((FKLiveViewerEnterCarLayout) G1(R$id.streamerUserEnterCarLayout)).h(messageModel.getEntity());
        } else {
            ((FKLiveViewerEnterDefaultLayout) G1(R$id.streamerLiveViewerEnterLayout)).m(messageModel.getEntity());
        }
        String animation = messageModel.getEntity().getAnimation();
        if (animation != null) {
            FKLiveGiftAnimationLayout streamerLiveGiftAnimationLayout = (FKLiveGiftAnimationLayout) G1(R$id.streamerLiveGiftAnimationLayout);
            s.h(streamerLiveGiftAnimationLayout, "streamerLiveGiftAnimationLayout");
            FKLiveGiftAnimationLayout.h(streamerLiveGiftAnimationLayout, new LiveShowAnimationModel(animation, null, AnimationType.UserEntry), true, 0, 4, null);
            ((LiveViewerRightEnterAnimatorLayout) G1(R$id.streamer_right_enter_animator_layout)).g(messageModel.getEntity());
        }
        ((FKActorInfoAndAudienceLayout) G1(R$id.streamerLiveActorUserInfoLayout)).k(messageModel.getViewersSeat());
        c3(event.getMessage().getMessageId(), null, messageModel.getLiveAdBadge(), false);
        ((FKLiveCommentLayout) G1(R$id.streamerLiveCommentLayout)).g(messageModel.getEntity().getUser(), messageModel.getEntity().getEnterText(), messageModel.getEntity().getTextEnterLabels());
        String relationshipType = messageModel.getEntity().getRelationshipType();
        if (!(relationshipType == null || relationshipType.length() == 0)) {
            GroupLiveLog groupLiveLog = GroupLiveLog.f18698a;
            LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
            String itemId = liveShowModel != null ? liveShowModel.getItemId() : null;
            User user = messageModel.getEntity().getUser();
            groupLiveLog.l(itemId, user != null ? user.userId() : null, messageModel.getEntity().getRelationshipType());
        }
        User user2 = messageModel.getEntity().getUser();
        if ((user2 != null ? user2.getNewUserIcon() : null) != null) {
            GroupLiveLog groupLiveLog2 = GroupLiveLog.f18698a;
            LiveShowModel liveShowModel2 = FKLiveConstantsData.INSTANCE.getLiveShowModel();
            String itemId2 = liveShowModel2 != null ? liveShowModel2.getItemId() : null;
            User user3 = messageModel.getEntity().getUser();
            groupLiveLog2.l(itemId2, user3 != null ? user3.userId() : null, "NEW_PEOPLE");
        }
    }

    public final void s2() {
        if (FKLiveConstantsData.INSTANCE.getRemoteConnectLiveShow() != null) {
            FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, this, false, 2, null), R$string.stop_link_go_to_pk, 0, 2, null), R$string.go_to_pk, null, new Function0<p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$checkConnectAndShowPkCenter$1
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
                    FKLivePkManager D2;
                    ((LiveConnectLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamer_connect_layout)).r();
                    D2 = FKLiveForStreamerBeautyActivity.this.D2();
                    D2.o();
                }
            }, 2, null), R$string.still_connect, null, 2, null).j(false), null, 1, null);
        } else {
            D2().o();
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void t(@NotNull LiveShowAnimationConnectorMessageModel messageModel) {
        s.i(messageModel, "messageModel");
        FKLiveGiftAnimationLayout streamerLiveGiftAnimationLayout = (FKLiveGiftAnimationLayout) G1(R$id.streamerLiveGiftAnimationLayout);
        s.h(streamerLiveGiftAnimationLayout, "streamerLiveGiftAnimationLayout");
        FKLiveGiftAnimationLayout.h(streamerLiveGiftAnimationLayout, new LiveShowAnimationModel(messageModel.getEntity().getAnimationResKey(), messageModel.getEntity().getAudioResKey(), AnimationType.Animation), false, 0, 6, null);
    }

    @Override // com.cupidapp.live.liveshow.activity.FKBaseLiveActivity
    public void t1(boolean z10) {
        t2();
    }

    public final void t2() {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        MultiPkLayout multiPkLayout = (MultiPkLayout) G1(R$id.streamer_multi_pk_layout);
        boolean z10 = false;
        if (multiPkLayout != null && multiPkLayout.getVisibility() == 0) {
            z10 = true;
        }
        if (z10) {
            u2.a r10 = NetworkClient.f11868a.r();
            LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
            Disposable disposed = a.C0826a.g(r10, liveShowModel != null ? liveShowModel.getItemId() : null, null, 2, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<LiveShowResult, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$checkCurrentLiveStatus$$inlined$handle$default$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(LiveShowResult liveShowResult) {
                    m2593invoke(liveShowResult);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2593invoke(LiveShowResult liveShowResult) {
                    LiveShowResult liveShowResult2 = liveShowResult;
                    if (liveShowResult2.hasMultiPk()) {
                        MultiPkLayout multiPkLayout2 = (MultiPkLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamer_multi_pk_layout);
                        if (multiPkLayout2 != null) {
                            MultiPkInfoModel multiPkInfo = liveShowResult2.getLiveShow().getMultiPkInfo();
                            s.f(multiPkInfo);
                            multiPkLayout2.E(multiPkInfo);
                            return;
                        }
                        return;
                    }
                    MultiPkLayout multiPkLayout3 = (MultiPkLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamer_multi_pk_layout);
                    if (multiPkLayout3 != null) {
                        multiPkLayout3.w();
                    }
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
    public void u(@NotNull LivePkRandPairedMessage messageModel) {
        s.i(messageModel, "messageModel");
        if (messageModel.getEntity().isAppointPk()) {
            return;
        }
        D2().j(messageModel.getEntity().getPkUser(), SensorsLogLiveShow.PkRequestType.RandomPkMatch.getType());
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void u0(@NotNull SignInInfoModel signInInfoModel) {
        a.C0157a.Q(this, signInInfoModel);
    }

    public final void u2() {
        if (this.N == null) {
            boolean z10 = false;
            if (this.M != null && (!r0.isEmpty())) {
                z10 = true;
            }
            if (z10) {
                Observable<Long> observeOn = Observable.interval(0L, com.huawei.openalliance.ad.ipc.c.Code, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread());
                final Function1<Long, p> function1 = new Function1<Long, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$checkShowGuideTips$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Long l10) {
                        invoke2(l10);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Long l10) {
                        List list;
                        list = FKLiveForStreamerBeautyActivity.this.M;
                        Iterator iterator2 = list != null ? list.iterator2() : null;
                        if (iterator2 != null && iterator2.hasNext()) {
                            String str = (String) iterator2.next();
                            FKLiveForStreamerBeautyActivity fKLiveForStreamerBeautyActivity = FKLiveForStreamerBeautyActivity.this;
                            int i10 = R$id.more_pointer_tip_view;
                            TextView textView = (TextView) fKLiveForStreamerBeautyActivity.G1(i10);
                            if (textView != null) {
                                textView.setText(t.a(str, -49088));
                            }
                            TextView textView2 = (TextView) FKLiveForStreamerBeautyActivity.this.G1(i10);
                            if (textView2 != null) {
                                textView2.setVisibility(0);
                            }
                            iterator2.remove();
                            return;
                        }
                        TextView textView3 = (TextView) FKLiveForStreamerBeautyActivity.this.G1(R$id.more_pointer_tip_view);
                        if (textView3 == null) {
                            return;
                        }
                        textView3.setVisibility(8);
                    }
                };
                this.N = observeOn.subscribe(new Consumer() { // from class: com.cupidapp.live.liveshow.activity.d
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        FKLiveForStreamerBeautyActivity.v2(Function1.this, obj);
                    }
                });
            }
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void v0(@NotNull LiveGiftCollectionConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        Disposable disposed = NetworkClient.f11868a.r().G0(messageModel.getLiveShowId()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<GiftCollectionModel, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$liveGiftCollectionConnector$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(GiftCollectionModel giftCollectionModel) {
                m2597invoke(giftCollectionModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2597invoke(GiftCollectionModel giftCollectionModel) {
                ((GiftCollectionLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamer_gift_collection_layout)).h(giftCollectionModel);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void w(@NotNull FullLiveVisibleGiftConnectorMessage message) {
        s.i(message, "message");
        ((FullLiveVisibleGiftLayout) G1(R$id.streamer_full_live_visible_gift_layout)).d(message.getEntity());
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void w0(@NotNull MultiPkEndModel messageModel) {
        s.i(messageModel, "messageModel");
        if (!messageModel.isInitiator() && !messageModel.getEnded()) {
            String liveShowId = messageModel.getLiveShowId();
            LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
            if (!s.d(liveShowId, liveShowModel != null ? liveShowModel.getItemId() : null)) {
                ((MultiPkLayout) G1(R$id.streamer_multi_pk_layout)).G(messageModel.getLiveShowId());
            }
        } else {
            ((MultiPkLayout) G1(R$id.streamer_multi_pk_layout)).w();
        }
        String liveShowId2 = messageModel.getLiveShowId();
        LiveShowModel liveShowModel2 = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (s.d(liveShowId2, liveShowModel2 != null ? liveShowModel2.getItemId() : null)) {
            return;
        }
        com.cupidapp.live.base.view.h.f12779a.m(this, messageModel.getTips());
    }

    public final void w2() {
        final LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || this.f14753z) {
            return;
        }
        this.f14753z = true;
        e1();
        Disposable disposed = NetworkClient.f11868a.r().E(liveShowModel.getItemId()).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<SummaryDataResult, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$closeCurrentLiveShow$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SummaryDataResult summaryDataResult) {
                m2594invoke(summaryDataResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2594invoke(SummaryDataResult summaryDataResult) {
                SummaryDataResult summaryDataResult2 = summaryDataResult;
                FKLiveForStreamerBeautyActivity.this.V0();
                FKLiveForStreamerBeautyActivity.this.Z2(summaryDataResult2.getSummary());
                Long liveDurationMillis = summaryDataResult2.getSummary().getLiveDurationMillis();
                if (liveDurationMillis != null) {
                    SensorsLogLiveShow.f12212a.h(liveShowModel.getItemId(), liveShowModel.getUser().userId(), (int) (((float) liveDurationMillis.longValue()) / 1000.0f), t.q(((FKActorInfoAndAudienceLayout) FKLiveForStreamerBeautyActivity.this.G1(R$id.streamerLiveActorUserInfoLayout)).getWatchPeakCount()), summaryDataResult2.getSummary().getViewers());
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$closeCurrentLiveShow$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                FKLiveForStreamerBeautyActivity.this.V0();
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void x(@NotNull MultiPkStartModel messageModel) {
        s.i(messageModel, "messageModel");
        G2().j(messageModel.getPkPairId());
        ((MultiPkLayout) G1(R$id.streamer_multi_pk_layout)).U(messageModel.getCountdownSec(), messageModel.getJumpUrl(), messageModel.getPkPairId(), true);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void x0(@NotNull MultiPkFirstBloodModel messageModel) {
        s.i(messageModel, "messageModel");
        ((MultiPkLayout) G1(R$id.streamer_multi_pk_layout)).R(messageModel.getLiveShowId());
    }

    public final boolean x2() {
        if (FKLiveConstantsData.INSTANCE.getRemoteConnectLiveShow() == null) {
            return false;
        }
        ((LiveConnectLayout) G1(R$id.streamer_connect_layout)).C();
        return true;
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void y0(@NotNull LiveConnectAcceptConnectorMessage liveConnectAcceptConnectorMessage) {
        a.C0157a.j(this, liveConnectAcceptConnectorMessage);
    }

    public final void y2(boolean z10) {
        LiveShowModel liveShow;
        String itemId;
        LiveShowResult fkLiveShowResult;
        LiveShowModel pkLiveShow;
        String itemId2;
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        LiveShowResult fkLiveShowResult2 = fKLiveConstantsData.getFkLiveShowResult();
        if (fkLiveShowResult2 == null || (liveShow = fkLiveShowResult2.getLiveShow()) == null || (itemId = liveShow.getItemId()) == null || (fkLiveShowResult = fKLiveConstantsData.getFkLiveShowResult()) == null || (pkLiveShow = fkLiveShowResult.getPkLiveShow()) == null || (itemId2 = pkLiveShow.getItemId()) == null) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.r().m0(itemId, itemId2, z10).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.activity.FKLiveForStreamerBeautyActivity$closeOthersSound$$inlined$handle$default$1
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

    public final void z2() {
        FKAlertLayout.a aVar = FKAlertLayout.f12456d;
        Window window = getWindow();
        s.h(window, "window");
        aVar.b(window).c(R$string.live_beauty_resource_download).e();
        LiveBeautyDownloader.f11939a.k(this, false, new i());
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull InsertShakeCommentEvent event) {
        s.i(event, "event");
        m2(new FKLiveCommentMessageViewModel(event.getComment(), false, 2, null));
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull FKLiveMusicDismissEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        if (event.getQuitPlay()) {
            ((FKMusicPlayerLayout) G1(R$id.musicPlayerLayout)).setVisibility(8);
            this.D = null;
        }
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ShowStickerEvent event) {
        s.i(event, "event");
        m1();
        ((FKLiveBeautyLayout) G1(R$id.streamerBeautyLayout)).setLiveSticker(event.getResourcePath());
    }
}
