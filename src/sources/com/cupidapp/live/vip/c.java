package com.cupidapp.live.vip;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.setting.activity.SettingAssistantActivity;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import p1.g;
import z0.h;

/* compiled from: VipAdHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f18740a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final int f18741b = 3;

    public static final void e(PopupWindow pop, Function0 closeCallback, View view) {
        s.i(pop, "$pop");
        s.i(closeCallback, "$closeCallback");
        pop.dismiss();
        closeCallback.invoke();
    }

    public static final void f(PopupWindow pop, Function0 closeCallback, View view, View view2) {
        s.i(pop, "$pop");
        s.i(closeCallback, "$closeCallback");
        s.i(view, "$view");
        pop.dismiss();
        closeCallback.invoke();
        SettingAssistantActivity.f18009s.a(view.getContext());
    }

    public final boolean c() {
        Integer c4 = g.f52734a.H1().c();
        return (c4 != null ? c4.intValue() : 0) < f18741b;
    }

    public final void d(@NotNull final View view, @NotNull final Function0<p> closeCallback) {
        s.i(view, "view");
        s.i(closeCallback, "closeCallback");
        if (h() && c()) {
            g gVar = g.f52734a;
            Integer c4 = gVar.H1().c();
            gVar.H1().d(Integer.valueOf((c4 != null ? c4.intValue() : 0) + 1));
            View inflate = LayoutInflater.from(view.getContext()).inflate(R$layout.layout_vip_pop_menu, (ViewGroup) null);
            final PopupWindow popupWindow = new PopupWindow(inflate, h.c(this, 150.0f), h.c(this, 80.0f));
            popupWindow.setBackgroundDrawable(new BitmapDrawable());
            popupWindow.setOutsideTouchable(true);
            popupWindow.showAsDropDown(view);
            View findViewById = inflate.findViewById(R$id.text_vip_close);
            if (findViewById != null) {
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.cupidapp.live.vip.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        c.e(PopupWindow.this, closeCallback, view2);
                    }
                });
            }
            View findViewById2 = inflate.findViewById(R$id.text_vip_setting);
            if (findViewById2 != null) {
                findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.cupidapp.live.vip.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        c.f(PopupWindow.this, closeCallback, view, view2);
                    }
                });
                return;
            }
            return;
        }
        closeCallback.invoke();
    }

    public final boolean g() {
        return com.cupidapp.live.profile.logic.c.f17839a.f();
    }

    public final boolean h() {
        return g() && !i();
    }

    public final boolean i() {
        User X = g.f52734a.X();
        return X != null && 1 == X.getVipAd();
    }
}
