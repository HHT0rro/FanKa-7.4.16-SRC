package com.cupidapp.live.base.view.timepicker;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.contrarywind.view.WheelView;
import com.cupidapp.live.R$layout;
import java.util.Calendar;
import java.util.Date;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joda.time.LocalDate;
import z0.v;

/* compiled from: DateTimePickerWrapper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class g {

    /* renamed from: a */
    @Nullable
    public l f12919a;

    /* renamed from: b */
    @Nullable
    public j0.b f12920b;

    /* renamed from: c */
    @Nullable
    public n0.c f12921c;

    public static final void f(g this$0, Date date, View view) {
        s.i(this$0, "this$0");
        l lVar = this$0.f12919a;
        if (lVar != null) {
            lVar.b(date);
        }
    }

    public static final void g(g this$0, Date date) {
        s.i(this$0, "this$0");
        l lVar = this$0.f12919a;
        if (lVar != null) {
            lVar.a(date);
        }
    }

    public static /* synthetic */ g i(g gVar, int i10, float f10, int i11, Integer num, Integer num2, Integer num3, boolean z10, boolean z11, ViewGroup viewGroup, int i12, Object obj) {
        return gVar.h((i12 & 1) != 0 ? 12 : i10, (i12 & 2) != 0 ? 1.2f : f10, (i12 & 4) != 0 ? 5 : i11, (i12 & 8) != 0 ? null : num, (i12 & 16) != 0 ? null : num2, (i12 & 32) != 0 ? null : num3, (i12 & 64) != 0 ? false : z10, (i12 & 128) != 0 ? true : z11, (i12 & 256) == 0 ? viewGroup : null);
    }

    public static final void k(View view) {
    }

    @NotNull
    public final g d(boolean z10) {
        j0.b bVar = this.f12920b;
        n0.c a10 = bVar != null ? bVar.a() : null;
        this.f12921c = a10;
        if (a10 != null) {
            a10.s(z10);
        }
        return this;
    }

    @NotNull
    public final g e(@Nullable Context context, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        LocalDate q10;
        LocalDate q11;
        LocalDate q12;
        if (str == null || (q10 = v.q(str)) == null) {
            q10 = v.q("1990-08-01");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(q10.getYear(), q10.getMonthOfYear() - 1, q10.getDayOfMonth());
        if (str2 == null || (q11 = v.q(str2)) == null) {
            q11 = v.q("1980-08-01");
        }
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(q11.getYear(), q11.getMonthOfYear() - 1, q11.getDayOfMonth());
        if (str3 == null || (q12 = v.q(str3)) == null) {
            q12 = v.q("2000-08-01");
        }
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(q12.getYear(), q12.getMonthOfYear() - 1, q12.getDayOfMonth());
        this.f12920b = new j0.b(context, new l0.g() { // from class: com.cupidapp.live.base.view.timepicker.f
            @Override // l0.g
            public final void a(Date date, View view) {
                g.f(g.this, date, view);
            }
        }).c(calendar).l(calendar2, calendar3).q(new l0.f() { // from class: com.cupidapp.live.base.view.timepicker.e
            @Override // l0.f
            public final void a(Date date) {
                g.g(g.this, date);
            }
        });
        return this;
    }

    @NotNull
    public final g h(int i10, float f10, int i11, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, boolean z10, boolean z11, @Nullable ViewGroup viewGroup) {
        j0.b bVar = this.f12920b;
        if (bVar != null) {
            bVar.r(new boolean[]{true, true, true, false, false, false});
            bVar.b(i10);
            bVar.h("", "", "", "", "", "");
            bVar.p(0, 0, 0, 0, 0, 0);
            bVar.j(f10);
            bVar.g(i11);
            bVar.f(WheelView.DividerType.FILL);
            if (num != null) {
                bVar.e(num.intValue());
            }
            if (num2 != null) {
                bVar.n(num2.intValue());
            }
            if (num3 != null) {
                bVar.o(num3.intValue());
            }
            bVar.m(z10);
            if (Build.VERSION.SDK_INT >= 28) {
                bVar.s(Typeface.create(Typeface.DEFAULT, 500, false));
            }
            bVar.k(z11);
            bVar.d(viewGroup);
        }
        return this;
    }

    @NotNull
    public final g j() {
        j0.b bVar = this.f12920b;
        if (bVar != null) {
            bVar.i(R$layout.layout_timepicker, new l0.a() { // from class: com.cupidapp.live.base.view.timepicker.d
                @Override // l0.a
                public final void a(View view) {
                    g.k(view);
                }
            });
        }
        return this;
    }

    @NotNull
    public final g l(@Nullable l lVar) {
        this.f12919a = lVar;
        return this;
    }

    public final void m(boolean z10) {
        n0.c cVar = this.f12921c;
        if (cVar != null) {
            cVar.w(z10);
        }
    }
}
