package com.cupidapp.live.base.view;

import com.cupidapp.live.R$drawable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKSnackbarView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SnackbarModel {

    @Nullable
    private final Integer actionHeight;

    @Nullable
    private final String actionTxt;

    @Nullable
    private final Integer actionTxtBgRes;
    private final int actionTxtColor;
    private final float actionTxtSize;

    @Nullable
    private final Integer actionWidth;
    private final int bgRes;

    @Nullable
    private final Function0<kotlin.p> click;

    @Nullable
    private final Integer leftDrawableRes;

    @NotNull
    private final String snackbarText;
    private final float snackbarTextSize;
    private final int timeLength;

    public SnackbarModel(@NotNull String snackbarText, float f10, @Nullable String str, int i10, @Nullable Integer num, float f11, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, int i11, int i12, @Nullable Function0<kotlin.p> function0) {
        kotlin.jvm.internal.s.i(snackbarText, "snackbarText");
        this.snackbarText = snackbarText;
        this.snackbarTextSize = f10;
        this.actionTxt = str;
        this.actionTxtColor = i10;
        this.actionTxtBgRes = num;
        this.actionTxtSize = f11;
        this.actionWidth = num2;
        this.actionHeight = num3;
        this.leftDrawableRes = num4;
        this.bgRes = i11;
        this.timeLength = i12;
        this.click = function0;
    }

    @NotNull
    public final String component1() {
        return this.snackbarText;
    }

    public final int component10() {
        return this.bgRes;
    }

    public final int component11() {
        return this.timeLength;
    }

    @Nullable
    public final Function0<kotlin.p> component12() {
        return this.click;
    }

    public final float component2() {
        return this.snackbarTextSize;
    }

    @Nullable
    public final String component3() {
        return this.actionTxt;
    }

    public final int component4() {
        return this.actionTxtColor;
    }

    @Nullable
    public final Integer component5() {
        return this.actionTxtBgRes;
    }

    public final float component6() {
        return this.actionTxtSize;
    }

    @Nullable
    public final Integer component7() {
        return this.actionWidth;
    }

    @Nullable
    public final Integer component8() {
        return this.actionHeight;
    }

    @Nullable
    public final Integer component9() {
        return this.leftDrawableRes;
    }

    @NotNull
    public final SnackbarModel copy(@NotNull String snackbarText, float f10, @Nullable String str, int i10, @Nullable Integer num, float f11, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, int i11, int i12, @Nullable Function0<kotlin.p> function0) {
        kotlin.jvm.internal.s.i(snackbarText, "snackbarText");
        return new SnackbarModel(snackbarText, f10, str, i10, num, f11, num2, num3, num4, i11, i12, function0);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SnackbarModel)) {
            return false;
        }
        SnackbarModel snackbarModel = (SnackbarModel) obj;
        return kotlin.jvm.internal.s.d(this.snackbarText, snackbarModel.snackbarText) && Float.compare(this.snackbarTextSize, snackbarModel.snackbarTextSize) == 0 && kotlin.jvm.internal.s.d(this.actionTxt, snackbarModel.actionTxt) && this.actionTxtColor == snackbarModel.actionTxtColor && kotlin.jvm.internal.s.d(this.actionTxtBgRes, snackbarModel.actionTxtBgRes) && Float.compare(this.actionTxtSize, snackbarModel.actionTxtSize) == 0 && kotlin.jvm.internal.s.d(this.actionWidth, snackbarModel.actionWidth) && kotlin.jvm.internal.s.d(this.actionHeight, snackbarModel.actionHeight) && kotlin.jvm.internal.s.d(this.leftDrawableRes, snackbarModel.leftDrawableRes) && this.bgRes == snackbarModel.bgRes && this.timeLength == snackbarModel.timeLength && kotlin.jvm.internal.s.d(this.click, snackbarModel.click);
    }

    @Nullable
    public final Integer getActionHeight() {
        return this.actionHeight;
    }

    @Nullable
    public final String getActionTxt() {
        return this.actionTxt;
    }

    @Nullable
    public final Integer getActionTxtBgRes() {
        return this.actionTxtBgRes;
    }

    public final int getActionTxtColor() {
        return this.actionTxtColor;
    }

    public final float getActionTxtSize() {
        return this.actionTxtSize;
    }

    @Nullable
    public final Integer getActionWidth() {
        return this.actionWidth;
    }

    public final int getBgRes() {
        return this.bgRes;
    }

    @Nullable
    public final Function0<kotlin.p> getClick() {
        return this.click;
    }

    @Nullable
    public final Integer getLeftDrawableRes() {
        return this.leftDrawableRes;
    }

    @NotNull
    public final String getSnackbarText() {
        return this.snackbarText;
    }

    public final float getSnackbarTextSize() {
        return this.snackbarTextSize;
    }

    public final int getTimeLength() {
        return this.timeLength;
    }

    public int hashCode() {
        int hashCode = ((this.snackbarText.hashCode() * 31) + Float.floatToIntBits(this.snackbarTextSize)) * 31;
        String str = this.actionTxt;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.actionTxtColor) * 31;
        Integer num = this.actionTxtBgRes;
        int hashCode3 = (((hashCode2 + (num == null ? 0 : num.hashCode())) * 31) + Float.floatToIntBits(this.actionTxtSize)) * 31;
        Integer num2 = this.actionWidth;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.actionHeight;
        int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.leftDrawableRes;
        int hashCode6 = (((((hashCode5 + (num4 == null ? 0 : num4.hashCode())) * 31) + this.bgRes) * 31) + this.timeLength) * 31;
        Function0<kotlin.p> function0 = this.click;
        return hashCode6 + (function0 != null ? function0.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.snackbarText;
        float f10 = this.snackbarTextSize;
        String str2 = this.actionTxt;
        int i10 = this.actionTxtColor;
        Integer num = this.actionTxtBgRes;
        float f11 = this.actionTxtSize;
        Integer num2 = this.actionWidth;
        Integer num3 = this.actionHeight;
        Integer num4 = this.leftDrawableRes;
        return "SnackbarModel(snackbarText=" + str + ", snackbarTextSize=" + f10 + ", actionTxt=" + str2 + ", actionTxtColor=" + i10 + ", actionTxtBgRes=" + ((Object) num) + ", actionTxtSize=" + f11 + ", actionWidth=" + ((Object) num2) + ", actionHeight=" + ((Object) num3) + ", leftDrawableRes=" + ((Object) num4) + ", bgRes=" + this.bgRes + ", timeLength=" + this.timeLength + ", click=" + ((Object) this.click) + ")";
    }

    public /* synthetic */ SnackbarModel(String str, float f10, String str2, int i10, Integer num, float f11, Integer num2, Integer num3, Integer num4, int i11, int i12, Function0 function0, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i13 & 2) != 0 ? 14.0f : f10, (i13 & 4) != 0 ? null : str2, (i13 & 8) != 0 ? -16738049 : i10, (i13 & 16) != 0 ? null : num, (i13 & 32) == 0 ? f11 : 14.0f, (i13 & 64) != 0 ? null : num2, (i13 & 128) != 0 ? null : num3, (i13 & 256) != 0 ? null : num4, (i13 & 512) != 0 ? R$drawable.shape_black_80_bg_twelve_corners : i11, (i13 & 1024) != 0 ? -1 : i12, (i13 & 2048) == 0 ? function0 : null);
    }
}
