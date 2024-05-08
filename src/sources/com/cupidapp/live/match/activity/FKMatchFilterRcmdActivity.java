package com.cupidapp.live.match.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.livedata.EventObserver;
import com.cupidapp.live.base.router.PurchaseSuccessEvent;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.match.fragment.MatchFilterFragment;
import com.cupidapp.live.match.fragment.MatchFilterTransModel;
import com.cupidapp.live.match.view.MBTIEntranceLayout;
import com.cupidapp.live.match.viewmodel.MatchFilterViewModel;
import com.cupidapp.live.profile.model.User;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import java.util.Arrays;
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

/* compiled from: FKMatchFilterRcmdActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKMatchFilterRcmdActivity extends FKBaseActivity {

    /* renamed from: s */
    @NotNull
    public static final a f16492s = new a(null);

    /* renamed from: q */
    @NotNull
    public final Lazy f16493q;

    /* renamed from: r */
    @NotNull
    public Map<Integer, View> f16494r = new LinkedHashMap();

    /* compiled from: FKMatchFilterRcmdActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(a aVar, Context context, String str, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                str = null;
            }
            aVar.a(context, str);
        }

        public final void a(@Nullable Context context, @Nullable String str) {
            if (context == null) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) FKMatchFilterRcmdActivity.class);
            intent.putExtra("defaultTab", str);
            context.startActivity(intent);
            FKBaseActivity.f11750o.b(context, R$anim.anim_activity_bottom_to_top, R$anim.anmi_stop);
        }
    }

    public FKMatchFilterRcmdActivity() {
        final Function0 function0 = null;
        this.f16493q = new ViewModelLazy(kotlin.jvm.internal.v.b(MatchFilterViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.match.activity.FKMatchFilterRcmdActivity$special$$inlined$viewModels$default$2
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.match.activity.FKMatchFilterRcmdActivity$special$$inlined$viewModels$default$1
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
        }, new Function0<CreationExtras>() { // from class: com.cupidapp.live.match.activity.FKMatchFilterRcmdActivity$special$$inlined$viewModels$default$3
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

    public static final void r1(FKMatchFilterRcmdActivity this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        ((CollapsingToolbarLayout) this$0.k1(R$id.toolbar_layout)).setScrimVisibleHeightTrigger(z0.h.c(this$0, 6.0f) + ((MaterialToolbar) this$0.k1(R$id.toolbar)).getHeight());
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.RcmdFilterGuide;
    }

    @Nullable
    public View k1(int i10) {
        Map<Integer, View> map = this.f16494r;
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

    public final void n1() {
        ((FKTitleBarLayout) k1(R$id.filter_rcmd_title)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.FKMatchFilterRcmdActivity$bindEvent$1$1
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
                FKMatchFilterRcmdActivity.this.s1();
            }
        });
        FKUniversalButton rcmd_filter_save = (FKUniversalButton) k1(R$id.rcmd_filter_save);
        kotlin.jvm.internal.s.h(rcmd_filter_save, "rcmd_filter_save");
        z0.y.d(rcmd_filter_save, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.activity.FKMatchFilterRcmdActivity$bindEvent$2
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
                MatchFilterViewModel o12;
                p1.g.f52734a.c();
                o12 = FKMatchFilterRcmdActivity.this.o1();
                o12.doneBtnClick(FKMatchFilterRcmdActivity.this.Q0());
            }
        });
    }

    public final MatchFilterViewModel o1() {
        return (MatchFilterViewModel) this.f16493q.getValue();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        s1();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_match_filter_rcmd);
        n1();
        q1();
        p1();
        j1.c cVar = j1.c.f50228a;
        SensorPosition sensorPosition = SensorPosition.RcmdFilterGuide;
        j1.c.b(cVar, sensorPosition, sensorPosition.getValue(), null, 4, null);
    }

    @he.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull PurchaseSuccessEvent event) {
        kotlin.jvm.internal.s.i(event, "event");
        EventBus.c().r(event);
    }

    public final void p1() {
        o1().getMbtiEntranceShowEvent().observe(this, new EventObserver(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.match.activity.FKMatchFilterRcmdActivity$initObserve$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                ((MBTIEntranceLayout) FKMatchFilterRcmdActivity.this.k1(R$id.mbti_entrance)).h(z10);
            }
        }));
    }

    public final void q1() {
        String str;
        ((MaterialToolbar) k1(R$id.toolbar)).post(new Runnable() { // from class: com.cupidapp.live.match.activity.b
            @Override // java.lang.Runnable
            public final void run() {
                FKMatchFilterRcmdActivity.r1(FKMatchFilterRcmdActivity.this);
            }
        });
        getSupportFragmentManager().beginTransaction().replace(2131363041, MatchFilterFragment.f16692k.a(new MatchFilterTransModel(false, false, getIntent().getStringExtra("defaultTab"), Q0(), false))).commitNow();
        ((MBTIEntranceLayout) k1(R$id.mbti_entrance)).setPosition(Q0());
        TextView textView = (TextView) k1(R$id.filter_rcmd_hi);
        kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f51038a;
        String string = getString(R$string.filter_rcmd_hi);
        kotlin.jvm.internal.s.h(string, "getString(R.string.filter_rcmd_hi)");
        Object[] objArr = new Object[1];
        User X = p1.g.f52734a.X();
        if (X == null || (str = X.getName()) == null) {
            str = "";
        }
        objArr[0] = str;
        String format = String.format(string, Arrays.copyOf(objArr, 1));
        kotlin.jvm.internal.s.h(format, "format(format, *args)");
        textView.setText(format);
    }

    public final void s1() {
        if (com.cupidapp.live.profile.logic.c.f17839a.f()) {
            finish();
        } else {
            FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, this, false, 2, null).j(false).D(R$string.confirm_cancel_filter), R$string.need_purchase_vip, 0, 2, null), R$string.confirm_purchase, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.activity.FKMatchFilterRcmdActivity$showTwiceConfirmDialog$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ kotlin.p invoke() {
                    invoke2();
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MatchFilterViewModel o12;
                    o12 = FKMatchFilterRcmdActivity.this.o1();
                    o12.doneBtnClick(FKMatchFilterRcmdActivity.this.Q0());
                    j1.i.d(j1.i.f50236a, PopupName.GIVE_UP_FILTER, PopupButtonName.CONTINUE, null, 4, null);
                }
            }, 2, null).q(R$string.determine, new Function0<kotlin.p>() { // from class: com.cupidapp.live.match.activity.FKMatchFilterRcmdActivity$showTwiceConfirmDialog$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ kotlin.p invoke() {
                    invoke2();
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    j1.i.d(j1.i.f50236a, PopupName.GIVE_UP_FILTER, PopupButtonName.Confirm, null, 4, null);
                    FKMatchFilterRcmdActivity.this.finish();
                }
            }), null, 1, null);
            j1.i.g(j1.i.f50236a, PopupName.GIVE_UP_FILTER, null, null, 6, null);
        }
    }
}
