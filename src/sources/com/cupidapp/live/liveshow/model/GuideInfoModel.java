package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class GuideInfoModel {

    @Nullable
    private final String buttonName;

    @Nullable
    private final ImageModel iconImage;

    @Nullable
    private final String message;

    @Nullable
    private final Integer showSec;

    @Nullable
    private final String title;

    @Nullable
    private final String type;

    @Nullable
    private final String url;

    public GuideInfoModel() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public GuideInfoModel(@Nullable String str, @Nullable String str2, @Nullable ImageModel imageModel, @Nullable String str3, @Nullable String str4, @Nullable Integer num, @Nullable String str5) {
        this.title = str;
        this.message = str2;
        this.iconImage = imageModel;
        this.buttonName = str3;
        this.url = str4;
        this.showSec = num;
        this.type = str5;
    }

    public static /* synthetic */ GuideInfoModel copy$default(GuideInfoModel guideInfoModel, String str, String str2, ImageModel imageModel, String str3, String str4, Integer num, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = guideInfoModel.title;
        }
        if ((i10 & 2) != 0) {
            str2 = guideInfoModel.message;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            imageModel = guideInfoModel.iconImage;
        }
        ImageModel imageModel2 = imageModel;
        if ((i10 & 8) != 0) {
            str3 = guideInfoModel.buttonName;
        }
        String str7 = str3;
        if ((i10 & 16) != 0) {
            str4 = guideInfoModel.url;
        }
        String str8 = str4;
        if ((i10 & 32) != 0) {
            num = guideInfoModel.showSec;
        }
        Integer num2 = num;
        if ((i10 & 64) != 0) {
            str5 = guideInfoModel.type;
        }
        return guideInfoModel.copy(str, str6, imageModel2, str7, str8, num2, str5);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.message;
    }

    @Nullable
    public final ImageModel component3() {
        return this.iconImage;
    }

    @Nullable
    public final String component4() {
        return this.buttonName;
    }

    @Nullable
    public final String component5() {
        return this.url;
    }

    @Nullable
    public final Integer component6() {
        return this.showSec;
    }

    @Nullable
    public final String component7() {
        return this.type;
    }

    @NotNull
    public final GuideInfoModel copy(@Nullable String str, @Nullable String str2, @Nullable ImageModel imageModel, @Nullable String str3, @Nullable String str4, @Nullable Integer num, @Nullable String str5) {
        return new GuideInfoModel(str, str2, imageModel, str3, str4, num, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GuideInfoModel)) {
            return false;
        }
        GuideInfoModel guideInfoModel = (GuideInfoModel) obj;
        return s.d(this.title, guideInfoModel.title) && s.d(this.message, guideInfoModel.message) && s.d(this.iconImage, guideInfoModel.iconImage) && s.d(this.buttonName, guideInfoModel.buttonName) && s.d(this.url, guideInfoModel.url) && s.d(this.showSec, guideInfoModel.showSec) && s.d(this.type, guideInfoModel.type);
    }

    @Nullable
    public final String getButtonName() {
        return this.buttonName;
    }

    @Nullable
    public final ImageModel getIconImage() {
        return this.iconImage;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final Integer getShowSec() {
        return this.showSec;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.message;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        ImageModel imageModel = this.iconImage;
        int hashCode3 = (hashCode2 + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str3 = this.buttonName;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.url;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.showSec;
        int hashCode6 = (hashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        String str5 = this.type;
        return hashCode6 + (str5 != null ? str5.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.message;
        ImageModel imageModel = this.iconImage;
        String str3 = this.buttonName;
        String str4 = this.url;
        Integer num = this.showSec;
        return "GuideInfoModel(title=" + str + ", message=" + str2 + ", iconImage=" + ((Object) imageModel) + ", buttonName=" + str3 + ", url=" + str4 + ", showSec=" + ((Object) num) + ", type=" + this.type + ")";
    }

    public /* synthetic */ GuideInfoModel(String str, String str2, ImageModel imageModel, String str3, String str4, Integer num, String str5, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : imageModel, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : str4, (i10 & 32) != 0 ? null : num, (i10 & 64) != 0 ? null : str5);
    }
}
