package com.cupidapp.live.consult.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.grpc.GrpcConnectEvent;
import com.cupidapp.live.base.grpc.GrpcMessageRouter;
import com.cupidapp.live.base.livedata.Event;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.d;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.consult.activity.ConsultViewerActivity;
import com.cupidapp.live.consult.helper.ConsultFloatWindowHelper;
import com.cupidapp.live.consult.helper.ConsultLiveHelper;
import com.cupidapp.live.consult.helper.ConsultRoomGuideHelper;
import com.cupidapp.live.consult.model.ConsultApplyConnectGrpcModel;
import com.cupidapp.live.consult.model.ConsultCommentModel;
import com.cupidapp.live.consult.model.ConsultConnectState;
import com.cupidapp.live.consult.model.ConsultConnectSuccessGrpcModel;
import com.cupidapp.live.consult.model.ConsultConnectType;
import com.cupidapp.live.consult.model.ConsultConnectUserModel;
import com.cupidapp.live.consult.model.ConsultLiveModel;
import com.cupidapp.live.consult.model.ConsultOnlineInfoModel;
import com.cupidapp.live.consult.model.HangUpConnectModel;
import com.cupidapp.live.consult.model.RequestConnectResult;
import com.cupidapp.live.consult.model.ShowDiamondBalanceModel;
import com.cupidapp.live.consult.view.ConsultBottomMenuLayout;
import com.cupidapp.live.consult.view.ConsultCommentListLayout;
import com.cupidapp.live.consult.view.ConsultLiveTitleLayout;
import com.cupidapp.live.consult.view.ConsultViewerLiveEndLayout;
import com.cupidapp.live.consult.view.ConsultVoiceChatLayout;
import com.cupidapp.live.consult.view.ViewerConsultConnectLayout;
import com.cupidapp.live.consult.viewmodel.ConsultViewerViewModel;
import com.cupidapp.live.liveshow.view.giftpicker.fragment.DiamondBalanceFragment;
import com.cupidapp.live.profile.event.UserProfileDataChangeEvent;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.ConsultConnectBtn;
import com.cupidapp.live.voiceparty.engine.IVoiceEngine;
import he.j;
import j1.i;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultViewerFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultViewerFragment extends FKBaseFragment {

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public static final a f13790q = new a(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f13792f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public ConsultViewerActivity.Config f13793g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Lazy f13794h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public final Lazy f13795i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f13796j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public Observer<Event<ConsultApplyConnectGrpcModel>> f13797k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public Observer<Event<Pair<Boolean, ConsultConnectSuccessGrpcModel>>> f13798l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public Observer<Event<HangUpConnectModel>> f13799m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public FKAlertDialog f13800n;

    /* renamed from: o, reason: collision with root package name */
    @NotNull
    public final Lazy f13801o;

    /* renamed from: p, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13802p = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    public boolean f13791e = true;

    /* compiled from: ConsultViewerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ConsultViewerFragment a() {
            return new ConsultViewerFragment();
        }
    }

    /* compiled from: ConsultViewerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements com.cupidapp.live.consult.view.e {
        public b() {
        }

        @Override // com.cupidapp.live.consult.view.e
        public void a() {
            ConsultViewerFragment.this.P1();
            ConsultViewerFragment.this.I1(ConsultConnectBtn.Connect);
            ConsultViewerFragment.this.A1().f();
        }

        @Override // com.cupidapp.live.consult.view.e
        public void b() {
            ConsultViewerFragment.this.D1().hangUp();
            ConsultViewerFragment.this.I1(ConsultConnectBtn.HangUp);
        }

        @Override // com.cupidapp.live.consult.view.e
        public void c(@NotNull ConsultConnectState connectState) {
            s.i(connectState, "connectState");
            ConsultViewerFragment.this.D1().showConnectOrder(connectState);
        }
    }

    /* compiled from: ConsultViewerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements IVoiceEngine.a {
        public c() {
        }

        @Override // com.cupidapp.live.voiceparty.engine.IVoiceEngine.a
        public void a(@NotNull IVoiceEngine.NetworkStateLevel localLevel, @NotNull IVoiceEngine.NetworkStateLevel remoteLevel) {
            s.i(localLevel, "localLevel");
            s.i(remoteLevel, "remoteLevel");
            ConsultLiveTitleLayout consultLiveTitleLayout = (ConsultLiveTitleLayout) ConsultViewerFragment.this.S0(R$id.consult_viewer_title_layout);
            if (consultLiveTitleLayout != null) {
                consultLiveTitleLayout.c(localLevel, remoteLevel);
            }
        }

        @Override // com.cupidapp.live.voiceparty.engine.IVoiceEngine.a
        public void b() {
            ConsultViewerFragment.this.D1().switchRoleSuccess();
        }

        @Override // com.cupidapp.live.voiceparty.engine.IVoiceEngine.a
        public void c(long j10) {
            ConsultViewerFragment.this.D1().changeRoomSuccess();
        }

        @Override // com.cupidapp.live.voiceparty.engine.IVoiceEngine.a
        public void d() {
            ConsultViewerFragment.this.D1().refreshConsultRoomInfo(true);
        }

        @Override // com.cupidapp.live.voiceparty.engine.IVoiceEngine.a
        public void e(@NotNull Map<String, Integer> userVolumes) {
            s.i(userVolumes, "userVolumes");
            ConsultVoiceChatLayout consultVoiceChatLayout = (ConsultVoiceChatLayout) ConsultViewerFragment.this.S0(R$id.consult_viewer_voice_chat_layout);
            if (consultVoiceChatLayout != null) {
                consultVoiceChatLayout.B(userVolumes);
            }
        }

        @Override // com.cupidapp.live.voiceparty.engine.IVoiceEngine.a
        public void f(int i10) {
        }

        @Override // com.cupidapp.live.voiceparty.engine.IVoiceEngine.a
        public void onError(int i10, @Nullable String str) {
        }
    }

    /* compiled from: ConsultViewerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class d implements com.cupidapp.live.consult.fragment.a {
        public d() {
        }

        @Override // com.cupidapp.live.consult.fragment.a
        public void a() {
            ConsultViewerFragment.this.P1();
            ConsultViewerFragment.this.A1().f();
        }

        @Override // com.cupidapp.live.consult.fragment.a
        public void b() {
            ConsultViewerFragment.this.D1().cancelRequest();
        }
    }

    /* compiled from: ConsultViewerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class e implements com.cupidapp.live.liveshow.view.giftpicker.fragment.a {
        public e() {
        }

        @Override // com.cupidapp.live.liveshow.view.giftpicker.fragment.a
        public void a() {
            if (((ConsultViewerLiveEndLayout) ConsultViewerFragment.this.S0(R$id.consult_viewer_live_end_layout)).getVisibility() != 0) {
                ConsultViewerFragment.this.D1().showRequestConnect();
            }
        }
    }

    /* compiled from: ConsultViewerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class f implements com.cupidapp.live.consult.fragment.b {
        public f() {
        }

        @Override // com.cupidapp.live.consult.fragment.b
        public void a(@NotNull ConsultConnectType connectType) {
            s.i(connectType, "connectType");
            ConsultViewerFragment.this.D1().requestConnect(connectType.getValue());
        }

        @Override // com.cupidapp.live.consult.fragment.b
        public void b() {
            ConsultViewerViewModel.showRecharge$default(ConsultViewerFragment.this.D1(), null, null, true, 3, null);
        }
    }

    /* compiled from: ConsultViewerFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class g implements com.cupidapp.live.consult.helper.a {
        public g() {
        }

        @Override // com.cupidapp.live.consult.helper.a
        public void a() {
            ConsultViewerFragment.this.R1();
        }

        @Override // com.cupidapp.live.consult.helper.a
        public void b() {
            ConsultViewerFragment.this.w1();
        }
    }

    public ConsultViewerFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.f13792f = FragmentViewModelLazyKt.createViewModelLazy(this, v.b(ConsultViewerViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                s.h(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
        this.f13794h = kotlin.c.b(new Function0<com.cupidapp.live.base.utils.d>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$mAudioControlManager$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final d invoke() {
                return new d(ConsultViewerFragment.this.getContext());
            }
        });
        this.f13795i = kotlin.c.b(new Function0<com.cupidapp.live.voiceparty.helper.b>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$mSoundPlayHelper$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.cupidapp.live.voiceparty.helper.b invoke() {
                return new com.cupidapp.live.voiceparty.helper.b();
            }
        });
        this.f13796j = true;
        this.f13801o = kotlin.c.b(new Function0<ConsultRoomGuideHelper>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$guideHelper$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ConsultRoomGuideHelper invoke() {
                return new ConsultRoomGuideHelper();
            }
        });
    }

    public final ConsultRoomGuideHelper A1() {
        return (ConsultRoomGuideHelper) this.f13801o.getValue();
    }

    public final com.cupidapp.live.base.utils.d B1() {
        return (com.cupidapp.live.base.utils.d) this.f13794h.getValue();
    }

    public final com.cupidapp.live.voiceparty.helper.b C1() {
        return (com.cupidapp.live.voiceparty.helper.b) this.f13795i.getValue();
    }

    public final ConsultViewerViewModel D1() {
        return (ConsultViewerViewModel) this.f13792f.getValue();
    }

    public final void E1(HangUpConnectModel hangUpConnectModel) {
        ((ViewerConsultConnectLayout) S0(R$id.consult_viewer_connect_layout)).d(ConsultConnectState.FreeState);
        T1(false, hangUpConnectModel.getConnectType(), hangUpConnectModel.getOption());
        if (hangUpConnectModel.getActive()) {
            h.f12779a.k(R$string.connect_finished);
        } else {
            String tips = hangUpConnectModel.getTips();
            if (!(tips == null || tips.length() == 0)) {
                M1(hangUpConnectModel.getTips());
            }
        }
        K1(true);
        DiamondBalanceFragment.f15433o.a();
    }

    public final void F1() {
        D1().getEnterRoomLog().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Pair<? extends Boolean, ? extends ConsultLiveModel>, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$initObserve$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Pair<? extends Boolean, ? extends ConsultLiveModel> pair) {
                invoke2((Pair<Boolean, ConsultLiveModel>) pair);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Pair<Boolean, ConsultLiveModel> it) {
                s.i(it, "it");
                ConsultViewerFragment.this.y1(it.getFirst().booleanValue(), it.getSecond());
            }
        }));
        D1().getLiveInfoData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<ConsultLiveModel, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$initObserve$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ConsultLiveModel consultLiveModel) {
                invoke2(consultLiveModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ConsultLiveModel model) {
                s.i(model, "model");
                ConsultViewerFragment.this.x1(model);
                ConsultViewerFragment.this.v1(model);
                ConsultViewerFragment.this.N1(model.getConnectGuideFreq(), model.getConnectGuideTimeLimit(), model.getUser());
            }
        }));
        D1().getRefreshRoomInfoLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Triple<? extends Boolean, ? extends ConsultLiveModel, ? extends HangUpConnectModel>, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$initObserve$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Triple<? extends Boolean, ? extends ConsultLiveModel, ? extends HangUpConnectModel> triple) {
                invoke2((Triple<Boolean, ConsultLiveModel, HangUpConnectModel>) triple);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Triple<Boolean, ConsultLiveModel, HangUpConnectModel> it) {
                s.i(it, "it");
                ConsultViewerFragment.this.H1(it.getFirst().booleanValue(), it.getSecond(), it.getThird());
            }
        }));
        D1().getVoiceEngineOption().observe(getViewLifecycleOwner(), new EventObserver(new Function1<IVoiceEngine.VoiceEngineOption, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$initObserve$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(IVoiceEngine.VoiceEngineOption voiceEngineOption) {
                invoke2(voiceEngineOption);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull IVoiceEngine.VoiceEngineOption option) {
                s.i(option, "option");
                ConsultViewerFragment.this.u1();
                ConsultViewerFragment.this.z1(option);
                ConsultViewerFragment.this.s1();
            }
        }));
        D1().getShowRequestConnectLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<String, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$initObserve$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(String str) {
                invoke2(str);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String it) {
                s.i(it, "it");
                ConsultViewerFragment.this.Q1(it);
            }
        }));
        D1().getRequestConnectLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<RequestConnectResult, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$initObserve$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(RequestConnectResult requestConnectResult) {
                invoke2(requestConnectResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull RequestConnectResult it) {
                s.i(it, "it");
                ViewerConsultConnectLayout viewerConsultConnectLayout = (ViewerConsultConnectLayout) ConsultViewerFragment.this.S0(R$id.consult_viewer_connect_layout);
                Integer count = it.getCount();
                viewerConsultConnectLayout.e(count != null ? count.intValue() : 0);
                viewerConsultConnectLayout.d(ConsultConnectState.WaitConnect);
                ConsultViewerFragment consultViewerFragment = ConsultViewerFragment.this;
                String string = consultViewerFragment.getString(R$string.connect_tips);
                s.h(string, "getString(R.string.connect_tips)");
                consultViewerFragment.M1(string);
            }
        }));
        D1().getRequestConnectChangeLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Boolean, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$initObserve$7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return p.f51048a;
            }

            public final void invoke(boolean z10) {
                h.f12779a.k(R$string.connect_be_refused);
                ((ViewerConsultConnectLayout) ConsultViewerFragment.this.S0(R$id.consult_viewer_connect_layout)).d(ConsultConnectState.FreeState);
                ConsultConnectOrderFragment.f13757k.b();
            }
        }));
        D1().getCancelRequestLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Boolean, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$initObserve$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return p.f51048a;
            }

            public final void invoke(boolean z10) {
                ((ViewerConsultConnectLayout) ConsultViewerFragment.this.S0(R$id.consult_viewer_connect_layout)).d(ConsultConnectState.FreeState);
                ConsultConnectOrderFragment.f13757k.b();
            }
        }));
        D1().getConnectCountChangeLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Integer, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$initObserve$9
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Integer num) {
                invoke(num.intValue());
                return p.f51048a;
            }

            public final void invoke(int i10) {
                ((ViewerConsultConnectLayout) ConsultViewerFragment.this.S0(R$id.consult_viewer_connect_layout)).e(i10);
                ConsultConnectOrderFragment.f13757k.c();
            }
        }));
        this.f13797k = new EventObserver(new ConsultViewerFragment$initObserve$10(this));
        LiveData<Event<ConsultApplyConnectGrpcModel>> applyConnectPromptLiveData = D1().getApplyConnectPromptLiveData();
        Observer<Event<ConsultApplyConnectGrpcModel>> observer = this.f13797k;
        s.f(observer);
        applyConnectPromptLiveData.observeForever(observer);
        D1().getAgreeConnectLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Pair<? extends String, ? extends IVoiceEngine.VoiceEngineOption>, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$initObserve$11
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Pair<? extends String, ? extends IVoiceEngine.VoiceEngineOption> pair) {
                invoke2((Pair<String, IVoiceEngine.VoiceEngineOption>) pair);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Pair<String, IVoiceEngine.VoiceEngineOption> it) {
                s.i(it, "it");
                if (ViewerConsultConnectLayout.f13884d.a() == ConsultConnectState.WaitConnect) {
                    ConsultConnectOrderFragment.f13757k.a();
                    ((ViewerConsultConnectLayout) ConsultViewerFragment.this.S0(R$id.consult_viewer_connect_layout)).d(ConsultConnectState.Answering);
                    ConsultViewerFragment.this.T1(true, it.getFirst(), it.getSecond());
                }
            }
        }));
        this.f13798l = new EventObserver(new Function1<Pair<? extends Boolean, ? extends ConsultConnectSuccessGrpcModel>, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$initObserve$12
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Pair<? extends Boolean, ? extends ConsultConnectSuccessGrpcModel> pair) {
                invoke2((Pair<Boolean, ConsultConnectSuccessGrpcModel>) pair);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Pair<Boolean, ConsultConnectSuccessGrpcModel> it) {
                s.i(it, "it");
                if (it.getFirst().booleanValue() && ViewerConsultConnectLayout.f13884d.a() == ConsultConnectState.Answering) {
                    ((ViewerConsultConnectLayout) ConsultViewerFragment.this.S0(R$id.consult_viewer_connect_layout)).d(ConsultConnectState.Connecting);
                    String tips = it.getSecond().getTips();
                    if (!(tips == null || tips.length() == 0)) {
                        ConsultViewerFragment.this.M1(tips);
                    }
                }
                ((ConsultVoiceChatLayout) ConsultViewerFragment.this.S0(R$id.consult_viewer_voice_chat_layout)).x(it.getSecond());
            }
        });
        LiveData<Event<Pair<Boolean, ConsultConnectSuccessGrpcModel>>> connectSuccessLiveData = D1().getConnectSuccessLiveData();
        Observer<Event<Pair<Boolean, ConsultConnectSuccessGrpcModel>>> observer2 = this.f13798l;
        s.f(observer2);
        connectSuccessLiveData.observeForever(observer2);
        this.f13799m = new EventObserver(new Function1<HangUpConnectModel, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$initObserve$13
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(HangUpConnectModel hangUpConnectModel) {
                invoke2(hangUpConnectModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull HangUpConnectModel it) {
                s.i(it, "it");
                if (it.isMe()) {
                    ConsultViewerFragment.this.E1(it);
                    ConsultViewerViewModel.Companion.d();
                    ConsultLiveHelper.f13820a.m();
                }
                ((ConsultVoiceChatLayout) ConsultViewerFragment.this.S0(R$id.consult_viewer_voice_chat_layout)).z();
            }
        });
        LiveData<Event<HangUpConnectModel>> hangUpConnectLiveData = D1().getHangUpConnectLiveData();
        Observer<Event<HangUpConnectModel>> observer3 = this.f13799m;
        s.f(observer3);
        hangUpConnectLiveData.observeForever(observer3);
        D1().getLiveEnd().observe(getViewLifecycleOwner(), new EventObserver(new Function1<ConsultLiveModel, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$initObserve$14
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ConsultLiveModel consultLiveModel) {
                invoke2(consultLiveModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ConsultLiveModel model) {
                s.i(model, "model");
                ((ConsultVoiceChatLayout) ConsultViewerFragment.this.S0(R$id.consult_viewer_voice_chat_layout)).z();
                ((ConsultViewerLiveEndLayout) ConsultViewerFragment.this.S0(R$id.consult_viewer_live_end_layout)).l(model);
                IVoiceEngine a10 = d4.b.f48611a.a();
                if (a10 != null) {
                    a10.f();
                }
                ConsultViewerFragment.this.K1(true);
                ConsultViewerFragment.this.A1().f();
            }
        }));
        D1().getCannotWatchLive().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Boolean, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$initObserve$15
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return p.f51048a;
            }

            public final void invoke(boolean z10) {
                ((ConsultViewerLiveEndLayout) ConsultViewerFragment.this.S0(R$id.consult_viewer_live_end_layout)).k();
                IVoiceEngine a10 = d4.b.f48611a.a();
                if (a10 != null) {
                    a10.f();
                }
                ConsultViewerFragment.this.K1(true);
                ConsultViewerFragment.this.A1().f();
            }
        }));
        D1().getAddCommentData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Pair<? extends Boolean, ? extends List<? extends ConsultCommentModel>>, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$initObserve$16
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Pair<? extends Boolean, ? extends List<? extends ConsultCommentModel>> pair) {
                invoke2((Pair<Boolean, ? extends List<ConsultCommentModel>>) pair);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Pair<Boolean, ? extends List<ConsultCommentModel>> it) {
                s.i(it, "it");
                ((ConsultCommentListLayout) ConsultViewerFragment.this.S0(R$id.consult_viewer_comment_list_layout)).d(it.getSecond(), it.getFirst().booleanValue());
            }
        }));
        D1().getOnlineInfoData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<ConsultOnlineInfoModel, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$initObserve$17
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ConsultOnlineInfoModel consultOnlineInfoModel) {
                invoke2(consultOnlineInfoModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ConsultOnlineInfoModel model) {
                s.i(model, "model");
                ((ConsultLiveTitleLayout) ConsultViewerFragment.this.S0(R$id.consult_viewer_title_layout)).e(model.getViewerCount());
            }
        }));
        D1().getAnchorLevel().observe(getViewLifecycleOwner(), new EventObserver(new Function1<ImageModel, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$initObserve$18
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ImageModel imageModel) {
                invoke2(imageModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable ImageModel imageModel) {
                ((ConsultVoiceChatLayout) ConsultViewerFragment.this.S0(R$id.consult_viewer_voice_chat_layout)).q(imageModel);
            }
        }));
        D1().getShowConnectOrderLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<Pair<? extends String, ? extends ConsultConnectState>, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$initObserve$19
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Pair<? extends String, ? extends ConsultConnectState> pair) {
                invoke2((Pair<String, ? extends ConsultConnectState>) pair);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Pair<String, ? extends ConsultConnectState> it) {
                s.i(it, "it");
                ConsultViewerFragment.this.L1(it.getFirst(), it.getSecond());
            }
        }));
        D1().getShowRechargeLiveData().observe(getViewLifecycleOwner(), new EventObserver(new Function1<ShowDiamondBalanceModel, p>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$initObserve$20
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ShowDiamondBalanceModel showDiamondBalanceModel) {
                invoke2(showDiamondBalanceModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ShowDiamondBalanceModel it) {
                s.i(it, "it");
                ConsultViewerFragment.this.O1(it);
            }
        }));
    }

    public final void G1() {
        Context context = getContext();
        if (context != null) {
            ConsultLiveTitleLayout consult_viewer_title_layout = (ConsultLiveTitleLayout) S0(R$id.consult_viewer_title_layout);
            s.h(consult_viewer_title_layout, "consult_viewer_title_layout");
            com.cupidapp.live.base.view.s.b(context, consult_viewer_title_layout);
        }
        ((ConsultVoiceChatLayout) S0(R$id.consult_viewer_voice_chat_layout)).setCurrentPagePosition(O0());
        ((ConsultCommentListLayout) S0(R$id.consult_viewer_comment_list_layout)).setCurrentPagePosition(O0());
    }

    public final void H1(boolean z10, ConsultLiveModel consultLiveModel, HangUpConnectModel hangUpConnectModel) {
        ViewerConsultConnectLayout.a aVar = ViewerConsultConnectLayout.f13884d;
        ConsultConnectState a10 = aVar.a();
        if (z10 && a10 == ConsultConnectState.Connecting) {
            ConsultViewerViewModel.Companion companion = ConsultViewerViewModel.Companion;
            String b4 = companion.b();
            ConsultConnectUserModel connectingUserInfo = consultLiveModel.getConnectingUserInfo();
            if (!(b4 == null || b4.length() == 0)) {
                if (!s.d(b4, connectingUserInfo != null ? connectingUserInfo.getRequestId() : null)) {
                    E1(hangUpConnectModel);
                    companion.d();
                    ConsultLiveHelper.f13820a.m();
                }
            }
        }
        ((ConsultLiveTitleLayout) S0(R$id.consult_viewer_title_layout)).e(consultLiveModel.getViewerCount());
        ViewerConsultConnectLayout viewerConsultConnectLayout = (ViewerConsultConnectLayout) S0(R$id.consult_viewer_connect_layout);
        Integer waitCount = consultLiveModel.getWaitCount();
        viewerConsultConnectLayout.e(waitCount != null ? waitCount.intValue() : 0);
        if (aVar.b()) {
            return;
        }
        ((ConsultVoiceChatLayout) S0(R$id.consult_viewer_voice_chat_layout)).w(consultLiveModel);
    }

    public final void I1(ConsultConnectBtn consultConnectBtn) {
        User user;
        ConsultLiveModel consultLiveModel = D1().getConsultLiveModel();
        z3.a aVar = z3.a.f54827a;
        String str = null;
        String id2 = consultLiveModel != null ? consultLiveModel.getId() : null;
        if (consultLiveModel != null && (user = consultLiveModel.getUser()) != null) {
            str = user.userId();
        }
        aVar.a(id2, str, consultConnectBtn);
    }

    public final void J1(@NotNull ConsultViewerActivity.Config config) {
        s.i(config, "config");
        this.f13793g = config;
    }

    public final void K1(boolean z10) {
        FragmentActivity activity = getActivity();
        ConsultViewerActivity consultViewerActivity = activity instanceof ConsultViewerActivity ? (ConsultViewerActivity) activity : null;
        if (consultViewerActivity != null) {
            consultViewerActivity.w1(z10);
        }
    }

    public final void L1(String str, ConsultConnectState consultConnectState) {
        ConsultConnectOrderFragment.f13757k.d(getChildFragmentManager(), true, str, consultConnectState, new d());
    }

    public final void M1(String str) {
        FKAlertDialog fKAlertDialog = this.f13800n;
        if (fKAlertDialog != null) {
            fKAlertDialog.g();
        }
        FKAlertDialog u10 = FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, getContext(), false, 2, null).n(str).k(true), R$string.all_right, null, null, 6, null).u(new Function0<p>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$showConnectPromptDialog$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:3:0x0010, code lost:
            
                r0 = r2.this$0.f13800n;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2() {
                /*
                    r2 = this;
                    com.cupidapp.live.consult.fragment.ConsultViewerFragment r0 = com.cupidapp.live.consult.fragment.ConsultViewerFragment.this
                    int r1 = com.cupidapp.live.R$id.consult_viewer_live_end_layout
                    android.view.View r0 = r0.S0(r1)
                    com.cupidapp.live.consult.view.ConsultViewerLiveEndLayout r0 = (com.cupidapp.live.consult.view.ConsultViewerLiveEndLayout) r0
                    int r0 = r0.getVisibility()
                    if (r0 != 0) goto L1b
                    com.cupidapp.live.consult.fragment.ConsultViewerFragment r0 = com.cupidapp.live.consult.fragment.ConsultViewerFragment.this
                    com.cupidapp.live.base.view.dialog.FKAlertDialog r0 = com.cupidapp.live.consult.fragment.ConsultViewerFragment.c1(r0)
                    if (r0 == 0) goto L1b
                    r0.g()
                L1b:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.consult.fragment.ConsultViewerFragment$showConnectPromptDialog$1.invoke2():void");
            }
        });
        this.f13800n = u10;
        if (u10 != null) {
            FKAlertDialog.G(u10, null, 1, null);
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f13802p.clear();
    }

    public final void N1(final Integer num, Integer num2, final User user) {
        A1().c(getContext(), num2, new Function0<p>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$showConsultRoomGuideDialog$1
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
                FragmentActivity activity = ConsultViewerFragment.this.getActivity();
                if ((activity != null && activity.isFinishing()) || com.cupidapp.live.base.fragment.b.f11807a.c()) {
                    return;
                }
                ConsultRoomGuideHelper A1 = ConsultViewerFragment.this.A1();
                Context context = ConsultViewerFragment.this.getContext();
                User user2 = user;
                Integer num3 = num;
                final ConsultViewerFragment consultViewerFragment = ConsultViewerFragment.this;
                A1.e(context, user2, num3, new Function0<p>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$showConsultRoomGuideDialog$1.1
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
                        ConsultViewerFragment.this.P1();
                    }
                });
            }
        });
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    @NotNull
    public SensorPosition O0() {
        return SensorPosition.CONSULT_ROOM;
    }

    public final void O1(ShowDiamondBalanceModel showDiamondBalanceModel) {
        DiamondBalanceFragment.f15433o.c(getChildFragmentManager(), showDiamondBalanceModel.getBalance(), null, showDiamondBalanceModel.getRoomId(), SensorPosition.CONSULT_ROOM, showDiamondBalanceModel.getTips(), showDiamondBalanceModel.getCloseShowRequest() ? new e() : null);
    }

    public final void P1() {
        D1().showRequestConnect();
        i.g(i.f50236a, PopupName.CONSULT_CONNECT_TO_ANCHOR, null, null, 6, null);
    }

    public final void Q1(String str) {
        ConsultRequestConnectFragment.f13777k.a(getChildFragmentManager(), str, new f());
    }

    public final void R1() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Nullable
    public View S0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f13802p;
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

    public final void S1() {
        D1().callVoiceRoomLeaveApi();
        IVoiceEngine a10 = d4.b.f48611a.a();
        if (a10 != null) {
            a10.f();
        }
    }

    public final void T1(boolean z10, String str, IVoiceEngine.VoiceEngineOption voiceEngineOption) {
        IVoiceEngine a10;
        if (voiceEngineOption == null) {
            return;
        }
        if (s.d(str, ConsultConnectType.NORMAL.getValue())) {
            IVoiceEngine a11 = d4.b.f48611a.a();
            if (a11 != null) {
                a11.o(z10, voiceEngineOption.a());
                return;
            }
            return;
        }
        if (!s.d(str, ConsultConnectType.ONE_ON_ONE.getValue()) || (a10 = d4.b.f48611a.a()) == null) {
            return;
        }
        a10.f();
        a10.n(voiceEngineOption);
        a10.d();
    }

    public final void U1() {
        Context context = getContext();
        ConsultLiveModel consultLiveModel = D1().getConsultLiveModel();
        if (context != null && consultLiveModel != null) {
            ConsultFloatWindowHelper.f13810b.r(context, consultLiveModel, new g());
        } else {
            w1();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        super.onActivityResult(i10, i11, intent);
        Context context = getContext();
        if (i10 != 231031 || context == null) {
            return;
        }
        if (ConsultFloatWindowHelper.f13810b.g(context)) {
            w1();
        } else {
            U1();
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public boolean onBackPressed() {
        if (((ConsultViewerLiveEndLayout) S0(R$id.consult_viewer_live_end_layout)).getVisibility() == 0) {
            w1();
            return true;
        }
        if (ViewerConsultConnectLayout.f13884d.b()) {
            FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, getContext(), false, 2, null), R$string.connecting_state_exit_tip, 0, 2, null).k(true).q(R$string.still_exit, new Function0<p>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$onBackPressed$1
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
                    ConsultViewerFragment.this.w1();
                }
            }), 2131886363, null, null, 6, null), null, 1, null);
            return true;
        }
        U1();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_consult_viewer, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        C1().h();
        Observer<Event<ConsultApplyConnectGrpcModel>> observer = this.f13797k;
        if (observer != null) {
            D1().getApplyConnectPromptLiveData().removeObserver(observer);
        }
        Observer<Event<Pair<Boolean, ConsultConnectSuccessGrpcModel>>> observer2 = this.f13798l;
        if (observer2 != null) {
            D1().getConnectSuccessLiveData().removeObserver(observer2);
        }
        Observer<Event<HangUpConnectModel>> observer3 = this.f13799m;
        if (observer3 != null) {
            D1().getHangUpConnectLiveData().removeObserver(observer3);
        }
        B1().a();
        A1().b();
        N0();
    }

    @j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull UserProfileDataChangeEvent event) {
        s.i(event, "event");
        EventBus.c().r(event);
        ((ConsultVoiceChatLayout) S0(R$id.consult_viewer_voice_chat_layout)).r(event.getUser());
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f13796j = false;
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f13796j = true;
        if (this.f13791e) {
            this.f13791e = false;
            ConsultViewerActivity.Config config = this.f13793g;
            if (config == null) {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.finish();
                    return;
                }
                return;
            }
            F1();
            t1();
            ((ConstraintLayout) S0(R$id.consult_viewer_root_layout)).setBackgroundResource(ConsultLiveHelper.f13820a.e(config.getCategory()));
            D1().initLiveInfoData(config);
            D1().callVoiceRoomViewerApi();
            GrpcMessageRouter.INSTANCE.notifyGrpc(true, config.getRoomId(), Boolean.TRUE);
            return;
        }
        if (((ConsultViewerLiveEndLayout) S0(R$id.consult_viewer_live_end_layout)).getVisibility() != 0) {
            D1().refreshConsultRoomInfo(false);
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        G1();
    }

    public final void s1() {
        ConsultViewerActivity.Config config = this.f13793g;
        ConsultApplyConnectGrpcModel connectModel = config != null ? config.getConnectModel() : null;
        if (connectModel != null) {
            B1().b();
            K1(false);
            D1().applyConnect(connectModel.getVoiceConnectType(), connectModel.getNewRoomId(), connectModel.getPrivateMapKey());
        }
    }

    public final void t1() {
        ((ConsultLiveTitleLayout) S0(R$id.consult_viewer_title_layout)).b(new Function0<p>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$bindClickEvent$1
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
                FragmentActivity activity = ConsultViewerFragment.this.getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                }
            }
        });
        ((ViewerConsultConnectLayout) S0(R$id.consult_viewer_connect_layout)).setListener(new b());
        ((ConsultViewerLiveEndLayout) S0(R$id.consult_viewer_live_end_layout)).i(new Function0<p>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$bindClickEvent$3
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
                FragmentActivity activity = ConsultViewerFragment.this.getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                }
            }
        });
        ((ConsultVoiceChatLayout) S0(R$id.consult_viewer_voice_chat_layout)).setChargeCallback(new Function0<p>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$bindClickEvent$4
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
                ConsultViewerFragment.this.D1().connectCharge();
            }
        });
    }

    public final void u1() {
        IVoiceEngine a10 = d4.b.f48611a.a();
        if (a10 != null) {
            a10.m(new c());
        }
    }

    public final void v1(ConsultLiveModel consultLiveModel) {
        ConsultViewerViewModel.Companion companion = ConsultViewerViewModel.Companion;
        String b4 = companion.b();
        if (b4 == null || b4.length() == 0) {
            String requestId = consultLiveModel.getRequestId();
            if (requestId == null || requestId.length() == 0) {
                return;
            }
            companion.f(requestId);
            companion.g(consultLiveModel.getVoiceConnectType());
            ConsultConnectUserModel connectingUserInfo = consultLiveModel.getConnectingUserInfo();
            if (s.d(requestId, connectingUserInfo != null ? connectingUserInfo.getRequestId() : null)) {
                D1().hangUp();
                return;
            } else {
                D1().cancelRequest();
                return;
            }
        }
        ((ViewerConsultConnectLayout) S0(R$id.consult_viewer_connect_layout)).d(ConsultConnectState.WaitConnect);
    }

    public final void w1() {
        D1().callVoiceRoomLeaveApi();
        IVoiceEngine a10 = d4.b.f48611a.a();
        if (a10 != null) {
            a10.e();
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public final void x1(ConsultLiveModel consultLiveModel) {
        ((ConsultLiveTitleLayout) S0(R$id.consult_viewer_title_layout)).d(consultLiveModel);
        ((ConsultVoiceChatLayout) S0(R$id.consult_viewer_voice_chat_layout)).w(consultLiveModel);
        ((ConsultBottomMenuLayout) S0(R$id.consult_viewer_bottom_menu_layout)).d(consultLiveModel);
        int i10 = R$id.consult_viewer_connect_layout;
        ((ViewerConsultConnectLayout) S0(i10)).setVisibility(0);
        ViewerConsultConnectLayout viewerConsultConnectLayout = (ViewerConsultConnectLayout) S0(i10);
        Integer waitCount = consultLiveModel.getWaitCount();
        viewerConsultConnectLayout.e(waitCount != null ? waitCount.intValue() : 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void y1(boolean r12, com.cupidapp.live.consult.model.ConsultLiveModel r13) {
        /*
            r11 = this;
            com.cupidapp.live.consult.activity.ConsultViewerActivity$Config r0 = r11.f13793g
            r1 = 0
            if (r0 == 0) goto La
            java.lang.String r0 = r0.getSource()
            goto Lb
        La:
            r0 = r1
        Lb:
            com.cupidapp.live.track.group.EnterConsultRoomSource r2 = com.cupidapp.live.track.group.EnterConsultRoomSource.ConsultWindow
            java.lang.String r2 = r2.getSource()
            boolean r0 = kotlin.jvm.internal.s.d(r0, r2)
            if (r0 == 0) goto L18
            return
        L18:
            if (r12 == 0) goto L1e
            com.cupidapp.live.track.group.ConsultConnectStatus r12 = com.cupidapp.live.track.group.ConsultConnectStatus.Block
        L1c:
            r9 = r12
            goto L50
        L1e:
            if (r13 == 0) goto L2b
            java.lang.Boolean r12 = r13.getEnded()
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            boolean r12 = kotlin.jvm.internal.s.d(r12, r0)
            goto L2c
        L2b:
            r12 = 0
        L2c:
            if (r12 == 0) goto L31
            com.cupidapp.live.track.group.ConsultConnectStatus r12 = com.cupidapp.live.track.group.ConsultConnectStatus.Finish
            goto L1c
        L31:
            if (r13 == 0) goto L38
            com.cupidapp.live.consult.model.ConsultConnectUserModel r12 = r13.getConnectingUserInfo()
            goto L39
        L38:
            r12 = r1
        L39:
            if (r12 == 0) goto L4d
            java.lang.Boolean r12 = r13.getSuspend()
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            boolean r12 = kotlin.jvm.internal.s.d(r12, r0)
            if (r12 == 0) goto L4a
            com.cupidapp.live.track.group.ConsultConnectStatus r12 = com.cupidapp.live.track.group.ConsultConnectStatus.Hang
            goto L1c
        L4a:
            com.cupidapp.live.track.group.ConsultConnectStatus r12 = com.cupidapp.live.track.group.ConsultConnectStatus.Connect
            goto L1c
        L4d:
            com.cupidapp.live.track.group.ConsultConnectStatus r12 = com.cupidapp.live.track.group.ConsultConnectStatus.NonConnect
            goto L1c
        L50:
            z3.a r2 = z3.a.f54827a
            if (r13 == 0) goto L5d
            java.lang.String r12 = r13.getId()
            if (r12 != 0) goto L5b
            goto L5d
        L5b:
            r3 = r12
            goto L67
        L5d:
            com.cupidapp.live.consult.activity.ConsultViewerActivity$Config r12 = r11.f13793g
            if (r12 == 0) goto L66
            java.lang.String r12 = r12.getRoomId()
            goto L5b
        L66:
            r3 = r1
        L67:
            if (r13 == 0) goto L75
            com.cupidapp.live.profile.model.User r12 = r13.getUser()
            if (r12 == 0) goto L75
            java.lang.String r12 = r12.userId()
            r4 = r12
            goto L76
        L75:
            r4 = r1
        L76:
            com.cupidapp.live.consult.activity.ConsultViewerActivity$Config r12 = r11.f13793g
            if (r12 == 0) goto L80
            java.lang.String r12 = r12.getFrom()
            r5 = r12
            goto L81
        L80:
            r5 = r1
        L81:
            com.cupidapp.live.consult.activity.ConsultViewerActivity$Config r12 = r11.f13793g
            if (r12 == 0) goto L8b
            java.lang.String r12 = r12.getSource()
            r6 = r12
            goto L8c
        L8b:
            r6 = r1
        L8c:
            if (r13 == 0) goto L9e
            com.cupidapp.live.profile.model.User r12 = r13.getUser()
            if (r12 == 0) goto L9e
            boolean r12 = r12.getAloha()
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)
            r7 = r12
            goto L9f
        L9e:
            r7 = r1
        L9f:
            if (r13 == 0) goto La7
            java.lang.Integer r12 = r13.getViewerRealCount()
            r8 = r12
            goto La8
        La7:
            r8 = r1
        La8:
            if (r13 == 0) goto Lb3
            java.lang.String r12 = r13.getCategory()
            if (r12 != 0) goto Lb1
            goto Lb3
        Lb1:
            r10 = r12
            goto Lbc
        Lb3:
            com.cupidapp.live.consult.activity.ConsultViewerActivity$Config r12 = r11.f13793g
            if (r12 == 0) goto Lbb
            java.lang.String r1 = r12.getCategory()
        Lbb:
            r10 = r1
        Lbc:
            r2.g(r3, r4, r5, r6, r7, r8, r9, r10)
            com.cupidapp.live.consult.viewmodel.ConsultViewerViewModel$Companion r12 = com.cupidapp.live.consult.viewmodel.ConsultViewerViewModel.Companion
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Long r13 = java.lang.Long.valueOf(r0)
            r12.e(r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.consult.fragment.ConsultViewerFragment.y1(boolean, com.cupidapp.live.consult.model.ConsultLiveModel):void");
    }

    public final void z1(IVoiceEngine.VoiceEngineOption voiceEngineOption) {
        IVoiceEngine a10 = d4.b.f48611a.a();
        if (a10 != null) {
            String g3 = a10.g();
            if ((g3 == null || g3.length() == 0) || !s.d(g3, voiceEngineOption.b())) {
                a10.n(voiceEngineOption);
                a10.d();
            }
        }
    }

    @j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull GrpcConnectEvent event) {
        s.i(event, "event");
        ((ConsultVoiceChatLayout) S0(R$id.consult_viewer_voice_chat_layout)).v(event.getConnect());
    }
}
