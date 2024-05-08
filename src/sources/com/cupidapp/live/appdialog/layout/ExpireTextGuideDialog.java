package com.cupidapp.live.appdialog.layout;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$style;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.setting.model.PrivacySettingDataResult;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x2.a;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: ExpireTextGuideDialog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ExpireTextGuideDialog extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f11654d = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public AlertDialog f11655b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f11656c;

    /* compiled from: ExpireTextGuideDialog.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ExpireTextGuideDialog a(@Nullable Context context) {
            if (context == null) {
                context = AppApplication.f11612d.h();
            }
            return new ExpireTextGuideDialog(context, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpireTextGuideDialog(Context context) {
        super(context);
        this.f11656c = new LinkedHashMap();
        e();
    }

    public /* synthetic */ ExpireTextGuideDialog(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f11656c;
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

    public final void c(boolean z10) {
        AlertDialog alertDialog = this.f11655b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        Disposable disposed = a.C0836a.f(NetworkClient.f11868a.N(), null, null, null, null, null, null, null, null, null, null, Boolean.valueOf(z10), null, 3071, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<PrivacySettingDataResult, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.ExpireTextGuideDialog$changeTextTipState$$inlined$handle$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(PrivacySettingDataResult privacySettingDataResult) {
                m2451invoke(privacySettingDataResult);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2451invoke(PrivacySettingDataResult privacySettingDataResult) {
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.appdialog.layout.ExpireTextGuideDialog$changeTextTipState$2
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                kotlin.jvm.internal.s.i(it, "it");
                return Boolean.FALSE;
            }
        }, null)));
        if (disposed != null) {
            kotlin.jvm.internal.s.h(disposed, "disposed");
        }
        kotlin.jvm.internal.s.h(disposed, "disposed");
    }

    @NotNull
    public final ExpireTextGuideDialog d(@NotNull String message) {
        kotlin.jvm.internal.s.i(message, "message");
        ((TextView) a(R$id.title_txt)).setText(message);
        return this;
    }

    public final void e() {
        z.a(this, R$layout.dialog_expire_text_tip, true);
        TextView title_txt = (TextView) a(R$id.title_txt);
        kotlin.jvm.internal.s.h(title_txt, "title_txt");
        u.a(title_txt);
        int i10 = R$id.cancel_btn;
        TextView cancel_btn = (TextView) a(i10);
        kotlin.jvm.internal.s.h(cancel_btn, "cancel_btn");
        u.a(cancel_btn);
        int i11 = R$id.confirm_btn;
        TextView confirm_btn = (TextView) a(i11);
        kotlin.jvm.internal.s.h(confirm_btn, "confirm_btn");
        u.a(confirm_btn);
        TextView cancel_btn2 = (TextView) a(i10);
        kotlin.jvm.internal.s.h(cancel_btn2, "cancel_btn");
        y.d(cancel_btn2, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.ExpireTextGuideDialog$initView$1
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
                ExpireTextGuideDialog.this.c(true);
                j1.i.d(j1.i.f50236a, PopupName.NEED_VIP_AUTO_PAY_REMIND, PopupButtonName.Open, null, 4, null);
            }
        });
        TextView confirm_btn2 = (TextView) a(i11);
        kotlin.jvm.internal.s.h(confirm_btn2, "confirm_btn");
        y.d(confirm_btn2, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.ExpireTextGuideDialog$initView$2
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
                ExpireTextGuideDialog.this.c(false);
                j1.i.d(j1.i.f50236a, PopupName.NEED_VIP_AUTO_PAY_REMIND, PopupButtonName.Close, null, 4, null);
            }
        });
    }

    public final void f() {
        Window window;
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f11655b = create;
        if (create != null) {
            create.setCancelable(false);
        }
        AlertDialog alertDialog = this.f11655b;
        if (alertDialog != null) {
            alertDialog.setCanceledOnTouchOutside(false);
        }
        AlertDialog alertDialog2 = this.f11655b;
        if (alertDialog2 != null) {
            alertDialog2.show();
        }
        AlertDialog alertDialog3 = this.f11655b;
        if (alertDialog3 != null && (window = alertDialog3.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R$style.dialog_translate_anim);
            window.setLayout(z0.h.c(window, 280.0f), -2);
            window.setGravity(17);
        }
        j1.i.g(j1.i.f50236a, PopupName.NEED_VIP_AUTO_PAY_REMIND, null, null, 6, null);
    }
}
