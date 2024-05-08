package com.cupidapp.live.base.view;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKRecyclerTitleLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKTitleViewModel {

    @Nullable
    private final TitleIndicatorModel indicator;
    private boolean isSelected;

    @NotNull
    private final TitleConfigModel selectedTitle;

    @NotNull
    private final String text;

    @NotNull
    private final TitleConfigModel unSelectedTitle;

    public FKTitleViewModel(@NotNull String text, @NotNull TitleConfigModel selectedTitle, @NotNull TitleConfigModel unSelectedTitle, @Nullable TitleIndicatorModel titleIndicatorModel, boolean z10) {
        kotlin.jvm.internal.s.i(text, "text");
        kotlin.jvm.internal.s.i(selectedTitle, "selectedTitle");
        kotlin.jvm.internal.s.i(unSelectedTitle, "unSelectedTitle");
        this.text = text;
        this.selectedTitle = selectedTitle;
        this.unSelectedTitle = unSelectedTitle;
        this.indicator = titleIndicatorModel;
        this.isSelected = z10;
    }

    public static /* synthetic */ FKTitleViewModel copy$default(FKTitleViewModel fKTitleViewModel, String str, TitleConfigModel titleConfigModel, TitleConfigModel titleConfigModel2, TitleIndicatorModel titleIndicatorModel, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = fKTitleViewModel.text;
        }
        if ((i10 & 2) != 0) {
            titleConfigModel = fKTitleViewModel.selectedTitle;
        }
        TitleConfigModel titleConfigModel3 = titleConfigModel;
        if ((i10 & 4) != 0) {
            titleConfigModel2 = fKTitleViewModel.unSelectedTitle;
        }
        TitleConfigModel titleConfigModel4 = titleConfigModel2;
        if ((i10 & 8) != 0) {
            titleIndicatorModel = fKTitleViewModel.indicator;
        }
        TitleIndicatorModel titleIndicatorModel2 = titleIndicatorModel;
        if ((i10 & 16) != 0) {
            z10 = fKTitleViewModel.isSelected;
        }
        return fKTitleViewModel.copy(str, titleConfigModel3, titleConfigModel4, titleIndicatorModel2, z10);
    }

    @NotNull
    public final String component1() {
        return this.text;
    }

    @NotNull
    public final TitleConfigModel component2() {
        return this.selectedTitle;
    }

    @NotNull
    public final TitleConfigModel component3() {
        return this.unSelectedTitle;
    }

    @Nullable
    public final TitleIndicatorModel component4() {
        return this.indicator;
    }

    public final boolean component5() {
        return this.isSelected;
    }

    @NotNull
    public final FKTitleViewModel copy(@NotNull String text, @NotNull TitleConfigModel selectedTitle, @NotNull TitleConfigModel unSelectedTitle, @Nullable TitleIndicatorModel titleIndicatorModel, boolean z10) {
        kotlin.jvm.internal.s.i(text, "text");
        kotlin.jvm.internal.s.i(selectedTitle, "selectedTitle");
        kotlin.jvm.internal.s.i(unSelectedTitle, "unSelectedTitle");
        return new FKTitleViewModel(text, selectedTitle, unSelectedTitle, titleIndicatorModel, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKTitleViewModel)) {
            return false;
        }
        FKTitleViewModel fKTitleViewModel = (FKTitleViewModel) obj;
        return kotlin.jvm.internal.s.d(this.text, fKTitleViewModel.text) && kotlin.jvm.internal.s.d(this.selectedTitle, fKTitleViewModel.selectedTitle) && kotlin.jvm.internal.s.d(this.unSelectedTitle, fKTitleViewModel.unSelectedTitle) && kotlin.jvm.internal.s.d(this.indicator, fKTitleViewModel.indicator) && this.isSelected == fKTitleViewModel.isSelected;
    }

    @Nullable
    public final TitleIndicatorModel getIndicator() {
        return this.indicator;
    }

    @NotNull
    public final TitleConfigModel getSelectedTitle() {
        return this.selectedTitle;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @NotNull
    public final TitleConfigModel getUnSelectedTitle() {
        return this.unSelectedTitle;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.text.hashCode() * 31) + this.selectedTitle.hashCode()) * 31) + this.unSelectedTitle.hashCode()) * 31;
        TitleIndicatorModel titleIndicatorModel = this.indicator;
        int hashCode2 = (hashCode + (titleIndicatorModel == null ? 0 : titleIndicatorModel.hashCode())) * 31;
        boolean z10 = this.isSelected;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode2 + i10;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z10) {
        this.isSelected = z10;
    }

    @NotNull
    public String toString() {
        String str = this.text;
        TitleConfigModel titleConfigModel = this.selectedTitle;
        TitleConfigModel titleConfigModel2 = this.unSelectedTitle;
        TitleIndicatorModel titleIndicatorModel = this.indicator;
        return "FKTitleViewModel(text=" + str + ", selectedTitle=" + ((Object) titleConfigModel) + ", unSelectedTitle=" + ((Object) titleConfigModel2) + ", indicator=" + ((Object) titleIndicatorModel) + ", isSelected=" + this.isSelected + ")";
    }

    public /* synthetic */ FKTitleViewModel(String str, TitleConfigModel titleConfigModel, TitleConfigModel titleConfigModel2, TitleIndicatorModel titleIndicatorModel, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, titleConfigModel, titleConfigModel2, (i10 & 8) != 0 ? null : titleIndicatorModel, (i10 & 16) != 0 ? false : z10);
    }
}
