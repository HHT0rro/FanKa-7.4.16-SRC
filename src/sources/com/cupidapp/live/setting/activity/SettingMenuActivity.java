package com.cupidapp.live.setting.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.extension.NetworkStateConstants;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.model.AndroidUpdateVersionModel;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.utils.n0;
import com.cupidapp.live.base.view.FKItemLayout;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.login.activity.SettingPasswordActivity;
import com.cupidapp.live.main.model.PassportModel;
import com.cupidapp.live.main.model.UserAccountResult;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.setting.helper.SwitchAccountHelper;
import com.cupidapp.live.update.FKUpdateNewVersionDownloader;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.k;

/* compiled from: SettingMenuActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SettingMenuActivity extends FKBaseActivity {

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public static final a f18012s = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public Boolean f18013q;

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18014r = new LinkedHashMap();

    /* compiled from: SettingMenuActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context) {
            if (context == null) {
                return;
            }
            context.startActivity(new Intent(context, (Class<?>) SettingMenuActivity.class));
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    public static final Long x1(SettingMenuActivity this$0) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        k.a aVar = z0.k.f54819a;
        File w3 = aVar.w(this$0);
        long a10 = w3 != null ? z0.l.a(w3) : 0L;
        File B = aVar.B(this$0);
        long a11 = B != null ? z0.l.a(B) : 0L;
        File o10 = aVar.o(this$0);
        return Long.valueOf(a10 + a11 + (o10 != null ? z0.l.a(o10) : 0L));
    }

    public static final void y1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void z1(Function1 tmp0, Object obj) {
        kotlin.jvm.internal.s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void A1() {
        Disposable disposed = NetworkClient.f11868a.N().F().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<UserAccountResult, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SettingMenuActivity$getUserAccountData$$inlined$handle$default$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(UserAccountResult userAccountResult) {
                m2796invoke(userAccountResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2796invoke(UserAccountResult userAccountResult) {
                UserAccountResult userAccountResult2 = userAccountResult;
                SettingMenuActivity.this.f18013q = Boolean.valueOf(userAccountResult2.getPasswordNeedReset());
                SettingMenuActivity.this.v1(userAccountResult2.getAccountLimited(), userAccountResult2.getPhone());
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void B1() {
        FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, this, false, 2, null), R$string.logout_confirm, 0, 2, null), 0, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SettingMenuActivity$showConfirmLogoutDialog$1
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
                SettingMenuActivity.this.t1();
            }
        }, 3, null), 0, null, 3, null), null, 1, null);
    }

    @Nullable
    public View m1(int i10) {
        Map<Integer, View> map = this.f18014r;
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
        setContentView(R$layout.activity_setting_menu);
        ((FKItemLayout) m1(R$id.aboutItemLayout)).setFkValueText("7.4.16");
        User X = p1.g.f52734a.X();
        if (X != null && X.isSsvip()) {
            FKItemLayout fKItemLayout = (FKItemLayout) m1(R$id.helpItemLayout);
            fKItemLayout.setFkTitleText(getString(R$string.exclusive_customer_service));
            fKItemLayout.setFkTitleRightImageRes(Integer.valueOf(R$mipmap.icon_rainbow_vip_logo));
        } else {
            FKItemLayout fKItemLayout2 = (FKItemLayout) m1(R$id.helpItemLayout);
            fKItemLayout2.setFkTitleText(getString(R$string.online_customer_service));
            fKItemLayout2.setFkTitleRightImageRes(0);
        }
        s1();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        A1();
    }

    public final void s1() {
        ((FKTitleBarLayout) m1(R$id.configSettingTitleLayout)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SettingMenuActivity$bindClickEvent$1
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
                SettingMenuActivity.this.onBackPressed();
            }
        });
        FKItemLayout accountSettingItemLayout = (FKItemLayout) m1(R$id.accountSettingItemLayout);
        kotlin.jvm.internal.s.h(accountSettingItemLayout, "accountSettingItemLayout");
        z0.y.d(accountSettingItemLayout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SettingMenuActivity$bindClickEvent$2
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
                AccountSecurityActivity.f17920s.a(SettingMenuActivity.this);
            }
        });
        FKItemLayout privacySettingItemLayout = (FKItemLayout) m1(R$id.privacySettingItemLayout);
        kotlin.jvm.internal.s.h(privacySettingItemLayout, "privacySettingItemLayout");
        z0.y.d(privacySettingItemLayout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SettingMenuActivity$bindClickEvent$3
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
                PrivacySettingActivity.B.a(SettingMenuActivity.this);
            }
        });
        FKItemLayout newPushSettingItemLayout = (FKItemLayout) m1(R$id.newPushSettingItemLayout);
        kotlin.jvm.internal.s.h(newPushSettingItemLayout, "newPushSettingItemLayout");
        z0.y.d(newPushSettingItemLayout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SettingMenuActivity$bindClickEvent$4
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
                NewPushSettingActivity.f17970t.a(SettingMenuActivity.this);
            }
        });
        FKItemLayout helpItemLayout = (FKItemLayout) m1(R$id.helpItemLayout);
        kotlin.jvm.internal.s.h(helpItemLayout, "helpItemLayout");
        z0.y.d(helpItemLayout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SettingMenuActivity$bindClickEvent$5
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
                ConstantsUrlModel urlModel2;
                p1.g gVar = p1.g.f52734a;
                User X = gVar.X();
                boolean z10 = X != null && X.isSsvip();
                String str = null;
                if (z10) {
                    ConstantsResult q10 = gVar.q();
                    if (q10 != null && (urlModel2 = q10.getUrlModel()) != null) {
                        str = urlModel2.getSsvipCustomerServiceUrl();
                    }
                } else {
                    ConstantsResult q11 = gVar.q();
                    if (q11 != null && (urlModel = q11.getUrlModel()) != null) {
                        str = urlModel.getUrlUserFeedBack();
                    }
                }
                j.a.b(com.cupidapp.live.base.router.j.f12156c, SettingMenuActivity.this, str, null, 4, null);
            }
        });
        FKItemLayout reportItemLayout = (FKItemLayout) m1(R$id.reportItemLayout);
        kotlin.jvm.internal.s.h(reportItemLayout, "reportItemLayout");
        z0.y.d(reportItemLayout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SettingMenuActivity$bindClickEvent$6
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
                j.a.b(com.cupidapp.live.base.router.j.f12156c, SettingMenuActivity.this, n0.f12353a.a(SensorPosition.MenuSetting), null, 4, null);
            }
        });
        FKItemLayout aboutItemLayout = (FKItemLayout) m1(R$id.aboutItemLayout);
        kotlin.jvm.internal.s.h(aboutItemLayout, "aboutItemLayout");
        z0.y.d(aboutItemLayout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SettingMenuActivity$bindClickEvent$7
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
                j.a aVar = com.cupidapp.live.base.router.j.f12156c;
                SettingMenuActivity settingMenuActivity = SettingMenuActivity.this;
                ConstantsResult q10 = p1.g.f52734a.q();
                j.a.b(aVar, settingMenuActivity, (q10 == null || (urlModel = q10.getUrlModel()) == null) ? null : urlModel.getUrlAboutNav(), null, 4, null);
            }
        });
        int i10 = R$id.switch_account_btn;
        ((TextView) m1(i10)).getPaint().setFakeBoldText(true);
        TextView switch_account_btn = (TextView) m1(i10);
        kotlin.jvm.internal.s.h(switch_account_btn, "switch_account_btn");
        z0.y.d(switch_account_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SettingMenuActivity$bindClickEvent$8
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
                SwitchAccountActivity.f18015t.a(SettingMenuActivity.this);
            }
        });
        int i11 = R$id.logoutText;
        TextView logoutText = (TextView) m1(i11);
        kotlin.jvm.internal.s.h(logoutText, "logoutText");
        z0.y.d(logoutText, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SettingMenuActivity$bindClickEvent$9
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
                if (z0.h.g(SettingMenuActivity.this) == NetworkStateConstants.DISCONNECT) {
                    com.cupidapp.live.base.view.h.f12779a.r(SettingMenuActivity.this, R$string.please_check_your_network);
                } else {
                    SettingMenuActivity.this.B1();
                }
            }
        });
        FKItemLayout cleanCacheLayout = (FKItemLayout) m1(R$id.cleanCacheLayout);
        kotlin.jvm.internal.s.h(cleanCacheLayout, "cleanCacheLayout");
        z0.y.d(cleanCacheLayout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SettingMenuActivity$bindClickEvent$10
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
                ((FKItemLayout) SettingMenuActivity.this.m1(R$id.cleanCacheLayout)).setFkValueText(SettingMenuActivity.this.getString(R$string.cleaning));
                SettingMenuActivity.this.u1();
                com.cupidapp.live.base.view.h.f12779a.c(SettingMenuActivity.this, R$string.clean_finished);
            }
        });
        FKItemLayout checkNewVersionLayout = (FKItemLayout) m1(R$id.checkNewVersionLayout);
        kotlin.jvm.internal.s.h(checkNewVersionLayout, "checkNewVersionLayout");
        z0.y.d(checkNewVersionLayout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SettingMenuActivity$bindClickEvent$11
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
                Observable<Result<ConstantsResult>> x10 = NetworkClient.f11868a.i().x();
                final SettingMenuActivity settingMenuActivity = SettingMenuActivity.this;
                Disposable disposed = x10.flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<ConstantsResult, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SettingMenuActivity$bindClickEvent$11$invoke$$inlined$handle$default$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ kotlin.p invoke(ConstantsResult constantsResult) {
                        m2795invoke(constantsResult);
                        return kotlin.p.f51048a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2795invoke(ConstantsResult constantsResult) {
                        ConstantsResult constantsResult2 = constantsResult;
                        AndroidUpdateVersionModel androidUpdateVersion = constantsResult2.getAndroidUpdateVersion();
                        if (androidUpdateVersion != null && androidUpdateVersion.getHasUpdateVersion()) {
                            FKUpdateNewVersionDownloader.f18715a.a(constantsResult2, SettingMenuActivity.this, false);
                        } else {
                            com.cupidapp.live.base.view.h.f12779a.c(SettingMenuActivity.this, R$string.no_new_version);
                        }
                    }
                }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(null, settingMenuActivity)));
                if (disposed != null) {
                    kotlin.jvm.internal.s.h(disposed, "disposed");
                    if (settingMenuActivity != null) {
                        settingMenuActivity.H(disposed);
                    }
                }
                kotlin.jvm.internal.s.h(disposed, "disposed");
            }
        });
        TextPaint paint = ((TextView) m1(i11)).getPaint();
        if (paint != null) {
            paint.setFakeBoldText(true);
        }
        FKItemLayout assistantSetting = (FKItemLayout) m1(R$id.assistantSetting);
        kotlin.jvm.internal.s.h(assistantSetting, "assistantSetting");
        z0.y.d(assistantSetting, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SettingMenuActivity$bindClickEvent$12
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
                SettingAssistantActivity.f18009s.a(SettingMenuActivity.this);
            }
        });
        FKItemLayout personal_setting_layout = (FKItemLayout) m1(R$id.personal_setting_layout);
        kotlin.jvm.internal.s.h(personal_setting_layout, "personal_setting_layout");
        z0.y.d(personal_setting_layout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SettingMenuActivity$bindClickEvent$13
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
                PersonalSettingActivity.f17987r.a(SettingMenuActivity.this);
            }
        });
        FKItemLayout post_limit = (FKItemLayout) m1(R$id.post_limit);
        kotlin.jvm.internal.s.h(post_limit, "post_limit");
        z0.y.d(post_limit, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SettingMenuActivity$bindClickEvent$14
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
                PostLimitSettingActivity.f17991u.a(SettingMenuActivity.this);
            }
        });
        FKItemLayout adolescent_mode_layout = (FKItemLayout) m1(R$id.adolescent_mode_layout);
        kotlin.jvm.internal.s.h(adolescent_mode_layout, "adolescent_mode_layout");
        z0.y.d(adolescent_mode_layout, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SettingMenuActivity$bindClickEvent$15
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
                j.a aVar = com.cupidapp.live.base.router.j.f12156c;
                SettingMenuActivity settingMenuActivity = SettingMenuActivity.this;
                ConstantsResult q10 = p1.g.f52734a.q();
                j.a.b(aVar, settingMenuActivity, (q10 == null || (urlModel = q10.getUrlModel()) == null) ? null : urlModel.getOpenTeenagerUrl(), null, 4, null);
                SensorsLogKeyButtonClick.MenuSetting.TeenMode.click();
            }
        });
    }

    public final void t1() {
        if (kotlin.jvm.internal.s.d(this.f18013q, Boolean.TRUE)) {
            SettingPasswordActivity.f16113s.a(this);
        } else {
            SwitchAccountHelper.f18181a.d(this);
        }
    }

    public final void u1() {
        z0.k.f54819a.c(this);
        w1();
    }

    public final void v1(boolean z10, PassportModel passportModel) {
        if (z10) {
            int i10 = R$id.accountSettingItemLayout;
            ((FKItemLayout) m1(i10)).setFkValueText(getString(R$string.account_limited));
            ((FKItemLayout) m1(i10)).setFkValueTextColor(-49088);
            ((FKItemLayout) m1(i10)).setFkValueImage(Integer.valueOf(R$mipmap.red_exclamation));
            return;
        }
        if (passportModel != null && passportModel.getBind()) {
            int i11 = R$id.accountSettingItemLayout;
            ((FKItemLayout) m1(i11)).setFkValueText(passportModel.getName());
            ((FKItemLayout) m1(i11)).setFkValueTextColor(-5658199);
            ((FKItemLayout) m1(i11)).setFkValueImage(null);
        }
    }

    public final void w1() {
        Observable observeOn = Observable.fromCallable(new Callable() { // from class: com.cupidapp.live.setting.activity.p
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Long x12;
                x12 = SettingMenuActivity.x1(SettingMenuActivity.this);
                return x12;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<Long, kotlin.p> function1 = new Function1<Long, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SettingMenuActivity$getFKCacheSize$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Long l10) {
                invoke2(l10);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long it) {
                FKItemLayout fKItemLayout = (FKItemLayout) SettingMenuActivity.this.m1(R$id.cleanCacheLayout);
                k.a aVar = z0.k.f54819a;
                kotlin.jvm.internal.s.h(it, "it");
                fKItemLayout.setFkValueText(aVar.n(it.longValue()));
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.setting.activity.n
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SettingMenuActivity.y1(Function1.this, obj);
            }
        };
        final SettingMenuActivity$getFKCacheSize$3 settingMenuActivity$getFKCacheSize$3 = new Function1<Throwable, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.SettingMenuActivity$getFKCacheSize$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Throwable th) {
                invoke2(th);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
            }
        };
        Disposable it = observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.setting.activity.o
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SettingMenuActivity.z1(Function1.this, obj);
            }
        });
        kotlin.jvm.internal.s.h(it, "it");
        H(it);
    }
}
