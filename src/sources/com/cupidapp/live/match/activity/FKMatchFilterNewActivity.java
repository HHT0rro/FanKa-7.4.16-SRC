package com.cupidapp.live.match.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.router.PurchaseSuccessEvent;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.match.fragment.MatchFilterFragment;
import com.cupidapp.live.match.fragment.MatchFilterTransModel;
import com.cupidapp.live.match.view.MBTIEntranceLayout;
import com.cupidapp.live.match.viewmodel.MatchFilterViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKMatchFilterNewActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKMatchFilterNewActivity extends FKBaseActivity {

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public static final a f16488t = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f16489q;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16491s = new LinkedHashMap();

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f16490r = kotlin.c.b(new Function0<Boolean>() { // from class: com.cupidapp.live.match.activity.FKMatchFilterNewActivity$fromNearby$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Boolean invoke() {
            return Boolean.valueOf(FKMatchFilterNewActivity.this.getIntent().getBooleanExtra("OPEN_MATCH_FILTER_FROM_NEARBY", false));
        }
    });

    /* compiled from: FKMatchFilterNewActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, boolean z10, boolean z11, @Nullable String str) {
            if (context == null) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) FKMatchFilterNewActivity.class);
            intent.putExtra("OPEN_MATCH_FILTER_FROM_NEARBY", z10);
            intent.putExtra("backToMainActivity", z11);
            intent.putExtra("defaultTab", str);
            context.startActivity(intent);
            FKBaseActivity.f11750o.b(context, R$anim.anim_activity_bottom_to_top, R$anim.anmi_stop);
        }
    }

    public FKMatchFilterNewActivity() {
        final Function0 function0 = null;
        this.f16489q = new ViewModelLazy(kotlin.jvm.internal.v.b(MatchFilterViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.match.activity.FKMatchFilterNewActivity$special$$inlined$viewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.match.activity.FKMatchFilterNewActivity$special$$inlined$viewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.match.activity.FKMatchFilterNewActivity$special$$inlined$viewModels$default$3
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

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.MatchFilter;
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f16491s;
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

    public final void l1() {
        FKTitleBarLayout fKTitleBarLayout = (FKTitleBarLayout) j1(R$id.matchFilterTitleLayout);
        fKTitleBarLayout.setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.FKMatchFilterNewActivity$bindEvent$1$1
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
                FKMatchFilterNewActivity.this.finish();
            }
        });
        fKTitleBarLayout.setRightTextClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.FKMatchFilterNewActivity$bindEvent$1$2
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
                MatchFilterViewModel n12;
                p1.g.f52734a.c();
                n12 = FKMatchFilterNewActivity.this.n1();
                n12.doneBtnClick(FKMatchFilterNewActivity.this.Q0());
            }
        });
    }

    public final boolean m1() {
        return ((Boolean) this.f16490r.getValue()).booleanValue();
    }

    public final MatchFilterViewModel n1() {
        return (MatchFilterViewModel) this.f16489q.getValue();
    }

    public final void o1() {
        n1().getMbtiEntranceShowEvent().observe(this, new EventObserver(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.match.activity.FKMatchFilterNewActivity$initObserve$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                ((MBTIEntranceLayout) FKMatchFilterNewActivity.this.j1(R$id.mbti_entrance)).h(z10);
            }
        }));
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        d1(R$anim.anmi_stop, Integer.valueOf(R$anim.anim_activity_top_to_bottom));
        setContentView(R$layout.activity_match_filter_new);
        l1();
        p1();
        o1();
        j1.c cVar = j1.c.f50228a;
        SensorPosition sensorPosition = SensorPosition.MatchFilter;
        j1.c.b(cVar, sensorPosition, sensorPosition.getValue(), null, 4, null);
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull PurchaseSuccessEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
        n1().loadData(m1());
    }

    public final void p1() {
        getSupportFragmentManager().beginTransaction().replace(2131363041, MatchFilterFragment.f16692k.a(new MatchFilterTransModel(m1(), getIntent().getBooleanExtra("backToMainActivity", false), getIntent().getStringExtra("defaultTab"), Q0(), true))).commitNow();
        ((MBTIEntranceLayout) j1(R$id.mbti_entrance)).setPosition(Q0());
    }
}
