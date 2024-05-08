package com.alimm.tanx.core.view.player.cache.videocache;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SourceInfo {
    public final long length;
    public final String mime;
    public final String url;

    public SourceInfo(String str, long j10, String str2) {
        this.url = str;
        this.length = j10;
        this.mime = str2;
    }

    public String toString() {
        return "SourceInfo{url='" + this.url + "', length=" + this.length + ", mime='" + this.mime + "'}";
    }
}
