package com.alibaba.security.realidentity.business.start;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ExtrasBean implements Serializable {
    private String name;
    private String sgConfig;
    private String status;

    public String getName() {
        return this.name;
    }

    public String getSgConfig() {
        return this.sgConfig;
    }

    public String getStatus() {
        return this.status;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSgConfig(String str) {
        this.sgConfig = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
