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
import org.joda.time.DateTime;

/* compiled from: CustomTimePickerWrapper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final Context f12911a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final Long f12912b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Function1<Date, p> f12913c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public j0.b f12914d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public n0.c f12915e;

    /* JADX WARN: Multi-variable type inference failed */
    public c(@NotNull Context context, @Nullable Long l10, @NotNull Function1<? super Date, p> selectedListener) {
        s.i(context, "context");
        s.i(selectedListener, "selectedListener");
        this.f12911a = context;
        this.f12912b = l10;
        this.f12913c = selectedListener;
    }

    public static final void e(c this$0, Date date, View view) {
        s.i(this$0, "this$0");
        this$0.f12913c.invoke(date);
    }

    public static final void g(View view) {
    }

    public final void c() {
        n0.c cVar = this.f12915e;
        if (cVar != null) {
            cVar.C();
        }
    }

    @NotNull
    public final c d(int i10) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(11, 24);
        calendar2.set(12, 0);
        Calendar calendar3 = Calendar.getInstance();
        DateTime dateTime = new DateTime(this.f12912b);
        calendar3.set(11, dateTime.getHourOfDay());
        calendar3.set(12, dateTime.getMinuteOfHour());
        this.f12914d = new j0.b(this.f12911a, new l0.g() { // from class: com.cupidapp.live.base.view.timepicker.b
            @Override // l0.g
            public final void a(Date date, View view) {
                c.e(c.this, date, view);
            }
        }).r(new boolean[]{false, false, false, true, true, false}).b(i10).l(calendar, calendar2).c(calendar3).h("", "", "", "", "", "").p(40, 0, -40, 0, 0, 0).j(2.0f);
        return this;
    }

    @NotNull
    public final c f(@NotNull ViewGroup decorView) {
        j0.b i10;
        j0.b d10;
        s.i(decorView, "decorView");
        j0.b bVar = this.f12914d;
        if (bVar != null && (i10 = bVar.i(R$layout.layout_timepicker, new l0.a() { // from class: com.cupidapp.live.base.view.timepicker.a
            @Override // l0.a
            public final void a(View view) {
                c.g(view);
            }
        })) != null && (d10 = i10.d(decorView)) != null) {
            d10.k(false);
        }
        j0.b bVar2 = this.f12914d;
        n0.c a10 = bVar2 != null ? bVar2.a() : null;
        this.f12915e = a10;
        if (a10 != null) {
            a10.s(false);
        }
        return this;
    }

    public final void h(@Nullable ViewGroup viewGroup, boolean z10) {
        n0.c cVar = this.f12915e;
        if (cVar != null) {
            cVar.v(viewGroup, z10);
        }
    }
}
