package com.cupidapp.live.feed.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FeedTagModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class CustomTag implements Serializable {

    @Nullable
    private final String backgroundColor;

    @Nullable
    private final String foregroundColor;

    @Nullable
    private final ImageModel icon;

    @NotNull
    private final String itemId;

    @NotNull
    private final String label;

    @Nullable
    private final String url;

    public CustomTag(@NotNull String itemId, @NotNull String label, @Nullable ImageModel imageModel, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        s.i(itemId, "itemId");
        s.i(label, "label");
        this.itemId = itemId;
        this.label = label;
        this.icon = imageModel;
        this.url = str;
        this.foregroundColor = str2;
        this.backgroundColor = str3;
    }

    public static /* synthetic */ CustomTag copy$default(CustomTag customTag, String str, String str2, ImageModel imageModel, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = customTag.itemId;
        }
        if ((i10 & 2) != 0) {
            str2 = customTag.label;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            imageModel = customTag.icon;
        }
        ImageModel imageModel2 = imageModel;
        if ((i10 & 8) != 0) {
            str3 = customTag.url;
        }
        String str7 = str3;
        if ((i10 & 16) != 0) {
            str4 = customTag.foregroundColor;
        }
        String str8 = str4;
        if ((i10 & 32) != 0) {
            str5 = customTag.backgroundColor;
        }
        return customTag.copy(str, str6, imageModel2, str7, str8, str5);
    }

    @NotNull
    public final String component1() {
        return this.itemId;
    }

    @NotNull
    public final String component2() {
        return this.label;
    }

    @Nullable
    public final ImageModel component3() {
        return this.icon;
    }

    @Nullable
    public final String component4() {
        return this.url;
    }

    @Nullable
    public final String component5() {
        return this.foregroundColor;
    }

    @Nullable
    public final String component6() {
        return this.backgroundColor;
    }

    @NotNull
    public final CustomTag copy(@NotNull String itemId, @NotNull String label, @Nullable ImageModel imageModel, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        s.i(itemId, "itemId");
        s.i(label, "label");
        return new CustomTag(itemId, label, imageModel, str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomTag)) {
            return false;
        }
        CustomTag customTag = (CustomTag) obj;
        return s.d(this.itemId, customTag.itemId) && s.d(this.label, customTag.label) && s.d(this.icon, customTag.icon) && s.d(this.url, customTag.url) && s.d(this.foregroundColor, customTag.foregroundColor) && s.d(this.backgroundColor, customTag.backgroundColor);
    }

    @Nullable
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public final String getForegroundColor() {
        return this.foregroundColor;
    }

    @Nullable
    public final ImageModel getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getItemId() {
        return this.itemId;
    }

    @NotNull
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int hashCode = ((this.itemId.hashCode() * 31) + this.label.hashCode()) * 31;
        ImageModel imageModel = this.icon;
        int hashCode2 = (hashCode + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        String str = this.url;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.foregroundColor;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.backgroundColor;
        return hashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.itemId;
        String str2 = this.label;
        ImageModel imageModel = this.icon;
        return "CustomTag(itemId=" + str + ", label=" + str2 + ", icon=" + ((Object) imageModel) + ", url=" + this.url + ", foregroundColor=" + this.foregroundColor + ", backgroundColor=" + this.backgroundColor + ")";
    }
}
