package com.cupidapp.live;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.cupidapp.live.base.activity.AppStateObserver;
import com.cupidapp.live.base.imageloader.ImageLoaderUtil;
import com.cupidapp.live.base.network.helper.RxJavaErrorHandlerHelper;
import com.cupidapp.live.base.safe.DigitalAllianceHelper;
import com.cupidapp.live.base.safe.MsaHelper;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.startup.model.FKExpressAdLocalModel;
import com.opensource.svgaplayer.SVGAParser;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.openapi.IWBAPI;
import com.sina.weibo.sdk.openapi.SdkListener;
import com.sina.weibo.sdk.openapi.WBAPIFactory;
import io.microshow.rxffmpeg.RxFFmpegInvoke;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.g;
import z0.h;

/* compiled from: AppApplication.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AppApplication extends Application {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f11612d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public static boolean f11613e;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f11614f;

    /* renamed from: g, reason: collision with root package name */
    public static AppApplication f11615g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final Lazy<AppStateObserver> f11616h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public static final Lazy<com.cupidapp.live.base.activity.a> f11617i;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Handler f11618b = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Lazy f11619c = kotlin.c.b(new Function0<IWBAPI>() { // from class: com.cupidapp.live.AppApplication$weiboApp$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IWBAPI invoke() {
            return WBAPIFactory.createWBAPI(AppApplication.f11612d.h());
        }
    });

    /* compiled from: AppApplication.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final Context c() {
            return h().getApplicationContext();
        }

        public final com.cupidapp.live.base.activity.a d() {
            return (com.cupidapp.live.base.activity.a) AppApplication.f11617i.getValue();
        }

        public final boolean e() {
            return AppApplication.f11613e;
        }

        public final AppStateObserver f() {
            return (AppStateObserver) AppApplication.f11616h.getValue();
        }

        public final boolean g() {
            return AppApplication.f11614f;
        }

        @NotNull
        public final AppApplication h() {
            AppApplication appApplication = AppApplication.f11615g;
            if (appApplication != null) {
                return appApplication;
            }
            s.A("shareInstance");
            return null;
        }

        public final void i(@NotNull Context context, @Nullable String str, @Nullable String str2) {
            s.i(context, "context");
            if (g.f52734a.Q3()) {
                com.cupidapp.live.base.network.a.f11902a.u(context);
                w0.a.f54093a.a(context, str, str2);
                j1.a.f50226a.a(context);
                com.cupidapp.live.base.safe.e.f12185a.b(context, str, str2);
                MsaHelper.Companion.a(context);
            }
        }

        public final void j(boolean z10) {
            AppApplication.f11613e = z10;
        }

        public final void k(boolean z10) {
            AppApplication.f11614f = z10;
        }

        public final void l(@NotNull AppApplication appApplication) {
            s.i(appApplication, "<set-?>");
            AppApplication.f11615g = appApplication;
        }
    }

    /* compiled from: AppApplication.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b extends AsyncTask<AppApplication, Void, Void> {
        @Override // android.os.AsyncTask
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(@NotNull AppApplication... params) {
            s.i(params, "params");
            AppApplication appApplication = params[0];
            if (appApplication == null) {
                return null;
            }
            appApplication.g();
            return null;
        }
    }

    /* compiled from: AppApplication.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c implements SdkListener {
        @Override // com.sina.weibo.sdk.openapi.SdkListener
        public void onInitFailure(@Nullable Exception exc) {
            j.f12332a.a("weibo", "sdk init fail, e= " + ((Object) exc));
        }

        @Override // com.sina.weibo.sdk.openapi.SdkListener
        public void onInitSuccess() {
            j.f12332a.a("weibo", "sdk init success");
        }
    }

    static {
        System.loadLibrary("native-lib");
        f11616h = kotlin.c.b(new Function0<AppStateObserver>() { // from class: com.cupidapp.live.AppApplication$Companion$appStateObserver$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AppStateObserver invoke() {
                return new AppStateObserver();
            }
        });
        f11617i = kotlin.c.b(new Function0<com.cupidapp.live.base.activity.a>() { // from class: com.cupidapp.live.AppApplication$Companion$activityLifecycleCallbacks$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.cupidapp.live.base.activity.a invoke() {
                return new com.cupidapp.live.base.activity.a();
            }
        });
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(@Nullable Context context) {
        super.attachBaseContext(context);
        if (h.r(this)) {
            i3.a.f49713a.g();
        } else {
            i3.a.f49713a.c();
        }
        com.cupidapp.live.base.web.helper.c.f13100a.c(this);
    }

    public final void g() {
        com.cupidapp.live.liveshow.entity.j.f14922f.d();
        h(this);
        registerActivityLifecycleCallbacks(f11612d.d());
        SVGAParser.f37905h.b().x(this);
        ub.d.f54013c.c(true);
        com.cupidapp.live.liveshow.view.music.c.f15798a.f(this);
        g.f52734a.E().d(new FKExpressAdLocalModel(0L, 0L, 3, null));
    }

    public final void h(@NotNull Context context) {
        s.i(context, "context");
        if (g.f52734a.Q3()) {
            k().registerApp(context, new AuthInfo(context, "4221720766", "https://3w.zhongyingleyou.com/connect/oauth/code", "email,direct_messages_read,direct_messages_write,friendships_groups_read,friendships_groups_write,statuses_to_me_read,follow_app_official_microblog,invitation_write"), new c());
            com.cupidapp.live.base.router.f.f12125b.a(context);
            DigitalAllianceHelper.f12175a.c();
            com.cupidapp.live.base.safe.c.f12183a.f();
        }
    }

    public final void i() {
        f11612d.d().b();
    }

    @NotNull
    public final Handler j() {
        return this.f11618b;
    }

    @NotNull
    public final IWBAPI k() {
        IWBAPI weiboApp = l();
        s.h(weiboApp, "weiboApp");
        return weiboApp;
    }

    public final IWBAPI l() {
        return (IWBAPI) this.f11619c.getValue();
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        a aVar = f11612d;
        aVar.l(this);
        j.f12332a.e(false);
        String a10 = com.cupidapp.live.base.utils.c.a(this);
        p1.j.f52847a.a(this);
        aVar.i(this, a10, getPackageName());
        k4.b.p().q(this);
        new b().execute(this);
        ProcessLifecycleOwner.Companion.get().getLifecycle().addObserver(aVar.f());
        com.cupidapp.live.base.web.helper.a.f13097a.b(this);
        RxFFmpegInvoke.getInstance().setDebug(false);
        RxJavaErrorHandlerHelper.f12006a.b();
        g2.a.f49362a.c(this);
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        ImageLoaderUtil.f11832a.a(this);
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        super.onTrimMemory(i10);
        if (i10 == 20) {
            ImageLoaderUtil.f11832a.a(this);
        }
        ImageLoaderUtil.f11832a.k(this, i10);
    }
}
