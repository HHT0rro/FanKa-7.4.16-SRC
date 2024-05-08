package com.cupidapp.live.base.view;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKRecyclerTitleLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class TitleIndicatorModel {
    private final float height;
    private final int indicatorColor;
    private final float width;

    public TitleIndicatorModel() {
        this(0, 0.0f, 0.0f, 7, null);
    }

    public TitleIndicatorModel(int i10, float f10, float f11) {
        this.indicatorColor = i10;
        this.width = f10;
        this.height = f11;
    }

    public static /* synthetic */ TitleIndicatorModel copy$default(TitleIndicatorModel titleIndicatorModel, int i10, float f10, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = titleIndicatorModel.indicatorColor;
        }
        if ((i11 & 2) != 0) {
            f10 = titleIndicatorModel.width;
        }
        if ((i11 & 4) != 0) {
            f11 = titleIndicatorModel.height;
        }
        return titleIndicatorModel.copy(i10, f10, f11);
    }

    public final int component1() {
        return this.indicatorColor;
    }

    public final float component2() {
        return this.width;
    }

    public final float component3() {
        return this.height;
    }

    @NotNull
    public final TitleIndicatorModel copy(int i10, float f10, float f11) {
        return new TitleIndicatorModel(i10, f10, f11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TitleIndicatorModel)) {
            return false;
        }
        TitleIndicatorModel titleIndicatorModel = (TitleIndicatorModel) obj;
        return this.indicatorColor == titleIndicatorModel.indicatorColor && Float.compare(this.width, titleIndicatorModel.width) == 0 && Float.compare(this.height, titleIndicatorModel.height) == 0;
    }

    public final float getHeight() {
        return this.height;
    }

    public final int getIndicatorColor() {
        return this.indicatorColor;
    }

    public final float getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((this.indicatorColor * 31) + Float.floatToIntBits(this.width)) * 31) + Float.floatToIntBits(this.height);
    }

    @NotNull
    public String toString() {
        return "TitleIndicatorModel(indicatorColor=" + this.indicatorColor + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public /* synthetic */ TitleIndicatorModel(int i10, float f10, float f11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? -1 : i10, (i11 & 2) != 0 ? 10.0f : f10, (i11 & 4) != 0 ? 4.0f : f11);
    }
}
