package com.cupidapp.live.base.network.download;

import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DownloadManager.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKDownloadModel {

    @Nullable
    private final String name;

    @NotNull
    private final String url;

    public FKDownloadModel(@Nullable String str, @NotNull String url) {
        s.i(url, "url");
        this.name = str;
        this.url = url;
    }

    public static /* synthetic */ FKDownloadModel copy$default(FKDownloadModel fKDownloadModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = fKDownloadModel.name;
        }
        if ((i10 & 2) != 0) {
            str2 = fKDownloadModel.url;
        }
        return fKDownloadModel.copy(str, str2);
    }

    @Nullable
    public final String component1() {
        return this.name;
    }

    @NotNull
    public final String component2() {
        return this.url;
    }

    @NotNull
    public final FKDownloadModel copy(@Nullable String str, @NotNull String url) {
        s.i(url, "url");
        return new FKDownloadModel(str, url);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKDownloadModel)) {
            return false;
        }
        FKDownloadModel fKDownloadModel = (FKDownloadModel) obj;
        return s.d(this.name, fKDownloadModel.name) && s.d(this.url, fKDownloadModel.url);
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.name;
        return ((str == null ? 0 : str.hashCode()) * 31) + this.url.hashCode();
    }

    @NotNull
    public String toString() {
        return "FKDownloadModel(name=" + this.name + ", url=" + this.url + ")";
    }
}
