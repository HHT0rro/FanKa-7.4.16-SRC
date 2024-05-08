package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveStickerModel implements Serializable {

    @Nullable
    private final String expiration;

    @Nullable
    private final Integer icon;

    @Nullable
    private final ImageModel image;
    private final int isLight;
    private boolean isSelected;

    @NotNull
    private final String privilegesName;

    @Nullable
    private final String resourcePath;

    @Nullable
    private final String subscript;

    public LiveStickerModel(@NotNull String privilegesName, int i10, @Nullable ImageModel imageModel, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, boolean z10) {
        s.i(privilegesName, "privilegesName");
        this.privilegesName = privilegesName;
        this.isLight = i10;
        this.image = imageModel;
        this.expiration = str;
        this.subscript = str2;
        this.resourcePath = str3;
        this.icon = num;
        this.isSelected = z10;
    }

    @NotNull
    public final String component1() {
        return this.privilegesName;
    }

    public final int component2() {
        return this.isLight;
    }

    @Nullable
    public final ImageModel component3() {
        return this.image;
    }

    @Nullable
    public final String component4() {
        return this.expiration;
    }

    @Nullable
    public final String component5() {
        return this.subscript;
    }

    @Nullable
    public final String component6() {
        return this.resourcePath;
    }

    @Nullable
    public final Integer component7() {
        return this.icon;
    }

    public final boolean component8() {
        return this.isSelected;
    }

    @NotNull
    public final LiveStickerModel copy(@NotNull String privilegesName, int i10, @Nullable ImageModel imageModel, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, boolean z10) {
        s.i(privilegesName, "privilegesName");
        return new LiveStickerModel(privilegesName, i10, imageModel, str, str2, str3, num, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveStickerModel)) {
            return false;
        }
        LiveStickerModel liveStickerModel = (LiveStickerModel) obj;
        return s.d(this.privilegesName, liveStickerModel.privilegesName) && this.isLight == liveStickerModel.isLight && s.d(this.image, liveStickerModel.image) && s.d(this.expiration, liveStickerModel.expiration) && s.d(this.subscript, liveStickerModel.subscript) && s.d(this.resourcePath, liveStickerModel.resourcePath) && s.d(this.icon, liveStickerModel.icon) && this.isSelected == liveStickerModel.isSelected;
    }

    @Nullable
    public final String getExpiration() {
        return this.expiration;
    }

    @Nullable
    public final Integer getIcon() {
        return this.icon;
    }

    @Nullable
    public final ImageModel getImage() {
        return this.image;
    }

    @NotNull
    public final String getPrivilegesName() {
        return this.privilegesName;
    }

    @Nullable
    public final String getResourcePath() {
        return this.resourcePath;
    }

    @Nullable
    public final String getSubscript() {
        return this.subscript;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.privilegesName.hashCode() * 31) + this.isLight) * 31;
        ImageModel imageModel = this.image;
        int hashCode2 = (hashCode + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str = this.expiration;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.subscript;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.resourcePath;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.icon;
        int hashCode6 = (hashCode5 + (num != null ? num.hashCode() : 0)) * 31;
        boolean z10 = this.isSelected;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode6 + i10;
    }

    public final int isLight() {
        return this.isLight;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z10) {
        this.isSelected = z10;
    }

    @NotNull
    public String toString() {
        String str = this.privilegesName;
        int i10 = this.isLight;
        ImageModel imageModel = this.image;
        String str2 = this.expiration;
        String str3 = this.subscript;
        String str4 = this.resourcePath;
        Integer num = this.icon;
        return "LiveStickerModel(privilegesName=" + str + ", isLight=" + i10 + ", image=" + ((Object) imageModel) + ", expiration=" + str2 + ", subscript=" + str3 + ", resourcePath=" + str4 + ", icon=" + ((Object) num) + ", isSelected=" + this.isSelected + ")";
    }

    public /* synthetic */ LiveStickerModel(String str, int i10, ImageModel imageModel, String str2, String str3, String str4, Integer num, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? 0 : i10, (i11 & 4) != 0 ? null : imageModel, (i11 & 8) != 0 ? null : str2, (i11 & 16) != 0 ? null : str3, (i11 & 32) != 0 ? null : str4, (i11 & 64) == 0 ? num : null, (i11 & 128) == 0 ? z10 : false);
    }
}
