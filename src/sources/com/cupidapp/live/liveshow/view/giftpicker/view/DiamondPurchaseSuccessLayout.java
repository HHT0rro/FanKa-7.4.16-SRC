package com.cupidapp.live.liveshow.view.giftpicker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.liveshow.view.giftpicker.model.SendGiftModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: DiamondPurchaseSuccessLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class DiamondPurchaseSuccessLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function1<? super SendGiftModel, p> f15496b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public SendGiftModel f15497c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15498d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiamondPurchaseSuccessLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15498d = new LinkedHashMap();
        d();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15498d;
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

    public final void c(@Nullable SendGiftModel sendGiftModel) {
        this.f15497c = sendGiftModel;
        if (sendGiftModel == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        ((TextView) a(R$id.send_gift_title_textview)).setText(getContext().getString(R$string.send_gift_to_anchor, sendGiftModel.getName()));
        ImageLoaderView send_gift_imageview = (ImageLoaderView) a(R$id.send_gift_imageview);
        s.h(send_gift_imageview, "send_gift_imageview");
        ImageLoaderView.g(send_gift_imageview, sendGiftModel.getImage(), null, null, 6, null);
        ((FKUniversalButton) a(R$id.confirm_send_btn)).setText(getContext().getString(R$string.confirm_send_gift, Integer.valueOf(sendGiftModel.getPrice())));
    }

    public final void d() {
        z.a(this, R$layout.layout_diamond_purchase_success, true);
        setVisibility(8);
        TextView send_gift_title_textview = (TextView) a(R$id.send_gift_title_textview);
        s.h(send_gift_title_textview, "send_gift_title_textview");
        u.a(send_gift_title_textview);
        FKUniversalButton confirm_send_btn = (FKUniversalButton) a(R$id.confirm_send_btn);
        s.h(confirm_send_btn, "confirm_send_btn");
        y.d(confirm_send_btn, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.DiamondPurchaseSuccessLayout$initView$1
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
                SendGiftModel sendGiftModel;
                sendGiftModel = DiamondPurchaseSuccessLayout.this.f15497c;
                if (sendGiftModel != null) {
                    Function1<SendGiftModel, p> confirmSendClick = DiamondPurchaseSuccessLayout.this.getConfirmSendClick();
                    if (confirmSendClick != null) {
                        confirmSendClick.invoke(sendGiftModel);
                    }
                    j1.i.d(j1.i.f50236a, PopupName.RECHARGE_WITH_GIFT_SUCCESS, PopupButtonName.Send, null, 4, null);
                }
            }
        });
    }

    @Nullable
    public final Function1<SendGiftModel, p> getConfirmSendClick() {
        return this.f15496b;
    }

    public final void setConfirmSendClick(@Nullable Function1<? super SendGiftModel, p> function1) {
        this.f15496b = function1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiamondPurchaseSuccessLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15498d = new LinkedHashMap();
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiamondPurchaseSuccessLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15498d = new LinkedHashMap();
        d();
    }
}
