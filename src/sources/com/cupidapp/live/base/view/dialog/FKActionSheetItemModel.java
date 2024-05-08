package com.cupidapp.live.base.view.dialog;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKActionSheetItemLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKActionSheetItemModel {

    @NotNull
    private final Function0<p> clickListener;

    @NotNull
    private final ActionSheetItemType itemType;

    @Nullable
    private final Integer leftImgResId;

    @Nullable
    private final Integer rightImgResId;

    @Nullable
    private final Integer subTextResId;
    private final int textResId;

    public FKActionSheetItemModel(@StringRes int i10, @NotNull ActionSheetItemType itemType, @DrawableRes @Nullable Integer num, @DrawableRes @Nullable Integer num2, @StringRes @Nullable Integer num3, @NotNull Function0<p> clickListener) {
        s.i(itemType, "itemType");
        s.i(clickListener, "clickListener");
        this.textResId = i10;
        this.itemType = itemType;
        this.leftImgResId = num;
        this.rightImgResId = num2;
        this.subTextResId = num3;
        this.clickListener = clickListener;
    }

    @NotNull
    public final Function0<p> getClickListener() {
        return this.clickListener;
    }

    @NotNull
    public final ActionSheetItemType getItemType() {
        return this.itemType;
    }

    @Nullable
    public final Integer getLeftImgResId() {
        return this.leftImgResId;
    }

    @Nullable
    public final Integer getRightImgResId() {
        return this.rightImgResId;
    }

    @Nullable
    public final Integer getSubTextResId() {
        return this.subTextResId;
    }

    public final int getTextResId() {
        return this.textResId;
    }

    public /* synthetic */ FKActionSheetItemModel(int i10, ActionSheetItemType actionSheetItemType, Integer num, Integer num2, Integer num3, Function0 function0, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, (i11 & 2) != 0 ? ActionSheetItemType.Default : actionSheetItemType, (i11 & 4) != 0 ? null : num, (i11 & 8) != 0 ? null : num2, (i11 & 16) != 0 ? null : num3, function0);
    }
}
