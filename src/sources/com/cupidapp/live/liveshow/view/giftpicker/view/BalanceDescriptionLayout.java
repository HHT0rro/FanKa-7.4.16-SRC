package com.cupidapp.live.liveshow.view.giftpicker.view;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.liveshow.view.giftpicker.model.BalanceModel;
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

/* compiled from: BalanceDescriptionLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class BalanceDescriptionLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final Companion f15474d = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public static AlertDialog f15475e;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function0<p> f15476b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15477c;

    /* compiled from: BalanceDescriptionLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context, @Nullable BalanceModel balanceModel) {
            Window window;
            if (context == null || balanceModel == null) {
                return;
            }
            AlertDialog alertDialog = BalanceDescriptionLayout.f15475e;
            if (alertDialog != null && alertDialog.isShowing()) {
                return;
            }
            BalanceDescriptionLayout balanceDescriptionLayout = new BalanceDescriptionLayout(context);
            balanceDescriptionLayout.f(balanceModel);
            balanceDescriptionLayout.f15476b = new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.BalanceDescriptionLayout$Companion$show$layout$1$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AlertDialog alertDialog2 = BalanceDescriptionLayout.f15475e;
                    if (alertDialog2 != null) {
                        alertDialog2.dismiss();
                    }
                }
            };
            BalanceDescriptionLayout.f15475e = z0.b.f54812a.e(context).setView(balanceDescriptionLayout).create();
            AlertDialog alertDialog2 = BalanceDescriptionLayout.f15475e;
            if (alertDialog2 != null) {
                alertDialog2.show();
            }
            AlertDialog alertDialog3 = BalanceDescriptionLayout.f15475e;
            if (alertDialog3 == null || (window = alertDialog3.getWindow()) == null) {
                return;
            }
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(z0.h.c(window, 300.0f), -2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BalanceDescriptionLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15477c = new LinkedHashMap();
        g();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15477c;
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

    public final void f(@NotNull BalanceModel balanceModel) {
        s.i(balanceModel, "balanceModel");
        ((TextView) a(R$id.universal_balance_count_textview)).setText(String.valueOf(balanceModel.getGenericBalance()));
        ((TextView) a(R$id.others_balance_count_textview)).setText(String.valueOf(balanceModel.getNobilityBalance()));
        ((TextView) a(R$id.description_textview)).setText(balanceModel.getTips());
    }

    public final void g() {
        z.a(this, R$layout.layout_balance_description, true);
        ((TextView) a(R$id.balance_description_title)).getPaint().setFakeBoldText(true);
        ((TextView) a(R$id.universal_balance_count_textview)).getPaint().setFakeBoldText(true);
        ((TextView) a(R$id.others_balance_count_textview)).getPaint().setFakeBoldText(true);
        FKUniversalButton know_btn = (FKUniversalButton) a(R$id.know_btn);
        s.h(know_btn, "know_btn");
        y.d(know_btn, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.BalanceDescriptionLayout$initView$1
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
                Function0 function0;
                function0 = BalanceDescriptionLayout.this.f15476b;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BalanceDescriptionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15477c = new LinkedHashMap();
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BalanceDescriptionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15477c = new LinkedHashMap();
        g();
    }
}
