package com.kwad.sdk.i;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class g {
    private JSONObject aJd;
    private boolean aJe;
    private Map<String, String> afK;
    private String appId;
    private JSONObject apq;
    private String atm;
    private String atn;
    private String ays;
    private String azo;
    private String azp;
    private String sdkVersion;

    private g() {
    }

    public static g IX() {
        return new g();
    }

    public final JSONObject IY() {
        return this.aJd;
    }

    public final boolean IZ() {
        return this.aJe;
    }

    public final String Ja() {
        return this.ays;
    }

    public final JSONObject Jb() {
        return this.apq;
    }

    public final g bE(boolean z10) {
        this.aJe = z10;
        return this;
    }

    public final g fN(String str) {
        this.appId = str;
        return this;
    }

    public final g fO(String str) {
        this.sdkVersion = str;
        return this;
    }

    public final g fP(String str) {
        this.atn = str;
        return this;
    }

    public final g fQ(String str) {
        this.azp = str;
        return this;
    }

    public final g fR(String str) {
        this.azo = str;
        return this;
    }

    public final g fS(String str) {
        this.atm = str;
        return this;
    }

    public final g fT(String str) {
        this.ays = str;
        return this;
    }

    public final g g(Map<String, String> map) {
        this.afK = map;
        return this;
    }

    public final String getAndroidId() {
        return this.azo;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getDeviceId() {
        return this.azp;
    }

    public final String getImei() {
        return this.atm;
    }

    public final String getOaid() {
        return this.atn;
    }

    public final Map<String, String> getRequestHeader() {
        return this.afK;
    }

    public final String getSdkVersion() {
        return this.sdkVersion;
    }

    public final g m(JSONObject jSONObject) {
        this.aJd = jSONObject;
        return this;
    }

    public final g n(JSONObject jSONObject) {
        this.apq = jSONObject;
        return this;
    }
}
