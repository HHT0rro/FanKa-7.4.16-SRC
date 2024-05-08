package com.hifive.sdk.entity;

import java.io.Serializable;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class HifiveMusicTagModel implements Serializable {
    private List<HifiveMusicTagModel> child;
    private String coverUrl;
    private int pid;
    private int tagId;
    private String tagName;

    public List<HifiveMusicTagModel> getChild() {
        return this.child;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public int getPid() {
        return this.pid;
    }

    public int getTagId() {
        return this.tagId;
    }

    public String getTagName() {
        return this.tagName;
    }

    public void setChild(List<HifiveMusicTagModel> list) {
        this.child = list;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setPid(int i10) {
        this.pid = i10;
    }

    public void setTagId(int i10) {
        this.tagId = i10;
    }

    public void setTagName(String str) {
        this.tagName = str;
    }
}
