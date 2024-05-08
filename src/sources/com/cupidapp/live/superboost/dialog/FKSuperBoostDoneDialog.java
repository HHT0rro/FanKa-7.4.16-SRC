package com.cupidapp.live.superboost.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.appdialog.model.ExposureDoneModel;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.b;
import z0.y;
import z0.z;

/* compiled from: FKSuperBoostDoneDialog.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKSuperBoostDoneDialog extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f18577d = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public AlertDialog f18578b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18579c;

    /* compiled from: FKSuperBoostDoneDialog.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKSuperBoostDoneDialog a(@Nullable Context context) {
            if (context == null) {
                context = AppApplication.f11612d.h();
            }
            return new FKSuperBoostDoneDialog(context, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSuperBoostDoneDialog(Context context) {
        super(context);
        this.f18579c = new LinkedHashMap();
        d();
    }

    public /* synthetic */ FKSuperBoostDoneDialog(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f18579c;
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

    @NotNull
    public final FKSuperBoostDoneDialog c(@NotNull ExposureDoneModel model) {
        s.i(model, "model");
        ((TextView) a(R$id.card_exposure_count_textview)).setText(model.getExposure());
        ((TextView) a(R$id.nearby_exposure_count_textview)).setText(model.getNearbyExposure());
        ((TextView) a(R$id.visitor_count_txt_view)).setText(model.getNewVisitors());
        ((TextView) a(R$id.attention_count_txt_view)).setText(model.getNewFans());
        return this;
    }

    public final void d() {
        z.a(this, R$layout.dialog_exposure_done, true);
        ImageView exposure_close_img = (ImageView) a(R$id.exposure_close_img);
        s.h(exposure_close_img, "exposure_close_img");
        y.d(exposure_close_img, new Function1<View, p>() { // from class: com.cupidapp.live.superboost.dialog.FKSuperBoostDoneDialog$initView$1
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
                alertDialog = FKSuperBoostDoneDialog.this.f18578b;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
        FKUniversalButton buy_it_now_btn = (FKUniversalButton) a(R$id.buy_it_now_btn);
        s.h(buy_it_now_btn, "buy_it_now_btn");
        y.d(buy_it_now_btn, new Function1<View, p>() { // from class: com.cupidapp.live.superboost.dialog.FKSuperBoostDoneDialog$initView$2
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
                alertDialog = FKSuperBoostDoneDialog.this.f18578b;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
    }

    public final void e() {
        Window window;
        AlertDialog create = b.f54812a.e(getContext()).setView(this).create();
        this.f18578b = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(false);
        }
        AlertDialog alertDialog = this.f18578b;
        if (alertDialog != null) {
            alertDialog.show();
        }
        AlertDialog alertDialog2 = this.f18578b;
        if (alertDialog2 == null || (window = alertDialog2.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(-1, -2);
        window.setGravity(17);
    }
}
