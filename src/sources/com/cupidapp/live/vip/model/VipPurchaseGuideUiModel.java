package com.cupidapp.live.vip.model;

import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VipPurchaseGuideUiModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VipPurchaseGuideUiModel {

    @NotNull
    private final String content;

    @Nullable
    private final String help;
    private final int imageId;

    @Nullable
    private final Integer markIcon;

    @NotNull
    private final String name;

    @NotNull
    private final VipPrivilegeType privilegeType;

    @Nullable
    private final List<VipPurchaseEntranceType> typeList;

    @NotNull
    private VipType vipType;

    /* JADX WARN: Multi-variable type inference failed */
    public VipPurchaseGuideUiModel(@Nullable List<? extends VipPurchaseEntranceType> list, int i10, @NotNull String name, @NotNull String content, @NotNull VipPrivilegeType privilegeType, @Nullable String str, @Nullable Integer num, @NotNull VipType vipType) {
        s.i(name, "name");
        s.i(content, "content");
        s.i(privilegeType, "privilegeType");
        s.i(vipType, "vipType");
        this.typeList = list;
        this.imageId = i10;
        this.name = name;
        this.content = content;
        this.privilegeType = privilegeType;
        this.help = str;
        this.markIcon = num;
        this.vipType = vipType;
    }

    @Nullable
    public final List<VipPurchaseEntranceType> component1() {
        return this.typeList;
    }

    public final int component2() {
        return this.imageId;
    }

    @NotNull
    public final String component3() {
        return this.name;
    }

    @NotNull
    public final String component4() {
        return this.content;
    }

    @NotNull
    public final VipPrivilegeType component5() {
        return this.privilegeType;
    }

    @Nullable
    public final String component6() {
        return this.help;
    }

    @Nullable
    public final Integer component7() {
        return this.markIcon;
    }

    @NotNull
    public final VipType component8() {
        return this.vipType;
    }

    @NotNull
    public final VipPurchaseGuideUiModel copy(@Nullable List<? extends VipPurchaseEntranceType> list, int i10, @NotNull String name, @NotNull String content, @NotNull VipPrivilegeType privilegeType, @Nullable String str, @Nullable Integer num, @NotNull VipType vipType) {
        s.i(name, "name");
        s.i(content, "content");
        s.i(privilegeType, "privilegeType");
        s.i(vipType, "vipType");
        return new VipPurchaseGuideUiModel(list, i10, name, content, privilegeType, str, num, vipType);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VipPurchaseGuideUiModel)) {
            return false;
        }
        VipPurchaseGuideUiModel vipPurchaseGuideUiModel = (VipPurchaseGuideUiModel) obj;
        return s.d(this.typeList, vipPurchaseGuideUiModel.typeList) && this.imageId == vipPurchaseGuideUiModel.imageId && s.d(this.name, vipPurchaseGuideUiModel.name) && s.d(this.content, vipPurchaseGuideUiModel.content) && this.privilegeType == vipPurchaseGuideUiModel.privilegeType && s.d(this.help, vipPurchaseGuideUiModel.help) && s.d(this.markIcon, vipPurchaseGuideUiModel.markIcon) && this.vipType == vipPurchaseGuideUiModel.vipType;
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final String getHelp() {
        return this.help;
    }

    public final int getImageId() {
        return this.imageId;
    }

    @Nullable
    public final Integer getMarkIcon() {
        return this.markIcon;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final VipPrivilegeType getPrivilegeType() {
        return this.privilegeType;
    }

    @Nullable
    public final List<VipPurchaseEntranceType> getTypeList() {
        return this.typeList;
    }

    @NotNull
    public final VipType getVipType() {
        return this.vipType;
    }

    public int hashCode() {
        List<VipPurchaseEntranceType> list = this.typeList;
        int hashCode = (((((((((list == null ? 0 : list.hashCode()) * 31) + this.imageId) * 31) + this.name.hashCode()) * 31) + this.content.hashCode()) * 31) + this.privilegeType.hashCode()) * 31;
        String str = this.help;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.markIcon;
        return ((hashCode2 + (num != null ? num.hashCode() : 0)) * 31) + this.vipType.hashCode();
    }

    public final void setVipType(@NotNull VipType vipType) {
        s.i(vipType, "<set-?>");
        this.vipType = vipType;
    }

    @NotNull
    public String toString() {
        List<VipPurchaseEntranceType> list = this.typeList;
        int i10 = this.imageId;
        String str = this.name;
        String str2 = this.content;
        VipPrivilegeType vipPrivilegeType = this.privilegeType;
        return "VipPurchaseGuideUiModel(typeList=" + ((Object) list) + ", imageId=" + i10 + ", name=" + str + ", content=" + str2 + ", privilegeType=" + ((Object) vipPrivilegeType) + ", help=" + this.help + ", markIcon=" + ((Object) this.markIcon) + ", vipType=" + ((Object) this.vipType) + ")";
    }

    public /* synthetic */ VipPurchaseGuideUiModel(List list, int i10, String str, String str2, VipPrivilegeType vipPrivilegeType, String str3, Integer num, VipType vipType, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, i10, str, str2, vipPrivilegeType, (i11 & 32) != 0 ? null : str3, (i11 & 64) != 0 ? null : num, (i11 & 128) != 0 ? VipType.SUPER : vipType);
    }
}
