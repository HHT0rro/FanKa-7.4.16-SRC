package com.cupidapp.live.vip.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VipFunctionModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipFunctionUiModel {

    @NotNull
    private final String dialogContent;
    private final int dialogImage;
    private final int image;
    private final boolean isSwitch;

    @NotNull
    private final String name;

    @Nullable
    private final String onLineTime;

    @NotNull
    private final VipType vipType;

    public VipFunctionUiModel(@NotNull String name, int i10, @NotNull String dialogContent, int i11, boolean z10, @NotNull VipType vipType, @Nullable String str) {
        s.i(name, "name");
        s.i(dialogContent, "dialogContent");
        s.i(vipType, "vipType");
        this.name = name;
        this.image = i10;
        this.dialogContent = dialogContent;
        this.dialogImage = i11;
        this.isSwitch = z10;
        this.vipType = vipType;
        this.onLineTime = str;
    }

    public static /* synthetic */ VipFunctionUiModel copy$default(VipFunctionUiModel vipFunctionUiModel, String str, int i10, String str2, int i11, boolean z10, VipType vipType, String str3, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = vipFunctionUiModel.name;
        }
        if ((i12 & 2) != 0) {
            i10 = vipFunctionUiModel.image;
        }
        int i13 = i10;
        if ((i12 & 4) != 0) {
            str2 = vipFunctionUiModel.dialogContent;
        }
        String str4 = str2;
        if ((i12 & 8) != 0) {
            i11 = vipFunctionUiModel.dialogImage;
        }
        int i14 = i11;
        if ((i12 & 16) != 0) {
            z10 = vipFunctionUiModel.isSwitch;
        }
        boolean z11 = z10;
        if ((i12 & 32) != 0) {
            vipType = vipFunctionUiModel.vipType;
        }
        VipType vipType2 = vipType;
        if ((i12 & 64) != 0) {
            str3 = vipFunctionUiModel.onLineTime;
        }
        return vipFunctionUiModel.copy(str, i13, str4, i14, z11, vipType2, str3);
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.image;
    }

    @NotNull
    public final String component3() {
        return this.dialogContent;
    }

    public final int component4() {
        return this.dialogImage;
    }

    public final boolean component5() {
        return this.isSwitch;
    }

    @NotNull
    public final VipType component6() {
        return this.vipType;
    }

    @Nullable
    public final String component7() {
        return this.onLineTime;
    }

    @NotNull
    public final VipFunctionUiModel copy(@NotNull String name, int i10, @NotNull String dialogContent, int i11, boolean z10, @NotNull VipType vipType, @Nullable String str) {
        s.i(name, "name");
        s.i(dialogContent, "dialogContent");
        s.i(vipType, "vipType");
        return new VipFunctionUiModel(name, i10, dialogContent, i11, z10, vipType, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VipFunctionUiModel)) {
            return false;
        }
        VipFunctionUiModel vipFunctionUiModel = (VipFunctionUiModel) obj;
        return s.d(this.name, vipFunctionUiModel.name) && this.image == vipFunctionUiModel.image && s.d(this.dialogContent, vipFunctionUiModel.dialogContent) && this.dialogImage == vipFunctionUiModel.dialogImage && this.isSwitch == vipFunctionUiModel.isSwitch && this.vipType == vipFunctionUiModel.vipType && s.d(this.onLineTime, vipFunctionUiModel.onLineTime);
    }

    @NotNull
    public final String getDialogContent() {
        return this.dialogContent;
    }

    public final int getDialogImage() {
        return this.dialogImage;
    }

    public final int getImage() {
        return this.image;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getOnLineTime() {
        return this.onLineTime;
    }

    @NotNull
    public final VipType getVipType() {
        return this.vipType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.name.hashCode() * 31) + this.image) * 31) + this.dialogContent.hashCode()) * 31) + this.dialogImage) * 31;
        boolean z10 = this.isSwitch;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int hashCode2 = (((hashCode + i10) * 31) + this.vipType.hashCode()) * 31;
        String str = this.onLineTime;
        return hashCode2 + (str == null ? 0 : str.hashCode());
    }

    public final boolean isSwitch() {
        return this.isSwitch;
    }

    @NotNull
    public String toString() {
        String str = this.name;
        int i10 = this.image;
        String str2 = this.dialogContent;
        int i11 = this.dialogImage;
        boolean z10 = this.isSwitch;
        VipType vipType = this.vipType;
        return "VipFunctionUiModel(name=" + str + ", image=" + i10 + ", dialogContent=" + str2 + ", dialogImage=" + i11 + ", isSwitch=" + z10 + ", vipType=" + ((Object) vipType) + ", onLineTime=" + this.onLineTime + ")";
    }

    public /* synthetic */ VipFunctionUiModel(String str, int i10, String str2, int i11, boolean z10, VipType vipType, String str3, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i10, str2, i11, z10, vipType, (i12 & 64) != 0 ? null : str3);
    }
}
