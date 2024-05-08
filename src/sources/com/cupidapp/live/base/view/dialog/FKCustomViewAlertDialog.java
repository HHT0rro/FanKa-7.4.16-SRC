package com.cupidapp.live.base.view.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKCustomViewAlertDialog.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKCustomViewAlertDialog extends FrameLayout implements com.cupidapp.live.base.fragment.d {

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f12713e = new a(null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public AlertDialog f12714b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12715c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f12716d;

    /* compiled from: FKCustomViewAlertDialog.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final FKCustomViewAlertDialog a(@Nullable Context context) {
            if (context == null) {
                return null;
            }
            return new FKCustomViewAlertDialog(context);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKCustomViewAlertDialog(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f12716d = new LinkedHashMap();
    }

    public static final void d(FKCustomViewAlertDialog this$0, DialogInterface dialogInterface) {
        s.i(this$0, "this$0");
        if (this$0.f12715c) {
            com.cupidapp.live.base.fragment.b.f11807a.a(this$0);
        }
    }

    public static final void e(FKCustomViewAlertDialog this$0, DialogInterface dialogInterface) {
        s.i(this$0, "this$0");
        if (this$0.f12715c) {
            com.cupidapp.live.base.fragment.b.f11807a.d(this$0);
        }
    }

    public static /* synthetic */ void setDialogWindow$default(FKCustomViewAlertDialog fKCustomViewAlertDialog, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = 0;
        }
        if ((i14 & 2) != 0) {
            i11 = -2;
        }
        if ((i14 & 4) != 0) {
            i12 = -2;
        }
        if ((i14 & 8) != 0) {
            i13 = 17;
        }
        fKCustomViewAlertDialog.setDialogWindow(i10, i11, i12, i13);
    }

    @Override // com.cupidapp.live.base.fragment.d
    public void L() {
        AlertDialog alertDialog = this.f12714b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    @NotNull
    public final FKCustomViewAlertDialog c() {
        AlertDialog create = z0.b.f54812a.e(getContext()).create();
        this.f12714b = create;
        if (create != null) {
            create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.cupidapp.live.base.view.dialog.g
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    FKCustomViewAlertDialog.d(FKCustomViewAlertDialog.this, dialogInterface);
                }
            });
        }
        AlertDialog alertDialog = this.f12714b;
        if (alertDialog != null) {
            alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.cupidapp.live.base.view.dialog.f
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    FKCustomViewAlertDialog.e(FKCustomViewAlertDialog.this, dialogInterface);
                }
            });
        }
        return this;
    }

    public final void f() {
        AlertDialog alertDialog = this.f12714b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public final boolean g() {
        AlertDialog alertDialog = this.f12714b;
        return alertDialog != null && alertDialog.isShowing();
    }

    @NotNull
    public final FKCustomViewAlertDialog h(@NotNull View view) {
        s.i(view, "view");
        AlertDialog alertDialog = this.f12714b;
        if (alertDialog != null) {
            alertDialog.setContentView(view);
        }
        return this;
    }

    @NotNull
    public final FKCustomViewAlertDialog i(boolean z10) {
        this.f12715c = z10;
        return this;
    }

    @NotNull
    public final FKCustomViewAlertDialog j(@NotNull View view) {
        s.i(view, "view");
        AlertDialog alertDialog = this.f12714b;
        if (alertDialog != null) {
            alertDialog.setView(view);
        }
        return this;
    }

    public final void k() {
        AlertDialog alertDialog = this.f12714b;
        if (alertDialog != null) {
            alertDialog.show();
        }
    }

    public final void setDialogWindow(int i10, int i11, int i12, int i13) {
        Window window;
        AlertDialog alertDialog = this.f12714b;
        if (alertDialog == null || (window = alertDialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(i10));
        window.setLayout(i11, i12);
        window.setGravity(i13);
    }
}
