package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveListResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AdModel {

    @Nullable
    private String adType;

    @NotNull
    private final String adUrl;
    private final boolean closeable;

    @Nullable
    private String description;

    @NotNull
    private final ImageModel image;

    @NotNull
    private final String itemId;

    @Nullable
    private String linkText;
    private final int timeInterval;

    @Nullable
    private String title;

    @NotNull
    private final String type;

    public AdModel(@NotNull String itemId, boolean z10, @NotNull ImageModel image, int i10, @NotNull String adUrl, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull String type) {
        s.i(itemId, "itemId");
        s.i(image, "image");
        s.i(adUrl, "adUrl");
        s.i(type, "type");
        this.itemId = itemId;
        this.closeable = z10;
        this.image = image;
        this.timeInterval = i10;
        this.adUrl = adUrl;
        this.adType = str;
        this.linkText = str2;
        this.description = str3;
        this.title = str4;
        this.type = type;
    }

    @NotNull
    public final String component1() {
        return this.itemId;
    }

    @NotNull
    public final String component10() {
        return this.type;
    }

    public final boolean component2() {
        return this.closeable;
    }

    @NotNull
    public final ImageModel component3() {
        return this.image;
    }

    public final int component4() {
        return this.timeInterval;
    }

    @NotNull
    public final String component5() {
        return this.adUrl;
    }

    @Nullable
    public final String component6() {
        return this.adType;
    }

    @Nullable
    public final String component7() {
        return this.linkText;
    }

    @Nullable
    public final String component8() {
        return this.description;
    }

    @Nullable
    public final String component9() {
        return this.title;
    }

    @NotNull
    public final AdModel copy(@NotNull String itemId, boolean z10, @NotNull ImageModel image, int i10, @NotNull String adUrl, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull String type) {
        s.i(itemId, "itemId");
        s.i(image, "image");
        s.i(adUrl, "adUrl");
        s.i(type, "type");
        return new AdModel(itemId, z10, image, i10, adUrl, str, str2, str3, str4, type);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdModel)) {
            return false;
        }
        AdModel adModel = (AdModel) obj;
        return s.d(this.itemId, adModel.itemId) && this.closeable == adModel.closeable && s.d(this.image, adModel.image) && this.timeInterval == adModel.timeInterval && s.d(this.adUrl, adModel.adUrl) && s.d(this.adType, adModel.adType) && s.d(this.linkText, adModel.linkText) && s.d(this.description, adModel.description) && s.d(this.title, adModel.title) && s.d(this.type, adModel.type);
    }

    @Nullable
    public final String getAdType() {
        return this.adType;
    }

    @NotNull
    public final String getAdUrl() {
        return this.adUrl;
    }

    public final boolean getCloseable() {
        return this.closeable;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final ImageModel getImage() {
        return this.image;
    }

    @NotNull
    public final String getItemId() {
        return this.itemId;
    }

    @Nullable
    public final String getLinkText() {
        return this.linkText;
    }

    public final int getTimeInterval() {
        return this.timeInterval;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.itemId.hashCode() * 31;
        boolean z10 = this.closeable;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int hashCode2 = (((((((hashCode + i10) * 31) + this.image.hashCode()) * 31) + this.timeInterval) * 31) + this.adUrl.hashCode()) * 31;
        String str = this.adType;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.linkText;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.title;
        return ((hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.type.hashCode();
    }

    public final void setAdType(@Nullable String str) {
        this.adType = str;
    }

    public final void setDescription(@Nullable String str) {
        this.description = str;
    }

    public final void setLinkText(@Nullable String str) {
        this.linkText = str;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    @NotNull
    public String toString() {
        String str = this.itemId;
        boolean z10 = this.closeable;
        ImageModel imageModel = this.image;
        return "AdModel(itemId=" + str + ", closeable=" + z10 + ", image=" + ((Object) imageModel) + ", timeInterval=" + this.timeInterval + ", adUrl=" + this.adUrl + ", adType=" + this.adType + ", linkText=" + this.linkText + ", description=" + this.description + ", title=" + this.title + ", type=" + this.type + ")";
    }
}
