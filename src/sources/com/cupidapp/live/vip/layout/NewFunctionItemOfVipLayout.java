package com.cupidapp.live.vip.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.utils.h;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.vip.model.VipFunctionUiModel;
import com.cupidapp.live.vip.model.VipType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.z;

/* compiled from: NewFunctionItemOfVipLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NewFunctionItemOfVipLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18768d;

    /* compiled from: NewFunctionItemOfVipLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18769a;

        static {
            int[] iArr = new int[VipType.values().length];
            try {
                iArr[VipType.SUPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[VipType.RAINBOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f18769a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewFunctionItemOfVipLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18768d = new LinkedHashMap();
        g();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f18768d;
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

    public final void f(@NotNull VipFunctionUiModel model, @NotNull VipType vipType) {
        s.i(model, "model");
        s.i(vipType, "vipType");
        int i10 = a.f18769a[vipType.ordinal()];
        boolean z10 = true;
        if (i10 == 1) {
            ((TextView) e(R$id.function_title_text_view)).setTextColor(-1);
            ((TextView) e(R$id.function_sub_title)).setTextColor(h.a(-1, 0.6f));
        } else if (i10 != 2) {
            ((TextView) e(R$id.function_title_text_view)).setTextColor(-15066598);
            ((TextView) e(R$id.function_sub_title)).setTextColor(-5658199);
        } else {
            ((TextView) e(R$id.function_title_text_view)).setTextColor(-1);
            ((TextView) e(R$id.function_sub_title)).setTextColor(h.a(-1, 0.6f));
        }
        int i11 = R$id.function_title_text_view;
        TextView function_title_text_view = (TextView) e(i11);
        s.h(function_title_text_view, "function_title_text_view");
        u.a(function_title_text_view);
        ((ImageView) e(R$id.function_icon)).setImageResource(model.getImage());
        ((TextView) e(i11)).setText(model.getName());
        String onLineTime = model.getOnLineTime();
        if (onLineTime != null && onLineTime.length() != 0) {
            z10 = false;
        }
        if (z10) {
            ((TextView) e(R$id.function_sub_title)).setText(getContext().getString(R$string.recent_online));
        } else {
            ((TextView) e(R$id.function_sub_title)).setText(model.getOnLineTime());
        }
    }

    public final void g() {
        z.a(this, R$layout.layout_new_function_item, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewFunctionItemOfVipLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18768d = new LinkedHashMap();
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewFunctionItemOfVipLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18768d = new LinkedHashMap();
        g();
    }
}
