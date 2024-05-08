package com.cupidapp.live.liveshow.view.giftpicker.view;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: QuickGiftSendConfirmLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class QuickGiftSendConfirmLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f15574d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public static AlertDialog f15575e;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function1<? super Boolean, p> f15576b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15577c;

    /* compiled from: QuickGiftSendConfirmLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull ImageModel giftIcon, int i10, @NotNull Function1<? super Boolean, p> sendCallback) {
            Window window;
            s.i(context, "context");
            s.i(giftIcon, "giftIcon");
            s.i(sendCallback, "sendCallback");
            AlertDialog alertDialog = QuickGiftSendConfirmLayout.f15575e;
            if (alertDialog != null && alertDialog.isShowing()) {
                return;
            }
            QuickGiftSendConfirmLayout quickGiftSendConfirmLayout = new QuickGiftSendConfirmLayout(context);
            quickGiftSendConfirmLayout.f15576b = sendCallback;
            quickGiftSendConfirmLayout.g(giftIcon, i10);
            QuickGiftSendConfirmLayout.f15575e = z0.b.f54812a.e(context).setView(quickGiftSendConfirmLayout).create();
            AlertDialog alertDialog2 = QuickGiftSendConfirmLayout.f15575e;
            if (alertDialog2 != null) {
                alertDialog2.show();
            }
            AlertDialog alertDialog3 = QuickGiftSendConfirmLayout.f15575e;
            if (alertDialog3 == null || (window = alertDialog3.getWindow()) == null) {
                return;
            }
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickGiftSendConfirmLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15577c = new LinkedHashMap();
        h();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15577c;
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

    public final void g(ImageModel imageModel, int i10) {
        ImageLoaderView quick_gift_icon = (ImageLoaderView) a(R$id.quick_gift_icon);
        s.h(quick_gift_icon, "quick_gift_icon");
        ImageLoaderView.g(quick_gift_icon, imageModel, null, null, 6, null);
        ((TextView) a(R$id.gift_price_txt)).setText(String.valueOf(i10));
    }

    public final void h() {
        z.a(this, R$layout.layout_quick_gift_send_confirm, true);
        TextView send_gift_txt = (TextView) a(R$id.send_gift_txt);
        s.h(send_gift_txt, "send_gift_txt");
        u.a(send_gift_txt);
        TextView gift_price_txt = (TextView) a(R$id.gift_price_txt);
        s.h(gift_price_txt, "gift_price_txt");
        u.a(gift_price_txt);
        int i10 = R$id.send_immediately_txt;
        TextView send_immediately_txt = (TextView) a(i10);
        s.h(send_immediately_txt, "send_immediately_txt");
        u.a(send_immediately_txt);
        int i11 = R$id.give_up_txt;
        TextView give_up_txt = (TextView) a(i11);
        s.h(give_up_txt, "give_up_txt");
        u.a(give_up_txt);
        int i12 = R$id.not_remind_img;
        ((ImageView) a(i12)).setSelected(true);
        ImageView not_remind_img = (ImageView) a(i12);
        s.h(not_remind_img, "not_remind_img");
        y.d(not_remind_img, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.QuickGiftSendConfirmLayout$initView$1
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
                ((ImageView) QuickGiftSendConfirmLayout.this.a(R$id.not_remind_img)).setSelected(!((ImageView) QuickGiftSendConfirmLayout.this.a(r0)).isSelected());
            }
        });
        TextView send_immediately_txt2 = (TextView) a(i10);
        s.h(send_immediately_txt2, "send_immediately_txt");
        y.d(send_immediately_txt2, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.QuickGiftSendConfirmLayout$initView$2
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
                Function1 function1;
                AlertDialog alertDialog = QuickGiftSendConfirmLayout.f15575e;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                function1 = QuickGiftSendConfirmLayout.this.f15576b;
                if (function1 != null) {
                    function1.invoke(Boolean.valueOf(((ImageView) QuickGiftSendConfirmLayout.this.a(R$id.not_remind_img)).isSelected()));
                }
            }
        });
        TextView give_up_txt2 = (TextView) a(i11);
        s.h(give_up_txt2, "give_up_txt");
        y.d(give_up_txt2, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.QuickGiftSendConfirmLayout$initView$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                AlertDialog alertDialog = QuickGiftSendConfirmLayout.f15575e;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickGiftSendConfirmLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15577c = new LinkedHashMap();
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickGiftSendConfirmLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15577c = new LinkedHashMap();
        h();
    }
}
