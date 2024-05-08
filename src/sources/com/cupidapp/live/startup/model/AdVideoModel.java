package com.cupidapp.live.startup.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ApiAdModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AdVideoModel {
    private final int height;

    @Nullable
    private final String url;
    private final int width;

    public AdVideoModel(int i10, int i11, @Nullable String str) {
        this.width = i10;
        this.height = i11;
        this.url = str;
    }

    public static /* synthetic */ AdVideoModel copy$default(AdVideoModel adVideoModel, int i10, int i11, String str, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = adVideoModel.width;
        }
        if ((i12 & 2) != 0) {
            i11 = adVideoModel.height;
        }
        if ((i12 & 4) != 0) {
            str = adVideoModel.url;
        }
        return adVideoModel.copy(i10, i11, str);
    }

    public final int component1() {
        return this.width;
    }

    public final int component2() {
        return this.height;
    }

    @Nullable
    public final String component3() {
        return this.url;
    }

    @NotNull
    public final AdVideoModel copy(int i10, int i11, @Nullable String str) {
        return new AdVideoModel(i10, i11, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdVideoModel)) {
            return false;
        }
        AdVideoModel adVideoModel = (AdVideoModel) obj;
        return this.width == adVideoModel.width && this.height == adVideoModel.height && s.d(this.url, adVideoModel.url);
    }

    public final int getHeight() {
        return this.height;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int i10 = ((this.width * 31) + this.height) * 31;
        String str = this.url;
        return i10 + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        return "AdVideoModel(width=" + this.width + ", height=" + this.height + ", url=" + this.url + ")";
    }

    public /* synthetic */ AdVideoModel(int i10, int i11, String str, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, i11, (i12 & 4) != 0 ? null : str);
    }
}
