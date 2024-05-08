package com.cupidapp.live.base.view.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKActionItemDialog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKActionItemDialog extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f12688e = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public AlertDialog f12689b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12690c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12691d;

    /* compiled from: FKActionItemDialog.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKActionItemDialog a(@Nullable Context context) {
            if (context == null) {
                context = AppApplication.f11612d.h();
            }
            return new FKActionItemDialog(context, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKActionItemDialog(Context context) {
        super(context);
        this.f12691d = new LinkedHashMap();
        this.f12690c = true;
        c();
    }

    public /* synthetic */ FKActionItemDialog(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f12691d;
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

    public final void c() {
        z.a(this, R$layout.layout_action_item_dialog, true);
        LinearLayout action_item_dialog_root_layout = (LinearLayout) a(R$id.action_item_dialog_root_layout);
        s.h(action_item_dialog_root_layout, "action_item_dialog_root_layout");
        y.o(action_item_dialog_root_layout, Integer.valueOf((int) (z0.h.l(this) * 0.86f)), null, 2, null);
    }

    @NotNull
    public final FKActionItemDialog d(@NotNull List<FKActionItemModel> itemList) {
        s.i(itemList, "itemList");
        for (final FKActionItemModel fKActionItemModel : itemList) {
            TextView textView = new TextView(getContext());
            textView.setLayoutParams(new ViewGroup.LayoutParams(-1, z0.h.c(this, 50.0f)));
            textView.setText(fKActionItemModel.getTextResId());
            textView.setTextColor(-16777216);
            textView.setTextSize(16.0f);
            textView.setGravity(16);
            textView.setPadding(z0.h.c(this, 23.0f), 0, 0, 0);
            y.d(textView, new Function1<View, p>() { // from class: com.cupidapp.live.base.view.dialog.FKActionItemDialog$setActionItem$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    FKActionItemModel.this.getClickListener().invoke();
                    alertDialog = this.f12689b;
                    if (alertDialog != null) {
                        alertDialog.dismiss();
                    }
                }
            });
            ((LinearLayout) a(R$id.action_item_dialog_root_layout)).addView(textView);
        }
        return this;
    }

    public final void e() {
        Window window;
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f12689b = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(this.f12690c);
        }
        AlertDialog alertDialog = this.f12689b;
        if (alertDialog != null) {
            alertDialog.show();
        }
        AlertDialog alertDialog2 = this.f12689b;
        if (alertDialog2 == null || (window = alertDialog2.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(-1, -2);
    }
}
