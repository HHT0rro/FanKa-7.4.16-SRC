package com.cupidapp.live.feed.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class TopShowGuideModel {

    @Nullable
    private final ImageModel icon;

    @Nullable
    private final String jumpUrl;

    @Nullable
    private final String title;

    public TopShowGuideModel(@Nullable ImageModel imageModel, @Nullable String str, @Nullable String str2) {
        this.icon = imageModel;
        this.title = str;
        this.jumpUrl = str2;
    }

    public static /* synthetic */ TopShowGuideModel copy$default(TopShowGuideModel topShowGuideModel, ImageModel imageModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = topShowGuideModel.icon;
        }
        if ((i10 & 2) != 0) {
            str = topShowGuideModel.title;
        }
        if ((i10 & 4) != 0) {
            str2 = topShowGuideModel.jumpUrl;
        }
        return topShowGuideModel.copy(imageModel, str, str2);
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
        return this.jumpUrl;
    }

    @NotNull
    public final TopShowGuideModel copy(@Nullable ImageModel imageModel, @Nullable String str, @Nullable String str2) {
        return new TopShowGuideModel(imageModel, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TopShowGuideModel)) {
            return false;
        }
        TopShowGuideModel topShowGuideModel = (TopShowGuideModel) obj;
        return s.d(this.icon, topShowGuideModel.icon) && s.d(this.title, topShowGuideModel.title) && s.d(this.jumpUrl, topShowGuideModel.jumpUrl);
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
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        ImageModel imageModel = this.icon;
        int hashCode = (imageModel == null ? 0 : imageModel.hashCode()) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.jumpUrl;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.icon;
        return "TopShowGuideModel(icon=" + ((Object) imageModel) + ", title=" + this.title + ", jumpUrl=" + this.jumpUrl + ")";
    }
}
