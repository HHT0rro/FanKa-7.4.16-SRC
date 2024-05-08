package com.cupidapp.live.visitors.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.z;

/* compiled from: SaleTimeCountLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class SaleTimeCountLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18941b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaleTimeCountLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18941b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f18941b;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void b(long j10) {
        long j11 = 24 * 3600000;
        if (j10 > j11) {
            long j12 = j10 / j11;
            int ceil = (int) Math.ceil((j10 % j11) / 3600000);
            if (ceil > 23) {
                j12++;
                ceil = 0;
            }
            int i10 = R$id.invalid_day_count_txt;
            ((TextView) a(i10)).setVisibility(0);
            ((TextView) a(R$id.invalid_day_txt)).setVisibility(0);
            ((TextView) a(i10)).setText(String.valueOf(j12));
            int i11 = R$id.invalid_hour_count_txt;
            ((TextView) a(i11)).setText(String.valueOf(ceil));
            TextView invalid_day_count_txt = (TextView) a(i10);
            s.h(invalid_day_count_txt, "invalid_day_count_txt");
            u.a(invalid_day_count_txt);
            TextView invalid_hour_count_txt = (TextView) a(i11);
            s.h(invalid_hour_count_txt, "invalid_hour_count_txt");
            u.a(invalid_hour_count_txt);
            return;
        }
        String valueOf = String.valueOf((int) Math.ceil(j10 / 3600000));
        ((TextView) a(R$id.invalid_day_count_txt)).setVisibility(8);
        ((TextView) a(R$id.invalid_day_txt)).setVisibility(8);
        int i12 = R$id.invalid_hour_count_txt;
        ((TextView) a(i12)).setText(valueOf);
        TextView invalid_hour_count_txt2 = (TextView) a(i12);
        s.h(invalid_hour_count_txt2, "invalid_hour_count_txt");
        u.a(invalid_hour_count_txt2);
    }

    public final void c() {
        z.a(this, R$layout.layout_sales_invalided_time, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaleTimeCountLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18941b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaleTimeCountLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18941b = new LinkedHashMap();
        c();
    }
}
