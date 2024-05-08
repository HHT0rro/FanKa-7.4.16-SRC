package com.kwad.sdk.core.videocache;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class n {
    public final long aCx;
    public final String aCy;
    public final String url;

    public n(String str, long j10, String str2) {
        this.url = str;
        this.aCx = j10;
        this.aCy = str2;
    }

    public final String toString() {
        return "SourceInfo{url='" + this.url + "', length=" + this.aCx + ", mime='" + this.aCy + "'}";
    }
}
