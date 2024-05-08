package com.cupidapp.live.liveshow.view.giftpicker.view;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: QuickGiftFirstSendLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class QuickGiftFirstSendLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f15570d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public static AlertDialog f15571e;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function0<p> f15572b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15573c;

    /* compiled from: QuickGiftFirstSendLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull ImageModel icon, int i10, int i11, @NotNull Function0<p> unlockCallback) {
            Window window;
            s.i(context, "context");
            s.i(icon, "icon");
            s.i(unlockCallback, "unlockCallback");
            AlertDialog alertDialog = QuickGiftFirstSendLayout.f15571e;
            if (alertDialog != null && alertDialog.isShowing()) {
                return;
            }
            QuickGiftFirstSendLayout quickGiftFirstSendLayout = new QuickGiftFirstSendLayout(context);
            quickGiftFirstSendLayout.f15572b = unlockCallback;
            quickGiftFirstSendLayout.g(icon, i10, i11);
            QuickGiftFirstSendLayout.f15571e = z0.b.f54812a.e(context).setView(quickGiftFirstSendLayout).create();
            AlertDialog alertDialog2 = QuickGiftFirstSendLayout.f15571e;
            if (alertDialog2 != null) {
                alertDialog2.show();
            }
            AlertDialog alertDialog3 = QuickGiftFirstSendLayout.f15571e;
            if (alertDialog3 == null || (window = alertDialog3.getWindow()) == null) {
                return;
            }
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickGiftFirstSendLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15573c = new LinkedHashMap();
        h();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15573c;
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

    public final void g(ImageModel imageModel, int i10, int i11) {
        ImageLoaderView quick_gift_icon = (ImageLoaderView) a(R$id.quick_gift_icon);
        s.h(quick_gift_icon, "quick_gift_icon");
        ImageLoaderView.g(quick_gift_icon, imageModel, null, null, 6, null);
        ((TextView) a(R$id.discount_price_txt)).setText(String.valueOf(i10));
        ((TextView) a(R$id.original_price_txt)).setText(getContext().getString(R$string.original_price, Integer.valueOf(i11)));
    }

    public final void h() {
        z.a(this, R$layout.layout_quick_gift_first_send, true);
        TextView special_offer_txt = (TextView) a(R$id.special_offer_txt);
        s.h(special_offer_txt, "special_offer_txt");
        u.a(special_offer_txt);
        TextView discount_price_txt = (TextView) a(R$id.discount_price_txt);
        s.h(discount_price_txt, "discount_price_txt");
        u.a(discount_price_txt);
        TextView send_gift_to_anchors_txt = (TextView) a(R$id.send_gift_to_anchors_txt);
        s.h(send_gift_to_anchors_txt, "send_gift_to_anchors_txt");
        u.a(send_gift_to_anchors_txt);
        ((TextView) a(R$id.original_price_txt)).getPaint().setFlags(16);
        LinearLayout unlock_gift_layout = (LinearLayout) a(R$id.unlock_gift_layout);
        s.h(unlock_gift_layout, "unlock_gift_layout");
        y.d(unlock_gift_layout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.giftpicker.view.QuickGiftFirstSendLayout$initView$1
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
                AlertDialog alertDialog = QuickGiftFirstSendLayout.f15571e;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                function0 = QuickGiftFirstSendLayout.this.f15572b;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickGiftFirstSendLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15573c = new LinkedHashMap();
        h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickGiftFirstSendLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15573c = new LinkedHashMap();
        h();
    }
}
