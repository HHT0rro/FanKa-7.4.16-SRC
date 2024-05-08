package com.hifive.sdk.entity;

import java.io.Serializable;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class HifiveMusicModel implements Serializable {
    private HifiveMusicAlbumModel album;
    private List<HifiveMusicAuthorModel> arranger;
    private List<HifiveMusicAuthorModel> artist;
    private int auditionBegin;
    private int auditionEnd;
    private int authType;
    private List<HifiveMusicAuthorModel> author;
    private int bpm;
    private List<HifiveMusicAuthorModel> composer;
    private HifiveMusicImageModel cover;
    private int duration;
    private int forSale;
    private String intro;
    private String introduce;
    private List<HifiveMusicAuthorModel> maker;
    private List<HifiveMusicAuthorModel> mastery;
    private String musicId;
    private String musicName;
    private int price;
    private int status;
    private List<HifiveMusicTagModel> tag;
    private List<HifiveMusicVersionModel> version;
    private String waveUrl;

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return this.musicId.equals(((HifiveMusicModel) obj).getMusicId());
    }

    public HifiveMusicAlbumModel getAlbum() {
        return this.album;
    }

    public List<HifiveMusicAuthorModel> getArranger() {
        return this.arranger;
    }

    public List<HifiveMusicAuthorModel> getArtist() {
        return this.artist;
    }

    public int getAuditionBegin() {
        return this.auditionBegin;
    }

    public int getAuditionEnd() {
        return this.auditionEnd;
    }

    public int getAuthType() {
        return this.authType;
    }

    public List<HifiveMusicAuthorModel> getAuthor() {
        return this.author;
    }

    public int getBpm() {
        return this.bpm;
    }

    public List<HifiveMusicAuthorModel> getComposer() {
        return this.composer;
    }

    public HifiveMusicImageModel getCover() {
        return this.cover;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getForSale() {
        return this.forSale;
    }

    public String getIntro() {
        return this.intro;
    }

    public String getIntroduce() {
        return this.introduce;
    }

    public List<HifiveMusicAuthorModel> getMaker() {
        return this.maker;
    }

    public List<HifiveMusicAuthorModel> getMastery() {
        return this.mastery;
    }

    public String getMusicId() {
        return this.musicId;
    }

    public String getMusicName() {
        return this.musicName;
    }

    public int getPrice() {
        return this.price;
    }

    public int getStatus() {
        return this.status;
    }

    public List<HifiveMusicTagModel> getTag() {
        return this.tag;
    }

    public List<HifiveMusicVersionModel> getVersion() {
        return this.version;
    }

    public String getWaveUrl() {
        return this.waveUrl;
    }

    public void setAlbum(HifiveMusicAlbumModel hifiveMusicAlbumModel) {
        this.album = hifiveMusicAlbumModel;
    }

    public void setArranger(List<HifiveMusicAuthorModel> list) {
        this.arranger = list;
    }

    public void setArtist(List<HifiveMusicAuthorModel> list) {
        this.artist = list;
    }

    public void setAuditionBegin(int i10) {
        this.auditionBegin = i10;
    }

    public void setAuditionEnd(int i10) {
        this.auditionEnd = i10;
    }

    public void setAuthType(int i10) {
        this.authType = i10;
    }

    public void setAuthor(List<HifiveMusicAuthorModel> list) {
        this.author = list;
    }

    public void setBpm(int i10) {
        this.bpm = i10;
    }

    public void setComposer(List<HifiveMusicAuthorModel> list) {
        this.composer = list;
    }

    public void setCover(HifiveMusicImageModel hifiveMusicImageModel) {
        this.cover = hifiveMusicImageModel;
    }

    public void setDuration(int i10) {
        this.duration = i10;
    }

    public void setForSale(int i10) {
        this.forSale = i10;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    public void setIntroduce(String str) {
        this.introduce = str;
    }

    public void setMaker(List<HifiveMusicAuthorModel> list) {
        this.maker = list;
    }

    public void setMastery(List<HifiveMusicAuthorModel> list) {
        this.mastery = list;
    }

    public void setMusicId(String str) {
        this.musicId = str;
    }

    public void setMusicName(String str) {
        this.musicName = str;
    }

    public void setPrice(int i10) {
        this.price = i10;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }

    public void setTag(List<HifiveMusicTagModel> list) {
        this.tag = list;
    }

    public void setVersion(List<HifiveMusicVersionModel> list) {
        this.version = list;
    }

    public void setWaveUrl(String str) {
        this.waveUrl = str;
    }
}
