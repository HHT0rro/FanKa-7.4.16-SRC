package com.hifive.sdk.entity;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InitBean.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class CoverInfo {

    @NotNull
    private final String size;

    @NotNull
    private final String url;

    public CoverInfo(@NotNull String size, @NotNull String url) {
        s.j(size, "size");
        s.j(url, "url");
        this.size = size;
        this.url = url;
    }

    public static /* synthetic */ CoverInfo copy$default(CoverInfo coverInfo, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = coverInfo.size;
        }
        if ((i10 & 2) != 0) {
            str2 = coverInfo.url;
        }
        return coverInfo.copy(str, str2);
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
    public final CoverInfo copy(@NotNull String size, @NotNull String url) {
        s.j(size, "size");
        s.j(url, "url");
        return new CoverInfo(size, url);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CoverInfo)) {
            return false;
        }
        CoverInfo coverInfo = (CoverInfo) obj;
        return s.d(this.size, coverInfo.size) && s.d(this.url, coverInfo.url);
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
        return "CoverInfo(size=" + this.size + ", url=" + this.url + ")";
    }
}
