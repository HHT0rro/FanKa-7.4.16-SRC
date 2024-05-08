package com.cupidapp.live.base.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.google.android.material.badge.BadgeDrawable;
import org.jetbrains.annotations.NotNull;

/* compiled from: HandGuideHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final t f12377a = new t();

    public static final void e(Context context, View anchor) {
        kotlin.jvm.internal.s.i(context, "$context");
        kotlin.jvm.internal.s.i(anchor, "$anchor");
        View contentView = LayoutInflater.from(context).inflate(R$layout.pop_guide_feed_recommend, (ViewGroup) null, false);
        int[] iArr = new int[2];
        anchor.getLocationOnScreen(iArr);
        TextView textView = (TextView) contentView.findViewById(R$id.guide_txt);
        if (textView != null) {
            z0.u.a(textView);
            z0.y.m(textView, Integer.valueOf(Math.max(iArr[0] - z0.h.c(textView, 34.0f), 0)), null, null, null, 14, null);
        }
        View findViewById = contentView.findViewById(R$id.feedGuideCircle);
        kotlin.jvm.internal.s.h(findViewById, "contentView.findViewById…ew>(R.id.feedGuideCircle)");
        int i10 = iArr[0];
        t tVar = f12377a;
        z0.y.m(findViewById, Integer.valueOf(i10 + z0.h.c(tVar, 5.0f)), Integer.valueOf(z0.h.c(tVar, 6.0f)), null, null, 12, null);
        kotlin.jvm.internal.s.h(contentView, "contentView");
        final AlertDialog c4 = tVar.c(context, contentView, 0, 0, -1, -2, BadgeDrawable.TOP_START);
        contentView.setOnClickListener(new View.OnClickListener() { // from class: com.cupidapp.live.base.utils.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t.f(c4, view);
            }
        });
    }

    public static final void f(AlertDialog alertDialog, View view) {
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public final AlertDialog c(Context context, View view, int i10, int i11, int i12, int i13, int i14) {
        AlertDialog create = z0.b.f54812a.e(context).setView(view).create();
        Window window = create.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setDimAmount(0.3f);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                attributes.f816x = i10;
            }
            if (attributes != null) {
                attributes.f817y = i11;
            }
        }
        try {
            create.show();
        } catch (Exception unused) {
        }
        if (window != null) {
            window.setLayout(i12, i13);
        }
        if (window != null) {
            window.setGravity(i14);
        }
        return create;
    }

    public final void d(@NotNull final View anchor, @NotNull final Context context) {
        kotlin.jvm.internal.s.i(anchor, "anchor");
        kotlin.jvm.internal.s.i(context, "context");
        p1.g gVar = p1.g.f52734a;
        if (kotlin.jvm.internal.s.d(gVar.B(), Boolean.TRUE)) {
            gVar.l2(Boolean.FALSE);
            anchor.post(new Runnable() { // from class: com.cupidapp.live.base.utils.s
                @Override // java.lang.Runnable
                public final void run() {
                    t.e(context, anchor);
                }
            });
        }
    }
}
