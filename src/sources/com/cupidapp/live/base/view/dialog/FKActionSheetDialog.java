package com.cupidapp.live.base.view.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

/* compiled from: FKActionSheetDialog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKActionSheetDialog extends FrameLayout implements com.cupidapp.live.base.fragment.d {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f12692f = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public AlertDialog f12693b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12694c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f12695d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12696e;

    /* compiled from: FKActionSheetDialog.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKActionSheetDialog a(@Nullable Context context) {
            if (context == null) {
                context = AppApplication.f11612d.h();
            }
            return new FKActionSheetDialog(context, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKActionSheetDialog(Context context) {
        super(context);
        this.f12696e = new LinkedHashMap();
        this.f12694c = true;
        e();
    }

    public /* synthetic */ FKActionSheetDialog(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    public static final void i(FKActionSheetDialog this$0, DialogInterface dialogInterface) {
        s.i(this$0, "this$0");
        if (this$0.f12695d) {
            com.cupidapp.live.base.fragment.b.f11807a.a(this$0);
        }
    }

    public static final void j(FKActionSheetDialog this$0, DialogInterface dialogInterface) {
        s.i(this$0, "this$0");
        if (this$0.f12695d) {
            com.cupidapp.live.base.fragment.b.f11807a.d(this$0);
        }
    }

    @Override // com.cupidapp.live.base.fragment.d
    public void L() {
        try {
            AlertDialog alertDialog = this.f12693b;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Nullable
    public View c(int i10) {
        Map<Integer, View> map = this.f12696e;
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

    public final void e() {
        z.a(this, R$layout.layout_action_sheet_dialog, true);
        TextView action_sheet_cancel_btn = (TextView) c(R$id.action_sheet_cancel_btn);
        s.h(action_sheet_cancel_btn, "action_sheet_cancel_btn");
        y.d(action_sheet_cancel_btn, new Function1<View, p>() { // from class: com.cupidapp.live.base.view.dialog.FKActionSheetDialog$initView$1
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
                alertDialog = FKActionSheetDialog.this.f12693b;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
            }
        });
    }

    @NotNull
    public final FKActionSheetDialog f(@NotNull List<FKActionSheetItemModel> itemList) {
        s.i(itemList, "itemList");
        int i10 = 0;
        for (FKActionSheetItemModel fKActionSheetItemModel : itemList) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            final FKActionSheetItemModel fKActionSheetItemModel2 = fKActionSheetItemModel;
            Context context = getContext();
            s.h(context, "context");
            FKActionSheetItemLayout fKActionSheetItemLayout = new FKActionSheetItemLayout(context);
            fKActionSheetItemLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, z0.h.c(this, 56.0f)));
            boolean z10 = true;
            if (i10 == itemList.size() - 1) {
                z10 = false;
            }
            fKActionSheetItemLayout.b(fKActionSheetItemModel2, z10);
            y.d(fKActionSheetItemLayout, new Function1<View, p>() { // from class: com.cupidapp.live.base.view.dialog.FKActionSheetDialog$setActionSheetItem$1$1
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
                    FKActionSheetItemModel.this.getClickListener().invoke();
                    alertDialog = this.f12693b;
                    if (alertDialog != null) {
                        alertDialog.dismiss();
                    }
                }
            });
            ((LinearLayout) c(R$id.action_sheet_content_layout)).addView(fKActionSheetItemLayout);
            i10 = i11;
        }
        return this;
    }

    @NotNull
    public final FKActionSheetDialog g(boolean z10) {
        this.f12695d = z10;
        return this;
    }

    public final void h() {
        Window window;
        AlertDialog create = z0.b.f54812a.e(getContext()).setView(this).create();
        this.f12693b = create;
        if (create != null) {
            create.setCanceledOnTouchOutside(this.f12694c);
        }
        AlertDialog alertDialog = this.f12693b;
        if (alertDialog != null) {
            alertDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.cupidapp.live.base.view.dialog.b
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    FKActionSheetDialog.i(FKActionSheetDialog.this, dialogInterface);
                }
            });
        }
        AlertDialog alertDialog2 = this.f12693b;
        if (alertDialog2 != null) {
            alertDialog2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.cupidapp.live.base.view.dialog.a
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    FKActionSheetDialog.j(FKActionSheetDialog.this, dialogInterface);
                }
            });
        }
        AlertDialog alertDialog3 = this.f12693b;
        if (alertDialog3 != null) {
            alertDialog3.show();
        }
        AlertDialog alertDialog4 = this.f12693b;
        if (alertDialog4 == null || (window = alertDialog4.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(-1, -2);
        window.setGravity(80);
    }
}
