package com.cupidapp.live.liveshow.view.bottommenu;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LiveMoreMenuAdapter.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveMoreMenuModel {

    @Nullable
    private Integer icon;

    @Nullable
    private final ImageModel iconImage;

    @Nullable
    private String name;
    private final boolean showRedDot;

    @Nullable
    private final String subscript;

    @NotNull
    private final MenuType type;

    public LiveMoreMenuModel(@NotNull MenuType type, @Nullable Integer num, @Nullable ImageModel imageModel, @Nullable String str, @Nullable String str2, boolean z10) {
        s.i(type, "type");
        this.type = type;
        this.icon = num;
        this.iconImage = imageModel;
        this.name = str;
        this.subscript = str2;
        this.showRedDot = z10;
    }

    public static /* synthetic */ LiveMoreMenuModel copy$default(LiveMoreMenuModel liveMoreMenuModel, MenuType menuType, Integer num, ImageModel imageModel, String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            menuType = liveMoreMenuModel.type;
        }
        if ((i10 & 2) != 0) {
            num = liveMoreMenuModel.icon;
        }
        Integer num2 = num;
        if ((i10 & 4) != 0) {
            imageModel = liveMoreMenuModel.iconImage;
        }
        ImageModel imageModel2 = imageModel;
        if ((i10 & 8) != 0) {
            str = liveMoreMenuModel.name;
        }
        String str3 = str;
        if ((i10 & 16) != 0) {
            str2 = liveMoreMenuModel.subscript;
        }
        String str4 = str2;
        if ((i10 & 32) != 0) {
            z10 = liveMoreMenuModel.showRedDot;
        }
        return liveMoreMenuModel.copy(menuType, num2, imageModel2, str3, str4, z10);
    }

    @NotNull
    public final MenuType component1() {
        return this.type;
    }

    @Nullable
    public final Integer component2() {
        return this.icon;
    }

    @Nullable
    public final ImageModel component3() {
        return this.iconImage;
    }

    @Nullable
    public final String component4() {
        return this.name;
    }

    @Nullable
    public final String component5() {
        return this.subscript;
    }

    public final boolean component6() {
        return this.showRedDot;
    }

    @NotNull
    public final LiveMoreMenuModel copy(@NotNull MenuType type, @Nullable Integer num, @Nullable ImageModel imageModel, @Nullable String str, @Nullable String str2, boolean z10) {
        s.i(type, "type");
        return new LiveMoreMenuModel(type, num, imageModel, str, str2, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveMoreMenuModel)) {
            return false;
        }
        LiveMoreMenuModel liveMoreMenuModel = (LiveMoreMenuModel) obj;
        return this.type == liveMoreMenuModel.type && s.d(this.icon, liveMoreMenuModel.icon) && s.d(this.iconImage, liveMoreMenuModel.iconImage) && s.d(this.name, liveMoreMenuModel.name) && s.d(this.subscript, liveMoreMenuModel.subscript) && this.showRedDot == liveMoreMenuModel.showRedDot;
    }

    @Nullable
    public final Integer getIcon() {
        return this.icon;
    }

    @Nullable
    public final ImageModel getIconImage() {
        return this.iconImage;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public final boolean getShowRedDot() {
        return this.showRedDot;
    }

    @Nullable
    public final String getSubscript() {
        return this.subscript;
    }

    @NotNull
    public final MenuType getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        Integer num = this.icon;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        ImageModel imageModel = this.iconImage;
        int hashCode3 = (hashCode2 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str = this.name;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.subscript;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z10 = this.showRedDot;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode5 + i10;
    }

    public final void setIcon(@Nullable Integer num) {
        this.icon = num;
    }

    public final void setName(@Nullable String str) {
        this.name = str;
    }

    @NotNull
    public String toString() {
        MenuType menuType = this.type;
        Integer num = this.icon;
        ImageModel imageModel = this.iconImage;
        return "LiveMoreMenuModel(type=" + ((Object) menuType) + ", icon=" + ((Object) num) + ", iconImage=" + ((Object) imageModel) + ", name=" + this.name + ", subscript=" + this.subscript + ", showRedDot=" + this.showRedDot + ")";
    }

    public /* synthetic */ LiveMoreMenuModel(MenuType menuType, Integer num, ImageModel imageModel, String str, String str2, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(menuType, (i10 & 2) != 0 ? null : num, (i10 & 4) != 0 ? null : imageModel, (i10 & 8) != 0 ? null : str, (i10 & 16) == 0 ? str2 : null, (i10 & 32) != 0 ? false : z10);
    }
}
