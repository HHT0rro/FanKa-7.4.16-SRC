package com.cupidapp.live.liveshow.view.giftpicker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.web.WebStyleEnum;
import com.cupidapp.live.base.web.WebStyleViewModel;
import com.cupidapp.live.liveshow.model.SendGiftCountModel;
import com.cupidapp.live.liveshow.view.giftpicker.fragment.RechargeDiamondSuccessEvent;
import com.cupidapp.live.track.group.GroupRechargeLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.o;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: FKSendGiftBottomMenuLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKSendGiftBottomMenuLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public k f15543d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f15544e;

    /* renamed from: f, reason: collision with root package name */
    public int f15545f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15546g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSendGiftBottomMenuLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15546g = new LinkedHashMap();
        this.f15545f = 1;
        k();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f15546g;
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

    public final void f() {
        int i10 = R$id.recharge_layout;
        LinearLayout recharge_layout = (LinearLayout) e(i10);
        s.h(recharge_layout, "recharge_layout");
        y.d(recharge_layout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.FKSendGiftBottomMenuLayout$bindClickEvent$1
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
                ConstantsUrlModel urlModel;
                String urlPurchasePay;
                GroupRechargeLog.f18707a.a(GroupRechargeLog.DiamondEntrance.LIVE);
                SensorsLogKeyButtonClick.LiveShowRoom.RechargePackage.click();
                ConstantsResult q10 = p1.g.f52734a.q();
                if (q10 == null || (urlModel = q10.getUrlModel()) == null || (urlPurchasePay = urlModel.getUrlPurchasePay()) == null) {
                    return;
                }
                com.cupidapp.live.base.router.j.f12156c.a(FKSendGiftBottomMenuLayout.this.getContext(), urlPurchasePay, new WebStyleViewModel(WebStyleEnum.BottomToTopStyle, false, null, 6, null));
            }
        });
        LinearLayout select_count_layout = (LinearLayout) e(R$id.select_count_layout);
        s.h(select_count_layout, "select_count_layout");
        y.d(select_count_layout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.FKSendGiftBottomMenuLayout$bindClickEvent$2
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
                int[] iArr = new int[2];
                ((TextView) FKSendGiftBottomMenuLayout.this.e(R$id.select_gift_count_btn)).getLocationInWindow(iArr);
                int i11 = iArr[1];
                k sendGiftListener = FKSendGiftBottomMenuLayout.this.getSendGiftListener();
                if (sendGiftListener != null) {
                    sendGiftListener.a(i11);
                }
            }
        });
        TextView send_gift_btn = (TextView) e(R$id.send_gift_btn);
        s.h(send_gift_btn, "send_gift_btn");
        y.d(send_gift_btn, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.FKSendGiftBottomMenuLayout$bindClickEvent$3
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
                k sendGiftListener = FKSendGiftBottomMenuLayout.this.getSendGiftListener();
                if (sendGiftListener != null) {
                    sendGiftListener.c();
                }
            }
        });
        LinearLayout recharge_layout2 = (LinearLayout) e(i10);
        s.h(recharge_layout2, "recharge_layout");
        y.d(recharge_layout2, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.FKSendGiftBottomMenuLayout$bindClickEvent$4
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
                k sendGiftListener = FKSendGiftBottomMenuLayout.this.getSendGiftListener();
                if (sendGiftListener != null) {
                    sendGiftListener.b();
                }
            }
        });
    }

    public final void g(boolean z10, @NotNull List<SendGiftCountModel> bulkGiftsCountDesc, boolean z11) {
        s.i(bulkGiftsCountDesc, "bulkGiftsCountDesc");
        if (z10) {
            SendGiftCountModel sendGiftCountModel = (SendGiftCountModel) CollectionsKt___CollectionsKt.f0(bulkGiftsCountDesc);
            this.f15545f = sendGiftCountModel != null ? sendGiftCountModel.getCount() : 1;
            ((TextView) e(R$id.select_gift_count_btn)).setText(String.valueOf(this.f15545f));
        }
        h(z11);
    }

    public final boolean getOpenBulkGiftsSwitch() {
        return this.f15544e;
    }

    @Nullable
    public final k getSendGiftListener() {
        return this.f15543d;
    }

    public final void h(boolean z10) {
        String string;
        ImageView first_recharge_imageview = (ImageView) e(R$id.first_recharge_imageview);
        s.h(first_recharge_imageview, "first_recharge_imageview");
        first_recharge_imageview.setVisibility(z10 ? 0 : 8);
        TextView textView = (TextView) e(R$id.recharge_textview);
        if (z10) {
            string = getContext().getString(R$string.recharge_with_courtesy);
        } else {
            string = getContext().getString(R$string.recharge);
        }
        textView.setText(string);
    }

    public final void i(boolean z10, @NotNull String buttonText, boolean z11, int i10, boolean z12) {
        s.i(buttonText, "buttonText");
        int i11 = R$id.send_gift_btn;
        ((TextView) e(i11)).setVisibility(0);
        if (z10) {
            if (this.f15544e && z11 && i10 == 0 && !z12) {
                ((LinearLayout) e(R$id.select_count_layout)).setVisibility(0);
                Integer j10 = o.j(((TextView) e(R$id.select_gift_count_btn)).getText().toString());
                this.f15545f = j10 != null ? j10.intValue() : 1;
            } else {
                ((LinearLayout) e(R$id.select_count_layout)).setVisibility(8);
                this.f15545f = 1;
            }
            ((TextView) e(i11)).setBackgroundResource(R$drawable.rect_cor_6_l2r_ff6139_ff2d62);
            ((TextView) e(i11)).setTextColor(-1);
        } else {
            ((LinearLayout) e(R$id.select_count_layout)).setVisibility(8);
            ((TextView) e(i11)).setBackgroundResource(R$drawable.rect_cor_6_sd_12ffffff);
            ((TextView) e(i11)).setTextColor(-7829368);
        }
        ((TextView) e(i11)).setText(buttonText);
    }

    public final void k() {
        z.a(this, R$layout.layout_send_gift_bottom_menu, true);
        TextView recharge_textview = (TextView) e(R$id.recharge_textview);
        s.h(recharge_textview, "recharge_textview");
        u.a(recharge_textview);
        TextView select_gift_count_btn = (TextView) e(R$id.select_gift_count_btn);
        s.h(select_gift_count_btn, "select_gift_count_btn");
        u.a(select_gift_count_btn);
        TextView send_gift_btn = (TextView) e(R$id.send_gift_btn);
        s.h(send_gift_btn, "send_gift_btn");
        u.a(send_gift_btn);
        f();
    }

    public final void l(boolean z10) {
        ((ImageView) e(R$id.select_count_imageview)).setRotation(z10 ? 180.0f : 0.0f);
    }

    public final void m(boolean z10) {
        ((TextView) e(R$id.send_gift_btn)).setVisibility(z10 ? 0 : 4);
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull RechargeDiamondSuccessEvent event) {
        s.i(event, "event");
        h(false);
    }

    public final void setGiftCountText(int i10) {
        ((TextView) e(R$id.select_gift_count_btn)).setText(String.valueOf(i10));
    }

    public final void setOpenBulkGiftsSwitch(boolean z10) {
        this.f15544e = z10;
    }

    public final void setSendGiftListener(@Nullable k kVar) {
        this.f15543d = kVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSendGiftBottomMenuLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15546g = new LinkedHashMap();
        this.f15545f = 1;
        k();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSendGiftBottomMenuLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15546g = new LinkedHashMap();
        this.f15545f = 1;
        k();
    }
}
