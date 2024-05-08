package com.cupidapp.live.feed.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PromotionNearByGuideModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class PromotionNearByGuideModel {

    @Nullable
    private final List<ImageModel> avatars;

    @Nullable
    private final String desc;

    @Nullable
    private final ImageModel icon;

    @Nullable
    private final String matchTitle;

    @Nullable
    private final String matchUrl;

    @Nullable
    private final String nearbyTitle;

    @Nullable
    private final String nearbyUrl;

    @Nullable
    private final String subTitle;

    @Nullable
    private final String title;

    @Nullable
    private final String trackName;

    public PromotionNearByGuideModel(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable ImageModel imageModel, @Nullable String str7, @Nullable String str8, @Nullable List<ImageModel> list) {
        this.desc = str;
        this.matchTitle = str2;
        this.matchUrl = str3;
        this.nearbyTitle = str4;
        this.nearbyUrl = str5;
        this.title = str6;
        this.icon = imageModel;
        this.subTitle = str7;
        this.trackName = str8;
        this.avatars = list;
    }

    @Nullable
    public final String component1() {
        return this.desc;
    }

    @Nullable
    public final List<ImageModel> component10() {
        return this.avatars;
    }

    @Nullable
    public final String component2() {
        return this.matchTitle;
    }

    @Nullable
    public final String component3() {
        return this.matchUrl;
    }

    @Nullable
    public final String component4() {
        return this.nearbyTitle;
    }

    @Nullable
    public final String component5() {
        return this.nearbyUrl;
    }

    @Nullable
    public final String component6() {
        return this.title;
    }

    @Nullable
    public final ImageModel component7() {
        return this.icon;
    }

    @Nullable
    public final String component8() {
        return this.subTitle;
    }

    @Nullable
    public final String component9() {
        return this.trackName;
    }

    @NotNull
    public final PromotionNearByGuideModel copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable ImageModel imageModel, @Nullable String str7, @Nullable String str8, @Nullable List<ImageModel> list) {
        return new PromotionNearByGuideModel(str, str2, str3, str4, str5, str6, imageModel, str7, str8, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PromotionNearByGuideModel)) {
            return false;
        }
        PromotionNearByGuideModel promotionNearByGuideModel = (PromotionNearByGuideModel) obj;
        return s.d(this.desc, promotionNearByGuideModel.desc) && s.d(this.matchTitle, promotionNearByGuideModel.matchTitle) && s.d(this.matchUrl, promotionNearByGuideModel.matchUrl) && s.d(this.nearbyTitle, promotionNearByGuideModel.nearbyTitle) && s.d(this.nearbyUrl, promotionNearByGuideModel.nearbyUrl) && s.d(this.title, promotionNearByGuideModel.title) && s.d(this.icon, promotionNearByGuideModel.icon) && s.d(this.subTitle, promotionNearByGuideModel.subTitle) && s.d(this.trackName, promotionNearByGuideModel.trackName) && s.d(this.avatars, promotionNearByGuideModel.avatars);
    }

    @Nullable
    public final List<ImageModel> getAvatars() {
        return this.avatars;
    }

    @Nullable
    public final String getDesc() {
        return this.desc;
    }

    @Nullable
    public final ImageModel getIcon() {
        return this.icon;
    }

    @Nullable
    public final String getMatchTitle() {
        return this.matchTitle;
    }

    @Nullable
    public final String getMatchUrl() {
        return this.matchUrl;
    }

    @Nullable
    public final String getNearbyTitle() {
        return this.nearbyTitle;
    }

    @Nullable
    public final String getNearbyUrl() {
        return this.nearbyUrl;
    }

    @Nullable
    public final String getSubTitle() {
        return this.subTitle;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getTrackName() {
        return this.trackName;
    }

    public int hashCode() {
        String str = this.desc;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.matchTitle;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.matchUrl;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.nearbyTitle;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.nearbyUrl;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.title;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        ImageModel imageModel = this.icon;
        int hashCode7 = (hashCode6 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str7 = this.subTitle;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.trackName;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        List<ImageModel> list = this.avatars;
        return hashCode9 + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.desc;
        String str2 = this.matchTitle;
        String str3 = this.matchUrl;
        String str4 = this.nearbyTitle;
        String str5 = this.nearbyUrl;
        String str6 = this.title;
        ImageModel imageModel = this.icon;
        return "PromotionNearByGuideModel(desc=" + str + ", matchTitle=" + str2 + ", matchUrl=" + str3 + ", nearbyTitle=" + str4 + ", nearbyUrl=" + str5 + ", title=" + str6 + ", icon=" + ((Object) imageModel) + ", subTitle=" + this.subTitle + ", trackName=" + this.trackName + ", avatars=" + ((Object) this.avatars) + ")";
    }
}
