package com.tencent.cloud.huiyansdkface.facelight.api.result;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WbFaceWillModeResult {

    /* renamed from: a, reason: collision with root package name */
    private String f40584a;

    /* renamed from: b, reason: collision with root package name */
    private String f40585b;

    /* renamed from: c, reason: collision with root package name */
    private String f40586c;

    /* renamed from: d, reason: collision with root package name */
    private String f40587d;

    /* renamed from: e, reason: collision with root package name */
    private String f40588e;

    public String getFaceCode() {
        return this.f40586c;
    }

    public String getFaceMsg() {
        return this.f40587d;
    }

    public String getVideoPath() {
        return this.f40588e;
    }

    public String getWillCode() {
        return this.f40584a;
    }

    public String getWillMsg() {
        return this.f40585b;
    }

    public void setFaceCode(String str) {
        this.f40586c = str;
    }

    public void setFaceMsg(String str) {
        this.f40587d = str;
    }

    public void setVideoPath(String str) {
        this.f40588e = str;
    }

    public void setWillCode(String str) {
        this.f40584a = str;
    }

    public void setWillMsg(String str) {
        this.f40585b = str;
    }

    public String toString() {
        return "WbFaceWillModeResult{willCode='" + this.f40584a + "', willMsg='" + this.f40585b + "', faceCode='" + this.f40586c + "', faceMsg='" + this.f40587d + "', videoPath='" + this.f40588e + "'}";
    }
}
