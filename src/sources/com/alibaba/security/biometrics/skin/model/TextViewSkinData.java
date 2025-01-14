package com.alibaba.security.biometrics.skin.model;

import com.alibaba.security.biometrics.skin.interfaces.ISkinParse;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TextViewSkinData extends BaseSkinData {
    private int fontSize;
    private String textColor;
    private Map<String, Integer> textPadding;

    public int getFontSize() {
        return this.fontSize;
    }

    public String getTextColor() {
        return this.textColor;
    }

    public Map<String, Integer> getTextPadding() {
        return this.textPadding;
    }

    @Override // com.alibaba.security.biometrics.skin.model.BaseSkinData
    public void parse(ISkinParse iSkinParse) {
    }

    public void setFontSize(int i10) {
        this.fontSize = i10;
    }

    public void setTextColor(String str) {
        this.textColor = str;
    }

    public void setTextPadding(HashMap<String, Integer> hashMap) {
        this.textPadding = hashMap;
    }

    @Override // com.alibaba.security.biometrics.skin.model.BaseSkinData
    public void webConvert(ISkinParse iSkinParse) {
    }
}
