package com.cupidapp.live.chat.adapter;

import com.cupidapp.live.chat.model.CustomEmojiCode;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FaceAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FaceUiModel {

    @NotNull
    private final CustomEmojiCode customEmojiCode;
    private final int height;
    private final int itemBgRes;
    private final int itemPaddingWithIcon;
    private final int width;

    public FaceUiModel(@NotNull CustomEmojiCode customEmojiCode, int i10, int i11, int i12, int i13) {
        s.i(customEmojiCode, "customEmojiCode");
        this.customEmojiCode = customEmojiCode;
        this.width = i10;
        this.height = i11;
        this.itemBgRes = i12;
        this.itemPaddingWithIcon = i13;
    }

    public static /* synthetic */ FaceUiModel copy$default(FaceUiModel faceUiModel, CustomEmojiCode customEmojiCode, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            customEmojiCode = faceUiModel.customEmojiCode;
        }
        if ((i14 & 2) != 0) {
            i10 = faceUiModel.width;
        }
        int i15 = i10;
        if ((i14 & 4) != 0) {
            i11 = faceUiModel.height;
        }
        int i16 = i11;
        if ((i14 & 8) != 0) {
            i12 = faceUiModel.itemBgRes;
        }
        int i17 = i12;
        if ((i14 & 16) != 0) {
            i13 = faceUiModel.itemPaddingWithIcon;
        }
        return faceUiModel.copy(customEmojiCode, i15, i16, i17, i13);
    }

    @NotNull
    public final CustomEmojiCode component1() {
        return this.customEmojiCode;
    }

    public final int component2() {
        return this.width;
    }

    public final int component3() {
        return this.height;
    }

    public final int component4() {
        return this.itemBgRes;
    }

    public final int component5() {
        return this.itemPaddingWithIcon;
    }

    @NotNull
    public final FaceUiModel copy(@NotNull CustomEmojiCode customEmojiCode, int i10, int i11, int i12, int i13) {
        s.i(customEmojiCode, "customEmojiCode");
        return new FaceUiModel(customEmojiCode, i10, i11, i12, i13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FaceUiModel)) {
            return false;
        }
        FaceUiModel faceUiModel = (FaceUiModel) obj;
        return this.customEmojiCode == faceUiModel.customEmojiCode && this.width == faceUiModel.width && this.height == faceUiModel.height && this.itemBgRes == faceUiModel.itemBgRes && this.itemPaddingWithIcon == faceUiModel.itemPaddingWithIcon;
    }

    @NotNull
    public final CustomEmojiCode getCustomEmojiCode() {
        return this.customEmojiCode;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getItemBgRes() {
        return this.itemBgRes;
    }

    public final int getItemPaddingWithIcon() {
        return this.itemPaddingWithIcon;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((((((this.customEmojiCode.hashCode() * 31) + this.width) * 31) + this.height) * 31) + this.itemBgRes) * 31) + this.itemPaddingWithIcon;
    }

    @NotNull
    public String toString() {
        CustomEmojiCode customEmojiCode = this.customEmojiCode;
        return "FaceUiModel(customEmojiCode=" + ((Object) customEmojiCode) + ", width=" + this.width + ", height=" + this.height + ", itemBgRes=" + this.itemBgRes + ", itemPaddingWithIcon=" + this.itemPaddingWithIcon + ")";
    }
}
