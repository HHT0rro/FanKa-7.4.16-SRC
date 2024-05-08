package z0;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ViewExtension.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class y {
    public static final void a(@NotNull View view) {
        kotlin.jvm.internal.s.i(view, "<this>");
        view.setOnTouchListener(new com.cupidapp.live.base.view.l());
    }

    @NotNull
    public static final int[] b(@NotNull View view) {
        kotlin.jvm.internal.s.i(view, "<this>");
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return new int[]{view.getMeasuredWidth(), view.getMeasuredHeight()};
    }

    public static final void c(@NotNull View view, @Nullable Function1<? super View, kotlin.p> function1) {
        kotlin.jvm.internal.s.i(view, "<this>");
        view.setOnLongClickListener(new p(function1));
    }

    public static final void d(@NotNull View view, @Nullable Function1<? super View, kotlin.p> function1) {
        kotlin.jvm.internal.s.i(view, "<this>");
        view.setOnClickListener(new r(function1));
    }

    @Nullable
    public static final Bitmap e(@NotNull View view) {
        kotlin.jvm.internal.s.i(view, "<this>");
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static final void f(@NotNull View view, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4) {
        kotlin.jvm.internal.s.i(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            if (num != null) {
                ((ConstraintLayout.LayoutParams) layoutParams).goneStartMargin = num.intValue();
            }
            if (num2 != null) {
                ((ConstraintLayout.LayoutParams) layoutParams).goneTopMargin = num2.intValue();
            }
            if (num3 != null) {
                ((ConstraintLayout.LayoutParams) layoutParams).goneEndMargin = num3.intValue();
            }
            if (num4 != null) {
                ((ConstraintLayout.LayoutParams) layoutParams).goneBottomMargin = num4.intValue();
            }
            view.setLayoutParams(layoutParams);
        }
    }

    public static /* synthetic */ void g(View view, Integer num, Integer num2, Integer num3, Integer num4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = null;
        }
        if ((i10 & 2) != 0) {
            num2 = null;
        }
        if ((i10 & 4) != 0) {
            num3 = null;
        }
        if ((i10 & 8) != 0) {
            num4 = null;
        }
        f(view, num, num2, num3, num4);
    }

    public static final void h(@NotNull View view, float f10, float f11, float f12, float f13, @Nullable List<Integer> list, @NotNull GradientDrawable.Orientation gradientOrientation, @Nullable Integer num, @Nullable Integer num2) {
        kotlin.jvm.internal.s.i(view, "<this>");
        kotlin.jvm.internal.s.i(gradientOrientation, "gradientOrientation");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(new float[]{f10, f12, f11, f12, f11, f13, f10, f13});
        if (!(list == null || list.isEmpty())) {
            if (list.size() > 1) {
                gradientDrawable.setColors(CollectionsKt___CollectionsKt.w0(list));
                gradientDrawable.setOrientation(gradientOrientation);
                gradientDrawable.setGradientType(0);
            } else if (list.size() == 1) {
                gradientDrawable.setColor(list.get(0).intValue());
            }
        }
        if (num != null && num2 != null) {
            gradientDrawable.setStroke(num.intValue(), num2.intValue());
        }
        view.setBackground(gradientDrawable);
    }

    public static final void i(@NotNull View view, float f10, @NotNull List<Integer> colorList, @NotNull GradientDrawable.Orientation gradientOrientation, @Nullable Integer num, @Nullable Integer num2, float f11, float f12) {
        kotlin.jvm.internal.s.i(view, "<this>");
        kotlin.jvm.internal.s.i(colorList, "colorList");
        kotlin.jvm.internal.s.i(gradientOrientation, "gradientOrientation");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(f10);
        if (colorList.size() > 1) {
            gradientDrawable.setColors(CollectionsKt___CollectionsKt.w0(colorList));
            gradientDrawable.setOrientation(gradientOrientation);
            gradientDrawable.setGradientType(0);
        } else if (colorList.size() == 1) {
            gradientDrawable.setColor(colorList.get(0).intValue());
        }
        if (num != null && num2 != null) {
            gradientDrawable.setStroke(num.intValue(), num2.intValue(), f11, f12);
        }
        view.setBackground(gradientDrawable);
    }

    public static /* synthetic */ void j(View view, float f10, float f11, float f12, float f13, List list, GradientDrawable.Orientation orientation, Integer num, Integer num2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 2) != 0) {
            f11 = 0.0f;
        }
        if ((i10 & 4) != 0) {
            f12 = 0.0f;
        }
        if ((i10 & 8) != 0) {
            f13 = 0.0f;
        }
        if ((i10 & 16) != 0) {
            list = null;
        }
        if ((i10 & 32) != 0) {
            orientation = GradientDrawable.Orientation.LEFT_RIGHT;
        }
        if ((i10 & 64) != 0) {
            num = null;
        }
        if ((i10 & 128) != 0) {
            num2 = null;
        }
        h(view, f10, f11, f12, f13, list, orientation, num, num2);
    }

    public static final void l(@NotNull View view, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4) {
        kotlin.jvm.internal.s.i(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            if (num != null) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart(num.intValue());
            }
            if (num2 != null) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = num2.intValue();
            }
            if (num3 != null) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(num3.intValue());
            }
            if (num4 != null) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = num4.intValue();
            }
            view.setLayoutParams(layoutParams);
        }
    }

    public static /* synthetic */ void m(View view, Integer num, Integer num2, Integer num3, Integer num4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = null;
        }
        if ((i10 & 2) != 0) {
            num2 = null;
        }
        if ((i10 & 4) != 0) {
            num3 = null;
        }
        if ((i10 & 8) != 0) {
            num4 = null;
        }
        l(view, num, num2, num3, num4);
    }

    public static final void n(@NotNull View view, @Nullable Integer num, @Nullable Integer num2) {
        kotlin.jvm.internal.s.i(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (num != null) {
            layoutParams.width = num.intValue();
        }
        if (num2 != null) {
            layoutParams.height = num2.intValue();
        }
        view.setLayoutParams(layoutParams);
    }

    public static /* synthetic */ void o(View view, Integer num, Integer num2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = null;
        }
        if ((i10 & 2) != 0) {
            num2 = null;
        }
        n(view, num, num2);
    }
}
