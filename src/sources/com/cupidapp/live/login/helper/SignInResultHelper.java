package com.cupidapp.live.login.helper;

import com.cupidapp.live.MainActivity;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.grpc.GrpcIM;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.RequestErrorCode;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.safe.DigitalAllianceHelper;
import com.cupidapp.live.base.sensorslog.SensorsLogAccount;
import com.cupidapp.live.base.utils.r0;
import com.cupidapp.live.liveshow.entity.FKLiveUtil;
import com.cupidapp.live.login.activity.CompleteInfoAgeActivity;
import com.cupidapp.live.login.activity.CompleteInfoAvatarActivity;
import com.cupidapp.live.login.activity.CompleteInfoNickNameActivity;
import com.cupidapp.live.login.model.AuthResult;
import com.cupidapp.live.login.viewmodel.CompleteInfoViewModel;
import com.cupidapp.live.profile.model.UserRankModel;
import com.cupidapp.live.setting.helper.MultiAccountUserIdManager;
import com.cupidapp.live.tourist.activity.AbnormalModeType;
import com.cupidapp.live.tourist.activity.FKTouristMainActivity;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import j1.n;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SignInResultHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SignInResultHelper {

    /* renamed from: a */
    @Nullable
    public Function0<p> f16148a;

    /* compiled from: SignInResultHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f16149a;

        static {
            int[] iArr = new int[LoginMethod.values().length];
            try {
                iArr[LoginMethod.PhoneNumberAndPasswordLogin.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoginMethod.VerificationCodeLogin.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoginMethod.OneClickLogin.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LoginMethod.UserNameAndPassWordLogin.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LoginMethod.CONVENIENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f16149a = iArr;
        }
    }

    public static /* synthetic */ void g(SignInResultHelper signInResultHelper, FKBaseActivity fKBaseActivity, Observable observable, LoginMethod loginMethod, String str, Function0 function0, Function1 function1, int i10, Object obj) {
        signInResultHelper.f(fKBaseActivity, observable, loginMethod, (i10 & 8) != 0 ? null : str, (i10 & 16) != 0 ? null : function0, (i10 & 32) != 0 ? null : function1);
    }

    public final void b(FKBaseActivity fKBaseActivity) {
        Disposable disposed = NetworkClient.f11868a.J().c().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.login.helper.SignInResultHelper$connectCheckAuth$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, fKBaseActivity)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (fKBaseActivity != null) {
                fKBaseActivity.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    public final String c(LoginMethod loginMethod) {
        String method;
        return (loginMethod == null || (method = loginMethod.getMethod()) == null) ? LoginMethod.VerificationCodeLogin.getMethod() : method;
    }

    public final void d(FKBaseActivity fKBaseActivity) {
        Disposable disposed = NetworkClient.f11868a.M().a().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<UserRankModel, p>() { // from class: com.cupidapp.live.login.helper.SignInResultHelper$getUserRank$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(UserRankModel userRankModel) {
                m2669invoke(userRankModel);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2669invoke(UserRankModel userRankModel) {
                UserRankModel userRankModel2 = userRankModel;
                n.f50241a.b(userRankModel2);
                p1.g.f52734a.F1().d(userRankModel2);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, fKBaseActivity)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (fKBaseActivity != null) {
                fKBaseActivity.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    @Nullable
    public final Function0<p> e() {
        return this.f16148a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f(@Nullable FKBaseActivity fKBaseActivity, @NotNull Observable<Result<AuthResult>> resultObservable, @Nullable final LoginMethod loginMethod, @Nullable final String str, @Nullable Function0<p> function0, @Nullable final Function1<? super Boolean, p> function1) {
        s.i(resultObservable, "resultObservable");
        final FKBaseActivity fKBaseActivity2 = (FKBaseActivity) new WeakReference(fKBaseActivity).get();
        final Map h10 = i0.h(kotlin.f.a(Integer.valueOf(RequestErrorCode.InvalidMobileVerifyCode.getValue()), new Function1<String, p>() { // from class: com.cupidapp.live.login.helper.SignInResultHelper$handleAuthResult$errorCodeInterceptor$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(String str2) {
                invoke2(str2);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable String str2) {
                Function0<p> e2 = SignInResultHelper.this.e();
                if (e2 != null) {
                    e2.invoke();
                }
            }
        }));
        if (function0 != null) {
            function0.invoke();
        } else if (fKBaseActivity2 != null) {
            fKBaseActivity2.e1();
        }
        Disposable disposed = resultObservable.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<AuthResult, p>() { // from class: com.cupidapp.live.login.helper.SignInResultHelper$handleAuthResult$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(AuthResult authResult) {
                m2670invoke(authResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2670invoke(AuthResult authResult) {
                AuthResult authResult2 = authResult;
                if (LoginMethod.this == LoginMethod.OneClickLogin) {
                    SensorsLogAccount.f12205a.c(authResult2.getAccountSign(), authResult2.getLoginType());
                }
                this.i(fKBaseActivity2, authResult2, LoginMethod.this, null);
                this.k(LoginMethod.this, authResult2);
                Function1 function12 = function1;
                if (function12 == null) {
                    FKBaseActivity fKBaseActivity3 = fKBaseActivity2;
                    if (fKBaseActivity3 != null) {
                        fKBaseActivity3.V0();
                    }
                } else {
                    function12.invoke(Boolean.FALSE);
                }
                if (s.d(authResult2.isRegist(), Boolean.TRUE)) {
                    z3.e.f54837a.H();
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.login.helper.SignInResultHelper$handleAuthResult$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:24:0x0041, code lost:
            
                if (r1.intValue() != r2) goto L28;
             */
            @Override // kotlin.jvm.functions.Function1
            @org.jetbrains.annotations.NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Boolean invoke(@org.jetbrains.annotations.NotNull java.lang.Throwable r11) {
                /*
                    r10 = this;
                    java.lang.String r0 = "t"
                    kotlin.jvm.internal.s.i(r11, r0)
                    kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.p> r0 = r1
                    if (r0 != 0) goto L11
                    com.cupidapp.live.base.activity.FKBaseActivity r0 = r2
                    if (r0 == 0) goto L16
                    r0.V0()
                    goto L16
                L11:
                    java.lang.Boolean r1 = java.lang.Boolean.TRUE
                    r0.invoke(r1)
                L16:
                    boolean r0 = r11 instanceof com.cupidapp.live.base.network.ResultException
                    if (r0 == 0) goto L6b
                    r0 = r11
                    com.cupidapp.live.base.network.ResultException r0 = (com.cupidapp.live.base.network.ResultException) r0
                    java.lang.Integer r1 = r0.getErrorCode()
                    com.cupidapp.live.base.network.RequestErrorCode r2 = com.cupidapp.live.base.network.RequestErrorCode.AuthFail
                    int r2 = r2.getValue()
                    if (r1 != 0) goto L2a
                    goto L30
                L2a:
                    int r1 = r1.intValue()
                    if (r1 == r2) goto L43
                L30:
                    java.lang.Integer r1 = r0.getErrorCode()
                    com.cupidapp.live.base.network.RequestErrorCode r2 = com.cupidapp.live.base.network.RequestErrorCode.PasswordError
                    int r2 = r2.getValue()
                    if (r1 != 0) goto L3d
                    goto L60
                L3d:
                    int r1 = r1.intValue()
                    if (r1 != r2) goto L60
                L43:
                    com.cupidapp.live.login.helper.LoginMethod r1 = r3
                    com.cupidapp.live.login.helper.LoginMethod r2 = com.cupidapp.live.login.helper.LoginMethod.UserNameAndPassWordLogin
                    if (r1 != r2) goto L50
                    com.cupidapp.live.base.sensorslog.SensorsLogAccount r1 = com.cupidapp.live.base.sensorslog.SensorsLogAccount.f12205a
                    java.lang.String r3 = r4
                    r1.f(r3)
                L50:
                    com.cupidapp.live.login.helper.LoginMethod r1 = r3
                    if (r1 != r2) goto L57
                    java.lang.String r1 = "name"
                    goto L59
                L57:
                    java.lang.String r1 = "phone"
                L59:
                    z3.e r2 = z3.e.f54837a
                    java.lang.String r3 = r4
                    r2.r(r1, r3)
                L60:
                    z3.e r1 = z3.e.f54837a
                    java.lang.String r0 = r0.getErrorMessage()
                    com.cupidapp.live.login.helper.LoginMethod r2 = r3
                    r1.d(r0, r2)
                L6b:
                    com.cupidapp.live.base.network.j r3 = com.cupidapp.live.base.network.j.f12008a
                    com.cupidapp.live.base.activity.FKBaseActivity r5 = r2
                    java.util.Map<java.lang.Integer, kotlin.jvm.functions.Function1<java.lang.String, kotlin.p>> r6 = r5
                    r7 = 0
                    r8 = 8
                    r9 = 0
                    r4 = r11
                    com.cupidapp.live.base.network.j.f(r3, r4, r5, r6, r7, r8, r9)
                    java.lang.Boolean r11 = java.lang.Boolean.TRUE
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.login.helper.SignInResultHelper$handleAuthResult$2.invoke(java.lang.Throwable):java.lang.Boolean");
            }
        }, fKBaseActivity2)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (fKBaseActivity2 != null) {
                fKBaseActivity2.H(disposed);
            }
        }
        s.h(disposed, "disposed");
    }

    public final void h(FKBaseActivity fKBaseActivity, AuthResult authResult, LoginMethod loginMethod, com.cupidapp.live.setting.helper.a aVar) {
        w0.a.f54093a.b();
        FKLiveUtil.f14913a.h();
        DigitalAllianceHelper.f12175a.c();
        if (authResult.getUser().getProfileIncomplete()) {
            CompleteInfoViewModel.Companion companion = CompleteInfoViewModel.Companion;
            companion.b(authResult.getAccountSign());
            companion.c(loginMethod);
            j(fKBaseActivity);
            String name = authResult.getUser().getName();
            if (name == null || name.length() == 0) {
                CompleteInfoNickNameActivity.f16082s.a(fKBaseActivity);
                return;
            }
            String birthday = authResult.getUser().getBirthday();
            if (birthday != null && birthday.length() != 0) {
                r1 = false;
            }
            if (r1) {
                CompleteInfoAgeActivity.f16060v.a(fKBaseActivity, false);
                return;
            } else {
                CompleteInfoAvatarActivity.f16069w.a(fKBaseActivity, false);
                return;
            }
        }
        if (fKBaseActivity != null) {
            z0.h.q(fKBaseActivity, null, 1, null);
        }
        b(fKBaseActivity);
        j(fKBaseActivity);
        com.cupidapp.live.base.view.dialog.h.f12743a.b();
        if (authResult.isTeenager()) {
            FKTouristMainActivity.f18670x.a(fKBaseActivity, AbnormalModeType.TeenModeType);
        } else {
            MainActivity.F.f(fKBaseActivity, aVar != null ? aVar.a() : null, aVar != null ? aVar.b() : null, true, aVar != null && aVar.c() ? Integer.valueOf(MainActivity.MainPagerType.Setting.getPageIndex()) : null, aVar != null ? Boolean.valueOf(aVar.d()) : null);
        }
        if (fKBaseActivity != null) {
            fKBaseActivity.finish();
        }
    }

    public final void i(@Nullable FKBaseActivity fKBaseActivity, @NotNull AuthResult result, @Nullable LoginMethod loginMethod, @Nullable com.cupidapp.live.setting.helper.a aVar) {
        s.i(result, "result");
        p1.h.f52842c.a().b();
        u0.a.f53817a.a();
        GrpcIM.INSTANCE.disconnect();
        m(result);
        MultiAccountUserIdManager.f18178a.a(result.getUser().userId());
        j1.a.f50226a.b();
        p1.g gVar = p1.g.f52734a;
        gVar.M1(false);
        d(fKBaseActivity);
        l(fKBaseActivity);
        h(fKBaseActivity, result, loginMethod, aVar);
        gVar.w0().d(Boolean.TRUE);
        com.cupidapp.live.base.safe.c.f12183a.g(1);
    }

    public final void j(FKBaseActivity fKBaseActivity) {
        Disposable disposed = NetworkClient.f11868a.M().b().flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.login.helper.SignInResultHelper$reportActive$$inlined$handle$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.login.helper.SignInResultHelper$reportActive$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                return Boolean.TRUE;
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

    public final void k(LoginMethod loginMethod, AuthResult authResult) {
        SensorsLogAccount.LoginRegisterLoginSuccessType loginRegisterLoginSuccessType;
        String c4 = c(loginMethod);
        int i10 = loginMethod == null ? -1 : a.f16149a[loginMethod.ordinal()];
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            loginRegisterLoginSuccessType = SensorsLogAccount.LoginRegisterLoginSuccessType.Phone;
        } else if (i10 != 4 && i10 != 5) {
            loginRegisterLoginSuccessType = SensorsLogAccount.LoginRegisterLoginSuccessType.Phone;
        } else {
            loginRegisterLoginSuccessType = SensorsLogAccount.LoginRegisterLoginSuccessType.Account;
        }
        SensorsLogAccount.f12205a.b(loginRegisterLoginSuccessType, authResult.getUser().getName(), authResult.getAccountSign(), c4);
    }

    public final void l(FKBaseActivity fKBaseActivity) {
        if (fKBaseActivity != null) {
            Disposable disposed = NetworkClient.f11868a.F().h(r0.f12373a.a(fKBaseActivity)).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.login.helper.SignInResultHelper$reportPushStatus$lambda$5$$inlined$handle$default$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Object obj) {
                    invoke2(obj);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object obj) {
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, fKBaseActivity)));
            if (disposed != null) {
                s.h(disposed, "disposed");
                fKBaseActivity.H(disposed);
            }
            s.h(disposed, "disposed");
        }
    }

    public final void m(AuthResult authResult) {
        p1.g gVar = p1.g.f52734a;
        gVar.P3(authResult.getUser());
        gVar.K3(authResult.getT());
        gVar.I3(Boolean.valueOf(authResult.isTeenager()));
    }

    public final void n(@Nullable Function0<p> function0) {
        this.f16148a = function0;
    }
}
