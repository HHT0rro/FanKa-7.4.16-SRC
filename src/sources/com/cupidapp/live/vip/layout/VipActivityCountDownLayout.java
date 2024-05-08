package com.cupidapp.live.vip.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: VipActivityCountDownLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipActivityCountDownLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18778b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipActivityCountDownLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18778b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f18778b;
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

    public final void b(@Nullable Long l10) {
        String str;
        if (l10 != null && l10.longValue() >= 1000) {
            setVisibility(0);
            long longValue = l10.longValue() - System.currentTimeMillis();
            long j10 = longValue / 86400000;
            long j11 = longValue % 86400000;
            if (j11 > 82800000) {
                j10++;
                j11 = 0;
            }
            if (j10 >= 1) {
                int i10 = R$id.day_value_text;
                ((TextView) a(i10)).setVisibility(0);
                ((TextView) a(R$id.day_text_view)).setVisibility(0);
                TextView textView = (TextView) a(i10);
                if (j10 > 10) {
                    str = String.valueOf(j10);
                } else {
                    str = "0" + j10;
                }
                textView.setText(str);
            } else {
                ((TextView) a(R$id.day_value_text)).setVisibility(8);
                ((TextView) a(R$id.day_text_view)).setVisibility(8);
            }
            long j12 = j11 / 3600000;
            if (j11 % 3600000 >= 1000) {
                j12++;
            }
            TextView textView2 = (TextView) a(R$id.hour_value_text);
            y yVar = y.f51038a;
            String format = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(j12)}, 1));
            s.h(format, "format(format, *args)");
            textView2.setText(format);
            return;
        }
        setVisibility(8);
    }

    public final void c() {
        z.a(this, R$layout.layout_vip_activity_count_down, true);
        ((TextView) a(R$id.activity_count_down)).getPaint().setFakeBoldText(true);
        ((TextView) a(R$id.day_text_view)).getPaint().setFakeBoldText(true);
        ((TextView) a(R$id.hour_text_view)).getPaint().setFakeBoldText(true);
        setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipActivityCountDownLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18778b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipActivityCountDownLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18778b = new LinkedHashMap();
        c();
    }
}
