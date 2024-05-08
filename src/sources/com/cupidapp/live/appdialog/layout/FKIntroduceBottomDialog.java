package com.cupidapp.live.appdialog.layout;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKIntroduceBottomDialog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKIntroduceBottomDialog extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f11681e = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public AlertDialog f11682b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11683c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f11684d;

    /* compiled from: FKIntroduceBottomDialog.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKIntroduceBottomDialog a(@Nullable Context context) {
            if (context == null) {
                context = AppApplication.f11612d.h();
            }
            return new FKIntroduceBottomDialog(context, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKIntroduceBottomDialog(Context context) {
        super(context);
        this.f11684d = new LinkedHashMap();
        this.f11683c = true;
        c();
    }

    public /* synthetic */ FKIntroduceBottomDialog(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f11684d;
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

    public final void c() {
        z.a(this, R$layout.dialog_introduce_bottom, true);
        TextView dialog_bottom_btn = (TextView) a(R$id.dialog_bottom_btn);
        kotlin.jvm.internal.s.h(dialog_bottom_btn, "dialog_bottom_btn");
        y.d(dialog_bottom_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.appdialog.layout.FKIntroduceBottomDialog$initView$1
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
                AlertDialog alertDialog;
                alertDialog = FKIntroduceBottomDialog.this.f11682b;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
    }

    @NotNull
    public final FKIntroduceBottomDialog d(@NotNull View view) {
        kotlin.jvm.internal.s.i(view, "view");
        int i10 = R$id.dialog_bottom_content_rl;
        ((RelativeLayout) a(i10)).removeAllViews();
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        ((RelativeLayout) a(i10)).addView(view);
        return this;
    }

    @NotNull
    public final FKIntroduceBottomDialog e(@StringRes int i10) {
        int i11 = R$id.dialog_bottom_title;
        ((TextView) a(i11)).setVisibility(0);
        ((TextView) a(i11)).setText(getContext().getString(i10));
        ((TextView) a(i11)).getPaint().setFakeBoldText(true);
        ((TextView) a(i11)).setVisibility(0);
        return this;
    }

    public final void f() {
        Window window;
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f11682b = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(this.f11683c);
        }
        AlertDialog alertDialog = this.f11682b;
        if (alertDialog != null) {
            alertDialog.show();
        }
        AlertDialog alertDialog2 = this.f11682b;
        if (alertDialog2 == null || (window = alertDialog2.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(-1, -2);
        window.setGravity(80);
    }
}
