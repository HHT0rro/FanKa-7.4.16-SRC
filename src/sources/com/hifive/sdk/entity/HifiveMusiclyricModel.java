package com.hifive.sdk.entity;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class HifiveMusiclyricModel implements Serializable {
    private String dynamicUrl;
    private String staticUrl;

    public String getDynamicUrl() {
        return this.dynamicUrl;
    }

    public String getStaticUrl() {
        return this.staticUrl;
    }

    public void setDynamicUrl(String str) {
        this.dynamicUrl = str;
    }

    public void setStaticUrl(String str) {
        this.staticUrl = str;
    }
}
