package com.hifive.sdk.entity;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InitBean.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Cover {

    @NotNull
    private final String size;

    @NotNull
    private final String url;

    public Cover(@NotNull String size, @NotNull String url) {
        s.j(size, "size");
        s.j(url, "url");
        this.size = size;
        this.url = url;
    }

    public static /* synthetic */ Cover copy$default(Cover cover, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = cover.size;
        }
        if ((i10 & 2) != 0) {
            str2 = cover.url;
        }
        return cover.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.size;
    }

    @NotNull
    public final String component2() {
        return this.url;
    }

    @NotNull
    public final Cover copy(@NotNull String size, @NotNull String url) {
        s.j(size, "size");
        s.j(url, "url");
        return new Cover(size, url);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cover)) {
            return false;
        }
        Cover cover = (Cover) obj;
        return s.d(this.size, cover.size) && s.d(this.url, cover.url);
    }

    @NotNull
    public final String getSize() {
        return this.size;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.size;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.url;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Cover(size=" + this.size + ", url=" + this.url + ")";
    }
}
