package com.cupidapp.live.match.view;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.sensorslog.PopupButtonName;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.match.model.CheckTravelUseResult;
import com.cupidapp.live.match.model.TravelCountSelectUiModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TravelSelectCountDialog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class TravelSelectCountDialog extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f17008f = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public AlertDialog f17009b;

    /* renamed from: c, reason: collision with root package name */
    public int f17010c;

    /* renamed from: d, reason: collision with root package name */
    public int f17011d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17012e;

    /* compiled from: TravelSelectCountDialog.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TravelSelectCountDialog a(@NotNull Context context) {
            kotlin.jvm.internal.s.i(context, "context");
            return new TravelSelectCountDialog(context, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TravelSelectCountDialog(Context context) {
        super(context);
        this.f17012e = new LinkedHashMap();
        this.f17010c = 5;
        h();
    }

    public /* synthetic */ TravelSelectCountDialog(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    public static final void i(TravelSelectCountDialog this$0, View view) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        int i10 = this$0.f17011d;
        if (i10 > 1) {
            this$0.f17011d = i10 - 1;
            this$0.f();
        }
    }

    public static final void j(TravelSelectCountDialog this$0, View view) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        int i10 = this$0.f17011d;
        if (i10 < this$0.f17010c) {
            this$0.f17011d = i10 + 1;
            this$0.f();
        }
    }

    @Nullable
    public View c(int i10) {
        Map<Integer, View> map = this.f17012e;
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
    public final TravelSelectCountDialog e(@NotNull TravelCountSelectUiModel model) {
        kotlin.jvm.internal.s.i(model, "model");
        CheckTravelUseResult countModel = model.getCountModel();
        TextView textView = (TextView) c(R$id.travel_message_text);
        String travelboostUseInfo = countModel.getTravelboostUseInfo();
        textView.setText(travelboostUseInfo != null ? z0.t.a(travelboostUseInfo, -49088) : null);
        this.f17011d = countModel.getTravelDefaultTimes();
        Integer travelboostLimit = countModel.getTravelboostLimit();
        int intValue = travelboostLimit != null ? travelboostLimit.intValue() : 5;
        if (countModel.getTravelboostRemains() <= intValue) {
            intValue = countModel.getTravelboostRemains();
        }
        this.f17010c = intValue;
        f();
        return this;
    }

    public final void f() {
        int i10 = this.f17011d;
        if (i10 < 1) {
            this.f17011d = 1;
        } else {
            int i11 = this.f17010c;
            if (i10 > i11) {
                this.f17011d = i11;
            }
        }
        ((TextView) c(R$id.count_text)).setText(String.valueOf(this.f17011d));
        if (this.f17011d >= this.f17010c) {
            ((ImageView) c(R$id.count_select_add)).setImageResource(R$mipmap.ic_travel_add_gray);
        } else {
            ((ImageView) c(R$id.count_select_add)).setImageResource(R$mipmap.ic_travel_add);
        }
        if (this.f17011d <= 1) {
            ((ImageView) c(R$id.count_select_sub)).setImageResource(R$mipmap.ic_travel_sub_gray);
        } else {
            ((ImageView) c(R$id.count_select_sub)).setImageResource(R$mipmap.ic_travel_sub);
        }
    }

    public final void g() {
        AlertDialog alertDialog = this.f17009b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public final void h() {
        z0.z.a(this, R$layout.dialog_travel_count, true);
        TextView confirm_btn = (TextView) c(R$id.confirm_btn);
        kotlin.jvm.internal.s.h(confirm_btn, "confirm_btn");
        z0.u.a(confirm_btn);
        TextView travel_title_text = (TextView) c(R$id.travel_title_text);
        kotlin.jvm.internal.s.h(travel_title_text, "travel_title_text");
        z0.u.a(travel_title_text);
        TextView count_text = (TextView) c(R$id.count_text);
        kotlin.jvm.internal.s.h(count_text, "count_text");
        z0.u.a(count_text);
        ((ImageView) c(R$id.count_select_sub)).setOnClickListener(new View.OnClickListener() { // from class: com.cupidapp.live.match.view.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TravelSelectCountDialog.i(TravelSelectCountDialog.this, view);
            }
        });
        ((ImageView) c(R$id.count_select_add)).setOnClickListener(new View.OnClickListener() { // from class: com.cupidapp.live.match.view.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TravelSelectCountDialog.j(TravelSelectCountDialog.this, view);
            }
        });
        ImageView travel_close_img = (ImageView) c(R$id.travel_close_img);
        kotlin.jvm.internal.s.h(travel_close_img, "travel_close_img");
        z0.y.d(travel_close_img, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.TravelSelectCountDialog$initView$3
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
                j1.i.d(j1.i.f50236a, PopupName.TRAVEL_MODE_USE_MORE, PopupButtonName.Cancel, null, 4, null);
                TravelSelectCountDialog.this.g();
            }
        });
    }

    @NotNull
    public final TravelSelectCountDialog k(@Nullable final Function1<? super Integer, kotlin.p> function1) {
        TextView confirm_btn = (TextView) c(R$id.confirm_btn);
        kotlin.jvm.internal.s.h(confirm_btn, "confirm_btn");
        z0.y.d(confirm_btn, new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.match.view.TravelSelectCountDialog$setPositiveButton$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                int i10;
                Function1<Integer, kotlin.p> function12 = function1;
                if (function12 != null) {
                    i10 = this.f17011d;
                    function12.invoke(Integer.valueOf(i10));
                }
                j1.i.d(j1.i.f50236a, PopupName.TRAVEL_MODE_USE_MORE, PopupButtonName.Confirm, null, 4, null);
                this.g();
            }
        });
        return this;
    }

    public final void l() {
        Window window;
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f17009b = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(false);
        }
        try {
            AlertDialog alertDialog = this.f17009b;
            if (alertDialog != null) {
                alertDialog.show();
            }
        } catch (Exception unused) {
        }
        AlertDialog alertDialog2 = this.f17009b;
        if (alertDialog2 != null && (window = alertDialog2.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-2, -2);
            window.setGravity(17);
        }
        j1.i.g(j1.i.f50236a, PopupName.TRAVEL_MODE_USE_MORE, null, null, 6, null);
    }
}
