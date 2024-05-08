package com.cupidapp.live.club.view;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.ConstantsUrlModel;
import com.cupidapp.live.base.router.j;
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

/* compiled from: SettleInClubLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SettleInClubLayout extends FrameLayout {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f13668c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public static AlertDialog f13669d;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13670b;

    /* compiled from: SettleInClubLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable Context context) {
            Window window;
            if (context == null) {
                return;
            }
            AlertDialog alertDialog = SettleInClubLayout.f13669d;
            if (alertDialog != null && alertDialog.isShowing()) {
                return;
            }
            SettleInClubLayout.f13669d = z0.b.f54812a.e(context).setView(new SettleInClubLayout(context)).create();
            AlertDialog alertDialog2 = SettleInClubLayout.f13669d;
            if (alertDialog2 != null) {
                alertDialog2.show();
            }
            AlertDialog alertDialog3 = SettleInClubLayout.f13669d;
            if (alertDialog3 == null || (window = alertDialog3.getWindow()) == null) {
                return;
            }
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -2);
            window.setGravity(80);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettleInClubLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13670b = new LinkedHashMap();
        d();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13670b;
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

    public final void d() {
        z.a(this, R$layout.layout_settle_in_club, true);
        BitmapFactory.Options m10 = z0.f.m(getContext(), R$mipmap.icon_settle_in_club);
        int l10 = (m10.outHeight * z0.h.l(this)) / m10.outWidth;
        ImageView settle_in_imageview = (ImageView) a(R$id.settle_in_imageview);
        s.h(settle_in_imageview, "settle_in_imageview");
        y.o(settle_in_imageview, null, Integer.valueOf(l10), 1, null);
        int i10 = R$id.contact_customer_service_textview;
        TextView contact_customer_service_textview = (TextView) a(i10);
        s.h(contact_customer_service_textview, "contact_customer_service_textview");
        u.a(contact_customer_service_textview);
        TextView contact_customer_service_textview2 = (TextView) a(i10);
        s.h(contact_customer_service_textview2, "contact_customer_service_textview");
        y.d(contact_customer_service_textview2, new Function1<View, p>() { // from class: com.cupidapp.live.club.view.SettleInClubLayout$initView$1
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
                AlertDialog alertDialog = SettleInClubLayout.f13669d;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                j.a aVar = com.cupidapp.live.base.router.j.f12156c;
                Context context = SettleInClubLayout.this.getContext();
                ConstantsResult q10 = p1.g.f52734a.q();
                j.a.b(aVar, context, (q10 == null || (urlModel = q10.getUrlModel()) == null) ? null : urlModel.getUrlUserFeedBack(), null, 4, null);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettleInClubLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13670b = new LinkedHashMap();
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettleInClubLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13670b = new LinkedHashMap();
        d();
    }
}
