package com.alibaba.security.biometrics.skin.model;

import com.alibaba.security.biometrics.skin.interfaces.ISkinParse;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ControlSkinData extends BaseSkinData {
    private String backgroundColor;

    public String getBackgroundColor() {
        return this.backgroundColor;
    }

    @Override // com.alibaba.security.biometrics.skin.model.BaseSkinData
    public void parse(ISkinParse iSkinParse) {
    }

    public void setBackgroundColor(String str) {
        this.backgroundColor = str;
    }

    @Override // com.alibaba.security.biometrics.skin.model.BaseSkinData
    public void webConvert(ISkinParse iSkinParse) {
    }
}
