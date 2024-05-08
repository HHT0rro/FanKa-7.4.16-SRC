package com.cupidapp.live.liveshow.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveStickerViewInfoModel {

    @Nullable
    private String content;

    @Nullable
    private String defaultTipContent;

    @Nullable
    private final Integer height;

    /* renamed from: id, reason: collision with root package name */
    @Nullable
    private final String f15102id;

    @Nullable
    private final String imageUrl;

    @Nullable
    private final Integer type;

    @Nullable
    private final Integer width;

    @Nullable
    private final Double xval;

    @Nullable
    private final Double yval;

    public LiveStickerViewInfoModel(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3, @Nullable Double d10, @Nullable Double d11, @Nullable Integer num2, @Nullable Integer num3, @Nullable String str4) {
        this.f15102id = str;
        this.imageUrl = str2;
        this.type = num;
        this.content = str3;
        this.xval = d10;
        this.yval = d11;
        this.width = num2;
        this.height = num3;
        this.defaultTipContent = str4;
    }

    @Nullable
    public final String component1() {
        return this.f15102id;
    }

    @Nullable
    public final String component2() {
        return this.imageUrl;
    }

    @Nullable
    public final Integer component3() {
        return this.type;
    }

    @Nullable
    public final String component4() {
        return this.content;
    }

    @Nullable
    public final Double component5() {
        return this.xval;
    }

    @Nullable
    public final Double component6() {
        return this.yval;
    }

    @Nullable
    public final Integer component7() {
        return this.width;
    }

    @Nullable
    public final Integer component8() {
        return this.height;
    }

    @Nullable
    public final String component9() {
        return this.defaultTipContent;
    }

    @NotNull
    public final LiveStickerViewInfoModel copy(@Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable String str3, @Nullable Double d10, @Nullable Double d11, @Nullable Integer num2, @Nullable Integer num3, @Nullable String str4) {
        return new LiveStickerViewInfoModel(str, str2, num, str3, d10, d11, num2, num3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveStickerViewInfoModel)) {
            return false;
        }
        LiveStickerViewInfoModel liveStickerViewInfoModel = (LiveStickerViewInfoModel) obj;
        return s.d(this.f15102id, liveStickerViewInfoModel.f15102id) && s.d(this.imageUrl, liveStickerViewInfoModel.imageUrl) && s.d(this.type, liveStickerViewInfoModel.type) && s.d(this.content, liveStickerViewInfoModel.content) && s.d(this.xval, liveStickerViewInfoModel.xval) && s.d(this.yval, liveStickerViewInfoModel.yval) && s.d(this.width, liveStickerViewInfoModel.width) && s.d(this.height, liveStickerViewInfoModel.height) && s.d(this.defaultTipContent, liveStickerViewInfoModel.defaultTipContent);
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Nullable
    public final String getDefaultTipContent() {
        return this.defaultTipContent;
    }

    @Nullable
    public final Integer getHeight() {
        return this.height;
    }

    @Nullable
    public final String getId() {
        return this.f15102id;
    }

    @Nullable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Nullable
    public final Integer getType() {
        return this.type;
    }

    @Nullable
    public final Integer getWidth() {
        return this.width;
    }

    @Nullable
    public final Double getXval() {
        return this.xval;
    }

    @Nullable
    public final Double getYval() {
        return this.yval;
    }

    public int hashCode() {
        String str = this.f15102id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.imageUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.type;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.content;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Double d10 = this.xval;
        int hashCode5 = (hashCode4 + (d10 == null ? 0 : d10.hashCode())) * 31;
        Double d11 = this.yval;
        int hashCode6 = (hashCode5 + (d11 == null ? 0 : d11.hashCode())) * 31;
        Integer num2 = this.width;
        int hashCode7 = (hashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.height;
        int hashCode8 = (hashCode7 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str4 = this.defaultTipContent;
        return hashCode8 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setContent(@Nullable String str) {
        this.content = str;
    }

    public final void setDefaultTipContent(@Nullable String str) {
        this.defaultTipContent = str;
    }

    @NotNull
    public String toString() {
        String str = this.f15102id;
        String str2 = this.imageUrl;
        Integer num = this.type;
        String str3 = this.content;
        Double d10 = this.xval;
        Double d11 = this.yval;
        Integer num2 = this.width;
        Integer num3 = this.height;
        return "LiveStickerViewInfoModel(id=" + str + ", imageUrl=" + str2 + ", type=" + ((Object) num) + ", content=" + str3 + ", xval=" + ((Object) d10) + ", yval=" + ((Object) d11) + ", width=" + ((Object) num2) + ", height=" + ((Object) num3) + ", defaultTipContent=" + this.defaultTipContent + ")";
    }
}
