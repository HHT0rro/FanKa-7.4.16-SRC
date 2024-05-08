package com.cupidapp.live.base.share.helper;

import java.io.Serializable;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ShareBuilder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class WebShareConfig implements Serializable {

    @Nullable
    private final String description;

    @Nullable
    private final String thumbUrl;

    @Nullable
    private final String title;

    @Nullable
    private final String url;

    public WebShareConfig(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.url = str;
        this.title = str2;
        this.description = str3;
        this.thumbUrl = str4;
    }

    public static /* synthetic */ WebShareConfig copy$default(WebShareConfig webShareConfig, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = webShareConfig.url;
        }
        if ((i10 & 2) != 0) {
            str2 = webShareConfig.title;
        }
        if ((i10 & 4) != 0) {
            str3 = webShareConfig.description;
        }
        if ((i10 & 8) != 0) {
            str4 = webShareConfig.thumbUrl;
        }
        return webShareConfig.copy(str, str2, str3, str4);
    }

    @Nullable
    public final String component1() {
        return this.url;
    }

    @Nullable
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.description;
    }

    @Nullable
    public final String component4() {
        return this.thumbUrl;
    }

    @NotNull
    public final WebShareConfig copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        return new WebShareConfig(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebShareConfig)) {
            return false;
        }
        WebShareConfig webShareConfig = (WebShareConfig) obj;
        return s.d(this.url, webShareConfig.url) && s.d(this.title, webShareConfig.title) && s.d(this.description, webShareConfig.description) && s.d(this.thumbUrl, webShareConfig.thumbUrl);
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getThumbUrl() {
        return this.thumbUrl;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.url;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.thumbUrl;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "WebShareConfig(url=" + this.url + ", title=" + this.title + ", description=" + this.description + ", thumbUrl=" + this.thumbUrl + ")";
    }
}
