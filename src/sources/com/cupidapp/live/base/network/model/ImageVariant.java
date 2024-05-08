package com.cupidapp.live.base.network.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ImageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ImageVariant implements Serializable {
    private final int heigth;

    @NotNull
    private final String url;
    private final int width;

    public ImageVariant(int i10, int i11, @NotNull String url) {
        s.i(url, "url");
        this.width = i10;
        this.heigth = i11;
        this.url = url;
    }

    public static /* synthetic */ ImageVariant copy$default(ImageVariant imageVariant, int i10, int i11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = imageVariant.width;
        }
        if ((i12 & 2) != 0) {
            i11 = imageVariant.heigth;
        }
        if ((i12 & 4) != 0) {
            str = imageVariant.url;
        }
        return imageVariant.copy(i10, i11, str);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.heigth;
    }

    @NotNull
    public final String component3() {
        return this.url;
    }

    @NotNull
    public final ImageVariant copy(int i10, int i11, @NotNull String url) {
        s.i(url, "url");
        return new ImageVariant(i10, i11, url);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageVariant)) {
            return false;
        }
        ImageVariant imageVariant = (ImageVariant) obj;
        return this.width == imageVariant.width && this.heigth == imageVariant.heigth && s.d(this.url, imageVariant.url);
    }

    public final int getHeigth() {
        return this.heigth;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((this.width * 31) + this.heigth) * 31) + this.url.hashCode();
    }

    @NotNull
    public String toString() {
        return "ImageVariant(width=" + this.width + ", heigth=" + this.heigth + ", url=" + this.url + ")";
    }
}
