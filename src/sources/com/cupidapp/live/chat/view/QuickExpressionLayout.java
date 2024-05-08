package com.cupidapp.live.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$array;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.view.decoration.FKAddExtraSpacingDecoration;
import com.cupidapp.live.chat.adapter.QuickExpressionAdapter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.m;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.z;

/* compiled from: QuickExpressionLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class QuickExpressionLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function1<? super String, p> f13237b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13238c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickExpressionLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13238c = new LinkedHashMap();
        d();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13238c;
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

    public final void c() {
        QuickExpressionAdapter quickExpressionAdapter = new QuickExpressionAdapter();
        quickExpressionAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.chat.view.QuickExpressionLayout$configRecyclerView$quickExpressionAdapter$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:3:0x0004, code lost:
            
                r0 = r1.this$0.f13237b;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(@org.jetbrains.annotations.Nullable java.lang.Object r2) {
                /*
                    r1 = this;
                    boolean r0 = r2 instanceof java.lang.String
                    if (r0 == 0) goto Lf
                    com.cupidapp.live.chat.view.QuickExpressionLayout r0 = com.cupidapp.live.chat.view.QuickExpressionLayout.this
                    kotlin.jvm.functions.Function1 r0 = com.cupidapp.live.chat.view.QuickExpressionLayout.b(r0)
                    if (r0 == 0) goto Lf
                    r0.invoke(r2)
                Lf:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.chat.view.QuickExpressionLayout$configRecyclerView$quickExpressionAdapter$1$1.invoke2(java.lang.Object):void");
            }
        });
        RecyclerView configRecyclerView$lambda$1 = (RecyclerView) a(R$id.quickExpressionRecyclerView);
        configRecyclerView$lambda$1.setAdapter(quickExpressionAdapter);
        configRecyclerView$lambda$1.setLayoutManager(new LinearLayoutManager(configRecyclerView$lambda$1.getContext(), 0, false));
        s.h(configRecyclerView$lambda$1, "configRecyclerView$lambda$1");
        configRecyclerView$lambda$1.addItemDecoration(new FKAddExtraSpacingDecoration(0, 0, 0, 0, h.c(configRecyclerView$lambda$1, 12.0f), 0, 32, null));
        String[] stringArray = getResources().getStringArray(R$array.emoji_face);
        s.h(stringArray, "resources.getStringArray(R.array.emoji_face)");
        quickExpressionAdapter.e(m.N(stringArray));
        quickExpressionAdapter.notifyDataSetChanged();
    }

    public final void d() {
        z.a(this, R$layout.layout_quick_expression, true);
        c();
    }

    public final void setItemClickListener(@NotNull Function1<? super String, p> listener) {
        s.i(listener, "listener");
        this.f13237b = listener;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickExpressionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13238c = new LinkedHashMap();
        d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickExpressionLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13238c = new LinkedHashMap();
        d();
    }
}
