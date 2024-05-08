package com.cupidapp.live.feed.adapter;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedClassifyAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FeedClassifyModel implements Serializable {

    @NotNull
    private final ImageModel iconImage;

    @NotNull
    private final String tag;

    @NotNull
    private final String tagName;

    @Nullable
    private final String url;

    public FeedClassifyModel(@NotNull ImageModel iconImage, @NotNull String tagName, @Nullable String str, @NotNull String tag) {
        s.i(iconImage, "iconImage");
        s.i(tagName, "tagName");
        s.i(tag, "tag");
        this.iconImage = iconImage;
        this.tagName = tagName;
        this.url = str;
        this.tag = tag;
    }

    public static /* synthetic */ FeedClassifyModel copy$default(FeedClassifyModel feedClassifyModel, ImageModel imageModel, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = feedClassifyModel.iconImage;
        }
        if ((i10 & 2) != 0) {
            str = feedClassifyModel.tagName;
        }
        if ((i10 & 4) != 0) {
            str2 = feedClassifyModel.url;
        }
        if ((i10 & 8) != 0) {
            str3 = feedClassifyModel.tag;
        }
        return feedClassifyModel.copy(imageModel, str, str2, str3);
    }

    @NotNull
    public final ImageModel component1() {
        return this.iconImage;
    }

    @NotNull
    public final String component2() {
        return this.tagName;
    }

    @Nullable
    public final String component3() {
        return this.url;
    }

    @NotNull
    public final String component4() {
        return this.tag;
    }

    @NotNull
    public final FeedClassifyModel copy(@NotNull ImageModel iconImage, @NotNull String tagName, @Nullable String str, @NotNull String tag) {
        s.i(iconImage, "iconImage");
        s.i(tagName, "tagName");
        s.i(tag, "tag");
        return new FeedClassifyModel(iconImage, tagName, str, tag);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedClassifyModel)) {
            return false;
        }
        FeedClassifyModel feedClassifyModel = (FeedClassifyModel) obj;
        return s.d(this.iconImage, feedClassifyModel.iconImage) && s.d(this.tagName, feedClassifyModel.tagName) && s.d(this.url, feedClassifyModel.url) && s.d(this.tag, feedClassifyModel.tag);
    }

    @NotNull
    public final ImageModel getIconImage() {
        return this.iconImage;
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    @NotNull
    public final String getTagName() {
        return this.tagName;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int hashCode = ((this.iconImage.hashCode() * 31) + this.tagName.hashCode()) * 31;
        String str = this.url;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.tag.hashCode();
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.iconImage;
        return "FeedClassifyModel(iconImage=" + ((Object) imageModel) + ", tagName=" + this.tagName + ", url=" + this.url + ", tag=" + this.tag + ")";
    }
}
