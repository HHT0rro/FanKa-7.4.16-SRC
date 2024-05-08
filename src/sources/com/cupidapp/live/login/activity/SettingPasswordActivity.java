package com.cupidapp.live.login.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.g;
import com.cupidapp.live.base.utils.q0;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.t;
import z0.y;

/* compiled from: SettingPasswordActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SettingPasswordActivity extends FKBaseActivity {

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public static final a f16113s = new a(null);

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16115r = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final com.cupidapp.live.login.helper.f f16114q = new com.cupidapp.live.login.helper.f(this, null, 2, null);

    /* compiled from: SettingPasswordActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context) {
            s.i(context, "context");
            Intent intent = new Intent(context, (Class<?>) SettingPasswordActivity.class);
            intent.putExtra("LogoutKey", true);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f16115r;
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

    public final void n1(String str) {
        if (str == null) {
            return;
        }
        e1();
        ((TextView) j1(R$id.saveTextView)).setText(getString(R$string.save_ing));
        Disposable disposed = NetworkClient.f11868a.N().k0(q0.e(str)).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.login.activity.SettingPasswordActivity$savePassword$$inlined$handle$1
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
                SettingPasswordActivity.this.V0();
                SettingPasswordActivity.this.o1();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.login.activity.SettingPasswordActivity$savePassword$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                SettingPasswordActivity.this.V0();
                ((TextView) SettingPasswordActivity.this.j1(R$id.saveTextView)).setText(SettingPasswordActivity.this.getString(R$string.save));
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void o1() {
        z3.e.f54837a.B();
        FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, this, false, 2, null).D(R$string.setting_success), R$string.setting_success_tip, 0, 2, null), 0, null, new Function0<p>() { // from class: com.cupidapp.live.login.activity.SettingPasswordActivity$showSettingPasswordGuide$1
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
                SettingPasswordActivity.this.V0();
                SettingPasswordActivity.this.finish();
            }
        }, 3, null), null, 1, null);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_setting_password);
        j1.c.b(j1.c.f50228a, SensorPosition.LogoutSettingPassword, null, null, 6, null);
        z3.e.f54837a.A();
        getWindow().setSoftInputMode(4);
        FKTitleBarLayout onCreate$lambda$0 = (FKTitleBarLayout) j1(R$id.setPasswordTitleBarLayout);
        onCreate$lambda$0.setLeftImageVisible(true);
        onCreate$lambda$0.setLeftImageClickEvent(new Function1<View, p>() { // from class: com.cupidapp.live.login.activity.SettingPasswordActivity$onCreate$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                SettingPasswordActivity.this.V0();
                SettingPasswordActivity.this.finish();
            }
        });
        s.h(onCreate$lambda$0, "onCreate$lambda$0");
        FKTitleBarLayout.setSingleTitle$default(onCreate$lambda$0, onCreate$lambda$0.getResources().getString(R$string.set_password), null, 2, null);
        ((TextView) j1(R$id.noPasswordGuideTextView)).setVisibility(getIntent().getBooleanExtra("LogoutKey", false) ? 0 : 8);
        int i10 = R$id.passwordItemLayout;
        View j12 = j1(i10);
        int i11 = R$id.titleTextView;
        ((TextView) j12.findViewById(i11)).setText(getString(R$string.password));
        int i12 = R$id.contentEditText;
        ((EditText) j12.findViewById(i12)).setHint(getString(R$string.edit_password));
        ((EditText) j12.findViewById(i12)).setInputType(129);
        int i13 = R$id.confirmPasswordLayout;
        View j13 = j1(i13);
        ((TextView) j13.findViewById(i11)).setText(getString(R$string.confirm_password));
        ((EditText) j13.findViewById(i12)).setHint(getString(R$string.edit_password_again));
        ((EditText) j13.findViewById(i12)).setInputType(129);
        new g(kotlin.collections.s.o((EditText) j1(i13).findViewById(i12), (EditText) j1(i10).findViewById(i12)), new Function1<Boolean, p>() { // from class: com.cupidapp.live.login.activity.SettingPasswordActivity$onCreate$4$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return p.f51048a;
            }

            public final void invoke(boolean z10) {
                SettingPasswordActivity settingPasswordActivity = SettingPasswordActivity.this;
                int i14 = R$id.saveTextView;
                ((TextView) settingPasswordActivity.j1(i14)).setAlpha(z10 ? 1.0f : 0.5f);
                ((TextView) SettingPasswordActivity.this.j1(i14)).setEnabled(z10);
            }
        });
        int i14 = R$id.saveTextView;
        ((TextView) j1(i14)).setEnabled(false);
        TextView saveTextView = (TextView) j1(i14);
        s.h(saveTextView, "saveTextView");
        y.a(saveTextView);
        TextView saveTextView2 = (TextView) j1(i14);
        s.h(saveTextView2, "saveTextView");
        y.d(saveTextView2, new Function1<View, p>() { // from class: com.cupidapp.live.login.activity.SettingPasswordActivity$onCreate$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                z3.e.f54837a.z();
                SettingPasswordActivity settingPasswordActivity = SettingPasswordActivity.this;
                int i15 = R$id.passwordItemLayout;
                View j14 = settingPasswordActivity.j1(i15);
                int i16 = R$id.contentEditText;
                h.p(settingPasswordActivity, (EditText) j14.findViewById(i16));
                final String obj = ((EditText) SettingPasswordActivity.this.j1(R$id.confirmPasswordLayout).findViewById(i16)).getText().toString();
                final String obj2 = ((EditText) SettingPasswordActivity.this.j1(i15).findViewById(i16)).getText().toString();
                final SettingPasswordActivity settingPasswordActivity2 = SettingPasswordActivity.this;
                t.h(obj, new Function2<Boolean, Integer, p>() { // from class: com.cupidapp.live.login.activity.SettingPasswordActivity$onCreate$5.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: invoke */
                    public /* bridge */ /* synthetic */ p mo1743invoke(Boolean bool, Integer num) {
                        invoke(bool.booleanValue(), num);
                        return p.f51048a;
                    }

                    public final void invoke(boolean z10, @Nullable Integer num) {
                        com.cupidapp.live.login.helper.f fVar;
                        if (z10) {
                            SettingPasswordActivity settingPasswordActivity3 = SettingPasswordActivity.this;
                            fVar = settingPasswordActivity3.f16114q;
                            settingPasswordActivity3.n1(fVar.b(obj, obj2));
                        } else if (num != null) {
                            SettingPasswordActivity settingPasswordActivity4 = SettingPasswordActivity.this;
                            num.intValue();
                            com.cupidapp.live.base.view.h.f12779a.r(settingPasswordActivity4, num.intValue());
                        }
                    }
                });
            }
        });
    }
}
