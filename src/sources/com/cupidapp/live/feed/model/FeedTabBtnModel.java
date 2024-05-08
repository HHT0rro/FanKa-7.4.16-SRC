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
public final class FeedTabBtnModel implements Serializable {

    @Nullable
    private final ImageModel iconImage;

    @Nullable
    private final String jumpUrl;

    @Nullable
    private final String tab;

    @Nullable
    private final String tabName;

    public FeedTabBtnModel(@Nullable String str, @Nullable ImageModel imageModel, @Nullable String str2, @Nullable String str3) {
        this.tabName = str;
        this.iconImage = imageModel;
        this.tab = str2;
        this.jumpUrl = str3;
    }

    public static /* synthetic */ FeedTabBtnModel copy$default(FeedTabBtnModel feedTabBtnModel, String str, ImageModel imageModel, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = feedTabBtnModel.tabName;
        }
        if ((i10 & 2) != 0) {
            imageModel = feedTabBtnModel.iconImage;
        }
        if ((i10 & 4) != 0) {
            str2 = feedTabBtnModel.tab;
        }
        if ((i10 & 8) != 0) {
            str3 = feedTabBtnModel.jumpUrl;
        }
        return feedTabBtnModel.copy(str, imageModel, str2, str3);
    }

    @Nullable
    public final String component1() {
        return this.tabName;
    }

    @Nullable
    public final ImageModel component2() {
        return this.iconImage;
    }

    @Nullable
    public final String component3() {
        return this.tab;
    }

    @Nullable
    public final String component4() {
        return this.jumpUrl;
    }

    @NotNull
    public final FeedTabBtnModel copy(@Nullable String str, @Nullable ImageModel imageModel, @Nullable String str2, @Nullable String str3) {
        return new FeedTabBtnModel(str, imageModel, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedTabBtnModel)) {
            return false;
        }
        FeedTabBtnModel feedTabBtnModel = (FeedTabBtnModel) obj;
        return s.d(this.tabName, feedTabBtnModel.tabName) && s.d(this.iconImage, feedTabBtnModel.iconImage) && s.d(this.tab, feedTabBtnModel.tab) && s.d(this.jumpUrl, feedTabBtnModel.jumpUrl);
    }

    @Nullable
    public final ImageModel getIconImage() {
        return this.iconImage;
    }

    @Nullable
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    @Nullable
    public final String getTab() {
        return this.tab;
    }

    @Nullable
    public final String getTabName() {
        return this.tabName;
    }

    public int hashCode() {
        String str = this.tabName;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        ImageModel imageModel = this.iconImage;
        int hashCode2 = (hashCode + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str2 = this.tab;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.jumpUrl;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.tabName;
        ImageModel imageModel = this.iconImage;
        return "FeedTabBtnModel(tabName=" + str + ", iconImage=" + ((Object) imageModel) + ", tab=" + this.tab + ", jumpUrl=" + this.jumpUrl + ")";
    }
}
