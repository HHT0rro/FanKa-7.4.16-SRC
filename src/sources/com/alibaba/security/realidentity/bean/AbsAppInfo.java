package com.alibaba.security.realidentity.bean;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class AbsAppInfo implements Serializable {
    private String flSdkName;
    private String flSdkVersion;
    private String name;
    private String rpSdkName;
    private String rpSdkVersion;
    private String version;
    private String versionTag;

    public String getFlSdkName() {
        return this.flSdkName;
    }

    public String getFlSdkVersion() {
        return this.flSdkVersion;
    }

    public String getName() {
        return this.name;
    }

    public String getRpSdkName() {
        return this.rpSdkName;
    }

    public String getRpSdkVersion() {
        return this.rpSdkVersion;
    }

    public String getVersion() {
        return this.version;
    }

    public String getVersionTag() {
        return this.versionTag;
    }

    public void setFlSdkName(String str) {
        this.flSdkName = str;
    }

    public void setFlSdkVersion(String str) {
        this.flSdkVersion = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRpSdkName(String str) {
        this.rpSdkName = str;
    }

    public void setRpSdkVersion(String str) {
        this.rpSdkVersion = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public void setVersionTag(String str) {
        this.versionTag = str;
    }
}
