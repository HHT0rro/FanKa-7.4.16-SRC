package com.alibaba.security.biometrics.skin.model;

import com.alibaba.security.biometrics.skin.interfaces.ISkinParse;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DetectAnimSkinData extends BaseSkinData {
    private String loadingColor;
    private String warningColor;

    public String getLoadingColor() {
        return this.loadingColor;
    }

    public String getWarningColor() {
        return this.warningColor;
    }

    @Override // com.alibaba.security.biometrics.skin.model.BaseSkinData
    public void parse(ISkinParse iSkinParse) {
    }

    public void setLoadingColor(String str) {
        this.loadingColor = str;
    }

    public void setWarningColor(String str) {
        this.warningColor = str;
    }

    @Override // com.alibaba.security.biometrics.skin.model.BaseSkinData
    public void webConvert(ISkinParse iSkinParse) {
    }
}
