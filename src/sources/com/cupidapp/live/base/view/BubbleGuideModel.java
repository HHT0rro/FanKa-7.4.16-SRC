package com.cupidapp.live.base.view;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKPopupWindowBubbleGuideView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class BubbleGuideModel {

    @Nullable
    private final Integer guideBg;
    private final int guideBgColor;

    @Nullable
    private final String guideText;
    private final int textColor;

    public BubbleGuideModel() {
        this(null, 0, null, 0, 15, null);
    }

    public BubbleGuideModel(@Nullable String str, int i10, @Nullable Integer num, int i11) {
        this.guideText = str;
        this.textColor = i10;
        this.guideBg = num;
        this.guideBgColor = i11;
    }

    public static /* synthetic */ BubbleGuideModel copy$default(BubbleGuideModel bubbleGuideModel, String str, int i10, Integer num, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = bubbleGuideModel.guideText;
        }
        if ((i12 & 2) != 0) {
            i10 = bubbleGuideModel.textColor;
        }
        if ((i12 & 4) != 0) {
            num = bubbleGuideModel.guideBg;
        }
        if ((i12 & 8) != 0) {
            i11 = bubbleGuideModel.guideBgColor;
        }
        return bubbleGuideModel.copy(str, i10, num, i11);
    }

    @Nullable
    public final String component1() {
        return this.guideText;
    }

    public final int component2() {
        return this.textColor;
    }

    @Nullable
    public final Integer component3() {
        return this.guideBg;
    }

    public final int component4() {
        return this.guideBgColor;
    }

    @NotNull
    public final BubbleGuideModel copy(@Nullable String str, int i10, @Nullable Integer num, int i11) {
        return new BubbleGuideModel(str, i10, num, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BubbleGuideModel)) {
            return false;
        }
        BubbleGuideModel bubbleGuideModel = (BubbleGuideModel) obj;
        return kotlin.jvm.internal.s.d(this.guideText, bubbleGuideModel.guideText) && this.textColor == bubbleGuideModel.textColor && kotlin.jvm.internal.s.d(this.guideBg, bubbleGuideModel.guideBg) && this.guideBgColor == bubbleGuideModel.guideBgColor;
    }

    @Nullable
    public final Integer getGuideBg() {
        return this.guideBg;
    }

    public final int getGuideBgColor() {
        return this.guideBgColor;
    }

    @Nullable
    public final String getGuideText() {
        return this.guideText;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public int hashCode() {
        String str = this.guideText;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.textColor) * 31;
        Integer num = this.guideBg;
        return ((hashCode + (num != null ? num.hashCode() : 0)) * 31) + this.guideBgColor;
    }

    @NotNull
    public String toString() {
        String str = this.guideText;
        int i10 = this.textColor;
        Integer num = this.guideBg;
        return "BubbleGuideModel(guideText=" + str + ", textColor=" + i10 + ", guideBg=" + ((Object) num) + ", guideBgColor=" + this.guideBgColor + ")";
    }

    public /* synthetic */ BubbleGuideModel(String str, int i10, Integer num, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? null : str, (i12 & 2) != 0 ? -15066598 : i10, (i12 & 4) != 0 ? null : num, (i12 & 8) != 0 ? -1 : i11);
    }
}
