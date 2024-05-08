package com.cupidapp.live.setting.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.FKItemLayout;
import com.cupidapp.live.base.view.FKItemSwitchLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.main.model.PassportModel;
import com.cupidapp.live.main.model.UserAccountResult;
import com.cupidapp.live.setting.activity.BindPhoneActivity;
import com.cupidapp.live.setting.activity.OrderManagementActivity;
import com.cupidapp.live.setting.model.OrderManagementResult;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AccountSecurityActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AccountSecurityActivity extends FKBaseActivity {

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public static final a f17920s = new a(null);

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17922r = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public ArrayList<OrderManagementResult> f17921q = new ArrayList<>();

    /* compiled from: AccountSecurityActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context) {
            kotlin.jvm.internal.s.i(context, "context");
            context.startActivity(new Intent(context, (Class<?>) AccountSecurityActivity.class));
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f17922r;
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

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_account_security);
        j1.c.b(j1.c.f50228a, SensorPosition.AccountSecurity, null, null, 6, null);
        r1();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        w1();
    }

    public final void r1() {
        ((FKTitleBarLayout) j1(R$id.accountSettingTitleLayout)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.AccountSecurityActivity$bindClickEvent$1
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
                AccountSecurityActivity.this.onBackPressed();
            }
        });
        FKItemLayout realNameVerifiedLayout = (FKItemLayout) j1(R$id.realNameVerifiedLayout);
        kotlin.jvm.internal.s.h(realNameVerifiedLayout, "realNameVerifiedLayout");
        z0.y.d(realNameVerifiedLayout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.AccountSecurityActivity$bindClickEvent$2
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
                ConstantsUrlModel urlModel;
                String urlAccountZhima;
                ConstantsResult q10 = p1.g.f52734a.q();
                if (q10 == null || (urlModel = q10.getUrlModel()) == null || (urlAccountZhima = urlModel.getUrlAccountZhima()) == null) {
                    return;
                }
                j.a.b(com.cupidapp.live.base.router.j.f12156c, AccountSecurityActivity.this, urlAccountZhima, null, 4, null);
            }
        });
        FKItemLayout orderManagementLayout = (FKItemLayout) j1(R$id.orderManagementLayout);
        kotlin.jvm.internal.s.h(orderManagementLayout, "orderManagementLayout");
        z0.y.d(orderManagementLayout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.AccountSecurityActivity$bindClickEvent$3
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
                ArrayList<OrderManagementResult> arrayList;
                OrderManagementActivity.a aVar = OrderManagementActivity.f17980r;
                AccountSecurityActivity accountSecurityActivity = AccountSecurityActivity.this;
                arrayList = accountSecurityActivity.f17921q;
                aVar.a(accountSecurityActivity, arrayList);
            }
        });
        FKItemLayout cancelAccountItemLayout = (FKItemLayout) j1(R$id.cancelAccountItemLayout);
        kotlin.jvm.internal.s.h(cancelAccountItemLayout, "cancelAccountItemLayout");
        z0.y.d(cancelAccountItemLayout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.AccountSecurityActivity$bindClickEvent$4
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
                ConstantsUrlModel urlModel;
                String urlClose;
                ConstantsResult q10 = p1.g.f52734a.q();
                if (q10 == null || (urlModel = q10.getUrlModel()) == null || (urlClose = urlModel.getUrlClose()) == null) {
                    return;
                }
                j.a.b(com.cupidapp.live.base.router.j.f12156c, AccountSecurityActivity.this, urlClose, null, 4, null);
            }
        });
        ((FKItemSwitchLayout) j1(R$id.convenient_login_switch_layout)).setOnCheckedChangeListener(new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.AccountSecurityActivity$bindClickEvent$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                AccountSecurityActivity.this.y1(z10);
            }
        });
    }

    public final void s1(boolean z10) {
        ((LinearLayout) j1(R$id.limitedLayout)).setVisibility(z10 ? 0 : 8);
    }

    public final void t1(final PassportModel passportModel, boolean z10) {
        if (passportModel == null) {
            return;
        }
        if (z10) {
            ((FKItemLayout) j1(R$id.changePasswordLayout)).setFkValueText(getString(R$string.not_set));
        } else {
            ((FKItemLayout) j1(R$id.changePasswordLayout)).setFkValueText(getString(R$string.have_set));
        }
        FKItemLayout changePasswordLayout = (FKItemLayout) j1(R$id.changePasswordLayout);
        kotlin.jvm.internal.s.h(changePasswordLayout, "changePasswordLayout");
        z0.y.d(changePasswordLayout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.AccountSecurityActivity$checkPasswordNeedReset$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                if (!PassportModel.this.getBind()) {
                    com.cupidapp.live.base.view.h.f12779a.r(this, R$string.bind_phone_first);
                } else {
                    ChangePasswordActivity.f17936s.a(this, PassportModel.this.getName());
                }
            }
        });
    }

    public final void u1(boolean z10) {
        if (z10) {
            int i10 = R$id.realNameVerifiedLayout;
            ((FKItemLayout) j1(i10)).setFkValueText(getString(R$string.already_bind));
            ((FKItemLayout) j1(i10)).setFkValueTextColor(-5658199);
        } else {
            int i11 = R$id.realNameVerifiedLayout;
            ((FKItemLayout) j1(i11)).setFkValueText(getString(R$string.ali_not_certify));
            ((FKItemLayout) j1(i11)).setFkValueTextColor(-49088);
        }
    }

    public final void v1(PassportModel passportModel, final boolean z10) {
        if (passportModel == null) {
            return;
        }
        if (passportModel.getBind()) {
            int i10 = R$id.phoneNumberItemLayout;
            ((FKItemLayout) j1(i10)).setFkValueText(passportModel.getName());
            ((FKItemLayout) j1(i10)).setFkValueTextColor(-5658199);
            ((FKItemLayout) j1(i10)).setFkValueImage(null);
            FKItemLayout phoneNumberItemLayout = (FKItemLayout) j1(i10);
            kotlin.jvm.internal.s.h(phoneNumberItemLayout, "phoneNumberItemLayout");
            z0.y.d(phoneNumberItemLayout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.AccountSecurityActivity$configUserPhoneNumber$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    if (z10) {
                        com.cupidapp.live.base.view.h.f12779a.r(this, R$string.set_password_first);
                    } else {
                        CheckPasswordActivity.f17941r.a(this);
                    }
                }
            });
            return;
        }
        int i11 = R$id.phoneNumberItemLayout;
        ((FKItemLayout) j1(i11)).setFkValueText(getString(R$string.not_bind_china_phone));
        ((FKItemLayout) j1(i11)).setFkValueTextColor(-49088);
        ((FKItemLayout) j1(i11)).setFkValueImage(Integer.valueOf(R$mipmap.red_exclamation));
        FKItemLayout phoneNumberItemLayout2 = (FKItemLayout) j1(i11);
        kotlin.jvm.internal.s.h(phoneNumberItemLayout2, "phoneNumberItemLayout");
        z0.y.d(phoneNumberItemLayout2, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.AccountSecurityActivity$configUserPhoneNumber$2
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
                BindPhoneActivity.a.b(BindPhoneActivity.f17923t, AccountSecurityActivity.this, false, 2, null);
            }
        });
    }

    public final void w1() {
        Disposable disposed = NetworkClient.f11868a.N().F().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<UserAccountResult, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.AccountSecurityActivity$getUserAccountData$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(UserAccountResult userAccountResult) {
                m2778invoke(userAccountResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2778invoke(UserAccountResult userAccountResult) {
                ArrayList arrayList;
                ArrayList arrayList2;
                UserAccountResult userAccountResult2 = userAccountResult;
                arrayList = AccountSecurityActivity.this.f17921q;
                arrayList.clear();
                List<OrderManagementResult> subscriptionInfoList = userAccountResult2.getSubscriptionInfoList();
                if (subscriptionInfoList != null) {
                    arrayList2 = AccountSecurityActivity.this.f17921q;
                    arrayList2.addAll(subscriptionInfoList);
                }
                AccountSecurityActivity.this.s1(userAccountResult2.getAccountLimited());
                AccountSecurityActivity.this.v1(userAccountResult2.getPhone(), userAccountResult2.getPasswordNeedReset());
                AccountSecurityActivity.this.t1(userAccountResult2.getPhone(), userAccountResult2.getPasswordNeedReset());
                AccountSecurityActivity.this.u1(userAccountResult2.getZhimaAuthPass());
                ((FKItemSwitchLayout) AccountSecurityActivity.this.j1(R$id.convenient_login_switch_layout)).setChecked(userAccountResult2.getUseQuickLogin());
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void x1(final boolean z10) {
        Disposable disposed = NetworkClient.f11868a.N().R0(z10).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.AccountSecurityActivity$setQuickLogin$$inlined$handle$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Object obj) {
                invoke2(obj);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                ((FKItemSwitchLayout) AccountSecurityActivity.this.j1(R$id.convenient_login_switch_layout)).setChecked(z10);
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.activity.AccountSecurityActivity$setQuickLogin$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                ((FKItemSwitchLayout) AccountSecurityActivity.this.j1(R$id.convenient_login_switch_layout)).setChecked(!z10);
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void y1(boolean z10) {
        if (!z10) {
            ((FKItemSwitchLayout) j1(R$id.convenient_login_switch_layout)).setChecked(true);
            FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, this, false, 2, null), R$string.convenient_login_prompt, 0, 2, null), R$string.continue_close, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.activity.AccountSecurityActivity$showCloseQuickLoginDialog$1
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
                    AccountSecurityActivity.this.x1(false);
                }
            }, 2, null), 0, null, 3, null), null, 1, null);
        } else {
            x1(true);
        }
    }
}
