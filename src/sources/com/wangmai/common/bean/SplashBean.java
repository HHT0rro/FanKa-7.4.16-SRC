package com.wangmai.common.bean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SplashBean {
    public String wmDesc;
    public String wmTitle;

    public SplashBean(String str, String str2) {
        this.wmTitle = str;
        this.wmDesc = str2;
    }

    public String getWmDesc() {
        return this.wmDesc;
    }

    public String getWmTitle() {
        return this.wmTitle;
    }

    public void setWmDesc(String str) {
        this.wmDesc = str;
    }

    public void setWmTitle(String str) {
        this.wmTitle = str;
    }

    public String toString() {
        return "SplashBean{wmTitle='" + this.wmTitle + "', wmDesc='" + this.wmDesc + "'}";
    }
}
