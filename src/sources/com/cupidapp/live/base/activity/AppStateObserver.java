package com.cupidapp.live.base.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$id;
import com.cupidapp.live.base.grpc.GrpcIM;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.utils.LocationRefreshTimeInterval;
import com.cupidapp.live.base.utils.LocationUtils;
import com.cupidapp.live.base.utils.r0;
import com.cupidapp.live.base.web.FKWebView;
import com.cupidapp.live.maskparty.activity.MaskPartyChatActivity;
import com.cupidapp.live.maskparty.fragment.BaseMaskPartyChatFragment;
import com.cupidapp.live.maskparty.helper.MaskPartyPromptHelper;
import com.cupidapp.live.maskparty.model.MaskPartyChatRoomModel;
import com.cupidapp.live.maskparty.model.MaskPartyHangUpMessageModel;
import com.cupidapp.live.setting.model.AppIcon;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;

/* compiled from: AppStateObserver.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AppStateObserver implements DefaultLifecycleObserver {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f11748b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public static boolean f11749c;

    /* compiled from: AppStateObserver.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final void j(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void k(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void m(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void o(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void e() {
        ConstantsResult q10 = p1.g.f52734a.q();
        String customAppIcon = q10 != null ? q10.getCustomAppIcon() : null;
        if (customAppIcon == null || customAppIcon.length() == 0) {
            return;
        }
        AppApplication.a aVar = AppApplication.f11612d;
        PackageManager packageManager = aVar.h().getPackageManager();
        String packageName = aVar.h().getPackageName();
        if (packageManager.getComponentEnabledSetting(new ComponentName(aVar.h(), packageName + "." + AppIcon.valueOf(customAppIcon).getActivityAliasName())) == 1) {
            return;
        }
        for (AppIcon appIcon : AppIcon.values()) {
            if (s.d(appIcon.name(), customAppIcon)) {
                packageManager.setComponentEnabledSetting(new ComponentName(AppApplication.f11612d.h(), packageName + "." + appIcon.getActivityAliasName()), 1, 1);
            } else {
                packageManager.setComponentEnabledSetting(new ComponentName(AppApplication.f11612d.h(), packageName + "." + appIcon.getActivityAliasName()), 2, 1);
            }
        }
    }

    public final void f(boolean z10) {
        MaskPartyChatRoomModel a10;
        WeakReference<Activity> a11 = com.cupidapp.live.base.activity.a.f11763c.a();
        final Activity activity = a11 != null ? a11.get() : null;
        com.cupidapp.live.base.utils.j.f12332a.a("AppStateObserver", "back: " + z10 + " currentActivity: " + ((Object) activity));
        if (!(activity instanceof MaskPartyChatActivity) || (a10 = BaseMaskPartyChatFragment.f16269l.a()) == null) {
            return;
        }
        Observable<Result<MaskPartyHangUpMessageModel>> t2 = NetworkClient.f11868a.z().t(a10.getRoomId(), z10 ? 1 : 2);
        com.cupidapp.live.base.network.g gVar = activity instanceof com.cupidapp.live.base.network.g ? (com.cupidapp.live.base.network.g) activity : null;
        Disposable disposed = t2.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<MaskPartyHangUpMessageModel, p>() { // from class: com.cupidapp.live.base.activity.AppStateObserver$maskPartyChatReport$lambda$7$$inlined$handleByContext$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(MaskPartyHangUpMessageModel maskPartyHangUpMessageModel) {
                m2455invoke(maskPartyHangUpMessageModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2455invoke(MaskPartyHangUpMessageModel maskPartyHangUpMessageModel) {
                if (maskPartyHangUpMessageModel.getPopupType() == 1) {
                    MaskPartyPromptHelper maskPartyPromptHelper = MaskPartyPromptHelper.f16347a;
                    final Activity activity2 = activity;
                    maskPartyPromptHelper.b(activity2, new Function0<p>() { // from class: com.cupidapp.live.base.activity.AppStateObserver$maskPartyChatReport$1$1$1
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
                            ((MaskPartyChatActivity) activity2).finish();
                        }
                    });
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

    public final void g(boolean z10) {
        Activity activity;
        WeakReference<Activity> a10 = com.cupidapp.live.base.activity.a.f11763c.a();
        FKWebView fKWebView = (a10 == null || (activity = a10.get()) == null) ? null : (FKWebView) activity.findViewById(R$id.appWebView);
        if (fKWebView == null) {
            return;
        }
        com.cupidapp.live.base.web.bridge.b.f13062a.e(fKWebView, z10);
    }

    public final void h() {
        if (com.cupidapp.live.login.helper.e.f16161a.b()) {
            p1.g.f52734a.e2(true);
        }
    }

    public final void i() {
        if (p1.g.f52734a.Q3() && com.cupidapp.live.login.helper.e.f16161a.a()) {
            Observable<Result<Object>> b4 = NetworkClient.f11868a.M().b();
            final AppStateObserver$reportActive$1 appStateObserver$reportActive$1 = new Function1<Result<? extends Object>, p>() { // from class: com.cupidapp.live.base.activity.AppStateObserver$reportActive$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Result<? extends Object> result) {
                    invoke2(result);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Result<? extends Object> result) {
                }
            };
            Consumer<? super Result<Object>> consumer = new Consumer() { // from class: com.cupidapp.live.base.activity.c
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    AppStateObserver.j(Function1.this, obj);
                }
            };
            final AppStateObserver$reportActive$2 appStateObserver$reportActive$2 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.base.activity.AppStateObserver$reportActive$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                    invoke2(th);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                }
            };
            b4.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.base.activity.f
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    AppStateObserver.k(Function1.this, obj);
                }
            });
        }
    }

    public final void l() {
        Context c4;
        if (!com.cupidapp.live.login.helper.e.f16161a.a() || (c4 = AppApplication.f11612d.c()) == null) {
            return;
        }
        Observable<Result<Object>> h10 = NetworkClient.f11868a.F().h(r0.f12373a.a(c4));
        final AppStateObserver$reportPushStatus$1$1 appStateObserver$reportPushStatus$1$1 = new Function1<Result<? extends Object>, p>() { // from class: com.cupidapp.live.base.activity.AppStateObserver$reportPushStatus$1$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Result<? extends Object> result) {
                invoke2(result);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends Object> result) {
            }
        };
        Consumer<? super Result<Object>> consumer = new Consumer() { // from class: com.cupidapp.live.base.activity.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AppStateObserver.m(Function1.this, obj);
            }
        };
        final AppStateObserver$reportPushStatus$1$2 appStateObserver$reportPushStatus$1$2 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.base.activity.AppStateObserver$reportPushStatus$1$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                invoke2(th);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
            }
        };
        h10.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.base.activity.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                AppStateObserver.o(Function1.this, obj);
            }
        });
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.a(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.b(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.c(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.d(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(@NotNull LifecycleOwner owner) {
        s.i(owner, "owner");
        com.cupidapp.live.base.utils.j.f12332a.a("AppStateObserver", "应用进入前台");
        AppApplication.f11612d.j(true);
        GrpcIM.INSTANCE.connect();
        i();
        l();
        if (f11749c) {
            EventBus.c().o(new AppEnterForegroundEvent());
        } else {
            f11749c = true;
        }
        p();
        h();
        EventBus.c().o(new HandleClipboardJumpEvent());
        g(true);
        f(false);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(@NotNull LifecycleOwner owner) {
        s.i(owner, "owner");
        com.cupidapp.live.base.utils.j.f12332a.a("AppStateObserver", "应用进入后台");
        com.cupidapp.live.base.utils.f.f12314a.a();
        i3.a.f49713a.c();
        com.cupidapp.live.feed.helper.h.f14329a.b();
        AppApplication.f11612d.j(false);
        p1.g.f52734a.R2(true);
        FKBaseActivity.f11750o.d(System.currentTimeMillis());
        g(false);
        e();
        f(true);
    }

    public final void p() {
        LocationUtils.Companion companion = LocationUtils.f12270h;
        if (companion.a().q(LocationRefreshTimeInterval.ReturnFromBackgroundInterval.getInterval())) {
            LocationUtils.o(companion.a(), AppApplication.f11612d.c(), null, null, null, 14, null);
        }
    }
}
