package com.alibaba.security.biometrics.skin.model;

import com.alibaba.security.biometrics.skin.interfaces.ISkinParse;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class BaseSkinData {
    private String key;

    public String getKey() {
        return this.key;
    }

    public abstract void parse(ISkinParse iSkinParse);

    public void setKey(String str) {
        this.key = str;
    }

    public abstract void webConvert(ISkinParse iSkinParse);
}
