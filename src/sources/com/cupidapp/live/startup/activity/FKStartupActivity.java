package com.cupidapp.live.startup.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.MainActivity;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.GuidHelper;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.NoAdReason;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.i0;
import com.cupidapp.live.login.activity.SignInActivity;
import com.cupidapp.live.login.helper.e;
import com.cupidapp.live.performance.time.LoadAdResult;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.startup.fragment.FKStartupAdFragment;
import com.cupidapp.live.startup.helper.SplashAdSelectHelper;
import com.cupidapp.live.startup.model.StartCacheSplashAdDataEvent;
import com.cupidapp.live.startup.splashad.a;
import com.cupidapp.live.tourist.activity.AbnormalModeType;
import com.cupidapp.live.tourist.activity.FKTouristMainActivity;
import j1.m;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.g;

/* compiled from: FKStartupActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKStartupActivity extends FKBaseActivity {

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public static final a f18306u = new a(null);

    /* renamed from: s, reason: collision with root package name */
    public boolean f18309s;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18310t = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final Lazy f18307q = kotlin.c.b(new Function0<StartupIsShowAdType>() { // from class: com.cupidapp.live.startup.activity.FKStartupActivity$startupShowAdType$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final StartupIsShowAdType invoke() {
            Intent intent = FKStartupActivity.this.getIntent();
            s.h(intent, "intent");
            return (StartupIsShowAdType) g.a(intent, StartupIsShowAdType.class);
        }
    });

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f18308r = kotlin.c.b(new Function0<com.cupidapp.live.startup.splashad.a>() { // from class: com.cupidapp.live.startup.activity.FKStartupActivity$hwExSplashManager$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final a invoke() {
            return new a(AppApplication.f11612d.c());
        }
    });

    /* compiled from: FKStartupActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @Nullable Uri uri, @Nullable Bundle bundle) {
            s.i(context, "context");
            Intent intent = new Intent(context, (Class<?>) FKStartupActivity.class);
            intent.setData(uri);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            intent.putExtra("IS_COLD_START", true);
            context.startActivity(intent);
            FKBaseActivity.f11750o.b(context, 0, 0);
        }

        public final void b(@NotNull Context context, @NotNull StartupIsShowAdType showAdType, boolean z10) {
            s.i(context, "context");
            s.i(showAdType, "showAdType");
            Intent intent = new Intent(context, (Class<?>) FKStartupActivity.class);
            g.c(intent, showAdType);
            intent.putExtra("IS_COLD_START", false);
            if (z10) {
                intent.addFlags(32768);
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
            FKBaseActivity.f11750o.b(context, 0, 0);
        }
    }

    /* compiled from: FKStartupActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18311a;

        static {
            int[] iArr = new int[StartupIsShowAdType.values().length];
            try {
                iArr[StartupIsShowAdType.MustShow.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StartupIsShowAdType.MustNotShowing.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f18311a = iArr;
        }
    }

    /* compiled from: FKStartupActivity.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements com.cupidapp.live.startup.fragment.c {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f18313b;

        public c(boolean z10) {
            this.f18313b = z10;
        }

        @Override // com.cupidapp.live.startup.fragment.c
        public void a() {
            FKStartupActivity.this.t1(this.f18313b);
        }

        @Override // com.cupidapp.live.startup.fragment.c
        public void b(@NotNull String url) {
            s.i(url, "url");
            FKStartupActivity.this.s1(url, this.f18313b);
        }
    }

    public static /* synthetic */ void u1(FKStartupActivity fKStartupActivity, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        fKStartupActivity.t1(z10);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.Startup;
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        FKBaseActivity.f11750o.b(this, R$anim.alpha_in, R$anim.alpha_out);
    }

    public final boolean n1() {
        p1.g gVar = p1.g.f52734a;
        ConstantsResult q10 = gVar.q();
        if (!(q10 != null ? s.d(q10.getEnableHWExSplash(), Boolean.TRUE) : false) || !i0.f12331a.c()) {
            return false;
        }
        User X = gVar.X();
        return !(X != null && X.getVipAd() == 1);
    }

    public final com.cupidapp.live.startup.splashad.a o1() {
        return (com.cupidapp.live.startup.splashad.a) this.f18308r.getValue();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        getSupportFragmentManager().popBackStack();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (a1()) {
            finish();
            return;
        }
        setContentView(R$layout.activity_startup);
        d1(0, 0);
        r1();
        if ((getIntent().getFlags() & 4194304) != 0) {
            com.cupidapp.live.base.web.c cVar = com.cupidapp.live.base.web.c.f13063a;
            if (!cVar.b(getIntent().getData()) && !cVar.a(getIntent().getData())) {
                finish();
                return;
            }
            if (e.f16161a.b()) {
                if (s.d(p1.g.f52734a.C1(), Boolean.TRUE)) {
                    FKTouristMainActivity.f18670x.a(this, AbnormalModeType.TeenModeType);
                    return;
                } else {
                    u1(this, false, 1, null);
                    return;
                }
            }
            finish();
            return;
        }
        this.f18309s = getIntent().getBooleanExtra("IS_COLD_START", false);
        v1();
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        com.cupidapp.live.startup.helper.b.f18418a.a("FKStartupActivity onRestart startupShowAdType:" + ((Object) p1()));
        StartupIsShowAdType p12 = p1();
        int i10 = p12 == null ? -1 : b.f18311a[p12.ordinal()];
        if (i10 != 1 && i10 != 2) {
            u1(this, false, 1, null);
        } else {
            t1(false);
        }
    }

    public final StartupIsShowAdType p1() {
        return (StartupIsShowAdType) this.f18307q.getValue();
    }

    public final void q1(boolean z10) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        s.h(beginTransaction, "supportFragmentManager.beginTransaction()");
        beginTransaction.replace(R$id.startupFragContainer, FKStartupAdFragment.f18400m.a(this.f18309s, new c(z10))).commit();
        getSupportFragmentManager().popBackStackImmediate();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0103, code lost:
    
        if (r4.equals(com.tencent.connect.common.Constants.PARAM_PLATFORM) == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0178, code lost:
    
        if ((r10.length() > 0) == true) goto L79;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x016b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void r1() {
        /*
            Method dump skipped, instructions count: 462
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.startup.activity.FKStartupActivity.r1():void");
    }

    public final void s1(String str, boolean z10) {
        com.cupidapp.live.startup.helper.b.f18418a.a("FKStartupActivity startAdWebAndMain url:" + str + " startToMain:" + z10);
        t1(z10);
        j.a.b(j.f12156c, this, str, null, 4, null);
    }

    public final void t1(boolean z10) {
        com.cupidapp.live.startup.helper.b.f18418a.a("FKStartupActivity startMainActivity startToMain:" + z10 + "  data:" + ((Object) getIntent().getData()) + "  extras:" + ((Object) getIntent().getExtras()));
        if (z10) {
            MainActivity.a aVar = MainActivity.F;
            Uri data = getIntent().getData();
            Bundle extras = getIntent().getExtras();
            Object obj = extras != null ? extras.get("pushModel") : null;
            aVar.f(this, (r12 & 2) != 0 ? null : data, (r12 & 4) != 0 ? null : obj instanceof String ? (String) obj : null, (r12 & 8) != 0 ? false : false, (r12 & 16) == 0 ? null : null, (r12 & 32) != 0 ? Boolean.FALSE : null);
            getIntent().setData(null);
            Bundle extras2 = getIntent().getExtras();
            if (extras2 != null) {
                extras2.putString("pushModel", null);
            }
        }
        finish();
    }

    public final void v1() {
        p1.g gVar = p1.g.f52734a;
        if (gVar.Q3()) {
            GuidHelper.f11866a.e(this);
            com.cupidapp.live.base.network.a.f11902a.v(this);
            if (n1()) {
                o1().e(true);
            } else {
                o1().e(false);
            }
        }
        if (e.f16161a.b()) {
            if (s.d(gVar.C1(), Boolean.TRUE)) {
                FKTouristMainActivity.f18670x.a(this, AbnormalModeType.TeenModeType);
                return;
            }
            if (p1() == null && n1()) {
                EventBus.c().o(new StartCacheSplashAdDataEvent());
                t1(true);
                return;
            } else {
                if (this.f18309s) {
                    i3.a.f49713a.f(SystemClock.uptimeMillis());
                }
                SplashAdSelectHelper.f18415a.s(p1(), new Function1<Boolean, p>() { // from class: com.cupidapp.live.startup.activity.FKStartupActivity$startupInitialization$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return p.f51048a;
                    }

                    public final void invoke(boolean z10) {
                        boolean z11;
                        i3.a aVar = i3.a.f49713a;
                        z11 = FKStartupActivity.this.f18309s;
                        aVar.d(z11, null, LoadAdResult.NOT_LOAD);
                        FKStartupActivity.this.t1(z10);
                    }
                }, new Function1<Boolean, p>() { // from class: com.cupidapp.live.startup.activity.FKStartupActivity$startupInitialization$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return p.f51048a;
                    }

                    public final void invoke(boolean z10) {
                        FKStartupActivity.this.q1(z10);
                    }
                });
                return;
            }
        }
        m.f50240a.f(NoAdReason.NOT_SIGN_IN);
        SignInActivity.a.b(SignInActivity.f16116t, this, false, 2, null);
        finish();
    }
}
