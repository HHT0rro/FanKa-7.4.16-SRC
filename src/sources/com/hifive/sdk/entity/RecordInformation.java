package com.hifive.sdk.entity;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InitBean.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class RecordInformation {

    @NotNull
    private final Album album;

    @NotNull
    private final List<Object> arranger;

    @NotNull
    private final List<Artist> artist;
    private final int auditionBegin;
    private final int auditionEnd;
    private final int authType;

    @NotNull
    private final List<Object> author;
    private final int bpm;

    @NotNull
    private final List<Composer> composer;

    @NotNull
    private final CoverInfo cover;
    private final int duration;
    private final int forSale;

    @NotNull
    private final String majorVersion;

    @NotNull
    private final List<Object> maker;

    @NotNull
    private final List<Object> mastery;

    @NotNull
    private final String musicId;

    @NotNull
    private final String musicName;
    private final int price;

    @NotNull
    private final List<Object> tag;

    @NotNull
    private final List<Version> version;

    @NotNull
    private final String versionName;

    @NotNull
    private final Object waveUrl;

    public RecordInformation(@NotNull Album album, @NotNull List<? extends Object> arranger, @NotNull List<Artist> artist, int i10, int i11, int i12, @NotNull List<? extends Object> author, int i13, @NotNull List<Composer> composer, @NotNull CoverInfo cover, int i14, int i15, @NotNull String majorVersion, @NotNull List<? extends Object> maker, @NotNull List<? extends Object> mastery, @NotNull String musicId, @NotNull String musicName, int i16, @NotNull List<? extends Object> tag, @NotNull List<Version> version, @NotNull String versionName, @NotNull Object waveUrl) {
        s.j(album, "album");
        s.j(arranger, "arranger");
        s.j(artist, "artist");
        s.j(author, "author");
        s.j(composer, "composer");
        s.j(cover, "cover");
        s.j(majorVersion, "majorVersion");
        s.j(maker, "maker");
        s.j(mastery, "mastery");
        s.j(musicId, "musicId");
        s.j(musicName, "musicName");
        s.j(tag, "tag");
        s.j(version, "version");
        s.j(versionName, "versionName");
        s.j(waveUrl, "waveUrl");
        this.album = album;
        this.arranger = arranger;
        this.artist = artist;
        this.auditionBegin = i10;
        this.auditionEnd = i11;
        this.authType = i12;
        this.author = author;
        this.bpm = i13;
        this.composer = composer;
        this.cover = cover;
        this.duration = i14;
        this.forSale = i15;
        this.majorVersion = majorVersion;
        this.maker = maker;
        this.mastery = mastery;
        this.musicId = musicId;
        this.musicName = musicName;
        this.price = i16;
        this.tag = tag;
        this.version = version;
        this.versionName = versionName;
        this.waveUrl = waveUrl;
    }

    @NotNull
    public final Album component1() {
        return this.album;
    }

    @NotNull
    public final CoverInfo component10() {
        return this.cover;
    }

    public final int component11() {
        return this.duration;
    }

    public final int component12() {
        return this.forSale;
    }

    @NotNull
    public final String component13() {
        return this.majorVersion;
    }

    @NotNull
    public final List<Object> component14() {
        return this.maker;
    }

    @NotNull
    public final List<Object> component15() {
        return this.mastery;
    }

    @NotNull
    public final String component16() {
        return this.musicId;
    }

    @NotNull
    public final String component17() {
        return this.musicName;
    }

    public final int component18() {
        return this.price;
    }

    @NotNull
    public final List<Object> component19() {
        return this.tag;
    }

    @NotNull
    public final List<Object> component2() {
        return this.arranger;
    }

    @NotNull
    public final List<Version> component20() {
        return this.version;
    }

    @NotNull
    public final String component21() {
        return this.versionName;
    }

    @NotNull
    public final Object component22() {
        return this.waveUrl;
    }

    @NotNull
    public final List<Artist> component3() {
        return this.artist;
    }

    public final int component4() {
        return this.auditionBegin;
    }

    public final int component5() {
        return this.auditionEnd;
    }

    public final int component6() {
        return this.authType;
    }

    @NotNull
    public final List<Object> component7() {
        return this.author;
    }

    public final int component8() {
        return this.bpm;
    }

    @NotNull
    public final List<Composer> component9() {
        return this.composer;
    }

    @NotNull
    public final RecordInformation copy(@NotNull Album album, @NotNull List<? extends Object> arranger, @NotNull List<Artist> artist, int i10, int i11, int i12, @NotNull List<? extends Object> author, int i13, @NotNull List<Composer> composer, @NotNull CoverInfo cover, int i14, int i15, @NotNull String majorVersion, @NotNull List<? extends Object> maker, @NotNull List<? extends Object> mastery, @NotNull String musicId, @NotNull String musicName, int i16, @NotNull List<? extends Object> tag, @NotNull List<Version> version, @NotNull String versionName, @NotNull Object waveUrl) {
        s.j(album, "album");
        s.j(arranger, "arranger");
        s.j(artist, "artist");
        s.j(author, "author");
        s.j(composer, "composer");
        s.j(cover, "cover");
        s.j(majorVersion, "majorVersion");
        s.j(maker, "maker");
        s.j(mastery, "mastery");
        s.j(musicId, "musicId");
        s.j(musicName, "musicName");
        s.j(tag, "tag");
        s.j(version, "version");
        s.j(versionName, "versionName");
        s.j(waveUrl, "waveUrl");
        return new RecordInformation(album, arranger, artist, i10, i11, i12, author, i13, composer, cover, i14, i15, majorVersion, maker, mastery, musicId, musicName, i16, tag, version, versionName, waveUrl);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof RecordInformation) {
                RecordInformation recordInformation = (RecordInformation) obj;
                if (s.d(this.album, recordInformation.album) && s.d(this.arranger, recordInformation.arranger) && s.d(this.artist, recordInformation.artist)) {
                    if (this.auditionBegin == recordInformation.auditionBegin) {
                        if (this.auditionEnd == recordInformation.auditionEnd) {
                            if ((this.authType == recordInformation.authType) && s.d(this.author, recordInformation.author)) {
                                if ((this.bpm == recordInformation.bpm) && s.d(this.composer, recordInformation.composer) && s.d(this.cover, recordInformation.cover)) {
                                    if (this.duration == recordInformation.duration) {
                                        if ((this.forSale == recordInformation.forSale) && s.d(this.majorVersion, recordInformation.majorVersion) && s.d(this.maker, recordInformation.maker) && s.d(this.mastery, recordInformation.mastery) && s.d(this.musicId, recordInformation.musicId) && s.d(this.musicName, recordInformation.musicName)) {
                                            if (!(this.price == recordInformation.price) || !s.d(this.tag, recordInformation.tag) || !s.d(this.version, recordInformation.version) || !s.d(this.versionName, recordInformation.versionName) || !s.d(this.waveUrl, recordInformation.waveUrl)) {
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final Album getAlbum() {
        return this.album;
    }

    @NotNull
    public final List<Object> getArranger() {
        return this.arranger;
    }

    @NotNull
    public final List<Artist> getArtist() {
        return this.artist;
    }

    public final int getAuditionBegin() {
        return this.auditionBegin;
    }

    public final int getAuditionEnd() {
        return this.auditionEnd;
    }

    public final int getAuthType() {
        return this.authType;
    }

    @NotNull
    public final List<Object> getAuthor() {
        return this.author;
    }

    public final int getBpm() {
        return this.bpm;
    }

    @NotNull
    public final List<Composer> getComposer() {
        return this.composer;
    }

    @NotNull
    public final CoverInfo getCover() {
        return this.cover;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final int getForSale() {
        return this.forSale;
    }

    @NotNull
    public final String getMajorVersion() {
        return this.majorVersion;
    }

    @NotNull
    public final List<Object> getMaker() {
        return this.maker;
    }

    @NotNull
    public final List<Object> getMastery() {
        return this.mastery;
    }

    @NotNull
    public final String getMusicId() {
        return this.musicId;
    }

    @NotNull
    public final String getMusicName() {
        return this.musicName;
    }

    public final int getPrice() {
        return this.price;
    }

    @NotNull
    public final List<Object> getTag() {
        return this.tag;
    }

    @NotNull
    public final List<Version> getVersion() {
        return this.version;
    }

    @NotNull
    public final String getVersionName() {
        return this.versionName;
    }

    @NotNull
    public final Object getWaveUrl() {
        return this.waveUrl;
    }

    public int hashCode() {
        Album album = this.album;
        int hashCode = (album != null ? album.hashCode() : 0) * 31;
        List<Object> list = this.arranger;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        List<Artist> list2 = this.artist;
        int hashCode3 = (((((((hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31) + this.auditionBegin) * 31) + this.auditionEnd) * 31) + this.authType) * 31;
        List<Object> list3 = this.author;
        int hashCode4 = (((hashCode3 + (list3 != null ? list3.hashCode() : 0)) * 31) + this.bpm) * 31;
        List<Composer> list4 = this.composer;
        int hashCode5 = (hashCode4 + (list4 != null ? list4.hashCode() : 0)) * 31;
        CoverInfo coverInfo = this.cover;
        int hashCode6 = (((((hashCode5 + (coverInfo != null ? coverInfo.hashCode() : 0)) * 31) + this.duration) * 31) + this.forSale) * 31;
        String str = this.majorVersion;
        int hashCode7 = (hashCode6 + (str != null ? str.hashCode() : 0)) * 31;
        List<Object> list5 = this.maker;
        int hashCode8 = (hashCode7 + (list5 != null ? list5.hashCode() : 0)) * 31;
        List<Object> list6 = this.mastery;
        int hashCode9 = (hashCode8 + (list6 != null ? list6.hashCode() : 0)) * 31;
        String str2 = this.musicId;
        int hashCode10 = (hashCode9 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.musicName;
        int hashCode11 = (((hashCode10 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.price) * 31;
        List<Object> list7 = this.tag;
        int hashCode12 = (hashCode11 + (list7 != null ? list7.hashCode() : 0)) * 31;
        List<Version> list8 = this.version;
        int hashCode13 = (hashCode12 + (list8 != null ? list8.hashCode() : 0)) * 31;
        String str4 = this.versionName;
        int hashCode14 = (hashCode13 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Object obj = this.waveUrl;
        return hashCode14 + (obj != null ? obj.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "RecordInformation(album=" + ((Object) this.album) + ", arranger=" + ((Object) this.arranger) + ", artist=" + ((Object) this.artist) + ", auditionBegin=" + this.auditionBegin + ", auditionEnd=" + this.auditionEnd + ", authType=" + this.authType + ", author=" + ((Object) this.author) + ", bpm=" + this.bpm + ", composer=" + ((Object) this.composer) + ", cover=" + ((Object) this.cover) + ", duration=" + this.duration + ", forSale=" + this.forSale + ", majorVersion=" + this.majorVersion + ", maker=" + ((Object) this.maker) + ", mastery=" + ((Object) this.mastery) + ", musicId=" + this.musicId + ", musicName=" + this.musicName + ", price=" + this.price + ", tag=" + ((Object) this.tag) + ", version=" + ((Object) this.version) + ", versionName=" + this.versionName + ", waveUrl=" + this.waveUrl + ")";
    }
}
