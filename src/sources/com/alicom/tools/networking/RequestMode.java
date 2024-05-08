package com.alicom.tools.networking;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class RequestMode {
    private String baseUrl;
    private String requestMethod;
    private boolean useAnnotation;
    private boolean isSign = false;
    public Set<String> fileds = new HashSet();

    public void addField(String str) {
        this.fileds.add(str);
    }

    public abstract String buildSignByAnnotation() throws IOException;

    public abstract String buildSignByListFields() throws IOException;

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public Set<String> getFileds() {
        return this.fileds;
    }

    public String getRequestMethod() {
        return this.requestMethod;
    }

    public boolean isSign() {
        return this.isSign;
    }

    public boolean isUseAnnotation() {
        return this.useAnnotation;
    }

    public void setBaseUrl(String str) {
        this.baseUrl = str;
    }

    public void setRequestMethod(String str) {
        this.requestMethod = str;
    }

    public void setSign(boolean z10) {
        this.isSign = z10;
    }

    public void setUseAnnotation(boolean z10) {
        this.useAnnotation = z10;
    }
}
