package com.cupidapp.live.liveshow.miniwindow;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.Property;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.cupidapp.live.AppApplication;
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
import com.cupidapp.live.base.sensorslog.MiniWindowCloseMethod;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerActivity;
import com.cupidapp.live.liveshow.activity.FKLiveForViewerViewModel;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.constants.FKLiveType;
import com.cupidapp.live.liveshow.entity.FKLiveGrpcEntity;
import com.cupidapp.live.liveshow.entity.FKLiveUtil;
import com.cupidapp.live.liveshow.entity.a;
import com.cupidapp.live.liveshow.model.FKLiveHornModel;
import com.cupidapp.live.liveshow.model.HeatValuesModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.LiveShowPkWarResult;
import com.cupidapp.live.liveshow.model.LiveShowResult;
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
import com.cupidapp.live.liveshow.view.FollowLiveStatusLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.h;

/* compiled from: FKLiveMiniWindow.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveMiniWindow implements com.cupidapp.live.liveshow.entity.a {

    /* renamed from: m */
    @NotNull
    public static final a f15074m = new a(null);

    /* renamed from: n */
    @Nullable
    public static FKLiveMiniWindow f15075n;

    /* renamed from: b */
    public int f15076b;

    /* renamed from: c */
    public int f15077c;

    /* renamed from: d */
    @Nullable
    public List<com.cupidapp.live.liveshow.miniwindow.a> f15078d;

    /* renamed from: e */
    @Nullable
    public FKLiveMiniWindowLayout f15079e;

    /* renamed from: f */
    public boolean f15080f;

    /* renamed from: g */
    @Nullable
    public Boolean f15081g;

    /* renamed from: h */
    public boolean f15082h;

    /* renamed from: i */
    @Nullable
    public WindowManager f15083i;

    /* renamed from: j */
    @Nullable
    public WindowManager.LayoutParams f15084j = new WindowManager.LayoutParams();

    /* renamed from: k */
    @Nullable
    public String f15085k;

    /* renamed from: l */
    @Nullable
    public FKLiveForViewerViewModel f15086l;

    /* compiled from: FKLiveMiniWindow.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKLiveMiniWindow a() {
            if (FKLiveMiniWindow.f15075n == null) {
                FKLiveMiniWindow.f15075n = new FKLiveMiniWindow();
            }
            FKLiveMiniWindow fKLiveMiniWindow = FKLiveMiniWindow.f15075n;
            s.f(fKLiveMiniWindow);
            return fKLiveMiniWindow;
        }
    }

    public static /* synthetic */ void G(FKLiveMiniWindow fKLiveMiniWindow, MiniWindowCloseMethod miniWindowCloseMethod, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        if ((i10 & 4) != 0) {
            z11 = false;
        }
        fKLiveMiniWindow.C(miniWindowCloseMethod, z10, z11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void V(FKLiveMiniWindow fKLiveMiniWindow, Activity activity, String str, Function1 function1, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            activity = null;
        }
        if ((i10 & 4) != 0) {
            function1 = null;
        }
        fKLiveMiniWindow.U(activity, str, function1);
    }

    public static /* synthetic */ void n0(FKLiveMiniWindow fKLiveMiniWindow, Integer num, Integer num2, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = null;
        }
        if ((i10 & 2) != 0) {
            num2 = null;
        }
        if ((i10 & 8) != 0) {
            z11 = true;
        }
        fKLiveMiniWindow.m0(num, num2, z10, z11);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void A(@NotNull KickOutLiveRoomMessageModel kickOutLiveRoomMessageModel) {
        a.C0157a.r(this, kickOutLiveRoomMessageModel);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void A0(@NotNull RefreshFollowLiveStatusMessageModel refreshFollowLiveStatusMessageModel) {
        a.C0157a.N(this, refreshFollowLiveStatusMessageModel);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void B(@NotNull LivePkAppointRejectConnectMessage livePkAppointRejectConnectMessage) {
        a.C0157a.F(this, livePkAppointRejectConnectMessage);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void B0(@NotNull LiveConnectPushStreamStartMessage liveConnectPushStreamStartMessage) {
        a.C0157a.k(this, liveConnectPushStreamStartMessage);
    }

    public final void C(@NotNull MiniWindowCloseMethod closeMethod, boolean z10, boolean z11) {
        s.i(closeMethod, "closeMethod");
        j.f12332a.a("ZGEntityLog", "closeMiniLiveShow  closeMethod:" + ((Object) closeMethod) + "  needRelease:" + z10 + " report: " + z11);
        if (z10) {
            FKLiveUtil.o(FKLiveUtil.f14913a, (s.d(this.f15085k, "miniProfile查看资料") && closeMethod == MiniWindowCloseMethod.CloseMethodClickClose) ? false : z11, this.f15086l, false, 4, null);
        }
        if (this.f15080f) {
            this.f15080f = false;
            FKLiveMiniWindowUtil.f15095a.h(closeMethod);
            FKLiveMiniWindowLayout fKLiveMiniWindowLayout = this.f15079e;
            this.f15081g = fKLiveMiniWindowLayout != null ? Boolean.valueOf(fKLiveMiniWindowLayout.getSoundState()) : null;
            WindowManager windowManager = this.f15083i;
            if (windowManager != null) {
                windowManager.removeViewImmediate(this.f15079e);
            }
            this.f15084j = null;
            this.f15083i = null;
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void C0(@NotNull LiveCriticalHitConnectorMessage liveCriticalHitConnectorMessage) {
        a.C0157a.m(this, liveCriticalHitConnectorMessage);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void D(@NotNull LiveBroadcastConnectorMessage liveBroadcastConnectorMessage) {
        a.C0157a.h(this, liveBroadcastConnectorMessage);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void D0(@NotNull LivePkUpdateConnectorMessage livePkUpdateConnectorMessage) {
        a.C0157a.L(this, livePkUpdateConnectorMessage);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void E(@NotNull RedEnvelopeConnectorMessage redEnvelopeConnectorMessage) {
        a.C0157a.M(this, redEnvelopeConnectorMessage);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void F(@NotNull LiveStickerUpdateConnectorMessageModel liveStickerUpdateConnectorMessageModel) {
        a.C0157a.W(this, liveStickerUpdateConnectorMessageModel);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void F0(@NotNull MultiPkAgreeInvitingModel multiPkAgreeInvitingModel) {
        a.C0157a.u(this, multiPkAgreeInvitingModel);
    }

    public final boolean H() {
        return this.f15080f;
    }

    @Nullable
    public final WindowManager.LayoutParams I() {
        return this.f15084j;
    }

    public final void J(@NotNull WindowManager.LayoutParams layoutParams) {
        s.i(layoutParams, "layoutParams");
        if (this.f15076b == 0 && this.f15077c == 0) {
            this.f15076b = 0;
            this.f15077c = h.c(this, 56.0f);
        }
        layoutParams.f816x = this.f15076b;
        layoutParams.f817y = this.f15077c;
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void K(@NotNull MultiPkCancelPrepareModel messageModel) {
        s.i(messageModel, "messageModel");
        String liveShowId = messageModel.getLiveShowId();
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        boolean d10 = s.d(liveShowId, liveShowModel != null ? liveShowModel.getItemId() : null);
        if (messageModel.isInitiator() || d10) {
            WindowManager.LayoutParams layoutParams = this.f15084j;
            if (layoutParams != null) {
                FKLiveMiniWindowUtil.f15095a.i(layoutParams, true);
            }
            FKLiveMiniWindowLayout fKLiveMiniWindowLayout = this.f15079e;
            if (fKLiveMiniWindowLayout != null) {
                fKLiveMiniWindowLayout.g(FKLiveType.MULTI_PK);
            }
            i0();
        }
    }

    public final void L() {
        Boolean bool = this.f15081g;
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            FKLiveMiniWindowLayout fKLiveMiniWindowLayout = this.f15079e;
            if (fKLiveMiniWindowLayout != null) {
                fKLiveMiniWindowLayout.setSoundState(booleanValue);
            }
            this.f15081g = null;
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void L0(@NotNull LiveAnchorPrivilegeEndUseConnectorMessage liveAnchorPrivilegeEndUseConnectorMessage) {
        a.C0157a.d(this, liveAnchorPrivilegeEndUseConnectorMessage);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void M(@NotNull ViewerLeaveConnectorMessage viewerLeaveConnectorMessage) {
        a.C0157a.Y(this, viewerLeaveConnectorMessage);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void N(@NotNull LiveEndConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        FKLiveUtil.o(FKLiveUtil.f14913a, false, null, false, 7, null);
        FKLiveMiniWindowLayout fKLiveMiniWindowLayout = this.f15079e;
        if (fKLiveMiniWindowLayout != null) {
            fKLiveMiniWindowLayout.e();
        }
        FollowLiveStatusLayout.f15289g.k();
    }

    public final void O(Context context) {
        AppApplication.a aVar = AppApplication.f11612d;
        Object systemService = aVar.h().getBaseContext().getSystemService("window");
        this.f15083i = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        this.f15084j = new WindowManager.LayoutParams();
        LiveShowResult fkLiveShowResult = FKLiveConstantsData.INSTANCE.getFkLiveShowResult();
        boolean z10 = (fkLiveShowResult != null ? fkLiveShowResult.getLiveType() : null) == FKLiveType.COMMON;
        WindowManager.LayoutParams layoutParams = this.f15084j;
        if (layoutParams != null) {
            FKLiveMiniWindowUtil.f15095a.i(layoutParams, z10);
        }
        WindowManager.LayoutParams layoutParams2 = this.f15084j;
        if (layoutParams2 != null) {
            FKLiveMiniWindowUtil fKLiveMiniWindowUtil = FKLiveMiniWindowUtil.f15095a;
            Context baseContext = aVar.h().getBaseContext();
            s.h(baseContext, "AppApplication.shareInstance.baseContext");
            fKLiveMiniWindowUtil.c(layoutParams2, baseContext);
        }
        FKLiveMiniWindowLayout fKLiveMiniWindowLayout = new FKLiveMiniWindowLayout(context);
        this.f15079e = fKLiveMiniWindowLayout;
        fKLiveMiniWindowLayout.b();
        FKLiveMiniWindowLayout fKLiveMiniWindowLayout2 = this.f15079e;
        if (fKLiveMiniWindowLayout2 != null) {
            fKLiveMiniWindowLayout2.setTouchEvent(new Function3<Integer, Integer, Boolean, p>() { // from class: com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindow$initView$1
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ p invoke(Integer num, Integer num2, Boolean bool) {
                    invoke(num, num2, bool.booleanValue());
                    return p.f51048a;
                }

                public final void invoke(@Nullable Integer num, @Nullable Integer num2, boolean z11) {
                    FKLiveMiniWindow.n0(FKLiveMiniWindow.this, num, num2, z11, false, 8, null);
                }
            });
        }
        FKLiveMiniWindowLayout fKLiveMiniWindowLayout3 = this.f15079e;
        if (fKLiveMiniWindowLayout3 != null) {
            fKLiveMiniWindowLayout3.setClickEvent(new Function0<p>() { // from class: com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindow$initView$2
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FKLiveMiniWindowUtil.f15095a.d();
                }
            });
        }
        this.f15080f = true;
        WindowManager windowManager = this.f15083i;
        if (windowManager != null) {
            windowManager.addView(this.f15079e, this.f15084j);
        }
    }

    public final boolean P() {
        return this.f15080f;
    }

    public final void Q(boolean z10) {
        List<com.cupidapp.live.liveshow.miniwindow.a> list;
        if (this.f15080f && z10 && this.f15082h && (list = this.f15078d) != null) {
            Iterator<com.cupidapp.live.liveshow.miniwindow.a> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                iterator2.next().a(false);
            }
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void R(@NotNull LiveShowMoreMenuUnreadMessageModel liveShowMoreMenuUnreadMessageModel) {
        a.C0157a.T(this, liveShowMoreMenuUnreadMessageModel);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void S(@NotNull LiveConnectEndConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        FKLiveMiniWindowLayout fKLiveMiniWindowLayout = this.f15079e;
        if (fKLiveMiniWindowLayout != null) {
            fKLiveMiniWindowLayout.g(FKLiveType.CHAT);
        }
        WindowManager.LayoutParams layoutParams = this.f15084j;
        if (layoutParams == null || this.f15079e == null) {
            return;
        }
        if (layoutParams != null) {
            FKLiveMiniWindowUtil.f15095a.i(layoutParams, true);
        }
        i0();
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void T(@NotNull LivePkChatConnectorMessage livePkChatConnectorMessage) {
        a.C0157a.H(this, livePkChatConnectorMessage);
    }

    public final void U(@Nullable Activity activity, @Nullable String str, @Nullable Function1<? super Boolean, p> function1) {
        FKLiveForViewerActivity fKLiveForViewerActivity = activity instanceof FKLiveForViewerActivity ? (FKLiveForViewerActivity) activity : null;
        this.f15086l = fKLiveForViewerActivity != null ? fKLiveForViewerActivity.W1() : null;
        this.f15085k = str;
        FKLiveMiniWindowUtil fKLiveMiniWindowUtil = FKLiveMiniWindowUtil.f15095a;
        fKLiveMiniWindowUtil.a(activity);
        Boolean c4 = g.f52734a.o0().c();
        Boolean bool = Boolean.FALSE;
        if (!s.d(c4, bool)) {
            FKLiveUtil fKLiveUtil = FKLiveUtil.f14913a;
            if (fKLiveUtil.c() != null) {
                List<String> c10 = fKLiveUtil.c();
                boolean z10 = false;
                if (c10 != null && c10.size() == 0) {
                    z10 = true;
                }
                if (!z10) {
                    Boolean e2 = fKLiveMiniWindowUtil.e(activity, function1);
                    if (e2 != null) {
                        if (e2.booleanValue()) {
                            try {
                                Z(str);
                                return;
                            } catch (Exception unused) {
                                FKLiveUtil.o(FKLiveUtil.f14913a, true, this.f15086l, false, 4, null);
                                return;
                            }
                        }
                        FKLiveUtil.o(fKLiveUtil, true, this.f15086l, false, 4, null);
                        return;
                    }
                    return;
                }
            }
        }
        FKLiveUtil.o(FKLiveUtil.f14913a, true, this.f15086l, false, 4, null);
        if (function1 != null) {
            function1.invoke(bool);
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void W(@NotNull LivePkEndConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        WindowManager.LayoutParams layoutParams = this.f15084j;
        if (layoutParams == null || this.f15079e == null) {
            return;
        }
        if (layoutParams != null) {
            FKLiveMiniWindowUtil.f15095a.i(layoutParams, true);
        }
        FKLiveMiniWindowLayout fKLiveMiniWindowLayout = this.f15079e;
        if (fKLiveMiniWindowLayout != null) {
            fKLiveMiniWindowLayout.g(FKLiveType.PK);
        }
        i0();
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void X(@NotNull LivePkCloseAudioConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        LiveShowModel pkLiveShowModel = FKLiveConstantsData.INSTANCE.getPkLiveShowModel();
        if (pkLiveShowModel != null && s.d(messageModel.getEntity().getLiveShowId(), pkLiveShowModel.getItemId())) {
            FKLiveUtil.f14913a.w(messageModel.getEntity().getClose(), pkLiveShowModel.getStreamId());
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void Y(@NotNull LiveAnchorPrivilegeInUseConnectorMessage liveAnchorPrivilegeInUseConnectorMessage) {
        a.C0157a.f(this, liveAnchorPrivilegeInUseConnectorMessage);
    }

    public final void Z(String str) {
        if (this.f15080f) {
            return;
        }
        AppApplication.a aVar = AppApplication.f11612d;
        if (aVar.h().getBaseContext() == null) {
            return;
        }
        Context baseContext = aVar.h().getBaseContext();
        s.h(baseContext, "AppApplication.shareInstance.baseContext");
        O(baseContext);
        L();
        FKLiveConstantsData.INSTANCE.setMiniLiveViewDuration(Long.valueOf(System.currentTimeMillis()));
        FKLiveGrpcEntity.f14907e.a().r(this);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void a(@NotNull StarChallengeLvlUpgradeConnectorMessage starChallengeLvlUpgradeConnectorMessage) {
        a.C0157a.V(this, starChallengeLvlUpgradeConnectorMessage);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void a0(@NotNull StarChallengeChestConnectorMessage starChallengeChestConnectorMessage) {
        a.C0157a.U(this, starChallengeChestConnectorMessage);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void b(@NotNull LivePkStartConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        FKLiveGrpcEntity a10 = FKLiveGrpcEntity.f14907e.a();
        FKLiveMiniWindowLayout fKLiveMiniWindowLayout = this.f15079e;
        a10.m(fKLiveMiniWindowLayout != null ? fKLiveMiniWindowLayout.getContext() : null, new Function1<LiveShowPkWarResult, p>() { // from class: com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindow$livePkStartConnector$1
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
                WindowManager.LayoutParams layoutParams;
                FKLiveMiniWindowLayout fKLiveMiniWindowLayout2;
                WindowManager windowManager;
                FKLiveMiniWindowLayout fKLiveMiniWindowLayout3;
                WindowManager.LayoutParams layoutParams2;
                s.i(it, "it");
                layoutParams = FKLiveMiniWindow.this.f15084j;
                if (layoutParams != null) {
                    FKLiveMiniWindowUtil.f15095a.i(layoutParams, false);
                }
                fKLiveMiniWindowLayout2 = FKLiveMiniWindow.this.f15079e;
                if (fKLiveMiniWindowLayout2 != null) {
                    fKLiveMiniWindowLayout2.f(FKLiveType.PK);
                }
                windowManager = FKLiveMiniWindow.this.f15083i;
                if (windowManager != null) {
                    fKLiveMiniWindowLayout3 = FKLiveMiniWindow.this.f15079e;
                    layoutParams2 = FKLiveMiniWindow.this.f15084j;
                    windowManager.updateViewLayout(fKLiveMiniWindowLayout3, layoutParams2);
                }
            }
        });
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void b0(@NotNull CommentConnectorMessage commentConnectorMessage, @NotNull ConnectorMessageEvent connectorMessageEvent) {
        a.C0157a.i(this, commentConnectorMessage, connectorMessageEvent);
    }

    public final void c0(@Nullable com.cupidapp.live.liveshow.miniwindow.a aVar) {
        List<com.cupidapp.live.liveshow.miniwindow.a> list = this.f15078d;
        Iterator<com.cupidapp.live.liveshow.miniwindow.a> iterator2 = list != null ? list.iterator2() : null;
        if (aVar == null || iterator2 == null) {
            return;
        }
        while (iterator2.hasNext()) {
            if (s.d(iterator2.next(), aVar)) {
                iterator2.remove();
            }
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void d(@NotNull LiveAnchorPrivilegeLineUpConnectorMessage liveAnchorPrivilegeLineUpConnectorMessage) {
        a.C0157a.g(this, liveAnchorPrivilegeLineUpConnectorMessage);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void d0(@NotNull FKLiveHornModel fKLiveHornModel) {
        a.C0157a.q(this, fKLiveHornModel);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void e(@NotNull LivePkAppointRequestConnectorMessage livePkAppointRequestConnectorMessage) {
        a.C0157a.G(this, livePkAppointRequestConnectorMessage);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void e0(@NotNull LiveAnchorPrivilegeHintConnectorMessage liveAnchorPrivilegeHintConnectorMessage) {
        a.C0157a.e(this, liveAnchorPrivilegeHintConnectorMessage);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void f(@NotNull NotifyConnectorMessage notifyConnectorMessage) {
        a.C0157a.E(this, notifyConnectorMessage);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void f0(@NotNull LiveShowTagConnectorMessageModel liveShowTagConnectorMessageModel) {
        a.C0157a.S(this, liveShowTagConnectorMessageModel);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void g(@NotNull MultiPkScoreUpdateModel multiPkScoreUpdateModel) {
        a.C0157a.C(this, multiPkScoreUpdateModel);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void g0(@NotNull MultiPkMixSuccessModel messageModel) {
        s.i(messageModel, "messageModel");
        WindowManager.LayoutParams layoutParams = this.f15084j;
        if (layoutParams != null) {
            FKLiveMiniWindowUtil.f15095a.i(layoutParams, false);
        }
        WindowManager windowManager = this.f15083i;
        if (windowManager != null) {
            windowManager.updateViewLayout(this.f15079e, this.f15084j);
        }
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel != null) {
            liveShowModel.setMixStreamId(messageModel.getMixStreamId());
        }
        FKLiveMiniWindowLayout fKLiveMiniWindowLayout = this.f15079e;
        if (fKLiveMiniWindowLayout != null) {
            fKLiveMiniWindowLayout.f(FKLiveType.MULTI_PK);
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void h(@Nullable HeatValuesModel heatValuesModel) {
        a.C0157a.O(this, heatValuesModel);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void h0(@NotNull AnchorInfoBorderConnectorMessage anchorInfoBorderConnectorMessage) {
        a.C0157a.a(this, anchorInfoBorderConnectorMessage);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void i(@NotNull LiveShowShakeConnectorMessage liveShowShakeConnectorMessage) {
        a.C0157a.s(this, liveShowShakeConnectorMessage);
    }

    public final void i0() {
        j.a aVar = j.f12332a;
        WindowManager.LayoutParams layoutParams = this.f15084j;
        s.f(layoutParams);
        int i10 = layoutParams.f816x;
        WindowManager.LayoutParams layoutParams2 = this.f15084j;
        s.f(layoutParams2);
        aVar.a("updateWindowLayoutParams", "x: " + i10 + " width: " + layoutParams2.width + " screenWidth: " + h.l(this));
        WindowManager.LayoutParams layoutParams3 = this.f15084j;
        s.f(layoutParams3);
        int abs = Math.abs(layoutParams3.f816x);
        int l10 = h.l(this);
        WindowManager.LayoutParams layoutParams4 = this.f15084j;
        s.f(layoutParams4);
        if (abs > (l10 - layoutParams4.width) / 2) {
            int l11 = h.l(this);
            WindowManager.LayoutParams layoutParams5 = this.f15084j;
            s.f(layoutParams5);
            m0(Integer.valueOf(l11 - layoutParams5.width), null, true, false);
            return;
        }
        m0(0, null, true, false);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void j(@NotNull GiftConnectorMessage giftConnectorMessage, @NotNull ConnectorMessageEvent connectorMessageEvent) {
        a.C0157a.p(this, giftConnectorMessage, connectorMessageEvent);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void j0(@Nullable String str, @Nullable String str2) {
        a.C0157a.P(this, str, str2);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void k0(@NotNull MultiPkMuteOthersModel multiPkMuteOthersModel) {
        a.C0157a.A(this, multiPkMuteOthersModel);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void l(@NotNull NewLiveConnectRequestConnectorMessage newLiveConnectRequestConnectorMessage) {
        a.C0157a.l(this, newLiveConnectRequestConnectorMessage);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void l0(@NotNull LivePkFirstBloodConnectorMessage livePkFirstBloodConnectorMessage) {
        a.C0157a.I(this, livePkFirstBloodConnectorMessage);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void m(@NotNull LiveAnchorLvlUpgradeAnimationConnectorMessage liveAnchorLvlUpgradeAnimationConnectorMessage) {
        a.C0157a.c(this, liveAnchorLvlUpgradeAnimationConnectorMessage);
    }

    public final void m0(Integer num, Integer num2, boolean z10, boolean z11) {
        if (this.f15084j == null) {
            return;
        }
        if (!z10) {
            if (num != null) {
                int intValue = num.intValue();
                WindowManager.LayoutParams layoutParams = this.f15084j;
                s.f(layoutParams);
                layoutParams.f816x -= intValue;
            }
            if (num2 != null) {
                int intValue2 = num2.intValue();
                WindowManager.LayoutParams layoutParams2 = this.f15084j;
                s.f(layoutParams2);
                layoutParams2.f817y -= intValue2;
            }
            WindowManager windowManager = this.f15083i;
            if (windowManager != null) {
                windowManager.updateViewLayout(this.f15079e, this.f15084j);
                return;
            }
            return;
        }
        if (num != null) {
            int intValue3 = num.intValue();
            WindowManager.LayoutParams layoutParams3 = this.f15084j;
            s.f(layoutParams3);
            layoutParams3.f816x = intValue3;
        }
        WindowManager.LayoutParams layoutParams4 = this.f15084j;
        s.f(layoutParams4);
        this.f15076b = layoutParams4.f816x;
        WindowManager.LayoutParams layoutParams5 = this.f15084j;
        s.f(layoutParams5);
        this.f15077c = layoutParams5.f817y;
        WindowManager windowManager2 = this.f15083i;
        if (windowManager2 != null) {
            windowManager2.updateViewLayout(this.f15079e, this.f15084j);
        }
        if (z11) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f15079e, (Property<FKLiveMiniWindowLayout, Float>) View.SCALE_X, 1.0f, 0.95f, 1.0f, 0.96f, 1.0f);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f15079e, (Property<FKLiveMiniWindowLayout, Float>) View.SCALE_Y, 1.0f, 0.95f, 1.0f, 0.96f, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ofFloat).with(ofFloat2);
            animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
            animatorSet.setDuration(1000L);
            animatorSet.start();
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void n(@NotNull StartPrayContestConnectorMessage startPrayContestConnectorMessage) {
        a.C0157a.t(this, startPrayContestConnectorMessage);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void o(@NotNull MultiPkCancelInvitingModel multiPkCancelInvitingModel) {
        a.C0157a.v(this, multiPkCancelInvitingModel);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void o0(@NotNull LiveAnchorLvlExpChangeConnectorMessage liveAnchorLvlExpChangeConnectorMessage) {
        a.C0157a.b(this, liveAnchorLvlExpChangeConnectorMessage);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void p(@NotNull FKLivePkStatus fKLivePkStatus) {
        a.C0157a.K(this, fKLivePkStatus);
    }

    public final void p0(boolean z10) {
        if (this.f15080f) {
            if (z10) {
                this.f15082h = true;
                FKLiveMiniWindowLayout fKLiveMiniWindowLayout = this.f15079e;
                if ((fKLiveMiniWindowLayout == null || fKLiveMiniWindowLayout.getSoundState()) ? false : true) {
                    return;
                }
                this.f15081g = Boolean.TRUE;
                FKLiveMiniWindowLayout fKLiveMiniWindowLayout2 = this.f15079e;
                if (fKLiveMiniWindowLayout2 != null) {
                    fKLiveMiniWindowLayout2.setSoundState(false);
                    return;
                }
                return;
            }
            this.f15082h = false;
            L();
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void q0(@NotNull MultiPkInvitationModel multiPkInvitationModel) {
        a.C0157a.y(this, multiPkInvitationModel);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void r(@NotNull MultiPkInteractModel multiPkInteractModel) {
        a.C0157a.x(this, multiPkInteractModel);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void r0(@NotNull MultiPkRefuseInvitingModel multiPkRefuseInvitingModel) {
        a.C0157a.B(this, multiPkRefuseInvitingModel);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void s(@NotNull UserEntryConnectorMessage userEntryConnectorMessage, @NotNull ConnectorMessageEvent connectorMessageEvent) {
        a.C0157a.X(this, userEntryConnectorMessage, connectorMessageEvent);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void t(@NotNull LiveShowAnimationConnectorMessageModel liveShowAnimationConnectorMessageModel) {
        a.C0157a.R(this, liveShowAnimationConnectorMessageModel);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void u(@NotNull LivePkRandPairedMessage livePkRandPairedMessage) {
        a.C0157a.J(this, livePkRandPairedMessage);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void u0(@NotNull SignInInfoModel signInInfoModel) {
        a.C0157a.Q(this, signInInfoModel);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void v0(@NotNull LiveGiftCollectionConnectorMessage liveGiftCollectionConnectorMessage) {
        a.C0157a.o(this, liveGiftCollectionConnectorMessage);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void w(@NotNull FullLiveVisibleGiftConnectorMessage fullLiveVisibleGiftConnectorMessage) {
        a.C0157a.n(this, fullLiveVisibleGiftConnectorMessage);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void w0(@NotNull MultiPkEndModel messageModel) {
        s.i(messageModel, "messageModel");
        String liveShowId = messageModel.getLiveShowId();
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        boolean d10 = s.d(liveShowId, liveShowModel != null ? liveShowModel.getItemId() : null);
        if (messageModel.isInitiator() || d10 || messageModel.getEnded()) {
            WindowManager.LayoutParams layoutParams = this.f15084j;
            if (layoutParams != null) {
                FKLiveMiniWindowUtil.f15095a.i(layoutParams, true);
            }
            FKLiveMiniWindowLayout fKLiveMiniWindowLayout = this.f15079e;
            if (fKLiveMiniWindowLayout != null) {
                fKLiveMiniWindowLayout.g(FKLiveType.MULTI_PK);
            }
            i0();
        }
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void x(@NotNull MultiPkStartModel multiPkStartModel) {
        a.C0157a.D(this, multiPkStartModel);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void x0(@NotNull MultiPkFirstBloodModel multiPkFirstBloodModel) {
        a.C0157a.w(this, multiPkFirstBloodModel);
    }

    @Override // com.cupidapp.live.liveshow.entity.a
    public void y0(@NotNull LiveConnectAcceptConnectorMessage messageModel) {
        s.i(messageModel, "messageModel");
        List<LiveShowModel> connectLive = messageModel.getEntity().getConnectLive();
        if (connectLive == null || ((LiveShowModel) CollectionsKt___CollectionsKt.V(connectLive)) == null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = this.f15084j;
        if (layoutParams != null) {
            FKLiveMiniWindowUtil.f15095a.i(layoutParams, false);
        }
        FKLiveMiniWindowLayout fKLiveMiniWindowLayout = this.f15079e;
        if (fKLiveMiniWindowLayout != null) {
            fKLiveMiniWindowLayout.f(FKLiveType.CHAT);
        }
        WindowManager windowManager = this.f15083i;
        if (windowManager != null) {
            windowManager.updateViewLayout(this.f15079e, this.f15084j);
        }
    }

    public final void z(@NotNull com.cupidapp.live.liveshow.miniwindow.a liveCallback) {
        s.i(liveCallback, "liveCallback");
        if (this.f15078d == null) {
            this.f15078d = new ArrayList();
        }
        List<com.cupidapp.live.liveshow.miniwindow.a> list = this.f15078d;
        if (list != null) {
            list.add(liveCallback);
        }
    }
}
