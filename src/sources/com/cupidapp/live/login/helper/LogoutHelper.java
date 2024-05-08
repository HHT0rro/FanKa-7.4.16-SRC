package com.cupidapp.live.login.helper;

import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.grpc.GrpcIM;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.sensorslog.MiniWindowCloseMethod;
import com.cupidapp.live.consult.helper.ConsultFloatWindowHelper;
import com.cupidapp.live.liveshow.miniwindow.FKLiveMiniWindow;
import com.cupidapp.live.login.layout.QuickLoginLayout;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.push.BindPushTokenUtilKt;
import com.cupidapp.live.setting.helper.MultiAccountUserIdManager;
import com.cupidapp.live.startup.activity.FKStartupActivity;
import com.cupidapp.live.startup.activity.StartupIsShowAdType;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LogoutHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class LogoutHelper {

    /* renamed from: a */
    public boolean f16137a;

    /* renamed from: b */
    @Nullable
    public Function0<p> f16138b;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f(LogoutHelper logoutHelper, FKBaseActivity fKBaseActivity, boolean z10, Function0 function0, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            function0 = null;
        }
        logoutHelper.e(fKBaseActivity, z10, function0);
    }

    public final void d(FKBaseActivity fKBaseActivity) {
        com.cupidapp.live.push.d.f17892a.a();
        p1.g gVar = p1.g.f52734a;
        gVar.h2(null);
        gVar.g2(null);
        ConsultFloatWindowHelper.f13810b.i();
        FKLiveMiniWindow.G(FKLiveMiniWindow.f15074m.a(), MiniWindowCloseMethod.CloseMethodOther, false, true, 2, null);
        QuickLoginLayout.f16187f.b(false);
        gVar.c();
        GrpcIM.INSTANCE.disconnect();
        j1.a aVar = j1.a.f50226a;
        User X = gVar.X();
        aVar.c(X != null ? X.userId() : null);
        u0.a.f53817a.a();
        p1.h.f52842c.a().b();
        NetworkClient.f11868a.f();
        if (this.f16138b == null) {
            com.cupidapp.live.base.view.dialog.h.f12743a.b();
        }
        Function0<p> function0 = this.f16138b;
        if (function0 != null) {
            function0.invoke();
        }
        if (this.f16137a) {
            return;
        }
        FKStartupActivity.f18306u.b(fKBaseActivity, StartupIsShowAdType.MustNotShowing, true);
    }

    public final void e(@NotNull FKBaseActivity activity, boolean z10, @Nullable Function0<p> function0) {
        s.i(activity, "activity");
        this.f16137a = z10;
        this.f16138b = function0;
        com.cupidapp.live.base.view.dialog.h.d(com.cupidapp.live.base.view.dialog.h.f12743a, null, true, 1, null);
        g(activity);
    }

    public final void g(final FKBaseActivity fKBaseActivity) {
        BindPushTokenUtilKt.h(fKBaseActivity, new Function0<p>() { // from class: com.cupidapp.live.login.helper.LogoutHelper$unBindHuaweiPush$1
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
                LogoutHelper.this.h(fKBaseActivity);
            }
        });
    }

    public final void h(final FKBaseActivity fKBaseActivity) {
        Disposable disposed = NetworkClient.f11868a.s().a().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.login.helper.LogoutHelper$unRegisterLBS$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                LogoutHelper.this.i(fKBaseActivity);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.login.helper.LogoutHelper$unRegisterLBS$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                LogoutHelper.this.i(fKBaseActivity);
                return Boolean.FALSE;
            }
        }, fKBaseActivity)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (fKBaseActivity != null) {
                fKBaseActivity.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    public final void i(final FKBaseActivity fKBaseActivity) {
        if (this.f16137a) {
            d(fKBaseActivity);
            return;
        }
        Disposable disposed = NetworkClient.f11868a.N().n0().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.login.helper.LogoutHelper$userUnAuth$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                MultiAccountUserIdManager multiAccountUserIdManager = MultiAccountUserIdManager.f18178a;
                User X = p1.g.f52734a.X();
                multiAccountUserIdManager.b(X != null ? X.userId() : null);
                LogoutHelper.this.d(fKBaseActivity);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.login.helper.LogoutHelper$userUnAuth$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                MultiAccountUserIdManager multiAccountUserIdManager = MultiAccountUserIdManager.f18178a;
                User X = p1.g.f52734a.X();
                multiAccountUserIdManager.b(X != null ? X.userId() : null);
                LogoutHelper.this.d(fKBaseActivity);
                return Boolean.FALSE;
            }
        }, fKBaseActivity)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (fKBaseActivity != null) {
                fKBaseActivity.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }
}
