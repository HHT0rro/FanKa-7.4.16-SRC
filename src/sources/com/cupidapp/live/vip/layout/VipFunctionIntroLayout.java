package com.cupidapp.live.vip.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.utils.h;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.vip.model.VipFunctionUiModel;
import com.cupidapp.live.vip.model.VipType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: VipFunctionIntroLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipFunctionIntroLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18783d;

    /* compiled from: VipFunctionIntroLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18784a;

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
            f18784a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipFunctionIntroLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18783d = new LinkedHashMap();
        g();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f18783d;
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

    public final void f(@NotNull VipFunctionUiModel model, @NotNull final Function0<p> dismiss) {
        s.i(model, "model");
        s.i(dismiss, "dismiss");
        int i10 = R$id.function_intro_title;
        ((TextView) e(i10)).setText(model.getName());
        int i11 = R$id.function_intro_subtitle;
        ((TextView) e(i11)).setText(model.getDialogContent());
        ((ImageView) e(R$id.function_intro_img)).setImageResource(model.getDialogImage());
        int i12 = R$id.function_intro_close;
        ImageView function_intro_close = (ImageView) e(i12);
        s.h(function_intro_close, "function_intro_close");
        y.d(function_intro_close, new Function1<View, p>() { // from class: com.cupidapp.live.vip.layout.VipFunctionIntroLayout$configData$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                dismiss.invoke();
            }
        });
        int i13 = a.f18784a[model.getVipType().ordinal()];
        if (i13 == 1) {
            ((ConstraintLayout) e(R$id.function_intro_cl)).setBackgroundResource(R$drawable.rect_top_cor_16_sd_1a1a1a);
            ((TextView) e(i10)).setTextColor(-1);
            ((TextView) e(i11)).setTextColor(h.a(-1, 0.6f));
            ((ConstraintLayout) e(R$id.function_intro_root)).setBackgroundColor(h.a(-13487566, 0.8f));
            ((ImageView) e(i12)).setImageResource(R$mipmap.dialog_ic_close_in_black);
            ((FrameLayout) e(R$id.function_intro_img_root)).setBackgroundDrawable(null);
            return;
        }
        if (i13 != 2) {
            ((ConstraintLayout) e(R$id.function_intro_cl)).setBackgroundResource(R$drawable.rect_top_cor_16_sd_ffffff);
            ((TextView) e(i10)).setTextColor(-15066598);
            ((TextView) e(i11)).setTextColor(-7434610);
            ((ConstraintLayout) e(R$id.function_intro_root)).setBackgroundColor(h.a(-16777216, 0.6f));
            ((ImageView) e(i12)).setImageResource(R$mipmap.pop_ic_close_gray);
            ((FrameLayout) e(R$id.function_intro_img_root)).setBackgroundResource(R$drawable.rect_top_cor_16_sd_f7f7f7);
            return;
        }
        ((ConstraintLayout) e(R$id.function_intro_cl)).setBackgroundResource(R$drawable.rect_top_cor_16_sd_1a1a1a);
        ((TextView) e(i10)).setTextColor(-1);
        ((TextView) e(i11)).setTextColor(h.a(-1, 0.6f));
        ((ConstraintLayout) e(R$id.function_intro_root)).setBackgroundColor(h.a(-13487566, 0.8f));
        ((ImageView) e(i12)).setImageResource(R$mipmap.dialog_ic_close_in_black);
        ((FrameLayout) e(R$id.function_intro_img_root)).setBackgroundDrawable(null);
    }

    public final void g() {
        z.a(this, R$layout.layout_vip_function_intro, true);
        TextView function_intro_title = (TextView) e(R$id.function_intro_title);
        s.h(function_intro_title, "function_intro_title");
        u.a(function_intro_title);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipFunctionIntroLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18783d = new LinkedHashMap();
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipFunctionIntroLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18783d = new LinkedHashMap();
        g();
    }
}
