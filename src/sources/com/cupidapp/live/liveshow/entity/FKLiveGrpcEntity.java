package com.cupidapp.live.liveshow.entity;

import android.content.Context;
import com.cupidapp.live.base.grpc.AnchorInfoBorderConnectorMessage;
import com.cupidapp.live.base.grpc.CommentConnectorMessage;
import com.cupidapp.live.base.grpc.ConnectorMessageEvent;
import com.cupidapp.live.base.grpc.FullLiveVisibleGiftConnectorMessage;
import com.cupidapp.live.base.grpc.GiftConnectorMessage;
import com.cupidapp.live.base.grpc.InLiveShowHeartBeatEvent;
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
import com.cupidapp.live.base.grpc.LiveHotConnectorMessage;
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
import com.cupidapp.live.base.grpc.LiveShowConnectorMessage;
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
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.constants.FKLiveType;
import com.cupidapp.live.liveshow.model.FKHornType;
import com.cupidapp.live.liveshow.model.FKLiveBaseHornModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.LiveShowPkWarResult;
import com.cupidapp.live.liveshow.model.LiveShowResult;
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
import com.cupidapp.live.liveshow.pk.view.FKLivePkStatus;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveGrpcEntity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveGrpcEntity {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f14907e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public static FKLiveGrpcEntity f14908f;

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.liveshow.entity.a f14909a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public FKLivePkStatus f14910b = FKLivePkStatus.LivePkInitialize;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public String f14911c = "";

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public Integer f14912d;

    /* compiled from: FKLiveGrpcEntity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKLiveGrpcEntity a() {
            if (FKLiveGrpcEntity.f14908f == null) {
                FKLiveGrpcEntity.f14908f = new FKLiveGrpcEntity();
            }
            FKLiveGrpcEntity fKLiveGrpcEntity = FKLiveGrpcEntity.f14908f;
            s.f(fKLiveGrpcEntity);
            return fKLiveGrpcEntity;
        }
    }

    public static /* synthetic */ void p(FKLiveGrpcEntity fKLiveGrpcEntity, boolean z10, com.cupidapp.live.liveshow.entity.a aVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            aVar = null;
        }
        fKLiveGrpcEntity.o(z10, aVar);
    }

    @NotNull
    public final String e() {
        return this.f14911c;
    }

    @NotNull
    public final FKLivePkStatus f() {
        return this.f14910b;
    }

    @Nullable
    public final Integer g() {
        return this.f14912d;
    }

    public final void h(@NotNull FKLivePkStatus status, @NotNull String matchId, @NotNull Function0<p> handle) {
        s.i(status, "status");
        s.i(matchId, "matchId");
        s.i(handle, "handle");
        if (s.d(matchId, this.f14911c)) {
            if (this.f14910b.getValue() < status.getValue()) {
                t(status);
                handle.invoke();
                return;
            }
            return;
        }
        handle.invoke();
        t(status);
        this.f14911c = matchId;
    }

    public final void i(Object obj) {
        com.cupidapp.live.liveshow.entity.a aVar;
        if (obj instanceof MultiPkInvitationGrpcModel) {
            com.cupidapp.live.liveshow.entity.a aVar2 = this.f14909a;
            if (aVar2 != null) {
                aVar2.q0(((MultiPkInvitationGrpcModel) obj).getEntity());
                return;
            }
            return;
        }
        if (obj instanceof MultiPkCancelInvitingGrpcModel) {
            com.cupidapp.live.liveshow.entity.a aVar3 = this.f14909a;
            if (aVar3 != null) {
                aVar3.o(((MultiPkCancelInvitingGrpcModel) obj).getEntity());
                return;
            }
            return;
        }
        if (obj instanceof MultiPkAgreeInvitingGrpcModel) {
            com.cupidapp.live.liveshow.entity.a aVar4 = this.f14909a;
            if (aVar4 != null) {
                aVar4.F0(((MultiPkAgreeInvitingGrpcModel) obj).getEntity());
                return;
            }
            return;
        }
        if (obj instanceof MultiPkRefuseInvitingGrpcModel) {
            com.cupidapp.live.liveshow.entity.a aVar5 = this.f14909a;
            if (aVar5 != null) {
                aVar5.r0(((MultiPkRefuseInvitingGrpcModel) obj).getEntity());
                return;
            }
            return;
        }
        if (obj instanceof MultiPkCancelPrepareGrpcModel) {
            MultiPkCancelPrepareGrpcModel multiPkCancelPrepareGrpcModel = (MultiPkCancelPrepareGrpcModel) obj;
            String liveShowId = multiPkCancelPrepareGrpcModel.getEntity().getLiveShowId();
            FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
            LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
            boolean d10 = s.d(liveShowId, liveShowModel != null ? liveShowModel.getItemId() : null);
            if (multiPkCancelPrepareGrpcModel.getEntity().isInitiator() || d10) {
                fKLiveConstantsData.setFkLiveType(FKLiveType.COMMON);
            }
            com.cupidapp.live.liveshow.entity.a aVar6 = this.f14909a;
            if (aVar6 != null) {
                aVar6.K(multiPkCancelPrepareGrpcModel.getEntity());
                return;
            }
            return;
        }
        if (obj instanceof MultiPkStartGrpcModel) {
            com.cupidapp.live.liveshow.entity.a aVar7 = this.f14909a;
            if (aVar7 != null) {
                aVar7.x(((MultiPkStartGrpcModel) obj).getEntity());
                return;
            }
            return;
        }
        if (obj instanceof MultiPkEndGrpcModel) {
            MultiPkEndGrpcModel multiPkEndGrpcModel = (MultiPkEndGrpcModel) obj;
            String liveShowId2 = multiPkEndGrpcModel.getEntity().getLiveShowId();
            FKLiveConstantsData fKLiveConstantsData2 = FKLiveConstantsData.INSTANCE;
            LiveShowModel liveShowModel2 = fKLiveConstantsData2.getLiveShowModel();
            boolean d11 = s.d(liveShowId2, liveShowModel2 != null ? liveShowModel2.getItemId() : null);
            if (multiPkEndGrpcModel.getEntity().isInitiator() || d11 || multiPkEndGrpcModel.getEntity().getEnded()) {
                fKLiveConstantsData2.setFkLiveType(FKLiveType.COMMON);
            }
            com.cupidapp.live.liveshow.entity.a aVar8 = this.f14909a;
            if (aVar8 != null) {
                aVar8.w0(multiPkEndGrpcModel.getEntity());
                return;
            }
            return;
        }
        if (obj instanceof MultiPkInteractGrpcModel) {
            com.cupidapp.live.liveshow.entity.a aVar9 = this.f14909a;
            if (aVar9 != null) {
                aVar9.r(((MultiPkInteractGrpcModel) obj).getEntity());
                return;
            }
            return;
        }
        if (obj instanceof MultiPkMixSuccessGrpcModel) {
            FKLiveConstantsData.INSTANCE.setFkLiveType(FKLiveType.MULTI_PK);
            com.cupidapp.live.liveshow.entity.a aVar10 = this.f14909a;
            if (aVar10 != null) {
                aVar10.g0(((MultiPkMixSuccessGrpcModel) obj).getEntity());
                return;
            }
            return;
        }
        if (obj instanceof MultiPkScoreUpdateGrpcModel) {
            com.cupidapp.live.liveshow.entity.a aVar11 = this.f14909a;
            if (aVar11 != null) {
                aVar11.g(((MultiPkScoreUpdateGrpcModel) obj).getEntity());
                return;
            }
            return;
        }
        if (obj instanceof MultiPkFirstBloodGrpcModel) {
            com.cupidapp.live.liveshow.entity.a aVar12 = this.f14909a;
            if (aVar12 != null) {
                aVar12.x0(((MultiPkFirstBloodGrpcModel) obj).getEntity());
                return;
            }
            return;
        }
        if (!(obj instanceof MultiPkMuteOthersGrpcModel) || (aVar = this.f14909a) == null) {
            return;
        }
        aVar.k0(((MultiPkMuteOthersGrpcModel) obj).getEntity());
    }

    public final void j(final Object obj) {
        com.cupidapp.live.liveshow.entity.a aVar;
        if (obj instanceof LivePkRandPairedMessage) {
            com.cupidapp.live.liveshow.entity.a aVar2 = this.f14909a;
            if (aVar2 != null) {
                aVar2.u((LivePkRandPairedMessage) obj);
                return;
            }
            return;
        }
        if (obj instanceof LivePkAppointRequestConnectorMessage) {
            com.cupidapp.live.liveshow.entity.a aVar3 = this.f14909a;
            if (aVar3 != null) {
                aVar3.e((LivePkAppointRequestConnectorMessage) obj);
                return;
            }
            return;
        }
        if (obj instanceof LivePkAppointRejectConnectMessage) {
            com.cupidapp.live.liveshow.entity.a aVar4 = this.f14909a;
            if (aVar4 != null) {
                aVar4.B((LivePkAppointRejectConnectMessage) obj);
                return;
            }
            return;
        }
        if (obj instanceof LivePkStartConnectorMessage) {
            FKLiveConstantsData.INSTANCE.setFkLiveType(FKLiveType.PK);
            LivePkStartConnectorMessage livePkStartConnectorMessage = (LivePkStartConnectorMessage) obj;
            this.f14912d = Integer.valueOf(livePkStartConnectorMessage.getEntity().getPkType());
            h(FKLivePkStatus.LivePkStart, livePkStartConnectorMessage.getEntity().getMatchId(), new Function0<p>() { // from class: com.cupidapp.live.liveshow.entity.FKLiveGrpcEntity$livePkConnectorMessage$1
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
                    a aVar5;
                    aVar5 = FKLiveGrpcEntity.this.f14909a;
                    if (aVar5 != null) {
                        aVar5.b((LivePkStartConnectorMessage) obj);
                    }
                }
            });
            return;
        }
        if (obj instanceof LivePkUpdateConnectorMessage) {
            com.cupidapp.live.liveshow.entity.a aVar5 = this.f14909a;
            if (aVar5 != null) {
                aVar5.D0((LivePkUpdateConnectorMessage) obj);
                return;
            }
            return;
        }
        if (obj instanceof LivePkFirstBloodConnectorMessage) {
            com.cupidapp.live.liveshow.entity.a aVar6 = this.f14909a;
            if (aVar6 != null) {
                aVar6.l0((LivePkFirstBloodConnectorMessage) obj);
                return;
            }
            return;
        }
        if (obj instanceof LivePkChatConnectorMessage) {
            com.cupidapp.live.liveshow.entity.a aVar7 = this.f14909a;
            if (aVar7 != null) {
                aVar7.T((LivePkChatConnectorMessage) obj);
                return;
            }
            return;
        }
        if (obj instanceof LivePkEndConnectorMessage) {
            FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
            fKLiveConstantsData.setFkLiveType(FKLiveType.COMMON);
            com.cupidapp.live.liveshow.entity.a aVar8 = this.f14909a;
            if (aVar8 != null) {
                aVar8.W((LivePkEndConnectorMessage) obj);
            }
            LiveShowResult fkLiveShowResult = fKLiveConstantsData.getFkLiveShowResult();
            if (fkLiveShowResult == null) {
                return;
            }
            fkLiveShowResult.setPkLiveShow(null);
            return;
        }
        if (!(obj instanceof LivePkCloseAudioConnectorMessage) || (aVar = this.f14909a) == null) {
            return;
        }
        aVar.X((LivePkCloseAudioConnectorMessage) obj);
    }

    public final void k() {
        com.cupidapp.live.base.utils.j.f12332a.a("FKLiveGrpcEntity", "notifyGrpcLiveEnd");
        EventBus.c().l(new InLiveShowHeartBeatEvent(false, null, null, null, 14, null));
    }

    public final void l(@Nullable String str, boolean z10) {
        com.cupidapp.live.base.utils.j.f12332a.a("FKLiveGrpcEntity", "notifyGrpcLiveStart");
        EventBus.c().l(new InLiveShowHeartBeatEvent(true, str, Boolean.valueOf(z10), null, 8, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m(@Nullable Context context, @Nullable final Function1<? super LiveShowPkWarResult, p> function1) {
        String itemId;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null) {
            return;
        }
        Observable<Result<LiveShowPkWarResult>> S = NetworkClient.f11868a.r().S(itemId);
        com.cupidapp.live.base.network.g gVar = context instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) context : null;
        Disposable disposed = S.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<LiveShowPkWarResult, p>() { // from class: com.cupidapp.live.liveshow.entity.FKLiveGrpcEntity$pkMatchSuccess$$inlined$handleByContext$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(LiveShowPkWarResult liveShowPkWarResult) {
                m2605invoke(liveShowPkWarResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2605invoke(LiveShowPkWarResult liveShowPkWarResult) {
                LiveShowPkWarResult liveShowPkWarResult2 = liveShowPkWarResult;
                if (liveShowPkWarResult2.getLiveShow() == null || liveShowPkWarResult2.getPkLiveShow() == null) {
                    return;
                }
                FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
                LiveShowResult fkLiveShowResult = fKLiveConstantsData.getFkLiveShowResult();
                if (fkLiveShowResult != null) {
                    fkLiveShowResult.setPkLiveShow(liveShowPkWarResult2.getPkLiveShow());
                }
                fKLiveConstantsData.setLiveShowModel(liveShowPkWarResult2.getLiveShow());
                Function1 function12 = Function1.this;
                if (function12 != null) {
                    function12.invoke(liveShowPkWarResult2);
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    public final void n(Object obj) {
        com.cupidapp.live.liveshow.entity.a aVar;
        if (obj instanceof LiveAnchorLvlUpgradeAnimationConnectorMessage) {
            com.cupidapp.live.liveshow.entity.a aVar2 = this.f14909a;
            if (aVar2 != null) {
                aVar2.m((LiveAnchorLvlUpgradeAnimationConnectorMessage) obj);
                return;
            }
            return;
        }
        if (obj instanceof LiveAnchorPrivilegeHintConnectorMessage) {
            com.cupidapp.live.liveshow.entity.a aVar3 = this.f14909a;
            if (aVar3 != null) {
                aVar3.e0((LiveAnchorPrivilegeHintConnectorMessage) obj);
                return;
            }
            return;
        }
        if (obj instanceof LiveAnchorPrivilegeInUseConnectorMessage) {
            com.cupidapp.live.liveshow.entity.a aVar4 = this.f14909a;
            if (aVar4 != null) {
                aVar4.Y((LiveAnchorPrivilegeInUseConnectorMessage) obj);
                return;
            }
            return;
        }
        if (obj instanceof LiveAnchorPrivilegeEndUseConnectorMessage) {
            com.cupidapp.live.liveshow.entity.a aVar5 = this.f14909a;
            if (aVar5 != null) {
                aVar5.L0((LiveAnchorPrivilegeEndUseConnectorMessage) obj);
                return;
            }
            return;
        }
        if (!(obj instanceof LiveAnchorPrivilegeLineUpConnectorMessage) || (aVar = this.f14909a) == null) {
            return;
        }
        aVar.d((LiveAnchorPrivilegeLineUpConnectorMessage) obj);
    }

    public final void o(final boolean z10, @Nullable final com.cupidapp.live.liveshow.entity.a aVar) {
        com.cupidapp.live.base.utils.j.f12332a.a("FKLiveGrpcEntity", "registerLiveGrpc");
        y0.a.f54658a.a(this, new Function1<Boolean, p>() { // from class: com.cupidapp.live.liveshow.entity.FKLiveGrpcEntity$registerLiveGrpc$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return p.f51048a;
            }

            public final void invoke(boolean z11) {
                FKLiveGrpcEntity fKLiveGrpcEntity = FKLiveGrpcEntity.this;
                LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
                fKLiveGrpcEntity.l(liveShowModel != null ? liveShowModel.getItemId() : null, z10);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    FKLiveGrpcEntity.this.f14909a = aVar2;
                }
            }
        });
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ConnectorMessageEvent event) {
        com.cupidapp.live.liveshow.entity.a aVar;
        com.cupidapp.live.liveshow.entity.a aVar2;
        com.cupidapp.live.liveshow.entity.a aVar3;
        s.i(event, "event");
        com.cupidapp.live.base.utils.j.f12332a.a("FKLiveGrpcEntity", "event.model:" + event.getModel().getClass().getSimpleName() + "  type:" + ((Object) event.getMessage().getType()));
        Object model = event.getModel();
        if (event.getModel() instanceof FKLiveBaseHornModel) {
            LiveShowConnectorMessage baseInfoMessageModel = event.getBaseInfoMessageModel();
            u(baseInfoMessageModel != null ? baseInfoMessageModel.getLiveShowId() : null, (FKLiveBaseHornModel) event.getModel());
            return;
        }
        if (model instanceof SignInInfoModel) {
            com.cupidapp.live.liveshow.entity.a aVar4 = this.f14909a;
            if (aVar4 != null) {
                aVar4.u0((SignInInfoModel) model);
            }
        } else if ((model instanceof LiveShowMoreMenuUnreadMessageModel) && (aVar = this.f14909a) != null) {
            aVar.R((LiveShowMoreMenuUnreadMessageModel) model);
        }
        LiveShowConnectorMessage baseInfoMessageModel2 = event.getBaseInfoMessageModel();
        String liveShowId = baseInfoMessageModel2 != null ? baseInfoMessageModel2.getLiveShowId() : null;
        FKLiveConstantsData fKLiveConstantsData = FKLiveConstantsData.INSTANCE;
        LiveShowModel liveShowModel = fKLiveConstantsData.getLiveShowModel();
        if (s.d(liveShowId, liveShowModel != null ? liveShowModel.getItemId() : null)) {
            com.cupidapp.live.liveshow.entity.a aVar5 = this.f14909a;
            if (aVar5 != null) {
                LiveShowConnectorMessage baseInfoMessageModel3 = event.getBaseInfoMessageModel();
                String viewerCount = baseInfoMessageModel3 != null ? baseInfoMessageModel3.getViewerCount() : null;
                LiveShowConnectorMessage baseInfoMessageModel4 = event.getBaseInfoMessageModel();
                aVar5.j0(viewerCount, baseInfoMessageModel4 != null ? baseInfoMessageModel4.getCommission() : null);
            }
            if ((model instanceof LiveHotConnectorMessage) && (aVar3 = this.f14909a) != null) {
                aVar3.h(((LiveHotConnectorMessage) model).getEntity());
            }
            if (model instanceof LiveConnectAcceptConnectorMessage) {
                fKLiveConstantsData.setFkLiveType(FKLiveType.CHAT);
                LiveConnectAcceptConnectorMessage liveConnectAcceptConnectorMessage = (LiveConnectAcceptConnectorMessage) model;
                fKLiveConstantsData.setLiveShowModel(liveConnectAcceptConnectorMessage.getEntity());
                com.cupidapp.live.liveshow.entity.a aVar6 = this.f14909a;
                if (aVar6 != null) {
                    aVar6.y0(liveConnectAcceptConnectorMessage);
                }
            } else if (model instanceof LiveConnectEndConnectorMessage) {
                fKLiveConstantsData.setFkLiveType(FKLiveType.COMMON);
                com.cupidapp.live.liveshow.entity.a aVar7 = this.f14909a;
                if (aVar7 != null) {
                    aVar7.S((LiveConnectEndConnectorMessage) model);
                }
            } else if (model instanceof LiveEndConnectorMessage) {
                fKLiveConstantsData.setFkLiveType(FKLiveType.FINISH);
                com.cupidapp.live.liveshow.entity.a aVar8 = this.f14909a;
                if (aVar8 != null) {
                    aVar8.N((LiveEndConnectorMessage) model);
                }
            } else if (model instanceof LiveBroadcastConnectorMessage) {
                com.cupidapp.live.liveshow.entity.a aVar9 = this.f14909a;
                if (aVar9 != null) {
                    aVar9.D((LiveBroadcastConnectorMessage) model);
                }
            } else if (model instanceof CommentConnectorMessage) {
                com.cupidapp.live.liveshow.entity.a aVar10 = this.f14909a;
                if (aVar10 != null) {
                    aVar10.b0((CommentConnectorMessage) model, event);
                }
            } else if (model instanceof GiftConnectorMessage) {
                com.cupidapp.live.liveshow.entity.a aVar11 = this.f14909a;
                if (aVar11 != null) {
                    aVar11.j((GiftConnectorMessage) model, event);
                }
            } else if (model instanceof NotifyConnectorMessage) {
                com.cupidapp.live.liveshow.entity.a aVar12 = this.f14909a;
                if (aVar12 != null) {
                    aVar12.f((NotifyConnectorMessage) model);
                }
            } else if (model instanceof UserEntryConnectorMessage) {
                com.cupidapp.live.liveshow.entity.a aVar13 = this.f14909a;
                if (aVar13 != null) {
                    aVar13.s((UserEntryConnectorMessage) model, event);
                }
            } else if (model instanceof LiveShowShakeConnectorMessage) {
                com.cupidapp.live.liveshow.entity.a aVar14 = this.f14909a;
                if (aVar14 != null) {
                    aVar14.i((LiveShowShakeConnectorMessage) model);
                }
            } else if (model instanceof NewLiveConnectRequestConnectorMessage) {
                com.cupidapp.live.liveshow.entity.a aVar15 = this.f14909a;
                if (aVar15 != null) {
                    aVar15.l((NewLiveConnectRequestConnectorMessage) model);
                }
            } else if (model instanceof LiveConnectPushStreamStartMessage) {
                fKLiveConstantsData.setFkLiveType(FKLiveType.CHAT);
                LiveConnectPushStreamStartMessage liveConnectPushStreamStartMessage = (LiveConnectPushStreamStartMessage) model;
                fKLiveConstantsData.setLiveShowModel(liveConnectPushStreamStartMessage.getEntity());
                com.cupidapp.live.liveshow.entity.a aVar16 = this.f14909a;
                if (aVar16 != null) {
                    aVar16.B0(liveConnectPushStreamStartMessage);
                }
            } else if (model instanceof ViewerLeaveConnectorMessage) {
                com.cupidapp.live.liveshow.entity.a aVar17 = this.f14909a;
                if (aVar17 != null) {
                    aVar17.M((ViewerLeaveConnectorMessage) model);
                }
            } else if (model instanceof FKLiveBaseHornModel) {
                com.cupidapp.live.liveshow.entity.a aVar18 = this.f14909a;
                if (aVar18 != null) {
                    aVar18.d0(((FKLiveBaseHornModel) model).getEntity());
                }
            } else if (model instanceof LiveAnchorLvlExpChangeConnectorMessage) {
                com.cupidapp.live.liveshow.entity.a aVar19 = this.f14909a;
                if (aVar19 != null) {
                    aVar19.o0((LiveAnchorLvlExpChangeConnectorMessage) model);
                }
            } else if (model instanceof LiveCriticalHitConnectorMessage) {
                com.cupidapp.live.liveshow.entity.a aVar20 = this.f14909a;
                if (aVar20 != null) {
                    aVar20.C0((LiveCriticalHitConnectorMessage) model);
                }
            } else if (model instanceof LiveGiftCollectionConnectorMessage) {
                com.cupidapp.live.liveshow.entity.a aVar21 = this.f14909a;
                if (aVar21 != null) {
                    aVar21.v0((LiveGiftCollectionConnectorMessage) model);
                }
            } else if (model instanceof StartPrayContestConnectorMessage) {
                com.cupidapp.live.liveshow.entity.a aVar22 = this.f14909a;
                if (aVar22 != null) {
                    aVar22.n((StartPrayContestConnectorMessage) model);
                }
            } else if (model instanceof RedEnvelopeConnectorMessage) {
                com.cupidapp.live.liveshow.entity.a aVar23 = this.f14909a;
                if (aVar23 != null) {
                    aVar23.E((RedEnvelopeConnectorMessage) model);
                }
            } else if (model instanceof KickOutLiveRoomMessageModel) {
                com.cupidapp.live.liveshow.entity.a aVar24 = this.f14909a;
                if (aVar24 != null) {
                    aVar24.A((KickOutLiveRoomMessageModel) model);
                }
            } else if (model instanceof AnchorInfoBorderConnectorMessage) {
                com.cupidapp.live.liveshow.entity.a aVar25 = this.f14909a;
                if (aVar25 != null) {
                    aVar25.h0((AnchorInfoBorderConnectorMessage) model);
                }
            } else if (model instanceof StarChallengeChestConnectorMessage) {
                com.cupidapp.live.liveshow.entity.a aVar26 = this.f14909a;
                if (aVar26 != null) {
                    aVar26.a0((StarChallengeChestConnectorMessage) model);
                }
            } else if (model instanceof StarChallengeLvlUpgradeConnectorMessage) {
                com.cupidapp.live.liveshow.entity.a aVar27 = this.f14909a;
                if (aVar27 != null) {
                    aVar27.a((StarChallengeLvlUpgradeConnectorMessage) model);
                }
            } else if (model instanceof LiveShowTagConnectorMessageModel) {
                com.cupidapp.live.liveshow.entity.a aVar28 = this.f14909a;
                if (aVar28 != null) {
                    aVar28.f0((LiveShowTagConnectorMessageModel) model);
                }
            } else if (model instanceof LiveShowAnimationConnectorMessageModel) {
                com.cupidapp.live.liveshow.entity.a aVar29 = this.f14909a;
                if (aVar29 != null) {
                    aVar29.t((LiveShowAnimationConnectorMessageModel) model);
                }
            } else if (model instanceof FullLiveVisibleGiftConnectorMessage) {
                com.cupidapp.live.liveshow.entity.a aVar30 = this.f14909a;
                if (aVar30 != null) {
                    aVar30.w((FullLiveVisibleGiftConnectorMessage) model);
                }
            } else if (model instanceof LiveStickerUpdateConnectorMessageModel) {
                com.cupidapp.live.liveshow.entity.a aVar31 = this.f14909a;
                if (aVar31 != null) {
                    aVar31.F((LiveStickerUpdateConnectorMessageModel) model);
                }
            } else if ((model instanceof RefreshFollowLiveStatusMessageModel) && (aVar2 = this.f14909a) != null) {
                aVar2.A0((RefreshFollowLiveStatusMessageModel) model);
            }
            j(model);
            n(model);
            i(model);
        }
    }

    public final void q() {
        t(FKLivePkStatus.LivePkInitialize);
        this.f14911c = "";
        this.f14912d = null;
    }

    public final void r(@Nullable com.cupidapp.live.liveshow.entity.a aVar) {
        this.f14909a = aVar;
    }

    public final void s(@NotNull String str) {
        s.i(str, "<set-?>");
        this.f14911c = str;
    }

    public final void t(@NotNull FKLivePkStatus value) {
        s.i(value, "value");
        this.f14910b = value;
        com.cupidapp.live.liveshow.entity.a aVar = this.f14909a;
        if (aVar != null) {
            aVar.p(value);
        }
    }

    public final void u(String str, FKLiveBaseHornModel fKLiveBaseHornModel) {
        if (fKLiveBaseHornModel.getEntity().getType() == FKHornType.SmallHornType.getHornType()) {
            LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
            if (!s.d(str, liveShowModel != null ? liveShowModel.getItemId() : null)) {
                return;
            }
        }
        com.cupidapp.live.liveshow.entity.a aVar = this.f14909a;
        if (aVar != null) {
            aVar.d0(fKLiveBaseHornModel.getEntity());
        }
    }

    public final void v() {
        com.cupidapp.live.base.utils.j.f12332a.a("FKLiveGrpcEntity", "unRegisterGrpcEvent");
        k();
        y0.a.f54658a.c(this);
        this.f14909a = null;
        f14908f = null;
    }
}
