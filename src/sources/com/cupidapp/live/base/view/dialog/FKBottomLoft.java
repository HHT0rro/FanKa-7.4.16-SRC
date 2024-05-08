package com.cupidapp.live.base.view.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$style;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKBottomLoft.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKBottomLoft extends FrameLayout {

    /* renamed from: e */
    @NotNull
    public static final a f12709e = new a(null);

    /* renamed from: b */
    @Nullable
    public AlertDialog f12710b;

    /* renamed from: c */
    public boolean f12711c;

    /* renamed from: d */
    @NotNull
    public Map<Integer, View> f12712d;

    /* compiled from: FKBottomLoft.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKBottomLoft a(@Nullable Context context) {
            if (context == null) {
                context = AppApplication.f11612d.h();
            }
            return new FKBottomLoft(context);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKBottomLoft(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f12712d = new LinkedHashMap();
        this.f12711c = true;
        z.a(this, R$layout.layout_bottom_loft, true);
        ((TextView) a(R$id.bottom_loft_title)).getPaint().setFakeBoldText(true);
        ((TextView) a(R$id.bottom_loft_positive_button)).getPaint().setFakeBoldText(true);
        ((TextView) a(R$id.bottom_loft_negative_button)).getPaint().setFakeBoldText(true);
    }

    public static /* synthetic */ FKBottomLoft g(FKBottomLoft fKBottomLoft, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = -13421773;
        }
        if ((i13 & 4) != 0) {
            i12 = 400;
        }
        return fKBottomLoft.e(i10, i11, i12);
    }

    public static /* synthetic */ FKBottomLoft h(FKBottomLoft fKBottomLoft, CharSequence charSequence, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = -13421773;
        }
        if ((i12 & 4) != 0) {
            i11 = 400;
        }
        return fKBottomLoft.f(charSequence, i10, i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FKBottomLoft j(FKBottomLoft fKBottomLoft, int i10, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function0 = null;
        }
        return fKBottomLoft.i(i10, function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FKBottomLoft l(FKBottomLoft fKBottomLoft, int i10, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function0 = null;
        }
        return fKBottomLoft.k(i10, function0);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f12712d;
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
        TextView bottom_loft_title = (TextView) a(R$id.bottom_loft_title);
        s.h(bottom_loft_title, "bottom_loft_title");
        if (bottom_loft_title.getVisibility() == 0) {
            int i10 = R$id.bottom_loft_message;
            TextView bottom_loft_message = (TextView) a(i10);
            s.h(bottom_loft_message, "bottom_loft_message");
            if (bottom_loft_message.getVisibility() == 0) {
                TextView bottom_loft_message2 = (TextView) a(i10);
                s.h(bottom_loft_message2, "bottom_loft_message");
                y.m(bottom_loft_message2, null, Integer.valueOf(z0.h.c(this, 12.0f)), null, null, 13, null);
            }
        }
        TextView bottom_loft_positive_button = (TextView) a(R$id.bottom_loft_positive_button);
        s.h(bottom_loft_positive_button, "bottom_loft_positive_button");
        if (bottom_loft_positive_button.getVisibility() == 0) {
            int i11 = R$id.bottom_loft_negative_button;
            TextView bottom_loft_negative_button = (TextView) a(i11);
            s.h(bottom_loft_negative_button, "bottom_loft_negative_button");
            if (bottom_loft_negative_button.getVisibility() == 0) {
                TextView bottom_loft_negative_button2 = (TextView) a(i11);
                s.h(bottom_loft_negative_button2, "bottom_loft_negative_button");
                y.m(bottom_loft_negative_button2, null, Integer.valueOf(z0.h.c(this, 8.0f)), null, null, 13, null);
            }
        }
    }

    public final void c() {
        AlertDialog alertDialog = this.f12710b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    @NotNull
    public final FKBottomLoft d(boolean z10) {
        this.f12711c = z10;
        return this;
    }

    @NotNull
    public final FKBottomLoft e(@StringRes int i10, int i11, int i12) {
        int i13 = R$id.bottom_loft_message;
        ((TextView) a(i13)).setVisibility(0);
        ((TextView) a(i13)).setText(getContext().getString(i10));
        ((TextView) a(i13)).setTextColor(i11);
        if (Build.VERSION.SDK_INT >= 28) {
            ((TextView) a(i13)).setTypeface(Typeface.create(Typeface.DEFAULT, i12, false));
        } else {
            ((TextView) a(i13)).setTypeface(Typeface.DEFAULT);
        }
        return this;
    }

    @NotNull
    public final FKBottomLoft f(@Nullable CharSequence charSequence, int i10, int i11) {
        int i12 = R$id.bottom_loft_message;
        ((TextView) a(i12)).setVisibility(0);
        ((TextView) a(i12)).setText(charSequence);
        ((TextView) a(i12)).setTextColor(i10);
        if (Build.VERSION.SDK_INT >= 28) {
            ((TextView) a(i12)).setTypeface(Typeface.create(Typeface.DEFAULT, i11, false));
        } else {
            ((TextView) a(i12)).setTypeface(Typeface.DEFAULT);
        }
        ((TextView) a(i12)).setMovementMethod(LinkMovementMethod.getInstance());
        return this;
    }

    @NotNull
    public final FKBottomLoft i(@StringRes int i10, @Nullable final Function0<p> function0) {
        int i11 = R$id.bottom_loft_negative_button;
        ((TextView) a(i11)).setVisibility(0);
        ((TextView) a(i11)).setText(getContext().getString(i10));
        TextView bottom_loft_negative_button = (TextView) a(i11);
        s.h(bottom_loft_negative_button, "bottom_loft_negative_button");
        y.d(bottom_loft_negative_button, new Function1<View, p>() { // from class: com.cupidapp.live.base.view.dialog.FKBottomLoft$setNegativeButton$1
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
                this.c();
            }
        });
        return this;
    }

    @NotNull
    public final FKBottomLoft k(@StringRes int i10, @Nullable final Function0<p> function0) {
        int i11 = R$id.bottom_loft_positive_button;
        ((TextView) a(i11)).setVisibility(0);
        ((TextView) a(i11)).setText(getContext().getString(i10));
        TextView bottom_loft_positive_button = (TextView) a(i11);
        s.h(bottom_loft_positive_button, "bottom_loft_positive_button");
        y.d(bottom_loft_positive_button, new Function1<View, p>() { // from class: com.cupidapp.live.base.view.dialog.FKBottomLoft$setPositiveButton$1
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
                this.c();
            }
        });
        return this;
    }

    @NotNull
    public final FKBottomLoft m(@StringRes int i10) {
        int i11 = R$id.bottom_loft_title;
        ((TextView) a(i11)).setVisibility(0);
        ((TextView) a(i11)).setText(getContext().getString(i10));
        return this;
    }

    public final void n() {
        Window window;
        b();
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f12710b = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(this.f12711c);
        }
        AlertDialog alertDialog = this.f12710b;
        if (alertDialog != null) {
            alertDialog.show();
        }
        AlertDialog alertDialog2 = this.f12710b;
        if (alertDialog2 == null || (window = alertDialog2.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(-1, -2);
        window.setWindowAnimations(R$style.dialog_translate_anim);
        window.setGravity(80);
    }
}
