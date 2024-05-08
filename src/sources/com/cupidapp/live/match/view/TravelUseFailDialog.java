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
import com.cupidapp.live.base.sensorslog.PopupName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TravelUseFailDialog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class TravelUseFailDialog extends FrameLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f17013d = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public AlertDialog f17014b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17015c;

    /* compiled from: TravelUseFailDialog.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TravelUseFailDialog a(@NotNull Context context) {
            kotlin.jvm.internal.s.i(context, "context");
            return new TravelUseFailDialog(context, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TravelUseFailDialog(Context context) {
        super(context);
        this.f17015c = new LinkedHashMap();
        c();
    }

    public /* synthetic */ TravelUseFailDialog(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f17015c;
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
        AlertDialog alertDialog = this.f17014b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public final void c() {
        z0.z.a(this, R$layout.dialog_travel_fail, true);
        int i10 = R$id.know_btn;
        TextView know_btn = (TextView) a(i10);
        kotlin.jvm.internal.s.h(know_btn, "know_btn");
        z0.u.a(know_btn);
        TextView know_btn2 = (TextView) a(i10);
        kotlin.jvm.internal.s.h(know_btn2, "know_btn");
        z0.y.d(know_btn2, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.TravelUseFailDialog$initView$1
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
                TravelUseFailDialog.this.b();
            }
        });
    }

    public final void d() {
        Window window;
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f17014b = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(false);
        }
        try {
            AlertDialog alertDialog = this.f17014b;
            if (alertDialog != null) {
                alertDialog.show();
            }
        } catch (Exception unused) {
        }
        AlertDialog alertDialog2 = this.f17014b;
        if (alertDialog2 != null && (window = alertDialog2.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-2, -2);
            window.setGravity(17);
        }
        j1.i.g(j1.i.f50236a, PopupName.TRAVEL_MODE_CANNOT_USE, null, null, 6, null);
    }
}
