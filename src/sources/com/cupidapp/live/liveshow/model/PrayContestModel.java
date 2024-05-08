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
public final class PrayContestModel implements Serializable {
    private final int count;

    @NotNull
    private final ImageModel iconImage;

    @NotNull
    private String text;

    @NotNull
    private String type;

    @Nullable
    private final String url;

    @Nullable
    private final ImageModel userAvatar;

    @Nullable
    private final String userName;

    public PrayContestModel(@Nullable String str, @NotNull String text, @NotNull ImageModel iconImage, int i10, @Nullable ImageModel imageModel, @Nullable String str2, @NotNull String type) {
        s.i(text, "text");
        s.i(iconImage, "iconImage");
        s.i(type, "type");
        this.url = str;
        this.text = text;
        this.iconImage = iconImage;
        this.count = i10;
        this.userAvatar = imageModel;
        this.userName = str2;
        this.type = type;
    }

    public static /* synthetic */ PrayContestModel copy$default(PrayContestModel prayContestModel, String str, String str2, ImageModel imageModel, int i10, ImageModel imageModel2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = prayContestModel.url;
        }
        if ((i11 & 2) != 0) {
            str2 = prayContestModel.text;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            imageModel = prayContestModel.iconImage;
        }
        ImageModel imageModel3 = imageModel;
        if ((i11 & 8) != 0) {
            i10 = prayContestModel.count;
        }
        int i12 = i10;
        if ((i11 & 16) != 0) {
            imageModel2 = prayContestModel.userAvatar;
        }
        ImageModel imageModel4 = imageModel2;
        if ((i11 & 32) != 0) {
            str3 = prayContestModel.userName;
        }
        String str6 = str3;
        if ((i11 & 64) != 0) {
            str4 = prayContestModel.type;
        }
        return prayContestModel.copy(str, str5, imageModel3, i12, imageModel4, str6, str4);
    }

    @Nullable
    public final String component1() {
        return this.url;
    }

    @NotNull
    public final String component2() {
        return this.text;
    }

    @NotNull
    public final ImageModel component3() {
        return this.iconImage;
    }

    public final int component4() {
        return this.count;
    }

    @Nullable
    public final ImageModel component5() {
        return this.userAvatar;
    }

    @Nullable
    public final String component6() {
        return this.userName;
    }

    @NotNull
    public final String component7() {
        return this.type;
    }

    @NotNull
    public final PrayContestModel copy(@Nullable String str, @NotNull String text, @NotNull ImageModel iconImage, int i10, @Nullable ImageModel imageModel, @Nullable String str2, @NotNull String type) {
        s.i(text, "text");
        s.i(iconImage, "iconImage");
        s.i(type, "type");
        return new PrayContestModel(str, text, iconImage, i10, imageModel, str2, type);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrayContestModel)) {
            return false;
        }
        PrayContestModel prayContestModel = (PrayContestModel) obj;
        return s.d(this.url, prayContestModel.url) && s.d(this.text, prayContestModel.text) && s.d(this.iconImage, prayContestModel.iconImage) && this.count == prayContestModel.count && s.d(this.userAvatar, prayContestModel.userAvatar) && s.d(this.userName, prayContestModel.userName) && s.d(this.type, prayContestModel.type);
    }

    public final int getCount() {
        return this.count;
    }

    @NotNull
    public final ImageModel getIconImage() {
        return this.iconImage;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final ImageModel getUserAvatar() {
        return this.userAvatar;
    }

    @Nullable
    public final String getUserName() {
        return this.userName;
    }

    public int hashCode() {
        String str = this.url;
        int hashCode = (((((((str == null ? 0 : str.hashCode()) * 31) + this.text.hashCode()) * 31) + this.iconImage.hashCode()) * 31) + this.count) * 31;
        ImageModel imageModel = this.userAvatar;
        int hashCode2 = (hashCode + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str2 = this.userName;
        return ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.type.hashCode();
    }

    public final void setText(@NotNull String str) {
        s.i(str, "<set-?>");
        this.text = str;
    }

    public final void setType(@NotNull String str) {
        s.i(str, "<set-?>");
        this.type = str;
    }

    @NotNull
    public String toString() {
        String str = this.url;
        String str2 = this.text;
        ImageModel imageModel = this.iconImage;
        int i10 = this.count;
        ImageModel imageModel2 = this.userAvatar;
        return "PrayContestModel(url=" + str + ", text=" + str2 + ", iconImage=" + ((Object) imageModel) + ", count=" + i10 + ", userAvatar=" + ((Object) imageModel2) + ", userName=" + this.userName + ", type=" + this.type + ")";
    }
}
