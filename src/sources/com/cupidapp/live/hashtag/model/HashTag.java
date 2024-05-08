package com.cupidapp.live.hashtag.model;

import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HashTagResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class HashTag implements Serializable {

    @Nullable
    private final ImageModel backgroundImage;

    @Nullable
    private final ImageModel bannerImage;

    @Nullable
    private final String bannerUrl;

    @Nullable
    private final String countDesc;

    @Nullable
    private final String description;

    @Nullable
    private final ImageModel hashTagBaseImage;
    private final boolean hashTagBaseImageSwitch;

    @Nullable
    private final String hotTag;

    @NotNull
    private final String itemId;

    @Nullable
    private final String jumpUrl;

    @NotNull
    private final String name;

    /* renamed from: new, reason: not valid java name */
    private final boolean f199new;
    private final int postCount;

    @Nullable
    private final String presetImageKey;

    @Nullable
    private final String shareContent;

    @Nullable
    private final String shareLink;

    @Nullable
    private final String shareTitle;

    @NotNull
    private final String summary;

    @Nullable
    private final String superscript;

    @Nullable
    private final Integer superscriptType;

    @NotNull
    private final String type;

    @Nullable
    private final String url;
    private final int userCount;

    @Nullable
    private final String userCountDesc;

    public HashTag(@NotNull String itemId, @NotNull String name, @Nullable ImageModel imageModel, @NotNull String summary, int i10, @Nullable String str, @NotNull String type, @Nullable String str2, int i11, @Nullable String str3, @Nullable String str4, boolean z10, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable ImageModel imageModel2, @Nullable String str9, @Nullable Integer num, @Nullable String str10, @Nullable String str11, @Nullable ImageModel imageModel3, boolean z11, @Nullable String str12) {
        s.i(itemId, "itemId");
        s.i(name, "name");
        s.i(summary, "summary");
        s.i(type, "type");
        this.itemId = itemId;
        this.name = name;
        this.backgroundImage = imageModel;
        this.summary = summary;
        this.postCount = i10;
        this.url = str;
        this.type = type;
        this.presetImageKey = str2;
        this.userCount = i11;
        this.userCountDesc = str3;
        this.countDesc = str4;
        this.f199new = z10;
        this.shareContent = str5;
        this.shareLink = str6;
        this.shareTitle = str7;
        this.hotTag = str8;
        this.bannerImage = imageModel2;
        this.bannerUrl = str9;
        this.superscriptType = num;
        this.superscript = str10;
        this.description = str11;
        this.hashTagBaseImage = imageModel3;
        this.hashTagBaseImageSwitch = z11;
        this.jumpUrl = str12;
    }

    @NotNull
    public final String component1() {
        return this.itemId;
    }

    @Nullable
    public final String component10() {
        return this.userCountDesc;
    }

    @Nullable
    public final String component11() {
        return this.countDesc;
    }

    public final boolean component12() {
        return this.f199new;
    }

    @Nullable
    public final String component13() {
        return this.shareContent;
    }

    @Nullable
    public final String component14() {
        return this.shareLink;
    }

    @Nullable
    public final String component15() {
        return this.shareTitle;
    }

    @Nullable
    public final String component16() {
        return this.hotTag;
    }

    @Nullable
    public final ImageModel component17() {
        return this.bannerImage;
    }

    @Nullable
    public final String component18() {
        return this.bannerUrl;
    }

    @Nullable
    public final Integer component19() {
        return this.superscriptType;
    }

    @NotNull
    public final String component2() {
        return this.name;
    }

    @Nullable
    public final String component20() {
        return this.superscript;
    }

    @Nullable
    public final String component21() {
        return this.description;
    }

    @Nullable
    public final ImageModel component22() {
        return this.hashTagBaseImage;
    }

    public final boolean component23() {
        return this.hashTagBaseImageSwitch;
    }

    @Nullable
    public final String component24() {
        return this.jumpUrl;
    }

    @Nullable
    public final ImageModel component3() {
        return this.backgroundImage;
    }

    @NotNull
    public final String component4() {
        return this.summary;
    }

    public final int component5() {
        return this.postCount;
    }

    @Nullable
    public final String component6() {
        return this.url;
    }

    @NotNull
    public final String component7() {
        return this.type;
    }

    @Nullable
    public final String component8() {
        return this.presetImageKey;
    }

    public final int component9() {
        return this.userCount;
    }

    @NotNull
    public final HashTag copy(@NotNull String itemId, @NotNull String name, @Nullable ImageModel imageModel, @NotNull String summary, int i10, @Nullable String str, @NotNull String type, @Nullable String str2, int i11, @Nullable String str3, @Nullable String str4, boolean z10, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable ImageModel imageModel2, @Nullable String str9, @Nullable Integer num, @Nullable String str10, @Nullable String str11, @Nullable ImageModel imageModel3, boolean z11, @Nullable String str12) {
        s.i(itemId, "itemId");
        s.i(name, "name");
        s.i(summary, "summary");
        s.i(type, "type");
        return new HashTag(itemId, name, imageModel, summary, i10, str, type, str2, i11, str3, str4, z10, str5, str6, str7, str8, imageModel2, str9, num, str10, str11, imageModel3, z11, str12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HashTag)) {
            return false;
        }
        HashTag hashTag = (HashTag) obj;
        return s.d(this.itemId, hashTag.itemId) && s.d(this.name, hashTag.name) && s.d(this.backgroundImage, hashTag.backgroundImage) && s.d(this.summary, hashTag.summary) && this.postCount == hashTag.postCount && s.d(this.url, hashTag.url) && s.d(this.type, hashTag.type) && s.d(this.presetImageKey, hashTag.presetImageKey) && this.userCount == hashTag.userCount && s.d(this.userCountDesc, hashTag.userCountDesc) && s.d(this.countDesc, hashTag.countDesc) && this.f199new == hashTag.f199new && s.d(this.shareContent, hashTag.shareContent) && s.d(this.shareLink, hashTag.shareLink) && s.d(this.shareTitle, hashTag.shareTitle) && s.d(this.hotTag, hashTag.hotTag) && s.d(this.bannerImage, hashTag.bannerImage) && s.d(this.bannerUrl, hashTag.bannerUrl) && s.d(this.superscriptType, hashTag.superscriptType) && s.d(this.superscript, hashTag.superscript) && s.d(this.description, hashTag.description) && s.d(this.hashTagBaseImage, hashTag.hashTagBaseImage) && this.hashTagBaseImageSwitch == hashTag.hashTagBaseImageSwitch && s.d(this.jumpUrl, hashTag.jumpUrl);
    }

    @Nullable
    public final ImageModel getBackgroundImage() {
        return this.backgroundImage;
    }

    @Nullable
    public final ImageModel getBannerImage() {
        return this.bannerImage;
    }

    @Nullable
    public final String getBannerUrl() {
        return this.bannerUrl;
    }

    public final int getCornerRes() {
        Integer num = this.superscriptType;
        if (num != null && num.intValue() == 1) {
            return R$mipmap.bg_new;
        }
        if (num != null && num.intValue() == 2) {
            return R$mipmap.bg_hot;
        }
        if (num != null && num.intValue() == 3) {
            return R$mipmap.bg_reward;
        }
        return 0;
    }

    @Nullable
    public final String getCountDesc() {
        return this.countDesc;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final ImageModel getHashTagBaseImage() {
        return this.hashTagBaseImage;
    }

    public final boolean getHashTagBaseImageSwitch() {
        return this.hashTagBaseImageSwitch;
    }

    @Nullable
    public final String getHotTag() {
        return this.hotTag;
    }

    @NotNull
    public final String getItemId() {
        return this.itemId;
    }

    @Nullable
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final boolean getNew() {
        return this.f199new;
    }

    public final int getPostCount() {
        return this.postCount;
    }

    @Nullable
    public final String getPresetImageKey() {
        return this.presetImageKey;
    }

    @Nullable
    public final String getShareContent() {
        return this.shareContent;
    }

    @Nullable
    public final String getShareLink() {
        return this.shareLink;
    }

    @Nullable
    public final String getShareTitle() {
        return this.shareTitle;
    }

    @NotNull
    public final HashTagSimpleModel getSimpleHashTag() {
        return new HashTagSimpleModel(this.itemId, this.name);
    }

    @NotNull
    public final String getSummary() {
        return this.summary;
    }

    @Nullable
    public final String getSuperscript() {
        return this.superscript;
    }

    @Nullable
    public final Integer getSuperscriptType() {
        return this.superscriptType;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public final int getUserCount() {
        return this.userCount;
    }

    @Nullable
    public final String getUserCountDesc() {
        return this.userCountDesc;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.itemId.hashCode() * 31) + this.name.hashCode()) * 31;
        ImageModel imageModel = this.backgroundImage;
        int hashCode2 = (((((hashCode + (imageModel == null ? 0 : imageModel.hashCode())) * 31) + this.summary.hashCode()) * 31) + this.postCount) * 31;
        String str = this.url;
        int hashCode3 = (((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.type.hashCode()) * 31;
        String str2 = this.presetImageKey;
        int hashCode4 = (((hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.userCount) * 31;
        String str3 = this.userCountDesc;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.countDesc;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        boolean z10 = this.f199new;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode6 + i10) * 31;
        String str5 = this.shareContent;
        int hashCode7 = (i11 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.shareLink;
        int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.shareTitle;
        int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.hotTag;
        int hashCode10 = (hashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        ImageModel imageModel2 = this.bannerImage;
        int hashCode11 = (hashCode10 + (imageModel2 == null ? 0 : imageModel2.hashCode())) * 31;
        String str9 = this.bannerUrl;
        int hashCode12 = (hashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Integer num = this.superscriptType;
        int hashCode13 = (hashCode12 + (num == null ? 0 : num.hashCode())) * 31;
        String str10 = this.superscript;
        int hashCode14 = (hashCode13 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.description;
        int hashCode15 = (hashCode14 + (str11 == null ? 0 : str11.hashCode())) * 31;
        ImageModel imageModel3 = this.hashTagBaseImage;
        int hashCode16 = (hashCode15 + (imageModel3 == null ? 0 : imageModel3.hashCode())) * 31;
        boolean z11 = this.hashTagBaseImageSwitch;
        int i12 = (hashCode16 + (z11 ? 1 : z11 ? 1 : 0)) * 31;
        String str12 = this.jumpUrl;
        return i12 + (str12 != null ? str12.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.itemId;
        String str2 = this.name;
        ImageModel imageModel = this.backgroundImage;
        String str3 = this.summary;
        int i10 = this.postCount;
        String str4 = this.url;
        String str5 = this.type;
        String str6 = this.presetImageKey;
        int i11 = this.userCount;
        String str7 = this.userCountDesc;
        String str8 = this.countDesc;
        boolean z10 = this.f199new;
        String str9 = this.shareContent;
        String str10 = this.shareLink;
        String str11 = this.shareTitle;
        String str12 = this.hotTag;
        ImageModel imageModel2 = this.bannerImage;
        String str13 = this.bannerUrl;
        Integer num = this.superscriptType;
        String str14 = this.superscript;
        String str15 = this.description;
        ImageModel imageModel3 = this.hashTagBaseImage;
        return "HashTag(itemId=" + str + ", name=" + str2 + ", backgroundImage=" + ((Object) imageModel) + ", summary=" + str3 + ", postCount=" + i10 + ", url=" + str4 + ", type=" + str5 + ", presetImageKey=" + str6 + ", userCount=" + i11 + ", userCountDesc=" + str7 + ", countDesc=" + str8 + ", new=" + z10 + ", shareContent=" + str9 + ", shareLink=" + str10 + ", shareTitle=" + str11 + ", hotTag=" + str12 + ", bannerImage=" + ((Object) imageModel2) + ", bannerUrl=" + str13 + ", superscriptType=" + ((Object) num) + ", superscript=" + str14 + ", description=" + str15 + ", hashTagBaseImage=" + ((Object) imageModel3) + ", hashTagBaseImageSwitch=" + this.hashTagBaseImageSwitch + ", jumpUrl=" + this.jumpUrl + ")";
    }

    public /* synthetic */ HashTag(String str, String str2, ImageModel imageModel, String str3, int i10, String str4, String str5, String str6, int i11, String str7, String str8, boolean z10, String str9, String str10, String str11, String str12, ImageModel imageModel2, String str13, Integer num, String str14, String str15, ImageModel imageModel3, boolean z11, String str16, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, imageModel, str3, i10, str4, str5, (i12 & 128) != 0 ? null : str6, i11, str7, str8, (i12 & 2048) != 0 ? false : z10, (i12 & 4096) != 0 ? "" : str9, (i12 & 8192) != 0 ? null : str10, (i12 & 16384) != 0 ? "" : str11, (32768 & i12) != 0 ? null : str12, imageModel2, str13, num, str14, str15, imageModel3, (4194304 & i12) != 0 ? false : z11, (i12 & 8388608) != 0 ? null : str16);
    }
}
