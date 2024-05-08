package com.cupidapp.live.base.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import kotlin.jvm.functions.Function0;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;

/* compiled from: FKSnackbarView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f12778a = new g();

    public static /* synthetic */ void c(g gVar, SnackbarModel snackbarModel, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        gVar.b(snackbarModel, str, z10);
    }

    public static final void e(SnackbarModel model, View view) {
        kotlin.jvm.internal.s.i(model, "$model");
        Function0<kotlin.p> click = model.getClick();
        if (click != null) {
            click.invoke();
        }
    }

    public final void b(@NotNull SnackbarModel model, @Nullable String str, boolean z10) {
        kotlin.jvm.internal.s.i(model, "model");
        EventBus.c().o(new SnackbarMsgEvent(model, str, z10));
    }

    public final void d(@Nullable View view, @NotNull final SnackbarModel model) {
        kotlin.jvm.internal.s.i(model, "model");
        if (view == null) {
            return;
        }
        Snackbar make = Snackbar.make(view, model.getSnackbarText(), model.getTimeLength());
        kotlin.jvm.internal.s.h(make, "make(parentView, model.s…arText, model.timeLength)");
        View view2 = make.getView();
        kotlin.jvm.internal.s.h(view2, "snackbar.view");
        if (view2 instanceof Snackbar.SnackbarLayout) {
            View child = ((Snackbar.SnackbarLayout) view2).getChildAt(0);
            kotlin.jvm.internal.s.h(child, "child");
            y.m(child, null, null, null, Integer.valueOf(z0.h.c(this, 66.0f)), 7, null);
            child.setBackgroundResource(model.getBgRes());
            view2.setBackgroundColor(0);
            ViewGroup.LayoutParams layoutParams = child.getLayoutParams();
            layoutParams.width = z0.h.l(this) - z0.h.c(this, 32.0f);
            layoutParams.height = z0.h.c(this, 52.0f);
            child.setLayoutParams(layoutParams);
            child.setPadding(z0.h.c(this, 13.0f), 0, z0.h.c(this, 12.0f), 0);
        }
        TextView textView = (TextView) view2.findViewById(2131366824);
        Button actionBtn = (Button) view2.findViewById(2131366823);
        textView.setCompoundDrawablePadding(z0.h.c(this, 5.0f));
        textView.setTextSize(model.getSnackbarTextSize());
        textView.setGravity(16);
        textView.setPadding(0, 0, 0, 0);
        Integer leftDrawableRes = model.getLeftDrawableRes();
        if (leftDrawableRes != null) {
            int intValue = leftDrawableRes.intValue();
            kotlin.jvm.internal.s.h(textView, "textView");
            u.e(textView, intValue, 0, 0, 0, 14, null);
        }
        actionBtn.setTextColor(model.getActionTxtColor());
        if (model.getActionTxtBgRes() != null) {
            actionBtn.setBackgroundResource(model.getActionTxtBgRes().intValue());
        }
        actionBtn.setPadding(0, 0, 0, 0);
        if (model.getActionWidth() != null && model.getActionHeight() != null) {
            kotlin.jvm.internal.s.h(actionBtn, "actionBtn");
            y.n(actionBtn, model.getActionWidth(), model.getActionHeight());
        }
        actionBtn.setTextSize(model.getActionTxtSize());
        String actionTxt = model.getActionTxt();
        if (!(actionTxt == null || kotlin.text.p.t(actionTxt))) {
            make.setAction(model.getActionTxt(), new View.OnClickListener() { // from class: com.cupidapp.live.base.view.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    g.e(SnackbarModel.this, view3);
                }
            });
        }
        make.show();
    }
}
