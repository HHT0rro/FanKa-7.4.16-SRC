package com.cupidapp.live.superboost.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.b;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: SuperBoostUseDialog.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SuperBoostUseDialog extends FrameLayout {

    /* renamed from: d */
    @NotNull
    public static final a f18588d = new a(null);

    /* renamed from: b */
    @Nullable
    public AlertDialog f18589b;

    /* renamed from: c */
    @NotNull
    public Map<Integer, View> f18590c;

    /* compiled from: SuperBoostUseDialog.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SuperBoostUseDialog a(@Nullable Context context) {
            if (context == null) {
                context = AppApplication.f11612d.h();
            }
            return new SuperBoostUseDialog(context, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperBoostUseDialog(Context context) {
        super(context);
        this.f18590c = new LinkedHashMap();
        c();
    }

    public /* synthetic */ SuperBoostUseDialog(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    public static /* synthetic */ void i(SuperBoostUseDialog superBoostUseDialog, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = null;
        }
        superBoostUseDialog.h(num);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f18590c;
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

    public final void b() {
        AlertDialog alertDialog = this.f18589b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public final void c() {
        z.a(this, R$layout.dialog_super_boost_use, true);
        TextView confirm_btn = (TextView) a(R$id.confirm_btn);
        s.h(confirm_btn, "confirm_btn");
        u.a(confirm_btn);
        TextView title_txt = (TextView) a(R$id.title_txt);
        s.h(title_txt, "title_txt");
        u.a(title_txt);
        TextView cancel_btn = (TextView) a(R$id.cancel_btn);
        s.h(cancel_btn, "cancel_btn");
        u.a(cancel_btn);
        ImageView alert_dialog_close_img = (ImageView) a(R$id.alert_dialog_close_img);
        s.h(alert_dialog_close_img, "alert_dialog_close_img");
        y.d(alert_dialog_close_img, new Function1<View, p>() { // from class: com.cupidapp.live.superboost.dialog.SuperBoostUseDialog$initView$1
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
                SuperBoostUseDialog.this.b();
            }
        });
    }

    @NotNull
    public final SuperBoostUseDialog d(@StringRes int i10, @Nullable final Function0<p> function0) {
        int i11 = R$id.cancel_btn;
        ((TextView) a(i11)).setText(getContext().getString(i10));
        ((TextView) a(i11)).setVisibility(0);
        TextView cancel_btn = (TextView) a(i11);
        s.h(cancel_btn, "cancel_btn");
        y.d(cancel_btn, new Function1<View, p>() { // from class: com.cupidapp.live.superboost.dialog.SuperBoostUseDialog$setCancelButton$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Function0<p> function02 = function0;
                if (function02 != null) {
                    function02.invoke();
                }
                this.b();
            }
        });
        return this;
    }

    @NotNull
    public final SuperBoostUseDialog e(@StringRes int i10, @Nullable final Function0<p> function0) {
        int i11 = R$id.confirm_btn;
        TextView textView = (TextView) a(i11);
        textView.setText(textView.getContext().getString(i10));
        ((TextView) a(i11)).setVisibility(0);
        TextView confirm_btn = (TextView) a(i11);
        s.h(confirm_btn, "confirm_btn");
        y.d(confirm_btn, new Function1<View, p>() { // from class: com.cupidapp.live.superboost.dialog.SuperBoostUseDialog$setPositiveButton$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Function0<p> function02 = function0;
                if (function02 != null) {
                    function02.invoke();
                }
                this.b();
            }
        });
        return this;
    }

    @NotNull
    public final SuperBoostUseDialog f(@Nullable String str) {
        if (str == null || str.length() == 0) {
            ((TextView) a(R$id.confirm_button_tag)).setVisibility(8);
        } else {
            int i10 = R$id.confirm_button_tag;
            ((TextView) a(i10)).setVisibility(0);
            ((TextView) a(i10)).setText(str);
        }
        return this;
    }

    @NotNull
    public final SuperBoostUseDialog g(int i10) {
        int i11 = R$id.title_txt;
        ((TextView) a(i11)).setVisibility(0);
        ((TextView) a(i11)).setText(i10);
        return this;
    }

    public final void h(@StyleRes @Nullable Integer num) {
        Window window;
        AlertDialog create = b.f54812a.f(getContext(), num).setView(this).create();
        this.f18589b = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(false);
        }
        AlertDialog alertDialog = this.f18589b;
        if (alertDialog != null) {
            alertDialog.show();
        }
        AlertDialog alertDialog2 = this.f18589b;
        if (alertDialog2 == null || (window = alertDialog2.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(-2, -2);
    }
}
