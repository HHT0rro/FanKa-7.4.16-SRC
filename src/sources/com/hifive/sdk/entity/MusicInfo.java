package com.hifive.sdk.entity;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InitBean.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class MusicInfo implements Serializable {

    @Nullable
    private final String albumName;

    @Nullable
    private final Integer bpm;

    @Nullable
    private final String coverUrl;

    @Nullable
    private final String createTime;

    @Nullable
    private final Integer duration;

    /* renamed from: id, reason: collision with root package name */
    @Nullable
    private final Integer f27206id;

    @Nullable
    private Boolean isKing;

    @Nullable
    private Boolean isPlaying;

    @Nullable
    private final String mediaAction;

    @Nullable
    private final String musicName;

    @Nullable
    private final String musicNo;

    @Nullable
    private final String musicSinger;

    @Nullable
    private final Integer price;

    @Nullable
    private final Integer size;

    public MusicInfo(@Nullable Integer num, @Nullable String str, @Nullable Integer num2, @Nullable String str2, @Nullable String str3, @Nullable Integer num3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable Integer num4, @Nullable Integer num5, @Nullable Boolean bool, @Nullable Boolean bool2) {
        this.f27206id = num;
        this.albumName = str;
        this.bpm = num2;
        this.coverUrl = str2;
        this.createTime = str3;
        this.duration = num3;
        this.mediaAction = str4;
        this.musicName = str5;
        this.musicNo = str6;
        this.musicSinger = str7;
        this.price = num4;
        this.size = num5;
        this.isPlaying = bool;
        this.isKing = bool2;
    }

    @Nullable
    public final Integer component1() {
        return this.f27206id;
    }

    @Nullable
    public final String component10() {
        return this.musicSinger;
    }

    @Nullable
    public final Integer component11() {
        return this.price;
    }

    @Nullable
    public final Integer component12() {
        return this.size;
    }

    @Nullable
    public final Boolean component13() {
        return this.isPlaying;
    }

    @Nullable
    public final Boolean component14() {
        return this.isKing;
    }

    @Nullable
    public final String component2() {
        return this.albumName;
    }

    @Nullable
    public final Integer component3() {
        return this.bpm;
    }

    @Nullable
    public final String component4() {
        return this.coverUrl;
    }

    @Nullable
    public final String component5() {
        return this.createTime;
    }

    @Nullable
    public final Integer component6() {
        return this.duration;
    }

    @Nullable
    public final String component7() {
        return this.mediaAction;
    }

    @Nullable
    public final String component8() {
        return this.musicName;
    }

    @Nullable
    public final String component9() {
        return this.musicNo;
    }

    @NotNull
    public final MusicInfo copy(@Nullable Integer num, @Nullable String str, @Nullable Integer num2, @Nullable String str2, @Nullable String str3, @Nullable Integer num3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable Integer num4, @Nullable Integer num5, @Nullable Boolean bool, @Nullable Boolean bool2) {
        return new MusicInfo(num, str, num2, str2, str3, num3, str4, str5, str6, str7, num4, num5, bool, bool2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MusicInfo)) {
            return false;
        }
        MusicInfo musicInfo = (MusicInfo) obj;
        return s.d(this.f27206id, musicInfo.f27206id) && s.d(this.albumName, musicInfo.albumName) && s.d(this.bpm, musicInfo.bpm) && s.d(this.coverUrl, musicInfo.coverUrl) && s.d(this.createTime, musicInfo.createTime) && s.d(this.duration, musicInfo.duration) && s.d(this.mediaAction, musicInfo.mediaAction) && s.d(this.musicName, musicInfo.musicName) && s.d(this.musicNo, musicInfo.musicNo) && s.d(this.musicSinger, musicInfo.musicSinger) && s.d(this.price, musicInfo.price) && s.d(this.size, musicInfo.size) && s.d(this.isPlaying, musicInfo.isPlaying) && s.d(this.isKing, musicInfo.isKing);
    }

    @Nullable
    public final String getAlbumName() {
        return this.albumName;
    }

    @Nullable
    public final Integer getBpm() {
        return this.bpm;
    }

    @Nullable
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @Nullable
    public final String getCreateTime() {
        return this.createTime;
    }

    @Nullable
    public final Integer getDuration() {
        return this.duration;
    }

    @Nullable
    public final Integer getId() {
        return this.f27206id;
    }

    @Nullable
    public final String getMediaAction() {
        return this.mediaAction;
    }

    @Nullable
    public final String getMusicName() {
        return this.musicName;
    }

    @Nullable
    public final String getMusicNo() {
        return this.musicNo;
    }

    @Nullable
    public final String getMusicSinger() {
        return this.musicSinger;
    }

    @Nullable
    public final Integer getPrice() {
        return this.price;
    }

    @Nullable
    public final Integer getSize() {
        return this.size;
    }

    public int hashCode() {
        Integer num = this.f27206id;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.albumName;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Integer num2 = this.bpm;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str2 = this.coverUrl;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.createTime;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num3 = this.duration;
        int hashCode6 = (hashCode5 + (num3 != null ? num3.hashCode() : 0)) * 31;
        String str4 = this.mediaAction;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.musicName;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.musicNo;
        int hashCode9 = (hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.musicSinger;
        int hashCode10 = (hashCode9 + (str7 != null ? str7.hashCode() : 0)) * 31;
        Integer num4 = this.price;
        int hashCode11 = (hashCode10 + (num4 != null ? num4.hashCode() : 0)) * 31;
        Integer num5 = this.size;
        int hashCode12 = (hashCode11 + (num5 != null ? num5.hashCode() : 0)) * 31;
        Boolean bool = this.isPlaying;
        int hashCode13 = (hashCode12 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.isKing;
        return hashCode13 + (bool2 != null ? bool2.hashCode() : 0);
    }

    @Nullable
    public final Boolean isKing() {
        return this.isKing;
    }

    @Nullable
    public final Boolean isPlaying() {
        return this.isPlaying;
    }

    public final void setKing(@Nullable Boolean bool) {
        this.isKing = bool;
    }

    public final void setPlaying(@Nullable Boolean bool) {
        this.isPlaying = bool;
    }

    @NotNull
    public String toString() {
        return "MusicInfo(id=" + ((Object) this.f27206id) + ", albumName=" + this.albumName + ", bpm=" + ((Object) this.bpm) + ", coverUrl=" + this.coverUrl + ", createTime=" + this.createTime + ", duration=" + ((Object) this.duration) + ", mediaAction=" + this.mediaAction + ", musicName=" + this.musicName + ", musicNo=" + this.musicNo + ", musicSinger=" + this.musicSinger + ", price=" + ((Object) this.price) + ", size=" + ((Object) this.size) + ", isPlaying=" + ((Object) this.isPlaying) + ", isKing=" + ((Object) this.isKing) + ")";
    }
}
