package com.cupidapp.live.consult.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.router.j;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: ConsultListEmptyLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultListEmptyLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public String f13863b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13864c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultListEmptyLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13864c = new LinkedHashMap();
        d();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13864c;
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

    public final void c(@Nullable String str, @Nullable String str2) {
        if (str == null || str.length() == 0) {
            ((TextView) a(R$id.view_fortune_txt)).setVisibility(4);
            return;
        }
        this.f13863b = str2;
        int i10 = R$id.view_fortune_txt;
        ((TextView) a(i10)).setVisibility(0);
        ((TextView) a(i10)).setText(str);
    }

    public final void d() {
        z.a(this, R$layout.layout_consult_list_empty, true);
        int i10 = R$id.view_fortune_txt;
        TextView view_fortune_txt = (TextView) a(i10);
        s.h(view_fortune_txt, "view_fortune_txt");
        u.a(view_fortune_txt);
        TextView view_fortune_txt2 = (TextView) a(i10);
        s.h(view_fortune_txt2, "view_fortune_txt");
        y.d(view_fortune_txt2, new Function1<View, p>() { // from class: com.cupidapp.live.consult.view.ConsultListEmptyLayout$initView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                String str;
                j.a aVar = j.f12156c;
                Context context = ConsultListEmptyLayout.this.getContext();
                str = ConsultListEmptyLayout.this.f13863b;
                j.a.b(aVar, context, str, null, 4, null);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultListEmptyLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13864c = new LinkedHashMap();
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultListEmptyLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13864c = new LinkedHashMap();
        d();
    }
}
