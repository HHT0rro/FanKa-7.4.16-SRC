package com.cupidapp.live.feed.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedTopIntroModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedTopIntroModel {

    @Nullable
    private final String buttonName;

    @Nullable
    private final String desc;

    @Nullable
    private final ImageModel image;

    @Nullable
    private final String jumpUrl;

    @Nullable
    private final String note;

    @Nullable
    private final String title;

    public FeedTopIntroModel(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable ImageModel imageModel) {
        this.buttonName = str;
        this.desc = str2;
        this.jumpUrl = str3;
        this.note = str4;
        this.title = str5;
        this.image = imageModel;
    }

    public static /* synthetic */ FeedTopIntroModel copy$default(FeedTopIntroModel feedTopIntroModel, String str, String str2, String str3, String str4, String str5, ImageModel imageModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = feedTopIntroModel.buttonName;
        }
        if ((i10 & 2) != 0) {
            str2 = feedTopIntroModel.desc;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = feedTopIntroModel.jumpUrl;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = feedTopIntroModel.note;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            str5 = feedTopIntroModel.title;
        }
        String str9 = str5;
        if ((i10 & 32) != 0) {
            imageModel = feedTopIntroModel.image;
        }
        return feedTopIntroModel.copy(str, str6, str7, str8, str9, imageModel);
    }

    @Nullable
    public final String component1() {
        return this.buttonName;
    }

    @Nullable
    public final String component2() {
        return this.desc;
    }

    @Nullable
    public final String component3() {
        return this.jumpUrl;
    }

    @Nullable
    public final String component4() {
        return this.note;
    }

    @Nullable
    public final String component5() {
        return this.title;
    }

    @Nullable
    public final ImageModel component6() {
        return this.image;
    }

    @NotNull
    public final FeedTopIntroModel copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable ImageModel imageModel) {
        return new FeedTopIntroModel(str, str2, str3, str4, str5, imageModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedTopIntroModel)) {
            return false;
        }
        FeedTopIntroModel feedTopIntroModel = (FeedTopIntroModel) obj;
        return s.d(this.buttonName, feedTopIntroModel.buttonName) && s.d(this.desc, feedTopIntroModel.desc) && s.d(this.jumpUrl, feedTopIntroModel.jumpUrl) && s.d(this.note, feedTopIntroModel.note) && s.d(this.title, feedTopIntroModel.title) && s.d(this.image, feedTopIntroModel.image);
    }

    @Nullable
    public final String getButtonName() {
        return this.buttonName;
    }

    @Nullable
    public final String getDesc() {
        return this.desc;
    }

    @Nullable
    public final ImageModel getImage() {
        return this.image;
    }

    @Nullable
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @Nullable
    public final String getNote() {
        return this.note;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.buttonName;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.desc;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.jumpUrl;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.note;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.title;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        ImageModel imageModel = this.image;
        return hashCode5 + (imageModel != null ? imageModel.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "FeedTopIntroModel(buttonName=" + this.buttonName + ", desc=" + this.desc + ", jumpUrl=" + this.jumpUrl + ", note=" + this.note + ", title=" + this.title + ", image=" + ((Object) this.image) + ")";
    }
}
