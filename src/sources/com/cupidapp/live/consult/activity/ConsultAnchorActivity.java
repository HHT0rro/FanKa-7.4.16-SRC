package com.cupidapp.live.consult.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.grpc.GrpcMessageRouter;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.consult.fragment.ConsultConnectOrderFragment;
import com.cupidapp.live.consult.helper.ConsultLiveHelper;
import com.cupidapp.live.consult.model.ConsultAnchorCloseLiveResult;
import com.cupidapp.live.consult.model.ConsultAnchorTaskModel;
import com.cupidapp.live.consult.model.ConsultCommentModel;
import com.cupidapp.live.consult.model.ConsultConnectState;
import com.cupidapp.live.consult.model.ConsultConnectSuccessGrpcModel;
import com.cupidapp.live.consult.model.ConsultConnectType;
import com.cupidapp.live.consult.model.ConsultLiveModel;
import com.cupidapp.live.consult.model.ConsultOnlineInfoModel;
import com.cupidapp.live.consult.view.AnchorConsultConnectLayout;
import com.cupidapp.live.consult.view.ConsultAnchorLiveEndLayout;
import com.cupidapp.live.consult.view.ConsultAnchorTaskLayout;
import com.cupidapp.live.consult.view.ConsultBottomMenuLayout;
import com.cupidapp.live.consult.view.ConsultCommentListLayout;
import com.cupidapp.live.consult.view.ConsultLiveTitleLayout;
import com.cupidapp.live.consult.view.ConsultVoiceChatLayout;
import com.cupidapp.live.consult.viewmodel.ConsultAnchorViewModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.ConsultConnectBtn;
import com.cupidapp.live.voiceparty.engine.IVoiceEngine;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.g;

/* compiled from: ConsultAnchorActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultAnchorActivity extends BaseConsultActivity {

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public static final a f13716v = new a(null);

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final Lazy f13717s;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13719u = new LinkedHashMap();

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public final Lazy f13718t = kotlin.c.b(new Function0<Boolean>() { // from class: com.cupidapp.live.consult.activity.ConsultAnchorActivity$suspend$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Boolean invoke() {
            return Boolean.valueOf(ConsultAnchorActivity.this.getIntent().getBooleanExtra("CONSULT_SUSPEND", false));
        }
    });

    /* compiled from: ConsultAnchorActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(a aVar, Context context, ConsultLiveModel consultLiveModel, boolean z10, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                z10 = false;
            }
            aVar.a(context, consultLiveModel, z10);
        }

        public final void a(@Nullable Context context, @NotNull ConsultLiveModel model, boolean z10) {
            s.i(model, "model");
            if (context == null) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) ConsultAnchorActivity.class);
            g.c(intent, model);
            intent.putExtra("CONSULT_SUSPEND", z10);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    /* compiled from: ConsultAnchorActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements IVoiceEngine.a {
        public b() {
        }

        @Override // com.cupidapp.live.voiceparty.engine.IVoiceEngine.a
        public void a(@NotNull IVoiceEngine.NetworkStateLevel localLevel, @NotNull IVoiceEngine.NetworkStateLevel remoteLevel) {
            s.i(localLevel, "localLevel");
            s.i(remoteLevel, "remoteLevel");
            ConsultLiveTitleLayout consultLiveTitleLayout = (ConsultLiveTitleLayout) ConsultAnchorActivity.this.m1(R$id.consult_anchor_title_layout);
            if (consultLiveTitleLayout != null) {
                consultLiveTitleLayout.c(localLevel, remoteLevel);
            }
        }

        @Override // com.cupidapp.live.voiceparty.engine.IVoiceEngine.a
        public void b() {
            IVoiceEngine.a.C0175a.c(this);
        }

        @Override // com.cupidapp.live.voiceparty.engine.IVoiceEngine.a
        public void c(long j10) {
            ConsultAnchorActivity.this.w1().enterRoomSuccess(ConsultAnchorActivity.this.x1());
        }

        @Override // com.cupidapp.live.voiceparty.engine.IVoiceEngine.a
        public void d() {
            IVoiceEngine.a.C0175a.a(this);
        }

        @Override // com.cupidapp.live.voiceparty.engine.IVoiceEngine.a
        public void e(@NotNull Map<String, Integer> userVolumes) {
            s.i(userVolumes, "userVolumes");
            ConsultVoiceChatLayout consultVoiceChatLayout = (ConsultVoiceChatLayout) ConsultAnchorActivity.this.m1(R$id.consult_anchor_voice_chat_layout);
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

    /* compiled from: ConsultAnchorActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements com.cupidapp.live.consult.view.a {
        public c() {
        }

        @Override // com.cupidapp.live.consult.view.a
        public void b() {
            ConsultAnchorActivity.this.w1().hangUp();
            ConsultAnchorActivity.this.A1(ConsultConnectBtn.HangUp);
        }

        @Override // com.cupidapp.live.consult.view.a
        public void c() {
            ConsultAnchorActivity.this.w1().showConnectOrder();
        }

        @Override // com.cupidapp.live.consult.view.a
        public void d() {
            ConsultAnchorActivity.this.w1().agreeConnect();
            ConsultAnchorActivity.this.A1(ConsultConnectBtn.Answer);
        }

        @Override // com.cupidapp.live.consult.view.a
        public void e() {
            ConsultAnchorActivity.this.w1().refuseConnect();
            ConsultAnchorActivity.this.A1(ConsultConnectBtn.Refuse);
        }
    }

    public ConsultAnchorActivity() {
        final Function0 function0 = null;
        this.f13717s = new ViewModelLazy(v.b(ConsultAnchorViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.consult.activity.ConsultAnchorActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
                s.h(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.consult.activity.ConsultAnchorActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = ComponentActivity.this.getDefaultViewModelProviderFactory();
                s.h(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.consult.activity.ConsultAnchorActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = Function0.this;
                if (function02 != null && (creationExtras = (CreationExtras) function02.invoke()) != null) {
                    return creationExtras;
                }
                CreationExtras defaultViewModelCreationExtras = this.getDefaultViewModelCreationExtras();
                s.h(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        });
    }

    public final void A1(ConsultConnectBtn consultConnectBtn) {
        User user;
        ConsultLiveModel consultLiveModel = w1().getConsultLiveModel();
        z3.a aVar = z3.a.f54827a;
        String str = null;
        String id2 = consultLiveModel != null ? consultLiveModel.getId() : null;
        if (consultLiveModel != null && (user = consultLiveModel.getUser()) != null) {
            str = user.userId();
        }
        aVar.a(id2, str, consultConnectBtn);
    }

    public final void B1(IVoiceEngine.VoiceEngineOption voiceEngineOption) {
        IVoiceEngine a10;
        if (voiceEngineOption == null || (a10 = d4.b.f48611a.a()) == null) {
            return;
        }
        a10.f();
        a10.n(voiceEngineOption);
        a10.d();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.CONSULT_ROOM;
    }

    @Nullable
    public View m1(int i10) {
        Map<Integer, View> map = this.f13719u;
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

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (((ConsultAnchorLiveEndLayout) m1(R$id.consult_anchor_live_end_layout)).getVisibility() == 0) {
            super.onBackPressed();
        } else {
            FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, this, false, 2, null), R$string.stop_live_and_clear_connect, 0, 2, null).k(true).q(2131886528, new Function0<p>() { // from class: com.cupidapp.live.consult.activity.ConsultAnchorActivity$onBackPressed$1
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
                    ConsultAnchorActivity.this.w1().callVoiceRoomCloseApi();
                }
            }), 2131886363, null, null, 6, null), null, 1, null);
        }
    }

    @Override // com.cupidapp.live.consult.activity.BaseConsultActivity, com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_consult_anchor);
        Intent intent = getIntent();
        s.h(intent, "intent");
        ConsultLiveModel consultLiveModel = (ConsultLiveModel) g.a(intent, ConsultLiveModel.class);
        if (consultLiveModel == null) {
            finish();
            return;
        }
        GrpcMessageRouter.INSTANCE.notifyGrpc(true, consultLiveModel.getId(), Boolean.FALSE);
        ((ConstraintLayout) m1(R$id.consult_anchor_root_layout)).setBackgroundResource(ConsultLiveHelper.f13820a.e(consultLiveModel.getCategory()));
        IVoiceEngine a10 = d4.b.f48611a.a();
        if (a10 != null) {
            a10.a();
        }
        w1().initConsultLiveModel(consultLiveModel);
        z1();
        y1();
        s1();
        u1(consultLiveModel);
        t1(consultLiveModel);
        if (x1()) {
            w1().switchConnect();
        }
    }

    @Override // com.cupidapp.live.consult.activity.BaseConsultActivity, com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        v1();
    }

    public final void s1() {
        ((ConsultLiveTitleLayout) m1(R$id.consult_anchor_title_layout)).b(new Function0<p>() { // from class: com.cupidapp.live.consult.activity.ConsultAnchorActivity$bindClickEvent$1
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
                ConsultAnchorActivity.this.onBackPressed();
            }
        });
        IVoiceEngine a10 = d4.b.f48611a.a();
        if (a10 != null) {
            a10.m(new b());
        }
        ((AnchorConsultConnectLayout) m1(R$id.consult_anchor_connect_layout)).setListener(new c());
        ((ConsultAnchorLiveEndLayout) m1(R$id.consult_anchor_live_end_layout)).b(new Function0<p>() { // from class: com.cupidapp.live.consult.activity.ConsultAnchorActivity$bindClickEvent$4
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
                ConsultAnchorActivity.this.onBackPressed();
            }
        });
        ((ConsultAnchorTaskLayout) m1(R$id.consult_anchor_task_layout)).setClickCallback(new Function1<String, p>() { // from class: com.cupidapp.live.consult.activity.ConsultAnchorActivity$bindClickEvent$5
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
                ConsultAnchorActivity.this.l1(it);
            }
        });
    }

    public final void t1(ConsultLiveModel consultLiveModel) {
        ((ConsultLiveTitleLayout) m1(R$id.consult_anchor_title_layout)).d(consultLiveModel);
        ((ConsultVoiceChatLayout) m1(R$id.consult_anchor_voice_chat_layout)).w(consultLiveModel);
        ((ConsultBottomMenuLayout) m1(R$id.consult_anchor_bottom_menu_layout)).d(consultLiveModel);
        AnchorConsultConnectLayout anchorConsultConnectLayout = (AnchorConsultConnectLayout) m1(R$id.consult_anchor_connect_layout);
        Integer waitCount = consultLiveModel.getWaitCount();
        anchorConsultConnectLayout.g(waitCount != null ? waitCount.intValue() : 0);
    }

    public final void u1(ConsultLiveModel consultLiveModel) {
        IVoiceEngine a10 = d4.b.f48611a.a();
        if (a10 != null) {
            a10.n(new IVoiceEngine.VoiceEngineOption(consultLiveModel.getId(), consultLiveModel.getAId(), consultLiveModel.getUserSig(), consultLiveModel.getPrivateMapKey(), true));
            a10.d();
        }
    }

    public final void v1() {
        IVoiceEngine a10 = d4.b.f48611a.a();
        if (a10 != null) {
            a10.e();
        }
        GrpcMessageRouter.notifyGrpc$default(GrpcMessageRouter.INSTANCE, false, null, null, 6, null);
    }

    public final ConsultAnchorViewModel w1() {
        return (ConsultAnchorViewModel) this.f13717s.getValue();
    }

    public final boolean x1() {
        return ((Boolean) this.f13718t.getValue()).booleanValue();
    }

    public final void y1() {
        w1().getAnchorTask().observe(this, new EventObserver(new Function1<ConsultAnchorTaskModel, p>() { // from class: com.cupidapp.live.consult.activity.ConsultAnchorActivity$initObserve$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ConsultAnchorTaskModel consultAnchorTaskModel) {
                invoke2(consultAnchorTaskModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable ConsultAnchorTaskModel consultAnchorTaskModel) {
                ((ConsultAnchorTaskLayout) ConsultAnchorActivity.this.m1(R$id.consult_anchor_task_layout)).c(consultAnchorTaskModel);
            }
        }));
        w1().getLiveEnd().observe(this, new EventObserver(new Function1<ConsultAnchorCloseLiveResult, p>() { // from class: com.cupidapp.live.consult.activity.ConsultAnchorActivity$initObserve$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ConsultAnchorCloseLiveResult consultAnchorCloseLiveResult) {
                invoke2(consultAnchorCloseLiveResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ConsultAnchorCloseLiveResult model) {
                s.i(model, "model");
                h.f12779a.m(ConsultAnchorActivity.this, model.getTips());
                ((ConsultAnchorLiveEndLayout) ConsultAnchorActivity.this.m1(R$id.consult_anchor_live_end_layout)).c(model.getSummary());
                ((ConsultVoiceChatLayout) ConsultAnchorActivity.this.m1(R$id.consult_anchor_voice_chat_layout)).z();
                ConsultAnchorActivity.this.v1();
            }
        }));
        w1().getConnectCountChangeLiveData().observe(this, new EventObserver(new Function1<Integer, p>() { // from class: com.cupidapp.live.consult.activity.ConsultAnchorActivity$initObserve$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Integer num) {
                invoke(num.intValue());
                return p.f51048a;
            }

            public final void invoke(int i10) {
                ((AnchorConsultConnectLayout) ConsultAnchorActivity.this.m1(R$id.consult_anchor_connect_layout)).g(i10);
                ConsultConnectOrderFragment.f13757k.c();
            }
        }));
        w1().getSwitchConnectLiveData().observe(this, new EventObserver(new Function1<Pair<? extends String, ? extends User>, p>() { // from class: com.cupidapp.live.consult.activity.ConsultAnchorActivity$initObserve$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Pair<? extends String, ? extends User> pair) {
                invoke2((Pair<String, User>) pair);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Pair<String, User> it) {
                s.i(it, "it");
                String first = it.getFirst();
                User second = it.getSecond();
                if (first != null && second != null) {
                    AnchorConsultConnectLayout anchorConsultConnectLayout = (AnchorConsultConnectLayout) ConsultAnchorActivity.this.m1(R$id.consult_anchor_connect_layout);
                    anchorConsultConnectLayout.e(second, first);
                    anchorConsultConnectLayout.d(ConsultConnectState.WaitConnect);
                    n1.a.f52091a.a(ConsultAnchorActivity.this, 100L);
                    return;
                }
                ((AnchorConsultConnectLayout) ConsultAnchorActivity.this.m1(R$id.consult_anchor_connect_layout)).d(ConsultConnectState.FreeState);
            }
        }));
        w1().getApplyConnectLiveData().observe(this, new EventObserver(new Function1<Boolean, p>() { // from class: com.cupidapp.live.consult.activity.ConsultAnchorActivity$initObserve$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return p.f51048a;
            }

            public final void invoke(boolean z10) {
                ((AnchorConsultConnectLayout) ConsultAnchorActivity.this.m1(R$id.consult_anchor_connect_layout)).d(ConsultConnectState.Answering);
            }
        }));
        w1().getSwitchRoomLiveData().observe(this, new EventObserver(new Function1<IVoiceEngine.VoiceEngineOption, p>() { // from class: com.cupidapp.live.consult.activity.ConsultAnchorActivity$initObserve$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(IVoiceEngine.VoiceEngineOption voiceEngineOption) {
                invoke2(voiceEngineOption);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable IVoiceEngine.VoiceEngineOption voiceEngineOption) {
                ConsultAnchorActivity.this.B1(voiceEngineOption);
            }
        }));
        w1().getConnectSuccessLiveData().observe(this, new EventObserver(new Function1<ConsultConnectSuccessGrpcModel, p>() { // from class: com.cupidapp.live.consult.activity.ConsultAnchorActivity$initObserve$7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(ConsultConnectSuccessGrpcModel consultConnectSuccessGrpcModel) {
                invoke2(consultConnectSuccessGrpcModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ConsultConnectSuccessGrpcModel it) {
                s.i(it, "it");
                ((AnchorConsultConnectLayout) ConsultAnchorActivity.this.m1(R$id.consult_anchor_connect_layout)).d(ConsultConnectState.Connecting);
                ((ConsultVoiceChatLayout) ConsultAnchorActivity.this.m1(R$id.consult_anchor_voice_chat_layout)).x(it);
            }
        }));
        w1().getHangUpConnectLiveData().observe(this, new EventObserver(new Function1<Triple<? extends String, ? extends String, ? extends IVoiceEngine.VoiceEngineOption>, p>() { // from class: com.cupidapp.live.consult.activity.ConsultAnchorActivity$initObserve$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Triple<? extends String, ? extends String, ? extends IVoiceEngine.VoiceEngineOption> triple) {
                invoke2((Triple<String, String, IVoiceEngine.VoiceEngineOption>) triple);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Triple<String, String, IVoiceEngine.VoiceEngineOption> it) {
                s.i(it, "it");
                h.f12779a.m(ConsultAnchorActivity.this, it.getSecond());
                ((AnchorConsultConnectLayout) ConsultAnchorActivity.this.m1(R$id.consult_anchor_connect_layout)).d(ConsultConnectState.FreeState);
                if (s.d(it.getFirst(), ConsultConnectType.ONE_ON_ONE.getValue()) && it.getThird() != null) {
                    ConsultAnchorActivity consultAnchorActivity = ConsultAnchorActivity.this;
                    IVoiceEngine.VoiceEngineOption third = it.getThird();
                    s.f(third);
                    consultAnchorActivity.B1(third);
                }
                ((ConsultVoiceChatLayout) ConsultAnchorActivity.this.m1(R$id.consult_anchor_voice_chat_layout)).z();
                ConsultAnchorActivity.this.w1().switchConnect();
            }
        }));
        w1().getAddCommentData().observe(this, new EventObserver(new Function1<List<? extends ConsultCommentModel>, p>() { // from class: com.cupidapp.live.consult.activity.ConsultAnchorActivity$initObserve$9
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(List<? extends ConsultCommentModel> list) {
                invoke2((List<ConsultCommentModel>) list);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<ConsultCommentModel> list) {
                s.i(list, "list");
                ConsultCommentListLayout consult_anchor_comment_list_layout = (ConsultCommentListLayout) ConsultAnchorActivity.this.m1(R$id.consult_anchor_comment_list_layout);
                s.h(consult_anchor_comment_list_layout, "consult_anchor_comment_list_layout");
                ConsultCommentListLayout.e(consult_anchor_comment_list_layout, list, false, 2, null);
            }
        }));
        w1().getOnlineInfoData().observe(this, new EventObserver(new Function1<ConsultOnlineInfoModel, p>() { // from class: com.cupidapp.live.consult.activity.ConsultAnchorActivity$initObserve$10
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
                ((ConsultLiveTitleLayout) ConsultAnchorActivity.this.m1(R$id.consult_anchor_title_layout)).e(model.getViewerCount());
            }
        }));
        w1().getAnchorLevel().observe(this, new EventObserver(new Function1<ImageModel, p>() { // from class: com.cupidapp.live.consult.activity.ConsultAnchorActivity$initObserve$11
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
                ((ConsultVoiceChatLayout) ConsultAnchorActivity.this.m1(R$id.consult_anchor_voice_chat_layout)).q(imageModel);
            }
        }));
        w1().getShowConnectOrderLiveData().observe(this, new EventObserver(new Function1<String, p>() { // from class: com.cupidapp.live.consult.activity.ConsultAnchorActivity$initObserve$12
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
                ConsultConnectOrderFragment.f13757k.d(ConsultAnchorActivity.this.getSupportFragmentManager(), false, it, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null);
            }
        }));
    }

    public final void z1() {
        ConsultLiveTitleLayout consult_anchor_title_layout = (ConsultLiveTitleLayout) m1(R$id.consult_anchor_title_layout);
        s.h(consult_anchor_title_layout, "consult_anchor_title_layout");
        com.cupidapp.live.base.view.s.b(this, consult_anchor_title_layout);
        ((ConsultVoiceChatLayout) m1(R$id.consult_anchor_voice_chat_layout)).setCurrentPagePosition(Q0());
        ((ConsultCommentListLayout) m1(R$id.consult_anchor_comment_list_layout)).setCurrentPagePosition(Q0());
    }
}
