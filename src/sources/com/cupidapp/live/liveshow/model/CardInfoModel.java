package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveMiniProfileResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class CardInfoModel {

    @Nullable
    private final String backContent;

    @Nullable
    private final Integer backPercent;

    @Nullable
    private final String backTitle;

    @Nullable
    private final String backgroundColor;

    @Nullable
    private final String frontContent;

    @Nullable
    private final String frontJumpUrl;

    @NotNull
    private final String frontTitle;

    @Nullable
    private final ImageModel icon;

    public CardInfoModel(@NotNull String frontTitle, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable ImageModel imageModel, @Nullable String str4, @Nullable String str5) {
        s.i(frontTitle, "frontTitle");
        this.frontTitle = frontTitle;
        this.frontContent = str;
        this.backTitle = str2;
        this.backContent = str3;
        this.backPercent = num;
        this.icon = imageModel;
        this.backgroundColor = str4;
        this.frontJumpUrl = str5;
    }

    @NotNull
    public final String component1() {
        return this.frontTitle;
    }

    @Nullable
    public final String component2() {
        return this.frontContent;
    }

    @Nullable
    public final String component3() {
        return this.backTitle;
    }

    @Nullable
    public final String component4() {
        return this.backContent;
    }

    @Nullable
    public final Integer component5() {
        return this.backPercent;
    }

    @Nullable
    public final ImageModel component6() {
        return this.icon;
    }

    @Nullable
    public final String component7() {
        return this.backgroundColor;
    }

    @Nullable
    public final String component8() {
        return this.frontJumpUrl;
    }

    @NotNull
    public final CardInfoModel copy(@NotNull String frontTitle, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable ImageModel imageModel, @Nullable String str4, @Nullable String str5) {
        s.i(frontTitle, "frontTitle");
        return new CardInfoModel(frontTitle, str, str2, str3, num, imageModel, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardInfoModel)) {
            return false;
        }
        CardInfoModel cardInfoModel = (CardInfoModel) obj;
        return s.d(this.frontTitle, cardInfoModel.frontTitle) && s.d(this.frontContent, cardInfoModel.frontContent) && s.d(this.backTitle, cardInfoModel.backTitle) && s.d(this.backContent, cardInfoModel.backContent) && s.d(this.backPercent, cardInfoModel.backPercent) && s.d(this.icon, cardInfoModel.icon) && s.d(this.backgroundColor, cardInfoModel.backgroundColor) && s.d(this.frontJumpUrl, cardInfoModel.frontJumpUrl);
    }

    @Nullable
    public final String getBackContent() {
        return this.backContent;
    }

    @Nullable
    public final Integer getBackPercent() {
        return this.backPercent;
    }

    @Nullable
    public final String getBackTitle() {
        return this.backTitle;
    }

    @Nullable
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public final String getFrontContent() {
        return this.frontContent;
    }

    @Nullable
    public final String getFrontJumpUrl() {
        return this.frontJumpUrl;
    }

    @NotNull
    public final String getFrontTitle() {
        return this.frontTitle;
    }

    @Nullable
    public final ImageModel getIcon() {
        return this.icon;
    }

    public int hashCode() {
        int hashCode = this.frontTitle.hashCode() * 31;
        String str = this.frontContent;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.backTitle;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.backContent;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.backPercent;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        ImageModel imageModel = this.icon;
        int hashCode6 = (hashCode5 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str4 = this.backgroundColor;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.frontJumpUrl;
        return hashCode7 + (str5 != null ? str5.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.frontTitle;
        String str2 = this.frontContent;
        String str3 = this.backTitle;
        String str4 = this.backContent;
        Integer num = this.backPercent;
        ImageModel imageModel = this.icon;
        return "CardInfoModel(frontTitle=" + str + ", frontContent=" + str2 + ", backTitle=" + str3 + ", backContent=" + str4 + ", backPercent=" + ((Object) num) + ", icon=" + ((Object) imageModel) + ", backgroundColor=" + this.backgroundColor + ", frontJumpUrl=" + this.frontJumpUrl + ")";
    }
}
