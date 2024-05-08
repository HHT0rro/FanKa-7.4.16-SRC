package com.cupidapp.live.match.viewmodel;

import android.text.format.DateUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.livedata.TripleCombineLiveData;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.RequestErrorCode;
import com.cupidapp.live.base.network.gson.GsonUtil;
import com.cupidapp.live.base.network.model.AlohaOrNopeGuideModel;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.DailyLikeGuideModel;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.network.model.ListResult;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.network.model.SwipeCardUserLikeResult;
import com.cupidapp.live.base.network.model.VideoModel;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.match.model.AlohaGuideModel;
import com.cupidapp.live.match.model.GuideModel;
import com.cupidapp.live.match.model.MatchCardItemModel;
import com.cupidapp.live.match.model.MatchGroupCampaignModel;
import com.cupidapp.live.match.model.MatchMarketingModel;
import com.cupidapp.live.match.model.MatchRecommendModel;
import com.cupidapp.live.match.model.MatchRecommendUserModel;
import com.cupidapp.live.match.model.MatchResult;
import com.cupidapp.live.match.model.MatchSettingResult;
import com.cupidapp.live.match.view.FKFaultModel;
import com.cupidapp.live.match.view.FKSwipeCardFaultType;
import com.cupidapp.live.profile.model.MBTIInfoModel;
import com.cupidapp.live.profile.model.SceneType;
import com.cupidapp.live.profile.model.SuperLikeGuideResult;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.profile.model.ZodiacElfInfoModel;
import com.cupidapp.live.setting.model.AvatarProfileModel;
import com.cupidapp.live.superboost.dialog.SuperBoostManager;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;

/* compiled from: FKSwipeCardViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKSwipeCardViewModel extends ViewModel {

    @NotNull
    private final MutableLiveData<Pair<Boolean, Float>> _alohaOrNopeButtonVisibleLiveData;

    @NotNull
    private final MutableLiveData<Event<Boolean>> _alohaOrNopeClickEvent;

    @NotNull
    private MutableLiveData<Event<AlohaOrNopeGuideModel>> _alohaOrNopeGuideLiveData;

    @NotNull
    private final MutableLiveData<Event<Integer>> _alohaOrNopeResidueNumLiveData;

    @NotNull
    private final MutableLiveData<Pair<Boolean, SwipeCardUserLikeResult>> _alohaOrNopeResultLiveData;

    @NotNull
    private final MutableLiveData<Boolean> _cancelNopeButtonVisibleLiveData;

    @NotNull
    private final MutableLiveData<Event<Boolean>> _clearSwipeCardEvent;

    @NotNull
    private final MutableLiveData<DailyLikeGuideModel> _dailyGuideTipLiveData;

    @NotNull
    private final MutableLiveData<Event<FKSwipeCardFaultType>> _faultActionEvent;

    @NotNull
    private final MutableLiveData<MatchSettingResult> _filterSettingLiveData = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<Boolean> _guideAnimLiveData;

    @NotNull
    private final MutableLiveData<Event<MatchRecommendModel>> _nopeCardClickEvent;

    @NotNull
    private final MutableLiveData<MatchRecommendModel> _nopeCardLiveData;

    @NotNull
    private MutableLiveData<Event<AlohaGuideModel>> _showGetAlohaDialogLiveData;

    @NotNull
    private MutableLiveData<Event<VipPurchaseEntranceType>> _showVipOrPlusDialogEvent;

    @NotNull
    private final MutableLiveData<Boolean> _startOrStopPlayStreamLiveData;

    @NotNull
    private final MutableLiveData<Pair<String, String>> _superBoostOrSuperLikeNumLiveData;

    @NotNull
    private final MutableLiveData<Event<Integer>> _superLikeEvent;

    @NotNull
    private final MutableLiveData<Pair<Boolean, FKFaultModel>> _swipeCardFaultLiveData;

    @NotNull
    private final MutableLiveData<StateResult<Pair<List<MatchRecommendModel>, Boolean>>> _swipeCardLiveData;

    @NotNull
    private final MutableLiveData<List<LiveShowModel>> _swipeCardLiveShowLiveData;

    @NotNull
    private final MutableLiveData<Event<String>> _swipeCardNewUserGuideLiveData;

    @NotNull
    private final MutableLiveData<Boolean> _uploadAvatarVisibleLiveData;

    @NotNull
    private final MutableLiveData<Boolean> _windowClickLiveData;

    @NotNull
    private final LiveData<Pair<Boolean, Float>> alohaOrNopeButtonVisibleLiveData;

    @NotNull
    private final LiveData<Event<Boolean>> alohaOrNopeClickEvent;

    @NotNull
    private final LiveData<Event<AlohaOrNopeGuideModel>> alohaOrNopeGuideLiveData;

    @NotNull
    private final LiveData<Event<Integer>> alohaOrNopeResidueNumLiveData;

    @NotNull
    private final LiveData<Pair<Boolean, SwipeCardUserLikeResult>> alohaOrNopeResultLiveData;
    private int callApiReturnEmptyMaxCount;

    @NotNull
    private final LiveData<Boolean> cancelNopeButtonVisibleLiveData;

    @NotNull
    private final LiveData<Event<Boolean>> clearSwipeCardEvent;

    @NotNull
    private final LiveData<DailyLikeGuideModel> dailyGuideTipLiveData;

    @NotNull
    private final LiveData<Event<FKSwipeCardFaultType>> faultActionEvent;

    @NotNull
    private final LiveData<Boolean> guideAnimLiveData;
    private boolean isLoading;

    @NotNull
    private final LiveData<Event<MatchRecommendModel>> nopeCardClickEvent;

    @NotNull
    private final LiveData<Event<AlohaGuideModel>> showGetAlohaDialogLiveData;

    @NotNull
    private final LiveData<Pair<String, String>> showSuperBoostOrSuperLikeNumLiveData;

    @NotNull
    private final LiveData<Event<VipPurchaseEntranceType>> showVipOrPlusDialogEvent;

    @NotNull
    private final LiveData<Boolean> startOrStopPlayStreamLiveData;

    @NotNull
    private final LiveData<Event<Integer>> superLikeEvent;
    private int swipeCardCount;

    @NotNull
    private final LiveData<Pair<Boolean, FKFaultModel>> swipeCardFaultLiveData;

    @NotNull
    private final LiveData<StateResult<Pair<List<MatchRecommendModel>, Boolean>>> swipeCardLiveData;

    @NotNull
    private final LiveData<List<LiveShowModel>> swipeCardLiveShowLiveData;

    @NotNull
    private final LiveData<Event<String>> swipeCardNewUserGuideLiveData;

    @NotNull
    private final LiveData<Boolean> uploadAvatarVisibleLiveData;

    @NotNull
    private final LiveData<Boolean> windowClickLiveData;

    public FKSwipeCardViewModel() {
        MutableLiveData<Event<Integer>> mutableLiveData = new MutableLiveData<>();
        this._superLikeEvent = mutableLiveData;
        this.superLikeEvent = mutableLiveData;
        MutableLiveData<StateResult<Pair<List<MatchRecommendModel>, Boolean>>> mutableLiveData2 = new MutableLiveData<>();
        this._swipeCardLiveData = mutableLiveData2;
        LiveData<StateResult<Pair<List<MatchRecommendModel>, Boolean>>> distinctUntilChanged = Transformations.distinctUntilChanged(mutableLiveData2);
        this.swipeCardLiveData = distinctUntilChanged;
        MutableLiveData<Event<Boolean>> mutableLiveData3 = new MutableLiveData<>();
        this._clearSwipeCardEvent = mutableLiveData3;
        this.clearSwipeCardEvent = mutableLiveData3;
        MutableLiveData<Pair<Boolean, FKFaultModel>> mutableLiveData4 = new MutableLiveData<>();
        this._swipeCardFaultLiveData = mutableLiveData4;
        this.swipeCardFaultLiveData = mutableLiveData4;
        MutableLiveData<Event<String>> mutableLiveData5 = new MutableLiveData<>();
        this._swipeCardNewUserGuideLiveData = mutableLiveData5;
        this.swipeCardNewUserGuideLiveData = Transformations.distinctUntilChanged(mutableLiveData5);
        MutableLiveData<Boolean> mutableLiveData6 = new MutableLiveData<>();
        this._windowClickLiveData = mutableLiveData6;
        this.windowClickLiveData = mutableLiveData6;
        MutableLiveData<Event<FKSwipeCardFaultType>> mutableLiveData7 = new MutableLiveData<>();
        this._faultActionEvent = mutableLiveData7;
        this.faultActionEvent = mutableLiveData7;
        MutableLiveData<Pair<Boolean, SwipeCardUserLikeResult>> mutableLiveData8 = new MutableLiveData<>();
        this._alohaOrNopeResultLiveData = mutableLiveData8;
        this.alohaOrNopeResultLiveData = mutableLiveData8;
        this._nopeCardLiveData = new MutableLiveData<>();
        MutableLiveData<Boolean> mutableLiveData9 = new MutableLiveData<>();
        this._cancelNopeButtonVisibleLiveData = mutableLiveData9;
        this.cancelNopeButtonVisibleLiveData = mutableLiveData9;
        MutableLiveData<Pair<Boolean, Float>> mutableLiveData10 = new MutableLiveData<>();
        this._alohaOrNopeButtonVisibleLiveData = mutableLiveData10;
        this.alohaOrNopeButtonVisibleLiveData = mutableLiveData10;
        MutableLiveData<Event<MatchRecommendModel>> mutableLiveData11 = new MutableLiveData<>();
        this._nopeCardClickEvent = mutableLiveData11;
        this.nopeCardClickEvent = mutableLiveData11;
        MutableLiveData<Event<Boolean>> mutableLiveData12 = new MutableLiveData<>();
        this._alohaOrNopeClickEvent = mutableLiveData12;
        this.alohaOrNopeClickEvent = mutableLiveData12;
        MutableLiveData<List<LiveShowModel>> mutableLiveData13 = new MutableLiveData<>();
        this._swipeCardLiveShowLiveData = mutableLiveData13;
        this.swipeCardLiveShowLiveData = Transformations.distinctUntilChanged(mutableLiveData13);
        this.callApiReturnEmptyMaxCount = 3;
        MutableLiveData<Boolean> mutableLiveData14 = new MutableLiveData<>();
        this._uploadAvatarVisibleLiveData = mutableLiveData14;
        this.uploadAvatarVisibleLiveData = mutableLiveData14;
        MutableLiveData<DailyLikeGuideModel> mutableLiveData15 = new MutableLiveData<>();
        this._dailyGuideTipLiveData = mutableLiveData15;
        this.dailyGuideTipLiveData = mutableLiveData15;
        MutableLiveData<Boolean> mutableLiveData16 = new MutableLiveData<>();
        this._startOrStopPlayStreamLiveData = mutableLiveData16;
        this.startOrStopPlayStreamLiveData = mutableLiveData16;
        MutableLiveData<Boolean> mutableLiveData17 = new MutableLiveData<>();
        mutableLiveData17.setValue(Boolean.FALSE);
        this._guideAnimLiveData = mutableLiveData17;
        LiveData<Boolean> distinctUntilChanged2 = Transformations.distinctUntilChanged(mutableLiveData17);
        this.guideAnimLiveData = distinctUntilChanged2;
        MutableLiveData<Pair<String, String>> mutableLiveData18 = new MutableLiveData<>();
        this._superBoostOrSuperLikeNumLiveData = mutableLiveData18;
        this.showSuperBoostOrSuperLikeNumLiveData = new TripleCombineLiveData(mutableLiveData18, distinctUntilChanged2, distinctUntilChanged, new Function3<Pair<? extends String, ? extends String>, Boolean, StateResult<Pair<? extends List<? extends MatchRecommendModel>, ? extends Boolean>>, Pair<? extends String, ? extends String>>() { // from class: com.cupidapp.live.match.viewmodel.FKSwipeCardViewModel$showSuperBoostOrSuperLikeNumLiveData$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Pair<? extends String, ? extends String> invoke(Pair<? extends String, ? extends String> pair, Boolean bool, StateResult<Pair<? extends List<? extends MatchRecommendModel>, ? extends Boolean>> stateResult) {
                return invoke2((Pair<String, String>) pair, bool, (StateResult<Pair<List<MatchRecommendModel>, Boolean>>) stateResult);
            }

            @Nullable
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Pair<String, String> invoke2(@Nullable Pair<String, String> pair, @Nullable Boolean bool, @Nullable StateResult<Pair<List<MatchRecommendModel>, Boolean>> stateResult) {
                if (!kotlin.jvm.internal.s.d(bool, Boolean.TRUE) || stateResult == null) {
                    return null;
                }
                return pair;
            }
        });
        MutableLiveData<Event<AlohaGuideModel>> mutableLiveData19 = new MutableLiveData<>();
        this._showGetAlohaDialogLiveData = mutableLiveData19;
        this.showGetAlohaDialogLiveData = mutableLiveData19;
        MutableLiveData<Event<Integer>> mutableLiveData20 = new MutableLiveData<>();
        this._alohaOrNopeResidueNumLiveData = mutableLiveData20;
        this.alohaOrNopeResidueNumLiveData = mutableLiveData20;
        MutableLiveData<Event<AlohaOrNopeGuideModel>> mutableLiveData21 = new MutableLiveData<>();
        this._alohaOrNopeGuideLiveData = mutableLiveData21;
        this.alohaOrNopeGuideLiveData = mutableLiveData21;
        MutableLiveData<Event<VipPurchaseEntranceType>> mutableLiveData22 = new MutableLiveData<>();
        this._showVipOrPlusDialogEvent = mutableLiveData22;
        this.showVipOrPlusDialogEvent = mutableLiveData22;
        p1.g.f52734a.U2(true);
    }

    public final void checkShowSuperLikeGuide() {
        Disposable disposed = NetworkClient.f11868a.N().h0(SceneType.MATCH.getValue(), null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<SuperLikeGuideResult, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.FKSwipeCardViewModel$checkShowSuperLikeGuide$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(SuperLikeGuideResult superLikeGuideResult) {
                m2724invoke(superLikeGuideResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2724invoke(SuperLikeGuideResult superLikeGuideResult) {
                MutableLiveData mutableLiveData;
                mutableLiveData = FKSwipeCardViewModel.this._superBoostOrSuperLikeNumLiveData;
                mutableLiveData.setValue(new Pair(null, superLikeGuideResult.getRemainNums()));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.match.viewmodel.FKSwipeCardViewModel$checkShowSuperLikeGuide$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                return Boolean.TRUE;
            }
        }, null)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    private final void loadMatchRcmdData() {
        Observable just;
        p1.g gVar = p1.g.f52734a;
        if (gVar.q() == null) {
            just = NetworkClient.f11868a.i().o().flatMap(new com.cupidapp.live.base.network.i());
        } else {
            just = Observable.just(gVar.q());
        }
        Observable observeOn = Observable.zip(just, NetworkClient.f11868a.A().e(true).flatMap(new com.cupidapp.live.base.network.i()), new BiFunction() { // from class: com.cupidapp.live.match.viewmodel.e
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                MatchResult loadMatchRcmdData$lambda$2;
                loadMatchRcmdData$lambda$2 = FKSwipeCardViewModel.loadMatchRcmdData$lambda$2((ConstantsResult) obj, (MatchResult) obj2);
                return loadMatchRcmdData$lambda$2;
            }
        }).observeOn(AndroidSchedulers.mainThread());
        final Function1<MatchResult, kotlin.p> function1 = new Function1<MatchResult, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.FKSwipeCardViewModel$loadMatchRcmdData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(MatchResult matchResult) {
                invoke2(matchResult);
                return kotlin.p.f51048a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MatchResult matchResult) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                MutableLiveData mutableLiveData3;
                MutableLiveData mutableLiveData4;
                MutableLiveData mutableLiveData5;
                mutableLiveData = FKSwipeCardViewModel.this._alohaOrNopeResidueNumLiveData;
                Integer alohaOrNopeResidueNum = matchResult.getAlohaOrNopeResidueNum();
                mutableLiveData.setValue(new Event(Integer.valueOf(alohaOrNopeResidueNum != null ? alohaOrNopeResidueNum.intValue() : -1)));
                p1.g.f52734a.V1(matchResult.getAvatarWindowTipStyle());
                FKSwipeCardViewModel.this.isLoading = false;
                List<MatchRecommendModel> list = matchResult.getList();
                if (list == null || list.isEmpty()) {
                    mutableLiveData4 = FKSwipeCardViewModel.this._swipeCardFaultLiveData;
                    Boolean bool = Boolean.TRUE;
                    mutableLiveData5 = FKSwipeCardViewModel.this._filterSettingLiveData;
                    mutableLiveData4.setValue(new Pair(bool, new FKFaultModel(null, null, true, (MatchSettingResult) mutableLiveData5.getValue(), 3, null)));
                    return;
                }
                mutableLiveData2 = FKSwipeCardViewModel.this._dailyGuideTipLiveData;
                mutableLiveData2.setValue(matchResult.getDailyLikePopInfo());
                mutableLiveData3 = FKSwipeCardViewModel.this._swipeCardLiveData;
                List<MatchRecommendModel> list2 = matchResult.getList();
                kotlin.jvm.internal.s.f(list2);
                mutableLiveData3.setValue(new StateResult.c(new Pair(list2, Boolean.TRUE), null, 2, null));
                SuperBoostManager.p(SuperBoostManager.f18580a, null, 1, null);
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.match.viewmodel.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FKSwipeCardViewModel.loadMatchRcmdData$lambda$3(Function1.this, obj);
            }
        };
        final Function1<Throwable, kotlin.p> function12 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.FKSwipeCardViewModel$loadMatchRcmdData$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                invoke2(th);
                return kotlin.p.f51048a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                FKSwipeCardViewModel.this.isLoading = false;
                mutableLiveData = FKSwipeCardViewModel.this._swipeCardFaultLiveData;
                Boolean bool = Boolean.TRUE;
                com.cupidapp.live.base.network.j jVar = com.cupidapp.live.base.network.j.f12008a;
                String a10 = jVar.a(it);
                Integer valueOf = a10 != null ? Integer.valueOf(z0.t.q(a10)) : null;
                kotlin.jvm.internal.s.h(it, "it");
                String b4 = jVar.b(it, false);
                mutableLiveData2 = FKSwipeCardViewModel.this._filterSettingLiveData;
                mutableLiveData.setValue(new Pair(bool, new FKFaultModel(valueOf, b4, false, (MatchSettingResult) mutableLiveData2.getValue())));
            }
        };
        observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.match.viewmodel.f
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FKSwipeCardViewModel.loadMatchRcmdData$lambda$4(Function1.this, obj);
            }
        });
    }

    public static final MatchResult loadMatchRcmdData$lambda$2(ConstantsResult t12, MatchResult t2) {
        kotlin.jvm.internal.s.i(t12, "t1");
        kotlin.jvm.internal.s.i(t2, "t2");
        ConstantsResult q10 = p1.g.f52734a.q();
        if (q10 != null) {
            q10.setEnableButtons(t12.getEnableButtons());
        }
        return t2;
    }

    public static final void loadMatchRcmdData$lambda$3(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void loadMatchRcmdData$lambda$4(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static /* synthetic */ void setAlohaOrNopeButtonVisible$default(FKSwipeCardViewModel fKSwipeCardViewModel, boolean z10, float f10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f10 = 0.0f;
        }
        fKSwipeCardViewModel.setAlohaOrNopeButtonVisible(z10, f10);
    }

    public static /* synthetic */ void setSwipeCardFault$default(FKSwipeCardViewModel fKSwipeCardViewModel, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        fKSwipeCardViewModel.setSwipeCardFault(z10, z11);
    }

    public final void alohaCard(@NotNull final MatchRecommendUserModel card, @NotNull String refer, final int i10) {
        kotlin.jvm.internal.s.i(card, "card");
        kotlin.jvm.internal.s.i(refer, "refer");
        w2.a.f54095a.c();
        p1.g.f52734a.M0().d(Long.valueOf(System.currentTimeMillis()));
        Disposable disposed = a.C0836a.o(NetworkClient.f11868a.N(), card.getUser().userId(), GsonUtil.f12000a.b().toJson(card.getRecommendContext()), null, refer, 0, null, null, null, 244, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<SwipeCardUserLikeResult, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.FKSwipeCardViewModel$alohaCard$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                m2721invoke(swipeCardUserLikeResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2721invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                MutableLiveData mutableLiveData3;
                SwipeCardUserLikeResult swipeCardUserLikeResult2 = swipeCardUserLikeResult;
                mutableLiveData = FKSwipeCardViewModel.this._alohaOrNopeGuideLiveData;
                mutableLiveData.setValue(new Event(swipeCardUserLikeResult2.getAlohaOrNopeGuide()));
                mutableLiveData2 = FKSwipeCardViewModel.this._alohaOrNopeResidueNumLiveData;
                Integer alohaOrNopeResidueNum = swipeCardUserLikeResult2.getAlohaOrNopeResidueNum();
                mutableLiveData2.setValue(new Event(Integer.valueOf(alohaOrNopeResidueNum != null ? alohaOrNopeResidueNum.intValue() : -1)));
                mutableLiveData3 = FKSwipeCardViewModel.this._alohaOrNopeResultLiveData;
                mutableLiveData3.setValue(new Pair(Boolean.TRUE, swipeCardUserLikeResult2));
                FKSwipeCardViewModel.this.groupMatchLog(true, card, null, false, i10);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.match.viewmodel.FKSwipeCardViewModel$alohaCard$2
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                boolean z10;
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                kotlin.jvm.internal.s.i(it, "it");
                String a10 = com.cupidapp.live.base.network.j.f12008a.a(it);
                Integer valueOf = a10 != null ? Integer.valueOf(z0.t.q(a10)) : null;
                int value = RequestErrorCode.MatchUserFrequentlyAlohaPunishment.getValue();
                if (valueOf != null && valueOf.intValue() == value) {
                    FKSwipeCardViewModel.this.setClearEvent();
                    mutableLiveData = FKSwipeCardViewModel.this._swipeCardFaultLiveData;
                    Boolean bool = Boolean.TRUE;
                    mutableLiveData2 = FKSwipeCardViewModel.this._filterSettingLiveData;
                    mutableLiveData.setValue(new Pair(bool, new FKFaultModel(valueOf, null, false, (MatchSettingResult) mutableLiveData2.getValue(), 6, null)));
                    z10 = true;
                } else {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            }
        }, null)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void alohaOrNopeClick(boolean z10) {
        if (checkHasAlohaOrNopeNum()) {
            this._alohaOrNopeClickEvent.setValue(new Event<>(Boolean.valueOf(z10)));
        } else {
            this._showVipOrPlusDialogEvent.setValue(new Event<>(VipPurchaseEntranceType.UnLimitSwipeCard));
        }
    }

    public final void campaignExposure(@NotNull MatchRecommendModel model) {
        String str;
        String str2;
        String str3;
        kotlin.jvm.internal.s.i(model, "model");
        if (model instanceof MatchGroupCampaignModel) {
            MatchGroupCampaignModel matchGroupCampaignModel = (MatchGroupCampaignModel) model;
            str2 = matchGroupCampaignModel.getConfigKey();
            str3 = matchGroupCampaignModel.getActivityId();
            str = matchGroupCampaignModel.getGroupId();
        } else if (model instanceof MatchMarketingModel) {
            str2 = ((MatchMarketingModel) model).getConfigKey();
            str = null;
            str3 = null;
        } else {
            str = null;
            str2 = null;
            str3 = null;
        }
        Disposable disposed = NetworkClient.f11868a.A().a(model.getType(), str2, str3, str).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.FKSwipeCardViewModel$campaignExposure$$inlined$handle$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.match.viewmodel.FKSwipeCardViewModel$campaignExposure$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                return Boolean.TRUE;
            }
        }, null)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void changeGuideAnimLiveData(boolean z10) {
        this._guideAnimLiveData.setValue(Boolean.valueOf(z10));
    }

    public final boolean checkHasAlohaOrNopeNum() {
        Integer peekContent;
        Event<Integer> value = this.alohaOrNopeResidueNumLiveData.getValue();
        boolean z10 = false;
        if (value != null && (peekContent = value.peekContent()) != null && peekContent.intValue() == 0) {
            z10 = true;
        }
        return !z10;
    }

    public final void checkShowNewUserGuide() {
        if (p1.g.f52734a.x0()) {
            Disposable disposed = NetworkClient.f11868a.l().L().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<GuideModel, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.FKSwipeCardViewModel$checkShowNewUserGuide$$inlined$handle$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(GuideModel guideModel) {
                    m2722invoke(guideModel);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2722invoke(GuideModel guideModel) {
                    MutableLiveData mutableLiveData;
                    mutableLiveData = FKSwipeCardViewModel.this._swipeCardNewUserGuideLiveData;
                    mutableLiveData.setValue(new Event(guideModel.getGuideContent()));
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.match.viewmodel.FKSwipeCardViewModel$checkShowNewUserGuide$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    MutableLiveData mutableLiveData;
                    kotlin.jvm.internal.s.i(it, "it");
                    mutableLiveData = FKSwipeCardViewModel.this._swipeCardNewUserGuideLiveData;
                    mutableLiveData.setValue(new Event(""));
                    return Boolean.TRUE;
                }
            }, null)));
            if (disposed != null) {
                kotlin.jvm.internal.s.h(disposed, "disposed");
            }
            kotlin.jvm.internal.s.h(disposed, "disposed");
            return;
        }
        this._swipeCardNewUserGuideLiveData.setValue(new Event<>(""));
    }

    public final void checkShowSuperBoostGuide() {
        p1.g gVar = p1.g.f52734a;
        if (gVar.M3() || gVar.L3()) {
            if (gVar.M3() && !gVar.L3()) {
                checkShowSuperLikeGuide();
                return;
            }
            Disposable disposed = NetworkClient.f11868a.N().W().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<SuperLikeGuideResult, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.FKSwipeCardViewModel$checkShowSuperBoostGuide$$inlined$handle$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(SuperLikeGuideResult superLikeGuideResult) {
                    m2723invoke(superLikeGuideResult);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2723invoke(SuperLikeGuideResult superLikeGuideResult) {
                    MutableLiveData mutableLiveData;
                    SuperLikeGuideResult superLikeGuideResult2 = superLikeGuideResult;
                    String remainNums = superLikeGuideResult2.getRemainNums();
                    if (remainNums == null || remainNums.length() == 0) {
                        FKSwipeCardViewModel.this.checkShowSuperLikeGuide();
                    } else {
                        mutableLiveData = FKSwipeCardViewModel.this._superBoostOrSuperLikeNumLiveData;
                        mutableLiveData.setValue(new Pair(superLikeGuideResult2.getRemainNums(), null));
                    }
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.match.viewmodel.FKSwipeCardViewModel$checkShowSuperBoostGuide$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    kotlin.jvm.internal.s.i(it, "it");
                    FKSwipeCardViewModel.this.checkShowSuperLikeGuide();
                    return Boolean.TRUE;
                }
            }, null)));
            if (disposed != null) {
                kotlin.jvm.internal.s.h(disposed, "disposed");
            }
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
    }

    public final void checkSwipeNumToShowPurchase() {
        if (checkHasAlohaOrNopeNum()) {
            return;
        }
        this._showVipOrPlusDialogEvent.setValue(new Event<>(VipPurchaseEntranceType.UnLimitSwipeCard));
    }

    public final void closeShowNewUserGuide() {
        p1.g.f52734a.U2(false);
        Disposable disposed = NetworkClient.f11868a.l().L().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<GuideModel, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.FKSwipeCardViewModel$closeShowNewUserGuide$$inlined$handle$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(GuideModel guideModel) {
                m2725invoke(guideModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2725invoke(GuideModel guideModel) {
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.match.viewmodel.FKSwipeCardViewModel$closeShowNewUserGuide$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                return Boolean.TRUE;
            }
        }, null)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<Pair<Boolean, Float>> getAlohaOrNopeButtonVisibleLiveData() {
        return this.alohaOrNopeButtonVisibleLiveData;
    }

    @NotNull
    public final LiveData<Event<Boolean>> getAlohaOrNopeClickEvent() {
        return this.alohaOrNopeClickEvent;
    }

    @NotNull
    public final LiveData<Event<AlohaOrNopeGuideModel>> getAlohaOrNopeGuideLiveData() {
        return this.alohaOrNopeGuideLiveData;
    }

    @NotNull
    public final LiveData<Event<Integer>> getAlohaOrNopeResidueNumLiveData() {
        return this.alohaOrNopeResidueNumLiveData;
    }

    @NotNull
    public final LiveData<Pair<Boolean, SwipeCardUserLikeResult>> getAlohaOrNopeResultLiveData() {
        return this.alohaOrNopeResultLiveData;
    }

    @NotNull
    public final LiveData<Boolean> getCancelNopeButtonVisibleLiveData() {
        return this.cancelNopeButtonVisibleLiveData;
    }

    @NotNull
    public final LiveData<Event<Boolean>> getClearSwipeCardEvent() {
        return this.clearSwipeCardEvent;
    }

    @NotNull
    public final LiveData<DailyLikeGuideModel> getDailyGuideTipLiveData() {
        return this.dailyGuideTipLiveData;
    }

    @NotNull
    public final LiveData<Event<FKSwipeCardFaultType>> getFaultActionEvent() {
        return this.faultActionEvent;
    }

    @NotNull
    public final LiveData<Boolean> getGuideAnimLiveData() {
        return this.guideAnimLiveData;
    }

    @NotNull
    public final LiveData<Event<MatchRecommendModel>> getNopeCardClickEvent() {
        return this.nopeCardClickEvent;
    }

    public final void getRecommendLiveData() {
        if (this.callApiReturnEmptyMaxCount <= 0) {
            return;
        }
        Disposable disposed = NetworkClient.f11868a.A().r().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ListResult<LiveShowModel>, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.FKSwipeCardViewModel$getRecommendLiveData$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(ListResult<LiveShowModel> listResult) {
                m2726invoke(listResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2726invoke(ListResult<LiveShowModel> listResult) {
                MutableLiveData mutableLiveData;
                int i10;
                ListResult<LiveShowModel> listResult2 = listResult;
                List<LiveShowModel> list = listResult2.getList();
                if (list == null || list.isEmpty()) {
                    i10 = FKSwipeCardViewModel.this.callApiReturnEmptyMaxCount;
                    FKSwipeCardViewModel.this.callApiReturnEmptyMaxCount = i10 - 1;
                } else {
                    mutableLiveData = FKSwipeCardViewModel.this._swipeCardLiveShowLiveData;
                    List<LiveShowModel> list2 = listResult2.getList();
                    kotlin.jvm.internal.s.f(list2);
                    mutableLiveData.setValue(list2);
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    @NotNull
    public final LiveData<Event<AlohaGuideModel>> getShowGetAlohaDialogLiveData() {
        return this.showGetAlohaDialogLiveData;
    }

    @NotNull
    public final LiveData<Pair<String, String>> getShowSuperBoostOrSuperLikeNumLiveData() {
        return this.showSuperBoostOrSuperLikeNumLiveData;
    }

    @NotNull
    public final LiveData<Event<VipPurchaseEntranceType>> getShowVipOrPlusDialogEvent() {
        return this.showVipOrPlusDialogEvent;
    }

    @NotNull
    public final LiveData<Boolean> getStartOrStopPlayStreamLiveData() {
        return this.startOrStopPlayStreamLiveData;
    }

    @NotNull
    public final LiveData<Event<Integer>> getSuperLikeEvent() {
        return this.superLikeEvent;
    }

    public final void getSwipeCardData() {
        if (this.isLoading) {
            return;
        }
        this.isLoading = true;
        loadMatchRcmdData();
    }

    @NotNull
    public final LiveData<Pair<Boolean, FKFaultModel>> getSwipeCardFaultLiveData() {
        return this.swipeCardFaultLiveData;
    }

    @NotNull
    public final LiveData<StateResult<Pair<List<MatchRecommendModel>, Boolean>>> getSwipeCardLiveData() {
        return this.swipeCardLiveData;
    }

    @NotNull
    public final LiveData<List<LiveShowModel>> getSwipeCardLiveShowLiveData() {
        return this.swipeCardLiveShowLiveData;
    }

    @NotNull
    public final LiveData<Event<String>> getSwipeCardNewUserGuideLiveData() {
        return this.swipeCardNewUserGuideLiveData;
    }

    @NotNull
    public final LiveData<Boolean> getUploadAvatarVisibleLiveData() {
        return this.uploadAvatarVisibleLiveData;
    }

    @NotNull
    public final LiveData<Boolean> getWindowClickLiveData() {
        return this.windowClickLiveData;
    }

    public final void groupMatchLog(boolean z10, @NotNull MatchRecommendUserModel recommend, @Nullable Integer num, boolean z11, int i10) {
        ImageModel avatar;
        int size;
        VideoModel video;
        kotlin.jvm.internal.s.i(recommend, "recommend");
        List<MatchCardItemModel> multiAvatars = recommend.getMultiAvatars();
        boolean z12 = false;
        if (multiAvatars == null || multiAvatars.isEmpty()) {
            avatar = recommend.getUser().getAvatarProfile().get(i10).getAvatarImage();
            List<AvatarProfileModel> avatarProfile = recommend.getUser().getAvatarProfile();
            ArrayList arrayList = new ArrayList();
            Iterator<AvatarProfileModel> iterator2 = avatarProfile.iterator2();
            while (iterator2.hasNext()) {
                VideoModel avatarVideo = iterator2.next().getAvatarVideo();
                if (avatarVideo != null) {
                    arrayList.add(avatarVideo);
                }
            }
            size = arrayList.size();
            video = recommend.getUser().getAvatarProfile().get(i10).getAvatarVideo();
        } else {
            avatar = recommend.getMultiAvatars().get(i10).getAvatar();
            List<MatchCardItemModel> multiAvatars2 = recommend.getMultiAvatars();
            ArrayList arrayList2 = new ArrayList();
            Iterator<MatchCardItemModel> iterator22 = multiAvatars2.iterator2();
            while (iterator22.hasNext()) {
                VideoModel video2 = iterator22.next().getVideo();
                if (video2 != null) {
                    arrayList2.add(video2);
                }
            }
            size = arrayList2.size();
            video = recommend.getMultiAvatars().get(i10).getVideo();
        }
        int i11 = size;
        GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
        String value = SensorScene.Match.getValue();
        String userId = recommend.getUser().userId();
        int i12 = i10 + 1;
        boolean isAlohaMatched = recommend.getUser().isAlohaMatched();
        Map<String, Object> recommendContext = recommend.getRecommendContext();
        User user = recommend.getUser();
        String imageId = avatar != null ? avatar.getImageId() : null;
        String newUserTag = recommend.getUser().getNewUserTag();
        boolean z13 = !(newUserTag == null || newUserTag.length() == 0);
        String videoId = video != null ? video.getVideoId() : null;
        boolean z14 = recommend.getAlohaGetIcon() != null;
        String activeDesc = recommend.getUser().getActiveDesc();
        int i13 = this.swipeCardCount;
        boolean z15 = recommend.getUser().getProfileLevelIcon() != null;
        ZodiacElfInfoModel zodiacInfo = recommend.getUser().getZodiacInfo();
        String subTitle = zodiacInfo != null ? zodiacInfo.getSubTitle() : null;
        MBTIInfoModel mbtiInfo = recommend.getUser().getMbtiInfo();
        String mbti = mbtiInfo != null ? mbtiInfo.getMbti() : null;
        String travelCity = recommend.getUser().getTravelCity();
        if (travelCity != null) {
            if (travelCity.length() > 0) {
                z12 = true;
            }
        }
        groupSocialLog.B(z10, value, userId, (r52 & 8) != 0 ? 1 : i12, (r52 & 16) != 0 ? null : Boolean.valueOf(isAlohaMatched), (r52 & 32) != 0 ? null : recommendContext, (r52 & 64) != 0 ? false : true, (r52 & 128) != 0 ? null : user, (r52 & 256) != 0 ? null : null, (r52 & 512) != 0 ? false : z11, (r52 & 1024) != 0 ? null : imageId, (r52 & 2048) != 0 ? null : Boolean.valueOf(z13), (r52 & 4096) != 0 ? 0 : i11, (r52 & 8192) != 0 ? null : videoId, (r52 & 16384) != 0 ? false : z14, (32768 & r52) != 0 ? null : activeDesc, (65536 & r52) != 0 ? null : Integer.valueOf(i13), (131072 & r52) != 0 ? null : num, (262144 & r52) != 0 ? null : Boolean.valueOf(z15), (524288 & r52) != 0 ? null : null, (1048576 & r52) != 0 ? null : subTitle, (2097152 & r52) != 0 ? null : mbti, (4194304 & r52) != 0 ? null : null, (r52 & 8388608) != 0 ? null : Boolean.valueOf(z12));
    }

    public final void loadAlohaCard() {
        Disposable disposed = NetworkClient.f11868a.A().o().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<AlohaGuideModel, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.FKSwipeCardViewModel$loadAlohaCard$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(AlohaGuideModel alohaGuideModel) {
                m2727invoke(alohaGuideModel);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2727invoke(AlohaGuideModel alohaGuideModel) {
                MutableLiveData mutableLiveData;
                mutableLiveData = FKSwipeCardViewModel.this._showGetAlohaDialogLiveData;
                mutableLiveData.setValue(new Event(alohaGuideModel));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void nopeCampaign(@NotNull MatchRecommendModel card) {
        kotlin.jvm.internal.s.i(card, "card");
        setNopeCardData(card);
    }

    public final void nopeCard(@NotNull final MatchRecommendUserModel card, @NotNull String refer, final int i10) {
        kotlin.jvm.internal.s.i(card, "card");
        kotlin.jvm.internal.s.i(refer, "refer");
        w2.a.f54095a.c();
        p1.g.f52734a.M0().d(Long.valueOf(System.currentTimeMillis()));
        Disposable disposed = NetworkClient.f11868a.N().D0(card.getUser().userId(), GsonUtil.f12000a.b().toJson(card.getRecommendContext()), refer).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<SwipeCardUserLikeResult, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.FKSwipeCardViewModel$nopeCard$$inlined$handle$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                m2728invoke(swipeCardUserLikeResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2728invoke(SwipeCardUserLikeResult swipeCardUserLikeResult) {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                MutableLiveData mutableLiveData3;
                SwipeCardUserLikeResult swipeCardUserLikeResult2 = swipeCardUserLikeResult;
                mutableLiveData = FKSwipeCardViewModel.this._alohaOrNopeResidueNumLiveData;
                Integer alohaOrNopeResidueNum = swipeCardUserLikeResult2.getAlohaOrNopeResidueNum();
                mutableLiveData.setValue(new Event(Integer.valueOf(alohaOrNopeResidueNum != null ? alohaOrNopeResidueNum.intValue() : -1)));
                mutableLiveData2 = FKSwipeCardViewModel.this._alohaOrNopeResultLiveData;
                mutableLiveData2.setValue(new Pair(Boolean.FALSE, swipeCardUserLikeResult2));
                mutableLiveData3 = FKSwipeCardViewModel.this._alohaOrNopeGuideLiveData;
                mutableLiveData3.setValue(new Event(swipeCardUserLikeResult2.getAlohaOrNopeGuide()));
                FKSwipeCardViewModel.this.groupMatchLog(false, card, null, false, i10);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, null)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
        setNopeCardData(card);
    }

    public final void prefetchSwipeCardData() {
        if (this.isLoading) {
            return;
        }
        this.isLoading = true;
        Disposable disposed = NetworkClient.f11868a.A().e(true).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<MatchResult, kotlin.p>() { // from class: com.cupidapp.live.match.viewmodel.FKSwipeCardViewModel$prefetchSwipeCardData$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(MatchResult matchResult) {
                m2729invoke(matchResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2729invoke(MatchResult matchResult) {
                MutableLiveData mutableLiveData;
                MatchResult matchResult2 = matchResult;
                FKSwipeCardViewModel.this.isLoading = false;
                List<MatchRecommendModel> list = matchResult2.getList();
                if (list == null || list.isEmpty()) {
                    return;
                }
                mutableLiveData = FKSwipeCardViewModel.this._swipeCardLiveData;
                List<MatchRecommendModel> list2 = matchResult2.getList();
                kotlin.jvm.internal.s.f(list2);
                mutableLiveData.setValue(new StateResult.c(new Pair(list2, Boolean.FALSE), null, 2, null));
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.match.viewmodel.FKSwipeCardViewModel$prefetchSwipeCardData$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                FKSwipeCardViewModel.this.isLoading = false;
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void setAlohaOrNopeButtonVisible(boolean z10, float f10) {
        this._alohaOrNopeButtonVisibleLiveData.setValue(new Pair<>(Boolean.valueOf(z10), Float.valueOf(f10)));
    }

    public final void setCancelNopeButtonVisible(boolean z10) {
        this._cancelNopeButtonVisibleLiveData.setValue(Boolean.valueOf(this._nopeCardLiveData.getValue() != null && z10));
    }

    public final void setClearEvent() {
        this._clearSwipeCardEvent.setValue(new Event<>(Boolean.TRUE));
    }

    public final void setFaultClickEvent(@NotNull FKSwipeCardFaultType fault) {
        kotlin.jvm.internal.s.i(fault, "fault");
        this._faultActionEvent.setValue(new Event<>(fault));
    }

    public final void setFilterSetting(@Nullable MatchSettingResult matchSettingResult) {
        this._filterSettingLiveData.setValue(matchSettingResult);
    }

    public final void setNopeCardClick() {
        this._nopeCardClickEvent.setValue(new Event<>(this._nopeCardLiveData.getValue()));
    }

    public final void setNopeCardData(@Nullable MatchRecommendModel matchRecommendModel) {
        this._nopeCardLiveData.setValue(matchRecommendModel);
        this._cancelNopeButtonVisibleLiveData.setValue(Boolean.valueOf(matchRecommendModel != null));
    }

    public final void setStartOrStopPlayStream(boolean z10) {
        this._startOrStopPlayStreamLiveData.setValue(Boolean.valueOf(z10));
    }

    public final void setSwipeCardCount(boolean z10) {
        if (z10) {
            this.swipeCardCount++;
        } else {
            this.swipeCardCount--;
        }
    }

    public final void setSwipeCardFault(boolean z10, boolean z11) {
        this._swipeCardFaultLiveData.setValue(new Pair<>(Boolean.valueOf(z10), new FKFaultModel(null, null, z11, this._filterSettingLiveData.getValue(), 3, null)));
    }

    public final void setUploadAvatarVisible(boolean z10) {
        Long E1 = p1.g.f52734a.E1();
        this._uploadAvatarVisibleLiveData.setValue(Boolean.valueOf(z10 && (E1 == null || E1.longValue() == 0 || !DateUtils.isToday(E1.longValue()))));
    }

    public final void setWindowClickable(boolean z10) {
        this._windowClickLiveData.setValue(Boolean.valueOf(z10));
    }

    public final void showVipOrPlusPurchaseDialog(@NotNull VipPurchaseEntranceType type) {
        kotlin.jvm.internal.s.i(type, "type");
        this._showVipOrPlusDialogEvent.setValue(new Event<>(type));
    }

    public final void superLikeClick(int i10) {
        this._superLikeEvent.setValue(new Event<>(Integer.valueOf(i10)));
    }
}
