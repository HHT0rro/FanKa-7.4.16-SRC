package com.cupidapp.live.filter.view;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FilterRangeBarLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FilterBarUiModel {
    private final int barColor;

    @Nullable
    private final Integer bgDrawable;

    @NotNull
    private final List<Float> padding;
    private final int selectContentDefaultColor;
    private final int selectContentSelectColor;
    private final int selectContentSize;
    private final int titleTextColor;
    private final int titleTextSize;

    @NotNull
    private final TextStyle titleTextStyle;

    public FilterBarUiModel() {
        this(null, 0, null, 0, 0, 0, 0, 0, null, 511, null);
    }

    public FilterBarUiModel(@DrawableRes @Nullable Integer num, int i10, @NotNull TextStyle titleTextStyle, @ColorInt int i11, @ColorInt int i12, @ColorInt int i13, int i14, @ColorInt int i15, @NotNull List<Float> padding) {
        s.i(titleTextStyle, "titleTextStyle");
        s.i(padding, "padding");
        this.bgDrawable = num;
        this.titleTextSize = i10;
        this.titleTextStyle = titleTextStyle;
        this.titleTextColor = i11;
        this.selectContentDefaultColor = i12;
        this.selectContentSelectColor = i13;
        this.selectContentSize = i14;
        this.barColor = i15;
        this.padding = padding;
    }

    @Nullable
    public final Integer component1() {
        return this.bgDrawable;
    }

    public final int component2() {
        return this.titleTextSize;
    }

    @NotNull
    public final TextStyle component3() {
        return this.titleTextStyle;
    }

    public final int component4() {
        return this.titleTextColor;
    }

    public final int component5() {
        return this.selectContentDefaultColor;
    }

    public final int component6() {
        return this.selectContentSelectColor;
    }

    public final int component7() {
        return this.selectContentSize;
    }

    public final int component8() {
        return this.barColor;
    }

    @NotNull
    public final List<Float> component9() {
        return this.padding;
    }

    @NotNull
    public final FilterBarUiModel copy(@DrawableRes @Nullable Integer num, int i10, @NotNull TextStyle titleTextStyle, @ColorInt int i11, @ColorInt int i12, @ColorInt int i13, int i14, @ColorInt int i15, @NotNull List<Float> padding) {
        s.i(titleTextStyle, "titleTextStyle");
        s.i(padding, "padding");
        return new FilterBarUiModel(num, i10, titleTextStyle, i11, i12, i13, i14, i15, padding);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterBarUiModel)) {
            return false;
        }
        FilterBarUiModel filterBarUiModel = (FilterBarUiModel) obj;
        return s.d(this.bgDrawable, filterBarUiModel.bgDrawable) && this.titleTextSize == filterBarUiModel.titleTextSize && this.titleTextStyle == filterBarUiModel.titleTextStyle && this.titleTextColor == filterBarUiModel.titleTextColor && this.selectContentDefaultColor == filterBarUiModel.selectContentDefaultColor && this.selectContentSelectColor == filterBarUiModel.selectContentSelectColor && this.selectContentSize == filterBarUiModel.selectContentSize && this.barColor == filterBarUiModel.barColor && s.d(this.padding, filterBarUiModel.padding);
    }

    public final int getBarColor() {
        return this.barColor;
    }

    @Nullable
    public final Integer getBgDrawable() {
        return this.bgDrawable;
    }

    @NotNull
    public final List<Float> getPadding() {
        return this.padding;
    }

    public final int getSelectContentDefaultColor() {
        return this.selectContentDefaultColor;
    }

    public final int getSelectContentSelectColor() {
        return this.selectContentSelectColor;
    }

    public final int getSelectContentSize() {
        return this.selectContentSize;
    }

    public final int getTitleTextColor() {
        return this.titleTextColor;
    }

    public final int getTitleTextSize() {
        return this.titleTextSize;
    }

    @NotNull
    public final TextStyle getTitleTextStyle() {
        return this.titleTextStyle;
    }

    public int hashCode() {
        Integer num = this.bgDrawable;
        return ((((((((((((((((num == null ? 0 : num.hashCode()) * 31) + this.titleTextSize) * 31) + this.titleTextStyle.hashCode()) * 31) + this.titleTextColor) * 31) + this.selectContentDefaultColor) * 31) + this.selectContentSelectColor) * 31) + this.selectContentSize) * 31) + this.barColor) * 31) + this.padding.hashCode();
    }

    @NotNull
    public String toString() {
        Integer num = this.bgDrawable;
        int i10 = this.titleTextSize;
        TextStyle textStyle = this.titleTextStyle;
        return "FilterBarUiModel(bgDrawable=" + ((Object) num) + ", titleTextSize=" + i10 + ", titleTextStyle=" + ((Object) textStyle) + ", titleTextColor=" + this.titleTextColor + ", selectContentDefaultColor=" + this.selectContentDefaultColor + ", selectContentSelectColor=" + this.selectContentSelectColor + ", selectContentSize=" + this.selectContentSize + ", barColor=" + this.barColor + ", padding=" + ((Object) this.padding) + ")";
    }

    public /* synthetic */ FilterBarUiModel(Integer num, int i10, TextStyle textStyle, int i11, int i12, int i13, int i14, int i15, List list, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? null : num, (i16 & 2) != 0 ? 10 : i10, (i16 & 4) != 0 ? TextStyle.BOLD : textStyle, (i16 & 8) != 0 ? -15066598 : i11, (i16 & 16) != 0 ? -5658199 : i12, (i16 & 32) != 0 ? -49088 : i13, (i16 & 64) == 0 ? i14 : 10, (i16 & 128) == 0 ? i15 : -49088, (i16 & 256) != 0 ? kotlin.collections.s.m(Float.valueOf(4.0f), Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(0.0f)) : list);
    }
}
