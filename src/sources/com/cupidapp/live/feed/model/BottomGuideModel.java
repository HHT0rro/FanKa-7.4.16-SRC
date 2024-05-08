package com.cupidapp.live.feed.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class BottomGuideModel implements Serializable {

    @Nullable
    private final ImageModel icon;

    @Nullable
    private final String jumpUrl;

    @Nullable
    private final String subTitle;

    @Nullable
    private final String title;

    public BottomGuideModel(@Nullable ImageModel imageModel, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.icon = imageModel;
        this.title = str;
        this.subTitle = str2;
        this.jumpUrl = str3;
    }

    public static /* synthetic */ BottomGuideModel copy$default(BottomGuideModel bottomGuideModel, ImageModel imageModel, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = bottomGuideModel.icon;
        }
        if ((i10 & 2) != 0) {
            str = bottomGuideModel.title;
        }
        if ((i10 & 4) != 0) {
            str2 = bottomGuideModel.subTitle;
        }
        if ((i10 & 8) != 0) {
            str3 = bottomGuideModel.jumpUrl;
        }
        return bottomGuideModel.copy(imageModel, str, str2, str3);
    }

    @Nullable
    public final ImageModel component1() {
        return this.icon;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.subTitle;
    }

    @Nullable
    public final String component4() {
        return this.jumpUrl;
    }

    @NotNull
    public final BottomGuideModel copy(@Nullable ImageModel imageModel, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        return new BottomGuideModel(imageModel, str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BottomGuideModel)) {
            return false;
        }
        BottomGuideModel bottomGuideModel = (BottomGuideModel) obj;
        return s.d(this.icon, bottomGuideModel.icon) && s.d(this.title, bottomGuideModel.title) && s.d(this.subTitle, bottomGuideModel.subTitle) && s.d(this.jumpUrl, bottomGuideModel.jumpUrl);
    }

    @Nullable
    public final ImageModel getIcon() {
        return this.icon;
    }

    @Nullable
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @Nullable
    public final String getSubTitle() {
        return this.subTitle;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        ImageModel imageModel = this.icon;
        int hashCode = (imageModel == null ? 0 : imageModel.hashCode()) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.subTitle;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.jumpUrl;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.icon;
        return "BottomGuideModel(icon=" + ((Object) imageModel) + ", title=" + this.title + ", subTitle=" + this.subTitle + ", jumpUrl=" + this.jumpUrl + ")";
    }
}
