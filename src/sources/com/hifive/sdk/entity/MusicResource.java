package com.hifive.sdk.entity;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InitBean.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class MusicResource implements Serializable {

    @NotNull
    private final String accompanyUrl;

    @NotNull
    private String coverUrl;

    @NotNull
    private final String lyricUrl;

    @NotNull
    private final String majorUrl;

    @Nullable
    private String musicNo;

    @NotNull
    private final String outTradeNo;

    @Nullable
    private String type;

    public MusicResource(@NotNull String accompanyUrl, @NotNull String lyricUrl, @NotNull String majorUrl, @NotNull String outTradeNo, @Nullable String str, @Nullable String str2, @NotNull String coverUrl) {
        s.j(accompanyUrl, "accompanyUrl");
        s.j(lyricUrl, "lyricUrl");
        s.j(majorUrl, "majorUrl");
        s.j(outTradeNo, "outTradeNo");
        s.j(coverUrl, "coverUrl");
        this.accompanyUrl = accompanyUrl;
        this.lyricUrl = lyricUrl;
        this.majorUrl = majorUrl;
        this.outTradeNo = outTradeNo;
        this.type = str;
        this.musicNo = str2;
        this.coverUrl = coverUrl;
    }

    public static /* synthetic */ MusicResource copy$default(MusicResource musicResource, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = musicResource.accompanyUrl;
        }
        if ((i10 & 2) != 0) {
            str2 = musicResource.lyricUrl;
        }
        String str8 = str2;
        if ((i10 & 4) != 0) {
            str3 = musicResource.majorUrl;
        }
        String str9 = str3;
        if ((i10 & 8) != 0) {
            str4 = musicResource.outTradeNo;
        }
        String str10 = str4;
        if ((i10 & 16) != 0) {
            str5 = musicResource.type;
        }
        String str11 = str5;
        if ((i10 & 32) != 0) {
            str6 = musicResource.musicNo;
        }
        String str12 = str6;
        if ((i10 & 64) != 0) {
            str7 = musicResource.coverUrl;
        }
        return musicResource.copy(str, str8, str9, str10, str11, str12, str7);
    }

    @NotNull
    public final String component1() {
        return this.accompanyUrl;
    }

    @NotNull
    public final String component2() {
        return this.lyricUrl;
    }

    @NotNull
    public final String component3() {
        return this.majorUrl;
    }

    @NotNull
    public final String component4() {
        return this.outTradeNo;
    }

    @Nullable
    public final String component5() {
        return this.type;
    }

    @Nullable
    public final String component6() {
        return this.musicNo;
    }

    @NotNull
    public final String component7() {
        return this.coverUrl;
    }

    @NotNull
    public final MusicResource copy(@NotNull String accompanyUrl, @NotNull String lyricUrl, @NotNull String majorUrl, @NotNull String outTradeNo, @Nullable String str, @Nullable String str2, @NotNull String coverUrl) {
        s.j(accompanyUrl, "accompanyUrl");
        s.j(lyricUrl, "lyricUrl");
        s.j(majorUrl, "majorUrl");
        s.j(outTradeNo, "outTradeNo");
        s.j(coverUrl, "coverUrl");
        return new MusicResource(accompanyUrl, lyricUrl, majorUrl, outTradeNo, str, str2, coverUrl);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MusicResource)) {
            return false;
        }
        MusicResource musicResource = (MusicResource) obj;
        return s.d(this.accompanyUrl, musicResource.accompanyUrl) && s.d(this.lyricUrl, musicResource.lyricUrl) && s.d(this.majorUrl, musicResource.majorUrl) && s.d(this.outTradeNo, musicResource.outTradeNo) && s.d(this.type, musicResource.type) && s.d(this.musicNo, musicResource.musicNo) && s.d(this.coverUrl, musicResource.coverUrl);
    }

    @NotNull
    public final String getAccompanyUrl() {
        return this.accompanyUrl;
    }

    @NotNull
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @NotNull
    public final String getLyricUrl() {
        return this.lyricUrl;
    }

    @NotNull
    public final String getMajorUrl() {
        return this.majorUrl;
    }

    @Nullable
    public final String getMusicNo() {
        return this.musicNo;
    }

    @NotNull
    public final String getOutTradeNo() {
        return this.outTradeNo;
    }

    @Nullable
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.accompanyUrl;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.lyricUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.majorUrl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.outTradeNo;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.type;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.musicNo;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.coverUrl;
        return hashCode6 + (str7 != null ? str7.hashCode() : 0);
    }

    public final void setCoverUrl(@NotNull String str) {
        s.j(str, "<set-?>");
        this.coverUrl = str;
    }

    public final void setMusicNo(@Nullable String str) {
        this.musicNo = str;
    }

    public final void setType(@Nullable String str) {
        this.type = str;
    }

    @NotNull
    public String toString() {
        return "MusicResource(accompanyUrl=" + this.accompanyUrl + ", lyricUrl=" + this.lyricUrl + ", majorUrl=" + this.majorUrl + ", outTradeNo=" + this.outTradeNo + ", type=" + this.type + ", musicNo=" + this.musicNo + ", coverUrl=" + this.coverUrl + ")";
    }
}
