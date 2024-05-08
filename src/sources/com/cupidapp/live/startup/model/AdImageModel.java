package com.cupidapp.live.startup.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ApiAdModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AdImageModel {
    private final int height;

    @NotNull
    private final String url;
    private final int width;

    public AdImageModel(int i10, int i11, @NotNull String url) {
        s.i(url, "url");
        this.width = i10;
        this.height = i11;
        this.url = url;
    }

    public static /* synthetic */ AdImageModel copy$default(AdImageModel adImageModel, int i10, int i11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = adImageModel.width;
        }
        if ((i12 & 2) != 0) {
            i11 = adImageModel.height;
        }
        if ((i12 & 4) != 0) {
            str = adImageModel.url;
        }
        return adImageModel.copy(i10, i11, str);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    @NotNull
    public final String component3() {
        return this.url;
    }

    @NotNull
    public final AdImageModel copy(int i10, int i11, @NotNull String url) {
        s.i(url, "url");
        return new AdImageModel(i10, i11, url);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdImageModel)) {
            return false;
        }
        AdImageModel adImageModel = (AdImageModel) obj;
        return this.width == adImageModel.width && this.height == adImageModel.height && s.d(this.url, adImageModel.url);
    }

    public final int getHeight() {
        return this.height;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((this.width * 31) + this.height) * 31) + this.url.hashCode();
    }

    @NotNull
    public String toString() {
        return "AdImageModel(width=" + this.width + ", height=" + this.height + ", url=" + this.url + ")";
    }
}
