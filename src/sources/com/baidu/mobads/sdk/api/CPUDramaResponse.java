package com.baidu.mobads.sdk.api;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class CPUDramaResponse {
    private String contentId;
    private String coverImageUrl;
    private int represent;
    private String subVideoId;
    private String title;

    public String getDramaContentId() {
        return this.contentId;
    }

    public String getDramaCoverImage() {
        return this.coverImageUrl;
    }

    public String getDramaSubVideoId() {
        return this.subVideoId;
    }

    public String getDramaTitle() {
        return this.title;
    }

    public int getRepresent() {
        return this.represent;
    }

    public CPUDramaResponse setContentId(String str) {
        this.contentId = str;
        return this;
    }

    public CPUDramaResponse setCoverImageUrl(String str) {
        this.coverImageUrl = str;
        return this;
    }

    public CPUDramaResponse setRepresent(int i10) {
        this.represent = i10;
        return this;
    }

    public CPUDramaResponse setSubVideoId(String str) {
        this.subVideoId = str;
        return this;
    }

    public CPUDramaResponse setTitle(String str) {
        this.title = str;
        return this;
    }
}
