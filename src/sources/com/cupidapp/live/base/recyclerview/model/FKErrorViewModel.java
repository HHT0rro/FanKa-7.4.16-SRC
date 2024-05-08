package com.cupidapp.live.base.recyclerview.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKEmptyViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKErrorViewModel {

    @Nullable
    private final Integer errorImage;

    @Nullable
    private final String errorText;

    @Nullable
    private final Integer errorTextColor;

    @Nullable
    private final Integer errorTextRes;

    @Nullable
    private final KeyWordsSpanViewModel keywordsModel;

    public FKErrorViewModel() {
        this(null, null, null, null, null, 31, null);
    }

    public FKErrorViewModel(@Nullable Integer num, @Nullable Integer num2, @Nullable String str, @Nullable Integer num3, @Nullable KeyWordsSpanViewModel keyWordsSpanViewModel) {
        this.errorImage = num;
        this.errorTextRes = num2;
        this.errorText = str;
        this.errorTextColor = num3;
        this.keywordsModel = keyWordsSpanViewModel;
    }

    public static /* synthetic */ FKErrorViewModel copy$default(FKErrorViewModel fKErrorViewModel, Integer num, Integer num2, String str, Integer num3, KeyWordsSpanViewModel keyWordsSpanViewModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = fKErrorViewModel.errorImage;
        }
        if ((i10 & 2) != 0) {
            num2 = fKErrorViewModel.errorTextRes;
        }
        Integer num4 = num2;
        if ((i10 & 4) != 0) {
            str = fKErrorViewModel.errorText;
        }
        String str2 = str;
        if ((i10 & 8) != 0) {
            num3 = fKErrorViewModel.errorTextColor;
        }
        Integer num5 = num3;
        if ((i10 & 16) != 0) {
            keyWordsSpanViewModel = fKErrorViewModel.keywordsModel;
        }
        return fKErrorViewModel.copy(num, num4, str2, num5, keyWordsSpanViewModel);
    }

    @Nullable
    public final Integer component1() {
        return this.errorImage;
    }

    @Nullable
    public final Integer component2() {
        return this.errorTextRes;
    }

    @Nullable
    public final String component3() {
        return this.errorText;
    }

    @Nullable
    public final Integer component4() {
        return this.errorTextColor;
    }

    @Nullable
    public final KeyWordsSpanViewModel component5() {
        return this.keywordsModel;
    }

    @NotNull
    public final FKErrorViewModel copy(@Nullable Integer num, @Nullable Integer num2, @Nullable String str, @Nullable Integer num3, @Nullable KeyWordsSpanViewModel keyWordsSpanViewModel) {
        return new FKErrorViewModel(num, num2, str, num3, keyWordsSpanViewModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKErrorViewModel)) {
            return false;
        }
        FKErrorViewModel fKErrorViewModel = (FKErrorViewModel) obj;
        return s.d(this.errorImage, fKErrorViewModel.errorImage) && s.d(this.errorTextRes, fKErrorViewModel.errorTextRes) && s.d(this.errorText, fKErrorViewModel.errorText) && s.d(this.errorTextColor, fKErrorViewModel.errorTextColor) && s.d(this.keywordsModel, fKErrorViewModel.keywordsModel);
    }

    @Nullable
    public final Integer getErrorImage() {
        return this.errorImage;
    }

    @Nullable
    public final String getErrorText() {
        return this.errorText;
    }

    @Nullable
    public final Integer getErrorTextColor() {
        return this.errorTextColor;
    }

    @Nullable
    public final Integer getErrorTextRes() {
        return this.errorTextRes;
    }

    @Nullable
    public final KeyWordsSpanViewModel getKeywordsModel() {
        return this.keywordsModel;
    }

    public int hashCode() {
        Integer num = this.errorImage;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.errorTextRes;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.errorText;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num3 = this.errorTextColor;
        int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        KeyWordsSpanViewModel keyWordsSpanViewModel = this.keywordsModel;
        return hashCode4 + (keyWordsSpanViewModel != null ? keyWordsSpanViewModel.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        Integer num = this.errorImage;
        Integer num2 = this.errorTextRes;
        return "FKErrorViewModel(errorImage=" + ((Object) num) + ", errorTextRes=" + ((Object) num2) + ", errorText=" + this.errorText + ", errorTextColor=" + ((Object) this.errorTextColor) + ", keywordsModel=" + ((Object) this.keywordsModel) + ")";
    }

    public /* synthetic */ FKErrorViewModel(Integer num, Integer num2, String str, Integer num3, KeyWordsSpanViewModel keyWordsSpanViewModel, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : num2, (i10 & 4) != 0 ? null : str, (i10 & 8) != 0 ? null : num3, (i10 & 16) != 0 ? null : keyWordsSpanViewModel);
    }
}
