package com.hifive.sdk.entity;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InitBean.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class SearchMusicInfo implements Serializable {

    @NotNull
    private final String albumName;

    @NotNull
    private final String coverUrl;
    private final int duration;

    @Nullable
    private Boolean isExpend;

    @Nullable
    private Boolean isKing;
    private boolean isPlayType;

    @Nullable
    private Boolean isPlaying;

    @NotNull
    private final String mediaAction;

    @NotNull
    private final String musicName;

    @NotNull
    private final String musicNo;

    @NotNull
    private final String musicSinger;

    public SearchMusicInfo(@NotNull String albumName, int i10, @NotNull String mediaAction, @NotNull String musicName, @NotNull String musicNo, @NotNull String musicSinger, @NotNull String coverUrl, boolean z10, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3) {
        s.j(albumName, "albumName");
        s.j(mediaAction, "mediaAction");
        s.j(musicName, "musicName");
        s.j(musicNo, "musicNo");
        s.j(musicSinger, "musicSinger");
        s.j(coverUrl, "coverUrl");
        this.albumName = albumName;
        this.duration = i10;
        this.mediaAction = mediaAction;
        this.musicName = musicName;
        this.musicNo = musicNo;
        this.musicSinger = musicSinger;
        this.coverUrl = coverUrl;
        this.isPlayType = z10;
        this.isPlaying = bool;
        this.isKing = bool2;
        this.isExpend = bool3;
    }

    @NotNull
    public final String component1() {
        return this.albumName;
    }

    @Nullable
    public final Boolean component10() {
        return this.isKing;
    }

    @Nullable
    public final Boolean component11() {
        return this.isExpend;
    }

    public final int component2() {
        return this.duration;
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
    public final String component7() {
        return this.coverUrl;
    }

    public final boolean component8() {
        return this.isPlayType;
    }

    @Nullable
    public final Boolean component9() {
        return this.isPlaying;
    }

    @NotNull
    public final SearchMusicInfo copy(@NotNull String albumName, int i10, @NotNull String mediaAction, @NotNull String musicName, @NotNull String musicNo, @NotNull String musicSinger, @NotNull String coverUrl, boolean z10, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3) {
        s.j(albumName, "albumName");
        s.j(mediaAction, "mediaAction");
        s.j(musicName, "musicName");
        s.j(musicNo, "musicNo");
        s.j(musicSinger, "musicSinger");
        s.j(coverUrl, "coverUrl");
        return new SearchMusicInfo(albumName, i10, mediaAction, musicName, musicNo, musicSinger, coverUrl, z10, bool, bool2, bool3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SearchMusicInfo) {
                SearchMusicInfo searchMusicInfo = (SearchMusicInfo) obj;
                if (s.d(this.albumName, searchMusicInfo.albumName)) {
                    if ((this.duration == searchMusicInfo.duration) && s.d(this.mediaAction, searchMusicInfo.mediaAction) && s.d(this.musicName, searchMusicInfo.musicName) && s.d(this.musicNo, searchMusicInfo.musicNo) && s.d(this.musicSinger, searchMusicInfo.musicSinger) && s.d(this.coverUrl, searchMusicInfo.coverUrl)) {
                        if (!(this.isPlayType == searchMusicInfo.isPlayType) || !s.d(this.isPlaying, searchMusicInfo.isPlaying) || !s.d(this.isKing, searchMusicInfo.isKing) || !s.d(this.isExpend, searchMusicInfo.isExpend)) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getAlbumName() {
        return this.albumName;
    }

    @NotNull
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final int getDuration() {
        return this.duration;
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

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.albumName;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.duration) * 31;
        String str2 = this.mediaAction;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.musicName;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.musicNo;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.musicSinger;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.coverUrl;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        boolean z10 = this.isPlayType;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode6 + i10) * 31;
        Boolean bool = this.isPlaying;
        int hashCode7 = (i11 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.isKing;
        int hashCode8 = (hashCode7 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.isExpend;
        return hashCode8 + (bool3 != null ? bool3.hashCode() : 0);
    }

    @Nullable
    public final Boolean isExpend() {
        return this.isExpend;
    }

    @Nullable
    public final Boolean isKing() {
        return this.isKing;
    }

    public final boolean isPlayType() {
        return this.isPlayType;
    }

    @Nullable
    public final Boolean isPlaying() {
        return this.isPlaying;
    }

    public final void setExpend(@Nullable Boolean bool) {
        this.isExpend = bool;
    }

    public final void setKing(@Nullable Boolean bool) {
        this.isKing = bool;
    }

    public final void setPlayType(boolean z10) {
        this.isPlayType = z10;
    }

    public final void setPlaying(@Nullable Boolean bool) {
        this.isPlaying = bool;
    }

    @NotNull
    public String toString() {
        return "SearchMusicInfo(albumName=" + this.albumName + ", duration=" + this.duration + ", mediaAction=" + this.mediaAction + ", musicName=" + this.musicName + ", musicNo=" + this.musicNo + ", musicSinger=" + this.musicSinger + ", coverUrl=" + this.coverUrl + ", isPlayType=" + this.isPlayType + ", isPlaying=" + ((Object) this.isPlaying) + ", isKing=" + ((Object) this.isKing) + ", isExpend=" + ((Object) this.isExpend) + ")";
    }

    public /* synthetic */ SearchMusicInfo(String str, int i10, String str2, String str3, String str4, String str5, String str6, boolean z10, Boolean bool, Boolean bool2, Boolean bool3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i10, str2, str3, str4, str5, str6, (i11 & 128) != 0 ? false : z10, bool, bool2, (i11 & 1024) != 0 ? Boolean.FALSE : bool3);
    }
}
