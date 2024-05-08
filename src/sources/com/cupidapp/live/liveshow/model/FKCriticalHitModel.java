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
public final class FKCriticalHitModel implements Serializable {

    @NotNull
    private final String category;

    @Nullable
    private final Integer countdown;

    @Nullable
    private final Long currentTimeMillis;

    @Nullable
    private final ImageModel iconImage;

    @Nullable
    private final String text;

    @Nullable
    private final String url;

    public FKCriticalHitModel(@Nullable String str, @Nullable String str2, @Nullable ImageModel imageModel, @Nullable Integer num, @Nullable Long l10, @NotNull String category) {
        s.i(category, "category");
        this.url = str;
        this.text = str2;
        this.iconImage = imageModel;
        this.countdown = num;
        this.currentTimeMillis = l10;
        this.category = category;
    }

    public static /* synthetic */ FKCriticalHitModel copy$default(FKCriticalHitModel fKCriticalHitModel, String str, String str2, ImageModel imageModel, Integer num, Long l10, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = fKCriticalHitModel.url;
        }
        if ((i10 & 2) != 0) {
            str2 = fKCriticalHitModel.text;
        }
        String str4 = str2;
        if ((i10 & 4) != 0) {
            imageModel = fKCriticalHitModel.iconImage;
        }
        ImageModel imageModel2 = imageModel;
        if ((i10 & 8) != 0) {
            num = fKCriticalHitModel.countdown;
        }
        Integer num2 = num;
        if ((i10 & 16) != 0) {
            l10 = fKCriticalHitModel.currentTimeMillis;
        }
        Long l11 = l10;
        if ((i10 & 32) != 0) {
            str3 = fKCriticalHitModel.category;
        }
        return fKCriticalHitModel.copy(str, str4, imageModel2, num2, l11, str3);
    }

    @Nullable
    public final String component1() {
        return this.url;
    }

    @Nullable
    public final String component2() {
        return this.text;
    }

    @Nullable
    public final ImageModel component3() {
        return this.iconImage;
    }

    @Nullable
    public final Integer component4() {
        return this.countdown;
    }

    @Nullable
    public final Long component5() {
        return this.currentTimeMillis;
    }

    @NotNull
    public final String component6() {
        return this.category;
    }

    @NotNull
    public final FKCriticalHitModel copy(@Nullable String str, @Nullable String str2, @Nullable ImageModel imageModel, @Nullable Integer num, @Nullable Long l10, @NotNull String category) {
        s.i(category, "category");
        return new FKCriticalHitModel(str, str2, imageModel, num, l10, category);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKCriticalHitModel)) {
            return false;
        }
        FKCriticalHitModel fKCriticalHitModel = (FKCriticalHitModel) obj;
        return s.d(this.url, fKCriticalHitModel.url) && s.d(this.text, fKCriticalHitModel.text) && s.d(this.iconImage, fKCriticalHitModel.iconImage) && s.d(this.countdown, fKCriticalHitModel.countdown) && s.d(this.currentTimeMillis, fKCriticalHitModel.currentTimeMillis) && s.d(this.category, fKCriticalHitModel.category);
    }

    @NotNull
    public final String getCategory() {
        return this.category;
    }

    @Nullable
    public final Integer getCountdown() {
        return this.countdown;
    }

    @Nullable
    public final Long getCurrentTimeMillis() {
        return this.currentTimeMillis;
    }

    @Nullable
    public final ImageModel getIconImage() {
        return this.iconImage;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.url;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.text;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        ImageModel imageModel = this.iconImage;
        int hashCode3 = (hashCode2 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        Integer num = this.countdown;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Long l10 = this.currentTimeMillis;
        return ((hashCode4 + (l10 != null ? l10.hashCode() : 0)) * 31) + this.category.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.url;
        String str2 = this.text;
        ImageModel imageModel = this.iconImage;
        Integer num = this.countdown;
        Long l10 = this.currentTimeMillis;
        return "FKCriticalHitModel(url=" + str + ", text=" + str2 + ", iconImage=" + ((Object) imageModel) + ", countdown=" + ((Object) num) + ", currentTimeMillis=" + ((Object) l10) + ", category=" + this.category + ")";
    }
}
