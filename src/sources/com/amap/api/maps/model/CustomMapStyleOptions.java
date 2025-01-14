package com.amap.api.maps.model;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class CustomMapStyleOptions {
    private String styleDataPath = null;
    private byte[] styleData = null;
    private String styleTexturePath = null;
    private byte[] styleTextureData = null;
    private String styleId = null;
    private boolean enable = true;
    private byte[] styleExtraData = null;
    private String styleExtraPath = null;
    private String styleDataOverseaPath = null;
    private byte[] styleDataOversea = null;
    private String styleResDataPath = null;
    private byte[] styleResData = null;

    public byte[] getStyleData() {
        return this.styleData;
    }

    public byte[] getStyleDataOversea() {
        return this.styleDataOversea;
    }

    public String getStyleDataOverseaPath() {
        return this.styleDataOverseaPath;
    }

    public String getStyleDataPath() {
        return this.styleDataPath;
    }

    public byte[] getStyleExtraData() {
        return this.styleExtraData;
    }

    public String getStyleExtraPath() {
        return this.styleExtraPath;
    }

    public String getStyleId() {
        return this.styleId;
    }

    public byte[] getStyleResData() {
        return this.styleResData;
    }

    public String getStyleResDataPath() {
        return this.styleResDataPath;
    }

    public byte[] getStyleTextureData() {
        return this.styleTextureData;
    }

    public String getStyleTexturePath() {
        return this.styleTexturePath;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public CustomMapStyleOptions setEnable(boolean z10) {
        this.enable = z10;
        return this;
    }

    public CustomMapStyleOptions setStyleData(byte[] bArr) {
        this.styleData = bArr;
        return this;
    }

    public CustomMapStyleOptions setStyleDataOversea(byte[] bArr) {
        this.styleDataOversea = bArr;
        return this;
    }

    public CustomMapStyleOptions setStyleDataOverseaPath(String str) {
        this.styleDataOverseaPath = str;
        return this;
    }

    public CustomMapStyleOptions setStyleDataPath(String str) {
        this.styleDataPath = str;
        return this;
    }

    public CustomMapStyleOptions setStyleExtraData(byte[] bArr) {
        this.styleExtraData = bArr;
        return this;
    }

    public CustomMapStyleOptions setStyleExtraPath(String str) {
        this.styleExtraPath = str;
        return this;
    }

    public CustomMapStyleOptions setStyleId(String str) {
        this.styleId = str;
        return this;
    }

    public CustomMapStyleOptions setStyleResData(byte[] bArr) {
        return this;
    }

    public CustomMapStyleOptions setStyleResDataPath(String str) {
        return this;
    }

    public CustomMapStyleOptions setStyleTextureData(byte[] bArr) {
        this.styleTextureData = bArr;
        return this;
    }

    public CustomMapStyleOptions setStyleTexturePath(String str) {
        this.styleTexturePath = str;
        return this;
    }
}
