package com.cupidapp.live.base.view;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKRecyclerTitleLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class TitleConfigModel {
    private final boolean textBold;
    private final int textColor;
    private final float textSize;

    public TitleConfigModel(float f10, int i10, boolean z10) {
        this.textSize = f10;
        this.textColor = i10;
        this.textBold = z10;
    }

    public static /* synthetic */ TitleConfigModel copy$default(TitleConfigModel titleConfigModel, float f10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f10 = titleConfigModel.textSize;
        }
        if ((i11 & 2) != 0) {
            i10 = titleConfigModel.textColor;
        }
        if ((i11 & 4) != 0) {
            z10 = titleConfigModel.textBold;
        }
        return titleConfigModel.copy(f10, i10, z10);
    }

    public final float component1() {
        return this.textSize;
    }

    public final int component2() {
        return this.textColor;
    }

    public final boolean component3() {
        return this.textBold;
    }

    @NotNull
    public final TitleConfigModel copy(float f10, int i10, boolean z10) {
        return new TitleConfigModel(f10, i10, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TitleConfigModel)) {
            return false;
        }
        TitleConfigModel titleConfigModel = (TitleConfigModel) obj;
        return Float.compare(this.textSize, titleConfigModel.textSize) == 0 && this.textColor == titleConfigModel.textColor && this.textBold == titleConfigModel.textBold;
    }

    public final boolean getTextBold() {
        return this.textBold;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final float getTextSize() {
        return this.textSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int floatToIntBits = ((Float.floatToIntBits(this.textSize) * 31) + this.textColor) * 31;
        boolean z10 = this.textBold;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return floatToIntBits + i10;
    }

    @NotNull
    public String toString() {
        return "TitleConfigModel(textSize=" + this.textSize + ", textColor=" + this.textColor + ", textBold=" + this.textBold + ")";
    }
}
