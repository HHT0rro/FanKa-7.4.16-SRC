package com.cupidapp.live.login.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.network.j;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogAccount;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.login.activity.InputPassWordActivity;
import com.cupidapp.live.login.activity.InputVerificationCodeActivity;
import com.cupidapp.live.login.helper.FKVerificationCodeViewWrapper;
import com.cupidapp.live.login.helper.ForRecoverPasswordEnum;
import com.cupidapp.live.login.helper.LoginMethod;
import com.cupidapp.live.login.helper.SignInResultHelper;
import com.cupidapp.live.login.layout.SingleVerificationCodeLayout;
import e1.b;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.g;
import z0.h;
import z0.y;

/* compiled from: InputVerificationCodeActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class InputVerificationCodeActivity extends FKBaseActivity {

    /* renamed from: u, reason: collision with root package name */
    @NotNull
    public static final a f16106u = new a(null);

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public FKVerificationCodeViewWrapper f16108r;

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16110t = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public final SignInResultHelper f16107q = new SignInResultHelper();

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public final Lazy f16109s = kotlin.c.b(new Function0<Config>() { // from class: com.cupidapp.live.login.activity.InputVerificationCodeActivity$mConfig$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @Nullable
        public final InputVerificationCodeActivity.Config invoke() {
            Intent intent = InputVerificationCodeActivity.this.getIntent();
            s.h(intent, "intent");
            return (InputVerificationCodeActivity.Config) g.a(intent, InputVerificationCodeActivity.Config.class);
        }
    });

    /* compiled from: InputVerificationCodeActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class Config implements Serializable {

        @NotNull
        private final String account;

        @NotNull
        private final String accountSign;
        private final boolean fromSwitchAccount;

        @Nullable
        private final String loginType;

        public Config(@NotNull String account, @NotNull String accountSign, @Nullable String str, boolean z10) {
            s.i(account, "account");
            s.i(accountSign, "accountSign");
            this.account = account;
            this.accountSign = accountSign;
            this.loginType = str;
            this.fromSwitchAccount = z10;
        }

        public static /* synthetic */ Config copy$default(Config config, String str, String str2, String str3, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = config.account;
            }
            if ((i10 & 2) != 0) {
                str2 = config.accountSign;
            }
            if ((i10 & 4) != 0) {
                str3 = config.loginType;
            }
            if ((i10 & 8) != 0) {
                z10 = config.fromSwitchAccount;
            }
            return config.copy(str, str2, str3, z10);
        }

        @NotNull
        public final String component1() {
            return this.account;
        }

        @NotNull
        public final String component2() {
            return this.accountSign;
        }

        @Nullable
        public final String component3() {
            return this.loginType;
        }

        public final boolean component4() {
            return this.fromSwitchAccount;
        }

        @NotNull
        public final Config copy(@NotNull String account, @NotNull String accountSign, @Nullable String str, boolean z10) {
            s.i(account, "account");
            s.i(accountSign, "accountSign");
            return new Config(account, accountSign, str, z10);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Config)) {
                return false;
            }
            Config config = (Config) obj;
            return s.d(this.account, config.account) && s.d(this.accountSign, config.accountSign) && s.d(this.loginType, config.loginType) && this.fromSwitchAccount == config.fromSwitchAccount;
        }

        @NotNull
        public final String getAccount() {
            return this.account;
        }

        @NotNull
        public final String getAccountSign() {
            return this.accountSign;
        }

        public final boolean getFromSwitchAccount() {
            return this.fromSwitchAccount;
        }

        @Nullable
        public final String getLoginType() {
            return this.loginType;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((this.account.hashCode() * 31) + this.accountSign.hashCode()) * 31;
            String str = this.loginType;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            boolean z10 = this.fromSwitchAccount;
            int i10 = z10;
            if (z10 != 0) {
                i10 = 1;
            }
            return hashCode2 + i10;
        }

        @NotNull
        public String toString() {
            return "Config(account=" + this.account + ", accountSign=" + this.accountSign + ", loginType=" + this.loginType + ", fromSwitchAccount=" + this.fromSwitchAccount + ")";
        }
    }

    /* compiled from: InputVerificationCodeActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull Config config) {
            s.i(context, "context");
            s.i(config, "config");
            Intent intent = new Intent(context, (Class<?>) InputVerificationCodeActivity.class);
            g.c(intent, config);
            context.startActivity(intent);
            FKBaseActivity.f11750o.b(context, 0, R$anim.alpha_out_duration_180);
        }
    }

    /* compiled from: TextView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements TextWatcher {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SingleVerificationCodeLayout[] f16111b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InputVerificationCodeActivity f16112c;

        public b(SingleVerificationCodeLayout[] singleVerificationCodeLayoutArr, InputVerificationCodeActivity inputVerificationCodeActivity) {
            this.f16111b = singleVerificationCodeLayoutArr;
            this.f16112c = inputVerificationCodeActivity;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable editable) {
            SingleVerificationCodeLayout[] singleVerificationCodeLayoutArr = this.f16111b;
            int length = singleVerificationCodeLayoutArr.length;
            boolean z10 = false;
            int i10 = 0;
            int i11 = 0;
            while (i10 < length) {
                int i12 = i11 + 1;
                singleVerificationCodeLayoutArr[i10].setCodeText(editable != null ? r.V0(editable, i11) : null);
                i10++;
                i11 = i12;
            }
            if (editable != null && editable.length() == 6) {
                z10 = true;
            }
            if (z10) {
                this.f16112c.u1(editable.toString());
            }
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
        return SensorPosition.VerifySMSLogin;
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f16110t;
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
        setContentView(R$layout.activity_input_verification_code);
        d1(0, Integer.valueOf(R$anim.alpha_out_duration_180));
        t1();
        s1();
        p1();
        j1.c.b(j1.c.f50228a, SensorPosition.VerifySMSLogin, null, null, 6, null);
        z3.e eVar = z3.e.f54837a;
        Config r12 = r1();
        eVar.y(r12 != null ? r12.getLoginType() : null);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        FKVerificationCodeViewWrapper fKVerificationCodeViewWrapper = this.f16108r;
        if (fKVerificationCodeViewWrapper != null) {
            fKVerificationCodeViewWrapper.f();
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.cupidapp.live.login.helper.d.f16155a.a(kotlin.collections.s.m((ImageView) j1(R$id.code_title), (ConstraintLayout) j1(R$id.input_code_layout), (LinearLayout) j1(R$id.input_code_resend_layout), null));
    }

    public final void p1() {
        int i10 = R$id.input_code_title_bar;
        FKTitleBarLayout input_code_title_bar = (FKTitleBarLayout) j1(i10);
        s.h(input_code_title_bar, "input_code_title_bar");
        y.d(input_code_title_bar, new Function1<View, p>() { // from class: com.cupidapp.live.login.activity.InputVerificationCodeActivity$bindClickEvent$1
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
                InputVerificationCodeActivity.this.onBackPressed();
            }
        });
        ((FKTitleBarLayout) j1(i10)).setRightTextClickEvent(new Function1<View, p>() { // from class: com.cupidapp.live.login.activity.InputVerificationCodeActivity$bindClickEvent$2
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
                InputVerificationCodeActivity.Config r12;
                InputVerificationCodeActivity.Config r13;
                InputVerificationCodeActivity.Config r14;
                boolean q12;
                SensorsLogAccount sensorsLogAccount = SensorsLogAccount.f12205a;
                r12 = InputVerificationCodeActivity.this.r1();
                sensorsLogAccount.k(r12 != null ? r12.getAccountSign() : null);
                r13 = InputVerificationCodeActivity.this.r1();
                String account = r13 != null ? r13.getAccount() : null;
                r14 = InputVerificationCodeActivity.this.r1();
                String accountSign = r14 != null ? r14.getAccountSign() : null;
                if (account == null || accountSign == null) {
                    return;
                }
                LoginMethod loginMethod = LoginMethod.PhoneNumberAndPasswordLogin;
                q12 = InputVerificationCodeActivity.this.q1();
                InputPassWordActivity.f16092t.a(InputVerificationCodeActivity.this, new InputPassWordActivity.Config(account, accountSign, loginMethod, q12));
                InputVerificationCodeActivity.this.finish();
            }
        });
        SingleVerificationCodeLayout[] singleVerificationCodeLayoutArr = {(SingleVerificationCodeLayout) j1(R$id.input_code_first_text), (SingleVerificationCodeLayout) j1(R$id.input_code_second_text), (SingleVerificationCodeLayout) j1(R$id.input_code_third_text), (SingleVerificationCodeLayout) j1(R$id.input_code_fourth_text), (SingleVerificationCodeLayout) j1(R$id.input_code_fifth_text), (SingleVerificationCodeLayout) j1(R$id.input_code_sixth_text)};
        EditText input_code_hide_edit_text = (EditText) j1(R$id.input_code_hide_edit_text);
        s.h(input_code_hide_edit_text, "input_code_hide_edit_text");
        input_code_hide_edit_text.addTextChangedListener(new b(singleVerificationCodeLayoutArr, this));
        ConstraintLayout input_code_layout = (ConstraintLayout) j1(R$id.input_code_layout);
        s.h(input_code_layout, "input_code_layout");
        y.d(input_code_layout, new Function1<View, p>() { // from class: com.cupidapp.live.login.activity.InputVerificationCodeActivity$bindClickEvent$4
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
                InputVerificationCodeActivity inputVerificationCodeActivity = InputVerificationCodeActivity.this;
                EditText input_code_hide_edit_text2 = (EditText) inputVerificationCodeActivity.j1(R$id.input_code_hide_edit_text);
                s.h(input_code_hide_edit_text2, "input_code_hide_edit_text");
                h.v(inputVerificationCodeActivity, input_code_hide_edit_text2);
            }
        });
        TextView input_code_resend_btn = (TextView) j1(R$id.input_code_resend_btn);
        s.h(input_code_resend_btn, "input_code_resend_btn");
        y.d(input_code_resend_btn, new Function1<View, p>() { // from class: com.cupidapp.live.login.activity.InputVerificationCodeActivity$bindClickEvent$5
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
                InputVerificationCodeActivity.Config r12;
                z3.e eVar = z3.e.f54837a;
                r12 = InputVerificationCodeActivity.this.r1();
                eVar.x(r12 != null ? r12.getAccountSign() : null);
                InputVerificationCodeActivity.this.s1();
            }
        });
        TextView input_code_meet_problem_btn = (TextView) j1(R$id.input_code_meet_problem_btn);
        s.h(input_code_meet_problem_btn, "input_code_meet_problem_btn");
        y.d(input_code_meet_problem_btn, new Function1<View, p>() { // from class: com.cupidapp.live.login.activity.InputVerificationCodeActivity$bindClickEvent$6
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
                InputVerificationCodeActivity.Config r12;
                SensorsLogAccount sensorsLogAccount = SensorsLogAccount.f12205a;
                r12 = InputVerificationCodeActivity.this.r1();
                sensorsLogAccount.h(r12 != null ? r12.getAccountSign() : null);
                com.cupidapp.live.login.helper.e.f16161a.c(InputVerificationCodeActivity.this, ForRecoverPasswordEnum.InvalidNumber);
            }
        });
        this.f16107q.n(new Function0<p>() { // from class: com.cupidapp.live.login.activity.InputVerificationCodeActivity$bindClickEvent$7
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
                InputVerificationCodeActivity.Config r12;
                FKAlertDialog o10 = FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, InputVerificationCodeActivity.this, false, 2, null), R$string.code_error_re_input, 0, 2, null);
                final InputVerificationCodeActivity inputVerificationCodeActivity = InputVerificationCodeActivity.this;
                FKAlertDialog.G(FKAlertDialog.r(FKAlertDialog.w(o10, 0, null, new Function0<p>() { // from class: com.cupidapp.live.login.activity.InputVerificationCodeActivity$bindClickEvent$7.1
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
                        InputVerificationCodeActivity inputVerificationCodeActivity2 = InputVerificationCodeActivity.this;
                        int i11 = R$id.input_code_hide_edit_text;
                        ((EditText) inputVerificationCodeActivity2.j1(i11)).setText((CharSequence) null);
                        InputVerificationCodeActivity inputVerificationCodeActivity3 = InputVerificationCodeActivity.this;
                        EditText input_code_hide_edit_text2 = (EditText) inputVerificationCodeActivity3.j1(i11);
                        s.h(input_code_hide_edit_text2, "input_code_hide_edit_text");
                        h.v(inputVerificationCodeActivity3, input_code_hide_edit_text2);
                    }
                }, 3, null), 0, null, 3, null), null, 1, null);
                z3.e eVar = z3.e.f54837a;
                r12 = InputVerificationCodeActivity.this.r1();
                eVar.w(r12 != null ? r12.getAccountSign() : null);
            }
        });
    }

    public final boolean q1() {
        Config r12 = r1();
        if (r12 != null) {
            return r12.getFromSwitchAccount();
        }
        return false;
    }

    public final Config r1() {
        return (Config) this.f16109s.getValue();
    }

    public final void s1() {
        e1();
        e1.b J = NetworkClient.f11868a.J();
        Config r12 = r1();
        Disposable disposed = J.b(r12 != null ? r12.getAccount() : null, q1()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.login.activity.InputVerificationCodeActivity$getVerificationCode$$inlined$handle$1
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
                FKVerificationCodeViewWrapper fKVerificationCodeViewWrapper;
                SensorsLogAccount.f12205a.a("登录", true, null);
                InputVerificationCodeActivity.this.V0();
                fKVerificationCodeViewWrapper = InputVerificationCodeActivity.this.f16108r;
                if (fKVerificationCodeViewWrapper != null) {
                    fKVerificationCodeViewWrapper.e(-3750202, -15395563);
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.login.activity.InputVerificationCodeActivity$getVerificationCode$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                SensorsLogAccount.f12205a.a("登录", false, j.f12008a.a(it));
                InputVerificationCodeActivity.this.V0();
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void t1() {
        int i10 = R$id.input_code_hide_edit_text;
        ((EditText) j1(i10)).setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(6)});
        ((EditText) j1(i10)).requestFocus();
        int i11 = R$id.input_code_resend_btn;
        TextView input_code_resend_btn = (TextView) j1(i11);
        s.h(input_code_resend_btn, "input_code_resend_btn");
        this.f16108r = new FKVerificationCodeViewWrapper(input_code_resend_btn, R$string.restart_get_verification_code_in_processing, R$string.restart_get_verification_code_start);
        ((TextView) j1(i11)).getPaint().setFakeBoldText(true);
    }

    public final void u1(String str) {
        Config r12 = r1();
        String account = r12 != null ? r12.getAccount() : null;
        if (account == null || account.length() == 0) {
            return;
        }
        h.p(this, (EditText) j1(R$id.input_code_hide_edit_text));
        SignInResultHelper.g(this.f16107q, this, b.a.a(NetworkClient.f11868a.J(), account, null, str, com.cupidapp.live.base.safe.e.f12185a.a(), null, null, q1(), 50, null), LoginMethod.VerificationCodeLogin, null, null, null, 56, null);
    }
}
