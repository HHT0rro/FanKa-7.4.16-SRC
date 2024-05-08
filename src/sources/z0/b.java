package z0;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.IBinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.StyleRes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AlertDialogExtension.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f54812a = new b();

    public static /* synthetic */ void c(b bVar, Dialog dialog, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        bVar.b(dialog, z10);
    }

    public static final boolean d(Dialog dialog, boolean z10, View view, MotionEvent motionEvent) {
        View currentFocus;
        if (motionEvent.getAction() != 1) {
            return false;
        }
        Object systemService = dialog.getContext().getSystemService("input_method");
        Window window = dialog.getWindow();
        IBinder windowToken = (window == null || (currentFocus = window.getCurrentFocus()) == null) ? null : currentFocus.getWindowToken();
        if (!(systemService instanceof InputMethodManager) || windowToken == null) {
            return false;
        }
        if (((InputMethodManager) systemService).hideSoftInputFromWindow(windowToken, 2)) {
            com.cupidapp.live.base.utils.j.f12332a.a("AlertDialog", "键盘：展示 -> 隐藏；弹窗：展示 -> 展示");
            return false;
        }
        if (z10) {
            dialog.dismiss();
            com.cupidapp.live.base.utils.j.f12332a.a("AlertDialog", "键盘：隐藏 -> 隐藏；弹窗：展示 -> 隐藏");
        }
        com.cupidapp.live.base.utils.j.f12332a.a("AlertDialog", "键盘：隐藏 -> 隐藏；弹窗：展示 -> 展示");
        return false;
    }

    public final void b(@Nullable final Dialog dialog, final boolean z10) {
        View decorView;
        if (dialog == null) {
            return;
        }
        dialog.setCanceledOnTouchOutside(false);
        Window window = dialog.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.setOnTouchListener(new View.OnTouchListener() { // from class: z0.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean d10;
                d10 = b.d(dialog, z10, view, motionEvent);
                return d10;
            }
        });
    }

    @NotNull
    public final AlertDialog.Builder e(@Nullable Context context) {
        return new AlertDialog.Builder(context);
    }

    @NotNull
    public final AlertDialog.Builder f(@Nullable Context context, @Nullable Integer num) {
        if (num == null) {
            return new AlertDialog.Builder(context);
        }
        return new AlertDialog.Builder(context, num.intValue());
    }

    @NotNull
    public final AlertDialog g(@NotNull Context context, @NotNull View contentView, int i10, int i11, int i12, int i13, int i14, @Nullable Float f10, @StyleRes @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable DialogInterface.OnShowListener onShowListener, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        kotlin.jvm.internal.s.i(context, "context");
        kotlin.jvm.internal.s.i(contentView, "contentView");
        AlertDialog dialog = f(context, num4).create();
        if (onShowListener != null) {
            dialog.setOnShowListener(onShowListener);
        }
        if (onDismissListener != null) {
            dialog.setOnDismissListener(onDismissListener);
        }
        try {
            dialog.show();
            kotlin.jvm.internal.s.h(dialog, "dialog");
            i(dialog, i10, i11, i12, i13, i14, f10, num, num2, num3);
            dialog.setContentView(contentView);
        } catch (Exception unused) {
        }
        kotlin.jvm.internal.s.h(dialog, "dialog");
        return dialog;
    }

    public final void i(@NotNull AlertDialog dialog, int i10, int i11, int i12, int i13, int i14, @Nullable Float f10, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3) {
        kotlin.jvm.internal.s.i(dialog, "dialog");
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            if (f10 != null) {
                window.setDimAmount(f10.floatValue());
            }
            if (num2 != null) {
                View decorView = window.getDecorView();
                kotlin.jvm.internal.s.h(decorView, "window.decorView");
                int intValue = num2.intValue();
                decorView.setPadding(intValue, intValue, intValue, intValue);
            }
            if (num3 != null) {
                window.addFlags(num3.intValue());
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                attributes.f816x = i10;
            }
            if (attributes != null) {
                attributes.f817y = i11;
            }
            if (num != null) {
                window.setWindowAnimations(num.intValue());
            }
        }
        if (window != null) {
            window.setLayout(i12, i13);
        }
        if (window != null) {
            window.setGravity(i14);
        }
    }
}
