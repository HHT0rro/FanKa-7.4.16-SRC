package com.cupidapp.live.setting.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.utils.q0;
import com.cupidapp.live.base.view.dialog.FKAlertDialog;
import com.cupidapp.live.setting.fragment.ChangePasswordFragment;
import com.cupidapp.live.setting.fragment.VerifyCodeFragment;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChangePasswordActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ChangePasswordActivity extends FKBaseActivity {

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public static final a f17936s = new a(null);

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public String f17937q;

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17938r = new LinkedHashMap();

    /* compiled from: ChangePasswordActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @Nullable String str) {
            kotlin.jvm.internal.s.i(context, "context");
            Intent intent = new Intent(context, (Class<?>) ChangePasswordActivity.class);
            intent.putExtra("PHONE_NUMBER", str);
            context.startActivity(intent);
            FKBaseActivity.a.c(FKBaseActivity.f11750o, context, 0, 0, 6, null);
        }
    }

    /* compiled from: ChangePasswordActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements ChangePasswordFragment.a {
        public b() {
        }

        @Override // com.cupidapp.live.setting.fragment.ChangePasswordFragment.a
        public void a(@NotNull String password) {
            kotlin.jvm.internal.s.i(password, "password");
            ChangePasswordActivity.this.f17937q = password;
            ChangePasswordActivity.this.p1();
        }
    }

    /* compiled from: ChangePasswordActivity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements VerifyCodeFragment.b {
        public c() {
        }

        @Override // com.cupidapp.live.setting.fragment.VerifyCodeFragment.b
        public void a(@NotNull String code) {
            kotlin.jvm.internal.s.i(code, "code");
            ChangePasswordActivity.this.o1(code);
        }
    }

    public final void o1(String str) {
        e1();
        Disposable disposed = NetworkClient.f11868a.N().X(null, str, q0.e(this.f17937q)).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.ChangePasswordActivity$changePassword$$inlined$handle$1
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
                ChangePasswordActivity.this.V0();
                ChangePasswordActivity.this.q1();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.activity.ChangePasswordActivity$changePassword$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                ChangePasswordActivity.this.V0();
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_change_password);
        FKBaseActivity.g1(this, ChangePasswordFragment.f18102g.a(new b()), false, R$id.changePasswordContainerLayout, false, false, 16, null);
    }

    public final void p1() {
        e1();
        Disposable disposed = NetworkClient.f11868a.N().K().flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, kotlin.p>() { // from class: com.cupidapp.live.setting.activity.ChangePasswordActivity$getVerifyCode$$inlined$handle$1
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
                ChangePasswordActivity.this.V0();
                ChangePasswordActivity.this.r1();
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.setting.activity.ChangePasswordActivity$getVerifyCode$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                ChangePasswordActivity.this.V0();
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
            H(disposed);
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    public final void q1() {
        FKAlertDialog.G(FKAlertDialog.w(FKAlertDialog.o(FKAlertDialog.a.c(FKAlertDialog.f12698l, this, false, 2, null).D(R$string.change_success), R$string.change_password_success, 0, 2, null).j(false), 0, null, new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.activity.ChangePasswordActivity$showMessage$1
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
                ChangePasswordActivity.this.finish();
            }
        }, 3, null).t(new Function0<kotlin.p>() { // from class: com.cupidapp.live.setting.activity.ChangePasswordActivity$showMessage$2
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
                ChangePasswordActivity.this.finish();
            }
        }), null, 1, null);
    }

    public final void r1() {
        FKBaseActivity.g1(this, VerifyCodeFragment.f18151h.a(getIntent().getStringExtra("PHONE_NUMBER"), new c()), false, R$id.changePasswordContainerLayout, true, false, 16, null);
    }
}
