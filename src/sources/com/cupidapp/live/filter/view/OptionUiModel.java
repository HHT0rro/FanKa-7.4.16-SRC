package com.cupidapp.live.filter.view;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import com.cupidapp.live.R$drawable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FilterOptionLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class OptionUiModel {
    private final int bgDrawable;
    private final int itemBgDrawable;
    private final int itemDefaultTextColor;
    private final int itemSelectedColor;
    private final int titleTextColor;

    public OptionUiModel() {
        this(0, 0, 0, 0, 0, 31, null);
    }

    public OptionUiModel(@ColorInt int i10, @ColorInt int i11, @ColorInt int i12, @DrawableRes int i13, @DrawableRes int i14) {
        this.titleTextColor = i10;
        this.itemDefaultTextColor = i11;
        this.itemSelectedColor = i12;
        this.itemBgDrawable = i13;
        this.bgDrawable = i14;
    }

    public static /* synthetic */ OptionUiModel copy$default(OptionUiModel optionUiModel, int i10, int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i10 = optionUiModel.titleTextColor;
        }
        if ((i15 & 2) != 0) {
            i11 = optionUiModel.itemDefaultTextColor;
        }
        int i16 = i11;
        if ((i15 & 4) != 0) {
            i12 = optionUiModel.itemSelectedColor;
        }
        int i17 = i12;
        if ((i15 & 8) != 0) {
            i13 = optionUiModel.itemBgDrawable;
        }
        int i18 = i13;
        if ((i15 & 16) != 0) {
            i14 = optionUiModel.bgDrawable;
        }
        return optionUiModel.copy(i10, i16, i17, i18, i14);
    }

    public final int component1() {
        return this.titleTextColor;
    }

    public final int component2() {
        return this.itemDefaultTextColor;
    }

    public final int component3() {
        return this.itemSelectedColor;
    }

    public final int component4() {
        return this.itemBgDrawable;
    }

    public final int component5() {
        return this.bgDrawable;
    }

    @NotNull
    public final OptionUiModel copy(@ColorInt int i10, @ColorInt int i11, @ColorInt int i12, @DrawableRes int i13, @DrawableRes int i14) {
        return new OptionUiModel(i10, i11, i12, i13, i14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OptionUiModel)) {
            return false;
        }
        OptionUiModel optionUiModel = (OptionUiModel) obj;
        return this.titleTextColor == optionUiModel.titleTextColor && this.itemDefaultTextColor == optionUiModel.itemDefaultTextColor && this.itemSelectedColor == optionUiModel.itemSelectedColor && this.itemBgDrawable == optionUiModel.itemBgDrawable && this.bgDrawable == optionUiModel.bgDrawable;
    }

    public final int getBgDrawable() {
        return this.bgDrawable;
    }

    public final int getItemBgDrawable() {
        return this.itemBgDrawable;
    }

    public final int getItemDefaultTextColor() {
        return this.itemDefaultTextColor;
    }

    public final int getItemSelectedColor() {
        return this.itemSelectedColor;
    }

    public final int getTitleTextColor() {
        return this.titleTextColor;
    }

    public int hashCode() {
        return (((((((this.titleTextColor * 31) + this.itemDefaultTextColor) * 31) + this.itemSelectedColor) * 31) + this.itemBgDrawable) * 31) + this.bgDrawable;
    }

    @NotNull
    public String toString() {
        return "OptionUiModel(titleTextColor=" + this.titleTextColor + ", itemDefaultTextColor=" + this.itemDefaultTextColor + ", itemSelectedColor=" + this.itemSelectedColor + ", itemBgDrawable=" + this.itemBgDrawable + ", bgDrawable=" + this.bgDrawable + ")";
    }

    public /* synthetic */ OptionUiModel(int i10, int i11, int i12, int i13, int i14, int i15, DefaultConstructorMarker defaultConstructorMarker) {
        this((i15 & 1) != 0 ? -15066598 : i10, (i15 & 2) != 0 ? -8618884 : i11, (i15 & 4) != 0 ? -49088 : i12, (i15 & 8) != 0 ? R$drawable.mul_select_bg : i13, (i15 & 16) != 0 ? R$drawable.rect_btm_cor_8_sd_ffffff : i14);
    }
}
