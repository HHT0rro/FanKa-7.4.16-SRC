package com.hifive.sdk.entity;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InitBean.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class RecommendMusic implements Serializable {

    @NotNull
    private final String albumName;

    @NotNull
    private final String dayTime;

    @NotNull
    private final String mediaAction;

    @NotNull
    private final String musicName;

    @NotNull
    private final String musicNo;

    @NotNull
    private final String musicSinger;

    public RecommendMusic(@NotNull String albumName, @NotNull String dayTime, @NotNull String mediaAction, @NotNull String musicName, @NotNull String musicNo, @NotNull String musicSinger) {
        s.j(albumName, "albumName");
        s.j(dayTime, "dayTime");
        s.j(mediaAction, "mediaAction");
        s.j(musicName, "musicName");
        s.j(musicNo, "musicNo");
        s.j(musicSinger, "musicSinger");
        this.albumName = albumName;
        this.dayTime = dayTime;
        this.mediaAction = mediaAction;
        this.musicName = musicName;
        this.musicNo = musicNo;
        this.musicSinger = musicSinger;
    }

    public static /* synthetic */ RecommendMusic copy$default(RecommendMusic recommendMusic, String str, String str2, String str3, String str4, String str5, String str6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = recommendMusic.albumName;
        }
        if ((i10 & 2) != 0) {
            str2 = recommendMusic.dayTime;
        }
        String str7 = str2;
        if ((i10 & 4) != 0) {
            str3 = recommendMusic.mediaAction;
        }
        String str8 = str3;
        if ((i10 & 8) != 0) {
            str4 = recommendMusic.musicName;
        }
        String str9 = str4;
        if ((i10 & 16) != 0) {
            str5 = recommendMusic.musicNo;
        }
        String str10 = str5;
        if ((i10 & 32) != 0) {
            str6 = recommendMusic.musicSinger;
        }
        return recommendMusic.copy(str, str7, str8, str9, str10, str6);
    }

    @NotNull
    public final String component1() {
        return this.albumName;
    }

    @NotNull
    public final String component2() {
        return this.dayTime;
    }

    @NotNull
    public final String component3() {
        return this.mediaAction;
    }

    @NotNull
    public final String component4() {
        return this.musicName;
    }

    @NotNull
    public final String component5() {
        return this.musicNo;
    }

    @NotNull
    public final String component6() {
        return this.musicSinger;
    }

    @NotNull
    public final RecommendMusic copy(@NotNull String albumName, @NotNull String dayTime, @NotNull String mediaAction, @NotNull String musicName, @NotNull String musicNo, @NotNull String musicSinger) {
        s.j(albumName, "albumName");
        s.j(dayTime, "dayTime");
        s.j(mediaAction, "mediaAction");
        s.j(musicName, "musicName");
        s.j(musicNo, "musicNo");
        s.j(musicSinger, "musicSinger");
        return new RecommendMusic(albumName, dayTime, mediaAction, musicName, musicNo, musicSinger);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecommendMusic)) {
            return false;
        }
        RecommendMusic recommendMusic = (RecommendMusic) obj;
        return s.d(this.albumName, recommendMusic.albumName) && s.d(this.dayTime, recommendMusic.dayTime) && s.d(this.mediaAction, recommendMusic.mediaAction) && s.d(this.musicName, recommendMusic.musicName) && s.d(this.musicNo, recommendMusic.musicNo) && s.d(this.musicSinger, recommendMusic.musicSinger);
    }

    @NotNull
    public final String getAlbumName() {
        return this.albumName;
    }

    @NotNull
    public final String getDayTime() {
        return this.dayTime;
    }

    @NotNull
    public final String getMediaAction() {
        return this.mediaAction;
    }

    @NotNull
    public final String getMusicName() {
        return this.musicName;
    }

    @NotNull
    public final String getMusicNo() {
        return this.musicNo;
    }

    @NotNull
    public final String getMusicSinger() {
        return this.musicSinger;
    }

    public int hashCode() {
        String str = this.albumName;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.dayTime;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.mediaAction;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.musicName;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.musicNo;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.musicSinger;
        return hashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "RecommendMusic(albumName=" + this.albumName + ", dayTime=" + this.dayTime + ", mediaAction=" + this.mediaAction + ", musicName=" + this.musicName + ", musicNo=" + this.musicNo + ", musicSinger=" + this.musicSinger + ")";
    }
}
