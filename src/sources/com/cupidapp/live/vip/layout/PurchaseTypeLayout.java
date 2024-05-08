package com.cupidapp.live.vip.layout;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.R$style;
import com.cupidapp.live.vip.model.PayType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: PurchaseTypeLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PurchaseTypeLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18771b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PurchaseTypeLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18771b = new LinkedHashMap();
        b();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f18771b;
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
        z.a(this, R$layout.layout_vip_purchase_type, true);
        TextView aliPayTextView = (TextView) a(R$id.aliPayTextView);
        s.h(aliPayTextView, "aliPayTextView");
        u.a(aliPayTextView);
        TextView weChatPayTextView = (TextView) a(R$id.weChatPayTextView);
        s.h(weChatPayTextView, "weChatPayTextView");
        u.a(weChatPayTextView);
        TextView huaBeiPayTextView = (TextView) a(R$id.huaBeiPayTextView);
        s.h(huaBeiPayTextView, "huaBeiPayTextView");
        u.a(huaBeiPayTextView);
    }

    public final void c(@NotNull final Function2<? super String, ? super PayType, p> purchaseTypeClickCallback) {
        s.i(purchaseTypeClickCallback, "purchaseTypeClickCallback");
        final AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        create.show();
        Window window = create.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        Window window2 = create.getWindow();
        if (window2 != null) {
            window2.setLayout(-1, -2);
        }
        Window window3 = create.getWindow();
        if (window3 != null) {
            window3.setWindowAnimations(R$style.dialog_no_animation);
        }
        RelativeLayout aliPayLayout = (RelativeLayout) a(R$id.aliPayLayout);
        s.h(aliPayLayout, "aliPayLayout");
        y.d(aliPayLayout, new Function1<View, p>() { // from class: com.cupidapp.live.vip.layout.PurchaseTypeLayout$showVipPurchaseType$1
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
                create.dismiss();
                Function2<String, PayType, p> function2 = purchaseTypeClickCallback;
                String string = this.getContext().getString(R$string.aliPay);
                s.h(string, "context.getString(R.string.aliPay)");
                function2.mo1743invoke(string, PayType.AliPay);
            }
        });
        RelativeLayout weChatPayLayout = (RelativeLayout) a(R$id.weChatPayLayout);
        s.h(weChatPayLayout, "weChatPayLayout");
        y.d(weChatPayLayout, new Function1<View, p>() { // from class: com.cupidapp.live.vip.layout.PurchaseTypeLayout$showVipPurchaseType$2
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
                create.dismiss();
                Function2<String, PayType, p> function2 = purchaseTypeClickCallback;
                String string = this.getContext().getString(R$string.weChat_pay);
                s.h(string, "context.getString(R.string.weChat_pay)");
                function2.mo1743invoke(string, PayType.WeChatPay);
            }
        });
        RelativeLayout huaBeiPayLayout = (RelativeLayout) a(R$id.huaBeiPayLayout);
        s.h(huaBeiPayLayout, "huaBeiPayLayout");
        y.d(huaBeiPayLayout, new Function1<View, p>() { // from class: com.cupidapp.live.vip.layout.PurchaseTypeLayout$showVipPurchaseType$3
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
                create.dismiss();
                Function2<String, PayType, p> function2 = purchaseTypeClickCallback;
                String string = this.getContext().getString(R$string.hua_bei_pay);
                s.h(string, "context.getString(R.string.hua_bei_pay)");
                function2.mo1743invoke(string, PayType.AliPayHuaBei);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PurchaseTypeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18771b = new LinkedHashMap();
        b();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PurchaseTypeLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18771b = new LinkedHashMap();
        b();
    }
}
