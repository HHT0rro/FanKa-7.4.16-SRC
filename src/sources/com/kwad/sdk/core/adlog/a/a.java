package com.kwad.sdk.core.adlog.a;

import androidx.annotation.NonNull;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {
    public JSONObject apq;
    public com.kwad.sdk.core.adlog.c.a apr;
    public long aps;
    public int apt;
    public String apu;
    public int retryCount;
    public String url;

    public static a Bh() {
        return new a();
    }

    public final a ad(long j10) {
        this.aps = j10;
        return this;
    }

    public final a c(com.kwad.sdk.core.adlog.c.a aVar) {
        this.apr = aVar;
        return this;
    }

    public final a cX(String str) {
        this.url = str;
        return this;
    }

    public final a cY(String str) {
        this.apu = str;
        return this;
    }

    public final a cr(int i10) {
        this.apt = i10;
        return this;
    }

    public final a i(JSONObject jSONObject) {
        this.apq = jSONObject;
        return this;
    }

    @NonNull
    public final String toString() {
        return "AdLogCache {actionType=" + this.apr.aoM + ", retryCount=" + this.retryCount + ", retryErrorCode=" + this.apt + ", retryErrorMsg=" + this.apu + '}';
    }
}
