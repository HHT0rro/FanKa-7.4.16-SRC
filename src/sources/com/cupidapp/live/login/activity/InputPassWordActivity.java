package com.cupidapp.live.login.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.model.Result;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogAccount;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.utils.q0;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.login.activity.InputPassWordActivity;
import com.cupidapp.live.login.helper.ForRecoverPasswordEnum;
import com.cupidapp.live.login.helper.LoginMethod;
import com.cupidapp.live.login.helper.SignInResultHelper;
import com.cupidapp.live.login.layout.LoginNextButton;
import com.cupidapp.live.login.model.AuthResult;
import e1.b;
import io.reactivex.Observable;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.g;
import z0.h;
import z0.y;

/* compiled from: InputPassWordActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class InputPassWordActivity extends FKBaseActivity {

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public static final a f16092t = new a(null);

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16095s = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final SignInResultHelper f16093q = new SignInResultHelper();

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f16094r = kotlin.c.b(new Function0<Config>() { // from class: com.cupidapp.live.login.activity.InputPassWordActivity$mConfig$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final InputPassWordActivity.Config invoke() {
            Intent intent = InputPassWordActivity.this.getIntent();
            s.h(intent, "intent");
            return (InputPassWordActivity.Config) g.a(intent, InputPassWordActivity.Config.class);
        }
    });

    /* compiled from: InputPassWordActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class Config implements Serializable {

        @NotNull
        private final String account;

        @NotNull
        private final String accountSign;

        @NotNull
        private String eventTrackAccount;

        @NotNull
        private String eventTrackAccountType;
        private final boolean fromSwitchAccount;

        @NotNull
        private final LoginMethod loginMethod;

        public Config(@NotNull String account, @NotNull String accountSign, @NotNull LoginMethod loginMethod, boolean z10) {
            s.i(account, "account");
            s.i(accountSign, "accountSign");
            s.i(loginMethod, "loginMethod");
            this.account = account;
            this.accountSign = accountSign;
            this.loginMethod = loginMethod;
            this.fromSwitchAccount = z10;
            this.eventTrackAccountType = "";
            this.eventTrackAccount = "";
        }

        public static /* synthetic */ Config copy$default(Config config, String str, String str2, LoginMethod loginMethod, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = config.account;
            }
            if ((i10 & 2) != 0) {
                str2 = config.accountSign;
            }
            if ((i10 & 4) != 0) {
                loginMethod = config.loginMethod;
            }
            if ((i10 & 8) != 0) {
                z10 = config.fromSwitchAccount;
            }
            return config.copy(str, str2, loginMethod, z10);
        }

        @NotNull
        public final String component1() {
            return this.account;
        }

        @NotNull
        public final String component2() {
            return this.accountSign;
        }

        @NotNull
        public final LoginMethod component3() {
            return this.loginMethod;
        }

        public final boolean component4() {
            return this.fromSwitchAccount;
        }

        @NotNull
        public final Config copy(@NotNull String account, @NotNull String accountSign, @NotNull LoginMethod loginMethod, boolean z10) {
            s.i(account, "account");
            s.i(accountSign, "accountSign");
            s.i(loginMethod, "loginMethod");
            return new Config(account, accountSign, loginMethod, z10);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Config)) {
                return false;
            }
            Config config = (Config) obj;
            return s.d(this.account, config.account) && s.d(this.accountSign, config.accountSign) && this.loginMethod == config.loginMethod && this.fromSwitchAccount == config.fromSwitchAccount;
        }

        @NotNull
        public final String getAccount() {
            return this.account;
        }

        @NotNull
        public final String getAccountSign() {
            return this.accountSign;
        }

        @NotNull
        public final String getEventTrackAccount() {
            String str;
            if (this.eventTrackAccount.length() == 0) {
                if (this.loginMethod == LoginMethod.UserNameAndPassWordLogin) {
                    str = this.account;
                } else {
                    str = this.accountSign;
                }
                this.eventTrackAccount = str;
            }
            return this.eventTrackAccount;
        }

        @NotNull
        public final String getEventTrackAccountType() {
            if (this.eventTrackAccountType.length() == 0) {
                this.eventTrackAccountType = this.loginMethod == LoginMethod.UserNameAndPassWordLogin ? "name" : "phone";
            }
            return this.eventTrackAccountType;
        }

        public final boolean getFromSwitchAccount() {
            return this.fromSwitchAccount;
        }

        @NotNull
        public final LoginMethod getLoginMethod() {
            return this.loginMethod;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((this.account.hashCode() * 31) + this.accountSign.hashCode()) * 31) + this.loginMethod.hashCode()) * 31;
            boolean z10 = this.fromSwitchAccount;
            int i10 = z10;
            if (z10 != 0) {
                i10 = 1;
            }
            return hashCode + i10;
        }

        public final void setEventTrackAccount(@NotNull String str) {
            s.i(str, "<set-?>");
            this.eventTrackAccount = str;
        }

        public final void setEventTrackAccountType(@NotNull String str) {
            s.i(str, "<set-?>");
            this.eventTrackAccountType = str;
        }

        @NotNull
        public String toString() {
            String str = this.account;
            String str2 = this.accountSign;
            LoginMethod loginMethod = this.loginMethod;
            return "Config(account=" + str + ", accountSign=" + str2 + ", loginMethod=" + ((Object) loginMethod) + ", fromSwitchAccount=" + this.fromSwitchAccount + ")";
        }
    }

    /* compiled from: InputPassWordActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull Config model) {
            s.i(context, "context");
            s.i(model, "model");
            Intent intent = new Intent(context, (Class<?>) InputPassWordActivity.class);
            g.c(intent, model);
            context.startActivity(intent);
            FKBaseActivity.f11750o.b(context, 0, R$anim.alpha_out_duration_180);
        }
    }

    /* compiled from: TextView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable editable) {
            boolean z10 = editable != null && editable.length() == 0;
            ((LoginNextButton) InputPassWordActivity.this.j1(R$id.input_password_next_btn)).setSelected(!z10);
            ((ImageView) InputPassWordActivity.this.j1(R$id.input_password_clear_edit_btn)).setVisibility(z10 ? 8 : 0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.PasswordLogin;
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f16095s;
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

    public final void m1() {
        FKTitleBarLayout input_password_title_bar = (FKTitleBarLayout) j1(R$id.input_password_title_bar);
        s.h(input_password_title_bar, "input_password_title_bar");
        y.d(input_password_title_bar, new Function1<View, p>() { // from class: com.cupidapp.live.login.activity.InputPassWordActivity$bindClickEvent$1
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
                InputPassWordActivity.this.onBackPressed();
            }
        });
        EditText input_password_edit_text = (EditText) j1(R$id.input_password_edit_text);
        s.h(input_password_edit_text, "input_password_edit_text");
        input_password_edit_text.addTextChangedListener(new b());
        ImageView input_password_clear_edit_btn = (ImageView) j1(R$id.input_password_clear_edit_btn);
        s.h(input_password_clear_edit_btn, "input_password_clear_edit_btn");
        y.d(input_password_clear_edit_btn, new Function1<View, p>() { // from class: com.cupidapp.live.login.activity.InputPassWordActivity$bindClickEvent$3
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
                ((EditText) InputPassWordActivity.this.j1(R$id.input_password_edit_text)).setText((CharSequence) null);
            }
        });
        LoginNextButton input_password_next_btn = (LoginNextButton) j1(R$id.input_password_next_btn);
        s.h(input_password_next_btn, "input_password_next_btn");
        y.d(input_password_next_btn, new Function1<View, p>() { // from class: com.cupidapp.live.login.activity.InputPassWordActivity$bindClickEvent$4

            /* compiled from: InputPassWordActivity.kt */
            @kotlin.d
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f16097a;

                static {
                    int[] iArr = new int[LoginMethod.values().length];
                    try {
                        iArr[LoginMethod.UserNameAndPassWordLogin.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[LoginMethod.PhoneNumberAndPasswordLogin.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f16097a = iArr;
                }
            }

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
                InputPassWordActivity.Config o12;
                InputPassWordActivity.Config o13;
                InputPassWordActivity.Config o14;
                InputPassWordActivity.Config o15;
                InputPassWordActivity.Config o16;
                InputPassWordActivity.Config o17;
                InputPassWordActivity.Config o18;
                InputPassWordActivity.Config o19;
                o12 = InputPassWordActivity.this.o1();
                LoginMethod loginMethod = o12 != null ? o12.getLoginMethod() : null;
                int i10 = loginMethod == null ? -1 : a.f16097a[loginMethod.ordinal()];
                if (i10 == 1) {
                    SensorsLogAccount sensorsLogAccount = SensorsLogAccount.f12205a;
                    o13 = InputPassWordActivity.this.o1();
                    sensorsLogAccount.e(o13 != null ? o13.getAccountSign() : null);
                } else if (i10 == 2) {
                    SensorsLogAccount sensorsLogAccount2 = SensorsLogAccount.f12205a;
                    o19 = InputPassWordActivity.this.o1();
                    sensorsLogAccount2.j(o19 != null ? o19.getAccountSign() : null);
                }
                z3.e eVar = z3.e.f54837a;
                o14 = InputPassWordActivity.this.o1();
                String eventTrackAccountType = o14 != null ? o14.getEventTrackAccountType() : null;
                o15 = InputPassWordActivity.this.o1();
                eVar.t(eventTrackAccountType, o15 != null ? o15.getEventTrackAccount() : null);
                InputPassWordActivity inputPassWordActivity = InputPassWordActivity.this;
                int i11 = R$id.input_password_edit_text;
                String obj = ((EditText) inputPassWordActivity.j1(i11)).getText().toString();
                InputPassWordActivity inputPassWordActivity2 = InputPassWordActivity.this;
                h.p(inputPassWordActivity2, (EditText) inputPassWordActivity2.j1(i11));
                if (!(obj.length() == 0) && obj.length() >= 6) {
                    InputPassWordActivity.this.q1(obj);
                    return;
                }
                com.cupidapp.live.base.view.h.f12779a.l(InputPassWordActivity.this, R$string.password_error_enter_again);
                SensorsLogAccount sensorsLogAccount3 = SensorsLogAccount.f12205a;
                o16 = InputPassWordActivity.this.o1();
                sensorsLogAccount3.g(o16 != null ? o16.getAccountSign() : null);
                o17 = InputPassWordActivity.this.o1();
                String eventTrackAccountType2 = o17 != null ? o17.getEventTrackAccountType() : null;
                o18 = InputPassWordActivity.this.o1();
                eVar.u(eventTrackAccountType2, o18 != null ? o18.getEventTrackAccount() : null);
            }
        });
        TextView input_password_meet_problem_btn = (TextView) j1(R$id.input_password_meet_problem_btn);
        s.h(input_password_meet_problem_btn, "input_password_meet_problem_btn");
        y.d(input_password_meet_problem_btn, new Function1<View, p>() { // from class: com.cupidapp.live.login.activity.InputPassWordActivity$bindClickEvent$5
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
                InputPassWordActivity.Config o12;
                InputPassWordActivity.Config o13;
                z3.e eVar = z3.e.f54837a;
                o12 = InputPassWordActivity.this.o1();
                String eventTrackAccountType = o12 != null ? o12.getEventTrackAccountType() : null;
                o13 = InputPassWordActivity.this.o1();
                eVar.s(eventTrackAccountType, o13 != null ? o13.getEventTrackAccount() : null);
                SensorsLogKeyButtonClick.PasswordLogin.ForgetPassword.click();
                com.cupidapp.live.login.helper.e.f16161a.c(InputPassWordActivity.this, ForRecoverPasswordEnum.ForgetPassword);
            }
        });
    }

    public final boolean n1() {
        Config o12 = o1();
        if (o12 != null) {
            return o12.getFromSwitchAccount();
        }
        return false;
    }

    public final Config o1() {
        return (Config) this.f16094r.getValue();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_input_password);
        d1(0, Integer.valueOf(R$anim.alpha_out_duration_180));
        p1();
        m1();
        j1.c.b(j1.c.f50228a, SensorPosition.PasswordLogin, null, null, 6, null);
        z3.e eVar = z3.e.f54837a;
        Config o12 = o1();
        String eventTrackAccountType = o12 != null ? o12.getEventTrackAccountType() : null;
        Config o13 = o1();
        eVar.v(eventTrackAccountType, o13 != null ? o13.getEventTrackAccount() : null);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.cupidapp.live.login.helper.d.f16155a.a(kotlin.collections.s.m((ImageView) j1(R$id.password_title), (LinearLayout) j1(R$id.input_password_layout), (LinearLayout) j1(R$id.input_password_next_layout), null));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ((LoginNextButton) j1(R$id.input_password_next_btn)).b();
    }

    public final void p1() {
        int i10 = R$id.input_password_edit_text;
        ((EditText) j1(i10)).getPaint().setFakeBoldText(true);
        ((EditText) j1(i10)).requestFocus();
        ((LoginNextButton) j1(R$id.input_password_next_btn)).setSelected(false);
    }

    public final void q1(String str) {
        Config o12 = o1();
        String account = o12 != null ? o12.getAccount() : null;
        if (account == null || account.length() == 0) {
            return;
        }
        Observable<Result<AuthResult>> it = b.a.a(NetworkClient.f11868a.J(), account, q0.e(str), null, com.cupidapp.live.base.safe.e.f12185a.a(), null, null, n1(), 52, null).delay(600L, TimeUnit.MILLISECONDS);
        SignInResultHelper signInResultHelper = this.f16093q;
        s.h(it, "it");
        Config o13 = o1();
        LoginMethod loginMethod = o13 != null ? o13.getLoginMethod() : null;
        Config o14 = o1();
        signInResultHelper.f(this, it, loginMethod, o14 != null ? o14.getEventTrackAccount() : null, new Function0<p>() { // from class: com.cupidapp.live.login.activity.InputPassWordActivity$userAuth$1$1
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
                ((LoginNextButton) InputPassWordActivity.this.j1(R$id.input_password_next_btn)).e();
            }
        }, new Function1<Boolean, p>() { // from class: com.cupidapp.live.login.activity.InputPassWordActivity$userAuth$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return p.f51048a;
            }

            public final void invoke(boolean z10) {
                if (z10) {
                    ((LoginNextButton) InputPassWordActivity.this.j1(R$id.input_password_next_btn)).b();
                }
            }
        });
    }
}
