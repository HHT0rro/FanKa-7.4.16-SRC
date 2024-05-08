package com.cupidapp.live.match.view;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TravelConfirmDialog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class TravelConfirmDialog extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f17004e = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final boolean f17005b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public AlertDialog f17006c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17007d;

    /* compiled from: TravelConfirmDialog.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TravelConfirmDialog a(@NotNull Context context, boolean z10) {
            kotlin.jvm.internal.s.i(context, "context");
            return new TravelConfirmDialog(context, z10, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TravelConfirmDialog(Context context, boolean z10) {
        super(context);
        this.f17007d = new LinkedHashMap();
        this.f17005b = z10;
        c();
    }

    public /* synthetic */ TravelConfirmDialog(Context context, boolean z10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, z10);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f17007d;
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
        AlertDialog alertDialog = this.f17006c;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public final void c() {
        z0.z.a(this, R$layout.dialog_travel_confirm, true);
        if (this.f17005b) {
            ((TextView) a(R$id.title_txt)).setText(R$string.people_is_less_on_location);
        } else {
            ((TextView) a(R$id.title_txt)).setText(R$string.people_is_less_spread_to_country);
        }
        int i10 = R$id.cancel_btn;
        TextView cancel_btn = (TextView) a(i10);
        kotlin.jvm.internal.s.h(cancel_btn, "cancel_btn");
        z0.u.a(cancel_btn);
        TextView confirm_btn = (TextView) a(R$id.confirm_btn);
        kotlin.jvm.internal.s.h(confirm_btn, "confirm_btn");
        z0.u.a(confirm_btn);
        TextView cancel_btn2 = (TextView) a(i10);
        kotlin.jvm.internal.s.h(cancel_btn2, "cancel_btn");
        z0.y.d(cancel_btn2, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.TravelConfirmDialog$initView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                j1.i.d(j1.i.f50236a, PopupName.TRAVEL_MODE_USE_LESS, PopupButtonName.Cancel, null, 4, null);
                TravelConfirmDialog.this.b();
            }
        });
    }

    @NotNull
    public final TravelConfirmDialog d(@Nullable final Function0<kotlin.p> function0) {
        TextView confirm_btn = (TextView) a(R$id.confirm_btn);
        kotlin.jvm.internal.s.h(confirm_btn, "confirm_btn");
        z0.y.d(confirm_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.TravelConfirmDialog$setPositiveButton$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                Function0<kotlin.p> function02 = function0;
                if (function02 != null) {
                    function02.invoke();
                }
                j1.i.d(j1.i.f50236a, PopupName.TRAVEL_MODE_USE_LESS, PopupButtonName.Confirm, null, 4, null);
                this.b();
            }
        });
        return this;
    }

    public final void e() {
        Window window;
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f17006c = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(false);
        }
        try {
            AlertDialog alertDialog = this.f17006c;
            if (alertDialog != null) {
                alertDialog.show();
            }
        } catch (Exception unused) {
        }
        AlertDialog alertDialog2 = this.f17006c;
        if (alertDialog2 != null && (window = alertDialog2.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-2, -2);
            window.setGravity(17);
        }
        j1.i.g(j1.i.f50236a, PopupName.TRAVEL_MODE_USE_LESS, null, null, 6, null);
    }

    public final boolean getInChina() {
        return this.f17005b;
    }
}
