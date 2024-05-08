package com.cupidapp.live.liveshow.view.giftpicker.view;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.model.SendGiftResult;
import com.cupidapp.live.liveshow.view.giftpicker.model.SendGiftModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u2.a;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: SendGiftConfirmLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SendGiftConfirmLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public SendGiftModel f15583d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public AlertDialog f15584e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15585f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15586g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendGiftConfirmLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15586g = new LinkedHashMap();
        k();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f15586g;
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

    public final void k() {
        z.a(this, R$layout.layout_send_gift_confirm, true);
        TextView confirm_send_textview = (TextView) e(R$id.confirm_send_textview);
        s.h(confirm_send_textview, "confirm_send_textview");
        u.a(confirm_send_textview);
        TextView send_gift_name_textview = (TextView) e(R$id.send_gift_name_textview);
        s.h(send_gift_name_textview, "send_gift_name_textview");
        u.a(send_gift_name_textview);
        FKUniversalButton cancel_btn = (FKUniversalButton) e(R$id.cancel_btn);
        s.h(cancel_btn, "cancel_btn");
        y.d(cancel_btn, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.SendGiftConfirmLayout$initView$1
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
                AlertDialog alertDialog;
                alertDialog = SendGiftConfirmLayout.this.f15584e;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
        FKUniversalButton send_btn = (FKUniversalButton) e(R$id.send_btn);
        s.h(send_btn, "send_btn");
        y.d(send_btn, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.SendGiftConfirmLayout$initView$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:5:0x0009, code lost:
            
                r8 = r7.this$0.f15583d;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(@org.jetbrains.annotations.Nullable android.view.View r8) {
                /*
                    r7 = this;
                    com.cupidapp.live.liveshow.view.giftpicker.view.SendGiftConfirmLayout r8 = com.cupidapp.live.liveshow.view.giftpicker.view.SendGiftConfirmLayout.this
                    boolean r8 = com.cupidapp.live.liveshow.view.giftpicker.view.SendGiftConfirmLayout.h(r8)
                    if (r8 == 0) goto L9
                    return
                L9:
                    com.cupidapp.live.liveshow.view.giftpicker.view.SendGiftConfirmLayout r8 = com.cupidapp.live.liveshow.view.giftpicker.view.SendGiftConfirmLayout.this
                    com.cupidapp.live.liveshow.view.giftpicker.model.SendGiftModel r8 = com.cupidapp.live.liveshow.view.giftpicker.view.SendGiftConfirmLayout.g(r8)
                    if (r8 == 0) goto L26
                    com.cupidapp.live.liveshow.view.giftpicker.view.SendGiftConfirmLayout r0 = com.cupidapp.live.liveshow.view.giftpicker.view.SendGiftConfirmLayout.this
                    java.lang.String r8 = r8.getItemId()
                    com.cupidapp.live.liveshow.view.giftpicker.view.SendGiftConfirmLayout.i(r0, r8)
                    j1.i r1 = j1.i.f50236a
                    com.cupidapp.live.base.sensorslog.PopupName r2 = com.cupidapp.live.base.sensorslog.PopupName.RECHARGE_WITH_GIFT_SEND_CONFIRM
                    com.cupidapp.live.base.sensorslog.PopupButtonName r3 = com.cupidapp.live.base.sensorslog.PopupButtonName.Confirm
                    r4 = 0
                    r5 = 4
                    r6 = 0
                    j1.i.d(r1, r2, r3, r4, r5, r6)
                L26:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.liveshow.view.giftpicker.view.SendGiftConfirmLayout$initView$2.invoke2(android.view.View):void");
            }
        });
    }

    public final void l(String str) {
        String itemId;
        LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
        if (liveShowModel == null || (itemId = liveShowModel.getItemId()) == null) {
            return;
        }
        this.f15585f = true;
        Disposable disposed = a.C0826a.f(NetworkClient.f11868a.r(), itemId, str, null, false, null, 1, null, null, 220, null).flatMap(new com.cupidapp.live.base.network.i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<SendGiftResult, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.SendGiftConfirmLayout$sendGift$$inlined$handle$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(SendGiftResult sendGiftResult) {
                m2649invoke(sendGiftResult);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2649invoke(SendGiftResult sendGiftResult) {
                AlertDialog alertDialog;
                SendGiftConfirmLayout.this.f15585f = false;
                alertDialog = SendGiftConfirmLayout.this.f15584e;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                com.cupidapp.live.base.view.h.f12779a.b(R$string.give_success);
                EventBus.c().l(new SendGiftSuccessEvent());
            }
        }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.SendGiftConfirmLayout$sendGift$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                SendGiftConfirmLayout.this.f15585f = false;
                return Boolean.FALSE;
            }
        }, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void m(@NotNull SendGiftModel model) {
        Window window;
        s.i(model, "model");
        this.f15583d = model;
        ImageLoaderView send_gift_imageview = (ImageLoaderView) e(R$id.send_gift_imageview);
        s.h(send_gift_imageview, "send_gift_imageview");
        ImageLoaderView.g(send_gift_imageview, model.getImage(), null, null, 6, null);
        ((TextView) e(R$id.send_gift_name_textview)).setText(model.getName() + " x1");
        ((TextView) e(R$id.gift_price_textview)).setText(getContext().getString(R$string.club_red_packet_price, Integer.valueOf(model.getPrice())));
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f15584e = create;
        if (create != null) {
            create.show();
        }
        AlertDialog alertDialog = this.f15584e;
        if (alertDialog == null || (window = alertDialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendGiftConfirmLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15586g = new LinkedHashMap();
        k();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendGiftConfirmLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15586g = new LinkedHashMap();
        k();
    }
}
