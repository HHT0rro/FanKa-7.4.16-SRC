package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class BadgeModel implements Serializable {

    @Nullable
    private final ImageModel iconImage;

    @Nullable
    private final String url;

    public BadgeModel(@Nullable ImageModel imageModel, @Nullable String str) {
        this.iconImage = imageModel;
        this.url = str;
    }

    public static /* synthetic */ BadgeModel copy$default(BadgeModel badgeModel, ImageModel imageModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = badgeModel.iconImage;
        }
        if ((i10 & 2) != 0) {
            str = badgeModel.url;
        }
        return badgeModel.copy(imageModel, str);
    }

    @Nullable
    public final ImageModel component1() {
        return this.iconImage;
    }

    @Nullable
    public final String component2() {
        return this.url;
    }

    @NotNull
    public final BadgeModel copy(@Nullable ImageModel imageModel, @Nullable String str) {
        return new BadgeModel(imageModel, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BadgeModel)) {
            return false;
        }
        BadgeModel badgeModel = (BadgeModel) obj;
        return s.d(this.iconImage, badgeModel.iconImage) && s.d(this.url, badgeModel.url);
    }

    @Nullable
    public final ImageModel getIconImage() {
        return this.iconImage;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        ImageModel imageModel = this.iconImage;
        int hashCode = (imageModel == null ? 0 : imageModel.hashCode()) * 31;
        String str = this.url;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.iconImage;
        return "BadgeModel(iconImage=" + ((Object) imageModel) + ", url=" + this.url + ")";
    }
}
