package com.cupidapp.live.base.recyclerview.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKFooterWithSpaceModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKFooterWithSpaceModel extends FKFooterViewModel {
    private int bottomSpaceHeight;
    private int height;
    private boolean showProgress;
    private boolean showText;

    @Nullable
    private String text;
    private int textColor;

    public FKFooterWithSpaceModel() {
        this(false, false, null, 0, 0, 0, 63, null);
    }

    public /* synthetic */ FKFooterWithSpaceModel(boolean z10, boolean z11, String str, int i10, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? true : z10, (i13 & 2) != 0 ? false : z11, (i13 & 4) != 0 ? "" : str, (i13 & 8) != 0 ? -15066598 : i10, (i13 & 16) != 0 ? 80 : i11, (i13 & 32) == 0 ? i12 : 0);
    }

    public static /* synthetic */ FKFooterWithSpaceModel copy$default(FKFooterWithSpaceModel fKFooterWithSpaceModel, boolean z10, boolean z11, String str, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            z10 = fKFooterWithSpaceModel.getShowProgress();
        }
        if ((i13 & 2) != 0) {
            z11 = fKFooterWithSpaceModel.getShowText();
        }
        boolean z12 = z11;
        if ((i13 & 4) != 0) {
            str = fKFooterWithSpaceModel.getText();
        }
        String str2 = str;
        if ((i13 & 8) != 0) {
            i10 = fKFooterWithSpaceModel.getTextColor();
        }
        int i14 = i10;
        if ((i13 & 16) != 0) {
            i11 = fKFooterWithSpaceModel.getHeight();
        }
        int i15 = i11;
        if ((i13 & 32) != 0) {
            i12 = fKFooterWithSpaceModel.bottomSpaceHeight;
        }
        return fKFooterWithSpaceModel.copy(z10, z12, str2, i14, i15, i12);
    }

    public final boolean component1() {
        return getShowProgress();
    }

    public final boolean component2() {
        return getShowText();
    }

    @Nullable
    public final String component3() {
        return getText();
    }

    public final int component4() {
        return getTextColor();
    }

    public final int component5() {
        return getHeight();
    }

    public final int component6() {
        return this.bottomSpaceHeight;
    }

    @NotNull
    public final FKFooterWithSpaceModel copy(boolean z10, boolean z11, @Nullable String str, int i10, int i11, int i12) {
        return new FKFooterWithSpaceModel(z10, z11, str, i10, i11, i12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKFooterWithSpaceModel)) {
            return false;
        }
        FKFooterWithSpaceModel fKFooterWithSpaceModel = (FKFooterWithSpaceModel) obj;
        return getShowProgress() == fKFooterWithSpaceModel.getShowProgress() && getShowText() == fKFooterWithSpaceModel.getShowText() && s.d(getText(), fKFooterWithSpaceModel.getText()) && getTextColor() == fKFooterWithSpaceModel.getTextColor() && getHeight() == fKFooterWithSpaceModel.getHeight() && this.bottomSpaceHeight == fKFooterWithSpaceModel.bottomSpaceHeight;
    }

    public final int getBottomSpaceHeight() {
        return this.bottomSpaceHeight;
    }

    @Override // com.cupidapp.live.base.recyclerview.model.FKFooterViewModel
    public int getHeight() {
        return this.height;
    }

    @Override // com.cupidapp.live.base.recyclerview.model.FKFooterViewModel
    public boolean getShowProgress() {
        return this.showProgress;
    }

    @Override // com.cupidapp.live.base.recyclerview.model.FKFooterViewModel
    public boolean getShowText() {
        return this.showText;
    }

    @Override // com.cupidapp.live.base.recyclerview.model.FKFooterViewModel
    @Nullable
    public String getText() {
        return this.text;
    }

    @Override // com.cupidapp.live.base.recyclerview.model.FKFooterViewModel
    public int getTextColor() {
        return this.textColor;
    }

    public int hashCode() {
        boolean showProgress = getShowProgress();
        int i10 = showProgress;
        if (showProgress) {
            i10 = 1;
        }
        int i11 = i10 * 31;
        boolean showText = getShowText();
        return ((((((((i11 + (showText ? 1 : showText)) * 31) + (getText() == null ? 0 : getText().hashCode())) * 31) + getTextColor()) * 31) + getHeight()) * 31) + this.bottomSpaceHeight;
    }

    public final void setBottomSpaceHeight(int i10) {
        this.bottomSpaceHeight = i10;
    }

    @Override // com.cupidapp.live.base.recyclerview.model.FKFooterViewModel
    public void setHeight(int i10) {
        this.height = i10;
    }

    @Override // com.cupidapp.live.base.recyclerview.model.FKFooterViewModel
    public void setShowProgress(boolean z10) {
        this.showProgress = z10;
    }

    @Override // com.cupidapp.live.base.recyclerview.model.FKFooterViewModel
    public void setShowText(boolean z10) {
        this.showText = z10;
    }

    @Override // com.cupidapp.live.base.recyclerview.model.FKFooterViewModel
    public void setText(@Nullable String str) {
        this.text = str;
    }

    @Override // com.cupidapp.live.base.recyclerview.model.FKFooterViewModel
    public void setTextColor(int i10) {
        this.textColor = i10;
    }

    @NotNull
    public String toString() {
        return "FKFooterWithSpaceModel(showProgress=" + getShowProgress() + ", showText=" + getShowText() + ", text=" + getText() + ", textColor=" + getTextColor() + ", height=" + getHeight() + ", bottomSpaceHeight=" + this.bottomSpaceHeight + ")";
    }

    public FKFooterWithSpaceModel(boolean z10, boolean z11, @Nullable String str, int i10, int i11, int i12) {
        super(false, false, null, 0, 0, 0, 63, null);
        this.showProgress = z10;
        this.showText = z11;
        this.text = str;
        this.textColor = i10;
        this.height = i11;
        this.bottomSpaceHeight = i12;
    }
}
