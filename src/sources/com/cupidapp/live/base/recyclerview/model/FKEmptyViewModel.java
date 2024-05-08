package com.cupidapp.live.base.recyclerview.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKEmptyViewModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKEmptyViewModel {

    @Nullable
    private final Integer bgColor;
    private final boolean bold;

    @Nullable
    private final Integer emptyBtnTextRes;

    @Nullable
    private final Integer emptyImage;

    @Nullable
    private final String emptyText;

    @Nullable
    private final Integer emptyTextColor;

    @Nullable
    private final Integer emptyTextRes;

    @Nullable
    private final Float emptyTextSize;

    @Nullable
    private final Integer height;

    @Nullable
    private final KeyWordsSpanViewModel keywordsModel;

    public FKEmptyViewModel() {
        this(null, null, null, null, null, null, null, false, null, null, 1023, null);
    }

    public FKEmptyViewModel(@Nullable Integer num, @Nullable Integer num2, @Nullable String str, @Nullable Integer num3, @Nullable KeyWordsSpanViewModel keyWordsSpanViewModel, @Nullable Integer num4, @Nullable Float f10, boolean z10, @Nullable Integer num5, @Nullable Integer num6) {
        this.emptyImage = num;
        this.emptyTextRes = num2;
        this.emptyText = str;
        this.emptyTextColor = num3;
        this.keywordsModel = keyWordsSpanViewModel;
        this.height = num4;
        this.emptyTextSize = f10;
        this.bold = z10;
        this.emptyBtnTextRes = num5;
        this.bgColor = num6;
    }

    @Nullable
    public final Integer component1() {
        return this.emptyImage;
    }

    @Nullable
    public final Integer component10() {
        return this.bgColor;
    }

    @Nullable
    public final Integer component2() {
        return this.emptyTextRes;
    }

    @Nullable
    public final String component3() {
        return this.emptyText;
    }

    @Nullable
    public final Integer component4() {
        return this.emptyTextColor;
    }

    @Nullable
    public final KeyWordsSpanViewModel component5() {
        return this.keywordsModel;
    }

    @Nullable
    public final Integer component6() {
        return this.height;
    }

    @Nullable
    public final Float component7() {
        return this.emptyTextSize;
    }

    public final boolean component8() {
        return this.bold;
    }

    @Nullable
    public final Integer component9() {
        return this.emptyBtnTextRes;
    }

    @NotNull
    public final FKEmptyViewModel copy(@Nullable Integer num, @Nullable Integer num2, @Nullable String str, @Nullable Integer num3, @Nullable KeyWordsSpanViewModel keyWordsSpanViewModel, @Nullable Integer num4, @Nullable Float f10, boolean z10, @Nullable Integer num5, @Nullable Integer num6) {
        return new FKEmptyViewModel(num, num2, str, num3, keyWordsSpanViewModel, num4, f10, z10, num5, num6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKEmptyViewModel)) {
            return false;
        }
        FKEmptyViewModel fKEmptyViewModel = (FKEmptyViewModel) obj;
        return s.d(this.emptyImage, fKEmptyViewModel.emptyImage) && s.d(this.emptyTextRes, fKEmptyViewModel.emptyTextRes) && s.d(this.emptyText, fKEmptyViewModel.emptyText) && s.d(this.emptyTextColor, fKEmptyViewModel.emptyTextColor) && s.d(this.keywordsModel, fKEmptyViewModel.keywordsModel) && s.d(this.height, fKEmptyViewModel.height) && s.d(this.emptyTextSize, fKEmptyViewModel.emptyTextSize) && this.bold == fKEmptyViewModel.bold && s.d(this.emptyBtnTextRes, fKEmptyViewModel.emptyBtnTextRes) && s.d(this.bgColor, fKEmptyViewModel.bgColor);
    }

    @Nullable
    public final Integer getBgColor() {
        return this.bgColor;
    }

    public final boolean getBold() {
        return this.bold;
    }

    @Nullable
    public final Integer getEmptyBtnTextRes() {
        return this.emptyBtnTextRes;
    }

    @Nullable
    public final Integer getEmptyImage() {
        return this.emptyImage;
    }

    @Nullable
    public final String getEmptyText() {
        return this.emptyText;
    }

    @Nullable
    public final Integer getEmptyTextColor() {
        return this.emptyTextColor;
    }

    @Nullable
    public final Integer getEmptyTextRes() {
        return this.emptyTextRes;
    }

    @Nullable
    public final Float getEmptyTextSize() {
        return this.emptyTextSize;
    }

    @Nullable
    public final Integer getHeight() {
        return this.height;
    }

    @Nullable
    public final KeyWordsSpanViewModel getKeywordsModel() {
        return this.keywordsModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Integer num = this.emptyImage;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.emptyTextRes;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.emptyText;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num3 = this.emptyTextColor;
        int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        KeyWordsSpanViewModel keyWordsSpanViewModel = this.keywordsModel;
        int hashCode5 = (hashCode4 + (keyWordsSpanViewModel == null ? 0 : keyWordsSpanViewModel.hashCode())) * 31;
        Integer num4 = this.height;
        int hashCode6 = (hashCode5 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Float f10 = this.emptyTextSize;
        int hashCode7 = (hashCode6 + (f10 == null ? 0 : f10.hashCode())) * 31;
        boolean z10 = this.bold;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode7 + i10) * 31;
        Integer num5 = this.emptyBtnTextRes;
        int hashCode8 = (i11 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.bgColor;
        return hashCode8 + (num6 != null ? num6.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        Integer num = this.emptyImage;
        Integer num2 = this.emptyTextRes;
        String str = this.emptyText;
        Integer num3 = this.emptyTextColor;
        KeyWordsSpanViewModel keyWordsSpanViewModel = this.keywordsModel;
        Integer num4 = this.height;
        Float f10 = this.emptyTextSize;
        return "FKEmptyViewModel(emptyImage=" + ((Object) num) + ", emptyTextRes=" + ((Object) num2) + ", emptyText=" + str + ", emptyTextColor=" + ((Object) num3) + ", keywordsModel=" + ((Object) keyWordsSpanViewModel) + ", height=" + ((Object) num4) + ", emptyTextSize=" + ((Object) f10) + ", bold=" + this.bold + ", emptyBtnTextRes=" + ((Object) this.emptyBtnTextRes) + ", bgColor=" + ((Object) this.bgColor) + ")";
    }

    public /* synthetic */ FKEmptyViewModel(Integer num, Integer num2, String str, Integer num3, KeyWordsSpanViewModel keyWordsSpanViewModel, Integer num4, Float f10, boolean z10, Integer num5, Integer num6, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : num2, (i10 & 4) != 0 ? null : str, (i10 & 8) != 0 ? null : num3, (i10 & 16) != 0 ? null : keyWordsSpanViewModel, (i10 & 32) != 0 ? null : num4, (i10 & 64) != 0 ? null : f10, (i10 & 128) != 0 ? false : z10, (i10 & 256) != 0 ? null : num5, (i10 & 512) == 0 ? num6 : null);
    }
}
