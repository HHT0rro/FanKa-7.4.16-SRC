package com.cupidapp.live.tourist.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.login.activity.SignInActivity;
import com.cupidapp.live.main.view.FKBottomTabLayout;
import com.cupidapp.live.tourist.fragment.FKTeenModeLiveFragment;
import com.cupidapp.live.tourist.fragment.FKTouristRecommendFeedFragment;
import com.cupidapp.live.tourist.fragment.FKTouristSwipeCardFragment;
import com.cupidapp.live.tourist.view.FKTouristLoginLayout;
import com.google.android.material.tabs.TabLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.g;
import z3.f;

/* compiled from: FKTouristMainActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKTouristMainActivity extends FKBaseActivity {

    /* renamed from: x, reason: collision with root package name */
    @NotNull
    public static final a f18670x = new a(null);

    /* renamed from: u, reason: collision with root package name */
    @Nullable
    public TabLayout.Tab f18675u;

    /* renamed from: w, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18677w = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f18671q = kotlin.c.b(new Function0<AbnormalModeType>() { // from class: com.cupidapp.live.tourist.activity.FKTouristMainActivity$modeType$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final AbnormalModeType invoke() {
            Intent intent = FKTouristMainActivity.this.getIntent();
            s.h(intent, "intent");
            return (AbnormalModeType) g.a(intent, AbnormalModeType.class);
        }
    });

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final FKTouristSwipeCardFragment f18672r = new FKTouristSwipeCardFragment();

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final FKTeenModeLiveFragment f18673s = new FKTeenModeLiveFragment();

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public final FKTouristRecommendFeedFragment f18674t = FKTouristRecommendFeedFragment.f18681j.a(new Function0<p>() { // from class: com.cupidapp.live.tourist.activity.FKTouristMainActivity$touristRecommendFeedFragment$1
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
            FKTouristMainActivity.this.s1();
        }
    });

    /* renamed from: v, reason: collision with root package name */
    @NotNull
    public SensorPosition f18676v = SensorPosition.Match;

    /* compiled from: FKTouristMainActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @NotNull AbnormalModeType modeType) {
            s.i(modeType, "modeType");
            Intent intent = new Intent(context, (Class<?>) FKTouristMainActivity.class);
            g.c(intent, modeType);
            if (modeType == AbnormalModeType.TeenModeType) {
                intent.addFlags(32768);
                intent.addFlags(268435456);
            }
            if (context != null) {
                context.startActivity(intent);
            }
            FKBaseActivity.f11750o.b(context, 0, 0);
        }
    }

    /* compiled from: FKTouristMainActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18678a;

        static {
            int[] iArr = new int[AbnormalModeType.values().length];
            try {
                iArr[AbnormalModeType.TouristModeType.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AbnormalModeType.TeenModeType.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f18678a = iArr;
        }
    }

    /* compiled from: FKTouristMainActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements TabLayout.OnTabSelectedListener {
        public c() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(@Nullable TabLayout.Tab tab) {
            if (FKTouristMainActivity.this.isFinishing() || FKTouristMainActivity.this.getSupportFragmentManager().isDestroyed() || tab == null) {
                return;
            }
            FKTouristMainActivity fKTouristMainActivity = FKTouristMainActivity.this;
            if (fKTouristMainActivity.q1() == AbnormalModeType.TouristModeType) {
                int position = tab.getPosition();
                if (position == 1 || position == 3 || position == 4) {
                    fKTouristMainActivity.s1();
                    return;
                }
                return;
            }
            int position2 = tab.getPosition();
            if (position2 == 0 || position2 == 2 || position2 == 3 || position2 == 4) {
                fKTouristMainActivity.u1();
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(@Nullable TabLayout.Tab tab) {
            if (FKTouristMainActivity.this.isFinishing() || FKTouristMainActivity.this.getSupportFragmentManager().isDestroyed() || tab == null) {
                return;
            }
            FKTouristMainActivity fKTouristMainActivity = FKTouristMainActivity.this;
            if (fKTouristMainActivity.q1() == AbnormalModeType.TouristModeType) {
                int position = tab.getPosition();
                if (position != 0 && position != 2) {
                    fKTouristMainActivity.s1();
                    return;
                }
                TabLayout.Tab tab2 = fKTouristMainActivity.f18675u;
                if (tab2 != null && tab.getPosition() != tab2.getPosition()) {
                    ((FKBottomTabLayout) fKTouristMainActivity.j1(R$id.bottom_tab_layout)).i(tab2, false);
                }
                fKTouristMainActivity.t1(tab.getPosition());
                ((FKBottomTabLayout) fKTouristMainActivity.j1(R$id.bottom_tab_layout)).i(tab, true);
                return;
            }
            if (tab.getPosition() == 1) {
                fKTouristMainActivity.t1(tab.getPosition());
                ((FKBottomTabLayout) fKTouristMainActivity.j1(R$id.bottom_tab_layout)).i(tab, true);
            } else {
                fKTouristMainActivity.u1();
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(@Nullable TabLayout.Tab tab) {
            if (FKTouristMainActivity.this.isFinishing() || FKTouristMainActivity.this.getSupportFragmentManager().isDestroyed() || tab == null) {
                return;
            }
            FKTouristMainActivity fKTouristMainActivity = FKTouristMainActivity.this;
            int position = tab.getPosition();
            if (position == 0 || position == 2) {
                fKTouristMainActivity.f18675u = tab;
            }
        }
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f18677w;
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
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.setFlags(268435456);
            startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            AppApplication.f11612d.h().i();
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_tourist_main);
        r1();
    }

    public final AbnormalModeType q1() {
        return (AbnormalModeType) this.f18671q.getValue();
    }

    public final void r1() {
        int i10 = R$id.bottom_tab_layout;
        ((FKBottomTabLayout) j1(i10)).addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new c());
        AbnormalModeType q12 = q1();
        int i11 = q12 == null ? -1 : b.f18678a[q12.ordinal()];
        ((FKBottomTabLayout) j1(i10)).b(Integer.valueOf((i11 == 1 || i11 != 2) ? 0 : 1));
        int i12 = R$id.tourist_login_layout;
        FKTouristLoginLayout tourist_login_layout = (FKTouristLoginLayout) j1(i12);
        s.h(tourist_login_layout, "tourist_login_layout");
        tourist_login_layout.setVisibility(q1() == AbnormalModeType.TouristModeType ? 0 : 8);
        ((FKTouristLoginLayout) j1(i12)).setJumpToLoginCallback(new Function0<p>() { // from class: com.cupidapp.live.tourist.activity.FKTouristMainActivity$initView$2
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
                FKTouristMainActivity.this.s1();
            }
        });
    }

    public final void s1() {
        SignInActivity.f16116t.a(this, true);
        f.f54838a.a(this.f18676v);
    }

    public final void t1(int i10) {
        FKBaseFragment fKBaseFragment;
        if (i10 == 0) {
            this.f18676v = SensorPosition.Match;
            ((FKTouristLoginLayout) j1(R$id.tourist_login_layout)).setIntercept(true);
            fKBaseFragment = this.f18672r;
        } else if (i10 == 1) {
            fKBaseFragment = this.f18673s;
        } else if (i10 != 2) {
            fKBaseFragment = null;
        } else {
            this.f18676v = SensorPosition.RecommendFeed;
            ((FKTouristLoginLayout) j1(R$id.tourist_login_layout)).setIntercept(false);
            fKBaseFragment = this.f18674t;
        }
        f1(fKBaseFragment, false, R$id.tourist_main_container_layout, false, true);
    }

    public final void u1() {
        FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.f12698l.b(this, false), R$string.teen_mode_prompt, 0, 2, null), R$string.i_know_it, null, null, 6, null), null, 1, null);
    }
}
