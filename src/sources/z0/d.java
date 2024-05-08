package z0;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import androidx.annotation.ColorInt;
import com.cupidapp.live.base.view.FKAlertLayout;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: AlertDialogExtension.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class d {
    @NotNull
    public static final AlertDialog b(@NotNull AlertDialog.Builder builder) {
        kotlin.jvm.internal.s.i(builder, "<this>");
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        kotlin.jvm.internal.s.h(alertDialog, "alertDialog");
        m(alertDialog, 0, 1, null);
        i(alertDialog, 0, 1, null);
        k(alertDialog, 0, 1, null);
        return alertDialog;
    }

    public static final void c(@NotNull Dialog dialog) {
        kotlin.jvm.internal.s.i(dialog, "<this>");
        Window window = dialog.getWindow();
        if (window != null) {
            FKAlertLayout.f12456d.d(window);
        }
    }

    public static final void d(@NotNull Dialog dialog, @NotNull final Function0<kotlin.p> mOnBackListener) {
        kotlin.jvm.internal.s.i(dialog, "<this>");
        kotlin.jvm.internal.s.i(mOnBackListener, "mOnBackListener");
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: z0.c
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                boolean e2;
                e2 = d.e(Function0.this, dialogInterface, i10, keyEvent);
                return e2;
            }
        });
    }

    public static final boolean e(Function0 mOnBackListener, DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        kotlin.jvm.internal.s.i(mOnBackListener, "$mOnBackListener");
        if (i10 != 4 || keyEvent.getAction() != 1 || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        mOnBackListener.invoke();
        return false;
    }

    @NotNull
    public static final AlertDialog f(@NotNull AlertDialog alertDialog, int i10, int i11) {
        kotlin.jvm.internal.s.i(alertDialog, "<this>");
        Button button = alertDialog.getButton(i10);
        if (button != null) {
            button.setTextColor(i11);
        }
        return alertDialog;
    }

    public static final void g(@NotNull Dialog dialog, float f10) {
        kotlin.jvm.internal.s.i(dialog, "<this>");
        Window window = dialog.getWindow();
        if (window != null) {
            window.setDimAmount(f10);
        }
    }

    @NotNull
    public static final AlertDialog h(@NotNull AlertDialog alertDialog, int i10) {
        kotlin.jvm.internal.s.i(alertDialog, "<this>");
        return f(alertDialog, -2, i10);
    }

    public static /* synthetic */ AlertDialog i(AlertDialog alertDialog, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = -15066598;
        }
        return h(alertDialog, i10);
    }

    @NotNull
    public static final AlertDialog j(@NotNull AlertDialog alertDialog, int i10) {
        kotlin.jvm.internal.s.i(alertDialog, "<this>");
        return f(alertDialog, -3, i10);
    }

    public static /* synthetic */ AlertDialog k(AlertDialog alertDialog, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = -15066598;
        }
        return j(alertDialog, i10);
    }

    @NotNull
    public static final AlertDialog l(@NotNull AlertDialog alertDialog, int i10) {
        kotlin.jvm.internal.s.i(alertDialog, "<this>");
        return f(alertDialog, -1, i10);
    }

    public static /* synthetic */ AlertDialog m(AlertDialog alertDialog, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = -49088;
        }
        return l(alertDialog, i10);
    }

    public static final void n(@NotNull Dialog dialog, boolean z10, @ColorInt int i10) {
        View decorView;
        kotlin.jvm.internal.s.i(dialog, "<this>");
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                Window window = dialog.getWindow();
                if (window != null) {
                    window.clearFlags(67108864);
                }
                if (z10) {
                    Window window2 = dialog.getWindow();
                    decorView = window2 != null ? window2.getDecorView() : null;
                    if (decorView != null) {
                        decorView.setSystemUiVisibility(1280);
                    }
                } else {
                    Window window3 = dialog.getWindow();
                    decorView = window3 != null ? window3.getDecorView() : null;
                    if (decorView != null) {
                        decorView.setSystemUiVisibility(9216);
                    }
                }
                Window window4 = dialog.getWindow();
                if (window4 != null) {
                    window4.addFlags(Integer.MIN_VALUE);
                }
                Window window5 = dialog.getWindow();
                if (window5 == null) {
                    return;
                }
                window5.setStatusBarColor(i10);
                return;
            }
            Window window6 = dialog.getWindow();
            if (window6 != null) {
                window6.clearFlags(67108864);
            }
            Window window7 = dialog.getWindow();
            if (window7 != null) {
                window7.addFlags(Integer.MIN_VALUE);
            }
            Window window8 = dialog.getWindow();
            if (window8 != null) {
                window8.setStatusBarColor(0);
            }
            Window window9 = dialog.getWindow();
            if (window9 == null) {
                return;
            }
            window9.setStatusBarColor(-16777216);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static /* synthetic */ void o(Dialog dialog, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        n(dialog, z10, i10);
    }

    public static final void p(@NotNull Dialog dialog, @NotNull String message) {
        kotlin.jvm.internal.s.i(dialog, "<this>");
        kotlin.jvm.internal.s.i(message, "message");
        Window window = dialog.getWindow();
        if (window != null) {
            FKAlertLayout.f12456d.b(window).d(message).e();
        }
    }
}
