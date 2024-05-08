package com.cupidapp.live.base.network.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ProfileResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class InnerFunctionModel {

    @Nullable
    private final ImageModel icon;

    @NotNull
    private final String title;

    @Nullable
    private final String trackName;

    @NotNull
    private final String url;

    public InnerFunctionModel(@Nullable ImageModel imageModel, @NotNull String title, @Nullable String str, @NotNull String url) {
        s.i(title, "title");
        s.i(url, "url");
        this.icon = imageModel;
        this.title = title;
        this.trackName = str;
        this.url = url;
    }

    public static /* synthetic */ InnerFunctionModel copy$default(InnerFunctionModel innerFunctionModel, ImageModel imageModel, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = innerFunctionModel.icon;
        }
        if ((i10 & 2) != 0) {
            str = innerFunctionModel.title;
        }
        if ((i10 & 4) != 0) {
            str2 = innerFunctionModel.trackName;
        }
        if ((i10 & 8) != 0) {
            str3 = innerFunctionModel.url;
        }
        return innerFunctionModel.copy(imageModel, str, str2, str3);
    }

    @Nullable
    public final ImageModel component1() {
        return this.icon;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final String component3() {
        return this.trackName;
    }

    @NotNull
    public final String component4() {
        return this.url;
    }

    @NotNull
    public final InnerFunctionModel copy(@Nullable ImageModel imageModel, @NotNull String title, @Nullable String str, @NotNull String url) {
        s.i(title, "title");
        s.i(url, "url");
        return new InnerFunctionModel(imageModel, title, str, url);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InnerFunctionModel)) {
            return false;
        }
        InnerFunctionModel innerFunctionModel = (InnerFunctionModel) obj;
        return s.d(this.icon, innerFunctionModel.icon) && s.d(this.title, innerFunctionModel.title) && s.d(this.trackName, innerFunctionModel.trackName) && s.d(this.url, innerFunctionModel.url);
    }

    @Nullable
    public final ImageModel getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getTrackName() {
        return this.trackName;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        ImageModel imageModel = this.icon;
        int hashCode = (((imageModel == null ? 0 : imageModel.hashCode()) * 31) + this.title.hashCode()) * 31;
        String str = this.trackName;
        return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.url.hashCode();
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.icon;
        return "InnerFunctionModel(icon=" + ((Object) imageModel) + ", title=" + this.title + ", trackName=" + this.trackName + ", url=" + this.url + ")";
    }

    public /* synthetic */ InnerFunctionModel(ImageModel imageModel, String str, String str2, String str3, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : imageModel, str, str2, str3);
    }
}
