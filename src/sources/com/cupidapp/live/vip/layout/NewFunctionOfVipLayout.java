package com.cupidapp.live.vip.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.utils.h;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.vip.model.VipFunctionUiModel;
import com.cupidapp.live.vip.model.VipType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: NewFunctionOfVipLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NewFunctionOfVipLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18770d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewFunctionOfVipLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18770d = new LinkedHashMap();
        g();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f18770d;
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

    public final void f(@NotNull List<VipFunctionUiModel> functionList, @NotNull VipType vipType, @NotNull final Function1<? super VipFunctionUiModel, p> itemClick) {
        s.i(functionList, "functionList");
        s.i(vipType, "vipType");
        s.i(itemClick, "itemClick");
        ((LinearLayout) e(R$id.new_function_ll)).removeAllViews();
        if (vipType == VipType.NORMAL) {
            ((TextView) e(R$id.new_function_title)).setTextColor(-5658199);
            ((ConstraintLayout) e(R$id.new_function_cl)).setBackgroundResource(R$drawable.rect_cor_8_sk_e9e9e9);
        } else {
            ((TextView) e(R$id.new_function_title)).setTextColor(h.a(-1, 0.6f));
            ((ConstraintLayout) e(R$id.new_function_cl)).setBackgroundResource(R$drawable.rect_cor_8_sk_26ffffff);
        }
        for (final VipFunctionUiModel vipFunctionUiModel : functionList) {
            Context context = getContext();
            s.h(context, "context");
            NewFunctionItemOfVipLayout newFunctionItemOfVipLayout = new NewFunctionItemOfVipLayout(context);
            newFunctionItemOfVipLayout.f(vipFunctionUiModel, vipType);
            y.d(newFunctionItemOfVipLayout, new Function1<View, p>() { // from class: com.cupidapp.live.vip.layout.NewFunctionOfVipLayout$configData$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    itemClick.invoke(vipFunctionUiModel);
                }
            });
            ((LinearLayout) e(R$id.new_function_ll)).addView(newFunctionItemOfVipLayout, new LinearLayout.LayoutParams(0, -2, 1.0f));
        }
    }

    public final void g() {
        z.a(this, R$layout.layout_new_function_of_vip, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewFunctionOfVipLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18770d = new LinkedHashMap();
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewFunctionOfVipLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18770d = new LinkedHashMap();
        g();
    }
}
