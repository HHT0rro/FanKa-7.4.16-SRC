package com.kwad.sdk.core.videocache;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class p implements m {
    public volatile String aCy;
    public volatile int length = Integer.MIN_VALUE;
    public String url;

    public abstract String Gy();

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "UrlSource{url='" + this.url + "', length=" + this.length + ", mime='" + this.aCy + "'}";
    }
}
