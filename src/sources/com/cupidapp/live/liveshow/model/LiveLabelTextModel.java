package com.cupidapp.live.liveshow.model;

import androidx.annotation.ColorInt;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LiveLabelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveLabelTextModel {

    @NotNull
    private final String content;
    private final int contentColor;
    private final boolean isBold;

    @Nullable
    private final Integer selectColor;

    @Nullable
    private final String selectText;

    @NotNull
    private final LiveLabelTextSizeType sizeType;

    public LiveLabelTextModel(@NotNull String content, @NotNull LiveLabelTextSizeType sizeType, @ColorInt int i10, @Nullable String str, @ColorInt @Nullable Integer num, boolean z10) {
        s.i(content, "content");
        s.i(sizeType, "sizeType");
        this.content = content;
        this.sizeType = sizeType;
        this.contentColor = i10;
        this.selectText = str;
        this.selectColor = num;
        this.isBold = z10;
    }

    public static /* synthetic */ LiveLabelTextModel copy$default(LiveLabelTextModel liveLabelTextModel, String str, LiveLabelTextSizeType liveLabelTextSizeType, int i10, String str2, Integer num, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = liveLabelTextModel.content;
        }
        if ((i11 & 2) != 0) {
            liveLabelTextSizeType = liveLabelTextModel.sizeType;
        }
        LiveLabelTextSizeType liveLabelTextSizeType2 = liveLabelTextSizeType;
        if ((i11 & 4) != 0) {
            i10 = liveLabelTextModel.contentColor;
        }
        int i12 = i10;
        if ((i11 & 8) != 0) {
            str2 = liveLabelTextModel.selectText;
        }
        String str3 = str2;
        if ((i11 & 16) != 0) {
            num = liveLabelTextModel.selectColor;
        }
        Integer num2 = num;
        if ((i11 & 32) != 0) {
            z10 = liveLabelTextModel.isBold;
        }
        return liveLabelTextModel.copy(str, liveLabelTextSizeType2, i12, str3, num2, z10);
    }

    @NotNull
    public final String component1() {
        return this.content;
    }

    @NotNull
    public final LiveLabelTextSizeType component2() {
        return this.sizeType;
    }

    public final int component3() {
        return this.contentColor;
    }

    @Nullable
    public final String component4() {
        return this.selectText;
    }

    @Nullable
    public final Integer component5() {
        return this.selectColor;
    }

    public final boolean component6() {
        return this.isBold;
    }

    @NotNull
    public final LiveLabelTextModel copy(@NotNull String content, @NotNull LiveLabelTextSizeType sizeType, @ColorInt int i10, @Nullable String str, @ColorInt @Nullable Integer num, boolean z10) {
        s.i(content, "content");
        s.i(sizeType, "sizeType");
        return new LiveLabelTextModel(content, sizeType, i10, str, num, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveLabelTextModel)) {
            return false;
        }
        LiveLabelTextModel liveLabelTextModel = (LiveLabelTextModel) obj;
        return s.d(this.content, liveLabelTextModel.content) && this.sizeType == liveLabelTextModel.sizeType && this.contentColor == liveLabelTextModel.contentColor && s.d(this.selectText, liveLabelTextModel.selectText) && s.d(this.selectColor, liveLabelTextModel.selectColor) && this.isBold == liveLabelTextModel.isBold;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public final int getContentColor() {
        return this.contentColor;
    }

    @Nullable
    public final Integer getSelectColor() {
        return this.selectColor;
    }

    @Nullable
    public final String getSelectText() {
        return this.selectText;
    }

    @NotNull
    public final LiveLabelTextSizeType getSizeType() {
        return this.sizeType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.content.hashCode() * 31) + this.sizeType.hashCode()) * 31) + this.contentColor) * 31;
        String str = this.selectText;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.selectColor;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        boolean z10 = this.isBold;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode3 + i10;
    }

    public final boolean isBold() {
        return this.isBold;
    }

    @NotNull
    public String toString() {
        String str = this.content;
        LiveLabelTextSizeType liveLabelTextSizeType = this.sizeType;
        int i10 = this.contentColor;
        String str2 = this.selectText;
        Integer num = this.selectColor;
        return "LiveLabelTextModel(content=" + str + ", sizeType=" + ((Object) liveLabelTextSizeType) + ", contentColor=" + i10 + ", selectText=" + str2 + ", selectColor=" + ((Object) num) + ", isBold=" + this.isBold + ")";
    }

    public /* synthetic */ LiveLabelTextModel(String str, LiveLabelTextSizeType liveLabelTextSizeType, int i10, String str2, Integer num, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? LiveLabelTextSizeType.Eleven : liveLabelTextSizeType, (i11 & 4) != 0 ? -1 : i10, (i11 & 8) != 0 ? null : str2, (i11 & 16) != 0 ? null : num, (i11 & 32) != 0 ? false : z10);
    }
}
