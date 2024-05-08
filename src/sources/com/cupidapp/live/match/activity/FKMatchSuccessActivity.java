package com.cupidapp.live.match.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.sensorslog.FKSensorContext;
import com.cupidapp.live.base.sensorslog.InboxMessageType;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.p0;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.base.view.indicator.TopIndicatorLayout;
import com.cupidapp.live.chat.model.CustomEmojiCode;
import com.cupidapp.live.chat.view.FaceLayout;
import com.cupidapp.live.chat2.activity.ChatDetailActivity;
import com.cupidapp.live.chat2.model.ChatBundleData;
import com.cupidapp.live.liveshow.beauty.databeauty.UserData;
import com.cupidapp.live.match.activity.FKMatchSuccessActivity$pageChangeCallback$2;
import com.cupidapp.live.match.adapter.FKMatchSuccessAdapter;
import com.cupidapp.live.match.view.FKMatchSuccessStoryLabelLayout;
import com.cupidapp.live.match.view.PictureWithClickChangeLayout;
import com.cupidapp.live.profile.model.FKStoryLabelItemModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.superlike.view.MatchSuccessSuperLikeText;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKMatchSuccessActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKMatchSuccessActivity extends FKBaseActivity {

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public static final a f16495v = new a(null);

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final Lazy f16498s;

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16500u = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f16496q = kotlin.c.b(new Function0<FKMatchSuccessActivity$pageChangeCallback$2.AnonymousClass1>() { // from class: com.cupidapp.live.match.activity.FKMatchSuccessActivity$pageChangeCallback$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.cupidapp.live.match.activity.FKMatchSuccessActivity$pageChangeCallback$2$1] */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final AnonymousClass1 invoke() {
            final FKMatchSuccessActivity fKMatchSuccessActivity = FKMatchSuccessActivity.this;
            return new ViewPager2.OnPageChangeCallback() { // from class: com.cupidapp.live.match.activity.FKMatchSuccessActivity$pageChangeCallback$2.1
                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public void onPageSelected(int i10) {
                    MatchSuccessViewModel x12;
                    x12 = FKMatchSuccessActivity.this.x1();
                    x12.changeSelectAvatarPos(i10);
                }
            };
        }
    });

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final FKMatchSuccessAdapter f16497r = new FKMatchSuccessAdapter();

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public final Lazy f16499t = kotlin.c.b(new Function0<FKSensorContext>() { // from class: com.cupidapp.live.match.activity.FKMatchSuccessActivity$mSensorContext$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKSensorContext invoke() {
            return new FKSensorContext(FKMatchSuccessActivity.this.Q0(), SensorPosition.Unknown, null, null);
        }
    });

    /* compiled from: FKMatchSuccessActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull User user, boolean z10, boolean z11) {
            kotlin.jvm.internal.s.i(context, "context");
            kotlin.jvm.internal.s.i(user, "user");
            Intent intent = new Intent(context, (Class<?>) FKMatchSuccessActivity.class);
            intent.putExtra(UserData.NAME, user);
            intent.putExtra("initiativeMatch", z10);
            intent.putExtra(ALBiometricsActivityParentView.f2433i, z11);
            context.startActivity(intent);
            if (context instanceof Activity) {
                ((Activity) context).overridePendingTransition(0, 0);
            }
        }
    }

    public FKMatchSuccessActivity() {
        final Function0 function0 = null;
        this.f16498s = new ViewModelLazy(kotlin.jvm.internal.v.b(MatchSuccessViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.match.activity.FKMatchSuccessActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
                kotlin.jvm.internal.s.h(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.match.activity.FKMatchSuccessActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = ComponentActivity.this.getDefaultViewModelProviderFactory();
                kotlin.jvm.internal.s.h(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.match.activity.FKMatchSuccessActivity$special$$inlined$viewModels$default$3
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
                kotlin.jvm.internal.s.h(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        });
    }

    public static final boolean A1(FKMatchSuccessActivity this$0, View view, MotionEvent motionEvent) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (motionEvent.getAction() == 1) {
            view.performClick();
            ((RelativeLayout) this$0.r1(R$id.swipe_guide_cl)).setVisibility(8);
        }
        return true;
    }

    public static final void B1(FKMatchSuccessActivity this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ((RelativeLayout) this$0.r1(R$id.swipe_guide_cl)).setVisibility(8);
    }

    public static final void E1(FKMatchSuccessActivity this$0, View view) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        this$0.finish();
    }

    public static final void G1(FKMatchSuccessActivity this$0, List list) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (list == null) {
            return;
        }
        this$0.f16497r.e(list);
        this$0.f16497r.notifyItemRangeInserted(0, list.size());
        int i10 = R$id.matchIndicator;
        ((TopIndicatorLayout) this$0.r1(i10)).setPagerCount(list.size());
        ((TopIndicatorLayout) this$0.r1(i10)).setCurrentPager(0);
    }

    public static final void H1(FKMatchSuccessActivity this$0, Integer it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        TopIndicatorLayout topIndicatorLayout = (TopIndicatorLayout) this$0.r1(R$id.matchIndicator);
        kotlin.jvm.internal.s.h(it, "it");
        topIndicatorLayout.setCurrentPager(it.intValue());
    }

    public static final void I1(FKMatchSuccessActivity this$0, Boolean it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        int i10 = R$id.match_success_super_like_text;
        ((MatchSuccessSuperLikeText) this$0.r1(i10)).setVisibility(0);
        MatchSuccessSuperLikeText matchSuccessSuperLikeText = (MatchSuccessSuperLikeText) this$0.r1(i10);
        kotlin.jvm.internal.s.h(it, "it");
        matchSuccessSuperLikeText.b(it.booleanValue());
    }

    public static final void J1(FKMatchSuccessActivity this$0, Boolean it) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        FKSVGAImageView matchSVGA = (FKSVGAImageView) this$0.r1(R$id.matchSVGA);
        kotlin.jvm.internal.s.h(matchSVGA, "matchSVGA");
        kotlin.jvm.internal.s.h(it, "it");
        FKSVGAImageView.F(matchSVGA, it.booleanValue() ? "match_success_no_match.svga" : "match_success.svga", null, null, 6, null);
    }

    public static final void K1(FKMatchSuccessActivity this$0, FKStoryLabelItemModel fKStoryLabelItemModel) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (fKStoryLabelItemModel == null) {
            ((FKMatchSuccessStoryLabelLayout) this$0.r1(R$id.match_success_story_label)).setVisibility(8);
            return;
        }
        int i10 = R$id.match_success_story_label;
        ((FKMatchSuccessStoryLabelLayout) this$0.r1(i10)).setVisibility(0);
        ((FKMatchSuccessStoryLabelLayout) this$0.r1(i10)).b(fKStoryLabelItemModel);
    }

    public final void C1() {
        int k10 = z0.h.k(this);
        if (k10 != 0) {
            int m10 = k10 - z0.h.m(this);
            View matchTopShadow = r1(R$id.matchTopShadow);
            kotlin.jvm.internal.s.h(matchTopShadow, "matchTopShadow");
            z0.y.n(matchTopShadow, null, Integer.valueOf(m10 / 5));
            View matchBottomShadow = r1(R$id.matchBottomShadow);
            kotlin.jvm.internal.s.h(matchBottomShadow, "matchBottomShadow");
            z0.y.l(matchBottomShadow, null, Integer.valueOf(m10 / 3), null, null);
        }
    }

    public final void D1() {
        ((ImageView) r1(R$id.matchCloseImg)).setOnClickListener(new View.OnClickListener() { // from class: com.cupidapp.live.match.activity.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FKMatchSuccessActivity.E1(FKMatchSuccessActivity.this, view);
            }
        });
        ((PictureWithClickChangeLayout) r1(R$id.matchPictureLayout)).g(w1());
        TextView matchSendTxt = (TextView) r1(R$id.matchSendTxt);
        kotlin.jvm.internal.s.h(matchSendTxt, "matchSendTxt");
        z0.y.d(matchSendTxt, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.FKMatchSuccessActivity$initListener$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                Editable text = ((EditText) FKMatchSuccessActivity.this.r1(R$id.matchEditText)).getText();
                String obj = text != null ? text.toString() : null;
                if (obj == null || kotlin.text.p.t(obj)) {
                    return;
                }
                FKMatchSuccessActivity.this.O1(obj, InboxMessageType.WORD);
            }
        });
    }

    public final void F1() {
        x1().getAvatarsLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.match.activity.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FKMatchSuccessActivity.G1(FKMatchSuccessActivity.this, (List) obj);
            }
        });
        x1().getSelectAvatarPosLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.match.activity.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FKMatchSuccessActivity.H1(FKMatchSuccessActivity.this, (Integer) obj);
            }
        });
        x1().getSuperLikeState().observe(this, new Observer() { // from class: com.cupidapp.live.match.activity.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FKMatchSuccessActivity.I1(FKMatchSuccessActivity.this, (Boolean) obj);
            }
        });
        x1().getMatchSuccessAnimationLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.match.activity.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FKMatchSuccessActivity.J1(FKMatchSuccessActivity.this, (Boolean) obj);
            }
        });
        x1().getStoryLabel();
        x1().getStoryLabelLiveData().observe(this, new Observer() { // from class: com.cupidapp.live.match.activity.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FKMatchSuccessActivity.K1(FKMatchSuccessActivity.this, (FKStoryLabelItemModel) obj);
            }
        });
        x1().getSendMsgStateResult().observe(this, new EventObserver(new Function1<StateResult<Boolean>, kotlin.p>() { // from class: com.cupidapp.live.match.activity.FKMatchSuccessActivity$initObserve$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(StateResult<Boolean> stateResult) {
                invoke2(stateResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull StateResult<Boolean> result) {
                kotlin.jvm.internal.s.i(result, "result");
                Boolean data = result.getData();
                if (result instanceof StateResult.c) {
                    if (kotlin.jvm.internal.s.d(data, Boolean.TRUE)) {
                        FKMatchSuccessActivity.this.N1();
                    } else {
                        com.cupidapp.live.base.view.h.f12779a.c(FKMatchSuccessActivity.this, R$string.send_suc);
                    }
                    FKMatchSuccessActivity.this.finish();
                    return;
                }
                if (result instanceof StateResult.a) {
                    com.cupidapp.live.base.view.h.f12779a.r(FKMatchSuccessActivity.this, R$string.send_fail);
                }
            }
        }));
    }

    public final void L1() {
        int i10 = R$id.matchPictureLayout;
        ((PictureWithClickChangeLayout) r1(i10)).setViewPagerUserInputEnabled(false);
        ((PictureWithClickChangeLayout) r1(i10)).setAdapter(this.f16497r);
    }

    public final void M1() {
        Serializable serializableExtra = getIntent().getSerializableExtra(UserData.NAME);
        User user = serializableExtra instanceof User ? (User) serializableExtra : null;
        boolean booleanExtra = getIntent().getBooleanExtra("initiativeMatch", false);
        if (user != null) {
            C1();
            y1();
            L1();
            z1();
            D1();
            x1().initData(user, booleanExtra);
            F1();
            return;
        }
        finish();
    }

    public final void N1() {
        Serializable serializableExtra = getIntent().getSerializableExtra(UserData.NAME);
        User user = serializableExtra instanceof User ? (User) serializableExtra : null;
        if (user != null) {
            ChatDetailActivity.f13276r.a(this, new ChatBundleData(user, user.userId(), v1(), null, false, true, true, false, false, 408, null));
        }
    }

    public final void O1(String str, InboxMessageType inboxMessageType) {
        x1().prepareSendMsg(str, inboxMessageType, v1());
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.MatchSuccess;
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_match_success);
        p0.a(this);
        M1();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ((PictureWithClickChangeLayout) r1(R$id.matchPictureLayout)).h(w1());
        super.onDestroy();
    }

    @Nullable
    public View r1(int i10) {
        Map<Integer, View> map = this.f16500u;
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

    public final FKSensorContext v1() {
        return (FKSensorContext) this.f16499t.getValue();
    }

    public final ViewPager2.OnPageChangeCallback w1() {
        return (ViewPager2.OnPageChangeCallback) this.f16496q.getValue();
    }

    public final MatchSuccessViewModel x1() {
        return (MatchSuccessViewModel) this.f16498s.getValue();
    }

    public final void y1() {
        int i10 = R$id.matchFaceLayout;
        if (((FaceLayout) r1(i10)) != null) {
            int l10 = ((z0.h.l(this) - z0.h.c(this, 21.0f)) / 5) - z0.h.c(this, 11.0f);
            ((FaceLayout) r1(i10)).e(l10, l10);
            ((FaceLayout) r1(i10)).f(kotlin.collections.s.o(CustomEmojiCode.Greet, CustomEmojiCode.WaterPistol, CustomEmojiCode.Poke, CustomEmojiCode.TouchHead, CustomEmojiCode.ThanHeart));
            ((FaceLayout) r1(i10)).setItemClickListener(new Function1<CustomEmojiCode, kotlin.p>() { // from class: com.cupidapp.live.match.activity.FKMatchSuccessActivity$initFaceView$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.p invoke(CustomEmojiCode customEmojiCode) {
                    invoke2(customEmojiCode);
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull CustomEmojiCode it) {
                    kotlin.jvm.internal.s.i(it, "it");
                    FKMatchSuccessActivity.this.O1(it.getEmojiCNCode(), InboxMessageType.EMOJI);
                }
            });
        }
    }

    public final void z1() {
        if (getIntent().getBooleanExtra(ALBiometricsActivityParentView.f2433i, false)) {
            int i10 = R$id.swipe_guide_cl;
            ((RelativeLayout) r1(i10)).setOnTouchListener(new View.OnTouchListener() { // from class: com.cupidapp.live.match.activity.d
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean A1;
                    A1 = FKMatchSuccessActivity.A1(FKMatchSuccessActivity.this, view, motionEvent);
                    return A1;
                }
            });
            int i11 = R$id.match_guide_svga;
            FKSVGAImageView fKSVGAImageView = (FKSVGAImageView) r1(i11);
            if (fKSVGAImageView != null) {
                fKSVGAImageView.postDelayed(new Runnable() { // from class: com.cupidapp.live.match.activity.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        FKMatchSuccessActivity.B1(FKMatchSuccessActivity.this);
                    }
                }, 10000L);
            }
            FKSVGAImageView match_guide_svga = (FKSVGAImageView) r1(i11);
            kotlin.jvm.internal.s.h(match_guide_svga, "match_guide_svga");
            FKSVGAImageView.F(match_guide_svga, "match_guide.svga", null, null, 6, null);
            ((RelativeLayout) r1(i10)).setVisibility(0);
            return;
        }
        ((RelativeLayout) r1(R$id.swipe_guide_cl)).setVisibility(8);
    }
}
