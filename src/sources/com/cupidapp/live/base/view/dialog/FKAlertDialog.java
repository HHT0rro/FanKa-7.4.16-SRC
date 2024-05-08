package com.cupidapp.live.base.view.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
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

/* compiled from: FKAlertDialog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKAlertDialog extends FrameLayout implements com.cupidapp.live.base.fragment.d {

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public static final a f12698l = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public AlertDialog f12699b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12700c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f12701d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f12702e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public Function0<p> f12703f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public Function0<p> f12704g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public Function0<p> f12705h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public Function0<p> f12706i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f12707j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12708k;

    /* compiled from: FKAlertDialog.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ FKAlertDialog c(a aVar, Context context, boolean z10, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                z10 = true;
            }
            return aVar.b(context, z10);
        }

        public final void a(@NotNull View view) {
            s.i(view, "view");
            y.o(view, Integer.valueOf((int) (z0.h.l(this) * 0.68f)), null, 2, null);
        }

        @NotNull
        public final FKAlertDialog b(@Nullable Context context, boolean z10) {
            if (context == null) {
                context = AppApplication.f11612d.h();
            }
            FKAlertDialog fKAlertDialog = new FKAlertDialog(context, null);
            fKAlertDialog.f12702e = z10;
            return fKAlertDialog;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKAlertDialog(Context context) {
        super(context);
        this.f12708k = new LinkedHashMap();
        this.f12700c = true;
        this.f12701d = true;
        this.f12702e = true;
        h();
    }

    public /* synthetic */ FKAlertDialog(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FKAlertDialog A(FKAlertDialog fKAlertDialog, int i10, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 2131886528;
        }
        if ((i11 & 2) != 0) {
            function1 = null;
        }
        return fKAlertDialog.z(i10, function1);
    }

    public static /* synthetic */ void G(FKAlertDialog fKAlertDialog, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = null;
        }
        fKAlertDialog.F(num);
    }

    public static final void H(FKAlertDialog this$0, DialogInterface dialogInterface) {
        s.i(this$0, "this$0");
        if (this$0.f12707j) {
            com.cupidapp.live.base.fragment.b.f11807a.a(this$0);
        }
        Function0<p> function0 = this$0.f12703f;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static final void I(FKAlertDialog this$0, DialogInterface dialogInterface) {
        s.i(this$0, "this$0");
        if (this$0.f12707j) {
            com.cupidapp.live.base.fragment.b.f11807a.d(this$0);
        }
        Function0<p> function0 = this$0.f12704g;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static final boolean J(FKAlertDialog this$0, DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        s.i(this$0, "this$0");
        if (i10 != 4 || keyEvent.getAction() != 1 || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        Function0<p> function0 = this$0.f12705h;
        if (function0 != null) {
            if (function0 == null) {
                return false;
            }
            function0.invoke();
            return false;
        }
        Function0<p> function02 = this$0.f12706i;
        if (function02 == null) {
            return false;
        }
        function02.invoke();
        return false;
    }

    private final TextView getMainBtn() {
        TextView textView;
        String str;
        if (this.f12702e) {
            textView = (TextView) d(R$id.horizontal_main_button);
            str = "horizontal_main_button";
        } else {
            textView = (TextView) d(R$id.vertical_main_button);
            str = "vertical_main_button";
        }
        s.h(textView, str);
        return textView;
    }

    private final TextView getSecondaryBtn() {
        TextView textView;
        String str;
        if (this.f12702e) {
            textView = (TextView) d(R$id.horizontal_secondary_button);
            str = "horizontal_secondary_button";
        } else {
            textView = (TextView) d(R$id.vertical_secondary_button);
            str = "vertical_secondary_button";
        }
        s.h(textView, str);
        return textView;
    }

    public static /* synthetic */ FKAlertDialog o(FKAlertDialog fKAlertDialog, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 17;
        }
        return fKAlertDialog.l(i10, i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FKAlertDialog r(FKAlertDialog fKAlertDialog, int i10, Function0 function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 2131886363;
        }
        if ((i11 & 2) != 0) {
            function0 = null;
        }
        return fKAlertDialog.q(i10, function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FKAlertDialog w(FKAlertDialog fKAlertDialog, int i10, Integer num, Function0 function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 2131886528;
        }
        if ((i11 & 2) != 0) {
            num = null;
        }
        if ((i11 & 4) != 0) {
            function0 = null;
        }
        return fKAlertDialog.v(i10, num, function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FKAlertDialog y(FKAlertDialog fKAlertDialog, String str, String str2, Function0 function0, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "确认";
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            function0 = null;
        }
        return fKAlertDialog.x(str, str2, function0);
    }

    @NotNull
    public final FKAlertDialog B(@StringRes int i10, @Nullable final Function0<p> function0) {
        int i11 = R$id.secondary_operation_text;
        ((TextView) d(i11)).setVisibility(0);
        ((TextView) d(i11)).setText(getContext().getString(i10));
        TextView secondary_operation_text = (TextView) d(i11);
        s.h(secondary_operation_text, "secondary_operation_text");
        y.d(secondary_operation_text, new Function1<View, p>() { // from class: com.cupidapp.live.base.view.dialog.FKAlertDialog$setSecondaryOperationText$1
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
                boolean z10;
                Function0<p> function02 = function0;
                if (function02 != null) {
                    function02.invoke();
                }
                z10 = this.f12701d;
                if (z10) {
                    this.g();
                }
            }
        });
        return this;
    }

    @NotNull
    public final FKAlertDialog C(boolean z10, @StringRes int i10) {
        if (z10) {
            int i11 = R$id.alert_dialog_check_box;
            ((ImageView) d(i11)).setVisibility(0);
            ImageView alert_dialog_check_box = (ImageView) d(i11);
            s.h(alert_dialog_check_box, "alert_dialog_check_box");
            y.d(alert_dialog_check_box, new Function1<View, p>() { // from class: com.cupidapp.live.base.view.dialog.FKAlertDialog$setShowCheckBox$1
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
                    ((ImageView) FKAlertDialog.this.d(R$id.alert_dialog_check_box)).setSelected(!((ImageView) FKAlertDialog.this.d(r0)).isSelected());
                }
            });
            int i12 = R$id.alert_dialog_check_box_text;
            ((TextView) d(i12)).setVisibility(0);
            ((TextView) d(i12)).setText(getContext().getString(i10));
        }
        return this;
    }

    @NotNull
    public final FKAlertDialog D(@StringRes int i10) {
        int i11 = R$id.alert_dialog_title_text;
        ((TextView) d(i11)).setVisibility(0);
        ((TextView) d(i11)).setText(getContext().getString(i10));
        return this;
    }

    @NotNull
    public final FKAlertDialog E(@Nullable String str) {
        int i10 = R$id.alert_dialog_title_text;
        ((TextView) d(i10)).setVisibility(0);
        ((TextView) d(i10)).setText(str);
        return this;
    }

    public final void F(@StyleRes @Nullable Integer num) {
        Window window;
        AlertDialog alertDialog;
        AlertDialog create = z0.b.f54812a.f(getContext(), num).setView(this).create();
        this.f12699b = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(this.f12700c);
        }
        AlertDialog alertDialog2 = this.f12699b;
        if (alertDialog2 != null) {
            alertDialog2.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.cupidapp.live.base.view.dialog.e
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    FKAlertDialog.H(FKAlertDialog.this, dialogInterface);
                }
            });
        }
        AlertDialog alertDialog3 = this.f12699b;
        if (alertDialog3 != null) {
            alertDialog3.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.cupidapp.live.base.view.dialog.c
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    FKAlertDialog.I(FKAlertDialog.this, dialogInterface);
                }
            });
        }
        if (!this.f12700c && (alertDialog = this.f12699b) != null) {
            alertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.cupidapp.live.base.view.dialog.d
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                    boolean J;
                    J = FKAlertDialog.J(FKAlertDialog.this, dialogInterface, i10, keyEvent);
                    return J;
                }
            });
        }
        AlertDialog alertDialog4 = this.f12699b;
        if (alertDialog4 != null) {
            alertDialog4.show();
        }
        AlertDialog alertDialog5 = this.f12699b;
        if (alertDialog5 == null || (window = alertDialog5.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(-1, -2);
    }

    @Override // com.cupidapp.live.base.fragment.d
    public void L() {
        try {
            g();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Nullable
    public View d(int i10) {
        Map<Integer, View> map = this.f12708k;
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

    public final void g() {
        AlertDialog alertDialog = this.f12699b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public final void h() {
        z.a(this, R$layout.layout_alert_dialog, true);
        a aVar = f12698l;
        ConstraintLayout alert_dialog_root_layout = (ConstraintLayout) d(R$id.alert_dialog_root_layout);
        s.h(alert_dialog_root_layout, "alert_dialog_root_layout");
        aVar.a(alert_dialog_root_layout);
    }

    public final boolean i() {
        AlertDialog alertDialog = this.f12699b;
        if (alertDialog != null) {
            return alertDialog.isShowing();
        }
        return false;
    }

    @NotNull
    public final FKAlertDialog j(boolean z10) {
        this.f12700c = z10;
        return this;
    }

    @NotNull
    public final FKAlertDialog k(boolean z10) {
        this.f12707j = z10;
        return this;
    }

    @NotNull
    public final FKAlertDialog l(@StringRes int i10, int i11) {
        int i12 = R$id.alert_dialog_message_text;
        ((TextView) d(i12)).setVisibility(0);
        ((TextView) d(i12)).setText(getContext().getString(i10));
        ((TextView) d(i12)).setGravity(i11);
        return this;
    }

    @NotNull
    public final FKAlertDialog m(@Nullable CharSequence charSequence, boolean z10) {
        int i10 = R$id.alert_dialog_message_text;
        ((TextView) d(i10)).setVisibility(0);
        ((TextView) d(i10)).setText(charSequence);
        if (z10) {
            ((TextView) d(i10)).setMovementMethod(LinkMovementMethod.getInstance());
        }
        return this;
    }

    @NotNull
    public final FKAlertDialog n(@Nullable String str) {
        int i10 = R$id.alert_dialog_message_text;
        ((TextView) d(i10)).setVisibility(0);
        ((TextView) d(i10)).setText(str);
        return this;
    }

    @NotNull
    public final FKAlertDialog p(boolean z10) {
        this.f12701d = z10;
        return this;
    }

    @NotNull
    public final FKAlertDialog q(@StringRes int i10, @Nullable final Function0<p> function0) {
        this.f12705h = function0;
        TextView secondaryBtn = getSecondaryBtn();
        secondaryBtn.setVisibility(0);
        secondaryBtn.setText(getContext().getString(i10));
        y.d(secondaryBtn, new Function1<View, p>() { // from class: com.cupidapp.live.base.view.dialog.FKAlertDialog$setNegativeButton$1
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
                boolean z10;
                Function0<p> function02 = function0;
                if (function02 != null) {
                    function02.invoke();
                }
                z10 = this.f12701d;
                if (z10) {
                    this.g();
                }
            }
        });
        return this;
    }

    @NotNull
    public final FKAlertDialog s(@Nullable String str, @Nullable final Function0<p> function0) {
        this.f12705h = function0;
        TextView secondaryBtn = getSecondaryBtn();
        secondaryBtn.setVisibility(0);
        secondaryBtn.setText(str);
        y.d(secondaryBtn, new Function1<View, p>() { // from class: com.cupidapp.live.base.view.dialog.FKAlertDialog$setNegativeButtonOfStr$1
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
                boolean z10;
                Function0<p> function02 = function0;
                if (function02 != null) {
                    function02.invoke();
                }
                z10 = this.f12701d;
                if (z10) {
                    this.g();
                }
            }
        });
        return this;
    }

    @NotNull
    public final FKAlertDialog t(@NotNull Function0<p> listener) {
        s.i(listener, "listener");
        this.f12706i = listener;
        return this;
    }

    @NotNull
    public final FKAlertDialog u(@NotNull Function0<p> listener) {
        s.i(listener, "listener");
        this.f12703f = listener;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final FKAlertDialog v(@StringRes int i10, @StringRes @Nullable Integer num, @Nullable final Function0<p> function0) {
        LinearLayout mainBtn;
        if (this.f12702e) {
            TextView textView = (TextView) d(R$id.horizontal_main_button);
            textView.setText(textView.getContext().getString(i10));
            mainBtn = textView;
        } else {
            ((TextView) d(R$id.vertical_main_button)).setText(getContext().getString(i10));
            if (num != null) {
                int i11 = R$id.secondary_text;
                ((TextView) d(i11)).setVisibility(0);
                ((TextView) d(i11)).setText(getContext().getString(num.intValue()));
            }
            mainBtn = (LinearLayout) d(R$id.vertical_main_button_layout);
        }
        mainBtn.setVisibility(0);
        s.h(mainBtn, "mainBtn");
        y.d(mainBtn, new Function1<View, p>() { // from class: com.cupidapp.live.base.view.dialog.FKAlertDialog$setPositiveButton$1
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
                boolean z10;
                Function0<p> function02 = function0;
                if (function02 != null) {
                    function02.invoke();
                }
                z10 = this.f12701d;
                if (z10) {
                    this.g();
                }
            }
        });
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final FKAlertDialog x(@Nullable String str, @Nullable String str2, @Nullable final Function0<p> function0) {
        LinearLayout mainBtn;
        if (this.f12702e) {
            TextView textView = (TextView) d(R$id.horizontal_main_button);
            textView.setText(str);
            mainBtn = textView;
        } else {
            ((TextView) d(R$id.vertical_main_button)).setText(str);
            if (!(str2 == null || str2.length() == 0)) {
                int i10 = R$id.secondary_text;
                ((TextView) d(i10)).setVisibility(0);
                ((TextView) d(i10)).setText(str2);
            }
            mainBtn = (LinearLayout) d(R$id.vertical_main_button_layout);
        }
        mainBtn.setVisibility(0);
        s.h(mainBtn, "mainBtn");
        y.d(mainBtn, new Function1<View, p>() { // from class: com.cupidapp.live.base.view.dialog.FKAlertDialog$setPositiveButtonOfStr$1
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
                boolean z10;
                Function0<p> function02 = function0;
                if (function02 != null) {
                    function02.invoke();
                }
                z10 = this.f12701d;
                if (z10) {
                    this.g();
                }
            }
        });
        return this;
    }

    @NotNull
    public final FKAlertDialog z(@StringRes int i10, @Nullable final Function1<? super Boolean, p> function1) {
        TextView mainBtn = getMainBtn();
        mainBtn.setVisibility(0);
        mainBtn.setText(getContext().getString(i10));
        y.d(mainBtn, new Function1<View, p>() { // from class: com.cupidapp.live.base.view.dialog.FKAlertDialog$setPositiveButtonWithCheckBoxState$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                boolean z10;
                Function1<Boolean, p> function12 = function1;
                if (function12 != null) {
                    function12.invoke(Boolean.valueOf(((ImageView) this.d(R$id.alert_dialog_check_box)).isSelected()));
                }
                z10 = this.f12701d;
                if (z10) {
                    this.g();
                }
            }
        });
        return this;
    }
}
