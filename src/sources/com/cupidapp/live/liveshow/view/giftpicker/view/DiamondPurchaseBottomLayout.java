package com.cupidapp.live.liveshow.view.giftpicker.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.vip.model.PayType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: DiamondPurchaseBottomLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class DiamondPurchaseBottomLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public PayType f15491b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Function0<p> f15492c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public String f15493d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15494e;

    /* compiled from: DiamondPurchaseBottomLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends ClickableSpan {
        public a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            s.i(widget, "widget");
            j.a.b(com.cupidapp.live.base.router.j.f12156c, DiamondPurchaseBottomLayout.this.getContext(), DiamondPurchaseBottomLayout.this.getAgreementUrl(), null, 4, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiamondPurchaseBottomLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15494e = new LinkedHashMap();
        this.f15491b = PayType.WeChatPay;
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15494e;
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

    public final void b(@NotNull String text) {
        s.i(text, "text");
        ((FKUniversalButton) a(R$id.confirm_pay_btn)).setText(text);
    }

    public final void c() {
        SpannableStringBuilder c4;
        z.a(this, R$layout.layout_diamond_purchase_bottom, true);
        int i10 = R$id.wechat_pay_textview;
        TextView wechat_pay_textview = (TextView) a(i10);
        s.h(wechat_pay_textview, "wechat_pay_textview");
        u.a(wechat_pay_textview);
        int i11 = R$id.ali_pay_textview;
        TextView ali_pay_textview = (TextView) a(i11);
        s.h(ali_pay_textview, "ali_pay_textview");
        u.a(ali_pay_textview);
        ((TextView) a(i10)).setSelected(true);
        int i12 = R$id.recharge_agreement_textview;
        TextView textView = (TextView) a(i12);
        q1.d dVar = q1.d.f53006a;
        String string = getContext().getString(R$string.recharge_diamond_agreement);
        s.h(string, "context.getString(R.stri…charge_diamond_agreement)");
        String string2 = getContext().getString(R$string.diamond_agreement);
        s.h(string2, "context.getString(R.string.diamond_agreement)");
        c4 = dVar.c(string, kotlin.collections.s.o(string2), (r18 & 4) != 0 ? null : -12566464, (r18 & 8) != 0 ? null : -1, (r18 & 16) != 0 ? false : false, (r18 & 32) != 0 ? null : kotlin.collections.s.o(new a()), (r18 & 64) != 0 ? null : null);
        textView.setText(c4);
        ((TextView) a(i12)).setMovementMethod(LinkMovementMethod.getInstance());
        TextView wechat_pay_textview2 = (TextView) a(i10);
        s.h(wechat_pay_textview2, "wechat_pay_textview");
        y.d(wechat_pay_textview2, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.DiamondPurchaseBottomLayout$initView$2
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
                DiamondPurchaseBottomLayout diamondPurchaseBottomLayout = DiamondPurchaseBottomLayout.this;
                int i13 = R$id.wechat_pay_textview;
                if (((TextView) diamondPurchaseBottomLayout.a(i13)).isSelected()) {
                    return;
                }
                DiamondPurchaseBottomLayout.this.setPayType(PayType.WeChatPay);
                ((TextView) DiamondPurchaseBottomLayout.this.a(i13)).setSelected(true);
                ((TextView) DiamondPurchaseBottomLayout.this.a(R$id.ali_pay_textview)).setSelected(false);
            }
        });
        TextView ali_pay_textview2 = (TextView) a(i11);
        s.h(ali_pay_textview2, "ali_pay_textview");
        y.d(ali_pay_textview2, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.DiamondPurchaseBottomLayout$initView$3
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
                DiamondPurchaseBottomLayout diamondPurchaseBottomLayout = DiamondPurchaseBottomLayout.this;
                int i13 = R$id.ali_pay_textview;
                if (((TextView) diamondPurchaseBottomLayout.a(i13)).isSelected()) {
                    return;
                }
                DiamondPurchaseBottomLayout.this.setPayType(PayType.AliPay);
                ((TextView) DiamondPurchaseBottomLayout.this.a(i13)).setSelected(true);
                ((TextView) DiamondPurchaseBottomLayout.this.a(R$id.wechat_pay_textview)).setSelected(false);
            }
        });
        FKUniversalButton confirm_pay_btn = (FKUniversalButton) a(R$id.confirm_pay_btn);
        s.h(confirm_pay_btn, "confirm_pay_btn");
        y.d(confirm_pay_btn, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.DiamondPurchaseBottomLayout$initView$4
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
                Function0<p> createOrder = DiamondPurchaseBottomLayout.this.getCreateOrder();
                if (createOrder != null) {
                    createOrder.invoke();
                }
            }
        });
    }

    @Nullable
    public final String getAgreementUrl() {
        return this.f15493d;
    }

    @Nullable
    public final Function0<p> getCreateOrder() {
        return this.f15492c;
    }

    @NotNull
    public final PayType getPayType() {
        return this.f15491b;
    }

    public final void setAgreementUrl(@Nullable String str) {
        this.f15493d = str;
    }

    public final void setCreateOrder(@Nullable Function0<p> function0) {
        this.f15492c = function0;
    }

    public final void setPayType(@NotNull PayType payType) {
        s.i(payType, "<set-?>");
        this.f15491b = payType;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiamondPurchaseBottomLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15494e = new LinkedHashMap();
        this.f15491b = PayType.WeChatPay;
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiamondPurchaseBottomLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15494e = new LinkedHashMap();
        this.f15491b = PayType.WeChatPay;
        c();
    }
}
