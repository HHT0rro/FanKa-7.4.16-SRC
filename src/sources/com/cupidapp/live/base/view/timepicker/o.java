package com.cupidapp.live.base.view.timepicker;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.cupidapp.live.R$layout;
import java.util.Calendar;
import java.util.Date;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joda.time.LocalDate;
import z0.v;

/* compiled from: TimePickerWrapper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final Context f12935a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f12936b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f12937c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f12938d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Function1<Date, p> f12939e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public j0.b f12940f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public n0.c f12941g;

    /* JADX WARN: Multi-variable type inference failed */
    public o(@NotNull Context context, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull Function1<? super Date, p> selectedListener) {
        s.i(context, "context");
        s.i(selectedListener, "selectedListener");
        this.f12935a = context;
        this.f12936b = str;
        this.f12937c = str2;
        this.f12938d = str3;
        this.f12939e = selectedListener;
    }

    public static /* synthetic */ o e(o oVar, int i10, float f10, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 12;
        }
        if ((i11 & 2) != 0) {
            f10 = 2.0f;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return oVar.d(i10, f10, z10);
    }

    public static final void f(o this$0, Date date, View view) {
        s.i(this$0, "this$0");
        this$0.f12939e.invoke(date);
    }

    public static final void h(View view) {
    }

    public final void c() {
        n0.c cVar = this.f12941g;
        if (cVar != null) {
            cVar.C();
        }
    }

    @NotNull
    public final o d(int i10, float f10, boolean z10) {
        LocalDate q10;
        LocalDate q11;
        LocalDate q12;
        String str = this.f12936b;
        if (str == null || (q10 = v.q(str)) == null) {
            q10 = v.q("1990-08-01");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(q10.getYear(), q10.getMonthOfYear() - 1, q10.getDayOfMonth());
        String str2 = this.f12937c;
        if (str2 == null || (q11 = v.q(str2)) == null) {
            q11 = v.q("1980-08-01");
        }
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(q11.getYear(), q11.getMonthOfYear() - 1, q11.getDayOfMonth());
        String str3 = this.f12938d;
        if (str3 == null || (q12 = v.q(str3)) == null) {
            q12 = v.q("2000-08-01");
        }
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(q12.getYear(), q12.getMonthOfYear() - 1, q12.getDayOfMonth());
        this.f12940f = new j0.b(this.f12935a, new l0.g() { // from class: com.cupidapp.live.base.view.timepicker.n
            @Override // l0.g
            public final void a(Date date, View view) {
                o.f(o.this, date, view);
            }
        }).c(calendar).l(calendar2, calendar3).m(z10).b(i10).h("", "", "", "", "", "").p(40, 0, -40, 0, 0, 0).j(f10);
        return this;
    }

    @NotNull
    public final o g(@NotNull ViewGroup decorView) {
        j0.b i10;
        j0.b d10;
        s.i(decorView, "decorView");
        j0.b bVar = this.f12940f;
        if (bVar != null && (i10 = bVar.i(R$layout.layout_timepicker, new l0.a() { // from class: com.cupidapp.live.base.view.timepicker.m
            @Override // l0.a
            public final void a(View view) {
                o.h(view);
            }
        })) != null && (d10 = i10.d(decorView)) != null) {
            d10.k(false);
        }
        j0.b bVar2 = this.f12940f;
        n0.c a10 = bVar2 != null ? bVar2.a() : null;
        this.f12941g = a10;
        if (a10 != null) {
            a10.s(false);
        }
        return this;
    }

    public final void i(@Nullable ViewGroup viewGroup, boolean z10) {
        n0.c cVar = this.f12941g;
        if (cVar != null) {
            cVar.v(viewGroup, z10);
        }
    }
}
