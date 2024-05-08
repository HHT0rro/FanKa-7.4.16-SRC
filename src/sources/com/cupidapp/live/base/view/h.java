package com.cupidapp.live.base.view;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;

/* compiled from: FKToastView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f12779a = new h();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public static Toast f12780b;

    public static /* synthetic */ void p(h hVar, Context context, String str, Integer num, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            num = null;
        }
        hVar.o(context, str, num, (i13 & 8) != 0 ? 49 : i10, (i13 & 16) != 0 ? 0 : i11, (i13 & 32) != 0 ? 1 : i12);
    }

    public final boolean a(Context context) {
        return (context instanceof Activity) && !((Activity) context).isFinishing();
    }

    public final void b(@StringRes int i10) {
        f(null, i10, ToastIconType.SUCCESS);
    }

    public final void c(@Nullable Context context, @StringRes int i10) {
        f(context, i10, ToastIconType.SUCCESS);
    }

    public final void d(@Nullable Context context, @Nullable CharSequence charSequence) {
        g(context, charSequence, ToastIconType.SUCCESS);
    }

    public final void e(@Nullable CharSequence charSequence) {
        g(null, charSequence, ToastIconType.SUCCESS);
    }

    public final void f(Context context, @StringRes int i10, ToastIconType toastIconType) {
        if (context == null) {
            i(Integer.valueOf(i10), null, toastIconType);
        } else {
            h(context, context.getString(i10), toastIconType.getIconResId());
        }
    }

    public final void g(Context context, CharSequence charSequence, ToastIconType toastIconType) {
        if (charSequence == null || charSequence.length() == 0) {
            return;
        }
        if (context == null) {
            i(null, charSequence, toastIconType);
        } else {
            h(context, charSequence, toastIconType.getIconResId());
        }
    }

    public final void h(@Nullable Context context, @Nullable CharSequence charSequence, @DrawableRes @Nullable Integer num) {
        if (a(context)) {
            if (charSequence == null || charSequence.length() == 0) {
                return;
            }
            Toast toast = f12780b;
            if (toast != null) {
                if (toast != null) {
                    toast.cancel();
                }
                f12780b = null;
            }
            Toast toast2 = new Toast(context);
            f12780b = toast2;
            View inflate = View.inflate(context, R$layout.layout_common_toast, null);
            TextView textView = (TextView) inflate.findViewById(R$id.common_toast_text);
            textView.setText(charSequence);
            ImageView imageView = (ImageView) inflate.findViewById(R$id.common_toast_img);
            if (num != null && num.intValue() != 0) {
                imageView.setVisibility(0);
                imageView.setImageResource(num.intValue());
                textView.setMinWidth(z0.h.c(this, 58.0f));
            } else {
                imageView.setVisibility(8);
            }
            toast2.setView(inflate);
            toast2.setGravity(17, 0, 0);
            toast2.setDuration(0);
            toast2.show();
        }
    }

    public final void i(@StringRes Integer num, CharSequence charSequence, ToastIconType toastIconType) {
        EventBus.c().o(new ToastMessageEvent(num, charSequence, toastIconType));
    }

    public final void j(@Nullable Context context, @StringRes int i10, @DrawableRes int i11) {
        if (context == null) {
            return;
        }
        h(context, context.getString(i10), Integer.valueOf(i11));
    }

    public final void k(@StringRes int i10) {
        f(null, i10, ToastIconType.NONE);
    }

    public final void l(@Nullable Context context, @StringRes int i10) {
        f(context, i10, ToastIconType.NONE);
    }

    public final void m(@Nullable Context context, @Nullable CharSequence charSequence) {
        g(context, charSequence, ToastIconType.NONE);
    }

    public final void n(@Nullable CharSequence charSequence) {
        g(null, charSequence, ToastIconType.NONE);
    }

    public final void o(@Nullable Context context, @Nullable String str, @DrawableRes @Nullable Integer num, int i10, int i11, int i12) {
        if (a(context)) {
            if (str == null || str.length() == 0) {
                return;
            }
            Toast toast = new Toast(context);
            View inflate = View.inflate(context, R$layout.layout_top_tip_toast, null);
            TextView textView = (TextView) inflate.findViewById(R$id.top_tip_toast_text);
            textView.setText(str);
            if (num != null) {
                kotlin.jvm.internal.s.h(textView, "textView");
                u.e(textView, num.intValue(), 0, 0, 0, 14, null);
            }
            toast.setView(inflate);
            toast.setGravity(i10, 0, i11);
            toast.setDuration(i12);
            toast.show();
        }
    }

    public final void q(@StringRes int i10) {
        f(null, i10, ToastIconType.WARNING);
    }

    public final void r(@Nullable Context context, @StringRes int i10) {
        f(context, i10, ToastIconType.WARNING);
    }

    public final void s(@Nullable Context context, @Nullable CharSequence charSequence) {
        g(context, charSequence, ToastIconType.WARNING);
    }

    public final void t(@Nullable CharSequence charSequence) {
        g(null, charSequence, ToastIconType.WARNING);
    }
}
