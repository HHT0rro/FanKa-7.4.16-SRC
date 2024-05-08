package com.cupidapp.live.base.view.timepicker;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import com.contrarywind.view.WheelView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: OptionsPickerWrapper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class OptionsPickerWrapper {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public List<String> f12903a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public List<String> f12904b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public List<String> f12905c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public h f12906d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public j0.a f12907e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public n0.b<String> f12908f;

    public static /* synthetic */ OptionsPickerWrapper g(OptionsPickerWrapper optionsPickerWrapper, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return optionsPickerWrapper.f(z10);
    }

    public static /* synthetic */ OptionsPickerWrapper i(OptionsPickerWrapper optionsPickerWrapper, Context context, OptionsModel optionsModel, OptionsModel optionsModel2, OptionsModel optionsModel3, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            optionsModel2 = null;
        }
        if ((i10 & 8) != 0) {
            optionsModel3 = null;
        }
        return optionsPickerWrapper.h(context, optionsModel, optionsModel2, optionsModel3);
    }

    public static final void j(OptionsPickerWrapper this$0, int i10, int i11, int i12, View view) {
        s.i(this$0, "this$0");
        h hVar = this$0.f12906d;
        if (hVar != null) {
            hVar.a(i10, i11, i12);
        }
    }

    public static final void k(OptionsPickerWrapper this$0, int i10, int i11, int i12) {
        s.i(this$0, "this$0");
        h hVar = this$0.f12906d;
        if (hVar != null) {
            hVar.b(i10, i11, i12);
        }
    }

    public static /* synthetic */ OptionsPickerWrapper o(OptionsPickerWrapper optionsPickerWrapper, int i10, float f10, int i11, Integer num, Integer num2, Integer num3, Typeface typeface, boolean z10, ViewGroup viewGroup, int i12, Object obj) {
        Typeface DEFAULT;
        int i13 = (i12 & 1) != 0 ? 12 : i10;
        float f11 = (i12 & 2) != 0 ? 1.2f : f10;
        int i14 = (i12 & 4) != 0 ? 5 : i11;
        Integer num4 = (i12 & 8) != 0 ? null : num;
        Integer num5 = (i12 & 16) != 0 ? null : num2;
        Integer num6 = (i12 & 32) != 0 ? null : num3;
        if ((i12 & 64) != 0) {
            DEFAULT = Typeface.DEFAULT;
            s.h(DEFAULT, "DEFAULT");
        } else {
            DEFAULT = typeface;
        }
        return optionsPickerWrapper.n(i13, f11, i14, num4, num5, num6, DEFAULT, (i12 & 128) != 0 ? true : z10, (i12 & 256) == 0 ? viewGroup : null);
    }

    public static final void r(Integer num, boolean z10, int i10, float f10, int i11, final OptionsPickerWrapper this$0, int i12, float f11, int i13, View view) {
        s.i(this$0, "this$0");
        if (num != null) {
            view.setBackgroundResource(num.intValue());
        }
        RelativeLayout titleLayout = (RelativeLayout) view.findViewById(R$id.title_layout);
        if (z10) {
            titleLayout.setVisibility(0);
            s.h(titleLayout, "titleLayout");
            y.d(titleLayout, new Function1<View, p>() { // from class: com.cupidapp.live.base.view.timepicker.OptionsPickerWrapper$setLayoutRes$1$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(View view2) {
                    invoke2(view2);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view2) {
                }
            });
            TextView setLayoutRes$lambda$6$lambda$4 = (TextView) view.findViewById(R$id.confirm_textview);
            setLayoutRes$lambda$6$lambda$4.getPaint().setFakeBoldText(true);
            setLayoutRes$lambda$6$lambda$4.setText(setLayoutRes$lambda$6$lambda$4.getContext().getString(i10));
            setLayoutRes$lambda$6$lambda$4.setTextSize(f10);
            setLayoutRes$lambda$6$lambda$4.setTextColor(i11);
            s.h(setLayoutRes$lambda$6$lambda$4, "setLayoutRes$lambda$6$lambda$4");
            y.d(setLayoutRes$lambda$6$lambda$4, new Function1<View, p>() { // from class: com.cupidapp.live.base.view.timepicker.OptionsPickerWrapper$setLayoutRes$1$2$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(View view2) {
                    invoke2(view2);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view2) {
                    n0.b bVar;
                    n0.b bVar2;
                    h hVar;
                    bVar = OptionsPickerWrapper.this.f12908f;
                    if (bVar != null) {
                        bVar.f();
                    }
                    bVar2 = OptionsPickerWrapper.this.f12908f;
                    if (bVar2 != null) {
                        bVar2.A();
                    }
                    hVar = OptionsPickerWrapper.this.f12906d;
                    if (hVar != null) {
                        hVar.onConfirm();
                    }
                }
            });
            TextView setLayoutRes$lambda$6$lambda$5 = (TextView) view.findViewById(R$id.cancel_textview);
            setLayoutRes$lambda$6$lambda$5.getPaint().setFakeBoldText(true);
            setLayoutRes$lambda$6$lambda$5.setText(setLayoutRes$lambda$6$lambda$5.getContext().getString(i12));
            setLayoutRes$lambda$6$lambda$5.setTextSize(f11);
            setLayoutRes$lambda$6$lambda$5.setTextColor(i13);
            s.h(setLayoutRes$lambda$6$lambda$5, "setLayoutRes$lambda$6$lambda$5");
            y.d(setLayoutRes$lambda$6$lambda$5, new Function1<View, p>() { // from class: com.cupidapp.live.base.view.timepicker.OptionsPickerWrapper$setLayoutRes$1$3$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(View view2) {
                    invoke2(view2);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view2) {
                    n0.b bVar;
                    h hVar;
                    bVar = OptionsPickerWrapper.this.f12908f;
                    if (bVar != null) {
                        bVar.f();
                    }
                    hVar = OptionsPickerWrapper.this.f12906d;
                    if (hVar != null) {
                        hVar.onCancel();
                    }
                }
            });
            return;
        }
        titleLayout.setVisibility(8);
    }

    public static /* synthetic */ void u(OptionsPickerWrapper optionsPickerWrapper, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        optionsPickerWrapper.t(z10);
    }

    @NotNull
    public final OptionsPickerWrapper f(boolean z10) {
        j0.a aVar = this.f12907e;
        n0.b<String> a10 = aVar != null ? aVar.a() : null;
        this.f12908f = a10;
        if (a10 != null) {
            a10.B(this.f12903a, this.f12904b, this.f12905c);
        }
        n0.b<String> bVar = this.f12908f;
        if (bVar != null) {
            bVar.s(z10);
        }
        return this;
    }

    @NotNull
    public final OptionsPickerWrapper h(@Nullable Context context, @NotNull OptionsModel options1, @Nullable OptionsModel optionsModel, @Nullable OptionsModel optionsModel2) {
        s.i(options1, "options1");
        this.f12903a = options1.getOptionList();
        this.f12904b = optionsModel != null ? optionsModel.getOptionList() : null;
        this.f12905c = optionsModel2 != null ? optionsModel2.getOptionList() : null;
        j0.a aVar = new j0.a(context, new l0.e() { // from class: com.cupidapp.live.base.view.timepicker.k
            @Override // l0.e
            public final void a(int i10, int i11, int i12, View view) {
                OptionsPickerWrapper.j(OptionsPickerWrapper.this, i10, i11, i12, view);
            }
        });
        if (optionsModel != null && optionsModel2 != null) {
            aVar.m(l(options1), l(optionsModel), l(optionsModel2));
        } else if (optionsModel != null) {
            aVar.l(l(options1), l(optionsModel));
        } else {
            aVar.k(l(options1));
        }
        aVar.i(new l0.d() { // from class: com.cupidapp.live.base.view.timepicker.j
            @Override // l0.d
            public final void a(int i10, int i11, int i12) {
                OptionsPickerWrapper.k(OptionsPickerWrapper.this, i10, i11, i12);
            }
        });
        this.f12907e = aVar;
        return this;
    }

    public final int l(OptionsModel optionsModel) {
        List<String> optionList = optionsModel.getOptionList();
        String selectedValue = optionsModel.getSelectedValue();
        if (selectedValue != null && optionList.contains(selectedValue)) {
            return optionList.indexOf(selectedValue);
        }
        return 0;
    }

    public final void m() {
        n0.b<String> bVar = this.f12908f;
        if (bVar != null) {
            bVar.A();
        }
    }

    @NotNull
    public final OptionsPickerWrapper n(int i10, float f10, int i11, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @NotNull Typeface typeface, boolean z10, @Nullable ViewGroup viewGroup) {
        s.i(typeface, "typeface");
        j0.a aVar = this.f12907e;
        if (aVar != null) {
            aVar.b(i10);
            aVar.h(f10);
            aVar.f(i11);
            aVar.e(WheelView.DividerType.FILL);
            if (num != null) {
                aVar.d(num.intValue());
            }
            if (num2 != null) {
                aVar.n(num2.intValue());
            }
            if (num3 != null) {
                aVar.o(num3.intValue());
            }
            aVar.p(typeface);
            aVar.j(z10);
            aVar.c(viewGroup);
        }
        return this;
    }

    @NotNull
    public final OptionsPickerWrapper p(@DrawableRes @Nullable final Integer num, final boolean z10, @StringRes final int i10, final float f10, final int i11, @StringRes final int i12, final float f11, final int i13) {
        j0.a aVar = this.f12907e;
        if (aVar != null) {
            aVar.g(R$layout.layout_numberpicker, new l0.a() { // from class: com.cupidapp.live.base.view.timepicker.i
                @Override // l0.a
                public final void a(View view) {
                    OptionsPickerWrapper.r(Integer.this, z10, i10, f10, i11, this, i12, f11, i13, view);
                }
            });
        }
        return this;
    }

    @NotNull
    public final OptionsPickerWrapper s(@Nullable h hVar) {
        this.f12906d = hVar;
        return this;
    }

    public final void t(boolean z10) {
        n0.b<String> bVar = this.f12908f;
        if (bVar != null) {
            bVar.w(z10);
        }
    }
}
