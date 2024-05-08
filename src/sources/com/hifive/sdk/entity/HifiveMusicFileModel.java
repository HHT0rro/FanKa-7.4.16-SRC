package com.hifive.sdk.entity;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class HifiveMusicFileModel implements Serializable {
    private String expires;
    private String ext;
    private int size;
    private String url;

    public String getExpires() {
        return this.expires;
    }

    public String getExt() {
        return this.ext;
    }

    public int getSize() {
        return this.size;
    }

    public String getUrl() {
        return this.url;
    }

    public void setExpires(String str) {
        this.expires = str;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setSize(int i10) {
        this.size = i10;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
