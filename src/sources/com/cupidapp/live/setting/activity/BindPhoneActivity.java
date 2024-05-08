package com.cupidapp.live.setting.activity;

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
import com.cupidapp.live.base.network.RequestErrorCode;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.login.helper.FKVerificationCodeViewWrapper;
import com.cupidapp.live.login.layout.FKBottomLineEditLayout;
import com.cupidapp.live.setting.model.BindMobileResult;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BindPhoneActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class BindPhoneActivity extends FKBaseActivity {

    /* renamed from: t, reason: collision with root package name */
    @NotNull
    public static final a f17923t = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public FKVerificationCodeViewWrapper f17924q;

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17926s = new LinkedHashMap();

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public final com.cupidapp.live.login.helper.f f17925r = new com.cupidapp.live.login.helper.f(this, null, 2, null);

    /* compiled from: BindPhoneActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(a aVar, Context context, boolean z10, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            aVar.a(context, z10);
        }

        public final void a(@NotNull Context context, boolean z10) {
            kotlin.jvm.internal.s.i(context, "context");
            Intent intent = new Intent(context, (Class<?>) BindPhoneActivity.class);
            intent.putExtra("BIND_PHONE_IS_BIND", z10);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f17926s;
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
        setContentView(R$layout.activity_bind_phone_number);
        j1.c.b(j1.c.f50228a, SensorPosition.ChangePhoneNumber, null, null, 6, null);
        TextView sendVerifyCode = (TextView) j1(R$id.sendVerifyCode);
        kotlin.jvm.internal.s.h(sendVerifyCode, "sendVerifyCode");
        this.f17924q = new FKVerificationCodeViewWrapper(sendVerifyCode, R$string.resend_verify_code, R$string.send_verify_code);
        s1();
        p1();
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        FKVerificationCodeViewWrapper fKVerificationCodeViewWrapper = this.f17924q;
        if (fKVerificationCodeViewWrapper != null) {
            fKVerificationCodeViewWrapper.f();
        }
        super.onDestroy();
    }

    public final void p1() {
        ((FKTitleBarLayout) j1(R$id.bindPhoneTitleBarLayout)).setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.BindPhoneActivity$bindClickEvent$1
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
                z0.h.q(BindPhoneActivity.this, null, 1, null);
                BindPhoneActivity.this.onBackPressed();
            }
        });
        TextView sendVerifyCode = (TextView) j1(R$id.sendVerifyCode);
        kotlin.jvm.internal.s.h(sendVerifyCode, "sendVerifyCode");
        z0.y.d(sendVerifyCode, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.BindPhoneActivity$bindClickEvent$2
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
                com.cupidapp.live.login.helper.f fVar;
                BindPhoneActivity bindPhoneActivity = BindPhoneActivity.this;
                fVar = bindPhoneActivity.f17925r;
                bindPhoneActivity.r1(fVar.a(((EditText) ((FKBottomLineEditLayout) BindPhoneActivity.this.j1(R$id.inputPhoneNumberLayout)).c(R$id.bottomLineEditText)).getText().toString()));
            }
        });
        FKUniversalButton bindPhoneNumberButton = (FKUniversalButton) j1(R$id.bindPhoneNumberButton);
        kotlin.jvm.internal.s.h(bindPhoneNumberButton, "bindPhoneNumberButton");
        z0.y.d(bindPhoneNumberButton, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.BindPhoneActivity$bindClickEvent$3
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
                com.cupidapp.live.login.helper.f fVar;
                com.cupidapp.live.login.helper.f fVar2;
                fVar = BindPhoneActivity.this.f17925r;
                FKBottomLineEditLayout fKBottomLineEditLayout = (FKBottomLineEditLayout) BindPhoneActivity.this.j1(R$id.inputPhoneNumberLayout);
                int i10 = R$id.bottomLineEditText;
                String a10 = fVar.a(((EditText) fKBottomLineEditLayout.c(i10)).getText().toString());
                fVar2 = BindPhoneActivity.this.f17925r;
                BindPhoneActivity.this.q1(a10, fVar2.d(((EditText) ((FKBottomLineEditLayout) BindPhoneActivity.this.j1(R$id.inputVerifyCodeLayout)).c(i10)).getText().toString()));
            }
        });
    }

    public final void q1(String str, String str2) {
        if (str == null || str.length() == 0) {
            return;
        }
        if (str2 == null || str2.length() == 0) {
            return;
        }
        e1();
        final Map h10 = i0.h(kotlin.f.a(Integer.valueOf(RequestErrorCode.InvalidMobileVerifyCode.getValue()), new Function1<String, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.BindPhoneActivity$bindPhone$errorCodeInterceptor$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(String str3) {
                invoke2(str3);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable String str3) {
                BindPhoneActivity bindPhoneActivity = BindPhoneActivity.this;
                int i10 = R$id.codeErrorPromptTextView;
                ((TextView) bindPhoneActivity.j1(i10)).setVisibility(0);
                ((TextView) BindPhoneActivity.this.j1(i10)).setText(BindPhoneActivity.this.getString(R$string.check_verify_code));
            }
        }));
        Disposable disposed = NetworkClient.f11868a.N().B0(str, str2).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<BindMobileResult, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.BindPhoneActivity$bindPhone$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(BindMobileResult bindMobileResult) {
                m2779invoke(bindMobileResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2779invoke(BindMobileResult bindMobileResult) {
                BindMobileResult bindMobileResult2 = bindMobileResult;
                BindPhoneActivity.this.V0();
                String message = bindMobileResult2.getMessage();
                if (message == null || message.length() == 0) {
                    BindPhoneActivity.this.finish();
                } else {
                    BindPhoneActivity.this.t1(bindMobileResult2.getMessage());
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.activity.BindPhoneActivity$bindPhone$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                BindPhoneActivity.this.V0();
                com.cupidapp.live.base.network.j.f(com.cupidapp.live.base.network.j.f12008a, it, BindPhoneActivity.this, h10, null, 8, null);
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void r1(String str) {
        if (str == null) {
            return;
        }
        e1();
        Disposable disposed = NetworkClient.f11868a.N().d0(str).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.BindPhoneActivity$getCode$$inlined$handle$1
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
                FKVerificationCodeViewWrapper fKVerificationCodeViewWrapper;
                BindPhoneActivity.this.V0();
                fKVerificationCodeViewWrapper = BindPhoneActivity.this.f17924q;
                if (fKVerificationCodeViewWrapper != null) {
                    fKVerificationCodeViewWrapper.d();
                }
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.activity.BindPhoneActivity$getCode$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                BindPhoneActivity.this.V0();
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void s1() {
        int i10 = R$id.inputPhoneNumberLayout;
        FKBottomLineEditLayout fKBottomLineEditLayout = (FKBottomLineEditLayout) j1(i10);
        int i11 = R$id.bottomLineEditText;
        EditText editText = (EditText) fKBottomLineEditLayout.c(i11);
        kotlin.jvm.internal.s.h(editText, "inputPhoneNumberLayout.bottomLineEditText");
        z0.h.v(this, editText);
        ((TextView) j1(R$id.sendVerifyCode)).getPaint().setFakeBoldText(true);
        ((TextView) j1(R$id.codeErrorPromptTextView)).getPaint().setFakeBoldText(true);
        new com.cupidapp.live.base.utils.g(kotlin.collections.r.e((EditText) ((FKBottomLineEditLayout) j1(i10)).c(i11)), new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.BindPhoneActivity$initView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                ((TextView) BindPhoneActivity.this.j1(R$id.sendVerifyCode)).setVisibility(z10 ? 0 : 8);
            }
        });
        int i12 = R$id.bindPhoneNumberButton;
        ((FKUniversalButton) j1(i12)).a(false);
        FKUniversalButton bindPhoneNumberButton = (FKUniversalButton) j1(i12);
        kotlin.jvm.internal.s.h(bindPhoneNumberButton, "bindPhoneNumberButton");
        z0.y.a(bindPhoneNumberButton);
        new com.cupidapp.live.base.utils.g(kotlin.collections.s.m((EditText) ((FKBottomLineEditLayout) j1(i10)).c(i11), (EditText) ((FKBottomLineEditLayout) j1(R$id.inputVerifyCodeLayout)).c(i11)), new Function1<Boolean, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.BindPhoneActivity$initView$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return kotlin.p.f51048a;
            }

            public final void invoke(boolean z10) {
                ((FKUniversalButton) BindPhoneActivity.this.j1(R$id.bindPhoneNumberButton)).a(z10);
            }
        });
        if (getIntent().getBooleanExtra("BIND_PHONE_IS_BIND", false)) {
            FKTitleBarLayout bindPhoneTitleBarLayout = (FKTitleBarLayout) j1(R$id.bindPhoneTitleBarLayout);
            kotlin.jvm.internal.s.h(bindPhoneTitleBarLayout, "bindPhoneTitleBarLayout");
            FKTitleBarLayout.setSingleTitle$default(bindPhoneTitleBarLayout, getString(R$string.bind_phone_number), null, 2, null);
            ((FKUniversalButton) j1(i12)).setText(getString(R$string.bind_number));
            ((FKBottomLineEditLayout) j1(i10)).setHint(getString(R$string.input_phone_number));
            return;
        }
        FKTitleBarLayout bindPhoneTitleBarLayout2 = (FKTitleBarLayout) j1(R$id.bindPhoneTitleBarLayout);
        kotlin.jvm.internal.s.h(bindPhoneTitleBarLayout2, "bindPhoneTitleBarLayout");
        FKTitleBarLayout.setSingleTitle$default(bindPhoneTitleBarLayout2, getString(R$string.modify_phone_number), null, 2, null);
        ((FKUniversalButton) j1(i12)).setText(getString(R$string.modify_number));
        ((FKBottomLineEditLayout) j1(i10)).setHint(getString(R$string.input_new_phone_number));
    }

    public final void t1(String str) {
        FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.a.c(FKAlertDialog.f12698l, this, false, 2, null).D(R$string.bind_success).n(str).j(false), 0, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.activity.BindPhoneActivity$showMessage$1
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
                BindPhoneActivity.this.finish();
            }
        }, 3, null).t(new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.activity.BindPhoneActivity$showMessage$2
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
                BindPhoneActivity.this.finish();
            }
        }), null, 1, null);
    }
}
