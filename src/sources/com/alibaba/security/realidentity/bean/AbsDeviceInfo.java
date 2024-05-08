package com.alibaba.security.realidentity.bean;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class AbsDeviceInfo implements Serializable {
    private String model;
    private boolean neon;
    private String osName;
    private String osVersion;

    public String getModel() {
        return this.model;
    }

    public String getOsName() {
        return this.osName;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public boolean isNeon() {
        return this.neon;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setNeon(boolean z10) {
        this.neon = z10;
    }

    public void setOsName(String str) {
        this.osName = str;
    }

    public void setOsVersion(String str) {
        this.osVersion = str;
    }
}
