package com.alibaba.security.common.track.model;

import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class LastExitTrackMsg implements Serializable {
    private String page;
    private String params;
    private String view;

    public String getPage() {
        return this.page;
    }

    public String getParams() {
        return this.params;
    }

    public String getView() {
        return this.view;
    }

    public void setPage(String str) {
        this.page = str;
    }

    public void setParams(String str) {
        this.params = str;
    }

    public void setView(String str) {
        this.view = str;
    }
}