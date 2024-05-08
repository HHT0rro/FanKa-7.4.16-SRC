package com.bytedance.android.live.base.api.outer.data;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class RoomInfo {
    public City city;
    public String count;
    public String cover;
    public String openRoomId;
    public long orientation;
    public AnchorInfo owner;
    public String requestId;
    public long status;
    public String title;

    public RoomInfo(String str, String str2, String str3, String str4, long j10, City city, long j11, AnchorInfo anchorInfo, String str5) {
        this.openRoomId = str;
        this.title = str2;
        this.cover = str3;
        this.count = str4;
        this.orientation = j10;
        this.city = city;
        this.status = j11;
        this.owner = anchorInfo;
        this.requestId = str5;
    }

    public City getCity() {
        return this.city;
    }

    public String getCount() {
        return this.count;
    }

    public String getCover() {
        return this.cover;
    }

    public String getOpenRoomId() {
        return this.openRoomId;
    }

    public long getOrientation() {
        return this.orientation;
    }

    public AnchorInfo getOwner() {
        return this.owner;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public long getStatus() {
        return this.status;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setCount(String str) {
        this.count = str;
    }

    public void setCover(String str) {
        this.cover = str;
    }

    public void setOpenRoomId(String str) {
        this.openRoomId = str;
    }

    public void setOrientation(long j10) {
        this.orientation = j10;
    }

    public void setOwner(AnchorInfo anchorInfo) {
        this.owner = anchorInfo;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setStatus(long j10) {
        this.status = j10;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
