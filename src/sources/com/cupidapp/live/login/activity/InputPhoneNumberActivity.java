package com.cupidapp.live.login.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$array;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.utils.l0;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.timepicker.OptionsModel;
import com.cupidapp.live.base.view.timepicker.OptionsPickerWrapper;
import com.cupidapp.live.base.view.timepicker.h;
import com.cupidapp.live.chat2.helper.KeyboardStatePopupWindow;
import com.cupidapp.live.login.helper.ForRecoverPasswordEnum;
import com.cupidapp.live.login.layout.LoginNextButton;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.g;
import z0.y;

/* compiled from: InputPhoneNumberActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class InputPhoneNumberActivity extends FKBaseActivity {

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public static final a f16098t = new a(null);

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16101s = new LinkedHashMap();

    /* renamed from: q, reason: collision with root package name */
    @NotNull
    public String f16099q = "";

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final Lazy f16100r = kotlin.c.b(new Function0<OptionsPickerWrapper>() { // from class: com.cupidapp.live.login.activity.InputPhoneNumberActivity$optionsPicker$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final OptionsPickerWrapper invoke() {
            return new OptionsPickerWrapper();
        }
    });

    /* compiled from: InputPhoneNumberActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum InputPhoneNumberEnum {
        Password(1),
        VerificationCode(0);

        private final int type;

        InputPhoneNumberEnum(int i10) {
            this.type = i10;
        }

        public final int getType() {
            return this.type;
        }
    }

    /* compiled from: InputPhoneNumberActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public enum PageSource {
        SwitchAccount,
        Welcome,
        Unknown
    }

    /* compiled from: InputPhoneNumberActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @NotNull PageSource source) {
            s.i(source, "source");
            Intent intent = new Intent(context, (Class<?>) InputPhoneNumberActivity.class);
            g.c(intent, source);
            if (context != null) {
                context.startActivity(intent);
            }
            FKBaseActivity.f11750o.b(context, 0, R$anim.alpha_out_duration_180);
        }
    }

    /* compiled from: InputPhoneNumberActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16102a;

        static {
            int[] iArr = new int[PageSource.values().length];
            try {
                iArr[PageSource.SwitchAccount.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PageSource.Welcome.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f16102a = iArr;
        }
    }

    /* compiled from: TextView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable editable) {
            boolean z10 = editable != null && editable.length() == 0;
            ((LoginNextButton) InputPhoneNumberActivity.this.j1(R$id.input_phone_next_btn)).setSelected(!z10);
            ((ImageView) InputPhoneNumberActivity.this.j1(R$id.input_phone_clear_edit_btn)).setVisibility(z10 ? 8 : 0);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* compiled from: InputPhoneNumberActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d implements h {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List<String> f16104a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InputPhoneNumberActivity f16105b;

        public d(List<String> list, InputPhoneNumberActivity inputPhoneNumberActivity) {
            this.f16104a = list;
            this.f16105b = inputPhoneNumberActivity;
        }

        @Override // com.cupidapp.live.base.view.timepicker.h
        public void a(int i10, int i11, int i12) {
            String str = this.f16104a.get(i10);
            this.f16105b.f16099q = str + " ";
            InputPhoneNumberActivity inputPhoneNumberActivity = this.f16105b;
            int i13 = R$id.input_phone_country_code_text;
            ((TextView) inputPhoneNumberActivity.j1(i13)).setText(str);
            ((TextView) this.f16105b.j1(i13)).setTextColor(-8618884);
            InputPhoneNumberActivity inputPhoneNumberActivity2 = this.f16105b;
            EditText input_account_edit_text = (EditText) inputPhoneNumberActivity2.j1(R$id.input_account_edit_text);
            s.h(input_account_edit_text, "input_account_edit_text");
            z0.h.v(inputPhoneNumberActivity2, input_account_edit_text);
        }

        @Override // com.cupidapp.live.base.view.timepicker.h
        public void b(int i10, int i11, int i12) {
            h.a.c(this, i10, i11, i12);
        }

        @Override // com.cupidapp.live.base.view.timepicker.h
        public void onCancel() {
            InputPhoneNumberActivity inputPhoneNumberActivity = this.f16105b;
            EditText input_account_edit_text = (EditText) inputPhoneNumberActivity.j1(R$id.input_account_edit_text);
            s.h(input_account_edit_text, "input_account_edit_text");
            z0.h.v(inputPhoneNumberActivity, input_account_edit_text);
        }

        @Override // com.cupidapp.live.base.view.timepicker.h
        public void onConfirm() {
            h.a.b(this);
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity
    @NotNull
    public SensorPosition Q0() {
        return SensorPosition.Login;
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f16101s;
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

    public final void o1() {
        ((FKTitleBarLayout) j1(R$id.input_phone_title_bar)).setLeftImageClickEvent(new Function1<View, p>() { // from class: com.cupidapp.live.login.activity.InputPhoneNumberActivity$bindClickEvent$1
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
                InputPhoneNumberActivity.this.onBackPressed();
            }
        });
        TextView input_phone_country_code_text = (TextView) j1(R$id.input_phone_country_code_text);
        s.h(input_phone_country_code_text, "input_phone_country_code_text");
        y.d(input_phone_country_code_text, new Function1<View, p>() { // from class: com.cupidapp.live.login.activity.InputPhoneNumberActivity$bindClickEvent$2
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
                InputPhoneNumberActivity.this.s1();
            }
        });
        EditText input_account_edit_text = (EditText) j1(R$id.input_account_edit_text);
        s.h(input_account_edit_text, "input_account_edit_text");
        input_account_edit_text.addTextChangedListener(new c());
        ImageView input_phone_clear_edit_btn = (ImageView) j1(R$id.input_phone_clear_edit_btn);
        s.h(input_phone_clear_edit_btn, "input_phone_clear_edit_btn");
        y.d(input_phone_clear_edit_btn, new Function1<View, p>() { // from class: com.cupidapp.live.login.activity.InputPhoneNumberActivity$bindClickEvent$4
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
                ((EditText) InputPhoneNumberActivity.this.j1(R$id.input_account_edit_text)).setText((CharSequence) null);
            }
        });
        LoginNextButton input_phone_next_btn = (LoginNextButton) j1(R$id.input_phone_next_btn);
        s.h(input_phone_next_btn, "input_phone_next_btn");
        y.d(input_phone_next_btn, new Function1<View, p>() { // from class: com.cupidapp.live.login.activity.InputPhoneNumberActivity$bindClickEvent$5
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
                String str;
                String obj = ((EditText) InputPhoneNumberActivity.this.j1(R$id.input_account_edit_text)).getText().toString();
                if (l0.f12345a.b(obj)) {
                    InputPhoneNumberActivity inputPhoneNumberActivity = InputPhoneNumberActivity.this;
                    int i10 = R$id.input_phone_country_code_text;
                    if (((TextView) inputPhoneNumberActivity.j1(i10)).getVisibility() != 0) {
                        ((TextView) InputPhoneNumberActivity.this.j1(i10)).setVisibility(0);
                        return;
                    }
                }
                InputPhoneNumberActivity inputPhoneNumberActivity2 = InputPhoneNumberActivity.this;
                str = inputPhoneNumberActivity2.f16099q;
                inputPhoneNumberActivity2.t1(str + obj);
            }
        });
        TextView input_phone_meet_problem_btn = (TextView) j1(R$id.input_phone_meet_problem_btn);
        s.h(input_phone_meet_problem_btn, "input_phone_meet_problem_btn");
        y.d(input_phone_meet_problem_btn, new Function1<View, p>() { // from class: com.cupidapp.live.login.activity.InputPhoneNumberActivity$bindClickEvent$6
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
                SensorsLogKeyButtonClick.Login.Help.click();
                z3.e.f54837a.l();
                com.cupidapp.live.login.helper.e.f16161a.c(InputPhoneNumberActivity.this, ForRecoverPasswordEnum.Help);
            }
        });
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_input_phone_number);
        d1(0, Integer.valueOf(R$anim.alpha_out_duration_180));
        r1();
        o1();
        q1();
        j1.c.b(j1.c.f50228a, SensorPosition.Login, null, null, 6, null);
        z3.e.f54837a.b();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.cupidapp.live.login.helper.d.f16155a.a(kotlin.collections.s.m((LinearLayout) j1(R$id.phone_title), (ConstraintLayout) j1(R$id.input_phone_layout), (LinearLayout) j1(R$id.input_phone_next_layout), null));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ((LoginNextButton) j1(R$id.input_phone_next_btn)).b();
    }

    public final OptionsPickerWrapper p1() {
        return (OptionsPickerWrapper) this.f16100r.getValue();
    }

    public final void q1() {
        ConstraintLayout input_phone_root_layout = (ConstraintLayout) j1(R$id.input_phone_root_layout);
        s.h(input_phone_root_layout, "input_phone_root_layout");
        new KeyboardStatePopupWindow(this, this, input_phone_root_layout);
    }

    public final void r1() {
        int i10 = R$id.input_account_edit_text;
        ((EditText) j1(i10)).getPaint().setFakeBoldText(true);
        ((EditText) j1(i10)).requestFocus();
        ((LoginNextButton) j1(R$id.input_phone_next_btn)).setSelected(false);
    }

    public final void s1() {
        Typeface typeface;
        OptionsPickerWrapper p10;
        z0.h.p(this, (EditText) j1(R$id.input_account_edit_text));
        String[] stringArray = getResources().getStringArray(R$array.phone_area_code_name);
        s.h(stringArray, "resources.getStringArray…ray.phone_area_code_name)");
        List N = m.N(stringArray);
        String[] stringArray2 = getResources().getStringArray(R$array.phone_area_code);
        s.h(stringArray2, "resources.getStringArray(R.array.phone_area_code)");
        OptionsPickerWrapper s2 = OptionsPickerWrapper.i(p1(), this, new OptionsModel(N, (String) CollectionsKt___CollectionsKt.T(N)), null, null, 12, null).s(new d(m.N(stringArray2), this));
        if (Build.VERSION.SDK_INT >= 28) {
            typeface = Typeface.create(Typeface.DEFAULT, 500, false);
        } else {
            typeface = Typeface.DEFAULT;
        }
        s.h(typeface, "if (Build.VERSION.SDK_IN…DEFAULT\n                }");
        p10 = OptionsPickerWrapper.o(s2, 24, 1.5f, 7, 0, -15395563, -3750202, typeface, false, null, 384, null).p((r18 & 1) != 0 ? null : Integer.valueOf(R$drawable.shape_white_bg_top_24_corners), (r18 & 2) != 0, (r18 & 4) != 0 ? R$string.determine : 0, (r18 & 8) != 0 ? 16.0f : 0.0f, (r18 & 16) != 0 ? -15395563 : 0, (r18 & 32) != 0 ? 2131886363 : 0, (r18 & 64) == 0 ? 0.0f : 16.0f, (r18 & 128) != 0 ? -3750202 : 0);
        OptionsPickerWrapper.u(OptionsPickerWrapper.g(p10, false, 1, null), false, 1, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004a, code lost:
    
        if ((r0 == null || r0.isEmpty()) == false) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void t1(final java.lang.String r14) {
        /*
            r13 = this;
            int r0 = com.cupidapp.live.R$id.input_phone_next_btn
            android.view.View r0 = r13.j1(r0)
            com.cupidapp.live.login.layout.LoginNextButton r0 = (com.cupidapp.live.login.layout.LoginNextButton) r0
            r0.e()
            android.content.Intent r0 = r13.getIntent()
            java.lang.String r1 = "intent"
            kotlin.jvm.internal.s.h(r0, r1)
            java.lang.Class<com.cupidapp.live.login.activity.InputPhoneNumberActivity$PageSource> r1 = com.cupidapp.live.login.activity.InputPhoneNumberActivity.PageSource.class
            java.io.Serializable r0 = z0.g.a(r0, r1)
            com.cupidapp.live.login.activity.InputPhoneNumberActivity$PageSource r0 = (com.cupidapp.live.login.activity.InputPhoneNumberActivity.PageSource) r0
            if (r0 != 0) goto L20
            r0 = -1
            goto L28
        L20:
            int[] r1 = com.cupidapp.live.login.activity.InputPhoneNumberActivity.b.f16102a
            int r0 = r0.ordinal()
            r0 = r1[r0]
        L28:
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L4c
            r3 = 2
            if (r0 == r3) goto L30
            goto L4d
        L30:
            p1.g r0 = p1.g.f52734a
            com.cupidapp.live.setting.model.MultiAccountUserIdsModel r0 = r0.p0()
            if (r0 == 0) goto L3d
            java.util.List r0 = r0.getList()
            goto L3e
        L3d:
            r0 = 0
        L3e:
            if (r0 == 0) goto L49
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L47
            goto L49
        L47:
            r0 = 0
            goto L4a
        L49:
            r0 = 1
        L4a:
            if (r0 != 0) goto L4d
        L4c:
            r1 = 1
        L4d:
            com.cupidapp.live.base.network.NetworkClient r0 = com.cupidapp.live.base.network.NetworkClient.f11868a
            e1.b r3 = r0.J()
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 62
            r12 = 0
            r4 = r14
            r10 = r1
            io.reactivex.Observable r0 = e1.b.a.a(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r2 = 600(0x258, double:2.964E-321)
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS
            io.reactivex.Observable r0 = r0.delay(r2, r4)
            java.lang.String r2 = "NetworkClient.signInServ…S, TimeUnit.MILLISECONDS)"
            kotlin.jvm.internal.s.h(r0, r2)
            com.cupidapp.live.login.activity.InputPhoneNumberActivity$userAuth$2 r2 = new com.cupidapp.live.login.activity.InputPhoneNumberActivity$userAuth$2
            r2.<init>()
            com.cupidapp.live.base.network.i r3 = new com.cupidapp.live.base.network.i
            r3.<init>()
            io.reactivex.Observable r0 = r0.flatMap(r3)
            io.reactivex.Scheduler r3 = io.reactivex.android.schedulers.AndroidSchedulers.mainThread()
            io.reactivex.Observable r0 = r0.observeOn(r3)
            com.cupidapp.live.login.activity.InputPhoneNumberActivity$userAuth$$inlined$handle$1 r3 = new com.cupidapp.live.login.activity.InputPhoneNumberActivity$userAuth$$inlined$handle$1
            r3.<init>()
            com.cupidapp.live.base.network.e r14 = new com.cupidapp.live.base.network.e
            r14.<init>(r3)
            com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2 r1 = new com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2
            r1.<init>(r2, r13)
            com.cupidapp.live.base.network.e r2 = new com.cupidapp.live.base.network.e
            r2.<init>(r1)
            io.reactivex.disposables.Disposable r14 = r0.subscribe(r14, r2)
            java.lang.String r0 = "disposed"
            if (r14 == 0) goto La6
            kotlin.jvm.internal.s.h(r14, r0)
            r13.H(r14)
        La6:
            kotlin.jvm.internal.s.h(r14, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.login.activity.InputPhoneNumberActivity.t1(java.lang.String):void");
    }
}
